// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import com.socialin.android.apiv3.model.Contest2;
import java.util.Comparator;
import java.util.Date;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            GetContestsController

final class 
    implements Comparator
{

    public final int compare(Object obj, Object obj1)
    {
        obj = (Contest2)obj;
        obj1 = (Contest2)obj1;
        return ((Contest2) (obj)).endDate.compareTo(((Contest2) (obj1)).endDate);
    }

    ()
    {
    }
}
