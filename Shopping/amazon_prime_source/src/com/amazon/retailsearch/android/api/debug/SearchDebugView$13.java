// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.debug;


// Referenced classes of package com.amazon.retailsearch.android.api.debug:
//            SearchDebugView, ServiceUrlType

static class 
{

    static final int $SwitchMap$com$amazon$retailsearch$android$api$debug$ServiceUrlType[];

    static 
    {
        $SwitchMap$com$amazon$retailsearch$android$api$debug$ServiceUrlType = new int[ServiceUrlType.values().length];
        try
        {
            $SwitchMap$com$amazon$retailsearch$android$api$debug$ServiceUrlType[ServiceUrlType.SECURE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$retailsearch$android$api$debug$ServiceUrlType[ServiceUrlType.INSECURE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
