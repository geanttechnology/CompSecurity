// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.lucasr.smoothie;

import android.os.Handler;
import android.os.Process;
import java.lang.ref.SoftReference;
import java.util.Map;

// Referenced classes of package org.lucasr.smoothie:
//            ItemLoader

private static final class mRequest
    implements Runnable
{

    private final ItemLoader mItemLoader;
    private final mRequest mRequest;

    public mRequest getItemRequest()
    {
        return mRequest;
    }

    public void run()
    {
        Process.setThreadPriority(10);
        ItemLoader.access$000(mItemLoader).remove(mRequest.mRequest);
        if (!ItemLoader.access$100(mItemLoader, mRequest))
        {
            Object obj = mItemLoader.loadItemPart(mRequest.arams, mRequest.art.intValue());
            mRequest.t = new SoftReference(obj);
            if (mRequest.iew != null && !ItemLoader.access$100(mItemLoader, mRequest))
            {
                ItemLoader.access$200(mItemLoader).post(new le(mItemLoader, mRequest, false));
                return;
            }
        }
    }

    public le(ItemLoader itemloader, le le)
    {
        mItemLoader = itemloader;
        mRequest = le;
    }
}
