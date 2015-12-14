// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.cyberlink.beautycircle.model.NotificationNew;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.j;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            o

final class New extends j
{

    protected NotificationNew a(String s)
    {
        return (NotificationNew)Model.a(com/cyberlink/beautycircle/model/NotificationNew, s);
    }

    protected volatile Object a(Object obj)
    {
        return a((String)obj);
    }

    New()
    {
    }
}
