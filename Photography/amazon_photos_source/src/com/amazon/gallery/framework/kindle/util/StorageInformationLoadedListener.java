// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.util;

import android.content.Intent;
import com.amazon.gallery.framework.network.http.adrive.operations.StorageInformation;

public interface StorageInformationLoadedListener
{

    public abstract void onSetBuyStorageInformation(Intent intent);

    public abstract void onStorageInformationLoaded(StorageInformation storageinformation);
}
