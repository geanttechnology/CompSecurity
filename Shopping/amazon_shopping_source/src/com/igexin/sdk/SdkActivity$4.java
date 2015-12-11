// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk;

import android.content.DialogInterface;
import android.view.KeyEvent;

// Referenced classes of package com.igexin.sdk:
//            SdkActivity

class this._cls0
    implements android.content.e.OnKeyListener
{

    final SdkActivity this$0;

    public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
    {
        switch (i)
        {
        default:
            return true;

        case 4: // '\004'
            dialoginterface.dismiss();
            break;
        }
        finish();
        return true;
    }

    ce()
    {
        this$0 = SdkActivity.this;
        super();
    }
}
