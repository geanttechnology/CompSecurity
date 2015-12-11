// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.authorization;

import com.comcast.cim.cmasl.http.request.RequestProviderFactory;
import com.comcast.cim.cmasl.http.request.signing.RequestSignerFactory;
import com.comcast.cim.cmasl.http.response.DetailedRequestStatus;
import com.comcast.cim.cmasl.http.service.HttpService;
import com.comcast.cim.cmasl.http.service.RetryingHttpService;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.utils.exceptions.CimException;
import com.comcast.cim.cmasl.xip.XipRequestProviderFactory;
import com.comcast.cim.cmasl.xip.ams.AmsHttpErrorException;
import com.comcast.cim.httpcomponentsandroid.NoHttpResponseException;
import com.comcast.cim.model.user.AuthKeys;
import com.comcast.playerplatform.primetime.android.player.DisneyEspnTokenDelegate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import com.xfinity.playerlib.model.user.PlayNowUser;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import com.xfinity.playerlib.tracking.PlayNowTrackingService;
import java.net.SocketTimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.authorization:
//            ThePlatformClient, SMILResource, VideoAuthorization, VideoAuthToken, 
//            VideoAuthorizationClient, VideoAuthTokenClient, VideoContinueClient, VideoSession

public class VideoAuthManager
    implements DisneyEspnTokenDelegate
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/authorization/VideoAuthManager);
    private VideoAuthorization amsVideoAuth;
    private AuthKeys authKeys;
    final RequestProviderFactory httpRequestProviderFactory;
    final HttpService httpService;
    private String liveStreamChannel;
    private String liveStreamScm;
    final ObjectMapper objectMapper;
    final RequestSignerFactory requestSignerFactory;
    private SMILResource smil;
    final PlayNowTrackingService trackingService;
    final PlayNowUserManager userManager;
    private VideoContinueClient vcClient;
    private VideoAuthToken videoAuthToken;
    private VideoEntitlement videoEntitlement;
    final Task videoEntitlementCache;
    final XipRequestProviderFactory xipRequestProviderFactory;

    public VideoAuthManager(PlayNowUserManager playnowusermanager, ObjectMapper objectmapper, HttpService httpservice, Task task, PlayNowTrackingService playnowtrackingservice, RequestProviderFactory requestproviderfactory, XipRequestProviderFactory xiprequestproviderfactory, 
            RequestSignerFactory requestsignerfactory)
    {
        userManager = playnowusermanager;
        objectMapper = objectmapper;
        httpService = httpservice;
        videoEntitlementCache = task;
        trackingService = playnowtrackingservice;
        httpRequestProviderFactory = requestproviderfactory;
        xipRequestProviderFactory = xiprequestproviderfactory;
        requestSignerFactory = requestsignerfactory;
    }

    private void callThePlatform(VideoFacade videofacade)
        throws Exception
    {
        try
        {
            LOG.debug("\n####thePlatform SMIL service call####");
            LOG.debug((new StringBuilder()).append("\n####smilUrl is:").append(videofacade.getReleaseURL()).toString());
            smil = (new ThePlatformClient(httpService, httpRequestProviderFactory)).getSMILResource(videofacade.getReleaseURL());
            LOG.debug((new StringBuilder()).append("*Signed Manifest Url: ").append(smil.getSignedManifestUrl()).toString());
            LOG.debug((new StringBuilder()).append("*AdsType: ").append(smil.getAdsType()).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (VideoFacade videofacade)
        {
            LOG.error("thePlatform call encountered exception:", videofacade);
        }
        throw videofacade;
    }

    private void reset()
    {
        LOG.debug("AuthManager reset...");
        authKeys = null;
        videoEntitlement = null;
        amsVideoAuth = null;
        smil = null;
        vcClient = null;
        liveStreamChannel = null;
        liveStreamScm = null;
    }

    private void setupAuth()
    {
        reset();
        authKeys = ((PlayNowUser)userManager.getUser()).getAuthKeys();
        LOG.debug((new StringBuilder()).append("####Auth Key:").append(authKeys).toString());
        videoEntitlement = (VideoEntitlement)videoEntitlementCache.execute();
        if (videoEntitlement != null)
        {
            LOG.debug((new StringBuilder()).append("*edata: ").append(videoEntitlement.getEdata()).toString());
            LOG.debug((new StringBuilder()).append("*xedata: ").append(videoEntitlement.getXedata()).toString());
        }
    }

    public String getDrmToken()
    {
        if (amsVideoAuth != null)
        {
            return amsVideoAuth.getDevicePlaybackToken();
        } else
        {
            return null;
        }
    }

    public SMILResource getSmil()
    {
        return smil;
    }

    public VideoAuthToken getVideoAuthToken()
    {
        return videoAuthToken;
    }

    public String onTokenExpired(String s, String s1)
    {
        try
        {
            performTVEAuth();
            s = videoAuthToken.getRawData();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }

    public void performAMSAuth(String s, String s1, boolean flag)
        throws Exception
    {
        try
        {
            LOG.debug("\n####AMS Access service call####");
            PlayerUserSettings playerusersettings = (PlayerUserSettings)userManager.getUserSettings();
            String s2 = playerusersettings.getDeviceAuthToken();
            String s3 = playerusersettings.getPreviousSessionId();
            amsVideoAuth = (new VideoAuthorizationClient(new RetryingHttpService(httpService, new com.comcast.cim.cmasl.http.service.RetryingHttpService.RetryPredicate() {

                final VideoAuthManager this$0;

                public boolean shouldRetry(CimException cimexception, int i)
                {
                    cimexception = cimexception.getCause();
                    return ((cimexception instanceof SocketTimeoutException) || (cimexception instanceof NoHttpResponseException)) && i < 1;
                }

            
            {
                this$0 = VideoAuthManager.this;
                super();
            }
            }), objectMapper, xipRequestProviderFactory, requestSignerFactory)).authorize(authKeys, videoEntitlement, s, s2, s3, s1, flag);
            LOG.debug((new StringBuilder()).append("*Playback token: ").append(amsVideoAuth.getDevicePlaybackToken()).toString());
            LOG.debug((new StringBuilder()).append("*Device auth token: ").append(amsVideoAuth.getDeviceAuthorizationToken()).toString());
            LOG.debug((new StringBuilder()).append("*Session id: ").append(amsVideoAuth.getSessionToken()).toString());
            if (amsVideoAuth.getSessionToken() != null)
            {
                playerusersettings.setDeviceAuthToken(amsVideoAuth.getDeviceAuthorizationToken());
                playerusersettings.setPreviousSessionId(amsVideoAuth.getSessionToken());
            }
            userManager.saveUserAsync();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            LOG.error("AMS call encountered exception:", s);
            trackingService.trackAMSRelatedVideoError(s.getDetailedStatus().getStatusMessage());
            throw s;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            LOG.error("AMS call encountered exception:", s);
        }
        trackingService.trackAMSRelatedVideoError(s.getMessage());
        throw s;
    }

    public void performLiveStreamAuthorization(HalLiveStream hallivestream, String s)
        throws Exception
    {
        setupAuth();
        if (hallivestream.getPlaybackLink() != null && (hallivestream.isEspn() || hallivestream.isDisney()))
        {
            liveStreamChannel = hallivestream.getSchemeSpecificPart();
            liveStreamScm = hallivestream.getScm();
            performTVEAuth();
            return;
        } else
        {
            performAMSAuth(hallivestream.getScm(), s, true);
            return;
        }
    }

    public void performTVEAuth()
        throws Exception
    {
        try
        {
            LOG.debug("\n####TVE Token Request call####");
            videoAuthToken = (new VideoAuthTokenClient(new RetryingHttpService(httpService, new com.comcast.cim.cmasl.http.service.RetryingHttpService.RetryPredicate() {

                final VideoAuthManager this$0;

                public boolean shouldRetry(CimException cimexception, int i)
                {
                    cimexception = cimexception.getCause();
                    return ((cimexception instanceof SocketTimeoutException) || (cimexception instanceof NoHttpResponseException)) && i < 1;
                }

            
            {
                this$0 = VideoAuthManager.this;
                super();
            }
            }), xipRequestProviderFactory, requestSignerFactory)).authorize(authKeys, videoEntitlement, liveStreamChannel, liveStreamScm);
            LOG.debug((new StringBuilder()).append("*Auth token title id: ").append(videoAuthToken.getTitleID()).toString());
            LOG.debug((new StringBuilder()).append("*Auth token resource id: ").append(videoAuthToken.getResourceID()).toString());
            LOG.debug((new StringBuilder()).append("*Auth token keyName: ").append(videoAuthToken.getKeyName()).toString());
            LOG.debug((new StringBuilder()).append("*Auth token value: ").append(videoAuthToken.getValue()).toString());
            return;
        }
        catch (AmsHttpErrorException amshttperrorexception)
        {
            LOG.error("AMS call encountered exception:", amshttperrorexception);
            trackingService.trackAMSRelatedVideoError(amshttperrorexception.getDetailedStatus().getStatusMessage());
            throw amshttperrorexception;
        }
        catch (Exception exception)
        {
            LOG.error("AMS call encountered exception:", exception);
            trackingService.trackAMSRelatedVideoError(exception.getMessage());
            throw exception;
        }
    }

    public void performVideoAuthorization(VideoFacade videofacade, String s)
        throws Exception
    {
        setupAuth();
        performAMSAuth(videofacade.getSecureMetadata(), s, false);
        callThePlatform(videofacade);
    }

    public void sendVideoContinueHeartbeat()
    {
        LOG.debug("\n####AMS Continue service call####");
        if (vcClient == null)
        {
            vcClient = new VideoContinueClient(httpService, objectMapper, xipRequestProviderFactory, requestSignerFactory);
        }
        VideoSession videosession = vcClient.sendHeartbeat(authKeys, amsVideoAuth);
        LOG.debug((new StringBuilder()).append("*Status code: ").append(videosession.getStatusCode()).toString());
    }

    public boolean shouldMakeContinueCall()
    {
        return amsVideoAuth != null && amsVideoAuth.getSessionToken() != null;
    }

}
