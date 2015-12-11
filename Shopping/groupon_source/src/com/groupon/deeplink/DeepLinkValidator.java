// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.deeplink;


// Referenced classes of package com.groupon.deeplink:
//            InvalidDeepLinkException

public interface DeepLinkValidator
{

    public abstract boolean validateDeepLink(String s)
        throws InvalidDeepLinkException;
}
