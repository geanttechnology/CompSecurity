// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import com.smule.android.network.models.SongV2;
import com.smule.pianoandroid.magicpiano.b.q;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            StartupActivity, i

class a
    implements q
{

    final StartupActivity a;

    public void a(SongV2 songv2)
    {
        if (StartupActivity.f(a) != null)
        {
            StartupActivity.f(a).dismiss();
        }
        StartupActivity.a(a, songv2);
        StartupActivity.a(a, null);
    }

    _cls9(StartupActivity startupactivity)
    {
        a = startupactivity;
        super();
    }
}
