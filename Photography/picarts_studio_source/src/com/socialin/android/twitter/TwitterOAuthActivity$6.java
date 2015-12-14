// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.twitter;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import myobfuscated.cd.a;

// Referenced classes of package com.socialin.android.twitter:
//            TwitterOAuthActivity

final class c
    implements Runnable
{

    private View a;
    private a b;
    private View c;
    private TwitterOAuthActivity d;

    public final void run()
    {
        a.setVisibility(0);
        TwitterOAuthActivity.e(d).setText("#PicsArt");
        TwitterOAuthActivity.f(d).setBackgroundDrawable(b);
        TwitterOAuthActivity.f(d).setVisibility(0);
        c.setVisibility(0);
    }

    _cls9(TwitterOAuthActivity twitteroauthactivity, View view, a a1, View view1)
    {
        d = twitteroauthactivity;
        a = view;
        b = a1;
        c = view1;
        super();
    }
}
