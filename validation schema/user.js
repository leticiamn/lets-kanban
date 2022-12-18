db.createCollection("user", {
  validator: {
    $jsonSchema: {
      required: ["name", "email"],
      properties: {
        name: {
          bsonType: "string",
          maxLength: 64,
          description: "Nome do usuário.",
        },
        email: {
          bsonType: "string",
          maxLength: 320,
          description: "Email do usuário.",
        },
        quadro: {
          bsonType: "object",
          description: "Quadro do usuário.",
        },
      },
    },
  },
});
