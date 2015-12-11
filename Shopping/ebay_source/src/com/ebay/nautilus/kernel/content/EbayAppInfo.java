// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.content;


public interface EbayAppInfo
{

    public abstract String getAppVersionBuildNumber();

    public abstract int getAppVersionBuildNumberWithoutVariations();

    public abstract String getAppVersionName();

    public abstract String getAppVersionWithoutBuildNumber();

    public abstract String getPackageName();

    public abstract boolean isDebuggable();
}
