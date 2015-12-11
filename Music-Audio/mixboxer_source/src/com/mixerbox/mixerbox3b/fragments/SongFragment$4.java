// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.view.View;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            SongFragment

class this._cls0
    implements android.view.tener
{

    final SongFragment this$0;

    public void onClick(View view)
    {
        view = currentPlaylist.getPlaylistId();
        VectorFragment vectorfragment = ((MainPage)getActivity()).setVector(view, "dj", 1, "");
        MixerBoxUtils.getSubsInfo(getActivity(), view, vectorfragment);
    }

    ()
    {
        this$0 = SongFragment.this;
        super();
    }
}
