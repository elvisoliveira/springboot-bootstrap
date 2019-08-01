CREATE TABLE "public".equipment (
	id serial NOT NULL,
	name varchar
);
CREATE TABLE "public".maintenance (
	id serial NOT NULL,
	"date" date NOT NULL,
	equipment int NOT NULL
);