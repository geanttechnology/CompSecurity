// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import com.gps.locationfinder.GPSTracker;
import com.inc247.ApplicationStatusModel.ApplicationLocationAlerts;
import com.inc247.ApplicationStatusModel.ChatRunningStatus;
import com.inc247.bridge.ChatSDKNativeToJSBridge;
import com.inc247.constants.ChatSDKConstants;
import com.inc247.constants.CheckInternetConnection;
import com.inc247.errors.ChatSDKError;
import com.inc247.errors.ChatSDKErrorCodes;
import java.util.HashMap;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

// Referenced classes of package com.inc247:
//            ChatSDKResources, ChatSDKUtil, ChatSDKMaximizeButton, ChatSDKEventsCallback, 
//            ChatSDKBadgeView, ChatSDKWebView, ChatSDKAgentAvailibilityHelper, ChatSDKEventsListener

public class ChatSDK
{

    private static final String TAG = com/inc247/ChatSDK.getSimpleName();
    public static Dialog chatDialog;
    public static NodeList contactList;
    public static Document doc;
    public static Document documentDataForReturn = null;
    public static float height_landscape;
    public static boolean isAppDeveloperWantToAccessLocationService = false;
    public static String queue = "";
    public static String queueFromServerData;
    private static ChatSDK self = null;
    public static String url = "";
    public static float width_landscape;
    public Activity activity;
    String agentAvailabilityURLWithParams;
    private LinearLayout badgeLayout;
    private android.widget.LinearLayout.LayoutParams badgeLayoutParams;
    private ChatSDKBadgeView badgeView;
    private LinearLayout buttonLayout;
    private android.widget.LinearLayout.LayoutParams buttonLayoutParams;
    public ChatSDKEventsCallback callback;
    public ChatSDKWebView chatWebView;
    Context context;
    public JSONObject contextInfo;
    double deviceInches;
    public int height;
    public float height_portrait;
    private ChatSDKMaximizeButton maximizeButton;
    private boolean maximizedView;
    boolean notCalled;
    public float padding_left_landscape;
    public float padding_left_portrait;
    public float padding_top_landscape;
    public float padding_top_portrait;
    ProgressDialog progressDialog;
    HashMap queueIdAndUrl;
    public JSONObject queueIdFromAppDeveloper;
    double screenInches;
    public int width;
    public float width_portrait;

    private ChatSDK()
    {
        maximizedView = false;
        chatWebView = null;
        callback = null;
        activity = null;
        notCalled = false;
        contextInfo = null;
        queueIdFromAppDeveloper = null;
        buttonLayout = null;
        badgeLayout = null;
        maximizeButton = null;
        badgeView = null;
        buttonLayoutParams = null;
        badgeLayoutParams = null;
        queueIdAndUrl = new HashMap();
    }

