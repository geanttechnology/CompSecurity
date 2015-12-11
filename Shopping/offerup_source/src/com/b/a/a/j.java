// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import b.a.a;
import com.offerup.android.dto.BackgroundImage;
import com.offerup.android.dto.Image;
import com.offerup.android.dto.Rating;
import com.offerup.android.dto.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

// Referenced classes of package com.b.a.a:
//            k, g

public final class j
{

    private static j c;
    private String a;
    private SharedPreferences b;

    private j(Context context)
    {
        b = context.getSharedPreferences("OFFERUP_PREFS", 0);
        a = context.getResources().getString(0x7f0900fc);
    }

    public static j a()
    {
        return c;
    }

    public static j a(Context context)
    {
        if (c == null)
        {
            c = new j(context);
        }
        return c;
    }

    public final void A(String s1)
    {
        b.edit().putString("offerZipCode", s1).commit();
    }

    public final boolean A()
    {
        return b.getBoolean("viewedArchiveHelp", false);
    }

    public final void B(String s1)
    {
        b.edit().putString("offerLong", s1).commit();
    }

    public final boolean B()
    {
        return b.getBoolean("viewedAutoArchiveHelp", false);
    }

    public final String C()
    {
        return b.getString("categories", null);
    }

    public final void C(String s1)
    {
        b.edit().putString("offerLat", s1).commit();
    }

    public final String D()
    {
        return b.getString("exploreList", null);
    }

    public final void D(String s1)
    {
        b.edit().putString("offerCity", s1).commit();
    }

    public final String E()
    {
        return b.getString("searchZipCode", null);
    }

    public final void E(String s1)
    {
        b.edit().putString("offerState", s1).commit();
    }

    public final String F()
    {
        return b.getString("searchLongitude", null);
    }

    public final void F(String s1)
    {
        b.edit().putString("buyButtonTitle", s1).apply();
    }

    public final String G()
    {
        return b.getString("searchLatitude", null);
    }

    public final void G(String s1)
    {
        b.edit().putString("NoSearchResultsString", s1).commit();
    }

    public final void H(String s1)
    {
        b.edit().putString("itemDetailsFragmentOrder", s1).commit();
    }

    public final boolean H()
    {
        return b.getBoolean("useSavedLocation", false);
    }

    public final String I()
    {
        return b.getString("searchCity", null);
    }

    public final String J()
    {
        return b.getString("searchState", null);
    }

    public final String K()
    {
        return b.getString("offerZipCode", null);
    }

    public final String L()
    {
        return b.getString("offerLong", null);
    }

    public final String M()
    {
        return b.getString("offerLat", null);
    }

    public final String N()
    {
        return b.getString("offerCity", null);
    }

    public final String O()
    {
        return b.getString("offerState", null);
    }

    public final boolean P()
    {
        return b.getBoolean("offerUseSavedLocation", false);
    }

    public final boolean Q()
    {
        return b.getBoolean("madeFirstPost", false);
    }

    public final boolean R()
    {
        return b.getBoolean("shouldShowSelectConditionPrompt", true);
    }

    public final boolean S()
    {
        return b.getBoolean("askedFirstQuestion", false);
    }

    public final int T()
    {
        return b.getInt("notificationCount", 0);
    }

    public final String U()
    {
        String s1 = a;
        return b.getString("NoSearchResultsString", s1);
    }

