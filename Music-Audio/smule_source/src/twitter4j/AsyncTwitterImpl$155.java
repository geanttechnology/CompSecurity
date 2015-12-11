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
    final String val$callbackURL;
    final String val$xAuthAccessType;
    final String val$xAuthMode;

    public void invoke(List list)
    {
        twitter4j.auth.RequestToken requesttoken = AsyncTwitterImpl.access$000(AsyncTwitterImpl.this).getOAuthRequestToken(val$callbackURL, val$xAuthAccessType, val$xAuthMode);
        for (list = list.iterator(); list.hasNext();)
        {
            TwitterListener twitterlistener = (TwitterListener)list.next();
            try
            {
                twitterlistener.gotOAuthRequestToken(requesttoken);
            }
            catch (Exception exception) { }
        }

    }

    cTask(String s1, String s2)
    {
        this$0 = final_asynctwitterimpl;
        val$callbackURL = String.this;
        val$xAuthAccessType = s1;
        val$xAuthMode = s2;
        super(final_asynctwitterimpl, final_twittermethod, final_list);
    }
}
