// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.content.DialogInterface;
import android.view.KeyEvent;

// Referenced classes of package io.branch.referral:
//            AnimatedDialog

class this._cls0
    implements android.content.nKeyListener
{

    final AnimatedDialog this$0;

    public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            AnimatedDialog.access$000(AnimatedDialog.this);
        }
        return true;
    }

    yListener()
    {
        this$0 = AnimatedDialog.this;
        super();
    }
}
