// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.connection.CompressionOption;
import amazon.communication.connection.KeepAlive;
import amazon.communication.connection.Policy;
import amazon.communication.connection.Priority;
import amazon.communication.connection.Purpose;
import android.os.Parcel;
import android.os.Parcelable;

public class ParcelablePolicy
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

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
                return new ParcelablePolicy((new amazon.communication.connection.Policy.Builder()).setCompressionOption(compressionoption).setPriority(priority).setIsLowLatencyNecessary(flag).setIsRequestResponseOnly(flag2).setIsClearText(flag4).setIsWiFiNecessary(flag6).setIsAnonymousCredentialsAllowed(flag8).setIsDedicated(flag10).setPurpose(new Purpose(parcel)).build());
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
                parcel = (new amazon.communication.connection.Policy.Builder()).setCompressionOption(compressionoption1).setPriority(priority1).setIsLowLatencyNecessary(flag1).setIsRequestResponseOnly(flag3).setIsClearText(flag5).setIsWiFiNecessary(flag7).setIsAnonymousCredentialsAllowed(flag9).setIsDedicated(flag11).setReconnectOnFailure(flag12).setKeepAlive(parcel);
                if (!"".equals(s))
                {
                    parcel.setPurpose(new Purpose(s));
                }
                return new ParcelablePolicy(parcel.build());
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

    };
    private final Policy mPolicy;

    public ParcelablePolicy(Policy policy)
    {
        if (policy == null)
        {
            throw new IllegalArgumentException("policy must not be null");
        } else
        {
            mPolicy = policy;
            return;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public Policy getPolicy()
    {
        return mPolicy;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeInt(2);
        parcel.writeString(mPolicy.getCompressionOption().toString());
        parcel.writeString(mPolicy.getPriority().toString());
        String s;
        if (mPolicy.isLowLatencyNecessary())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (mPolicy.isRequestResponseOnly())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (mPolicy.isClearText())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (mPolicy.isWiFiNecessary())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (mPolicy.isAnonymousCredentialsAllowed())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (mPolicy.isDedicated())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (mPolicy.getPurpose() == null)
        {
            s = "";
        } else
        {
            s = mPolicy.getPurpose().getPurpose();
        }
        parcel.writeString(s);
        if (mPolicy.getReconnectOnFailure())
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        parcel.writeString(mPolicy.getKeepAlive().toString());
    }

}
