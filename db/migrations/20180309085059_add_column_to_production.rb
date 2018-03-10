class AddColumnToProduction < ActiveRecord::Migration[4.2]
  def change
    add_column :products, :describe, :string
  end
end
