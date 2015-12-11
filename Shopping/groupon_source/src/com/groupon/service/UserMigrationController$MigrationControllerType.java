// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;


// Referenced classes of package com.groupon.service:
//            UserMigrationController

public static abstract class <init> extends Enum
{

    private static final NOT_APPLICABLE $VALUES[];
    public static final NOT_APPLICABLE FORCED_MIGRATION;
    public static final NOT_APPLICABLE NOT_APPLICABLE;
    public static final NOT_APPLICABLE SUGGESTED_MIGRATION;

    public static <init> from(String s)
    {
        <init> a_3C_init>[] = values();
        int j = a_3C_init>.length;
        for (int i = 0; i < j; i++)
        {
            <init> <init>1 = a_3C_init>[i];
            if (<init>1.name().equals(s))
            {
                return <init>1;
            }
        }

        return NOT_APPLICABLE;
    }

    public static NOT_APPLICABLE valueOf(String s)
    {
        return (NOT_APPLICABLE)Enum.valueOf(com/groupon/service/UserMigrationController$MigrationControllerType, s);
    }

    public static NOT_APPLICABLE[] values()
    {
        return (NOT_APPLICABLE[])$VALUES.clone();
    }

    public abstract UserMigrationController instance();

    static 
    {
        FORCED_MIGRATION = new UserMigrationController.MigrationControllerType("FORCED_MIGRATION", 0) {

            public UserMigrationController instance()
            {
                return new UserMigrationController.ForcedMigrationController();
            }

        };
        SUGGESTED_MIGRATION = new UserMigrationController.MigrationControllerType("SUGGESTED_MIGRATION", 1) {

            public UserMigrationController instance()
            {
                return new UserMigrationController.SuggestedMigrationController();
            }

        };
        NOT_APPLICABLE = new UserMigrationController.MigrationControllerType("NOT_APPLICABLE", 2) {

            public UserMigrationController instance()
            {
                return new UserMigrationController.NoOperationController();
            }

        };
        $VALUES = (new .VALUES[] {
            FORCED_MIGRATION, SUGGESTED_MIGRATION, NOT_APPLICABLE
        });
    }

    private _cls3(String s, int i)
    {
        super(s, i);
    }

    _cls3(String s, int i, _cls3 _pcls3)
    {
        this(s, i);
    }
}
