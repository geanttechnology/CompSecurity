// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package a.a:
//            bc, bd

public final class bb
    implements bc
{

    private Map a;

    public bb()
    {
        a = new HashMap();
    }

    public final bb a(bd bd1)
    {
        if (bd1.b() != null)
        {
            a.put(bd1.a(), bd1.b());
        }
        return this;
    }

    public final JSONObject a()
    {
        return new JSONObject(a);
    }

    public final Object b()
    {
        return a();
    }
}