    public final void V()
    {
        if (b.getBoolean("migratedUserPrefs", false))
        {
            return;
        }
        Object obj;
        obj = new k();
        obj = new File((new StringBuilder()).append(((k) (obj)).a).append("offerup_userprefs.txt").toString());
        if (!((File) (obj)).exists()) goto _L2; else goto _L1
_L1:
        FileInputStream fileinputstream;
        Object obj1;
        obj1 = new Properties();
        fileinputstream = new FileInputStream(((File) (obj)));
        ((Properties) (obj1)).load(fileinputstream);
        if (((Properties) (obj1)).containsKey("userId"))
        {
            String s1 = ((Properties) (obj1)).getProperty("userId");
            if (StringUtils.isNotEmpty(s1) && NumberUtils.isNumber(s1))
            {
                a(Long.parseLong(s1));
            }
        }
        if (((Properties) (obj1)).containsKey("email"))
        {
            String s2 = ((Properties) (obj1)).getProperty("email");
            if (StringUtils.isNotEmpty(s2))
            {
                d(s2);
            }
        }
        if (((Properties) (obj1)).containsKey("FBAccessToken"))
        {
            String s3 = ((Properties) (obj1)).getProperty("FBAccessToken");
            if (StringUtils.isNotEmpty(s3))
            {
                f(s3);
            }
        }
        if (((Properties) (obj1)).containsKey("token"))
        {
            String s4 = ((Properties) (obj1)).getProperty("token");
            if (StringUtils.isNotEmpty(s4))
            {
                e(s4);
            }
        }
        if (((Properties) (obj1)).containsKey("useSavedZipCode"))
        {
            String s5 = ((Properties) (obj1)).getProperty("useSavedZipCode");
            if (StringUtils.isNotEmpty(s5) && Boolean.parseBoolean(s5))
            {
                m(true);
            }
        }
        if (((Properties) (obj1)).containsKey("searchZipCode"))
        {
            String s6 = ((Properties) (obj1)).getProperty("searchZipCode");
            if (StringUtils.isNotEmpty(s6))
            {
                p(s6);
            }
        }
        if (((Properties) (obj1)).containsKey("searchLongitude"))
        {
            String s7 = ((Properties) (obj1)).getProperty("searchLongitude");
            if (StringUtils.isNotEmpty(s7))
            {
                q(s7);
            }
        }
        if (((Properties) (obj1)).containsKey("searchlatitude"))
        {
            String s8 = ((Properties) (obj1)).getProperty("searchlatitude");
            if (StringUtils.isNotEmpty(s8))
            {
                r(s8);
            }
        }
        if (((Properties) (obj1)).containsKey("searchCity"))
        {
            String s9 = ((Properties) (obj1)).getProperty("searchCity");
            if (StringUtils.isNotEmpty(s9))
            {
                s(s9);
            }
        }
        if (((Properties) (obj1)).containsKey("searchState"))
        {
            String s10 = ((Properties) (obj1)).getProperty("searchState");
            if (StringUtils.isNotEmpty(s10))
            {
                t(s10);
            }
        }
        if (!((Properties) (obj1)).containsKey("selectedCategory")) goto _L4; else goto _L3
_L3:
        String s11 = ((Properties) (obj1)).getProperty("selectedCategory");
        if (!StringUtils.isNotEmpty(s11) || !NumberUtils.isNumber(s11)) goto _L4; else goto _L5
_L5:
        int i1 = Integer.parseInt(s11);
        if (i1 < 0) goto _L4; else goto _L6
_L6:
        j(i1);
_L4:
        if (((Properties) (obj1)).containsKey("offerTitle"))
        {
            String s12 = ((Properties) (obj1)).getProperty("offerTitle");
            if (StringUtils.isNotEmpty(s12))
            {
                u(s12);
            }
        }
        if (((Properties) (obj1)).containsKey("offerImagePath"))
        {
            String s13 = ((Properties) (obj1)).getProperty("offerImagePath");
            if (StringUtils.isNotEmpty(s13))
            {
                v(s13);
            }
        }
        if (((Properties) (obj1)).containsKey("offerCategory"))
        {
            String s14 = ((Properties) (obj1)).getProperty("offerCategory");
            if (StringUtils.isNotEmpty(s14))
            {
                w(s14);
            }
        }
        if (((Properties) (obj1)).containsKey("offerDescription"))
        {
            String s15 = ((Properties) (obj1)).getProperty("offerDescription");
            if (StringUtils.isNotEmpty(s15))
            {
                x(s15);
            }
        }
        if (((Properties) (obj1)).containsKey("offerPrice"))
        {
            String s16 = ((Properties) (obj1)).getProperty("offerPrice");
            if (StringUtils.isNotEmpty(s16))
            {
                y(s16);
            }
        }
        if (((Properties) (obj1)).containsKey("offerFirmPrice"))
        {
            String s17 = ((Properties) (obj1)).getProperty("offerFirmPrice");
            if (StringUtils.isNotEmpty(s17) && Boolean.parseBoolean(s17))
            {
                n(true);
            }
        }
        if (((Properties) (obj1)).containsKey("offerCondition"))
        {
            String s18 = ((Properties) (obj1)).getProperty("offerCondition");
            if (StringUtils.isNotEmpty(s18))
            {
                z(s18);
            }
        }
        if (((Properties) (obj1)).containsKey("offerFBShare"))
        {
            String s19 = ((Properties) (obj1)).getProperty("offerFBShare");
            if (StringUtils.isNotEmpty(s19) && Boolean.parseBoolean(s19))
            {
                o(true);
            }
        }
        if (((Properties) (obj1)).containsKey("offerZipcode"))
        {
            String s20 = ((Properties) (obj1)).getProperty("offerZipcode");
            if (StringUtils.isNotEmpty(s20))
            {
                A(s20);
            }
        }
        if (((Properties) (obj1)).containsKey("offerLongitude"))
        {
            String s21 = ((Properties) (obj1)).getProperty("offerLongitude");
            if (StringUtils.isNotEmpty(s21))
            {
                C(s21);
            }
        }
        if (((Properties) (obj1)).containsKey("offerLatitude"))
        {
            String s22 = ((Properties) (obj1)).getProperty("offerLatitude");
            if (StringUtils.isNotEmpty(s22))
            {
                B(s22);
            }
        }
        if (((Properties) (obj1)).containsKey("offerCity"))
        {
            String s23 = ((Properties) (obj1)).getProperty("offerCity");
            if (StringUtils.isNotEmpty(s23))
            {
                D(s23);
            }
        }
        if (((Properties) (obj1)).containsKey("offerState"))
        {
            String s24 = ((Properties) (obj1)).getProperty("offerState");
            if (StringUtils.isNotEmpty(s24))
            {
                E(s24);
            }
        }
        if (((Properties) (obj1)).containsKey("offerUseSavedLocation"))
        {
            String s25 = ((Properties) (obj1)).getProperty("offerUseSavedLocation");
            if (StringUtils.isNotEmpty(s25) && Boolean.parseBoolean(s25))
            {
                q(true);
            }
        }
        if (((Properties) (obj1)).containsKey("madeFirstPost"))
        {
            String s26 = ((Properties) (obj1)).getProperty("madeFirstPost");
            if (StringUtils.isNotEmpty(s26) && Boolean.parseBoolean(s26))
            {
                r(true);
            }
        }
        if (!((Properties) (obj1)).containsKey("notificationCount")) goto _L8; else goto _L7
_L7:
        obj1 = ((Properties) (obj1)).getProperty("notificationCount");
        if (!StringUtils.isNotEmpty(((CharSequence) (obj1))) || !NumberUtils.isNumber(((String) (obj1)))) goto _L8; else goto _L9
_L9:
        i1 = Integer.parseInt(((String) (obj1)));
        if (i1 <= 0) goto _L8; else goto _L10
_L10:
        k(i1);
_L8:
        fileinputstream.close();
_L11:
        ((File) (obj)).delete();
_L2:
        b.edit().putBoolean("migratedUserPrefs", true).apply();
        return;
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
          goto _L11
        Exception exception;
        exception;
        com.b.a.a.g.a(getClass().getSimpleName(), exception);
          goto _L2
    }

