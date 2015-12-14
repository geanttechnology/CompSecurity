// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.boombox.internal.adapter;

import android.graphics.drawable.Drawable;
import java.util.LinkedHashMap;

// Referenced classes of package com.amazon.boombox.internal.adapter:
//            AsyncDrawableAdapter

public class CachedAsyncDrawableAdapter
    implements AsyncDrawableAdapter
{
    private class LruCache extends LinkedHashMap
    {

        private int mCacheSize;
        final CachedAsyncDrawableAdapter this$0;

        protected boolean removeEldestEntry(java.util.Map.Entry entry)
        {
            return size() > mCacheSize;
        }

        public LruCache(int i)
        {
            this$0 = CachedAsyncDrawableAdapter.this;
            super(i, 0.75F, true);
            mCacheSize = i;
        }
    }


    private AsyncDrawableAdapter mAdapter;
    private LruCache mCachedDrawables;

    public CachedAsyncDrawableAdapter(AsyncDrawableAdapter asyncdrawableadapter, int i)
    {
        mAdapter = asyncdrawableadapter;
        mCachedDrawables = new LruCache(i);
    }

    private String createKey(int i, int j, int k)
    {
        return (new StringBuilder()).append(j).append("x").append(k).append("@").append(i).toString();
    }

    public void dispose(Drawable drawable)
    {
    }

    public void getCount(AsyncDrawableAdapter.Listener listener)
    {
        mAdapter.getCount(listener);
    }

    public void getDrawable(int i, final int width, final int height, final AsyncDrawableAdapter.Listener listener)
    {
        Drawable drawable = (Drawable)mCachedDrawables.get(createKey(i, width, height));
        if (drawable != null)
        {
            listener.onDrawableReady(i, drawable);
            return;
        } else
        {
            listener = new AsyncDrawableAdapter.Listener() {

                final CachedAsyncDrawableAdapter this$0;
                final int val$height;
                final AsyncDrawableAdapter.Listener val$listener;
                final int val$width;

                public void onCountReady(int j)
                {
                    listener.onCountReady(j);
                }

                public void onDrawableReady(int j, Drawable drawable1)
                {
                    mCachedDrawables.put(createKey(j, width, height), drawable1);
                    listener.onDrawableReady(j, drawable1);
                }

            
            {
                this$0 = CachedAsyncDrawableAdapter.this;
                width = i;
                height = j;
                listener = listener1;
                super();
            }
            };
            mAdapter.getDrawable(i, width, height, listener);
            return;
        }
    }


}
