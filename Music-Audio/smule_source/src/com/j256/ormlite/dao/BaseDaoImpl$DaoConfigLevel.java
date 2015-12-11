// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.dao;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.j256.ormlite.dao:
//            BaseDaoImpl

class <init>
{

    List daoList;
    int level;

    public void addDao(BaseDaoImpl basedaoimpl)
    {
        if (daoList == null)
        {
            daoList = new ArrayList();
        }
        daoList.add(basedaoimpl);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