    public final String W()
    {
        return b.getString("itemDetailsFragmentOrder", null);
    }

    public final boolean X()
    {
        return b.getBoolean("madePostSinceLogin", false);
    }

    public final void a(float f1)
    {
        b.edit().putFloat("averageRating", f1).apply();
    }

    public final void a(int i1)
    {
        b.edit().putInt("userUpgradeState", i1).commit();
    }

    public final void a(long l1)
    {
        b.edit().putLong("userId", l1).commit();
    }

    public final void a(a a1)
    {
        if (a1 != null)
        {
            b.edit().putString("dateJoined", a1.a()).apply();
            return;
        } else
        {
            b.edit().remove("dateJoined").apply();
            return;
        }
    }

    public final void a(String s1)
    {
        b.edit().putString("softExpirationDate", s1).commit();
    }

    public final void a(boolean flag)
    {
        b.edit().putBoolean("hasReceivedPaymentPayout", flag).commit();
    }

    public final void b(int i1)
    {
        b.edit().putInt("userUpgradeDismissedBuild", i1).commit();
    }

    public final void b(String s1)
    {
        b.edit().putString("laterDate", s1).commit();
    }

    public final void b(boolean flag)
    {
        b.edit().putBoolean("isPaymentsPurchasingEnabled", flag).commit();
    }

