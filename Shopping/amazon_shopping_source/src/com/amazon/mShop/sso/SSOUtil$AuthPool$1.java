// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.mShop.sso:
//            SSOUtil

static final class nit> extends nit>
{

    public List getLocaleList()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("de_DE");
        arraylist.add("en_GB");
        arraylist.add("en_US");
        arraylist.add("en_IN");
        arraylist.add("fr_FR");
        arraylist.add("it_IT");
        arraylist.add("es_ES");
        arraylist.add("en_CA");
        arraylist.add("fr_CA");
        return arraylist;
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
