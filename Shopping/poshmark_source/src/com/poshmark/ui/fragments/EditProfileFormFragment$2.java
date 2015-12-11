// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.MotionEvent;
import android.view.View;
import com.poshmark.ui.PMActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            EditProfileFormFragment, ChangePasswordFragment

class this._cls0
    implements android.view.rmFragment._cls2
{

    final EditProfileFormFragment this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1)
        {
            hideKeyboard();
            ((PMActivity)getActivity()).launchFragment(null, com/poshmark/ui/fragments/ChangePasswordFragment, null);
            return true;
        } else
        {
            return false;
        }
    }

    _cls9()
    {
        this$0 = EditProfileFormFragment.this;
        super();
    }
}
