// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package twitter4j:
//            AsyncTwitterImpl, Twitter, TwitterListener, TwitterMethod

class ncTask extends ncTask
{

    final AsyncTwitterImpl this$0;
    final String val$sourceScreenName;
    final String val$targetScreenName;

    public void invoke(List list)
    {
        Relationship relationship = AsyncTwitterImpl.access$000(AsyncTwitterImpl.this).showFriendship(val$sourceScreenName, val$targetScreenName);
        for (list = list.iterator(); list.hasNext();)
        {
            TwitterListener twitterlistener = (TwitterListener)list.next();
            try
            {
                twitterlistener.gotShowFriendship(relationship);
            }
            catch (Exception exception) { }
        }

    }

    ncTask(String s, String s1)
    {
        this$0 = final_asynctwitterimpl;
        val$sourceScreenName = s;
        val$targetScreenName = s1;
        super(final_asynctwitterimpl, final_twittermethod, List.this);
    }
}
