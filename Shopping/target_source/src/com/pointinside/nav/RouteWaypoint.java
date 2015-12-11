// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.nav;

import android.graphics.PointF;
import android.os.Parcel;
import com.pointinside.maps.Location;
import com.pointinside.model.Place;
import com.pointinside.products.BaseProduct;
import java.util.UUID;

// Referenced classes of package com.pointinside.nav:
//            BaseRouteWaypoint, IRouteWaypoint, RouteException

public class RouteWaypoint extends BaseRouteWaypoint
    implements IRouteWaypoint
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public RouteWaypoint createFromParcel(Parcel parcel)
        {
            return new RouteWaypoint(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public RouteWaypoint[] newArray(int i)
        {
            return new RouteWaypoint[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    final UUID key;
    private double mLatitude;
    private double mLongitude;
    private float mMapX;
    private float mMapY;
    private String mMetaproductId;
    private String mPlace;
    private String mProductId;
    private String mServiceTypeId;
    private String mTerm;
    private String mZone;

    protected RouteWaypoint()
    {
        key = UUID.randomUUID();
    }

    protected RouteWaypoint(Parcel parcel)
    {
        mType = (BaseRouteWaypoint.WaypointType)parcel.readSerializable();
        key = (UUID)parcel.readSerializable();
        mPlace = parcel.readString();
        mServiceTypeId = parcel.readString();
        mZone = parcel.readString();
        mMapX = parcel.readFloat();
        mMapY = parcel.readFloat();
        mLatitude = parcel.readDouble();
        mLongitude = parcel.readDouble();
        mProductId = parcel.readString();
        mTerm = parcel.readString();
        mMetaproductId = parcel.readString();
    }

    public static RouteWaypoint buildWithBaseProduct(BaseProduct baseproduct)
        throws RouteException
    {
        requireNonNull(baseproduct, "product cannot be null");
        return baseproduct.getWaypoint();
    }

    public static RouteWaypoint buildWithGeoPoint(String s, double d, double d1)
        throws RouteException
    {
        requireNonNull(s, "Zone cannot be null");
        return (new RouteWaypoint()).zone(s).latitude(d).longitude(d1).type(BaseRouteWaypoint.WaypointType.GEOPOINT);
    }

    public static RouteWaypoint buildWithLocation(Location location)
        throws RouteException
    {
        requireNonNull(location, "location cannot be null");
        return location.getWaypoint();
    }

    public static RouteWaypoint buildWithMapPoint(String s, PointF pointf)
        throws RouteException
    {
        requireNonNull(pointf, "Map point cannot be null");
        requireNonNull(s, "Zone cannot be null");
        return (new RouteWaypoint()).zone(s).mapPoint(pointf).type(BaseRouteWaypoint.WaypointType.MAPPOINT);
    }

    public static RouteWaypoint buildWithMetaproductId(String s)
        throws RouteException
    {
        requireNonNull(s, "Metaproduct Id cannot be null");
        return (new RouteWaypoint()).metaproductId(s).type(BaseRouteWaypoint.WaypointType.METAPRODUCTID);
    }

    public static RouteWaypoint buildWithPlace(Place place1)
        throws RouteException
    {
        requireNonNull(place1, "Place cannot be null");
        return place1.getWaypoint();
    }

    public static RouteWaypoint buildWithPlaceUuid(String s)
        throws RouteException
    {
        requireNonNull(s, "Place uuid cannot be null");
        return (new RouteWaypoint()).place(s).type(BaseRouteWaypoint.WaypointType.PLACE);
    }

    public static RouteWaypoint buildWithProductId(String s)
        throws RouteException
    {
        requireNonNull(s, "Product Id cannot be null");
        return (new RouteWaypoint()).productId(s).type(BaseRouteWaypoint.WaypointType.PRODUCTID);
    }

    public static RouteWaypoint buildWithServiceTypeId(String s)
        throws RouteException
    {
        requireNonNull(s, "ServiceTypeId cannot be null");
        return (new RouteWaypoint()).serviceTypeId(s).type(BaseRouteWaypoint.WaypointType.SERVICETYPEID);
    }

    public static RouteWaypoint buildWithTerm(String s)
        throws RouteException
    {
        requireNonNull(s, "Term cannot be null");
        return (new RouteWaypoint()).term(s).type(BaseRouteWaypoint.WaypointType.TERM);
    }

    static Object requireNonNull(Object obj, String s)
        throws RouteException
    {
        if (obj == null)
        {
            throw new RouteException(s);
        } else
        {
            return obj;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof RouteWaypoint))
        {
            return false;
        } else
        {
            obj = (RouteWaypoint)obj;
            return key.equals(((RouteWaypoint) (obj)).key);
        }
    }

    public UUID getKey()
    {
        return key;
    }

    public Double getLatitude()
    {
        return Double.valueOf(mLatitude);
    }

    public Location getLocation()
    {
        com.pointinside.maps.Location.Builder builder = new com.pointinside.maps.Location.Builder();
        builder.x(mMapX).y(mMapY);
        return builder.build();
    }

    public Double getLongitude()
    {
        return Double.valueOf(mLongitude);
    }

    public PointF getMapPoint()
    {
        return new PointF(mMapX, mMapY);
    }

    public String getPlace()
    {
        return mPlace;
    }

    public String getProductId()
    {
        return mProductId;
    }

    public String getServiceTypeId()
    {
        return mServiceTypeId;
    }

    public String getTerm()
    {
        return mTerm;
    }

    public BaseRouteWaypoint.WaypointType getType()
    {
        return mType;
    }

    public volatile BaseRouteWaypoint getWaypoint()
        throws RouteException
    {
        return getWaypoint();
    }

    public RouteWaypoint getWaypoint()
    {
        return this;
    }

    public String getZone()
    {
        return mZone;
    }

    public int hashCode()
    {
        return key.hashCode();
    }

    public RouteWaypoint latitude(double d)
    {
        mLatitude = d;
        return this;
    }

    public RouteWaypoint longitude(double d)
    {
        mLongitude = d;
        return this;
    }

    public RouteWaypoint mapPoint(PointF pointf)
    {
        mMapX = pointf.x;
        mMapY = pointf.y;
        return this;
    }

    public RouteWaypoint metaproductId(String s)
    {
        mMetaproductId = s;
        return this;
    }

    public RouteWaypoint place(String s)
    {
        mPlace = s;
        return this;
    }

    public RouteWaypoint productId(String s)
    {
        mProductId = s;
        return this;
    }

    public RouteWaypoint serviceTypeId(String s)
    {
        mServiceTypeId = s;
        return this;
    }

    public RouteWaypoint term(String s)
    {
        mTerm = s;
        return this;
    }

    public RouteWaypoint type(BaseRouteWaypoint.WaypointType waypointtype)
    {
        mType = waypointtype;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeSerializable(mType);
        parcel.writeSerializable(key);
        parcel.writeString(mPlace);
        parcel.writeString(mServiceTypeId);
        parcel.writeString(mZone);
        parcel.writeFloat(mMapX);
        parcel.writeFloat(mMapY);
        parcel.writeDouble(mLatitude);
        parcel.writeDouble(mLongitude);
        parcel.writeString(mProductId);
        parcel.writeString(mTerm);
        parcel.writeString(mMetaproductId);
    }

    public RouteWaypoint zone(String s)
    {
        mZone = s;
        return this;
    }

}
