// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package twitter4j:
//            AsyncTwitterImpl, Twitter, TwitterListener, GeoQuery, 
//            TwitterMethod

class cTask extends cTask
{

    final AsyncTwitterImpl this$0;
    final GeoQuery val$query;

    public void invoke(List list)
    {
        ResponseList responselist = AsyncTwitterImpl.access$000(AsyncTwitterImpl.this).searchPlaces(val$query);
        for (list = list.iterator(); list.hasNext();)
        {
            TwitterListener twitterlistener = (TwitterListener)list.next();
            try
            {
                twitterlistener.searchedPlaces(responselist);
            }
            catch (Exception exception) { }
        }

    }

    cTask(List list, GeoQuery geoquery)
    {
        this$0 = final_asynctwitterimpl;
        val$query = geoquery;
        super(final_asynctwitterimpl, TwitterMethod.this, list);
    }
}
