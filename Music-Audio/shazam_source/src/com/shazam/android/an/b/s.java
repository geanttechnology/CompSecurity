// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.b;

import java.util.Collection;

// Referenced classes of package com.shazam.android.an.b:
//            ad

public final class s
    implements ad
{

    private final Collection a;

    public s(Collection collection)
    {
        a = collection;
    }

    public final boolean a(String s1)
    {
        return a.contains(s1);
    }
}
