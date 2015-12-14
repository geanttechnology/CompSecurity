// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.model.Model;
import com.perfectcorp.utility.j;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkUser

final class onse extends j
{

    protected com.cyberlink.beautycircle.model.UserResponse a(String s)
    {
        return (com.cyberlink.beautycircle.model.UserResponse)Model.a(com/cyberlink/beautycircle/model/UserInfo$UpdateUserResponse, s);
    }

    protected volatile Object a(Object obj)
    {
        return a((String)obj);
    }

    onse()
    {
    }
}
