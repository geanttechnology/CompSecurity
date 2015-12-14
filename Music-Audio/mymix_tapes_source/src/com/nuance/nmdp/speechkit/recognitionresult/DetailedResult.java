// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit.recognitionresult;

import java.util.List;

// Referenced classes of package com.nuance.nmdp.speechkit.recognitionresult:
//            Token

public interface DetailedResult
{

    public abstract List getAlternatives(int i, int j);

    public abstract double getConfidenceScore();

    public abstract Token getTokenAtCursorPosition(int i);

    public abstract List getTokens();

    public abstract String toString();
}
