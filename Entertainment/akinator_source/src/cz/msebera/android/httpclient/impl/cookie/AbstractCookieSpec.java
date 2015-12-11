// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.cookie.CookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.CookieSpec;
import cz.msebera.android.httpclient.util.Args;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCookieSpec
    implements CookieSpec
{

    private final Map attribHandlerMap = new HashMap(10);

    public AbstractCookieSpec()
    {
    }

    protected CookieAttributeHandler findAttribHandler(String s)
    {
        return (CookieAttributeHandler)attribHandlerMap.get(s);
    }

    protected CookieAttributeHandler getAttribHandler(String s)
    {
        CookieAttributeHandler cookieattributehandler = findAttribHandler(s);
        if (cookieattributehandler == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("Handler not registered for ").append(s).append(" attribute.").toString());
        } else
        {
            return cookieattributehandler;
        }
    }

    protected Collection getAttribHandlers()
    {
        return attribHandlerMap.values();
    }

    public void registerAttribHandler(String s, CookieAttributeHandler cookieattributehandler)
    {
        Args.notNull(s, "Attribute name");
        Args.notNull(cookieattributehandler, "Attribute handler");
        attribHandlerMap.put(s, cookieattributehandler);
    }
}