    public final boolean b()
    {
        return b.getBoolean("isPaymentsPurchasingEnabled", false);
    }

    public final int c()
    {
        return b.getInt("userUpgradeState", 0);
    }

    public final void c(int i1)
    {
        b.edit().putInt("appMinBuild", i1).commit();
    }

    public final void c(String s1)
    {
        b.edit().putString("userAgent", s1).commit();
    }

    public final void c(boolean flag)
    {
        b.edit().putBoolean("verifiedUser", flag).apply();
    }

    public final String d()
    {
        return b.getString("softExpirationDate", null);
    }

    public final void d(int i1)
    {
        b.edit().putInt("appSoftMinBuild", i1).commit();
    }

    public final void d(String s1)
    {
        b.edit().putString("email", s1).commit();
    }

    public final void d(boolean flag)
    {
        b.edit().putBoolean("addedCard", flag).commit();
    }

    public final String e()
    {
        return b.getString("laterDate", null);
    }

    public final void e(int i1)
    {
        b.edit().putInt("appLatestBuild", i1).commit();
    }

    public final void e(String s1)
    {
        b.edit().putString("token", s1).commit();
    }

    public final void e(boolean flag)
    {
        b.edit().putBoolean("cardOnFile", flag).commit();
    }

    public final String f()
    {
        return b.getString("userAgent", null);
    }

    public final void f(int i1)
    {
        b.edit().putInt("verificationStatus", i1).apply();
    }

    public final void f(String s1)
    {
        b.edit().putString("fbToken", s1).apply();
    }

    public final void f(boolean flag)
    {
        b.edit().putBoolean("defaultAvatar", flag).apply();
    }

    public final int g()
    {
        return b.getInt("userUpgradeDismissedBuild", 0);
    }

    public final void g(int i1)
    {
        b.edit().putInt("ratingCount", i1).apply();
    }

    public final void g(String s1)
    {
        b.edit().putString("firstName", s1).commit();
    }

    public final void g(boolean flag)
    {
        b.edit().putBoolean("termsAccepted", flag).commit();
    }

    public final int h()
    {
        return b.getInt("appMinBuild", 0);
    }

    public final void h(int i1)
    {
        b.edit().putInt("watchlistBalloonTimesShown", i1).commit();
    }

    public final void h(String s1)
    {
        b.edit().putString("lastName", s1).commit();
    }

    public final void h(boolean flag)
    {
        b.edit().putBoolean("watchlistBalloonDisabled", true).commit();
    }

    public final int i()
    {
        return b.getInt("appSoftMinBuild", 0);
    }

    public final void i(int i1)
    {
        b.edit().putInt("watchlistItemsViewedBetweenBalloons", i1).commit();
    }

    public final void i(String s1)
    {
        b.edit().putString("avatarLarge", s1).commit();
    }

    public final void i(boolean flag)
    {
        b.edit().putBoolean("itemsArchived", flag).commit();
    }

    public final int j()
    {
        return b.getInt("appLatestBuild", 0);
    }

