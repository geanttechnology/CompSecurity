// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.request;

import android.content.Context;
import android.util.Base64;
import com.adobe.ave.drm.DRMAcquireLicenseSettings;
import com.adobe.ave.drm.DRMLicense;
import com.adobe.ave.drm.DRMLicenseAcquiredCallback;
import com.adobe.ave.drm.DRMLicenseReturnCompleteCallback;
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
import com.comcast.playerplatform.drm.java.util.DrmUtil;
import com.comcast.playerplatform.drm.java.util.ThreadManager;
import com.comcast.playerplatform.util.android.AbstractResponseEventListener;
import com.comcast.playerplatform.util.android.ConfigurationManager;
import com.comcast.playerplatform.util.android.MoneyTrace;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.playerplatform.drm.java.request:
//            MetadataRequest, ClientSessionParser, TokenRequestData

public class ClientSessionRequest
{

    public static String ACCOUNT_WORKFLOW = "Account";
    public static String DEPROVISION_WORKFLOW = "Deprovision";
    public static String PROVISION_WORKFLOW = "Provision";
    public static String SESSION_WORKFLOW = "Session";
    public static final Logger logger = LoggerFactory.getLogger(com/comcast/playerplatform/drm/java/request/ClientSessionRequest);
    protected final com.adobe.mediacore.DRMService.DRMEventListener adobeDrmEventListener = new com.adobe.mediacore.DRMService.DRMEventListener() {

        final ClientSessionRequest this$0;

        public void onError(long l, long l1, Exception exception)
        {
            drmResponseEventListener.internalDRMError(SecurityTokenType.XSCT, "7505.1", "Unable to initialize");
        }

        public void onInitialized()
        {
            acquireLicense();
        }

            
            {
                this$0 = ClientSessionRequest.this;
                super();
            }
    };
    protected final DRMLicenseAcquiredCallback adobeDrmLicenseAcquiredCallback = new DRMLicenseAcquiredCallback() {

        final ClientSessionRequest this$0;

        public void LicenseAcquired(DRMLicense drmlicense)
        {
            ClientSessionRequest.logger.debug("LicenseAcquiredCallback");
            if (workflow.equals(ClientSessionRequest.DEPROVISION_WORKFLOW))
            {
                clientState.deleteAllSecurityTokens();
                drmResponseEventListener.deProvisionComplete();
            } else
            {
                drmlicense = new ClientSessionParser(drmlicense);
                if (drmlicense.isParsed())
                {
                    ClientSessionRequest.logger.debug((new StringBuilder()).append("DrmLicense parsed. Current Workflow:").append(String.valueOf(workflow)).toString());
                    if (workflow.equals(ClientSessionRequest.SESSION_WORKFLOW))
                    {
                        clientState.addSecurityToken(new SecurityToken(SecurityTokenType.XSCT, drmlicense));
                        ClientSessionRequest.logger.debug("Session Created. Call event listener");
                        drmResponseEventListener.sessionCreated();
                        return;
                    }
                    if (workflow.equals(ClientSessionRequest.PROVISION_WORKFLOW))
                    {
                        clientState.addSecurityToken(new SecurityToken(SecurityTokenType.XSCT, drmlicense));
                        drmResponseEventListener.provisionComplete();
                        return;
                    }
                    if (workflow.equals(ClientSessionRequest.ACCOUNT_WORKFLOW))
                    {
                        clientState.addSecurityToken(new SecurityToken(SecurityTokenType.XACT, drmlicense));
                        drmResponseEventListener.xactCreated();
                        return;
                    }
                } else
                {
                    ClientSessionRequest.logger.debug("Internal DRM Error 7503.3");
                    drmResponseEventListener.internalDRMError(SecurityTokenType.XSCT, "7503.3", "XSCT Token Failure Unable to Parse XSCT Token");
                    return;
                }
            }
        }

            
            {
                this$0 = ClientSessionRequest.this;
                super();
            }
    };
    protected final DRMOperationErrorCallback adobeDrmOperationCallback = new DRMOperationErrorCallback() {

        final ClientSessionRequest this$0;

        public void OperationError(long l, long l1, Exception exception)
        {
            ClientSessionRequest.logger.debug((new StringBuilder()).append("DRM OperationError: ").append(String.valueOf(l)).append(".").append(String.valueOf(l1)).toString());
            expireMetadataToken();
            if (l == 3329L && l1 == 412L)
            {
                drmResponseEventListener.unprovisionedError();
                return;
            }
            if (l == 3329L)
            {
                drmResponseEventListener.serverSecurityError(SecurityTokenType.XSCT, (new StringBuilder()).append(String.valueOf(l)).append(".").append(String.valueOf(l1)).toString(), "Security Server Error", messageId);
                return;
            } else
            {
                drmResponseEventListener.internalDRMError(SecurityTokenType.XSCT, (new StringBuilder()).append(String.valueOf(l)).append(".").append(String.valueOf(l1)).toString(), "Internal Error");
                return;
            }
        }

            
            {
                this$0 = ClientSessionRequest.this;
                super();
            }
    };
    protected final DRMOperationCompleteCallback adobeDrmOperationCompleteCallback = new DRMOperationCompleteCallback() {

        final ClientSessionRequest this$0;

        public void OperationComplete()
        {
            ThreadManager.getInstance().executeOnUIThread(new Runnable() {

                final _cls5 this$1;

                public void run()
                {
                    ClientSessionRequest.logger.debug("DrmOperation Complete. Start drmManager acquireLicense");
                    drmManager.acquireLicense(drmMetadata, DRMAcquireLicenseSettings.FORCE_REFRESH, adobeDrmOperationCallback, adobeDrmLicenseAcquiredCallback);
                }

            
            {
                this$1 = _cls5.this;
                super();
            }
            });
        }

            
            {
                this$0 = ClientSessionRequest.this;
                super();
            }
    };
    private ClientStateInterface clientState;
    private DRMManager drmManager;
    private DRMMetadata drmMetadata;
    private AbstractDrmEventListener drmResponseEventListener;
    protected final DRMLicenseReturnCompleteCallback licenseReturnCompleteCallback = new DRMLicenseReturnCompleteCallback() {

        final ClientSessionRequest this$0;

        public void OperationComplete(long l)
        {
        }

            
            {
                this$0 = ClientSessionRequest.this;
                super();
            }
    };
    private String messageId;
    private MetadataRequest metadataRequest;
    private final AbstractResponseEventListener onMetadataResponse = new AbstractResponseEventListener() {

        final ClientSessionRequest this$0;

        public void configurationNotReady()
        {
            ClientSessionRequest.logger.debug("MetaDataResponse Error: 7505.1");
            drmResponseEventListener.internalDRMError(SecurityTokenType.META, "7505.1", "Metadata ErrorNetwork Request Error");
        }

        public void requestFailed(String s)
        {
            ClientSessionRequest.logger.debug("MetaDataResponse Error: 7505.0");
            drmResponseEventListener.internalDRMError(SecurityTokenType.META, "7505.0", "Metadata ErrorNetwork Request Error");
        }

        public void responseReceived(String s)
        {
            ClientSessionRequest.logger.debug("MetaDataResponse Received. Creating Meta token");
            s = new SecurityToken(SecurityTokenType.META, s);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeZone(TimeZone.getTimeZone("Zulu"));
            calendar.add(11, 24);
            SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            simpledateformat.setTimeZone(TimeZone.getTimeZone("Zulu"));
            s.setNotOnOrAfter(simpledateformat.format(calendar.getTime()));
            clientState.addSecurityToken(s);
            acquireLicense();
        }

            
            {
                this$0 = ClientSessionRequest.this;
                super();
            }
    };
    private String productName;
    private String requestString;
    private String workflow;

