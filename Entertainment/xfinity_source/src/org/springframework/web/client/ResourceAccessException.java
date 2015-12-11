// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.web.client;

import java.io.IOException;

// Referenced classes of package org.springframework.web.client:
//            RestClientException

public class ResourceAccessException extends RestClientException
{

    public ResourceAccessException(String s, IOException ioexception)
    {
        super(s, ioexception);
    }
}
