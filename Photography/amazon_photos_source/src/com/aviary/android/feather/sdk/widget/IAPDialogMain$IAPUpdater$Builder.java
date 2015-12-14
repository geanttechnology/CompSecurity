// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.os.Bundle;
import java.util.HashMap;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            IAPDialogMain

public static class result
{

    result result;

    public result addEventAttributes(String s, String s1)
    {
        _mth00(result).put(s, s1);
        return this;
    }

    public result build()
    {
        return result;
    }

    public result setEvent(String s)
    {
        _mth02(result, s);
        return this;
    }

    public result setExtras(Bundle bundle)
    {
        _mth02(result, bundle);
        return this;
    }

    public result setFeaturedPackId(long l)
    {
        _mth02(result, l);
        return this;
    }

    public result setPackId(long l)
    {
        _mth02(result, l);
        return this;
    }

    public result setPackType(com.aviary.android.feather.cds.uilder uilder)
    {
        _mth02(result, uilder);
        return this;
    }

    public ()
    {
        result = new result();
    }
}
