// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.abtnprojects.ambatana.models.AbstractLetgoUser;
import com.abtnprojects.ambatana.models.ProductInserted;
import com.abtnprojects.ambatana.models.product.ApiProduct;
import com.abtnprojects.ambatana.models.product.Product;
import com.abtnprojects.ambatana.models.product.ProductInsertedEntity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

// Referenced classes of package android.support.v7:
//            iv, aqo, ig

public abstract class fe
{

    protected final Context a;
    protected final Product b;
    protected final AbstractLetgoUser c;
    protected final Handler d = new Handler(Looper.myLooper());
    protected final String e;

    public fe(Context context, Product product, AbstractLetgoUser abstractletgouser, String s)
    {
        a = context;
        b = product;
        c = abstractletgouser;
        e = s;
    }

    public abstract ProductInserted a(boolean flag);

    protected ProductInserted a(boolean flag, ApiProduct apiproduct)
    {
        if (apiproduct != null)
        {
            apiproduct = (new ProductInsertedEntity(iv.a(a, 0x7f080001))).transform(apiproduct, flag);
            aqo.b("Successful insertion of product", new Object[0]);
            return apiproduct;
        } else
        {
            aqo.b("product insertion failed", new Object[0]);
            return null;
        }
    }

    String a(Bitmap bitmap)
    {
        if (bitmap != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if ((bitmap = ig.b(bitmap, 1280)) == null) goto _L1; else goto _L3
_L3:
        try
        {
            File file = iv.a(a, "LetgoImg", "jpg");
            FileOutputStream fileoutputstream = new FileOutputStream(file);
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 50, fileoutputstream);
            bitmap.recycle();
            bitmap = file.getAbsolutePath();
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            aqo.b(bitmap, "saveResizedFile", new Object[0]);
            return null;
        }
        return bitmap;
    }

    String a(String s)
    {
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if ((s = ig.a(s, 1280)) == null) goto _L1; else goto _L3
_L3:
        try
        {
            File file = iv.a(a, "LetgoImg", "jpg");
            FileOutputStream fileoutputstream = new FileOutputStream(file);
            s.compress(android.graphics.Bitmap.CompressFormat.JPEG, 50, fileoutputstream);
            s.recycle();
            s = file.getAbsolutePath();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            aqo.b(s, "saveResizedFile", new Object[0]);
            return null;
        }
        return s;
    }
}
