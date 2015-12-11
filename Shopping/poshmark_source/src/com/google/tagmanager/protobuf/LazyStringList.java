// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.util.Collection;
import java.util.List;

// Referenced classes of package com.google.tagmanager.protobuf:
//            ByteString

public interface LazyStringList
    extends List
{

    public abstract void add(ByteString bytestring);

    public abstract void add(byte abyte0[]);

    public abstract boolean addAllByteArray(Collection collection);

    public abstract boolean addAllByteString(Collection collection);

    public abstract List asByteArrayList();

    public abstract byte[] getByteArray(int i);

    public abstract ByteString getByteString(int i);

    public abstract List getUnderlyingElements();

    public abstract void mergeFrom(LazyStringList lazystringlist);

    public abstract void set(int i, ByteString bytestring);

    public abstract void set(int i, byte abyte0[]);
}
