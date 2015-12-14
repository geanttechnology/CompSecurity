// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.facebook.activity.FacebookAdapterActivity;
import com.socialin.android.facebook.p;

// Referenced classes of package com.socialin.android.facebook.util:
//            FacebookUtils

final class g
    implements p
{

    private Activity a;
    private ImageItem b;
    private String c;
    private String d;
    private boolean e;
    private boolean f;
    private long g;

    public final void a()
    {
        if (a != null && !a.isFinishing())
        {
            if (b != null && FacebookUtils.isSSOUser() && ShareDialog.canShow(com/facebook/share/model/ShareLinkContent))
            {
                Object obj;
                if (c == null)
                {
                    obj = "";
                } else
                {
                    obj = c;
                }
                obj = ((com.facebook.share.model..Builder)(new com.facebook.share.model..Builder()).setContentTitle(b.title).setContentDescription(((String) (obj))).setContentUrl(Uri.parse((new StringBuilder("http://picsart.com/i/")).append(b.id).toString()))).build();
                ShareDialog.show(a, ((com.facebook.share.model.ShareContent) (obj)));
            } else
            {
                Intent intent = new Intent();
                intent.setClassName(a.getPackageName(), "com.socialin.android.facebook.FacebookWallPostActivity");
                intent.setFlags(0x4200000);
                intent.putExtra("path", d);
                intent.putExtra("freeToEdit", e);
                intent.putExtra("videoPost", f);
                if (c != null)
                {
                    intent.putExtra("postMessage", c);
                }
                intent.putExtra("item_id", g);
                intent.putExtra("item", b);
                a.startActivityForResult(intent, 1231);
                a.overridePendingTransition(0x7f040044, 0x7f040048);
            }
            if (a instanceof FacebookAdapterActivity)
            {
                a.finish();
                return;
            }
        }
    }

    terActivity(Activity activity, ImageItem imageitem, String s, String s1, boolean flag, boolean flag1, long l)
    {
        a = activity;
        b = imageitem;
        c = s;
        d = s1;
        e = flag;
        f = flag1;
        g = l;
        super();
    }
}
