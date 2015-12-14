// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appinvite;

import android.accounts.Account;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.internal.zzx;
import java.util.Map;

// Referenced classes of package com.google.android.gms.appinvite:
//            AppInviteInvitation

public final class mIntent
{

    public static final int MAX_CALL_TO_ACTION_TEXT_LENGTH = 20;
    public static final int MAX_MESSAGE_LENGTH = 100;
    public static final int MIN_CALL_TO_ACTION_TEXT_LENGTH = 2;
    private final Intent mIntent = new Intent("com.google.android.gms.appinvite.ACTION_APP_INVITE");

    public final Intent build()
    {
        return mIntent;
    }

    public final mIntent setAccount(Account account)
    {
        if (account != null && "com.google".equals(account.type))
        {
            mIntent.putExtra("com.google.android.gms.appinvite.ACCOUNT_NAME", account);
            return this;
        } else
        {
            mIntent.removeExtra("com.google.android.gms.appinvite.ACCOUNT_NAME");
            return this;
        }
    }

    public final mIntent setAdditionalReferralParameters(Map map)
    {
        if (map != null)
        {
            mIntent.putExtra("com.google.android.gms.appinvite.REFERRAL_PARAMETERS_URI", AppInviteInvitation.zzD(map));
            return this;
        } else
        {
            mIntent.removeExtra("com.google.android.gms.appinvite.REFERRAL_PARAMETERS_URI");
            return this;
        }
    }

    public final mIntent setAndroidMinimumVersionCode(int i)
    {
        mIntent.putExtra("com.google.android.gms.appinvite.appMinimumVersionCode", i);
        return this;
    }

    public final mIntent setCallToActionText(CharSequence charsequence)
    {
        if (charsequence == null || charsequence.length() < 2 || charsequence.length() > 20)
        {
            throw new IllegalArgumentException(String.format("Text must be between %d and %d chars in length.", new Object[] {
                Integer.valueOf(2), Integer.valueOf(20)
            }));
        } else
        {
            mIntent.putExtra("com.google.android.gms.appinvite.BUTTON_TEXT", charsequence);
            return this;
        }
    }

    public final mIntent setCustomImage(Uri uri)
    {
        zzx.zzw(uri);
        zzx.zzb(uri.isAbsolute(), "Image uri is not an absolute uri. Did you forget to add a scheme to the Uri?");
        String s = uri.getScheme().toLowerCase();
        boolean flag;
        if (s.equals("http") || s.equals("https"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Image uri must be a network url with scheme \"http\" or \"https\".");
        uri = uri.buildUpon().(s).();
        mIntent.setData(uri);
        return this;
    }

    public final mIntent setDeepLink(Uri uri)
    {
        if (uri != null)
        {
            mIntent.putExtra("com.google.android.gms.appinvite.DEEP_LINK_URL", uri);
            return this;
        } else
        {
            mIntent.removeExtra("com.google.android.gms.appinvite.DEEP_LINK_URL");
            return this;
        }
    }

    public final mIntent setGoogleAnalyticsTrackingId(String s)
    {
        mIntent.putExtra("com.google.android.gms.appinvite.GOOGLE_ANALYTICS_TRACKING_ID", s);
        return this;
    }

    public final mIntent setMessage(CharSequence charsequence)
    {
        if (charsequence != null && charsequence.length() > 100)
        {
            throw new IllegalArgumentException(String.format("Message must be %d chars or less.", new Object[] {
                Integer.valueOf(100)
            }));
        } else
        {
            mIntent.putExtra("com.google.android.gms.appinvite.MESSAGE", charsequence);
            return this;
        }
    }

    public final mIntent setOtherPlatformsTargetApplication(int i, String s)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException("targetPlatform must be either PROJECT_PLATFORM_IOS or PROJECT_PLATFORM_ANDROID.");

        case 1: // '\001'
            mIntent.putExtra("com.google.android.gms.appinvite.iosTargetApplication", s);
            return this;

        case 2: // '\002'
            mIntent.putExtra("com.google.android.gms.appinvite.androidTargetApplication", s);
            break;
        }
        return this;
    }

    public (CharSequence charsequence)
    {
        zzx.zzw(charsequence);
        mIntent.putExtra("com.google.android.gms.appinvite.TITLE", charsequence);
        mIntent.setPackage("com.google.android.gms");
    }
}
