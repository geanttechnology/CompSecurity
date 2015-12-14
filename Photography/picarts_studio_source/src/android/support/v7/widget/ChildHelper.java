// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

class ChildHelper
{

    private static final boolean DEBUG = false;
    private static final String TAG = "ChildrenHelper";
    final Bucket mBucket = new Bucket();
    final Callback mCallback;
    final List mHiddenViews = new ArrayList();

    ChildHelper(Callback callback)
    {
        mCallback = callback;
    }

    private int getOffset(int i)
    {
        if (i >= 0)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        i = -1;
        return i;
        int j;
        int k;
        int l;
        k = mCallback.getChildCount();
        j = i;
          goto _L1
        continue; /* Loop/switch isn't completed */
        j += l;
    }

    void addView(View view, int i, boolean flag)
    {
        if (i < 0)
        {
            i = mCallback.getChildCount();
        } else
        {
            i = getOffset(i);
        }
        mCallback.addView(view, i);
        mBucket.insert(i, flag);
        if (flag)
        {
            mHiddenViews.add(view);
        }
    }

    void addView(View view, boolean flag)
    {
        addView(view, -1, flag);
    }

    void attachViewToParent(View view, int i, android.view.ViewGroup.LayoutParams layoutparams, boolean flag)
    {
        if (i < 0)
        {
            i = mCallback.getChildCount();
        } else
        {
            i = getOffset(i);
        }
        mCallback.attachViewToParent(view, i, layoutparams);
        mBucket.insert(i, flag);
        if (flag)
        {
            mHiddenViews.add(view);
        }
    }

    void detachViewFromParent(int i)
    {
        i = getOffset(i);
        mCallback.detachViewFromParent(i);
        mBucket.remove(i);
    }

    View findHiddenNonRemovedView(int i, int j)
    {
        int l = mHiddenViews.size();
        for (int k = 0; k < l; k++)
        {
            View view = (View)mHiddenViews.get(k);
            RecyclerView.ViewHolder viewholder = mCallback.getChildViewHolder(view);
            if (viewholder.getLayoutPosition() == i && !viewholder.isInvalid() && (j == -1 || viewholder.getItemViewType() == j))
            {
                return view;
            }
        }

        return null;
    }

    View getChildAt(int i)
    {
        i = getOffset(i);
        return mCallback.getChildAt(i);
    }

    int getChildCount()
    {
        return mCallback.getChildCount() - mHiddenViews.size();
    }

    View getUnfilteredChildAt(int i)
    {
        return mCallback.getChildAt(i);
    }

    int getUnfilteredChildCount()
    {
        return mCallback.getChildCount();
    }

    void hide(View view)
    {
        int i = mCallback.indexOfChild(view);
        if (i < 0)
        {
            throw new IllegalArgumentException((new StringBuilder("view is not a child, cannot hide ")).append(view).toString());
        } else
        {
            mBucket.set(i);
            mHiddenViews.add(view);
            return;
        }
    }

    int indexOfChild(View view)
    {
        int i;
        for (i = mCallback.indexOfChild(view); i == -1 || mBucket.get(i);)
        {
            return -1;
        }

        return i - mBucket.countOnesBefore(i);
    }

    boolean isHidden(View view)
    {
        return mHiddenViews.contains(view);
    }

    void removeAllViewsUnfiltered()
    {
        mCallback.removeAllViews();
        mBucket.reset();
        mHiddenViews.clear();
    }

    void removeView(View view)
    {
        int i = mCallback.indexOfChild(view);
        if (i >= 0)
        {
            mCallback.removeViewAt(i);
            if (mBucket.remove(i))
            {
                mHiddenViews.remove(view);
                return;
            }
        }
    }

    void removeViewAt(int i)
    {
        i = getOffset(i);
        View view = mCallback.getChildAt(i);
        if (view != null)
        {
            mCallback.removeViewAt(i);
            if (mBucket.remove(i))
            {
                mHiddenViews.remove(view);
                return;
            }
        }
    }

    boolean removeViewIfHidden(View view)
    {
        int i = mCallback.indexOfChild(view);
        if (i == -1)
        {
            mHiddenViews.remove(view);
            return true;
        }
        if (mBucket.get(i))
        {
            mBucket.remove(i);
            mCallback.removeViewAt(i);
            mHiddenViews.remove(view);
            return true;
        } else
        {
            return false;
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append(mBucket.toString()).append(", hidden list:").append(mHiddenViews.size()).toString();
    }

    /* member class not found */
    class Bucket {}


    private class Callback
    {

        public abstract void addView(View view, int i);

        public abstract void attachViewToParent(View view, int i, android.view.ViewGroup.LayoutParams layoutparams);

        public abstract void detachViewFromParent(int i);

        public abstract View getChildAt(int i);

        public abstract int getChildCount();

        public abstract RecyclerView.ViewHolder getChildViewHolder(View view);

        public abstract int indexOfChild(View view);

        public abstract void removeAllViews();

        public abstract void removeViewAt(int i);
    }

}
