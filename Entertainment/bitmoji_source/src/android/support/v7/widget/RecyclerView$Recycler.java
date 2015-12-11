// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView, RecyclerViewAccessibilityDelegate, AdapterHelper, ChildHelper

public final class mViewCacheMax
{

    private static final int DEFAULT_CACHE_SIZE = 2;
    final ArrayList mAttachedScrap = new ArrayList();
    final ArrayList mCachedViews = new ArrayList();
    private ArrayList mChangedScrap;
    private iewPool mRecyclerPool;
    private final List mUnmodifiableAttachedScrap;
    private Extension mViewCacheExtension;
    private int mViewCacheMax;
    final RecyclerView this$0;

    private void attachAccessibilityDelegate(View view)
    {
        if (isAccessibilityEnabled())
        {
            if (ViewCompat.getImportantForAccessibility(view) == 0)
            {
                ViewCompat.setImportantForAccessibility(view, 1);
            }
            if (!ViewCompat.hasAccessibilityDelegate(view))
            {
                ViewCompat.setAccessibilityDelegate(view, RecyclerView.access$4000(RecyclerView.this).getItemDelegate());
            }
        }
    }

    private void invalidateDisplayListInt(r r)
    {
        if (r.itemView instanceof ViewGroup)
        {
            invalidateDisplayListInt((ViewGroup)r.itemView, false);
        }
    }

    private void invalidateDisplayListInt(ViewGroup viewgroup, boolean flag)
    {
        for (int i = viewgroup.getChildCount() - 1; i >= 0; i--)
        {
            View view = viewgroup.getChildAt(i);
            if (view instanceof ViewGroup)
            {
                invalidateDisplayListInt((ViewGroup)view, true);
            }
        }

        if (!flag)
        {
            return;
        }
        if (viewgroup.getVisibility() == 4)
        {
            viewgroup.setVisibility(0);
            viewgroup.setVisibility(4);
            return;
        } else
        {
            int j = viewgroup.getVisibility();
            viewgroup.setVisibility(4);
            viewgroup.setVisibility(j);
            return;
        }
    }

    void addViewHolderToRecycledViewPool(r r)
    {
        ViewCompat.setAccessibilityDelegate(r.itemView, null);
        dispatchViewRecycled(r);
        r.mOwnerRecyclerView = null;
        getRecycledViewPool().putRecycledView(r);
    }

    public void bindViewToPosition(View view, int i)
    {
        boolean flag = true;
        r r = RecyclerView.getChildViewHolderInt(view);
        if (r == null)
        {
            throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter");
        }
        int j = mAdapterHelper.findPositionOffset(i);
        if (j < 0 || j >= RecyclerView.access$2400(RecyclerView.this).etItemCount())
        {
            throw new IndexOutOfBoundsException((new StringBuilder()).append("Inconsistency detected. Invalid item position ").append(i).append("(offset:").append(j).append(").").append("state:").append(mState.ItemCount()).toString());
        }
        r.mOwnerRecyclerView = RecyclerView.this;
        RecyclerView.access$2400(RecyclerView.this).indViewHolder(r, j);
        attachAccessibilityDelegate(view);
        if (mState.reLayout())
        {
            r.mPreLayoutPosition = i;
        }
        view = r.itemView.getLayoutParams();
        if (view == null)
        {
            view = (ams)generateDefaultLayoutParams();
            r.itemView.setLayoutParams(view);
        } else
        if (!checkLayoutParams(view))
        {
            view = (ams)generateLayoutParams(view);
            r.itemView.setLayoutParams(view);
        } else
        {
            view = (ams)view;
        }
        view.mInsetsDirty = true;
        view.mViewHolder = r;
        if (r.itemView.getParent() != null)
        {
            flag = false;
        }
        view.mPendingInvalidate = flag;
    }

    public void clear()
    {
        mAttachedScrap.clear();
        recycleAndClearCachedViews();
    }

