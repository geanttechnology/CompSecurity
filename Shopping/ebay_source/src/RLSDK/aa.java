// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


public class aa
{

    private final float a;
    private final float b;

    public aa(float f, float f1)
    {
        a = f;
        b = f1;
    }

    public static float a(aa aa1, aa aa2)
    {
        float f = aa1.a - aa2.a;
        float f1 = aa1.b - aa2.b;
        return (float)Math.sqrt(f * f + f1 * f1);
    }

    public static void a(aa aaa[])
    {
        float f = a(aaa[0], aaa[1]);
        float f1 = a(aaa[1], aaa[2]);
        float f2 = a(aaa[0], aaa[2]);
        float f3;
        float f4;
        aa aa1;
        aa aa2;
        aa aa3;
        if (f1 >= f && f1 >= f2)
        {
            aa3 = aaa[0];
            aa2 = aaa[1];
            aa1 = aaa[2];
        } else
        if (f2 >= f1 && f2 >= f)
        {
            aa3 = aaa[1];
            aa2 = aaa[0];
            aa1 = aaa[2];
        } else
        {
            aa3 = aaa[2];
            aa2 = aaa[0];
            aa1 = aaa[1];
        }
        f = aa3.a;
        f1 = aa3.b;
        f2 = aa1.a;
        f3 = aa2.b;
        f4 = aa1.b;
        if ((f2 - f) * (f3 - f1) - (aa2.a - f) * (f4 - f1) >= 0.0F)
        {
            aa aa4 = aa1;
            aa1 = aa2;
            aa2 = aa4;
        }
        aaa[0] = aa1;
        aaa[1] = aa3;
        aaa[2] = aa2;
    }

    public final float a()
    {
        return a;
    }

    public final float b()
    {
        return b;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof aa)
        {
            obj = (aa)obj;
            flag = flag1;
            if (a == ((aa) (obj)).a)
            {
                flag = flag1;
                if (b == ((aa) (obj)).b)
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        return Float.floatToIntBits(a) * 31 + Float.floatToIntBits(b);
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer(25);
        stringbuffer.append('(');
        stringbuffer.append(a);
        stringbuffer.append(',');
        stringbuffer.append(b);
        stringbuffer.append(')');
        return stringbuffer.toString();
    }
}
