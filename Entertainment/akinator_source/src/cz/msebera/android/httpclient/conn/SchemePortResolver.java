// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.HttpHost;

// Referenced classes of package cz.msebera.android.httpclient.conn:
//            UnsupportedSchemeException

public interface SchemePortResolver
{

    public abstract int resolve(HttpHost httphost)
        throws UnsupportedSchemeException;
}
