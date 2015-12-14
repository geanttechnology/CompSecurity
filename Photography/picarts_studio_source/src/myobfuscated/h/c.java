// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.h;

import bo.app.cx;
import bo.app.eg;
import bo.app.el;
import com.appboy.Constants;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{

    private final String a;
    private final int b;
    private final String c;
    private final String d;
    private eg e;
    private final Object f;

    private c(String s, int i, String s1, String s2)
    {
        f = new Object();
        a = s;
        b = i;
        c = s1;
        d = s2;
    }

    public c(String s, int i, String s1, String s2, eg eg1)
    {
        this(s, i, s1, s2);
        e = eg1;
    }

    public final JSONObject a()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("sdk_version", a);
            jsonobject.put("now", el.b());
            jsonobject.put("version_code", b);
            jsonobject.put("version_name", c);
            jsonobject.put("package_name", d);
            jsonobject.put("no_acks", true);
        }
        catch (JSONException jsonexception)
        {
            return jsonobject;
        }
        return jsonobject;
    }

    public final cx b()
    {
        Object obj2 = f;
        obj2;
        JVM INSTR monitorenter ;
        Object obj;
        Object obj1;
        obj1 = null;
        obj = obj1;
        if (e == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        obj = obj1;
        if (e.c.get())
        {
            obj = String.valueOf(e.e());
            e.a(false);
        }
        obj = new cx(a, b, c, d, ((String) (obj)));
        obj2;
        JVM INSTR monitorexit ;
        return ((cx) (obj));
        Exception exception;
        exception;
        throw exception;
    }

    static 
    {
        String.format("%s.%s", new Object[] {
            Constants.APPBOY_LOG_TAG_PREFIX, myobfuscated/h/c.getName()
        });
    }
}
