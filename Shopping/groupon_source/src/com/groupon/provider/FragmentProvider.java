// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.provider;

import com.google.inject.Provider;

public interface FragmentProvider
    extends Provider
{

    public abstract String getTitle();

    public abstract boolean isFragmentEnabled();
}
