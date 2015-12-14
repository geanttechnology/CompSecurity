// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.services;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.IBinder;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.aviary.android.feather.library.services.drag.DragLayer;
import com.aviary.android.feather.library.services.drag.DragView;
import com.aviary.android.feather.library.services.drag.DropTarget;
import java.util.ArrayList;

public class DragController
{

    public static final int DRAG_ACTION_COPY = 1;
    public static final int DRAG_ACTION_MOVE = 0;
    private static final int VIBRATE_DURATION = 35;
    Context mContext;
    private final int mCoordinatesTemp[] = new int[2];
    private DisplayMetrics mDisplayMetrics;
    private Object mDragInfo;
    DragLayer mDragLayer;
    private DragControllerService.DragSource mDragSource;
    private DragView mDragView;
    private ArrayList mDropTargets;
    private InputMethodManager mInputMethodManager;
    private DropTarget mLastDropTarget;
    private DragControllerService.DragListener mListener;
    private float mMotionDownX;
    private float mMotionDownY;
    private View mMoveTarget;
    private View mOriginator;
    private Rect mRectTemp;
    private float mTouchOffsetX;
    private float mTouchOffsetY;
    private Vibrator mVibrator;
    private IBinder mWindowToken;

    public DragController(Context context, DragLayer draglayer)
    {
        mRectTemp = new Rect();
        mDisplayMetrics = new DisplayMetrics();
        mDropTargets = new ArrayList();
        mContext = context;
        mDragLayer = draglayer;
    }

    private static int clamp(int i, int j, int k)
    {
        if (i < j)
        {
            return j;
        }
        if (i >= k)
        {
            return k - 1;
        } else
        {
            return i;
        }
    }

    private boolean drop(float f, float f1)
    {
        int ai[] = mCoordinatesTemp;
        DropTarget droptarget = findDropTarget((int)f, (int)f1, ai);
        if (droptarget != null)
        {
            droptarget.onDragExit(mDragSource, ai[0], ai[1], (int)mTouchOffsetX, (int)mTouchOffsetY, mDragView, mDragInfo);
            if (droptarget.acceptDrop(mDragSource, ai[0], ai[1], (int)mTouchOffsetX, (int)mTouchOffsetY, mDragView, mDragInfo))
            {
                droptarget.onDrop(mDragSource, ai[0], ai[1], (int)mTouchOffsetX, (int)mTouchOffsetY, mDragView, mDragInfo);
                mDragSource.onDropCompleted(droptarget, true);
                return true;
            } else
            {
                mDragSource.onDropCompleted(droptarget, false);
                return true;
            }
        } else
        {
            return false;
        }
    }

    private void endDrag()
    {
        if (isDragging())
        {
            if (mOriginator != null)
            {
                mOriginator.setVisibility(0);
            }
            boolean flag = true;
            if (mListener != null)
            {
                flag = mListener.onDragEnd();
            }
            if (mDragView != null)
            {
                mDragView.remove(flag);
                mDragView = null;
            }
        }
    }

    private DropTarget findDropTarget(int i, int j, int ai[])
    {
        Rect rect = mRectTemp;
        ArrayList arraylist = mDropTargets;
        for (int k = arraylist.size() - 1; k >= 0; k--)
        {
            DropTarget droptarget = (DropTarget)arraylist.get(k);
            droptarget.getHitRect(rect);
            droptarget.getLocationOnScreen(ai);
            rect.offset(ai[0] - droptarget.getLeft(), ai[1] - droptarget.getTop());
            if (rect.contains(i, j))
            {
                ai[0] = i - ai[0];
                ai[1] = j - ai[1];
                return droptarget;
            }
        }

        return null;
    }

    private Bitmap getViewBitmap(View view)
    {
        view.clearFocus();
        view.setPressed(false);
        boolean flag = view.willNotCacheDrawing();
        view.setWillNotCacheDrawing(false);
        int i = view.getDrawingCacheBackgroundColor();
        view.setDrawingCacheBackgroundColor(0);
        if (i != 0)
        {
            view.destroyDrawingCache();
        }
        view.buildDrawingCache();
        Bitmap bitmap = view.getDrawingCache();
        if (bitmap == null)
        {
            return null;
        } else
        {
            bitmap = Bitmap.createBitmap(bitmap);
            view.destroyDrawingCache();
            view.setWillNotCacheDrawing(flag);
            view.setDrawingCacheBackgroundColor(i);
            return bitmap;
        }
    }

    private void recordScreenSize()
    {
        ((WindowManager)mContext.getSystemService("window")).getDefaultDisplay().getMetrics(mDisplayMetrics);
    }

