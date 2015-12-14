// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.lucasr.smoothie;

import android.view.View;
import java.lang.ref.SoftReference;

// Referenced classes of package org.lucasr.smoothie:
//            ItemLoader

private static final class mFromMemory
    implements Runnable
{

    private final boolean mFromMemory;
    private final ItemLoader mItemLoader;
    private final mFromMemory mRequest;

    public void run()
    {
        if (!ItemLoader.access$100(mItemLoader, mRequest))
        {
            if (mRequest.mRequest == null)
            {
                throw new IllegalStateException("Result should not be null when displaying an item part");
            }
            View view = (View)mRequest..get();
            if (view != null)
            {
                Object obj = mRequest.mRequest.get();
                mItemLoader.displayItemPart(view, obj, mRequest..intValue(), mFromMemory);
                return;
            }
        }
    }

    public (ItemLoader itemloader,  , boolean flag)
    {
        mItemLoader = itemloader;
        mRequest = ;
        mFromMemory = flag;
    }
}
