// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flow.android.engine.library.objectinfo;

import android.graphics.PointF;
import com.a9.vs.mobile.library.impl.jni.ObjectInfo;
import com.a9.vs.mobile.library.impl.jni.Point2f;
import com.a9.vs.mobile.library.impl.jni.VectorOfPoint2f;
import com.a9.vs.mobile.library.impl.jni.VectorOfString;
import java.util.ArrayList;
import java.util.List;

public class FlowObjectInfo
{
    public static class PointsAndCentroid
    {

        public PointF m_centroid;
        public ArrayList m_points;

        public PointsAndCentroid()
        {
            m_points = new ArrayList(4);
        }
    }


    protected ObjectInfo m_objectInfo;
    private PointsAndCentroid m_pointsAndCentroid;

    public FlowObjectInfo(ObjectInfo objectinfo)
    {
        m_pointsAndCentroid = null;
        m_objectInfo = objectinfo;
    }

    protected static List getListOfStrings(VectorOfString vectorofstring)
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; (long)i < vectorofstring.size(); i++)
        {
            arraylist.add(vectorofstring.get(i));
        }

        return arraylist;
    }

    public static ArrayList getPoints(VectorOfPoint2f vectorofpoint2f)
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; (long)i < vectorofpoint2f.size(); i++)
        {
            Point2f point2f = vectorofpoint2f.get(i);
            arraylist.add(new PointF(point2f.getX(), point2f.getY()));
        }

        return arraylist;
    }

    public static PointsAndCentroid getPointsAndCentroid(VectorOfPoint2f vectorofpoint2f)
    {
        PointsAndCentroid pointsandcentroid = new PointsAndCentroid();
        float f1 = 0.0F;
        float f = 0.0F;
        for (int i = 0; (long)i < vectorofpoint2f.size(); i++)
        {
            Point2f point2f = vectorofpoint2f.get(i);
            pointsandcentroid.m_points.add(new PointF(point2f.getX(), point2f.getY()));
            f1 += point2f.getX();
            f += point2f.getY();
        }

        if (vectorofpoint2f.size() > 0L)
        {
            pointsandcentroid.m_centroid = new PointF(f1 * (1.0F / (float)vectorofpoint2f.size()), f * (1.0F / (float)vectorofpoint2f.size()));
            return pointsandcentroid;
        } else
        {
            pointsandcentroid.m_centroid = new PointF(-1F, -1F);
            return pointsandcentroid;
        }
    }
}
