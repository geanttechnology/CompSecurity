// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.client;

import com.penthera.virtuososdk.interfaces.toolkit.InterfaceFactory;

// Referenced classes of package com.penthera.virtuososdk.client:
//            IVirtuosoAsset

public interface IVirtuosoFile
    extends IVirtuosoAsset
{

    public static final android.os.Parcelable.Creator CREATOR = InterfaceFactory.FILE_CREATOR;

    public abstract long errorCount();

    public abstract String fileMD5();

    public abstract String filePath();

    public abstract String mimeType();

    public abstract void setExpectedSize(double d);

}
