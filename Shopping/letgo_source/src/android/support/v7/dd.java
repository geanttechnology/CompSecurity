// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.abtnprojects.ambatana.datasource.api.EditProductService;
import com.abtnprojects.ambatana.datasource.api.c;
import com.abtnprojects.ambatana.models.product.ApiProduct;
import com.abtnprojects.ambatana.models.product.ApiSendProduct;
import retrofit.RetrofitError;

// Referenced classes of package android.support.v7:
//            aqo

public class dd
{

    private EditProductService a;
    private boolean b;

    public dd(String s)
    {
        a = c.k(s);
    }

    public ApiProduct a(String s, ApiSendProduct apisendproduct)
    {
        Object obj = null;
        if (b)
        {
            return null;
        }
        b = true;
        try
        {
            s = a.editProduct(s, apisendproduct);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            aqo.b(s, "editProduct error", new Object[0]);
            s = obj;
        }
        b = false;
        return s;
    }
}
