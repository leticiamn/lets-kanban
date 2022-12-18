db.createCollection("quadro", {
  validator: {
    $jsonSchema: {
      required: ["name"],
      properties: {
        name: {
          bsonType: "string",
          maxLength: 64,
          description: "Nome do quadro.",
        },
        cardList: {
          bsonType: "array",
          description: "List de cards.",
        },
      },
    },
  },
});
