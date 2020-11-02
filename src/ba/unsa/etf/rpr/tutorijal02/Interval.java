package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetnaTacka;
    private double krajnjaTacka;
    private boolean pocetnaTackaPripadaIntervalu;
    private boolean krajnjaTackaPripadaIntervalu;

    public Interval(double t1, double t2, boolean t1I, boolean t2I) throws IllegalArgumentException {
        if (t1 > t2) throw new IllegalArgumentException("Greska : pocetna tacka ne smije biti veca od krajnje tacke");
        pocetnaTacka = t1;
        krajnjaTacka = t2;
        pocetnaTackaPripadaIntervalu = t1I;
        krajnjaTackaPripadaIntervalu = t2I;
    }

    public Interval() {
        pocetnaTacka = 0;
        krajnjaTacka = 0;
        pocetnaTackaPripadaIntervalu = false;
        krajnjaTackaPripadaIntervalu = false;
    }

    public boolean isNull() {
        return (pocetnaTacka == 0 && krajnjaTacka == 0 && !pocetnaTackaPripadaIntervalu && !krajnjaTackaPripadaIntervalu);
    }

    public boolean isIn(double t) {
        boolean p = false;
        boolean k = false;
        if (pocetnaTackaPripadaIntervalu) {
            if (t >= pocetnaTacka)
                p = true;
        } else {
            if (t > pocetnaTacka)
                p = true;
        }
        if (krajnjaTackaPripadaIntervalu) {
            if (t <= krajnjaTacka)
                k = true;
        } else {
            if (t < krajnjaTacka)
                k = true;
        }
        return p && k;
    }

    public Interval intersect(Interval i) {
        if (i.pocetnaTacka == pocetnaTacka && !pocetnaTackaPripadaIntervalu) {
            i.pocetnaTackaPripadaIntervalu = false;
        }
        if (i.krajnjaTacka == krajnjaTacka && !krajnjaTackaPripadaIntervalu) {
            i.krajnjaTackaPripadaIntervalu = false;
        }
        if (i.pocetnaTacka < pocetnaTacka) {
            i.pocetnaTacka = pocetnaTacka;
            i.pocetnaTackaPripadaIntervalu = pocetnaTackaPripadaIntervalu;
        }
        if (i.krajnjaTacka > krajnjaTacka) {
            i.krajnjaTacka = krajnjaTacka;
            i.krajnjaTackaPripadaIntervalu = krajnjaTackaPripadaIntervalu;
        }
        return i;
    }

    public static Interval intersect(Interval i, Interval j) {
        if (i.pocetnaTacka == j.pocetnaTacka && !j.pocetnaTackaPripadaIntervalu) {
            i.pocetnaTackaPripadaIntervalu = false;
        }
        if (i.krajnjaTacka == j.krajnjaTacka && !j.krajnjaTackaPripadaIntervalu) {
            i.krajnjaTackaPripadaIntervalu = false;
        }
        if (i.pocetnaTacka < j.pocetnaTacka) {
            i.pocetnaTacka = j.pocetnaTacka;
            i.pocetnaTackaPripadaIntervalu = j.pocetnaTackaPripadaIntervalu;

        }
        if (i.krajnjaTacka > j.krajnjaTacka) {
            i.krajnjaTacka = j.krajnjaTacka;
            i.krajnjaTackaPripadaIntervalu = j.krajnjaTackaPripadaIntervalu;
        }
        return i;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Interval) {
            Interval i = (Interval) o;
            return (pocetnaTacka == i.pocetnaTacka && krajnjaTacka == i.krajnjaTacka
                    && pocetnaTackaPripadaIntervalu == i.pocetnaTackaPripadaIntervalu && krajnjaTackaPripadaIntervalu == i.krajnjaTackaPripadaIntervalu);
        }
        return false;
    }

    @Override
    public String toString() {
        if (isNull()) return "()";
        String s = "";
        if (pocetnaTackaPripadaIntervalu) {
            s = s + "[";
        } else {
            s = s + "(";
        }
        s = s + pocetnaTacka + "," + krajnjaTacka;
        if (krajnjaTackaPripadaIntervalu) {
            s = s + "]";
        } else {
            s = s + ")";
        }
        return s;
    }

}
