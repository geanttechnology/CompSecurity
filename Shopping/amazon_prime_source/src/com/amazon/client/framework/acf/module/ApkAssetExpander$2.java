// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf.module;


// Referenced classes of package com.amazon.client.framework.acf.module:
//            ApkAssetExpander

static class sult
{

    static final int $SwitchMap$com$amazon$client$framework$acf$module$ApkAssetExpander$Result[];
    static final int $SwitchMap$com$amazon$client$framework$acf$module$ApkAssetExpander$VersionQueryResponse[];

    static 
    {
        $SwitchMap$com$amazon$client$framework$acf$module$ApkAssetExpander$VersionQueryResponse = new int[rsionQueryResponse.values().length];
        try
        {
            $SwitchMap$com$amazon$client$framework$acf$module$ApkAssetExpander$VersionQueryResponse[rsionQueryResponse.ALWAYS_UPGRADE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$client$framework$acf$module$ApkAssetExpander$VersionQueryResponse[rsionQueryResponse.DONT_UPGRADE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        $SwitchMap$com$amazon$client$framework$acf$module$ApkAssetExpander$Result = new int[sult.values().length];
        try
        {
            $SwitchMap$com$amazon$client$framework$acf$module$ApkAssetExpander$Result[sult.OK.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$client$framework$acf$module$ApkAssetExpander$Result[sult.OK_NO_CHANGE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
