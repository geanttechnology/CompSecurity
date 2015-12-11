// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io.parsing;

import java.io.IOException;

// Referenced classes of package com.flurry.org.apache.avro.io.parsing:
//            SkipParser

public static interface 
{

    public abstract void skipAction()
        throws IOException;

    public abstract void skipTopSymbol()
        throws IOException;
}
