// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.data.model;


// Referenced classes of package com.smule.pianoandroid.data.model:
//            AchievementDefinition, LevelConfig

public class GameReward
{

    public static final String COLUMN_ACHIEVEMENT = "achievement";
    public static final String COLUMN_AMOUNT = "amount";
    public static final String COLUMN_LEVEL = "level";
    public static final String COLUMN_NAME_ID = "_id";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_VALUE = "value";
    public int _id;
    public AchievementDefinition achievement;
    public int amount;
    public LevelConfig level;
    public String type;
    public String value;

    public GameReward()
    {
    }

    public Type getRewardType()
    {
        if ("COINS".equals(type.toUpperCase()))
        {
            return Type.COINS;
        }
        if ("SONG".equals(type.toUpperCase()) || "PRODUCT".equals(type.toUpperCase()) || "SNDF".equals(type.toUpperCase()))
        {
            return Type.PRODUCT;
        } else
        {
            return Type.UNKNOWN;
        }
    }

    private class Type extends Enum
    {

        private static final Type $VALUES[];
        public static final Type COINS;
        public static final Type PRODUCT;
        public static final Type UNKNOWN;

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/smule/pianoandroid/data/model/GameReward$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])$VALUES.clone();
        }

        static 
        {
            COINS = new Type("COINS", 0);
            PRODUCT = new Type("PRODUCT", 1);
            UNKNOWN = new Type("UNKNOWN", 2);
            $VALUES = (new Type[] {
                COINS, PRODUCT, UNKNOWN
            });
        }

        private Type(String s, int i)
        {
            super(s, i);
        }
    }

}
