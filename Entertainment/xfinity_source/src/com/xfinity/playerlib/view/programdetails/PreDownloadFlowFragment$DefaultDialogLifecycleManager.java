// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.cmasl.utils.provider.Provider;
import org.slf4j.Logger;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

private class dialogProvider extends dialogProvider
{

    private final String dialogId;
    private final Provider dialogProvider;
    private CALDialogFragment managedDialog;
    final PreDownloadFlowFragment this$0;

    protected void dismissDialog()
    {
        managedDialog.dismiss();
    }

    protected String getDialogId()
    {
        return dialogId;
    }

    protected void showDialogWithDismissListener(android.content.ultDialogLifecycleManager ultdialoglifecyclemanager)
    {
        PreDownloadFlowFragment.access$100(PreDownloadFlowFragment.this).debug((new StringBuilder()).append("Resuming dialog with id ").append(dialogId).toString());
        managedDialog = (CALDialogFragment)dialogProvider.get();
        managedDialog.setOnDismissListener(ultdialoglifecyclemanager);
        managedDialog.show(getFragmentManager(), "caldialogfragment");
    }

    public (Provider provider, String s)
    {
        this$0 = PreDownloadFlowFragment.this;
        super(PreDownloadFlowFragment.this, null);
        dialogId = s;
        dialogProvider = provider;
    }
}
