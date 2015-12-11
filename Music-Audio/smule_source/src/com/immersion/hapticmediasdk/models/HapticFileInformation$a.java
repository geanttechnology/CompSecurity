// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.models;

import android.os.Parcel;

// Referenced classes of package com.immersion.hapticmediasdk.models:
//            HapticFileInformation

public final class b
    implements android.os..HapticFileInformation.a
{

    public static int a = 84;
    public static int b = 0;
    public static int c = 1;
    public static int d = 2;

    public static int a()
    {
        return 2;
    }

    public static int b()
    {
        return 54;
    }

    public static int c()
    {
        return 1;
    }

    public static int d()
    {
        return 0;
    }

    public HapticFileInformation a(Parcel parcel)
    {
        if (((b() + c()) * b()) % d != b)
        {
            a = b();
            b = b();
        }
        parcel = new HapticFileInformation(parcel);
label0:
        do
        {
            switch (1)
            {
            default:
                while (true) 
                {
                    switch (0)
                    {
                    default:
                        break;

                    case 0: // '\0'
                        break label0;

                    case 1: // '\001'
                        continue label0;
                    }
                }
                break;

            case 0: // '\0'
                break;

            case 1: // '\001'
                break label0;
            }
        } while (true);
        return parcel;
    }

    public HapticFileInformation[] a(int i)
    {
label0:
        do
        {
            switch (1)
            {
            default:
                while (true) 
                {
                    switch (1)
                    {
                    default:
                        break;

                    case 0: // '\0'
                        continue label0;

                    case 1: // '\001'
                        break label0;
                    }
                }
                break;

            case 0: // '\0'
                break;

            case 1: // '\001'
                break label0;
            }
        } while (true);
        HapticFileInformation ahapticfileinformation[] = new HapticFileInformation[i];
        if (((a + c) * a) % d != b)
        {
            a = 32;
            b = 80;
        }
        return ahapticfileinformation;
    }

    public Object createFromParcel(Parcel parcel)
    {
        try
        {
            parcel = a(parcel);
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            throw parcel;
        }
        if (((a + c) * a) % a() != d())
        {
            a = 46;
            b = b();
        }
        return parcel;
    }

    public Object[] newArray(int i)
    {
        int j = a;
        HapticFileInformation ahapticfileinformation[];
        switch ((j * (c + j)) % d)
        {
        default:
            a = b();
            b = 47;
            // fall through

        case 0: // '\0'
            ahapticfileinformation = a(i);
            break;
        }
label0:
        do
        {
            switch (1)
            {
            default:
                while (true) 
                {
                    switch (1)
                    {
                    default:
                        break;

                    case 0: // '\0'
                        continue label0;

                    case 1: // '\001'
                        break label0;
                    }
                }
                break;

            case 0: // '\0'
                break;

            case 1: // '\001'
                break label0;
            }
        } while (true);
        return ahapticfileinformation;
    }

    public A()
    {
        if (((a + c) * a) % a() != b)
        {
            a = b();
            b = b();
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
