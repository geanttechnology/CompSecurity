// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.xfinity.playerlib.view.common.ParentalControlPinFragment;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

private class fragmentProvider extends fragmentProvider
{

    private ParentalControlPinFragment fragment;
    private final Provider fragmentProvider;
    final PreDownloadFlowFragment this$0;

    protected void dismissDialog()
    {
        fragment.dismiss();
    }

    protected String getDialogId()
    {
        return "parental control pin fragment";
    }

    protected void showDialogWithDismissListener(android.content.nFragmentLifecycleManager nfragmentlifecyclemanager)
    {
        fragment = (ParentalControlPinFragment)fragmentProvider.get();
        FragmentTransaction fragmenttransaction = getActivity().getFragmentManager().beginTransaction();
        fragmenttransaction.addToBackStack(null);
        fragment.setOnDismissListener(nfragmentlifecyclemanager);
        fragment.show(fragmenttransaction, "dialog");
    }

    public (Provider provider)
    {
        this$0 = PreDownloadFlowFragment.this;
        super(PreDownloadFlowFragment.this, null);
        fragmentProvider = provider;
    }
}
