// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import com.abtnprojects.ambatana.models.ProductInserted;
import com.parse.ParseUser;

// Referenced classes of package android.support.v7:
//            gx, at, gh

public class gu extends gx
{

    public gu(gh gh, ParseUser parseuser)
    {
        super(gh, parseuser);
    }

    public void a(Context context)
    {
        b(context, "dummy-product-sell-start", new at(1));
    }

    public void a(Context context, ProductInserted productinserted, String s)
    {
        a(context, "dummy-product-sell-complete", a(productinserted.getProductId(), productinserted.getSelectedCategoryId(), s));
    }

    public void a(Context context, String s)
    {
        a(context, "dummy-product-sell-form-validation-failed", a(s));
    }

    public void b(Context context, String s)
    {
        a(context, "dummy-product-sell-shared-fb", s);
    }
}
