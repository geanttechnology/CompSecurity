// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.cookie;

import cz.msebera.android.httpclient.params.HttpParams;

// Referenced classes of package cz.msebera.android.httpclient.cookie:
//            CookieSpec

public interface CookieSpecFactory
{

    public abstract CookieSpec newInstance(HttpParams httpparams);
}
