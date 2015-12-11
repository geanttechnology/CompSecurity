// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import com.groupon.events.EventVisitor;
import com.groupon.events.UserMigrationClickEvent;
import com.groupon.events.UserMigrationViewEvent;
import com.groupon.models.country.Country;
import com.groupon.models.nst.UserMigrationClickMetadata;
import com.groupon.models.nst.UserMigrationExtraInfo;
import com.groupon.service.countryanddivision.CurrentCountryManager;

// Referenced classes of package com.groupon.util:
//            LoggingUtils

public class UserMigrationEventLogger extends EventVisitor
{

    private CurrentCountryManager currentCountryManager;
    private LoggingUtils eventLogger;

    public UserMigrationEventLogger()
    {
    }

    public void visit(UserMigrationClickEvent usermigrationclickevent)
    {
        String s = (new StringBuilder()).append(usermigrationclickevent.migrationEvent.type.toLowerCase()).append("_click").toString();
        String s1 = currentCountryManager.getCurrentCountry().shortName;
        eventLogger.logClickWithMetadata("", s, "", new UserMigrationClickMetadata((new StringBuilder()).append(usermigrationclickevent.type).append("_click").toString(), s1));
    }

    public void visit(UserMigrationViewEvent usermigrationviewevent)
    {
        String s = currentCountryManager.getCurrentCountry().shortName;
        eventLogger.logPageView("", usermigrationviewevent.type, new UserMigrationExtraInfo(s));
    }
}
