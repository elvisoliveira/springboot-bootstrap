CREATE TABLE IF NOT EXISTS public.equipment (
	id serial NOT NULL,
	name varchar
);
CREATE TABLE IF NOT EXISTS public.maintenance (
	id serial NOT NULL,
	"date" date NOT NULL,
	equipment int NOT NULL
);
INSERT INTO public.equipment ("name")
     VALUES ('SQUAT RACK'),
            ('BARBELLS'),
            ('BENCH PRESS'),
            ('INCLINE BENCH PRESS'),
            ('HAMMER STRENGTH MACHINE'),
            ('CABLES AND PULLEYS'),
            ('DUMBBELLS'),
            ('PULLUP BAR');
INSERT INTO public.maintenance ("date",equipment)
     VALUES ('2008-09-11',1),
            ('2003-05-16',2),
            ('2013-03-22',3),
            ('2012-08-07',4),
            ('1993-04-11',5),
            ('2010-08-16',6),
            ('1989-10-05',7);