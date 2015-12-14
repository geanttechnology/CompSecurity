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
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.List;
import my.googlemusic.play.advertising.BannerManager;
import my.googlemusic.play.advertising.InterstitialManager;
import my.googlemusic.play.application.App;
import my.googlemusic.play.fragments.ShareContainerFragment;
import my.googlemusic.play.fragments.player.QueueFragment;
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
import my.googlemusic.play.utils.animations.AnimationFAB;
import my.googlemusic.play.utils.animations.AnimationInfo;
import my.googlemusic.play.utils.animations.AnimationRipple;
import my.googlemusic.play.utils.animations.AnimationUtil;
import my.googlemusic.play.utils.appbar.AppBar;
import my.googlemusic.play.utils.dialog.DialogSkipUser;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;

// Referenced classes of package my.googlemusic.play.activities:
//            CommentsActivity

public class PlayerActivity extends ActionBarActivity
    implements android.view.View.OnClickListener, my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener, my.googlemusic.play.fragments.ShareContainerFragment.OnDabbDownloadListener
{
    private static class ViewHolder
    {

        RelativeLayout adView;
        TextView album;
        AppBar appBar;
        SimpleDraweeView cover;
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
        ImageButton list;
        ProgressBar loading;
        ImageButton next;
        View parent;
        ImageButton play;
        ImageButton prev;
        SeekBar seekbar;
        View shadow;
        ImageButton shuffle;
        TextView song;
        View statusBar;
        TextView time;

        private ViewHolder()
        {
        }

    }


    public static final String EXTRAS_PLAYLIST = "playlist";
    public static final String EXTRAS_TRACK = "track";
    public static final int SHARE_DEFAULT = 0;
    public static final int SHARE_FACEBOOK = 1;
    public static final int SHARE_INSTAGRAM = 3;
    public static final int SHARE_TWITTER = 2;
    private boolean mBound;
    private BroadcastReceiver mBroadcastReceiver;
    private ServiceConnection mConnection;
    private boolean mDabbIsActive;
    private ViewHolder mHolder;
    private Player mPlayer;
    private boolean mQueueClosed;
    private Fragment mQueueFragment;
    private Server mServer;
    private ShareContainerFragment mShareFragment;
    private boolean mSupportFfmpeg;
    private FragmentTransaction mTransaction;

    public PlayerActivity()
    {
        mQueueClosed = true;
        mDabbIsActive = false;
        mSupportFfmpeg = false;
        mBroadcastReceiver = new BroadcastReceiver() {

            final PlayerActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                byte byte0;
                context = intent.getStringExtra("EXTRAS");
                if (context == null || mPlayer == null || !mPlayer.isActive())
                {
                    break MISSING_BLOCK_LABEL_285;
                }
                byte0 = -1;
                context.hashCode();
                JVM INSTR lookupswitch 6: default 100
            //                           -1800986711: 197
            //                           -1311235430: 211
            //                           -1231961305: 155
            //                           300620019: 183
            //                           1533127545: 169
            //                           1865311224: 141;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
                break; /* Loop/switch isn't completed */
_L3:
                break MISSING_BLOCK_LABEL_211;
_L8:
                switch (byte0)
                {
                default:
                    return;

                case 0: // '\0'
                    onPlayerPrepared();
                    return;

                case 1: // '\001'
                    onPlayerBuffering(Integer.valueOf(intent.getStringExtra("EXTRAS ADDITIONAL")).intValue());
                    return;

                case 2: // '\002'
                    onPlayerMusicChanged();
                    return;

                case 3: // '\003'
                    onPlayerPlaying();
                    return;

                case 4: // '\004'
                    onPlayerPaused();
                    return;

                case 5: // '\005'
                    onPlayerFinished();
                    break;
                }
                break MISSING_BLOCK_LABEL_284;
_L7:
                if (context.equals("MUSIC PREPARED"))
                {
                    byte0 = 0;
                }
                  goto _L8
_L4:
                if (context.equals("MUSIC BUFFERING"))
                {
                    byte0 = 1;
                }
                  goto _L8
_L6:
                if (context.equals("MUSIC CHANGED"))
                {
                    byte0 = 2;
                }
                  goto _L8
_L5:
                if (context.equals("MUSIC PLAYING"))
                {
                    byte0 = 3;
                }
                  goto _L8
_L2:
                if (context.equals("MUSIC PAUSED"))
                {
                    byte0 = 4;
                }
                  goto _L8
                if (context.equals("MUSIC MEDIA PLAYER FINISHED"))
                {
                    byte0 = 5;
                }
                  goto _L8
                return;
                onError();
                return;
            }

            
            {
                this$0 = PlayerActivity.this;
                super();
            }
        };
        mConnection = new ServiceConnection() {

            final PlayerActivity this$0;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                componentname = (my.googlemusic.play.services.player.PlayerService.LocalBinder)ibinder;
                mPlayer = componentname.getPlayer();
                mBound = true;
                if (!mPlayer.isActive())
                {
                    finish();
                    return;
                }
                componentname = mPlayer.getCurrentSong();
                mHolder.song.setText(componentname.getName());
                mHolder.album.setText(componentname.getAlbum().getName());
                mHolder.appBar.title(componentname.getAlbum().getArtist().getName());
                mHolder.infoPlays.setText((new StringBuilder()).append(componentname.getAlbum().getHits()).append(" plays").toString());
                mHolder.infoLikes.setText((new StringBuilder()).append(componentname.getAlbum().getLikes()).append(" likes").toString());
                mHolder.infoComments.setText((new StringBuilder()).append(componentname.getAlbum().getCommentsCount()).append(" comments").toString());
                ibinder = mHolder.favorite;
                int i;
                if (mServer.isFavorited(componentname))
                {
                    i = 0x7f020078;
                } else
                {
                    i = 0x7f020077;
                }
                ibinder.setImageResource(i);
                Picasso.with(PlayerActivity.this).load(componentname.getAlbum().getImage()).placeholder(0x7f0201dc).into(mHolder.cover);
                AnimationRipple.initFadeState(mHolder.song, mHolder.favoriteEffectBack, mServer.isFavorited(componentname), PlayerActivity.this);
                if (!mPlayer.isPlaying()) goto _L2; else goto _L1
_L1:
                onPlayerPrepared();
                onPlayerPlaying();
_L4:
                mPlayer.setNotificationVisible(false);
                initQueue();
                animationInfo();
                return;
_L2:
                if (mPlayer.isPaused())
                {
                    onPlayerPrepared();
                    onPlayerPaused();
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
                mBound = false;
            }

            
            {
                this$0 = PlayerActivity.this;
                super();
            }
        };
    }

    private void animationInfo()
    {
        mHolder.cover.post(new Runnable() {

            final PlayerActivity this$0;

            public void run()
            {
                AnimationInfo.animationInfo(mHolder.infoPlays, mHolder.infoLikes, mHolder.infoComments, mHolder.info);
            }

            
            {
                this$0 = PlayerActivity.this;
                super();
            }
        });
    }

    private void closeQueue()
    {
        collapseAppBar(false);
        setQueueClosed(true);
        AnimationUtil.fadeOut(mHolder.statusBar, 300);
        AnimationUtil.fadeOut(mHolder.appBar.getBackground(), 300);
        findViewById(0x7f0d0116).setVisibility(4);
    }

    private void collapseAppBar(boolean flag)
    {
        if (flag)
        {
            mHolder.appBar.close();
            mHolder.appBar.remove(my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.BACK);
            mHolder.appBar.remove(my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.COMMENTS);
            if (mSupportFfmpeg)
            {
                mHolder.appBar.remove(my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.SHARE);
                return;
            } else
            {
                mHolder.appBar.remove(my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.TWITTER);
                mHolder.appBar.remove(my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.INSTAGRAM);
                return;
            }
        }
        mHolder.appBar.remove(my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.CLOSE);
        if (mSupportFfmpeg)
        {
            mHolder.appBar.back().queue().share();
            return;
        } else
        {
            mHolder.appBar.back().instagram().queue().share();
            return;
        }
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
            InterstitialManager.loadmmdev(this, true);
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
        mServer = ((App)getApplication()).getServer();
        bindService(new Intent(this, my/googlemusic/play/services/player/PlayerService), mConnection, 1);
        if (android.os.Build.VERSION.SDK_INT >= 16 && App.getPreferences().getBoolean("support_ffmpeg", false))
        {
            mSupportFfmpeg = true;
        }
    }

    private void initQueue()
    {
        mQueueFragment = QueueFragment.newInstance();
        mTransaction = getSupportFragmentManager().beginTransaction();
        mTransaction.add(0x7f0d0116, mQueueFragment);
        mTransaction.commit();
    }

    private void initView()
    {
        getSupportActionBar().hide();
        if (CompatibilityUtil.getSdkVersion() >= 19)
        {
            getWindow().setFlags(0x4000000, 0x4000000);
        }
        setContentView(0x7f03002f);
        mHolder = new ViewHolder();
        mHolder.parent = findViewById(0x7f0d00fb);
        mHolder.song = (TextView)findViewById(0x7f0d0109);
        mHolder.shadow = findViewById(0x7f0d010d);
        mHolder.next = (ImageButton)findViewById(0x7f0d0102);
        mHolder.prev = (ImageButton)findViewById(0x7f0d00ff);
        mHolder.play = (ImageButton)findViewById(0x7f0d0100);
        mHolder.infoView = findViewById(0x7f0d010e);
        mHolder.album = (TextView)findViewById(0x7f0d010a);
        mHolder.time = (TextView)findViewById(0x7f0d0113);
        mHolder.seekbar = (SeekBar)findViewById(0x7f0d010b);
        mHolder.info = (ImageView)findViewById(0x7f0d0112);
        mHolder.statusBar = findViewById(0x7f0d0115);
        mHolder.shuffle = (ImageButton)findViewById(0x7f0d00fe);
        mHolder.loading = (ProgressBar)findViewById(0x7f0d0101);
        mHolder.cover = (SimpleDraweeView)findViewById(0x7f0d010c);
        mHolder.duration = (TextView)findViewById(0x7f0d0114);
        mHolder.adView = (RelativeLayout)findViewById(0x7f0d00fc);
        mHolder.favorite = (ImageButton)findViewById(0x7f0d0108);
        mHolder.list = (ImageButton)findViewById(0x7f0d0103);
        mHolder.infoPlays = (TextView)findViewById(0x7f0d010f);
        mHolder.infoLikes = (TextView)findViewById(0x7f0d0110);
        mHolder.infoComments = (TextView)findViewById(0x7f0d0111);
        mHolder.favoriteEffectBack = findViewById(0x7f0d0105);
        mHolder.favoriteEffect = (ImageView)findViewById(0x7f0d0107);
        mHolder.favoriteEffectTransiction = findViewById(0x7f0d0106);
        if (mSupportFfmpeg)
        {
            mShareFragment = new ShareContainerFragment();
            mHolder.appBar = AppBar.with(findViewById(0x7f0d0074), this).title("").back().share().queue();
            getSupportFragmentManager().beginTransaction().add(0x7f0d0117, mShareFragment).commit();
        } else
        {
            mHolder.appBar = AppBar.with(findViewById(0x7f0d0074), this).title("").back().instagram().twitter().queue();
        }
        if (CompatibilityUtil.getSdkVersion() > 11)
        {
            mHolder.statusBar.setAlpha(0.0F);
            mHolder.appBar.getBackground().setAlpha(0.0F);
        }
        if (CompatibilityUtil.getSdkVersion() < 19)
        {
            mHolder.statusBar.setVisibility(8);
        }
        mHolder.next.setOnClickListener(this);
        mHolder.play.setOnClickListener(this);
        mHolder.prev.setOnClickListener(this);
        mHolder.shuffle.setOnClickListener(this);
        mHolder.list.setOnClickListener(this);
        mHolder.favorite.setOnClickListener(this);
        mHolder.shuffle.setOnClickListener(this);
        mHolder.cover.setOnClickListener(this);
        mHolder.song.setSelected(true);
        mHolder.album.setSelected(true);
        mHolder.seekbar.setEnabled(false);
        mHolder.seekbar.setClickable(false);
        mHolder.seekbar.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            final PlayerActivity this$0;

            public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
            {
                mHolder.time.setText(convertSecondsToText(i));
            }

            public void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public void onStopTrackingTouch(SeekBar seekbar)
            {
                if (mPlayer != null)
                {
                    mPlayer.seekTo(seekbar.getProgress());
                }
            }

            
            {
                this$0 = PlayerActivity.this;
                super();
            }
        });
    }

    private boolean isQueueClosed()
    {
        return mQueueClosed;
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
        Intent intent = new Intent(this, my/googlemusic/play/activities/CommentsActivity);
        Album album = mPlayer.getCurrentSong().getAlbum();
        album.setSongs(null);
        intent.putExtra("album", App.getGson().toJson(album));
        startActivity(intent);
        overridePendingTransition(0x7f040025, 0x7f040022);
    }

    private void onError()
    {
        if (mHolder.seekbar != null)
        {
            if (mPlayer != null)
            {
                mPlayer.pause();
            }
            mHolder.seekbar.setProgress(0);
            mHolder.play.setClickable(false);
            mHolder.play.setFocusable(false);
            mHolder.seekbar.setFocusable(false);
            mHolder.seekbar.setClickable(false);
            mHolder.play.setVisibility(0);
            mHolder.play.setFocusableInTouchMode(false);
            mHolder.loading.setVisibility(4);
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
        if (mServer.isStreaming(song.getAlbum().getId()))
        {
            Toast.with(this).message("Stream only albums can\u2019t be favorited").show();
            return;
        }
        if (!mServer.isFavorited(song))
        {
            AnimationRipple.animationRippleIn(mHolder.favoriteEffectBack, mHolder.favoriteEffect, mHolder.song, this);
            mServer.addFavorite(mPlayer.getCurrentSong(), new my.googlemusic.play.interfaces.Server.Callback() {

                final PlayerActivity this$0;

                public void onFailure(Response response)
                {
                    Toast.with(PlayerActivity.this).message(response.getContent()).show();
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
                this$0 = PlayerActivity.this;
                super();
            }
            });
            mHolder.favorite.setImageResource(0x7f020078);
            return;
        } else
        {
            AnimationRipple.animationRippleOut(mHolder.favoriteEffectBack, mHolder.favoriteEffect, mHolder.song, this);
            mServer.deleteFavorite(mPlayer.getCurrentSong(), new my.googlemusic.play.interfaces.Server.Callback() {

                final PlayerActivity this$0;

                public void onFailure(Response response)
                {
                    Toast.with(PlayerActivity.this).message(response.getContent()).show();
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
                this$0 = PlayerActivity.this;
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
        if (mHolder.seekbar.getMax() != mHolder.seekbar.getSecondaryProgress())
        {
            mHolder.seekbar.setSecondaryProgress(i);
        }
        if (!mHolder.seekbar.isPressed())
        {
            mHolder.seekbar.setProgress(mPlayer.getCurrentPosition());
        }
        mHolder.time.setText(convertSecondsToText(mPlayer.getCurrentPosition()));
    }

    private void onPlayerFinished()
    {
        finish();
    }

    private void onPlayerMusicChanged()
    {
        nextPrevAnimation();
        mHolder.seekbar.setProgress(0);
        mHolder.time.setText("00:00");
        mHolder.duration.setText("00:00");
        mHolder.seekbar.setEnabled(false);
        mHolder.seekbar.setClickable(false);
        mHolder.seekbar.setSecondaryProgress(0);
        if (!mPlayer.getCurrentSong().isDownloaded())
        {
            mHolder.play.setVisibility(4);
            mHolder.loading.setVisibility(0);
            AnimationFAB.defaultFadeOut(mHolder.play, 200);
            AnimationFAB.defaultFadeIn(mHolder.loading, 200);
        }
        mHolder.song.setText(mPlayer.getCurrentSong().getName());
        mHolder.album.setText(mPlayer.getCurrentSong().getAlbum().getName());
        mHolder.appBar.title(mPlayer.getCurrentSong().getAlbum().getArtist().getName());
        mHolder.infoPlays.setText((new StringBuilder()).append(mPlayer.getCurrentSong().getAlbum().getHits()).append(" plays").toString());
        mHolder.infoLikes.setText((new StringBuilder()).append(((Song)mPlayer.getPlaylist().get(mPlayer.getCurrentTrack())).getAlbum().getLikes()).append(" likes").toString());
        mHolder.infoComments.setText((new StringBuilder()).append(((Song)mPlayer.getPlaylist().get(mPlayer.getCurrentTrack())).getAlbum().getCommentsCount()).append(" comments").toString());
        ImageButton imagebutton = mHolder.favorite;
        int i;
        if (mServer.isFavorited(mPlayer.getCurrentSong()))
        {
            i = 0x7f020078;
        } else
        {
            i = 0x7f020077;
        }
        imagebutton.setImageResource(i);
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
        mHolder.seekbar.setEnabled(true);
        mHolder.seekbar.setClickable(true);
        if (!mPlayer.getCurrentSong().isDownloaded())
        {
            mHolder.play.setVisibility(0);
            mHolder.loading.setVisibility(4);
            AnimationFAB.defaultFadeIn(mHolder.play, 300);
            AnimationFAB.defaultFadeOut(mHolder.loading, 200);
        }
        mHolder.seekbar.setMax(mPlayer.getDuration());
        mHolder.duration.setText(convertSecondsToText(mPlayer.getDuration()));
        mHolder.time.setText(convertSecondsToText(mPlayer.getDuration()));
        mHolder.infoPlays.setText((new StringBuilder()).append(mPlayer.getCurrentSong().getAlbum().getHits()).append(" plays").toString());
        ImageButton imagebutton = mHolder.shuffle;
        int i;
        if (mPlayer.isShuffle())
        {
            i = 0x7f020096;
        } else
        {
            i = 0x7f020095;
        }
        imagebutton.setImageResource(i);
        mHolder.infoLikes.setText((new StringBuilder()).append(((Song)mPlayer.getPlaylist().get(mPlayer.getCurrentTrack())).getAlbum().getLikes()).append(" likes").toString());
        mHolder.infoComments.setText((new StringBuilder()).append(((Song)mPlayer.getPlaylist().get(mPlayer.getCurrentTrack())).getAlbum().getCommentsCount()).append(" comments").toString());
        mHolder.cover.setImageURI(Uri.parse(mPlayer.getCurrentSong().getAlbum().getImage()));
        if (mDabbIsActive)
        {
            mPlayer.pause();
        }
    }

    private void onPlayerResumed()
    {
        if (mPlayer != null)
        {
            Object obj1 = mHolder.song;
            Object obj;
            int i;
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

    private void onPreviousClick()
    {
        if (mPlayer != null)
        {
            mPlayer.previous();
        }
    }

    private void onShuffleClick()
    {
        if (mPlayer != null)
        {
            Object obj = mPlayer;
            int i;
            boolean flag;
            if (!mPlayer.isShuffle())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ((Player) (obj)).setShuffle(flag);
            obj = mHolder.shuffle;
            if (mPlayer.isShuffle())
            {
                i = 0x7f020096;
            } else
            {
                i = 0x7f020095;
            }
            ((ImageButton) (obj)).setImageResource(i);
        }
    }

    private void openQueue()
    {
        collapseAppBar(true);
        setQueueClosed(false);
        if (CompatibilityUtil.getSdkVersion() > 11)
        {
            mHolder.statusBar.setAlpha(1.0F);
            mHolder.appBar.getBackground().setAlpha(1.0F);
        }
        AnimationUtil.fadeIn(mHolder.statusBar, 300);
        AnimationUtil.fadeIn(mHolder.appBar.getBackground(), 300);
        findViewById(0x7f0d0116).setVisibility(0);
    }

    private void setQueueClosed(boolean flag)
    {
        mQueueClosed = flag;
    }

    public Player getPlayer()
    {
        return mPlayer;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (!mSupportFfmpeg)
        {
            mHolder.appBar.setLoading(false).enableInstagram(true);
        }
    }

    public void onAppBarClick(my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action action)
    {
        if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.CLOSE)
        {
            closeQueue();
        } else
        {
            if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.COMMENTS)
            {
                onCommentsClick();
                return;
            }
            if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.BACK)
            {
                finish();
                return;
            }
            if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.SHARE)
            {
                mShareFragment.share(mPlayer.getCurrentSong());
                return;
            }
            if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.INSTAGRAM)
            {
                (new InstagramUtil(this, mPlayer.getCurrentSong(), mHolder.appBar, null)).shareInstagram();
                mHolder.appBar.setLoading(true).enableInstagram(false);
                ((AnimationDrawable)mHolder.appBar.getLoadingDrawable()).start();
                return;
            }
            if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.TWITTER)
            {
                TwitterUtil.with(this).sharePicture(mPlayer.getCurrentSong());
                return;
            }
        }
    }

    public void onBackPressed()
    {
        if (mShareFragment != null && mShareFragment.isActive())
        {
            mShareFragment.hideComponents();
        } else
        if (!isQueueClosed())
        {
            closeQueue();
        } else
        {
            super.onBackPressed();
            InterstitialManager.loadmmdev(this, false);
            Runtime.getRuntime().gc();
            finish();
        }
        if (!mSupportFfmpeg)
        {
            mHolder.appBar.setLoading(false).enableInstagram(true);
        }
    }

    public void onClick(View view)
    {
        if (view.getId() == mHolder.prev.getId())
        {
            onPreviousClick();
        } else
        {
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
            if (view.getId() == mHolder.list.getId())
            {
                openQueue();
                return;
            }
            if (view.getId() == mHolder.favorite.getId())
            {
                onFavoriteClick();
                return;
            }
            if (view.getId() == mHolder.shuffle.getId())
            {
                onShuffleClick();
                return;
            }
            if (view.getId() == mHolder.cover.getId())
            {
                animationInfo();
                return;
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
        initData();
        initView();
        initAds();
    }

    public void onDestroy()
    {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mBroadcastReceiver);
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

    public void onPause()
    {
        super.onPause();
        if (mPlayer != null)
        {
            mPlayer.setNotificationVisible(true);
        }
    }

    public void onResume()
    {
label0:
        {
            super.onResume();
            LocalBroadcastManager.getInstance(this).registerReceiver(mBroadcastReceiver, new IntentFilter("MIXTAPEZ BROADCAST"));
            if (mPlayer != null)
            {
                if (!mPlayer.isActive())
                {
                    break label0;
                }
                mPlayer.setNotificationVisible(false);
                onPlayerPrepared();
                onPlayerResumed();
            }
            return;
        }
        finish();
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
    static Player access$002(PlayerActivity playeractivity, Player player)
    {
        playeractivity.mPlayer = player;
        return player;
    }

*/




/*
    static boolean access$1102(PlayerActivity playeractivity, boolean flag)
    {
        playeractivity.mBound = flag;
        return flag;
    }

*/










}
