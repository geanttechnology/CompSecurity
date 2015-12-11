// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.groupon.models.division.Division;
import com.groupon.models.emailsubscription.EmailSubscriptionContainer;
import com.groupon.models.emailsubscription.EmailSubscriptionsContainer;
import com.groupon.service.core.UserManager;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.ReturningFunction1;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.service:
//            LoginService, ApiServiceBase

public class EmailSubscriptionsService
{

    private static final int NO_PROGRESS_BAR = -1;
    private ApiServiceBase addService;
    private Context context;
    private ApiServiceBase deleteService;
    private ApiServiceBase getService;
    private LoginService loginService;
    private UserManager userManager;

    public EmailSubscriptionsService()
    {
    }

    private boolean checkLoginBeforeProceeding(ReturningFunction1 returningfunction1, Function0 function0)
    {
        boolean flag = loginService.isLoggedIn();
        if (!flag)
        {
            if (returningfunction1 != null)
            {
                returningfunction1.execute(new UnsupportedOperationException("Operation is not supported when not logged in"));
            }
            if (function0 != null)
            {
                function0.execute();
            }
        }
        return flag;
    }

    private void init()
    {
        getService = new ApiServiceBase(context, com/groupon/models/emailsubscription/EmailSubscriptionsContainer);
        addService = new ApiServiceBase(context, com/groupon/models/emailsubscription/EmailSubscriptionContainer);
        deleteService = new ApiServiceBase(context, java/lang/Void);
    }

    public void addEmailSubscription(Division division, Function1 function1, ReturningFunction1 returningfunction1, Function0 function0)
    {
        if (!checkLoginBeforeProceeding(returningfunction1, function0))
        {
            return;
        } else
        {
            addEmailSubscription(userManager.getPrimaryEmailAddress(), division, function1, returningfunction1, function0, null);
            return;
        }
    }

    public void addEmailSubscription(String s, Division division, Function1 function1, ReturningFunction1 returningfunction1, Function0 function0, Function0 function0_1)
    {
        boolean flag = false;
        if (Strings.isEmpty(s))
        {
            if (returningfunction1 != null)
            {
                returningfunction1.execute(new IllegalArgumentException("emailAddress may not be empty"));
            }
            if (function0 != null)
            {
                function0.execute();
            }
            return;
        }
        ArrayList arraylist = new ArrayList();
        if (division.hasParent())
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "division_id", division.parent.id, "email_address", s
            }));
            arraylist.addAll(Arrays.asList(new String[] {
                "area_id", division.id
            }));
        } else
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "division_id", division.id, "email_address", s
            }));
        }
        if (!division.hasParent())
        {
            flag = true;
        }
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "autolocate", Boolean.valueOf(flag)
        }));
        addService.execute(function1, returningfunction1, function0, function0_1, "https:/email_subscriptions", "POST", arraylist);
    }

    public void deleteEmailSubscription(String s, Function1 function1, ReturningFunction1 returningfunction1, Function0 function0)
    {
        if (checkLoginBeforeProceeding(returningfunction1, function0))
        {
            if (!isDeleteSupported() || Strings.isEmpty(s))
            {
                if (returningfunction1 != null)
                {
                    returningfunction1.execute(new IllegalArgumentException("id may not be empty"));
                }
                if (function0 != null)
                {
                    function0.execute();
                    return;
                }
            } else
            {
                deleteService.execute(function1, returningfunction1, function0, String.format("https:/email_subscriptions/%s", new Object[] {
                    s
                }), "DELETE");
                return;
            }
        }
    }

    public void getEmaiSubscriptionsNoProgressBar(Function1 function1, ReturningFunction1 returningfunction1, Function0 function0)
    {
        getEmailSubscriptions(-1, function1, returningfunction1, function0);
    }

    public void getEmailSubscriptions(int i, Function1 function1, ReturningFunction1 returningfunction1, Function0 function0)
    {
        if (!checkLoginBeforeProceeding(returningfunction1, function0))
        {
            return;
        } else
        {
            List list = Arrays.asList(new Object[] {
                "user_id", loginService.getUserId()
            });
            getService.withProgress(i).execute(function1, returningfunction1, function0, "https:/email_subscriptions", "GET", list);
            return;
        }
    }

    public boolean isDeleteSupported()
    {
        return true;
    }
}
