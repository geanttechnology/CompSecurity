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
    implements android.view.y._cls4._cls2
{

    private a a;

    public final void onClick(View view)
    {
        ImagePickerActivity.d(a.a);
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/picsart/studio/ImagePickerActivity$4

/* anonymous class */
    final class ImagePickerActivity._cls4
        implements c
    {

        final ImagePickerActivity a;

        public final void onViewCreated(View view, DialogFragment dialogfragment)
        {
            view.findViewById(0x7f10037e).setOnClickListener(new ImagePickerActivity._cls4._cls1());
            view.findViewById(0x7f10037d).setOnClickListener(new ImagePickerActivity._cls4._cls2(this));
        }

            
            {
                a = imagepickeractivity;
                super();
            }

        // Unreferenced inner class com/picsart/studio/ImagePickerActivity$4$1

/* anonymous class */
        final class ImagePickerActivity._cls4._cls1
            implements android.view.View.OnClickListener
        {

            private ImagePickerActivity._cls4 a;

            public final void onClick(View view)
            {
                com.picsart.studio.ImagePickerActivity.c(a.a);
            }

                    
                    {
                        a = ImagePickerActivity._cls4.this;
                        super();
                    }
        }

    }

}
