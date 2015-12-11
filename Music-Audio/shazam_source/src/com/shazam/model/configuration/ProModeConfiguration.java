// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.configuration;

import com.shazam.b.b;
import com.shazam.server.response.follow.FollowData;

public interface ProModeConfiguration
{

    public static final ProModeConfiguration NO_OP = (ProModeConfiguration)com.shazam.b.b.a(com/shazam/model/configuration/ProModeConfiguration);

    public abstract boolean a();

    public abstract FollowData b();

}
