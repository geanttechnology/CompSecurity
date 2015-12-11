// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import com.inc247.bridge.ChatSDKNativeToJSBridge;
import com.inc247.constants.ChatSDKConstants;
import org.json.JSONObject;

// Referenced classes of package com.inc247:
//            ChatSDK, ChatSDKResources

public final class ChatSDKUtil
{

    private static final String TAG = com/inc247/ChatSDKUtil.getSimpleName();

    public ChatSDKUtil()
    {
    }

    public static int convertDpToPixel(int i)
    {
        Resources resources = ChatSDK.getSDKInstance().activity.getResources();
        return (int)TypedValue.applyDimension(1, i, resources.getDisplayMetrics());
    }

    public static String createAgentAvailabilityURLString(String s, String s1, String s2)
    {
        return String.format("%s?queueId=%s&accountId=%s", new Object[] {
            s, s1, s2
        });
    }

    public static String createAgentAvailabilityURLStringFromCAServerUrl(String s)
    {
        return s;
    }

    public static String createExecJSString(String s)
    {
        return String.format("javascript:%s", new Object[] {
            s
        });
    }

    public static String createExecJSString(String s, String s1)
    {
        return String.format("javascript:%s('%s')", new Object[] {
            s, s1
        });
    }

    public static String createExecJSString(String s, String s1, String s2, String s3)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("id", s);
            jsonobject.put("result", s1);
            jsonobject.put("action", s2);
            jsonobject.put("data", new JSONObject(s3));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            ChatSDKNativeToJSBridge.executeJS(createExecJSString((new StringBuilder("{'Error':'")).append(s).append("'}").toString()));
        }
        return String.format("javascript:window.NativeBridge._complete('%s')", new Object[] {
            jsonobject.toString()
        });
    }

    public static String createExecJSString(String s, String s1, String s2, JSONObject jsonobject)
    {
        JSONObject jsonobject1 = new JSONObject();
        try
        {
            jsonobject1.put("id", s);
            jsonobject1.put("result", s1);
            jsonobject1.put("action", s2);
            jsonobject1.put("data", jsonobject);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            ChatSDKNativeToJSBridge.executeJS(createExecJSString((new StringBuilder("{'Error':'")).append(s).append("'}").toString()));
        }
        return String.format("javascript:window.NativeBridge._complete('%s')", new Object[] {
            jsonobject1.toString()
        });
    }

    public static int getBadgeHeight()
    {
        return convertDpToPixel((int)ChatSDKConstants.BADGE_HEIGHT_DP);
    }

    public static int getBadgeMargin()
    {
        return convertDpToPixel((int)ChatSDKConstants.BADGE_MARGIN_DP);
    }

    public static int getBadgeWidth()
    {
        return convertDpToPixel((int)ChatSDKConstants.BADGE_WIDTH_DP);
    }

    public static TranslateAnimation getButtonHideAnimation()
    {
        String s;
        String s1;
        s = ChatSDKResources.MAXIMIZE_BUTTON_POSITION_PORTRAIT;
        s1 = ChatSDKResources.MAXIMIZE_BUTTON_POSITION_LANDSCAPE;
        if (ChatSDK.getSDKInstance().activity.getResources().getConfiguration().orientation != 1) goto _L2; else goto _L1
_L1:
        if (!s.equalsIgnoreCase("top-right") && !s.equalsIgnoreCase("middle-right") && !s.equalsIgnoreCase("bottom-right")) goto _L4; else goto _L3
_L3:
        int i;
        int j;
        j = getMaximizeButtonWidth();
        i = 0;
_L7:
        return new TranslateAnimation(0, j, 0, i);
_L4:
        if (s.equalsIgnoreCase("top-left") || s.equalsIgnoreCase("middle-left") || s.equalsIgnoreCase("bottom-left"))
        {
            j = -getMaximizeButtonWidth();
            i = 0;
            continue; /* Loop/switch isn't completed */
        }
        if (s.equalsIgnoreCase("top-center"))
        {
            i = -getMaximizeButtonHeight();
            j = 0;
            continue; /* Loop/switch isn't completed */
        }
        if (s.equalsIgnoreCase("bottom-center"))
        {
            i = getMaximizeButtonHeight();
            j = 0;
            continue; /* Loop/switch isn't completed */
        }
          goto _L5
_L2:
        if (s1.equalsIgnoreCase("top-right") || s1.equalsIgnoreCase("middle-right") || s1.equalsIgnoreCase("bottom-right"))
        {
            j = getMaximizeButtonWidth();
            i = 0;
            continue; /* Loop/switch isn't completed */
        }
        if (s1.equalsIgnoreCase("top-left") || s1.equalsIgnoreCase("middle-left") || s1.equalsIgnoreCase("bottom-left"))
        {
            j = -getMaximizeButtonWidth();
            i = 0;
            continue; /* Loop/switch isn't completed */
        }
        if (s1.equalsIgnoreCase("top-center"))
        {
            i = -getMaximizeButtonHeight();
            j = 0;
            continue; /* Loop/switch isn't completed */
        }
        if (s1.equalsIgnoreCase("bottom-center"))
        {
            i = getMaximizeButtonHeight();
            j = 0;
            continue; /* Loop/switch isn't completed */
        }
_L5:
        i = 0;
        j = 0;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static TranslateAnimation getButtonShowAnimation()
    {
        String s;
        String s1;
        s = ChatSDKResources.MAXIMIZE_BUTTON_POSITION_PORTRAIT;
        s1 = ChatSDKResources.MAXIMIZE_BUTTON_POSITION_LANDSCAPE;
        if (ChatSDK.getSDKInstance().activity.getResources().getConfiguration().orientation != 1) goto _L2; else goto _L1
_L1:
        if (!s.equalsIgnoreCase("top-right") && !s.equalsIgnoreCase("middle-right") && !s.equalsIgnoreCase("bottom-right")) goto _L4; else goto _L3
_L3:
        int i;
        int j;
        j = getMaximizeButtonWidth();
        i = 0;
_L7:
        return new TranslateAnimation(j, 0, i, 0);
_L4:
        if (s.equalsIgnoreCase("top-left") || s.equalsIgnoreCase("middle-left") || s.equalsIgnoreCase("bottom-left"))
        {
            j = -getMaximizeButtonWidth();
            i = 0;
            continue; /* Loop/switch isn't completed */
        }
        if (s.equalsIgnoreCase("top-center"))
        {
            i = -getMaximizeButtonHeight();
            j = 0;
            continue; /* Loop/switch isn't completed */
        }
        if (s.equalsIgnoreCase("bottom-center"))
        {
            i = getMaximizeButtonHeight();
            j = 0;
            continue; /* Loop/switch isn't completed */
        }
          goto _L5
_L2:
        if (s1.equalsIgnoreCase("top-right") || s1.equalsIgnoreCase("middle-right") || s1.equalsIgnoreCase("bottom-right"))
        {
            j = getMaximizeButtonWidth();
            i = 0;
            continue; /* Loop/switch isn't completed */
        }
        if (s1.equalsIgnoreCase("top-left") || s1.equalsIgnoreCase("middle-left") || s1.equalsIgnoreCase("bottom-left"))
        {
            j = -getMaximizeButtonWidth();
            i = 0;
            continue; /* Loop/switch isn't completed */
        }
        if (s1.equalsIgnoreCase("top-center"))
        {
            i = -getMaximizeButtonHeight();
            j = 0;
            continue; /* Loop/switch isn't completed */
        }
        if (s1.equalsIgnoreCase("bottom-center"))
        {
            i = getMaximizeButtonHeight();
            j = 0;
            continue; /* Loop/switch isn't completed */
        }
_L5:
        i = 0;
        j = 0;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static int[] getMarginParams()
    {
        int i = getStatusBarHeight();
        int ai[] = new int[2];
        int j = getMaximizeButtonWidth();
        int k = getMaximizeButtonHeight();
        int l = getScreenDimentions()[0];
        int i1 = getScreenDimentions()[1];
        String s;
        if (ChatSDK.getSDKInstance().activity.getResources().getConfiguration().orientation == 1)
        {
            s = ChatSDKResources.MAXIMIZE_BUTTON_POSITION_PORTRAIT;
        } else
        {
            s = ChatSDKResources.MAXIMIZE_BUTTON_POSITION_LANDSCAPE;
        }
        if (s.equalsIgnoreCase("top-left"))
        {
            ai[0] = 0;
            ai[1] = 0;
        } else
        if (s.equalsIgnoreCase("top-right"))
        {
            ai[0] = l - j;
            ai[1] = 0;
        } else
        if (s.equalsIgnoreCase("top-center"))
        {
            ai[0] = (l - j) / 2 - j / 2;
            ai[1] = 0;
        } else
        if (s.equalsIgnoreCase("middle-left"))
        {
            ai[0] = 0;
            ai[1] = ((i1 - k) / 2 - k / 2) + i;
        } else
        if (s.equalsIgnoreCase("middle-right"))
        {
            ai[0] = l - j;
            ai[1] = ((i1 - k) / 2 - k / 2) + i;
        } else
        if (s.equalsIgnoreCase("bottom-left"))
        {
            ai[0] = 0;
            ai[1] = i1 - (i + k);
        } else
        if (s.equalsIgnoreCase("bottom-center"))
        {
            ai[0] = (l - j) / 2 - j / 2;
            ai[1] = i1 - (i + j);
        } else
        if (s.equalsIgnoreCase("bottom-right"))
        {
            ai[0] = l - j;
            ai[1] = i1 - (i + k);
        } else
        {
            Log.e(TAG, "Invalid Parameter in XML");
            ai[0] = 0;
            ai[1] = 0;
        }
        return (new int[] {
            ai[0], ai[1] + i, 0, 0
        });
    }

    public static int[] getMarginParamsForBadge()
    {
        int ai[] = new int[4];
        int ai1[] = getMarginParams();
        String s;
        if (ChatSDK.getSDKInstance().activity.getResources().getConfiguration().orientation == 1)
        {
            s = ChatSDKResources.MAXIMIZE_BUTTON_POSITION_PORTRAIT;
        } else
        {
            s = ChatSDKResources.MAXIMIZE_BUTTON_POSITION_LANDSCAPE;
        }
        if (s.equalsIgnoreCase("top-right") || s.equalsIgnoreCase("middle-right") || s.equalsIgnoreCase("bottom-right"))
        {
            ai1[0] = ai1[0] + getBadgeMargin();
            ai1[1] = ai1[1] + getBadgeMargin();
            return ai1;
        }
        if (s.equalsIgnoreCase("top-left") || s.equalsIgnoreCase("middle-left") || s.equalsIgnoreCase("bottom-left"))
        {
            ai1[0] = ai1[0] + getBadgeMargin();
            ai1[1] = ai1[1] + getBadgeMargin();
            return ai1;
        }
        if (s.equalsIgnoreCase("top-center") || s.equalsIgnoreCase("bottom-center"))
        {
            ai1[0] = ai1[0] + (getMaximizeButtonHeight() - (getBadgeWidth() + getBadgeMargin()));
            ai1[1] = ai1[1] + getBadgeMargin();
            return ai1;
        } else
        {
            Log.e(TAG, "Invalid Parameter in XML");
            ai1[0] = 0;
            ai1[1] = 0;
            return ai1;
        }
    }

    public static int getMaximizeButtonHeight()
    {
        return convertDpToPixel((int)ChatSDKConstants.MAXIMIZE_BUTTON_HEIGHT_DP);
    }

    public static int getMaximizeButtonWidth()
    {
        return convertDpToPixel((int)ChatSDKConstants.MAXIMIZE_BUTTON_WIDTH_DP);
    }

    public static int[] getScreenDimentions()
    {
        int ai[] = new int[2];
        Display display = ChatSDK.getSDKInstance().activity.getWindowManager().getDefaultDisplay();
        if (android.os.Build.VERSION.SDK_INT >= 13)
        {
            Point point = new Point();
            display.getSize(point);
            ai[0] = point.x;
            ai[1] = point.y;
            return ai;
        } else
        {
            ai[0] = display.getWidth();
            ai[1] = display.getHeight();
            return ai;
        }
    }

    public static int getStatusBarHeight()
    {
        Rect rect = new Rect();
        ChatSDK.getSDKInstance().activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    public static boolean isTablet(Context context)
    {
        return (context.getResources().getConfiguration().screenLayout & 0xf) >= 3;
    }

    public static String sendLocation(String s, String s1, String s2)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("Longitude", s1);
            jsonobject.put("Latitude", s2);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1.printStackTrace();
            ChatSDKNativeToJSBridge.executeJS(createExecJSString((new StringBuilder("{'Error':'")).append(s1).append("'}").toString()));
        }
        return String.format("javascript:%s(%s)", new Object[] {
            s, jsonobject.toString()
        });
    }

}
