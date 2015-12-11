// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.DialogInterface;
import com.ebay.common.net.api.usage.Usage;

// Referenced classes of package com.ebay.mobile.activities:
//            PreferencesActivity

class val.usage
    implements android.content.ntroller._cls1
{

    final val.usage this$1;
    final Usage val$usage;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        val$usage.startSession();
    }

    ()
    {
        this$1 = final_;
        val$usage = Usage.this;
        super();
    }
}
