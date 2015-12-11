// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;

public final class EbayCategory
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public EbayCategory createFromParcel(Parcel parcel)
        {
            return new EbayCategory(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public EbayCategory[] newArray(int i)
        {
            return new EbayCategory[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static final int FLAG_AutoPayEnabled = 2;
    private static final int FLAG_B2BVATEnabled = 4;
    private static final int FLAG_BestOfferEnabled = 8;
    private static final int FLAG_Expired = 16;
    private static final int FLAG_IntlAutosFixedCat = 32;
    private static final int FLAG_LSD = 64;
    private static final int FLAG_LeafCategory = 1;
    private static final int FLAG_ORPA = 128;
    private static final int FLAG_ORRA = 256;
    private static final int FLAG_SellerGuaranteeEligible = 512;
    private static final int FLAG_Virtual = 1024;
    public static final String PATH_SEPARATOR = ":";
    public static final long ROOT_CATEGORY_ID = -1L;
    public boolean autoPayEnabled;
    public boolean b2BVATEnabled;
    public boolean bestOfferEnabled;
    public boolean expired;
    public long id;
    public String idPath;
    public boolean intlAutosFixedCat;
    public boolean isLeaf;
    public int level;
    public boolean lsd;
    public String name;
    public String namePath;
    public boolean orpa;
    public boolean orra;
    public long parentId;
    public long resultCount;
    public boolean sellerGuaranteeEligible;
    public boolean virtual;

    public EbayCategory()
    {
        id = -1L;
        parentId = 0L;
        level = 0;
        idPath = null;
        name = null;
        namePath = null;
        isLeaf = false;
        autoPayEnabled = false;
        b2BVATEnabled = false;
        bestOfferEnabled = false;
        expired = false;
        intlAutosFixedCat = false;
        lsd = false;
        orpa = false;
        orra = false;
        sellerGuaranteeEligible = false;
        virtual = false;
    }

    public EbayCategory(long l, String s)
    {
        this();
        id = l;
        name = s;
    }

    public EbayCategory(long l, String s, long l1)
    {
        this(l, s);
        resultCount = l1;
    }

    public EbayCategory(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        id = parcel.readLong();
        parentId = parcel.readLong();
        level = parcel.readInt();
        idPath = parcel.readString();
        name = parcel.readString();
        namePath = parcel.readString();
        int i = parcel.readInt();
        boolean flag;
        if ((i & 1) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isLeaf = flag;
        if ((i & 2) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        autoPayEnabled = flag;
        if ((i & 4) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b2BVATEnabled = flag;
        if ((i & 8) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bestOfferEnabled = flag;
        if ((i & 0x10) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        expired = flag;
        if ((i & 0x20) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        intlAutosFixedCat = flag;
        if ((i & 0x40) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        lsd = flag;
        if ((i & 0x80) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        orpa = flag;
        if ((i & 0x100) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        orra = flag;
        if ((i & 0x200) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        sellerGuaranteeEligible = flag;
        if ((i & 0x400) != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        virtual = flag;
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        return name;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        char c3 = '\0';
        parcel.writeLong(id);
        parcel.writeLong(parentId);
        parcel.writeInt(level);
        parcel.writeString(idPath);
        parcel.writeString(name);
        parcel.writeString(namePath);
        byte byte0;
        byte byte1;
        byte byte2;
        byte byte3;
        byte byte4;
        byte byte5;
        char c;
        char c1;
        char c2;
        if (isLeaf)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (autoPayEnabled)
        {
            byte0 = 2;
        } else
        {
            byte0 = 0;
        }
        if (b2BVATEnabled)
        {
            byte1 = 4;
        } else
        {
            byte1 = 0;
        }
        if (bestOfferEnabled)
        {
            byte2 = 8;
        } else
        {
            byte2 = 0;
        }
        if (expired)
        {
            byte3 = 16;
        } else
        {
            byte3 = 0;
        }
        if (intlAutosFixedCat)
        {
            byte4 = 32;
        } else
        {
            byte4 = 0;
        }
        if (lsd)
        {
            byte5 = 64;
        } else
        {
            byte5 = 0;
        }
        if (orpa)
        {
            c = '\200';
        } else
        {
            c = '\0';
        }
        if (orra)
        {
            c1 = '\u0100';
        } else
        {
            c1 = '\0';
        }
        if (sellerGuaranteeEligible)
        {
            c2 = '\u0200';
        } else
        {
            c2 = '\0';
        }
        if (virtual)
        {
            c3 = '\u0400';
        }
        parcel.writeInt(c2 | (byte0 | i | byte1 | byte2 | byte3 | byte4 | byte5 | c | c1) | c3);
    }

}
