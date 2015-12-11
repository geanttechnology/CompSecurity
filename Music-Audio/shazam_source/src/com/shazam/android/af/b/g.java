// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.af.b;


// Referenced classes of package com.shazam.android.af.b:
//            d, f

public final class g extends IllegalStateException
{

    public g(f f1, d d1)
    {
        super((new StringBuilder("Cannot handle action ")).append(d1.name()).append(" in state ").append(f1.name()).toString());
    }

    public g(f f1, f f2)
    {
        super((new StringBuilder("Cannot transition to state ")).append(f2.name()).append(" from state ").append(f1.name()).toString());
    }
}
