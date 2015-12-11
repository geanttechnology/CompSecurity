// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.tags;

import android.os.Parcel;
import android.os.Parcelable;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.Program;

public class FeaturedShow
    implements Parcelable, Program
{
    public static final class EntityType extends Enum
    {

        private static final EntityType $VALUES[];
        public static final EntityType Movie;
        public static final EntityType TvSeries;

        public static EntityType valueOf(String s)
        {
            return (EntityType)Enum.valueOf(com/xfinity/playerlib/model/tags/FeaturedShow$EntityType, s);
        }

        public static EntityType[] values()
        {
            return (EntityType[])$VALUES.clone();
        }

        static 
        {
            Movie = new EntityType("Movie", 0);
            TvSeries = new EntityType("TvSeries", 1);
            $VALUES = (new EntityType[] {
                Movie, TvSeries
            });
        }

        private EntityType(String s, int i)
        {
            super(s, i);
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public FeaturedShow createFromParcel(Parcel parcel)
        {
            return new FeaturedShow(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public FeaturedShow[] newArray(int i)
        {
            return new FeaturedShow[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private final String entityId;
    private final String entityName;
    private final EntityType entityType;
    private final String imageUrl;
    private final String imageUrl2x;
    private final MerlinId merlinId;

    private FeaturedShow(Parcel parcel)
    {
        entityId = parcel.readString();
        entityName = parcel.readString();
        entityType = EntityType.values()[parcel.readInt()];
        imageUrl = parcel.readString();
        imageUrl2x = parcel.readString();
        merlinId = createMerlinId();
    }


    FeaturedShow(String s, String s1, EntityType entitytype, String s2, String s3)
    {
        entityId = s;
        entityName = s1;
        entityType = entitytype;
        imageUrl = s2;
        imageUrl2x = s3;
        merlinId = createMerlinId();
    }

    private MerlinId createMerlinId()
    {
        return new MerlinId(com.xfinity.playerlib.model.MerlinId.Namespace.valueOf(entityType.name()), Long.valueOf(entityId));
    }

    public int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj instanceof FeaturedShow)
        {
            obj = (FeaturedShow)obj;
            return (entityId == ((FeaturedShow) (obj)).entityId || entityId != null && entityId.equals(((FeaturedShow) (obj)).entityId)) && (entityName == ((FeaturedShow) (obj)).entityName || entityName != null && entityName.equals(((FeaturedShow) (obj)).entityName)) && (entityType == ((FeaturedShow) (obj)).entityType || entityType != null && entityType.equals(((FeaturedShow) (obj)).entityType)) && (imageUrl == ((FeaturedShow) (obj)).imageUrl || imageUrl != null && imageUrl.equals(((FeaturedShow) (obj)).imageUrl)) && (imageUrl2x == ((FeaturedShow) (obj)).imageUrl2x || imageUrl2x != null && imageUrl2x.equals(((FeaturedShow) (obj)).imageUrl2x));
        } else
        {
            return false;
        }
    }

    public String getEntityId()
    {
        return entityId;
    }

    public String getEntityName()
    {
        return entityName;
    }

    public EntityType getEntityType()
    {
        return entityType;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public String getImageUrl2x()
    {
        return imageUrl2x;
    }

    public MerlinId getMerlinId()
    {
        return merlinId;
    }

    public com.xfinity.playerlib.model.MerlinId.Namespace getMerlinIdNamespace()
    {
        return getMerlinId().getNamespace();
    }

    public MerlinId getParentMerlinIdIfApplicable()
    {
        return getMerlinId();
    }

    public String getTitle()
    {
        return entityName;
    }

    public final int hashCode()
    {
        int i1 = 0;
        int i;
        int j;
        int k;
        int l;
        if (entityId == null)
        {
            i = 0;
        } else
        {
            i = entityId.hashCode();
        }
        if (entityName == null)
        {
            j = 0;
        } else
        {
            j = entityName.hashCode();
        }
        if (entityType == null)
        {
            k = 0;
        } else
        {
            k = entityType.hashCode();
        }
        if (imageUrl == null)
        {
            l = 0;
        } else
        {
            l = imageUrl.hashCode();
        }
        if (imageUrl2x != null)
        {
            i1 = imageUrl2x.hashCode();
        }
        return ((((i + 217) * 31 + j) * 31 + k) * 31 + l) * 31 + i1;
    }

    public boolean isMovie()
    {
        return getMerlinIdNamespace().equals(com.xfinity.playerlib.model.MerlinId.Namespace.Movie);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(entityId);
        parcel.writeString(entityName);
        parcel.writeInt(entityType.ordinal());
        parcel.writeString(imageUrl);
        parcel.writeString(imageUrl2x);
    }

}
