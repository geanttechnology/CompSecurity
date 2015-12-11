// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.view.View;
import android.widget.AdapterView;
import com.comcast.cim.cmasl.utils.CommonUtils;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            LiveStreamsFragment

class this._cls0
    implements android.widget.nLiveStreamClickedListener
{

    final LiveStreamsFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (HalLiveStream)CommonUtils.uncheckedCast(adapterview.getItemAtPosition(i));
        LiveStreamsFragment.access$1100(LiveStreamsFragment.this, adapterview, null);
    }

    ()
    {
        this$0 = LiveStreamsFragment.this;
        super();
    }
}
