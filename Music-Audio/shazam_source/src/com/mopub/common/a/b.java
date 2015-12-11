// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.a;


// Referenced classes of package com.mopub.common.a:
//            a

public final class b extends a
{

    final String E;
    final String F;
    final String G;
    final String H;
    final String I;
    final String J;
    final Integer K;

    public final String toString()
    {
        String s = super.toString();
        return (new StringBuilder()).append(s).append("ErrorEvent\nErrorExceptionClassName: ").append(E).append("\nErrorMessage: ").append(F).append("\nErrorStackTrace: ").append(G).append("\nErrorFileName: ").append(H).append("\nErrorClassName: ").append(I).append("\nErrorMethodName: ").append(J).append("\nErrorLineNumber: ").append(K).append("\n").toString();
    }
}
