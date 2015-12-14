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

final class a
    implements g
{

    private aType a;

    public final void a(String s, m m)
    {
        m = a.a;
        Object obj = a.a;
        Object obj1 = a.a;
        s = FacebookUtils.createFacebookMessage(a.a, a.a.n, a.a.o, s);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setPackage("com.facebook.katana");
        intent.putExtra("android.intent.extra.STREAM", Uri.parse((new StringBuilder("file://")).append(((String) (obj1))).toString()));
        intent.setType("video/*");
        intent.putExtra("android.intent.extra.SUBJECT", ((Context) (obj)).getString(0x7f0808af));
        intent.putExtra("android.intent.extra.TEXT", s);
        ((Context) (obj)).startActivity(intent);
        obj = AnalyticUtils.getInstance(((Context) (obj)));
        obj1 = (new com.socialin.android.apiv3.events.vent(((SaveAndShareDialogHandler) (m)).r, ((SaveAndShareDialogHandler) (m)).t)).setDest("facebook");
        if (((SaveAndShareDialogHandler) (m)).l)
        {
            s = aType.GIF;
        } else
        {
            s = aType.MPG;
        }
        ((AnalyticUtils) (obj)).track(((com.socialin.android.apiv3.events.vent) (obj1)).setType(aType.getType(s)));
    }

    aType(aType atype)
    {
        a = atype;
        super();
    }

    // Unreferenced inner class com/socialin/android/videogenerator/SaveAndShareDialogHandler$6

/* anonymous class */
    public final class SaveAndShareDialogHandler._cls6
        implements android.view.View.OnClickListener
    {

        final Activity a;
        final String b;
        final SaveAndShareDialogHandler c;

        public final void onClick(View view)
        {
            d.a(a, "facebook", "photo_share_facebook", c.o, new SaveAndShareDialogHandler._cls6._cls1(this));
        }

            public 
            {
                c = saveandsharedialoghandler;
                a = activity;
                b = s;
                super();
            }
    }

}
