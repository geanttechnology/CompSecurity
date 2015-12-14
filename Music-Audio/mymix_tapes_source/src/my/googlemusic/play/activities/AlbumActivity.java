// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import my.googlemusic.play.adapters.album.AlbumAdapter;
import my.googlemusic.play.advertising.BannerManager;
import my.googlemusic.play.advertising.InterstitialManager;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.DatabaseCallback;
import my.googlemusic.play.interfaces.Player;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Connection;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Artist;
import my.googlemusic.play.model.Song;
import my.googlemusic.play.model.User;
import my.googlemusic.play.services.player.PlayerService;
import my.googlemusic.play.utils.CompatibilityUtil;
import my.googlemusic.play.utils.ListSpaceUtil;
import my.googlemusic.play.utils.animations.AnimationFAB;
import my.googlemusic.play.utils.appbar.AppBar;
import my.googlemusic.play.utils.dialog.DialogSkipUser;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;
import my.googlemusic.play.utils.views.RobotoTextView;
import my.googlemusic.play.utils.views.StickyListView;

// Referenced classes of package my.googlemusic.play.activities:
//            CommentsActivity, ArtistActivity, PlayerActivity

public class AlbumActivity extends ActionBarActivity
    implements my.googlemusic.play.adapters.album.AlbumAdapter.OnSongListener, android.view.View.OnClickListener, my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener
{
    private static class ViewHolderDialog
    {

        RobotoTextView later;
        RobotoTextView rate;

        private ViewHolderDialog()
        {
        }

    }


    static final boolean $assertionsDisabled;
    public static final String EXTRAS_ACTION_SONG = "actionSong";
    public static final String EXTRAS_ALBUM_ID = "albumId";
    public static final String EXTRAS_ALBUM_OBJECT = "album";
    private static final String MENU_ADD_TO_FAVORITES = "Add to Favorites";
    private static final String MENU_DOWNLOAD = "Download";
    private static final String MENU_DOWNLOAD_ALL = "Download All";
    private static final String MENU_QUEUE = "Queue";
    private static final String MENU_REMOVE = "Remove from Downloads";
    private static final String MENU_RINGTONE = "Set this song as ringtone";
    private static final String MENU_SHARE = "Share on Twitter";
    public static final String PACKAGE_GOOGLE = "com.google.android.apps.plus";
    public static final String PACKAGE_TWITTER = "com.twitter.android";
    public static final int RESULT_CANCELED = -7000;
    public static final int RESULT_ERROR = -30000;
    public static final int RESULT_SUCCESS_FACEBOOK = 1000;
    public static final int RESULT_SUCCESS_GOOGLE_PLUS = 3000;
    public static final int RESULT_SUCCESS_TWITTER = 2000;
    public static final int SHARE_DEFAULT = 0;
    RelativeLayout adView;
    View albumOverlay;
    AppBar appBar;
    String artistsFeatures;
    View backgroundBar;
    View backgroundList;
    ImageButton buttonArtist;
    ImageButton buttonComment;
    ImageButton buttonFAB;
    ImageButton buttonGoogle;
    ImageButton buttonShareAlbum;
    ImageButton buttonTwitter;
    SimpleDraweeView cover;
    private boolean downloadClick;
    TextView infoSong;
    View itemArtist;
    View itemComment;
    View itemGoogle;
    View itemTwitter;
    StickyListView list;
    View loading;
    private Song mActionSong;
    private AlbumAdapter mAdapter;
    Album mAlbum;
    private boolean mBound;
    private BroadcastReceiver mBroadcastReceiver;
    private ServiceConnection mConnection;
    private Dialog mDialog;
    private ViewHolderDialog mHolderDialog;
    private float mLastVisibleListPosition;
    private float mLastVisibleListPositionTemp;
    private List mPlayList;
    private Player mPlayer;
    private String mPreferences;
    private Server mServer;
    private Song mSongSelected;
    TextView name;
    View shareContainer;
    private SharedPreferences sharedPreferences;
    View sticky;
    TextView textArtist;
    TextView textArtistFeature;
    TextView textComment;
    TextView textGoogle;
    TextView textShareAlbum;
    TextView textTwitter;
    View viewLocked;

    public AlbumActivity()
    {
        mPreferences = "share";
        mLastVisibleListPosition = 99F;
        mBroadcastReceiver = new BroadcastReceiver() {

            final AlbumActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                context = intent.getStringExtra("EXTRAS");
                if (context != null)
                {
                    if (context.equals("DOWNLOAD FINISHED"))
                    {
                        mAdapter.notifyDataSetChanged();
                    } else
                    if (context.equals("DOWNLOAD COMPLETED") && this != null)
                    {
                        Toast.with(AlbumActivity.this).message("Download complete").show();
                        return;
                    }
                }
            }

            
            {
                this$0 = AlbumActivity.this;
                super();
            }
        };
        mConnection = new ServiceConnection() {

            final AlbumActivity this$0;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                componentname = (my.googlemusic.play.services.player.PlayerService.LocalBinder)ibinder;
                mPlayer = componentname.getPlayer();
                mBound = true;
                if (mActionSong != null)
                {
                    onSongPlay(mActionSong);
                }
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
                mBound = false;
            }

            
            {
                this$0 = AlbumActivity.this;
                super();
            }
        };
    }

    private void clickCloseOptions()
    {
        buttonArtist.setVisibility(4);
        buttonComment.setVisibility(4);
        buttonShareAlbum.setVisibility(4);
        textArtist.setVisibility(4);
        textComment.setVisibility(4);
        textShareAlbum.setVisibility(4);
        albumOverlay.setVisibility(4);
        AnimationFAB.buttonFadeOut(buttonArtist, 120);
        AnimationFAB.textFadeOut(textArtist, 120);
        AnimationFAB.buttonFadeOut(buttonComment, 120);
        AnimationFAB.textFadeOut(textComment, 120);
        AnimationFAB.buttonFadeOut(buttonShareAlbum, 120);
        AnimationFAB.textFadeOut(textShareAlbum, 120);
        buttonFAB.setBackgroundResource(0x7f02005f);
    }

    private void clickOpenOptions()
    {
        buttonArtist.setVisibility(0);
        buttonComment.setVisibility(0);
        buttonShareAlbum.setVisibility(0);
        textArtist.setVisibility(0);
        textComment.setVisibility(0);
        textShareAlbum.setVisibility(0);
        albumOverlay.setVisibility(0);
        AnimationFAB.buttonFadeInDown(buttonArtist, 120);
        AnimationFAB.textFadeIn(textArtist, 200);
        AnimationFAB.buttonFadeInDown(buttonComment, 140);
        AnimationFAB.textFadeIn(textComment, 220);
        AnimationFAB.buttonFadeInDown(buttonShareAlbum, 140);
        AnimationFAB.textFadeIn(textShareAlbum, 220);
        AnimationFAB.albumOverlayFadeIn(albumOverlay, 140);
        list.smoothScrollToPosition(0);
        buttonFAB.setBackgroundResource(0x7f02005b);
    }

    private List getDownloadedSongs(Album album)
    {
        Object obj = mServer.getSongs(album);
        album = new ArrayList();
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Song song = (Song)((Iterator) (obj)).next();
            if (mServer.isDownloaded(song))
            {
                album.add(song);
            }
        } while (true);
        return album;
    }

    private void initAds()
    {
        if (!mServer.getUser().isPremium())
        {
            BannerManager.loadmmdevbanner(adView);
        }
    }

    private void initData()
    {
        long l = getIntent().getLongExtra("albumId", -1L);
        loading.setVisibility(0);
        if (l != -1L)
        {
            loadAlbum(l);
        } else
        {
            Object obj = getIntent().getStringExtra("album");
            obj = (Album)App.getGson().fromJson(((String) (obj)), my/googlemusic/play/model/Album);
            mPlayList = getDownloadedSongs(((Album) (obj)));
            mAlbum = ((Album) (obj));
            updateView();
        }
        bindService(new Intent(this, my/googlemusic/play/services/player/PlayerService), mConnection, 1);
    }

    private void initDialog()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(new ContextThemeWrapper(this, 0x7f0800e7));
        View view = getLayoutInflater().inflate(0x7f030057, null);
        mHolderDialog = new ViewHolderDialog();
        mHolderDialog.rate = (RobotoTextView)view.findViewById(0x7f0d01da);
        mHolderDialog.later = (RobotoTextView)view.findViewById(0x7f0d01d9);
        mHolderDialog.rate.setOnClickListener(this);
        mHolderDialog.later.setOnClickListener(this);
        builder.setView(view);
        mDialog = builder.create();
        mDialog.show();
    }

    private void initRateUs()
    {
        if (Connection.with(this).isConnected() && !mServer.getUser().isRateUs() && (new Random()).nextInt(100) < 10)
        {
            initDialog();
        }
    }

    private void initView()
    {
        getSupportActionBar().hide();
        setContentView(0x7f030019);
        sticky = findViewById(0x7f0d0073);
        loading = findViewById(0x7f0d019b);
        viewLocked = findViewById(0x7f0d0076);
        list = (StickyListView)findViewById(0x7f0d0072);
        backgroundBar = findViewById(0x7f0d00c4);
        backgroundList = findViewById(0x7f0d0071);
        shareContainer = findViewById(0x7f0d017f);
        adView = (RelativeLayout)findViewById(0x7f0d007a);
        buttonTwitter = (ImageButton)findViewById(0x7f0d0078);
        buttonGoogle = (ImageButton)findViewById(0x7f0d0077);
        appBar = AppBar.with(findViewById(0x7f0d0074), this).title("").back();
        if (CompatibilityUtil.getSdkVersion() >= 11)
        {
            appBar.getBackground().setAlpha(0.0F);
        }
        TextView textview = (TextView)findViewById(0x7f0d00bd);
        textview.setTextColor(getResources().getColor(0x106000b));
        textview.setSelected(true);
        viewLocked.setOnClickListener(this);
        buttonGoogle.setOnClickListener(this);
        buttonTwitter.setOnClickListener(this);
        initList();
    }

    private void loadAlbum(long l)
    {
        mServer.getAlbumFromServer(l, new my.googlemusic.play.interfaces.Server.Callback() {

            final AlbumActivity this$0;

            public void onFailure(Response response)
            {
            }

            public void onProgress(int i)
            {
            }

            public void onSuccess(Object obj)
            {
                if (obj instanceof Album)
                {
                    obj = (Album)obj;
                    mAlbum = ((Album) (obj));
                    mPlayList = ((Album) (obj)).getSongs();
                    ((Album) (obj)).setSongs(null);
                    for (int i = 0; i < mPlayList.size(); i++)
                    {
                        ((Song)mPlayList.get(i)).setAlbum(((Album) (obj)));
                    }

                    updateView();
                }
            }

            
            {
                this$0 = AlbumActivity.this;
                super();
            }
        });
    }

    private void loadAlbumWhenShareReceived()
    {
        Song song = (Song)getIntent().getParcelableExtra("actionSong");
        if (song != null)
        {
            Iterator iterator = mPlayList.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Song song1 = (Song)iterator.next();
                if (song1.getId() != song.getId())
                {
                    continue;
                }
                mActionSong = song1;
                break;
            } while (true);
            if (mActionSong != null && mPlayer != null)
            {
                onSongPlay(mActionSong);
            }
        }
    }

    private void onDeleteMenu()
    {
        mServer.deleteDownload(mSongSelected, new my.googlemusic.play.interfaces.Server.Callback() {

            final AlbumActivity this$0;

            public void onFailure(Response response)
            {
                Toast.with(AlbumActivity.this).message(response.getContent()).show();
            }

            public void onProgress(int i)
            {
            }

            public void onSuccess(Object obj)
            {
                mAdapter.notifyDataSetChanged();
            }

            
            {
                this$0 = AlbumActivity.this;
                super();
            }
        });
    }

    private void onDownloadAllMenu()
    {
        Toast.with(this).message("Downloading now").show();
        mServer.addDownload(mPlayList, new my.googlemusic.play.interfaces.Server.Callback() {

            final AlbumActivity this$0;

            public void onFailure(Response response)
            {
                Toast.with(AlbumActivity.this).message(response.getContent()).show();
            }

            public void onProgress(int i)
            {
            }

            public void onSuccess(Object obj)
            {
                mAdapter.notifyDataSetChanged();
            }

            
            {
                this$0 = AlbumActivity.this;
                super();
            }
        });
        if (!mServer.getUser().isPremium() && !downloadClick)
        {
            InterstitialManager.loadmmdev(this, false);
            downloadClick = true;
        }
    }

    private void onDownloadMenu()
    {
        if (mServer.isStreaming(mSongSelected.getAlbum().getId()))
        {
            mServer.requestStore(new my.googlemusic.play.interfaces.Server.Callback() {

                final AlbumActivity this$0;

                public void onFailure(Response response)
                {
                    Toast.with(AlbumActivity.this).message("This album is unavailable").show();
                }

                public void onProgress(int i)
                {
                }

                public void onSuccess(Object obj)
                {
                    obj = new Intent("android.intent.action.VIEW", Uri.parse(obj.toString()));
                    startActivity(((Intent) (obj)));
                }

            
            {
                this$0 = AlbumActivity.this;
                super();
            }
            }, mSongSelected.getAlbum().getId());
            return;
        } else
        {
            mServer.addDownload(mSongSelected, new my.googlemusic.play.interfaces.Server.Callback() {

                final AlbumActivity this$0;

                public void onFailure(Response response)
                {
                    Toast.with(AlbumActivity.this).message(response.getContent()).show();
                }

                public void onProgress(int i)
                {
                }

                public void onSuccess(Object obj)
                {
                    mAdapter.notifyDataSetChanged();
                }

            
            {
                this$0 = AlbumActivity.this;
                super();
            }
            });
            return;
        }
    }

    private void onFavoriteMenu()
    {
        if (mServer.getUser().isSkip())
        {
            (new DialogSkipUser()).show(getSupportFragmentManager(), null);
            return;
        } else
        {
            mServer.addFavorite(mSongSelected, new my.googlemusic.play.interfaces.Server.Callback() {

                final AlbumActivity this$0;

                public void onFailure(Response response)
                {
                    Toast.with(AlbumActivity.this).message(response.getContent()).show();
                }

                public void onProgress(int i)
                {
                }

                public void onSuccess(Object obj)
                {
                    if (obj instanceof String)
                    {
                        Toast.with(AlbumActivity.this).message((String)obj).show();
                    }
                }

            
            {
                this$0 = AlbumActivity.this;
                super();
            }
            });
            return;
        }
    }

    private void onQueueMenu()
    {
        Toast.with(this).message((new StringBuilder()).append("Queue ").append(mSongSelected.getName()).toString()).show();
    }

    private void onRingtoneMenu()
    {
        if (mServer.getUser().isSkip())
        {
            (new DialogSkipUser()).show(getSupportFragmentManager(), null);
            return;
        } else
        {
            mServer.setRingtoner(mServer.getDownload(mSongSelected.getId()), this, new my.googlemusic.play.interfaces.Server.Callback() {

                final AlbumActivity this$0;

                public void onFailure(Response response)
                {
                }

                public void onProgress(int i)
                {
                }

                public void onSuccess(Object obj)
                {
                    Toast.with(AlbumActivity.this).message(obj.toString()).show();
                }

            
            {
                this$0 = AlbumActivity.this;
                super();
            }
            });
            return;
        }
    }

    private void onShareAlbumClick()
    {
        mServer.addLike(mAlbum.getId(), mServer.getUser().getId(), 0, new my.googlemusic.play.interfaces.Server.Callback() {

            final AlbumActivity this$0;

            public void onFailure(Response response)
            {
                response = (new StringBuilder()).append("I'm listening to ").append(mAlbum.getArtist().getName()).append("'s ").append(mPlayer.getCurrentSong().getAlbum().getName()).append(" on #mymixtapez app").toString();
                shareAlbum(response);
            }

            public void onProgress(int i)
            {
            }

            public void onSuccess(Object obj)
            {
                (new Intent("android.intent.action.SEND")).setType("text/plain");
                if (obj instanceof String)
                {
                    obj = (String)obj;
                } else
                {
                    obj = (new StringBuilder()).append("I'm listening to ").append(mAlbum.getArtist().getName()).append("'s ").append(mAlbum.getName()).append(" on My Mixtapez app http://goo.gl/7dQT59").toString();
                }
                shareAlbum(((String) (obj)));
            }

            
            {
                this$0 = AlbumActivity.this;
                super();
            }
        });
    }

    private void onShareMenu()
    {
        mServer.addLike(mSongSelected.getAlbum().getId(), mServer.getUser().getId(), 2, new my.googlemusic.play.interfaces.Server.Callback() {

            final AlbumActivity this$0;

            public void onFailure(Response response)
            {
                response = new Intent("android.intent.action.SEND");
                response.setType("text/plain");
                response.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append("I'm listening to ").append(mSongSelected.getAlbum().getArtist().getName()).append("'s ").append(mSongSelected.getAlbum().getName()).append(" on My Mixtapez app http://goo.gl/7dQT59").toString());
                startActivity(Intent.createChooser(response, "Share via"));
            }

            public void onProgress(int i)
            {
            }

            public void onSuccess(Object obj)
            {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TEXT", obj.toString());
                obj = getPackageManager().queryIntentActivities(intent, 0);
                for (int i = 0; i < ((List) (obj)).size(); i++)
                {
                    String s = ((ResolveInfo)((List) (obj)).get(i)).activityInfo.packageName;
                    if (s.contains("twitter"))
                    {
                        intent.setPackage(s);
                    }
                }

                if (intent.getPackage() != null)
                {
                    startActivity(intent);
                    return;
                } else
                {
                    Toast.with(AlbumActivity.this).message("You don\u2019t have twitter installed").show();
                    return;
                }
            }

            
            {
                this$0 = AlbumActivity.this;
                super();
            }
        });
    }

    private void shareAlbum(String s)
    {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", "Share via");
        intent.putExtra("android.intent.extra.TEXT", s);
        startActivity(Intent.createChooser(intent, "Share via"));
    }

    public void initList()
    {
        View view = LayoutInflater.from(this).inflate(0x7f030076, list, false);
        if (!$assertionsDisabled && view == null)
        {
            throw new AssertionError();
        }
        name = (TextView)view.findViewById(0x7f0d026f);
        itemArtist = view.findViewById(0x7f0d027f);
        itemGoogle = view.findViewById(0x7f0d0273);
        itemComment = view.findViewById(0x7f0d027c);
        itemTwitter = view.findViewById(0x7f0d0276);
        albumOverlay = view.findViewById(0x7f0d0270);
        infoSong = (TextView)view.findViewById(0x7f0d0272);
        cover = (SimpleDraweeView)view.findViewById(0x7f0d026e);
        textArtist = (TextView)view.findViewById(0x7f0d0281);
        textGoogle = (TextView)view.findViewById(0x7f0d0275);
        buttonFAB = (ImageButton)view.findViewById(0x7f0d0283);
        textComment = (TextView)view.findViewById(0x7f0d027e);
        buttonArtist = (ImageButton)view.findViewById(0x7f0d0280);
        buttonComment = (ImageButton)view.findViewById(0x7f0d027d);
        textArtistFeature = (TextView)view.findViewById(0x7f0d0271);
        textShareAlbum = (TextView)view.findViewById(0x7f0d027b);
        buttonShareAlbum = (ImageButton)view.findViewById(0x7f0d027a);
        buttonFAB.setOnClickListener(this);
        textArtist.setOnClickListener(this);
        textComment.setOnClickListener(this);
        textShareAlbum.setOnClickListener(this);
        buttonArtist.setOnClickListener(this);
        buttonComment.setOnClickListener(this);
        buttonShareAlbum.setOnClickListener(this);
        list.addFadeView(appBar.getBackground());
        list.addHeaderView(view);
        if (mServer.getUser().isPremium())
        {
            list.addFooterView(ListSpaceUtil.getSpace(this, 50), null, false);
        } else
        {
            list.addFooterView(ListSpaceUtil.getSpace(this, 100), null, false);
        }
        list.addStickyView(sticky);
        registerForContextMenu(list);
    }

    public boolean isAlbumShared()
    {
        boolean flag1 = false;
        if (sharedPreferences == null)
        {
            sharedPreferences = getSharedPreferences(mPreferences, 0);
        }
        String s = sharedPreferences.getString(mAlbum.getName(), null);
        boolean flag = flag1;
        if (s != null)
        {
            flag = flag1;
            if (s.contains(mAlbum.getName()))
            {
                flag = true;
            }
        }
        return flag;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (j != 1000) goto _L2; else goto _L1
_L1:
        unlockAlbum();
        updateView();
        Toast.with(this).message("Album unlocked").show();
_L8:
        if (i != 3000) goto _L4; else goto _L3
_L3:
        if (j == -1)
        {
            unlockAlbum();
            updateView();
        }
_L6:
        return;
_L2:
        if (j == -7000)
        {
            Toast.with(this).message("Share to unlock this album").show();
        } else
        if (j == -30000)
        {
            Toast.with(this).message("An error has occurred. This is probably a network error or you no have the facebook app installed.").show();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (i != 2000 || j != -1) goto _L6; else goto _L5
_L5:
        unlockAlbum();
        updateView();
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void onAppBarClick(my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action action)
    {
        if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.BACK)
        {
            finish();
        }
    }

    public void onClick(View view)
    {
        if (view != textComment && view != buttonComment) goto _L2; else goto _L1
_L1:
        startActivity((new Intent(this, my/googlemusic/play/activities/CommentsActivity)).putExtra("album", App.getGson().toJson(mAlbum)));
        overridePendingTransition(0x7f040025, 0x7f040022);
_L8:
        if (mHolderDialog == null || view != mHolderDialog.rate) goto _L4; else goto _L3
_L3:
        mServer.setRateUs(true);
        view = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(getPackageName()).toString()));
        try
        {
            startActivity(view);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("http://play.google.com/store/apps/details?id=").append(getPackageName()).toString())));
        }
        mDialog.cancel();
