// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit.recognitionresult;

import fd;

// Referenced classes of package com.nuance.nmdp.speechkit.recognitionresult:
//            Token

final class d
    implements Token
{

    private fd a;

    d(fd fd1)
    {
        a = fd1;
    }

    public final double getConfidenceScore()
    {
        return a.a();
    }

    public final String toString()
    {
        return a.toString();
    }
}
