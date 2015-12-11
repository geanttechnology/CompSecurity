// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.appindexing:
//            Action, Thing

public final class ut extends ut
{

    public final Action build()
    {
        zzx.zzb(zzRj.get("object"), "setObject is required before calling build().");
        zzx.zzb(zzRj.get("type"), "setType is required before calling build().");
        Bundle bundle = (Bundle)zzRj.getParcelable("object");
        zzx.zzb(bundle.get("name"), "Must call setObject() with a valid name. Example: setObject(new Thing.Builder().setName(name).setUrl(url))");
        zzx.zzb(bundle.get("url"), "Must call setObject() with a valid app URI. Example: setObject(new Thing.Builder().setName(name).setUrl(url))");
        return new Action(zzRj, null);
    }

    public final volatile Thing build()
    {
        return build();
    }

    public final build put(String s, Thing thing)
    {
        return (build)super.ut(s, thing);
    }

    public final ut put(String s, String s1)
    {
        return (ut)super.ut(s, s1);
    }

    public final volatile ut put(String s, Thing thing)
    {
        return put(s, thing);
    }

    public final volatile put put(String s, String s1)
    {
        return put(s, s1);
    }

    public final put setActionStatus(String s)
    {
        zzx.zzw(s);
        return (put)super.ut("actionStatus", s);
    }

    public final ut setName(String s)
    {
        return (ut)super.ut("name", s);
    }

    public final volatile ut setName(String s)
    {
        return setName(s);
    }

    public final setName setObject(Thing thing)
    {
        zzx.zzw(thing);
        return (setName)super.ut("object", thing);
    }

    public final ut setUrl(Uri uri)
    {
        if (uri != null)
        {
            super.ut("url", uri.toString());
        }
        return this;
    }

    public final volatile ut setUrl(Uri uri)
    {
        return setUrl(uri);
    }

    public (String s)
    {
        zzx.zzw(s);
        super.ut("type", s);
    }
}
