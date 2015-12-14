// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.services.player;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.targetspot.android.sdk.AdListener;
import com.targetspot.android.sdk.SimpleAdListener;
import java.util.List;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Player;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.model.Song;
import my.googlemusic.play.model.User;

// Referenced classes of package my.googlemusic.play.services.player:
//            PlayerManager, PlayerNotification

public class PlayerService extends Service
    implements PlayerManager.Service
{
    public class LocalBinder extends Binder
    {

        final PlayerService this$0;

        public Player getDownloader()
        {
            return mPlayer;
        }

        public Player getPlayer()
        {
            return mPlayer;
        }

        public LocalBinder()
        {
            this$0 = PlayerService.this;
            super();
        }
    }


    public static final int AD_DURATION = 30;
    public static final String TARGET_SPOT_STATION = "MYMIXAND";
    public static boolean adAvailable = false;
    private final IBinder mBinder = new LocalBinder();
    private BroadcastReceiver mBroadcastReceiver;
    private AdListener mListener;
    private PlayerNotification mNotification;
    private PlayerManager mPlayer;
    private Server mServer;
    private int mSpotNumber;
    private boolean mSpotNumberMultiple;

    public PlayerService()
    {
        mSpotNumber = 3;
        mSpotNumberMultiple = true;
        mBroadcastReceiver = new BroadcastReceiver() {

            final PlayerService this$0;

            public void onReceive(Context context, Intent intent)
            {
                context = intent.getStringExtra("EXTRAS");
                if (context != null && context.equals("MUSIC PREPARED") && mPlayer.isRadio())
                {
                    int i = 0;
                    while (i < mPlayer.getPlaylist().size()) 
                    {
                        if (((Song)mPlayer.getPlaylist().get(i)).getId() != mPlayer.getCurrentSong().getId() || i != mSpotNumber)
                        {
                            continue;
                        }
                        if (mSpotNumberMultiple)
                        {
                            mSpotNumberMultiple = false;
                            context = 
// JavaClassFileOutputException: get_constant: invalid tag

            
            {
                this$0 = PlayerService.this;
                super();
            }
        };
        mListener = new SimpleAdListener() {

            final PlayerService this$0;

            public void onAdAvailable()
            {
                Log.d("Service", "Ad available");
            }

            public void onAdRefreshing()
            {
                Log.d("Service", "Ads are being refreshed");
            }

            public void onError(int i, Exception exception)
            {
                Log.e("Service", (new StringBuilder()).append("Error ").append(i).append(": ").append(exception.getMessage()).toString());
            }

            public void onPlaybackStarting()
            {
                Log.d("Service", "Ad playback starting");
                if (mPlayer.isRadio())
                {
                    mPlayer.pause();
                    PlayerService.adAvailable = true;
                }
            }

            public void onPlaybackStopped(int i)
            {
                String s = "";
                i;
                JVM INSTR tableswitch 1 4: default 36
            //                           1 76
            //                           2 82
            //                           3 94
            //                           4 88;
                   goto _L1 _L2 _L3 _L4 _L5
_L1:
                mPlayer.play();
                PlayerService.adAvailable = false;
                Log.d("Service", (new StringBuilder()).append("Ad playback stopped: ").append(s).toString());
                return;
_L2:
                s = "completed";
                continue; /* Loop/switch isn't completed */
_L3:
                s = "cancelled";
                continue; /* Loop/switch isn't completed */
_L5:
                s = "more info request";
                continue; /* Loop/switch isn't completed */
_L4:
                s = "interrupted";
                if (true) goto _L1; else goto _L6
_L6:
            }

            
            {
                this$0 = PlayerService.this;
                super();
            }
        };
    }

    private void finish()
    {
        mPlayer.sendBroadcastTest();
        mPlayer.finish();
        stopSelf();
    }

    private void showAd()
    {
        adAvailable = false;
    }

    public IBinder onBind(Intent intent)
    {
        return mBinder;
    }

    public void onCreate()
    {
        onCreate();
        App app = (App)getApplication();
        if (app != null)
        {
            mPlayer = new PlayerManager(getApplicationContext(), this, app.getServer());
            mNotification = mPlayer.getNotification();
        } else
        {
            stopSelf();
        }
        mServer = ((App)getApplication()).getServer();
        LocalBroadcastManager.getInstance(this).registerReceiver(mBroadcastReceiver, new IntentFilter("MIXTAPEZ BROADCAST"));
    }

    public void onDestroy()
    {
        if (mPlayer != null)
        {
            mPlayer.finish();
        }
        onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        if (adAvailable || intent == null) goto _L2; else goto _L1
_L1:
        intent = intent.getAction();
        if (intent == null || !mNotification.isEnabled()) goto _L2; else goto _L3
_L3:
        mNotification.setEnabled(false);
        if (!intent.equals("my.googlemusic.play.services.player.PlayerNotification.ACTION_PLAY_OR_PAUSE")) goto _L5; else goto _L4
_L4:
        if (!mPlayer.isPlaying()) goto _L7; else goto _L6
_L6:
        mNotification.setEnabled(false);
        mPlayer.pause();
_L2:
        return 2;
_L7:
        if (mPlayer.isPaused())
        {
            mNotification.setEnabled(false);
            mPlayer.play();
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (intent.equals("my.googlemusic.play.services.player.PlayerNotification.ACTION_NEXT"))
        {
            mNotification.setEnabled(false);
            mPlayer.next();
        } else
        if (intent.equals("my.googlemusic.play.services.player.PlayerNotification.ACTION_PREVIOUS"))
        {
            mNotification.setEnabled(false);
            mPlayer.previous();
        } else
        if (intent.equals("my.googlemusic.play.services.player.PlayerNotification.ACTION_STOP"))
        {
            finish();
        }
        if (true) goto _L2; else goto _L8
_L8:
    }

    public void startForeground()
    {
        if (mPlayer.isActive())
        {
            startForeground(mNotification.getId(), mNotification.create(mPlayer.isRadio()));
            mNotification.update(mPlayer.getCurrentSong());
            if (mPlayer.isPlaying())
            {
                mNotification.updateState(PlayerManager.State.PREPARED);
                mNotification.updateState(PlayerManager.State.RESUMED);
            } else
            if (mPlayer.isPaused())
            {
                mNotification.updateState(PlayerManager.State.PREPARED);
                mNotification.updateState(PlayerManager.State.PAUSED);
                return;
            }
        }
    }

    public void stopForeground()
    {
        mNotification.remove();
        stopForeground(true);
    }





/*
    static int access$112(PlayerService playerservice, int i)
    {
        i = playerservice.mSpotNumber + i;
        playerservice.mSpotNumber = i;
        return i;
    }

*/



/*
    static boolean access$202(PlayerService playerservice, boolean flag)
    {
        playerservice.mSpotNumberMultiple = flag;
        return flag;
    }

*/


}
