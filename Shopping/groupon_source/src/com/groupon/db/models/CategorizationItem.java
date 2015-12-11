// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.groupon.db.models:
//            Deal

public class CategorizationItem
{

    protected Collection children;
    protected volatile ArrayList childrenList;
    public String friendlyName;
    public String id;
    public CategorizationItem parentCategorizationItem;
    public Deal parentDeal;
    public Long primaryKey;
    public String uuid;

    public CategorizationItem()
    {
        children = Collections.emptyList();
    }

    public List getChildren()
    {
        if (childrenList != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (childrenList == null)
        {
            childrenList = new ArrayList(children);
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        return childrenList;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setChildren(Collection collection)
    {
        Object obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        for (collection = ((Collection) (obj)).iterator(); collection.hasNext();)
        {
            ((CategorizationItem)collection.next()).parentCategorizationItem = this;
        }

        children = ((Collection) (obj));
    }
}
