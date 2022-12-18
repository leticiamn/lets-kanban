db.createCollection("card", {
  validator: {
    $jsonSchema: {
      required: ["titulo", "descricao"],
      properties: {
        titulo: {
          bsonType: "string",
          maxLength: 50,
          description: "Título do card.",
        },
        descricao: {
          bsonType: "string",
          maxLength: 255,
          description: "Descrição do card.",
        }
      },
    },
  },
});
