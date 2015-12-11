// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.text.TextUtils;
import com.abtnprojects.ambatana.models.ParseLetgoUser;
import com.abtnprojects.ambatana.models.ProductInserted;
import com.abtnprojects.ambatana.models.product.ApiImageTokenEntity;
import com.abtnprojects.ambatana.models.product.Geo;
import com.abtnprojects.ambatana.models.product.Product;
import com.abtnprojects.ambatana.models.product.RemoteImage;
import com.abtnprojects.ambatana.models.product.TokenEntity;
import com.parse.ParseUser;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package android.support.v7:
//            fe, ds, aqo, db, 
//            dz, ep, ajx

public class fp extends fe
    implements ds.a
{

    public fp(Context context, Product product, ParseLetgoUser parseletgouser, String s)
    {
        super(context, product, parseletgouser, s);
    }

    public ProductInserted a(boolean flag)
    {
        Object obj = b.getImages();
        Object obj1 = new ArrayList();
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            String s = a((new File(((RemoteImage)((Iterator) (obj)).next()).getUrl())).getAbsolutePath());
            if (!TextUtils.isEmpty(s))
            {
                ((List) (obj1)).add(new File(s));
            }
        } while (true);
        Object obj2 = ParseUser.getCurrentUser().getSessionToken();
        Object obj3 = new ds(((String) (obj2)));
        obj = ParseUser.getCurrentUser().getObjectId();
        obj3 = ((ds) (obj3)).a(((String) (obj)), ((List) (obj1)), this);
        if (obj3 == null || ((List) (obj3)).size() == 0)
        {
            return null;
        }
        aqo.a(b.toString(), new Object[0]);
        obj1 = new db(((String) (obj2)));
        obj2 = b.getGeo();
        if (obj2 == null)
        {
            aqo.d("Error : geolocation data missing", new Object[0]);
            return null;
        }
        ApiImageTokenEntity apiimagetokenentity = new ApiImageTokenEntity();
        obj3 = (new TokenEntity()).transform(((List) (obj3)));
        if (obj3 == null || ((List) (obj3)).size() == 0)
        {
            aqo.d("Error: no images to upload", new Object[0]);
            return null;
        } else
        {
            obj3 = apiimagetokenentity.transformToString(((List) (obj3)));
            return a(flag, ((db) (obj1)).a(b.getName(), b.getCategoryId(), b.getLanguageCode(), ((String) (obj)), b.getDescription(), Double.toString(b.getPrice()), b.getCurrency(), ((Geo) (obj2)).getLat(), ((Geo) (obj2)).getLng(), ((Geo) (obj2)).getCountryCode(), ((Geo) (obj2)).getCity(), e, ((Geo) (obj2)).getZipCode(), ((String) (obj3))));
        }
    }

    public void a(int i)
    {
        dz.a().a(new ep(i));
    }
}
