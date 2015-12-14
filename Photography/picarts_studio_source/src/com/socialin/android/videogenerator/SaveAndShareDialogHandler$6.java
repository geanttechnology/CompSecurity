// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.facebook.util.FacebookUtils;
import io.branch.referral.g;
import io.branch.referral.m;
import myobfuscated.cy.d;

// Referenced classes of package com.socialin.android.videogenerator:
//            SaveAndShareDialogHandler

public final class b
    implements android.view.ndShareDialogHandler._cls6
{

    final Activity a;
    final String b;
    final SaveAndShareDialogHandler c;

    public final void onClick(View view)
    {
        d.a(a, "facebook", "photo_share_facebook", c.o, new g() {

            private SaveAndShareDialogHandler._cls6 a;

            public final void a(String s, m m)
            {
                m = a.c;
                Object obj = a.a;
                Object obj1 = a.b;
                s = FacebookUtils.createFacebookMessage(a.a, a.c.n, a.c.o, s);
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setPackage("com.facebook.katana");
                intent.putExtra("android.intent.extra.STREAM", Uri.parse((new StringBuilder("file://")).append(((String) (obj1))).toString()));
                intent.setType("video/*");
                intent.putExtra("android.intent.extra.SUBJECT", ((Context) (obj)).getString(0x7f0808af));
                intent.putExtra("android.intent.extra.TEXT", s);
                ((Context) (obj)).startActivity(intent);
                obj = AnalyticUtils.getInstance(((Context) (obj)));
                obj1 = (new com.socialin.android.apiv3.events.EventsFactory.DrawExportVideoEvent(((SaveAndShareDialogHandler) (m)).r, ((SaveAndShareDialogHandler) (m)).t)).setDest("facebook");
                if (((SaveAndShareDialogHandler) (m)).l)
                {
                    s = SaveAndShareDialogHandler.MediaType.GIF;
                } else
                {
                    s = SaveAndShareDialogHandler.MediaType.MPG;
                }
                ((AnalyticUtils) (obj)).track(((com.socialin.android.apiv3.events.EventsFactory.DrawExportVideoEvent) (obj1)).setType(SaveAndShareDialogHandler.MediaType.getType(s)));
            }

            
            {
                a = SaveAndShareDialogHandler._cls6.this;
                super();
            }
        });
    }

    public _cls1.a(SaveAndShareDialogHandler saveandsharedialoghandler, Activity activity, String s)
    {
        c = saveandsharedialoghandler;
        a = activity;
        b = s;
        super();
    }
}
