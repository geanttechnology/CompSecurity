// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package twitter4j:
//            AsyncTwitterImpl, Twitter, TwitterListener, TwitterMethod

class cTask extends cTask
{

    final AsyncTwitterImpl this$0;
    final long val$ownerId;
    final String val$slug;
    final long val$userId;

    public void invoke(List list)
    {
        UserList userlist = AsyncTwitterImpl.access$000(AsyncTwitterImpl.this).destroyUserListMember(val$ownerId, val$slug, val$userId);
        for (list = list.iterator(); list.hasNext();)
        {
            TwitterListener twitterlistener = (TwitterListener)list.next();
            try
            {
                twitterlistener.destroyedUserListMember(userlist);
            }
            catch (Exception exception) { }
        }

    }

    cTask(String s, long l1)
    {
        this$0 = final_asynctwitterimpl;
        val$ownerId = J.this;
        val$slug = s;
        val$userId = l1;
        super(final_asynctwitterimpl, final_twittermethod, final_list);
    }
}
