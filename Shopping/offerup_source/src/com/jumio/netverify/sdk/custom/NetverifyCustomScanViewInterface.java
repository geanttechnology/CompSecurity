// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netverify.sdk.custom;


public interface NetverifyCustomScanViewInterface
{

    public abstract void onNetverifyCameraAvailable();

    public abstract void onNetverifyExtractionStarted();

    public abstract void onNetverifyNoUSAddressFound();

    public abstract void onNetverifyPresentConfirmationView();
}
