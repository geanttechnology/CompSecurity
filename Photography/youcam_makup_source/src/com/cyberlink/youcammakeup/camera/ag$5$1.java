// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.clflurry.YMKResultPageEvent;
import com.cyberlink.youcammakeup.clflurry.YMKShareToEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.flurry.PhotoSavePageClickEvent;
import com.cyberlink.youcammakeup.flurry.a;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.dialogs.ai;
import com.cyberlink.youcammakeup.widgetpool.dialogs.al;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            ag

class a
    implements android.content.nterface.OnDismissListener
{

    final View a;
    final b b;

    public void onDismiss(DialogInterface dialoginterface)
    {
        YMKResultPageEvent.b = System.currentTimeMillis();
        a.setEnabled(true);
        com.cyberlink.youcammakeup.camera.ag.a(b.b, true);
    }

    logs.ai(logs.ai ai, View view)
    {
        b = ai;
        a = view;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/camera/ag$5

/* anonymous class */
    class ag._cls5
        implements android.view.View.OnClickListener
    {

        final ag a;

        public void onClick(View view)
        {
            if (com.cyberlink.youcammakeup.camera.ag.a(a))
            {
                com.cyberlink.youcammakeup.camera.ag.a(a, false);
                view.setEnabled(false);
                YMKShareToEvent.a(com.cyberlink.youcammakeup.clflurry.YMKShareToEvent.Source.b);
                com.cyberlink.youcammakeup.flurry.a.a(new PhotoSavePageClickEvent(com.cyberlink.youcammakeup.flurry.PhotoSavePageClickEvent.ButtonName.p));
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKResultPageEvent(com.cyberlink.youcammakeup.clflurry.YMKResultPageEvent.Operation.c, YMKResultPageEvent.b, System.currentTimeMillis()));
                android.net.Uri uri = a.b();
                if (uri != null)
                {
                    Globals.d().a(ag.c(a));
                    Object obj = a.getArguments();
                    Bundle bundle = ((Bundle) (obj));
                    if (obj == null)
                    {
                        bundle = new Bundle();
                    }
                    bundle.putString("BUNDLE_KEY_TITLE", al.a);
                    bundle.putString("BUNDLE_KEY_MESSAGE", null);
                    bundle.putParcelable("BUNDLE_KEY_URI", uri);
                    obj = new ai(ag.d(a));
                    ((ai) (obj)).setArguments(bundle);
                    ((ai) (obj)).a(new ag._cls5._cls1(this, view));
                    o.a(a.getFragmentManager(), ((android.app.DialogFragment) (obj)), "ShareDialog");
                    return;
                }
            }
        }

            
            {
                a = ag1;
                super();
            }
    }

}
