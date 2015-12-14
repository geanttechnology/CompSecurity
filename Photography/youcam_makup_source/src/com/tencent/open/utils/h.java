// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.open.a.k;
import java.lang.ref.WeakReference;
import java.net.URL;

public class h
{

    private static final String a = (new StringBuilder()).append("openSDK_LOG.").append(com/tencent/open/utils/h.getName()).toString();
    private static h b = null;
    private volatile WeakReference c;

    public h()
    {
        c = null;
    }

    public static h a()
    {
        com/tencent/open/utils/h;
        JVM INSTR monitorenter ;
        h h1;
        if (b == null)
        {
            b = new h();
        }
        h1 = b;
        com/tencent/open/utils/h;
        JVM INSTR monitorexit ;
        return h1;
        Exception exception;
        exception;
        throw exception;
    }

    public String a(Context context, String s)
    {
        String s1;
        String s2;
        if (c == null || c.get() == null)
        {
            c = new WeakReference(context.getSharedPreferences("ServerPrefs", 0));
        }
        context = s;
        try
        {
            s1 = (new URL(s)).getHost();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            k.e(a, (new StringBuilder()).append("getEnvUrl url=").append(context).append("error.: ").append(s.getMessage()).toString());
            return context;
        }
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        context = s;
        k.e(a, (new StringBuilder()).append("Get host error. url=").append(s).toString());
        return s;
        context = s;
        s2 = ((SharedPreferences)c.get()).getString(s1, null);
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        context = s;
        if (!s1.equals(s2))
        {
            break MISSING_BLOCK_LABEL_198;
        }
        context = s;
        k.b(a, (new StringBuilder()).append("host=").append(s1).append(", envHost=").append(s2).toString());
        return s;
        context = s;
        s = s.replace(s1, s2);
        context = s;
        k.b(a, (new StringBuilder()).append("return environment url : ").append(s).toString());
        return s;
    }

}
