// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;
import com.smule.pianoandroid.d.a;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            PreSongActivity

class a
    implements android.view.er
{

    final PreSongActivity a;

    public void onClick(View view)
    {
        int i = 1;
        if (com.smule.pianoandroid.d.a.b(a) < 1)
        {
            i = 0;
        }
        com.smule.pianoandroid.magicpiano.PreSongActivity.a(a, i);
    }

    _cls9(PreSongActivity presongactivity)
    {
        a = presongactivity;
        super();
    }
}
