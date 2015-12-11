// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

// Referenced classes of package com.apprupt.sdk:
//            CvLocale, CvICSLoader, CvBase64, Logger, 
//            CvOverlayLoader, CvAdType

class CvLauncher
{

    static final int ACTION_FAILED = 1;
    static final int ACTION_ICS = 3;
    static final int ACTION_NONE = 0;
    static final int ACTION_RESIZE = 2;
    private int action;
    private Context mContext;
    private ResizeProperties resizeProperties;

    public CvLauncher(Context context)
    {
        action = 0;
        resizeProperties = null;
        mContext = context;
    }

    private void callNumber(Uri uri)
    {
        AlertDialog alertdialog = (new android.app.AlertDialog.Builder(mContext)).create();
        _cls1 _lcls1 = new _cls1(uri);
        uri = uri.toString();
        String s = uri.substring(uri.indexOf(":") + 1);
        uri = s;
        if (s.contains("%"))
        {
            try
            {
                uri = URLDecoder.decode(s, "utf-8");
            }
            // Misplaced declaration of an exception variable
            catch (Uri uri)
            {
                uri.printStackTrace();
                uri = s;
            }
        }
        alertdialog.setMessage(uri);
        alertdialog.setButton(-1, CvLocale.BUTTON_CALL.msg(), _lcls1);
        alertdialog.setButton(-2, CvLocale.BUTTON_CANCEL.msg(), _lcls1);
        alertdialog.show();
    }

    private Intent createIntent(Uri uri, String s)
    {
        uri = new Intent(s, uri);
        setDefaultIntentFlags(uri);
        return uri;
    }

    private boolean isCallable(Intent intent)
    {
        return mContext.getPackageManager().queryIntentActivities(intent, 0x10000).size() > 0;
    }

    private void loadICS(String s)
    {
        new CvICSLoader(mContext, s);
    }

    private void parseResizeUri(Uri uri)
    {
        int i;
        int j;
label0:
        {
            String s = uri.getHost();
            if (s.matches("^[0-9]+x[0-9]+$"))
            {
                j = s.indexOf("x");
                i = Integer.valueOf(s.substring(0, j)).intValue();
                j = Integer.valueOf(s.substring(j + 1)).intValue();
                s = null;
                String s1 = uri.getPath();
                uri = s;
                if (s1 == null)
                {
                    break label0;
                }
                uri = s;
                if (s1.length() <= 0)
                {
                    break label0;
                }
                s1 = s1.replaceAll("((^\\/)|(\\/$))", "");
                uri = s;
                if (s1.length() <= 0)
                {
                    break label0;
                }
                byte abyte0[] = CvBase64.urlDecode(s1);
                uri = s;
                if (abyte0 == null)
                {
                    break label0;
                }
                s = new String(abyte0);
                uri = s;
                if (Uri.parse(s) != null)
                {
                    break label0;
                }
            }
            return;
        }
    /* block-local class not found */
    class ResizeProperties {}

        if (uri != null)
        {
            resizeProperties = new ResizeProperties(i, j, uri);
        } else
        {
            resizeProperties = new ResizeProperties(i, j);
        }
        action = 2;
    }

    private boolean runIntent(Intent intent)
    {
        if (isCallable(intent))
        {
            break MISSING_BLOCK_LABEL_52;
        }
        Logger.get("LAUNCHER").e(new Object[] {
            (new StringBuilder()).append("Intent not callable ").append(intent.getData().toString()).toString()
        });
        return false;
        try
        {
            mContext.startActivity(intent);
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            Logger.get("LAUNCHER").e(new Object[] {
                "Cannot find proper activity for intent", intent
            });
            return false;
        }
        return true;
    }

    private boolean runUri(Uri uri)
    {
        return runUri(uri, "android.intent.action.VIEW");
    }

    private boolean runUri(Uri uri, String s)
    {
        return runIntent(createIntent(uri, s));
    }

    private boolean sendEmail(Uri uri)
    {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("plain/text");
        intent.putExtra("android.intent.extra.EMAIL", new String[] {
            uri.getSchemeSpecificPart()
        });
        setDefaultIntentFlags(intent);
        return runIntent(intent);
    }

    private void setDefaultIntentFlags(Intent intent)
    {
        intent.addFlags(0x10000000);
        if (android.os.Build.VERSION.SDK_INT < 21)
        {
            intent.addFlags(0x80000);
        }
        intent.addFlags(0x40000000);
    }

    int getAction()
    {
        return action;
    }

    ResizeProperties getResizeProperties()
    {
        return resizeProperties;
    }

    void runBrowserOverlay(String s)
    {
        runBrowserOverlay(s, true);
    }

    void runBrowserOverlay(String s, boolean flag)
    {
        (new CvOverlayLoader(mContext, flag)).load(s);
    }

    public boolean shouldRunURL(String s, CvAdType cvadtype)
    {
        action = 0;
        Uri uri = Uri.parse(s);
        if (uri.getScheme().equals("webcal") || (uri.getScheme().equals("http") || uri.getScheme().equals("https")) && uri.getPath().endsWith(".ics"))
        {
            loadICS(s);
            return false;
        }
        if (uri.getScheme().equals("http") || uri.getScheme().equals("https"))
        {
            if (uri.getPath().endsWith(".mp4") || uri.getPath().endsWith(".ics") || uri.getHost().equals("webapps.apprupt.com") || uri.getHost().equals("market.android.com") || uri.getHost().matches("^(.+\\.)?(youtube\\.)([a-z]+)$"))
            {
                runUri(uri);
                return false;
            }
            if (cvadtype == CvAdType.IN_PLACE)
            {
                return true;
            } else
            {
                Logger.get("LAUNCHER").v(new Object[] {
                    "Launcher", (new StringBuilder()).append("Running browser overlay: ").append(uri).toString()
                });
                runBrowserOverlay(s);
                return false;
            }
        }
        if (uri.getScheme().equals("browserhttp") || uri.getScheme().equals("browserhttps"))
        {
            runUri(Uri.parse(uri.toString().substring(7)));
            return false;
        }
        if (uri.getScheme().equals("video"))
        {
            runUri(Uri.parse((new StringBuilder()).append("http").append(uri.toString().substring(5)).toString()));
            return false;
        }
        if (uri.getScheme().equals("resize"))
        {
            parseResizeUri(uri);
            return false;
        }
        if (uri.getScheme().equals("tel"))
        {
            callNumber(uri);
            return false;
        }
        if (uri.getScheme().equals("mailto"))
        {
            sendEmail(uri);
            return false;
        } else
        {
            runUri(uri);
            return false;
        }
    }


    /* member class not found */
    class _cls1 {}

}
