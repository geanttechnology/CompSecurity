// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.widget.CompoundButton;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.fb_tmblr_twitter.FBPermissionStates;
import com.poshmark.fb_tmblr_twitter.FbHelper;
import com.poshmark.utils.ListingManager;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingEditorShareFragment

class this._cls0
    implements android.widget.eListener
{

    final ListingEditorShareFragment this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (FbHelper.getInstance().isPermissionEnabled(FBPermissionStates.PUBLISH_PERMISSION))
        {
            PMApplicationSession.GetPMSession().setFacebookSharingFlag(Boolean.valueOf(flag));
            ListingEditorShareFragment.access$000(ListingEditorShareFragment.this).setFacebookShareFlag(flag);
        } else
        if (flag)
        {
            FbHelper.getInstance().link(ListingEditorShareFragment.this, 8, 8, FbHelper.FB_CONNECT_PUBLISH_REQUEST);
            return;
        }
    }

    ()
    {
        this$0 = ListingEditorShareFragment.this;
        super();
    }
}
