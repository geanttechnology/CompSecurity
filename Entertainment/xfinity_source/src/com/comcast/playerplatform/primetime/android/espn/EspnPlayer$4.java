// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.espn;

import com.comcast.playerplatform.primetime.android.asset.Asset;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.comcast.playerplatform.primetime.android.events.AbstractPlayerPlatformVideoEventListener;
import com.comcast.playerplatform.primetime.android.player.Player;
import com.comcast.playerplatform.primetime.android.util.ThreadManager;
import com.espn.androidplayersdk.datamanager.EPStream;
import com.espn.androidplayersdk.objects.EPAuthError;
import com.espn.androidplayersdk.playbackmanager.EPPlaybackManagerListener;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import org.slf4j.Logger;

// Referenced classes of package com.comcast.playerplatform.primetime.android.espn:
//            EspnPlayer

class this._cls0
    implements EPPlaybackManagerListener
{

    final EspnPlayer this$0;

    public boolean shouldWaitForUpdatedAdobePassParams()
    {
        EspnPlayer.access$600().debug("shouldWaitForUpdatedAdobePass");
        return false;
    }

    public boolean shouldWaitForUpdatedAffiliateToken()
    {
        EspnPlayer.access$600().debug("shouldWaitForUpdatedAffiliateToken");
        if (EspnPlayer.access$100(EspnPlayer.this).getDisneyEspnTokenDelegate() != null && !EspnPlayer.access$400(EspnPlayer.this))
        {
            ThreadManager.getInstance().executeRunnable(EspnPlayer.access$1000(EspnPlayer.this));
        }
        return !EspnPlayer.access$400(EspnPlayer.this);
    }

    public void streamAuthorizationFailedWithError(EPAuthError epautherror)
    {
        EspnPlayer.access$402(EspnPlayer.this, false);
        if (EspnPlayer.access$500(EspnPlayer.this) != null)
        {
            String s = String.valueOf(epautherror.geterrorCode());
            String s1 = epautherror.getMessage();
            EspnPlayer.access$500(EspnPlayer.this).drmFailure(s, s1, "", null);
            sendMediaFailed(s, s1);
        }
        EspnPlayer.access$600().debug((new StringBuilder()).append("Stream Authorization failed with error:").append(epautherror.getMessage()).toString());
    }

    public void streamAuthorizationSucceeded(EPStream epstream)
    {
        EspnPlayer.access$600().debug("AuthorizationSucceeded");
        EspnPlayer.access$402(EspnPlayer.this, false);
        HttpCookie httpcookie = new HttpCookie(epstream.getAuthCookieName(), epstream.getToken());
        URI uri = URI.create("https://broadband.espn.go.com/");
        httpcookie.setDomain(uri.getHost());
        httpcookie.setPath(uri.getPath());
        httpcookie.setVersion(0);
        EspnPlayer.access$800(EspnPlayer.this).getCookieStore().removeAll();
        EspnPlayer.access$800(EspnPlayer.this).getCookieStore().add(uri, httpcookie);
        EspnPlayer.access$900(EspnPlayer.this, epstream);
    }

    public void streamCookieUpdated(EPStream epstream)
    {
        EspnPlayer.access$600().debug("CookieUpdated");
        HttpCookie httpcookie = new HttpCookie(epstream.getAuthCookieName(), epstream.getToken());
        URI uri = URI.create("https://broadband.espn.go.com/");
        httpcookie.setDomain(uri.getHost());
        httpcookie.setPath(uri.getPath());
        httpcookie.setVersion(0);
        EspnPlayer.access$800(EspnPlayer.this).getCookieStore().removeAll();
        EspnPlayer.access$800(EspnPlayer.this).getCookieStore().add(uri, httpcookie);
        EspnPlayer.access$900(EspnPlayer.this, epstream);
    }

    public void streamDidEnterBlackout(EPAuthError epautherror)
    {
        EspnPlayer.access$600().debug((new StringBuilder()).append("Stream Entered Blackout:").append(epautherror.getMessage()).toString());
        EspnPlayer.access$402(EspnPlayer.this, false);
        if (EspnPlayer.access$500(EspnPlayer.this) != null)
        {
            EspnPlayer.access$500(EspnPlayer.this).drmFailure(String.valueOf("7101"), epautherror.getMessage(), "", null);
            sendMediaFailed(String.valueOf("7101"), epautherror.getMessage());
            if (EspnPlayer.access$700(EspnPlayer.this).getPlayerStatus() == PlayerStatus.PLAYING || EspnPlayer.access$700(EspnPlayer.this).getPlayerStatus() == PlayerStatus.PAUSED)
            {
                EspnPlayer.access$700(EspnPlayer.this).stop();
            }
        }
    }

    public void streamDidFailAuthorizationWithMessage(String s)
    {
        EspnPlayer.access$402(EspnPlayer.this, false);
        if (EspnPlayer.access$500(EspnPlayer.this) != null)
        {
            String s1 = String.valueOf(7);
            if (s.equals("Unable to retrive live event for linear network"))
            {
                s1 = String.valueOf(8);
            }
            EspnPlayer.access$500(EspnPlayer.this).drmFailure(s1, s, "", null);
            sendMediaFailed(s1, s);
        }
        EspnPlayer.access$600().debug((new StringBuilder()).append("Authorization failed with message:").append(s).toString());
    }

    ()
    {
        this$0 = EspnPlayer.this;
        super();
    }
}
