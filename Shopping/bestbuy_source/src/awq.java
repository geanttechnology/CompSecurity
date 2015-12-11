// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.util.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class awq
    implements atx
{

    private Uri a;
    private byte b[];
    private Map c;

    public awq(atx atx1)
    {
        a = atx1.b();
        b = atx1.c();
        HashMap hashmap = new HashMap();
        atx1 = atx1.d().entrySet().iterator();
        do
        {
            if (!atx1.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)atx1.next();
            if (entry.getKey() != null)
            {
                hashmap.put(entry.getKey(), ((aty)entry.getValue()).a());
            }
        } while (true);
        c = Collections.unmodifiableMap(hashmap);
    }

    public Object a()
    {
        return e();
    }

    public String a(boolean flag)
    {
        StringBuilder stringbuilder = new StringBuilder("DataItemEntity[");
        stringbuilder.append("@");
        stringbuilder.append(Integer.toHexString(hashCode()));
        StringBuilder stringbuilder1 = (new StringBuilder()).append(",dataSz=");
        Object obj;
        if (b == null)
        {
            obj = "null";
        } else
        {
            obj = Integer.valueOf(b.length);
        }
        stringbuilder.append(stringbuilder1.append(obj).toString());
        stringbuilder.append((new StringBuilder()).append(", numAssets=").append(c.size()).toString());
        stringbuilder.append((new StringBuilder()).append(", uri=").append(a).toString());
        if (!flag)
        {
            stringbuilder.append("]");
            return stringbuilder.toString();
        }
        stringbuilder.append("]\n  assets: ");
        String s;
        for (Iterator iterator = c.keySet().iterator(); iterator.hasNext(); stringbuilder.append((new StringBuilder()).append("\n    ").append(s).append(": ").append(c.get(s)).toString()))
        {
            s = (String)iterator.next();
        }

        stringbuilder.append("\n  ]");
        return stringbuilder.toString();
    }

    public Uri b()
    {
        return a;
    }

    public byte[] c()
    {
        return b;
    }

    public Map d()
    {
        return c;
    }

    public atx e()
    {
        return this;
    }

    public String toString()
    {
        return a(Log.isLoggable("DataItem", 3));
    }
}
