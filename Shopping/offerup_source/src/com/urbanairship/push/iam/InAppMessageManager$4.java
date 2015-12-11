// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam;

import android.app.Activity;
import android.os.Handler;
import com.urbanairship.Logger;

// Referenced classes of package com.urbanairship.push.iam:
//            InAppMessageFragment, InAppMessageManager, InAppMessage

class this._cls0
    implements istener
{

    final InAppMessageManager this$0;

    public void onFinish(InAppMessageFragment inappmessagefragment)
    {
        InAppMessage inappmessage;
        Logger.verbose((new StringBuilder("InAppMessageManager - InAppMessageFragment finished: ")).append(inappmessagefragment).toString());
        inappmessage = inappmessagefragment.getMessage();
        inappmessagefragment = ((InAppMessageFragment) (InAppMessageManager.access$500(InAppMessageManager.this)));
        inappmessagefragment;
        JVM INSTR monitorenter ;
        if (inappmessage == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        if (inappmessage.equals(getPendingMessage()))
        {
            setPendingMessage(null);
        }
        inappmessagefragment;
        JVM INSTR monitorexit ;
        if (inappmessage != null && inappmessage.equals(InAppMessageManager.access$400(InAppMessageManager.this)))
        {
            InAppMessageManager.access$402(InAppMessageManager.this, null);
            if (isDisplayAsapEnabled() && InAppMessageManager.access$100(InAppMessageManager.this) != null)
            {
                InAppMessageManager.access$002(InAppMessageManager.this, true);
                InAppMessageManager.access$700(InAppMessageManager.this).removeCallbacks(InAppMessageManager.access$600(InAppMessageManager.this));
                InAppMessageManager.access$700(InAppMessageManager.this).postDelayed(InAppMessageManager.access$600(InAppMessageManager.this), InAppMessageManager.access$800(InAppMessageManager.this));
            }
        }
        return;
        Exception exception;
        exception;
        inappmessagefragment;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onPause(InAppMessageFragment inappmessagefragment)
    {
        Logger.verbose((new StringBuilder("InAppMessageManager - InAppMessageFragment paused: ")).append(inappmessagefragment).toString());
        if (inappmessagefragment == InAppMessageManager.access$300(InAppMessageManager.this))
        {
            InAppMessageManager.access$302(InAppMessageManager.this, null);
            if (!inappmessagefragment.isDismissed() && inappmessagefragment.getActivity().isFinishing())
            {
                Logger.verbose((new StringBuilder("InAppMessageManager - InAppMessageFragment's activity is finishing: ")).append(inappmessagefragment).toString());
                InAppMessageManager.access$002(InAppMessageManager.this, true);
                return;
            }
        }
    }

    public void onResume(InAppMessageFragment inappmessagefragment)
    {
        Logger.verbose((new StringBuilder("InAppMessageManager - InAppMessageFragment resumed: ")).append(inappmessagefragment).toString());
        if (InAppMessageManager.access$300(InAppMessageManager.this) != null && InAppMessageManager.access$300(InAppMessageManager.this) != inappmessagefragment)
        {
            Logger.debug((new StringBuilder("InAppMessageManager - Dismissing ")).append(inappmessagefragment).append(" because it is no longer the current fragment.").toString());
            inappmessagefragment.dismiss(false);
            return;
        }
        if (InAppMessageManager.access$400(InAppMessageManager.this) == null || !InAppMessageManager.access$400(InAppMessageManager.this).equals(inappmessagefragment.getMessage()))
        {
            Logger.debug((new StringBuilder("InAppMessageManager - Dismissing ")).append(inappmessagefragment).append(" because its message is no longer current.").toString());
            inappmessagefragment.dismiss(false);
            return;
        } else
        {
            InAppMessageManager.access$302(InAppMessageManager.this, inappmessagefragment);
            return;
        }
    }

    istener()
    {
        this$0 = InAppMessageManager.this;
        super();
    }
}
