// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;

import android.os.Parcel;
import com.pointinside.internal.utils.Objects;
import com.pointinside.internal.utils.StringUtils;
import com.pointinside.maps.Location;
import com.pointinside.nav.BaseRouteWaypoint;
import com.pointinside.nav.IRouteWaypoint;
import com.pointinside.nav.RouteException;
import com.pointinside.nav.RouteWaypoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.pointinside.products:
//            ProductPrice, ImageInfo, Metadata, Deal, 
//            CustomerData

public class BaseProduct
    implements IRouteWaypoint
{
    public static final class PIProductsProductType extends Enum
    {

        private static final PIProductsProductType $VALUES[];
        public static final PIProductsProductType deal;
        public static final PIProductsProductType metaproduct;
        public static final PIProductsProductType product;

        public static PIProductsProductType valueOf(String s)
        {
            return (PIProductsProductType)Enum.valueOf(com/pointinside/products/BaseProduct$PIProductsProductType, s);
        }

        public static PIProductsProductType[] values()
        {
            return (PIProductsProductType[])$VALUES.clone();
        }

        static 
        {
            product = new PIProductsProductType("product", 0);
            metaproduct = new PIProductsProductType("metaproduct", 1);
            deal = new PIProductsProductType("deal", 2);
            $VALUES = (new PIProductsProductType[] {
                product, metaproduct, deal
            });
        }

        private PIProductsProductType(String s, int i)
        {
            super(s, i);
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public BaseProduct createFromParcel(Parcel parcel)
        {
            return new BaseProduct(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public BaseProduct[] newArray(int i)
        {
            return new BaseProduct[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final Boolean automaticallyApplied = Boolean.valueOf(false);
    public final String brand;
    public final String category;
    public final CustomerData customerData;
    public final String dealId;
    public final List dealProductIds;
    public final List dealType;
    public final List deals = new ArrayList();
    public final String description;
    public final Date displayEndDate;
    public final Date displayStartDate;
    public final Date endDate;
    public final List images = new ArrayList();
    public final boolean isBoosted;
    public final List locations = new ArrayList();
    public final List metadata = new ArrayList();
    public final String metaproductId;
    public final String parentCategory;
    public final ProductPrice price;
    public final String productId;
    public final Date startDate;
    public final String title;
    public final PIProductsProductType type;
    public final String upc;

    protected BaseProduct(Parcel parcel)
    {
        price = (ProductPrice)parcel.readParcelable(com/pointinside/products/ProductPrice.getClassLoader());
        parcel.readTypedList(images, ImageInfo.CREATOR);
        parcel.readTypedList(locations, Location.CREATOR);
        brand = parcel.readString();
        category = parcel.readString();
        description = parcel.readString();
        metaproductId = parcel.readString();
        parentCategory = parcel.readString();
        productId = parcel.readString();
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isBoosted = flag;
        title = parcel.readString();
        type = (PIProductsProductType)parcel.readSerializable();
        upc = parcel.readString();
        parcel.readTypedList(metadata, Metadata.CREATOR);
        dealId = parcel.readString();
        if (1 == parcel.readByte())
        {
            parcel.readTypedList(deals, Deal.CREATOR);
        }
        if (1 == parcel.readByte())
        {
            dealType = parcel.createStringArrayList();
        } else
        {
            dealType = new ArrayList();
        }
        if (1 == parcel.readByte())
        {
            startDate = (Date)parcel.readSerializable();
        } else
        {
            startDate = null;
        }
        if (1 == parcel.readByte())
        {
            endDate = (Date)parcel.readSerializable();
        } else
        {
            endDate = null;
        }
        if (1 == parcel.readByte())
        {
            displayStartDate = (Date)parcel.readSerializable();
        } else
        {
            displayStartDate = null;
        }
        if (1 == parcel.readByte())
        {
            displayEndDate = (Date)parcel.readSerializable();
        } else
        {
            displayEndDate = null;
        }
        if (1 == parcel.readByte())
        {
            dealProductIds = parcel.createStringArrayList();
        } else
        {
            dealProductIds = null;
        }
        customerData = (CustomerData)parcel.readParcelable(com/pointinside/products/CustomerData.getClassLoader());
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag;
        if (this == obj)
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (obj != null)
            {
                flag = flag1;
                if (obj instanceof BaseProduct)
                {
                    obj = (BaseProduct)obj;
                    static class _cls2
                    {

                        static final int $SwitchMap$com$pointinside$products$BaseProduct$PIProductsProductType[];

                        static 
                        {
                            $SwitchMap$com$pointinside$products$BaseProduct$PIProductsProductType = new int[PIProductsProductType.values().length];
                            try
                            {
                                $SwitchMap$com$pointinside$products$BaseProduct$PIProductsProductType[PIProductsProductType.product.ordinal()] = 1;
                            }
                            catch (NoSuchFieldError nosuchfielderror2) { }
                            try
                            {
                                $SwitchMap$com$pointinside$products$BaseProduct$PIProductsProductType[PIProductsProductType.metaproduct.ordinal()] = 2;
                            }
                            catch (NoSuchFieldError nosuchfielderror1) { }
                            try
                            {
                                $SwitchMap$com$pointinside$products$BaseProduct$PIProductsProductType[PIProductsProductType.deal.ordinal()] = 3;
                            }
                            catch (NoSuchFieldError nosuchfielderror)
                            {
                                return;
                            }
                        }
                    }

                    switch (_cls2..SwitchMap.com.pointinside.products.BaseProduct.PIProductsProductType[type.ordinal()])
                    {
                    default:
                        return false;

                    case 1: // '\001'
                        return Objects.equals(((BaseProduct) (obj)).productId, productId);

                    case 2: // '\002'
                        return Objects.equals(((BaseProduct) (obj)).metaproductId, metaproductId);

                    case 3: // '\003'
                        return Objects.equals(((BaseProduct) (obj)).dealId, dealId);
                    }
                }
            }
        }
        return flag;
    }

    public volatile BaseRouteWaypoint getWaypoint()
        throws RouteException
    {
        return getWaypoint();
    }

    public RouteWaypoint getWaypoint()
        throws RouteException
    {
        switch (_cls2..SwitchMap.com.pointinside.products.BaseProduct.PIProductsProductType[type.ordinal()])
        {
        default:
            return RouteWaypoint.buildWithTerm(title);

        case 1: // '\001'
            return RouteWaypoint.buildWithProductId(productId);

        case 2: // '\002'
            return RouteWaypoint.buildWithMetaproductId(metaproductId);
        }
    }

    public int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            productId, metaproductId, dealId, title
        });
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        StringUtils.appendIfNotNull(stringbuilder, "title", title);
        StringUtils.appendIfNotNull(stringbuilder, "description", description);
        StringUtils.appendIfNotNull(stringbuilder, "type", type.toString());
        StringUtils.appendIfNotNull(stringbuilder, "metaProductId", metaproductId);
        StringUtils.appendIfNotNull(stringbuilder, "productId", productId);
        StringUtils.appendIfNotNull(stringbuilder, "upc", upc);
        StringUtils.appendIfNotNull(stringbuilder, "category", category);
        StringUtils.appendIfNotNull(stringbuilder, "parentCategory", parentCategory);
        StringUtils.appendIfNotNull(stringbuilder, "brand", brand);
        StringUtils.appendIfNotNull(stringbuilder, "deals", deals);
        if (price != null)
        {
            stringbuilder.append(price.toString());
        }
        ImageInfo imageinfo;
        for (Iterator iterator = images.iterator(); iterator.hasNext(); stringbuilder.append(imageinfo.toString()))
        {
            imageinfo = (ImageInfo)iterator.next();
            stringbuilder.append(" ~ ImageInfo ~");
        }

        Location location;
        for (Iterator iterator1 = locations.iterator(); iterator1.hasNext(); stringbuilder.append(location.toString()))
        {
            location = (Location)iterator1.next();
            stringbuilder.append(" ~ Location ~");
        }

        if (metadata != null)
        {
            Metadata metadata1;
            for (Iterator iterator2 = metadata.iterator(); iterator2.hasNext(); stringbuilder.append(metadata1.toString()))
            {
                metadata1 = (Metadata)iterator2.next();
                stringbuilder.append(" ~ Metadata ~");
            }

        }
        if (customerData != null)
        {
            stringbuilder.append(customerData.toString());
        }
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = false;
        parcel.writeParcelable(price, 0);
        parcel.writeTypedList(images);
        parcel.writeTypedList(locations);
        parcel.writeString(brand);
        parcel.writeString(category);
        parcel.writeString(description);
        parcel.writeString(metaproductId);
        parcel.writeString(parentCategory);
        parcel.writeString(productId);
        int j;
        if (isBoosted)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeByte((byte)j);
        parcel.writeString(title);
        parcel.writeSerializable(type);
        parcel.writeString(upc);
        parcel.writeTypedList(metadata);
        parcel.writeString(dealId);
        if (deals == null)
        {
            j = 0;
        } else
        {
            j = 1;
        }
        parcel.writeByte((byte)j);
        if (deals != null)
        {
            parcel.writeTypedList(deals);
        }
        if (dealType == null)
        {
            j = 0;
        } else
        {
            j = 1;
        }
        parcel.writeByte((byte)j);
        if (dealType != null)
        {
            parcel.writeStringList(dealType);
        }
        if (startDate == null)
        {
            j = 0;
        } else
        {
            j = 1;
        }
        parcel.writeByte((byte)j);
        if (startDate != null)
        {
            parcel.writeSerializable(startDate);
        }
        if (endDate == null)
        {
            j = 0;
        } else
        {
            j = 1;
        }
        parcel.writeByte((byte)j);
        if (endDate != null)
        {
            parcel.writeSerializable(endDate);
        }
        if (displayStartDate == null)
        {
            j = 0;
        } else
        {
            j = 1;
        }
        parcel.writeByte((byte)j);
        if (displayStartDate != null)
        {
            parcel.writeSerializable(displayStartDate);
        }
        if (startDate == null)
        {
            j = 0;
        } else
        {
            j = 1;
        }
        parcel.writeByte((byte)j);
        if (displayEndDate != null)
        {
            parcel.writeSerializable(displayEndDate);
        }
        if (dealProductIds == null)
        {
            j = ((flag) ? 1 : 0);
        } else
        {
            j = 1;
        }
        parcel.writeByte((byte)j);
        if (dealProductIds != null)
        {
            parcel.writeStringList(dealProductIds);
        }
        parcel.writeParcelable(customerData, i);
    }

}