    public void activate()
    {
        mDragLayer.setDragController(this);
        mWindowToken = mDragLayer.getWindowToken();
    }

    public boolean active()
    {
        return mWindowToken != null;
    }

    public void addDropTarget(DropTarget droptarget)
    {
        mDropTargets.add(droptarget);
    }

    public void cancelDrag()
    {
        endDrag();
    }

    public void deactivate()
    {
        mDragLayer.setDragController(null);
        mWindowToken = null;
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        return isDragging();
    }

    public boolean dispatchUnhandledMove(View view, int i)
    {
        return mMoveTarget != null && mMoveTarget.dispatchUnhandledMove(view, i);
    }

    public void dispose()
    {
        deactivate();
        mDropTargets.clear();
        mListener = null;
        mWindowToken = null;
    }

    Point getTopLeft(View view, Bitmap bitmap)
    {
        int ai[] = new int[2];
        view.getLocationOnScreen(ai);
        int i = ai[0];
        int j = view.getWidth() / 2;
        int k = ai[1];
        int l = view.getHeight() / 2;
        return new Point((i + j) - bitmap.getWidth() / 2, (k + l) - bitmap.getHeight() / 2);
    }

    public boolean isDragging()
    {
        return mDragView != null;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i;
        int j;
        int k;
        if (!active())
        {
            return false;
        }
        i = motionevent.getAction();
        if (i == 0)
        {
            recordScreenSize();
        }
        j = clamp((int)motionevent.getRawX(), 0, mDisplayMetrics.widthPixels);
        k = clamp((int)motionevent.getRawY(), 0, mDisplayMetrics.heightPixels);
        i;
        JVM INSTR tableswitch 0 3: default 88
    //                   0 93
    //                   1 114
    //                   2 88
    //                   3 138;
           goto _L1 _L2 _L3 _L1 _L4
_L1:
        return isDragging();
_L2:
        mMotionDownX = j;
        mMotionDownY = k;
        mLastDropTarget = null;
        continue; /* Loop/switch isn't completed */
_L3:
        if (isDragging())
        {
            drop(j, k);
        }
        endDrag();
        continue; /* Loop/switch isn't completed */
_L4:
        cancelDrag();
        if (true) goto _L1; else goto _L5
_L5:
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i;
        int j;
        int k;
        if (!isDragging())
        {
            return false;
        }
        i = motionevent.getAction();
        j = clamp((int)motionevent.getRawX(), 0, mDisplayMetrics.widthPixels);
        k = clamp((int)motionevent.getRawY(), 0, mDisplayMetrics.heightPixels);
        i;
        JVM INSTR tableswitch 0 3: default 84
    //                   0 86
    //                   1 390
    //                   2 103
    //                   3 415;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return true;
_L2:
        mMotionDownX = j;
        mMotionDownY = k;
        continue; /* Loop/switch isn't completed */
_L4:
        DropTarget droptarget;
        int ai[];
        mDragView.move((int)motionevent.getRawX(), (int)motionevent.getRawY());
        ai = mCoordinatesTemp;
        droptarget = findDropTarget(j, k, ai);
        if (droptarget == null) goto _L7; else goto _L6
_L6:
        motionevent = droptarget;
        if (!droptarget.acceptDrop(mDragSource, ai[0], ai[1], (int)mTouchOffsetX, (int)mTouchOffsetY, mDragView, mDragInfo))
        {
            motionevent = null;
        }
        if (mLastDropTarget != motionevent) goto _L9; else goto _L8
_L8:
        Object obj;
        obj = motionevent;
        if (motionevent != null)
        {
            motionevent.onDragOver(mDragSource, ai[0], ai[1], (int)mTouchOffsetX, (int)mTouchOffsetY, mDragView, mDragInfo);
            obj = motionevent;
        }
_L10:
        mLastDropTarget = ((DropTarget) (obj));
        continue; /* Loop/switch isn't completed */
_L9:
        if (mLastDropTarget != null)
        {
            mLastDropTarget.onDragExit(mDragSource, ai[0], ai[1], (int)mTouchOffsetX, (int)mTouchOffsetY, mDragView, mDragInfo);
        }
        obj = motionevent;
        if (motionevent != null)
        {
            motionevent.onDragEnter(mDragSource, ai[0], ai[1], (int)mTouchOffsetX, (int)mTouchOffsetY, mDragView, mDragInfo);
            obj = motionevent;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        obj = droptarget;
        if (mLastDropTarget != null)
        {
            mLastDropTarget.onDragExit(mDragSource, ai[0], ai[1], (int)mTouchOffsetX, (int)mTouchOffsetY, mDragView, mDragInfo);
            obj = droptarget;
        }
        if (true) goto _L10; else goto _L3
_L3:
        if (isDragging())
        {
            drop(j, k);
        }
        endDrag();
        continue; /* Loop/switch isn't completed */
_L5:
        cancelDrag();
        if (true) goto _L1; else goto _L11
_L11:
    }

    public void removeDropTarget(DropTarget droptarget)
    {
        mDropTargets.remove(droptarget);
    }

    public void setDragListener(DragControllerService.DragListener draglistener)
    {
        mListener = draglistener;
    }

    public void setMoveTarget(View view)
    {
        mMoveTarget = view;
    }

    public void setWindowToken(IBinder ibinder)
    {
        mWindowToken = ibinder;
    }

    public boolean startDrag(Bitmap bitmap, int i, int j, int k, int l, int i1, int j1, 
            DragControllerService.DragSource dragsource, Object obj, int k1, boolean flag)
    {
        if (mWindowToken == null)
        {
            return false;
        }
        if (!mWindowToken.pingBinder())
        {
            return false;
        }
        if (mInputMethodManager == null)
        {
            mInputMethodManager = (InputMethodManager)mContext.getSystemService("input_method");
        }
        mInputMethodManager.hideSoftInputFromWindow(mWindowToken, 0);
        if (mListener != null)
        {
            mListener.onDragStart(dragsource, obj, k1);
        }
        k1 = (int)mMotionDownX;
        int l1 = (int)mMotionDownY;
        mTouchOffsetX = mMotionDownX - (float)i;
        mTouchOffsetY = mMotionDownY - (float)j;
        mDragSource = dragsource;
        mDragInfo = obj;
        if (mVibrator != null)
        {
            mVibrator.vibrate(35L);
        }
        mDragView = new DragView(mContext, bitmap, k1 - i, l1 - j, k, l, i1, j1);
        mDragView.show(mWindowToken, (int)mMotionDownX, (int)mMotionDownY, flag);
        return true;
    }

    public boolean startDrag(Bitmap bitmap, DragControllerService.DragSource dragsource, Object obj, int i, View view)
    {
        while (mWindowToken == null || !mWindowToken.pingBinder()) 
        {
            return false;
        }
        if (mListener != null)
        {
            mListener.onDragStart(dragsource, obj, i);
        }
        if (mVibrator != null)
        {
            mVibrator.vibrate(35L);
        }
        mDragView = new DragView(mContext, bitmap, view);
        Log.w("", (new StringBuilder()).append("mMotionDown: ").append(mMotionDownX).append(", ").append(mMotionDownY).toString());
        Log.w("", (new StringBuilder()).append("mMotionDown: ").append(mMotionDownX - mTouchOffsetX).append(", ").append(mMotionDownY - mTouchOffsetY).toString());
        bitmap = getTopLeft(view, bitmap);
        mDragView.show(mWindowToken, ((Point) (bitmap)).x, ((Point) (bitmap)).y, true);
        return true;
    }

    public boolean startDrag(View view, Bitmap bitmap, int i, int j, DragControllerService.DragSource dragsource, Object obj, int k, 
            boolean flag)
    {
        mOriginator = view;
        if (bitmap == null)
        {
            flag = false;
        } else
        {
            int ai[] = mCoordinatesTemp;
            view.getLocationOnScreen(ai);
            boolean flag1 = startDrag(bitmap, ai[0] + i, ai[1] + j, 0, 0, bitmap.getWidth(), bitmap.getHeight(), dragsource, obj, k, flag);
            flag = flag1;
            if (k == 0)
            {
                flag = flag1;
                if (flag1)
                {
                    view.setVisibility(8);
                    return flag1;
                }
            }
        }
        return flag;
    }

    public boolean startDrag(View view, Bitmap bitmap, DragControllerService.DragSource dragsource, Object obj, int i, float f, float f1)
    {
        if (bitmap == null || bitmap.isRecycled())
        {
            return false;
        } else
        {
            mOriginator = view;
            mDragInfo = obj;
            mDragSource = dragsource;
            mMotionDownX = f;
            mMotionDownY = f1;
            return startDrag(bitmap, dragsource, obj, i, view);
        }
    }

    public boolean startDrag(View view, Bitmap bitmap, DragControllerService.DragSource dragsource, Object obj, int i, MotionEvent motionevent)
    {
        return startDrag(view, bitmap, dragsource, obj, i, motionevent.getRawX(), motionevent.getRawY());
    }

    public boolean startDrag(View view, DragControllerService.DragSource dragsource, Object obj, int i, boolean flag)
    {
        return startDrag(view, getViewBitmap(view), 0, 0, dragsource, obj, i, flag);
    }
}
