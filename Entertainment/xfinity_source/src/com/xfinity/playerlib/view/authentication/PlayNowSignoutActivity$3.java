// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.authentication;

import android.content.DialogInterface;

// Referenced classes of package com.xfinity.playerlib.view.authentication:
//            PlayNowSignoutActivity

class this._cls0
    implements android.content.istener
{

    final PlayNowSignoutActivity this$0;

    public void onCancel(DialogInterface dialoginterface)
    {
        finish();
    }

    ()
    {
        this$0 = PlayNowSignoutActivity.this;
        super();
    }
}
