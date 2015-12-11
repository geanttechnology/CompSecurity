// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            aqo

public class ir
{

    public ir()
    {
    }

    private int a(String s, int i)
    {
        int j;
        if (s != null && i < s.length())
        {
            j = Integer.parseInt(String.valueOf(s.charAt(i)));
        } else
        {
            j = 0;
        }
        aqo.a("getCharAtOrZero: value : %s, i : %d, result : %d", new Object[] {
            s, Integer.valueOf(i), Integer.valueOf(j)
        });
        return j;
    }

    private String a(double d, int i)
    {
        Object obj = new StringBuffer();
        for (int j = 0; j < i; j++)
        {
            d = 2D * d;
            double d1 = Math.floor(d);
            ((StringBuffer) (obj)).append((int)d1);
            d -= d1;
        }

        obj = ((StringBuffer) (obj)).toString();
        aqo.a("toBinary : value : %f, result : %s", new Object[] {
            Double.valueOf(d), obj
        });
        return ((String) (obj));
    }

    private String a(String s, String s1)
    {
        if (s == null || s1 == null)
        {
            return null;
        }
        StringBuffer stringbuffer = new StringBuffer();
        int j = Math.max(s.length(), s1.length());
        for (int i = 0; i < j; i++)
        {
            stringbuffer.append(a(s, i) * 2 + a(s1, i));
        }

        s = stringbuffer.toString();
        aqo.a("toQuadKey : %s", new Object[] {
            s
        });
        return s;
    }

    public String a(double d, double d1, int i)
    {
        d = Math.sin((3.1415926535897931D * d) / 180D);
        aqo.a("sinLat : %f", new Object[] {
            Double.valueOf(d)
        });
        d = 0.5D - Math.log((1.0D + d) / (1.0D - d)) / 12.566370614359172D;
        aqo.a("latDec : %f", new Object[] {
            Double.valueOf(d)
        });
        d1 = (180D + d1) / 360D;
        aqo.a("lngDec : %f", new Object[] {
            Double.valueOf(d1)
        });
        return a(a(d, i), a(d1, i));
    }
}
