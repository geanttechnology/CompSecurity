// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.app.Dialog;
import android.view.View;

// Referenced classes of package com.smule.pianoandroid.utils:
//            o

final class a
    implements android.view.OnClickListener
{

    final Dialog a;

    public void onClick(View view)
    {
        a.dismiss();
    }

    (Dialog dialog)
    {
        a = dialog;
        super();
    }
}
