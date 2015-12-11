// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.settings;

import android.content.DialogInterface;
import com.comcast.cim.android.view.launch.LaunchStrategy;
import com.comcast.cim.model.user.UserManager;

// Referenced classes of package com.comcast.cim.android.view.settings:
//            SignoutActivity

class this._cls0
    implements android.content.ClickListener
{

    final SignoutActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        SignoutActivity.access$000(SignoutActivity.this).signOutUser();
        SignoutActivity.access$100(SignoutActivity.this).restartAppFlow(SignoutActivity.this);
        finish();
    }

    ()
    {
        this$0 = SignoutActivity.this;
        super();
    }
}
