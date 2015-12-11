// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

// Referenced classes of package android.support.v4.widget:
//            s, t

public class r
{
    static class a
        implements d
    {

        public void a(TextView textview, Drawable drawable, Drawable drawable1, Drawable drawable2, Drawable drawable3)
        {
            textview.setCompoundDrawables(drawable, drawable1, drawable2, drawable3);
        }

        a()
        {
        }
    }

    static class b extends a
    {

        public void a(TextView textview, Drawable drawable, Drawable drawable1, Drawable drawable2, Drawable drawable3)
        {
            s.a(textview, drawable, drawable1, drawable2, drawable3);
        }

        b()
        {
        }
    }

    static class c extends b
    {

        public void a(TextView textview, Drawable drawable, Drawable drawable1, Drawable drawable2, Drawable drawable3)
        {
            t.a(textview, drawable, drawable1, drawable2, drawable3);
        }

        c()
        {
        }
    }

    static interface d
    {

        public abstract void a(TextView textview, Drawable drawable, Drawable drawable1, Drawable drawable2, Drawable drawable3);
    }


    static final d a;

    public static void a(TextView textview, Drawable drawable, Drawable drawable1, Drawable drawable2, Drawable drawable3)
    {
        a.a(textview, drawable, drawable1, drawable2, drawable3);
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 18)
        {
            a = new c();
        } else
        if (i >= 17)
        {
            a = new b();
        } else
        {
            a = new a();
        }
    }
}
