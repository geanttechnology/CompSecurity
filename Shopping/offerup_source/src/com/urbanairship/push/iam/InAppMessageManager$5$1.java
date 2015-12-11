// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam;

import com.urbanairship.UAirship;

// Referenced classes of package com.urbanairship.push.iam:
//            InAppMessageManager

class this._cls0
    implements com.urbanairship.
{

    final reground this$0;

    public void onAirshipReady(UAirship uairship)
    {
        UAirship.shared().getInAppMessageManager().onForeground();
    }

    ()
    {
        this$0 = this._cls0.this;
        super();
    }
}
