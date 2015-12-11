// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;


// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DcsPropLong, DcsState

public final class DcsNautilusLong extends Enum
    implements DcsPropLong
{

    private static final DcsNautilusLong $VALUES[];
    public static final DcsNautilusLong ImageDataManagerDiskSize;
    public static final DcsNautilusLong MerchandiseDataManagerCacheAge;
    public static final DcsNautilusLong MerchandiseDataManagerCacheSizeOnDisk;
    public static final DcsNautilusLong PayPalDysonRefreshRate;
    public static final DcsNautilusLong ShoppingCartDataManagerCacheAge;
    private final Object defaultValue;

    private DcsNautilusLong(String s, int i)
    {
        super(s, i);
        defaultValue = Long.valueOf(0L);
    }

    private DcsNautilusLong(String s, int i, long l)
    {
        super(s, i);
        defaultValue = Long.valueOf(l);
    }

    private DcsNautilusLong(String s, int i, String s1)
    {
        super(s, i);
        defaultValue = s1;
    }

    public static DcsNautilusLong valueOf(String s)
    {
        return (DcsNautilusLong)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsNautilusLong, s);
    }

    public static DcsNautilusLong[] values()
    {
        return (DcsNautilusLong[])$VALUES.clone();
    }

    public Object defaultValue(DcsState dcsstate)
    {
        return defaultValue;
    }

    public String key()
    {
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$nautilus$domain$dcs$DcsNautilusLong[];

            static 
            {
                $SwitchMap$com$ebay$nautilus$domain$dcs$DcsNautilusLong = new int[DcsNautilusLong.values().length];
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$dcs$DcsNautilusLong[DcsNautilusLong.ImageDataManagerDiskSize.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$dcs$DcsNautilusLong[DcsNautilusLong.MerchandiseDataManagerCacheAge.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$dcs$DcsNautilusLong[DcsNautilusLong.MerchandiseDataManagerCacheSizeOnDisk.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$dcs$DcsNautilusLong[DcsNautilusLong.PayPalDysonRefreshRate.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.ebay.nautilus.domain.dcs.DcsNautilusLong[ordinal()])
        {
        default:
            return name();

        case 1: // '\001'
            return "ImageDataManager.diskSize";

        case 2: // '\002'
            return "Merchandise.DataManager.cacheAge";

        case 3: // '\003'
            return "Merchandise.DataManager.cacheSizeOnDisk";

        case 4: // '\004'
            return "dyson-refresh-rate";
        }
    }

    static 
    {
        ImageDataManagerDiskSize = new DcsNautilusLong("ImageDataManagerDiskSize", 0, 0x1400000L);
        MerchandiseDataManagerCacheAge = new DcsNautilusLong("MerchandiseDataManagerCacheAge", 1, 0xdbba0L);
        MerchandiseDataManagerCacheSizeOnDisk = new DcsNautilusLong("MerchandiseDataManagerCacheSizeOnDisk", 2, 25L);
        PayPalDysonRefreshRate = new DcsNautilusLong("PayPalDysonRefreshRate", 3, 1800L);
        ShoppingCartDataManagerCacheAge = new DcsNautilusLong("ShoppingCartDataManagerCacheAge", 4, 0xdbba0L);
        $VALUES = (new DcsNautilusLong[] {
            ImageDataManagerDiskSize, MerchandiseDataManagerCacheAge, MerchandiseDataManagerCacheSizeOnDisk, PayPalDysonRefreshRate, ShoppingCartDataManagerCacheAge
        });
    }
}
