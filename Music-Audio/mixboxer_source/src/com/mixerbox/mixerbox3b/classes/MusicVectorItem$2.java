// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.classes;

import android.view.View;
import com.flurry.android.FlurryAgent;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.mixerbox.mixerbox3b.classes:
//            SongItem, MusicVectorItem

class this._cls0
    implements android.view.er
{

    final MusicVectorItem this$0;

    public void onClick(View view)
    {
        SongItem songitem = new SongItem(MusicVectorItem.access$100(MusicVectorItem.this), MusicVectorItem.access$200(MusicVectorItem.this), MusicVectorItem.access$300(MusicVectorItem.this), MusicVectorItem.access$400(MusicVectorItem.this), MusicVectorItem.access$500(MusicVectorItem.this), MusicVectorItem.access$600(MusicVectorItem.this), MusicVectorItem.access$700(MusicVectorItem.this));
        MixerBoxUtils.createPopupMenu(MusicVectorItem.access$800(MusicVectorItem.this), view, songitem, "", MusicVectorItem.access$900(MusicVectorItem.this));
        view = new HashMap();
        view.put("id", MusicVectorItem.access$100(MusicVectorItem.this));
        view.put("playlist", "");
        FlurryAgent.logEvent("action:music_edit", view);
    }

    ()
    {
        this$0 = MusicVectorItem.this;
        super();
    }
}
