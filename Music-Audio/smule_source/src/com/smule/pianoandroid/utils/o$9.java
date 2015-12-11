// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.app.Dialog;
import android.view.View;

// Referenced classes of package com.smule.pianoandroid.utils:
//            o

final class b
    implements android.view..OnClickListener
{

    final Dialog a;
    final android.view..OnClickListener b;

    public void onClick(View view)
    {
        a.dismiss();
        b.onClick(view);
    }

    (Dialog dialog, android.view..OnClickListener onclicklistener)
    {
        a = dialog;
        b = onclicklistener;
        super();
    }
}
