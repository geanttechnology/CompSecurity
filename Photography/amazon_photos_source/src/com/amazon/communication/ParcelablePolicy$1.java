// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.connection.CompressionOption;
import amazon.communication.connection.KeepAlive;
import amazon.communication.connection.Priority;
import amazon.communication.connection.Purpose;
import android.os.Parcel;

// Referenced classes of package com.amazon.communication:
//            ParcelablePolicy

static final class er
    implements android.os.lablePolicy._cls1
{

    public ParcelablePolicy createFromParcel(Parcel parcel)
    {
        int i = parcel.readInt();
        if (i == 1)
        {
            CompressionOption compressionoption = CompressionOption.valueOf(parcel.readString());
            Priority priority = Priority.valueOf(parcel.readString());
            boolean flag;
            boolean flag2;
            boolean flag4;
            boolean flag6;
            boolean flag8;
            boolean flag10;
            if (parcel.readByte() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (parcel.readByte() != 0)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (parcel.readByte() != 0)
            {
                flag4 = true;
            } else
            {
                flag4 = false;
            }
            if (parcel.readByte() != 0)
            {
                flag6 = true;
            } else
            {
                flag6 = false;
            }
            if (parcel.readByte() != 0)
            {
                flag8 = true;
            } else
            {
                flag8 = false;
            }
            if (parcel.readByte() != 0)
            {
                flag10 = true;
            } else
            {
                flag10 = false;
            }
            parcel = parcel.readString();
            return new ParcelablePolicy((new amazon.communication.connection.t>()).ompressionOption(compressionoption).riority(priority).sLowLatencyNecessary(flag).sRequestResponseOnly(flag2).sClearText(flag4).sWiFiNecessary(flag6).sAnonymousCredentialsAllowed(flag8).sDedicated(flag10).urpose(new Purpose(parcel)).d());
        }
        if (i == 2)
        {
            CompressionOption compressionoption1 = CompressionOption.valueOf(parcel.readString());
            Priority priority1 = Priority.valueOf(parcel.readString());
            String s;
            boolean flag1;
            boolean flag3;
            boolean flag5;
            boolean flag7;
            boolean flag9;
            boolean flag11;
            boolean flag12;
            if (parcel.readByte() != 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (parcel.readByte() != 0)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            if (parcel.readByte() != 0)
            {
                flag5 = true;
            } else
            {
                flag5 = false;
            }
            if (parcel.readByte() != 0)
            {
                flag7 = true;
            } else
            {
                flag7 = false;
            }
            if (parcel.readByte() != 0)
            {
                flag9 = true;
            } else
            {
                flag9 = false;
            }
            if (parcel.readByte() != 0)
            {
                flag11 = true;
            } else
            {
                flag11 = false;
            }
            s = parcel.readString();
            if (parcel.readByte() != 0)
            {
                flag12 = true;
            } else
            {
                flag12 = false;
            }
            parcel = KeepAlive.valueOf(parcel.readString());
            parcel = (new amazon.communication.connection.t>()).ompressionOption(compressionoption1).riority(priority1).sLowLatencyNecessary(flag1).sRequestResponseOnly(flag3).sClearText(flag5).sWiFiNecessary(flag7).sAnonymousCredentialsAllowed(flag9).sDedicated(flag11).econnectOnFailure(flag12).eepAlive(parcel);
            if (!"".equals(s))
            {
                parcel.urpose(new Purpose(s));
            }
            return new ParcelablePolicy(parcel.d());
        } else
        {
            throw new IllegalStateException((new StringBuilder()).append("Unrecognized version: ").append(i).toString());
        }
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public ParcelablePolicy[] newArray(int i)
    {
        return new ParcelablePolicy[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    er()
    {
    }
}
