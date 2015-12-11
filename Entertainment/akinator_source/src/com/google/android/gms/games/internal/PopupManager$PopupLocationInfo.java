// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IBinder;

// Referenced classes of package com.google.android.gms.games.internal:
//            PopupManager

public static final class <init>
{

    public int bottom;
    public int gravity;
    public int left;
    public int right;
    public int top;
    public IBinder zzawO;
    public int zzawP;

    public Bundle zzve()
    {
        Bundle bundle = new Bundle();
        bundle.putInt("popupLocationInfo.gravity", gravity);
        bundle.putInt("popupLocationInfo.displayId", zzawP);
        bundle.putInt("popupLocationInfo.left", left);
        bundle.putInt("popupLocationInfo.top", top);
        bundle.putInt("popupLocationInfo.right", right);
        bundle.putInt("popupLocationInfo.bottom", bottom);
        return bundle;
    }

    private (int i, IBinder ibinder)
    {
        zzawP = -1;
        left = 0;
        top = 0;
        right = 0;
        bottom = 0;
        gravity = i;
        zzawO = ibinder;
    }

    zzawO(int i, IBinder ibinder, zzawO zzawo)
    {
        this(i, ibinder);
    }
}
