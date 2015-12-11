// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.content.res.Resources;
import com.comcast.cim.android.view.common.errorformatter.ErrorFormatter;
import com.comcast.cim.android.view.common.errorformatter.FormattedError;
import com.xfinity.playerlib.view.videoplay.PlayerPlatformErrorException;

public class PlayerPlatformErrorFormatter
    implements ErrorFormatter
{

    private final Resources resources;

    public PlayerPlatformErrorFormatter(Resources resources1)
    {
        resources = resources1;
    }

    private int getDescriptionResourceForError(PlayerPlatformErrorException playerplatformerrorexception)
    {
        switch (playerplatformerrorexception.getMajorCode())
        {
        default:
            return com.xfinity.playerlib.R.string.video_playback_error_msg_default;

        case 3305: 
        case 3348: 
            return com.xfinity.playerlib.R.string.player_platform_error_msg_connection_problem;

        case 3306: 
        case 3311: 
        case 3335: 
        case 3337: 
        case 3349: 
            return com.xfinity.playerlib.R.string.player_platform_error_msg_upgrade_required;

        case 3309: 
            return com.xfinity.playerlib.R.string.player_platform_error_msg_video_corrupted;

        case 3304: 
            return com.xfinity.playerlib.R.string.player_platform_error_msg_subscription_required;

        case 3303: 
        case 3333: 
            return com.xfinity.playerlib.R.string.player_platform_error_msg_video_expired;

        case 3321: 
            return com.xfinity.playerlib.R.string.player_platform_error_msg_device_registration_problem;

        case 3313: 
        case 3322: 
        case 3323: 
        case 3324: 
        case 3325: 
        case 3326: 
        case 3343: 
            return com.xfinity.playerlib.R.string.player_platform_error_msg_app_corrupted;

        case 3327: 
            return com.xfinity.playerlib.R.string.player_platform_error_msg_clock_tampering;

        case 3328: 
        case 3332: 
        case 3362: 
            return com.xfinity.playerlib.R.string.player_platform_error_msg_unable_to_reach_auth_server;

        case 3329: 
            return getMessageResourceForCustomError(playerplatformerrorexception.getMinorCode());

        case 3336: 
            return com.xfinity.playerlib.R.string.player_platform_error_msg_playback_disallowed_for_os;

        case 3334: 
            return com.xfinity.playerlib.R.string.player_platform_error_msg_playback_disallowed_for_device;

        case 3331: 
            return com.xfinity.playerlib.R.string.player_platform_error_msg_unable_to_play;

        case 3347: 
            return com.xfinity.playerlib.R.string.player_platform_error_msg_restore_to_factory_settings;

        case 3338: 
            return com.xfinity.playerlib.R.string.player_platform_error_msg_external_device_not_supported;

        case 3300: 
        case 3302: 
        case 3308: 
        case 3310: 
        case 3312: 
        case 3351: 
        case 3352: 
        case 3353: 
        case 3354: 
        case 3355: 
        case 3356: 
        case 3357: 
        case 3360: 
        case 3361: 
            return com.xfinity.playerlib.R.string.video_playback_generic_error;

        case 3363: 
            return com.xfinity.playerlib.R.string.player_platform_error_msg_playlist_problem;

        case 3350: 
            return com.xfinity.playerlib.R.string.player_platform_error_msg_playlist_fetch_failed;

        case 106000: 
            if (playerplatformerrorexception.isLocalPlayback())
            {
                return getMessageResourceForLocalAdobeNativeError(playerplatformerrorexception.getMinorCode());
            } else
            {
                return getMessageResourceForAdobeNativeError(playerplatformerrorexception.getMinorCode());
            }

        case 8: // '\b'
            return com.xfinity.playerlib.R.string.player_platform_error_msg_espn_no_live_events;

        case 7101: 
            return com.xfinity.playerlib.R.string.player_platform_error_msg_espn_playback_blacked_out;
        }
    }

    private int getMessageResourceForAdobeNativeError(int i)
    {
        switch (i)
        {
        default:
            return com.xfinity.playerlib.R.string.video_playback_error_msg_default;

        case 32: // ' '
        case 33: // '!'
        case 43: // '+'
        case 44: // ','
            return com.xfinity.playerlib.R.string.player_platform_error_msg_connection_problem;

        case 29: // '\035'
        case 31: // '\037'
        case 35: // '#'
        case 41: // ')'
            return com.xfinity.playerlib.R.string.player_platform_error_msg_generic_device_not_supported;

        case 78: // 'N'
        case 79: // 'O'
        case 80: // 'P'
            return com.xfinity.playerlib.R.string.player_platform_error_msg_io_error;

        case 5: // '\005'
            return com.xfinity.playerlib.R.string.player_platform_error_msg_file_not_found;

        case 2: // '\002'
        case 12: // '\f'
        case 26: // '\032'
        case 46: // '.'
        case 55: // '7'
            return com.xfinity.playerlib.R.string.player_platform_error_msg_video_corrupted;

        case 47: // '/'
            return com.xfinity.playerlib.R.string.player_platform_error_msg_playlist_problem;
        }
    }

    private int getMessageResourceForCustomError(int i)
    {
        switch (i)
        {
        default:
            return com.xfinity.playerlib.R.string.video_playback_error_msg_default;

        case 404: 
            return com.xfinity.playerlib.R.string.player_platform_error_msg_license_server_communication_problem;

        case 412: 
            return com.xfinity.playerlib.R.string.video_max_registered_devices;

        case 420: 
            return com.xfinity.playerlib.R.string.video_max_per_household_streams;

        case 428: 
            return com.xfinity.playerlib.R.string.video_max_per_household_streams_another_user;

        case 401: 
            return com.xfinity.playerlib.R.string.player_platform_error_msg_unable_to_play;
        }
    }

    private int getMessageResourceForLocalAdobeNativeError(int i)
    {
        switch (i)
        {
        default:
            return getMessageResourceForAdobeNativeError(i);

        case 5: // '\005'
            return com.xfinity.playerlib.R.string.player_platform_error_msg_variant_deleted;
        }
    }

    private boolean isOriginalOperationRetryable(PlayerPlatformErrorException playerplatformerrorexception)
    {
        int i = getDescriptionResourceForError(playerplatformerrorexception);
        return i == com.xfinity.playerlib.R.string.video_playback_error_msg_default || i == com.xfinity.playerlib.R.string.player_platform_error_msg_device_registration_problem || i == com.xfinity.playerlib.R.string.player_platform_error_msg_external_device_not_supported || i == com.xfinity.playerlib.R.string.player_platform_error_msg_connection_problem || i == com.xfinity.playerlib.R.string.player_platform_error_msg_playlist_fetch_failed || i == com.xfinity.playerlib.R.string.player_platform_error_msg_unable_to_reach_auth_server || i == com.xfinity.playerlib.R.string.player_platform_error_msg_file_not_found;
    }

    public FormattedError formatError(Throwable throwable)
    {
        if (!(throwable instanceof PlayerPlatformErrorException))
        {
            return null;
        } else
        {
            throwable = (PlayerPlatformErrorException)throwable;
            return new FormattedError(String.format("%s :: %s", new Object[] {
                resources.getString(com.xfinity.playerlib.R.string.dlg_title_error), throwable.getRawCode()
            }), resources.getString(getDescriptionResourceForError(throwable)), null, isOriginalOperationRetryable(throwable));
        }
    }
}
