// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.cos.base.AddressTypeEnum;
import com.ebay.nautilus.domain.data.cos.base.DimensionUnitOfMeasureEnum;
import com.ebay.nautilus.domain.data.cos.base.LanguageScriptEnum;
import com.ebay.nautilus.domain.data.cos.base.MarketplaceIdEnum;
import com.ebay.nautilus.domain.data.cos.base.PropertyValueTypeEnum;
import com.ebay.nautilus.domain.data.cos.base.RegionTypeEnum;
import com.ebay.nautilus.domain.data.cos.base.TimeDurationUnitEnum;
import com.ebay.nautilus.domain.data.cos.base.WeightUnitOfMeasureEnum;
import com.ebay.nautilus.domain.data.cos.base.WorldRegionEnum;
import com.ebay.nautilus.domain.data.cos.listing.DiscountPriceTypeEnum;
import com.ebay.nautilus.domain.data.cos.listing.ListingFormatEnum;
import com.ebay.nautilus.domain.data.cos.listing.ListingStatusEnum;
import com.ebay.nautilus.domain.data.cos.trading.PurchaseOptionEnum;
import com.ebay.nautilus.domain.datamapping.gson.EbayDateAdapter;
import com.ebay.nautilus.domain.datamapping.gson.EbaySiteAdapter;
import com.ebay.nautilus.domain.datamapping.gson.EnumDeserializer;
import com.ebay.nautilus.kernel.util.NetworkUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain.net:
//            EbayResponse, CosVersionType

public abstract class EbayCosResponse extends EbayResponse
{

    private static final int DEFAULT_EXCLUDE_MODIFIERS[] = {
        8, 128, 64
    };
    private static final Map listOfGsonMappers = new HashMap();
    protected final CosVersionType cosVersionType;
    private Gson mapper;

    protected EbayCosResponse(boolean flag)
    {
        cosVersionType = CosVersionType.V1;
        initialize(flag);
    }

    protected EbayCosResponse(boolean flag, CosVersionType cosversiontype)
    {
        cosVersionType = cosversiontype;
        initialize(flag);
    }

    public static void addGsonBuilderPropertiesHelper(GsonBuilder gsonbuilder, CosVersionType cosversiontype)
    {
        gsonbuilder.excludeFieldsWithModifiers(DEFAULT_EXCLUDE_MODIFIERS);
        gsonbuilder.enableComplexMapKeySerialization();
        gsonbuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        gsonbuilder.registerTypeAdapter(java/util/Date, new EbayDateAdapter());
        gsonbuilder.registerTypeAdapter(com/ebay/nautilus/domain/EbaySite, new EbaySiteAdapter());
        gsonbuilder.registerTypeAdapter(com/ebay/nautilus/domain/net/EbayResponseError$RecommendedAction, new EbayResponseError.RecommendedAction.Deserializer());
        if (cosversiontype.minimumOf(CosVersionType.V3))
        {
            gsonbuilder.registerTypeAdapter(com/ebay/nautilus/domain/data/cos/base/AddressTypeEnum, new EnumDeserializer(AddressTypeEnum.UNKNOWN));
            gsonbuilder.registerTypeAdapter(com/ebay/nautilus/domain/data/cos/base/DimensionUnitOfMeasureEnum, new EnumDeserializer(DimensionUnitOfMeasureEnum.UNKNOWN));
            gsonbuilder.registerTypeAdapter(com/ebay/nautilus/domain/data/cos/base/LanguageScriptEnum, new EnumDeserializer(LanguageScriptEnum.UNKNOWN));
            gsonbuilder.registerTypeAdapter(com/ebay/nautilus/domain/data/cos/base/MarketplaceIdEnum, new EnumDeserializer(MarketplaceIdEnum.UNKNOWN));
            gsonbuilder.registerTypeAdapter(com/ebay/nautilus/domain/data/cos/base/PropertyValueTypeEnum, new EnumDeserializer(PropertyValueTypeEnum.UNKNOWN));
            gsonbuilder.registerTypeAdapter(com/ebay/nautilus/domain/data/cos/base/RegionTypeEnum, new EnumDeserializer(RegionTypeEnum.UNKNOWN));
            gsonbuilder.registerTypeAdapter(com/ebay/nautilus/domain/data/cos/base/TimeDurationUnitEnum, new EnumDeserializer(TimeDurationUnitEnum.UNKNOWN));
            gsonbuilder.registerTypeAdapter(com/ebay/nautilus/domain/data/cos/base/WeightUnitOfMeasureEnum, new EnumDeserializer(WeightUnitOfMeasureEnum.UNKNOWN));
            gsonbuilder.registerTypeAdapter(com/ebay/nautilus/domain/data/cos/base/WorldRegionEnum, new EnumDeserializer(WorldRegionEnum.UNKNOWN));
            gsonbuilder.registerTypeAdapter(com/ebay/nautilus/domain/data/cos/listing/ListingFormatEnum, new EnumDeserializer(ListingFormatEnum.UNKNOWN));
            gsonbuilder.registerTypeAdapter(com/ebay/nautilus/domain/data/cos/listing/ListingStatusEnum, new EnumDeserializer(ListingStatusEnum.UNKNOWN));
            gsonbuilder.registerTypeAdapter(com/ebay/nautilus/domain/data/cos/trading/PurchaseOptionEnum, new EnumDeserializer(PurchaseOptionEnum.UNKNOWN));
            gsonbuilder.registerTypeAdapter(com/ebay/nautilus/domain/data/cos/listing/DiscountPriceTypeEnum, new EnumDeserializer(DiscountPriceTypeEnum.UNKNOWN));
        }
    }

    private void initialize(boolean flag)
    {
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        Map map = listOfGsonMappers;
        map;
        JVM INSTR monitorenter ;
        if (listOfGsonMappers.containsKey(getClass().getSimpleName()))
        {
            break MISSING_BLOCK_LABEL_72;
        }
        GsonBuilder gsonbuilder = new GsonBuilder();
        addGsonBuilderProperties(gsonbuilder);
        mapper = gsonbuilder.create();
        listOfGsonMappers.put(getClass().getSimpleName(), mapper);
_L2:
        return;
        mapper = (Gson)listOfGsonMappers.get(getClass().getSimpleName());
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void addGsonBuilderProperties(GsonBuilder gsonbuilder)
    {
        addGsonBuilderPropertiesHelper(gsonbuilder, cosVersionType);
    }

    public boolean hasSuccessResponseCode()
    {
        return super.hasSuccessResponseCode() || responseCode == 400 || responseCode == 403 || responseCode == 401 || NetworkUtil.isHttpClass5xx(responseCode);
    }

    protected Object readJsonStream(Gson gson, InputStream inputstream, Class class1)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        return super.readJsonStream(mapper, inputstream, class1);
    }

    protected Object readJsonStream(InputStream inputstream, Class class1)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        return super.readStream(mapper, inputstream, class1);
    }

    protected Object readStream(Gson gson, InputStream inputstream, Class class1)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        return super.readStream(mapper, inputstream, class1);
    }

}
