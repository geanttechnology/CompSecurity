// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.svg;

import android.graphics.Paint;
import java.io.Serializable;
import java.util.ArrayList;

// Referenced classes of package com.socialin.android.brushlib.svg:
//            NodeAttributeBean

public class NodeBean
    implements Serializable
{

    private float blurRadius;
    private boolean changable;
    private ArrayList nodeAttributeBeanList;
    private int opacity;
    private transient Paint paint;
    private String shader;
    private int strokeColor;

    public NodeBean()
    {
        shader = "noShader";
        strokeColor = -256;
        opacity = 0;
        changable = false;
        blurRadius = 0.0F;
        nodeAttributeBeanList = new ArrayList();
    }

    public void addToNodeAttributeBeanList(NodeAttributeBean nodeattributebean)
    {
        nodeAttributeBeanList.add(nodeattributebean);
    }

    public float getBlurRadius()
    {
        return blurRadius;
    }

    public boolean getChangable()
    {
        return changable;
    }

    public ArrayList getNodeAttributeBeanList()
    {
        return nodeAttributeBeanList;
    }

    public int getOpacity()
    {
        return opacity;
    }

    public Paint getPaint()
    {
        return paint;
    }

    public String getShader()
    {
        return shader;
    }

    public int getStrokeColor()
    {
        return strokeColor;
    }

    public boolean isBlurred()
    {
        return blurRadius > 0.0F;
    }

    public void setBlurRadius(float f)
    {
        blurRadius = f;
    }

    public void setChangable(boolean flag)
    {
        changable = flag;
    }

    public void setNodeAttributeBeanList(ArrayList arraylist)
    {
        nodeAttributeBeanList = arraylist;
    }

    public void setOpacity(int i)
    {
        opacity = i;
    }

    public void setPaint(Paint paint1)
    {
        paint = paint1;
    }

    public void setShader(String s)
    {
        shader = s;
    }

    public void setStrokeColor(int i)
    {
        strokeColor = i;
    }
}
