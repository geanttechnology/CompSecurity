// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.util;

import android.app.Activity;
import android.content.Context;
import android.widget.FrameLayout;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.playerplatform.drm.java.service.LicenseService;
import com.comcast.playerplatform.primetime.android.disney.DisneyPlayer;
import com.comcast.playerplatform.primetime.android.espn.EspnPlayer;
import com.comcast.playerplatform.primetime.android.player.Player;
import com.comcast.playerplatform.primetime.android.player.PlayerSettings;
import com.comcast.playerplatform.primetime.android.primetime.PrimeTimePlayer;
import com.comcast.playerplatform.util.android.ConfigurationManager;

public class PlayerManager
{

    private Activity activity;
    private Context applicationContext;
    private Player currentPlayer;
    private DisneyPlayer disneyPlayer;
    private EspnPlayer espnPlayer;
    private HttpClient httpClient;
    private LicenseService licenseService;
    private FrameLayout parentView;
    private boolean playerChanged;
    private final PlayerSettings playerSettings;
    private PrimeTimePlayer primeTimePlayer;

    public PlayerManager(PlayerSettings playersettings, Context context, Activity activity1, HttpClient httpclient, LicenseService licenseservice, FrameLayout framelayout)
    {
        playerSettings = playersettings;
        applicationContext = context;
        activity = activity1;
        httpClient = httpclient;
        licenseService = licenseservice;
        parentView = framelayout;
    }

    private void resetPreviousPlayer()
    {
        if (currentPlayer instanceof PrimeTimePlayer)
        {
            primeTimePlayer.destroy();
            primeTimePlayer = null;
        } else
        {
            if (currentPlayer instanceof EspnPlayer)
            {
                espnPlayer.destroy();
                espnPlayer = null;
                return;
            }
            if (currentPlayer instanceof DisneyPlayer)
            {
                disneyPlayer.destroy();
                disneyPlayer = null;
                return;
            }
        }
    }

    private void setCurrentPlayer(Player player)
    {
        boolean flag;
        if (player != currentPlayer)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        playerChanged = flag;
        currentPlayer = player;
    }

    public boolean didPlayerChange()
    {
        return playerChanged;
    }

    public Player getDisneyPlayer()
    {
        if (currentPlayer != null && !(currentPlayer instanceof DisneyPlayer))
        {
            resetPreviousPlayer();
        }
        if (disneyPlayer == null)
        {
            disneyPlayer = new DisneyPlayer(applicationContext, activity, playerSettings);
            parentView.removeAllViews();
            parentView.addView(disneyPlayer.getView());
        }
        setCurrentPlayer(disneyPlayer);
        return disneyPlayer;
    }

    public Player getEspnPlayer()
    {
        if (!ConfigurationManager.getInstance().isEspnReady())
        {
            ConfigurationManager.getInstance().initializeESPN(applicationContext, false);
        }
        if (currentPlayer != null && !(currentPlayer instanceof EspnPlayer))
        {
            resetPreviousPlayer();
        }
        if (espnPlayer == null)
        {
            espnPlayer = new EspnPlayer(applicationContext, httpClient, playerSettings);
            parentView.removeAllViews();
            parentView.addView(espnPlayer.getView());
        }
        setCurrentPlayer(espnPlayer);
        return espnPlayer;
    }

    public Player getPlayer(com.comcast.playerplatform.primetime.android.asset.Asset.AssetType assettype)
    {
        this;
        JVM INSTR monitorenter ;
        static class _cls1
        {

            static final int $SwitchMap$com$comcast$playerplatform$primetime$android$asset$Asset$AssetType[];

            static 
            {
                $SwitchMap$com$comcast$playerplatform$primetime$android$asset$Asset$AssetType = new int[com.comcast.playerplatform.primetime.android.asset.Asset.AssetType.values().length];
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$asset$Asset$AssetType[com.comcast.playerplatform.primetime.android.asset.Asset.AssetType.ESPN.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$asset$Asset$AssetType[com.comcast.playerplatform.primetime.android.asset.Asset.AssetType.DISNEY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.comcast.playerplatform.primetime.android.asset.Asset.AssetType[assettype.ordinal()];
        JVM INSTR tableswitch 1 2: default 62
    //                   1 41
    //                   2 49;
           goto _L1 _L2 _L3
_L1:
        assettype = getPrimetimePlayer();
_L5:
        this;
        JVM INSTR monitorexit ;
        return assettype;
_L2:
        assettype = getEspnPlayer();
        continue; /* Loop/switch isn't completed */
_L3:
        assettype = getDisneyPlayer();
        if (true) goto _L5; else goto _L4
_L4:
        assettype;
        throw assettype;
    }

    public Player getPrimetimePlayer()
    {
        if (currentPlayer != null && !(currentPlayer instanceof PrimeTimePlayer))
        {
            resetPreviousPlayer();
        }
        if (primeTimePlayer == null)
        {
            primeTimePlayer = new PrimeTimePlayer(applicationContext, httpClient, playerSettings, licenseService);
            parentView.removeAllViews();
            parentView.addView(primeTimePlayer.getView());
        }
        setCurrentPlayer(primeTimePlayer);
        return primeTimePlayer;
    }
}
