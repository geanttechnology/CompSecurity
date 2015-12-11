// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.a.i;

import com.shazam.model.myshazam.MyShazamTag;

// Referenced classes of package com.shazam.android.a.i:
//            a

final class a
    implements Runnable
{

    final MyShazamTag a;
    final hazamTag b;

    public final void run()
    {
        if (((MyShazamTag)b.b.getItem(b.b)).requestId.equals(a.requestId))
        {
            b.b.a(b.b, a);
        }
    }

    hazamTag(hazamTag hazamtag, MyShazamTag myshazamtag)
    {
        b = hazamtag;
        a = myshazamtag;
        super();
    }
}
