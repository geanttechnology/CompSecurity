// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid;

import java.util.Locale;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid:
//            HttpMessage, HttpEntity, StatusLine

public interface HttpResponse
    extends HttpMessage
{

    public abstract HttpEntity getEntity();

    public abstract Locale getLocale();

    public abstract StatusLine getStatusLine();

    public abstract void setEntity(HttpEntity httpentity);

    public abstract void setLocale(Locale locale);

    public abstract void setReasonPhrase(String s)
        throws IllegalStateException;

    public abstract void setStatusCode(int i)
        throws IllegalStateException;

    public abstract void setStatusLine(StatusLine statusline);
}