    private void GetDeviceInch()
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        self.activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        double d = Math.pow((float)displaymetrics.widthPixels / displaymetrics.xdpi, 2D);
        screenInches = Math.sqrt(Math.pow((float)displaymetrics.heightPixels / displaymetrics.ydpi, 2D) + d);
        deviceInches = screenInches;
    }

    public static ChatSDK getSDKInstance()
    {
        if (self != null)
        {
            return self;
        } else
        {
            Log.e(TAG, "Please call initializeChat before calling any other method from ChatSDK");
            return null;
        }
    }

    private void get_landscape_padding_parameters()
    {
        padding_top_landscape = Float.parseFloat(ChatSDKResources.PADDING_TOP_LANDSCAPE);
        padding_left_landscape = Float.parseFloat(ChatSDKResources.PADDING_LEFT_LANDSCAPE);
    }

    public static void get_landscape_parameters()
    {
        try
        {
            width_landscape = Float.parseFloat(ChatSDKResources.WIDTH_LANDSCAPE);
            height_landscape = Float.parseFloat(ChatSDKResources.HEIGHT_LANDSCAPE);
            return;
        }
        catch (NumberFormatException numberformatexception)
        {
            numberformatexception.printStackTrace();
            ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString((new StringBuilder("{'Error':'")).append(numberformatexception).append("'}").toString()));
            return;
        }
    }

    private void get_portrait_padding_parameters()
    {
        padding_top_portrait = Float.parseFloat(ChatSDKResources.PADDING_TOP_PORTRAIT);
        padding_left_portrait = Float.parseFloat(ChatSDKResources.PADDING_LEFT_PORTRAIT);
    }

    private void get_portrait_parameters()
    {
        try
        {
            width_portrait = Float.parseFloat(ChatSDKResources.WIDTH_PORTRAIT);
            width_portrait = Math.round(width_portrait);
            height_portrait = Float.parseFloat(ChatSDKResources.HEIGHT_PORTRAIT);
            height_portrait = Math.round(height_portrait);
            return;
        }
        catch (NumberFormatException numberformatexception)
        {
            numberformatexception.printStackTrace();
            ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString((new StringBuilder("{'Error':'")).append(numberformatexception).append("'}").toString()));
            return;
        }
    }

    private void hideDialog()
    {
        if (chatDialog != null)
        {
            chatDialog.dismiss();
            maximizedView = false;
        }
    }

    private void hideMaximizeButton()
    {
        hideWithAnimation();
    }

    private void hideMaximizedChat()
    {
        hideDialog();
    }

    private void hideWithAnimation()
    {
        TranslateAnimation translateanimation = ChatSDKUtil.getButtonHideAnimation();
        translateanimation.setDuration(ChatSDKConstants.maximizeButtonAnimationDuration);
        translateanimation.setFillAfter(true);
        translateanimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final ChatSDK this$0;

            public void onAnimationEnd(Animation animation)
            {
                buttonLayout.setVisibility(8);
                badgeLayout.setVisibility(8);
            }

            public void onAnimationRepeat(Animation animation)
            {
                badgeLayout.setVisibility(8);
            }

            public void onAnimationStart(Animation animation)
            {
                badgeLayout.setVisibility(8);
            }

            
            {
                this$0 = ChatSDK.this;
                super();
            }
        });
        maximizeButton.startAnimation(translateanimation);
    }

    public static ChatSDK initializeChat(Activity activity1)
    {
        if (self == null)
        {
            self = new ChatSDK();
            self.callback = ChatSDKEventsCallback.getInstance();
            ChatSDKResources.initializeValues(activity1);
            self.activity = activity1;
        }
        return self;
    }

    private void makeNotifView()
    {
        Log.d("Fade Function", "Chat SDK Fade Function Enters");
        badgeLayout = new LinearLayout(activity);
        GradientDrawable gradientdrawable = new GradientDrawable();
        gradientdrawable.setColor(0xffff0000);
        gradientdrawable.setCornerRadius(90F);
        badgeLayoutParams = new android.widget.LinearLayout.LayoutParams(ChatSDKUtil.convertDpToPixel(18), ChatSDKUtil.convertDpToPixel(18));
        badgeLayoutParams.setMargins(ChatSDKUtil.getMarginParams()[0] + ChatSDKUtil.convertDpToPixel(5), ChatSDKUtil.getMarginParams()[1] + ChatSDKUtil.convertDpToPixel(7), ChatSDKUtil.getMarginParams()[2], ChatSDKUtil.getMarginParams()[3]);
        badgeLayoutParams = new android.widget.LinearLayout.LayoutParams(10, 10);
        badgeLayoutParams.setMargins(5, 5, 5, 5);
        badgeView = new ChatSDKBadgeView(activity);
        badgeView.setText("0");
        badgeView.setTextSize(12F);
        badgeView.setTextColor(-1);
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            badgeView.setBackgroundDrawable(gradientdrawable);
        } else
        {
            badgeView.setBackground(gradientdrawable);
        }
        badgeLayout.addView(badgeView, badgeLayoutParams);
    }

    private void resetBadge()
    {
        if (badgeView != null)
        {
            badgeView.setText("0");
            badgeLayout.setVisibility(8);
        }
    }

    private void resetBadgeViewPosition()
    {
        badgeLayoutParams.height = ChatSDKUtil.getBadgeHeight();
        badgeLayoutParams.width = ChatSDKUtil.getBadgeWidth();
        badgeLayoutParams.setMargins(ChatSDKUtil.getMarginParamsForBadge()[0], ChatSDKUtil.getMarginParamsForBadge()[1], ChatSDKUtil.getMarginParamsForBadge()[2], ChatSDKUtil.getMarginParamsForBadge()[3]);
        badgeView.setLayoutParams(badgeLayoutParams);
    }

    private void resetMaximizeButtonPosition()
    {
        buttonLayoutParams.height = ChatSDKUtil.getMaximizeButtonHeight();
        buttonLayoutParams.width = ChatSDKUtil.getMaximizeButtonWidth();
        buttonLayoutParams.setMargins(ChatSDKUtil.getMarginParams()[0], ChatSDKUtil.getMarginParams()[1], ChatSDKUtil.getMarginParams()[2], ChatSDKUtil.getMarginParams()[3]);
        maximizeButton.setLayoutParams(buttonLayoutParams);
    }

    private void showMaximizeButton()
    {
        if (ChatSDKResources.CUSTOM_MINIMIZE_STATE.equalsIgnoreCase("false"))
        {
            ViewGroup viewgroup = (ViewGroup)activity.getWindow().getDecorView().getRootView();
            if (buttonLayout.getParent() != null)
            {
                ((ViewManager)buttonLayout.getParent()).removeView(buttonLayout);
            }
            resetMaximizeButtonPosition();
            if (badgeLayout.getParent() != null)
            {
                ((ViewManager)badgeLayout.getParent()).removeView(badgeLayout);
            }
            resetBadgeViewPosition();
            viewgroup.addView(buttonLayout);
            viewgroup.addView(badgeLayout);
            showWithAnimation();
        }
        maximizedView = false;
    }

    private void showMaximizedChat()
    {
        if (isAppDeveloperWantToAccessLocationService)
        {
            ChatSDKNativeToJSBridge.sendLocation();
        }
        badgeLayout.setVisibility(8);
        showDialog();
        resetBadge();
        chatWebView.setVisibility(0);
    }

    private void showWithAnimation()
    {
        buttonLayout.setVisibility(0);
        badgeLayout.setVisibility(8);
        TranslateAnimation translateanimation = ChatSDKUtil.getButtonShowAnimation();
        translateanimation.setDuration(ChatSDKConstants.maximizeButtonAnimationDuration);
        translateanimation.setFillAfter(true);
        translateanimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final ChatSDK this$0;

            public void onAnimationEnd(Animation animation)
            {
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$0 = ChatSDK.this;
                super();
            }
        });
        maximizeButton.startAnimation(translateanimation);
    }

    public void addChat(Activity activity1)
    {
        self.activity = activity1;
        if (self.contextInfo != null)
        {
            if (!maximizedView)
            {
                (new Handler()).postDelayed(new Runnable() {

                    final ChatSDK this$0;

                    public void run()
                    {
                        showMaximizeButton();
                    }

            
            {
                this$0 = ChatSDK.this;
                super();
            }
                }, 200L);
            }
            return;
        } else
        {
            activity1 = new ChatSDKError(ChatSDKErrorCodes.ChatSDKChatNotStartedError);
            self.callback.sendonChatErrorEvent(activity1);
            return;
        }
    }

    public void checkAgentAvailability()
    {
        if (queueFromServerData == null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        agentAvailabilityURLWithParams = ChatSDKUtil.createAgentAvailabilityURLStringFromCAServerUrl(queueFromServerData);
_L1:
        (new ChatSDKAgentAvailibilityHelper()).execute(new String[] {
            agentAvailabilityURLWithParams
        });
        return;
        try
        {
            agentAvailabilityURLWithParams = ChatSDKUtil.createAgentAvailabilityURLString(ChatSDKResources.AGENTAVAILABILITY_URL, ChatSDKResources.QUEUE_ID, ChatSDKResources.ACCOUNT_ID);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString((new StringBuilder("{'Error':'")).append(exception).append("'}").toString()));
            CheckInternetConnection.ShowInternetConnectionLossAlert(getSDKInstance().activity);
            return;
        }
          goto _L1
    }

    public void destroySDKInstance()
    {
        self = null;
    }

    public void endChat()
    {
        if (chatWebView == null)
        {
            ChatSDKError chatsdkerror = new ChatSDKError(ChatSDKErrorCodes.ChatSDKChatNotStartedError);
            self.callback.sendonChatErrorEvent(chatsdkerror);
            return;
        } else
        {
            hideMaximizedChat();
            hideMaximizeButton();
            resetBadge();
            chatWebView.destroyWebView();
            ChatRunningStatus.setChatRunning(false);
            chatWebView = null;
            contextInfo = null;
            GPSTracker.locationManager = null;
            return;
        }
    }

    public void getQueueId(JSONObject jsonobject)
    {
        queueIdFromAppDeveloper = jsonobject;
    }

    public void getQueueIdParameters()
    {
        try
        {
            (new getXmlData(null)).execute(new String[0]);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString((new StringBuilder("{'Error':'")).append(exception).append("'}").toString()));
            return;
        }
    }

    public void getWindowParam()
    {
        Display display = ((WindowManager)self.activity.getSystemService("window")).getDefaultDisplay();
        width = display.getWidth();
        height = display.getHeight();
    }

    public void incrementBadge()
    {
        if (!maximizedView && badgeView != null)
        {
            (new Handler()).postDelayed(new Runnable() {

                final ChatSDK this$0;

                public void run()
                {
                    badgeLayout.setVisibility(0);
                    int i = Integer.parseInt((new StringBuilder()).append(badgeView.getText().toString().charAt(0)).toString());
                    String s;
                    if (i == 9)
                    {
                        s = (new StringBuilder(String.valueOf(i))).append("+").toString();
                    } else
                    {
                        s = (new StringBuilder(String.valueOf(i + 1))).toString();
                    }
                    badgeView.setText(s);
                }

            
            {
                this$0 = ChatSDK.this;
                super();
            }
            }, ChatSDKConstants.maximizeButtonAnimationDuration);
        }
    }

    public void maximizeChat()
    {
        if (chatWebView == null)
        {
            ChatSDKError chatsdkerror = new ChatSDKError(ChatSDKErrorCodes.ChatSDKChatNotStartedError);
            self.callback.sendonChatErrorEvent(chatsdkerror);
            return;
        }
        badgeLayout.setVisibility(8);
        try
        {
            ChatSDKNativeToJSBridge.sendChatMaximizedCallbackToJS();
        }
        catch (Exception exception)
        {
            ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString((new StringBuilder("{'Error':'")).append(exception).append("'}").toString()));
        }
        hideMaximizeButton();
        showMaximizedChat();
        self.callback.sendonChatMaximizedEvent(new JSONObject());
        (new Handler()).postDelayed(new Runnable() {

            final ChatSDK this$0;

            public void run()
            {
                badgeLayout.setVisibility(8);
            }

            
            {
                this$0 = ChatSDK.this;
                super();
            }
        }, 200L);
    }

    public void minimizeChat()
    {
        if (chatWebView == null)
        {
            ChatSDKError chatsdkerror = new ChatSDKError(ChatSDKErrorCodes.ChatSDKChatNotStartedError);
            self.callback.sendonChatErrorEvent(chatsdkerror);
            return;
        }
        hideMaximizedChat();
        if (ChatSDKResources.CUSTOM_MINIMIZE_STATE.equalsIgnoreCase("false"))
        {
            ChatSDKNativeToJSBridge.sendChatMinimizedCallbackToJS();
            showMaximizeButton();
        }
        self.callback.sendonChatMinimizedEvent(new JSONObject());
        maximizedView = false;
    }

    public void orientationChanged()
    {
        if (chatDialog.isShowing())
        {
            chatDialog.dismiss();
            resetMaximizeButtonPosition();
            resetBadgeViewPosition();
        }
        if (maximizedView)
        {
            showDialog();
            if (ApplicationLocationAlerts.getLocationAlertStatus())
            {
                ChatSDKConstants.alert.dismiss();
                (new Handler()).postDelayed(new Runnable() {

                    final ChatSDK this$0;

                    public void run()
                    {
                        ChatSDKConstants.alert.show();
                    }

            
            {
                this$0 = ChatSDK.this;
                super();
            }
                }, 400L);
                return;
            }
            break MISSING_BLOCK_LABEL_111;
        }
        try
        {
            resetMaximizeButtonPosition();
            resetBadgeViewPosition();
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString((new StringBuilder("{'Error':'")).append(exception).append("'}").toString()));
        }
    }

    public void setChatEventsListener(ChatSDKEventsListener chatsdkeventslistener)
    {
        self.callback.setChatEventsListener(chatsdkeventslistener);
    }

    public void showDialog()
    {
        getWindowParam();
        GetDeviceInch();
        if (chatWebView.getParent() != null)
        {
            ((ViewManager)chatWebView.getParent()).removeView(chatWebView);
        }
        Object obj;
        if (maximizedView)
        {
            try
            {
                chatDialog.dismiss();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((Exception) (obj)).printStackTrace();
                obj = new ChatSDKError(ChatSDKErrorCodes.ChatSDKUnknownError);
                self.callback.sendonChatErrorEvent(((ChatSDKError) (obj)));
            }
        }
        chatDialog = new Dialog(activity, 0x1030009);
        chatDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        obj = new android.view.WindowManager.LayoutParams();
        ((android.view.WindowManager.LayoutParams) (obj)).copyFrom(chatDialog.getWindow().getAttributes());
        if (screenInches >= 6.5D)
        {
            if (width > height)
            {
                get_landscape_padding_parameters();
                get_landscape_parameters();
                obj.width = (width * (int)width_landscape) / 100;
                obj.height = (height * (int)height_landscape) / 100;
                obj.x = (int)padding_left_landscape;
                obj.y = (int)padding_top_landscape;
            } else
            {
                get_portrait_padding_parameters();
                get_portrait_parameters();
                obj.height = (height * (int)height_portrait) / 100;
                obj.width = (width * (int)width_portrait) / 100;
                obj.x = (int)padding_left_portrait;
                obj.y = (int)padding_top_portrait;
            }
        }
        chatDialog.getWindow().setAttributes(((android.view.WindowManager.LayoutParams) (obj)));
        if (!ChatSDKResources.ANIMATION_TYPE.equalsIgnoreCase("left-right")) goto _L2; else goto _L1
_L1:
        chatDialog.getWindow().getAttributes().windowAnimations = getSDKInstance().activity.getResources().getIdentifier("chatAnimation_left_right", "style", self.activity.getApplicationContext().getPackageName());
_L3:
        chatDialog.requestWindowFeature(1);
        chatDialog.setContentView(chatWebView);
        chatDialog.setCancelable(false);
        chatDialog.show();
        maximizedView = true;
        return;
_L2:
        Exception exception;
label0:
        {
            if (!ChatSDKResources.ANIMATION_TYPE.equalsIgnoreCase("right-left"))
            {
                break label0;
            }
            chatDialog.getWindow().getAttributes().windowAnimations = getSDKInstance().activity.getResources().getIdentifier("chatAnimation_right_left", "style", self.activity.getApplicationContext().getPackageName());
        }
          goto _L3
label1:
        {
            if (!ChatSDKResources.ANIMATION_TYPE.equalsIgnoreCase("top-bottom"))
            {
                break label1;
            }
            chatDialog.getWindow().getAttributes().windowAnimations = getSDKInstance().activity.getResources().getIdentifier("chatAnimation_top_bottom", "style", self.activity.getApplicationContext().getPackageName());
        }
          goto _L3
label2:
        {
            if (!ChatSDKResources.ANIMATION_TYPE.equalsIgnoreCase("bottom-top") && !ChatSDKResources.ANIMATION_TYPE.equalsIgnoreCase(""))
            {
                break label2;
            }
            chatDialog.getWindow().getAttributes().windowAnimations = getSDKInstance().activity.getResources().getIdentifier("chatAnimation_bottom_top", "style", self.activity.getApplicationContext().getPackageName());
        }
          goto _L3
label3:
        {
            if (!ChatSDKResources.ANIMATION_TYPE.equalsIgnoreCase("none"))
            {
                break label3;
            }
            chatDialog.getWindow().getAttributes().windowAnimations = 0;
        }
          goto _L3
        try
        {
            chatDialog.getWindow().getAttributes().windowAnimations = 0;
            ChatSDKError chatsdkerror = new ChatSDKError(ChatSDKErrorCodes.ChatSDKInvalidParameterError);
            self.callback.sendonChatErrorEvent(chatsdkerror);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            exception.printStackTrace();
            ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString((new StringBuilder("{'Error':'")).append(exception).append("'}").toString()));
            return;
        }
          goto _L3
    }

    public void startChat(JSONObject jsonobject, Activity activity1, JSONObject jsonobject1, boolean flag)
    {
        isAppDeveloperWantToAccessLocationService = flag;
        ApplicationLocationAlerts.setLocationAlertShowingOrNot(false);
        self.activity = activity1;
        self.queueIdFromAppDeveloper = jsonobject1;
        if (ChatSDKResources.isXMLValid())
        {
            self.contextInfo = jsonobject;
            chatWebView = ChatSDKWebView.getInstance(activity1);
            if (buttonLayout == null)
            {
                buttonLayout = new LinearLayout(activity1);
                maximizeButton = new ChatSDKMaximizeButton(activity1);
                maximizeButton.setBackgroundColor(Color.parseColor(ChatSDKResources.MAXIMIZE_BUTTON_BACKGROUND));
                maximizeButton.setTextColor(Color.parseColor(ChatSDKResources.MAXIMIZE_BUTTON_TEXTCOLOR));
                maximizeButton.setText("  Chat");
                maximizeButton.setTextSize(18F);
                maximizeButton.setGravity(16);
                buttonLayoutParams = new android.widget.LinearLayout.LayoutParams(ChatSDKUtil.getMaximizeButtonWidth(), ChatSDKUtil.getMaximizeButtonHeight());
                buttonLayoutParams.setMargins(ChatSDKUtil.getMarginParams()[0], ChatSDKUtil.getMarginParams()[1], ChatSDKUtil.getMarginParams()[2], ChatSDKUtil.getMarginParams()[3]);
                maximizeButton.setOnClickListener(new android.view.View.OnClickListener() {

                    final ChatSDK this$0;

                    public void onClick(View view)
                    {
                        maximizeChat();
                        maximizeButton.setClickable(false);
                        (new Handler()).postDelayed(new Runnable() {

                            final _cls1 this$1;

                            public void run()
                            {
                                maximizeButton.setClickable(true);
                            }

            
            {
                this$1 = _cls1.this;
                super();
            }
                        }, 500L);
                    }


            
            {
                this$0 = ChatSDK.this;
                super();
            }
                });
                buttonLayout.addView(maximizeButton, buttonLayoutParams);
            }
        }
        if (badgeLayout == null)
        {
            makeNotifView();
            return;
        } else
        {
            jsonobject = new ChatSDKError(ChatSDKErrorCodes.ChatSDKInvalidParameterError);
            self.callback.sendonChatErrorEvent(jsonobject);
            return;
        }
    }

    public void uploadFile(int i, int j, Intent intent)
    {
        ChatSDKWebView.getInstance(null).onActivityResult(i, j, intent);
    }









    private class getXmlData extends AsyncTask
    {

        final ChatSDK this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient String doInBackground(String as[])
        {
            as = ChatSDKResources.Chatsdk_Config_URL;
            try
            {
                as = EntityUtils.toString(p.a(new DefaultHttpClient(new BasicHttpParams()), new HttpGet(as)).getEntity());
                DocumentBuilder documentbuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                InputSource inputsource = new InputSource();
                inputsource.setCharacterStream(new StringReader(as));
                ChatSDK.documentDataForReturn = documentbuilder.parse(inputsource);
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                as.printStackTrace();
            }
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            ChatSDK.self.callback.sendonQueueIdParamRetrievalFinished();
            if (!ChatSDKResources.XML_DATA_LOADER_DIALOG.equalsIgnoreCase("false"))
            {
                try
                {
                    if (progressDialog.isShowing())
                    {
                        progressDialog.dismiss();
                    }
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    Log.e("ERROR dismissing progress dialog", "Please check that the activity used to initialize the dialog is still active and its finish() hasnt been called.");
                    progressDialog = null;
                }
            }
            if (ChatSDK.documentDataForReturn != null)
            {
                ChatSDK.contactList = ChatSDK.documentDataForReturn.getElementsByTagName("CheckAvailability");
                int i = 0;
                do
                {
                    if (i >= ChatSDK.contactList.getLength())
                    {
                        checkAgentAvailability();
                        return;
                    }
                    s = ChatSDK.contactList.item(i);
                    if (s.getNodeType() == 1)
                    {
                        s = (Element)s;
                        ChatSDK.queue = s.getElementsByTagName("queue").item(0).getTextContent();
                        ChatSDK.url = s.getElementsByTagName("url").item(0).getTextContent();
                    }
                    queueIdAndUrl.put(ChatSDK.queue, ChatSDK.url);
                    try
                    {
                        s = queueIdFromAppDeveloper.get("queueId").toString();
                        ChatSDK.queueFromServerData = (String)queueIdAndUrl.get(s);
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s)
                    {
                        s.printStackTrace();
                        ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString((new StringBuilder("{'Error':'")).append(s).append("'}").toString()));
                    }
                    i++;
                } while (true);
            } else
            {
                Log.d(ChatSDK.TAG, "oops  documentDataForReturn is null ");
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            ChatSDK.self.callback.sendonQueueIdParamRetrievalStarted();
            if (ChatSDKResources.XML_DATA_LOADER_DIALOG.equalsIgnoreCase("false"))
            {
                break MISSING_BLOCK_LABEL_78;
            }
            progressDialog = new ProgressDialog(ChatSDK.self.activity);
            progressDialog.setMessage("Please wait...");
            progressDialog.show();
            progressDialog.setCancelable(false);
            return;
            Exception exception;
            exception;
            Log.e("ERROR showing progress dialog", "Please check the activity used to initialize the dialog is still active and its finish() hasnt been called.");
            return;
        }

        private getXmlData()
        {
            this$0 = ChatSDK.this;
            super();
        }

        getXmlData(getXmlData getxmldata)
        {
            this();
        }
    }

}
