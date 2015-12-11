// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.favorite;

import com.comcast.cim.cmasl.taskexecutor.task.NonCachingBaseTask;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.utils.container.Tuple4;
import com.xfinity.playerlib.bookmarks.LiveStreamBookmark;
import com.xfinity.playerlib.model.Favorite;
import com.xfinity.playerlib.model.LiveStreamFavorite;
import com.xfinity.playerlib.model.database.FavoriteDAO;
import com.xfinity.playerlib.model.database.LiveStreamBookmarkDAO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.favorite:
//            BookmarksFragment

class this._cls1
    implements Comparator
{

    final compare this$1;

    public int compare(Favorite favorite, Favorite favorite1)
    {
        return favorite1.getCreated().compareTo(favorite.getCreated());
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((Favorite)obj, (Favorite)obj1);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/xfinity/playerlib/view/favorite/BookmarksFragment$1

/* anonymous class */
    class BookmarksFragment._cls1 extends NonCachingBaseTask
    {

        final BookmarksFragment this$0;

        public Tuple4 execute()
        {
            ArrayList arraylist = new ArrayList();
            arraylist.addAll(BookmarksFragment.access$000(BookmarksFragment.this).getAllFavorite());
            for (Iterator iterator = BookmarksFragment.access$100(BookmarksFragment.this).getFavorites().iterator(); iterator.hasNext(); arraylist.add(new LiveStreamFavorite((LiveStreamBookmark)iterator.next()))) { }
            Collections.sort(arraylist, new BookmarksFragment._cls1._cls1());
            return new Tuple4(BookmarksFragment.access$200(BookmarksFragment.this).execute(), BookmarksFragment.access$300(BookmarksFragment.this).execute(), BookmarksFragment.access$400(BookmarksFragment.this).execute(), arraylist);
        }

        public volatile Object execute()
        {
            return execute();
        }

            
            {
                this$0 = BookmarksFragment.this;
                super();
            }
    }

}
