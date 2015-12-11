// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

// Referenced classes of package android.support.v7:
//            ev, aky, alc, ih, 
//            akj, aqo

public class ez extends ev
{

    public ez()
    {
    }

    public void a(Context context, ImageView imageview, Uri uri, ev.a a1)
    {
        aky.a(context).a(uri).a().a(new ih()).c().a(imageview, new akj(a1, uri) {

            final ev.a a;
            final Uri b;
            final ez c;

            public void a()
            {
                aqo.a("Picasso image load ok", new Object[0]);
                a.a();
            }

            public void b()
            {
                aqo.c("Picasso image error %s:", new Object[] {
                    b
                });
                a.b();
            }

            
            {
                c = ez.this;
                a = a1;
                b = uri;
                super();
            }
        });
    }
}
