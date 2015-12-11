// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.config;

import cz.msebera.android.httpclient.util.Args;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package cz.msebera.android.httpclient.config:
//            Registry

public final class RegistryBuilder
{

    private final Map items = new HashMap();

    RegistryBuilder()
    {
    }

    public static RegistryBuilder create()
    {
        return new RegistryBuilder();
    }

    public Registry build()
    {
        return new Registry(items);
    }

    public RegistryBuilder register(String s, Object obj)
    {
        Args.notEmpty(s, "ID");
        Args.notNull(obj, "Item");
        items.put(s.toLowerCase(Locale.ENGLISH), obj);
        return this;
    }

    public String toString()
    {
        return items.toString();
    }
}
