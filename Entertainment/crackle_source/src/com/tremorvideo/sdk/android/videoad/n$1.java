// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import java.util.Comparator;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            n, aw

static final class 
    implements Comparator
{

    public int a(aw aw1, aw aw2)
    {
        if (aw1.i() < aw2.i())
        {
            return -1;
        }
        return aw1.i() <= aw2.i() ? 0 : 1;
    }

    public int compare(Object obj, Object obj1)
    {
        return a((aw)obj, (aw)obj1);
    }

    ()
    {
    }
}
