// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.venus;


public final class InternalModelState extends Enum
{

    private static final InternalModelState $VALUES[];
    public static final InternalModelState INTERNAL_MODEL_LOAD_ERROR;
    public static final InternalModelState INTERNAL_MODEL_NOT_READY;
    public static final InternalModelState INTERNAL_MODEL_READY;

    private InternalModelState(String s, int i)
    {
        super(s, i);
    }

    public static InternalModelState valueOf(String s)
    {
        return (InternalModelState)Enum.valueOf(com/cyberlink/youcammakeup/venus/InternalModelState, s);
    }

    public static InternalModelState[] values()
    {
        return (InternalModelState[])$VALUES.clone();
    }

    static 
    {
        INTERNAL_MODEL_NOT_READY = new InternalModelState("INTERNAL_MODEL_NOT_READY", 0);
        INTERNAL_MODEL_READY = new InternalModelState("INTERNAL_MODEL_READY", 1);
        INTERNAL_MODEL_LOAD_ERROR = new InternalModelState("INTERNAL_MODEL_LOAD_ERROR", 2);
        $VALUES = (new InternalModelState[] {
            INTERNAL_MODEL_NOT_READY, INTERNAL_MODEL_READY, INTERNAL_MODEL_LOAD_ERROR
        });
    }
}
