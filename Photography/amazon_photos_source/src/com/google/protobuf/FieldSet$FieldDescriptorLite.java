// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;


// Referenced classes of package com.google.protobuf:
//            FieldSet, MessageLite

public static interface 
    extends Comparable
{

    public abstract  getLiteJavaType();

    public abstract  getLiteType();

    public abstract int getNumber();

    public abstract  internalMergeFrom( , MessageLite messagelite);

    public abstract boolean isPacked();

    public abstract boolean isRepeated();
}
