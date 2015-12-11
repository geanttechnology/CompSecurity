// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.a;

import com.squareup.picasso.Callback;
import uk.co.senab.photoview.PhotoViewAttacher;

// Referenced classes of package com.offerup.android.g.a:
//            l

final class n
    implements Callback
{

    private l a;

    n(l l1)
    {
        a = l1;
        super();
    }

    public final void onError()
    {
        l.d(a);
    }

    public final void onSuccess()
    {
        l.c(a);
        l.a(a).update();
    }
}
