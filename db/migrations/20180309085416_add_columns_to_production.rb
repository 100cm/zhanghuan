class AddColumnsToProduction < ActiveRecord::Migration[4.2]
  def change
    add_column :products, :detail, :string
  end
end
