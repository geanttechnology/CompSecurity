// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.graphics.BitmapFactory;

// Referenced classes of package android.support.v7:
//            amq, alt, amc

public class aph
{

    public final String a;
    public final int b;
    public final int c;
    public final int d;

    public aph(String s, int i, int j, int k)
    {
        a = s;
        b = i;
        c = j;
        d = k;
    }

    public static aph a(Context context, String s)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        int i = amq.l(context);
        alt.h().a("Fabric", (new StringBuilder()).append("App icon resource ID is ").append(i).toString());
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(context.getResources(), i, options);
        context = new aph(s, i, options.outWidth, options.outHeight);
        return context;
        context;
        alt.h().e("Fabric", "Failed to load icon", context);
        return null;
    }
}
