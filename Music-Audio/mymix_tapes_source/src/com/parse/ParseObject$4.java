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
            if (ParseObject.access$000(((ParseObject) (obj))) != null && ((ParseObject) (obj)).isDataAvailable())
            {
                val$fetchedObjects.put(ParseObject.access$000(((ParseObject) (obj))), obj);
            }
        }
        return true;
    }

    ()
    {
        this$0 = final_parseobject;
        val$fetchedObjects = Map.this;
        super();
    }
}
