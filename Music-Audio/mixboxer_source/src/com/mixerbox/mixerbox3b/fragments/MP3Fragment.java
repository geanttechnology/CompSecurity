// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.mixerbox.mixerbox3b.adapters.PlaylistAdapter;
import com.mixerbox.mixerbox3b.adapters.SongAdapter;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.mixerbox.mixerbox3b.classes.SongItem;
import java.util.ArrayList;

public class MP3Fragment extends Fragment
{

    ArrayList arrayAlbum;
    ArrayList arrayArtist;
    ArrayList arrayPlaylist;
    ArrayList arraySong;
    public PullToRefreshListView lvAlbum;
    public PullToRefreshListView lvArtist;
    public PullToRefreshListView lvPlaylist;
    public PullToRefreshListView lvSong;
    public String q;
    android.widget.TabHost.TabSpec tabAlbums;
    android.widget.TabHost.TabSpec tabArtists;
    public TabHost tabHost;
    android.widget.TabHost.TabSpec tabPlaylists;
    android.widget.TabHost.TabSpec tabSongs;
    View v;

    public MP3Fragment()
    {
    }

    private String getCoverOfArtist(String s)
    {
        s = getActivity().getContentResolver().query(android.provider.MediaStore.Audio.Artists.Albums.getContentUri("external", Long.valueOf(s).longValue()), new String[] {
            "album_art"
        }, null, null, null);
        int j = s.getCount();
        if (j > 0)
        {
            s.moveToFirst();
            for (int i = 0; i < j; i++)
            {
                if (s.getString(0) != null)
                {
                    String s1 = (new StringBuilder()).append("file://").append(s.getString(0)).toString();
                    s.close();
                    return s1;
                }
                s.moveToNext();
            }

        }
        s.close();
        return "";
    }

    private String getCoverOfPlaylist(String s)
    {
        s = android.provider.MediaStore.Audio.Playlists.Members.getContentUri("external", Long.valueOf(s).longValue());
        s = getActivity().getContentResolver().query(s, new String[] {
            "album_id"
        }, "is_music != 0 ", null, null);
        int j = s.getCount();
        if (j <= 0) goto _L2; else goto _L1
_L1:
        s.moveToFirst();
        int i = 0;
_L3:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        String s1;
        Uri uri = ContentUris.withAppendedId(Uri.parse("content://media/external/audio/albumart"), Long.valueOf(s.getString(0)).longValue());
        s1 = uri.toString();
        if (getActivity().getContentResolver().openFileDescriptor(uri, "r") == null)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        s.close();
        if (s != null)
        {
            s.close();
        }
        return s1;
        s.moveToNext();
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        if (s != null)
        {
            s.close();
        }
_L5:
        return "";
        s;
        s = null;
_L8:
        if (s != null)
        {
            s.close();
        }
        if (true) goto _L5; else goto _L4
_L4:
        Object obj;
        obj;
        s = null;
_L7:
        if (s != null)
        {
            s.close();
        }
        throw obj;
        obj;
        if (true) goto _L7; else goto _L6
_L6:
        obj;
          goto _L8
    }

    private void loadAlbum()
    {
        arrayAlbum = new ArrayList();
        Object obj = getActivity().getContentResolver().query(android.provider.MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI, new String[] {
            "_id", "album", "album_art", "artist", "numsongs"
        }, null, null, null);
        int j = ((Cursor) (obj)).getCount();
        if (j > 0)
        {
            ((Cursor) (obj)).moveToFirst();
            for (int i = 0; i < j; i++)
            {
                String s = (new StringBuilder()).append("file://").append(((Cursor) (obj)).getString(2)).toString();
                arrayAlbum.add(new PlaylistItem("PLAYLISTMP3ALBUMID", ((Cursor) (obj)).getString(1), ((Cursor) (obj)).getString(0), ((Cursor) (obj)).getString(3), ((Cursor) (obj)).getString(4), "0", s, 8, false));
                ((Cursor) (obj)).moveToNext();
            }

        }
        ((Cursor) (obj)).close();
        obj = new PlaylistAdapter(getActivity(), arrayAlbum);
        lvAlbum.setAdapter(((android.widget.ListAdapter) (obj)));
    }

    private void loadArtist()
    {
        arrayArtist = new ArrayList();
        Object obj = getActivity().getContentResolver().query(android.provider.MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI, new String[] {
            "_id", "artist", "number_of_tracks"
        }, null, null, null);
        int j = ((Cursor) (obj)).getCount();
        if (j > 0)
        {
            ((Cursor) (obj)).moveToFirst();
            for (int i = 0; i < j; i++)
            {
                String s = getCoverOfArtist(((Cursor) (obj)).getString(0));
                arrayArtist.add(new PlaylistItem("PLAYLISTMP3ARTISTID", ((Cursor) (obj)).getString(1), ((Cursor) (obj)).getString(0), "", ((Cursor) (obj)).getString(2), "0", s, 8, false));
                ((Cursor) (obj)).moveToNext();
            }

        }
        ((Cursor) (obj)).close();
        obj = new PlaylistAdapter(getActivity(), arrayArtist);
        lvArtist.setAdapter(((android.widget.ListAdapter) (obj)));
    }

