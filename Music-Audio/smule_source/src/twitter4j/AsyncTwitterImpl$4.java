// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package twitter4j:
//            AsyncTwitterImpl, Twitter, TwitterListener, Paging, 
//            TwitterMethod

class yncTask extends yncTask
{

    final AsyncTwitterImpl this$0;
    final Paging val$paging;
    final long val$userId;

    public void invoke(List list)
    {
        ResponseList responselist = AsyncTwitterImpl.access$000(AsyncTwitterImpl.this).getUserTimeline(val$userId, val$paging);
        for (list = list.iterator(); list.hasNext();)
        {
            TwitterListener twitterlistener = (TwitterListener)list.next();
            try
            {
                twitterlistener.gotUserTimeline(responselist);
            }
            catch (Exception exception) { }
        }

    }

    yncTask(long l, Paging paging1)
    {
        this$0 = final_asynctwitterimpl;
        val$userId = l;
        val$paging = paging1;
        super(final_asynctwitterimpl, final_twittermethod, List.this);
    }
}
