// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import com.ebay.nautilus.domain.data.experience.type.base.ActionType;
import com.ebay.nautilus.domain.data.experience.type.base.CallToActionType;
import com.ebay.nautilus.domain.data.experience.type.base.ImageIdType;
import com.ebay.nautilus.domain.data.experience.type.base.StyleEnum;
import com.ebay.nautilus.domain.data.experience.type.base.TrackingEventType;
import com.ebay.nautilus.domain.datamapping.gson.EnumDeserializer;
import com.ebay.nautilus.kernel.util.NetworkUtil;
import com.google.gson.GsonBuilder;

// Referenced classes of package com.ebay.nautilus.domain.net:
//            EbayCosResponse, CosVersionType

public abstract class EbayCosExpResponse extends EbayCosResponse
{

    public EbayCosExpResponse()
    {
        super(true, CosVersionType.V3);
    }

    public static void addGsonBuilderPropertiesHelper(GsonBuilder gsonbuilder)
    {
        gsonbuilder.registerTypeAdapter(com/ebay/nautilus/domain/data/experience/type/base/ActionType, new EnumDeserializer(ActionType.UNKNOWN));
        gsonbuilder.registerTypeAdapter(com/ebay/nautilus/domain/data/experience/type/base/CallToActionType, new EnumDeserializer(CallToActionType.UNKNOWN));
        gsonbuilder.registerTypeAdapter(com/ebay/nautilus/domain/data/experience/type/base/ImageIdType, new EnumDeserializer(ImageIdType.UNKNOWN));
        gsonbuilder.registerTypeAdapter(com/ebay/nautilus/domain/data/experience/type/base/TrackingEventType, new EnumDeserializer(TrackingEventType.UNKNOWN));
        gsonbuilder.registerTypeAdapter(com/ebay/nautilus/domain/data/experience/type/base/StyleEnum, new EnumDeserializer(StyleEnum.UNKNOWN));
    }

    protected void addGsonBuilderProperties(GsonBuilder gsonbuilder)
    {
        super.addGsonBuilderProperties(gsonbuilder);
        addGsonBuilderPropertiesHelper(gsonbuilder);
    }

    public boolean hasSuccessResponseCode()
    {
        return super.hasSuccessResponseCode() || NetworkUtil.isHttpClass4xx(responseCode);
    }
}
