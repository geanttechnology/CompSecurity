// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.google.android.gms.b.de;

public final class i
{

    public static final String a(Context context, int j)
    {
        context = context.getResources();
        switch (j)
        {
        default:
            Log.e("GooglePlayServicesUtil", (new StringBuilder()).append("Unexpected error code ").append(j).toString());
            // fall through

        case 4: // '\004'
        case 6: // '\006'
            return null;

        case 1: // '\001'
            return context.getString(com.google.android.gms.a.a.common_google_play_services_install_title);

        case 3: // '\003'
            return context.getString(com.google.android.gms.a.a.common_google_play_services_enable_title);

        case 18: // '\022'
            return context.getString(com.google.android.gms.a.a.common_google_play_services_updating_title);

        case 2: // '\002'
            return context.getString(com.google.android.gms.a.a.common_google_play_services_update_title);

        case 42: // '*'
            return context.getString(com.google.android.gms.a.a.common_android_wear_update_title);

        case 9: // '\t'
            Log.e("GooglePlayServicesUtil", "Google Play services is invalid. Cannot recover.");
            return context.getString(com.google.android.gms.a.a.common_google_play_services_unsupported_title);

        case 7: // '\007'
            Log.e("GooglePlayServicesUtil", "Network error occurred. Please retry request later.");
            return context.getString(com.google.android.gms.a.a.common_google_play_services_network_error_title);

        case 8: // '\b'
            Log.e("GooglePlayServicesUtil", "Internal error occurred. Please see logs for detailed information");
            return null;

        case 10: // '\n'
            Log.e("GooglePlayServicesUtil", "Developer error occurred. Please see logs for detailed information");
            return null;

        case 5: // '\005'
            Log.e("GooglePlayServicesUtil", "An invalid account was specified when connecting. Please provide a valid account.");
            return context.getString(com.google.android.gms.a.a.common_google_play_services_invalid_account_title);

        case 11: // '\013'
            Log.e("GooglePlayServicesUtil", "The application is not licensed to the user.");
            return null;

        case 16: // '\020'
            Log.e("GooglePlayServicesUtil", "One of the API components you attempted to connect to is not available.");
            return null;

        case 17: // '\021'
            Log.e("GooglePlayServicesUtil", "The specified account could not be signed in.");
            break;
        }
        return context.getString(com.google.android.gms.a.a.common_google_play_services_sign_in_failed_title);
    }

    public static String a(Context context, int j, String s)
    {
        context = context.getResources();
        switch (j)
        {
        default:
            return context.getString(com.google.android.gms.a.a.common_google_play_services_unknown_issue);

        case 1: // '\001'
            if (de.a(context))
            {
                return context.getString(com.google.android.gms.a.a.common_google_play_services_install_text_tablet, new Object[] {
                    s
                });
            } else
            {
                return context.getString(com.google.android.gms.a.a.common_google_play_services_install_text_phone, new Object[] {
                    s
                });
            }

        case 3: // '\003'
            return context.getString(com.google.android.gms.a.a.common_google_play_services_enable_text, new Object[] {
                s
            });

        case 18: // '\022'
            return context.getString(com.google.android.gms.a.a.common_google_play_services_updating_text, new Object[] {
                s
            });

        case 2: // '\002'
            return context.getString(com.google.android.gms.a.a.common_google_play_services_update_text, new Object[] {
                s
            });

        case 42: // '*'
            return context.getString(com.google.android.gms.a.a.common_android_wear_update_text, new Object[] {
                s
            });

        case 9: // '\t'
            return context.getString(com.google.android.gms.a.a.common_google_play_services_unsupported_text, new Object[] {
                s
            });

        case 7: // '\007'
            return context.getString(com.google.android.gms.a.a.common_google_play_services_network_error_text);

        case 5: // '\005'
            return context.getString(com.google.android.gms.a.a.common_google_play_services_invalid_account_text);

        case 16: // '\020'
            return context.getString(com.google.android.gms.a.a.common_google_play_services_api_unavailable_text, new Object[] {
                s
            });

        case 17: // '\021'
            return context.getString(com.google.android.gms.a.a.common_google_play_services_sign_in_failed_text);
        }
    }

    public static String b(Context context, int j)
    {
        context = context.getResources();
        switch (j)
        {
        default:
            return context.getString(0x104000a);

        case 1: // '\001'
            return context.getString(com.google.android.gms.a.a.common_google_play_services_install_button);

        case 3: // '\003'
            return context.getString(com.google.android.gms.a.a.common_google_play_services_enable_button);

        case 2: // '\002'
        case 42: // '*'
            return context.getString(com.google.android.gms.a.a.common_google_play_services_update_button);
        }
    }
}
