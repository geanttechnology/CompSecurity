// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package wantu.sephiroth.android.library.imagezoom;

import air;
import ais;
import aix;
import aiy;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.instamag.activity.view.ImagesMovingView;
import java.util.ArrayList;
import java.util.List;
import lz;
import re;

// Referenced classes of package wantu.sephiroth.android.library.imagezoom:
//            RoundCornerImageViewTouch

public class TRoundImageViewLayout extends FrameLayout
    implements air, ais, re
{

    public static final int START_TAG = 1000;
    public static String TAG = "TRoundImageViewLayout";
    RoundCornerImageViewTouch curImageViewTouch;
    aix _flddelegate;
    boolean isTransform;
    private float lastX;
    private float lastY;
    lz listener;
    List mImageCenterFs;
    aiy mLayoutInfo;
    ImagesMovingView movingView;
    RoundCornerImageViewTouch selectedView;
    View touchGestureView;

    public TRoundImageViewLayout(Context context)
    {
        super(context);
        curImageViewTouch = null;
        selectedView = null;
        mLayoutInfo = null;
        movingView = null;
        listener = null;
        mImageCenterFs = new ArrayList();
        _flddelegate = null;
        init();
    }

    public TRoundImageViewLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        curImageViewTouch = null;
        selectedView = null;
        mLayoutInfo = null;
        movingView = null;
        listener = null;
        mImageCenterFs = new ArrayList();
        _flddelegate = null;
        init();
    }

    public TRoundImageViewLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        curImageViewTouch = null;
        selectedView = null;
        mLayoutInfo = null;
        movingView = null;
        listener = null;
        mImageCenterFs = new ArrayList();
        _flddelegate = null;
        init();
    }

    private List caculateScalePoints(List list, List list1, int i)
    {
        ArrayList arraylist = new ArrayList();
        for (int j = 0; j < list.size(); j++)
        {
            Point point = (Point)list.get(j);
            PointF pointf = (PointF)list1.get(j);
            arraylist.add(new Point((int)((float)point.x + pointf.x * (float)i), (int)((float)point.y - pointf.y * (float)i)));
        }

        return arraylist;
    }

    private RoundCornerImageViewTouch getImageViewByRect(Rect rect)
    {
        if (mLayoutInfo != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L6:
        return ((RoundCornerImageViewTouch) (obj));
_L2:
        int i = 0;
_L7:
        if (i >= mLayoutInfo.c().size()) goto _L4; else goto _L3
_L3:
        int j;
        int k;
        int l;
        int i1;
        obj = getChildAt(i);
        if (obj == null || !(obj instanceof RoundCornerImageViewTouch))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = (RoundCornerImageViewTouch)obj;
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)((RoundCornerImageViewTouch) (obj)).getLayoutParams();
        j = layoutparams.leftMargin;
        k = layoutparams.topMargin;
        l = layoutparams.width;
        i1 = layoutparams.height;
        if (rect.left == j && rect.top == k && rect.width() == l && rect.height() == i1) goto _L6; else goto _L5
_L5:
        i++;
          goto _L7
_L4:
        return null;
    }

    private void init()
    {
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        movingView = new ImagesMovingView(getContext());
        movingView.setDelegate(this);
        addView(movingView, layoutparams);
        touchGestureView = new View(getContext());
        touchGestureView.setOnTouchListener(new android.view.View.OnTouchListener() {

            final TRoundImageViewLayout a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (a.mLayoutInfo != null)
                {
                    if ((motionevent.getAction() & 0xff) == 0)
                    {
                        for (int i = 0; i < a.mLayoutInfo.c().size(); i++)
                        {
                            view = a.getChildAt(i);
                            if (view == null || !(view instanceof RoundCornerImageViewTouch))
                            {
                                continue;
                            }
                            view = (RoundCornerImageViewTouch)view;
                            if (view.isContaintPoint(new Point((int)motionevent.getX(), (int)motionevent.getY())))
                            {
                                a.curImageViewTouch = view;
                            }
                        }

                    }
                    if (a.curImageViewTouch != null)
                    {
                        a.curImageViewTouch.onTouchEvent(motionevent);
                    }
                }
                return true;
            }

            
            {
                a = TRoundImageViewLayout.this;
                super();
            }
        });
        addView(touchGestureView, layoutparams);
    }

    private boolean rectIsEqual(Rect rect, Rect rect1)
    {
        while (rect == null || rect1 == null || rect.left != rect1.left || rect.top != rect1.top || rect.bottom != rect1.bottom || rect.right != rect1.right) 
        {
            return false;
        }
        return true;
    }

    private void setAllImageViewsScroolEnable(boolean flag)
    {
        for (int i = 0; i < mLayoutInfo.c().size(); i++)
        {
            View view = getChildAt(i);
            if (view != null && (view instanceof RoundCornerImageViewTouch))
            {
                ((RoundCornerImageViewTouch)view).setScaleEnabled(flag);
            }
        }

    }

    public void ImageMovingTouchEvent(MotionEvent motionevent)
    {
        motionevent.getAction() & 0xff;
        JVM INSTR tableswitch 0 2: default 36
    //                   0 37
    //                   1 104
    //                   2 54;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        lastX = motionevent.getX();
        lastY = motionevent.getY();
        return;
_L4:
        if (movingView.getVisibility() != 4 && movingView != null)
        {
            float f = motionevent.getX();
            float f1 = motionevent.getY();
            movingView.movePosition((int)(f - lastX), (int)(f1 - lastY));
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (movingView != null && movingView.getVisibility() == 0)
        {
            Rect rect = movingView.getStartRect();
            motionevent = movingView.getTargetRect();
            if (!rectIsEqual(rect, motionevent) && rect != null && motionevent != null)
            {
                RoundCornerImageViewTouch roundcornerimageviewtouch = getImageViewByRect(rect);
                RoundCornerImageViewTouch roundcornerimageviewtouch1 = getImageViewByRect(motionevent);
                if (roundcornerimageviewtouch != null && roundcornerimageviewtouch1 != null)
                {
                    cancelSelected();
                    int i = ((Integer)roundcornerimageviewtouch.getTag()).intValue();
                    int j = ((Integer)roundcornerimageviewtouch1.getTag()).intValue();
                    PointF pointf = roundcornerimageviewtouch.getImageCenterPointF();
                    PointF pointf1 = roundcornerimageviewtouch1.getImageCenterPointF();
                    Bitmap bitmap;
                    if (_flddelegate != null)
                    {
                        bitmap = _flddelegate.getTouchBitmapWithTag(i);
                        motionevent = _flddelegate.getTouchBitmapWithTag(j);
                    } else
                    {
                        motionevent = null;
                        bitmap = null;
                    }
                    if (bitmap != null && motionevent != null)
                    {
                        roundcornerimageviewtouch.setImageBitmap(motionevent, true, null, 2.5F);
                        roundcornerimageviewtouch.setScrollEnabled(true);
                        roundcornerimageviewtouch.setImageCenterPoint(pointf1, motionevent.getWidth(), motionevent.getHeight());
                        roundcornerimageviewtouch1.setImageBitmap(bitmap, true, null, 2.5F);
                        roundcornerimageviewtouch1.setScrollEnabled(true);
                        roundcornerimageviewtouch1.setImageCenterPoint(pointf, bitmap.getWidth(), bitmap.getHeight());
                    }
                    if (listener != null)
                    {
                        listener.a(false, false);
                        listener.a(roundcornerimageviewtouch, roundcornerimageviewtouch1);
                    }
                }
            }
            movingView.setVisibility(4);
            movingView.setStartRectAndBitmap(null, null);
            setAllImageViewsScroolEnable(true);
            if (curImageViewTouch != null)
            {
                curImageViewTouch.setScrollEnabled(true);
                return;
            }
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void cancelSelected()
    {
        if (selectedView != null)
        {
            selectedView.setHighlight(false);
        }
        selectedView = null;
    }

    public void changeViewCorner(int i)
    {
        if (mLayoutInfo != null)
        {
            mLayoutInfo.c(i);
            int j = 0;
            while (j < mLayoutInfo.c().size()) 
            {
                View view = getChildAt(j);
                if (view != null && (view instanceof RoundCornerImageViewTouch))
                {
                    ((RoundCornerImageViewTouch)view).changeRadius(i);
                }
                j++;
            }
        }
    }

    public void changeViewEdge(int i)
    {
        while (mLayoutInfo == null || mLayoutInfo.a().size() != mLayoutInfo.b().size()) 
        {
            return;
        }
        mLayoutInfo.b(i);
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        i = 0;
        while (i < mLayoutInfo.c().size()) 
        {
            Object obj = getChildAt(i);
            if (obj != null && (obj instanceof RoundCornerImageViewTouch))
            {
                obj = (RoundCornerImageViewTouch)obj;
                List list = caculateScalePoints((List)mLayoutInfo.a().get(i), (List)mLayoutInfo.b().get(i), mLayoutInfo.d());
                Rect rect = getMaxRectFromPoints(list);
                arraylist.add(new Rect(rect.left, rect.top, rect.right, rect.bottom));
                android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(rect.right - rect.left, rect.bottom - rect.top);
                layoutparams.setMargins(rect.left, rect.top, 0, 0);
                layoutparams.gravity = 3;
                ((RoundCornerImageViewTouch) (obj)).setLayoutParams(layoutparams);
                boolean flag;
                if (mLayoutInfo.d() == 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                ((RoundCornerImageViewTouch) (obj)).setIsInsertZero(flag);
                ((RoundCornerImageViewTouch) (obj)).setPoints(getNewPointsInRect(rect, list));
                ((RoundCornerImageViewTouch) (obj)).setContaintPoints(list);
                ((RoundCornerImageViewTouch) (obj)).invalidate();
                arraylist1.add(((RoundCornerImageViewTouch) (obj)).getContaintPath());
            }
            i++;
        }
        movingView.setTargetRects(arraylist);
        movingView.setTargetPaths(arraylist1);
    }

    public void configByInfo(aiy aiy1)
    {
        if (aiy1 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj1;
        Object obj2;
        int j;
        mImageCenterFs.clear();
        mLayoutInfo = aiy1;
        for (int i = 0; i < mLayoutInfo.c().size(); i++)
        {
            Object obj = getChildAt(i);
            if (obj != null && (obj instanceof RoundCornerImageViewTouch))
            {
                obj = (RoundCornerImageViewTouch)obj;
                mImageCenterFs.add(((RoundCornerImageViewTouch) (obj)).getImageCenterPointF());
            }
        }

        removeAllViews();
        obj1 = new ArrayList();
        obj2 = new ArrayList();
        j = 0;
_L6:
        if (j < aiy1.c().size() && j < aiy1.a().size())
        {
            break MISSING_BLOCK_LABEL_376;
        }
        movingView.setTargetRects(((List) (obj1)));
        movingView.setTargetPaths(((List) (obj2)));
        aiy1 = new android.widget.FrameLayout.LayoutParams(-1, -1);
        addView(movingView, aiy1);
        addView(touchGestureView, aiy1);
        j = 0;
_L4:
        if (j >= mLayoutInfo.c().size())
        {
            continue; /* Loop/switch isn't completed */
        }
        aiy1 = getChildAt(j);
        if (aiy1 == null)
        {
            break MISSING_BLOCK_LABEL_367;
        }
        if (!(aiy1 instanceof RoundCornerImageViewTouch))
        {
            break MISSING_BLOCK_LABEL_367;
        }
        obj1 = (RoundCornerImageViewTouch)aiy1;
        obj2 = (Bitmap)mLayoutInfo.c().get(j);
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_367;
        }
        PointF pointf;
        if (((Bitmap) (obj2)).isRecycled())
        {
            break MISSING_BLOCK_LABEL_367;
        }
        pointf = new PointF((float)((Bitmap) (obj2)).getWidth() / 2.0F, (float)((Bitmap) (obj2)).getHeight() / 2.0F);
        aiy1 = pointf;
        if (mImageCenterFs == null)
        {
            break MISSING_BLOCK_LABEL_348;
        }
        aiy1 = pointf;
        if (j < mImageCenterFs.size())
        {
            aiy1 = new PointF(((PointF)mImageCenterFs.get(j)).x, ((PointF)mImageCenterFs.get(j)).y);
        }
        ((RoundCornerImageViewTouch) (obj1)).setImageCenterPoint(aiy1, ((Bitmap) (obj2)).getWidth(), ((Bitmap) (obj2)).getHeight());
        ((RoundCornerImageViewTouch) (obj1)).invalidate();
        j++;
        if (true) goto _L4; else goto _L3
_L3:
        continue; /* Loop/switch isn't completed */
        List list = (List)aiy1.a().get(j);
        if (mLayoutInfo.b() != null && mLayoutInfo.b().size() > 0)
        {
            list = caculateScalePoints(list, (List)mLayoutInfo.b().get(j), mLayoutInfo.i);
        }
        if (list != null && getContext() != null)
        {
            Rect rect = getMaxRectFromPoints(list);
            ((List) (obj1)).add(new Rect(rect.left, rect.top, rect.right, rect.bottom));
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(rect.right - rect.left, rect.bottom - rect.top);
            layoutparams.setMargins(rect.left, rect.top, 0, 0);
            layoutparams.gravity = 3;
            RoundCornerImageViewTouch roundcornerimageviewtouch = new RoundCornerImageViewTouch(getContext());
            roundcornerimageviewtouch.setLongClickable(true);
            roundcornerimageviewtouch.setLayoutParams(layoutparams);
            roundcornerimageviewtouch.setImageBitmap((Bitmap)aiy1.c().get(j), aiy1.g(), null, aiy1.h());
            roundcornerimageviewtouch.setPoints(getNewPointsInRect(rect, list));
            roundcornerimageviewtouch.setContaintPoints(list);
            roundcornerimageviewtouch.resetDisplayMatrix();
            roundcornerimageviewtouch.setRadius(aiy1.e());
            roundcornerimageviewtouch.setIsUsingShadow(aiy1.f());
            roundcornerimageviewtouch.setFitToScreen(true);
            roundcornerimageviewtouch.setSingleTapListener(this);
            roundcornerimageviewtouch.setLongPressListener(this);
            roundcornerimageviewtouch.setMovingListener(this);
            roundcornerimageviewtouch.setTag(Integer.valueOf(j));
            addView(roundcornerimageviewtouch, j);
            ((List) (obj2)).add(roundcornerimageviewtouch.getContaintPath());
        }
        j++;
        if (true) goto _L6; else goto _L5
_L5:
        aiy1;
        return;
        if (true) goto _L1; else goto _L7
_L7:
    }

    public int getEdge()
    {
        if (mLayoutInfo == null)
        {
            return 0;
        } else
        {
            return mLayoutInfo.d();
        }
    }

    public Rect getMaxRectFromPoints(List list)
    {
        int i = 0;
        int j = -1;
        int l = -1;
        int i1 = -1;
        int k;
        int j1;
        for (j1 = -1; i < list.size(); j1 = k)
        {
            Point point;
label0:
            {
                point = (Point)list.get(i);
                if (j1 <= point.x)
                {
                    k = j1;
                    if (j1 != -1)
                    {
                        break label0;
                    }
                }
                k = point.x;
            }
label1:
            {
                if (i1 <= point.y)
                {
                    j1 = i1;
                    if (i1 != -1)
                    {
                        break label1;
                    }
                }
                j1 = point.y;
            }
label2:
            {
                if (l >= point.x)
                {
                    i1 = l;
                    if (l != -1)
                    {
                        break label2;
                    }
                }
                i1 = point.x;
            }
label3:
            {
                if (j >= point.y)
                {
                    l = j;
                    if (j != -1)
                    {
                        break label3;
                    }
                }
                l = point.y;
            }
            i++;
            j = l;
            l = i1;
            i1 = j1;
        }

        return new Rect(j1 - 1, i1 - 1, l + 1, j + 1);
    }

    public List getNewPointsInRect(Rect rect, List list)
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < list.size(); i++)
        {
            Point point = (Point)list.get(i);
            arraylist.add(new Point(point.x - rect.left, point.y - rect.top));
        }

        return arraylist;
    }

    public int getSelectIndex()
    {
        if (selectedView != null)
        {
            return ((Integer)selectedView.getTag()).intValue();
        } else
        {
            return -1;
        }
    }

    public int getViewCorner()
    {
        if (mLayoutInfo != null)
        {
            return mLayoutInfo.e();
        } else
        {
            return (int)getContext().getResources().getDimension(0x7f08002d);
        }
    }

    public boolean isUseShadow()
    {
        if (mLayoutInfo == null)
        {
            return false;
        } else
        {
            return mLayoutInfo.f();
        }
    }

    public void movingPosition(int i, int j)
    {
    }

    public void onLongPress()
    {
        if (movingView != null)
        {
            movingView.setVisibility(0);
        }
        if (curImageViewTouch != null)
        {
            selectedView = curImageViewTouch;
        }
        if (selectedView != null)
        {
            selectedView.setScrollEnabled(false);
            Object obj = (android.widget.FrameLayout.LayoutParams)selectedView.getLayoutParams();
            int i = ((android.widget.FrameLayout.LayoutParams) (obj)).leftMargin;
            int j = ((android.widget.FrameLayout.LayoutParams) (obj)).topMargin;
            int k = ((android.widget.FrameLayout.LayoutParams) (obj)).width;
            int l = ((android.widget.FrameLayout.LayoutParams) (obj)).height;
            obj = new Rect();
            obj.left = i;
            obj.right = i + k;
            obj.top = j;
            obj.bottom = j + l;
            if (movingView != null)
            {
                Bitmap bitmap = selectedView.getDispalyImage(k, l);
                movingView.setStartRectAndBitmap(((Rect) (obj)), bitmap);
            }
        }
    }

    public void onSingleTap()
    {
        if (!isTransform) goto _L2; else goto _L1
_L1:
        if (listener != null)
        {
            listener.a(false, true);
        }
_L4:
        return;
_L2:
        if (curImageViewTouch == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (selectedView != null && selectedView == curImageViewTouch)
        {
            break; /* Loop/switch isn't completed */
        }
        cancelSelected();
        selectedView = curImageViewTouch;
        selectedView.setHighlight(true);
        if (listener != null)
        {
            listener.a(true, false);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        cancelSelected();
        if (listener != null)
        {
            listener.a(false, false);
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public void setBitmapsNull()
    {
        if (mLayoutInfo != null)
        {
            int i = 0;
            while (i < mLayoutInfo.c().size()) 
            {
                View view = getChildAt(i);
                if (view != null && (view instanceof RoundCornerImageViewTouch))
                {
                    ((RoundCornerImageViewTouch)view).setImageBitmap(null);
                }
                i++;
            }
        }
    }

    public void setDelegate(aix aix1)
    {
        _flddelegate = aix1;
    }

    public void setIsTransform(boolean flag)
    {
        isTransform = flag;
    }

    public void setIsUsingBK(boolean flag)
    {
        if (mLayoutInfo != null)
        {
            mLayoutInfo.b(flag);
            int i = 0;
            while (i < mLayoutInfo.c().size()) 
            {
                View view = getChildAt(i);
                if (view != null && (view instanceof RoundCornerImageViewTouch))
                {
                    ((RoundCornerImageViewTouch)view).setBK(flag);
                }
                i++;
            }
        }
    }

    public void setIsUsingShadow(boolean flag)
    {
        if (mLayoutInfo != null)
        {
            mLayoutInfo.a(flag);
            int i = 0;
            while (i < mLayoutInfo.c().size()) 
            {
                View view = getChildAt(i);
                if (view != null && (view instanceof RoundCornerImageViewTouch))
                {
                    ((RoundCornerImageViewTouch)view).setIsUsingShadow(flag);
                }
                i++;
            }
        }
    }

    public void setOnViewItemClickListener(lz lz1)
    {
        listener = lz1;
    }

    public void setSelectedBitmap(Bitmap bitmap)
    {
        if (selectedView != null)
        {
            selectedView.setImageBitmap(bitmap);
            selectedView.setImageCenterPoint(new PointF((float)bitmap.getWidth() / 2.0F, (float)bitmap.getHeight() / 2.0F), bitmap.getWidth(), bitmap.getHeight());
        }
    }

}
