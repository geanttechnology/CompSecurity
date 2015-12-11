// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import com.abtnprojects.ambatana.models.product.Product;
import com.abtnprojects.ambatana.models.user.User;
import com.parse.ParseUser;

// Referenced classes of package android.support.v7:
//            gl, gi, iu

public class gk extends gl
{

    public gk(gi gi, ParseUser parseuser, iu iu)
    {
        super(gi, parseuser, iu);
    }

    public void a(Context context, Product product, User user)
    {
        a(context, "dummy-product-detail-ask-question", a(product, user), a);
    }

    public void a(Context context, Product product, User user, String s)
    {
        a(context, "dummy-product-detail-offer", a(product, user, s), a);
    }

    public void b(Context context, Product product, User user)
    {
        a(context, "dummy-user-sent-message", a(product, user), a);
    }
}
