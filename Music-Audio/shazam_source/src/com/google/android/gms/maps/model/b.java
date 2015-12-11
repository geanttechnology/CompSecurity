// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.gms.common.internal.w;

// Referenced classes of package com.google.android.gms.maps.model:
//            a, d

public final class b
{

    public static com.google.android.gms.maps.model.a.b a;

    private static com.google.android.gms.maps.model.a.b a()
    {
        return (com.google.android.gms.maps.model.a.b)w.a(a, "IBitmapDescriptorFactory is not initialized");
    }

    public static a a(int i)
    {
        a a1;
        try
        {
            a1 = new a(a().a(i));
        }
        catch (RemoteException remoteexception)
        {
            throw new d(remoteexception);
        }
        return a1;
    }

    public static a a(Bitmap bitmap)
    {
        try
        {
            bitmap = new a(a().a(bitmap));
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            throw new d(bitmap);
        }
        return bitmap;
    }
}
