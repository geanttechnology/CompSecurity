// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.models;

import android.os.Parcel;

// Referenced classes of package com.immersion.hapticmediasdk.models:
//            HapticFileInformation

public static final class b
    implements android.os..HapticFileInformation.b
{

    public static int a = 84;
    public static int b = 0;
    public static int c = 1;
    public static int d = 2;

    public final Object createFromParcel(Parcel parcel)
    {
        try
        {
            if (2970 % d != b)
            {
                a = 54;
                b = 54;
            }
            parcel = new HapticFileInformation(parcel);
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            throw parcel;
        }
        if (((a + c) * a) % 2 != 0)
        {
            a = 46;
            b = 54;
        }
        return parcel;
    }

    public final Object[] newArray(int i)
    {
        int j = a;
        HapticFileInformation ahapticfileinformation[];
        switch ((j * (c + j)) % d)
        {
        default:
            a = 54;
            b = 47;
            // fall through

        case 0: // '\0'
            ahapticfileinformation = new HapticFileInformation[i];
            break;
        }
        if (((a + c) * a) % d != b)
        {
            a = 32;
            b = 80;
        }
        return ahapticfileinformation;
    }

    public A()
    {
        if (((a + c) * a) % 2 != b)
        {
            a = 54;
            b = 54;
        }
        try
        {
            super();
            return;
        }
        catch (Exception exception)
        {
            throw exception;
        }
    }
}
