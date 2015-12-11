// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.mixerbox.mixerbox3b.dialogs.LoginDialog;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            SongFragment

class this._cls0
    implements android.view.tener
{

    final SongFragment this$0;

    public void onClick(View view)
    {
        if (currentPlaylist.getPlaylistType() == 5)
        {
            (new LoginDialog(getActivity(), 8)).show();
            return;
        } else
        {
            view = currentPlaylist.getPlaylistName();
            String s = currentPlaylist.getPlaylistId();
            Object obj = new HashMap();
            ((Map) (obj)).put("id", s);
            FlurryAgent.logEvent("action:share_playlist", ((Map) (obj)));
            s = (new StringBuilder()).append("http://www.mixerbox.com/list/").append(s).toString();
            obj = (new StringBuilder()).append(getResources().getString(0x7f0800ba)).append(getResources().getString(0x7f0800b8)).toString();
            String s1 = getResources().getString(0x7f0800b9);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", (new StringBuilder()).append(((String) (obj))).append(view).append(s1).toString());
            intent.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(((String) (obj))).append(view).append(s1).append(s).toString());
            startActivity(Intent.createChooser(intent, null));
            return;
        }
    }

    ()
    {
        this$0 = SongFragment.this;
        super();
    }
}
