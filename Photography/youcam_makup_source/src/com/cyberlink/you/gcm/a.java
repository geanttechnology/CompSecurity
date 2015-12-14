// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.gcm;

import android.util.Log;
import com.cyberlink.you.utility.ULogUtility;

// Referenced classes of package com.cyberlink.you.gcm:
//            b

class a extends Thread
{

    private a()
    {
    }

    a(GcmRegService._cls1 _pcls1)
    {
        this();
    }

    public void run()
    {
        Log.d("GcmRegService", "GcmReg Service enter");
        ULogUtility.b("GcmReg Service enter", "GcmRegService");
        Thread.currentThread().setName("GcmReg");
        b.b();
        Log.d("GcmRegService", "GcmReg Service exit");
        ULogUtility.b("GcmReg Service exit", "GcmRegService");
    }
}
