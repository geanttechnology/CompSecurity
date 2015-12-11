// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

// Referenced classes of package android.support.v7.internal.widget:
//            q, k

public final class o extends ContextWrapper
{
    static final class a extends k
    {

        private final q a;

        public final Drawable getDrawable(int i)
        {
            Drawable drawable = super.getDrawable(i);
            if (drawable != null)
            {
                a.a(i, drawable);
            }
            return drawable;
        }

        public a(Resources resources, q q1)
        {
            super(resources);
            a = q1;
        }
    }


    private Resources a;

    private o(Context context)
    {
        super(context);
    }

    public static Context a(Context context)
    {
        Object obj = context;
        if (!(context instanceof o))
        {
            obj = new o(context);
        }
        return ((Context) (obj));
    }

    public final Resources getResources()
    {
        if (a == null)
        {
            a = new a(super.getResources(), q.a(this));
        }
        return a;
    }
}
