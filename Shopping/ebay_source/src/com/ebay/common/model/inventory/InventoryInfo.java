// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.inventory;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.common.model.ParcelableHelper;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.common.model.inventory:
//            StoreAvailability

public class InventoryInfo extends ParcelableHelper
    implements Parcelable
{
    public static final class ListDerivation extends Enum
    {

        private static final ListDerivation $VALUES[];
        public static final ListDerivation LATLNG;
        public static final ListDerivation POSTAL_CODE;
        public static final ListDerivation SEARCH_POSTAL_CODE;
        public static final ListDerivation UNKNOWN;
        private int value;

        public static ListDerivation getFromValue(int i)
        {
            ListDerivation alistderivation[] = values();
            int k = alistderivation.length;
            for (int j = 0; j < k; j++)
            {
                ListDerivation listderivation = alistderivation[j];
                if (listderivation.getValue() == i)
                {
                    return listderivation;
                }
            }

            return UNKNOWN;
        }

        public static ListDerivation valueOf(String s)
        {
            return (ListDerivation)Enum.valueOf(com/ebay/common/model/inventory/InventoryInfo$ListDerivation, s);
        }

        public static ListDerivation[] values()
        {
            return (ListDerivation[])$VALUES.clone();
        }

        public int getValue()
        {
            return value;
        }

        static 
        {
            UNKNOWN = new ListDerivation("UNKNOWN", 0, 0);
            LATLNG = new ListDerivation("LATLNG", 1, 1);
            POSTAL_CODE = new ListDerivation("POSTAL_CODE", 2, 2);
            SEARCH_POSTAL_CODE = new ListDerivation("SEARCH_POSTAL_CODE", 3, 3);
            $VALUES = (new ListDerivation[] {
                UNKNOWN, LATLNG, POSTAL_CODE, SEARCH_POSTAL_CODE
            });
        }

        private ListDerivation(String s, int i, int j)
        {
            super(s, i);
            value = j;
        }
    }


    static final double BEARING_DUE_EAST = Math.toRadians(90D);
    static final double BEARING_DUE_NORTH = Math.toRadians(0.0D);
    static final double BEARING_DUE_SOUTH = Math.toRadians(180D);
    static final double BEARING_DUE_WEST = Math.toRadians(270D);
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public InventoryInfo createFromParcel(Parcel parcel)
        {
            return new InventoryInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public InventoryInfo[] newArray(int i)
        {
            return new InventoryInfo[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    static final double RADIUS_OF_EARTH_IN_MILES = 3963.0999999999999D;
    private List availabilities;
    private double boundingBoxComponents[];
    private String checkoutLineItemId;
    private ListDerivation derivation;
    private Date estimatedDeliveryDate;
    private boolean forceInventoryLookup;
    private String itemSku;
    private com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type logisticsPlanType;
    private String postalCode;
    private LatLng queryLocation;
    private String searchRefinedPostalCode;
    private StoreAvailability selectedStore;
    private String sellerUserId;
    public String site;
    private LatLng userLocation;

    public InventoryInfo()
    {
        derivation = ListDerivation.UNKNOWN;
        searchRefinedPostalCode = null;
        postalCode = null;
        userLocation = null;
        queryLocation = null;
        boundingBoxComponents = null;
        availabilities = null;
        selectedStore = null;
        derivation = ListDerivation.UNKNOWN;
        itemSku = null;
        sellerUserId = null;
        checkoutLineItemId = null;
        forceInventoryLookup = false;
        logisticsPlanType = com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.UNKNOWN;
        estimatedDeliveryDate = null;
        site = null;
    }

    private InventoryInfo(Parcel parcel)
    {
        derivation = ListDerivation.UNKNOWN;
        int j;
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        forceInventoryLookup = flag;
        searchRefinedPostalCode = parcel.readString();
        postalCode = parcel.readString();
        if (parcel.readInt() == 1)
        {
            userLocation = new LatLng(parcel.readDouble(), parcel.readDouble());
        }
        if (parcel.readInt() == 1)
        {
            queryLocation = new LatLng(parcel.readDouble(), parcel.readDouble());
        }
        boundingBoxComponents = parcel.createDoubleArray();
        j = parcel.readInt();
        if (j > 0)
        {
            availabilities = new ArrayList();
            for (int i = 0; i < j; i++)
            {
                availabilities.add(StoreAvailability.CREATOR.createFromParcel(parcel));
            }

        }
        derivation = ListDerivation.getFromValue(parcel.readInt());
        if (parcel.readInt() == 1)
        {
            selectedStore = (StoreAvailability)StoreAvailability.CREATOR.createFromParcel(parcel);
        }
        itemSku = parcel.readString();
        sellerUserId = parcel.readString();
        checkoutLineItemId = parcel.readString();
        logisticsPlanType = com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.fromOrdinal(parcel.readInt());
        if (parcel.readInt() == 1)
        {
            estimatedDeliveryDate = new Date(parcel.readLong());
        }
        site = parcel.readString();
    }


    public InventoryInfo(String s, LatLng latlng, int i, List list, ListDerivation listderivation, String s1, String s2, 
            com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type type, Date date, String s3)
    {
        derivation = ListDerivation.UNKNOWN;
        postalCode = s;
        userLocation = latlng;
        if (latlng != null)
        {
            boundingBoxComponents = calculateBoundingBox(latlng, i);
        }
        queryLocation = null;
        availabilities = list;
        derivation = listderivation;
        sellerUserId = s1;
        itemSku = s2;
        forceInventoryLookup = false;
        if (type == null)
        {
            type = com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.UNKNOWN;
        }
        logisticsPlanType = type;
        estimatedDeliveryDate = date;
        site = s3;
    }

    private double[] calculateBoundingBox(LatLng latlng, double d)
    {
        double d4 = d / 2D / 3963.0999999999999D;
        double d5 = Math.toRadians(latlng.latitude);
        double d1 = Math.toRadians(latlng.longitude);
        double d2 = Math.asin(Math.sin(d5) * Math.cos(d4) + Math.cos(d5) * Math.sin(d4) * Math.cos(BEARING_DUE_NORTH));
        double d3 = Math.asin(Math.sin(d5) * Math.cos(d4) + Math.cos(d5) * Math.sin(d4) * Math.cos(BEARING_DUE_SOUTH));
        d = Math.atan2(Math.sin(BEARING_DUE_EAST) * Math.sin(d4) * Math.cos(d5), Math.cos(d4) - Math.sin(d5) * Math.sin(d5));
        d4 = Math.atan2(Math.sin(BEARING_DUE_WEST) * Math.sin(d4) * Math.cos(d5), Math.cos(d4) - Math.sin(d5) * Math.sin(d5));
        d2 = Math.toDegrees(d2);
        d3 = Math.toDegrees(d3);
        d = Math.toDegrees(d1 + d);
        d1 = Math.toDegrees(d1 + d4);
        d5 = d3;
        double d7 = d1;
        double d6 = d2;
        d4 = d;
        if (d2 < d3)
        {
            d6 = d3;
            d5 = d2;
        }
        if (d < d1)
        {
            d4 = d1;
            d7 = d;
        }
        return (new double[] {
            d5, d7, d6, d4
        });
    }

    public int describeContents()
    {
        return 0;
    }

    public List getAvailabilities()
    {
        return availabilities;
    }

    public double[] getBoundingBox()
    {
        return boundingBoxComponents;
    }

    public String getCheckoutLineItemId()
    {
        return checkoutLineItemId;
    }

    public ListDerivation getDerivation()
    {
        return derivation;
    }

    public Date getEstimatedDeliveryDate()
    {
        return estimatedDeliveryDate;
    }

    public String getItemSku()
    {
        return itemSku;
    }

    public com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type getLogisticsPlanType()
    {
        return logisticsPlanType;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public LatLng getQueryLocation()
    {
        return queryLocation;
    }

    public String getSearchRefinedPostalCode()
    {
        return searchRefinedPostalCode;
    }

    public StoreAvailability getSelectedStore()
    {
        return selectedStore;
    }

    public String getSellerUserId()
    {
        return sellerUserId;
    }

    public LatLng getUserLocation()
    {
        return userLocation;
    }

    public boolean isForceInventoryLookup()
    {
        return forceInventoryLookup;
    }

    public void setAvailabilities(List list)
    {
        availabilities = list;
    }

    public void setCheckoutLineItemId(String s)
    {
        checkoutLineItemId = s;
    }

    public void setDerivation(ListDerivation listderivation)
    {
        derivation = listderivation;
        if (ListDerivation.LATLNG != listderivation)
        {
            boundingBoxComponents = null;
        }
    }

    public void setEstimatedDeliveryDate(Date date)
    {
        estimatedDeliveryDate = date;
    }

    public void setForceInventoryLookup(boolean flag)
    {
        forceInventoryLookup = flag;
    }

    public void setItemSku(String s)
    {
        itemSku = s;
    }

    public void setLogisticsPlanType(com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type type)
    {
        if (type == null)
        {
            type = com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.UNKNOWN;
        }
        logisticsPlanType = type;
    }

    public void setPostalCode(String s)
    {
        postalCode = s;
    }

    public void setQueryLocation(LatLng latlng)
    {
        queryLocation = latlng;
    }

    public void setSearchRefinedPostalCode(String s)
    {
        searchRefinedPostalCode = s;
    }

    public void setSelectedStore(StoreAvailability storeavailability)
    {
        selectedStore = storeavailability;
    }

    public void setSellerUserId(String s)
    {
        sellerUserId = s;
    }

    public void setUserLocation(LatLng latlng, int i)
    {
        userLocation = latlng;
        if (latlng != null)
        {
            boundingBoxComponents = calculateBoundingBox(latlng, i);
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        int j;
        if (forceInventoryLookup)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        parcel.writeString(searchRefinedPostalCode);
        parcel.writeString(postalCode);
        if (userLocation != null)
        {
            parcel.writeInt(1);
            parcel.writeDouble(userLocation.latitude);
            parcel.writeDouble(userLocation.longitude);
        } else
        {
            parcel.writeInt(0);
        }
        if (queryLocation != null)
        {
            parcel.writeInt(1);
            parcel.writeDouble(queryLocation.latitude);
            parcel.writeDouble(queryLocation.longitude);
        } else
        {
            parcel.writeInt(0);
        }
        parcel.writeDoubleArray(boundingBoxComponents);
        if (availabilities != null && !availabilities.isEmpty())
        {
            parcel.writeInt(availabilities.size());
            for (Iterator iterator = availabilities.iterator(); iterator.hasNext(); ((StoreAvailability)iterator.next()).writeToParcel(parcel, i)) { }
        } else
        {
            parcel.writeInt(0);
        }
        parcel.writeInt(derivation.getValue());
        if (selectedStore != null)
        {
            parcel.writeInt(1);
            selectedStore.writeToParcel(parcel, i);
        } else
        {
            parcel.writeInt(0);
        }
        parcel.writeString(itemSku);
        parcel.writeString(sellerUserId);
        parcel.writeString(checkoutLineItemId);
        parcel.writeInt(logisticsPlanType.ordinal());
        if (estimatedDeliveryDate != null)
        {
            parcel.writeInt(1);
            parcel.writeLong(estimatedDeliveryDate.getTime());
        } else
        {
            parcel.writeInt(0);
        }
        parcel.writeString(site);
    }

}
