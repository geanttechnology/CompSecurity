// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.services;

import com.aviary.android.feather.headless.AviaryExecutionException;

// Referenced classes of package com.aviary.android.feather.library.services:
//            HiResBackgroundService

public static interface 
{

    public abstract void onHiresComplete();

    public abstract void onHiresError(AviaryExecutionException aviaryexecutionexception);

    public abstract void onHiresProgress(int i, int j);
}
