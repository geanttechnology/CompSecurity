// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;

class ExpandableHListPosition
{

    private static ArrayList sPool = new ArrayList(5);
    public int childPos;
    int flatListPos;
    public int groupPos;
    public int type;

    private ExpandableHListPosition()
    {
    }

    private static ExpandableHListPosition getRecycledOrCreate()
    {
label0:
        {
            ExpandableHListPosition expandablehlistposition;
            synchronized (sPool)
            {
                if (sPool.size() <= 0)
                {
                    break label0;
                }
                expandablehlistposition = (ExpandableHListPosition)sPool.remove(0);
            }
            expandablehlistposition.resetState();
            return expandablehlistposition;
        }
        ExpandableHListPosition expandablehlistposition1 = new ExpandableHListPosition();
        arraylist;
        JVM INSTR monitorexit ;
        return expandablehlistposition1;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static ExpandableHListPosition obtain(int i, int j, int k, int l)
    {
        ExpandableHListPosition expandablehlistposition = getRecycledOrCreate();
        expandablehlistposition.type = i;
        expandablehlistposition.groupPos = j;
        expandablehlistposition.childPos = k;
        expandablehlistposition.flatListPos = l;
        return expandablehlistposition;
    }

    static ExpandableHListPosition obtainGroupPosition(int i)
    {
        return obtain(2, i, 0, 0);
    }

    private void resetState()
    {
        groupPos = 0;
        childPos = 0;
        flatListPos = 0;
        type = 0;
    }

    long getPackedPosition()
    {
        if (type == 1)
        {
            return ExpandableListView.getPackedPositionForChild(groupPos, childPos);
        } else
        {
            return ExpandableListView.getPackedPositionForGroup(groupPos);
        }
    }

    public void recycle()
    {
        synchronized (sPool)
        {
            if (sPool.size() < 5)
            {
                sPool.add(this);
            }
        }
        return;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
