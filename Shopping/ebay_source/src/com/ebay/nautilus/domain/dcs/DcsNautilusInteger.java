// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;


// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DcsPropInteger, DcsState

public final class DcsNautilusInteger extends Enum
    implements DcsPropInteger
{

    private static final DcsNautilusInteger $VALUES[];
    public static final DcsNautilusInteger ImageDataManagerInMemoryFlatSize;
    public static final DcsNautilusInteger ImageDataManagerInMemoryInflatedSize;
    public static final DcsNautilusInteger MerchandiseDataManagerCacheSizeDeflated;
    public static final DcsNautilusInteger MerchandiseDataManagerCacheSizeInflated;
    public static final DcsNautilusInteger searchFollowAggregateOperationTimeoutMs;
    public static final DcsNautilusInteger searchFollowMaxCachedFollowerSummaries;
    public static final DcsNautilusInteger searchFollowMaxFollowCacheTtlInMinutes;
    public static final DcsNautilusInteger searchFollowMaxInterestCacheTtlInDays;
    public static final DcsNautilusInteger searchFollowMaxInterestsPerRequest;
    private final Object defaultValue;

    private DcsNautilusInteger(String s, int i)
    {
        super(s, i);
        defaultValue = Integer.valueOf(0);
    }

    private DcsNautilusInteger(String s, int i, int j)
    {
        super(s, i);
        defaultValue = Integer.valueOf(j);
    }

    private DcsNautilusInteger(String s, int i, String s1)
    {
        super(s, i);
        defaultValue = s1;
    }

    public static DcsNautilusInteger valueOf(String s)
    {
        return (DcsNautilusInteger)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsNautilusInteger, s);
    }

    public static DcsNautilusInteger[] values()
    {
        return (DcsNautilusInteger[])$VALUES.clone();
    }

    public Object defaultValue(DcsState dcsstate)
    {
        return defaultValue;
    }

    public String key()
    {
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$nautilus$domain$dcs$DcsNautilusInteger[];

            static 
            {
                $SwitchMap$com$ebay$nautilus$domain$dcs$DcsNautilusInteger = new int[DcsNautilusInteger.values().length];
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$dcs$DcsNautilusInteger[DcsNautilusInteger.ImageDataManagerInMemoryInflatedSize.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$dcs$DcsNautilusInteger[DcsNautilusInteger.ImageDataManagerInMemoryFlatSize.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$dcs$DcsNautilusInteger[DcsNautilusInteger.MerchandiseDataManagerCacheSizeInflated.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$dcs$DcsNautilusInteger[DcsNautilusInteger.MerchandiseDataManagerCacheSizeDeflated.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.ebay.nautilus.domain.dcs.DcsNautilusInteger[ordinal()])
        {
        default:
            return name();

        case 1: // '\001'
            return "ImageDataManager.inMemoryInflatedSize";

        case 2: // '\002'
            return "ImageDataManager.inMemoryFlatSize";

        case 3: // '\003'
            return "Merchandise.DataManager.cacheSizeInflated";

        case 4: // '\004'
            return "Merchandise.DataManager.cacheSizeDeflated";
        }
    }

    static 
    {
        ImageDataManagerInMemoryInflatedSize = new DcsNautilusInteger("ImageDataManagerInMemoryInflatedSize", 0, 0x400000);
        ImageDataManagerInMemoryFlatSize = new DcsNautilusInteger("ImageDataManagerInMemoryFlatSize", 1, 0xc0000);
        MerchandiseDataManagerCacheSizeInflated = new DcsNautilusInteger("MerchandiseDataManagerCacheSizeInflated", 2, 5);
        MerchandiseDataManagerCacheSizeDeflated = new DcsNautilusInteger("MerchandiseDataManagerCacheSizeDeflated", 3, 10);
        searchFollowMaxInterestsPerRequest = new DcsNautilusInteger("searchFollowMaxInterestsPerRequest", 4, 20);
        searchFollowMaxCachedFollowerSummaries = new DcsNautilusInteger("searchFollowMaxCachedFollowerSummaries", 5, 50);
        searchFollowMaxFollowCacheTtlInMinutes = new DcsNautilusInteger("searchFollowMaxFollowCacheTtlInMinutes", 6, 15);
        searchFollowMaxInterestCacheTtlInDays = new DcsNautilusInteger("searchFollowMaxInterestCacheTtlInDays", 7, 14);
        searchFollowAggregateOperationTimeoutMs = new DcsNautilusInteger("searchFollowAggregateOperationTimeoutMs", 8, 60000);
        $VALUES = (new DcsNautilusInteger[] {
            ImageDataManagerInMemoryInflatedSize, ImageDataManagerInMemoryFlatSize, MerchandiseDataManagerCacheSizeInflated, MerchandiseDataManagerCacheSizeDeflated, searchFollowMaxInterestsPerRequest, searchFollowMaxCachedFollowerSummaries, searchFollowMaxFollowCacheTtlInMinutes, searchFollowMaxInterestCacheTtlInDays, searchFollowAggregateOperationTimeoutMs
        });
    }
}
