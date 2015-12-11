// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.content.DialogInterface;

// Referenced classes of package io.branch.referral:
//            ShareLinkManager

class this._cls0
    implements android.content.ismissListener
{

    final ShareLinkManager this$0;

    public void onDismiss(DialogInterface dialoginterface)
    {
        if (callback_ != null)
        {
            callback_.onShareLinkDialogDismissed();
            callback_ = null;
        }
        if (!ShareLinkManager.access$500(ShareLinkManager.this))
        {
            context_ = null;
            ShareLinkManager.access$602(ShareLinkManager.this, null);
        }
        shareDlg_ = null;
    }

    areListener()
    {
        this$0 = ShareLinkManager.this;
        super();
    }
}
