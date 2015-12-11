// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.d.ik;

public final class i
{

    public static String a(Context context, int j)
    {
        context = context.getResources();
        switch (j)
        {
        default:
            return context.getString(0x104000a);

        case 1: // '\001'
            return context.getString(com.google.android.gms.a.b.common_google_play_services_install_button);

        case 3: // '\003'
            return context.getString(com.google.android.gms.a.b.common_google_play_services_enable_button);

        case 2: // '\002'
        case 42: // '*'
            return context.getString(com.google.android.gms.a.b.common_google_play_services_update_button);
        }
    }

    public static String a(Context context, int j, String s)
    {
        context = context.getResources();
        switch (j)
        {
        default:
            return context.getString(com.google.android.gms.a.b.common_google_play_services_unknown_issue);

        case 1: // '\001'
            if (ik.a(context))
            {
                return context.getString(com.google.android.gms.a.b.common_google_play_services_install_text_tablet, new Object[] {
                    s
                });
            } else
            {
                return context.getString(com.google.android.gms.a.b.common_google_play_services_install_text_phone, new Object[] {
                    s
                });
            }

        case 3: // '\003'
            return context.getString(com.google.android.gms.a.b.common_google_play_services_enable_text, new Object[] {
                s
            });

        case 18: // '\022'
            return context.getString(com.google.android.gms.a.b.common_google_play_services_updating_text, new Object[] {
                s
            });

        case 2: // '\002'
            return context.getString(com.google.android.gms.a.b.common_google_play_services_update_text, new Object[] {
                s
            });

        case 42: // '*'
            return context.getString(com.google.android.gms.a.b.common_android_wear_update_text, new Object[] {
                s
            });

        case 9: // '\t'
            return context.getString(com.google.android.gms.a.b.common_google_play_services_unsupported_text, new Object[] {
                s
            });

        case 7: // '\007'
            return context.getString(com.google.android.gms.a.b.common_google_play_services_network_error_text);

        case 5: // '\005'
            return context.getString(com.google.android.gms.a.b.common_google_play_services_invalid_account_text);

        case 16: // '\020'
            return context.getString(com.google.android.gms.a.b.common_google_play_services_api_unavailable_text, new Object[] {
                s
            });

        case 17: // '\021'
            return context.getString(com.google.android.gms.a.b.common_google_play_services_sign_in_failed_text);
        }
    }
}
