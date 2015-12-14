// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.h;

import bo.app.ep;
import com.appboy.Constants;
import java.util.Iterator;
import myobfuscated.f.e;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
    implements e
{

    private static final String b;
    public JSONObject a;

    public a()
    {
        a = new JSONObject();
    }

    public a(JSONObject jsonobject)
    {
        Iterator iterator;
        a = new JSONObject();
        a = jsonobject;
        iterator = jsonobject.keys();
_L2:
        String s;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s = (String)iterator.next();
        if (!a(s))
        {
            a.remove(s);
            continue; /* Loop/switch isn't completed */
        }
        JSONException jsonexception;
        if (jsonobject.get(s) instanceof String)
        {
            if (!b(jsonobject.getString(s)))
            {
                a.remove(s);
            }
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            if (jsonobject.get(s) == JSONObject.NULL)
            {
                a.remove(s);
            }
        }
        // Misplaced declaration of an exception variable
        catch (JSONException jsonexception)
        {
            myobfuscated.i.a.c(b, (new StringBuilder("Caught json exception validating property with key name: ")).append(s).toString(), jsonexception);
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static boolean a(String s)
    {
        if (ep.c(s))
        {
            myobfuscated.i.a.b(b, "The Appboy property key cannot be null or contain only whitespaces. Not adding property.");
            return false;
        }
        if (s.startsWith("$"))
        {
            myobfuscated.i.a.b(b, "The leading character in the key string may not be '$'. Not adding property.");
            return false;
        } else
        {
            return true;
        }
    }

    private static boolean b(String s)
    {
        if (ep.c(s))
        {
            myobfuscated.i.a.b(b, "The Appboy property value cannot be null or contain only whitespaces. Not adding property.");
            return false;
        } else
        {
            return true;
        }
    }

    public final a a(String s, double d)
    {
        if (!a(s))
        {
            return this;
        }
        try
        {
            a.put(myobfuscated.i.e.e(s), d);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            myobfuscated.i.a.c(b, "Caught json exception trying to add property.", s);
            return this;
        }
        return this;
    }

    public final a a(String s, int i)
    {
        if (!a(s))
        {
            return this;
        }
        try
        {
            a.put(myobfuscated.i.e.e(s), i);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            myobfuscated.i.a.c(b, "Caught json exception trying to add property.", s);
            return this;
        }
        return this;
    }

    public final a a(String s, String s1)
    {
        if (!a(s) || !b(s1))
        {
            return this;
        }
        try
        {
            a.put(myobfuscated.i.e.e(s), myobfuscated.i.e.e(s1));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            myobfuscated.i.a.c(b, "Caught json exception trying to add property.", s);
            return this;
        }
        return this;
    }

    public final a a(String s, boolean flag)
    {
        if (!a(s))
        {
            return this;
        }
        try
        {
            a.put(myobfuscated.i.e.e(s), flag);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            myobfuscated.i.a.c(b, "Caught json exception trying to add property.", s);
            return this;
        }
        return this;
    }

    public final volatile Object forJsonPut()
    {
        return a;
    }

    static 
    {
        b = String.format("%s.%s", new Object[] {
            Constants.APPBOY_LOG_TAG_PREFIX, myobfuscated/h/a.getName()
        });
    }
}
