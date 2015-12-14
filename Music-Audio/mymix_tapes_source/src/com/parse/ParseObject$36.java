// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Capture;

// Referenced classes of package com.parse:
//            ParseTraverser, ParseObject

class <init> extends ParseTraverser
{

    final ParseObject this$0;
    final Capture val$result;

    protected boolean visit(Object obj)
    {
        if ((obj instanceof ParseObject) && ((ParseObject)obj).getObjectId() == null)
        {
            val$result.set(Boolean.valueOf(false));
        }
        return ((Boolean)val$result.get()).booleanValue();
    }

    ()
    {
        this$0 = final_parseobject;
        val$result = Capture.this;
        super();
    }
}
