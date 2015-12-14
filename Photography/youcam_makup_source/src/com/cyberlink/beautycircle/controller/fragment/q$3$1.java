// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.net.Uri;
import com.cyberlink.beautycircle.utility.l;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            q, p

class a
    implements Runnable
{

    final Uri a;
    final a b;

    public void run()
    {
        p.a(b.b.b, a);
        q.d(b.b).setImageURI(a);
    }

    ImageView(ImageView imageview, Uri uri)
    {
        b = imageview;
        a = uri;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/fragment/q$3

/* anonymous class */
    class q._cls3
        implements l
    {

        final q a;

        public void a()
        {
        }

        public void a(Uri uri)
        {
            if (q.d(a) != null)
            {
                q.d(a).post(new q._cls3._cls1(this, uri));
            }
        }

            
            {
                a = q1;
                super();
            }
    }

}
