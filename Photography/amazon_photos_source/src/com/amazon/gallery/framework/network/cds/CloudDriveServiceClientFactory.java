// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.cds;

import com.amazon.mixtape.service.MixtapeCloudDriveServiceClient;
import java.util.concurrent.ExecutorService;

public interface CloudDriveServiceClientFactory
{

    public abstract MixtapeCloudDriveServiceClient getCloudDriveExtendedClient(String s, ExecutorService executorservice);
}
