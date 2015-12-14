// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.graphics.Paint;
import android.view.View;
import com.socialin.android.colorpicker.c;
import com.socialin.android.photo.view.ColorPickerPreview;

// Referenced classes of package com.picsart.collages:
//            e, CollageCreatorView

final class a
    implements android.view..OnClickListener
{

    final e a;

    public final void onClick(View view)
    {
        e.a(a, new c() {

            private e._cls1 a;

            public final void a(int i)
            {
                e.b(a.a).setBackgroundColor(i);
                e.b(a.a).setBackgroundBitmap(null, null);
                e.b(a.a).invalidate();
                e.d(a.a).setColor(i);
            }

            
            {
                a = e._cls1.this;
                super();
            }
        }, e.b(a).a.getColor());
    }

    _cls1.a(e e1)
    {
        a = e1;
        super();
    }
}
