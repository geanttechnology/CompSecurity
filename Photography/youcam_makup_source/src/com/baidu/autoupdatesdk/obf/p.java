// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.apache.http.HttpEntity;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            m, o, r

public class p
{

    private static p b;
    private m a;

    private p()
    {
        a = new m();
    }

    public static p a()
    {
        if (b == null)
        {
            b = new p();
        }
        return b;
    }

    public WeakReference a(Context context, String s, o o)
    {
        return a.a(context, s, o);
    }

    public WeakReference a(Context context, String s, r r, o o)
    {
        return a.a(context, s, r, o);
    }

    public WeakReference a(Context context, String s, r r, Map map, o o)
    {
        return a.a(context, s, r, map, o);
    }

    public WeakReference a(Context context, String s, HttpEntity httpentity, o o)
    {
        return a.a(context, s, httpentity, "application/x-www-form-urlencoded", o);
    }

    public void a(Context context)
    {
        a.a(context, true);
    }
}
