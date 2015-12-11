// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

// Referenced classes of package android.support.v7.internal.widget:
//            r, l

public class p extends ContextWrapper
{
    static class a extends l
    {

        private final r a;

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

        public a(Resources resources, r r1)
        {
            super(resources);
            a = r1;
        }
    }


    private Resources a;

    private p(Context context)
    {
        super(context);
    }

    public static Context a(Context context)
    {
        Object obj = context;
        if (!(context instanceof p))
        {
            obj = new p(context);
        }
        return ((Context) (obj));
    }

    public Resources getResources()
    {
        if (a == null)
        {
            a = new a(super.getResources(), r.a(this));
        }
        return a;
    }
}
