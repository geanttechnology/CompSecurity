// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

// Referenced classes of package android.support.v7.internal.widget:
//            p, j

public class n extends ContextWrapper
{
    static class a extends j
    {

        private final p a;

        public Drawable getDrawable(int i)
            throws android.content.res.Resources.NotFoundException
        {
            Drawable drawable = super.getDrawable(i);
            if (drawable != null)
            {
                a.a(i, drawable);
            }
            return drawable;
        }

        public a(Resources resources, p p1)
        {
            super(resources);
            a = p1;
        }
    }


    private Resources a;

    private n(Context context)
    {
        super(context);
    }

    public static Context a(Context context)
    {
        Object obj = context;
        if (!(context instanceof n))
        {
            obj = new n(context);
        }
        return ((Context) (obj));
    }

    public Resources getResources()
    {
        if (a == null)
        {
            a = new a(super.getResources(), p.a(this));
        }
        return a;
    }
}
