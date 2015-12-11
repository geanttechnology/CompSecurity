// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.poshmark.data_model.models:
//            PMData

public class ShowroomGroupList extends PMData
{

    List data;
    PMData.NextMaxID more;

    public ShowroomGroupList()
    {
        data = Collections.synchronizedList(new ArrayList());
        more = null;
    }

    public List getList()
    {
        return data;
    }
}