    public ClientSessionRequest(final ClientStateInterface appclientState, final HttpClient httpClient, final AbstractDrmEventListener adobeDrmEventListener, final Context context)
    {
        logger.debug((new StringBuilder()).append("ClientSessionRequest created. ThreadTest:").append(Thread.currentThread().toString()).toString());
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final ClientSessionRequest this$0;
            final AbstractDrmEventListener val$adobeDrmEventListener;
            final ClientStateInterface val$appclientState;
            final Context val$context;
            final HttpClient val$httpClient;

            public void run()
            {
                drmManager = DRMManager.getSharedManager(context);
                clientState = appclientState;
                drmResponseEventListener = adobeDrmEventListener;
                productName = ConfigurationManager.getInstance().getConfigValue("ProductType");
                metadataRequest = new MetadataRequest(onMetadataResponse, httpClient);
            }

            
            {
                this$0 = ClientSessionRequest.this;
                context = context1;
                appclientState = clientstateinterface;
                adobeDrmEventListener = abstractdrmeventlistener;
                httpClient = httpclient;
                super();
            }
        });
    }

    private void acquireLicense()
    {
        String s = clientState.retrieveSecurityToken(SecurityTokenType.META).getToken();
        logger.debug((new StringBuilder()).append("Current Metadata token").append(String.valueOf(s)).toString());
        drmMetadata = drmManager.createMetadataFromBytes(Base64.decode(s, 0), adobeDrmOperationCallback);
        logger.debug("DrmMetadata created. Start SetAuth.");
        drmManager.setAuthenticationToken(drmMetadata, drmMetadata.getPolicies()[0].getAuthenticationDomain(), requestString.getBytes(), adobeDrmOperationCallback, adobeDrmOperationCompleteCallback);
    }

    private void expireMetadataToken()
    {
        if (clientState.retrieveSecurityToken(SecurityTokenType.META) != null)
        {
            Object obj = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            ((DateFormat) (obj)).setTimeZone(TimeZone.getTimeZone("Zulu"));
            obj = ((DateFormat) (obj)).format(new Date());
            clientState.retrieveSecurityToken(SecurityTokenType.META).setNotOnOrAfter(((String) (obj)));
        }
    }

    private void sendTokenRequest(final SecurityTokenType type, final String messageType, final String accountToken, final MoneyTrace moneyTrace)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final ClientSessionRequest this$0;
            final String val$accountToken;
            final String val$messageType;
            final MoneyTrace val$moneyTrace;
            final SecurityTokenType val$type;

            public void run()
            {
                ClientSessionRequest.logger.debug((new StringBuilder()).append("Get Token  ThreadTest:").append(Thread.currentThread().toString()).toString());
                byte abyte0[] = DrmUtil.generateNonce();
                if (moneyTrace != null)
                {
                    messageId = moneyTrace.generateHttpHeaderValue();
                } else
                {
                    messageId = DrmUtil.generateId();
                }
                ClientSessionRequest.logger.debug((new StringBuilder()).append("Current DRM MessageId:").append(messageId).toString());
                if (abyte0 != null)
                {
                    ObjectMapper objectmapper = new ObjectMapper();
                    try
                    {
                        requestString = objectmapper.writeValueAsString(new TokenRequestData(messageId, messageType, new String(abyte0), productName, accountToken));
                        submitRequest();
                        return;
                    }
                    catch (JsonProcessingException jsonprocessingexception)
                    {
                        drmResponseEventListener.internalDRMError(type, "7503.0", (new StringBuilder()).append(messageType).append(" Error").append("Unable to generate key").toString());
                    }
                    return;
                } else
                {
                    drmResponseEventListener.internalDRMError(type, "7503.0", "Session Create ErrorUnable to generate key");
                    return;
                }
            }

            
            {
                this$0 = ClientSessionRequest.this;
                moneyTrace = moneytrace;
                messageType = s;
                accountToken = s1;
                type = securitytokentype;
                super();
            }
        });
    }

    public void create(MoneyTrace moneytrace)
    {
        logger.debug((new StringBuilder()).append("SessionCreate.  ThreadTest:").append(Thread.currentThread().toString()).toString());
        workflow = SESSION_WORKFLOW;
        sendTokenRequest(SecurityTokenType.XSCT, "clientSession", null, moneytrace);
    }

    public void getXactToken(MoneyTrace moneytrace)
    {
        logger.debug((new StringBuilder()).append("GetXACT.  ThreadTest:").append(Thread.currentThread().toString()).toString());
        workflow = ACCOUNT_WORKFLOW;
        sendTokenRequest(SecurityTokenType.XACT, "clientAuthentication", null, moneytrace);
    }

    public void submitMetadataRequest()
    {
        metadataRequest.submitRequest();
    }

    public void submitRequest()
    {
        SecurityToken securitytoken = clientState.retrieveSecurityToken(SecurityTokenType.META);
        if (securitytoken != null && securitytoken.isValid())
        {
            logger.debug("MetaData is valid. Submitting DRM Request.");
            acquireLicense();
            return;
        } else
        {
            logger.debug("MetaData is invalid, refreshing data.");
            submitMetadataRequest();
            return;
        }
    }






