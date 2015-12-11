// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v4.view.ai;
import android.util.Log;
import android.view.View;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView

public static abstract class itemView
{

    static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
    static final int FLAG_BOUND = 1;
    static final int FLAG_CHANGED = 64;
    static final int FLAG_IGNORE = 128;
    static final int FLAG_INVALID = 4;
    static final int FLAG_NOT_RECYCLABLE = 16;
    static final int FLAG_REMOVED = 8;
    static final int FLAG_RETURNED_FROM_SCRAP = 32;
    static final int FLAG_TMP_DETACHED = 256;
    static final int FLAG_UPDATE = 2;
    public final View itemView;
    private int mFlags;
    private int mIsRecyclableCount;
    long mItemId;
    int mItemViewType;
    int mOldPosition;
    int mPosition;
    int mPreLayoutPosition;
    private itemView mScrapContainer;
    itemView mShadowedHolder;
    itemView mShadowingHolder;

    static itemView a(itemView itemview, itemView itemview1)
    {
        itemview.mScrapContainer = itemview1;
        return itemview1;
    }

    static boolean a(mScrapContainer mscrapcontainer)
    {
        return mscrapcontainer.x();
    }

    static boolean b(x x1)
    {
        return x1.w();
    }

    static int c(w w1)
    {
        return w1.mFlags;
    }

    private boolean w()
    {
        return (mFlags & 0x10) != 0;
    }

    private boolean x()
    {
        return (mFlags & 0x10) == 0 && ai.c(itemView);
    }

    void a()
    {
        mOldPosition = -1;
        mPreLayoutPosition = -1;
    }

    void a(int i1, int j1)
    {
        mFlags = mFlags & ~j1 | i1 & j1;
    }

    void a(int i1, int j1, boolean flag)
    {
        b(8);
        a(j1, flag);
        mPosition = i1;
    }

    void a(int i1, boolean flag)
    {
        if (mOldPosition == -1)
        {
            mOldPosition = mPosition;
        }
        if (mPreLayoutPosition == -1)
        {
            mPreLayoutPosition = mPosition;
        }
        if (flag)
        {
            mPreLayoutPosition = mPreLayoutPosition + i1;
        }
        mPosition = mPosition + i1;
        if (itemView.getLayoutParams() != null)
        {
            ((itemView)itemView.getLayoutParams()).c = true;
        }
    }

    void a(c c1)
    {
        mScrapContainer = c1;
    }

    public final void a(boolean flag)
    {
        int i1;
        if (flag)
        {
            i1 = mIsRecyclableCount - 1;
        } else
        {
            i1 = mIsRecyclableCount + 1;
        }
        mIsRecyclableCount = i1;
        if (mIsRecyclableCount < 0)
        {
            mIsRecyclableCount = 0;
            Log.e("View", (new StringBuilder()).append("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ").append(this).toString());
        } else
        {
            if (!flag && mIsRecyclableCount == 1)
            {
                mFlags = mFlags | 0x10;
                return;
            }
            if (flag && mIsRecyclableCount == 0)
            {
                mFlags = mFlags & 0xffffffef;
                return;
            }
        }
    }

    boolean a(int i1)
    {
        return (mFlags & i1) != 0;
    }

    void b()
    {
        if (mOldPosition == -1)
        {
            mOldPosition = mPosition;
        }
    }

    void b(int i1)
    {
        mFlags = mFlags | i1;
    }

    boolean c()
    {
        return (mFlags & 0x80) != 0;
    }

    public final int d()
    {
        if (mPreLayoutPosition == -1)
        {
            return mPosition;
        } else
        {
            return mPreLayoutPosition;
        }
    }

    public final int e()
    {
        if (mPreLayoutPosition == -1)
        {
            return mPosition;
        } else
        {
            return mPreLayoutPosition;
        }
    }

    public final int f()
    {
        android.view.ViewParent viewparent = itemView.getParent();
        if (!(viewparent instanceof RecyclerView))
        {
            return -1;
        } else
        {
            return RecyclerView.a((RecyclerView)viewparent, this);
        }
    }

    public final long g()
    {
        return mItemId;
    }

    public final int h()
    {
        return mItemViewType;
    }

    boolean i()
    {
        return mScrapContainer != null;
    }

    void j()
    {
        mScrapContainer.d(this);
    }

    boolean k()
    {
        return (mFlags & 0x20) != 0;
    }

    void l()
    {
        mFlags = mFlags & 0xffffffdf;
    }

    void m()
    {
        mFlags = mFlags & 0xfffffeff;
    }

    boolean n()
    {
        return (mFlags & 4) != 0;
    }

    boolean o()
    {
        return (mFlags & 2) != 0;
    }

    boolean p()
    {
        return (mFlags & 0x40) != 0;
    }

    boolean q()
    {
        return (mFlags & 1) != 0;
    }

    boolean r()
    {
        return (mFlags & 8) != 0;
    }

    boolean s()
    {
        return (mFlags & 0x100) != 0;
    }

    boolean t()
    {
        return (mFlags & 0x200) != 0;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder((new StringBuilder()).append("ViewHolder{").append(Integer.toHexString(hashCode())).append(" position=").append(mPosition).append(" id=").append(mItemId).append(", oldPos=").append(mOldPosition).append(", pLpos:").append(mPreLayoutPosition).toString());
        if (i())
        {
            stringbuilder.append(" scrap");
        }
        if (n())
        {
            stringbuilder.append(" invalid");
        }
        if (!q())
        {
            stringbuilder.append(" unbound");
        }
        if (o())
        {
            stringbuilder.append(" update");
        }
        if (r())
        {
            stringbuilder.append(" removed");
        }
        if (c())
        {
            stringbuilder.append(" ignored");
        }
        if (p())
        {
            stringbuilder.append(" changed");
        }
        if (s())
        {
            stringbuilder.append(" tmpDetached");
        }
        if (!v())
        {
            stringbuilder.append((new StringBuilder()).append(" not recyclable(").append(mIsRecyclableCount).append(")").toString());
        }
        if (!t())
        {
            stringbuilder.append("undefined adapter position");
        }
        if (itemView.getParent() == null)
        {
            stringbuilder.append(" no parent");
        }
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    void u()
    {
        mFlags = 0;
        mPosition = -1;
        mOldPosition = -1;
        mItemId = -1L;
        mPreLayoutPosition = -1;
        mIsRecyclableCount = 0;
        mShadowedHolder = null;
        mShadowingHolder = null;
    }

    public final boolean v()
    {
        return (mFlags & 0x10) == 0 && !ai.c(itemView);
    }

    public (View view)
    {
        mPosition = -1;
        mOldPosition = -1;
        mItemId = -1L;
        mItemViewType = -1;
        mPreLayoutPosition = -1;
        mShadowedHolder = null;
        mShadowingHolder = null;
        mIsRecyclableCount = 0;
        mScrapContainer = null;
        if (view == null)
        {
            throw new IllegalArgumentException("itemView may not be null");
        } else
        {
            itemView = view;
            return;
        }
    }
}
