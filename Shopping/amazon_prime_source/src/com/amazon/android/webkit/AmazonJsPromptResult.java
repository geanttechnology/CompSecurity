// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;


// Referenced classes of package com.amazon.android.webkit:
//            AmazonJsResult

public abstract class AmazonJsPromptResult extends AmazonJsResult
{

    public AmazonJsPromptResult()
    {
    }

    public void cancel()
    {
        confirm(null);
    }

    public abstract void confirm(String s);
}
