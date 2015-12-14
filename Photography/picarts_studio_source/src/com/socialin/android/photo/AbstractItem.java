// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo;

import android.content.Context;

// Referenced classes of package com.socialin.android.photo:
//            Item

public abstract class AbstractItem
    implements Item
{

    public float X;
    public float Y;
    public float centerX;
    public float centerY;
    public float curHeight;
    public float curWidth;
    public float imageLeft;
    public float imageTop;
    public float imageZoom;
    public boolean isActive;
    public boolean isDrawHandle;
    public int opacity;
    public float rotateDegree;
    public float scaleX;
    public float scaleY;

    public AbstractItem()
    {
        curWidth = 0.0F;
        curHeight = 0.0F;
        centerX = 0.0F;
        centerY = 0.0F;
        imageZoom = 1.0F;
        imageLeft = 0.0F;
        imageTop = 0.0F;
        rotateDegree = 0.0F;
        X = 10F;
        Y = 10F;
        scaleX = 1.0F;
        scaleY = 1.0F;
        isActive = true;
        isDrawHandle = false;
        opacity = 255;
    }

    public void clearData()
    {
    }

    public float getHeight()
    {
        return curHeight;
    }

    public float getImageLeft()
    {
        return imageLeft;
    }

    public float getImageTop()
    {
        return imageTop;
    }

    public float getImageZoom()
    {
        return imageZoom;
    }

    public int getOpacity()
    {
        return opacity;
    }

    public float getRotation()
    {
        return rotateDegree;
    }

    public float getScaleX()
    {
        return scaleX;
    }

    public float getScaleY()
    {
        return scaleY;
    }

    public float getWidth()
    {
        return curWidth;
    }

    public float getX()
    {
        return X;
    }

    public float getY()
    {
        return Y;
    }

    public void initSpecStateObjects(Context context)
    {
    }

    public boolean isActive()
    {
        return isActive;
    }

    public boolean isDrawHandle()
    {
        return isDrawHandle;
    }

    public void setActive(boolean flag)
    {
        isActive = flag;
    }

    public void setDrawHandle(boolean flag)
    {
        isDrawHandle = flag;
    }
}
