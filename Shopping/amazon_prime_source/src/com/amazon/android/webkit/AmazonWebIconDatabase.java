// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;


// Referenced classes of package com.amazon.android.webkit:
//            AmazonIconListener

public abstract class AmazonWebIconDatabase
{

    public AmazonWebIconDatabase()
    {
    }

    public abstract void close();

    public abstract void open(String s);

    public abstract void releaseIconForPageUrl(String s);

    public abstract void removeAllIcons();

    public abstract void requestIconForPageUrl(String s, AmazonIconListener amazoniconlistener);

    public abstract void retainIconForPageUrl(String s);
}
