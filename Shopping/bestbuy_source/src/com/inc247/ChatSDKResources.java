// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247;

import android.content.Context;
import android.content.res.Resources;

public class ChatSDKResources
{

    public static String ACCOUNT_ID = null;
    public static String AGENTAVAILABILITY_URL = null;
    public static String ANIMATION_TYPE = null;
    public static String CUSTOM_MINIMIZE_STATE = null;
    public static String CUSTOM_URL_SCHEME = null;
    public static String Chatsdk_Config_URL = null;
    public static String HALIGN_LANDSCAPE = null;
    public static String HALIGN_PORTRAIT = null;
    public static String HEIGHT_LANDSCAPE = null;
    public static String HEIGHT_PORTRAIT = null;
    public static String MAXIMIZE_BUTTON_BACKGROUND = null;
    public static String MAXIMIZE_BUTTON_POSITION_LANDSCAPE = null;
    public static String MAXIMIZE_BUTTON_POSITION_PORTRAIT = null;
    public static String MAXIMIZE_BUTTON_TEXTCOLOR = null;
    public static String PADDING_BOTTOM_LANDSCAPE = null;
    public static String PADDING_BOTTOM_PORTRAIT = null;
    public static String PADDING_LEFT_LANDSCAPE = null;
    public static String PADDING_LEFT_PORTRAIT = null;
    public static String PADDING_RIGHT_LANDSCAPE = null;
    public static String PADDING_RIGHT_PORTRAIT = null;
    public static String PADDING_TOP_LANDSCAPE = null;
    public static String PADDING_TOP_PORTRAIT = null;
    public static String QUEUE_ID = null;
    public static String URL = null;
    public static String VALIGN_LANDSCAPE = null;
    public static String VALIGN_PORTRAIT = null;
    public static String WIDTH_LANDSCAPE = null;
    public static String WIDTH_PORTRAIT = null;
    public static String XML_DATA_LOADER_DIALOG = "true";
    private static boolean isValid = true;

    public ChatSDKResources()
    {
    }

