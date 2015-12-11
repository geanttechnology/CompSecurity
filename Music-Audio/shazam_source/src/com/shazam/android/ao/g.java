// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ao;

import com.shazam.b.a.e;
import com.shazam.model.account.UserState;

public final class g
    implements e
{

    public g()
    {
    }

    public final volatile boolean apply(Object obj)
    {
        return (UserState)obj == UserState.ANONYMOUS;
    }
}
