// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247.constants;

import android.app.AlertDialog;

public class ChatSDKConstants
{

    public static float BADGE_HEIGHT_DP = 0F;
    public static float BADGE_MARGIN_DP = 0F;
    public static float BADGE_WIDTH_DP = 0F;
    public static String CHATSDK_OFFLINEPAGE = "<!DOCTYPE html><html><head><meta name='viewport' content='width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no'><style type='text/css'> /* global styles */ *{font-family: 'HelveticaNeue', 'Helvetica Neue', Helvetica, Verdana, Arial, sans-serif;}html, body{margin: 0;padding: 0;overflow: hidden;background-color: rgba(57, 62, 69, 0.95);height: 100%;}body{position: relative;}div{color: white;}/* * Input Box Styles */ .input-box{background-color: #303030;box-shadow: inset 0 0 1px rgba(0, 0, 0, 0.5), 0 1px 0 rgba(255, 255, 255, 0.15);display: inline-block;position: relative;padding: 2px;border-radius: 7px;margin: 1em;}/* Header button styles */ .close-btn{/* -4 px for 2px border on each side */ width: 61px;height: 30px}.close-btn{width: 69px;}/* * Button Styles */ button{background-color: #586572;border-bottom: none;border-left: none;border-right: none;border-top: 1px solid rgba(255, 255, 255, 0.25);border-radius: 5px;color: white;font-size: 11px;font-weight: bold;line-height: 28px;margin: 0;padding: 0 5px;/*4px 5px 9px 5px;*/ text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.35);}button:active, button.clicked{background-color: #494E54;border-top: 1px solid #494E54;}button .icon.left{display: inline-block;height: 12px;position: relative;top: 3px;width: 12px;margin-right: 2px;}.icon{background-color: transparent;display: block;}.icon.left.close{width: 14px;height: 14px;background-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAA2hpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDowQjg4RkVENTBGMjA2ODExODIyQUU2MkI5ODhGMjM0QSIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDpFRTUyNkNGODg1MjQxMUUyOTM5RTlEM0JGMjdGNTBCRSIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDpFRTUyNkNGNzg1MjQxMUUyOTM5RTlEM0JGMjdGNTBCRSIgeG1wOkNyZWF0b3JUb29sPSJBZG9iZSBQaG90b3Nob3AgQ1M2IChNYWNpbnRvc2gpIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6MDE4MDExNzQwNzIwNjgxMTgwODNGMEYzRTAyMzRGNkIiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6MEI4OEZFRDUwRjIwNjgxMTgyMkFFNjJCOTg4RjIzNEEiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz7apjeKAAAB0UlEQVR42uyXz0rDQBDGm1IawUtohGCgvkEgTxCag+BFfQK9+YpNb4IvYB/BBwjeBCMhcUZ2ZTvdP7ObQw+6MLRsd77vl00y043GcZydcsxnJx4LOhFFEZ1aQvQQQ8DFof6XOkl3fKHLlIsAJoaPGuIT4gXmWRCQh+YVxBnEM0TnfQukeVEU6zRNr1BQCLPMMQdzxQXExgS8WjXEwISbsiyf2rZ9g/EKgo8wt0FomqPkovkG12IO5qIGakmIoxyNyIH5KIYLgprLPAKx5ADM67q+V81dECZzFaKqqjstuGYrU4gjERUiSZIHCeEyVwb+tuIAxBCNRYhCSPP9aB9boe28BV4QPubch1Ddia0LwsfcF4AF4WMeAjAFoqHmoQA/EMMwNFxnWLvTmQcD4KuW5/m14zWTz8Ue15rKPNVm1/au6y6ZXXAUaytWu7ftgEeRsVbMoFsQau6CYAFMNbdBsJqRh3nDqZjWLqprx1mW3TLNY27ZRk1WO0bBvu93THN2AxOa8eR2rDHnQvDasXhQLgwQW4O5CwK1Ut9KSHfCZW7qHb/mIaVYQnDNKcSBuQ4gogcFPJiQuRXEh+2/ve5wI5rROXx/tx1Moj9/NvwH+BZgAPrxsJVCeDeyAAAAAElFTkSuQmCC);background-position: 0 0;background-size: 100%;}.container{height: 100%;position: relative;}/* * Maximized chat screen container styles * Full height * 10px pad from top and sides of window */ .chat-maximized-window{left: 0;margin: 0;padding: 0;position: absolute;}.chat-maximized-window.full-height{bottom: 0;position: absolute;right: 0;top: 10px;}.chat-maximized-window.full-height .container{z-index: 2;}/* * Full Height absolute positioning. */ .full-height .chat-window, .full-height .body-area{left: 0;position: absolute;right: 0;}.full-height .chat-window{bottom: 0;top: 0;}.full-height .body-area{bottom: 40px;top: 50px;}/* * Maximized screen styles */ .chat-window{position: relative;z-index: 2;}.chat-window.full-height{margin-bottom: 0;}.chat-window.full-height{margin-left: auto;margin-right: auto;max-width: 600px;}.body-area{padding: 0;margin: 0;}/* * Waiting screen styles */ .waiting{text-align: center;margin-bottom: 0.5em;}.waiting-area{text-align: center;}.waiting-inset{display: block;margin: 15px 30px 20px;text-align: center;}.waiting span{font-size: 16px;line-height: 26px;}.waiting-banner{margin-top: 1em;margin-bottom: 0.3em;text-align: center;font-size: 18px;line-height: 32px;}/* Max chat width handling */ @media only screen and (max-width: 620px){.chat-window.full-height{margin-left: 10px;margin-right: 10px;}}/* Styles for managing small screens */ @media only screen and (max-height: 320px){.chat-window.full-height{margin-top: 0;}.chat-maximized-window.full-height{top: 5px;}.full-height .body-area{top: 0;}}</style></head><div id='div_247_mainbody' class='chat-mainbody'><div id='chat_maximized_window' class='chat-maximized-window full-height'><div class='waiting-container container' id='waiting_container'><div class='waiting-area chat-window panel full-height' id='waiting_area'><div class='waiting-body-area body-area' id='waiting_body_area'><div class='waiting-area' id='waiting_area'><div class='waiting-inset input-box' id='waiting_inset'><div class='waiting-banner' id='waiting_banner'> We're sorry. </div><div class='waiting' id='waiting_waittime'><span> There are currently no<br/> agents available to assist you.<br/> Please try again later.<br/></span><a href='chatsdk_closedialog' class='btn input-box'><button class='closebutton-btn close-btn' id='closebutton_close_btn' ><i class='icon left close'></i> Close </button></a></div></div></div></div></div></div></div></body></html>";
    public static float MAXIMIZE_BUTTON_HEIGHT_DP = 0F;
    public static float MAXIMIZE_BUTTON_WIDTH_DP = 0F;
    public static final int REQUEST_CODE_FILE_PICKER = 51426;
    public static String USER_AGENT_STRING_MOBILE = "mobile";
    public static String USER_AGENT_STRING_TABLET = "tablet";
    public static AlertDialog alert;
    public static android.app.AlertDialog.Builder alertDialogBuilder = null;
    public static String alertForEnableGps = "Location access for your phone is off. App wants to use your location to serve better. Do you want to turn on location access ";
    public static String alertForEnabledGoogleLocationService = "Allow Google's Location Service to get accurate location";
    public static boolean isUserPermitGps = true;
    public static int maximizeButtonAnimationDuration = 500;

    public ChatSDKConstants()
    {
    }

    static 
    {
        MAXIMIZE_BUTTON_WIDTH_DP = 36F;
        MAXIMIZE_BUTTON_HEIGHT_DP = 80F;
        BADGE_WIDTH_DP = 18F;
        BADGE_HEIGHT_DP = 18F;
        BADGE_MARGIN_DP = 3F;
    }
}
