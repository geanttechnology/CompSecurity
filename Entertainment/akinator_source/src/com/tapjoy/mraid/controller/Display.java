// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.URLUtil;
import com.tapjoy.TapjoyLog;
import com.tapjoy.mraid.util.ConfigBroadcastReceiver;
import com.tapjoy.mraid.view.MraidView;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tapjoy.mraid.controller:
//            Abstract

public class Display extends Abstract
{

    private WindowManager c;
    private boolean d;
    private int e;
    private int f;
    private ConfigBroadcastReceiver g;
    private float h;
    private Context i;

    public Display(MraidView mraidview, Context context)
    {
        super(mraidview, context);
        d = false;
        e = -1;
        f = -1;
        i = context;
        mraidview = new DisplayMetrics();
        c = (WindowManager)context.getSystemService("window");
        c.getDefaultDisplay().getMetrics(mraidview);
        h = ((DisplayMetrics) (mraidview)).density;
    }

    private Abstract.Dimensions a(Abstract.Dimensions dimensions1)
    {
        dimensions1.width = (int)Math.ceil(h * (float)dimensions1.width);
        dimensions1.height = (int)Math.ceil(h * (float)dimensions1.height);
        dimensions1.x = (int)((float)dimensions1.x * h);
        dimensions1.y = (int)((float)dimensions1.y * h);
        if (dimensions1.height < 0)
        {
            dimensions1.height = a.getHeight();
        }
        if (dimensions1.width < 0)
        {
            dimensions1.width = a.getWidth();
        }
        int ai[] = new int[2];
        a.getLocationInWindow(ai);
        if (dimensions1.x < 0)
        {
            dimensions1.x = ai[0];
        }
        if (dimensions1.y < 0)
        {
            dimensions1.y = ai[1] + 0;
        }
        return dimensions1;
    }

    public void close()
    {
        TapjoyLog.d("MRAID Display", "close");
        a.close();
    }

    public String dimensions()
    {
        return (new StringBuilder("{ \"top\" :")).append((int)((float)a.getTop() / h)).append(",\"left\" :").append((int)((float)a.getLeft() / h)).append(",\"bottom\" :").append((int)((float)a.getBottom() / h)).append(",\"right\" :").append((int)((float)a.getRight() / h)).append("}").toString();
    }

