// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.support.v7.agv;
import android.util.Log;

// Referenced classes of package com.kahuna.sdk:
//            p, m

class v extends agv
{

    final er.toString a;

    public void a(String s)
    {
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Successfully sent monitor request: ").append(s).toString());
        }
    }

    public void a(Throwable throwable, String s)
    {
        super.a(throwable, s);
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Failed to send monitor request: ").append(s).toString(), throwable);
        }
    }

    er(er er)
    {
        a = er;
        super();
    }
}
