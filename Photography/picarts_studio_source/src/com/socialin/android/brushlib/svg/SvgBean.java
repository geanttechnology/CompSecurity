// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.svg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.socialin.android.brushlib.svg:
//            GradientBean, NodeBean

public class SvgBean
    implements Serializable, Cloneable
{

    private float cHeight;
    private float cWidth;
    private float centerX;
    private float centerY;
    private float currentHeight;
    private float currentWidth;
    public HashMap gradientCollection;
    private float h;
    private float minx;
    private float miny;
    ArrayList nodeList;
    private short originalHeight;
    private short originalWidth;
    private float previousTouchX;
    private float previousTouchY;
    private float rotateAngle;
    private float scaleProportionX;
    private float scaleProportionY;
    private boolean selected;
    private float startAngle;
    private float upX;
    private float upY;
    private float w;

    public SvgBean()
    {
        originalWidth = 0;
        originalHeight = 0;
        currentWidth = 0.0F;
        currentHeight = 0.0F;
        cWidth = 0.0F;
        cHeight = 0.0F;
        upX = 0.0F;
        upY = 0.0F;
        centerX = 0.0F;
        centerY = 0.0F;
        selected = false;
        scaleProportionX = 1.0F;
        scaleProportionY = 1.0F;
        startAngle = 0.0F;
        rotateAngle = 0.0F;
        minx = 0.0F;
        miny = 0.0F;
        w = 0.0F;
        h = 0.0F;
        nodeList = new ArrayList();
        gradientCollection = new HashMap();
        previousTouchX = 0.0F;
        previousTouchY = 0.0F;
    }

    public void addToGradientCollection(String s, GradientBean gradientbean)
    {
        gradientCollection.put(s, gradientbean);
    }

    public void addToNodeList(NodeBean nodebean)
    {
        nodeList.add(nodebean);
    }

    public Object clone()
    {
        Object obj;
        try
        {
            obj = super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            return null;
        }
        return obj;
    }

    public float getCenterX()
    {
        return centerX;
    }

    public float getCenterY()
    {
        return centerY;
    }

    public float getCurrentHeight()
    {
        return currentHeight;
    }

    public float getCurrentWidth()
    {
        return currentWidth;
    }

    public float getH()
    {
        return h;
    }

    public float getMinx()
    {
        return minx;
    }

    public float getMiny()
    {
        return miny;
    }

    public ArrayList getNodeList()
    {
        return nodeList;
    }

    public short getOriginalHeight()
    {
        return originalHeight;
    }

    public short getOriginalWidth()
    {
        return originalWidth;
    }

    public float getPreviousTouchX()
    {
        return previousTouchX;
    }

    public float getPreviousTouchY()
    {
        return previousTouchY;
    }

    public float getRotateAngle()
    {
        return rotateAngle;
    }

    public float getScaleProportionX()
    {
        return scaleProportionX;
    }

    public float getScaleProportionY()
    {
        return scaleProportionY;
    }

    public GradientBean getShader(String s)
    {
        return (GradientBean)gradientCollection.get(s);
    }

    public float getStartAngle()
    {
        return startAngle;
    }

    public float getUpX()
    {
        return upX;
    }

    public float getUpY()
    {
        return upY;
    }

    public float getW()
    {
        return w;
    }

    public float getcHeight()
    {
        return cHeight;
    }

    public float getcWidth()
    {
        return cWidth;
    }

    public boolean isSelected()
    {
        return selected;
    }

    public void setCenterX(float f)
    {
        centerX = f;
    }

    public void setCenterY(float f)
    {
        centerY = f;
    }

    public void setCurrentHeight(float f)
    {
        currentHeight = f;
    }

    public void setCurrentWidth(float f)
    {
        currentWidth = f;
    }

    public void setMinx(float f)
    {
        minx = f;
    }

    public void setMiny(float f)
    {
        miny = f;
    }

    public void setNodeList(ArrayList arraylist)
    {
        nodeList = arraylist;
    }

    public void setOriginalHeight(short word0)
    {
        originalHeight = word0;
    }

    public void setOriginalWidth(short word0)
    {
        originalWidth = word0;
    }

    public void setPreviousTouchX(float f)
    {
        previousTouchX = f;
    }

    public void setPreviousTouchY(float f)
    {
        previousTouchY = f;
    }

    public void setRotateAngle(float f)
    {
        rotateAngle = f;
    }

    public void setScaleProportionX(float f)
    {
        scaleProportionX = f;
    }

    public void setScaleProportionY(float f)
    {
        scaleProportionY = f;
    }

    public void setSelected(boolean flag)
    {
        selected = flag;
    }

    public void setStartAngle(float f)
    {
        startAngle = f;
    }

    public void setUpX(float f)
    {
        upX = f;
    }

    public void setUpY(float f)
    {
        upY = f;
    }

    public void setcHeight(float f)
    {
        cHeight = f;
    }

    public void setcWidth(float f)
    {
        cWidth = f;
    }
}