    private void loadPlaylist()
    {
        arrayPlaylist = new ArrayList();
        Object obj = getActivity().getContentResolver().query(android.provider.MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI, new String[] {
            "_id", "name", "_data"
        }, null, null, null);
        int j = ((Cursor) (obj)).getCount();
        if (j > 0)
        {
            ((Cursor) (obj)).moveToFirst();
            for (int i = 0; i < j; i++)
            {
                String s = getCoverOfPlaylist(((Cursor) (obj)).getString(0));
                arrayPlaylist.add(new PlaylistItem("PLAYLISTMP3PLAYLISTID", ((Cursor) (obj)).getString(1), ((Cursor) (obj)).getString(0), "", "", "0", s, 8, false));
                ((Cursor) (obj)).moveToNext();
            }

        }
        ((Cursor) (obj)).close();
        obj = new PlaylistAdapter(getActivity(), arrayPlaylist);
        lvPlaylist.setAdapter(((android.widget.ListAdapter) (obj)));
    }

    private void loadSong()
    {
        arraySong = new ArrayList();
        Object obj = getActivity().getContentResolver().query(android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[] {
            "album_id", "title", "duration", "_data", "artist"
        }, "is_music != 0", null, null);
        int j = ((Cursor) (obj)).getCount();
        if (j <= 0) goto _L2; else goto _L1
_L1:
        ((Cursor) (obj)).moveToFirst();
        int i = 0;
_L3:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        arraySong.add(new SongItem(((Cursor) (obj)).getString(0), (new StringBuilder()).append(((Cursor) (obj)).getString(4)).append(" - ").append(((Cursor) (obj)).getString(1)).toString(), String.valueOf(Integer.valueOf(((Cursor) (obj)).getString(2)).intValue() / 1000), ((Cursor) (obj)).getString(3), i, 2, ""));
        ((Cursor) (obj)).moveToNext();
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
_L5:
        obj = new SongAdapter(getActivity(), arraySong, "PLAYLISTMP3ID");
        lvSong.setAdapter(((android.widget.ListAdapter) (obj)));
        return;
        obj;
        obj = null;
_L8:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        if (true) goto _L5; else goto _L4
_L4:
        Object obj1;
        obj1;
        obj = null;
_L7:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw obj1;
        obj1;
        if (true) goto _L7; else goto _L6
_L6:
        obj1;
          goto _L8
    }

    public void loadContent()
    {
label0:
        {
label1:
            {
                loadPlaylist();
                loadArtist();
                loadAlbum();
                loadSong();
                if (arrayPlaylist.size() == 0)
                {
                    if (arrayAlbum.size() != 0)
                    {
                        break label0;
                    }
                    if (arrayArtist.size() != 0)
                    {
                        break label1;
                    }
                    tabHost.setCurrentTab(3);
                }
                return;
            }
            tabHost.setCurrentTab(2);
            return;
        }
        tabHost.setCurrentTab(1);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        v = layoutinflater.inflate(0x7f03002e, viewgroup, false);
        lvPlaylist = (PullToRefreshListView)v.findViewById(0x7f07006a);
        lvArtist = (PullToRefreshListView)v.findViewById(0x7f07006c);
        lvAlbum = (PullToRefreshListView)v.findViewById(0x7f07006e);
        lvSong = (PullToRefreshListView)v.findViewById(0x7f070070);
        lvPlaylist.getLoadingLayoutProxy().setPullLabel(getActivity().getResources().getString(0x7f0800dd));
        lvPlaylist.getLoadingLayoutProxy().setReleaseLabel(getActivity().getResources().getString(0x7f0800b6));
        lvPlaylist.getLoadingLayoutProxy().setRefreshingLabel(getActivity().getResources().getString(0x7f080074));
        lvArtist.getLoadingLayoutProxy().setPullLabel(getActivity().getResources().getString(0x7f0800dd));
        lvArtist.getLoadingLayoutProxy().setReleaseLabel(getActivity().getResources().getString(0x7f0800b6));
        lvArtist.getLoadingLayoutProxy().setRefreshingLabel(getActivity().getResources().getString(0x7f080074));
        lvAlbum.getLoadingLayoutProxy().setPullLabel(getActivity().getResources().getString(0x7f0800dd));
        lvAlbum.getLoadingLayoutProxy().setReleaseLabel(getActivity().getResources().getString(0x7f0800b6));
        lvAlbum.getLoadingLayoutProxy().setRefreshingLabel(getActivity().getResources().getString(0x7f080074));
        lvSong.getLoadingLayoutProxy().setPullLabel(getActivity().getResources().getString(0x7f0800dd));
        lvSong.getLoadingLayoutProxy().setReleaseLabel(getActivity().getResources().getString(0x7f0800b6));
        lvSong.getLoadingLayoutProxy().setRefreshingLabel(getActivity().getResources().getString(0x7f080074));
        tabHost = (TabHost)v.findViewById(0x7f070068);
        tabHost.setup();
        tabHost.addTab(tabHost.newTabSpec(getActivity().getResources().getString(0x7f080085)).setIndicator(getActivity().getResources().getString(0x7f080085)).setContent(0x7f070069));
        tabHost.addTab(tabHost.newTabSpec(getActivity().getResources().getString(0x7f080126)).setIndicator(getActivity().getResources().getString(0x7f080126)).setContent(0x7f07006d));
        tabHost.addTab(tabHost.newTabSpec(getActivity().getResources().getString(0x7f080127)).setIndicator(getActivity().getResources().getString(0x7f080127)).setContent(0x7f07006b));
        tabHost.addTab(tabHost.newTabSpec(getActivity().getResources().getString(0x7f080097)).setIndicator(getActivity().getResources().getString(0x7f080097)).setContent(0x7f07006f));
        tabHost.setBackgroundResource(0x7f020128);
        lvSong.setOnItemClickListener(new _cls1());
        lvAlbum.setOnItemClickListener(new _cls2());
        lvArtist.setOnItemClickListener(new _cls3());
        lvPlaylist.setOnItemClickListener(new _cls4());
        layoutinflater = new android.widget.LinearLayout.LayoutParams(-1, -1);
        lvPlaylist.setLayoutParams(layoutinflater);
        lvArtist.setLayoutParams(layoutinflater);
        lvAlbum.setLayoutParams(layoutinflater);
        lvSong.setLayoutParams(layoutinflater);
        return v;
    }

