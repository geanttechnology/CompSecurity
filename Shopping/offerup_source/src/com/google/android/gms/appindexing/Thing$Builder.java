// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.appindexing:
//            Thing

public class 
{

    final Bundle zzRj = new Bundle();

    public Thing build()
    {
        return new Thing(zzRj);
    }

    public zzRj put(String s, Thing thing)
    {
        zzx.zzw(s);
        if (thing != null)
        {
            zzRj.putParcelable(s, thing.zzRi);
        }
        return this;
    }

    public zzRj put(String s, String s1)
    {
        zzx.zzw(s);
        if (s1 != null)
        {
            zzRj.putString(s, s1);
        }
        return this;
    }

    public zzRj setDescription(String s)
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
        zzx.zzw(s);
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
        zzx.zzw(uri);
        put("url", uri.toString());
        return this;
    }

    public ()
    {
    }
}
