// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public interface ETNotificationLaunchIntent
{

    public abstract Intent setupLaunchIntent(Context context, Bundle bundle);
}
