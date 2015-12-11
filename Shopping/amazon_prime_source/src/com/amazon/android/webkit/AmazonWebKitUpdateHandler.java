// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;

import android.content.Context;

// Referenced classes of package com.amazon.android.webkit:
//            AmazonWebKitUpdateReadyListener

public interface AmazonWebKitUpdateHandler
{

    public abstract boolean isUpdateRequired(Context context);

    public abstract void setReadyListener(AmazonWebKitUpdateReadyListener amazonwebkitupdatereadylistener);

    public abstract void startUpdate();
}
