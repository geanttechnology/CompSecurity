// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.targetspot.android.sdk.AdListener;
import com.targetspot.android.sdk.AdSettings;
import com.targetspot.android.sdk.SimpleAdListener;
import com.targetspot.android.sdk.TSAdType;
import com.targetspot.android.sdk.TSAudioBitrate;
import com.targetspot.android.sdk.TSAudioFormat;
import com.targetspot.android.sdk.TSContentSize;
import com.targetspot.android.sdk.TSGender;
import com.targetspot.android.sdk.TSLocationType;
import com.targetspot.android.sdk.TargetSpot;
import java.io.PrintStream;
import java.util.Collections;
import java.util.List;
import my.googlemusic.play.advertising.BannerManager;
import my.googlemusic.play.application.App;
import my.googlemusic.play.fragments.ShareContainerFragment;
import my.googlemusic.play.interfaces.Player;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Artist;
import my.googlemusic.play.model.Song;
import my.googlemusic.play.model.User;
import my.googlemusic.play.services.player.PlayerService;
import my.googlemusic.play.utils.CompatibilityUtil;
import my.googlemusic.play.utils.InstagramUtil;
import my.googlemusic.play.utils.TwitterUtil;
import my.googlemusic.play.utils.animations.AnimationInfo;
import my.googlemusic.play.utils.animations.AnimationRipple;
import my.googlemusic.play.utils.appbar.AppBar;
import my.googlemusic.play.utils.dialog.DialogSkipUser;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;

// Referenced classes of package my.googlemusic.play.activities:
//            CommentsActivity

