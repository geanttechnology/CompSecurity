// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.classes;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.dialogs.AlertDialogFactory;
import com.mixerbox.mixerbox3b.fragments.SongFragment;
import com.mixerbox.mixerbox3b.utils.MixerBoxClient;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b.classes:
//            PlaylistVectorItem, PlaylistItem

class this._cls0
    implements android.view.aylistVectorItem._cls1
{

    final PlaylistVectorItem this$0;

    public void onClick(View view)
    {
        if (PlaylistVectorItem.access$100(PlaylistVectorItem.this).isNull("isAlbum"))
        {
            break MISSING_BLOCK_LABEL_209;
        }
        view = Boolean.valueOf(PlaylistVectorItem.access$100(PlaylistVectorItem.this).getBoolean("isAlbum"));
_L1:
        view = new PlaylistItem(PlaylistVectorItem.access$100(PlaylistVectorItem.this).getString("ref"), PlaylistVectorItem.access$200(PlaylistVectorItem.this), "", PlaylistVectorItem.access$300(PlaylistVectorItem.this), PlaylistVectorItem.access$400(PlaylistVectorItem.this), "0", PlaylistVectorItem.access$500(PlaylistVectorItem.this), 3, view.booleanValue());
        if (!MixerBoxClient.isConnectingToInternet(PlaylistVectorItem.access$600(PlaylistVectorItem.this)))
        {
            AlertDialogFactory.NoNetworkAlertDialog((Activity)PlaylistVectorItem.access$600(PlaylistVectorItem.this)).show();
            return;
        }
        try
        {
            ((MainPage)PlaylistVectorItem.access$600(PlaylistVectorItem.this)).arraySong.clear();
            Object obj = ((MainPage)PlaylistVectorItem.access$600(PlaylistVectorItem.this)).setSong(view.getPlaylistId());
            obj.currentPlaylist = view;
            MixerBoxUtils.loadSong(PlaylistVectorItem.access$600(PlaylistVectorItem.this), view.getPlaylistId(), false, 1, 0, ((SongFragment) (obj)));
            obj = new HashMap();
            ((Map) (obj)).put("id", view.getPlaylistId());
            FlurryAgent.logEvent("action:playlist_play", ((Map) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
        }
        return;
        view = Boolean.valueOf(false);
          goto _L1
    }

    ()
    {
        this$0 = PlaylistVectorItem.this;
        super();
    }
}
