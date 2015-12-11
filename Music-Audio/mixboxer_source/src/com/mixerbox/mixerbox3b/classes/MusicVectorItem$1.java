// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.classes;

import android.view.View;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;

// Referenced classes of package com.mixerbox.mixerbox3b.classes:
//            SongItem, MusicVectorItem

class this._cls0
    implements android.view.er
{

    final MusicVectorItem this$0;

    public void onClick(View view)
    {
        view = new SongItem(MusicVectorItem.access$100(MusicVectorItem.this), MusicVectorItem.access$200(MusicVectorItem.this), MusicVectorItem.access$300(MusicVectorItem.this), MusicVectorItem.access$400(MusicVectorItem.this), MusicVectorItem.access$500(MusicVectorItem.this), MusicVectorItem.access$600(MusicVectorItem.this), MusicVectorItem.access$700(MusicVectorItem.this));
        MixerBoxUtils.performSongAction(MusicVectorItem.access$800(MusicVectorItem.this), 1, view, "", MusicVectorItem.access$900(MusicVectorItem.this));
    }

    ()
    {
        this$0 = MusicVectorItem.this;
        super();
    }
}
