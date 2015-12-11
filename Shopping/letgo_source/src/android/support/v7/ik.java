// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Build;
import java.lang.reflect.Field;
import java.util.Locale;

// Referenced classes of package android.support.v7:
//            aqo

public class ik
{

    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;

    public ik()
    {
        d();
        e();
        f();
        g();
    }

    private String a(int i)
    {
        Field afield[] = android/os/Build$VERSION_CODES.getFields();
        StringBuilder stringbuilder = new StringBuilder("Android");
        int l = afield.length;
        int k = 0;
        do
        {
label0:
            {
                if (k < l)
                {
                    Field field = afield[k];
                    String s1 = field.getName();
                    String s;
                    int j;
                    try
                    {
                        j = field.getInt(new Object());
                    }
                    catch (IllegalArgumentException illegalargumentexception)
                    {
                        aqo.b(illegalargumentexception, "Illegal Argument Exception", new Object[0]);
                        j = -1;
                    }
                    catch (IllegalAccessException illegalaccessexception)
                    {
                        aqo.b(illegalaccessexception, "Illegal Access Exception", new Object[0]);
                        j = -1;
                    }
                    catch (NullPointerException nullpointerexception)
                    {
                        aqo.b(nullpointerexception, "Npe!", new Object[0]);
                        j = -1;
                    }
                    if (j != i)
                    {
                        break label0;
                    }
                    s = (new StringBuilder()).append(s1.substring(0, 1).toUpperCase()).append(s1.substring(1).toLowerCase(Locale.US)).toString();
                    stringbuilder.append(" ").append(s);
                }
                return stringbuilder.toString();
            }
            k++;
        } while (true);
    }

    private void d()
    {
        a = "Android";
    }

    private void e()
    {
        b = (new StringBuilder()).append(Build.MANUFACTURER).append(" ").append(Build.MODEL).toString();
    }

    private void f()
    {
        f = "Letgo";
        e = "1.3.2";
    }

    private void g()
    {
        d = a(android.os.Build.VERSION.SDK_INT);
        c = android.os.Build.VERSION.RELEASE;
    }

    public String a()
    {
        return (new StringBuilder()).append(d).append(" ").append(c).toString();
    }

    public String b()
    {
        return (new StringBuilder()).append(f).append(" ").append(e).toString();
    }

    public String c()
    {
        return b;
    }
}
