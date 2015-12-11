// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import android.content.Context;

// Referenced classes of package com.ebay.nautilus.domain.content:
//            AsyncResult

public static interface 
{

    public abstract void deliverResult(Object obj);

    public abstract Context getContext();

    public abstract boolean isAbandoned();

    public abstract void onCanceled(Object obj);
}
