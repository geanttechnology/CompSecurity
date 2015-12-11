// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models.product;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.abtnprojects.ambatana.models.product:
//            ApiImageToken

public class TokenEntity
{

    public TokenEntity()
    {
    }

    public String transform(ApiImageToken apiimagetoken)
    {
        if (apiimagetoken == null)
        {
            return null;
        } else
        {
            return apiimagetoken.getImageId();
        }
    }

    public List transform(List list)
    {
        if (list == null)
        {
            return null;
        }
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            String s = transform((ApiImageToken)list.next());
            if (!TextUtils.isEmpty(s))
            {
                arraylist.add(s);
            }
        } while (true);
        return arraylist;
    }
}
