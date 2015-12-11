// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.service.workflow;

import android.content.Context;
import com.adobe.ave.drm.DRMLicense;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.playerplatform.drm.java.client.ClientStateInterface;
import com.comcast.playerplatform.drm.java.client.SecurityTokenType;
import com.comcast.playerplatform.drm.java.event.AbstractDrmEventListener;
import com.comcast.playerplatform.drm.java.event.AbstractDrmLicenseEventListener;
import com.comcast.playerplatform.drm.java.util.AuthenticationDelegate;
import com.comcast.playerplatform.util.android.MoneyTrace;
import java.util.Iterator;
import java.util.Vector;

// Referenced classes of package com.comcast.playerplatform.drm.java.service.workflow:
//            AbstractDRMWorkflow

public abstract class AbstractOfflineDrmWorkflow extends AbstractDRMWorkflow
{

    public AbstractOfflineDrmWorkflow(ClientStateInterface clientstateinterface, AuthenticationDelegate authenticationdelegate, Context context, HttpClient httpclient, MoneyTrace moneytrace)
    {
        super(clientstateinterface, authenticationdelegate, context, httpclient, moneytrace);
        drmEventListener = new AbstractDrmEventListener() {

            final AbstractOfflineDrmWorkflow this$0;

            public void internalDRMError(SecurityTokenType securitytokentype, String s, String s1)
            {
                securitytokentype = listeners;
                securitytokentype;
                JVM INSTR monitorenter ;
                Iterator iterator = listeners.iterator();
_L2:
                AbstractDrmLicenseEventListener abstractdrmlicenseeventlistener;
                do
                {
                    if (!iterator.hasNext())
                    {
                        break MISSING_BLOCK_LABEL_66;
                    }
                    abstractdrmlicenseeventlistener = (AbstractDrmLicenseEventListener)iterator.next();
                } while (abstractdrmlicenseeventlistener == null);
                abstractdrmlicenseeventlistener.offlineDRMFailure(s, s1, "");
                if (true) goto _L2; else goto _L1
_L1:
                s;
                securitytokentype;
                JVM INSTR monitorexit ;
                throw s;
                securitytokentype;
                JVM INSTR monitorexit ;
            }

            public void serverSecurityError(SecurityTokenType securitytokentype, String s, String s1, String s2)
            {
                securitytokentype = listeners;
                securitytokentype;
                JVM INSTR monitorenter ;
                Iterator iterator = listeners.iterator();
_L2:
                AbstractDrmLicenseEventListener abstractdrmlicenseeventlistener;
                do
                {
                    if (!iterator.hasNext())
                    {
                        break MISSING_BLOCK_LABEL_66;
                    }
                    abstractdrmlicenseeventlistener = (AbstractDrmLicenseEventListener)iterator.next();
                } while (abstractdrmlicenseeventlistener == null);
                abstractdrmlicenseeventlistener.offlineDRMFailure(s, s1, s2);
                if (true) goto _L2; else goto _L1
_L1:
                s;
                securitytokentype;
                JVM INSTR monitorexit ;
                throw s;
                securitytokentype;
                JVM INSTR monitorexit ;
            }

            public void sessionCreated()
            {
                validate();
            }

            public void unprovisionedError()
            {
                Vector vector = listeners;
                vector;
                JVM INSTR monitorenter ;
                Iterator iterator = listeners.iterator();
_L2:
                AbstractDrmLicenseEventListener abstractdrmlicenseeventlistener;
                do
                {
                    if (!iterator.hasNext())
                    {
                        break MISSING_BLOCK_LABEL_62;
                    }
                    abstractdrmlicenseeventlistener = (AbstractDrmLicenseEventListener)iterator.next();
                } while (abstractdrmlicenseeventlistener == null);
                abstractdrmlicenseeventlistener.offlineDRMFailure("3329.412.7005", "Device was unprovisioned, unable to retrieve session token", "");
                if (true) goto _L2; else goto _L1
_L1:
                Exception exception;
                exception;
                vector;
                JVM INSTR monitorexit ;
                throw exception;
                vector;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = AbstractOfflineDrmWorkflow.this;
                super();
            }
        };
    }

    public void sendDrmComplete(DRMLicense drmlicense)
    {
        Vector vector = listeners;
        vector;
        JVM INSTR monitorenter ;
        Iterator iterator = listeners.iterator();
_L2:
        AbstractDrmLicenseEventListener abstractdrmlicenseeventlistener;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_69;
            }
            abstractdrmlicenseeventlistener = (AbstractDrmLicenseEventListener)iterator.next();
        } while (abstractdrmlicenseeventlistener == null);
        abstractdrmlicenseeventlistener.offlineDRMComplete(manifestUri, drmlicense.getLicenseStartDate(), drmlicense.getLicenseEndDate(), drmlicense.getPolicyID());
        if (true) goto _L2; else goto _L1
_L1:
        drmlicense;
        vector;
        JVM INSTR monitorexit ;
        throw drmlicense;
        vector;
        JVM INSTR monitorexit ;
    }

    public void sendDrmFailure(String s, String s1, String s2)
    {
        Vector vector = listeners;
        vector;
        JVM INSTR monitorenter ;
        Iterator iterator = listeners.iterator();
_L2:
        AbstractDrmLicenseEventListener abstractdrmlicenseeventlistener;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_62;
            }
            abstractdrmlicenseeventlistener = (AbstractDrmLicenseEventListener)iterator.next();
        } while (abstractdrmlicenseeventlistener == null);
        abstractdrmlicenseeventlistener.offlineDRMFailure(s, s1, s2);
        if (true) goto _L2; else goto _L1
_L1:
        s;
        vector;
        JVM INSTR monitorexit ;
        throw s;
        vector;
        JVM INSTR monitorexit ;
    }
}
