// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.launch;

import android.app.AlertDialog;
import android.content.Context;

// Referenced classes of package com.comcast.cim.android.view.launch:
//            AuthenticatingActivityDelegate

class this._cls0 extends AlertDialog
{

    final AuthenticatingActivityDelegate this$0;

    public boolean onSearchRequested()
    {
        return false;
    }

    (Context context)
    {
        this$0 = AuthenticatingActivityDelegate.this;
        super(context);
    }
}
