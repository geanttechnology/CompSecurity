// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.error;

import java.util.List;

// Referenced classes of package com.groupon.models.error:
//            GrouponException

public class GoogleAuthenticationException extends GrouponException
{

    public String email;
    public String errorCode;
    public List requiredScopes;

    public GoogleAuthenticationException(int i, String s)
    {
        super(i, s);
    }
}
