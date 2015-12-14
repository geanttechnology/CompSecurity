// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appboy;

import bo.app.br;
import bo.app.cb;
import bo.app.ct;
import bo.app.cz;
import bo.app.eg;
import bo.app.ei;
import bo.app.el;
import com.appboy.enums.Gender;
import com.appboy.enums.Month;
import com.appboy.enums.NotificationSubscriptionType;
import myobfuscated.h.b;
import myobfuscated.h.d;
import myobfuscated.h.f;
import myobfuscated.i.a;
import myobfuscated.i.e;

// Referenced classes of package com.appboy:
//            Constants

public class AppboyUser
{

    private static final String c;
    final Object a = new Object();
    volatile String b;
    private final ei d;
    private final br e;
    private final eg f;
    private final cb g;

    AppboyUser(ei ei1, br br1, String s, cb cb1, eg eg1)
    {
        b = s;
        d = ei1;
        e = br1;
        g = cb1;
        f = eg1;
    }

    public boolean addToCustomAttributeArray(String s, String s1)
    {
        while (!myobfuscated.i.e.c(s) || myobfuscated.i.e.a(s, f.g()) || !myobfuscated.i.e.d(s1)) 
        {
            return false;
        }
        s = myobfuscated.i.e.e(s);
        s1 = myobfuscated.i.e.e(s1);
        try
        {
            s1 = ct.e(s, s1);
            e.a(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            myobfuscated.i.a.b(c, (new StringBuilder("Failed to add custom attribute with key '")).append(s).append("'.").toString(), s1);
            return false;
        }
        return true;
    }

    public String getUserId()
    {
        String s;
        synchronized (a)
        {
            s = b;
        }
        return s;
    }

    public boolean incrementCustomUserAttribute(String s)
    {
        return incrementCustomUserAttribute(s, 1);
    }

    public boolean incrementCustomUserAttribute(String s, int i)
    {
        if (myobfuscated.i.e.a(s, f.g()))
        {
            return false;
        }
        try
        {
            ct ct1 = ct.a(s, i);
            e.a(ct1);
        }
        catch (Exception exception)
        {
            myobfuscated.i.a.b(c, (new StringBuilder("Failed to increment custom attribute ")).append(s).append(" by ").append(i).append(".").toString(), exception);
            return false;
        }
        return true;
    }

    public boolean removeFromCustomAttributeArray(String s, String s1)
    {
        while (!myobfuscated.i.e.c(s) || myobfuscated.i.e.a(s, f.g()) || !myobfuscated.i.e.d(s1)) 
        {
            return false;
        }
        s = myobfuscated.i.e.e(s);
        s1 = myobfuscated.i.e.e(s1);
        try
        {
            s1 = ct.f(s, s1);
            e.a(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            myobfuscated.i.a.b(c, (new StringBuilder("Failed to remove custom attribute with key '")).append(s).append("'.").toString(), s1);
            return false;
        }
        return true;
    }

    public boolean setAttributionData(b b1)
    {
        try
        {
            d.a(b1);
        }
        // Misplaced declaration of an exception variable
        catch (b b1)
        {
            myobfuscated.i.a.b(c, "Failed to set attribution data.", b1);
            return false;
        }
        return true;
    }

    public boolean setAvatarImageUrl(String s)
    {
        try
        {
            d.h(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            myobfuscated.i.a.b(c, "Failed to set the avatar image URL.", s);
            return false;
        }
        return true;
    }

    public boolean setBio(String s)
    {
        try
        {
            d.d(s);
        }
        catch (Exception exception)
        {
            myobfuscated.i.a.b(c, (new StringBuilder("Failed to set bio to: ")).append(s).toString(), exception);
            return false;
        }
        return true;
    }

    public boolean setCountry(String s)
    {
        try
        {
            d.e(s);
        }
        catch (Exception exception)
        {
            myobfuscated.i.a.b(c, (new StringBuilder("Failed to set country to: ")).append(s).toString(), exception);
            return false;
        }
        return true;
    }

    public boolean setCustomAttributeArray(String s, String as[])
    {
        while (!myobfuscated.i.e.c(s) || myobfuscated.i.e.a(s, f.g())) 
        {
            return false;
        }
        String s1 = myobfuscated.i.e.e(s);
        s = as;
        if (as != null)
        {
            s = myobfuscated.i.e.a(as);
        }
        try
        {
            s = ct.a(s1, s);
            e.a(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            myobfuscated.i.a.b(c, (new StringBuilder("Failed to set custom attribute array with key: '")).append(s1).append("'.").toString());
            return false;
        }
        return true;
    }

    public boolean setCustomUserAttribute(String s, float f1)
    {
        boolean flag;
        try
        {
            flag = d.a(s, Float.valueOf(f1));
        }
        catch (Exception exception)
        {
            myobfuscated.i.a.b(c, (new StringBuilder("Failed to set custom float attribute ")).append(s).append(".").toString(), exception);
            return false;
        }
        return flag;
    }

    public boolean setCustomUserAttribute(String s, int i)
    {
        boolean flag;
        try
        {
            flag = d.a(s, Integer.valueOf(i));
        }
        catch (Exception exception)
        {
            myobfuscated.i.a.b(c, (new StringBuilder("Failed to set custom integer attribute ")).append(s).append(".").toString(), exception);
            return false;
        }
        return flag;
    }

    public boolean setCustomUserAttribute(String s, long l)
    {
        boolean flag;
        try
        {
            flag = d.a(s, Long.valueOf(l));
        }
        catch (Exception exception)
        {
            myobfuscated.i.a.b(c, (new StringBuilder("Failed to set custom long attribute ")).append(s).append(".").toString(), exception);
            return false;
        }
        return flag;
    }

    public boolean setCustomUserAttribute(String s, String s1)
    {
        boolean flag;
        try
        {
            flag = d.a(s, s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            myobfuscated.i.a.b(c, (new StringBuilder("Failed to set custom string attribute ")).append(s).append(".").toString(), s1);
            return false;
        }
        return flag;
    }

    public boolean setCustomUserAttribute(String s, boolean flag)
    {
        try
        {
            flag = d.a(s, Boolean.valueOf(flag));
        }
        catch (Exception exception)
        {
            myobfuscated.i.a.b(c, (new StringBuilder("Failed to set custom boolean attribute ")).append(s).append(".").toString(), exception);
            return false;
        }
        return flag;
    }

    public boolean setCustomUserAttributeToNow(String s)
    {
        boolean flag;
        try
        {
            flag = d.a(s, el.a());
        }
        catch (Exception exception)
        {
            myobfuscated.i.a.b(c, (new StringBuilder("Failed to set custom attribute ")).append(s).append(" to now.").toString(), exception);
            return false;
        }
        return flag;
    }

    public boolean setCustomUserAttributeToSecondsFromEpoch(String s, long l)
    {
        boolean flag;
        try
        {
            flag = d.a(s, l);
        }
        catch (Exception exception)
        {
            myobfuscated.i.a.b(c, (new StringBuilder("Failed to set custom attribute ")).append(s).append(" to ").append(l).append(" seconds from epoch.").toString(), exception);
            return false;
        }
        return flag;
    }

    public boolean setDateOfBirth(int i, Month month, int j)
    {
        boolean flag;
        try
        {
            flag = d.a(i, month, j);
        }
        catch (Exception exception)
        {
            myobfuscated.i.a.b(c, String.format("Failed to set date of birth to: %d-%d-%d", new Object[] {
                Integer.valueOf(i), Integer.valueOf(month.getValue()), Integer.valueOf(j)
            }), exception);
            return false;
        }
        return flag;
    }

    public boolean setEmail(String s)
    {
        boolean flag;
        try
        {
            flag = d.c(s);
        }
        catch (Exception exception)
        {
            myobfuscated.i.a.b(c, (new StringBuilder("Failed to set email to: ")).append(s).toString(), exception);
            return false;
        }
        return flag;
    }

    public boolean setEmailNotificationSubscriptionType(NotificationSubscriptionType notificationsubscriptiontype)
    {
        try
        {
            d.a(notificationsubscriptiontype);
        }
        catch (Exception exception)
        {
            myobfuscated.i.a.b(c, (new StringBuilder("Failed to set email notification subscription to: ")).append(notificationsubscriptiontype).toString(), exception);
            return false;
        }
        return true;
    }

    public boolean setFacebookData(d d1)
    {
        try
        {
            d.a(d1);
        }
        // Misplaced declaration of an exception variable
        catch (d d1)
        {
            myobfuscated.i.a.b(c, "Failed to set Facebook user data.", d1);
            return false;
        }
        return true;
    }

    public boolean setFirstName(String s)
    {
        try
        {
            d.a(s);
        }
        catch (Exception exception)
        {
            myobfuscated.i.a.b(c, (new StringBuilder("Failed to set first name to: ")).append(s).toString(), exception);
            return false;
        }
        return true;
    }

    public boolean setGender(Gender gender)
    {
        try
        {
            d.a(gender);
        }
        catch (Exception exception)
        {
            myobfuscated.i.a.b(c, (new StringBuilder("Failed to set gender to: ")).append(gender).toString(), exception);
            return false;
        }
        return true;
    }

    public boolean setHomeCity(String s)
    {
        try
        {
            d.f(s);
        }
        catch (Exception exception)
        {
            myobfuscated.i.a.b(c, (new StringBuilder("Failed to set home city to: ")).append(s).toString(), exception);
            return false;
        }
        return true;
    }

    public boolean setIsSubscribedToEmails(boolean flag)
    {
        NotificationSubscriptionType notificationsubscriptiontype;
        if (flag)
        {
            notificationsubscriptiontype = NotificationSubscriptionType.SUBSCRIBED;
        } else
        {
            notificationsubscriptiontype = NotificationSubscriptionType.UNSUBSCRIBED;
        }
        return setEmailNotificationSubscriptionType(notificationsubscriptiontype);
    }

    public void setLastKnownLocation(double d1, double d2, Double double1, Double double2)
    {
        try
        {
            double1 = new cz(d1, d2, double1, double2);
            g.a(double1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Double double1)
        {
            myobfuscated.i.a.b(c, "Failed to manually set location.", double1);
        }
    }

    public boolean setLastName(String s)
    {
        try
        {
            d.b(s);
        }
        catch (Exception exception)
        {
            myobfuscated.i.a.b(c, (new StringBuilder("Failed to set last name to: ")).append(s).toString(), exception);
            return false;
        }
        return true;
    }

    public boolean setPhoneNumber(String s)
    {
        boolean flag;
        try
        {
            flag = d.g(s);
        }
        catch (Exception exception)
        {
            myobfuscated.i.a.b(c, (new StringBuilder("Failed to set phone number to: ")).append(s).toString(), exception);
            return false;
        }
        return flag;
    }

    public boolean setPushNotificationSubscriptionType(NotificationSubscriptionType notificationsubscriptiontype)
    {
        try
        {
            d.b(notificationsubscriptiontype);
        }
        catch (Exception exception)
        {
            myobfuscated.i.a.b(c, (new StringBuilder("Failed to set push notification subscription to: ")).append(notificationsubscriptiontype).toString(), exception);
            return false;
        }
        return true;
    }

    public boolean setTwitterData(f f1)
    {
        try
        {
            d.a(f1);
        }
        // Misplaced declaration of an exception variable
        catch (f f1)
        {
            myobfuscated.i.a.b(c, "Failed to set Twitter user data.", f1);
            return false;
        }
        return true;
    }

    public boolean unsetCustomUserAttribute(String s)
    {
        if (myobfuscated.i.e.a(s, f.g()))
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = d.i(s);
        }
        catch (Exception exception)
        {
            myobfuscated.i.a.b(c, (new StringBuilder("Failed to unset custom attribute ")).append(s).append(".").toString(), exception);
            return false;
        }
        return flag;
    }

    static 
    {
        c = String.format("%s.%s", new Object[] {
            Constants.APPBOY_LOG_TAG_PREFIX, com/appboy/AppboyUser.getName()
        });
    }
}
