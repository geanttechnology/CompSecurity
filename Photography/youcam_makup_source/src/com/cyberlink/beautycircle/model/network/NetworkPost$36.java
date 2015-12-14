// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.cyberlink.beautycircle.model.Comment;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.j;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkPost

final class  extends j
{

    protected Comment a(String s)
    {
        return (Comment)Model.a(com/cyberlink/beautycircle/model/Comment, s);
    }

    protected volatile Object a(Object obj)
    {
        return a((String)obj);
    }

    ()
    {
    }
}
