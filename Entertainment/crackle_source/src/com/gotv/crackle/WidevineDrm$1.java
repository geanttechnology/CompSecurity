// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.drm.DrmInfoEvent;
import android.drm.DrmManagerClient;

// Referenced classes of package com.gotv.crackle:
//            WidevineDrm

class this._cls0
    implements android.drm.nt.OnInfoListener
{

    final WidevineDrm this$0;

    public void onInfo(DrmManagerClient drmmanagerclient, DrmInfoEvent drminfoevent)
    {
        if (drminfoevent.getType() == 3)
        {
            WidevineDrm.access$000(WidevineDrm.this, "Rights installed\n");
        }
    }

    InfoListener()
    {
        this$0 = WidevineDrm.this;
        super();
    }
}
