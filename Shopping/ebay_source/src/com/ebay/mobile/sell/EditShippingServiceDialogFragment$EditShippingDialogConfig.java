// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.data.LdsField;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.ebay.mobile.sell:
//            EditShippingServiceDialogFragment

static class _cls1 extends BaseDataMapped
    implements Parcelable
{

    public static final android.os.logConfig.shippingType CREATOR = new android.os.Parcelable.Creator() {

        public EditShippingServiceDialogFragment.EditShippingDialogConfig createFromParcel(Parcel parcel)
        {
            return (EditShippingServiceDialogFragment.EditShippingDialogConfig)DataMapperFactory.readParcelJson(parcel, com/ebay/mobile/sell/EditShippingServiceDialogFragment$EditShippingDialogConfig);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public EditShippingServiceDialogFragment.EditShippingDialogConfig[] newArray(int i)
        {
            return new EditShippingServiceDialogFragment.EditShippingDialogConfig[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private boolean allowDelete;
    private String currency;
    private ArrayList estimates;
    private LdsField fee;
    private LdsField freeShipping;
    private boolean isInternational;
    private boolean isNewService;
    private LdsField location;
    private LdsField region;
    private Set selectedShippingServices;
    private LdsField service;
    private Map shippingServices;
    private LdsField shippingType;

    public _cls1 setAllowDelete(boolean flag)
    {
        allowDelete = flag;
        return this;
    }

    public allowDelete setCurrency(String s)
    {
        currency = s;
        return this;
    }

    public currency setEstimates(ArrayList arraylist)
    {
        estimates = arraylist;
        return this;
    }

    public estimates setFee(LdsField ldsfield)
    {
        fee = ldsfield;
        return this;
    }

    public fee setFreeShipping(LdsField ldsfield)
    {
        freeShipping = ldsfield;
        return this;
    }

    public freeShipping setInternational(boolean flag)
    {
        isInternational = flag;
        return this;
    }

    public isInternational setLocation(LdsField ldsfield)
    {
        location = ldsfield;
        return this;
    }

    public location setNewService(boolean flag)
    {
        isNewService = flag;
        return this;
    }

    public isNewService setRegion(LdsField ldsfield)
    {
        region = ldsfield;
        return this;
    }

    public region setSelectedShippingServices(Set set)
    {
        selectedShippingServices = set;
        return this;
    }

    public selectedShippingServices setService(LdsField ldsfield)
    {
        service = ldsfield;
        return this;
    }

    public service setShippingServices(Map map)
    {
        shippingServices = map;
        return this;
    }

    public shippingServices setShippingType(LdsField ldsfield)
    {
        shippingType = ldsfield;
        return this;
    }















    _cls1()
    {
    }
}
