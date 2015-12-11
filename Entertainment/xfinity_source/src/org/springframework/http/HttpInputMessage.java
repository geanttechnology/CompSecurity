// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package org.springframework.http:
//            HttpMessage

public interface HttpInputMessage
    extends HttpMessage
{

    public abstract InputStream getBody()
        throws IOException;
}
