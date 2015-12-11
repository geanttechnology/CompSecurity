// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.view.View;
import com.comcast.cim.android.view.launch.LaunchStrategy;
import com.comcast.cim.model.user.UserManager;

// Referenced classes of package com.comcast.cim.android.view.common:
//            CALDialogFragment

class this._cls0
    implements android.view.
{

    final CALDialogFragment this$0;

    public void onClick(View view)
    {
        dismiss();
        CALDialogFragment.access$000(CALDialogFragment.this).signOutUser();
        CALDialogFragment.access$100(CALDialogFragment.this).restartAppFlow(view.getContext());
    }

    ()
    {
        this$0 = CALDialogFragment.this;
        super();
    }
}
