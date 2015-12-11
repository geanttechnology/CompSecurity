// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.launch;

import android.app.Activity;
import android.content.DialogInterface;

// Referenced classes of package com.comcast.cim.android.view.launch:
//            AuthenticatingActivityDelegate

class this._cls0
    implements android.content.gActivityDelegate._cls2
{

    final AuthenticatingActivityDelegate this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        AuthenticatingActivityDelegate.access$000(AuthenticatingActivityDelegate.this).finish();
    }

    ()
    {
        this$0 = AuthenticatingActivityDelegate.this;
        super();
    }
}
