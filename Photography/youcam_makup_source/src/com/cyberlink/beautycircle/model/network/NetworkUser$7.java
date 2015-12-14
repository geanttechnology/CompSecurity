// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.cyberlink.beautycircle.model.UserInfo;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.j;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkUser

final class erInfoResult extends j
{

    protected UserInfo a(String s)
    {
        return ((erInfoResult)Model.a(com/cyberlink/beautycircle/model/network/NetworkUser$UserInfoResult, s)).result;
    }

    protected volatile Object a(Object obj)
    {
        return a((String)obj);
    }

    erInfoResult()
    {
    }
}
