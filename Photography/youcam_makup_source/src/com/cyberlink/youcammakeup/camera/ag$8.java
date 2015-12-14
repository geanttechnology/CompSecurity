// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.content.DialogInterface;
import android.view.View;
import com.cyberlink.youcammakeup.clflurry.YMKResultPageEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.flurry.PhotoSavePageClickEvent;
import com.cyberlink.youcammakeup.flurry.a;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.dialogs.ae;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            ag

class a
    implements android.view.OnClickListener
{

    final ag a;

    public void onClick(View view)
    {
        if (!com.cyberlink.youcammakeup.camera.ag.a(a))
        {
            return;
        } else
        {
            com.cyberlink.youcammakeup.camera.ag.a(a, false);
            view.setEnabled(false);
            com.cyberlink.youcammakeup.flurry.a.a(new PhotoSavePageClickEvent(com.cyberlink.youcammakeup.flurry.SavePageClickEvent.ButtonName.e));
            b.a(new YMKResultPageEvent(com.cyberlink.youcammakeup.clflurry.sultPageEvent.Operation.g, YMKResultPageEvent.b, System.currentTimeMillis()));
            ae ae1 = new ae(null);
            ae1.a(new android.content.DialogInterface.OnDismissListener(view) {

                final View a;
                final ag._cls8 b;

                public void onDismiss(DialogInterface dialoginterface)
                {
                    YMKResultPageEvent.b = System.currentTimeMillis();
                    a.setEnabled(true);
                    com.cyberlink.youcammakeup.camera.ag.a(b.a, true);
                }

            
            {
                b = ag._cls8.this;
                a = view;
                super();
            }
            });
            o.a(a.getFragmentManager(), ae1, "SaveMyLookCollageShareDialog");
            return;
        }
    }

    _cls1.a(ag ag1)
    {
        a = ag1;
        super();
    }
}
