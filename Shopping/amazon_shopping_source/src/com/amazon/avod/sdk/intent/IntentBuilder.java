// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk.intent;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public interface IntentBuilder
{

    public abstract Intent build(Context context, Uri uri);
}