    public final void j(int i1)
    {
        b.edit().putInt("selectedCategory", i1).commit();
    }

    public final void j(String s1)
    {
        b.edit().putString("avatarSquare", s1).commit();
    }

    public final void j(boolean flag)
    {
        b.edit().putBoolean("itemsAutoArchived", flag).commit();
    }

    public final String k()
    {
        return b.getString("email", null);
    }

    public final void k(int i1)
    {
        b.edit().putInt("notificationCount", i1).commit();
    }

    public final void k(String s1)
    {
        b.edit().putString("userLocation", s1).apply();
    }

    public final void k(boolean flag)
    {
        b.edit().putBoolean("viewedArchiveHelp", flag).commit();
    }

    public final String l()
    {
        return b.getString("token", null);
    }

    public final void l(int i1)
    {
        b.edit().putInt("lastVersionRun", i1).apply();
    }

    public final void l(String s1)
    {
        b.edit().putString("backgroundImageUrl", s1).apply();
    }

    public final void l(boolean flag)
    {
        b.edit().putBoolean("viewedAutoArchiveHelp", flag).commit();
    }

    public final String m()
    {
        return b.getString("fbToken", null);
    }

    public final void m(String s1)
    {
        b.edit().putString("androidId", s1).apply();
    }

    public final void m(boolean flag)
    {
        b.edit().putBoolean("useSavedLocation", flag).commit();
    }

    public final long n()
    {
        return b.getLong("userId", 0L);
    }

    public final void n(String s1)
    {
        b.edit().putString("categories", s1).apply();
    }

    public final void n(boolean flag)
    {
        b.edit().putBoolean("offerFirmPrice", flag).commit();
    }

    public final int o()
    {
        return b.getInt("verificationStatus", 0);
    }

    public final void o(String s1)
    {
        b.edit().putString("exploreList", s1).apply();
    }

    public final void o(boolean flag)
    {
        b.edit().putBoolean("offerFBShare", flag).commit();
    }

    public final void p(String s1)
    {
        b.edit().putString("searchZipCode", s1).commit();
    }

    public final void p(boolean flag)
    {
        b.edit().putBoolean("facebookLogin", flag).commit();
    }

    public final boolean p()
    {
        return b.getBoolean("addedCard", false);
    }

    public final void q(String s1)
    {
        b.edit().putString("searchLongitude", s1).commit();
    }

    public final void q(boolean flag)
    {
        b.edit().putBoolean("offerUseSavedLocation", flag).commit();
    }

    public final boolean q()
    {
        return b.getBoolean("cardOnFile", false);
    }

    public final void r(String s1)
    {
        b.edit().putString("searchLatitude", s1).commit();
    }

    public final void r(boolean flag)
    {
        b.edit().putBoolean("madeFirstPost", flag).commit();
    }

    public final boolean r()
    {
        return b.getBoolean("termsAccepted", true);
    }

    public final void s()
    {
        d(((String) (null)));
        e(((String) (null)));
        f(((String) (null)));
        a(0L);
        g(((String) (null)));
        h(((String) (null)));
        j(((String) (null)));
        i(((String) (null)));
        f(0);
        c(false);
        j(false);
        i(false);
        k(false);
        l(false);
        k(((String) (null)));
        a(0.0F);
        g(0);
        j(-1);
        p(((String) (null)));
        q(((String) (null)));
        r(((String) (null)));
        m(false);
        s(((String) (null)));
        t(((String) (null)));
        u(((String) (null)));
        v(((String) (null)));
        w(((String) (null)));
        x(null);
        y(null);
        n(false);
        z(null);
        o(false);
        p(false);
        A(null);
        B(null);
        C(null);
        D(null);
        E(null);
        q(false);
        r(false);
        t(false);
        k(0);
        d(false);
        e(false);
        f(false);
        a(((a) (null)));
        w(false);
        l(((String) (null)));
    }

    public final void s(String s1)
    {
        b.edit().putString("searchCity", s1).commit();
    }

