// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.tumblr;

import android.net.Uri;
import android.view.View;

// Referenced classes of package com.socialin.android.tumblr:
//            TumblrOAuthActivity

final class b
    implements Runnable
{

    final TumblrOAuthActivity a;
    private Uri b;

    public final void run()
    {
        if (!a.a(b))
        {
            a.setResult(0);
            a.finish();
            return;
        } else
        {
            a.runOnUiThread(new Runnable() {

                private TumblrOAuthActivity._cls1 a;

                public final void run()
                {
                    a.a.findViewById(0x7f100a6f).setVisibility(4);
                    a.a.findViewById(0x7f100a6e).setVisibility(0);
                }

            
            {
                a = TumblrOAuthActivity._cls1.this;
                super();
            }
            });
            TumblrOAuthActivity.a(a);
            return;
        }
    }

    _cls1.a(TumblrOAuthActivity tumblroauthactivity, Uri uri)
    {
        a = tumblroauthactivity;
        b = uri;
        super();
    }
}
