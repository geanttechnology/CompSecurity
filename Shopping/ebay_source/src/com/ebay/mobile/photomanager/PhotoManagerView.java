// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;

// Referenced classes of package com.ebay.mobile.photomanager:
//            PhotoManagerViewAdapter, PhotoManagerFragment, BitmapUtil

public class PhotoManagerView extends GridView
    implements android.widget.AdapterView.OnItemClickListener, android.widget.AdapterView.OnItemLongClickListener
{
    class RemovePhotoClickListener
        implements android.content.DialogInterface.OnClickListener
    {

        int index;
        final PhotoManagerView this$0;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            if (i != -1 || adapter == null)
            {
                return;
            } else
            {
                adapter.remove(index);
                invalidateViews();
                return;
            }
        }

        RemovePhotoClickListener(int i)
        {
            this$0 = PhotoManagerView.this;
            super();
            index = i;
        }
    }


    private Activity activity;
    private PhotoManagerViewAdapter adapter;
    private boolean canScroll;
    private int dragIndex;
    private int dragOffsetX;
    private int dragOffsetY;
    private View dragView;
    private int dragX;
    private int dragY;
    private PhotoManagerFragment fragment;
    private Rect frame;
    private boolean isDrag;
    private int lastTouchRawX;
    private int lastTouchRawY;
    private int lastTouchX;
    private int lastTouchY;
    private View originalView;
    private int selectedPosition;

    public PhotoManagerView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        fragment = null;
        activity = null;
        adapter = null;
        canScroll = true;
        selectedPosition = 0;
        frame = new Rect();
    }

    private void clearDropBorders()
    {
        int j = getFirstVisiblePosition();
        for (int i = 0; i < getChildCount(); i++)
        {
            if (!adapter.isAddButton(i + j))
            {
                getChildAt(i).setBackgroundResource(0x7f02029c);
            }
        }

    }

    private int distance(int i, int j, int k, int l)
    {
        return Math.abs(k - i) + Math.abs(l - j);
    }

    private void drag(int i, int j)
    {
        if (dragView != null)
        {
            android.view.WindowManager.LayoutParams layoutparams = (android.view.WindowManager.LayoutParams)dragView.getLayoutParams();
            layoutparams.x = i - dragOffsetX;
            layoutparams.y = j - dragOffsetY;
            ((WindowManager)getContext().getSystemService("window")).updateViewLayout(dragView, layoutparams);
            clearDropBorders();
            i = myPointToPosition(i, j);
            if (i != -1)
            {
                if (adapter.isPossibleDragOrDropLocation(getFirstVisiblePosition() + i))
                {
                    getChildAt(i).setBackgroundResource(0x7f02029d);
                }
                if (canScroll)
                {
                    if (getChildAt(i).getTop() < getTop())
                    {
                        selectedPosition = selectedPosition - 1;
                        setSelection(selectedPosition);
                        waitToScrollAgain();
                        return;
                    }
                    if (getChildAt(i).getBottom() > getBottom())
                    {
                        selectedPosition = selectedPosition + 1;
                        setSelection(selectedPosition);
                        waitToScrollAgain();
                        return;
                    }
                }
            }
        }
    }

    private void handleClick(int i)
    {
        if (!adapter.isAddButton(i)) goto _L2; else goto _L1
_L1:
        if (!adapter.hasSelfHostedPhotos()) goto _L4; else goto _L3
_L3:
        if (fragment == null) goto _L6; else goto _L5
_L5:
        fragment.showDialog(2);
_L8:
        return;
_L6:
        if (activity != null)
        {
            activity.showDialog(2);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (fragment != null)
        {
            fragment.showDialog(1);
            return;
        }
        if (activity != null)
        {
            activity.showDialog(1);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (!adapter.isRemovable(i))
        {
            if (fragment != null)
            {
                fragment.showDialog(4);
                return;
            }
            if (activity != null)
            {
                activity.showDialog(4);
                return;
            }
        } else
        {
            Context context = getContext();
            android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
            builder.setTitle(context.getString(0x7f07077f));
            RemovePhotoClickListener removephotoclicklistener = new RemovePhotoClickListener(i);
            builder.setPositiveButton(context.getString(0x104000a), removephotoclicklistener);
            builder.setNegativeButton(context.getString(0x1040000), removephotoclicklistener);
            builder.create().show();
            return;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    private int myPointToPosition(int i, int j)
    {
        int l = 0x7fffffff;
        int i1 = -1;
        for (int k = 0; k < getChildCount();)
        {
            getChildAt(k).getHitRect(frame);
            int k1 = distance(i, j, frame.centerX(), frame.centerY());
            int j1 = l;
            if (k1 < l)
            {
                j1 = k1;
                i1 = k;
            }
            k++;
            l = j1;
        }

        return i1;
    }

    private void startDrag()
    {
        stopDrag();
        if (originalView != null)
        {
            Context context = getContext();
            android.view.WindowManager.LayoutParams layoutparams = new android.view.WindowManager.LayoutParams();
            layoutparams.gravity = 51;
            layoutparams.x = dragX - dragOffsetX;
            layoutparams.y = dragY - dragOffsetY;
            layoutparams.height = -2;
            layoutparams.width = -2;
            layoutparams.flags = 920;
            layoutparams.format = -3;
            layoutparams.windowAnimations = 0;
            android.graphics.Bitmap bitmap = BitmapUtil.getViewBitmap(originalView);
            if (bitmap != null)
            {
                dragView = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f03019d, null);
                ((ImageView)dragView.findViewById(0x7f1004b2)).setImageBitmap(bitmap);
                ((WindowManager)context.getSystemService("window")).addView(dragView, layoutparams);
                originalView.setVisibility(4);
                return;
            }
        }
    }

    private void stopDrag()
    {
        if (dragView == null)
        {
            return;
        } else
        {
            dragView.setVisibility(8);
            ((WindowManager)getContext().getSystemService("window")).removeView(dragView);
            ((ImageView)(ImageView)dragView.findViewById(0x7f1004b2)).setImageDrawable(null);
            dragView = originalView;
            dragView.setVisibility(0);
            dragView = null;
            clearDropBorders();
            return;
        }
    }

    private void waitToScrollAgain()
    {
        canScroll = false;
        (new Thread() {

            final PhotoManagerView this$0;

            public void run()
            {
                try
                {
                    Thread.sleep(250L);
                }
                catch (Exception exception) { }
                canScroll = true;
            }

            
            {
                this$0 = PhotoManagerView.this;
                super();
            }
        }).start();
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        handleClick(i);
    }

    public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
    {
        while (i == -1 || !adapter.isPossibleDragOrDropLocation(i)) 
        {
            return false;
        }
        dragX = lastTouchX;
        dragY = lastTouchY;
        isDrag = true;
        dragIndex = i;
        originalView = view;
        selectedPosition = getFirstVisiblePosition();
        dragOffsetX = lastTouchX - view.getLeft() - (lastTouchRawX - lastTouchX);
        dragOffsetY = lastTouchY - view.getTop() - (lastTouchRawY - lastTouchY);
        startDrag();
        drag(dragX, dragY);
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        lastTouchX = (int)motionevent.getX();
        lastTouchY = (int)motionevent.getY();
        lastTouchRawX = (int)motionevent.getRawX();
        lastTouchRawY = (int)motionevent.getRawY();
        if (isDrag) goto _L2; else goto _L1
_L1:
        boolean flag = super.onTouchEvent(motionevent);
_L4:
        return flag;
_L2:
        int i;
        flag = true;
        switch (motionevent.getAction())
        {
        default:
            return false;

        case 0: // '\0'
            break;

        case 2: // '\002'
            drag(lastTouchX, lastTouchY);
            return true;

        case 3: // '\003'
            isDrag = false;
            stopDrag();
            dragIndex = -1;
            return true;

        case 1: // '\001'
            isDrag = false;
            stopDrag();
            i = myPointToPosition(lastTouchX, lastTouchY) + getFirstVisiblePosition();
            break; /* Loop/switch isn't completed */
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (i != -1 && adapter.isPossibleDragOrDropLocation(i))
        {
            adapter.move(dragIndex, i);
        }
        dragIndex = -1;
        return true;
    }

    void setActivity(Activity activity1)
    {
        activity = activity1;
    }

    public volatile void setAdapter(Adapter adapter1)
    {
        setAdapter((ListAdapter)adapter1);
    }

    public void setAdapter(ListAdapter listadapter)
    {
        super.setAdapter(listadapter);
        adapter = (PhotoManagerViewAdapter)listadapter;
        setOnItemClickListener(this);
        setOnItemLongClickListener(this);
    }

    void setFragment(PhotoManagerFragment photomanagerfragment)
    {
        fragment = photomanagerfragment;
    }


/*
    static boolean access$002(PhotoManagerView photomanagerview, boolean flag)
    {
        photomanagerview.canScroll = flag;
        return flag;
    }

*/

}
