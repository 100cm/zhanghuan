class Customer < ActiveRecord::Migration[4.2]
  def change
    create_table :customers do |t|
      t.string :name
      t.string :score
      t.string :location
      t.string :phone
      t.string :email
      t.timestamps
    end
  end
end
