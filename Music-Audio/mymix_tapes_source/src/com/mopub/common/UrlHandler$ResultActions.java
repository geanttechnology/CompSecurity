// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;


// Referenced classes of package com.mopub.common:
//            UrlHandler, UrlAction

public static interface 
{

    public abstract void urlHandlingFailed(String s, UrlAction urlaction);

    public abstract void urlHandlingSucceeded(String s, UrlAction urlaction);
}
