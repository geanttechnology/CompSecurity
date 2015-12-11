// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.g;

import android.content.Context;
import com.shazam.android.persistence.n.b;

// Referenced classes of package com.shazam.android.j.g:
//            l

public final class i
    implements l
{

    private final Context a;
    private final b b;

    public i(Context context, b b1)
    {
        a = context;
        b = b1;
    }

    public final boolean a()
    {
        return b.a(a.getString(0x7f090241), true);
    }
}
