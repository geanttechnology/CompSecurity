// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.meta_data;

import java.io.Serializable;

public class FieldValueMetaData
    implements Serializable
{

    public final byte type;

    public FieldValueMetaData(byte byte0)
    {
        type = byte0;
    }

    public boolean isContainer()
    {
        return type == 15 || type == 13 || type == 14;
    }

    public boolean isStruct()
    {
        return type == 12;
    }
}
