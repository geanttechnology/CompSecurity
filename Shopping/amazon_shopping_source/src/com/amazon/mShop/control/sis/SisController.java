// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.sis;

import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.IdentifyUserWithSisRequest;
import com.amazon.rio.j2me.client.services.mShop.IdentifyUserWithSisResponse;
import com.amazon.rio.j2me.client.services.mShop.IdentifyUserWithSisResponseListener;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.util.Logger;
import java.util.List;
import java.util.Vector;

public class SisController
    implements IdentifyUserWithSisResponseListener
{

    private static final Logger logger = com.amazon.mShop.platform.Platform.Factory.getInstance().getLogger(com/amazon/mShop/control/sis/SisController);
    private static SisController sInstance;

    private SisController()
    {
    }

    public static void clearInstance()
    {
        com/amazon/mShop/control/sis/SisController;
        JVM INSTR monitorenter ;
        sInstance = null;
        com/amazon/mShop/control/sis/SisController;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static SisController getInstance()
    {
        com/amazon/mShop/control/sis/SisController;
        JVM INSTR monitorenter ;
        SisController siscontroller;
        if (sInstance == null)
        {
            sInstance = new SisController();
        }
        siscontroller = sInstance;
        com/amazon/mShop/control/sis/SisController;
        JVM INSTR monitorexit ;
        return siscontroller;
        Exception exception;
        exception;
        throw exception;
    }

    public void cancelled(ServiceCall servicecall)
    {
        logger.info("SIS call cancelled");
    }

    public void completed(IdentifyUserWithSisResponse identifyuserwithsisresponse, ServiceCall servicecall)
    {
        logger.info((new StringBuilder()).append("SIS call completed: ").append(identifyuserwithsisresponse).toString());
    }

    public void error(Exception exception, ServiceCall servicecall)
    {
        logger.error((new StringBuilder()).append("SIS call Exception: ").append(exception).toString());
    }

    public void startIdentifyUserSessionWithSis(List list, List list1)
    {
        IdentifyUserWithSisRequest identifyuserwithsisrequest = new IdentifyUserWithSisRequest();
        identifyuserwithsisrequest.setDeviceInfo(new Vector(list));
        identifyuserwithsisrequest.setDeviceNativeData(new Vector(list1));
        com.amazon.mShop.platform.Platform.Factory.getInstance().getMShopService().identifyUserWithSis(identifyuserwithsisrequest, this);
    }

}
