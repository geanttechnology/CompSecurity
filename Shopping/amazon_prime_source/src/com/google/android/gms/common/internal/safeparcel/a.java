// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public class com.google.android.gms.common.internal.safeparcel.a
{
    public static class a extends RuntimeException
    {

        public a(String s, Parcel parcel)
        {
            super((new StringBuilder()).append(s).append(" Parcel: pos=").append(parcel.dataPosition()).append(" size=").append(parcel.dataSize()).toString());
        }
    }


    public static ArrayList A(Parcel parcel, int j)
    {
        j = a(parcel, j);
        int k = parcel.dataPosition();
        if (j == 0)
        {
            return null;
        } else
        {
            ArrayList arraylist = parcel.createStringArrayList();
            parcel.setDataPosition(j + k);
            return arraylist;
        }
    }

    public static int R(int j)
    {
        return 0xffff & j;
    }

    public static int a(Parcel parcel, int j)
    {
        if ((j & 0xffff0000) != 0xffff0000)
        {
            return j >> 16 & 0xffff;
        } else
        {
            return parcel.readInt();
        }
    }

    public static Parcelable a(Parcel parcel, int j, android.os.Parcelable.Creator creator)
    {
        j = a(parcel, j);
        int k = parcel.dataPosition();
        if (j == 0)
        {
            return null;
        } else
        {
            creator = (Parcelable)creator.createFromParcel(parcel);
            parcel.setDataPosition(j + k);
            return creator;
        }
    }

    private static void a(Parcel parcel, int j, int k)
    {
        j = a(parcel, j);
        if (j != k)
        {
            throw new a((new StringBuilder()).append("Expected size ").append(k).append(" got ").append(j).append(" (0x").append(Integer.toHexString(j)).append(")").toString(), parcel);
        } else
        {
            return;
        }
    }

    public static void b(Parcel parcel, int j)
    {
        parcel.setDataPosition(a(parcel, j) + parcel.dataPosition());
    }

    public static Object[] b(Parcel parcel, int j, android.os.Parcelable.Creator creator)
    {
        j = a(parcel, j);
        int k = parcel.dataPosition();
        if (j == 0)
        {
            return null;
        } else
        {
            creator = ((android.os.Parcelable.Creator) (parcel.createTypedArray(creator)));
            parcel.setDataPosition(j + k);
            return creator;
        }
    }

    public static boolean c(Parcel parcel, int j)
    {
        a(parcel, j, 4);
        return parcel.readInt() != 0;
    }

    public static int g(Parcel parcel, int j)
    {
        a(parcel, j, 4);
        return parcel.readInt();
    }

    public static long i(Parcel parcel, int j)
    {
        a(parcel, j, 8);
        return parcel.readLong();
    }

    public static int n(Parcel parcel)
    {
        return parcel.readInt();
    }

    public static String n(Parcel parcel, int j)
    {
        j = a(parcel, j);
        int k = parcel.dataPosition();
        if (j == 0)
        {
            return null;
        } else
        {
            String s = parcel.readString();
            parcel.setDataPosition(j + k);
            return s;
        }
    }

    public static int o(Parcel parcel)
    {
        int k = n(parcel);
        int l = a(parcel, k);
        int j = parcel.dataPosition();
        if (R(k) != 20293)
        {
            throw new a((new StringBuilder()).append("Expected object header. Got 0x").append(Integer.toHexString(k)).toString(), parcel);
        }
        k = j + l;
        if (k < j || k > parcel.dataSize())
        {
            throw new a((new StringBuilder()).append("Size read is invalid start=").append(j).append(" end=").append(k).toString(), parcel);
        } else
        {
            return k;
        }
    }

    public static IBinder o(Parcel parcel, int j)
    {
        j = a(parcel, j);
        int k = parcel.dataPosition();
        if (j == 0)
        {
            return null;
        } else
        {
            IBinder ibinder = parcel.readStrongBinder();
            parcel.setDataPosition(j + k);
            return ibinder;
        }
    }

    public static Bundle p(Parcel parcel, int j)
    {
        j = a(parcel, j);
        int k = parcel.dataPosition();
        if (j == 0)
        {
            return null;
        } else
        {
            Bundle bundle = parcel.readBundle();
            parcel.setDataPosition(j + k);
            return bundle;
        }
    }
}
