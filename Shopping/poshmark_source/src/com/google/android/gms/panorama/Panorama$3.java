// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.panorama;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.internal.ih;

// Referenced classes of package com.google.android.gms.panorama:
//            Panorama

static final class <init> extends <init>
{

    final Uri Qz;

    protected volatile void a(com.google.android.gms.common.api.nit> nit>)
        throws RemoteException
    {
        a((ih)nit>);
    }

    protected void a(ih ih1)
    {
        ih1.a(this, Qz, true);
    }

    (Uri uri)
    {
        Qz = uri;
        super();
    }
}
