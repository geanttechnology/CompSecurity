// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.client;

import java.io.IOException;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpStatus;

public interface ClientHttpResponse
    extends HttpInputMessage
{

    public abstract void close();

    public abstract int getRawStatusCode()
        throws IOException;

    public abstract HttpStatus getStatusCode()
        throws IOException;

    public abstract String getStatusText()
        throws IOException;
}
