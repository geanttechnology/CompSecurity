// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.client;

import android.os.Parcelable;
import com.penthera.virtuososdk.interfaces.toolkit.InterfaceFactory;

public interface IVirtuosoIdentifier
    extends Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = InterfaceFactory.FD_CREATOR;

    public abstract long completionTime();

    public abstract com.penthera.virtuososdk.Common.EFileDownloadStatus downloadStatus();

    public abstract int id();

    public abstract String parentUuid();

    public abstract int type();

    public abstract String uuid();

}
