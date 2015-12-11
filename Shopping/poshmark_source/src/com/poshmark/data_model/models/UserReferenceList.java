// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.inner_models.UserReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.poshmark.data_model.models:
//            PMData

public class UserReferenceList extends PMData
{

    List data;
    public PMData.NextMaxID meta;
    public PMData.NextMaxID more;

    public UserReferenceList()
    {
        data = new ArrayList();
        more = null;
        meta = null;
    }

    public void append(PMData pmdata)
    {
        if (data != null && pmdata != null)
        {
            pmdata = (UserReferenceList)pmdata;
            data.addAll(((UserReferenceList) (pmdata)).data);
            more = ((UserReferenceList) (pmdata)).more;
            meta = ((UserReferenceList) (pmdata)).meta;
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
    Integer.valueOf(0), (UserReference)iterator.next()
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

    public List getConnectionInfoList()
    {
        return data;
    }

    public String getNextPageMaxValue()
    {
        if (meta != null)
        {
            return meta.next_max_id;
        }
        if (more != null)
        {
            return more.next_max_id;
        } else
        {
            return null;
        }
    }

    public boolean isEmpty()
    {
        return data == null || data.size() == 0;
    }
}
