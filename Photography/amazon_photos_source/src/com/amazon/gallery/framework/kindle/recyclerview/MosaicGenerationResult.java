// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.recyclerview;

import android.graphics.RectF;
import android.util.SparseArray;

public class MosaicGenerationResult
{

    private SparseArray groups;
    private RectF pageBounds;
    private SparseArray rectGroups;

    public MosaicGenerationResult()
    {
        rectGroups = new SparseArray();
        groups = new SparseArray();
        pageBounds = new RectF();
    }

    public int getGroup(int i)
    {
        if (groups.get(i) != null)
        {
            return ((Integer)groups.get(i)).intValue();
        } else
        {
            return -1;
        }
    }

    public int getOffsetFromGroupEnd(int i, int j)
    {
        j++;
        int k = 0;
        int i1 = ((SparseArray)rectGroups.valueAt(i)).size();
        for (int l = getGroup(j); j < i1 && l != -1 && l == i; l = getGroup(j))
        {
            k++;
            j++;
        }

        return k;
    }

    public int getOffsetFromGroupStart(int i, int j)
    {
        j--;
        int k = 0;
        for (int l = getGroup(j); j >= 0 && l != -1 && l == i; l = getGroup(j))
        {
            k--;
            j--;
        }

        return k;
    }

    public RectF getRectForPosition(int i)
    {
        int j = getGroup(i);
        if (j >= 0)
        {
            return (RectF)((SparseArray)rectGroups.get(j)).get(i);
        } else
        {
            return null;
        }
    }

    public SparseArray getRectsForGroup(int i)
    {
        return (SparseArray)rectGroups.get(i);
    }

    public void setPageBounds(RectF rectf)
    {
        pageBounds.set(rectf);
    }

    public void setRect(int i, RectF rectf, int j)
    {
        groups.put(i, Integer.valueOf(j));
        if (rectGroups.get(j) == null)
        {
            rectGroups.put(j, new SparseArray());
            ((SparseArray)rectGroups.get(j)).put(i, new RectF(rectf));
            return;
        }
        SparseArray sparsearray = (SparseArray)rectGroups.get(j);
        if (sparsearray.get(i) == null)
        {
            sparsearray.put(i, new RectF(rectf));
            return;
        } else
        {
            ((RectF)sparsearray.get(i)).set(rectf);
            return;
        }
    }
}
