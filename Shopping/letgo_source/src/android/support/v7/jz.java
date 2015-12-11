// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class jz
{

    private static final ConcurrentHashMap a = new ConcurrentHashMap();

    public static JSONObject a(String s)
    {
        return (JSONObject)a.get(s);
    }

    public static void a(String s, JSONObject jsonobject)
    {
        a.put(s, jsonobject);
    }

}
