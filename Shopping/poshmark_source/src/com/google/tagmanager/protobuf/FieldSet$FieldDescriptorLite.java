// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;


// Referenced classes of package com.google.tagmanager.protobuf:
//            FieldSet, MessageLite, MutableMessageLite

public static interface A
    extends Comparable
{

    public abstract A getEnumType();

    public abstract A getLiteJavaType();

    public abstract A getLiteType();

    public abstract int getNumber();

    public abstract A internalMergeFrom(A a, MessageLite messagelite);

    public abstract MutableMessageLite internalMergeFrom(MutableMessageLite mutablemessagelite, MutableMessageLite mutablemessagelite1);

    public abstract boolean isPacked();

    public abstract boolean isRepeated();
}
