class AddInfoToProduction < ActiveRecord::Migration[4.2]
  def change
    add_column :products, :info, :text
  end
end
