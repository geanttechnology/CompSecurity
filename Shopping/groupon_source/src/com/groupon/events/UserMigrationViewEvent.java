// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.events;


// Referenced classes of package com.groupon.events:
//            EventAcceptor, EventVisitor

public final class UserMigrationViewEvent extends Enum
    implements EventAcceptor
{

    private static final UserMigrationViewEvent $VALUES[];
    public static final UserMigrationViewEvent FORCED;
    public static final UserMigrationViewEvent SUGGESTED;
    public final String type;

    private UserMigrationViewEvent(String s, int i, String s1)
    {
        super(s, i);
        type = s1;
    }

    public static UserMigrationViewEvent valueOf(String s)
    {
        return (UserMigrationViewEvent)Enum.valueOf(com/groupon/events/UserMigrationViewEvent, s);
    }

    public static UserMigrationViewEvent[] values()
    {
        return (UserMigrationViewEvent[])$VALUES.clone();
    }

    public void accept(EventVisitor eventvisitor)
    {
        eventvisitor.visit(this);
    }

    static 
    {
        SUGGESTED = new UserMigrationViewEvent("SUGGESTED", 0, "TigersPrompt");
        FORCED = new UserMigrationViewEvent("FORCED", 1, "TigersForce");
        $VALUES = (new UserMigrationViewEvent[] {
            SUGGESTED, FORCED
        });
    }
}