    public void expand(String s, String s1)
    {
        TapjoyLog.d("MRAID Display", (new StringBuilder("expand: properties: ")).append(s1).append(" url: ").append(s).toString());
        try
        {
            Object obj = new JSONObject(s1);
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("width", ((JSONObject) (obj)).get("width"));
            jsonobject.put("height", ((JSONObject) (obj)).get("height"));
            jsonobject.put("x", 0);
            jsonobject.put("y", 0);
            obj = (Abstract.Dimensions)a(jsonobject, com/tapjoy/mraid/controller/Abstract$Dimensions);
            a.expand(a(((Abstract.Dimensions) (obj))), s, (Abstract.Properties)a(new JSONObject(s1), com/tapjoy/mraid/controller/Abstract$Properties));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    public String getMaxSize()
    {
        if (d)
        {
            return (new StringBuilder("{ width: ")).append(e).append(", height: ").append(f).append("}").toString();
        } else
        {
            return getScreenSize();
        }
    }

    public int getOrientation()
    {
        char c1;
        int j;
        j = c.getDefaultDisplay().getOrientation();
        c1 = '\uFFFF';
        j;
        JVM INSTR tableswitch 0 3: default 48
    //                   0 71
    //                   1 76
    //                   2 82
    //                   3 89;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        TapjoyLog.d("MRAID Display", (new StringBuilder("getOrientation: ")).append(c1).toString());
        return c1;
_L2:
        c1 = '\0';
        continue; /* Loop/switch isn't completed */
_L3:
        c1 = 'Z';
        continue; /* Loop/switch isn't completed */
_L4:
        c1 = '\264';
        continue; /* Loop/switch isn't completed */
_L5:
        c1 = '\u010E';
        if (true) goto _L1; else goto _L6
_L6:
    }

    public String getScreenSize()
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        c.getDefaultDisplay().getMetrics(displaymetrics);
        return (new StringBuilder("{ width: ")).append((int)Math.ceil((float)displaymetrics.widthPixels / displaymetrics.density)).append(", height: ").append((int)Math.ceil((float)displaymetrics.heightPixels / displaymetrics.density)).append("}").toString();
    }

    public String getSize()
    {
        return a.getSize();
    }

    public void hide()
    {
        TapjoyLog.d("MRAID Display", "hide");
        a.hide();
    }

    public boolean isVisible()
    {
        return a.getVisibility() == 0;
    }

    public void logHTML(String s)
    {
        TapjoyLog.d("MRAID Display", s);
    }

    public void onOrientationChanged(int j)
    {
        String s = (new StringBuilder("window.mraidview.fireChangeEvent({ orientation: ")).append(j).append("});").toString();
        TapjoyLog.d("MRAID Display", s);
        a.injectMraidJavaScript(s);
    }

    public void open(String s, boolean flag, boolean flag1, boolean flag2)
    {
        TapjoyLog.i("MRAID Display", (new StringBuilder("open: url: ")).append(s).append(" back: ").append(flag).append(" forward: ").append(flag1).append(" refresh: ").append(flag2).toString());
        if (!URLUtil.isValidUrl(s))
        {
            TapjoyLog.i("MRAID Display", "invalid URL");
            s = new Intent("android.intent.action.VIEW", Uri.parse(s));
            List list = i.getPackageManager().queryIntentActivities(s, 0);
            if (list.size() == 1)
            {
                i.startActivity(s);
                return;
            }
            if (list.size() > 1)
            {
                s = Intent.createChooser(s, "Select");
                ((Activity)i).startActivity(s);
                return;
            } else
            {
                a.raiseError("Invalid url", "open");
                return;
            }
        } else
        {
            a.open(s, flag, flag1, flag2);
            return;
        }
    }

    public void openMap(String s, boolean flag)
    {
        TapjoyLog.d("MRAID Display", (new StringBuilder("openMap: url: ")).append(s).toString());
        a.openMap(s, flag);
    }

    public void playAudio(String s, boolean flag, boolean flag1, boolean flag2, boolean flag3, String s1, String s2)
    {
        TapjoyLog.d("MRAID Display", (new StringBuilder("playAudio: url: ")).append(s).append(" autoPlay: ").append(flag).append(" controls: ").append(flag1).append(" loop: ").append(flag2).append(" position: ").append(flag3).append(" startStyle: ").append(s1).append(" stopStyle: ").append(s2).toString());
        if (!URLUtil.isValidUrl(s))
        {
            a.raiseError("Invalid url", "playAudio");
            return;
        } else
        {
            a.playAudio(s, flag, flag1, flag2, flag3, s1, s2);
            return;
        }
    }

    public void playVideo(String s, boolean flag, boolean flag1, boolean flag2, boolean flag3, int ai[], String s1, 
            String s2)
    {
        int j;
        TapjoyLog.d("MRAID Display", (new StringBuilder("playVideo: url: ")).append(s).append(" audioMuted: ").append(flag).append(" autoPlay: ").append(flag1).append(" controls: ").append(flag2).append(" loop: ").append(flag3).append(" x: ").append(ai[0]).append(" y: ").append(ai[1]).append(" width: ").append(ai[2]).append(" height: ").append(ai[3]).append(" startStyle: ").append(s1).append(" stopStyle: ").append(s2).toString());
        s1 = null;
        if (ai[0] != -1)
        {
            s1 = new Abstract.Dimensions();
            s1.x = ai[0];
            s1.y = ai[1];
            s1.width = ai[2];
            s1.height = ai[3];
            s1 = a(s1);
        }
        j = 0;
        ai = s;
        if (!s.contains("android.resource")) goto _L2; else goto _L1
_L1:
        s = s.substring(s.lastIndexOf("/") + 1, s.lastIndexOf("."));
        int k = android/R$raw.getField(s).getInt(null);
        j = k;
_L4:
        s = b.getPackageName();
        ai = (new StringBuilder("android.resource://")).append(s).append("/").append(j).toString();
_L2:
        a.playVideo(ai, false, true, true, false, s1, "fullscreen", "exit");
        return;
        s;
        s.printStackTrace();
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void resize(String s)
    {
        Object obj;
        Object obj1;
        int i1;
        int j1;
        boolean flag;
        j1 = 0;
        i1 = 0;
        obj1 = null;
        obj = null;
        flag = true;
        JSONObject jsonobject;
        int j;
        jsonobject = new JSONObject(s);
        j = jsonobject.getInt("width");
        int k = jsonobject.getInt("height");
        int l = jsonobject.getInt("offsetX");
        i1 = l;
        s = obj1;
        l = jsonobject.getInt("offsetY");
        j1 = l;
        s = obj1;
        obj = jsonobject.getString("customClosePosition");
        j1 = l;
        s = ((String) (obj));
        boolean flag1 = jsonobject.getBoolean("allowOffScreen");
        int k1;
        flag = flag1;
        s = ((String) (obj));
        j1 = l;
        l = i1;
        k1 = j;
_L2:
        obj = a;
        float f1 = h;
        j = (int)((float)k1 * f1);
        f1 = h;
        ((MraidView) (obj)).resize(j, (int)((float)k * f1), l, j1, s, flag);
        return;
        s;
        j = 0;
        k = 0;
        l = 0;
        s = ((String) (obj));
_L3:
        k1 = l;
        l = j;
        j1 = i1;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        j1 = 0;
        k = 0;
        l = j;
        j = j1;
        s = ((String) (obj));
          goto _L3
        s;
        j1 = 0;
        l = j;
        j = j1;
        s = ((String) (obj));
          goto _L3
        Exception exception;
        exception;
        l = j;
        j = i1;
        i1 = j1;
          goto _L3
    }

    public void setMaxSize(int j, int k)
    {
        TapjoyLog.i("MRAID Display", (new StringBuilder("setMaxSize: ")).append(j).append("x").append(k).toString());
        d = true;
        e = j;
        f = k;
    }

    public void setOrientationProperties(boolean flag, String s)
    {
        TapjoyLog.d("MRAID Display", (new StringBuilder("setOrientationProperties: allowOrientationChange: ")).append(Boolean.toString(flag)).append(" forceOrientation: ").append(s).toString());
        a.setOrientationProperties(flag, s);
    }

    public void show()
    {
        TapjoyLog.d("MRAID Display", "show");
        a.show();
    }

    public void startConfigurationListener()
    {
        try
        {
            if (g == null)
            {
                g = new ConfigBroadcastReceiver(this);
            }
            b.registerReceiver(g, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void stopAllListeners()
    {
        stopConfigurationListener();
        g = null;
    }

    public void stopConfigurationListener()
    {
        try
        {
            b.unregisterReceiver(g);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void useCustomClose(boolean flag)
    {
        if (flag)
        {
            a.removeCloseImageButton();
        } else
        if (!flag)
        {
            a.showCloseImageButton();
            return;
        }
    }
}
