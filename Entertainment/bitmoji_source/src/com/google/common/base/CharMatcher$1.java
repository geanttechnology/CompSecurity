// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;


// Referenced classes of package com.google.common.base:
//            CharMatcher

class gatedFastMatcher extends gatedFastMatcher
{

    final CharMatcher this$0;
    final String val$description;

    public String toString()
    {
        return val$description;
    }

    gatedFastMatcher(String s)
    {
        this$0 = final_charmatcher;
        val$description = s;
        super(CharMatcher.this);
    }
}
