// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.abtnprojects.ambatana.datasource.api.CreateProductService;
import com.abtnprojects.ambatana.datasource.api.c;
import com.abtnprojects.ambatana.models.product.ApiProduct;
import retrofit.RetrofitError;
import retrofit.mime.TypedString;

// Referenced classes of package android.support.v7:
//            aqo

public class db
{

    private CreateProductService a;
    private boolean b;

    public db(String s)
    {
        a = c.j(s);
    }

    public ApiProduct a(String s, int i, String s1, String s2, String s3, String s4, String s5, 
            double d, double d1, String s6, String s7, String s8, 
            String s9, String s10)
    {
        if (b)
        {
            return null;
        }
        b = true;
        if (s8 != null) goto _L2; else goto _L1
_L1:
        s8 = null;
_L9:
        if (s1 != null) goto _L4; else goto _L3
_L3:
        s1 = null;
_L10:
        if (s6 != null) goto _L6; else goto _L5
_L5:
        s6 = null;
_L11:
        if (s7 != null) goto _L8; else goto _L7
_L7:
        s7 = null;
_L12:
        if (s9 != null)
        {
            break MISSING_BLOCK_LABEL_299;
        }
        s9 = null;
_L13:
        try
        {
            s = a.createProduct(new TypedString(s), new TypedString((new StringBuilder()).append(i).append("").toString()), s1, new TypedString(s2), new TypedString(s3), new TypedString((new StringBuilder()).append(s4).append("").toString()), new TypedString(s5), new TypedString((new StringBuilder()).append(d).append("").toString()), new TypedString((new StringBuilder()).append(d1).append("").toString()), s6, s7, s8, s9, new TypedString(s10));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            aqo.b(s, "createProduct error", new Object[0]);
            s = null;
        }
        b = false;
        return s;
_L2:
        s8 = new TypedString(s8);
          goto _L9
_L4:
        s1 = new TypedString(s1);
          goto _L10
_L6:
        s6 = new TypedString(s6);
          goto _L11
_L8:
        s7 = new TypedString(s7);
          goto _L12
        s9 = new TypedString(s9);
          goto _L13
    }
}
