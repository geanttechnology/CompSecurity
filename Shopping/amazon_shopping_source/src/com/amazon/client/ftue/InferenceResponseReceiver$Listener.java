// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.ftue;

import android.content.Intent;

// Referenced classes of package com.amazon.client.ftue:
//            InferenceResponseReceiver

public static interface 
{

    public abstract void onInferenceComplete(Intent intent);

    public abstract void onInferenceRequiresInteraction(Intent intent);
}
