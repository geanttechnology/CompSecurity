// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.content.res.Resources;
import android.os.Bundle;
import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.cmasl.utils.provider.Provider;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

class this._cls0
    implements Provider
{

    final PreDownloadFlowFragment this$0;

    public CALDialogFragment get()
    {
        Bundle bundle = new Bundle();
        bundle.putString("title", PreDownloadFlowFragment.access$500(PreDownloadFlowFragment.this).getString(com.xfinity.playerlib.on_storage_error_title));
        bundle.putString("description", PreDownloadFlowFragment.access$500(PreDownloadFlowFragment.this).getString(com.xfinity.playerlib.on_storage_error_message));
        CALDialogFragment caldialogfragment = CALDialogFragment.newInstance("errorDlg");
        caldialogfragment.addArguments(bundle);
        caldialogfragment.setOnDismissListener(PreDownloadFlowFragment.access$600(PreDownloadFlowFragment.this));
        caldialogfragment.setOnCancelListener(PreDownloadFlowFragment.access$700(PreDownloadFlowFragment.this));
        return caldialogfragment;
    }

    public volatile Object get()
    {
        return get();
    }

    I()
    {
        this$0 = PreDownloadFlowFragment.this;
        super();
    }
}
