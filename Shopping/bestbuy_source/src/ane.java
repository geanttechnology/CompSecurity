// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;
import android.os.Parcelable;

public final class ane
{

    private ane()
    {
    }

    public static void a(Bundle bundle, String s, Parcelable parcelable)
    {
        bundle.setClassLoader(ane.getClassLoader());
        Bundle bundle2 = bundle.getBundle("map_state");
        Bundle bundle1 = bundle2;
        if (bundle2 == null)
        {
            bundle1 = new Bundle();
        }
        bundle1.setClassLoader(ane.getClassLoader());
        bundle1.putParcelable(s, parcelable);
        bundle.putBundle("map_state", bundle1);
    }
}
