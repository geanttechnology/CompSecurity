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

    public void invoke(List list)
    {
        User user = AsyncTwitterImpl.access$000(AsyncTwitterImpl.this).createMute(val$screenName);
        for (list = list.iterator(); list.hasNext();)
        {
            TwitterListener twitterlistener = (TwitterListener)list.next();
            try
            {
                twitterlistener.createdMute(user);
            }
            catch (Exception exception) { }
        }

    }

    ncTask(List list, String s)
    {
        this$0 = final_asynctwitterimpl;
        val$screenName = s;
        super(final_asynctwitterimpl, TwitterMethod.this, list);
    }
}
