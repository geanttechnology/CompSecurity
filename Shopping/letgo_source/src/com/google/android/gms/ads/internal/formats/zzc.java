// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.formats;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import android.support.v7.lk;
import android.support.v7.ll;

public class zzc extends android.support.v7.nz.a
{

    private final Uri mUri;
    private final Drawable zzvJ;

    public zzc(Drawable drawable, Uri uri)
    {
        zzvJ = drawable;
        mUri = uri;
    }

    public Uri getUri()
        throws RemoteException
    {
        return mUri;
    }

    public lk zzdr()
        throws RemoteException
    {
        return ll.a(zzvJ);
    }
}
