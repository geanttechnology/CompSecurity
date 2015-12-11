// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;
import com.smule.android.c.f;
import com.smule.android.network.models.SongV2;
import com.smule.magicpiano.PianoCoreBridge;
import com.smule.pianoandroid.utils.q;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GoodJobActivity

class a
    implements android.view.r
{

    final GoodJobActivity a;

    public void onClick(View view)
    {
        String s = GoodJobActivity.d(a).songId;
        if (PianoCoreBridge.isJoin())
        {
            view = f.e;
        } else
        {
            view = f.a;
        }
        q.a(s, false, view);
        GoodJobActivity.e(a);
    }

    (GoodJobActivity goodjobactivity)
    {
        a = goodjobactivity;
        super();
    }
}
