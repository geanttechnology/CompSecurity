// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.content.SharedPreferences;
import co.vine.android.client.AppSessionListener;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android.service:
//            GCMRegistrationService

private class <init> extends AppSessionListener
{

    final GCMRegistrationService this$0;

    public void onGcmRegistrationComplete(String s, int i, String s1, long l)
    {
        if (i == 200 && l > 0L)
        {
            SLog.dWithTag("GCMRegService", "GCM registration completed successfully; saving regId and stopping service now.");
            s = GCMRegistrationService.getGCMPreferences(GCMRegistrationService.this).edit();
            s._mth0("registrationIdSent", true);
            s._mth0();
        }
        GCMRegistrationService.access$500(GCMRegistrationService.this);
    }

    private ()
    {
        this$0 = GCMRegistrationService.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
