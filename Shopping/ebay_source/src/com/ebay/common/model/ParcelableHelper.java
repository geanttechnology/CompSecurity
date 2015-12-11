// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

public abstract class ParcelableHelper
{

    public ParcelableHelper()
    {
    }

    protected static boolean readBoolean(Parcel parcel)
    {
        return parcel.readByte() == 1;
    }

    protected static Boolean readOptBoolean(Parcel parcel)
    {
        Boolean boolean1 = null;
        if (readBoolean(parcel))
        {
            boolean1 = Boolean.valueOf(readBoolean(parcel));
        }
        return boolean1;
    }

    protected static Date readOptDate(Parcel parcel)
    {
        long l = parcel.readLong();
        if (l != 0x8000000000000000L)
        {
            return new Date(l);
        } else
        {
            return null;
        }
    }

    protected static Double readOptDouble(Parcel parcel)
    {
        Double double1 = null;
        if (readBoolean(parcel))
        {
            double1 = Double.valueOf(parcel.readDouble());
        }
        return double1;
    }

    protected static Float readOptFloat(Parcel parcel)
    {
        Float float1 = null;
        if (readBoolean(parcel))
        {
            float1 = Float.valueOf(parcel.readFloat());
        }
        return float1;
    }

    protected static Integer readOptInt(Parcel parcel)
    {
        Integer integer = null;
        if (readBoolean(parcel))
        {
            integer = Integer.valueOf(parcel.readInt());
        }
        return integer;
    }

    protected static Long readOptLong(Parcel parcel)
    {
        Long long1 = null;
        if (readBoolean(parcel))
        {
            long1 = Long.valueOf(parcel.readLong());
        }
        return long1;
    }

    protected static Parcelable readOptParcelable(Parcel parcel)
    {
        Parcelable parcelable = null;
        if (readBoolean(parcel))
        {
            parcelable = parcel.readParcelable(com/ebay/common/model/ParcelableHelper.getClassLoader());
        }
        return parcelable;
    }

    protected static String readOptString(Parcel parcel)
    {
        String s = null;
        if (readBoolean(parcel))
        {
            s = parcel.readString();
        }
        return s;
    }

    protected static void writeBoolean(Parcel parcel, boolean flag)
    {
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
    }

    protected static void writeOptBoolean(Parcel parcel, Boolean boolean1)
    {
        boolean flag;
        if (boolean1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        writeBoolean(parcel, flag);
        if (flag)
        {
            writeBoolean(parcel, boolean1.booleanValue());
        }
    }

    protected static void writeOptDate(Parcel parcel, Date date)
    {
        long l;
        if (date != null)
        {
            l = date.getTime();
        } else
        {
            l = 0x8000000000000000L;
        }
        parcel.writeLong(l);
    }

    protected static void writeOptDouble(Parcel parcel, Double double1)
    {
        boolean flag;
        if (double1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        writeBoolean(parcel, flag);
        if (flag)
        {
            parcel.writeDouble(double1.doubleValue());
        }
    }

    protected static void writeOptFloat(Parcel parcel, Float float1)
    {
        boolean flag;
        if (float1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        writeBoolean(parcel, flag);
        if (flag)
        {
            parcel.writeFloat(float1.floatValue());
        }
    }

    protected static void writeOptInt(Parcel parcel, Integer integer)
    {
        boolean flag;
        if (integer != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        writeBoolean(parcel, flag);
        if (flag)
        {
            parcel.writeInt(integer.intValue());
        }
    }

    protected static void writeOptLong(Parcel parcel, Long long1)
    {
        boolean flag;
        if (long1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        writeBoolean(parcel, flag);
        if (flag)
        {
            parcel.writeLong(long1.longValue());
        }
    }

    protected static void writeOptParcelable(Parcel parcel, Parcelable parcelable, int i)
    {
        boolean flag;
        if (parcelable != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        writeBoolean(parcel, flag);
        if (parcelable != null)
        {
            parcel.writeParcelable(parcelable, i);
        }
    }

    protected static void writeOptString(Parcel parcel, String s)
    {
        boolean flag;
        if (s != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        writeBoolean(parcel, flag);
        if (flag)
        {
            parcel.writeString(s);
        }
    }
}
