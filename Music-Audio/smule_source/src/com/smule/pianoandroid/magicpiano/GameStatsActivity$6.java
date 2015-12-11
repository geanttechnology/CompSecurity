// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.Dialog;
import android.view.View;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GameStatsActivity

class a
    implements android.view.
{

    final Dialog a;
    final GameStatsActivity b;

    public void onClick(View view)
    {
        a.dismiss();
    }

    (GameStatsActivity gamestatsactivity, Dialog dialog)
    {
        b = gamestatsactivity;
        a = dialog;
        super();
    }
}
