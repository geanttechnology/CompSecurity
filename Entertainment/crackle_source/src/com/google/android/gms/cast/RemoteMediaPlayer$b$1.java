// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.dn;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            RemoteMediaPlayer

class lw
    implements dn
{

    final lw lw;

    public void a(long l, int i, JSONObject jsonobject)
    {
        lw.lw(new nit>(new Status(i), jsonobject));
    }

    public void g(long l)
    {
        lw.lw(lw.lw(new Status(4)));
    }

    ( )
    {
        lw = ;
        super();
    }
}
