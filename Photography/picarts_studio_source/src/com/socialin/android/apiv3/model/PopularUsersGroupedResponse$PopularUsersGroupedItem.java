// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;

import java.util.ArrayList;

// Referenced classes of package com.socialin.android.apiv3.model:
//            ViewerUser

public class total
{

    public ArrayList items;
    public int total;
    public ViewerUser user;

    public boolean equals(Object obj)
    {
        if (obj instanceof total)
        {
            return ((total)obj).user.id == user.id;
        } else
        {
            return super.equals(obj);
        }
    }

    public ()
    {
        total = 0;
    }
}
