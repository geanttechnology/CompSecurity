// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.fragments.search;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ListView;
import com.google.gson.Gson;
import java.util.List;
import my.googlemusic.play.activities.AlbumActivity;
import my.googlemusic.play.activities.ArtistActivity;
import my.googlemusic.play.activities.RadioActivity;
import my.googlemusic.play.activities.SearchMoreActivity;
import my.googlemusic.play.adapters.search.SearchAdapter;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Player;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Connection;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Artist;
import my.googlemusic.play.model.Song;
import my.googlemusic.play.services.player.PlayerService;
import my.googlemusic.play.utils.ListSpaceUtil;
import my.googlemusic.play.utils.views.RobotoTextView;

public class SearchAlbumFragment extends Fragment
    implements my.googlemusic.play.activities.SearchActivity.Searchable, my.googlemusic.play.adapters.search.SearchAdapter.OnItemSearchClickListener, android.view.View.OnClickListener
{

    private SearchAdapter mAdapter;
    private AnimationSet mAnimationSet;
    private boolean mBound;
    private ServiceConnection mConnection;
    private ViewHolder mHolder;
    private ViewHolderHeader mHolderHeader;
    private float mLastButtonSize;
    private String mNameSearch;
    private Player mPlayer;
    private List mSearchAlbumList;
    private List mSearchArtistList;
    private List mSearchSongList;
    private Server mServer;

    public SearchAlbumFragment()
    {
        mConnection = new _cls1();
    }

    private void animationChangeRadio()
    {
    /* block-local class not found */
    class ViewHolderHeader {}

        if (ViewHolderHeader.access._mth400(mHolderHeader).getVisibility() == 0 && !mNameSearch.isEmpty() && ViewHolderHeader.access._mth400(mHolderHeader).getWidth() == 0)
        {
            ViewHolderHeader.access._mth400(mHolderHeader).setVisibility(4);
            ViewHolderHeader.access._mth400(mHolderHeader).postDelayed(new _cls4(), 1L);
        }
    }

    private void animationHeader()
    {
label0:
        {
            if (!mAnimationSet.hasStarted() || mAnimationSet.hasEnded())
            {
                if (mSearchArtistList.size() != 0 && !mNameSearch.isEmpty())
                {
                    break label0;
                }
                if (ViewHolderHeader.access._mth400(mHolderHeader).getVisibility() != 8)
                {
                    ScaleAnimation scaleanimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 1.0F, ViewHolderHeader.access._mth400(mHolderHeader).getWidth() / 2, 0.0F);
                    AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
                    scaleanimation.setDuration(180L);
                    alphaanimation.setInterpolator(new AccelerateInterpolator());
                    alphaanimation.setDuration(180L);
                    mAnimationSet = new AnimationSet(true);
                    mAnimationSet.addAnimation(alphaanimation);
                    mAnimationSet.addAnimation(scaleanimation);
                    ViewHolderHeader.access._mth400(mHolderHeader).setAnimation(mAnimationSet);
                    ViewHolderHeader.access._mth400(mHolderHeader).postDelayed(new _cls2(), mAnimationSet.getDuration());
                }
            }
            return;
        }
        if (ViewHolderHeader.access._mth400(mHolderHeader).getVisibility() != 0)
        {
            TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, 180F);
            AlphaAnimation alphaanimation1 = new AlphaAnimation(1.0F, 0.0F);
            translateanimation.setDuration(180L);
            alphaanimation1.setDuration(180L);
            mAnimationSet = new AnimationSet(true);
            mAnimationSet.addAnimation(translateanimation);
            mAnimationSet.addAnimation(alphaanimation1);
    /* block-local class not found */
    class ViewHolder {}

            ViewHolder.access._mth200(mHolder).setAnimation(mAnimationSet);
            ViewHolder.access._mth200(mHolder).postDelayed(new _cls3(), mAnimationSet.getDuration());
        }
        ViewHolderHeader.access._mth500(mHolderHeader).setText((new StringBuilder()).append("Start a radio by \"").append(((Artist)mSearchArtistList.get(0)).getName()).append("\"").toString());
    }

    private void initData()
    {
        mNameSearch = getActivity().getIntent().getStringExtra("SearchText");
        mServer = ((App)getActivity().getApplication()).getServer();
        mAnimationSet = new AnimationSet(true);
        getActivity().bindService(new Intent(getActivity(), my/googlemusic/play/services/player/PlayerService), mConnection, 1);
    }

    private void initHeader()
    {
        mHolderHeader = new ViewHolderHeader(null);
        ViewGroup viewgroup = (ViewGroup)getActivity().getLayoutInflater().inflate(0x7f030046, ViewHolder.access._mth200(mHolder), false);
        ViewHolderHeader.access._mth402(mHolderHeader, viewgroup.findViewById(0x7f0d01a8));
        ViewHolderHeader.access._mth502(mHolderHeader, (RobotoTextView)viewgroup.findViewById(0x7f0d01a9));
        ViewHolderHeader.access._mth400(mHolderHeader).setOnClickListener(this);
        ViewHolderHeader.access._mth400(mHolderHeader).setVisibility(8);
        ViewHolder.access._mth200(mHolder).addHeaderView(viewgroup, null, false);
    }

    private void initSearch()
    {
    /* block-local class not found */
    class DataTask {}

        (new DataTask(null)).execute(new Void[0]);
    }

    private void initView(View view)
    {
        mHolder = new ViewHolder(null);
        ViewHolder.access._mth102(mHolder, view.findViewById(0x7f0d0264));
        ViewHolder.access._mth202(mHolder, (ListView)view.findViewById(0x7f0d0263));
        ViewHolder.access._mth200(mHolder).addFooterView(ListSpaceUtil.getSpace(getActivity(), 32));
        registerForContextMenu(ViewHolder.access._mth200(mHolder));
    }

    public static SearchAlbumFragment newInstance()
    {
        return new SearchAlbumFragment();
    }

    private void updateInfo()
    {
        View view = ViewHolder.access._mth100(mHolder);
        int i;
        if (mAdapter.getCount() == 0)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    public void onClick(View view)
    {
        if (view == ViewHolderHeader.access._mth400(mHolderHeader) && Connection.with(getActivity()).isConnected() && !mSearchArtistList.isEmpty())
        {
            startActivity((new Intent(getActivity(), my/googlemusic/play/activities/RadioActivity)).putExtra("id_artist", ((Artist)mSearchArtistList.get(0)).getId()).putExtra("radio", "artist"));
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030072, viewgroup, false);
        initData();
        initView(layoutinflater);
        initHeader();
        initSearch();
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (mBound)
        {
            getActivity().unbindService(mConnection);
            mBound = false;
        }
    }

    public void onItemSearchClick(my.googlemusic.play.adapters.search.SearchAdapter.Item item)
    {
        Intent intent;
        Object obj;
        intent = new Intent(getActivity(), my/googlemusic/play/activities/AlbumActivity);
        obj = item.getObject();
        if (!(obj instanceof Album)) goto _L2; else goto _L1
_L1:
        intent.putExtra("album", App.getGson().toJson(obj));
        item = intent;
_L4:
        startActivity(item);
        return;
_L2:
        if (obj instanceof Artist)
        {
            item = new Intent(getActivity(), my/googlemusic/play/activities/ArtistActivity);
            item.putExtra("artist", (Artist)obj);
        } else
        {
            item = intent;
            if (obj instanceof Song)
            {
                intent.putExtra("album", App.getGson().toJson(((Song)obj).getAlbum()));
                item = intent;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onMoreSearchClick(my.googlemusic.play.adapters.search.SearchAdapter.Item item)
    {
        Intent intent = new Intent(getActivity(), my/googlemusic/play/activities/SearchMoreActivity);
        intent.putExtra("search", mNameSearch);
        intent.putExtra("category", item.getCategory());
        startActivity(intent);
    }

    public void search(String s)
    {
        mNameSearch = s;
        initSearch();
        mLastButtonSize = ViewHolderHeader.access._mth400(mHolderHeader).getWidth();
    }



/*
    static List access$1002(SearchAlbumFragment searchalbumfragment, List list)
    {
        searchalbumfragment.mSearchSongList = list;
        return list;
    }

*/




/*
    static List access$1202(SearchAlbumFragment searchalbumfragment, List list)
    {
        searchalbumfragment.mSearchAlbumList = list;
        return list;
    }

*/



/*
    static List access$1302(SearchAlbumFragment searchalbumfragment, List list)
    {
        searchalbumfragment.mSearchArtistList = list;
        return list;
    }

*/



/*
    static SearchAdapter access$1402(SearchAlbumFragment searchalbumfragment, SearchAdapter searchadapter)
    {
        searchalbumfragment.mAdapter = searchadapter;
        return searchadapter;
    }

*/








/*
    static AnimationSet access$2002(SearchAlbumFragment searchalbumfragment, AnimationSet animationset)
    {
        searchalbumfragment.mAnimationSet = animationset;
        return animationset;
    }

*/



/*
    static Player access$702(SearchAlbumFragment searchalbumfragment, Player player)
    {
        searchalbumfragment.mPlayer = player;
        return player;
    }

*/


/*
    static boolean access$802(SearchAlbumFragment searchalbumfragment, boolean flag)
    {
        searchalbumfragment.mBound = flag;
        return flag;
    }

*/



/*
    static String access$902(SearchAlbumFragment searchalbumfragment, String s)
    {
        searchalbumfragment.mNameSearch = s;
        return s;
    }

*/

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}

}
