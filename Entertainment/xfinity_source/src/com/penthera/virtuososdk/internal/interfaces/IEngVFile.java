// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.internal.interfaces;

import android.content.ContentResolver;
import android.content.Context;
import com.penthera.virtuososdk.client.IVirtuosoFile;
import com.penthera.virtuososdk.download.MD5State;

// Referenced classes of package com.penthera.virtuososdk.internal.interfaces:
//            IEngVIdentifier

public interface IEngVFile
    extends IVirtuosoFile, IEngVIdentifier
{

    public abstract boolean isPending();

    public abstract MD5State md5State();

    public abstract byte[] md5StateAsByteArray();

    public abstract void regenerateFilePath(ContentResolver contentresolver, String s, Context context);

    public abstract void setCurrentSize(double d);

    public abstract void setErrorCount(long l);

    public abstract void setFilePath(String s);

    public abstract void setMd5State(MD5State md5state);

    public abstract void setPending(boolean flag);
}
