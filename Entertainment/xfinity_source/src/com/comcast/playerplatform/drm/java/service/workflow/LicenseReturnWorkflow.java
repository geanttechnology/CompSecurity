// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.service.workflow;

import android.util.Base64;
import com.adobe.ave.drm.DRMLicense;
import com.adobe.ave.drm.DRMManager;
import com.adobe.ave.drm.DRMMetadata;
import com.adobe.ave.drm.DRMOperationCompleteCallback;
import com.adobe.ave.drm.DRMPolicy;
import com.comcast.playerplatform.drm.java.client.SecurityToken;
import com.comcast.playerplatform.drm.java.event.AbstractDrmLicenseEventListener;
import com.comcast.playerplatform.drm.java.util.AuthenticationDelegate;
import com.comcast.playerplatform.drm.java.util.ThreadManager;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.comcast.playerplatform.drm.java.service.workflow:
//            AbstractOfflineDrmWorkflow

public class LicenseReturnWorkflow extends AbstractOfflineDrmWorkflow
{

    protected DRMLicense drmLicense;
    protected Boolean hasAcquiredLocalLicense;
    protected Boolean returnByPolicy;
    protected final DRMOperationCompleteCallback returnLicenseBlock;

    private void sendDrmLicenseReturn(final String drmKey)
    {
        Object obj = licenseFutureLock;
        obj;
        JVM INSTR monitorenter ;
        drmLicenseFuture = SettableFuture.create();
        drmKey = new Runnable() {

            final LicenseReturnWorkflow this$0;
            final String val$drmKey;

            public void run()
            {
                drmManager.setAuthenticationToken(drmMetadata, drmMetadata.getPolicies()[0].getAuthenticationDomain(), drmKey.getBytes(), drmOperationErrorCallback, returnLicenseBlock);
                drmLicenseFuture.get(20000L, TimeUnit.MILLISECONDS);
                return;
                Object obj1;
                obj1;
_L2:
                try
                {
                    sendDrmFailure("7005.2", ((Exception) (obj1)).getMessage(), messageId);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    drmLicenseFuture.setException(((Throwable) (obj1)));
                }
                return;
                obj1;
                continue; /* Loop/switch isn't completed */
                obj1;
                if (true) goto _L2; else goto _L1
_L1:
            }

            
            {
                this$0 = LicenseReturnWorkflow.this;
                drmKey = s;
                super();
            }
        };
        if (authDelegate == null || authDelegate.getSharedExecutor() == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        authDelegate.getSharedExecutor().execute(drmKey);
_L2:
        return;
        ThreadManager.getInstance().executeRunnable(drmKey);
        if (true) goto _L2; else goto _L1
_L1:
        drmKey;
        obj;
        JVM INSTR monitorexit ;
        throw drmKey;
    }

    public void sendDrmComplete(DRMLicense drmlicense)
    {
        if (!hasAcquiredLocalLicense.booleanValue() && drmlicense != null)
        {
            drmLicense = drmlicense;
            hasAcquiredLocalLicense = Boolean.valueOf(true);
            validate();
            return;
        } else
        {
            sendDrmFailure("7010.7009", "Error getting drmLicense", messageId);
            return;
        }
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
                break MISSING_BLOCK_LABEL_63;
            }
            abstractdrmlicenseeventlistener = (AbstractDrmLicenseEventListener)iterator.next();
        } while (abstractdrmlicenseeventlistener == null);
        abstractdrmlicenseeventlistener.licenseReturnFailure(s, s1, s2, null);
        if (true) goto _L2; else goto _L1
_L1:
        s;
        vector;
        JVM INSTR monitorexit ;
        throw s;
        vector;
        JVM INSTR monitorexit ;
    }

    public void validate()
    {
        if (hasAcquiredLocalLicense.booleanValue() || returnByPolicy.booleanValue())
        {
            SecurityToken securitytoken = getXsctToken();
            SecurityToken securitytoken1 = getMetadataToken();
            if (securitytoken != null && securitytoken.isValid() && securitytoken1 != null && securitytoken1.isValid())
            {
                drmMetadata = drmManager.createMetadataFromBytes(Base64.decode(securitytoken1.getToken(), 0), drmOperationErrorCallback);
                if (drmMetadata == null)
                {
                    return;
                } else
                {
                    sendDrmLicenseReturn((new StringBuilder()).append("{\"message:id\":\"").append(messageId).append("\", \"message:type\":\"clientAccess\",").append("\"client:accessToken\":\"").append(securitytoken.getToken()).append("\",\"client:mediaUsage\":\"download\"}").toString());
                    return;
                }
            } else
            {
                renewXsctToken();
                return;
            }
        } else
        {
            acquireVoucher(null);
            return;
        }
    }
}
