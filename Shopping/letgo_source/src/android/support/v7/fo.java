// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.text.TextUtils;
import com.abtnprojects.ambatana.models.ParseLetgoUser;
import com.abtnprojects.ambatana.models.ProductInserted;
import com.abtnprojects.ambatana.models.product.ApiImageTokenEntity;
import com.abtnprojects.ambatana.models.product.ApiSendProduct;
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
//            fe, aqo, gb, fz, 
//            ds, dd, dz, ep, 
//            ajx

public class fo extends fe
    implements ds.a
{

    public fo(Context context, Product product, ParseLetgoUser parseletgouser, String s)
    {
        super(context, product, parseletgouser, s);
    }

    public ProductInserted a(boolean flag)
    {
        Object obj = b.getImages();
        Object obj2 = new ArrayList();
        Object obj1 = new ArrayList();
        Object obj3 = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj3)).hasNext())
            {
                break;
            }
            obj = (RemoteImage)((Iterator) (obj3)).next();
            if (obj != null && ((RemoteImage) (obj)).getId() == null)
            {
                obj = ((RemoteImage) (obj)).getUrl();
                boolean flag1;
                if (obj == null)
                {
                    flag1 = false;
                } else
                {
                    flag1 = ((String) (obj)).toLowerCase().startsWith("http");
                }
                if (flag1)
                {
                    aqo.a("remote image has to be re-uploaded", new Object[0]);
                    obj = a(gb.a(0).a(((String) (obj))));
                } else
                {
                    aqo.a("New image will be uploaded", new Object[0]);
                    if (obj == null)
                    {
                        obj = null;
                    } else
                    {
                        obj = new File(((String) (obj)));
                    }
                    if (obj == null)
                    {
                        obj = null;
                    } else
                    {
                        obj = a(((File) (obj)).getAbsolutePath());
                    }
                }
                aqo.a("path : %s", new Object[] {
                    obj
                });
                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    obj = new File(((String) (obj)));
                    aqo.a("abs path %s", new Object[] {
                        ((File) (obj)).getAbsolutePath()
                    });
                    ((List) (obj2)).add(obj);
                }
            } else
            if (obj != null)
            {
                aqo.a("Image already uploaded", new Object[0]);
                ((List) (obj1)).add(((RemoteImage) (obj)).getId());
            } else
            {
                aqo.a("Image is null", new Object[0]);
            }
        } while (true);
        obj3 = ParseUser.getCurrentUser().getSessionToken();
        ds ds1 = new ds(((String) (obj3)));
        obj = ParseUser.getCurrentUser().getObjectId();
        TokenEntity tokenentity = new TokenEntity();
        if (obj2 != null && ((List) (obj2)).size() > 0)
        {
            obj2 = tokenentity.transform(ds1.a(((String) (obj)), ((List) (obj2)), this));
            if (obj2 != null)
            {
                ((List) (obj1)).addAll(((java.util.Collection) (obj2)));
            }
        } else
        {
            aqo.a("No images to upload", new Object[0]);
        }
        if (obj1 == null || ((List) (obj1)).size() == 0)
        {
            return null;
        }
        obj2 = new dd(((String) (obj3)));
        obj3 = b.getGeo();
        if (obj3 == null)
        {
            aqo.d("Error : geolocation data missing", new Object[0]);
            return null;
        } else
        {
            aqo.a("will edit product %s", new Object[] {
                b.toString()
            });
            obj1 = (new ApiImageTokenEntity()).transformToString(((List) (obj1)));
            obj = new ApiSendProduct(b.getName(), (new StringBuilder()).append(b.getCategoryId()).append("").toString(), b.getLanguageCode(), ((String) (obj)), b.getDescription(), Double.toString(b.getPrice()), b.getCurrency(), (new StringBuilder()).append(((Geo) (obj3)).getLat()).append("").toString(), (new StringBuilder()).append(((Geo) (obj3)).getLng()).append("").toString(), ((Geo) (obj3)).getCountryCode(), ((Geo) (obj3)).getCity(), e, ((Geo) (obj3)).getZipCode(), ((String) (obj1)));
            return a(flag, ((dd) (obj2)).a(b.getId(), ((ApiSendProduct) (obj))));
        }
    }

    public void a(int i)
    {
        dz.a().a(new ep(i));
    }
}
