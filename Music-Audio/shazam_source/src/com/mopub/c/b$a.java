// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.c;

import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

// Referenced classes of package com.mopub.c:
//            b

public static final class p
{

    String a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    String h;
    String i;
    Integer j;
    Integer k;
    Integer l;
    Integer m;
    String n;
    boolean o;
    String p;
    JSONObject q;
    String r;
    Map s;

    public final  a(Map map)
    {
        if (map == null)
        {
            s = new TreeMap();
            return this;
        } else
        {
            s = new TreeMap(map);
            return this;
        }
    }

    public final b a()
    {
        return new b(this, (byte)0);
    }

    public ()
    {
        o = false;
        s = new TreeMap();
    }
}
