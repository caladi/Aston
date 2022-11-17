create table insurance (
  id int auto_increment primary key,
  life_span_type enum ('SHORT_TERM','ANNUAL') not null,
  package_type enum ('BASIC','EXTENDED','EXTRA') default 'BASIC',
  from_date date not null,
  due_date date default null,
  created_at timestamp DEFAULT now(),
  price int not null,
  persons int not null,
  PRIMARY KEY (id)
);

create table additional_insurance (
  insurance_id int not null,
  additional_insurance enum ('TRIP_CANCELLATION','SPORT_ACTIVITIES') not null,
  primary key (insurance_id, additional_insurance),
  foreign key (insurance_id) references insurance(id)
);

create table tariff (
  life_span_type enum ('SHORT_TERM','ANNUAL') not null,
  package_type enum ('BASIC','EXTENDED','EXTRA') not null,
  price int not null
);
insert into tariff (life_span_type, package_type, price)
values (
  'SHORT_TERM',
  'BASIC',
  120
), (
  'SHORT_TERM',
  'EXTENDED',
  180
), (
  'SHORT_TERM',
  'EXTRA',
  240
), (
  'ANNUAL',
  'BASIC',
  3900
), (
  'ANNUAL',
  'EXTENDED',
  4900
), (
  'ANNUAL',
  'EXTRA',
  5900
);