// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.view.View;
import android.widget.AdapterView;
import com.comcast.cim.android.view.launch.AuthenticatingFragment;
import com.comcast.cim.cmasl.utils.CommonUtils;
import com.xfinity.playerlib.bookmarks.LiveStreamBookmark;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;
import com.xfinity.playerlib.view.favorite.BookmarkUtils;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            LiveStreamsFragment

class fragment
    implements android.widget.eStreamLongClickedListener
{

    private AuthenticatingFragment fragment;
    final LiveStreamsFragment this$0;

    public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (HalLiveStream)CommonUtils.uncheckedCast(adapterview.getItemAtPosition(i));
        boolean flag1 = false;
        view = LiveStreamsFragment.access$1600(LiveStreamsFragment.this).iterator();
        boolean flag;
        do
        {
            flag = flag1;
            if (!view.hasNext())
            {
                break;
            }
            if (!((LiveStreamBookmark)view.next()).getStreamId().equals(adapterview.getStreamId()))
            {
                continue;
            }
            flag = true;
            break;
        } while (true);
        bookmarkUtils.promptBookmarkDialog(fragment, adapterview, flag, new <init>(LiveStreamsFragment.this, null));
        return true;
    }

    public (AuthenticatingFragment authenticatingfragment)
    {
        this$0 = LiveStreamsFragment.this;
        super();
        fragment = authenticatingfragment;
    }
}
