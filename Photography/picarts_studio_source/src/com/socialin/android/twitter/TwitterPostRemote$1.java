// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.twitter;

import android.content.Context;
import android.widget.Toast;

// Referenced classes of package com.socialin.android.twitter:
//            TwitterPostRemote

final class a
    implements Runnable
{

    private int a;
    private TwitterPostRemote b;

    public final void run()
    {
        Toast.makeText(TwitterPostRemote.access$000(b).getApplicationContext(), a, 1).show();
    }

    (TwitterPostRemote twitterpostremote, int i)
    {
        b = twitterpostremote;
        a = i;
        super();
    }
}
