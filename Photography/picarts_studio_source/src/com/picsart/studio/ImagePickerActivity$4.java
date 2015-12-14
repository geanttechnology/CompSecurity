// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import android.app.DialogFragment;
import android.view.View;
import com.socialin.android.dialog.c;

// Referenced classes of package com.picsart.studio:
//            ImagePickerActivity

final class a
    implements c
{

    final ImagePickerActivity a;

    public final void onViewCreated(View view, DialogFragment dialogfragment)
    {
        view.findViewById(0x7f10037e).setOnClickListener(new android.view.View.OnClickListener() {

            private ImagePickerActivity._cls4 a;

            public final void onClick(View view1)
            {
                com.picsart.studio.ImagePickerActivity.c(a.a);
            }

            
            {
                a = ImagePickerActivity._cls4.this;
                super();
            }
        });
        view.findViewById(0x7f10037d).setOnClickListener(new android.view.View.OnClickListener() {

            private ImagePickerActivity._cls4 a;

            public final void onClick(View view1)
            {
                ImagePickerActivity.d(a.a);
            }

            
            {
                a = ImagePickerActivity._cls4.this;
                super();
            }
        });
    }

    _cls2.a(ImagePickerActivity imagepickeractivity)
    {
        a = imagepickeractivity;
        super();
    }
}
