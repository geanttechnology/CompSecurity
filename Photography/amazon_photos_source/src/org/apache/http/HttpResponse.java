// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http;


// Referenced classes of package org.apache.http:
//            HttpMessage, HttpEntity, StatusLine

public interface HttpResponse
    extends HttpMessage
{

    public abstract HttpEntity getEntity();

    public abstract StatusLine getStatusLine();

    public abstract void setEntity(HttpEntity httpentity);

    public abstract void setStatusLine(StatusLine statusline);
}
