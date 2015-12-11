// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.settings;

import android.content.DialogInterface;

// Referenced classes of package com.comcast.cim.android.view.settings:
//            SignoutActivity

class this._cls0
    implements android.content.CancelListener
{

    final SignoutActivity this$0;

    public void onCancel(DialogInterface dialoginterface)
    {
        finish();
    }

    ()
    {
        this$0 = SignoutActivity.this;
        super();
    }
}
