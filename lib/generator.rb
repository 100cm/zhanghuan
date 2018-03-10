require 'fileutils'
require 'active_support/all'

def generate_project(name)
  Dir.mkdir name
  gem_path = __FILE__.match(/(.*)\/lib/)[1]
  FileUtils.copy_entry gem_path + '/template', "./#{name}"
  Dir.chdir name
  %w{./db/migrations ./controllers ./models ./views }.each { |x| FileUtils.mkdir_p x }
end

def camelize(str)
  str.split('_').map(&:capitalize).join
end

def generate_migration(name)
  version = Time.now.utc.strftime("%Y%m%d%H%M%S")
  File.open("./db/migrations/#{version}_#{name}.rb", 'w').write <<-EOF
class #{camelize(name)} < ActiveRecord::Migration[4.2]
  def change
  end
end
  EOF
end

def generate_model(name)
  File.open("./src/main/java/zhanghuan/model/#{name.classify}.java", 'w').write <<-EOF
package zhanghuan.model;


import com.blade.jdbc.annotation.Table;
import com.blade.jdbc.core.ActiveRecord;

/**
 * Created by icepoint1999 on 09/03/2018.
 */
@Table("#{name.pluralize}")
public class #{camelize(name)} extends ActiveRecord {
}

  EOF

  version = Time.now.utc.strftime("%Y%m%d%H%M%S")
  File.open("./db/migrations/#{version}_#{name}.rb", 'w').write <<-EOF
class #{camelize(name)} < ActiveRecord::Migration[4.2]
  def change
    create_table :#{name.pluralize} do |t|
      t.timestamps
    end
  end
end
  EOF

end