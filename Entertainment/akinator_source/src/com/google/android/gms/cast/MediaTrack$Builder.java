// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzf;
import java.util.Locale;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            MediaTrack

public static class zzWL
{

    private final MediaTrack zzWL;

    public MediaTrack build()
    {
        return zzWL;
    }

    public zzWL setContentId(String s)
    {
        zzWL.setContentId(s);
        return this;
    }

    public ntId setContentType(String s)
    {
        zzWL.setContentType(s);
        return this;
    }

    public ntType setCustomData(JSONObject jsonobject)
    {
        zzWL.setCustomData(jsonobject);
        return this;
    }

    public mData setLanguage(String s)
    {
        zzWL.setLanguage(s);
        return this;
    }

    public age setLanguage(Locale locale)
    {
        zzWL.setLanguage(zzf.zzb(locale));
        return this;
    }

    public age setName(String s)
    {
        zzWL.setName(s);
        return this;
    }

    public zzWL setSubtype(int i)
        throws IllegalArgumentException
    {
        zzWL.zzaV(i);
        return this;
    }

    public (long l, int i)
        throws IllegalArgumentException
    {
        zzWL = new MediaTrack(l, i);
    }
}
