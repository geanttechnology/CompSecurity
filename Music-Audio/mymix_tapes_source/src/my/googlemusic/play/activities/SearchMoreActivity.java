// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.List;
import my.googlemusic.play.adapters.search.SearchMoreAdapter;
import my.googlemusic.play.advertising.BannerManager;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Player;
import my.googlemusic.play.interfaces.SearchCallback;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Artist;
import my.googlemusic.play.model.User;
import my.googlemusic.play.services.player.PlayerService;
import my.googlemusic.play.utils.ListSpaceUtil;
import my.googlemusic.play.utils.appbar.AppBar;

// Referenced classes of package my.googlemusic.play.activities:
//            ArtistActivity, AlbumActivity, PlayerActivity

public class SearchMoreActivity extends ActionBarActivity
    implements my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener, my.googlemusic.play.adapters.search.SearchMoreAdapter.OnItemSearchListClickListener, android.widget.AbsListView.OnScrollListener, SearchCallback
{
    private static class ViewHolder
    {

        RelativeLayout adView;
        AppBar appBar;
        ListView list;
        ProgressBar loading;

        private ViewHolder()
        {
        }

    }


    public static final String EXTRAS_TAG_CATEGORY = "category";
    public static final String EXTRAS_TAG_SEARCH = "search";
    boolean firstLoad;
    private boolean hasMoreData;
    private boolean loading;
    private SearchMoreAdapter mAdapter;
    boolean mBound;
    private String mCategory;
    private ServiceConnection mConnection;
    private int mCurrentSize;
    private View mFooter;
    private ViewHolder mHolder;
    private Player mPlayer;
    private String mSearch;
    private List mSearchList;
    private Server mServer;
    private int page;

    public SearchMoreActivity()
    {
        page = 1;
        mCurrentSize = 10;
        firstLoad = true;
        mConnection = new ServiceConnection() {

            final SearchMoreActivity this$0;

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
                this$0 = SearchMoreActivity.this;
                super();
            }
        };
    }

    private void generateSearchList(int i)
    {
        loading = true;
        if (mSearchList == null)
        {
            mSearchList = new ArrayList();
        }
        if (mCategory.equals("Mixtapes"))
        {
            mServer.searchAlbum(this, mSearch, mCurrentSize, i);
        } else
        {
            if (mCategory.equals("Artists"))
            {
                mServer.tempSearchArtist(this, mSearch, mCurrentSize, i);
                return;
            }
            if (mCategory.equals("Tracks"))
            {
                mServer.searchSong(this, mSearch, mCurrentSize, i);
                return;
            }
        }
    }

    private void initAds()
    {
        BannerManager.loadmmdevbanner(mHolder.adView);
    }

    private void initData()
    {
        mServer = ((App)getApplication()).getServer();
        mSearch = getIntent().getStringExtra("search");
        mCategory = getIntent().getStringExtra("category");
        String s;
        if (mSearch.isEmpty())
        {
            s = (new StringBuilder()).append("Search in ").append(mCategory).toString();
        } else
        {
            s = (new StringBuilder()).append(mSearch).append(" in ").append(mCategory).toString();
        }
        mHolder.appBar = AppBar.with(findViewById(0x7f0d0074), this).title(s).back();
        generateSearchList(page);
        bindService(new Intent(this, my/googlemusic/play/services/player/PlayerService), mConnection, 1);
    }

    private void initView()
    {
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().hide();
        }
        mHolder = new ViewHolder();
        mHolder.list = (ListView)findViewById(0x7f0d014c);
        mHolder.adView = (RelativeLayout)findViewById(0x7f0d014d);
        mHolder.loading = (ProgressBar)findViewById(0x7f0d014e);
        mFooter = getLayoutInflater().inflate(0x7f030040, mHolder.list, false);
        mHolder.list.addHeaderView(ListSpaceUtil.getSpace(this, 8));
        mHolder.list.addFooterView(mFooter);
        mHolder.list.setOnScrollListener(this);
    }

    public void onAppBarClick(my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action action)
    {
        if (action == my.googlemusic.play.utils.appbar.AppBar.OnAppBarListener.Action.BACK)
        {
            finish();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030036);
        initView();
        initData();
        initAds();
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

    public void onItemSearchListClick(Object obj)
    {
        if (obj instanceof Artist)
        {
            Intent intent = new Intent(this, my/googlemusic/play/activities/ArtistActivity);
            intent.putExtra("artist", (Artist)obj);
            startActivity(intent);
            return;
        }
        if (obj instanceof Album)
        {
            Intent intent1 = new Intent(this, my/googlemusic/play/activities/AlbumActivity);
            intent1.putExtra("albumId", ((Album)obj).getId());
            startActivity(intent1);
            return;
        } else
        {
            List list = mAdapter.getSongList();
            mPlayer.setPlayList(list);
            mPlayer.play(list.indexOf(obj));
            mPlayer.setShuffle(false);
            obj = new Intent(this, my/googlemusic/play/activities/PlayerActivity);
            ((Intent) (obj)).addFlags(0x4000000);
            ((Intent) (obj)).addFlags(0x10000000);
            startActivity(((Intent) (obj)));
            return;
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (mServer.getUser().isPremium() && mHolder.adView.getVisibility() == 0)
        {
            mHolder.adView.setVisibility(8);
        }
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (i + j == mCurrentSize + 1 && !loading && hasMoreData)
        {
            page = page + 1;
            generateSearchList(page);
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    public void onSearchAlbumFinish(List list)
    {
        mSearchList.addAll(list);
        boolean flag;
        if (!list.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hasMoreData = flag;
        mCurrentSize = mSearchList.size();
        if (mAdapter == null)
        {
            mAdapter = new SearchMoreAdapter(this, this);
            mHolder.list.setAdapter(mAdapter);
        }
        mAdapter.setSearchList(mSearchList);
        loading = false;
        mAdapter.notifyDataSetChanged();
        mHolder.loading.setVisibility(8);
        mFooter.findViewById(0x7f0d019a).setVisibility(8);
    }

    public void onSearchArtistFinish(List list)
    {
        mSearchList.addAll(list);
        boolean flag;
        if (!list.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hasMoreData = flag;
        mCurrentSize = mSearchList.size();
        if (mAdapter == null)
        {
            mAdapter = new SearchMoreAdapter(this, this);
            mHolder.list.setAdapter(mAdapter);
        }
        mAdapter.setSearchList(mSearchList);
        loading = false;
        mAdapter.notifyDataSetChanged();
        mHolder.loading.setVisibility(8);
        mFooter.findViewById(0x7f0d019a).setVisibility(8);
    }

    public void onSearchFailed(int i, String s)
    {
        loading = false;
        mHolder.loading.setVisibility(8);
        mFooter.findViewById(0x7f0d019a).setVisibility(8);
    }

    public void onSearchSongFinish(List list)
    {
        mSearchList.addAll(list);
        boolean flag;
        if (!list.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hasMoreData = flag;
        mCurrentSize = mSearchList.size();
        if (mAdapter == null)
        {
            mAdapter = new SearchMoreAdapter(this, this);
            mHolder.list.setAdapter(mAdapter);
        }
        mAdapter.setSearchList(mSearchList);
        loading = false;
        mAdapter.notifyDataSetChanged();
        mHolder.loading.setVisibility(8);
        mFooter.findViewById(0x7f0d019a).setVisibility(8);
    }

    public void onSearching()
    {
        loading = true;
        if (firstLoad)
        {
            mHolder.loading.setVisibility(0);
        }
        firstLoad = false;
        mFooter.findViewById(0x7f0d019a).setVisibility(0);
    }


/*
    static Player access$102(SearchMoreActivity searchmoreactivity, Player player)
    {
        searchmoreactivity.mPlayer = player;
        return player;
    }

*/
}
