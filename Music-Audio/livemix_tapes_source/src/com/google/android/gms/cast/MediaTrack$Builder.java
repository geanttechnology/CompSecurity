// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzf;
import java.util.Locale;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            MediaTrack

public static class zzUU
{

    private final MediaTrack zzUU;

    public MediaTrack build()
    {
        return zzUU;
    }

    public zzUU setContentId(String s)
    {
        zzUU.setContentId(s);
        return this;
    }

    public ntId setContentType(String s)
    {
        zzUU.setContentType(s);
        return this;
    }

    public ntType setCustomData(JSONObject jsonobject)
    {
        zzUU.setCustomData(jsonobject);
        return this;
    }

    public mData setLanguage(String s)
    {
        zzUU.setLanguage(s);
        return this;
    }

    public age setLanguage(Locale locale)
    {
        zzUU.setLanguage(zzf.zzb(locale));
        return this;
    }

    public age setName(String s)
    {
        zzUU.setName(s);
        return this;
    }

    public zzUU setSubtype(int i)
        throws IllegalArgumentException
    {
        zzUU.zzaO(i);
        return this;
    }

    public (long l, int i)
        throws IllegalArgumentException
    {
        zzUU = new MediaTrack(l, i);
    }
}
