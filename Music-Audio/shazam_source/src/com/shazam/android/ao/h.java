// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ao;

import com.shazam.b.a.e;
import com.shazam.model.account.UserState;

public final class h
    implements e
{

    public h()
    {
    }

    public final volatile boolean apply(Object obj)
    {
        obj = (UserState)obj;
        return obj == UserState.EMAIL_VALIDATED || obj == UserState.FACEBOOK_VALIDATED || obj == UserState.ANONYMOUS;
    }
}
