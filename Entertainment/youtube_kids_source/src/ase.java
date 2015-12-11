// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;

final class ase
    implements atj
{

    ase()
    {
    }

    public final boolean a(Object obj)
    {
        obj = atp.b((String)obj);
        return !TextUtils.isEmpty(((CharSequence) (obj))) && (!((String) (obj)).contains("text") || ((String) (obj)).contains("text/vtt")) && !((String) (obj)).contains("html") && !((String) (obj)).contains("xml");
    }
}
