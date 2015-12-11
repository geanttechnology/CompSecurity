// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.poshmark.data_model.models:
//            PMData, FeedItem

public class Feed extends PMData
{

    public List data;
    public PMData.NextMaxID more;

    public Feed()
    {
        data = new ArrayList();
        more = null;
    }

    public void append(PMData pmdata)
    {
        if (data != null && pmdata != null)
        {
            pmdata = (Feed)pmdata;
            data.addAll(((Feed) (pmdata)).data);
            more = ((Feed) (pmdata)).more;
        }
    }

    public void fillCursor(CustomMatrixCursor custommatrixcursor)
    {
        if (data == null) goto _L2; else goto _L1
_L1:
        List list = data;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = data.iterator(); iterator.hasNext(); custommatrixcursor.addRow(new Object[] {
    Integer.valueOf(0), (FeedItem)iterator.next()
})) { }
        break MISSING_BLOCK_LABEL_68;
        custommatrixcursor;
        list;
        JVM INSTR monitorexit ;
        throw custommatrixcursor;
        list;
        JVM INSTR monitorexit ;
_L2:
    }

    public String getNextPageMaxValue()
    {
        if (more != null)
        {
            return more.next_max_id;
        } else
        {
            return null;
        }
    }
}
