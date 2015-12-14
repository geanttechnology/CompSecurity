// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.LinkedHashMap;

// Referenced classes of package com.parse:
//            ParseAnalytics

static final class  extends LinkedHashMap
{

    protected boolean removeEldestEntry(java.util. )
    {
        return size() > 10;
    }

    ()
    {
    }
}
