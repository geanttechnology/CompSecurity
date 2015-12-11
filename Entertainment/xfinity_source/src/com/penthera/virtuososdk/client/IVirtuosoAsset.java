// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.client;


// Referenced classes of package com.penthera.virtuososdk.client:
//            IVirtuosoIdentifier

public interface IVirtuosoAsset
    extends IVirtuosoIdentifier
{

    public abstract String assetId();

    public abstract String assetURL();

    public abstract double currentSize();

    public abstract double expectedSize();

    public abstract double fractionComplete();

    public abstract String metadata();

    public abstract void setMetadata(String s);
}
