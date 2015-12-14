// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;

import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.widget.TextView;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.framework.kindle.activity.FTUEFragmentActivity;
import com.amazon.gallery.framework.metrics.clickstream.ClickstreamEventHelper;
import com.amazon.gallery.framework.metrics.clickstream.HitType;

// Referenced classes of package com.amazon.gallery.thor.ftue:
//            MobileScreen

private class <init> extends PhoneNumberFormattingTextWatcher
{

    private boolean hasLoggedEvent;
    final MobileScreen this$0;

    public void afterTextChanged(Editable editable)
    {
        this;
        JVM INSTR monitorenter ;
        super.afterTextChanged(editable);
        MobileScreen.access$3300(MobileScreen.this);
        if (!hasLoggedEvent && MobileScreen.access$200(MobileScreen.this) != null && MobileScreen.access$200(MobileScreen.this).getText().length() > 0)
        {
            MobileScreen.access$3400(MobileScreen.this).getProfiler().trackEvent(com.amazon.gallery.framework.kindle.metrics.customer._F3__DB__09__B8__E6__DB__09__88__EE__DB__09_A, ClickstreamEventHelper.createClickstreamExtra("FTUE-Event", HitType.PAGE_TOUCH));
            hasLoggedEvent = true;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        editable;
        throw editable;
    }

    private ()
    {
        this$0 = MobileScreen.this;
        super();
        hasLoggedEvent = false;
    }

    hasLoggedEvent(hasLoggedEvent hasloggedevent)
    {
        this();
    }
}
