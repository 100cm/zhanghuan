class Product < ActiveRecord::Migration[4.2]
  def change
    create_table :products do |t|
      t.string :name
      t.string :desc
      t.string :price
      t.string :image
      t.string :count
      t.string :product_category_id
      t.timestamps
    end
  end
end
