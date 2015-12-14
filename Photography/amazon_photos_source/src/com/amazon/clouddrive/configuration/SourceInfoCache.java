// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.configuration;

import com.amazon.clouddrive.internal.BasicSourceInfo;
import com.amazon.clouddrive.model.SetupSourceRequest;

public interface SourceInfoCache
{

    public abstract void cacheSourceInfo(BasicSourceInfo basicsourceinfo);

    public abstract void clear();

    public abstract SetupSourceRequest getSetupSourceRequest();

    public abstract BasicSourceInfo getSourceInfo();

    public abstract boolean isSourceInfoCached();
}
