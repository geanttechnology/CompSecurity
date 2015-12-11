// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import com.abtnprojects.ambatana.models.Category;
import com.abtnprojects.ambatana.models.CountryCurrencyInfo;
import com.abtnprojects.ambatana.models.product.Product;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.support.v7:
//            dv, aqo, ft, dz, 
//            ej, ajx, ek

public class fg extends AsyncTask
{

    private final String a;
    private final Context b;
    private final dv c;
    private final Product d;

    public fg(String s, Context context, dv dv1, Product product)
    {
        a = s;
        b = context;
        c = dv1;
        d = product;
    }

    private List a()
    {
        int i = 0;
        String as[] = b.getResources().getStringArray(0x7f0e0001);
        ArrayList arraylist = new ArrayList(as.length + 1);
        arraylist.add(new Category(0, a));
        int k = as.length;
        int j = 0;
        for (; i < k; i++)
        {
            String s = as[i];
            j++;
            arraylist.add(new Category(j, s));
        }

        return arraylist;
    }

    protected transient ft a(Void avoid[])
    {
        List list = a();
        if (d == null)
        {
            CountryCurrencyInfo countrycurrencyinfo = c.a(b);
            avoid = countrycurrencyinfo;
            if (countrycurrencyinfo == null)
            {
                avoid = CountryCurrencyInfo.createDefaultCountryCurrencyInfo();
            }
            aqo.a(avoid.toString(), new Object[0]);
            avoid = avoid.getCurrencyCode();
        } else
        {
            avoid = d.getCurrency();
        }
        return new ft(list, avoid);
    }

    protected void a(ft ft1)
    {
        dz.a().a(new ej(ft1));
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((ft)obj);
    }

    protected void onPreExecute()
    {
        dz.a().a(new ek());
    }
}
