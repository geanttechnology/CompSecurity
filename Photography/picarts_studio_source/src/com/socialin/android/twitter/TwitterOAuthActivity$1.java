// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.twitter;

import android.content.DialogInterface;

// Referenced classes of package com.socialin.android.twitter:
//            TwitterOAuthActivity

final class a
    implements android.content.lListener
{

    private TwitterOAuthActivity a;

    public final void onCancel(DialogInterface dialoginterface)
    {
        a.setResult(1);
        a.finish();
    }

    _cls9(TwitterOAuthActivity twitteroauthactivity)
    {
        a = twitteroauthactivity;
        super();
    }
}
