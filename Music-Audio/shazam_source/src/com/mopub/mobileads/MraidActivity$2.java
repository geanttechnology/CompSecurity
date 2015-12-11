// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.common.g;

// Referenced classes of package com.mopub.mobileads:
//            MraidActivity, g

final class a
    implements com.mopub.b.ivity._cls2
{

    final MraidActivity a;

    public final void a(boolean flag)
    {
        if (flag)
        {
            ((com.mopub.mobileads.g) (a)).b.setCloseVisible(false);
            return;
        } else
        {
            ((com.mopub.mobileads.g) (a)).b.setCloseVisible(true);
            return;
        }
    }

    (MraidActivity mraidactivity)
    {
        a = mraidactivity;
        super();
    }
}
