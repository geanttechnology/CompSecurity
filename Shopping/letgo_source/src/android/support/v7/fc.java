// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

// Referenced classes of package android.support.v7:
//            ew, aik, ajl, aij, 
//            ait, ajp, air

public class fc extends ew
{

    private final aij a;
    private final aik b = aik.a();

    public fc(ait ait)
    {
        aij.a a1 = (new aij.a()).a(0x7f020102).b(0x7f0200d7).c(0x7f020106).a(true).b(true);
        if (ait != null)
        {
            a1.a(ait);
        }
        a = a1.a();
    }

    public void a(String s, ImageView imageview, ew.a a1)
    {
        a1 = new ajl(imageview, false);
        b.a(s, a1, a, new ajp() {

            final fc a;

            public void a(String s1, View view)
            {
                ((ImageView)view).setScaleType(android.widget.ImageView.ScaleType.CENTER);
            }

            public void a(String s1, View view, Bitmap bitmap)
            {
                if (view != null)
                {
                    ((ImageView)view).setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
                }
            }

            public void a(String s1, View view, air air)
            {
                ((ImageView)view).setScaleType(android.widget.ImageView.ScaleType.CENTER);
            }

            
            {
                a = fc.this;
                super();
            }
        });
        imageview.setTag(s);
    }
}