    void clearOldPositions()
    {
        int l = mCachedViews.size();
        for (int i = 0; i < l; i++)
        {
            ((r)mCachedViews.get(i)).clearOldPosition();
        }

        l = mAttachedScrap.size();
        for (int j = 0; j < l; j++)
        {
            ((r)mAttachedScrap.get(j)).clearOldPosition();
        }

        if (mChangedScrap != null)
        {
            int i1 = mChangedScrap.size();
            for (int k = 0; k < i1; k++)
            {
                ((r)mChangedScrap.get(k)).clearOldPosition();
            }

        }
    }

    void clearScrap()
    {
        mAttachedScrap.clear();
    }

    public int convertPreLayoutPositionToPostLayout(int i)
    {
        if (i < 0 || i >= mState.ItemCount())
        {
            throw new IndexOutOfBoundsException((new StringBuilder()).append("invalid position ").append(i).append(". State ").append("item count is ").append(mState.ItemCount()).toString());
        }
        if (!mState.reLayout())
        {
            return i;
        } else
        {
            return mAdapterHelper.findPositionOffset(i);
        }
    }

    void dispatchViewRecycled(r r)
    {
        if (RecyclerView.access$4300(RecyclerView.this) != null)
        {
            RecyclerView.access$4300(RecyclerView.this).onViewRecycled(r);
        }
        if (RecyclerView.access$2400(RecyclerView.this) != null)
        {
            RecyclerView.access$2400(RecyclerView.this).nViewRecycled(r);
        }
        if (mState != null)
        {
            mState.iewRecycled(r);
        }
    }

    r getChangedScrapViewForPosition(int i)
    {
        int k;
label0:
        {
            if (mChangedScrap != null)
            {
                k = mChangedScrap.size();
                if (k != 0)
                {
                    break label0;
                }
            }
            return null;
        }
        for (int j = 0; j < k; j++)
        {
            r r = (r)mChangedScrap.get(j);
            if (!r.wasReturnedFromScrap() && r.getLayoutPosition() == i)
            {
                r.addFlags(32);
                return r;
            }
        }

        if (RecyclerView.access$2400(RecyclerView.this).asStableIds())
        {
            i = mAdapterHelper.findPositionOffset(i);
            if (i > 0 && i < RecyclerView.access$2400(RecyclerView.this).etItemCount())
            {
                long l = RecyclerView.access$2400(RecyclerView.this).etItemId(i);
                for (i = 0; i < k; i++)
                {
                    r r1 = (r)mChangedScrap.get(i);
                    if (!r1.wasReturnedFromScrap() && r1.getItemId() == l)
                    {
                        r1.addFlags(32);
                        return r1;
                    }
                }

            }
        }
        return null;
    }

    iewPool getRecycledViewPool()
    {
        if (mRecyclerPool == null)
        {
            mRecyclerPool = new iewPool();
        }
        return mRecyclerPool;
    }

    int getScrapCount()
    {
        return mAttachedScrap.size();
    }

    public List getScrapList()
    {
        return mUnmodifiableAttachedScrap;
    }

    View getScrapViewAt(int i)
    {
        return ((r)mAttachedScrap.get(i)).itemView;
    }

    r getScrapViewForId(long l, int i, boolean flag)
    {
        int j = mAttachedScrap.size() - 1;
_L5:
        if (j < 0) goto _L2; else goto _L1
_L1:
        r r1;
        r1 = (r)mAttachedScrap.get(j);
        if (r1.getItemId() != l || r1.wasReturnedFromScrap())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (i != r1.getItemViewType()) goto _L4; else goto _L3
_L3:
        r r;
        r1.addFlags(32);
        r = r1;
        if (r1.isRemoved())
        {
            r = r1;
            if (!mState.reLayout())
            {
                r1.setFlags(2, 14);
                r = r1;
            }
        }
_L8:
        return r;
_L4:
        if (!flag)
        {
            mAttachedScrap.remove(j);
            removeDetachedView(r1.itemView, false);
            quickRecycleScrapView(r1.itemView);
        }
        j--;
          goto _L5
_L2:
        j = mCachedViews.size() - 1;
_L9:
        if (j < 0) goto _L7; else goto _L6
_L6:
label0:
        {
            r r2 = (r)mCachedViews.get(j);
            if (r2.getItemId() != l)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (i != r2.getItemViewType())
            {
                break label0;
            }
            r = r2;
            if (!flag)
            {
                mCachedViews.remove(j);
                return r2;
            }
        }
          goto _L8
        if (!flag)
        {
            recycleCachedViewAt(j);
        }
        j--;
          goto _L9
_L7:
        return null;
          goto _L8
    }

