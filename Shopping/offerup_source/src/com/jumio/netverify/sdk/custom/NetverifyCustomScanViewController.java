// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netverify.sdk.custom;

import jumiomobile.gs;

public final class NetverifyCustomScanViewController
{

    private gs documentScanController;

    NetverifyCustomScanViewController(gs gs1)
    {
        documentScanController = gs1;
    }

    public final void confirmScan()
    {
        documentScanController.C();
    }

    public final void destroy()
    {
        documentScanController.g();
    }

    public final boolean hasFlash()
    {
        return documentScanController.h();
    }

    public final boolean hasMultipleCameras()
    {
        return documentScanController.l();
    }

    public final boolean isCameraFrontFacing()
    {
        return documentScanController.m();
    }

    public final boolean isFallbackAvailable()
    {
        return documentScanController.D();
    }

    public final boolean isFlashOn()
    {
        return documentScanController.i();
    }

    public final void pauseExtraction()
    {
        documentScanController.t();
    }

    public final void resumeExtraction()
    {
        documentScanController.u();
    }

    public final void retryScan()
    {
        documentScanController.e();
    }

    public final boolean showShutterButton()
    {
        return documentScanController.o();
    }

    public final void startFallback()
    {
        documentScanController.E();
    }

    public final void startUSAddressFallback()
    {
        documentScanController.G();
    }

    public final void stopScan()
    {
        documentScanController.f();
    }

    public final void switchCamera()
    {
        documentScanController.n();
    }

    public final void takePicture()
    {
        documentScanController.p();
    }

    public final void toggleFlash()
    {
        documentScanController.j();
    }
}
