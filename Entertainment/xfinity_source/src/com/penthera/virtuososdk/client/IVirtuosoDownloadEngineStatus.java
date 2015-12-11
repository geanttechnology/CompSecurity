// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.client;

import android.os.Parcelable;
import com.penthera.virtuososdk.download.VirtuosoDownloadEngineStatus;

public interface IVirtuosoDownloadEngineStatus
    extends Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = VirtuosoDownloadEngineStatus.CREATOR;

    public abstract com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus status();

}
