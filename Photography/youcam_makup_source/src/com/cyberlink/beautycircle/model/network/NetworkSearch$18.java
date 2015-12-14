// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.model.Model;
import com.perfectcorp.utility.j;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkSearch

final class gestionKeywords extends j
{

    protected gestionKeywords a(String s)
    {
        if (s == null)
        {
            b(0x80000003);
            return null;
        } else
        {
            return (gestionKeywords)Model.a(com/cyberlink/beautycircle/model/network/NetworkSearch$SuggestionKeywords, s);
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((String)obj);
    }

    gestionKeywords()
    {
    }
}
