// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.web.client;

import java.io.IOException;
import org.springframework.http.client.ClientHttpRequest;

public interface RequestCallback
{

    public abstract void doWithRequest(ClientHttpRequest clienthttprequest)
        throws IOException;
}
