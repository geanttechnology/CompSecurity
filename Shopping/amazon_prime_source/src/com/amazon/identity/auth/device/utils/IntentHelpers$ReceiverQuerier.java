// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            IntentHelpers

private static interface I
{

    public abstract boolean existsReceiverThatRespondsToIntent(Context context, Intent intent);
}
