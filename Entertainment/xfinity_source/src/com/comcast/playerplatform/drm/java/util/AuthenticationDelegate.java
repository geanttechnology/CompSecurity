// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.util;

import com.comcast.playerplatform.drm.java.client.SecurityToken;
import java.util.concurrent.Executor;

public interface AuthenticationDelegate
{

    public abstract SecurityToken getAccessToken();

    public abstract SecurityToken getMetadataToken();

    public abstract Executor getSharedExecutor();
}
