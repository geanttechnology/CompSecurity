// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.widget.ImageView;

// Referenced classes of package android.support.v7:
//            ew, aky, alc, akj

public class fa extends ew
{

    public fa()
    {
    }

    public void a(String s, ImageView imageview, ew.a a1)
    {
        aky.a(imageview.getContext()).a(s).a(imageview, new akj(a1, imageview, s) {

            final ew.a a;
            final ImageView b;
            final String c;
            final fa d;

            public void a()
            {
                if (a != null)
                {
                    a.a();
                }
                b.setTag(c);
            }

            public void b()
            {
                if (a != null)
                {
                    a.b();
                }
            }

            
            {
                d = fa.this;
                a = a1;
                b = imageview;
                c = s;
                super();
            }
        });
    }
}
