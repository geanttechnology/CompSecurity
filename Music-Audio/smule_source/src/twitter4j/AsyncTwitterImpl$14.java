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
    final String val$statusText;

    public void invoke(List list)
    {
        Status status = AsyncTwitterImpl.access$000(AsyncTwitterImpl.this).updateStatus(val$statusText);
        for (list = list.iterator(); list.hasNext();)
        {
            TwitterListener twitterlistener = (TwitterListener)list.next();
            try
            {
                twitterlistener.updatedStatus(status);
            }
            catch (Exception exception) { }
        }

    }

    ncTask(List list, String s)
    {
        this$0 = final_asynctwitterimpl;
        val$statusText = s;
        super(final_asynctwitterimpl, TwitterMethod.this, list);
    }
}
