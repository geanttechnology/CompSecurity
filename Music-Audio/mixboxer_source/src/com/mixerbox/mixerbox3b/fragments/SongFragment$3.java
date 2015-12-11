// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.mixerbox.mixerbox3b.utils.MixerBoxSQLite;
import com.mixerbox.mixerbox3b.utils.MixerBoxSharedPreferences;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import java.util.ArrayList;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            SongFragment, PlaylistsFragment

class this._cls0
    implements android.view.tener
{

    final SongFragment this$0;

    public void onClick(View view)
    {
        if (btnAdd.getText().toString().equals(getActivity().getResources().getString(0x7f0800e7)))
        {
            ((MainPage)getActivity()).subscribePlaylist(currentPlaylist, true);
            btnAdd.setText(getActivity().getResources().getString(0x7f0800e8));
        } else
        {
            if (btnAdd.getText().toString().equals(getActivity().getResources().getString(0x7f0800e8)))
            {
                if (((MainPage)getActivity()).isLogIn)
                {
                    MixerBoxUtils.unsubsPlaylist((MainPage)getActivity(), currentPlaylist.getPlaylistId());
                } else
                {
                    ((MainPage)getActivity()).DB.deletePlaylist(currentPlaylist.getPlaylistId());
                    ((MainPage)getActivity()).mySubscriptions.remove(currentPlaylist.getPlaylistId());
                    ((MainPage)getActivity()).fragmentPlaylists.loadContent();
                }
                btnAdd.setText(getActivity().getResources().getString(0x7f0800e7));
                return;
            }
            if (btnAdd.getText().toString().equals(getActivity().getResources().getString(0x7f080097)))
            {
                view = ((MainPage)getActivity()).menu.findItem(999);
                if (view != null)
                {
                    view.expandActionView();
                    MixerBoxSharedPreferences.putDefaultAddedPlaylist(getActivity(), currentPlaylist.getPlaylistId(), currentPlaylist.getPlaylistName());
                }
                if (!MixerBoxSharedPreferences.getTipFirstAddMusic(getActivity()))
                {
                    ((MainPage)getActivity()).setOnboardingGuide(8, new boolean[0]);
                    return;
                }
            }
        }
    }

    rences()
    {
        this$0 = SongFragment.this;
        super();
    }
}
