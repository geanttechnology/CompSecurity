// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.internal.gs;
import org.json.JSONObject;

public final class sn
{

    private final String a;
    private final JSONObject b;
    private final String c;
    private final String d;

    public sn(String s, gs gs1, String s1, JSONObject jsonobject)
    {
        d = gs1.b;
        b = jsonobject;
        c = s;
        a = s1;
    }

    public String a()
    {
        return a;
    }

    public String b()
    {
        return d;
    }

    public JSONObject c()
    {
        return b;
    }

    public String d()
    {
        return c;
    }
}
