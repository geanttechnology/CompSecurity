// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

// Referenced classes of package android.support.v4.a:
//            b

public class a
{

    public static final Drawable a(Context context, int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            return b.a(context, i);
        } else
        {
            return context.getResources().getDrawable(i);
        }
    }
}
