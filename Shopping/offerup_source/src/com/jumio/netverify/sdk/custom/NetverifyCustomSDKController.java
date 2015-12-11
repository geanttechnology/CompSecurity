// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netverify.sdk.custom;

import com.jumio.netverify.sdk.enums.NVDocumentType;
import com.jumio.netverify.sdk.enums.NVDocumentVariant;
import java.util.List;
import jumiomobile.gs;
import jumiomobile.ha;
import jumiomobile.hq;

// Referenced classes of package com.jumio.netverify.sdk.custom:
//            SDKNotConfiguredException, NetverifyDocumentPart, NetverifyCustomScanViewController, NetverifyCountry, 
//            NetverifyCustomScanView, NetverifyCustomConfirmationView, NetverifyCustomScanViewInterface

public final class NetverifyCustomSDKController
{

    private ha controller;
    private boolean isValid;

    public NetverifyCustomSDKController(ha ha1)
    {
        controller = ha1;
        isValid = true;
    }

    public final void clearSDK()
    {
        isValid = false;
        controller.e();
    }

    public final void finish()
    {
        if (!isValid)
        {
            throw new SDKNotConfiguredException("Controller is already destroyed");
        } else
        {
            controller.k();
            return;
        }
    }

    public final void retry()
    {
        if (!isValid)
        {
            throw new SDKNotConfiguredException("Controller is already destroyed");
        } else
        {
            controller.j();
            return;
        }
    }

    public final List setDocumentConfiguration(NetverifyCountry netverifycountry, NVDocumentType nvdocumenttype, NVDocumentVariant nvdocumentvariant)
    {
        if (!isValid)
        {
            throw new SDKNotConfiguredException("Controller is already destroyed");
        }
        controller.a(netverifycountry);
        controller.a(nvdocumenttype);
        controller.a(nvdocumentvariant);
        synchronized (controller)
        {
            controller.h();
            nvdocumenttype = controller.f();
        }
        return nvdocumenttype;
        nvdocumenttype;
        netverifycountry;
        JVM INSTR monitorexit ;
        throw nvdocumenttype;
    }

    public final NetverifyCustomScanViewController startScanForPart(NetverifyDocumentPart netverifydocumentpart, NetverifyCustomScanView netverifycustomscanview, NetverifyCustomConfirmationView netverifycustomconfirmationview, NetverifyCustomScanViewInterface netverifycustomscanviewinterface)
    {
        if (!isValid)
        {
            throw new SDKNotConfiguredException("Controller is already destroyed");
        }
        gs gs1 = controller.a(netverifydocumentpart);
        hq hq1 = controller.a(netverifydocumentpart.getScanSide());
        gs1.a(netverifycustomscanview, hq1, controller.b(netverifydocumentpart), netverifycustomscanviewinterface, controller.i());
        gs1.a(netverifycustomscanview);
        if (hq1 == hq.k)
        {
            gs1.d(false);
        }
        gs1.a(netverifycustomconfirmationview);
        gs1.d();
        gs1.e();
        return new NetverifyCustomScanViewController(gs1);
    }
}
