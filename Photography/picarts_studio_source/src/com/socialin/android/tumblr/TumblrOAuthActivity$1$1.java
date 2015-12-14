// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.tumblr;

import android.net.Uri;
import android.view.View;

// Referenced classes of package com.socialin.android.tumblr:
//            TumblrOAuthActivity

final class a
    implements Runnable
{

    private ViewById a;

    public final void run()
    {
        a.a.findViewById(0x7f100a6f).setVisibility(4);
        a.a.findViewById(0x7f100a6e).setVisibility(0);
    }

    _cls9(_cls9 _pcls9)
    {
        a = _pcls9;
        super();
    }

    // Unreferenced inner class com/socialin/android/tumblr/TumblrOAuthActivity$1

/* anonymous class */
    final class TumblrOAuthActivity._cls1
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
                a.runOnUiThread(new TumblrOAuthActivity._cls1._cls1(this));
                TumblrOAuthActivity.a(a);
                return;
            }
        }

            
            {
                a = tumblroauthactivity;
                b = uri;
                super();
            }
    }

}
