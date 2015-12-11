// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.os.Handler;
import android.util.Log;
import co.vine.android.client.VineAPI;
import co.vine.android.network.HttpOperation;
import co.vine.android.network.ThreadedHttpOperationClient;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package co.vine.android.util:
//            UrlResourceCache, Util, UrlResource

private class mWorkQueue
    implements Runnable
{

    private final long mOwnerId;
    private final HashMap mWorkQueue;
    final UrlResourceCache this$0;

    public void run()
    {
        HashMap hashmap = mWorkQueue;
        if (UrlResourceCache.LOGGABLE)
        {
            Log.d("ResourceCache", (new StringBuilder()).append("Queueing ").append(hashmap.size()).toString());
        }
        if (!hashmap.isEmpty())
        {
            HashMap hashmap1 = new HashMap(hashmap.size());
            ThreadedHttpOperationClient threadedhttpoperationclient = ThreadedHttpOperationClient.getInstance(mContext);
            Iterator iterator = hashmap.entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (java.util.ntext)iterator.next();
                Object obj2 = ((java.util.ntext) (obj)).ntext();
                Object obj1 = (getInstance)((java.util.dingRes) (obj)).dingRes();
                String s = ((getInstance) (obj1)).;
                obj = loadResource(mOwnerId, obj2, s);
                if (obj != null)
                {
                    hashmap1.put(obj2, obj);
                } else
                {
                    if (UrlResourceCache.LOGGABLE)
                    {
                        Log.d("ResourceCache", (new StringBuilder()).append("Fetch ").append(s).toString());
                    }
                    if (Util.parseURI(s) != null)
                    {
                        obj1 = new erationReader(UrlResourceCache.this, mOwnerId, obj2, s, ((mOwnerId) (obj1)).sist);
                        if (HttpOperation.createResourceGetRequest(threadedhttpoperationclient, new StringBuilder(s), VineAPI.getInstance(mContext), ((co.vine.android.network.HttpOperationReader) (obj1))).execute().isOK())
                        {
                            obj = ((erationReader) (obj1)).getResultResource();
                        }
                        obj1 = obj;
                        if (obj == null)
                        {
                            obj1 = instantiateResource(obj2, s, null);
                            obj1.nextRequestTime = System.currentTimeMillis() + 60000L;
                        }
                        hashmap1.put(obj2, obj1);
                    }
                }
            } while (true);
            UrlResourceCache.access$000().post(new (UrlResourceCache.this, hashmap1));
        }
    }

    public (long l, HashMap hashmap)
    {
        this$0 = UrlResourceCache.this;
        super();
        mOwnerId = l;
        mWorkQueue = hashmap;
    }
}
