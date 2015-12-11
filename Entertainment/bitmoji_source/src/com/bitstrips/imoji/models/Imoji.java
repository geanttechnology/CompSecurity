// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.bitstrips.imoji.models:
//            PurchasedState

public class Imoji
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Imoji createFromParcel(Parcel parcel)
        {
            return new Imoji(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Imoji[] newArray(int i)
        {
            return new Imoji[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    String imageUrl;
    String purchased;
    String src;
    List supertags;
    String template_id;
    int universal_pack_id;

    public Imoji(Parcel parcel)
    {
        supertags = new ArrayList();
        parcel.readStringList(supertags);
        src = parcel.readString();
        purchased = parcel.readString();
    }

    public Imoji(List list, String s, String s1, String s2)
    {
        supertags = list;
        src = s;
        template_id = s1;
        imageUrl = null;
        purchased = s2;
    }

    private boolean equalsWithNullCheck(Object obj, Object obj1)
    {
        if (obj == null)
        {
            return obj1 == null;
        } else
        {
            return obj.equals(obj1);
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof Imoji))
            {
                return false;
            }
            obj = (Imoji)obj;
            if (!equalsWithNullCheck(src, ((Imoji) (obj)).src))
            {
                return false;
            }
            if (!equalsWithNullCheck(purchased, ((Imoji) (obj)).purchased))
            {
                return false;
            }
            if (!equalsWithNullCheck(supertags, ((Imoji) (obj)).supertags))
            {
                return false;
            }
        }
        return true;
    }

    public String getFriendmojiUrl(String s, String s1)
    {
        if (imageUrl != null)
        {
            return imageUrl;
        } else
        {
            imageUrl = String.format(src, new Object[] {
                s, s1
            });
            return imageUrl;
        }
    }

    public List getSupertags()
    {
        return supertags;
    }

    public String getTemplateId()
    {
        return template_id;
    }

    public String getUncachedUrl(String s)
    {
        return String.format(src, new Object[] {
            s
        });
    }

    public int getUniversalPackId()
    {
        return universal_pack_id;
    }

    public String getUrl(String s)
    {
        return getUrl(s, false);
    }

    public String getUrl(String s, boolean flag)
    {
        if (imageUrl != null && !flag)
        {
            return imageUrl;
        } else
        {
            imageUrl = String.format(src, new Object[] {
                s
            });
            return imageUrl;
        }
    }

    public int hashCode()
    {
        int k = 0;
        int i;
        int j;
        if (supertags != null)
        {
            i = supertags.hashCode();
        } else
        {
            i = 0;
        }
        if (src != null)
        {
            j = src.hashCode();
        } else
        {
            j = 0;
        }
        if (purchased != null)
        {
            k = purchased.hashCode();
        }
        return (i * 31 + j) * 31 + k;
    }

    public boolean isFree()
    {
        return purchased.equals(PurchasedState.FREE.toString());
    }

    public boolean isFriendmoji()
    {
        return src != null && src.indexOf("%s") != src.lastIndexOf("%s");
    }

    public boolean isPurchased()
    {
        return purchased.equals(PurchasedState.PURCHASED.toString());
    }

    public boolean isUnpurchased()
    {
        return purchased.equals(PurchasedState.UNPURCHASED.toString());
    }

    public void resetImojiImageUrl()
    {
        imageUrl = null;
    }

    public void setSupertags(List list)
    {
        supertags = list;
    }

    public String toString()
    {
        String s;
        if (supertags != null)
        {
            s = Arrays.toString(supertags.toArray());
        } else
        {
            s = "null";
        }
        return (new StringBuilder()).append("url: ").append(src).append(", supertags: ").append(s).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeStringList(supertags);
        parcel.writeString(src);
        parcel.writeString(purchased);
    }

}
