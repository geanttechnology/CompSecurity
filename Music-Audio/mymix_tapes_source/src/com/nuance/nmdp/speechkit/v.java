// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;


// Referenced classes of package com.nuance.nmdp.speechkit:
//            SpeechError

final class v
    implements SpeechError
{

    private final int a;
    private final String b;
    private final String c;

    public v(int i, String s, String s1)
    {
        a = i;
        c = s1;
        if (s != null) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 1 5: default 52
    //                   1 61
    //                   2 67
    //                   3 52
    //                   4 52
    //                   5 73;
           goto _L3 _L4 _L5 _L3 _L3 _L6
_L3:
        s = "An error occurred.";
_L2:
        b = s;
        return;
_L4:
        s = "Failed to connect to speech server.";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "Please retry your query.";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "Query cancelled.";
        if (true) goto _L2; else goto _L7
_L7:
    }

    public final int getErrorCode()
    {
        return a;
    }

    public final String getErrorDetail()
    {
        return b;
    }

    public final String getSuggestion()
    {
        return c;
    }
}
