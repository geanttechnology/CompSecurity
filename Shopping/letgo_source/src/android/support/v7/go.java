// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import com.abtnprojects.ambatana.models.product.Product;
import com.abtnprojects.ambatana.models.user.User;
import com.parse.ParseUser;

// Referenced classes of package android.support.v7:
//            gp, gi, iu

public class go extends gp
{

    public go(gi gi, ParseUser parseuser, iu iu)
    {
        super(gi, parseuser, iu);
    }

    public void a(Context context)
    {
        b(context, "dummy-product-detail-share-facebook-complete", a(a));
    }

    public void a(Context context, Product product)
    {
        b(context, "dummy-product-detail-sold", a(product, a));
    }

    public void a(Context context, Product product, User user)
    {
        b(context, "dummy-product-detail-favorite", a(product, user));
    }

    public void b(Context context)
    {
        b(context, "dummy-product-detail-share-facebook-cancel", a(a));
    }

    public void b(Context context, Product product)
    {
        b(context, "dummy-product-delete-start", a(product));
    }

    public void b(Context context, Product product, User user)
    {
        b(context, "dummy-product-detail-favorite-chat", a(product, user));
    }

    public void c(Context context, Product product)
    {
        b(context, "dummy-product-delete-complete", a(product));
    }

    public void c(Context context, Product product, User user)
    {
        a(context, "dummy-product-detail-visit", a(product, user));
    }

    public void d(Context context, Product product, User user)
    {
        a(context, "dummy-product-detail-report", a(product, user));
    }

    public void e(Context context, Product product, User user)
    {
        b(context, "dummy-product-detail-share", a(product, user, "bottom", "email"));
    }

    public void f(Context context, Product product, User user)
    {
        b(context, "dummy-product-detail-share", a(product, user, "bottom", "whatsapp"));
    }

    public void g(Context context, Product product, User user)
    {
        b(context, "dummy-product-detail-share", a(product, user, "bottom", "facebook"));
    }

    public void h(Context context, Product product, User user)
    {
        b(context, "dummy-product-detail-share", a(product, user, "top", null));
    }
}
