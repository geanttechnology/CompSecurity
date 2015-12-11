// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.b;

import com.smule.android.f.j;
import com.smule.android.f.k;
import com.smule.android.f.n;
import com.smule.pianoandroid.magicpiano.MagicApplication;
import com.smule.pianoandroid.utils.g;

// Referenced classes of package com.smule.pianoandroid.magicpiano.b:
//            i

final class plication extends k
{

    public void a(j j1)
    {
        g.a((new StringBuilder()).append(n.b(MagicApplication.getContext())).append("/cache/").toString(), 20, 0);
        g.a((new StringBuilder()).append(n.b(MagicApplication.getContext())).append("globe_cache").toString(), 0, 1);
        j1.b(h);
    }

    plication()
    {
    }
}
