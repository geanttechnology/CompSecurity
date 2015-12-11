// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import com.xfinity.playerlib.bookmarks.LiveStreamBookmark;
import com.xfinity.playerlib.view.favorite.BookmarkEventListener;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            LiveStreamsFragment

private class <init>
    implements BookmarkEventListener
{

    final LiveStreamsFragment this$0;

    public void onLiveStreamBookmarkAdded(LiveStreamBookmark livestreambookmark)
    {
        LiveStreamsFragment.access$1600(LiveStreamsFragment.this).add(livestreambookmark);
    }

    public void onLiveStreamBookmarkDeleted(String s)
    {
        Iterator iterator = LiveStreamsFragment.access$1600(LiveStreamsFragment.this).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (!((LiveStreamBookmark)iterator.next()).getStreamId().equals(s))
            {
                continue;
            }
            iterator.remove();
            break;
        } while (true);
    }

    private ()
    {
        this$0 = LiveStreamsFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