    r getScrapViewForPosition(int i, int j, boolean flag)
    {
        int k;
        int l;
        l = mAttachedScrap.size();
        k = 0;
_L10:
        if (k >= l) goto _L2; else goto _L1
_L1:
        Object obj = (r)mAttachedScrap.get(k);
        if (((r) (obj)).wasReturnedFromScrap() || ((r) (obj)).getLayoutPosition() != i || ((r) (obj)).isInvalid() || !ess._mth1700(mState) && ((r) (obj)).isRemoved()) goto _L4; else goto _L3
_L3:
        if (j == -1 || ((r) (obj)).getItemViewType() == j) goto _L6; else goto _L5
_L5:
        Log.e("RecyclerView", (new StringBuilder()).append("Scrap view for position ").append(i).append(" isn't dirty but has").append(" wrong view type! (found ").append(((r) (obj)).getItemViewType()).append(" but expected ").append(j).append(")").toString());
_L2:
        if (!flag)
        {
            obj = mChildHelper.findHiddenNonRemovedView(i, j);
            if (obj != null)
            {
                mItemAnimator.endAnimation(getChildViewHolder(((View) (obj))));
            }
        }
        k = mCachedViews.size();
        j = 0;
_L8:
        if (j >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (r)mCachedViews.get(j);
        if (!((r) (obj)).isInvalid() && ((r) (obj)).getLayoutPosition() == i)
        {
            if (!flag)
            {
                mCachedViews.remove(j);
            }
            return ((r) (obj));
        }
        j++;
        continue; /* Loop/switch isn't completed */
_L6:
        ((r) (obj)).addFlags(32);
        return ((r) (obj));
_L4:
        k++;
        continue; /* Loop/switch isn't completed */
        if (true) goto _L8; else goto _L7
_L7:
        return null;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public View getViewForPosition(int i)
    {
        return getViewForPosition(i, false);
    }

    View getViewForPosition(int i, boolean flag)
    {
        boolean flag3 = true;
        if (i < 0 || i >= mState.ItemCount())
        {
            throw new IndexOutOfBoundsException((new StringBuilder()).append("Invalid item position ").append(i).append("(").append(i).append("). Item count:").append(mState.ItemCount()).toString());
        }
        boolean flag1 = false;
        r r = null;
        Object obj;
        int j;
        int k;
        if (mState.reLayout())
        {
            r = getChangedScrapViewForPosition(i);
            if (r != null)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
        }
        j = ((flag1) ? 1 : 0);
        obj = r;
        if (r == null)
        {
            r = getScrapViewForPosition(i, -1, flag);
            j = ((flag1) ? 1 : 0);
            obj = r;
            if (r != null)
            {
                if (!validateViewHolderForOffsetPosition(r))
                {
                    if (!flag)
                    {
                        r.addFlags(4);
                        if (r.isScrap())
                        {
                            removeDetachedView(r.itemView, false);
                            r.unScrap();
                        } else
                        if (r.wasReturnedFromScrap())
                        {
                            r.clearReturnedFromScrapFlag();
                        }
                        recycleViewHolderInternal(r);
                    }
                    obj = null;
                    j = ((flag1) ? 1 : 0);
                } else
                {
                    j = 1;
                    obj = r;
                }
            }
        }
        k = j;
        r = ((r) (obj));
        if (obj == null)
        {
            k = mAdapterHelper.findPositionOffset(i);
            if (k < 0 || k >= RecyclerView.access$2400(RecyclerView.this).etItemCount())
            {
                throw new IndexOutOfBoundsException((new StringBuilder()).append("Inconsistency detected. Invalid item position ").append(i).append("(offset:").append(k).append(").").append("state:").append(mState.ItemCount()).toString());
            }
            int l = RecyclerView.access$2400(RecyclerView.this).etItemViewType(k);
            flag1 = j;
            r = ((r) (obj));
            if (RecyclerView.access$2400(RecyclerView.this).asStableIds())
            {
                obj = getScrapViewForId(RecyclerView.access$2400(RecyclerView.this).etItemId(k), l, flag);
                flag1 = j;
                r = ((r) (obj));
                if (obj != null)
                {
                    obj.mPosition = k;
                    flag1 = true;
                    r = ((r) (obj));
                }
            }
            obj = r;
            if (r == null)
            {
                obj = r;
                if (mViewCacheExtension != null)
                {
                    View view = mViewCacheExtension.getViewForPositionAndType(this, i, l);
                    obj = r;
                    if (view != null)
                    {
                        r = getChildViewHolder(view);
                        if (r == null)
                        {
                            throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                        }
                        obj = r;
                        if (r.shouldIgnore())
                        {
                            throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                        }
                    }
                }
            }
            r r1 = ((r) (obj));
            if (obj == null)
            {
                obj = getRecycledViewPool().getRecycledView(l);
                r1 = ((r) (obj));
                if (obj != null)
                {
                    ((r) (obj)).resetInternal();
                    r1 = ((r) (obj));
                    if (RecyclerView.access$3900())
                    {
                        invalidateDisplayListInt(((r) (obj)));
                        r1 = ((r) (obj));
                    }
                }
            }
            k = ((flag1) ? 1 : 0);
            r = r1;
            if (r1 == null)
            {
                r = RecyclerView.access$2400(RecyclerView.this).reateViewHolder(RecyclerView.this, l);
                k = ((flag1) ? 1 : 0);
            }
        }
        j = 0;
        if (mState.reLayout() && r.isBound())
        {
            r.mPreLayoutPosition = i;
        } else
        if (!r.isBound() || r.needsUpdate() || r.isInvalid())
        {
            j = mAdapterHelper.findPositionOffset(i);
            r.mOwnerRecyclerView = RecyclerView.this;
            RecyclerView.access$2400(RecyclerView.this).indViewHolder(r, j);
            attachAccessibilityDelegate(r.itemView);
            boolean flag2 = true;
            j = ((flag2) ? 1 : 0);
            if (mState.reLayout())
            {
                r.mPreLayoutPosition = i;
                j = ((flag2) ? 1 : 0);
            }
        }
        obj = r.itemView.getLayoutParams();
        if (obj == null)
        {
            obj = (ams)generateDefaultLayoutParams();
            r.itemView.setLayoutParams(((android.view.) (obj)));
        } else
        if (!checkLayoutParams(((android.view.) (obj))))
        {
            obj = (ams)generateLayoutParams(((android.view.) (obj)));
            r.itemView.setLayoutParams(((android.view.) (obj)));
        } else
        {
            obj = (ams)obj;
        }
        obj.mViewHolder = r;
        if (k != 0 && j != 0)
        {
            flag = flag3;
        } else
        {
            flag = false;
        }
        obj.mPendingInvalidate = flag;
        return r.itemView;
    }

    void markItemDecorInsetsDirty()
    {
        int j = mCachedViews.size();
        for (int i = 0; i < j; i++)
        {
            ams ams = (ams)((r)mCachedViews.get(i)).itemView.getLayoutParams();
            if (ams != null)
            {
                ams.mInsetsDirty = true;
            }
        }

    }

    void markKnownViewsInvalid()
    {
        if (RecyclerView.access$2400(RecyclerView.this) != null && RecyclerView.access$2400(RecyclerView.this).asStableIds())
        {
            int j = mCachedViews.size();
            for (int i = 0; i < j; i++)
            {
                r r = (r)mCachedViews.get(i);
                if (r != null)
                {
                    r.addFlags(6);
                    r.addChangePayload(null);
                }
            }

        } else
        {
            recycleAndClearCachedViews();
        }
    }

    void offsetPositionRecordsForInsert(int i, int j)
    {
        int l = mCachedViews.size();
        for (int k = 0; k < l; k++)
        {
            r r = (r)mCachedViews.get(k);
            if (r != null && r.getLayoutPosition() >= i)
            {
                r.offsetPosition(j, true);
            }
        }

    }

    void offsetPositionRecordsForMove(int i, int j)
    {
        int k;
        byte byte0;
        int l;
        int i1;
        int j1;
        if (i < j)
        {
            l = i;
            k = j;
            byte0 = -1;
        } else
        {
            l = j;
            k = i;
            byte0 = 1;
        }
        j1 = mCachedViews.size();
        i1 = 0;
        while (i1 < j1) 
        {
            r r = (r)mCachedViews.get(i1);
            if (r != null && r.mPosition >= l && r.mPosition <= k)
            {
                if (r.mPosition == i)
                {
                    r.offsetPosition(j - i, false);
                } else
                {
                    r.offsetPosition(byte0, false);
                }
            }
            i1++;
        }
    }

    void offsetPositionRecordsForRemove(int i, int j, boolean flag)
    {
        int k = mCachedViews.size() - 1;
        while (k >= 0) 
        {
            r r = (r)mCachedViews.get(k);
            if (r != null)
            {
                if (r.getLayoutPosition() >= i + j)
                {
                    r.offsetPosition(-j, flag);
                } else
                if (r.getLayoutPosition() >= i)
                {
                    r.addFlags(8);
                    recycleCachedViewAt(k);
                }
            }
            k--;
        }
    }

    void onAdapterChanged(recycleCachedViewAt recyclecachedviewat, recycleCachedViewAt recyclecachedviewat1, boolean flag)
    {
        clear();
        getRecycledViewPool().onAdapterChanged(recyclecachedviewat, recyclecachedviewat1, flag);
    }

    void quickRecycleScrapView(View view)
    {
        view = RecyclerView.getChildViewHolderInt(view);
        r.access._mth4202(view, null);
        view.clearReturnedFromScrapFlag();
        recycleViewHolderInternal(view);
    }

    void recycleAndClearCachedViews()
    {
        for (int i = mCachedViews.size() - 1; i >= 0; i--)
        {
            recycleCachedViewAt(i);
        }

        mCachedViews.clear();
    }

    void recycleCachedViewAt(int i)
    {
        addViewHolderToRecycledViewPool((r)mCachedViews.get(i));
        mCachedViews.remove(i);
    }

    public void recycleView(View view)
    {
        r r;
        r = RecyclerView.getChildViewHolderInt(view);
        if (r.isTmpDetached())
        {
            removeDetachedView(view, false);
        }
        if (!r.isScrap()) goto _L2; else goto _L1
_L1:
        r.unScrap();
_L4:
        recycleViewHolderInternal(r);
        return;
_L2:
        if (r.wasReturnedFromScrap())
        {
            r.clearReturnedFromScrapFlag();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    void recycleViewHolderInternal(r r)
    {
label0:
        {
            boolean flag4 = true;
            if (r.isScrap() || r.itemView.getParent() != null)
            {
                StringBuilder stringbuilder = (new StringBuilder()).append("Scrapped or attached views may not be recycled. isScrap:").append(r.isScrap()).append(" isAttached:");
                if (r.itemView.getParent() == null)
                {
                    flag4 = false;
                }
                throw new IllegalArgumentException(stringbuilder.append(flag4).toString());
            }
            if (r.isTmpDetached())
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Tmp detached view should be removed from RecyclerView before it can be recycled: ").append(r).toString());
            }
            if (r.shouldIgnore())
            {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
            }
            flag4 = r.access._mth4100(r);
            boolean flag;
            int i;
            boolean flag1;
            boolean flag2;
            boolean flag3;
            if (RecyclerView.access$2400(RecyclerView.this) != null && flag4 && RecyclerView.access$2400(RecyclerView.this).nFailedToRecycleView(r))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            i = 0;
            flag3 = false;
            flag2 = false;
            if (!flag)
            {
                flag1 = flag2;
                if (!r.isRecyclable())
                {
                    break label0;
                }
            }
            flag = flag3;
            if (!r.hasAnyOfTheFlags(78))
            {
                i = mCachedViews.size();
                if (i == mViewCacheMax && i > 0)
                {
                    recycleCachedViewAt(0);
                }
                flag = flag3;
                if (i < mViewCacheMax)
                {
                    mCachedViews.add(r);
                    flag = true;
                }
            }
            i = ((flag) ? 1 : 0);
            flag1 = flag2;
            if (!flag)
            {
                addViewHolderToRecycledViewPool(r);
                flag1 = true;
                i = ((flag) ? 1 : 0);
            }
        }
        mState.iewRecycled(r);
        if (i == 0 && !flag1 && flag4)
        {
            r.mOwnerRecyclerView = null;
        }
    }

    void recycleViewInternal(View view)
    {
        recycleViewHolderInternal(RecyclerView.getChildViewHolderInt(view));
    }

    void scrapView(View view)
    {
        view = RecyclerView.getChildViewHolderInt(view);
        view.setScrapContainer(this);
        if (!view.isChanged() || !RecyclerView.access$2600(RecyclerView.this))
        {
            if (view.isInvalid() && !view.isRemoved() && !RecyclerView.access$2400(RecyclerView.this).asStableIds())
            {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
            } else
            {
                mAttachedScrap.add(view);
                return;
            }
        }
        if (mChangedScrap == null)
        {
            mChangedScrap = new ArrayList();
        }
        mChangedScrap.add(view);
    }

    void setAdapterPositionsAsUnknown()
    {
        int j = mCachedViews.size();
        for (int i = 0; i < j; i++)
        {
            r r = (r)mCachedViews.get(i);
            if (r != null)
            {
                r.addFlags(512);
            }
        }

    }

    void setRecycledViewPool(iewPool iewpool)
    {
        if (mRecyclerPool != null)
        {
            mRecyclerPool.detach();
        }
        mRecyclerPool = iewpool;
        if (iewpool != null)
        {
            mRecyclerPool.attach(getAdapter());
        }
    }

    void setViewCacheExtension(Extension extension)
    {
        mViewCacheExtension = extension;
    }

    public void setViewCacheSize(int i)
    {
        mViewCacheMax = i;
        for (int j = mCachedViews.size() - 1; j >= 0 && mCachedViews.size() > i; j--)
        {
            recycleCachedViewAt(j);
        }

    }

    void unscrapView(r r)
    {
        if (!r.isChanged() || !RecyclerView.access$2600(RecyclerView.this) || mChangedScrap == null)
        {
            mAttachedScrap.remove(r);
        } else
        {
            mChangedScrap.remove(r);
        }
        r.access._mth4202(r, null);
        r.clearReturnedFromScrapFlag();
    }

    boolean validateViewHolderForOffsetPosition(r r)
    {
        if (!r.isRemoved())
        {
            if (r.mPosition < 0 || r.mPosition >= RecyclerView.access$2400(RecyclerView.this).etItemCount())
            {
                throw new IndexOutOfBoundsException((new StringBuilder()).append("Inconsistency detected. Invalid view holder adapter position").append(r).toString());
            }
            if (!mState.reLayout() && RecyclerView.access$2400(RecyclerView.this).etItemViewType(r.mPosition) != r.getItemViewType())
            {
                return false;
            }
            if (RecyclerView.access$2400(RecyclerView.this).asStableIds() && r.getItemId() != RecyclerView.access$2400(RecyclerView.this).etItemId(r.mPosition))
            {
                return false;
            }
        }
        return true;
    }

    void viewRangeUpdate(int i, int j)
    {
        int k = mCachedViews.size() - 1;
        while (k >= 0) 
        {
            r r = (r)mCachedViews.get(k);
            if (r != null)
            {
                int l = r.getLayoutPosition();
                if (l >= i && l < i + j)
                {
                    r.addFlags(2);
                    recycleCachedViewAt(k);
                }
            }
            k--;
        }
    }


    public r()
    {
        this$0 = RecyclerView.this;
        super();
        mChangedScrap = null;
        mUnmodifiableAttachedScrap = Collections.unmodifiableList(mAttachedScrap);
        mViewCacheMax = 2;
    }
}
