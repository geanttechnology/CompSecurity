// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.DialogFragment;
import android.content.DialogInterface;

// Referenced classes of package com.wishabi.flipp.app:
//            dq

public class dp extends DialogFragment
{

    dq a;

    public dp()
    {
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        if (a != null)
        {
            a.a(this);
        }
        super.onDismiss(dialoginterface);
    }
}
