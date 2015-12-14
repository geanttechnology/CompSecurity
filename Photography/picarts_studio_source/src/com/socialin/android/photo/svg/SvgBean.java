// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.svg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.socialin.android.photo.svg:
//            GradientBean, NodeBean

public class SvgBean
    implements Serializable
{

    private HashMap gradientCollection;
    private ArrayList nodeList;
    private float originalHeight;
    private float originalWidth;

    public SvgBean()
    {
        originalWidth = 0.0F;
        originalHeight = 0.0F;
        nodeList = new ArrayList();
        gradientCollection = new HashMap();
    }

    public void addToGradientCollection(String s, GradientBean gradientbean)
    {
        gradientCollection.put(s, gradientbean);
    }

    public void addToNodeList(NodeBean nodebean)
    {
        nodeList.add(nodebean);
    }

    public List getNodeList()
    {
        return nodeList;
    }

    public float getOriginalHeight()
    {
        return originalHeight;
    }

    public float getOriginalWidth()
    {
        return originalWidth;
    }

    public GradientBean getShader(String s)
    {
        return (GradientBean)gradientCollection.get(s);
    }

    public void setDistance(float f)
    {
    }

    public void setOriginalHeight(float f)
    {
        originalHeight = f;
    }

    public void setOriginalWidth(float f)
    {
        originalWidth = f;
    }

    public void setPerpendicularDistance(float f)
    {
    }
}
