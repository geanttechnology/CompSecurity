// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.AssetManager;
import android.graphics.Typeface;

final class te
    implements tg
{

    private String a;

    te(String s)
    {
        a = s;
        super();
    }

    public final Typeface a(AssetManager assetmanager)
    {
        return Typeface.createFromAsset(assetmanager, a);
    }
}
