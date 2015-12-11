// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import com.abtnprojects.ambatana.models.ParseLetgoUser;
import com.abtnprojects.ambatana.models.product.Product;

// Referenced classes of package android.support.v7:
//            fp, fo, fe

public class fr
{

    public static fe a(int i, Context context, Product product, ParseLetgoUser parseletgouser, String s)
    {
        if (i == 0)
        {
            return new fp(context, product, parseletgouser, s);
        }
        if (i == 1)
        {
            return new fo(context, product, parseletgouser, s);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid delegate type  : ").append(i).toString());
        }
    }
}
