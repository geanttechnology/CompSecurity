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
    final String val$screenName;
    final String val$text;

    public void invoke(List list)
    {
        DirectMessage directmessage = AsyncTwitterImpl.access$000(AsyncTwitterImpl.this).sendDirectMessage(val$screenName, val$text);
        for (list = list.iterator(); list.hasNext();)
        {
            TwitterListener twitterlistener = (TwitterListener)list.next();
            try
            {
                twitterlistener.sentDirectMessage(directmessage);
            }
            catch (Exception exception) { }
        }

    }

    ncTask(String s, String s1)
    {
        this$0 = final_asynctwitterimpl;
        val$screenName = s;
        val$text = s1;
        super(final_asynctwitterimpl, final_twittermethod, List.this);
    }
}
