// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.service.workflow;

import com.comcast.playerplatform.drm.java.client.SecurityTokenType;
import com.comcast.playerplatform.drm.java.event.AbstractDrmEventListener;
import com.comcast.playerplatform.drm.java.event.AbstractDrmLicenseEventListener;
import java.util.Iterator;
import java.util.Vector;

// Referenced classes of package com.comcast.playerplatform.drm.java.service.workflow:
//            AbstractOfflineDrmWorkflow

class this._cls0 extends AbstractDrmEventListener
{

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

    ()
    {
        this$0 = AbstractOfflineDrmWorkflow.this;
        super();
    }
}
