// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.Reader;
import java.io.StringReader;

// Referenced classes of package com.tapjoy.internal:
//            bv, bu

static final class  extends 
{

    public final bu a(Reader reader)
    {
        return new bv(reader);
    }

    public final bu a(String s)
    {
        return new bv(new StringReader(s));
    }

    ()
    {
    }
}
