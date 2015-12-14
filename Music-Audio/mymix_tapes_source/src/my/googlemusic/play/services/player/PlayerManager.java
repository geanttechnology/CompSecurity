// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.services.player;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RemoteControlClient;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.webkit.URLUtil;
import com.squareup.picasso.Target;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Player;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Song;

// Referenced classes of package my.googlemusic.play.services.player:
//            PlayerNotification, PlayerRemoteReceiver

public class PlayerManager
    implements Player, android.media.MediaPlayer.OnPreparedListener, android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnSeekCompleteListener, android.media.MediaPlayer.OnBufferingUpdateListener, android.media.AudioManager.OnAudioFocusChangeListener, android.media.MediaPlayer.OnErrorListener
{
    public static interface Service
    {

        public abstract void startForeground();

        public abstract void stopForeground();
    }

    public static final class State extends Enum
    {

        private static final State $VALUES[];
        public static final State COMPLETED;
        public static final State IDLE;
        public static final State PAUSED;
        public static final State PLAYING;
        public static final State PREPARED;
        public static final State PREPARING;
        public static final State RESUMED;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(my/googlemusic/play/services/player/PlayerManager$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            IDLE = new State("IDLE", 0);
            PREPARING = new State("PREPARING", 1);
            PREPARED = new State("PREPARED", 2);
            PLAYING = new State("PLAYING", 3);
            PAUSED = new State("PAUSED", 4);
            RESUMED = new State("RESUMED", 5);
            COMPLETED = new State("COMPLETED", 6);
            $VALUES = (new State[] {
                IDLE, PREPARING, PREPARED, PLAYING, PAUSED, RESUMED, COMPLETED
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }


    static final boolean $assertionsDisabled;
    private static final int MAIN = 1;
    private static final int NEXT = 2;
    private static final int PREV = 0;
    public static final String RADIO_ACTIVITY_STATUS = "radio_activity_status";
    private AudioManager mAudioManager;
    private Context mContext;
    private int mCurrentTrack;
    private Handler mHandlerBuffering;
    private Handler mHandlerMain;
    private long mIdArtistRadio;
    private int mLastKnownAudioFocusState;
    private MediaPlayer mMediaPlayer[];
    private boolean mNext;
    private PlayerNotification mNotification;
    private List mPlaylist;
    private boolean mRadio;
    private boolean mReady;
    private RemoteControlClient mRemoteControlClient;
    private ComponentName mRemoteControlResponder;
    private Runnable mRunnableBuffering;
    private Runnable mRunnableForeground;
    private Server mServer;
    private Service mService;
    private boolean mShuffle;
    private List mShufflelist;
    private State mState[];
    private Target mTargetBluetooth;

    protected PlayerManager(Context context, Service service, Server server)
    {
        mTargetBluetooth = new _cls3();
        mRunnableForeground = new _cls5();
        mRunnableBuffering = new _cls6();
        mServer = server;
        mContext = context;
        mService = service;
        mCurrentTrack = -1;
        mState = new State[3];
        mMediaPlayer = new MediaPlayer[3];
        mMediaPlayer[0] = instantiateMediaPlayer();
        mMediaPlayer[1] = instantiateMediaPlayer();
        mMediaPlayer[2] = instantiateMediaPlayer();
        mNotification = new PlayerNotification(mContext);
        setState(0, State.IDLE);
        setState(1, State.IDLE);
        setState(2, State.IDLE);
        mNext = true;
        mReady = true;
        mHandlerBuffering = getHandler("buffering");
        mHandlerMain = new Handler();
        mAudioManager = (AudioManager)mContext.getSystemService("audio");
        PlayerRemoteReceiver.setPlayer(this);
        mRemoteControlResponder = new ComponentName(mContext.getPackageName(), my/googlemusic/play/services/player/PlayerRemoteReceiver.getName());
        mAudioManager.registerMediaButtonEventReceiver(mRemoteControlResponder);
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            context = new Intent("android.intent.action.MEDIA_BUTTON");
            context.setComponent(mRemoteControlResponder);
            mRemoteControlClient = new RemoteControlClient(PendingIntent.getBroadcast(mContext.getApplicationContext(), 0, context, 0));
            mAudioManager.registerRemoteControlClient(mRemoteControlClient);
        }
    }

    private void bluetoothNotifyChange()
    {
        mHandlerMain.post(new _cls4());
    }

    private Handler getHandler(String s)
    {
        s = new HandlerThread(s);
        s.start();
        android.os.Looper looper = s.getLooper();
        if (!$assertionsDisabled && looper == null)
        {
            throw new AssertionError();
        } else
        {
            return new Handler(s.getLooper());
        }
    }

    private int getNextTrack()
    {
        if (mCurrentTrack == mPlaylist.size() - 1)
        {
            return 0;
        } else
        {
            return mCurrentTrack + 1;
        }
    }

    private int getPreviousTrack()
    {
        if (mCurrentTrack == 0)
        {
            return mPlaylist.size() - 1;
        } else
        {
            return mCurrentTrack - 1;
        }
    }

    private MediaPlayer instantiateMediaPlayer()
    {
        MediaPlayer mediaplayer = new MediaPlayer();
        mediaplayer.setOnErrorListener(this);
        mediaplayer.setOnPreparedListener(this);
        mediaplayer.setOnCompletionListener(this);
        mediaplayer.setOnSeekCompleteListener(this);
        mediaplayer.setOnBufferingUpdateListener(this);
        return mediaplayer;
    }

    private void prepareSong(int i, Song song)
    {
        try
        {
            setState(i, State.PREPARING);
            mMediaPlayer[i].setAudioStreamType(3);
            mMediaPlayer[i].setDataSource(song.getUrl());
            mMediaPlayer[i].prepareAsync();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Song song)
        {
            Log.e("MEDIA PLAYER", song.getMessage());
        }
    }

    private void reset(int i)
    {
    /* anonymous class not found */
    class _anm7 {}

        _cls7..SwitchMap.my.googlemusic.play.services.player.PlayerManager.State[mState[i].ordinal()];
        JVM INSTR tableswitch 1 4: default 44
    //                   1 70
    //                   2 44
    //                   3 44
    //                   4 71;
           goto _L1 _L2 _L1 _L1 _L3
_L1:
        mMediaPlayer[i].stop();
        mMediaPlayer[i].reset();
_L5:
        setState(i, State.IDLE);
_L2:
        return;
_L3:
        mMediaPlayer[i].release();
        mMediaPlayer[i] = instantiateMediaPlayer();
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void sendBroadcast(String s)
    {
        sendBroadcast(s, null);
    }

    private void sendBroadcast(String s, String s1)
    {
        Intent intent = new Intent("MIXTAPEZ BROADCAST");
        intent.putExtra("EXTRAS", s);
        if (s1 != null)
        {
            intent.putExtra("EXTRAS ADDITIONAL", s1);
        }
        LocalBroadcastManager.getInstance(mContext).sendBroadcast(intent);
    }

    private void setCurrentMediaPlayer(int i)
    {
label0:
        {
            State state;
            State state1;
            MediaPlayer mediaplayer;
            byte byte0;
            if (i == 0)
            {
                byte0 = 2;
            } else
            {
                byte0 = 0;
            }
            state1 = mState[1];
            mediaplayer = mMediaPlayer[1];
            if (state1 != State.PAUSED)
            {
                state = state1;
                if (state1 != State.PLAYING)
                {
                    break label0;
                }
            }
            state = State.PREPARED;
            mediaplayer.pause();
            mediaplayer.seekTo(0);
        }
        mState[1] = mState[i];
        mMediaPlayer[1] = mMediaPlayer[i];
        mState[i] = mState[byte0];
        mMediaPlayer[i] = mMediaPlayer[byte0];
        mState[byte0] = state;
        mMediaPlayer[byte0] = mediaplayer;
        reset(i);
    }

    private void setState(int i, State state)
    {
        mState[i] = state;
        if (i != 1) goto _L2; else goto _L1
_L1:
        if (state != State.PREPARED) goto _L4; else goto _L3
_L3:
        sendBroadcast("MUSIC PREPARED");
        bluetoothNotifyChange();
_L6:
        if (mNotification.isVisible())
        {
            mNotification.updateState(state);
        }
_L2:
        return;
_L4:
        if (state == State.PLAYING)
        {
            sendBroadcast("MUSIC PLAYING");
            mHandlerBuffering.post(mRunnableBuffering);
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                mRemoteControlClient.setPlaybackState(3);
            }
        } else
        if (state == State.PAUSED)
        {
            sendBroadcast("MUSIC PAUSED");
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                mRemoteControlClient.setPlaybackState(2);
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean abandonFocus()
    {
        return 1 == mAudioManager.abandonAudioFocus(this);
    }

    public void finish()
    {
        if (!App.getPreferences().getBoolean("radio_activity_status", false))
        {
            sendBroadcast("MUSIC MEDIA PLAYER FINISHED");
            reset(0);
            reset(1);
            reset(2);
            mPlaylist = null;
            mRadio = false;
        } else
        {
            pause();
        }
        abandonFocus();
        mNotification.remove();
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            mAudioManager.unregisterRemoteControlClient(mRemoteControlClient);
        }
        mAudioManager.unregisterMediaButtonEventReceiver(mRemoteControlResponder);
        mService.stopForeground();
    }

    public int getCurrentPosition()
    {
        return (int)((float)mMediaPlayer[1].getCurrentPosition() / 1000F);
    }

    public Song getCurrentSong()
    {
        if (mShuffle)
        {
            return (Song)mPlaylist.get(((Integer)mShufflelist.get(mCurrentTrack)).intValue());
        } else
        {
            return (Song)mPlaylist.get(mCurrentTrack);
        }
    }

    public int getCurrentTrack()
    {
        if (mShuffle)
        {
            return ((Integer)mShufflelist.get(mCurrentTrack)).intValue();
        } else
        {
            return mCurrentTrack;
        }
    }

    public int getDuration()
    {
        if (mState[1] != State.IDLE && mState[1] != State.PREPARING)
        {
            return (int)((float)mMediaPlayer[1].getDuration() / 1000F);
        } else
        {
            return 0;
        }
    }

    public long getIdArtistRadio()
    {
        return mIdArtistRadio;
    }

    public PlayerNotification getNotification()
    {
        return mNotification;
    }

    public List getPlaylist()
    {
        return mPlaylist;
    }

    public boolean isActive()
    {
        return mPlaylist != null;
    }

    public boolean isPaused()
    {
        return mState[1] == State.PAUSED;
    }

    public boolean isPlaying()
    {
        return mState[1] == State.PLAYING;
    }

    public boolean isPreparing()
    {
        return mState[1] == State.PREPARING;
    }

    public boolean isRadio()
    {
        return mRadio;
    }

    public boolean isShuffle()
    {
        return mShuffle;
    }

    public void next()
    {
        mNext = true;
        mCurrentTrack = getNextTrack();
        setCurrentMediaPlayer(2);
        sendBroadcast("MUSIC CHANGED");
        play();
    }

    public void onAudioFocusChange(int i)
    {
        i;
        JVM INSTR tableswitch -3 1: default 36
    //                   -3 126
    //                   -2 101
    //                   -1 91
    //                   0 36
    //                   1 37;
           goto _L1 _L2 _L3 _L4 _L1 _L5
_L1:
        return;
_L5:
        mLastKnownAudioFocusState;
        JVM INSTR tableswitch -3 -2: default 64
    //                   -3 70
    //                   -2 84;
           goto _L6 _L7 _L8
_L6:
        mLastKnownAudioFocusState = 1;
        return;
_L7:
        mMediaPlayer[1].setVolume(1.0F, 1.0F);
          goto _L6
_L8:
        play();
          goto _L6
_L4:
        pause();
        mLastKnownAudioFocusState = -1;
        return;
_L3:
        if (isPlaying())
        {
            i = -2;
        } else
        {
            i = 0;
        }
        mLastKnownAudioFocusState = i;
        pause();
        return;
_L2:
        mMediaPlayer[1].setVolume(0.1F, 0.1F);
        mLastKnownAudioFocusState = -3;
        return;
    }

    public void onBufferingUpdate(MediaPlayer mediaplayer, int i)
    {
        if (mediaplayer == mMediaPlayer[1])
        {
            sendBroadcast("MUSIC BUFFERING", String.valueOf((int)(((float)i / 100F) * (float)getDuration())));
        }
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        if (isActive())
        {
            next();
        }
    }

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        return false;
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        if (mediaplayer != mMediaPlayer[0]) goto _L2; else goto _L1
_L1:
        setState(0, State.PREPARED);
_L4:
        return;
_L2:
        if (mediaplayer != mMediaPlayer[1])
        {
            break; /* Loop/switch isn't completed */
        }
        setState(1, State.PREPARED);
        mServer.addHit(getCurrentSong().getId(), getCurrentSong().getAlbum().getId());
        mediaplayer.start();
        setState(1, State.PLAYING);
        if (mState[2] == State.IDLE)
        {
            if (mShuffle)
            {
                mediaplayer = (Song)mPlaylist.get(((Integer)mShufflelist.get(getNextTrack())).intValue());
            } else
            {
                mediaplayer = (Song)mPlaylist.get(getNextTrack());
            }
            prepareSong(2, mediaplayer);
            return;
        }
        if (mState[0] == State.IDLE)
        {
            if (mShuffle)
            {
                mediaplayer = (Song)mPlaylist.get(((Integer)mShufflelist.get(getPreviousTrack())).intValue());
            } else
            {
                mediaplayer = (Song)mPlaylist.get(getPreviousTrack());
            }
            prepareSong(0, mediaplayer);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        setState(2, State.PREPARED);
        if (mState[0] == State.IDLE)
        {
            if (mShuffle)
            {
                mediaplayer = (Song)mPlaylist.get(((Integer)mShufflelist.get(getPreviousTrack())).intValue());
            } else
            {
                mediaplayer = (Song)mPlaylist.get(getPreviousTrack());
            }
            prepareSong(0, mediaplayer);
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public void onSeekComplete(MediaPlayer mediaplayer)
    {
    }

    public void pause()
    {
        if (mMediaPlayer[1].isPlaying())
        {
            mMediaPlayer[1].pause();
            setState(1, State.PAUSED);
        }
    }

    public void play()
    {
        if (!requestFocus())
        {
            return;
        }
        if (mNotification.isVisible())
        {
            mHandlerMain.post(new _cls1());
        }
        switch (_cls7..SwitchMap.my.googlemusic.play.services.player.PlayerManager.State[mState[1].ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            prepareSong(1, getCurrentSong());
            return;

        case 2: // '\002'
            setState(1, State.PREPARED);
            mMediaPlayer[1].start();
            setState(1, State.PLAYING);
            return;

        case 3: // '\003'
            mMediaPlayer[1].start();
            break;
        }
        setState(1, State.RESUMED);
        setState(1, State.PLAYING);
    }

    public void play(int i)
    {
        if (mCurrentTrack == -1 || mShuffle) goto _L2; else goto _L1
_L1:
        if (i != getPreviousTrack()) goto _L4; else goto _L3
_L3:
        previous();
_L6:
        return;
_L4:
        if (i == getNextTrack())
        {
            next();
            return;
        }
_L2:
        if (mReady)
        {
            mReady = false;
            (new Thread(new _cls2(i))).start();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void previous()
    {
        if (!isRadio())
        {
            mNext = false;
            mCurrentTrack = getPreviousTrack();
            setCurrentMediaPlayer(0);
            sendBroadcast("MUSIC CHANGED");
            play();
        }
    }

    public boolean requestFocus()
    {
        return 1 == mAudioManager.requestAudioFocus(this, 3, 1);
    }

    public void seekTo(int i)
    {
        mMediaPlayer[1].seekTo(i * 1000);
    }

    public void sendBroadcastTest()
    {
        sendBroadcast("MUSIC MEDIA PLAYER FINISHED");
    }

    public void setNotificationVisible(boolean flag)
    {
        if (flag)
        {
            mHandlerMain.postDelayed(mRunnableForeground, 1000L);
            return;
        } else
        {
            mHandlerMain.removeCallbacks(mRunnableForeground);
            mService.stopForeground();
            return;
        }
    }

    public void setPlayList(List list)
    {
        setPlayList(list, false, false, 0L);
    }

    public void setPlayList(List list, boolean flag, boolean flag1, long l)
    {
label0:
        {
            if (mPlaylist == null || mPlaylist.size() != list.size() || !((Song)mPlaylist.get(0)).getName().equals(((Song)list.get(0)).getName()))
            {
                mPlaylist = new ArrayList();
                list = list.iterator();
                do
                {
                    if (!list.hasNext())
                    {
                        break;
                    }
                    Song song = (Song)list.next();
                    if (song.isDownloaded() || URLUtil.isValidUrl(song.getUrl()))
                    {
                        mPlaylist.add(song);
                    }
                } while (true);
                mIdArtistRadio = l;
                mRadio = flag;
                mReady = true;
                int i;
                if (flag)
                {
                    i = 0;
                } else
                {
                    i = -1;
                }
                mCurrentTrack = i;
                reset(0);
                reset(1);
                reset(2);
                mShufflelist = new ArrayList(mPlaylist.size());
                for (i = 0; i < mPlaylist.size(); i++)
                {
                    mShufflelist.add(i, Integer.valueOf(i));
                }

                Collections.shuffle(mShufflelist, new Random(System.nanoTime()));
                if (android.os.Build.VERSION.SDK_INT >= 14)
                {
                    if (!mRadio)
                    {
                        break label0;
                    }
                    mRemoteControlClient.setTransportControlFlags(148);
                }
            }
            return;
        }
        mRemoteControlClient.setTransportControlFlags(149);
    }

    public void setShuffle(boolean flag)
    {
        mShuffle = flag;
        reset(2);
        reset(0);
    }

    static 
    {
        boolean flag;
        if (!my/googlemusic/play/services/player/PlayerManager.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }











/*
    static int access$202(PlayerManager playermanager, int i)
    {
        playermanager.mCurrentTrack = i;
        return i;
    }

*/



/*
    static boolean access$402(PlayerManager playermanager, boolean flag)
    {
        playermanager.mNext = flag;
        return flag;
    }

*/






/*
    static boolean access$902(PlayerManager playermanager, boolean flag)
    {
        playermanager.mReady = flag;
        return flag;
    }

*/

    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
