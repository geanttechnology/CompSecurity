// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.events;


// Referenced classes of package com.groupon.events:
//            EventAcceptor, UserMigrationViewEvent, EventVisitor

public final class UserMigrationClickEvent extends Enum
    implements EventAcceptor
{

    private static final UserMigrationClickEvent $VALUES[];
    public static final UserMigrationClickEvent CHANGE_COUNTRY;
    public static final UserMigrationClickEvent FORCED_DOWNLOAD;
    public static final UserMigrationClickEvent POSTPONED;
    public static final UserMigrationClickEvent SUGGESTED_DOWNLOAD;
    public final UserMigrationViewEvent migrationEvent;
    public final String type;

    private UserMigrationClickEvent(String s, int i, UserMigrationViewEvent usermigrationviewevent, String s1)
    {
        super(s, i);
        migrationEvent = usermigrationviewevent;
        type = s1;
    }

    public static UserMigrationClickEvent valueOf(String s)
    {
        return (UserMigrationClickEvent)Enum.valueOf(com/groupon/events/UserMigrationClickEvent, s);
    }

    public static UserMigrationClickEvent[] values()
    {
        return (UserMigrationClickEvent[])$VALUES.clone();
    }

    public void accept(EventVisitor eventvisitor)
    {
        eventvisitor.visit(this);
    }

    static 
    {
        POSTPONED = new UserMigrationClickEvent("POSTPONED", 0, UserMigrationViewEvent.SUGGESTED, "later");
        SUGGESTED_DOWNLOAD = new UserMigrationClickEvent("SUGGESTED_DOWNLOAD", 1, UserMigrationViewEvent.SUGGESTED, "download");
        FORCED_DOWNLOAD = new UserMigrationClickEvent("FORCED_DOWNLOAD", 2, UserMigrationViewEvent.FORCED, "download");
        CHANGE_COUNTRY = new UserMigrationClickEvent("CHANGE_COUNTRY", 3, UserMigrationViewEvent.FORCED, "changecountry");
        $VALUES = (new UserMigrationClickEvent[] {
            POSTPONED, SUGGESTED_DOWNLOAD, FORCED_DOWNLOAD, CHANGE_COUNTRY
        });
    }
}
