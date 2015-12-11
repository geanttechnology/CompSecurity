// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;


public final class RecordStatusEnum extends Enum
{

    private static final RecordStatusEnum $VALUES[];
    public static final RecordStatusEnum FAILURE;
    public static final RecordStatusEnum PARTIAL_RESULT;
    public static final RecordStatusEnum SUCCESS;

    private RecordStatusEnum(String s, int i)
    {
        super(s, i);
    }

    public static RecordStatusEnum valueOf(String s)
    {
        return (RecordStatusEnum)Enum.valueOf(com/ebay/nautilus/domain/data/UnifiedStream/RecordStatusEnum, s);
    }

    public static RecordStatusEnum[] values()
    {
        return (RecordStatusEnum[])$VALUES.clone();
    }

    static 
    {
        SUCCESS = new RecordStatusEnum("SUCCESS", 0);
        PARTIAL_RESULT = new RecordStatusEnum("PARTIAL_RESULT", 1);
        FAILURE = new RecordStatusEnum("FAILURE", 2);
        $VALUES = (new RecordStatusEnum[] {
            SUCCESS, PARTIAL_RESULT, FAILURE
        });
    }
}
