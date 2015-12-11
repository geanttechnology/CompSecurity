// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.services;

import android.content.Intent;
import com.abtnprojects.ambatana.models.product.Product;
import com.abtnprojects.ambatana.models.product.RemoteImage;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.abtnprojects.ambatana.services:
//            a

public class ProductEditionService extends a
{

    public ProductEditionService()
    {
        super("ProductEditionService");
        c = 1;
    }

    int a(Product product)
    {
        if (product != null)
        {
            if ((product = product.getImages()) != null)
            {
                product = product.iterator();
                int i = 0;
                do
                {
                    if (!product.hasNext())
                    {
                        break;
                    }
                    RemoteImage remoteimage = (RemoteImage)product.next();
                    if (remoteimage != null && remoteimage.getId() == null)
                    {
                        i++;
                    }
                } while (true);
                return i;
            }
        }
        return 0;
    }

    protected void onHandleIntent(Intent intent)
    {
        super.onHandleIntent(intent);
    }
}
