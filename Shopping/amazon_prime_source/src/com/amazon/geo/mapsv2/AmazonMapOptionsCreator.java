// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import android.os.Parcel;
import com.amazon.geo.mapsv2.model.CameraPosition;

// Referenced classes of package com.amazon.geo.mapsv2:
//            AmazonMapOptions

public class AmazonMapOptionsCreator
    implements android.os.Parcelable.Creator
{

    public AmazonMapOptionsCreator()
    {
    }

    private static Boolean readBoolean(Parcel parcel)
    {
        return (Boolean)java/lang/Boolean.cast(parcel.readValue(java/lang/Boolean.getClassLoader()));
    }

    private static Integer readInteger(Parcel parcel)
    {
        return (Integer)java/lang/Integer.cast(parcel.readValue(java/lang/Integer.getClassLoader()));
    }

    static void write(AmazonMapOptions amazonmapoptions, Parcel parcel, int i)
    {
        parcel.writeInt(amazonmapoptions.getMapType());
        parcel.writeParcelable(amazonmapoptions.getCamera(), i);
        parcel.writeValue(amazonmapoptions.getLiteMode());
        parcel.writeValue(amazonmapoptions.getCompassEnabled());
        parcel.writeValue(amazonmapoptions.getRotateGesturesEnabled());
        parcel.writeValue(amazonmapoptions.getScrollGesturesEnabled());
        parcel.writeValue(amazonmapoptions.getTiltGesturesEnabled());
        parcel.writeValue(amazonmapoptions.getUseViewLifecycleInFragment());
        parcel.writeValue(amazonmapoptions.getZOrderOnTop());
        parcel.writeValue(amazonmapoptions.getZoomControlsEnabled());
        parcel.writeValue(amazonmapoptions.getZoomGesturesEnabled());
        parcel.writeValue(amazonmapoptions.getMapToolbarEnabled());
        parcel.writeValue(amazonmapoptions.getAlignCompassTop());
        parcel.writeValue(amazonmapoptions.getAlignCompassLeft());
        parcel.writeValue(amazonmapoptions.getAlignCompassBottom());
        parcel.writeValue(amazonmapoptions.getAlignCompassRight());
        parcel.writeValue(amazonmapoptions.getCompassDrawable());
        parcel.writeValue(amazonmapoptions.getAlignLocatorTop());
        parcel.writeValue(amazonmapoptions.getAlignLocatorLeft());
        parcel.writeValue(amazonmapoptions.getAlignLocatorBottom());
        parcel.writeValue(amazonmapoptions.getAlignLocatorRight());
        parcel.writeValue(amazonmapoptions.getLocatorDrawable());
    }

    public AmazonMapOptions createFromParcel(Parcel parcel)
    {
        int i = parcel.readInt();
        CameraPosition cameraposition = (CameraPosition)com/amazon/geo/mapsv2/model/CameraPosition.cast(parcel.readParcelable(com/amazon/geo/mapsv2/model/CameraPosition.getClassLoader()));
        Boolean boolean1 = readBoolean(parcel);
        Boolean boolean2 = readBoolean(parcel);
        Boolean boolean3 = readBoolean(parcel);
        Boolean boolean4 = readBoolean(parcel);
        Boolean boolean5 = readBoolean(parcel);
        Boolean boolean6 = readBoolean(parcel);
        Boolean boolean7 = readBoolean(parcel);
        Boolean boolean8 = readBoolean(parcel);
        Boolean boolean9 = readBoolean(parcel);
        Boolean boolean10 = readBoolean(parcel);
        Boolean boolean11 = readBoolean(parcel);
        Boolean boolean12 = readBoolean(parcel);
        Boolean boolean13 = readBoolean(parcel);
        Boolean boolean14 = readBoolean(parcel);
        Integer integer = readInteger(parcel);
        Boolean boolean15 = readBoolean(parcel);
        Boolean boolean16 = readBoolean(parcel);
        Boolean boolean17 = readBoolean(parcel);
        Boolean boolean18 = readBoolean(parcel);
        parcel = readInteger(parcel);
        AmazonMapOptions amazonmapoptions = new AmazonMapOptions();
        amazonmapoptions.mapType(i);
        amazonmapoptions.camera(cameraposition);
        if (boolean1 != null)
        {
            amazonmapoptions.liteMode(boolean1.booleanValue());
        }
        if (boolean2 != null)
        {
            amazonmapoptions.compassEnabled(boolean2.booleanValue());
        }
        if (boolean3 != null)
        {
            amazonmapoptions.rotateGesturesEnabled(boolean3.booleanValue());
        }
        if (boolean4 != null)
        {
            amazonmapoptions.scrollGesturesEnabled(boolean4.booleanValue());
        }
        if (boolean5 != null)
        {
            amazonmapoptions.tiltGesturesEnabled(boolean5.booleanValue());
        }
        if (boolean6 != null)
        {
            amazonmapoptions.useViewLifecycleInFragment(boolean6.booleanValue());
        }
        if (boolean7 != null)
        {
            amazonmapoptions.zOrderOnTop(boolean7.booleanValue());
        }
        if (boolean8 != null)
        {
            amazonmapoptions.zoomControlsEnabled(boolean8.booleanValue());
        }
        if (boolean9 != null)
        {
            amazonmapoptions.zoomGesturesEnabled(boolean9.booleanValue());
        }
        if (boolean10 != null)
        {
            amazonmapoptions.mapToolbarEnabled(boolean10.booleanValue());
        }
        if (boolean11 != null)
        {
            amazonmapoptions.alignCompassTop(boolean11);
        }
        if (boolean13 != null)
        {
            amazonmapoptions.alignCompassBottom(boolean13);
        }
        if (boolean12 != null)
        {
            amazonmapoptions.alignCompassLeft(boolean12);
        }
        if (boolean14 != null)
        {
            amazonmapoptions.alignCompassRight(boolean14);
        }
        if (integer != null)
        {
            amazonmapoptions.compassDrawable(integer);
        }
        if (boolean16 != null)
        {
            amazonmapoptions.alignLocatorLeft(boolean16);
        }
        if (boolean15 != null)
        {
            amazonmapoptions.alignLocatorTop(boolean15);
        }
        if (boolean17 != null)
        {
            amazonmapoptions.alignLocatorBottom(boolean17);
        }
        if (boolean18 != null)
        {
            amazonmapoptions.alignLocatorRight(boolean18);
        }
        if (parcel != null)
        {
            amazonmapoptions.locatorDrawable(parcel);
        }
        return amazonmapoptions;
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public AmazonMapOptions[] newArray(int i)
    {
        return new AmazonMapOptions[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }
}
