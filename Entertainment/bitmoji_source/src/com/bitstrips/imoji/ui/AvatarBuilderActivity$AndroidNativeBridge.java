// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.bitstrips.imoji.analytics.Action;
import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.analytics.Category;
import com.bitstrips.imoji.deserializers.AvatarInfoDeserializer;
import com.bitstrips.imoji.models.AvatarInfo;
import com.bitstrips.imoji.util.WebUtils;
import com.crashlytics.android.Crashlytics;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.bitstrips.imoji.ui:
//            AvatarBuilderActivity, IntentCreatorService, B4MBitmojiBrowserActivity, ImojiBrowserActivity

class bsauthToken
{

    private Activity activity;
    private String bsauthToken;
    private String fbToken;
    final AvatarBuilderActivity this$0;
    private WebView webView;

    private void disableWebView()
    {
        webView.setOnTouchListener(new android.view.View.OnTouchListener() {

            final AvatarBuilderActivity.AndroidNativeBridge this$1;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                this$1 = AvatarBuilderActivity.AndroidNativeBridge.this;
                super();
            }
        });
    }

    private void enableWebView()
    {
        webView.setOnTouchListener(new android.view.View.OnTouchListener() {

            final AvatarBuilderActivity.AndroidNativeBridge this$1;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                return false;
            }

            
            {
                this$1 = AvatarBuilderActivity.AndroidNativeBridge.this;
                super();
            }
        });
    }

    private void saveAvatarInfo(String s)
    {
        GsonBuilder gsonbuilder = new GsonBuilder();
        gsonbuilder.registerTypeAdapter(com/bitstrips/imoji/models/AvatarInfo, new AvatarInfoDeserializer());
        ((AvatarInfo)gsonbuilder.create().fromJson(s, com/bitstrips/imoji/models/AvatarInfo)).saveToPreferences(preferenceUtils);
    }

    private void showYesNoDialog(final String message, final String title, final int positiveString, final int negativeString)
    {
        if (activity.isFinishing())
        {
            return;
        } else
        {
            isSaving = false;
            final Context context = webView.getContext();
            activity.runOnUiThread(new Runnable() {

                final AvatarBuilderActivity.AndroidNativeBridge this$1;
                final Context val$context;
                final String val$message;
                final int val$negativeString;
                final int val$positiveString;
                final String val$title;

                public void run()
                {
                    (new android.app.AlertDialog.Builder(context)).setTitle(title).setMessage(message).setPositiveButton(positiveString, new android.content.DialogInterface.OnClickListener() {

                        final _cls7 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            webView.loadUrl("javascript:imoji_app.getValueCallback(true)");
                        }

            
            {
                this$2 = _cls7.this;
                super();
            }
                    }).setNegativeButton(negativeString, new android.content.DialogInterface.OnClickListener() {

                        final _cls7 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            webView.loadUrl("javascript:imoji_app.getValueCallback(false)");
                        }

            
            {
                this$2 = _cls7.this;
                super();
            }
                    }).show();
                }

            
            {
                this$1 = AvatarBuilderActivity.AndroidNativeBridge.this;
                context = context1;
                title = s;
                message = s1;
                positiveString = i;
                negativeString = j;
                super();
            }
            });
            return;
        }
    }

    public void exitScreen()
    {
        isSaving = false;
        if (isNewUser)
        {
            intentCreatorService.goToOutfitBuilder(activity, 1, false);
            return;
        }
        Intent intent;
        if ("b4m".equals("production"))
        {
            intent = new Intent(activity, com/bitstrips/imoji/ui/B4MBitmojiBrowserActivity);
        } else
        {
            intent = new Intent(activity, com/bitstrips/imoji/ui/ImojiBrowserActivity);
        }
        intent.putExtra("isNewUser", isNewUser);
        intent.addFlags(0x20000);
        activity.startActivity(intent);
        activity.finish();
    }

    public void getUserInfo()
    {
        activity.runOnUiThread(new Runnable() {

            final AvatarBuilderActivity.AndroidNativeBridge this$1;

            public void run()
            {
                String s = Locale.getDefault().getLanguage();
                String s1 = activity.getString(0x7f0600cf);
                String s2 = (new StringBuilder()).append(activity.getString(0x7f060038)).append(activity.getString(0x7f060027)).toString();
                String s3 = activity.getString(0x7f060026);
                Object obj = new JSONObject();
                try
                {
                    ((JSONObject) (obj)).put("endPoint", s2);
                    ((JSONObject) (obj)).put("fbToken", fbToken);
                    ((JSONObject) (obj)).put("bsauthToken", bsauthToken);
                    ((JSONObject) (obj)).put("renderHost", s1);
                    ((JSONObject) (obj)).put("locale", s);
                    ((JSONObject) (obj)).put("localizedStrings", getWebviewTranslations());
                    ((JSONObject) (obj)).put("theme", s3);
                    ((JSONObject) (obj)).put("requestAvatarStyle", true);
                    ((JSONObject) (obj)).put("appName", activity.getString(0x7f060017));
                    ((JSONObject) (obj)).put("userAgent", WebUtils.getBitmojiUserAgent(getApplication()));
                }
                catch (JSONException jsonexception)
                {
                    jsonexception.printStackTrace();
                }
                obj = String.format("javascript:imoji_app.getValueCallback(%s)", new Object[] {
                    ((JSONObject) (obj)).toString()
                });
                webView.loadUrl(((String) (obj)));
            }

            
            {
                this$1 = AvatarBuilderActivity.AndroidNativeBridge.this;
                super();
            }
        });
    }

    public JSONObject getWebviewTranslations()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("FAILED_TO_SAVE_AVATAR_TITLE", activity.getString(0x7f060071));
            jsonobject.put("FAILED_TO_SAVE_AVATAR_MESSAGE", activity.getString(0x7f060070));
            jsonobject.put("FAILED_TO_LOAD_AVATAR_TITLE", activity.getString(0x7f06006f));
            jsonobject.put("FAILED_TO_LOAD_AVATAR_MESSAGE", activity.getString(0x7f06006e));
            jsonobject.put("PLEASE_CHOOSE_YOUR_GENDER", activity.getString(0x7f060078));
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return jsonobject;
        }
        return jsonobject;
    }

    public void goToOutfitBuilder(String s)
    {
        if (!isNewUser && isSaving)
        {
            exitScreen();
            return;
        } else
        {
            isSaving = false;
            saveAvatarInfo(s);
            intentCreatorService.goToOutfitBuilder(activity, 1, false);
            return;
        }
    }

    public void hideNativeSpinner()
    {
        activity.runOnUiThread(new Runnable() {

            final AvatarBuilderActivity.AndroidNativeBridge this$1;

            public void run()
            {
                enableWebView();
                activity.findViewById(0x102000d).setVisibility(8);
            }

            
            {
                this$1 = AvatarBuilderActivity.AndroidNativeBridge.this;
                super();
            }
        });
    }

    public void sendAnalyticsEvent(String s, String s1)
    {
        Log.d("AvatarBuilderActivity", (new StringBuilder()).append("Sending analytics event for Avatar Builder, ").append(s).append(", label: ").append(s1).toString());
        s = s.toUpperCase(Locale.ENGLISH);
        Action action;
        try
        {
            action = Action.valueOf(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.e("AvatarBuilderActivity", (new StringBuilder()).append("Unknown action: ").append(s).toString());
            s1.printStackTrace();
            Crashlytics.logException(s1);
            return;
        }
        if (Action.isUXAction(action))
        {
            analytics.sendEvent(Category.AVATAR_UX, action, s1);
            return;
        } else
        {
            analytics.sendEvent(Category.AVATAR, action, s1);
            return;
        }
    }

    public void showAvatarBuilderBackButtonDialog()
    {
        showYesNoDialog(activity.getString(0x7f060023), activity.getString(0x7f060024), 0x7f0600f4, 0x7f0600ac);
    }

    public void showBackButton()
    {
        Log.d("AvatarBuilderActivity", "TODO: Clean this up. showBackButton() triggered by JavaScript, does nothing in Android.");
    }

    public void showConfirmDialog(String s, String s1)
    {
        isSaving = false;
        showYesNoDialog(s, s1, 0x1040013, 0x1040009);
    }

    public void showErrorDialog(final String message, final String title)
    {
        isSaving = false;
        final Context context = webView.getContext();
        activity.runOnUiThread(new Runnable() {

            final AvatarBuilderActivity.AndroidNativeBridge this$1;
            final Context val$context;
            final String val$message;
            final String val$title;

            public void run()
            {
                (new android.app.AlertDialog.Builder(context)).setTitle(title).setMessage(message).setNeutralButton(0x104000a, null).show();
            }

            
            {
                this$1 = AvatarBuilderActivity.AndroidNativeBridge.this;
                context = context1;
                title = s;
                message = s1;
                super();
            }
        });
    }

    public void showErrorRetryDialog(String s, String s1)
    {
        isSaving = false;
        showYesNoDialog(s, s1, 0x7f060079, 0x1040000);
    }

    public void showNativeSpinner()
    {
        activity.runOnUiThread(new Runnable() {

            final AvatarBuilderActivity.AndroidNativeBridge this$1;

            public void run()
            {
                disableWebView();
                activity.findViewById(0x102000d).setVisibility(0);
            }

            
            {
                this$1 = AvatarBuilderActivity.AndroidNativeBridge.this;
                super();
            }
        });
    }







    _cls7.val.negativeString(Activity activity1, WebView webview, String s, String s1)
    {
        this$0 = AvatarBuilderActivity.this;
        super();
        activity = activity1;
        webView = webview;
        fbToken = s;
        bsauthToken = s1;
    }
}
