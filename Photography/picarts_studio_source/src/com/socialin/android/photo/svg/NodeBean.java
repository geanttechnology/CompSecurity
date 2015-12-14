// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.svg;

import android.graphics.Path;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.socialin.android.photo.svg:
//            NodeAttributeBean

public class NodeBean
    implements Serializable
{

    private float blurRadius;
    private int color;
    private ArrayList nodeAttributeBeanList;
    private int opacity;
    private transient Path path;
    private String shader;
    private android.graphics.Paint.Cap strokeCap;
    private int strokeColor;
    private boolean strokeColorSet;
    private android.graphics.Paint.Join strokeJoin;
    private float strokeWidth;
    private android.graphics.Paint.Style style;

    public NodeBean()
    {
        shader = "noShader";
        opacity = 0;
        blurRadius = 0.0F;
        nodeAttributeBeanList = new ArrayList();
        path = new Path();
    }

    public void addToNodeAttributeBeanList(NodeAttributeBean nodeattributebean)
    {
        nodeAttributeBeanList.add(nodeattributebean);
    }

    public float getBlurRadius()
    {
        return blurRadius;
    }

    public int getColor()
    {
        return color;
    }

    public List getNodeAttributeBeanList()
    {
        return nodeAttributeBeanList;
    }

    public int getOpacity()
    {
        return opacity;
    }

    public Path getPath()
    {
        return path;
    }

    public String getShader()
    {
        return shader;
    }

    public android.graphics.Paint.Cap getStrokeCap()
    {
        return strokeCap;
    }

    public int getStrokeColor()
    {
        return strokeColor;
    }

    public android.graphics.Paint.Join getStrokeJoin()
    {
        return strokeJoin;
    }

    public float getStrokeWidth()
    {
        return strokeWidth;
    }

    public android.graphics.Paint.Style getStyle()
    {
        return style;
    }

    public boolean haveStrokeColor()
    {
        return strokeColorSet;
    }

    public boolean isBlurred()
    {
        return blurRadius > 0.0F;
    }

    public void setBlurRadius(float f)
    {
        blurRadius = f;
    }

    public void setColor(int i)
    {
        color = i;
    }

    public void setOpacity(int i)
    {
        opacity = i;
    }

    public void setPath(Path path1)
    {
        path = path1;
    }

    public void setShader(String s)
    {
        shader = s;
    }

    public void setStrokeCap(android.graphics.Paint.Cap cap)
    {
        strokeCap = cap;
    }

    public void setStrokeColor(int i)
    {
        strokeColor = i;
        strokeColorSet = true;
    }

    public void setStrokeJoin(android.graphics.Paint.Join join)
    {
        strokeJoin = join;
    }

    public void setStrokeWidth(float f)
    {
        strokeWidth = f;
    }

    public void setStyle(android.graphics.Paint.Style style1)
    {
        style = style1;
    }
}
