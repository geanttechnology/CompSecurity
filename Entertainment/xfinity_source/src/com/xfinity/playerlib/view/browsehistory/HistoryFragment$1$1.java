// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browsehistory;

import com.comcast.cim.cmasl.taskexecutor.task.NonCachingBaseTask;
import com.xfinity.playerlib.bookmarks.Bookmark;
import com.xfinity.playerlib.bookmarks.LiveStreamBookmark;
import com.xfinity.playerlib.model.database.CachingVideoBookmarkDAO;
import com.xfinity.playerlib.model.database.LiveStreamBookmarkDAO;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.browsehistory:
//            HistoryFragment

class this._cls1
    implements Comparator
{

    final compare this$1;

    public int compare(Bookmark bookmark, Bookmark bookmark1)
    {
        return bookmark1.getTimestamp().compareTo(bookmark.getTimestamp());
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((Bookmark)obj, (Bookmark)obj1);
    }

    nit>()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/xfinity/playerlib/view/browsehistory/HistoryFragment$1

/* anonymous class */
    class HistoryFragment._cls1 extends NonCachingBaseTask
    {

        final HistoryFragment this$0;

        public volatile Object execute()
        {
            return execute();
        }

        public List execute()
        {
            ArrayList arraylist = new ArrayList();
            for (Iterator iterator = HistoryFragment.access$000(HistoryFragment.this).getRecentBookmarks().iterator(); iterator.hasNext(); arraylist.add((Bookmark)iterator.next())) { }
            Iterator iterator1 = HistoryFragment.access$100(HistoryFragment.this).getRecentBookmarks().iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                Bookmark bookmark = (Bookmark)iterator1.next();
                if (((PlayerUserSettings)HistoryFragment.access$200(HistoryFragment.this).getUserSettings()).getWantsAdultContent() || !((LiveStreamBookmark)bookmark).isAdultContent())
                {
                    arraylist.add(bookmark);
                }
            } while (true);
            Collections.sort(arraylist, new HistoryFragment._cls1._cls1());
            return arraylist;
        }

            
            {
                this$0 = HistoryFragment.this;
                super();
            }
    }

}
