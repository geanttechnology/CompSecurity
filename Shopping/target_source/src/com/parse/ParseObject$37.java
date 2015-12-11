// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.h;

// Referenced classes of package com.parse:
//            ParseTraverser, ParseObject, ParseFile

class <init> extends ParseTraverser
{

    final ParseObject this$0;
    final h val$result;

    protected boolean visit(Object obj)
    {
        if ((obj instanceof ParseFile) && ((ParseFile)obj).isDirty())
        {
            val$result.a(Boolean.valueOf(false));
        }
        if ((obj instanceof ParseObject) && ((ParseObject)obj).getObjectId() == null)
        {
            val$result.a(Boolean.valueOf(false));
        }
        return ((Boolean)val$result.a()).booleanValue();
    }

    ()
    {
        this$0 = final_parseobject;
        val$result = h.this;
        super();
    }
}