public class RadioActivity extends ActionBarActivity
    implements android.view.View.OnClickListener, my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener, my.googlemusic.play.fragments.ShareContainerFragment.OnDabbDownloadListener
{
    private static class ViewHolder
    {

        RelativeLayout adView;
        TextView album;
        AppBar appBar;
        ImageButton buttonComment;
        ImageView cover;
        ImageButton download;
        TextView duration;
        ImageButton favorite;
        ImageView favoriteEffect;
        View favoriteEffectBack;
        View favoriteEffectTransiction;
        ImageView info;
        TextView infoComments;
        TextView infoLikes;
        TextView infoPlays;
        View infoView;
        ImageButton next;
        View offline;
        View overlay;
        ImageButton play;
        SeekBar progress;
        ImageButton rate;
        TextView song;
        View statusBar;
        TextView time;

        private ViewHolder()
        {
        }

    }


    public static final String EXTRAS_PLAYLIST = "playlist";
    public static final String EXTRAS_RADIO = "radio";
    public static final String EXTRAS_TRACK = "track";
    public static final String RADIO_ACTIVITY_STATUS = "radio_activity_status";
    boolean adAvailable;
    private List mAdSongList;
    private boolean mBound;
    private BroadcastReceiver mBroadcastReceiver;
    private ServiceConnection mConnection;
    private boolean mDabbIsActive;
    private ViewHolder mHolder;
    private long mIdArtist;
    private AdListener mListener;
    private Player mPlayer;
    private List mPlaylist;
    private String mRadio;
    private Server mServer;
    private ShareContainerFragment mShareFragment;
    private boolean mSupportFfmpeg;

    public RadioActivity()
    {
        mDabbIsActive = false;
        mSupportFfmpeg = false;
        adAvailable = false;
        mBroadcastReceiver = new BroadcastReceiver() {

            final RadioActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                context = intent.getStringExtra("EXTRAS");
                if (context != null)
                {
                    if (context.equals("MUSIC PREPARED"))
                    {
                        onPlayerPrepared();
                    } else
                    {
                        if (context.equals("MUSIC BUFFERING"))
                        {
                            onPlayerBuffering(Integer.valueOf(intent.getStringExtra("EXTRAS ADDITIONAL")).intValue());
                            return;
                        }
                        if (context.equals("MUSIC CHANGED"))
                        {
                            onPlayerMusicChanged();
                            return;
                        }
                        if (context.equals("MUSIC PLAYING"))
                        {
                            onPlayerPlaying();
                            return;
                        }
                        if (context.equals("MUSIC PAUSED"))
                        {
                            onPlayerPaused();
                            return;
                        }
                        if (context.equals("DOWNLOAD FINISHED") && mPlayer != null && mServer.isDownloadFinished(mPlayer.getCurrentSong()))
                        {
                            mHolder.download.setImageResource(0x7f02008e);
                            return;
                        }
                    }
                }
            }

            
            {
                this$0 = RadioActivity.this;
                super();
            }
        };
        mListener = new SimpleAdListener() {

            final RadioActivity this$0;

            public void onAdAvailable()
            {
                Log.d("Sample", "Ad available");
                adAvailable = true;
            }

            public void onAdRefreshing()
            {
                Log.d("Sample", "Ads are being refreshed");
                adAvailable = false;
            }

            public void onError(int i, Exception exception)
            {
                Log.e("Sample", (new StringBuilder()).append("Error ").append(i).append(": ").append(exception.getMessage()).toString());
                mPlayer.play();
            }

            public void onPlaybackStarting()
            {
                Log.d("Sample", "Ad playback starting");
            }

            public void onPlaybackStopped(int i)
            {
                String s = "";
                i;
                JVM INSTR tableswitch 1 4: default 36
            //                           1 74
            //                           2 80
            //                           3 92
            //                           4 86;
                   goto _L1 _L2 _L3 _L4 _L5
_L1:
                Log.d("Sample", (new StringBuilder()).append("Ad playback stopped: ").append(s).toString());
                mPlayer.play();
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
                this$0 = RadioActivity.this;
                super();
            }
        };
        mConnection = new ServiceConnection() {

            final RadioActivity this$0;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                componentname = (my.googlemusic.play.services.player.PlayerService.LocalBinder)ibinder;
                mPlayer = componentname.getPlayer();
                mBound = true;
                int i;
                if (!mPlayer.isRadio() || isOtherRadio() || mIdArtist != mPlayer.getIdArtistRadio())
                {
                    componentname = mPlayer;
                    ibinder = mPlaylist;
                    Object obj;
                    boolean flag;
                    if (mIdArtist != 0L)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    componentname.setPlayList(ibinder, true, flag, mIdArtist);
                    mPlayer.play(0);
                    componentname = (Song)mPlaylist.get(0);
                } else
                {
                    ibinder = mPlayer.getCurrentSong();
                    componentname = ibinder;
                    if (mIdArtist == ibinder.getAlbum().getArtist().getId())
                    {
                        componentname = ibinder;
                    }
                }
                mPlayer.setNotificationVisible(false);
                mHolder.album.setText(componentname.getAlbum().getName());
                obj = mHolder.song;
                if (componentname.getId() == 0L)
                {
                    ibinder = "";
                } else
                {
                    ibinder = componentname.getName();
                }
                ((TextView) (obj)).setText(ibinder);
                obj = mHolder.appBar;
                if (componentname.getId() == 0L)
                {
                    ibinder = "";
                } else
                {
                    ibinder = componentname.getAlbum().getArtist().getName();
                }
                ((AppBar) (obj)).title(ibinder);
                mHolder.infoPlays.setText((new StringBuilder()).append(mPlayer.getCurrentSong().getAlbum().getHits()).append(" plays").toString());
                mHolder.infoLikes.setText((new StringBuilder()).append(((Song)mPlayer.getPlaylist().get(mPlayer.getCurrentTrack())).getAlbum().getLikes()).append(" likes").toString());
                mHolder.infoComments.setText((new StringBuilder()).append(((Song)mPlayer.getPlaylist().get(mPlayer.getCurrentTrack())).getAlbum().getCommentsCount()).append(" comments").toString());
                ibinder = mHolder.favorite;
                if (mServer.isFavorited(componentname))
                {
                    i = 0x7f020078;
                } else
                {
                    i = 0x7f020077;
                }
                ibinder.setImageResource(i);
                AnimationRipple.initFadeState(mHolder.song, mHolder.favoriteEffectBack, mServer.isFavorited(componentname), RadioActivity.this);
                if (mPlayer.isPlaying())
                {
                    onPlayerPrepared();
                    onPlayerPlaying();
                } else
                if (mPlayer.isPaused())
                {
                    onPlayerPrepared();
                    onPlayerPaused();
                }
                mHolder.download.setImageResource(0x7f02013d);
                if (mServer.isDownloaded(componentname))
                {
                    ibinder = mHolder.download;
                    if (mServer.isDownloadFinished(componentname))
                    {
                        i = 0x7f02008e;
                    } else
                    {
                        i = 0x7f02008f;
                    }
                    ibinder.setImageResource(i);
                }
                animationInfo();
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
                mBound = false;
            }

            
            {
                this$0 = RadioActivity.this;
                super();
            }
        };
    }

    private void animationInfo()
    {
        mHolder.cover.post(new Runnable() {

            final RadioActivity this$0;

            public void run()
            {
                AnimationInfo.animationInfo(mHolder.infoPlays, mHolder.infoLikes, mHolder.infoComments, mHolder.info);
            }

            
            {
                this$0 = RadioActivity.this;
                super();
            }
        });
    }

    private String convertSecondsToText(int i)
    {
        int j = (int)Math.floor((float)i / 60F);
        String s;
        String s1;
        if (j < 10)
        {
            s = (new StringBuilder()).append("0").append(j).toString();
        } else
        {
            s = String.valueOf(j);
        }
        i %= 60;
        if (i < 10)
        {
            s1 = (new StringBuilder()).append("0").append(i).toString();
        } else
        {
            s1 = String.valueOf(i);
        }
        return (new StringBuilder()).append(s).append(":").append(s1).toString();
    }

    private void initAds()
    {
        if (!mServer.getUser().isPremium())
        {
            BannerManager.loadmmdevbanner(mHolder.adView);
            return;
        } else
        {
            android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)mHolder.adView.getLayoutParams();
            layoutparams.height = 1;
            mHolder.adView.setLayoutParams(layoutparams);
            return;
        }
    }

    private void initData()
    {
        mIdArtist = getIntent().getLongExtra("id_artist", 0L);
        mRadio = getIntent().getStringExtra("radio");
        mServer = ((App)getApplication()).getServer();
        App.savePreferences("radio_activity_status", true);
        if (android.os.Build.VERSION.SDK_INT >= 16 && App.getPreferences().getBoolean("support_ffmpeg", false))
        {
            mSupportFfmpeg = true;
        }
    }

    private void initList()
    {
        mServer.updateRadio(new my.googlemusic.play.interfaces.Server.Callback() {

            final RadioActivity this$0;

            public void onFailure(Response response)
            {
            }

            public void onProgress(int i)
            {
            }

            public void onSuccess(Object obj)
            {
                if (mIdArtist == 0L)
                {
                    mPlaylist = mServer.getRadio();
                } else
                {
                    mPlaylist = mServer.getArtistSongs(mIdArtist);
                    Collections.shuffle(mPlaylist);
                }
                bindService(new Intent(RadioActivity.this, my/googlemusic/play/services/player/PlayerService), mConnection, 1);
            }

            
            {
                this$0 = RadioActivity.this;
                super();
            }
        });
    }

    private void initView()
    {
        setContentView(0x7f030033);
        mHolder = new ViewHolder();
        mHolder.offline = findViewById(0x7f0d01a3);
        mHolder.song = (TextView)findViewById(0x7f0d012e);
        mHolder.next = (ImageButton)findViewById(0x7f0d0127);
        mHolder.rate = (ImageButton)findViewById(0x7f0d0124);
        mHolder.play = (ImageButton)findViewById(0x7f0d0125);
        mHolder.infoView = findViewById(0x7f0d0133);
        mHolder.time = (TextView)findViewById(0x7f0d0138);
        mHolder.album = (TextView)findViewById(0x7f0d012f);
        mHolder.progress = (SeekBar)findViewById(0x7f0d0130);
        mHolder.info = (ImageView)findViewById(0x7f0d0137);
        mHolder.statusBar = findViewById(0x7f0d013a);
        mHolder.cover = (ImageView)findViewById(0x7f0d0131);
        mHolder.adView = (RelativeLayout)findViewById(0x7f0d0121);
        mHolder.duration = (TextView)findViewById(0x7f0d0139);
        mHolder.download = (ImageButton)findViewById(0x7f0d0123);
        mHolder.favorite = (ImageButton)findViewById(0x7f0d012d);
        mHolder.infoPlays = (TextView)findViewById(0x7f0d0134);
        mHolder.infoLikes = (TextView)findViewById(0x7f0d0135);
        mHolder.buttonComment = (ImageButton)findViewById(0x7f0d0128);
        mHolder.infoComments = (TextView)findViewById(0x7f0d0136);
        mHolder.favoriteEffectBack = findViewById(0x7f0d012a);
        mHolder.favoriteEffect = (ImageView)findViewById(0x7f0d012c);
        mHolder.favoriteEffectTransiction = findViewById(0x7f0d012b);
        mHolder.appBar = AppBar.with(findViewById(0x7f0d0074), this).title("").back().instagram().twitter();
        if (mSupportFfmpeg)
        {
            mShareFragment = new ShareContainerFragment();
            mHolder.appBar = AppBar.with(findViewById(0x7f0d0074), this).title("").back().share();
            getSupportFragmentManager().beginTransaction().add(0x7f0d0117, mShareFragment).commit();
        } else
        {
            mHolder.appBar = AppBar.with(findViewById(0x7f0d0074), this).title("").back().instagram().twitter();
        }
        mHolder.song.setSelected(true);
        mHolder.album.setSelected(true);
        mHolder.next.setOnClickListener(this);
        mHolder.play.setOnClickListener(this);
        mHolder.rate.setOnClickListener(this);
        mHolder.cover.setOnClickListener(this);
        mHolder.favorite.setOnClickListener(this);
        mHolder.download.setOnClickListener(this);
        mHolder.buttonComment.setOnClickListener(this);
        mHolder.progress.setEnabled(false);
        mHolder.progress.setClickable(false);
        mHolder.progress.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            final RadioActivity this$0;

            public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
            {
                mHolder.time.setText(convertSecondsToText(i));
            }

            public void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public void onStopTrackingTouch(SeekBar seekbar)
            {
                if (mPlayer != null && mPlayer.getCurrentSong().getId() != 0L)
                {
                    mPlayer.seekTo(seekbar.getProgress());
                }
            }

            
            {
                this$0 = RadioActivity.this;
                super();
            }
        });
        if (CompatibilityUtil.getSdkVersion() > 11)
        {
            mHolder.statusBar.setAlpha(0.0F);
            mHolder.appBar.getBackground().setAlpha(0.0F);
        }
        if (CompatibilityUtil.getSdkVersion() < 19)
        {
            mHolder.statusBar.setVisibility(8);
        }
    }

    private boolean isOtherRadio()
    {
        return mRadio != null && (mRadio.equals("radio") && mPlayer.getIdArtistRadio() != 0L || mRadio.equals("artist") && mPlayer.getIdArtistRadio() == 0L);
    }

    private void nextPrevAnimation()
    {
        if (mServer.isFavorited(mPlayer.getCurrentSong()))
        {
            AnimationRipple.animationFadeIn(mHolder.favoriteEffectTransiction, mHolder.favoriteEffectBack, mHolder.song, this);
            return;
        } else
        {
            AnimationRipple.animationFadeOut(mHolder.favoriteEffectTransiction, mHolder.favoriteEffectBack, mHolder.song, this);
            return;
        }
    }

    private void onCommentsClick()
    {
        if (this != null && mPlayer != null)
        {
            Intent intent = new Intent(this, my/googlemusic/play/activities/CommentsActivity);
            intent.putExtra("album", App.getGson().toJson(mPlayer.getCurrentSong().getAlbum()));
            startActivity(intent);
            overridePendingTransition(0x7f040025, 0x7f040022);
        }
    }

    private void onDownloadClick()
    {
        if (mPlayer != null && !mServer.isDownloaded(mPlayer.getCurrentSong()))
        {
            mHolder.download.setImageResource(0x7f02008f);
            mServer.addDownload(mPlayer.getCurrentSong(), new my.googlemusic.play.interfaces.Server.Callback() {

                final RadioActivity this$0;

                public void onFailure(Response response)
                {
                    Toast.with(RadioActivity.this).message(response.getContent()).show();
                }

                public void onProgress(int i)
                {
                }

                public void onSuccess(Object obj)
                {
                }

            
            {
                this$0 = RadioActivity.this;
                super();
            }
            });
        }
    }

    private void onFavoriteClick()
    {
        if (mServer.getUser().isSkip())
        {
            (new DialogSkipUser()).show(getSupportFragmentManager(), null);
            return;
        }
        Song song = mPlayer.getCurrentSong();
        if (!mServer.isFavorited(song))
        {
            AnimationRipple.animationRippleIn(mHolder.favoriteEffectBack, mHolder.favoriteEffect, mHolder.song, this);
            mServer.addFavorite(mPlayer.getCurrentSong(), new my.googlemusic.play.interfaces.Server.Callback() {

                final RadioActivity this$0;

                public void onFailure(Response response)
                {
                    Toast.with(RadioActivity.this).message(response.getContent()).show();
                    mHolder.favorite.setImageResource(0x7f020077);
                }

                public void onProgress(int i)
                {
                }

                public void onSuccess(Object obj)
                {
                    if (!(obj instanceof String));
                }

            
            {
                this$0 = RadioActivity.this;
                super();
            }
            });
            mHolder.favorite.setImageResource(0x7f020078);
            return;
        } else
        {
            AnimationRipple.animationRippleOut(mHolder.favoriteEffectBack, mHolder.favoriteEffect, mHolder.song, this);
            mServer.deleteFavorite(mPlayer.getCurrentSong(), new my.googlemusic.play.interfaces.Server.Callback() {

                final RadioActivity this$0;

                public void onFailure(Response response)
                {
                    Toast.with(RadioActivity.this).message(response.getContent()).show();
                    mHolder.favorite.setImageResource(0x7f020078);
                }

                public void onProgress(int i)
                {
                }

                public void onSuccess(Object obj)
                {
                    if (!(obj instanceof String));
                }

            
            {
                this$0 = RadioActivity.this;
                super();
            }
            });
            mHolder.favorite.setImageResource(0x7f020077);
            return;
        }
    }

    private void onNextClick()
    {
        if (mPlayer != null)
        {
            mPlayer.next();
        }
    }

    private void onPlayClick()
    {
label0:
        {
            if (mPlayer != null)
            {
                if (!mPlayer.isPlaying())
                {
                    break label0;
                }
                mPlayer.pause();
            }
            return;
        }
        mPlayer.play();
    }

    private void onPlayerBuffering(int i)
    {
        System.out.println((new StringBuilder()).append("player buffering:").append(i).toString());
        if (mPlayer != null)
        {
            if (mHolder.progress.getMax() != mHolder.progress.getSecondaryProgress())
            {
                mHolder.progress.setSecondaryProgress(i);
            }
            if (!mHolder.progress.isPressed())
            {
                mHolder.progress.setProgress(mPlayer.getCurrentPosition());
            }
            mHolder.time.setText(convertSecondsToText(mPlayer.getCurrentPosition()));
        }
    }

    private void onPlayerMusicChanged()
    {
        boolean flag1 = true;
        nextPrevAnimation();
        mHolder.progress.setProgress(0);
        mHolder.progress.setSecondaryProgress(0);
        mHolder.progress.setEnabled(false);
        mHolder.time.setVisibility(4);
        mHolder.duration.setVisibility(4);
        Object obj1 = mHolder.song;
        Object obj;
        int i;
        boolean flag;
        if (mPlayer.getCurrentSong().getId() == 0L)
        {
            obj = "";
        } else
        {
            obj = mPlayer.getCurrentSong().getName();
        }
        ((TextView) (obj1)).setText(((CharSequence) (obj)));
        obj1 = mHolder.album;
        if (mPlayer.getCurrentSong().getId() == 0L)
        {
            obj = "";
        } else
        {
            obj = mPlayer.getCurrentSong().getAlbum().getName();
        }
        ((TextView) (obj1)).setText(((CharSequence) (obj)));
        obj1 = mHolder.appBar;
        if (mPlayer.getCurrentSong().getId() == 0L)
        {
            obj = "";
        } else
        {
            obj = mPlayer.getCurrentSong().getAlbum().getArtist().getName();
        }
        ((AppBar) (obj1)).title(((String) (obj)));
        mHolder.infoPlays.setText((new StringBuilder()).append(mPlayer.getCurrentSong().getAlbum().getHits()).append(" plays").toString());
        mHolder.infoLikes.setText((new StringBuilder()).append(((Song)mPlayer.getPlaylist().get(mPlayer.getCurrentTrack())).getAlbum().getLikes()).append(" likes").toString());
        mHolder.infoComments.setText((new StringBuilder()).append(((Song)mPlayer.getPlaylist().get(mPlayer.getCurrentTrack())).getAlbum().getCommentsCount()).append(" comments").toString());
        mHolder.download.setImageResource(0x7f02013d);
        if (mServer.isDownloaded(mPlayer.getCurrentSong()))
        {
            obj = mHolder.download;
            if (mServer.isDownloadFinished(mPlayer.getCurrentSong()))
            {
                i = 0x7f02008e;
            } else
            {
                i = 0x7f02008f;
            }
            ((ImageButton) (obj)).setImageResource(i);
        }
        obj = mHolder.next;
        if (mPlayer.getCurrentSong().getId() != 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((ImageButton) (obj)).setEnabled(flag);
        obj = mHolder.rate;
        if (mPlayer.getCurrentSong().getId() != 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((ImageButton) (obj)).setEnabled(flag);
        obj = mHolder.favorite;
        if (mPlayer.getCurrentSong().getId() != 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((ImageButton) (obj)).setEnabled(flag);
        obj = mHolder.download;
        if (mPlayer.getCurrentSong().getId() != 0L)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        ((ImageButton) (obj)).setEnabled(flag);
        obj = mHolder.favorite;
        if (mServer.isFavorited(mPlayer.getCurrentSong()))
        {
            i = 0x7f020078;
        } else
        {
            i = 0x7f020077;
        }
        ((ImageButton) (obj)).setImageResource(i);
        animationInfo();
    }

    private void onPlayerPaused()
    {
        mHolder.play.setImageResource(0x7f020085);
    }

    private void onPlayerPlaying()
    {
        mHolder.play.setImageResource(0x7f020082);
    }

    private void onPlayerPrepared()
    {
        mHolder.progress.setEnabled(true);
        mHolder.progress.setClickable(true);
        mHolder.progress.setMax(mPlayer.getDuration());
        mHolder.duration.setText(convertSecondsToText(mPlayer.getDuration()));
        mHolder.time.setText(convertSecondsToText(mPlayer.getCurrentPosition()));
        mHolder.infoPlays.setText((new StringBuilder()).append(mPlayer.getCurrentSong().getAlbum().getHits()).append(" plays").toString());
        mHolder.infoLikes.setText((new StringBuilder()).append(((Song)mPlayer.getPlaylist().get(mPlayer.getCurrentTrack())).getAlbum().getLikes()).append(" likes").toString());
        mHolder.infoComments.setText((new StringBuilder()).append(((Song)mPlayer.getPlaylist().get(mPlayer.getCurrentTrack())).getAlbum().getCommentsCount()).append(" comments").toString());
        mHolder.time.setVisibility(0);
        mHolder.duration.setVisibility(0);
        Picasso.with(this).load(mPlayer.getCurrentSong().getAlbum().getImage()).placeholder(0x7f0201dc).into(mHolder.cover);
        if (mDabbIsActive)
        {
            mPlayer.pause();
        }
    }

    private void onPlayerResumed()
    {
        if (mPlayer != null)
        {
            mHolder.download.setImageResource(0x7f02013d);
            Object obj;
            int i;
            if (mServer.isDownloaded(mPlayer.getCurrentSong()))
            {
                obj = mHolder.download;
                Object obj1;
                if (mServer.isDownloadFinished(mPlayer.getCurrentSong()))
                {
                    i = 0x7f02008e;
                } else
                {
                    i = 0x7f02008f;
                }
                ((ImageButton) (obj)).setImageResource(i);
            }
            obj1 = mHolder.song;
            if (mPlayer.getCurrentSong().getId() == 0L)
            {
                obj = "";
            } else
            {
                obj = mPlayer.getCurrentSong().getName();
            }
            ((TextView) (obj1)).setText(((CharSequence) (obj)));
            obj1 = mHolder.album;
            if (mPlayer.getCurrentSong().getId() == 0L)
            {
                obj = "";
            } else
            {
                obj = mPlayer.getCurrentSong().getAlbum().getName();
            }
            ((TextView) (obj1)).setText(((CharSequence) (obj)));
            obj1 = mHolder.appBar;
            if (mPlayer.getCurrentSong().getId() == 0L)
            {
                obj = "";
            } else
            {
                obj = mPlayer.getCurrentSong().getAlbum().getArtist().getName();
            }
            ((AppBar) (obj1)).title(((String) (obj)));
            obj = mHolder.favorite;
            if (mServer.isFavorited(mPlayer.getCurrentSong()))
            {
                i = 0x7f020078;
            } else
            {
                i = 0x7f020077;
            }
            ((ImageButton) (obj)).setImageResource(i);
        }
    }

    private void onRateClick()
    {
        mServer.sendSongVote(mPlayer.getCurrentSong().getId());
        onNextClick();
        animationInfo();
    }

    private void targetSpot()
    {
        if (!TargetSpot.isActive())
        {
            AdSettings adsettings = new AdSettings();
            adsettings.setTargetSpotStation("MYMIXAND");
            adsettings.setAdType(TSAdType.TSAdTypeAudio);
            adsettings.setAlphaForBackground(0.90000000000000002D);
            adsettings.setAudioBitrate(TSAudioBitrate.TSAudioBitrateDefault);
            adsettings.setAudioFormat(TSAudioFormat.TSAudioMP3);
            adsettings.setBackToBackMode(false);
            adsettings.setContentSize(TSContentSize.TSContentSizeDefault);
            adsettings.setLocationType(TSLocationType.TSLocationLastKnown);
            adsettings.setManagedMode(true);
            adsettings.setMaxNumAds(9);
            adsettings.setPlaybackLengths(new int[] {
                30
            });
            adsettings.setProductionMode(true);
            adsettings.setUserGender(TSGender.TSGenderUnknown);
            TargetSpot.startAdSession(getApplicationContext(), adsettings);
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        break MISSING_BLOCK_LABEL_7;
        if (j == -1 || j != 0);
        if (!mSupportFfmpeg)
        {
            mHolder.appBar.setLoading(false).enableInstagram(true);
        }
        return;
    }

    public void onAppBarClick(my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action action)
    {
        if (!PlayerService.adAvailable)
        {
            if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.BACK)
            {
                finish();
            } else
            {
                if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.SHARE && mPlayer != null && mPlayer.getCurrentSong().getId() != 0L)
                {
                    mShareFragment.share(mPlayer.getCurrentSong());
                    return;
                }
                if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.INSTAGRAM && mPlayer != null && mPlayer.getCurrentSong().getId() != 0L)
                {
                    (new InstagramUtil(this, mPlayer.getCurrentSong(), mHolder.appBar, null)).shareInstagram();
                    return;
                }
                if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.TWITTER && mPlayer != null && mPlayer.getCurrentSong().getId() != 0L)
                {
                    TwitterUtil.with(this).sharePicture(mPlayer.getCurrentSong());
                    return;
                }
            }
        }
    }

    public void onBackPressed()
    {
        super.onBackPressed();
    }

    public void onClick(View view)
    {
        if (!PlayerService.adAvailable)
        {
            if (view.getId() == mHolder.buttonComment.getId())
            {
                onCommentsClick();
            } else
            {
                if (view.getId() == mHolder.rate.getId())
                {
                    onRateClick();
                    return;
                }
                if (view.getId() == mHolder.next.getId())
                {
                    onNextClick();
                    return;
                }
                if (view.getId() == mHolder.play.getId())
                {
                    onPlayClick();
                    return;
                }
                if (view.getId() == mHolder.favorite.getId())
                {
                    onFavoriteClick();
                    return;
                }
                if (view.getId() == mHolder.download.getId())
                {
                    onDownloadClick();
                    return;
                }
                if (view.getId() == mHolder.cover.getId())
                {
                    animationInfo();
                    return;
                }
            }
        }
    }

    public void onCloseDabb()
    {
        mDabbIsActive = false;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getSupportActionBar().hide();
        if (CompatibilityUtil.getSdkVersion() >= 19)
        {
            getWindow().setFlags(0x4000000, 0x4000000);
        }
        initData();
        initView();
        initAds();
        initList();
    }

    public void onDestroy()
    {
        super.onDestroy();
        App.savePreferences("radio_activity_status", false);
        if (mBound)
        {
            unbindService(mConnection);
            mBound = false;
        }
        if (mPlayer != null)
        {
            mPlayer.setNotificationVisible(false);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 82)
        {
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public void onPause()
    {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mBroadcastReceiver);
        if (mPlayer != null)
        {
            mPlayer.setNotificationVisible(true);
        }
    }

    public void onResume()
    {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(mBroadcastReceiver, new IntentFilter("MIXTAPEZ BROADCAST"));
        if (mPlayer != null)
        {
            if (mPlayer.isActive())
            {
                mPlayer.setNotificationVisible(false);
                onPlayerPrepared();
                if (mPlayer.isPlaying())
                {
                    onPlayerPlaying();
                } else
                {
                    onPlayerPaused();
                }
            } else
            {
                finish();
            }
        }
        onPlayerResumed();
    }

    public void onStartDabbDownload()
    {
        if (mPlayer.isPlaying())
        {
            mPlayer.pause();
        }
        mDabbIsActive = true;
    }






/*
    static boolean access$1302(RadioActivity radioactivity, boolean flag)
    {
        radioactivity.mBound = flag;
        return flag;
    }

*/








/*
    static Player access$502(RadioActivity radioactivity, Player player)
    {
        radioactivity.mPlayer = player;
        return player;
    }

*/






/*
    static List access$902(RadioActivity radioactivity, List list)
    {
        radioactivity.mPlaylist = list;
        return list;
    }

*/
}
