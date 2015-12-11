// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import com.abtnprojects.ambatana.models.ProductInserted;
import com.parse.ParseUser;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            gx, at, gi, gh

public class gv extends gx
{

    private String c;

    public gv(gh gh, String s, ParseUser parseuser)
    {
        super(gh, parseuser);
        c = s;
    }

    protected Map a(String s)
    {
        at at1 = new at(2);
        at1.put("product-id", c);
        if (s != null && !s.isEmpty())
        {
            at1.put("description", s);
        }
        return at1;
    }

    public void a(Context context)
    {
        b(context, "product-edit-start", b(c));
    }

    public void a(Context context, ProductInserted productinserted, String s)
    {
        a(context, "product-edit-complete", a(productinserted.getProductId(), productinserted.getSelectedCategoryId(), s));
    }

    public void a(Context context, String s)
    {
        a(context, "product-edit-form-validation-failed", a(s));
    }

    public void b(Context context, String s)
    {
        a.a(context, "product-edit-shared-fb", b(s), b);
    }
}
