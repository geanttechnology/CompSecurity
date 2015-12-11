// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.fb_tmblr_twitter.ExtServiceConnectManager;
import com.poshmark.fb_tmblr_twitter.PinterestHelper;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.PMActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            PinterestBoardSettingsFragment, PinterestBoardPickerFragment

class this._cls1
    implements android.content.gment._cls2._cls2
{

    final ctivity this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        showProgressDialogWithMessage(getString(0x7f060190));
        PMApi.unlinkExternalService("pn", new PMApiResponseHandler() {

            final PinterestBoardSettingsFragment._cls2._cls2 this$2;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                ExtServiceConnectManager.getGlobalConnectManager().pinterestUnlink();
                PinterestHelper.getInstance().unlink();
                PinterestHelper.getInstance().destroy();
                hideProgressDialog();
                getActivity().onBackPressed();
            }

            
            {
                this$2 = PinterestBoardSettingsFragment._cls2._cls2.this;
                super();
            }
        });
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/poshmark/ui/fragments/PinterestBoardSettingsFragment$2

/* anonymous class */
    class PinterestBoardSettingsFragment._cls2
        implements android.view.View.OnClickListener
    {

        final PinterestBoardSettingsFragment this$0;

        public void onClick(View view)
        {
            switch (view.getId())
            {
            default:
                return;

            case 2131493477: 
                view = new Bundle();
                view.putInt("mode", 1);
                getParentActivity().launchFragmentForResult(view, com/poshmark/ui/fragments/PinterestBoardPickerFragment, pins, PinterestBoardSettingsFragment.this, 1);
                return;

            case 2131493476: 
                view = new Bundle();
                view.putInt("mode", 2);
                getParentActivity().launchFragmentForResult(view, com/poshmark/ui/fragments/PinterestBoardPickerFragment, pins, PinterestBoardSettingsFragment.this, 2);
                return;

            case 2131493478: 
                view = new android.app.AlertDialog.Builder(getActivity());
                break;
            }
            view.setTitle((new StringBuilder()).append(getString(0x7f0602a6)).append("?").toString());
            view.setMessage(String.format(getString(0x7f0602aa), new Object[] {
                PMApplicationSession.GetPMSession().getTwitterUsername()
            }));
            view.setNegativeButton(0x7f06006d, new PinterestBoardSettingsFragment._cls2._cls1());
            view.setPositiveButton(0x7f0602a6, new PinterestBoardSettingsFragment._cls2._cls2());
            view.create().show();
        }

            
            {
                this$0 = PinterestBoardSettingsFragment.this;
                super();
            }

        // Unreferenced inner class com/poshmark/ui/fragments/PinterestBoardSettingsFragment$2$1

/* anonymous class */
        class PinterestBoardSettingsFragment._cls2._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final PinterestBoardSettingsFragment._cls2 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = PinterestBoardSettingsFragment._cls2.this;
                        super();
                    }
        }

    }

}
