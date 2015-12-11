// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.os.AsyncTask;
import com.abtnprojects.ambatana.models.CountryCurrencyInfo;
import com.abtnprojects.ambatana.models.product.ApiProduct;
import com.abtnprojects.ambatana.models.product.Product;
import com.abtnprojects.ambatana.models.product.ProductEntity;
import com.abtnprojects.ambatana.services.b;
import java.lang.ref.WeakReference;

// Referenced classes of package android.support.v7:
//            iv, dz, el, ajx

public class fq extends AsyncTask
{

    private final CountryCurrencyInfo a;
    private final int b;
    private final ApiProduct c;
    private final WeakReference d;

    public fq(CountryCurrencyInfo countrycurrencyinfo, Context context, int i, ApiProduct apiproduct)
    {
        a = countrycurrencyinfo;
        b = i;
        c = apiproduct;
        d = new WeakReference(context);
    }

    protected transient Product a(Void avoid[])
    {
        Object obj = null;
        Product product;
        if (d == null)
        {
            avoid = null;
        } else
        {
            avoid = (Context)d.get();
        }
        product = obj;
        if (c != null)
        {
            product = obj;
            if (avoid != null)
            {
                product = (new ProductEntity(iv.a(avoid, 0x7f080001), a, avoid, new b(), null, null)).transform(c);
            }
        }
        return product;
    }

    protected void a(Product product)
    {
        dz.a().a(new el(product, b));
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Product)obj);
    }
}
