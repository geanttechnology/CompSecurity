// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.Map;

// Referenced classes of package com.parse:
//            ParseTraverser, ParseObject

class  extends ParseTraverser
{

    final ParseObject this$0;
    final Map val$fetchedObjects;

    protected boolean visit(Object obj)
    {
        if (obj instanceof ParseObject)
        {
            obj = (ParseObject)obj;
            ate ate = ((ParseObject) (obj)).getState();
            if (ate.objectId() != null && ate.isComplete())
            {
                val$fetchedObjects.put(ate.objectId(), obj);
            }
        }
        return true;
    }

    ate()
    {
        this$0 = final_parseobject;
        val$fetchedObjects = Map.this;
        super();
    }
}