    public final void s(boolean flag)
    {
        b.edit().putBoolean("shouldShowSelectConditionPrompt", false).commit();
    }

    public final User t()
    {
        User user = new User();
        user.setEmail(k());
        user.setToken(l());
        user.setUserId(n());
        user.setFirstName(b.getString("firstName", null));
        user.setLastName(b.getString("lastName", null));
        user.setAvatarSquare(b.getString("avatarSquare", null));
        user.setAvatarLarge(b.getString("avatarLarge", null));
        user.setVerificationStatus(o());
        user.setVerifiedUser(b.getBoolean("verifiedUser", false));
        user.setItemsArchived(y());
        user.setItemsAutoArchived(z());
        user.setAddedCard(p());
        user.setCardOnFile(q());
        user.setTermsAccepted(r());
        Object obj = b.getString("dateJoined", null);
        Object obj1;
        if (StringUtils.isNotEmpty(((CharSequence) (obj))))
        {
            obj = new a(((String) (obj)));
        } else
        {
            obj = null;
        }
        user.setDateJoined(((a) (obj)));
        user.setUsingDefaultAvatar(b.getBoolean("defaultAvatar", false));
        user.setPublicLocationName(b.getString("userLocation", null));
        obj = new Rating();
        ((Rating) (obj)).setAverage(b.getFloat("averageRating", 0.0F));
        ((Rating) (obj)).setCount(b.getInt("ratingCount", 0));
        user.setRating(((Rating) (obj)));
        obj1 = b.getString("backgroundImageUrl", null);
        if (StringUtils.isNotEmpty(((CharSequence) (obj1))))
        {
            obj = new BackgroundImage();
            try
            {
                obj1 = new Image(Uri.parse(((String) (obj1))), 0, 0);
                ((BackgroundImage) (obj)).setSmall(((Image) (obj1)));
                ((BackgroundImage) (obj)).setMedium(((Image) (obj1)));
                ((BackgroundImage) (obj)).setLarge(((Image) (obj1)));
                user.setUserBackgroundImage(((BackgroundImage) (obj)));
            }
            catch (Exception exception)
            {
                com.b.a.a.g.a(this, exception);
                return user;
            }
        }
        return user;
    }

    public final void t(String s1)
    {
        b.edit().putString("searchState", s1).commit();
    }

    public final void t(boolean flag)
    {
        b.edit().putBoolean("askedFirstQuestion", flag).apply();
    }

    public final String u()
    {
        return b.getString("googleAdId", null);
    }

    public final void u(String s1)
    {
        b.edit().putString("offerTitle", s1).commit();
    }

    public final void u(boolean flag)
    {
        b.edit().putBoolean("isPaymentsPostingEnabled", flag).commit();
    }

    public final void v(String s1)
    {
        b.edit().putString("offerImagePath", s1).commit();
    }

    public final void v(boolean flag)
    {
        b.edit().putBoolean("itemDetailUseNewScreen", flag).commit();
    }

    public final boolean v()
    {
        return b.getBoolean("watchlistBalloonDisabled", false);
    }

    public final int w()
    {
        return b.getInt("watchlistBalloonTimesShown", 0);
    }

    public final void w(String s1)
    {
        b.edit().putString("offerCategory", s1).commit();
    }

    public final void w(boolean flag)
    {
        b.edit().putBoolean("madePostSinceLogin", flag).commit();
    }

    public final int x()
    {
        return b.getInt("watchlistItemsViewedBetweenBalloons", 30);
    }

    public final void x(String s1)
    {
        b.edit().putString("offerDescription", s1).commit();
    }

    public final void y(String s1)
    {
        b.edit().putString("offerPrice", s1).commit();
    }

    public final boolean y()
    {
        return b.getBoolean("itemsArchived", false);
    }

    public final void z(String s1)
    {
        b.edit().putString("offerCondition", s1).commit();
    }

    public final boolean z()
    {
        return b.getBoolean("itemsAutoArchived", false);
    }
}
