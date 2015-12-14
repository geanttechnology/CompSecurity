// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
import java.io.IOException;

// Referenced classes of package com.livemixtapes:
//            MusicFocusable, console, AudioFocusHelper, NowPlayingActivity, 
//            MusicRetriever, PrepareMusicRetrieverTask, MusicIntentReceiver, App, 
//            BitmapDownloader, MediaButtonHelper, RemoteControlClientCompat, RemoteControlHelper

public class LMTService extends Service
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnPreparedListener, android.media.MediaPlayer.OnErrorListener, MusicFocusable, PrepareMusicRetrieverTask.MusicRetrieverPreparedListener
{
    static final class AudioFocus extends Enum
    {

        private static final AudioFocus ENUM$VALUES[];
        public static final AudioFocus Focused;
        public static final AudioFocus NoFocusCanDuck;
        public static final AudioFocus NoFocusNoDuck;

        public static AudioFocus valueOf(String s)
        {
            return (AudioFocus)Enum.valueOf(com/livemixtapes/LMTService$AudioFocus, s);
        }

        public static AudioFocus[] values()
        {
            AudioFocus aaudiofocus[] = ENUM$VALUES;
            int i = aaudiofocus.length;
            AudioFocus aaudiofocus1[] = new AudioFocus[i];
            System.arraycopy(aaudiofocus, 0, aaudiofocus1, 0, i);
            return aaudiofocus1;
        }

        static 
        {
            NoFocusNoDuck = new AudioFocus("NoFocusNoDuck", 0);
            NoFocusCanDuck = new AudioFocus("NoFocusCanDuck", 1);
            Focused = new AudioFocus("Focused", 2);
            ENUM$VALUES = (new AudioFocus[] {
                NoFocusNoDuck, NoFocusCanDuck, Focused
            });
        }

        private AudioFocus(String s, int i)
        {
            super(s, i);
        }
    }

    static final class PauseReason extends Enum
    {

        private static final PauseReason ENUM$VALUES[];
        public static final PauseReason FocusLoss;
        public static final PauseReason UserRequest;

        public static PauseReason valueOf(String s)
        {
            return (PauseReason)Enum.valueOf(com/livemixtapes/LMTService$PauseReason, s);
        }

        public static PauseReason[] values()
        {
            PauseReason apausereason[] = ENUM$VALUES;
            int i = apausereason.length;
            PauseReason apausereason1[] = new PauseReason[i];
            System.arraycopy(apausereason, 0, apausereason1, 0, i);
            return apausereason1;
        }

        static 
        {
            UserRequest = new PauseReason("UserRequest", 0);
            FocusLoss = new PauseReason("FocusLoss", 1);
            ENUM$VALUES = (new PauseReason[] {
                UserRequest, FocusLoss
            });
        }

        private PauseReason(String s, int i)
        {
            super(s, i);
        }
    }

    static final class State extends Enum
    {

        private static final State ENUM$VALUES[];
        public static final State Paused;
        public static final State Playing;
        public static final State Preparing;
        public static final State Retrieving;
        public static final State Stopped;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/livemixtapes/LMTService$State, s);
        }

        public static State[] values()
        {
            State astate[] = ENUM$VALUES;
            int i = astate.length;
            State astate1[] = new State[i];
            System.arraycopy(astate, 0, astate1, 0, i);
            return astate1;
        }

        static 
        {
            Retrieving = new State("Retrieving", 0);
            Stopped = new State("Stopped", 1);
            Preparing = new State("Preparing", 2);
            Playing = new State("Playing", 3);
            Paused = new State("Paused", 4);
            ENUM$VALUES = (new State[] {
                Retrieving, Stopped, Preparing, Playing, Paused
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String ACTION_IMAGE = "com.livemixtapes.action.IMAGE";
    public static final String ACTION_PAUSE = "com.livemixtapes.action.PAUSE";
    public static final String ACTION_PLAY = "com.livemixtapes.action.PLAY";
    public static final String ACTION_REWIND = "com.livemixtapes.action.REWIND";
    public static final String ACTION_SKIP = "com.livemixtapes.action.SKIP";
    public static final String ACTION_STOP = "com.livemixtapes.action.STOP";
    public static final String ACTION_TOGGLE_PLAYBACK = "com.livemixtapes.action.TOGGLE_PLAYBACK";
    public static final String ACTION_URL = "com.livemixtapes.action.URL";
    public static final float DUCK_VOLUME = 0.1F;
    static final String TAG = "livemixtapesPlayer";
    public static Boolean amPlaying = Boolean.valueOf(false);
    public static MediaPlayer mPlayer = null;
    public static MediaSession mediaSession;
    public static String temp_title;
    final int NOTIFICATION_ID = 1;
    AudioFocus mAudioFocus;
    AudioFocusHelper mAudioFocusHelper;
    AudioManager mAudioManager;
    Bitmap mDummyAlbumArt;
    boolean mIsStreaming;
    ComponentName mMediaButtonReceiverComponent;
    Notification mNotification;
    NotificationManager mNotificationManager;
    PauseReason mPauseReason;
    RemoteControlClientCompat mRemoteControlClientCompat;
    MusicRetriever mRetriever;
    String mSongTitle;
    boolean mStartPlayingAfterRetrieve;
    State mState;
    Uri mWhatToPlayAfterRetrieve;
    android.net.wifi.WifiManager.WifiLock mWifiLock;

    public LMTService()
    {
        mAudioFocusHelper = null;
        mState = State.Retrieving;
        mStartPlayingAfterRetrieve = false;
        mWhatToPlayAfterRetrieve = null;
        mPauseReason = PauseReason.UserRequest;
        mAudioFocus = AudioFocus.NoFocusNoDuck;
        mSongTitle = "";
        mIsStreaming = false;
        mNotification = null;
    }

    private PendingIntent retreivePlaybackAction(int i)
    {
        console.log(new Object[] {
            "PENDING INTENT CALLED"
        });
        console.log(new Object[] {
            (new StringBuilder("AMPLAYING IS ")).append(amPlaying).toString()
        });
        ComponentName componentname = new ComponentName(this, com/livemixtapes/LMTService);
        Intent intent3;
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            Log.v("herp", "PLAY AND PAUSE");
            console.log(new Object[] {
                "PLAY AN DPAUSE "
            });
            console.log(new Object[] {
                "ACTION PLAY"
            });
            Intent intent = new Intent("com.livemixtapes.action.PLAY");
            console.log(new Object[] {
                (new StringBuilder("AMPLAYING IS ")).append(amPlaying).toString()
            });
            intent.setComponent(componentname);
            return PendingIntent.getService(this, 1, intent, 0);

        case 2: // '\002'
            Intent intent1 = new Intent("com.livemixtapes.action.SKIP");
            intent1.setComponent(componentname);
            return PendingIntent.getService(this, 2, intent1, 0);

        case 3: // '\003'
            Intent intent2 = new Intent("com.livemixtapes.action.REWIND");
            intent2.setComponent(componentname);
            return PendingIntent.getService(this, 3, intent2, 0);

        case 4: // '\004'
            intent3 = new Intent("com.livemixtapes.action.STOP");
            break;
        }
        intent3.setComponent(componentname);
        return PendingIntent.getService(this, 4, intent3, 0);
    }

    void configAndStartMediaPlayer()
    {
        if (mAudioFocus == AudioFocus.NoFocusNoDuck)
        {
            if (mPlayer.isPlaying())
            {
                mPlayer.pause();
            }
        } else
        {
            if (mAudioFocus == AudioFocus.NoFocusCanDuck)
            {
                mPlayer.setVolume(0.1F, 0.1F);
            } else
            {
                mPlayer.setVolume(1.0F, 1.0F);
            }
            if (!mPlayer.isPlaying())
            {
                mPlayer.start();
                return;
            }
        }
    }

    void createMediaPlayerIfNeeded()
    {
        if (mPlayer == null)
        {
            mPlayer = new MediaPlayer();
            mPlayer.setWakeMode(getApplicationContext(), 1);
            mPlayer.setOnPreparedListener(this);
            mPlayer.setOnCompletionListener(this);
            mPlayer.setOnErrorListener(this);
            return;
        } else
        {
            mPlayer.reset();
            return;
        }
    }

    void giveUpAudioFocus()
    {
        if (mAudioFocus == AudioFocus.Focused && mAudioFocusHelper != null && mAudioFocusHelper.abandonFocus())
        {
            mAudioFocus = AudioFocus.NoFocusNoDuck;
        }
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        NowPlayingActivity.nextTrack();
    }

    public void onCreate()
    {
        Log.i("livemixtapesPlayer", "debug: Creating service");
        mWifiLock = ((WifiManager)getSystemService("wifi")).createWifiLock(1, "mylock");
        mNotificationManager = (NotificationManager)getSystemService("notification");
        mAudioManager = (AudioManager)getSystemService("audio");
        mRetriever = new MusicRetriever(getContentResolver());
        (new PrepareMusicRetrieverTask(mRetriever, this)).execute(new Void[0]);
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            mAudioFocusHelper = new AudioFocusHelper(getApplicationContext(), this);
        } else
        {
            mAudioFocus = AudioFocus.Focused;
        }
        mDummyAlbumArt = BitmapFactory.decodeResource(getResources(), 0x7f0200a4);
        mMediaButtonReceiverComponent = new ComponentName(this, com/livemixtapes/MusicIntentReceiver);
    }

    public void onDestroy()
    {
        ((NotificationManager)App.context.getSystemService("notification")).cancelAll();
        mState = State.Stopped;
        relaxResources(true);
        giveUpAudioFocus();
    }

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        Toast.makeText(getApplicationContext(), "Media player error! Resetting.", 0).show();
        Log.e("livemixtapesPlayer", (new StringBuilder("Error: what=")).append(String.valueOf(i)).append(", extra=").append(String.valueOf(j)).toString());
        return true;
    }

    public void onGainedAudioFocus()
    {
        Toast.makeText(getApplicationContext(), "gained audio focus.", 0).show();
        mAudioFocus = AudioFocus.Focused;
        if (mState == State.Playing)
        {
            configAndStartMediaPlayer();
        }
    }

    public void onLostAudioFocus(boolean flag)
    {
        Context context = getApplicationContext();
        StringBuilder stringbuilder = new StringBuilder("lost audio focus.");
        Object obj;
        if (flag)
        {
            obj = "can duck";
        } else
        {
            obj = "no duck";
        }
        Toast.makeText(context, stringbuilder.append(((String) (obj))).toString(), 0).show();
        if (flag)
        {
            obj = AudioFocus.NoFocusCanDuck;
        } else
        {
            obj = AudioFocus.NoFocusNoDuck;
        }
        mAudioFocus = ((AudioFocus) (obj));
        if (mPlayer != null && mPlayer.isPlaying())
        {
            configAndStartMediaPlayer();
        }
    }

    public void onMusicRetrieverPrepared()
    {
        mState = State.Stopped;
        if (mStartPlayingAfterRetrieve)
        {
            tryToGetAudioFocus();
            String s;
            if (mWhatToPlayAfterRetrieve == null)
            {
                s = null;
            } else
            {
                s = mWhatToPlayAfterRetrieve.toString();
            }
            playNextSong(s);
        }
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        mState = State.Playing;
        updateNotification((new StringBuilder(String.valueOf(mSongTitle))).append(" (playing)").toString());
        configAndStartMediaPlayer();
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        String s;
        s = intent.getAction();
        console.log(new Object[] {
            (new StringBuilder("ACTION: ")).append(s).toString()
        });
        if (!s.equals("com.livemixtapes.action.TOGGLE_PLAYBACK")) goto _L2; else goto _L1
_L1:
        processTogglePlaybackRequest();
_L4:
        return 2;
_L2:
        if (s.equals("com.livemixtapes.action.PLAY"))
        {
            processPlayRequest();
        } else
        if (s.equals("com.livemixtapes.action.PAUSE"))
        {
            processPauseRequest();
        } else
        if (s.equals("com.livemixtapes.action.SKIP"))
        {
            processSkipRequest();
        } else
        if (s.equals("com.livemixtapes.action.STOP"))
        {
            processStopRequest();
        } else
        if (s.equals("com.livemixtapes.action.REWIND"))
        {
            processRewindRequest();
        } else
        if (s.equals("com.livemixtapes.action.URL"))
        {
            processAddRequest(intent);
        } else
        if (s.equals("com.livemixtapes.action.IMAGE"))
        {
            console.log(new Object[] {
                "PROCESSING IMAGE DAWG"
            });
            processImageRequest();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    void playNextSong(String s)
    {
        mState = State.Stopped;
        relaxResources(false);
        if (s == null) goto _L2; else goto _L1
_L1:
        createMediaPlayerIfNeeded();
        mPlayer.setAudioStreamType(3);
        mPlayer.setDataSource(s);
        Object obj;
        int i;
        boolean flag;
        if (!s.startsWith("http:") && !s.startsWith("https:"))
        {
            flag = false;
        } else
        {
            flag = true;
        }
        mIsStreaming = flag;
        s = new MusicRetriever.Item(0L, null, s, null, 0L);
_L11:
        mSongTitle = "";
        Exception exception;
        Bitmap bitmap;
        Exception exception2;
        try
        {
            mSongTitle = " ";
        }
        catch (Exception exception1) { }
        mState = State.Preparing;
        setUpAsForeground((new StringBuilder(String.valueOf(mSongTitle))).append(" (loading)").toString());
        i = android.os.Build.VERSION.SDK_INT;
        if (i < 21) goto _L4; else goto _L3
_L3:
        s = null;
        obj = (Bitmap)(new BitmapDownloader()).execute(new String[] {
            NowPlayingActivity.thumbURL
        }).get();
        s = ((String) (obj));
_L12:
        if (mediaSession != null)
        {
            mediaSession.release();
        }
        mediaSession = new MediaSession(this, "LMT");
        mediaSession.setMetadata((new android.media.MediaMetadata.Builder()).putBitmap("android.media.metadata.ALBUM_ART", s).putString("android.media.metadata.ARTIST", NowPlayingActivity.artist).putString("android.media.metadata.ALBUM", NowPlayingActivity.tape).putString("android.media.metadata.TITLE", NowPlayingActivity.title).build());
        mediaSession.setActive(true);
        mediaSession.setCallback(new android.media.session.MediaSession.Callback() {

            final LMTService this$0;

            
            {
                this$0 = LMTService.this;
                super();
            }
        });
        mediaSession.setFlags(2);
        obj = PendingIntent.getActivity(this, 0, new Intent(this, com/livemixtapes/NowPlayingActivity), 0);
        if (!NowPlayingActivity.artist.equals("")) goto _L6; else goto _L5
_L5:
        temp_title = NowPlayingActivity.title;
_L13:
        s = (new android.app.Notification.Builder(this)).setAutoCancel(false).setOngoing(true).setShowWhen(false).setStyle((new android.app.Notification.MediaStyle()).setMediaSession(mediaSession.getSessionToken()).setShowActionsInCompactView(new int[] {
            0, 1, 2
        })).setColor(0xff00457f).setLargeIcon(s).setSmallIcon(0x7f02005b).setContentText("").setContentInfo("").setContentTitle(temp_title).setContentIntent(((PendingIntent) (obj))).addAction(0x7f0200a8, "prev", retreivePlaybackAction(3)).addAction(0x7f0200a6, "pause", retreivePlaybackAction(1)).addAction(0x7f0200a5, "next", retreivePlaybackAction(2)).addAction(0x7f0200a0, "close", retreivePlaybackAction(4)).build();
        mediaSession.getController().getTransportControls();
        amPlaying = Boolean.valueOf(true);
        ((NotificationManager)getSystemService("notification")).notify(1, s);
_L14:
        mPlayer.prepareAsync();
        if (!mIsStreaming) goto _L8; else goto _L7
_L7:
        mWifiLock.acquire();
_L18:
        return;
_L2:
        mIsStreaming = false;
        s = mRetriever.getRandomItem();
        if (s != null) goto _L10; else goto _L9
_L9:
        try
        {
            Toast.makeText(this, "No available music to play. Place some music on your external storage device (e.g. your SD card) and try again.", 1).show();
            processStopRequest(true);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
_L19:
        Log.e("MusicService", (new StringBuilder("IOException playing next song: ")).append(s.getMessage()).toString());
        s.printStackTrace();
        return;
_L10:
        createMediaPlayerIfNeeded();
        mPlayer.setAudioStreamType(3);
        mPlayer.setDataSource(getApplicationContext(), s.getURI());
          goto _L11
        exception;
        console.log(new Object[] {
            "COULD NOT GRAB BITMAP"
        });
          goto _L12
_L6:
        temp_title = (new StringBuilder(String.valueOf(NowPlayingActivity.artist))).append(" - ").append(NowPlayingActivity.title).toString();
          goto _L13
_L4:
        MediaButtonHelper.registerMediaButtonEventReceiverCompat(mAudioManager, mMediaButtonReceiverComponent);
        if (mRemoteControlClientCompat == null)
        {
            exception = new Intent("android.intent.action.MEDIA_BUTTON");
            exception.setComponent(mMediaButtonReceiverComponent);
            mRemoteControlClientCompat = new RemoteControlClientCompat(PendingIntent.getBroadcast(this, 0, exception, 0));
            RemoteControlHelper.registerRemoteControlClient(mAudioManager, mRemoteControlClientCompat);
        }
        mRemoteControlClientCompat.setPlaybackState(3);
        mRemoteControlClientCompat.setTransportControlFlags(181);
        exception = null;
        bitmap = (Bitmap)(new BitmapDownloader()).execute(new String[] {
            NowPlayingActivity.thumbURL
        }).get();
        exception = bitmap;
_L15:
        console.log(new Object[] {
            (new StringBuilder("GRABBING THUMB: ")).append(NowPlayingActivity.thumbURL).toString()
        });
        if (!NowPlayingActivity.artist.equals(""))
        {
            break MISSING_BLOCK_LABEL_901;
        }
        temp_title = NowPlayingActivity.title;
_L16:
        mRemoteControlClientCompat.editMetadata(true).putString(2, NowPlayingActivity.artist).putString(13, NowPlayingActivity.artist).putString(1, NowPlayingActivity.tape).putLong(9, s.getDuration()).putString(7, NowPlayingActivity.title).putBitmap(100, exception).apply();
          goto _L14
        exception2;
        console.log(new Object[] {
            "COULD NOT GRAB BITMAP"
        });
          goto _L15
        temp_title = (new StringBuilder(String.valueOf(NowPlayingActivity.artist))).append(" - ").append(NowPlayingActivity.title).toString();
          goto _L16
_L8:
        if (!mWifiLock.isHeld()) goto _L18; else goto _L17
_L17:
        mWifiLock.release();
        return;
        s;
          goto _L19
    }

    void processAddRequest(Intent intent)
    {
        console.log(new Object[] {
            "ADDING"
        });
        console.log(new Object[] {
            (new StringBuilder("HERP: ")).append(intent.getData().toString()).toString()
        });
        if (mState == State.Retrieving)
        {
            console.log(new Object[] {
                "HUMRETREIVING"
            });
            mWhatToPlayAfterRetrieve = intent.getData();
            mStartPlayingAfterRetrieve = true;
        } else
        if (mState == State.Playing || mState == State.Paused || mState == State.Stopped)
        {
            console.log(new Object[] {
                "HUMSTARTING"
            });
            Log.i("livemixtapesPlayer", (new StringBuilder("Playing from URL/path: ")).append(intent.getData().toString()).toString());
            tryToGetAudioFocus();
            playNextSong(intent.getData().toString());
            return;
        }
    }

    void processImageRequest()
    {
    }

    void processPauseRequest()
    {
        if (mState == State.Retrieving)
        {
            mStartPlayingAfterRetrieve = false;
        } else
        {
            if (mState == State.Playing)
            {
                mState = State.Paused;
                mPlayer.pause();
                relaxResources(false);
            }
            if (mRemoteControlClientCompat != null)
            {
                mRemoteControlClientCompat.setPlaybackState(2);
                return;
            }
        }
    }

    void processPlayRequest()
    {
        if (mPlayer.isPlaying())
        {
            processPauseRequest();
            if (android.os.Build.VERSION.SDK_INT >= 21)
            {
                setPauseNotify();
            }
        } else
        {
            if (mState == State.Retrieving)
            {
                mWhatToPlayAfterRetrieve = null;
                mStartPlayingAfterRetrieve = true;
                return;
            }
            tryToGetAudioFocus();
            if (mState == State.Stopped)
            {
                playNextSong(null);
            } else
            if (mState == State.Paused)
            {
                mState = State.Playing;
                setUpAsForeground((new StringBuilder(String.valueOf(mSongTitle))).append(" (playing)").toString());
                configAndStartMediaPlayer();
            }
            if (mRemoteControlClientCompat != null)
            {
                mRemoteControlClientCompat.setPlaybackState(3);
            }
            if (android.os.Build.VERSION.SDK_INT >= 21)
            {
                setPlayNotify();
                return;
            }
        }
    }

    void processRewindRequest()
    {
        if (mState == State.Playing || mState == State.Paused)
        {
            NowPlayingActivity.previousTrack();
        }
    }

    void processSkipRequest()
    {
        console.log(new Object[] {
            (new StringBuilder("PRESKIP REQUEST")).append(mState).toString()
        });
        if (mState == State.Playing || mState == State.Paused)
        {
            console.log(new Object[] {
                "SKIP REQUEST"
            });
            tryToGetAudioFocus();
            NowPlayingActivity.nextTrack();
        }
    }

    void processStopRequest()
    {
        processPauseRequest();
        setCloseNotify();
    }

    void processStopRequest(boolean flag)
    {
        if (mState == State.Playing || mState == State.Paused || flag)
        {
            mState = State.Stopped;
            relaxResources(true);
            giveUpAudioFocus();
            if (mRemoteControlClientCompat != null)
            {
                mRemoteControlClientCompat.setPlaybackState(1);
            }
            stopSelf();
        }
        setCloseNotify();
    }

    void processTogglePlaybackRequest()
    {
        if (mState == State.Paused || mState == State.Stopped)
        {
            processPlayRequest();
            return;
        } else
        {
            processPauseRequest();
            return;
        }
    }

    void relaxResources(boolean flag)
    {
        stopForeground(true);
        if (flag && mPlayer != null)
        {
            mPlayer.reset();
            mPlayer.release();
            mPlayer = null;
        }
        if (mWifiLock.isHeld())
        {
            mWifiLock.release();
        }
    }

    void setCloseNotify()
    {
        amPlaying = Boolean.valueOf(true);
        ((NotificationManager)getSystemService("notification")).cancelAll();
    }

    void setPauseNotify()
    {
        Object obj = null;
        Bitmap bitmap = (Bitmap)(new BitmapDownloader()).execute(new String[] {
            NowPlayingActivity.thumbURL
        }).get();
        obj = bitmap;
_L1:
        PendingIntent pendingintent = PendingIntent.getActivity(this, 0, new Intent(this, com/livemixtapes/NowPlayingActivity), 0);
        Exception exception;
        if (NowPlayingActivity.artist.equals(""))
        {
            temp_title = NowPlayingActivity.title;
        } else
        {
            temp_title = (new StringBuilder(String.valueOf(NowPlayingActivity.artist))).append(" - ").append(NowPlayingActivity.title).toString();
        }
        obj = (new android.app.Notification.Builder(this)).setAutoCancel(false).setOngoing(true).setShowWhen(false).setStyle((new android.app.Notification.MediaStyle()).setMediaSession(mediaSession.getSessionToken()).setShowActionsInCompactView(new int[] {
            0, 1, 2
        })).setColor(0xff00457f).setLargeIcon(((Bitmap) (obj))).setSmallIcon(0x7f02005b).setContentText("").setContentInfo("").setContentTitle(temp_title).setContentIntent(pendingintent).addAction(0x7f0200a8, "prev", retreivePlaybackAction(3)).addAction(0x7f0200a7, "play", retreivePlaybackAction(1)).addAction(0x7f0200a5, "next", retreivePlaybackAction(2)).addAction(0x7f0200a0, "close", retreivePlaybackAction(4)).build();
        mediaSession.getController().getTransportControls();
        amPlaying = Boolean.valueOf(true);
        ((NotificationManager)getSystemService("notification")).notify(1, ((Notification) (obj)));
        return;
        exception;
        console.log(new Object[] {
            "COULD NOT GRAB BITMAP"
        });
          goto _L1
    }

    void setPlayNotify()
    {
        Object obj = null;
        Bitmap bitmap = (Bitmap)(new BitmapDownloader()).execute(new String[] {
            NowPlayingActivity.thumbURL
        }).get();
        obj = bitmap;
_L1:
        PendingIntent pendingintent = PendingIntent.getActivity(this, 0, new Intent(this, com/livemixtapes/NowPlayingActivity), 0);
        Exception exception;
        if (NowPlayingActivity.artist.equals(""))
        {
            temp_title = NowPlayingActivity.title;
        } else
        {
            temp_title = (new StringBuilder(String.valueOf(NowPlayingActivity.artist))).append(" - ").append(NowPlayingActivity.title).toString();
        }
        obj = (new android.app.Notification.Builder(this)).setAutoCancel(false).setOngoing(true).setShowWhen(false).setStyle((new android.app.Notification.MediaStyle()).setMediaSession(mediaSession.getSessionToken()).setShowActionsInCompactView(new int[] {
            0, 1, 2
        })).setColor(0xff00457f).setLargeIcon(((Bitmap) (obj))).setSmallIcon(0x7f02005b).setContentText("").setContentInfo("").setContentTitle(temp_title).setContentIntent(pendingintent).addAction(0x7f0200a8, "prev", retreivePlaybackAction(3)).addAction(0x7f0200a6, "pause", retreivePlaybackAction(1)).addAction(0x7f0200a5, "next", retreivePlaybackAction(2)).addAction(0x7f0200a0, "close", retreivePlaybackAction(4)).build();
        mediaSession.getController().getTransportControls();
        amPlaying = Boolean.valueOf(true);
        ((NotificationManager)getSystemService("notification")).notify(1, ((Notification) (obj)));
        return;
        exception;
        console.log(new Object[] {
            "COULD NOT GRAB BITMAP"
        });
          goto _L1
    }

    void setUpAsForeground(String s)
    {
    }

    void tryToGetAudioFocus()
    {
        if (mAudioFocus != AudioFocus.Focused && mAudioFocusHelper != null && mAudioFocusHelper.requestFocus())
        {
            mAudioFocus = AudioFocus.Focused;
        }
    }

    void updateNotification(String s)
    {
    }

}
