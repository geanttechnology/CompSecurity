// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import com.google.android.gms.d.bd;
import com.google.android.gms.d.be;
import com.google.android.gms.d.he;

// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            j, c, p, i

public final class l
    implements j
{

    public l()
    {
    }

    public final i a(Context context, he he1, be be, bd bd)
    {
        return new c(context, new p(context, he1.l(), he1.getRequestId(), be, bd));
    }
}
