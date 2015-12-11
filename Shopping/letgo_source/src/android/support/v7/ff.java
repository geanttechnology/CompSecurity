// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.location.Location;
import com.abtnprojects.ambatana.models.CountryCurrencyInfo;
import com.abtnprojects.ambatana.models.product.ProductEntity;
import com.abtnprojects.ambatana.services.b;
import java.util.List;

// Referenced classes of package android.support.v7:
//            iv, ge

public abstract class ff
{

    public ff()
    {
    }

    protected ge a(List list, Context context, CountryCurrencyInfo countrycurrencyinfo, Location location, String s, int i)
    {
        java.util.ArrayList arraylist = iv.a(context, 0x7f080001);
        int j;
        if (list == null)
        {
            j = 0;
        } else
        {
            j = list.size();
        }
        if (j > 0)
        {
            list = (new ProductEntity(arraylist, countrycurrencyinfo, context, new b(), location, s)).transform(list);
            boolean flag;
            if (j < 20)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return new ge(list, flag, i);
        } else
        {
            return null;
        }
    }
}