    public static void initializeValues(Context context)
    {
        int i = context.getResources().getIdentifier("chatsdk_url", "string", context.getPackageName());
        int j = context.getResources().getIdentifier("chatsdk_config_url", "string", context.getPackageName());
        int k = context.getResources().getIdentifier("chatsdk_agentavailability_url", "string", context.getPackageName());
        int l = context.getResources().getIdentifier("chatsdk_accountId", "string", context.getPackageName());
        int i1 = context.getResources().getIdentifier("chatsdk_queueId", "string", context.getPackageName());
        int j1 = context.getResources().getIdentifier("chatsdk_minimizedbuttonposition_portrait", "string", context.getPackageName());
        int k1 = context.getResources().getIdentifier("chatsdk_minimizedbuttonposition_landscape", "string", context.getPackageName());
        int l1 = context.getResources().getIdentifier("chatsdk_customminimizestate", "string", context.getPackageName());
        int i2 = context.getResources().getIdentifier("chatsdk_animationtype", "string", context.getPackageName());
        int j2 = context.getResources().getIdentifier("chatsdk_height_portrait", "string", context.getPackageName());
        int k2 = context.getResources().getIdentifier("chatsdk_height_landscape", "string", context.getPackageName());
        int l2 = context.getResources().getIdentifier("chatsdk_width_portrait", "string", context.getPackageName());
        int i3 = context.getResources().getIdentifier("chatsdk_width_landscape", "string", context.getPackageName());
        int j3 = context.getResources().getIdentifier("chatsdk_halign_portrait", "string", context.getPackageName());
        int k3 = context.getResources().getIdentifier("chatsdk_halign_landscape", "string", context.getPackageName());
        int l3 = context.getResources().getIdentifier("chatsdk_valign_portrait", "string", context.getPackageName());
        int i4 = context.getResources().getIdentifier("chatsdk_valign_landscape", "string", context.getPackageName());
        int j4 = context.getResources().getIdentifier("chatsdk_padding_top_portrait", "string", context.getPackageName());
        int k4 = context.getResources().getIdentifier("chatsdk_padding_top_landscape", "string", context.getPackageName());
        int l4 = context.getResources().getIdentifier("chatsdk_padding_bottom_portrait", "string", context.getPackageName());
        int i5 = context.getResources().getIdentifier("chatsdk_padding_bottom_landscape", "string", context.getPackageName());
        int j5 = context.getResources().getIdentifier("chatsdk_padding_left_portrait", "string", context.getPackageName());
        int k5 = context.getResources().getIdentifier("chatsdk_padding_left_landscape", "string", context.getPackageName());
        int l5 = context.getResources().getIdentifier("chatsdk_padding_right_portrait", "string", context.getPackageName());
        int i6 = context.getResources().getIdentifier("chatsdk_padding_right_landscape", "string", context.getPackageName());
        int j6 = context.getResources().getIdentifier("chatsdk_minimizedbutton_background", "string", context.getPackageName());
        int k6 = context.getResources().getIdentifier("chatsdk_minimizedbutton_textcolor", "string", context.getPackageName());
        int l6 = context.getResources().getIdentifier("chatsdk_urlscheme", "string", context.getPackageName());
        int i7 = context.getResources().getIdentifier("chatsdk_xml_loader_dialog", "string", context.getPackageName());
        if (i != 0)
        {
            URL = context.getResources().getString(i);
        }
        if (j != 0)
        {
            Chatsdk_Config_URL = context.getResources().getString(j);
        }
        if (k != 0)
        {
            AGENTAVAILABILITY_URL = context.getResources().getString(k);
        }
        if (l != 0)
        {
            ACCOUNT_ID = context.getResources().getString(l);
        }
        if (i1 != 0)
        {
            QUEUE_ID = context.getResources().getString(i1);
        }
        if (j1 != 0)
        {
            MAXIMIZE_BUTTON_POSITION_PORTRAIT = context.getResources().getString(j1);
        }
        if (k1 != 0)
        {
            MAXIMIZE_BUTTON_POSITION_LANDSCAPE = context.getResources().getString(k1);
        }
        if (l1 != 0)
        {
            CUSTOM_MINIMIZE_STATE = context.getResources().getString(l1);
        }
        if (i2 != 0)
        {
            ANIMATION_TYPE = context.getResources().getString(i2);
        }
        if (j2 != 0)
        {
            HEIGHT_PORTRAIT = context.getResources().getString(j2);
        }
        if (k2 != 0)
        {
            HEIGHT_LANDSCAPE = context.getResources().getString(k2);
        }
        if (l2 != 0)
        {
            WIDTH_PORTRAIT = context.getResources().getString(l2);
        }
        if (i3 != 0)
        {
            WIDTH_LANDSCAPE = context.getResources().getString(i3);
        }
        if (j3 != 0)
        {
            HALIGN_PORTRAIT = context.getResources().getString(j3);
        }
        if (k3 != 0)
        {
            HALIGN_LANDSCAPE = context.getResources().getString(k3);
        }
        if (l3 != 0)
        {
            VALIGN_PORTRAIT = context.getResources().getString(l3);
        }
        if (i4 != 0)
        {
            VALIGN_LANDSCAPE = context.getResources().getString(i4);
        }
        if (j4 != 0)
        {
            PADDING_TOP_PORTRAIT = context.getResources().getString(j4);
        }
        if (k4 != 0)
        {
            PADDING_TOP_LANDSCAPE = context.getResources().getString(k4);
        }
        if (l4 != 0)
        {
            PADDING_BOTTOM_PORTRAIT = context.getResources().getString(l4);
        }
        if (i5 != 0)
        {
            PADDING_BOTTOM_LANDSCAPE = context.getResources().getString(i5);
        }
        if (j5 != 0)
        {
            PADDING_LEFT_PORTRAIT = context.getResources().getString(j5);
        }
        if (k5 != 0)
        {
            PADDING_LEFT_LANDSCAPE = context.getResources().getString(k5);
        }
        if (l5 != 0)
        {
            PADDING_RIGHT_PORTRAIT = context.getResources().getString(l5);
        }
        if (i6 != 0)
        {
            PADDING_RIGHT_LANDSCAPE = context.getResources().getString(i6);
        }
        if (j6 != 0)
        {
            MAXIMIZE_BUTTON_BACKGROUND = context.getResources().getString(j6);
        }
        if (k6 != 0)
        {
            MAXIMIZE_BUTTON_TEXTCOLOR = context.getResources().getString(k6);
        }
        if (l6 != 0)
        {
            CUSTOM_URL_SCHEME = context.getResources().getString(l6);
        }
        if (i7 != 0)
        {
            XML_DATA_LOADER_DIALOG = context.getResources().getString(i7);
        }
        WIDTH_PORTRAIT = WIDTH_PORTRAIT.replace("%", "");
        HEIGHT_PORTRAIT = HEIGHT_PORTRAIT.replace("%", "");
        PADDING_TOP_PORTRAIT = PADDING_TOP_PORTRAIT.replace("%", "");
        PADDING_BOTTOM_PORTRAIT = PADDING_BOTTOM_PORTRAIT.replace("%", "");
        PADDING_LEFT_PORTRAIT = PADDING_LEFT_PORTRAIT.replace("%", "");
        PADDING_RIGHT_PORTRAIT = PADDING_RIGHT_PORTRAIT.replace("%", "");
        WIDTH_LANDSCAPE = WIDTH_LANDSCAPE.replace("%", "");
        HEIGHT_LANDSCAPE = HEIGHT_LANDSCAPE.replace("%", "");
        PADDING_TOP_LANDSCAPE = PADDING_TOP_LANDSCAPE.replace("%", "");
        PADDING_BOTTOM_LANDSCAPE = PADDING_BOTTOM_LANDSCAPE.replace("%", "");
        PADDING_LEFT_LANDSCAPE = PADDING_LEFT_LANDSCAPE.replace("%", "");
        PADDING_RIGHT_LANDSCAPE = PADDING_RIGHT_LANDSCAPE.replace("%", "");
        if (!MAXIMIZE_BUTTON_POSITION_PORTRAIT.equalsIgnoreCase("middle-left") && !MAXIMIZE_BUTTON_POSITION_PORTRAIT.equalsIgnoreCase("middle-right"))
        {
            isValid = false;
        }
        if (!MAXIMIZE_BUTTON_POSITION_LANDSCAPE.equalsIgnoreCase("middle-left") && !MAXIMIZE_BUTTON_POSITION_LANDSCAPE.equalsIgnoreCase("middle-right"))
        {
            isValid = false;
        }
        if (i == 0 || k == 0 || l == 0 || i1 == 0 || j1 == 0 || k1 == 0 || l1 == 0 || j6 == 0 || k6 == 0)
        {
            isValid = false;
        }
    }

    public static boolean isXMLValid()
    {
        return isValid;
    }

}
