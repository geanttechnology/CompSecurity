// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.downloads;

import com.comcast.cim.analytics.VideoErrorEventData;
import com.comcast.cim.android.view.common.errorformatter.ErrorFormatter;
import com.comcast.cim.android.view.common.errorformatter.FormattedError;
import com.comcast.cim.cmasl.analytics.AnalyticsLogger;
import com.comcast.cim.cmasl.utils.exceptions.CimException;
import com.comcast.playerplatform.primetime.android.asset.Asset;
import com.comcast.playerplatform.primetime.android.events.AbstractPlayerPlatformVideoEventListener;
import com.comcast.playerplatform.primetime.android.player.PlayerPlatformAPI;
import com.google.common.util.concurrent.SettableFuture;
import com.xfinity.playerlib.view.videoplay.PlayerPlatformErrorException;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MediaLicenseClient
{
    public static class LicenseAcquisitionTimeoutException extends CimException
    {

        public LicenseAcquisitionTimeoutException(String s, Throwable throwable)
        {
            super(s, throwable);
        }
    }


    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/downloads/MediaLicenseClient);
    private final ErrorFormatter errorFormatter;
    private final String hashedOmnitureGuid;
    private final AnalyticsLogger splunker;
    private final String versionNumber;

    public MediaLicenseClient(AnalyticsLogger analyticslogger, ErrorFormatter errorformatter, String s, String s1)
    {
        splunker = analyticslogger;
        errorFormatter = errorformatter;
        hashedOmnitureGuid = s;
        versionNumber = s1;
    }

    public Date getOrRefreshMediaLicense(PlayerPlatformAPI playerplatformapi, final Asset cimAsset)
    {
        AbstractPlayerPlatformVideoEventListener abstractplayerplatformvideoeventlistener;
        final SettableFuture licenseExpirationFuture;
        licenseExpirationFuture = SettableFuture.create();
        abstractplayerplatformvideoeventlistener = new AbstractPlayerPlatformVideoEventListener() {

            final MediaLicenseClient this$0;
            final Asset val$cimAsset;
            final SettableFuture val$licenseExpirationFuture;

            public void offlineDRMComplete(String s, Date date, Date date1, String s1)
            {
                if (s.equals(cimAsset.manifestUri))
                {
                    licenseExpirationFuture.set(date1);
                }
            }

            public void offlineDRMFailure(String s, String s1)
            {
                VideoErrorEventData videoerroreventdata = new VideoErrorEventData("drmFailure", hashedOmnitureGuid, versionNumber);
                videoerroreventdata.setErrorCodes(s);
                videoerroreventdata.setErrorTitle(s1);
                PlayerPlatformErrorException playerplatformerrorexception = new PlayerPlatformErrorException(s, s1);
                videoerroreventdata.setErrorMessage(errorFormatter.formatError(playerplatformerrorexception).getDescription());
                splunker.logData(videoerroreventdata);
                licenseExpirationFuture.setException(new PlayerPlatformErrorException(s, s1));
            }

            
            {
                this$0 = MediaLicenseClient.this;
                cimAsset = asset;
                licenseExpirationFuture = settablefuture;
                super();
            }
        };
        playerplatformapi.addEventListener(abstractplayerplatformvideoeventlistener);
        playerplatformapi.authenticateAssetOffline(cimAsset);
        cimAsset = (Date)licenseExpirationFuture.get(30L, TimeUnit.SECONDS);
        LOG.debug("License acquisition attempt complete, expiration date: {}", cimAsset);
        playerplatformapi.removeEventListener(abstractplayerplatformvideoeventlistener);
        return cimAsset;
        cimAsset;
        LOG.error("Caught exception acquiring license", cimAsset);
        throw new CimException("License acquisition failed", cimAsset);
        cimAsset;
        playerplatformapi.removeEventListener(abstractplayerplatformvideoeventlistener);
        throw cimAsset;
        cimAsset;
        cimAsset = cimAsset.getCause();
        if (cimAsset instanceof CimException)
        {
            throw (CimException)cimAsset;
        } else
        {
            throw new CimException("License acquisition failed", cimAsset);
        }
        cimAsset;
        throw new LicenseAcquisitionTimeoutException("License acquisition failed", cimAsset);
    }





}
