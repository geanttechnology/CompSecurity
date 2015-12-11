// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.poshmark.fb_tmblr_twitter.ExtServiceConnectInterface;
import com.poshmark.fb_tmblr_twitter.ExtServiceConnectManager;
import com.poshmark.http.api.PMApiError;
import com.poshmark.ui.model.ActionErrorContext;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingEditorShareFragment

class this._cls1
    implements ExtServiceConnectInterface
{

    final lrLoginComplete this$1;

    public void error(PMApiError pmapierror)
    {
        if (isAdded())
        {
            hideProgressDialog();
            showError(new ActionErrorContext(pmapierror, com.poshmark.ui.model.t.LINK_TUMBLR));
        }
    }

    public void success(int i, Bundle bundle)
    {
        if (isAdded())
        {
            hideProgressDialog();
            tumblrLoginComplete(bundle);
        }
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/poshmark/ui/fragments/ListingEditorShareFragment$5

/* anonymous class */
    class ListingEditorShareFragment._cls5
        implements android.view.View.OnClickListener
    {

        final ListingEditorShareFragment this$0;

        public void onClick(View view)
        {
            showProgressDialogWithMessage(getResources().getString(0x7f060190));
            ExtServiceConnectManager.getGlobalConnectManager().tumblrLink(ListingEditorShareFragment.this, new ListingEditorShareFragment._cls5._cls1());
        }

            
            {
                this$0 = ListingEditorShareFragment.this;
                super();
            }
    }

}
