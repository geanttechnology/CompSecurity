// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            UserDefinedListSummary

public class UserDefinedList extends UserDefinedListSummary
{

    public final List list;

    public UserDefinedList(String s, int i, List list1)
    {
        super(s, i);
        list = list1;
    }
}