    private class _cls1
        implements android.widget.AdapterView.OnItemClickListener
    {

        final MP3Fragment this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            adapterview = (SongItem)((ListView)lvSong.getRefreshableView()).getItemAtPosition(i);
            ((MainPage)getActivity()).arrayPlayingSong = new ArrayList(arraySong);
            ((MainPage)getActivity()).playingSong = adapterview;
            ((MainPage)getActivity()).playingPlaylist = new PlaylistItem("PLAYLISTMP3ID", getActivity().getResources().getString(0x7f080128), "", "", "0", "0", "", 8, false);
            ((MainPage)getActivity()).playingSongIndex = i - 1;
            ((MainPage)getActivity()).playMusic(true);
        }

        _cls1()
        {
            this$0 = MP3Fragment.this;
            super();
        }
    }


    private class _cls2
        implements android.widget.AdapterView.OnItemClickListener
    {

        final MP3Fragment this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            ((MainPage)getActivity()).arraySong.clear();
            view = (PlaylistItem)((ListView)lvAlbum.getRefreshableView()).getItemAtPosition(i);
            adapterview = ((MainPage)getActivity()).setSong(view.getPlaylistId());
            adapterview.currentPlaylist = view;
            view = (new StringBuilder()).append("album_id = ").append(((SongFragment) (adapterview)).currentPlaylist.getPlaylistOwnerId()).toString();
            MixerBoxUtils.loadMP3Song(getActivity(), false, adapterview, view, android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
        }

        _cls2()
        {
            this$0 = MP3Fragment.this;
            super();
        }
    }


    private class _cls3
        implements android.widget.AdapterView.OnItemClickListener
    {

        final MP3Fragment this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            ((MainPage)getActivity()).arraySong.clear();
            view = (PlaylistItem)((ListView)lvArtist.getRefreshableView()).getItemAtPosition(i);
            adapterview = ((MainPage)getActivity()).setSong(view.getPlaylistId());
            adapterview.currentPlaylist = view;
            view = (new StringBuilder()).append("artist_id = ").append(((SongFragment) (adapterview)).currentPlaylist.getPlaylistOwnerId()).toString();
            MixerBoxUtils.loadMP3Song(getActivity(), false, adapterview, view, android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
        }

        _cls3()
        {
            this$0 = MP3Fragment.this;
            super();
        }
    }


    private class _cls4
        implements android.widget.AdapterView.OnItemClickListener
    {

        final MP3Fragment this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            ((MainPage)getActivity()).arraySong.clear();
            view = (PlaylistItem)((ListView)lvPlaylist.getRefreshableView()).getItemAtPosition(i);
            adapterview = ((MainPage)getActivity()).setSong(view.getPlaylistId());
            adapterview.currentPlaylist = view;
            view = android.provider.MediaStore.Audio.Playlists.Members.getContentUri("external", Long.valueOf(view.getPlaylistOwnerId()).longValue());
            MixerBoxUtils.loadMP3Song(getActivity(), false, adapterview, "is_music != 0 ", view);
        }

        _cls4()
        {
            this$0 = MP3Fragment.this;
            super();
        }
    }

}
