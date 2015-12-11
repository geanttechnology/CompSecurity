// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.stream;


public final class EntityState extends Enum
{

    private static final EntityState $VALUES[];
    public static final EntityState T_BODY;
    public static final EntityState T_END_BODYPART;
    public static final EntityState T_END_HEADER;
    public static final EntityState T_END_MESSAGE;
    public static final EntityState T_END_MULTIPART;
    public static final EntityState T_END_OF_STREAM;
    public static final EntityState T_EPILOGUE;
    public static final EntityState T_FIELD;
    public static final EntityState T_PREAMBLE;
    public static final EntityState T_RAW_ENTITY;
    public static final EntityState T_START_BODYPART;
    public static final EntityState T_START_HEADER;
    public static final EntityState T_START_MESSAGE;
    public static final EntityState T_START_MULTIPART;

    private EntityState(String s, int i)
    {
        super(s, i);
    }

    public static EntityState valueOf(String s)
    {
        return (EntityState)Enum.valueOf(org/apache/james/mime4j/stream/EntityState, s);
    }

    public static EntityState[] values()
    {
        return (EntityState[])$VALUES.clone();
    }

    static 
    {
        T_START_MESSAGE = new EntityState("T_START_MESSAGE", 0);
        T_END_MESSAGE = new EntityState("T_END_MESSAGE", 1);
        T_RAW_ENTITY = new EntityState("T_RAW_ENTITY", 2);
        T_START_HEADER = new EntityState("T_START_HEADER", 3);
        T_FIELD = new EntityState("T_FIELD", 4);
        T_END_HEADER = new EntityState("T_END_HEADER", 5);
        T_START_MULTIPART = new EntityState("T_START_MULTIPART", 6);
        T_END_MULTIPART = new EntityState("T_END_MULTIPART", 7);
        T_PREAMBLE = new EntityState("T_PREAMBLE", 8);
        T_EPILOGUE = new EntityState("T_EPILOGUE", 9);
        T_START_BODYPART = new EntityState("T_START_BODYPART", 10);
        T_END_BODYPART = new EntityState("T_END_BODYPART", 11);
        T_BODY = new EntityState("T_BODY", 12);
        T_END_OF_STREAM = new EntityState("T_END_OF_STREAM", 13);
        $VALUES = (new EntityState[] {
            T_START_MESSAGE, T_END_MESSAGE, T_RAW_ENTITY, T_START_HEADER, T_FIELD, T_END_HEADER, T_START_MULTIPART, T_END_MULTIPART, T_PREAMBLE, T_EPILOGUE, 
            T_START_BODYPART, T_END_BODYPART, T_BODY, T_END_OF_STREAM
        });
    }
}
