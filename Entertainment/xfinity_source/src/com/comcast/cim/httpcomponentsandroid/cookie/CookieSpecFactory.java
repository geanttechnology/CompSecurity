// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.cookie;

import com.comcast.cim.httpcomponentsandroid.params.HttpParams;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.cookie:
//            CookieSpec

public interface CookieSpecFactory
{

    public abstract CookieSpec newInstance(HttpParams httpparams);
}
