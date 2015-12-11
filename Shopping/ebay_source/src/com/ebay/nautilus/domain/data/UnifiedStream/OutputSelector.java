// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.ebay.nautilus.domain.data.UnifiedStream:
//            ContentSourceEnum

public class OutputSelector
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public OutputSelector createFromParcel(Parcel parcel)
        {
            return new OutputSelector(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public OutputSelector[] newArray(int i)
        {
            return new OutputSelector[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static final int PRIME = 31;
    public ContentSourceEnum contentSource;

    OutputSelector(Parcel parcel)
    {
        contentSource = ContentSourceEnum.values()[parcel.readInt()];
    }

    public OutputSelector(ContentSourceEnum contentsourceenum)
    {
        contentSource = contentsourceenum;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (obj instanceof OutputSelector)
            {
                obj = (OutputSelector)obj;
                if (contentSource != ((OutputSelector) (obj)).contentSource)
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int j = getClass().getName().hashCode();
        int i;
        if (contentSource == null)
        {
            i = 0;
        } else
        {
            i = contentSource.hashCode();
        }
        return j * 31 + i;
    }

    public String toString()
    {
        return (new StringBuilder()).append("OutputSelector(").append(contentSource).append(")").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(contentSource.ordinal());
    }

}
