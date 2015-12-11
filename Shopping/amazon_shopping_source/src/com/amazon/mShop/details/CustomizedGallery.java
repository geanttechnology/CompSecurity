// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Gallery;
import com.amazon.mShop.net.RefMarkerObserver;
import java.util.HashMap;
import java.util.Map;

public class CustomizedGallery extends Gallery
{

    private ProductImagesView.MoveAction mAction;
    public Map mGalleryImageStatus;

    public CustomizedGallery(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mGalleryImageStatus = new HashMap();
    }

    private boolean isScrollingLeft(MotionEvent motionevent, MotionEvent motionevent1)
    {
        return motionevent1.getX() > motionevent.getX();
    }

    private void logImageStatusRefMarker(String s, String s1)
    {
        Map map = (Map)mGalleryImageStatus.get(Integer.valueOf(getSelectedItemPosition() + 1));
        if (map != null)
        {
            Boolean boolean1 = (Boolean)map.get(s);
            if (boolean1 == null || boolean1.equals(Boolean.FALSE))
            {
                RefMarkerObserver.logRefMarker(s1);
                map.put(s, Boolean.valueOf(true));
            }
            return;
        } else
        {
            RefMarkerObserver.logRefMarker(s1);
            s1 = new HashMap();
            s1.put(s, Boolean.valueOf(true));
            mGalleryImageStatus.put(Integer.valueOf(getSelectedItemPosition() + 1), s1);
            return;
        }
    }

    public ProductImagesView.MoveAction getAction()
    {
        return mAction;
    }

    public void logImageViewedRefMarker()
    {
        logImageStatusRefMarker("image_viewed", String.format("dp_img_%1$d", new Object[] {
            Integer.valueOf(getSelectedItemPosition() + 1)
        }));
    }

    public void logImageZoomedRefMarker()
    {
        logImageStatusRefMarker("image_zoomed", String.format("dp_img_%1$d_z", new Object[] {
            Integer.valueOf(getSelectedItemPosition() + 1)
        }));
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        byte byte0;
        if (isScrollingLeft(motionevent, motionevent1))
        {
            byte0 = 21;
        } else
        {
            byte0 = 22;
        }
        onKeyDown(byte0, null);
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag = true;
        if (motionevent.getPointerCount() == 1)
        {
            flag = super.onTouchEvent(motionevent);
        }
        return flag;
    }

    public void setAction(ProductImagesView.MoveAction moveaction)
    {
        mAction = moveaction;
    }

    public void setSelection(int i)
    {
        if (i <= getSelectedItemPosition()) goto _L2; else goto _L1
_L1:
        mAction = ProductImagesView.MoveAction.RIGHT;
_L4:
        super.setSelection(i);
        return;
_L2:
        if (i < getSelectedItemPosition())
        {
            mAction = ProductImagesView.MoveAction.LEFT;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
