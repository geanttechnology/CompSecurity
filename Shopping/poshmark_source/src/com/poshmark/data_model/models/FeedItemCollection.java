// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.utils.ItemPair;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.poshmark.data_model.models:
//            PMData, ListingSummaryCollection, ListingSummary

public class FeedItemCollection extends PMData
{

    List data;

    public FeedItemCollection()
    {
        data = new ArrayList();
    }

    public void append(PMData pmdata)
    {
        if (data != null && pmdata != null)
        {
            pmdata = (ListingSummaryCollection)pmdata;
        }
    }

    public void fillCursor(CustomMatrixCursor custommatrixcursor)
    {
        if (data == null)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        List list = data;
        list;
        JVM INSTR monitorenter ;
        int j;
        int k;
        j = data.size();
        k = j / 2;
        int i = 0;
_L2:
        if (i >= k * 2)
        {
            break; /* Loop/switch isn't completed */
        }
        custommatrixcursor.addRow(new Object[] {
            Integer.valueOf(0), new ItemPair((ListingSummary)data.get(i), (ListingSummary)data.get(i + 1))
        });
        i += 2;
        if (true) goto _L2; else goto _L1
_L1:
        if (j % 2 == 0)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        custommatrixcursor.addRow(new Object[] {
            Integer.valueOf(0), new ItemPair((ListingSummary)data.get(j - 1), null)
        });
        list;
        JVM INSTR monitorexit ;
        return;
        custommatrixcursor;
        list;
        JVM INSTR monitorexit ;
        throw custommatrixcursor;
    }

    public void setData(List list)
    {
        data = list;
    }
}
