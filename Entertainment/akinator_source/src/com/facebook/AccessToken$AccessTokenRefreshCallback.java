// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;


// Referenced classes of package com.facebook:
//            AccessToken, FacebookException

public static interface _cls9
{

    public abstract void OnTokenRefreshFailed(FacebookException facebookexception);

    public abstract void OnTokenRefreshed(AccessToken accesstoken);
}
