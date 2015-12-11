// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.service.workflow;

import android.content.Context;
import android.util.Base64;
import com.adobe.ave.drm.DRMAcquireLicenseSettings;
import com.adobe.ave.drm.DRMLicense;
import com.adobe.ave.drm.DRMLicenseAcquiredCallback;
import com.adobe.ave.drm.DRMManager;
import com.adobe.ave.drm.DRMMetadata;
import com.adobe.ave.drm.DRMOperationCompleteCallback;
import com.adobe.ave.drm.DRMOperationErrorCallback;
import com.adobe.ave.drm.DRMPolicy;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.playerplatform.drm.java.client.ClientStateInterface;
import com.comcast.playerplatform.drm.java.client.SecurityToken;
import com.comcast.playerplatform.drm.java.client.SecurityTokenType;
import com.comcast.playerplatform.drm.java.event.AbstractDrmEventListener;
import com.comcast.playerplatform.drm.java.event.AbstractDrmLicenseEventListener;
import com.comcast.playerplatform.drm.java.service.SessionService;
import com.comcast.playerplatform.drm.java.util.AuthenticationDelegate;
import com.comcast.playerplatform.drm.java.util.DrmUtil;
import com.comcast.playerplatform.drm.java.util.MetadataUtil;
import com.comcast.playerplatform.drm.java.util.ThreadManager;
import com.comcast.playerplatform.util.android.AbstractResponseEventListener;
import com.comcast.playerplatform.util.android.MoneyTrace;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractDRMWorkflow
{

    private static final Pattern TAG_REGEX = Pattern.compile("EXT-X-FAXS-CM:(.+?)(#|\n)");
    private static final Logger logger = LoggerFactory.getLogger(com/comcast/playerplatform/drm/java/service/workflow/AbstractDRMWorkflow);
    protected AuthenticationDelegate authDelegate;
    protected ClientStateInterface clientState;
    protected Context context;
    protected AbstractDrmEventListener drmEventListener;
    protected final DRMLicenseAcquiredCallback drmLicenseAcquiredCallback = new DRMLicenseAcquiredCallback() {

        final AbstractDRMWorkflow this$0;

        public void LicenseAcquired(DRMLicense drmlicense)
        {
            if (drmLicenseFuture != null)
            {
                drmLicenseFuture.set(Boolean.valueOf(true));
            }
            if (drmlicense != null)
            {
                if ((new Date()).compareTo(drmlicense.getLicenseEndDate()) < 0)
                {
                    sendDrmComplete(drmlicense);
                }
                return;
            } else
            {
                sendDrmFailure("7005.7", "license does not exist", messageId);
                return;
            }
        }

            
            {
                this$0 = AbstractDRMWorkflow.this;
                super();
            }
    };
    protected SettableFuture drmLicenseFuture;
    protected DRMManager drmManager;
    protected DRMMetadata drmMetadata;
    protected final DRMOperationCompleteCallback drmOperationCompleteCallback = new DRMOperationCompleteCallback() {

        final AbstractDRMWorkflow this$0;

        public void OperationComplete()
        {
            ThreadManager.getInstance().executeOnUIThread(new Runnable() {

                final _cls6 this$1;

                public void run()
                {
                    Object obj = listeners;
                    obj;
                    JVM INSTR monitorenter ;
                    Iterator iterator = listeners.iterator();
_L2:
                    AbstractDrmLicenseEventListener abstractdrmlicenseeventlistener;
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break MISSING_BLOCK_LABEL_89;
                        }
                        abstractdrmlicenseeventlistener = (AbstractDrmLicenseEventListener)iterator.next();
                    } while (abstractdrmlicenseeventlistener == null);
                    abstractdrmlicenseeventlistener.acquiringLicense(manifestUri);
                    if (true) goto _L2; else goto _L1
_L1:
                    Exception exception;
                    exception;
                    obj;
                    JVM INSTR monitorexit ;
                    try
                    {
                        throw exception;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        drmLicenseFuture.setException(((Throwable) (obj)));
                    }
                    return;
                    obj;
                    JVM INSTR monitorexit ;
                    drmManager.acquireLicense(drmMetadata, licenseSettings, drmOperationErrorCallback, drmLicenseAcquiredCallback);
                    return;
                }

            
            {
                this$1 = _cls6.this;
                super();
            }
            });
        }

            
            {
                this$0 = AbstractDRMWorkflow.this;
                super();
            }
    };
    protected final DRMOperationErrorCallback drmOperationErrorCallback = new DRMOperationErrorCallback() {

        final AbstractDRMWorkflow this$0;

        public void OperationError(long l, long l1, Exception exception)
        {
            if (drmLicenseFuture != null)
            {
                drmLicenseFuture.set(Boolean.valueOf(true));
            }
            sendDrmFailure((new StringBuilder()).append(String.valueOf(l)).append(".").append(String.valueOf(l1)).toString(), "Offline Drm Failure", messageId);
        }

            
            {
                this$0 = AbstractDRMWorkflow.this;
                super();
            }
    };
    protected Boolean hasRenewedSession;
    protected HttpClient httpClient;
    protected Object licenseFutureLock;
    protected DRMAcquireLicenseSettings licenseSettings;
    protected Vector listeners;
    protected String manifestUri;
    protected String messageId;
    protected Boolean requestLicenseAnonymously;
    private AbstractResponseEventListener responseEventListener;
    protected SessionService sessionService;

    public AbstractDRMWorkflow(ClientStateInterface clientstateinterface, AuthenticationDelegate authenticationdelegate, Context context1, HttpClient httpclient, MoneyTrace moneytrace)
    {
        messageId = DrmUtil.generateId();
        licenseFutureLock = new Object();
        drmEventListener = new AbstractDrmEventListener() {

            final AbstractDRMWorkflow this$0;

            public void deProvisionComplete()
            {
                super.deProvisionComplete();
            }

            public void internalDRMError(SecurityTokenType securitytokentype, String s, String s1)
            {
                sendDrmFailure((new StringBuilder()).append(s).append(".").append("7005").toString(), s1, "");
            }

            public void provisionComplete()
            {
                super.provisionComplete();
            }

            public void serverSecurityError(SecurityTokenType securitytokentype, String s, String s1, String s2)
            {
                sendDrmFailure((new StringBuilder()).append(s).append(".").append("7005").toString(), s1, s2);
            }

            public void sessionCreated()
            {
                validate();
            }

            public void unprovisionedError()
            {
                sendDrmFailure("3329.412.7005", "Unable to retrieve Session Token. Device is not provisioned", "");
            }

            
            {
                this$0 = AbstractDRMWorkflow.this;
                super();
            }
        };
        responseEventListener = new AbstractResponseEventListener() {

            final AbstractDRMWorkflow this$0;

            public void responseReceived(String s)
            {
                getMetadata(s);
                validate();
            }

            
            {
                this$0 = AbstractDRMWorkflow.this;
                super();
            }
        };
        initializeInternals(clientstateinterface, authenticationdelegate, context1, httpclient, moneytrace);
    }

    private void attachAssetWithMetadata(DRMMetadata drmmetadata)
    {
        requestLicenseAnonymously = Boolean.valueOf(false);
        drmManager = DRMManager.getSharedManager(context);
        drmMetadata = drmmetadata;
        validate();
    }

    private void attachAssetWithoutMetadata()
    {
        MetadataUtil.attachMetadata(manifestUri, responseEventListener, httpClient);
    }

    private void getMetadata(String s)
    {
        try
        {
            s = TAG_REGEX.matcher(s);
            s.find();
            s = Base64.decode(s.group(1).getBytes(), 0);
            drmMetadata = drmManager.createMetadataFromBytes(s, drmOperationErrorCallback);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            sendDrmFailure("7005.1", "Failed to get metadata", messageId);
        }
    }

    private void initializeInternals(ClientStateInterface clientstateinterface, AuthenticationDelegate authenticationdelegate, Context context1, HttpClient httpclient, MoneyTrace moneytrace)
    {
        context = context1;
        clientState = clientstateinterface;
        authDelegate = authenticationdelegate;
        httpClient = httpclient;
        if (authenticationdelegate == null)
        {
            sessionService = new SessionService(clientState, context1, httpclient);
            sessionService.addEventListeners(drmEventListener);
        }
        licenseSettings = DRMAcquireLicenseSettings.FORCE_REFRESH;
        hasRenewedSession = Boolean.valueOf(false);
        listeners = new Vector();
        drmManager = DRMManager.getSharedManager(context1);
        requestLicenseAnonymously = Boolean.valueOf(false);
        if (moneytrace != null)
        {
            messageId = moneytrace.generateHttpHeaderValue();
        }
        logger.debug((new StringBuilder()).append("Current DRM MessageId:").append(messageId).toString());
    }

    private void loadVoucherWithToken(final String drmKey)
    {
        Object obj = licenseFutureLock;
        obj;
        JVM INSTR monitorenter ;
        drmLicenseFuture = SettableFuture.create();
        drmKey = new Runnable() {

            final AbstractDRMWorkflow this$0;
            final String val$drmKey;

            public void run()
            {
                drmManager.setAuthenticationToken(drmMetadata, drmMetadata.getPolicies()[0].getAuthenticationDomain(), drmKey.getBytes(), drmOperationErrorCallback, drmOperationCompleteCallback);
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
                this$0 = AbstractDRMWorkflow.this;
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

    protected void acquireVoucher(String s)
    {
label0:
        {
            if (drmManager != null && drmMetadata != null)
            {
                if (s == null)
                {
                    break label0;
                }
                loadVoucherWithToken(s);
            }
            return;
        }
        loadVoucherNoToken();
    }

    public void addEventListener(AbstractDrmLicenseEventListener abstractdrmlicenseeventlistener)
    {
        listeners.add(abstractdrmlicenseeventlistener);
    }

    public void attachAsset(String s)
    {
        attachAsset(s, null);
    }

    public void attachAsset(String s, DRMMetadata drmmetadata)
    {
        manifestUri = s;
        if (drmmetadata != null)
        {
            attachAssetWithMetadata(drmmetadata);
            return;
        } else
        {
            attachAssetWithoutMetadata();
            return;
        }
    }

    protected SecurityToken getMetadataToken()
    {
        if (authDelegate != null)
        {
            return authDelegate.getMetadataToken();
        } else
        {
            return clientState.retrieveSecurityToken(SecurityTokenType.META);
        }
    }

    protected SecurityToken getXsctToken()
    {
        if (authDelegate != null)
        {
            return authDelegate.getAccessToken();
        } else
        {
            return clientState.retrieveSecurityToken(SecurityTokenType.XSCT);
        }
    }

    protected void loadVoucherNoToken()
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
                break MISSING_BLOCK_LABEL_54;
            }
            abstractdrmlicenseeventlistener = (AbstractDrmLicenseEventListener)iterator.next();
        } while (abstractdrmlicenseeventlistener == null);
        abstractdrmlicenseeventlistener.acquiringLicense(manifestUri);
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        vector;
        JVM INSTR monitorexit ;
        throw exception;
        vector;
        JVM INSTR monitorexit ;
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final AbstractDRMWorkflow this$0;

            public void run()
            {
                drmManager.acquireLicense(drmMetadata, licenseSettings, drmOperationErrorCallback, drmLicenseAcquiredCallback);
            }

            
            {
                this$0 = AbstractDRMWorkflow.this;
                super();
            }
        });
        return;
    }

    protected void renewXsctToken()
    {
        if (!hasRenewedSession.booleanValue() && authDelegate == null)
        {
            hasRenewedSession = Boolean.valueOf(true);
            sessionService.create();
            return;
        }
        Vector vector = listeners;
        vector;
        JVM INSTR monitorenter ;
        Iterator iterator = listeners.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if ((AbstractDrmLicenseEventListener)iterator.next() != null)
            {
                sendDrmFailure("7005.10", "XSCT Token is invalid even after it was renewed", "");
            }
        } while (true);
        break MISSING_BLOCK_LABEL_90;
        Exception exception;
        exception;
        vector;
        JVM INSTR monitorexit ;
        throw exception;
        vector;
        JVM INSTR monitorexit ;
    }

    public abstract void sendDrmComplete(DRMLicense drmlicense);

    public abstract void sendDrmFailure(String s, String s1, String s2);

    public abstract void validate();


}
