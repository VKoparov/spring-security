db.createUser(
        {
            roles: [
                {
                    role: "readWrite",
                    db: "spring-security"
                }
            ]
        }
);
