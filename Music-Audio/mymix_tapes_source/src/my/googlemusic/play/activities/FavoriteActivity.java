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
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.gson.Gson;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import my.googlemusic.play.adapters.feed.HeaderLayoutManagerFixed;
import my.googlemusic.play.adapters.manager.library.LibraryRecyclerAdapter;
import my.googlemusic.play.application.App;
import my.googlemusic.play.feed.listeners.EndlessRecyclerOnScrollListener;
import my.googlemusic.play.interfaces.Player;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Artist;
import my.googlemusic.play.model.Song;
import my.googlemusic.play.model.User;
import my.googlemusic.play.services.player.PlayerService;
import my.googlemusic.play.utils.appbar.AppBar;
import my.googlemusic.play.utils.dialog.DialogSkipUser;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;
import my.googlemusic.play.utils.views.RobotoTextView;

// Referenced classes of package my.googlemusic.play.activities:
//            AlbumActivity, ArtistActivity, PlayerActivity

public class FavoriteActivity extends ActionBarActivity
    implements my.googlemusic.play.adapters.manager.library.LibraryRecyclerAdapter.OnSongClickListener, my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener
{
    private static class ViewHolder
    {

        private AppBar appBar;
        private Button content;
        private ImageView cover;
        private View header;
        private View info;
        private TextView infoMessage;
        private RecyclerView list;
        private View loading;
        private TextView text;
        private TextView totalSongs;



/*
        static RecyclerView access$102(ViewHolder viewholder, RecyclerView recyclerview)
        {
            viewholder.list = recyclerview;
            return recyclerview;
        }

*/



/*
        static TextView access$202(ViewHolder viewholder, TextView textview)
        {
            viewholder.totalSongs = textview;
            return textview;
        }

*/


/*
        static AppBar access$302(ViewHolder viewholder, AppBar appbar)
        {
            viewholder.appBar = appbar;
            return appbar;
        }

*/



        private ViewHolder()
        {
        }

    }


    private static final String MENU_ALBUM = "Go to Album";
    private static final String MENU_ARTIST = "Go to Artist";
    private static final String MENU_DOWNLOAD = "Download";
    private static final String MENU_REMOVE = "Remove from favorites";
    private static final String MENU_RINGTONE = "Set this song as ringtone";
    private static final String MENU_SHARE = "Share";
    private final String ACTION_BAR_TITLE = "Favorites";
    private final String TOTAL_FAVORITED = " Favorited tracks";
    private LibraryRecyclerAdapter mAdapter;
    private boolean mBound;
    private BroadcastReceiver mBroadcastReceiver;
    private ServiceConnection mConnection;
    private ViewHolder mHolder;
    private long mIdUser;
    private final int mPageSize = 100;
    private Player mPlayer;
    private Server mServer;
    private Song mSongSelected;
    private List playList;

    public FavoriteActivity()
    {
        playList = new ArrayList();
        mBroadcastReceiver = new BroadcastReceiver() {

            final FavoriteActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                context = intent.getStringExtra("EXTRAS");
                if (context != null)
                {
                    if (context.equals("FAVORITE ADDED"))
                    {
                        loadData(1);
                        updateInfo();
                    } else
                    {
                        if (context.equals("DOWNLOAD ADDED"))
                        {
                            mAdapter.notifyDataSetChanged();
                            return;
                        }
                        if (context.equals("DOWNLOAD DELETED"))
                        {
                            mAdapter.notifyDataSetChanged();
                            return;
                        }
                        if (context.equals("DOWNLOAD FINISHED"))
                        {
                            mAdapter.notifyDataSetChanged();
                            return;
                        }
                    }
                }
            }

            
            {
                this$0 = FavoriteActivity.this;
                super();
            }
        };
        mConnection = new ServiceConnection() {

            final FavoriteActivity this$0;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                componentname = (my.googlemusic.play.services.player.PlayerService.LocalBinder)ibinder;
                mPlayer = componentname.getPlayer();
                mBound = true;
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
                mBound = false;
            }

            
            {
                this$0 = FavoriteActivity.this;
                super();
            }
        };
    }

    private void initView()
    {
        mHolder = new ViewHolder();
        mHolder.list = (RecyclerView)findViewById(0x7f0d00d7);
        HeaderLayoutManagerFixed headerlayoutmanagerfixed = new HeaderLayoutManagerFixed(this);
        mHolder.list.setLayoutManager(headerlayoutmanagerfixed);
        mHolder.totalSongs = (RobotoTextView)findViewById(0x7f0d00d6);
        mHolder.appBar = AppBar.with(findViewById(0x7f0d0074), this).title("Favorites").back();
        mAdapter = new LibraryRecyclerAdapter(this, this);
        mAdapter.setHeaderEnabled(true);
        mAdapter.setFooterEnabled(true);
        mHolder.list.setAdapter(mAdapter);
        mHolder.list.setOnScrollListener(new EndlessRecyclerOnScrollListener(headerlayoutmanagerfixed) {

            final FavoriteActivity this$0;

            public void onLoadMore(int i)
            {
            /* block-local class not found */
            class _cls1 {}

                (new Thread(new _cls1(i))).start();
            }

            public void onScroll(int i, int j)
            {
            }

            
            {
                this$0 = FavoriteActivity.this;
                super(headerlayoutmanagerfixed);
            }
        });
        registerForContextMenu(mHolder.list);
    }

    private void loadData(int i)
    {
        System.out.println((new StringBuilder()).append("Load more page").append(i).toString());
        mServer.getProfileFavorites(mIdUser, i, 100, new my.googlemusic.play.interfaces.Server.Callback() {

            final FavoriteActivity this$0;

            public void onFailure(Response response)
            {
            }

            public void onProgress(int j)
            {
            }

            public void onSuccess(Object obj)
            {
                if (obj instanceof List)
                {
                    if (((List)obj).size() != 0)
                    {
                        mAdapter.setFooterEnabled(true);
                        playList.addAll((List)obj);
                        mAdapter.setData(playList);
                    } else
                    {
                        mAdapter.setFooterEnabled(false);
                    }
                    mHolder.totalSongs.setText((new StringBuilder()).append(playList.size()).append(" Favorited tracks").toString());
                    mAdapter.notifyDataSetChanged();
                }
            }

            
            {
                this$0 = FavoriteActivity.this;
                super();
            }
        });
    }

    private void loadMore(int i)
    {
        loadData(i);
    }

    private void onAlbumMenu()
    {
        Intent intent = new Intent(this, my/googlemusic/play/activities/AlbumActivity);
        intent.putExtra("album", App.getGson().toJson(mSongSelected.getAlbum()));
        startActivity(intent);
    }

    private void onArtistMenu()
    {
        startActivity((new Intent(this, my/googlemusic/play/activities/ArtistActivity)).putExtra("artist", mSongSelected.getAlbum().getArtist()));
    }

    private void onDownloadMenu()
    {
        mServer.addDownload(mSongSelected, new my.googlemusic.play.interfaces.Server.Callback() {

            final FavoriteActivity this$0;

            public void onFailure(Response response)
            {
                Toast.with(FavoriteActivity.this).message(response.getContent()).show();
            }

            public void onProgress(int i)
            {
            }

            public void onSuccess(Object obj)
            {
            }

            
            {
                this$0 = FavoriteActivity.this;
                super();
            }
        });
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

                final FavoriteActivity this$0;

                public void onFailure(Response response)
                {
                }

                public void onProgress(int i)
                {
                }

                public void onSuccess(Object obj)
                {
                    Toast.with(FavoriteActivity.this).message(obj.toString()).show();
                }

            
            {
                this$0 = FavoriteActivity.this;
                super();
            }
            });
            return;
        }
    }

    private void onShareMenu()
    {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append("I'm listening to ").append(mSongSelected.getAlbum().getArtist().getName()).append("'s ").append(mSongSelected.getAlbum().getName()).append(" on My Mixtapez app http://goo.gl/7dQT59").toString());
        startActivity(Intent.createChooser(intent, "Share via"));
    }

    private void updateInfo()
    {
        mHolder.totalSongs.setText(String.valueOf((new StringBuilder()).append(mAdapter.getItemCount()).append(" Favorited tracks").toString()));
        Object obj = mHolder.info;
        TextView textview;
        int i;
        if (mAdapter.getItemCount() == 0)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
        textview = mHolder.infoMessage;
        if (mServer.getUser().isSkip())
        {
            obj = "Register/Log in to get access to favorites.";
        } else
        {
            obj = "No favorites added.";
        }
        textview.setText(((CharSequence) (obj)));
    }

    public void onAppBarClick(my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action action)
    {
        if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.BACK)
        {
            onBackPressed();
        }
    }

    public boolean onContextItemSelected(MenuItem menuitem)
    {
        if (!menuitem.getTitle().equals("Download")) goto _L2; else goto _L1
_L1:
        onDownloadMenu();
_L4:
        return true;
_L2:
        if (menuitem.getTitle().equals("Go to Album"))
        {
            onAlbumMenu();
        } else
        if (menuitem.getTitle().equals("Go to Artist"))
        {
            onArtistMenu();
        } else
        if (menuitem.getTitle().equals("Share"))
        {
            onShareMenu();
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
        getSupportActionBar().hide();
        bundle = getIntent().getExtras();
        if (bundle != null)
        {
            mIdUser = bundle.getLong("idUser");
        }
        mServer = ((App)getApplication()).getServer();
        bindService(new Intent(this, my/googlemusic/play/services/player/PlayerService), mConnection, 1);
        setContentView(0x7f030025);
        initView();
        loadData(1);
    }

    public void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        if (!mServer.isDownloaded(mSongSelected))
        {
            contextmenu.add("Download");
        } else
        {
            contextmenu.add("Set this song as ringtone");
        }
        contextmenu.add("Go to Album");
        contextmenu.add("Go to Artist");
        contextmenu.add("Share");
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

    public void onPause()
    {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mBroadcastReceiver);
    }

    public void onResume()
    {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(mBroadcastReceiver, new IntentFilter("MIXTAPEZ BROADCAST"));
    }

    public void onShuffle(List list)
    {
        mPlayer.setPlayList(list);
        int i = 0;
        if (list.size() > 1)
        {
            i = (new Random()).nextInt(list.size() - 1);
        }
        mPlayer.play(list.indexOf(list.get(i)));
        mPlayer.setShuffle(true);
        startActivity(new Intent(this, my/googlemusic/play/activities/PlayerActivity));
    }

    public void onSongMore(Song song)
    {
        mSongSelected = song;
        mHolder.list.showContextMenu();
    }

    public void onSongPlay(Song song)
    {
        mPlayer.setPlayList(playList);
        if (mPlayer.getPlaylist() != null)
        {
            mPlayer.play(playList.indexOf(song));
            mPlayer.setShuffle(false);
            startActivity(new Intent(this, my/googlemusic/play/activities/PlayerActivity));
            return;
        } else
        {
            throw new NullPointerException("Playlist cannot be null");
        }
    }




/*
    static Player access$1202(FavoriteActivity favoriteactivity, Player player)
    {
        favoriteactivity.mPlayer = player;
        return player;
    }

*/


/*
    static boolean access$1302(FavoriteActivity favoriteactivity, boolean flag)
    {
        favoriteactivity.mBound = flag;
        return flag;
    }

*/




}
