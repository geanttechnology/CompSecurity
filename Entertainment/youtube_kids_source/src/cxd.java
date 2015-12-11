// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class cxd
{

    private static final Pattern a = Pattern.compile("[0-9a-zA-Z._$]+@[0-9a-f]+$");
    private static final Pattern b = Pattern.compile("[\\.$]");
    private static final Map c;

    public static String a(Object obj)
    {
        return a(obj, false);
    }

    public static String a(Object obj, boolean flag)
    {
        if (!(obj instanceof Throwable))
        {
            String s = String.valueOf(obj);
            obj = s;
            if (a.matcher(s).matches())
            {
                obj = s.substring(0, s.lastIndexOf('@'));
            }
            return a(((String) (obj)));
        }
        Object obj2 = (Throwable)obj;
        obj = obj2.getClass().getSimpleName();
        Object obj1 = c.entrySet().iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj1)).next();
            String s1 = (String)entry.getKey();
            if (((String) (obj)).contains(s1))
            {
                obj = ((String) (obj)).replace(s1, (CharSequence)entry.getValue());
            }
        } while (true);
        obj1 = ((Throwable) (obj2)).getStackTrace();
        if (obj1.length == 0)
        {
            obj1 = "";
        } else
        {
            Object obj3 = obj1[0];
            obj1 = TextUtils.join(".", new String[] {
                ((StackTraceElement) (obj3)).getClassName(), ((StackTraceElement) (obj3)).getMethodName()
            });
            obj3 = Integer.toString(((StackTraceElement) (obj3)).getLineNumber());
            obj1 = b.split(((CharSequence) (obj1)));
            for (int i = 0; i < obj1.length; i++)
            {
                if (obj1[i].length() > 2)
                {
                    obj1[i] = obj1[i].substring(0, 2);
                }
            }

            obj1 = TextUtils.join(".", new String[] {
                TextUtils.join(".", ((Object []) (obj1))), obj3
            });
        }
        if (flag)
        {
            obj2 = ((Throwable) (obj2)).getMessage();
        } else
        {
            obj2 = null;
        }
        if (TextUtils.isEmpty(((CharSequence) (obj2))))
        {
            obj = TextUtils.join(".", new String[] {
                obj, obj1
            });
        } else
        {
            obj = TextUtils.join(".", new String[] {
                obj, obj1, obj2
            });
        }
        return a(((String) (obj)));
    }

    private static String a(String s)
    {
        if (s.length() <= 80)
        {
            return s;
        } else
        {
            return s.substring(0, 80);
        }
    }

    static 
    {
        HashMap hashmap = new HashMap();
        hashmap.put("Exception", "E");
        hashmap.put("Error", "E");
        hashmap.put("DataSource", "DSo");
        hashmap.put("DataSink", "DSi");
        c = Collections.unmodifiableMap(hashmap);
    }
}
