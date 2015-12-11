// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ak.a;

import android.net.Uri;
import java.net.URL;

// Referenced classes of package com.shazam.android.ak.a:
//            b

public final class a
    implements b
{

    private final com.shazam.android.j.n.a a;

    public a(com.shazam.android.j.n.a a1)
    {
        a = a1;
    }

    public final Uri a(String s, String s1)
    {
        return Uri.parse(a.a().toString().replace("{type}", s).replace("{id}", s1));
    }
}
