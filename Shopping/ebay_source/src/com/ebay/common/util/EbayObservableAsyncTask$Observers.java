// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.common.util:
//            EbayObservableAsyncTask

private static final class <init> extends HashSet
    implements <init>
{

    private static final long serialVersionUID = 1L;

    public void onError(int i, List list)
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = (new ArrayList(this)).iterator(); iterator.hasNext(); ((<init>)iterator.next()).<init>(i, list)) { }
        break MISSING_BLOCK_LABEL_47;
        list;
        this;
        JVM INSTR monitorexit ;
        throw list;
        clear();
        this;
        JVM INSTR monitorexit ;
    }

    public void onTaskComplete(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = (new ArrayList(this)).iterator(); iterator.hasNext(); ((clear)iterator.next()).mplete(obj)) { }
        break MISSING_BLOCK_LABEL_46;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        clear();
        this;
        JVM INSTR monitorexit ;
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
