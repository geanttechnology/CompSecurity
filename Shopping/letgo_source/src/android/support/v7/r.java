// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

// Referenced classes of package android.support.v7:
//            s

public class r
{

    public static Drawable a(Resources resources, int i, android.content.res.Resources.Theme theme)
        throws android.content.res.Resources.NotFoundException
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            return s.a(resources, i, theme);
        } else
        {
            return resources.getDrawable(i);
        }
    }
}
