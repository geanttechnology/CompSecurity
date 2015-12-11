// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.res.Resources;
import com.smule.android.network.core.b;
import com.smule.android.network.managers.s;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GlobeActivity, an

class a
    implements Runnable
{

    final s a;
    final b b;

    public void run()
    {
        b.b.a(false);
        if (a != null)
        {
            com.smule.android.network.core.b.a(a.a);
        }
        GlobeActivity.v(b.b).a(2, b.b.getResources().getString(0x7f0c0045), true);
        GlobeActivity.a(b.b, 4);
    }

    ( , s s1)
    {
        b = ;
        a = s1;
        super();
    }
}
