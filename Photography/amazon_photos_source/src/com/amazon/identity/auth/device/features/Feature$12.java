// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.features;

import android.content.Context;
import com.amazon.identity.auth.device.utils.MetaDataUtils;

// Referenced classes of package com.amazon.identity.auth.device.features:
//            Feature

static final class it> extends Feature
{

    boolean fetchValue(Context context)
    {
        return MetaDataUtils.getBooleanMetaDataForAPackage$a09a196(context, context.getPackageName(), "MAPIsolateApplication").booleanValue();
    }

    _cls9(String s, int i)
    {
        super(s, i, null);
    }
}
