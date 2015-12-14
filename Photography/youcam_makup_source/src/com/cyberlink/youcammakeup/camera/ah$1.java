// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.media.SoundPool;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            ah

class a
    implements android.media.Pool.OnLoadCompleteListener
{

    final ah a;

    public void onLoadComplete(SoundPool soundpool, int i, int j)
    {
        if (j == 0 && ah.a(a) == i)
        {
            float f = ah.b(a);
            soundpool.play(i, f, f, 1, 0, 1.0F);
            ah.a(a, -1);
        }
    }

    istener(ah ah1)
    {
        a = ah1;
        super();
    }
}