/*
    static AbstractDrmEventListener access$102(ClientSessionRequest clientsessionrequest, AbstractDrmEventListener abstractdrmeventlistener)
    {
        clientsessionrequest.drmResponseEventListener = abstractdrmeventlistener;
        return abstractdrmeventlistener;
    }

*/


/*
    static String access$1102(ClientSessionRequest clientsessionrequest, String s)
    {
        clientsessionrequest.requestString = s;
        return s;
    }

*/



/*
    static ClientStateInterface access$202(ClientSessionRequest clientsessionrequest, ClientStateInterface clientstateinterface)
    {
        clientsessionrequest.clientState = clientstateinterface;
        return clientstateinterface;
    }

*/




/*
    static String access$402(ClientSessionRequest clientsessionrequest, String s)
    {
        clientsessionrequest.messageId = s;
        return s;
    }

*/





/*
    static DRMManager access$702(ClientSessionRequest clientsessionrequest, DRMManager drmmanager)
    {
        clientsessionrequest.drmManager = drmmanager;
        return drmmanager;
    }

*/



/*
    static String access$802(ClientSessionRequest clientsessionrequest, String s)
    {
        clientsessionrequest.productName = s;
        return s;
    }

*/


/*
    static MetadataRequest access$902(ClientSessionRequest clientsessionrequest, MetadataRequest metadatarequest)
    {
        clientsessionrequest.metadataRequest = metadatarequest;
        return metadatarequest;
    }

*/
}
