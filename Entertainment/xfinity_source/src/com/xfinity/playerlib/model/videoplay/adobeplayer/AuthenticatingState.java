// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.xip.ams.AmsHttpErrorException;
import com.comcast.cim.model.parentalcontrols.ParentalControlsPin;
import com.comcast.cim.model.parentalcontrols.ParentalControlsSettings;
import com.disney.datg.videoplatforms.sdk.common.VPAuthToken;
import com.disney.datg.videoplatforms.sdk.media.VPMedia;
import com.xfinity.playerlib.authorization.SMILResource;
import com.xfinity.playerlib.authorization.VideoAuthManager;
import com.xfinity.playerlib.authorization.VideoAuthToken;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;
import com.xfinity.playerlib.model.consumable.hal.HalNetworkProvider;
import com.xfinity.playerlib.view.videoplay.PlayerPlatformMediaPlayer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            DefaultVideoState, VideoStateController, InitializeLocalHostState, PlayerPreparingState, 
//            CheckPinState, ErrorState, VideoState

public class AuthenticatingState extends DefaultVideoState
    implements com.disney.datg.videoplatforms.sdk.media.VPMedia.VPMediaAuthorizationListener
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState);
    private String pin;
    private com.comcast.cim.android.view.common.PinKeypadFragment.PinValidationCompletedListener validationCompletedListener;

    public AuthenticatingState(VideoStateController videostatecontroller, com.comcast.cim.android.view.common.PinKeypadFragment.PinValidationCompletedListener pinvalidationcompletedlistener, String s)
    {
        super(videostatecontroller);
        validationCompletedListener = pinvalidationcompletedlistener;
        pin = s;
    }

    private void checkHidePinPadFragment()
    {
        if (validationCompletedListener != null)
        {
            stateController.getUiController().hidePinPadFragment(validationCompletedListener);
        }
    }

    private void performAMSAuthentication(final String pin)
    {
        stateController.getUiController().setLaunchMaturityRating(stateController.getVideoFacade());
        stateController.getUiController().setLaunchScreenMessage(com.xfinity.playerlib.R.string.player_launch_authenticating);
        stateController.getMediaStreamExecutor().execute(new Runnable() {

            final AuthenticatingState this$0;
            final String val$pin;

            private void callOnAmsAuthenticationException(Exception exception)
            {
                stateController.getUiThreadExecutor().execute(exception. new Runnable() {

                    final _cls1 this$1;
                    final Exception val$e;

                    public void run()
                    {
                        stateController.onAmsAuthenticationException(e);
                    }

            
            {
                this$1 = final__pcls1;
                e = Exception.this;
                super();
            }
                });
            }

            private void callOnAmsAuthenticationSuccess()
            {
                stateController.getUiThreadExecutor().execute(new Runnable() {

                    final _cls1 this$1;

                    public void run()
                    {
                        stateController.onAmsAuthenticationSuccess();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
            }

            private void callOnAmsPinRequired()
            {
                stateController.getUiThreadExecutor().execute(new Runnable() {

                    final _cls1 this$1;

                    public void run()
                    {
                        stateController.onAmsPinRequired();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
            }

            public void run()
            {
                if (stateController.shouldUseDownloadFile()) goto _L2; else goto _L1
_L1:
                stateController.performAmsAuthorization(pin);
_L4:
                callOnAmsAuthenticationSuccess();
                return;
_L2:
                if (stateController.getLiveStream() != null) goto _L4; else goto _L3
_L3:
                ParentalControlsSettings parentalcontrolssettings = (ParentalControlsSettings)stateController.getParentalControlsCache().execute();
                if (parentalcontrolssettings == null) goto _L4; else goto _L5
_L5:
                ParentalControlsPin parentalcontrolspin;
                try
                {
                    parentalcontrolspin = parentalcontrolssettings.getParentalPin();
                }
                catch (Exception exception)
                {
                    if ((exception instanceof AmsHttpErrorException) && ((AmsHttpErrorException)exception).getDetailedStatusCode() == 417)
                    {
                        callOnAmsPinRequired();
                        return;
                    } else
                    {
                        callOnAmsAuthenticationException(exception);
                        return;
                    }
                }
                if (parentalcontrolspin == null) goto _L4; else goto _L6
_L6:
                if (!pinRequiredForVideo(parentalcontrolssettings, stateController.getVideoFacade()) || pin != null && parentalcontrolspin.getPin().equals(pin)) goto _L4; else goto _L7
_L7:
                callOnAmsPinRequired();
                  goto _L4
            }

            
            {
                this$0 = AuthenticatingState.this;
                pin = s;
                super();
            }
        });
    }

    private boolean pinRequiredForVideo(ParentalControlsSettings parentalcontrolssettings, VideoFacade videofacade)
    {
        return parentalcontrolssettings.getProtectedRatings().contains(videofacade.getVideoRating()) || parentalcontrolssettings.getProtectedNetworkIds().contains(Long.valueOf(videofacade.getNetworkInfo().getNetworkId()));
    }

    public String getStateName()
    {
        return "AuthenticatingState";
    }

    public void onAmsAuthenticationException(Exception exception)
    {
        checkHidePinPadFragment();
        handleExceptionCaughtDuringAmsOperation(exception, this);
    }

    public void onAmsAuthenticationSuccess()
    {
        checkHidePinPadFragment();
        Object obj;
        if (!stateController.shouldUseDownloadFile())
        {
            if (stateController.isLiveStream() && (stateController.getLiveStream().isEspn() || stateController.getLiveStream().isDisney()))
            {
                stateController.setDrmKey(stateController.getVideoAuthManager().getVideoAuthToken().getRawData());
            } else
            {
                stateController.setDrmKey(stateController.getVideoAuthManager().getDrmToken());
            }
        } else
        {
            stateController.setDrmKey(null);
        }
        if (stateController.shouldUseDownloadFile() || stateController.isLiveStream()) goto _L2; else goto _L1
_L1:
        obj = stateController.getVideoAuthManager().getSmil().getAdsType();
        if (!((com.xfinity.playerlib.authorization.SMILResource.AdsType) (obj)).equals(com.xfinity.playerlib.authorization.SMILResource.AdsType.C3_ADS)) goto _L4; else goto _L3
_L3:
        obj = stateController.getVideoAuthManager().getSmil().getC3Blocks();
        stateController.getMediaPlayer().configureC3Ads(((List) (obj)));
_L2:
        if (stateController.shouldUseDownloadFile())
        {
            stateController.setManifestUrl((new StringBuilder()).append("http://127.0.0.1:").append(stateController.getHttpPort()).append("/variant.m3u8").toString());
            stateController.transitionToState(new InitializeLocalHostState(stateController));
            return;
        }
        break; /* Loop/switch isn't completed */
_L4:
        try
        {
            stateController.getMediaPlayer().configureAuditudeAds();
        }
        catch (ClassCastException classcastexception)
        {
            LOG.debug((new StringBuilder()).append("Everything we know is wrong. ").append(classcastexception.getMessage()).toString());
        }
        if (true) goto _L2; else goto _L5
_L5:
        if (!stateController.isLiveStream() || stateController.getLiveStream().isEspn() || stateController.getLiveStream().isDisney()) goto _L7; else goto _L6
_L6:
        stateController.setManifestUrl(stateController.getLiveStream().getPlaybackLink());
_L9:
        stateController.transitionToState(new PlayerPreparingState(stateController));
        return;
_L7:
        if (!stateController.isLiveStream())
        {
            stateController.setManifestUrl(stateController.getVideoAuthManager().getSmil().getSignedManifestUrl());
        }
        if (true) goto _L9; else goto _L8
_L8:
    }

    public void onAmsPinRequired()
    {
        if (validationCompletedListener != null)
        {
            stateController.getUiController().showErrorInPinPadFragment(validationCompletedListener);
        }
        stateController.transitionToState(new CheckPinState(stateController));
    }

    public void onAuthorizationFailure(VPMedia vpmedia, String s)
    {
        transitionToState(new ErrorState(stateController, (new StringBuilder()).append("Disney Media Authorization failed with message: ").append(s).toString()));
    }

    public void onAuthorizationSuccess(VPMedia vpmedia)
    {
        if (vpmedia != null)
        {
            LOG.debug((new StringBuilder()).append("Disney Media Authorization success. Token: ").append(vpmedia.getCurrentToken()).toString());
        }
    }

    public void onAuthorizationTokenRequest(VPMedia vpmedia)
    {
        LOG.debug("Disney Player Auth Token request received");
        vpmedia.authorizeMediaWithAuthToken(new VPAuthToken() {

            final AuthenticatingState this$0;

            
            {
                this$0 = AuthenticatingState.this;
                super();
                if (stateController.getVideoAuthManager().getVideoAuthToken() != null)
                {
                    authenticatingstate = stateController.getVideoAuthManager().getVideoAuthToken().getRawData();
                    HashMap hashmap = new HashMap();
                    hashmap.put("token_type", "offsite.comcast");
                    hashmap.put("token", AuthenticatingState.this);
                    setTokenParameters(hashmap);
                    return;
                } else
                {
                    transitionToState(new ErrorState(stateController, "Disney Media Authorization failed: VideoAuthToken is null"));
                    return;
                }
            }
        });
    }

    public void onPinCanceled()
    {
        checkHidePinPadFragment();
    }

    public void run()
    {
        performAMSAuthentication(pin);
    }

    public void transitionToState(VideoState videostate)
    {
        if ((videostate instanceof CheckPinState) || (videostate instanceof InitializeLocalHostState) || (videostate instanceof PlayerPreparingState))
        {
            stateController.setState(videostate);
            return;
        } else
        {
            super.transitionToState(videostate);
            return;
        }
    }


}
