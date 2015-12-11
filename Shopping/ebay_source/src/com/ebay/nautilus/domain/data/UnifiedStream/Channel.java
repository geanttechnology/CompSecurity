// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.nautilus.domain.data.cos.base.Text;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class Channel
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Channel createFromParcel(Parcel parcel)
        {
            return new Channel(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Channel[] newArray(int i)
        {
            return new Channel[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static final int HASH_PRIME = 31;
    public String departmentName;
    public Text displayName;
    public boolean isDepartment;
    public boolean isLanding;
    public String name;
    public List subChannels;
    public String topBannerLarge;
    public String topBannerSmall;

    public Channel()
    {
    }

    private Channel(Parcel parcel)
    {
        if (parcel != null)
        {
            name = parcel.readString();
            displayName = (Text)parcel.readParcelable(com/ebay/nautilus/domain/data/cos/base/Text.getClassLoader());
            int j = parcel.readInt();
            Boolean boolean1;
            if (j < 0)
            {
                subChannels = null;
            } else
            {
                subChannels = new ArrayList(j);
                int i = 0;
                while (i < j) 
                {
                    subChannels.add((Channel)parcel.readParcelable(com/ebay/nautilus/domain/data/UnifiedStream/Channel.getClassLoader()));
                    i++;
                }
            }
            if (parcel.readInt() == 0)
            {
                boolean1 = Boolean.FALSE;
            } else
            {
                boolean1 = Boolean.TRUE;
            }
            isDepartment = boolean1.booleanValue();
            if (isDepartment)
            {
                departmentName = parcel.readString();
            }
            topBannerSmall = parcel.readString();
            topBannerLarge = parcel.readString();
            if (parcel.readInt() == 0)
            {
                parcel = Boolean.FALSE;
            } else
            {
                parcel = Boolean.TRUE;
            }
            isLanding = parcel.booleanValue();
        }
    }


    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (!(obj instanceof Channel)) goto _L4; else goto _L3
_L3:
        obj = (Channel)obj;
        flag = flag1;
        if (isDepartment != ((Channel) (obj)).isDepartment) goto _L4; else goto _L5
_L5:
        flag = flag1;
        if (isLanding != ((Channel) (obj)).isLanding) goto _L4; else goto _L6
_L6:
        flag = flag1;
        if (!TextUtils.equals(name, ((Channel) (obj)).name)) goto _L4; else goto _L7
_L7:
        if (displayName == null) goto _L9; else goto _L8
_L8:
        flag = flag1;
        if (!displayName.equals(((Channel) (obj)).displayName)) goto _L4; else goto _L10
_L10:
        flag = flag1;
        if (!TextUtils.equals(topBannerSmall, ((Channel) (obj)).topBannerSmall)) goto _L4; else goto _L11
_L11:
        flag = flag1;
        if (!TextUtils.equals(topBannerLarge, ((Channel) (obj)).topBannerLarge)) goto _L4; else goto _L12
_L12:
        if (subChannels == null)
        {
            break MISSING_BLOCK_LABEL_168;
        }
        flag = flag1;
        if (!subChannels.equals(((Channel) (obj)).subChannels)) goto _L4; else goto _L13
_L13:
        return TextUtils.equals(departmentName, ((Channel) (obj)).departmentName);
_L9:
        if (((Channel) (obj)).displayName != null)
        {
            return false;
        }
          goto _L10
        if (((Channel) (obj)).subChannels != null)
        {
            return false;
        }
          goto _L13
    }

    public String getTrackingName()
    {
        if (isDepartment)
        {
            return departmentName;
        } else
        {
            return name;
        }
    }

    public int hashCode()
    {
        int l1 = 1;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        if (name != null)
        {
            i = name.hashCode();
        } else
        {
            i = 0;
        }
        if (displayName != null)
        {
            j = displayName.hashCode();
        } else
        {
            j = 0;
        }
        if (topBannerSmall != null)
        {
            k = topBannerSmall.hashCode();
        } else
        {
            k = 0;
        }
        if (topBannerLarge != null)
        {
            l = topBannerLarge.hashCode();
        } else
        {
            l = 0;
        }
        if (subChannels != null)
        {
            i1 = subChannels.hashCode();
        } else
        {
            i1 = 0;
        }
        if (departmentName != null)
        {
            j1 = departmentName.hashCode();
        } else
        {
            j1 = 0;
        }
        if (isDepartment)
        {
            k1 = 1;
        } else
        {
            k1 = 0;
        }
        if (!isLanding)
        {
            l1 = 0;
        }
        return ((((((i * 31 + j) * 31 + k) * 31 + l) * 31 + i1) * 31 + j1) * 31 + k1) * 31 + l1;
    }

    public String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("Channel(");
        String s;
        if (displayName != null)
        {
            s = displayName.content;
        } else
        {
            s = name;
        }
        return stringbuilder.append(s).append(")").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeString(name);
        parcel.writeParcelable(displayName, i);
        int j;
        if (subChannels == null)
        {
            j = -1;
        } else
        {
            j = subChannels.size();
        }
        parcel.writeInt(j);
        if (subChannels != null)
        {
            for (Iterator iterator = subChannels.iterator(); iterator.hasNext(); parcel.writeParcelable((Channel)iterator.next(), i)) { }
        }
        if (isDepartment)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (isDepartment)
        {
            parcel.writeString(departmentName);
        }
        parcel.writeString(topBannerSmall);
        parcel.writeString(topBannerLarge);
        if (isLanding)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }

}
