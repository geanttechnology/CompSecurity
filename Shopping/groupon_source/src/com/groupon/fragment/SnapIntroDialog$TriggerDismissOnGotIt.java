// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.SharedPreferences;
import android.view.View;

// Referenced classes of package com.groupon.fragment:
//            SnapIntroDialog

private class <init>
    implements android.view.OnGotIt
{

    final SnapIntroDialog this$0;

    public void onClick(View view)
    {
        prefs.edit().otIt("snap_intro_done", true).otIt();
        dismiss();
    }

    private ()
    {
        this$0 = SnapIntroDialog.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
