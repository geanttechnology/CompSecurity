// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package twitter4j:
//            AsyncTwitterImpl, Twitter, TwitterListener, TwitterMethod

class yncTask extends yncTask
{

    final AsyncTwitterImpl this$0;

    public void invoke(List list)
    {
        ResponseList responselist = AsyncTwitterImpl.access$000(AsyncTwitterImpl.this).getHomeTimeline();
        for (list = list.iterator(); list.hasNext();)
        {
            TwitterListener twitterlistener = (TwitterListener)list.next();
            try
            {
                twitterlistener.gotHomeTimeline(responselist);
            }
            catch (Exception exception) { }
        }

    }

    yncTask(TwitterMethod twittermethod, List list)
    {
        this$0 = AsyncTwitterImpl.this;
        super(AsyncTwitterImpl.this, twittermethod, list);
    }
}
