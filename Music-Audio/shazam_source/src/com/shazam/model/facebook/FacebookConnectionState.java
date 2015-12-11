// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.facebook;

import com.shazam.b.b;
import com.shazam.model.social.ConnectionState;

public interface FacebookConnectionState
    extends ConnectionState
{

    public static final FacebookConnectionState NO_OP = (FacebookConnectionState)com.shazam.b.b.a(com/shazam/model/facebook/FacebookConnectionState);

    public abstract void b();

    public abstract void c();

}
