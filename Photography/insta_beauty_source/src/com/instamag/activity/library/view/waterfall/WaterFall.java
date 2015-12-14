// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.library.view.waterfall;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
import beb;
import bec;
import bed;
import bee;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

public class WaterFall extends ViewGroup
    implements Observer
{

    public static final int DEFAULT_EXTRA_SIZE = 100;
    private int N;
    private beb adapter;
    private bec bottomItems[];
    private int childHeightMeasureSpec;
    private int childWidthMeasureSpec;
    private int curY;
    private GestureDetector detector;
    private float firstFingerY;
    private float fisrtFingerX;
    private int flingBottomLimit;
    private boolean flingStarted;
    private int flingTopLimit;
    private View freshView;
    private boolean freshable;
    private android.view.GestureDetector.OnGestureListener gestureListener;
    private View headView;
    private int headViewHeight;
    private int headViewTop;
    private ArrayList idleItemList;
    private boolean isDownward;
    private boolean isFreshViewMeasured;
    private boolean isFreshing;
    private boolean isInitItemsDone;
    private boolean isLoadMoreViewMeasured;
    private boolean isLoading;
    private ArrayList itemList;
    private ArrayList itemRecycler;
    private ArrayList itemViewList;
    private int itemWidth;
    private int itemsBottomBound;
    private View loadMoreView;
    private boolean loadable;
    private int marginWidth;
    private int scrollBottomLimit;
    private int scrollDistance;
    private int scrollTopLimit;
    private Scroller scroller;
    private bed stateListener;
    private int topBound;
    private bec topItems[];
    private int viewHeight;
    private int viewWidth;

    public WaterFall(Context context)
    {
        super(context);
        scrollBottomLimit = 0x7fffffff;
        flingBottomLimit = 0x7fffffff;
        curY = 0;
        freshable = false;
        gestureListener = new bee(this);
        isDownward = false;
        loadable = true;
        N = 2;
        marginWidth = 0;
        init();
    }

    public WaterFall(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        scrollBottomLimit = 0x7fffffff;
        flingBottomLimit = 0x7fffffff;
        curY = 0;
        freshable = false;
        gestureListener = new bee(this);
        isDownward = false;
        loadable = true;
        N = 2;
        marginWidth = 0;
        init();
    }

    private final void computeBottom()
    {
        for (int i = 0; i < N && bottomItems[i] != null; i++)
        {
            if (bottomItems[i].a > itemsBottomBound)
            {
                itemsBottomBound = bottomItems[i].a;
            }
        }

    }

    private void computeChildVisibity()
    {
        if (!itemList.isEmpty()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!isDownward)
        {
            break; /* Loop/switch isn't completed */
        }
        for (int i = getNextDownWhenDown(); bottomItems[i].f > curY + viewHeight && bottomItems[i].g != null; i = getNextDownWhenDown())
        {
            p((new StringBuilder()).append("\u56DE\u6536Item").append(bottomItems[i].c).toString());
            bottomItems[i].h.setVisibility(8);
            itemRecycler.add(bottomItems[i].h);
            bottomItems[i] = bottomItems[i].g;
        }

        int j = getNextUpWhenDown();
        while (topItems[j].f > curY && topItems[j].g != null) 
        {
            p((new StringBuilder()).append("\u6DFB\u52A0Item").append(topItems[j].c).toString());
            bec bec1 = topItems[j].g;
            topItems[j] = bec1;
            bec1.h = obtainView(bec1.c);
            bec1.h.layout(bec1.d, bec1.f, bec1.e, bec1.a);
        }
        if (true) goto _L1; else goto _L3
_L3:
        int l;
        for (int k = getNextUpWhenUp(); topItems[k].a < curY && topItems[k].b != null; k = getNextUpWhenUp())
        {
            topItems[k].h.setVisibility(8);
            itemRecycler.add(topItems[k].h);
            topItems[k] = topItems[k].b;
        }

        l = getNextDownWhenUp();
_L6:
        if (bottomItems[l].a >= curY + viewHeight) goto _L1; else goto _L4
_L4:
        bec bec2;
        p((new StringBuilder()).append("\u6DFB\u52A0Item").append(bottomItems[l].c).toString());
        bec2 = bottomItems[l].b;
        if (bec2 != null)
        {
            break MISSING_BLOCK_LABEL_635;
        }
        if (itemList.size() >= adapter.a()) goto _L1; else goto _L5
_L5:
        bec bec3 = obtainItem();
        itemList.add(bec3);
        bec3.c = itemList.size() - 1;
        bec3.h = obtainView(bec3.c);
        bec3.f = bottomItems[l].a + marginWidth;
        bec3.g = bottomItems[l];
        bottomItems[l].b = bec3;
        bottomItems[l] = bec3;
        int i1 = itemWidth;
        bec3.d = (l + 1) * marginWidth + i1 * l;
        bec3.e = bec3.d + itemWidth;
        bec3.a = bec3.f + bec3.h.getMeasuredHeight();
        bec2 = bec3;
        if (itemList.size() == adapter.a())
        {
            computeBottom();
            setBottomConfigs();
            bec2 = bec3;
        }
_L7:
        bec2.h.layout(bec2.d, bec2.f, bec2.e, bec2.a);
        l = getNextDownWhenUp();
        computeBottom();
          goto _L6
        bec2.h = obtainView(bec2.c);
        bottomItems[l] = bec2;
          goto _L7
    }

    private void computePreState()
    {
        if (stateListener != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!isLoading)
        {
            int i = 0;
            if (loadMoreView != null)
            {
                i = loadMoreView.getMeasuredHeight();
            }
            if (curY + viewHeight >= i + itemsBottomBound)
            {
                if (isLoading)
                {
                    stateListener.a(1);
                }
            } else
            if (curY + viewHeight > itemsBottomBound && isLoading)
            {
                stateListener.a(2);
            }
        }
        if (isFreshing) goto _L1; else goto _L3
_L3:
        if (curY <= topBound)
        {
            stateListener.a(3);
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (curY > headViewHeight) goto _L1; else goto _L4
_L4:
        stateListener.a(4);
        return;
    }

    private final int getNextDownWhenDown()
    {
        int j = 0;
        for (int i = 1; i < N;)
        {
            int k = j;
            if (bottomItems[i].f > bottomItems[j].f)
            {
                k = i;
            }
            i++;
            j = k;
        }

        return j;
    }

    private final int getNextDownWhenUp()
    {
        int k = 0;
        for (int i = 0; i < N; i++)
        {
            if (bottomItems[i] == null)
            {
                return i;
            }
        }

        for (int j = 1; j < N;)
        {
            int l = k;
            if (bottomItems[j].a < bottomItems[k].a)
            {
                l = j;
            }
            j++;
            k = l;
        }

        return k;
    }

    private final int getNextUpWhenDown()
    {
        int j = 0;
        for (int i = 1; i < N;)
        {
            int k = j;
            if (topItems[i].f > topItems[j].f)
            {
                k = i;
            }
            i++;
            j = k;
        }

        return j;
    }

    private final int getNextUpWhenUp()
    {
        int j = 0;
        for (int i = 1; i < N;)
        {
            int k = j;
            if (topItems[i].a < topItems[j].a)
            {
                k = i;
            }
            i++;
            j = k;
        }

        return j;
    }

    private void init()
    {
        p("init");
        itemRecycler = new ArrayList();
        itemViewList = new ArrayList();
        itemList = new ArrayList();
        idleItemList = new ArrayList();
        detector = new GestureDetector(getContext(), gestureListener);
        if (android.os.Build.VERSION.SDK_INT > 10)
        {
            scroller = new Scroller(getContext(), null, true);
            return;
        } else
        {
            scroller = new Scroller(getContext(), null);
            return;
        }
    }

    private void initBottomConfigs()
    {
        p("initBottomConfigs");
        flingBottomLimit = 0x7fffffff;
        scrollBottomLimit = 0x7fffffff;
        if (loadMoreView != null)
        {
            loadMoreView.setVisibility(8);
        }
    }

    private void initItems()
    {
        p("initItems()");
        if (!isInitItemsDone && adapter.a() != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i;
        int j;
        p("initItems() data loading");
        j = adapter.a();
        i = 0;
_L7:
        if (i >= j) goto _L4; else goto _L3
_L3:
        int k;
        isInitItemsDone = true;
        k = getNextDownWhenUp();
        if (bottomItems[k] != null) goto _L6; else goto _L5
_L5:
        bec bec1;
        bec1 = obtainItem();
        topItems[k] = bec1;
        bec1.f = marginWidth + 0;
_L8:
        itemList.add(bec1);
        bec1.h = obtainView(i);
        bec1.d = itemWidth * k + marginWidth * (k + 1);
        bec1.e = bec1.d + itemWidth;
        bec1.a = bec1.f + bec1.h.getMeasuredHeight();
        bottomItems[k] = bec1;
        bec1.h.layout(bec1.d, bec1.f, bec1.e, bec1.a);
        bec1.c = i;
        p((new StringBuilder()).append("\u6DFB\u52A0Item").append(bec1.c).toString());
        i++;
          goto _L7
_L6:
        if (bottomItems[k].a <= curY + viewHeight)
        {
            break MISSING_BLOCK_LABEL_281;
        }
_L4:
        itemsBottomBound = 0;
        computeBottom();
        if (itemList.size() == adapter.a())
        {
            setBottomConfigs();
            return;
        }
          goto _L1
        bec1 = obtainItem();
        bec1.f = bottomItems[k].a + marginWidth;
        bec1.g = bottomItems[k];
        bottomItems[k].b = bec1;
          goto _L8
    }

    private final boolean isAllItemsLoaded()
    {
        while (adapter.a() == 0 || itemList.size() != adapter.a()) 
        {
            return false;
        }
        return true;
    }

    private void measureFreshViewIfNotMeasured(int i)
    {
        if (freshView != null && !isFreshViewMeasured)
        {
            int j = android.view.View.MeasureSpec.makeMeasureSpec(-2, 0);
            freshView.measure(i, j);
            topBound = headViewTop - freshView.getMeasuredHeight();
            if (freshable)
            {
                scrollTopLimit = topBound;
            } else
            {
                scrollTopLimit = headViewTop;
            }
            freshView.layout(0, topBound, freshView.getMeasuredWidth(), headViewTop);
            isFreshViewMeasured = true;
        }
    }

    private void measureHeadView(int i)
    {
        p("measureHeadView()");
        if (headView != null)
        {
            android.view.ViewGroup.LayoutParams layoutparams = headView.getLayoutParams();
            if (headView.getLayoutParams() == null)
            {
                layoutparams = new android.view.ViewGroup.LayoutParams(-1, -2);
                headView.setLayoutParams(layoutparams);
            }
            int j;
            if (layoutparams.height == -2)
            {
                i = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            } else
            {
                i = android.view.View.MeasureSpec.makeMeasureSpec(layoutparams.height, 0x40000000);
            }
            j = android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0x40000000);
            headView.measure(j, i);
            if (headViewHeight != headView.getMeasuredHeight())
            {
                headViewHeight = headView.getMeasuredHeight();
                headViewTop = -headViewHeight;
                flingTopLimit = headViewTop;
                topBound = headViewTop - freshView.getMeasuredHeight();
                scrollTopLimit = topBound;
                headView.layout(0, headViewTop, headView.getMeasuredWidth(), 0);
                freshView.layout(0, topBound, freshView.getMeasuredWidth(), headViewTop);
                scrollTo(0, headViewTop);
                return;
            }
        }
    }

    private void measureLoadMoreViewIfNotMeasured(int i)
    {
        if (loadMoreView != null && !isLoadMoreViewMeasured)
        {
            int j = android.view.View.MeasureSpec.makeMeasureSpec(-2, 0);
            loadMoreView.measure(i, j);
            isLoadMoreViewMeasured = true;
        }
    }

    private void modifyOverBound()
    {
        if (freshView == null || isFreshing) goto _L2; else goto _L1
_L1:
        if (curY > topBound) goto _L4; else goto _L3
_L3:
        if (stateListener != null)
        {
            isFreshing = true;
            flingTopLimit = scrollTopLimit;
            stateListener.a();
        }
_L2:
        if (loadMoreView == null) goto _L6; else goto _L5
_L5:
        if (isLoading || curY + viewHeight < itemsBottomBound + loadMoreView.getMeasuredHeight()) goto _L8; else goto _L7
_L7:
        if (stateListener != null)
        {
            isLoading = true;
            flingBottomLimit = scrollBottomLimit;
            scrollTo(0, flingBottomLimit);
            stateListener.b();
        }
_L6:
        return;
_L4:
        if (curY < headViewTop && curY > topBound)
        {
            flingTopLimit = headViewHeight;
            scroller.forceFinished(true);
            scroller.startScroll(0, curY, 0, headViewTop - curY, 500);
            postInvalidate();
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (curY + viewHeight <= itemsBottomBound) goto _L6; else goto _L9
_L9:
        flingBottomLimit = scrollBottomLimit - loadMoreView.getMeasuredHeight();
        scroller.forceFinished(true);
        scroller.startScroll(0, curY, 0, itemsBottomBound - viewHeight - curY, 500);
        postInvalidate();
        return;
        if (true) goto _L2; else goto _L10
_L10:
    }

    private final bec obtainItem()
    {
        if (idleItemList.isEmpty())
        {
            return new bec();
        } else
        {
            bec bec1 = (bec)idleItemList.get(0);
            bec1.a();
            idleItemList.remove(0);
            return bec1;
        }
    }

    private final View obtainView(int i)
    {
        View view;
        if (itemRecycler.isEmpty())
        {
            view = adapter.a(null, this, i);
            itemViewList.add(view);
            addView(view);
        } else
        {
            view = (View)itemRecycler.get(0);
            view = adapter.a(view, this, i);
            view.setVisibility(0);
            itemRecycler.remove(0);
        }
        view.forceLayout();
        view.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        return view;
    }

    private final void p(String s)
    {
    }

    private void reset()
    {
        itemRecycler.clear();
        View view;
        for (Iterator iterator = itemViewList.iterator(); iterator.hasNext(); itemRecycler.add(view))
        {
            view = (View)iterator.next();
            view.setVisibility(8);
        }

        idleItemList.addAll(itemList);
        itemList.clear();
        isInitItemsDone = false;
        for (int i = 0; i < N; i++)
        {
            topItems[i] = null;
            bottomItems[i] = null;
        }

        initBottomConfigs();
        requestLayout();
    }

    private void setBottomConfigs()
    {
        p("setBottomConfigs");
        if (loadMoreView == null && loadable)
        {
            if (headViewHeight + itemsBottomBound > viewHeight)
            {
                scrollBottomLimit = itemsBottomBound - viewHeight;
            } else
            {
                scrollBottomLimit = 0;
            }
            flingBottomLimit = scrollBottomLimit;
        } else
        {
            loadMoreView.setVisibility(0);
            if (headViewHeight + itemsBottomBound > viewHeight)
            {
                loadMoreView.layout(0, itemsBottomBound, viewWidth, itemsBottomBound + loadMoreView.getMeasuredHeight());
                loadMoreView.invalidate();
                scrollBottomLimit = (itemsBottomBound + loadMoreView.getMeasuredHeight()) - viewHeight;
                if (isLoading)
                {
                    flingBottomLimit = scrollBottomLimit;
                } else
                {
                    flingBottomLimit = scrollBottomLimit - loadMoreView.getMeasuredHeight();
                }
            } else
            {
                loadMoreView.layout(0, viewHeight - headViewHeight, viewWidth, (viewHeight - headViewHeight) + loadMoreView.getMeasuredHeight());
                scrollBottomLimit = loadMoreView.getMeasuredHeight();
                flingBottomLimit = 0;
            }
        }
        p((new StringBuilder()).append("flingBottomLimit").append(flingBottomLimit).toString());
        p((new StringBuilder()).append("scrollBottomLimit").append(scrollBottomLimit).toString());
    }

    public void cancelFreshing()
    {
        isFreshing = false;
        if (freshable)
        {
            scrollTopLimit = topBound;
        } else
        {
            scrollTopLimit = headViewTop;
        }
        flingTopLimit = headViewTop;
        flingBottomLimit = scrollBottomLimit - loadMoreView.getMeasuredHeight();
        if (curY < headViewTop)
        {
            scroller.startScroll(0, curY, 0, headViewTop - curY, 1000);
            postInvalidate();
        }
    }

    public void cancelLoading()
    {
        if (loadMoreView == null)
        {
            return;
        }
        isLoading = false;
        flingBottomLimit = scrollBottomLimit - loadMoreView.getMeasuredHeight();
        if (curY + viewHeight > itemsBottomBound)
        {
            scroller.startScroll(0, curY, 0, itemsBottomBound - viewHeight - curY, 1000);
            postInvalidate();
        }
        loadMoreView.setVisibility(8);
    }

    public void computeScroll()
    {
        super.computeScroll();
        if (scroller.computeScrollOffset())
        {
            scrollTo(0, scroller.getCurrY());
        }
    }

    public void freshHeadView()
    {
        measureHeadView(android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0x40000000));
    }

    public int getColumn()
    {
        return N;
    }

    public ArrayList getVisiableViews()
    {
        ArrayList arraylist = null;
        int i = 0;
        while (i < itemList.size()) 
        {
            bec bec1 = (bec)itemList.get(i);
            ArrayList arraylist1;
            boolean flag;
            if (bec1.a == 0)
            {
                flag = true;
            } else
            {
                flag = bec1.a(curY, viewHeight, 100);
            }
            arraylist1 = arraylist;
            if (flag)
            {
                arraylist1 = arraylist;
                if (arraylist == null)
                {
                    arraylist1 = new ArrayList();
                }
                arraylist1.add(bec1.h);
            }
            i++;
            arraylist = arraylist1;
        }
        return arraylist;
    }

    public boolean isDownWard()
    {
        return isDownward;
    }

    public boolean isFreshing()
    {
        return isFreshing;
    }

    public boolean isItemVisible(int i, int j)
    {
        if (i >= itemList.size())
        {
            return true;
        }
        bec bec1 = (bec)itemList.get(i);
        if (bec1.a == 0)
        {
            return true;
        } else
        {
            return bec1.a(curY, viewHeight, 100);
        }
    }

    public boolean isLoaing()
    {
        return isLoading;
    }

    public boolean isOnFling()
    {
        if (flingStarted && !scroller.isFinished())
        {
            return true;
        } else
        {
            flingStarted = false;
            return false;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getAction() == 0)
        {
            firstFingerY = motionevent.getY();
            fisrtFingerX = motionevent.getX();
            detector.onTouchEvent(motionevent);
            scroller.forceFinished(true);
        }
        return motionevent.getAction() == 2 && Math.abs(motionevent.getY() - firstFingerY) + Math.abs(motionevent.getX() - fisrtFingerX) > 6F && Math.abs(motionevent.getY() - firstFingerY) > Math.abs(motionevent.getX() - fisrtFingerX);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        p("onLayout()");
    }

    protected void onMeasure(int i, int j)
    {
        p("onMeasure");
        super.onMeasure(i, j);
        viewHeight = getMeasuredHeight();
        viewWidth = getMeasuredWidth();
        itemWidth = (viewWidth - (N + 1) * marginWidth) / N;
        childWidthMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(itemWidth, 0x40000000);
        childHeightMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        measureFreshViewIfNotMeasured(i);
        measureLoadMoreViewIfNotMeasured(i);
        measureHeadView(i);
        initItems();
    }

    protected void onScrollChanged(int i, int j, int k, int l)
    {
        if (j != l)
        {
            scrollDistance = j - curY;
            curY = j;
            boolean flag;
            if (j < l)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            isDownward = flag;
            if (isDownward)
            {
                if (isOnFling())
                {
                    i = flingTopLimit;
                } else
                if (scroller.isFinished())
                {
                    i = scrollTopLimit;
                } else
                {
                    i = 0;
                }
                if (j < i)
                {
                    scrollDistance = i - curY;
                    curY = i;
                    scrollTo(0, curY);
                    if (!scroller.isFinished())
                    {
                        scroller.forceFinished(true);
                    }
                }
            } else
            if (isAllItemsLoaded())
            {
                if (isOnFling())
                {
                    i = flingBottomLimit;
                } else
                {
                    i = scrollBottomLimit;
                }
                if (curY > i)
                {
                    scrollDistance = i - curY;
                    curY = i;
                    if (!scroller.isFinished())
                    {
                        scroller.forceFinished(true);
                    }
                }
                scrollTo(0, curY);
            }
            if (scrollDistance != 0)
            {
                computeChildVisibity();
            }
            if (stateListener != null)
            {
                stateListener.b(curY);
                return;
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1)
        {
            modifyOverBound();
        }
        return detector.onTouchEvent(motionevent);
    }

    public void setAdapter(beb beb1)
    {
        beb1.addObserver(this);
        adapter = beb1;
        requestLayout();
    }

    public void setCanFresh(boolean flag)
    {
        freshable = flag;
    }

    public void setCanLoad(boolean flag)
    {
        loadable = flag;
    }

    public void setColumn(int i)
    {
        N = i;
        topItems = new bec[N];
        bottomItems = new bec[N];
    }

    public void setFreshView(View view)
    {
        freshView = view;
        addView(freshView);
    }

    public void setHeadView(View view)
    {
        headView = view;
        addView(headView);
    }

    public void setLoadMoreView(View view)
    {
        loadMoreView = view;
        addView(loadMoreView);
    }

    public void setMarginWidth(int i)
    {
        marginWidth = i;
    }

    public void setStateListener(bed bed1)
    {
        stateListener = bed1;
    }

    public void startFresh()
    {
        if (!isFreshing)
        {
            scrollTopLimit = topBound;
            scroller.startScroll(0, curY, 0, topBound - curY);
            isFreshing = true;
            flingTopLimit = topBound;
            stateListener.a();
            postInvalidate();
        }
    }

    public void update(Observable observable, Object obj)
    {
        p("update()");
        if (obj != null)
        {
            int i = ((Integer)obj).intValue();
            p((new StringBuilder()).append("update() fresh item : position=").append(i).toString());
            if (i < itemList.size() && isItemVisible(i, 100))
            {
                observable = (bec)itemList.get(i);
                adapter.a(((bec) (observable)).h, this, i);
            }
        } else
        {
            switch (adapter.b())
            {
            default:
                return;

            case 0: // '\0'
                p("update() WaterFallAdapter.MODE_UPDATE_ALL");
                reset();
                return;

            case 1: // '\001'
                break;
            }
            if (adapter.a() != itemList.size())
            {
                initBottomConfigs();
                scrollBy(0, 1);
                return;
            }
        }
    }




/*
    public static boolean access$202(WaterFall waterfall, boolean flag)
    {
        waterfall.flingStarted = flag;
        return flag;
    }

*/

}
