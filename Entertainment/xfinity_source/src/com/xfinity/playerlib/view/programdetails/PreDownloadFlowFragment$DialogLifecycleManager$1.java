// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.content.DialogInterface;
import org.slf4j.Logger;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

class this._cls1
    implements android.content..DialogLifecycleManager._cls1
{

    final is._cls0 this$1;

    public void onDismiss(DialogInterface dialoginterface)
    {
        if (cess._mth4800(this._cls1.this))
        {
            cess._mth4802(this._cls1.this, false);
            return;
        }
        if (PreDownloadFlowFragment.access$4900(_fld0) == this._cls1.this)
        {
            PreDownloadFlowFragment.access$100(_fld0).debug("From onDismiss, nulling out lifecycle manager for {}", tDialogId());
            PreDownloadFlowFragment.access$4902(_fld0, null);
            return;
        } else
        {
            PreDownloadFlowFragment.access$100(_fld0).info("dialogLifecycleManager reference has been updated since we were dismissed, not clearing reference");
            return;
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
