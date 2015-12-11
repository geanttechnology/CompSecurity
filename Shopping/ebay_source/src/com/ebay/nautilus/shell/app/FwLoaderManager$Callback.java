// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.app;

import android.content.Context;
import com.ebay.nautilus.shell.content.FwLoader;

// Referenced classes of package com.ebay.nautilus.shell.app:
//            FwLoaderManager

public static interface 
{

    public abstract Context getContext();

    public abstract void onCanceled(int i, FwLoader fwloader);

    public abstract void onTaskComplete(int i, FwLoader fwloader);

    public abstract void onTaskStarted(int i, FwLoader fwloader);
}
