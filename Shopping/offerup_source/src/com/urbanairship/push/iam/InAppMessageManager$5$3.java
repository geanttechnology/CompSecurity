// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam;

import android.app.Activity;
import com.urbanairship.UAirship;
import java.lang.ref.WeakReference;

// Referenced classes of package com.urbanairship.push.iam:
//            InAppMessageManager

class val.weakReference
    implements com.urbanairship.
{

    final tivityResumed this$0;
    final WeakReference val$weakReference;

    public void onAirshipReady(UAirship uairship)
    {
        uairship = (Activity)val$weakReference.get();
        if (uairship != null)
        {
            UAirship.shared().getInAppMessageManager().onActivityResumed(uairship);
        }
    }

    ()
    {
        this$0 = final_;
        val$weakReference = WeakReference.this;
        super();
    }
}
