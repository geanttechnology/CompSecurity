// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.provider;

import android.content.Context;

// Referenced classes of package android.provider:
//            ParentalControlSettingsHelper

public class GlobalControlSettingsProvider
{

    private static final String POLICIES[] = {
        "device.policy.protect.settings.browser", "device.policy.protect.deregistration", "device.policy.protect.kindlestore", "device.policy.protect.archiveditems", "device.policy.protect.settings", "device.policy.force.devicepassword", "device.policy.protect.allowinstallation", "device.policy.protect.factoryreset", "device.policy.protect.wifi", "device.policy.protect.settings.content_libraries", 
        "device.policy.content.books", "device.policy.content.newstand", "device.policy.content.music", "device.policy.content.video", "device.policy.content.docs", "device.policy.content.apps", "device.policy.content.games", "device.policy.content.gallery", "device.policy.content.messaging", "device.policy.content.archive", 
        "device.policy.content.online"
    };
    private Context mContext;

    public GlobalControlSettingsProvider(Context context)
    {
        mContext = context;
    }

    private boolean getPermission(String s)
    {
        return Settings.Secure.getInt(mContext.getContentResolver(), s, 0) == 1;
    }

    public boolean getPermissionValue(String s)
    {
        if (isDevicePolicyEnabled())
        {
            if (!s.startsWith("device.policy."))
            {
                return getPermission((new StringBuilder()).append("device.policy.").append(s).toString());
            } else
            {
                return getPermission(s);
            }
        } else
        {
            new ParentalControlSettingsHelper(mContext);
            return getPermission(s);
        }
    }

    public String getPolicyId()
    {
        return Settings.Secure.getString(mContext.getContentResolver(), "device.policy.id");
    }

    public boolean isDevicePolicyEnabled()
    {
        return getPolicyId() != null;
    }

    public boolean isPINOn()
    {
        return isParentalPINOn() || isDevicePolicyEnabled();
    }

    public boolean isParentalPINOn()
    {
        return Settings.Secure.getInt(mContext.getContentResolver(), "parental_control", -1) == 1;
    }

}
