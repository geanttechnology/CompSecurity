// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models.mygroupons;

import java.util.ArrayList;

// Referenced classes of package com.groupon.db.models.mygroupons:
//            MyGrouponItem

protected static class DefaultListDetails
{

    public static final ArrayList DefaultListDetails = new ArrayList();
    ArrayList details;

    public ArrayList getDetails()
    {
        return (ArrayList)details.get(0);
    }


    protected ()
    {
        details = DefaultListDetails;
    }
}
