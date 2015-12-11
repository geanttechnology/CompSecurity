// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.fragment.h;

import android.net.Uri;
import android.os.Bundle;
import com.shazam.android.ag.h.a;
import com.shazam.android.ag.h.c;

public final class b
    implements c
{

    private final Bundle a;

    public b(Bundle bundle)
    {
        a = bundle;
    }

    public static com.shazam.android.ag.h.b a(Bundle bundle)
    {
        return com.shazam.android.ag.h.b.a(bundle.getString("mini_tagging_fragment_state"));
    }

    public final a a()
    {
        Uri uri = (Uri)a.getParcelable("mini_tagging_recognized_match_uri");
        com.shazam.android.ag.h.a.a a1 = new com.shazam.android.ag.h.a.a();
        a1.a = uri;
        a1.b = a.getBoolean("mini_tagging_recognized_match_should_persist");
        return a1.a();
    }

    public final void a(a a1)
    {
        a.putParcelable("mini_tagging_recognized_match_uri", a1.a);
        a.putBoolean("mini_tagging_recognized_match_should_persist", a1.b);
    }

    public final void a(com.shazam.android.ag.h.b b1)
    {
        a.putString("mini_tagging_fragment_state", b1.h);
    }

    public final com.shazam.android.ag.h.b b()
    {
        return a(a);
    }
}
