// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.model.Model;
import com.perfectcorp.utility.j;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkContest

final class eryVoteStatusResult extends j
{

    protected eryVoteStatusResult a(String s)
    {
        return (eryVoteStatusResult)Model.a(com/cyberlink/beautycircle/model/network/NetworkContest$QueryVoteStatusResult, s);
    }

    protected volatile Object a(Object obj)
    {
        return a((String)obj);
    }

    eryVoteStatusResult()
    {
    }
}
