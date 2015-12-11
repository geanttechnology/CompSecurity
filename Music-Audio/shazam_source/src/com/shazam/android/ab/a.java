// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ab;

import android.content.Intent;

// Referenced classes of package com.shazam.android.ab:
//            d

public final class a
    implements d
{

    public a()
    {
    }

    public final Intent a(String s)
    {
        return Intent.parseUri(s, 1);
    }
}
