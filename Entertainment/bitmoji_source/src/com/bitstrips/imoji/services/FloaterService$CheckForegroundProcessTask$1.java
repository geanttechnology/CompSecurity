// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.services;

import android.view.View;

// Referenced classes of package com.bitstrips.imoji.services:
//            FloaterService

class val.whitelistedAppInForeground
    implements Runnable
{

    final is._cls0 this$1;
    final boolean val$whitelistedAppInForeground;

    public void run()
    {
        if (val$whitelistedAppInForeground)
        {
            FloaterService.access$200(_fld0).setVisibility(0);
            return;
        } else
        {
            FloaterService.access$200(_fld0).setVisibility(4);
            return;
        }
    }

    ()
    {
        this$1 = final_;
        val$whitelistedAppInForeground = Z.this;
        super();
    }
}
