// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.activities.do;

import android.webkit.WebChromeClient;
import io.presage.utils.e;

// Referenced classes of package io.presage.activities.do:
//            e

final class t extends WebChromeClient
{

    final io.presage.activities.do.e a;

    public final void onConsoleMessage(String s, int i, String s1)
    {
        e.a(new String[] {
            "PresageActivity", s, "-- From line", Integer.toString(i), "of", s1
        });
    }

    public t(io.presage.activities.do.e e1)
    {
        a = e1;
        super();
    }
}
