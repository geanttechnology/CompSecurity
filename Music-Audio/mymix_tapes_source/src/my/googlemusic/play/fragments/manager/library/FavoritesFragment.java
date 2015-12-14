// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.fragments.manager.library;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import my.googlemusic.play.activities.AlbumActivity;
import my.googlemusic.play.activities.ArtistActivity;
import my.googlemusic.play.activities.PlayerActivity;
import my.googlemusic.play.adapters.manager.library.LibraryAdapter;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Player;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Artist;
import my.googlemusic.play.model.Song;
import my.googlemusic.play.model.User;
import my.googlemusic.play.services.player.PlayerService;
import my.googlemusic.play.utils.ListSpaceUtil;
import my.googlemusic.play.utils.dialog.DialogSkipUser;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;

public class FavoritesFragment extends Fragment
    implements my.googlemusic.play.adapters.manager.library.LibraryAdapter.OnSongClickListener, android.view.View.OnClickListener
{

    private static final String MENU_ALBUM = "Go to Album";
    private static final String MENU_ARTIST = "Go to Artist";
    private static final String MENU_DOWNLOAD = "Download";
    private static final String MENU_REMOVE = "Remove from favorites";
    private static final String MENU_RINGTONE = "Set this song as ringtone";
    private static final String MENU_SHARE = "Share on Twitter";
    private View header;
    private LibraryAdapter mAdapter;
    private boolean mBound;
    private BroadcastReceiver mBroadcastReceiver;
    private ServiceConnection mConnection;
    private List mFavoriteList;
    private ViewHolder mHolder;
    private Player mPlayer;
    private Server mServer;
    private Song mSongSelected;

    public FavoritesFragment()
    {
        mBroadcastReceiver = new _cls1();
        mConnection = new _cls6();
    }

    private void initFavorites()
    {
        setLoading(true);
        mServer.updatePlayLists(new _cls2());
    }

    private void initHeaderShuffle()
    {
    /* block-local class not found */
    class ViewHolder {}

        if (getActivity() != null && ViewHolder.access._mth600(mHolder) != null)
        {
            header = getActivity().getLayoutInflater().inflate(0x7f03008b, ViewHolder.access._mth600(mHolder), false);
            ViewHolder.access._mth902(mHolder, (TextView)header.findViewById(0x7f0d02ef));
            ViewHolder.access._mth1002(mHolder, (ImageView)header.findViewById(0x7f0d02ee));
            ViewHolder.access._mth1102(mHolder, (Button)header.findViewById(0x7f0d02ed));
            ViewHolder.access._mth900(mHolder).setText("Shuffle all favorites");
            ViewHolder.access._mth1100(mHolder).setOnClickListener(this);
            ViewHolder.access._mth1000(mHolder).setImageResource(0x7f020111);
            ViewHolder.access._mth600(mHolder).addHeaderView(header);
        }
    }

    private void initView(View view)
    {
        mHolder = new ViewHolder(null);
        ViewHolder.access._mth402(mHolder, view.findViewById(0x7f0d00d9));
        ViewHolder.access._mth502(mHolder, view.findViewById(0x7f0d019b));
        ViewHolder.access._mth602(mHolder, (ListView)view.findViewById(0x7f0d023f));
        ViewHolder.access._mth702(mHolder, (TextView)view.findViewById(0x7f0d00d6));
        ViewHolder.access._mth802(mHolder, (TextView)view.findViewById(0x7f0d00da));
        if (mServer.getUser().isPremium())
        {
            ViewHolder.access._mth600(mHolder).addFooterView(ListSpaceUtil.getSpace(getActivity(), 50), null, false);
        } else
        {
            ViewHolder.access._mth600(mHolder).addFooterView(ListSpaceUtil.getSpace(getActivity(), 100), null, false);
        }
        initHeaderShuffle();
        mAdapter = new LibraryAdapter(getActivity(), mServer, mFavoriteList, this);
        ViewHolder.access._mth600(mHolder).setAdapter(mAdapter);
        ViewHolder.access._mth400(mHolder).setOnClickListener(this);
        registerForContextMenu(ViewHolder.access._mth600(mHolder));
    }

    public static FavoritesFragment newInstance()
    {
        return new FavoritesFragment();
    }

    private void onAlbumMenu()
    {
        Intent intent = new Intent(getActivity(), my/googlemusic/play/activities/AlbumActivity);
        intent.putExtra("album", App.getGson().toJson(mSongSelected.getAlbum()));
        startActivity(intent);
    }

    private void onArtistMenu()
    {
        startActivity((new Intent(getActivity(), my/googlemusic/play/activities/ArtistActivity)).putExtra("artist", mSongSelected.getAlbum().getArtist()));
    }

    private void onDownloadMenu()
    {
        mServer.addDownload(mSongSelected, new _cls4());
    }

    private void onRemoveMenu()
    {
        if (mServer.getUser().isSkip())
        {
            (new DialogSkipUser()).show(getActivity().getSupportFragmentManager(), null);
            return;
        } else
        {
            mServer.deleteFavorite(mSongSelected, new _cls3());
            return;
        }
    }

    private void onRingtoneMenu()
    {
        if (mServer.getUser().isSkip())
        {
            (new DialogSkipUser()).show(getActivity().getSupportFragmentManager(), null);
            return;
        } else
        {
            mServer.setRingtoner(mServer.getDownload(mSongSelected.getId()), getActivity(), new _cls5());
            return;
        }
    }

    private void onShareMenu()
    {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append("I'm listening to ").append(mSongSelected.getAlbum().getArtist().getName()).append("'s ").append(mSongSelected.getAlbum().getName()).append(" on My Mixtapez app http://goo.gl/7dQT59").toString());
        List list = getActivity().getPackageManager().queryIntentActivities(intent, 0);
        for (int i = 0; i < list.size(); i++)
        {
            String s = ((ResolveInfo)list.get(i)).activityInfo.packageName;
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
            Toast.with(getActivity()).message("You don\u2019t have twitter installed").show();
            return;
        }
    }

    private void setLoading(boolean flag)
    {
        View view = ViewHolder.access._mth500(mHolder);
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    private void updateInfo()
    {
        ViewHolder.access._mth700(mHolder).setText(String.valueOf((new StringBuilder()).append(mAdapter.getCount()).append(" Favorited tracks").toString()));
        Object obj = ViewHolder.access._mth400(mHolder);
        TextView textview;
        int i;
        if (mAdapter.getCount() == 0)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
        textview = ViewHolder.access._mth800(mHolder);
        if (mServer.getUser().isSkip())
        {
            obj = "Register/Log in to get access to favorites.";
        } else
        {
            obj = "No favorites added.";
        }
        textview.setText(((CharSequence) (obj)));
    }

    public void onClick(View view)
    {
        if (mServer.getUser().isSkip() && view == ViewHolder.access._mth400(mHolder))
        {
            (new DialogSkipUser()).show(getFragmentManager(), null);
        } else
        if (view == ViewHolder.access._mth1100(mHolder))
        {
            mPlayer.setPlayList(mFavoriteList);
            int i = 0;
            if (mFavoriteList.size() > 1)
            {
                i = (new Random()).nextInt(mFavoriteList.size() - 1);
            }
            mPlayer.play(mFavoriteList.indexOf(mFavoriteList.get(i)));
            mPlayer.setShuffle(true);
            startActivity(new Intent(getActivity(), my/googlemusic/play/activities/PlayerActivity));
            return;
        }
    }

    public boolean onContextItemSelected(MenuItem menuitem)
    {
        if (!getUserVisibleHint()) goto _L2; else goto _L1
_L1:
        if (!menuitem.getTitle().equals("Remove from favorites")) goto _L4; else goto _L3
_L3:
        onRemoveMenu();
_L5:
        return true;
_L4:
        if (menuitem.getTitle().equals("Download"))
        {
            onDownloadMenu();
        } else
        if (menuitem.getTitle().equals("Go to Album"))
        {
            onAlbumMenu();
        } else
        if (menuitem.getTitle().equals("Go to Artist"))
        {
            onArtistMenu();
        } else
        if (menuitem.getTitle().equals("Share on Twitter"))
        {
            onShareMenu();
        } else
        if (menuitem.getTitle().equals("Set this song as ringtone"))
        {
            onRingtoneMenu();
        }
        if (true) goto _L5; else goto _L2
_L2:
        return false;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mFavoriteList = new ArrayList(0);
        mServer = ((App)getActivity().getApplication()).getServer();
        getActivity().bindService(new Intent(getActivity(), my/googlemusic/play/services/player/PlayerService), mConnection, 1);
    }

    public void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        contextmenu.add("Remove from favorites");
        if (!mServer.isDownloaded(mSongSelected))
        {
            contextmenu.add("Download");
        } else
        {
            contextmenu.add("Set this song as ringtone");
        }
        contextmenu.add("Go to Album");
        contextmenu.add("Go to Artist");
        contextmenu.add("Share on Twitter");
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030069, viewgroup, false);
        initView(layoutinflater);
        initFavorites();
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

    public void onPause()
    {
        super.onPause();
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(mBroadcastReceiver);
    }

    public void onResume()
    {
        super.onResume();
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(mBroadcastReceiver, new IntentFilter("MIXTAPEZ BROADCAST"));
    }

    public void onSongMore(Song song)
    {
        mSongSelected = song;
        ViewHolder.access._mth600(mHolder).showContextMenu();
    }

    public void onSongPlay(Song song)
    {
        mPlayer.setPlayList(mFavoriteList);
        mPlayer.play(mFavoriteList.indexOf(song));
        mPlayer.setShuffle(false);
        startActivity(new Intent(getActivity(), my/googlemusic/play/activities/PlayerActivity));
    }





/*
    static List access$1302(FavoritesFragment favoritesfragment, List list)
    {
        favoritesfragment.mFavoriteList = list;
        return list;
    }

*/







/*
    static Player access$1902(FavoritesFragment favoritesfragment, Player player)
    {
        favoritesfragment.mPlayer = player;
        return player;
    }

*/



/*
    static boolean access$2002(FavoritesFragment favoritesfragment, boolean flag)
    {
        favoritesfragment.mBound = flag;
        return flag;
    }

*/

    // Unreferenced inner class my/googlemusic/play/fragments/manager/library/FavoritesFragment$DataTask
    /* block-local class not found */
    class DataTask {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls5 {}

}
