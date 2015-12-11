// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

// Referenced classes of package android.support.v7:
//            ev, ajg, aik, aij, 
//            ajn, air

public class fb extends ev
{

    private final aij a = (new aij.a()).a(0x106000d).b(0x7f0200d7).c(0x106000d).a(new ajg(500)).a(true).b(true).a();
    private final aik b = aik.a();

    public fb()
    {
    }

    public void a(Context context, ImageView imageview, Uri uri, ev.a a1)
    {
        b.a(uri.toString(), imageview, a, new ajn(a1) {

            final ev.a a;
            final fb b;

            public void a(String s, View view)
            {
            }

            public void a(String s, View view, Bitmap bitmap)
            {
                a.a();
            }

            public void a(String s, View view, air air)
            {
                a.b();
            }

            public void b(String s, View view)
            {
            }

            
            {
                b = fb.this;
                a = a1;
                super();
            }
        });
    }
}
