// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http;

import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package org.springframework.http:
//            HttpMessage

public interface HttpOutputMessage
    extends HttpMessage
{

    public abstract OutputStream getBody()
        throws IOException;
}
