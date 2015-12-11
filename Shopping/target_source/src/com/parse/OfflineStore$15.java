// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.ArrayList;

// Referenced classes of package com.parse:
//            ParseTraverser, OfflineStore, ParseObject

class init> extends ParseTraverser
{

    final OfflineStore this$0;
    final ArrayList val$objectsInTree;

    protected boolean visit(Object obj)
    {
        if (obj instanceof ParseObject)
        {
            val$objectsInTree.add((ParseObject)obj);
        }
        return true;
    }

    ()
    {
        this$0 = final_offlinestore;
        val$objectsInTree = ArrayList.this;
        super();
    }
}
