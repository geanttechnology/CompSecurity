// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.ui.PMActivity;
import com.poshmark.utils.view_holders.EditProfileFormViewHolder;

// Referenced classes of package com.poshmark.ui.fragments:
//            EditProfileFormFragment, ChangePasswordFragment

class this._cls0
    implements android.view.
{

    final EditProfileFormFragment this$0;

    public void onFocusChange(View view, boolean flag)
    {
        if (flag && mode == OFILE_MODE.PROFILE_MODE_EDIT && view == EditProfileFormFragment.access$200(EditProfileFormFragment.this).passwordEditText)
        {
            hideKeyboard();
            ((PMActivity)getActivity()).launchFragment(null, com/poshmark/ui/fragments/ChangePasswordFragment, null);
        }
    }

    older()
    {
        this$0 = EditProfileFormFragment.this;
        super();
    }
}
