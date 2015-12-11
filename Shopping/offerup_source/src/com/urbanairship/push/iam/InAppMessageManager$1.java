// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam;


// Referenced classes of package com.urbanairship.push.iam:
//            InAppMessageManager

class this._cls0
    implements Runnable
{

    final InAppMessageManager this$0;

    public void run()
    {
        android.app.Activity activity;
        if ((InAppMessageManager.access$000(InAppMessageManager.this) || isDisplayAsapEnabled()) && isAutoDisplayEnabled())
        {
            if ((activity = InAppMessageManager.access$100(InAppMessageManager.this)) != null && showPendingMessage(activity))
            {
                InAppMessageManager.access$002(InAppMessageManager.this, false);
                return;
            }
        }
    }

    ()
    {
        this$0 = InAppMessageManager.this;
        super();
    }
}
