// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.groupon.models.country.Country;
import com.groupon.models.user.UserContainer;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.ReturningFunction1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.service:
//            ApiServiceBase, LoginService

public class GiftCodesService
{

    private static final int GIFT_CODE_LENGTH_JAPAN = 12;
    private Context context;
    private CurrentCountryManager currentCountryManager;
    private DeviceInfoUtil deviceInfoUtil;
    private LoginService loginService;
    private ApiServiceBase usersService;

    public GiftCodesService()
    {
    }

    private void init()
    {
        usersService = new ApiServiceBase(context, com/groupon/models/user/UserContainer);
    }

    public void addGiftCode(String s, String s1, Function1 function1, ReturningFunction1 returningfunction1, Function0 function0)
    {
        if (!loginService.isLoggedIn())
        {
            Ln.d("Gift codes -- not logged in, return", new Object[0]);
            return;
        }
        Ln.d("GIFTCODES: GiftCodesService.execute, s=%s, e=%s, code=%s, pin=%s", new Object[] {
            function1, returningfunction1, s, Strings.toString(s1)
        });
        s = new ArrayList(Arrays.asList(new Object[] {
            "code", s
        }));
        if (Strings.notEmpty(s1))
        {
            s.addAll(Arrays.asList(new String[] {
                "pin", s1
            }));
        }
        usersService.execute(function1, returningfunction1, function0, String.format("https:/users/%s/gift_codes?%s=%s", new Object[] {
            loginService.getUserId(), "lang", deviceInfoUtil.getLanguageFromLocale()
        }), "POST", s);
    }

    public void getCreditsForUser(Function1 function1, ReturningFunction1 returningfunction1, Function0 function0)
    {
        if (!loginService.isLoggedIn())
        {
            Ln.d("Get credits -- not logged in, return", new Object[0]);
            return;
        } else
        {
            ArrayList arraylist = new ArrayList(Arrays.asList(new Object[] {
                "show", "creditsAvailable"
            }));
            usersService.execute(function1, returningfunction1, function0, String.format("https:/users/%s", new Object[] {
                loginService.getUserId()
            }), "GET", arraylist);
            return;
        }
    }

    public boolean isGiftCodeValid(String s)
    {
        int i = 0;
        if (!Strings.isEmpty(s)) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = true;
        if (!currentCountryManager.getCurrentCountry().isJapan())
        {
            continue;
        }
        flag = false;
        if (s.length() != 12)
        {
            continue;
        }
        boolean flag1 = true;
        s = s.toCharArray();
        int j = s.length;
        do
        {
            flag = flag1;
            if (i >= j)
            {
                continue;
            }
            if (!Character.isLetterOrDigit(s[i]))
            {
                return false;
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean validatePin(String s)
    {
        if (!Strings.isEmpty(s)) goto _L2; else goto _L1
_L1:
        int j;
        return false;
_L2:
        if ((j = s.length()) == 8)
        {
            int i = 0;
label0:
            do
            {
label1:
                {
                    if (i >= j)
                    {
                        break label1;
                    }
                    if (!Character.isDigit(s.charAt(i)))
                    {
                        break label0;
                    }
                    i++;
                }
            } while (true);
        }
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }
}
