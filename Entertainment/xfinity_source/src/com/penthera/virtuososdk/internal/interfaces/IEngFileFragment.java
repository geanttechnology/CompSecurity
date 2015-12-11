// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.internal.interfaces;

import android.content.Context;
import com.penthera.virtuososdk.client.IFileFragment;

public interface IEngFileFragment
    extends IFileFragment
{

    public abstract void generateFilePath();

    public abstract void markComplete();

    public abstract void setCurrentSize(double d);

    public abstract void setDownloadStatus(com.penthera.virtuososdk.Common.EFileDownloadStatus efiledownloadstatus);

    public abstract void setExpectedSize(double d);

    public abstract void setFilePath(String s);

    public abstract void setPending(boolean flag);

    public abstract boolean update(Context context);
}
