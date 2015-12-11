// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.googlenow;

import android.content.Context;
import com.google.a.a.e;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;

// Referenced classes of package com.target.ui.googlenow:
//            b, GoogleNowSendCardHelper

public class GoogleNowStoreChangeListener
    implements com.target.ui.service.k.c
{

    public static final String TAG = "GoogleNowCreateAlarmListener";
    private Context mContext;

    public GoogleNowStoreChangeListener(Context context)
    {
        mContext = context.getApplicationContext();
    }

    private void b(e e1)
    {
        if (e1.b())
        {
            if (((RelevantStoreSummary)e1.c()).a() && !com.target.ui.googlenow.b.a(mContext).booleanValue())
            {
                com.target.ui.googlenow.b.a(mContext, Boolean.valueOf(true));
                (new GoogleNowSendCardHelper(mContext)).b();
                com.target.ui.googlenow.b.b(mContext, Boolean.valueOf(true));
            } else
            if (!((RelevantStoreSummary)e1.c()).a() && com.target.ui.googlenow.b.a(mContext).booleanValue())
            {
                com.target.ui.googlenow.b.a(mContext, Boolean.valueOf(false));
                return;
            }
        }
    }

    public void a(e e1)
    {
        b(e1);
    }
}