_L6:
        return;
_L2:
        if (view == textArtist || view == buttonArtist)
        {
            startActivity((new Intent(this, my/googlemusic/play/activities/ArtistActivity)).putExtra("artist", mAlbum.getArtist()));
            overridePendingTransition(0x7f040025, 0x7f040022);
        } else
        if (view == buttonGoogle)
        {
            shareGooglePlus();
        } else
        if (view == buttonTwitter)
        {
            shareTwitter();
        } else
        if (view == buttonShareAlbum || view == textShareAlbum)
        {
            onShareAlbumClick();
        } else
        if (view == buttonFAB && itemArtist.getVisibility() != 8)
        {
            if (buttonArtist.getVisibility() == 4)
            {
                clickOpenOptions();
            } else
            {
                clickCloseOptions();
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (mHolderDialog == null || view != mHolderDialog.later) goto _L6; else goto _L5
_L5:
        mDialog.cancel();
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public boolean onContextItemSelected(MenuItem menuitem)
    {
        if (!menuitem.getTitle().equals("Download")) goto _L2; else goto _L1
_L1:
        onDownloadMenu();
_L4:
        return true;
_L2:
        if (menuitem.getTitle().equals("Download All"))
        {
            onDownloadAllMenu();
        } else
        if (menuitem.getTitle().equals("Queue"))
        {
            onQueueMenu();
        } else
        if (menuitem.getTitle().equals("Add to Favorites"))
        {
            onFavoriteMenu();
        } else
        if (menuitem.getTitle().equals("Share on Twitter"))
        {
            onShareMenu();
        } else
        if (menuitem.getTitle().equals("Remove from Downloads"))
        {
            onDeleteMenu();
        } else
        if (menuitem.getTitle().equals("Set this song as ringtone"))
        {
            onRingtoneMenu();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (CompatibilityUtil.getSdkVersion() >= 21)
        {
            getWindow().setStatusBarColor(0xff000000);
        }
        mServer = ((App)getApplication()).getServer();
        initView();
        initData();
        initAds();
        initRateUs();
    }

    public void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        contextmenu.add("Share on Twitter");
        if (!mServer.isFavorited(mSongSelected))
        {
            contextmenu.add("Add to Favorites");
        }
        if (!mServer.isDownloaded(mSongSelected))
        {
            contextmenu.add("Download");
            contextmenu.add("Download All");
        }
        if (mServer.isDownloaded(mSongSelected))
        {
            contextmenu.add("Remove from Downloads");
            contextmenu.add("Set this song as ringtone");
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (mBound)
        {
            unbindService(mConnection);
            mBound = false;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        return super.onOptionsItemSelected(menuitem);
    }

    public void onPause()
    {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mBroadcastReceiver);
        clickCloseOptions();
        buttonFAB.setVisibility(4);
    }

    public void onResume()
    {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(mBroadcastReceiver, new IntentFilter("MIXTAPEZ BROADCAST"));
        buttonFAB.postDelayed(new Runnable() {

            final AlbumActivity this$0;

            public void run()
            {
                buttonFAB.setVisibility(0);
                AnimationFAB.buttonFadeInCenter(buttonFAB, 300);
            }

            
            {
                this$0 = AlbumActivity.this;
                super();
            }
        }, 400L);
        list.postDelayed(new Runnable() {

            final AlbumActivity this$0;

            public void run()
            {
                if (!mServer.getUser().isPremium())
                {
                    mLastVisibleListPositionTemp = (float)list.getLastVisiblePosition();
                    if (mLastVisibleListPosition == 99F)
                    {
                        mLastVisibleListPosition = (float)list.getLastVisiblePosition();
                    } else
                    if (mLastVisibleListPosition == mLastVisibleListPositionTemp)
                    {
                        list.smoothScrollBy(160, 500);
                        return;
                    }
                }
            }

            
            {
                this$0 = AlbumActivity.this;
                super();
            }
        }, 300L);
    }

    public void onSongMore(Song song)
    {
        mSongSelected = song;
        list.showContextMenu();
    }

    public void onSongPlay(Song song)
    {
        mPlayer.setPlayList(mPlayList);
        mPlayer.play(mPlayList.indexOf(song));
        mPlayer.setShuffle(false);
        song = new Intent(this, my/googlemusic/play/activities/PlayerActivity);
        song.addFlags(0x4000000);
        song.addFlags(0x10000000);
        startActivity(song);
    }

    public void shareGooglePlus()
    {
        mServer.addLike(mAlbum.getId(), mServer.getUser().getId(), 0, new my.googlemusic.play.interfaces.Server.Callback() {

            final AlbumActivity this$0;

            public void onFailure(Response response)
            {
            }

            public void onProgress(int i)
            {
            }

            public void onSuccess(Object obj)
            {
                if (obj instanceof String)
                {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.TEXT", obj.toString());
                    intent.setPackage("com.google.android.apps.plus");
                    startActivityForResult(Intent.createChooser(intent, "Share using Google+"), 3000);
                }
            }

            
            {
                this$0 = AlbumActivity.this;
                super();
            }
        });
    }

    public void shareTwitter()
    {
        mServer.addLike(mAlbum.getId(), mServer.getUser().getId(), 2, new my.googlemusic.play.interfaces.Server.Callback() {

            final AlbumActivity this$0;

            public void onFailure(Response response)
            {
            }

            public void onProgress(int i)
            {
            }

            public void onSuccess(Object obj)
            {
                if (obj instanceof String)
                {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.TEXT", obj.toString());
                    intent.setPackage("com.twitter.android");
                    startActivityForResult(Intent.createChooser(intent, "Share using Twitter"), 2000);
                }
            }

            
            {
                this$0 = AlbumActivity.this;
                super();
            }
        });
    }

    public void unlockAlbum()
    {
        if (sharedPreferences == null)
        {
            sharedPreferences = getSharedPreferences(mPreferences, 0);
        }
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(mAlbum.getName(), (new StringBuilder()).append(mAlbum.getName()).append(",").toString());
        editor.commit();
    }

    public void updateView()
    {
        boolean flag1 = false;
        Object obj;
        boolean flag;
        int i;
        boolean flag2;
        if (mAlbum.isRestricted() && !isAlbumShared())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = itemArtist;
        if (flag)
        {
            i = 8;
        } else
        {
            i = 0;
        }
        ((View) (obj)).setVisibility(i);
        obj = itemComment;
        if (flag)
        {
            i = 8;
        } else
        {
            i = 0;
        }
        ((View) (obj)).setVisibility(i);
        obj = list;
        if (!flag)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        ((StickyListView) (obj)).setEnabled(flag2);
        obj = viewLocked;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
        obj = sticky;
        i = ((flag1) ? 1 : 0);
        if (flag)
        {
            i = 4;
        }
        ((View) (obj)).setVisibility(i);
        if (mAdapter == null)
        {
            mAdapter = new AlbumAdapter(this, mServer, mPlayList, this);
            list.setAdapter(mAdapter);
        } else
        {
            mAdapter.setList(mPlayList);
            mAdapter.notifyDataSetChanged();
        }
        name.setText(mAlbum.getName());
        cover.setImageURI(Uri.parse(mAlbum.getImage()));
        artistsFeatures = mAlbum.getArtist().getName();
        mServer.getArtistsFeatured(mAlbum.getId(), new DatabaseCallback() {

            final AlbumActivity this$0;

            public void onTransactionSuccessful(Object obj1)
            {
                for (obj1 = ((List)obj1).iterator(); ((Iterator) (obj1)).hasNext();)
                {
                    Artist artist = (Artist)((Iterator) (obj1)).next();
                    StringBuilder stringbuilder = new StringBuilder();
                    AlbumActivity albumactivity = AlbumActivity.this;
                    albumactivity.artistsFeatures = stringbuilder.append(albumactivity.artistsFeatures).append(", ").append(artist.getName()).toString();
                }

                textArtistFeature.setText(artistsFeatures);
                infoSong.setText((new StringBuilder()).append(mPlayList.size()).append(" songs").toString());
                textArtist.setText((new StringBuilder()).append("More from ").append(mAlbum.getArtist().getName()).toString());
                if (mPlayList != null && mPlayList.size() != 0)
                {
                    appBar.title(artistsFeatures);
                }
            }

            
            {
                this$0 = AlbumActivity.this;
                super();
            }
        });
        loading.setVisibility(8);
        obj = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation) (obj)).setFillAfter(true);
        ((AlphaAnimation) (obj)).setDuration(300L);
        loading.setAnimation(((android.view.animation.Animation) (obj)));
    }

    static 
    {
        boolean flag;
        if (!my/googlemusic/play/activities/AlbumActivity.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }





/*
    static List access$102(AlbumActivity albumactivity, List list1)
    {
        albumactivity.mPlayList = list1;
        return list1;
    }

*/




/*
    static Player access$402(AlbumActivity albumactivity, Player player)
    {
        albumactivity.mPlayer = player;
        return player;
    }

*/





/*
    static float access$702(AlbumActivity albumactivity, float f)
    {
        albumactivity.mLastVisibleListPositionTemp = f;
        return f;
    }

*/



/*
    static float access$802(AlbumActivity albumactivity, float f)
    {
        albumactivity.mLastVisibleListPosition = f;
        return f;
    }

*/


/*
    static boolean access$902(AlbumActivity albumactivity, boolean flag)
    {
        albumactivity.mBound = flag;
        return flag;
    }

*/
}
