// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import android.content.Context;
import android.net.Uri;
import android.provider.SearchRecentSuggestions;
import android.support.v4.e.a;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.apptentive.android.sdk.Apptentive;
import com.b.a.a.g;
import com.b.a.a.h;
import com.b.a.a.i;
import com.b.a.a.j;
import com.crashlytics.android.Crashlytics;
import com.facebook.AccessToken;
import com.facebook.login.LoginManager;
import com.leanplum.Leanplum;
import com.offerup.android.dto.BackgroundImage;
import com.offerup.android.dto.Image;
import com.offerup.android.dto.Item;
import com.offerup.android.dto.Person;
import com.offerup.android.dto.Rating;
import com.offerup.android.dto.User;
import com.offerup.android.dto.UserProfile;
import com.offerup.android.dto.UserProfileModel;
import com.offerup.android.network.b;
import com.urbanairship.UAirship;
import com.urbanairship.push.PushManager;
import org.apache.commons.lang3.StringUtils;

public class ba
{

    private static j a;

    public ba()
    {
    }

    public static long a(long l, long l1)
    {
        j j1 = d();
        if (j1 != null)
        {
            long l2 = j1.n();
            if (l2 > 0L)
            {
                l2 = Long.valueOf(l2).longValue();
                if (l == l2)
                {
                    return l1;
                }
                if (l1 == l2)
                {
                    return l;
                }
            }
        }
        return 0L;
    }

    public static UserProfileModel a(User user)
    {
        return new UserProfileModel(user);
    }

    public static UserProfileModel a(UserProfile userprofile)
    {
        return new UserProfileModel(userprofile);
    }

    public static void a(Context context)
    {
        Object obj = d();
        try
        {
            LoginManager.getInstance().logOut();
        }
        catch (Throwable throwable)
        {
            g.a("UserUtil", throwable);
        }
        (new SearchRecentSuggestions(context, "com.offerup.android.providers.SearchSuggestionProvider", 1)).clearHistory();
        ((j) (obj)).s();
        h.a(context).c();
        com.offerup.android.network.b.a();
        obj = i.a(context);
        ((i) (obj)).b();
        ((i) (obj)).c();
        android.support.v4.e.a.k();
        android.support.v4.e.a.j();
        android.support.v4.e.a.i();
        Leanplum.setUserId(null);
        Apptentive.removeCustomPersonData(context, "user_id");
        Apptentive.removeCustomDeviceData(context, "apid");
        Apptentive.setInitialUserEmail(context, "");
        try
        {
            CookieSyncManager.createInstance(context);
            CookieManager.getInstance().removeAllCookie();
            UAirship.shared().getPushManager().setAlias(null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            g.c("UserUtil", Log.getStackTraceString(context));
        }
    }

    public static void a(Context context, User user)
    {
        j j1 = d();
        if (j1 == null) goto _L2; else goto _L1
_L1:
        if (StringUtils.isNotEmpty(user.getToken()))
        {
            j1.e(user.getToken());
        }
        if (user.getId() <= 0)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        if ((long)user.getId() != j1.n())
        {
            Apptentive.addCustomPersonData(context, "user_id", String.valueOf(user.getUserId()));
        }
        j1.a(user.getId());
        Leanplum.setUserId(String.valueOf(user.getId()));
        UAirship.shared().getPushManager().setAlias(String.valueOf(user.getId()));
_L4:
        if (StringUtils.isNotEmpty(user.getEmail()))
        {
            if (!StringUtils.equals(user.getEmail(), j1.k()))
            {
                Apptentive.setInitialUserEmail(context, user.getEmail());
            }
            j1.d(user.getEmail());
        }
        if (user.getFirstItemPosted() != null)
        {
            j1.r(true);
        }
        if (user.getFirstMessageSent() != null)
        {
            j1.t(true);
        }
        Exception exception;
        boolean flag;
        if (user.getFirstPayoutReceived() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        try
        {
            j1.a(flag);
            j1.u(user.isPaymentEnabled());
            j1.g(user.getFirstName());
            j1.h(user.getLastName());
            j1.i(user.getAvatarLarge());
            j1.j(user.getAvatarSquare());
            j1.f(user.getVerificationStatus());
            j1.c(user.isVerifiedUser());
            if (user.isItemsArchived())
            {
                j1.i(true);
                j1.k(true);
            }
            j1.j(user.isItemsAutoArchived());
            j1.d(user.hasAddedCard());
            j1.e(user.isCardOnFile());
            j1.g(user.isTermsAccepted());
            j1.k(user.getPublicLocationName());
            if (user.getRating() != null)
            {
                j1.a(user.getRating().getAverage());
                j1.g(user.getRating().getCount());
            }
            j1.f(user.isUsingDefaultAvatar());
            j1.a(user.getDateJoined());
            if (user.getBackgroundImage() != null && user.getBackgroundImage().getSmall() != null && user.getBackgroundImage().getSmall().getUri() != null)
            {
                j1.l(user.getBackgroundImage().getSmall().getUri().toString());
            }
            com.offerup.android.network.b.a();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            g.a("UserUtil", context);
        }
_L2:
        try
        {
            Crashlytics.setUserIdentifier(String.valueOf(user.getId()));
            Crashlytics.setUserEmail(user.getEmail());
            Crashlytics.setUserName(user.getEmail());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            g.c("UserUtil", Log.getStackTraceString(context));
        }
        break; /* Loop/switch isn't completed */
        exception;
        g.a("UserUtil", exception);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static boolean a()
    {
        j j1 = d();
        return j1 != null && StringUtils.isNotEmpty(j1.l());
    }

    public static boolean a(Item item)
    {
        return item != null && item.getOwner() != null && item.getOwner().getId() == j.a().n();
    }

    public static String b()
    {
        if (AccessToken.getCurrentAccessToken() != null && !AccessToken.getCurrentAccessToken().isExpired())
        {
            j.a().f(AccessToken.getCurrentAccessToken().getToken());
            return AccessToken.getCurrentAccessToken().getToken();
        } else
        {
            return j.a().m();
        }
    }

    public static int c()
    {
        switch (d().o())
        {
        default:
            return -1;

        case 0: // '\0'
        case 3: // '\003'
        case 4: // '\004'
            return 0;

        case 1: // '\001'
        case 2: // '\002'
            return 1;

        case 5: // '\005'
            return 2;
        }
    }

    private static j d()
    {
        Object obj;
        obj = a;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        com/offerup/android/utils/ba;
        JVM INSTR monitorenter ;
        j j1 = a;
        obj = j1;
        if (j1 != null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        obj = j.a();
        a = ((j) (obj));
        com/offerup/android/utils/ba;
        JVM INSTR monitorexit ;
        return ((j) (obj));
        obj;
        com/offerup/android/utils/ba;
        JVM INSTR monitorexit ;
        throw obj;
        return ((j) (obj));
    }
}
