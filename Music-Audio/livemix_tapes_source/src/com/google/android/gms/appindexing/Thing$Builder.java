// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.appindexing:
//            Thing

public static class 
{

    final Bundle zzQe = new Bundle();

    public Thing build()
    {
        return new Thing(zzQe);
    }

    public zzQe put(String s, Thing thing)
    {
        zzx.zzv(s);
        if (thing != null)
        {
            zzQe.putParcelable(s, thing.zzQd);
        }
        return this;
    }

    public zzQe put(String s, String s1)
    {
        zzx.zzv(s);
        if (s1 != null)
        {
            zzQe.putString(s, s1);
        }
        return this;
    }

    public zzQe setDescription(String s)
    {
        put("description", s);
        return this;
    }

    public put setId(String s)
    {
        if (s != null)
        {
            put("id", s);
        }
        return this;
    }

    public put setName(String s)
    {
        zzx.zzv(s);
        put("name", s);
        return this;
    }

    public put setType(String s)
    {
        put("type", s);
        return this;
    }

    public put setUrl(Uri uri)
    {
        zzx.zzv(uri);
        put("url", uri.toString());
        return this;
    }

    public ()
    {
    }
}
