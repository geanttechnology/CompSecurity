// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.fragments.player;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.Gson;
import java.util.List;
import my.googlemusic.play.activities.AlbumActivity;
import my.googlemusic.play.activities.ArtistActivity;
import my.googlemusic.play.activities.PlayerActivity;
import my.googlemusic.play.adapters.player.QueueAdapter;
import my.googlemusic.play.advertising.InterstitialManager;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Player;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Artist;
import my.googlemusic.play.model.Song;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.dialog.DialogSkipUser;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;

public class QueueFragment extends Fragment
    implements my.googlemusic.play.adapters.player.QueueAdapter.OnSongListener, android.view.View.OnClickListener
{

    public static final String MENU_ADD_TO_FAVORITES = "Add to Favorites";
    public static final String MENU_ALBUM = "Go to Album";
    public static final String MENU_ARTIST = "Go to Artist";
    public static final String MENU_DOWNLOAD = "Download";
    public static final String MENU_RINGTONE = "Set this song as ringtone";
    public static final String MENU_TWITTER = "Share on Twitter";
    private boolean downloadClicked;
    private QueueAdapter mAdapter;
    private BroadcastReceiver mBroadcastReceiver;
    private ViewHolder mHolder;
    private Player mPlayer;
    private Server mServer;
    private Song mSongSelected;

    public QueueFragment()
    {
        mBroadcastReceiver = new _cls6();
    }

    private void initAds()
    {
    }

    private void initData()
    {
        mServer = ((App)getActivity().getApplication()).getServer();
    }

    private void initQueue()
    {
        if (mHolder != null && mPlayer != null && mPlayer.getPlaylist() != null)
        {
            mAdapter = new QueueAdapter(getActivity(), mServer, mPlayer.getPlaylist(), this);
            mAdapter.enableHeader(true);
    /* block-local class not found */
    class ViewHolder {}

            mHolder.recyclerView.setAdapter(mAdapter);
            mAdapter.setSongPlaying(mPlayer.getCurrentTrack());
            mAdapter.notifyDataSetChanged();
        }
    }

    private void initView(View view)
    {
        mHolder = new ViewHolder(null);
        mHolder.loading = view.findViewById(0x7f0d019b);
        mHolder.recyclerView = (RecyclerView)view.findViewById(0x7f0d0262);
        mHolder.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        registerForContextMenu(mHolder.recyclerView);
    }

    public static Fragment newInstance()
    {
        return new QueueFragment();
    }

    private void onAlbumMenu()
    {
        Intent intent = new Intent(getActivity(), my/googlemusic/play/activities/AlbumActivity);
        intent.putExtra("album", App.getGson().toJson(mSongSelected.getAlbum()));
        startActivity(intent);
        getActivity().finish();
    }

    private void onArtistMenu()
    {
        Intent intent = new Intent(getActivity(), my/googlemusic/play/activities/ArtistActivity);
        intent.putExtra("artist", mSongSelected.getAlbum().getArtist());
        startActivity(intent);
        getActivity().finish();
    }

    private void onDownloadMenu()
    {
        onSongDownload(mSongSelected);
    }

    private void onFavoriteMenu()
    {
        if (mServer.getUser().isSkip())
        {
            (new DialogSkipUser()).show(getActivity().getSupportFragmentManager(), null);
            return;
        }
        if (mServer.isStreaming(mSongSelected.getAlbum().getId()))
        {
            Toast.with(getActivity()).message("Stream only albums can\u2019t be favorited").show();
            return;
        } else
        {
            mServer.addFavorite(mSongSelected, new _cls5());
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
            mServer.setRingtoner(mServer.getDownload(mSongSelected.getId()), getActivity(), new _cls4());
            return;
        }
    }

    private void onShareTwitter()
    {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append("I'm listening to ").append(mPlayer.getCurrentSong().getAlbum().getArtist().getName()).append("'s ").append(mPlayer.getCurrentSong().getName()).append(" on My Mixtapez app http://goo.gl/7dQT59").toString());
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

    private void onSongDownloadAll()
    {
        Toast.with(getActivity()).message("Downloading now").show();
        mServer.addDownload(mPlayer.getPlaylist(), new _cls3());
        if (!mServer.getUser().isPremium() && !downloadClicked)
        {
            InterstitialManager.loadmmdev(getActivity(), true);
            downloadClicked = true;
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        mPlayer = ((PlayerActivity)activity).getPlayer();
        initQueue();
    }

    public void onClick(View view)
    {
        if (view.getId() == 0x7f0d02d6)
        {
            onSongDownloadAll();
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
        if (menuitem.getTitle().equals("Add to Favorites"))
        {
            onFavoriteMenu();
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
            onShareTwitter();
        } else
        if (menuitem.getTitle().equals("Set this song as ringtone"))
        {
            onRingtoneMenu();
        }
        if (true) goto _L4; else goto _L3
_L3:
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
        if (!mServer.isFavorited(mSongSelected))
        {
            contextmenu.add("Add to Favorites");
        }
        contextmenu.add("Go to Album");
        contextmenu.add("Go to Artist");
        contextmenu.add("Share on Twitter");
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030071, viewgroup, false);
        initData();
        initView(layoutinflater);
        initQueue();
        initAds();
        return layoutinflater;
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

    public void onSongDownload(Song song)
    {
        if (mServer.isStreaming(song.getAlbum().getId()))
        {
            mServer.requestStore(new _cls1(), song.getAlbum().getId());
            return;
        } else
        {
            mServer.addDownload(song, new _cls2());
            return;
        }
    }

    public void onSongMore(Song song)
    {
        mSongSelected = song;
        mHolder.recyclerView.showContextMenu();
    }

    public void onSongPlay(int i)
    {
        if (mPlayer != null)
        {
            mPlayer.play(i);
        }
    }



    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
