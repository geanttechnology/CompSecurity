// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.models;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.immersion.hapticmediasdk.models:
//            a

public class HapticFileInformation
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new a();
    public static int a = 81;
    public static int b = 0;
    public static int c = 2;
    public static int d = 1;
    private String e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m[];
    private int n;
    private int o;
    private int p;

    public HapticFileInformation()
    {
        if (((a + a()) * a) % c != b)
        {
            a = 6;
            b = 23;
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
        super();
    }

    public HapticFileInformation(Parcel parcel)
    {
        int ai[];
        int i1;
        try
        {
            super();
            e = parcel.readString();
            f = parcel.readInt();
            g = parcel.readInt();
            h = parcel.readInt();
            j = parcel.readInt();
            k = parcel.readInt();
            l = parcel.readInt();
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            throw parcel;
        }
        if (((a + d) * a) % c != c())
        {
            a = b();
            b = b();
        }
        m = new int[l];
        i1 = 0;
_L2:
        try
        {
            if (i1 >= l)
            {
                break; /* Loop/switch isn't completed */
            }
            ai = m;
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            throw parcel;
        }
        ai[i1] = parcel.readInt();
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
        n = parcel.readInt();
        o = parcel.readInt();
        p = parcel.readInt();
        return;
    }

    private HapticFileInformation(a a1)
    {
        e = com.immersion.hapticmediasdk.models.a.a(a1);
        f = com.immersion.hapticmediasdk.models.a.b(a1);
        g = com.immersion.hapticmediasdk.models.a.c(a1);
        h = com.immersion.hapticmediasdk.models.a.d(a1);
        i = com.immersion.hapticmediasdk.models.a.e(a1);
        j = com.immersion.hapticmediasdk.models.a.f(a1);
        k = com.immersion.hapticmediasdk.models.a.g(a1);
label0:
        do
        {
            switch (0)
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
                break label0;

            case 1: // '\001'
                break;
            }
        } while (true);
        if (((a + d) * a) % c != b)
        {
            a = b();
            b = b();
        }
        l = com.immersion.hapticmediasdk.models.a.h(a1);
        m = com.immersion.hapticmediasdk.models.a.i(a1);
        n = com.immersion.hapticmediasdk.models.a.j(a1);
        o = com.immersion.hapticmediasdk.models.a.k(a1);
        p = com.immersion.hapticmediasdk.models.a.l(a1);
    }

    public HapticFileInformation(a a1, a a2)
    {
        int i1 = a;
        switch ((i1 * (d + i1)) % d())
        {
        default:
            a = 42;
            b = b();
            // fall through

        case 0: // '\0'
            this(a1);
            break;
        }
    }

    public static int a()
    {
        return 1;
    }

    public static int b()
    {
        return 23;
    }

    public static int c()
    {
        return 0;
    }

    public static int d()
    {
        return 2;
    }

    public int describeContents()
    {
        int i1 = a;
        switch ((i1 * (d + i1)) % c)
        {
        default:
            a = b();
            b = 72;
            // fall through

        case 0: // '\0'
            return 0;
        }
    }

    public int e()
    {
        int i1 = a;
        switch ((i1 * (a() + i1)) % c)
        {
        default:
            a = b();
            b = b();
            break;

        case 0: // '\0'
            break;
        }
label0:
        do
        {
            switch (0)
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
                break label0;

            case 1: // '\001'
                break;
            }
        } while (true);
        return j;
    }

    public int f()
    {
        if (((a + a()) * a) % c != b)
        {
            a = b();
            b = 66;
        }
        int i1;
        try
        {
            i1 = k;
        }
        catch (Exception exception)
        {
            throw exception;
        }
        return i1;
    }

    public int g()
    {
        int i1;
        try
        {
            i1 = l;
        }
        catch (Exception exception)
        {
            throw exception;
        }
        if (((a + d) * a) % c != b)
        {
            a = 66;
            b = 11;
        }
        return i1;
    }

    public int h()
    {
        return o;
    }

    public int i()
    {
        throw new Runtime("d2j fail translate: java.lang.IndexOutOfBoundsException: fromIndex < 0: -1\n\tat java.util.BitSet.nextSetBit(BitSet.java:701)\n\tat com.googlecode.dex2jar.ir.ts.array.FillArrayTransformer.makeSureAllElementAreAssigned(FillArrayTransformer.java:505)\n\tat com.googlecode.dex2jar.ir.ts.array.FillArrayTransformer.transformReportChanged(FillArrayTransformer.java:123)\n\tat com.googlecode.dex2jar.ir.ts.StatedTransformer.transform(StatedTransformer.java:10)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:149)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        parcel.writeString(e);
        parcel.writeInt(f);
        parcel.writeInt(g);
        parcel.writeInt(h);
        if (((a + a()) * a) % c != b)
        {
            a = b();
            b = 82;
        }
        parcel.writeInt(i);
        parcel.writeInt(j);
        parcel.writeInt(k);
        parcel.writeInt(l);
        for (i1 = 0; i1 < l; i1++)
        {
            parcel.writeInt(m[i1]);
        }

        parcel.writeInt(n);
        parcel.writeInt(o);
        parcel.writeInt(p);
    }

    static 
    {
label0:
        do
        {
            switch (0)
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
                break label0;

            case 1: // '\001'
                break;
            }
        } while (true);
        if (((b() + a()) * b()) % c != b)
        {
            a = 81;
            b = 79;
        }
        public final class a
            implements android.os.Parcelable.Creator
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

            public HapticFileInformation[] a(int i1)
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
                HapticFileInformation ahapticfileinformation[] = new HapticFileInformation[i1];
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

            public Object[] newArray(int i1)
            {
                int j1 = a;
                HapticFileInformation ahapticfileinformation[];
                switch ((j1 * (c + j1)) % d)
                {
                default:
                    a = b();
                    b = 47;
                    // fall through

                case 0: // '\0'
                    ahapticfileinformation = a(i1);
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

            public a()
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

    }
}
