// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.i;

import bo.app.gq;
import bo.app.gr;
import com.appboy.Constants;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package myobfuscated.i:
//            a

public final class e
{

    private static final String a;
    private static gq b = (new gr()).c("appboy").a();
    private static gq c = (new gr()).c("first_name").c("last_name").c("email").c("bio").c("gender").c("dob").c("country").c("home_city").c("email_subscribe").c("push_subscribe").c("phone").c("facebook").c("twitter").c("image_url").a();
    private static String d = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    private static String e = "^[0-9 .\\(\\)\\+\\-]+$";

    public e()
    {
    }

    public static boolean a(String s)
    {
        return s != null && s.toLowerCase().matches(d);
    }

    public static boolean a(String s, Set set)
    {
        if (set.contains(s))
        {
            myobfuscated.i.a.b(a, String.format("Custom attribute key cannot be blacklisted attribute: %s.", new Object[] {
                s
            }));
            return true;
        } else
        {
            return false;
        }
    }

    public static String[] a(String as[])
    {
        if (as != null && as.length > 0)
        {
            for (int i = 0; i < as.length; i++)
            {
                as[i] = e(as[i]);
            }

        }
        return as;
    }

    public static boolean b(String s)
    {
        return s != null && s.matches(e);
    }

    public static boolean c(String s)
    {
        boolean flag;
        if (s == null)
        {
            myobfuscated.i.a.b(a, "Custom attribute key cannot be null.");
            return false;
        }
        String s1 = s.trim();
        bo.app.hv hv = b.a();
        String s2;
        do
        {
            if (!hv.hasNext())
            {
                break MISSING_BLOCK_LABEL_130;
            }
            s2 = (String)hv.next();
        } while (!s1.toLowerCase().startsWith(s2));
        myobfuscated.i.a.b(a, String.format("'%s' contains a reserved prefix. Cannot use the given key.", new Object[] {
            s1
        }));
        flag = true;
_L1:
        if (!flag)
        {
            s = s.trim();
            if (c.contains(s))
            {
                myobfuscated.i.a.b(a, String.format("'%s' is a reserved attribute key. Cannot use the given key.", new Object[] {
                    s
                }));
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                return true;
            }
        }
        break MISSING_BLOCK_LABEL_142;
        flag = false;
          goto _L1
        return false;
    }

    public static boolean d(String s)
    {
        if (s == null)
        {
            myobfuscated.i.a.b(a, "Custom attribute value cannot be null.");
            return false;
        } else
        {
            return true;
        }
    }

    public static String e(String s)
    {
        String s1 = s.trim();
        s = s1;
        if (s1.length() > 255)
        {
            myobfuscated.i.a.b(a, String.format("Provided string field is too long [%d]. The max length is %d, truncating provided field.", new Object[] {
                Integer.valueOf(s1.length()), Integer.valueOf(255)
            }));
            s = s1.substring(0, 255);
        }
        return s;
    }

    static 
    {
        a = String.format("%s.%s", new Object[] {
            Constants.APPBOY_LOG_TAG_PREFIX, myobfuscated/i/e.getName()
        });
    }
}
