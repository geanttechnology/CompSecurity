// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;


// Referenced classes of package com.google.tagmanager.protobuf:
//            GeneratedMessageLite, GeneratedMutableMessageLite, MessageLite, MutableMessageLite

static final class isPacked
    implements isPacked
{

    final isRepeated enumTypeMap;
    final boolean isPacked;
    final boolean isRepeated;
    final int number;
    final isRepeated type;

    public int compareTo(isPacked ispacked)
    {
        return number - ispacked.number;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((compareTo)obj);
    }

    public compareTo getEnumType()
    {
        return enumTypeMap;
    }

    public enumTypeMap getLiteJavaType()
    {
        return type.type();
    }

    public type getLiteType()
    {
        return type;
    }

    public int getNumber()
    {
        return number;
    }

    public number internalMergeFrom(number number1, MessageLite messagelite)
    {
        return ((number)number1).number((GeneratedMessageLite)messagelite);
    }

    public MutableMessageLite internalMergeFrom(MutableMessageLite mutablemessagelite, MutableMessageLite mutablemessagelite1)
    {
        return ((GeneratedMutableMessageLite)mutablemessagelite).mergeFrom((GeneratedMutableMessageLite)mutablemessagelite1);
    }

    public boolean isPacked()
    {
        return isPacked;
    }

    public boolean isRepeated()
    {
        return isRepeated;
    }

    ( , int i,  1, boolean flag, boolean flag1)
    {
        enumTypeMap = ;
        number = i;
        type = 1;
        isRepeated = flag;
        isPacked = flag1;
    }
}
