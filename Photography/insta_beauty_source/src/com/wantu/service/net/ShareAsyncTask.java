// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.service.net;

import android.content.Context;
import android.telephony.TelephonyManager;
import boc;
import com.fotoable.comlib.util.AsyncTask;

public class ShareAsyncTask extends AsyncTask
{

    private final Context a;
    private final Target b;
    private final Type c;

    public ShareAsyncTask(Context context, Target target, Type type)
    {
        a = context;
        b = target;
        c = type;
    }

    protected transient String a(String as[])
    {
        as = ((TelephonyManager)a.getSystemService("phone")).getDeviceId();
        if (as != null)
        {
            try
            {
                boc.a(a, as, "android", b, c);
            }
            // Misplaced declaration of an exception variable
            catch (String as[]) { }
        }
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }
}
