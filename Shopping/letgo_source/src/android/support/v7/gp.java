// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.content.Context;
import com.abtnprojects.ambatana.models.product.Geo;
import com.abtnprojects.ambatana.models.product.Product;
import com.abtnprojects.ambatana.models.user.User;
import com.parse.ParseUser;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            at, iu, gi

public abstract class gp
{

    protected final ParseUser a;
    private final gi b;
    private final iu c;

    public gp(gi gi1, ParseUser parseuser, iu iu1)
    {
        b = gi1;
        a = parseuser;
        c = iu1;
    }

    protected Map a(Product product)
    {
        at at1 = new at(2);
        at1.put("user-id", a.getObjectId());
        if (product != null)
        {
            at1.put("product-id", product.getId());
        }
        return at1;
    }

    protected Map a(Product product, User user)
    {
        HashMap hashmap = new HashMap();
        if (product != null)
        {
            hashmap.put("category-id", product.getCategoryIdAsString());
            hashmap.put("product-id", product.getId());
            Geo geo = product.getGeo();
            if (geo != null)
            {
                hashmap.put("product-lat", geo.getLatString());
                hashmap.put("product-lng", geo.getLngString());
            }
            hashmap.put("product-price", product.getFormattedPrice());
            hashmap.put("product-currency", product.getCurrency());
        }
        if (user != null)
        {
            hashmap.put("user-to-id", user.getId());
            hashmap.put("item-type", c.a(user));
        }
        return hashmap;
    }

    protected Map a(Product product, User user, String s, String s1)
    {
        product = a(product, user);
        product.put("button-position", s);
        if (s1 != null)
        {
            product.put("share-network", s1);
        }
        return product;
    }

    protected Map a(Product product, ParseUser parseuser)
    {
        at at1 = new at(5);
        if (product != null)
        {
            at1.put("category-id", product.getCategoryIdAsString());
            at1.put("product-id", product.getId());
            at1.put("product-price", product.getFormattedPrice());
            at1.put("product-currency", product.getCurrency());
        }
        if (parseuser != null)
        {
            at1.put("user-id", parseuser.getObjectId());
        }
        return at1;
    }

    protected Map a(ParseUser parseuser)
    {
        at at1 = new at(1);
        at1.put("user-id", parseuser.getObjectId());
        return at1;
    }

    public void a(Activity activity)
    {
        b.a(activity);
    }

    public abstract void a(Context context);

    public abstract void a(Context context, Product product);

    public abstract void a(Context context, Product product, User user);

    protected void a(Context context, String s, Map map)
    {
        b.b(context, s, map, a);
    }

    public abstract void b(Context context);

    public abstract void b(Context context, Product product);

    public abstract void b(Context context, Product product, User user);

    protected void b(Context context, String s, Map map)
    {
        b.a(context, s, map, a);
    }

    public abstract void c(Context context, Product product);

    public abstract void c(Context context, Product product, User user);

    public abstract void d(Context context, Product product, User user);

    public abstract void e(Context context, Product product, User user);

    public abstract void f(Context context, Product product, User user);

    public abstract void g(Context context, Product product, User user);

    public abstract void h(Context context, Product product, User user);
}
