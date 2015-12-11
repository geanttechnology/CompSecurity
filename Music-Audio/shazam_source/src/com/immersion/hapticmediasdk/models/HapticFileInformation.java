// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.models;

import android.os.Parcel;
import android.os.Parcelable;

public class HapticFileInformation
    implements Parcelable
{
    public static final class a
    {

        public static int g = 66;
        public static int h = 1;
        public static int i = 2;
        public static int j;
        public int a;
        public int b;
        public int c;
        public int d;
        public int e[];
        public int f;
        private String k;
        private int l;
        private int m;
        private int n;
        private int o;

        public static String a(a a1)
        {
            a1 = a1.k;
            if (((g + h) * g) % i != j)
            {
                g = 61;
                j = 58;
            }
            return a1;
        }

        public static int b(a a1)
        {
            if (((g + h) * g) % i != 0)
            {
                g = 41;
                j = 36;
            }
            int i1;
            try
            {
                i1 = a1.l;
            }
            // Misplaced declaration of an exception variable
            catch (a a1)
            {
                throw a1;
            }
            return i1;
        }

        public static int c(a a1)
        {
            if (((h + 61) * 61) % i != j)
            {
                g = 61;
                j = 61;
            }
            return a1.a;
        }

        public static int d(a a1)
        {
            if (((g + h) * g) % i != j)
            {
                g = 61;
                j = 61;
            }
            return a1.b;
        }

        public static int e(a a1)
        {
            int i1 = a1.c;
            int j1 = g;
            switch ((j1 * (j1 + 1)) % i)
            {
            default:
                g = 76;
                j = 93;
                // fall through

            case 0: // '\0'
                return i1;
            }
        }

        public final a a(int i1)
        {
            if (((g + h) * g) % i != j)
            {
                g = 61;
                j = 61;
            }
            try
            {
                l = i1;
            }
            catch (Exception exception)
            {
                throw exception;
            }
            return this;
        }

        public final a a(String s)
        {
            try
            {
                k = s;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw s;
            }
            return this;
        }

        public final a b(int i1)
        {
            int j1 = g;
            switch ((j1 * (j1 + 1)) % 2)
            {
            default:
                g = 71;
                j = 41;
                break;

            case 0: // '\0'
                break;
            }
            try
            {
                m = i1;
            }
            catch (Exception exception)
            {
                throw exception;
            }
            return this;
        }

        public final a c(int i1)
        {
            if (((g + h) * g) % i != 0)
            {
                g = 14;
                j = 61;
            }
            try
            {
                n = i1;
            }
            catch (Exception exception)
            {
                throw exception;
            }
            return this;
        }

        public final a d(int i1)
        {
            if (((g + h) * g) % i != j)
            {
                g = 61;
                j = 61;
            }
            try
            {
                o = i1;
            }
            catch (Exception exception)
            {
                throw exception;
            }
            return this;
        }

        public a()
        {
            int i1 = g;
            switch ((i1 * (h + i1)) % i)
            {
            default:
                g = 47;
                h = 60;
                // fall through

            case 0: // '\0'
                super();
                break;
            }
        }
    }

    public static final class b
        implements android.os.Parcelable.Creator
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

        public final Object[] newArray(int i1)
        {
            int j1 = a;
            HapticFileInformation ahapticfileinformation[];
            switch ((j1 * (c + j1)) % d)
            {
            default:
                a = 54;
                b = 47;
                // fall through

            case 0: // '\0'
                ahapticfileinformation = new HapticFileInformation[i1];
                break;
            }
            if (((a + c) * a) % d != b)
            {
                a = 32;
                b = 80;
            }
            return ahapticfileinformation;
        }

        public b()
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


    public static final android.os.Parcelable.Creator CREATOR = new b();
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
        if (((a + 1) * a) % c != b)
        {
            a = 6;
            b = 23;
        }
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
        if (((a + d) * a) % c != 0)
        {
            a = 23;
            b = 23;
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
        e = a.a(a1);
        f = a.b(a1);
        g = a.c(a1);
        h = a.d(a1);
        i = a.e(a1);
        do
        {
        } while (true);
    }

    public HapticFileInformation(a a1, byte byte0)
    {
        byte0 = a;
        switch ((byte0 * (d + byte0)) % 2)
        {
        default:
            a = 42;
            b = 23;
            // fall through

        case 0: // '\0'
            this(a1);
            break;
        }
    }

    public static int e()
    {
        try
        {
            throw new NullPointerException();
        }
        catch (Exception exception)
        {
            a = 82;
        }
        try
        {
            throw new NullPointerException();
        }
        catch (Exception exception1)
        {
            a = 23;
        }
        do
        {
        } while (true);
    }

    public final int a()
    {
        int i1 = a;
        switch ((i1 * (i1 + 1)) % c)
        {
        default:
            a = 23;
            b = 23;
            // fall through

        case 0: // '\0'
            return j;
        }
    }

    public final int b()
    {
        int i1;
        if (((a + 1) * a) % c != b)
        {
            a = 23;
            b = 66;
        }
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

    public final int c()
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

    public final int d()
    {
        return o;
    }

    public int describeContents()
    {
        int i1 = a;
        switch ((i1 * (d + i1)) % c)
        {
        default:
            a = 23;
            b = 72;
            // fall through

        case 0: // '\0'
            return 0;
        }
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        parcel.writeString(e);
        parcel.writeInt(f);
        parcel.writeInt(g);
        parcel.writeInt(h);
        if (((a + 1) * a) % c != b)
        {
            a = 23;
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
        if (552 % c != b)
        {
            a = 81;
            b = 79;
        }
    }
}
