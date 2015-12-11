// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.bestbuy.android.activities.browseproduct.ProductAvailabilityFragment;

class lang.Object
    implements android.view.OnClickListener
{

    final dq a;

    public void onClick(View view)
    {
        if (dq.a(a) != null && (dq.a(a) instanceof ProductAvailabilityFragment))
        {
            ((ProductAvailabilityFragment)dq.a(a)).c();
        }
    }

    >(dq dq1)
    {
        a = dq1;
        super();
    }
}
