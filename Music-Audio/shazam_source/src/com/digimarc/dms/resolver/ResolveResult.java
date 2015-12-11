// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.resolver;

import android.os.Parcel;
import android.os.Parcelable;
import com.digimarc.dms.imagereader.Payload;

// Referenced classes of package com.digimarc.dms.resolver:
//            PayoffContainer, StandardPayoff, Payoff

public class ResolveResult
    implements Parcelable
{
    public static final class PayoffType extends Enum
    {

        private static final PayoffType $VALUES[];
        public static final PayoffType Error;
        public static final PayoffType Inactive;
        public static final PayoffType Standard;

        public static PayoffType valueOf(String s)
        {
            return (PayoffType)Enum.valueOf(com/digimarc/dms/resolver/ResolveResult$PayoffType, s);
        }

        public static PayoffType[] values()
        {
            return (PayoffType[])$VALUES.clone();
        }

        static 
        {
            Standard = new PayoffType("Standard", 0);
            Inactive = new PayoffType("Inactive", 1);
            Error = new PayoffType("Error", 2);
            $VALUES = (new PayoffType[] {
                Standard, Inactive, Error
            });
        }

        private PayoffType(String s, int i)
        {
            super(s, i);
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final ResolveResult createFromParcel(Parcel parcel)
        {
            return new ResolveResult(PayoffType.valueOf(parcel.readString()), (Payload)parcel.readParcelable(com/digimarc/dms/imagereader/Payload.getClassLoader()), parcel.readInt(), (StandardPayoff)parcel.readParcelable(com/digimarc/dms/resolver/StandardPayoff.getClassLoader()));
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final ResolveResult[] newArray(int i)
        {
            return null;
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static String TAG = "ResolveResult";
    private Payload mPayload;
    private Payoff mPayoff;
    private PayoffType mPayoffType;
    private int mResolveTime;

    protected ResolveResult(Payload payload, String s, Payoff payoff, int i)
    {
        mPayload = payload;
        mResolveTime = i;
        mPayoff = payoff;
        payload = s.toUpperCase();
        if (payload.equals("UNRESOLVED"))
        {
            mPayoffType = PayoffType.Inactive;
        } else
        {
            if (payload.equals("STANDARDPAYOFFONLY"))
            {
                mPayoffType = PayoffType.Standard;
                return;
            }
            if (payload.equals("NETWORKERROR"))
            {
                mPayoffType = PayoffType.Error;
                return;
            }
        }
    }

    public ResolveResult(PayoffType payofftype, Payload payload, int i, Payoff payoff)
    {
        mPayoffType = payofftype;
        mPayload = payload;
        mResolveTime = i;
        mPayoff = payoff;
    }

    static ResolveResult create(PayoffContainer payoffcontainer)
    {
        return new ResolveResult(payoffcontainer.getPayload(), payoffcontainer.getResult(), payoffcontainer.getStandardPayoff(), payoffcontainer.getTime());
    }

    public int describeContents()
    {
        return 0;
    }

    public Payload getPayload()
    {
        return mPayload;
    }

    public PayoffType getPayoffType()
    {
        return mPayoffType;
    }

    public int getResolveTime()
    {
        return mResolveTime;
    }

    public StandardPayoff getStandardPayoff()
    {
        return (StandardPayoff)mPayoff;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        String s;
        if (mPayoffType == null)
        {
            s = "";
        } else
        {
            s = mPayoffType.name();
        }
        parcel.writeString(s);
        parcel.writeParcelable(mPayload, 0);
        parcel.writeInt(mResolveTime);
        parcel.writeParcelable(mPayoff, 0);
    }

}
