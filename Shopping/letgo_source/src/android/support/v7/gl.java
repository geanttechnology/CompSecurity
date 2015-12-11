// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import com.abtnprojects.ambatana.models.product.Geo;
import com.abtnprojects.ambatana.models.product.Product;
import com.abtnprojects.ambatana.models.user.User;
import com.parse.ParseUser;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            iu, gi

public abstract class gl
{

    protected final ParseUser a;
    private final gi b;
    private final iu c;

    public gl(gi gi1, ParseUser parseuser, iu iu1)
    {
        b = gi1;
        c = iu1;
        a = parseuser;
    }

    private String a(Product product)
    {
        int i = 0;
        if (product == null)
        {
            return String.valueOf(0);
        }
        product = Integer.valueOf(product.getCategoryId());
        if (product != null)
        {
            i = product.intValue();
        }
        return String.valueOf(i);
    }

    private String b(Product product)
    {
        if (product == null)
        {
            return "";
        } else
        {
            return product.getId();
        }
    }

    private String c(Product product)
    {
        String s = null;
        if (product != null)
        {
            product = product.getGeo();
            s = (new StringBuilder()).append("").append(product.getLat()).toString();
        }
        return s;
    }

    private String d(Product product)
    {
        String s = null;
        if (product != null)
        {
            product = product.getGeo();
            s = (new StringBuilder()).append("").append(product.getLng()).toString();
        }
        return s;
    }

    private String e(Product product)
    {
        if (product == null)
        {
            return "";
        } else
        {
            double d1 = product.getPrice();
            return (new StringBuilder()).append("").append(Double.valueOf(d1)).toString();
        }
    }

    private String f(Product product)
    {
        String s = "";
        if (product != null)
        {
            s = product.getCurrency();
        }
        return s;
    }

    protected Map a(Product product, User user)
    {
        HashMap hashmap = new HashMap();
        if (product != null)
        {
            hashmap.put("category-id", a(product));
            hashmap.put("product-id", b(product));
            hashmap.put("product-lat", c(product));
            hashmap.put("product-lng", d(product));
            hashmap.put("product-price", e(product));
            hashmap.put("product-currency", f(product));
        }
        if (user != null)
        {
            hashmap.put("item-type", c.a(user));
            hashmap.put("user-to-id", user.getId());
        }
        return hashmap;
    }

    protected Map a(Product product, User user, String s)
    {
        product = a(product, user);
        if (s != null)
        {
            product.put("amount-offer", s);
        }
        return product;
    }

    public abstract void a(Context context, Product product, User user);

    public abstract void a(Context context, Product product, User user, String s);

    protected void a(Context context, String s, Map map, ParseUser parseuser)
    {
        b.a(context, s, map, parseuser);
    }

    public abstract void b(Context context, Product product, User user);
}
