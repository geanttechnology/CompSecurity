// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netswipe.sdk;

import jumiomobile.dm;

public class NetswipeCustomScanPresenter
{

    private dm scanCardPresenter;

    NetswipeCustomScanPresenter(dm dm1)
    {
        scanCardPresenter = dm1;
    }

    public void clearSDK()
    {
        scanCardPresenter.e();
    }

    public boolean hasFlash()
    {
        return scanCardPresenter.i();
    }

    public boolean hasMultipleCameras()
    {
        return scanCardPresenter.l();
    }

    public boolean isCameraFrontFacing()
    {
        return scanCardPresenter.m();
    }

    public boolean isFlashOn()
    {
        return scanCardPresenter.j();
    }

    public void onActivityPause()
    {
        scanCardPresenter.c();
    }

    public void retryScan()
    {
        scanCardPresenter.h();
    }

    public void stopScan()
    {
        scanCardPresenter.d();
    }

    public void switchCamera()
    {
        scanCardPresenter.n();
    }

    public void toggleFlash()
    {
        scanCardPresenter.k();
    }
}
