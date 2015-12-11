// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.widget;

import java.util.ArrayList;

// Referenced classes of package it.sephiroth.android.library.widget:
//            ExpandableHListConnector, ExpandableHListPosition

public static class 
{

    private static ArrayList sPool = new ArrayList(5);
    public int groupInsertIndex;
    public sPool groupMetadata;
    public ExpandableHListPosition position;

    private static  getRecycledOrCreate()
    {
label0:
        {
             ;
            synchronized (sPool)
            {
                if (sPool.size() <= 0)
                {
                    break label0;
                }
                 = (sPool)sPool.remove(0);
            }
            .resetState();
            return ;
        }
         1 = new <init>();
        arraylist;
        JVM INSTR monitorexit ;
        return 1;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static <init> obtain(int i, int j, int k, int l, <init> <init>1, int i1)
    {
        <init> <init>2 = getRecycledOrCreate();
        <init>2.position = ExpandableHListPosition.obtain(j, k, l, i);
        <init>2.groupMetadata = <init>1;
        <init>2.groupInsertIndex = i1;
        return <init>2;
    }

    private void resetState()
    {
        if (position != null)
        {
            position.recycle();
            position = null;
        }
        groupMetadata = null;
        groupInsertIndex = 0;
    }

    public boolean isExpanded()
    {
        return groupMetadata != null;
    }

    public void recycle()
    {
        resetState();
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


    private ()
    {
    }
}
