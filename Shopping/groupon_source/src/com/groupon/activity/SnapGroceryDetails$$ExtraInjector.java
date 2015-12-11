// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;


// Referenced classes of package com.groupon.activity:
//            SnapGroceryDetails

public class 
{

    public static void inject(com.f2prateek.dart.r r, SnapGroceryDetails snapgrocerydetails, Object obj)
    {
        .inject(r, snapgrocerydetails, obj);
        Object obj1 = r.inject(obj, "productName");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'productName' for field 'productName' was not found. If this extra is optional add '@Optional' annotation.");
        }
        snapgrocerydetails.productName = (String)obj1;
        r = ((com.f2prateek.dart.or.inject) (r.inject(obj, "groceryId")));
        if (r == null)
        {
            throw new IllegalStateException("Required extra with key 'groceryId' for field 'groceryId' was not found. If this extra is optional add '@Optional' annotation.");
        } else
        {
            snapgrocerydetails.groceryId = (String)r;
            return;
        }
    }

    public ()
    {
    }
}
