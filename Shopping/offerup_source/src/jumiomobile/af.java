// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


// Referenced classes of package jumiomobile:
//            ac, ad

public class af
{

    private double a;
    private double b;

    public af()
    {
    }

    public af(double d1, double d2)
    {
        a = d1;
        b = d2;
    }

    public af(float f1, float f2, float f3, float f4)
    {
        a = f3 - f1;
        b = f4 - f2;
    }

    protected af(af af1)
    {
        a = af1.a;
        b = af1.b;
    }

    public double a()
    {
        return Math.sqrt(Math.pow(a, 2D) + Math.pow(b, 2D));
    }

    public double a(af af1)
    {
        af af2 = b();
        af af3 = af1.b();
        if (equals(af1))
        {
            return 0.0D;
        } else
        {
            return ac.a(Math.acos(af2.b(af3)));
        }
    }

    public af a(double d1)
    {
        return new af(a * d1, b * d1);
    }

    public af a(float f1, float f2)
    {
        return c(new af(f1, f2));
    }

    public double b(af af1)
    {
        return a * af1.a + b * af1.b;
    }

    public af b()
    {
        af af1 = new af();
        double d1 = a();
        af1.a = a / d1;
        af1.b = b / d1;
        return af1;
    }

    public ad c()
    {
        if (a >= 0.0D)
        {
            if (b >= 0.0D)
            {
                return ad.a;
            } else
            {
                return ad.d;
            }
        }
        if (b >= 0.0D)
        {
            return ad.b;
        } else
        {
            return ad.c;
        }
    }

    public af c(af af1)
    {
        af af2 = new af(this);
        af2.a = af2.a + af1.a;
        af2.b = af2.b + af1.b;
        return af2;
    }

    public double d()
    {
        return a;
    }

    public af d(af af1)
    {
        af af2 = new af(this);
        af2.a = af2.a - af1.a;
        af2.b = af2.b - af1.b;
        return af2;
    }

    public double e()
    {
        return b;
    }

    public float f()
    {
        return (float)(b / a);
    }

    public af g()
    {
        return new af(b, -a);
    }
}
