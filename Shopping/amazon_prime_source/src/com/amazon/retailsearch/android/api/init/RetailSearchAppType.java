// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.init;


public final class RetailSearchAppType extends Enum
{
    private static class Builder
    {

        private String clientId;
        private boolean isAppStoreSupported;

        public Builder setAppStoreSupported(boolean flag)
        {
            isAppStoreSupported = flag;
            return this;
        }



        public Builder(String s)
        {
            clientId = s;
        }
    }


    private static final RetailSearchAppType $VALUES[];
    public static final RetailSearchAppType MSHOP;
    public static final RetailSearchAppType MSHOP_LITE;
    private String clientId;
    private boolean isAppStoreSupported;

    private RetailSearchAppType(String s, int i, Builder builder)
    {
        super(s, i);
        clientId = builder.clientId;
        isAppStoreSupported = builder.isAppStoreSupported;
    }

    public static RetailSearchAppType valueOf(String s)
    {
        return (RetailSearchAppType)Enum.valueOf(com/amazon/retailsearch/android/api/init/RetailSearchAppType, s);
    }

    public static RetailSearchAppType[] values()
    {
        return (RetailSearchAppType[])$VALUES.clone();
    }

    public String getClientId()
    {
        return clientId;
    }

    public boolean isAppStoreSupported()
    {
        return isAppStoreSupported;
    }

    static 
    {
        MSHOP_LITE = new RetailSearchAppType("MSHOP_LITE", 0, new Builder("08e6b9c8bdfc91895ce634a035f3d00febd36433"));
        MSHOP = new RetailSearchAppType("MSHOP", 1, (new Builder("d2c4ce878f78d258ac8fdbc00005c4ed1f3f89f27458792d76ea4001e0f3cf7a")).setAppStoreSupported(true));
        $VALUES = (new RetailSearchAppType[] {
            MSHOP_LITE, MSHOP
        });
    }
}
