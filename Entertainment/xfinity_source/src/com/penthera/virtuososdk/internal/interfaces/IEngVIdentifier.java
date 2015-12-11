// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.internal.interfaces;

import com.penthera.virtuososdk.client.IVirtuosoIdentifier;

public interface IEngVIdentifier
    extends IVirtuosoIdentifier
{

    public abstract String clientProviderAuth();

    public abstract int getContentState();

    public abstract void setClientProviderAuth(String s);

    public abstract void setCompletionTime(long l);

    public abstract void setDownloadStatus(com.penthera.virtuososdk.Common.EFileDownloadStatus efiledownloadstatus);

    public abstract void setId(int i);
}
