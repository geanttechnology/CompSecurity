// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package twitter4j:
//            AsyncTwitterImpl, Twitter, TwitterListener, Paging, 
//            TwitterMethod

class ncTask extends ncTask
{

    final AsyncTwitterImpl this$0;
    final Paging val$paging;
    final String val$screenName;

    public void invoke(List list)
    {
        ResponseList responselist = AsyncTwitterImpl.access$000(AsyncTwitterImpl.this).getFavorites(val$screenName, val$paging);
        for (list = list.iterator(); list.hasNext();)
        {
            TwitterListener twitterlistener = (TwitterListener)list.next();
            try
            {
                twitterlistener.gotFavorites(responselist);
            }
            catch (Exception exception) { }
        }

    }

    ncTask(String s, Paging paging1)
    {
        this$0 = final_asynctwitterimpl;
        val$screenName = s;
        val$paging = paging1;
        super(final_asynctwitterimpl, final_twittermethod, List.this);
    }
}
