// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.register.mobile;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.sina.weibo.sdk.component.view.ResizeableLayout;
import com.sina.weibo.sdk.component.view.TitleBar;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.NetUtils;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.NetworkHelper;
import com.sina.weibo.sdk.utils.ResourceManager;
import com.sina.weibo.sdk.utils.UIUtils;
import java.util.Locale;
import org.json.JSONObject;

// Referenced classes of package com.sina.weibo.sdk.register.mobile:
//            SelectCountryActivity

public class MobileRegisterActivity extends Activity
    implements android.view.View.OnClickListener, android.view.View.OnFocusChangeListener, com.sina.weibo.sdk.component.view.ResizeableLayout.SizeChangeListener
{

    private static final String APPKEY_NOT_SET_CN = "\u60A8\u7684app_key\u6CA1\u6709\u8BBE\u7F6E";
    private static final String APPKEY_NOT_SET_EN = "your appkey not set";
    private static final String APPKEY_NOT_SET_TW = "\u60A8\u7684app_key\u6C92\u6709\u8A2D\u7F6E";
    private static final String CANCEL_EN = "Cancel";
    private static final String CANCEL_ZH_CN = "\u53D6\u6D88";
    private static final String CANCEL_ZH_TW = "\u53D6\u6D88";
    private static final String CHINA_CN = "\u4E2D\u56FD";
    private static final String CHINA_EN = "China";
    private static final String CHINA_TW = "\u4E2D\u570B";
    private static final String CODE_LENGTH_CN = "\u4F60\u7684\u9A8C\u8BC1\u7801\u4E0D\u662F6\u4F4D\u6570";
    private static final String CODE_LENGTH_EN = "Your code isn\u2019t 6-digit long";
    private static final String CODE_LENGTH_TW = "\u4F60\u7684\u9A57\u8B49\u78BC\u4E0D\u662F6\u4F4D\u6578";
    private static final int DEFAULT_BG_COLOR = 0xfff2f2f2;
    private static final int DEFAULT_CLEAR_BTN = 22;
    private static final int DEFAULT_TEXT_PADDING = 12;
    private static final int DEFAULT_TIPS_TEXT_SIZE = 13;
    private static final int DEFAULT__RIGHT_TRIANGLE = 13;
    private static final int EMPTY_VIEW_TEXT_COLOR = 0xffbdbdbd;
    private static final int GET_CODE_BTN_ID = 3;
    private static final String GET_CODE_CN = "\u83B7\u53D6\u9A8C\u8BC1\u7801";
    private static final String GET_CODE_EN = "Get code";
    private static final String GET_CODE_TW = "\u7372\u53D6\u9A57\u8B49\u78BC";
    private static final String HELP_INFO_CN = "\u8BF7\u786E\u8BA4\u56FD\u5BB6\u548C\u5730\u533A\u5E76\u586B\u5199\u624B\u673A\u53F7\u7801";
    private static final String HELP_INFO_EN = "Confirm your country/region and enter your mobile number";
    private static final String HELP_INFO_TW = "\u8ACB\u78BA\u8A8D\u570B\u5BB6\u548C\u5730\u5340\u5E76\u586B\u5BEB\u624B\u6A5F\u865F";
    private static final String INPUT_AUTH_CODE_CN = "\u8BF7\u8F93\u5165\u9A8C\u8BC1\u7801";
    private static final String INPUT_AUTH_CODE_EN = "Verification code";
    private static final String INPUT_AUTH_CODE_TW = "\u8ACB\u8F38\u5165\u9A57\u8B49\u78BC";
    private static final String INPUT_PHONE_NUM_CN = "\u8BF7\u8F93\u5165\u624B\u673A\u53F7\u7801";
    private static final String INPUT_PHONE_NUM_EN = "Your mobile number";
    private static final String INPUT_PHONE_NUM_TW = "\u8ACB\u8F38\u5165\u624B\u6A5F\u865F";
    private static final int LINK_TEXT_COLOR = 0xff828282;
    private static final int MIAN_LINK_TEXT_COLOR = 0xff507daf;
    private static final String NETWORK_ERROR_CN = "\u60A8\u7684\u7F51\u7EDC\u4E0D\u53EF\u7528\uFF0C\u8BF7\u7A0D\u540E";
    private static final String NETWORK_ERROR_EN = "your network is  disabled  try again later";
    private static final String NETWORK_ERROR_TW = "\u60A8\u7684\u7DB2\u7D61\u4E0D\u53EF\u7528\uFF0C\u8ACB\u7A0D\u5F8C";
    private static final String OK_EN = "OK";
    private static final String OK_ZH_CN = "\u786E\u5B9A";
    private static final String OK_ZH_TW = "\u78BA\u5B9A";
    private static final String PHONE_ERROR_CN = "\u60A8\u7684\u624B\u673A\u53F7\u4E0D\u662F11\u4F4D\u6570";
    private static final String PHONE_ERROR_EN = "Your phone number isn\u2019t 11-digit long";
    private static final String PHONE_ERROR_TW = "\u60A8\u7684\u624B\u6A5F\u865F\u4E0D\u662F11\u4F4D\u6578";
    private static final int PHONE_NUM_CLEAR_BTN_ID = 4;
    public static final String REGISTER_TITLE = "register_title";
    private static final int RESIZEABLE_INPUTMETHODHIDE = 0;
    private static final int RESIZEABLE_INPUTMETHODSHOW = 1;
    public static final String RESPONSE_EXPIRES = "expires";
    public static final String RESPONSE_OAUTH_TOKEN = "oauth_token";
    private static final int SELECT_COUNTRY_REQUEST_CODE = 0;
    private static final String SEND_MSG = "http://api.weibo.com/oauth2/sms_authorize/send";
    private static final String SEND_SUBMIT = "http://api.weibo.com/oauth2/sms_authorize/submit";
    private static final String SERVER_ERROR_CN = "\u670D\u52A1\u5668\u5FD9,\u8BF7\u7A0D\u540E\u518D\u8BD5";
    private static final String SERVER_ERROR_EN = "the server is busy, please  wait";
    private static final String SERVER_ERROR_TW = "\u670D\u52D9\u5668\u5FD9,\u8ACB\u7A0D\u5F8C\u518D\u8A66";
    private static final String SINA_NOTICE_EN = "By clicking ok, you hereby agree to Weibo Online Service Agreement and Privacy Policy";
    private static final String SINA_NOTICE_ZH_CN = "\u70B9\u51FB\u201C\u786E\u5B9A\u201D\u8868\u793A\u4F60\u540C\u610F\u670D\u52A1\u4F7F\u7528\u534F\u8BAE\u548C\u9690\u79C1\u6761\u6B3E\u3002";
    private static final String SINA_NOTICE_ZH_TW = "\u9EDE\u64CA\u201C\u78BA\u5B9A\u201D\u6A19\u793A\u4F60\u540C\u610F\u670D\u52D9\u4F7F\u7528\u5354\u8B70\u548C\u96B1\u79C1\u689D\u6B3E\u3002";
    private static final String SINA_PRIVATE_URL = "http://m.weibo.cn/reg/privacyagreement?from=h5&wm=3349";
    private static final String SINA_PROTOCOL_URL = "http://weibo.cn/dpool/ttt/h5/regagreement.php?from=h5";
    private static final String SINA_SERVICE_EN = "Service By Sina WeiBo";
    private static final String SINA_SERVICE_ZH_CN = "\u6B64\u670D\u52A1\u7531\u5FAE\u535A\u63D0\u4F9B";
    private static final String SINA_SERVICE_ZH_TW = "\u6B64\u670D\u52D9\u7531\u5FAE\u535A\u63D0\u4F9B";
    private static final String TAG = com/sina/weibo/sdk/register/mobile/MobileRegisterActivity.getName();
    private static final int TITLE_BAR_ID = 1;
    private static final String TITLE_CN = "\u9A8C\u8BC1\u7801\u767B\u5F55";
    private static final String TITLE_EN = "Login";
    private static final String TITLE_TW = "\u9A57\u8B49\u78BC\u767B\u9304";
    private static final int TRIANGLE_ID = 2;
    private static final String WAIT_CN = "\u6B63\u5728\u5904\u7406\u4E2D.....";
    private static final String WAIT_EN = "please wait .... ";
    private static final String WAIT_TW = "\u6B63\u5728\u8655\u7406\u4E2D.....";
    private String cfrom;
    private String mAppkey;
    private Button mBtnRegist;
    private EditText mCheckCode;
    private CountDownTimer mCountDownTimer;
    private TextView mCountryCode;
    private String mCountryCodeStr;
    private RelativeLayout mCountryLayout;
    private TextView mCountryName;
    private String mCountryNameStr;
    private Button mGetCodeBtn;
    private TextView mInfoText;
    private InputHandler mInputHandler;
    private String mKeyHash;
    private ProgressDialog mLoadingDlg;
    private int mMaxHeight;
    private String mPackageName;
    private EditText mPhoneNum;
    private ImageView mPhoneNumClearBtn;
    private ScrollView mRegistScrollview;
    private LinearLayout mRegiter_llt;
    private String mSpecifyTitle;
    private TextView mTips;
    private TitleBar titleBar;

    public MobileRegisterActivity()
    {
        mInputHandler = new InputHandler(null);
        mMaxHeight = 0;
    }

    private void disableGetCodeBtn()
    {
        mGetCodeBtn.setEnabled(false);
        mGetCodeBtn.setTextColor(0xffbdbdbd);
    }

    private void disableRegisterBtn()
    {
        mBtnRegist.setTextColor(0x4dffffff);
        mBtnRegist.setEnabled(false);
    }

    private boolean doCheckOnGetMsg(String s)
    {
        if (!NetworkHelper.isNetworkAvailable(this))
        {
            showNetFail();
            return false;
        }
        if (!verifyPhoneNum(s))
        {
            mTips.setVisibility(0);
            mTips.setText(ResourceManager.getString(getApplicationContext(), "Your phone number isn\u2019t 11-digit long", "\u60A8\u7684\u624B\u673A\u53F7\u4E0D\u662F11\u4F4D\u6570", "\u60A8\u7684\u624B\u6A5F\u865F\u4E0D\u662F11\u4F4D\u6578"));
            return false;
        } else
        {
            mTips.setVisibility(4);
            return true;
        }
    }

    private boolean doCheckOnSubmit(String s)
    {
        if (!NetworkHelper.isNetworkAvailable(this))
        {
            showNetFail();
            return false;
        }
        if (verifyCheckCode(s))
        {
            mTips.setVisibility(4);
            return true;
        } else
        {
            mTips.setVisibility(0);
            mTips.setText(ResourceManager.getString(getApplicationContext(), "Your code isn\u2019t 6-digit long", "\u4F60\u7684\u9A8C\u8BC1\u7801\u4E0D\u662F6\u4F4D\u6570", "\u4F60\u7684\u9A57\u8B49\u78BC\u4E0D\u662F6\u4F4D\u6578"));
            UIUtils.showToast(getApplicationContext(), ResourceManager.getString(getApplicationContext(), "Your code isn\u2019t 6-digit long", "\u4F60\u7684\u9A8C\u8BC1\u7801\u4E0D\u662F6\u4F4D\u6570", "\u4F60\u7684\u9A57\u8B49\u78BC\u4E0D\u662F6\u4F4D\u6578"), 0);
            return false;
        }
    }

    private void enableGetCodeBtn()
    {
        mGetCodeBtn.setEnabled(true);
        mGetCodeBtn.setTextColor(0xff507daf);
    }

    private void enableRegisterBtn()
    {
        mBtnRegist.setEnabled(true);
        mBtnRegist.setTextColor(-1);
    }

    private Button genOKBtn()
    {
        Button button = new Button(this);
        button.setBackgroundDrawable(ResourceManager.createStateListDrawable(this, "common_button_big_blue.9.png", "common_button_big_blue_highlighted.9.png", "common_button_big_blue_disable.9.png"));
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-1, ResourceManager.dp2px(this, 46));
        int i = ResourceManager.dp2px(this, 12);
        layoutparams.rightMargin = i;
        layoutparams.leftMargin = i;
        button.setText(ResourceManager.getString(this, "OK", "\u786E\u5B9A", "\u78BA\u5B9A"));
        button.setTextSize(17F);
        button.setLayoutParams(layoutparams);
        return button;
    }

    private TextView genProtocalInfoTv()
    {
        TextView textview = new TextView(this);
        textview.setTextSize(2, 13F);
        Object obj = new android.widget.LinearLayout.LayoutParams(-1, -2);
        obj.topMargin = ResourceManager.dp2px(this, 8);
        obj.leftMargin = ResourceManager.dp2px(this, 12);
        obj.rightMargin = ResourceManager.dp2px(this, 12);
        textview.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        textview.setTextSize(13F);
        textview.setGravity(3);
        textview.setTextColor(0xff828282);
        Object obj1 = ResourceManager.getLanguage();
        obj = "zh_CN";
        int i;
        int j;
        int k;
        int l;
        if (Locale.SIMPLIFIED_CHINESE.equals(obj1))
        {
            obj1 = "\u70B9\u51FB\u201C\u786E\u5B9A\u201D\u8868\u793A\u4F60\u540C\u610F\u670D\u52A1\u4F7F\u7528\u534F\u8BAE\u548C\u9690\u79C1\u6761\u6B3E\u3002";
            l = "\u70B9\u51FB\u201C\u786E\u5B9A\u201D\u8868\u793A\u4F60\u540C\u610F\u670D\u52A1\u4F7F\u7528\u534F\u8BAE\u548C\u9690\u79C1\u6761\u6B3E\u3002".indexOf("\u670D\u52A1\u4F7F\u7528\u534F\u8BAE");
            k = l + "\u670D\u52A1\u4F7F\u7528\u534F\u8BAE".length();
            j = "\u70B9\u51FB\u201C\u786E\u5B9A\u201D\u8868\u793A\u4F60\u540C\u610F\u670D\u52A1\u4F7F\u7528\u534F\u8BAE\u548C\u9690\u79C1\u6761\u6B3E\u3002".indexOf("\u9690\u79C1\u6761\u6B3E");
            i = "\u9690\u79C1\u6761\u6B3E".length() + j;
        } else
        if (Locale.TRADITIONAL_CHINESE.equals(obj1))
        {
            obj1 = "\u9EDE\u64CA\u201C\u78BA\u5B9A\u201D\u6A19\u793A\u4F60\u540C\u610F\u670D\u52D9\u4F7F\u7528\u5354\u8B70\u548C\u96B1\u79C1\u689D\u6B3E\u3002";
            obj = "zh_HK";
            l = "\u9EDE\u64CA\u201C\u78BA\u5B9A\u201D\u6A19\u793A\u4F60\u540C\u610F\u670D\u52D9\u4F7F\u7528\u5354\u8B70\u548C\u96B1\u79C1\u689D\u6B3E\u3002".indexOf("\u670D\u52D9\u4F7F\u7528\u5354\u8B70");
            k = l + "\u670D\u52D9\u4F7F\u7528\u5354\u8B70".length();
            j = "\u9EDE\u64CA\u201C\u78BA\u5B9A\u201D\u6A19\u793A\u4F60\u540C\u610F\u670D\u52D9\u4F7F\u7528\u5354\u8B70\u548C\u96B1\u79C1\u689D\u6B3E\u3002".indexOf("\u96B1\u79C1\u689D\u6B3E");
            i = "\u96B1\u79C1\u689D\u6B3E".length() + j;
        } else
        {
            obj1 = "By clicking ok, you hereby agree to Weibo Online Service Agreement and Privacy Policy";
            obj = "en_US";
            l = "By clicking ok, you hereby agree to Weibo Online Service Agreement and Privacy Policy".indexOf("Service Agreement");
            k = l + "Service Agreement".length();
            j = "By clicking ok, you hereby agree to Weibo Online Service Agreement and Privacy Policy".indexOf("Privacy Policy");
            i = "Privacy Policy".length() + j;
        }
        obj1 = new SpannableStringBuilder(((CharSequence) (obj1)));
        if (l != -1 && k != -1)
        {
            ((Spannable) (obj1)).setSpan(new WBSdkUrlClickSpan(this, (new StringBuilder("http://weibo.cn/dpool/ttt/h5/regagreement.php?from=h5&lang=")).append(((String) (obj))).toString()), l, k, 33);
        }
        if (j != -1 && i != -1)
        {
            ((Spannable) (obj1)).setSpan(new WBSdkUrlClickSpan(this, (new StringBuilder("http://m.weibo.cn/reg/privacyagreement?from=h5&wm=3349&lang=")).append(((String) (obj))).toString()), j, i, 33);
        }
        textview.setText(((CharSequence) (obj1)));
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        textview.setFocusable(false);
        return textview;
    }

    private TextView genSinaServiceTv()
    {
        TextView textview = new TextView(this);
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-1, -2);
        layoutparams.topMargin = ResourceManager.dp2px(this, 12);
        layoutparams.leftMargin = ResourceManager.dp2px(this, 12);
        textview.setLayoutParams(layoutparams);
        textview.setTextSize(13F);
        textview.setGravity(3);
        textview.setTextColor(0xff828282);
        textview.setText(ResourceManager.getString(this, "Service By Sina WeiBo", "\u6B64\u670D\u52A1\u7531\u5FAE\u535A\u63D0\u4F9B", "\u6B64\u670D\u52D9\u7531\u5FAE\u535A\u63D0\u4F9B"));
        return textview;
    }

    private void initLoadingDlg()
    {
        mLoadingDlg = new ProgressDialog(this);
        mLoadingDlg.setCanceledOnTouchOutside(false);
        mLoadingDlg.requestWindowFeature(1);
        mLoadingDlg.setMessage(ResourceManager.getString(this, "please wait .... ", "\u6B63\u5728\u5904\u7406\u4E2D.....", "\u6B63\u5728\u8655\u7406\u4E2D....."));
    }

    private void initView()
    {
        ResizeableLayout resizeablelayout = new ResizeableLayout(this);
        resizeablelayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        resizeablelayout.setBackgroundColor(0xfff2f2f2);
        titleBar = new TitleBar(this);
        titleBar.setId(1);
        titleBar.setLeftBtnText(ResourceManager.getString(this, "Cancel", "\u53D6\u6D88", "\u53D6\u6D88"));
        titleBar.setTitleBarText(mSpecifyTitle);
        titleBar.setTitleBarClickListener(new com.sina.weibo.sdk.component.view.TitleBar.ListenerOnTitleBtnClicked() {

            final MobileRegisterActivity this$0;

            public void onLeftBtnClicked()
            {
                setResult(0);
                finish();
            }

            
            {
                this$0 = MobileRegisterActivity.this;
                super();
            }
        });
        resizeablelayout.addView(titleBar);
        Object obj = new View(this);
        Object obj1 = new android.widget.RelativeLayout.LayoutParams(-1, ResourceManager.dp2px(this, 2));
        ((View) (obj)).setBackgroundDrawable(ResourceManager.getNinePatchDrawable(this, "weibosdk_common_shadow_top.9.png"));
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(3, 1);
        ((View) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        resizeablelayout.addView(((View) (obj)));
        mRegistScrollview = new ScrollView(this);
        obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        obj.topMargin = ResourceManager.dp2px(this, 47);
        mRegistScrollview.setBackgroundColor(0xfff2f2f2);
        mRegistScrollview.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        mRegiter_llt = new LinearLayout(this);
        obj = new android.widget.LinearLayout.LayoutParams(-1, -2);
        mRegiter_llt.setOrientation(1);
        mRegiter_llt.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        mInfoText = new TextView(this);
        mInfoText.setTextSize(2, 13F);
        mInfoText.setHeight(ResourceManager.dp2px(this, 44));
        mInfoText.setGravity(17);
        mInfoText.setTextColor(0xff828282);
        mInfoText.setText(ResourceManager.getString(this, "Confirm your country/region and enter your mobile number", "\u8BF7\u786E\u8BA4\u56FD\u5BB6\u548C\u5730\u533A\u5E76\u586B\u5199\u624B\u673A\u53F7\u7801", "\u8ACB\u78BA\u8A8D\u570B\u5BB6\u548C\u5730\u5340\u5E76\u586B\u5BEB\u624B\u6A5F\u865F"));
        mInfoText.setFocusable(true);
        mInfoText.setFocusableInTouchMode(true);
        mRegiter_llt.addView(mInfoText);
        mCountryLayout = new RelativeLayout(this);
        obj = new android.widget.RelativeLayout.LayoutParams(-1, ResourceManager.dp2px(this, 48));
        mCountryLayout.setBackgroundDrawable(ResourceManager.createStateListDrawable(this, "login_country_background.9.png", "login_country_background_highlighted.9.png"));
        mCountryLayout.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        mCountryCode = new TextView(this);
        mCountryCode.setTextSize(2, 17F);
        mCountryCode.setText("0086");
        mCountryCode.setTextColor(0xff525252);
        mCountryCode.setGravity(3);
        mCountryCode.setGravity(16);
        obj = new android.widget.RelativeLayout.LayoutParams(-2, ResourceManager.dp2px(this, 48));
        obj.leftMargin = ResourceManager.dp2px(this, 15);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(9);
        mCountryCode.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        obj = new ImageView(this);
        ((ImageView) (obj)).setId(2);
        ((ImageView) (obj)).setImageDrawable(ResourceManager.getDrawable(this, "triangle.png"));
        obj1 = new android.widget.RelativeLayout.LayoutParams(ResourceManager.dp2px(this, 13), ResourceManager.dp2px(this, 13));
        obj1.rightMargin = ResourceManager.dp2px(this, 15);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(11);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(15);
        ((ImageView) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        mCountryName = new TextView(this);
        mCountryName.setTextSize(2, 17F);
        mCountryName.setTextColor(0xff525252);
        mCountryName.setText(mCountryNameStr);
        mCountryName.setGravity(16);
        obj1 = new android.widget.RelativeLayout.LayoutParams(-2, ResourceManager.dp2px(this, 48));
        obj1.rightMargin = ResourceManager.dp2px(this, 118);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(0, 2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(15);
        mCountryName.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        mCountryLayout.addView(mCountryCode);
        mCountryLayout.addView(mCountryName);
        mCountryLayout.addView(((View) (obj)));
        mRegiter_llt.addView(mCountryLayout);
        obj = new LinearLayout(this);
        obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
        obj1.topMargin = ResourceManager.dp2px(this, 10);
        ((LinearLayout) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        ((LinearLayout) (obj)).setOrientation(1);
        obj1 = new RelativeLayout(this);
        Object obj2 = new android.widget.LinearLayout.LayoutParams(-1, ResourceManager.dp2px(this, 50));
        obj2.gravity = 16;
        ((RelativeLayout) (obj1)).setBackgroundDrawable(ResourceManager.getNinePatchDrawable(this, "login_top_background.9.png"));
        ((RelativeLayout) (obj1)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
        mPhoneNumClearBtn = new ImageView(this);
        mPhoneNumClearBtn.setId(4);
        mPhoneNumClearBtn.setImageDrawable(ResourceManager.createStateListDrawable(this, "search_clear_btn_normal.png", "search_clear_btn_down.png"));
        obj2 = new android.widget.RelativeLayout.LayoutParams(ResourceManager.dp2px(this, 22), ResourceManager.dp2px(this, 22));
        obj2.rightMargin = ResourceManager.dp2px(this, 15);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(11);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(15);
        mPhoneNumClearBtn.setVisibility(4);
        mPhoneNumClearBtn.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
        ((RelativeLayout) (obj1)).addView(mPhoneNumClearBtn);
        mPhoneNum = new EditText(this);
        mPhoneNum.setTextSize(2, 16F);
        mPhoneNum.setTextColor(0xff000000);
        mPhoneNum.setHint(ResourceManager.getString(this, "Your mobile number", "\u8BF7\u8F93\u5165\u624B\u673A\u53F7\u7801", "\u8ACB\u8F38\u5165\u624B\u6A5F\u865F"));
        mPhoneNum.setHintTextColor(0xffbdbdbd);
        mPhoneNum.setBackgroundDrawable(null);
        mPhoneNum.setSelected(false);
        obj2 = new android.widget.RelativeLayout.LayoutParams(-1, ResourceManager.dp2px(this, 50));
        obj2.topMargin = ResourceManager.dp2px(this, 0);
        obj2.bottomMargin = ResourceManager.dp2px(this, 0);
        obj2.leftMargin = ResourceManager.dp2px(this, 0);
        obj2.rightMargin = ResourceManager.dp2px(this, 0);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(0, 4);
        mPhoneNum.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
        ((RelativeLayout) (obj1)).addView(mPhoneNum);
        obj2 = new RelativeLayout(this);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, ResourceManager.dp2px(this, 50));
        ((RelativeLayout) (obj2)).setBackgroundDrawable(ResourceManager.getNinePatchDrawable(this, "login_bottom_background.9.png"));
        ((RelativeLayout) (obj2)).setLayoutParams(layoutparams);
        mGetCodeBtn = new Button(this);
        mGetCodeBtn.setId(3);
        mGetCodeBtn.setBackgroundDrawable(ResourceManager.createStateListDrawable(this, "get_code_button.9.png", "get_code_button_highlighted.9.png"));
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, ResourceManager.dp2px(this, 29));
        layoutparams.rightMargin = ResourceManager.dp2px(this, 12);
        layoutparams.addRule(11);
        layoutparams.addRule(15);
        mGetCodeBtn.setPadding(18, 0, 18, 0);
        mGetCodeBtn.setLayoutParams(layoutparams);
        mGetCodeBtn.setText(ResourceManager.getString(this, "Get code", "\u83B7\u53D6\u9A8C\u8BC1\u7801", "\u7372\u53D6\u9A57\u8B49\u78BC"));
        mGetCodeBtn.setTextSize(15F);
        enableGetCodeBtn();
        ((RelativeLayout) (obj2)).addView(mGetCodeBtn);
        mCheckCode = new EditText(this);
        mCheckCode.setTextSize(2, 16F);
        mCheckCode.setTextColor(0xff000000);
        mCheckCode.setHintTextColor(0xffbdbdbd);
        mCheckCode.setHint(ResourceManager.getString(this, "Verification code", "\u8BF7\u8F93\u5165\u9A8C\u8BC1\u7801", "\u8ACB\u8F38\u5165\u9A57\u8B49\u78BC"));
        mCheckCode.setBackgroundDrawable(null);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, ResourceManager.dp2px(this, 48));
        layoutparams.addRule(0, 3);
        mCheckCode.setLayoutParams(layoutparams);
        ((RelativeLayout) (obj2)).addView(mCheckCode);
        ((LinearLayout) (obj)).addView(((View) (obj1)));
        ((LinearLayout) (obj)).addView(((View) (obj2)));
        mRegiter_llt.addView(((View) (obj)));
        mGetCodeBtn.setOnClickListener(this);
        mTips = new TextView(this);
        mTips.setTextSize(2, 13F);
        mTips.setTextColor(0xffe14123);
        mTips.setText("");
        mTips.setVisibility(4);
        obj = new android.widget.LinearLayout.LayoutParams(-1, ResourceManager.dp2px(this, 36));
        obj.leftMargin = ResourceManager.dp2px(this, 12);
        mTips.setGravity(16);
        mTips.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        mRegiter_llt.addView(mTips);
        mBtnRegist = genOKBtn();
        disableRegisterBtn();
        mRegiter_llt.addView(mBtnRegist);
        obj = genSinaServiceTv();
        obj1 = genProtocalInfoTv();
        mRegiter_llt.addView(((View) (obj)));
        mRegiter_llt.addView(((View) (obj1)));
        mRegistScrollview.addView(mRegiter_llt);
        resizeablelayout.addView(mRegistScrollview);
        initLoadingDlg();
        mPhoneNum.setInputType(2);
        mPhoneNum.addTextChangedListener(new PhoneNumTextWatcher(null));
        mCheckCode.setInputType(2);
        mCheckCode.addTextChangedListener(new CodeTextWatcher(null));
        mPhoneNumClearBtn.setOnClickListener(this);
        mPhoneNum.setOnFocusChangeListener(this);
        mBtnRegist.setOnClickListener(this);
        mCountryLayout.setOnClickListener(this);
        resizeablelayout.setSizeChangeListener(this);
        setContentView(resizeablelayout);
    }

    private void showNetFail()
    {
        UIUtils.showToast(getApplicationContext(), ResourceManager.getString(getApplicationContext(), "your network is  disabled  try again later", "\u60A8\u7684\u7F51\u7EDC\u4E0D\u53EF\u7528\uFF0C\u8BF7\u7A0D\u540E", "\u60A8\u7684\u7DB2\u7D61\u4E0D\u53EF\u7528\uFF0C\u8ACB\u7A0D\u5F8C"), 0);
    }

    private boolean verifyCheckCode(String s)
    {
        return !TextUtils.isEmpty(s) && s.length() == 6;
    }

    private boolean verifyPhoneNum(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            if ("0086".equals(mCountryCodeStr))
            {
                if (s.trim().length() == 11)
                {
                    return true;
                }
            } else
            {
                return true;
            }
        }
        return false;
    }

    public void dismiss()
    {
        if (mLoadingDlg != null && mLoadingDlg.isShowing())
        {
            mLoadingDlg.dismiss();
        }
    }

    public void getMsg(String s, String s1)
    {
        WeiboParameters weiboparameters = new WeiboParameters(mAppkey);
        weiboparameters.put("appkey", mAppkey);
        weiboparameters.put("packagename", mPackageName);
        weiboparameters.put("key_hash", mKeyHash);
        if (!"0086".equals(s1))
        {
            s = (new StringBuilder(String.valueOf(s1))).append(s).toString();
        }
        weiboparameters.put("phone", s);
        weiboparameters.put("version", "0031205000");
        NetUtils.internalHttpRequest(this, "http://api.weibo.com/oauth2/sms_authorize/send", weiboparameters, "GET", new RequestListener() {

            final MobileRegisterActivity this$0;

            public void onComplete(String s2)
            {
                LogUtil.d(MobileRegisterActivity.TAG, (new StringBuilder("get onComplete : ")).append(s2).toString());
                if (s2 == null)
                {
                    break MISSING_BLOCK_LABEL_51;
                }
                s2 = new JSONObject(s2);
                cfrom = (String)s2.get("cfrom");
                return;
                s2;
                s2.printStackTrace();
                return;
            }

            public void onWeiboException(WeiboException weiboexception)
            {
                String s2;
                LogUtil.d(MobileRegisterActivity.TAG, (new StringBuilder("get onWeiboException ")).append(weiboexception.getMessage()).toString());
                s2 = ResourceManager.getString(getApplicationContext(), "the server is busy, please  wait", "\u670D\u52A1\u5668\u5FD9,\u8BF7\u7A0D\u540E\u518D\u8BD5", "\u670D\u52D9\u5668\u5FD9,\u8ACB\u7A0D\u5F8C\u518D\u8A66");
                JSONObject jsonobject = new JSONObject(weiboexception.getMessage());
                weiboexception = s2;
                try
                {
                    if (!TextUtils.isEmpty(jsonobject.optString("error_description")))
                    {
                        weiboexception = jsonobject.optString("error_description");
                    }
                }
                // Misplaced declaration of an exception variable
                catch (WeiboException weiboexception)
                {
                    weiboexception.printStackTrace();
                    weiboexception = s2;
                }
                UIUtils.showToast(getApplicationContext(), weiboexception, 1);
                return;
            }

            
            {
                this$0 = MobileRegisterActivity.this;
                super();
            }
        });
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        i;
        JVM INSTR tableswitch 0 0: default 28
    //                   0 29;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (intent != null)
        {
            mCountryCodeStr = intent.getStringExtra("code");
            mCountryNameStr = intent.getStringExtra("name");
            mCountryCode.setText(mCountryCodeStr);
            mCountryName.setText(mCountryNameStr);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onClick(View view)
    {
        if (view != mGetCodeBtn) goto _L2; else goto _L1
_L1:
        view = mPhoneNum.getText().toString();
        String s = mCountryCode.getText().toString();
        if (doCheckOnGetMsg(view))
        {
            mCountDownTimer.start();
            disableGetCodeBtn();
            getMsg(view, s);
        }
_L4:
        return;
_L2:
        String s1;
        if (view == mPhoneNumClearBtn)
        {
            mPhoneNum.setText("");
            return;
        }
        if (view != mBtnRegist)
        {
            continue; /* Loop/switch isn't completed */
        }
        view = mPhoneNum.getText().toString();
        s1 = mCheckCode.getText().toString();
        if (!doCheckOnSubmit(s1)) goto _L4; else goto _L3
_L3:
        submit(view, s1);
        return;
        if (view != mCountryLayout) goto _L4; else goto _L5
_L5:
        mTips.setVisibility(4);
        view = new Intent();
        view.setClass(this, com/sina/weibo/sdk/register/mobile/SelectCountryActivity);
        startActivityForResult(view, 0);
        return;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent().getExtras();
        if (bundle == null)
        {
            UIUtils.showToast(getApplicationContext(), "Pass wrong params!!", 0);
            finish();
        }
        mAppkey = bundle.getString("appKey");
        mPackageName = bundle.getString("packagename");
        mKeyHash = bundle.getString("key_hash");
        if (TextUtils.isEmpty(mAppkey))
        {
            UIUtils.showToast(getApplicationContext(), ResourceManager.getString(this, "your appkey not set", "\u60A8\u7684app_key\u6CA1\u6709\u8BBE\u7F6E", "\u60A8\u7684app_key\u6C92\u6709\u8A2D\u7F6E"), 0);
            finish();
        }
        String s = bundle.getString("register_title");
        bundle = s;
        if (TextUtils.isEmpty(s))
        {
            bundle = ResourceManager.getString(this, "Login", "\u9A8C\u8BC1\u7801\u767B\u5F55", "\u9A57\u8B49\u78BC\u767B\u9304");
        }
        mSpecifyTitle = bundle;
        mCountryCodeStr = "0086";
        mCountryNameStr = ResourceManager.getString(this, "China", "\u4E2D\u56FD", "\u4E2D\u570B");
        initView();
        mCountDownTimer = new CountDownTimer(60000L, 1000L) {

            final MobileRegisterActivity this$0;

            public void onFinish()
            {
                mGetCodeBtn.setText(ResourceManager.getString(getApplicationContext(), "Get code", "\u83B7\u53D6\u9A8C\u8BC1\u7801", "\u7372\u53D6\u9A57\u8B49\u78BC"));
                enableGetCodeBtn();
            }

            public void onTick(long l)
            {
                mGetCodeBtn.setText((new StringBuilder(String.valueOf(ResourceManager.getString(getApplicationContext(), "Get code", "\u83B7\u53D6\u9A8C\u8BC1\u7801", "\u7372\u53D6\u9A57\u8B49\u78BC")))).append("(").append(l / 1000L).append("s)").toString());
            }

            
            {
                this$0 = MobileRegisterActivity.this;
                super(l, l1);
            }
        };
    }

    public void onFocusChange(View view, boolean flag)
    {
label0:
        {
            if (view == mPhoneNum && !flag)
            {
                if (!verifyPhoneNum(mPhoneNum.getText().toString()))
                {
                    break label0;
                }
                mTips.setVisibility(4);
            }
            return;
        }
        mTips.setText(ResourceManager.getString(this, "Your phone number isn\u2019t 11-digit long", "\u60A8\u7684\u624B\u673A\u53F7\u4E0D\u662F11\u4F4D\u6570", "\u60A8\u7684\u624B\u6A5F\u865F\u4E0D\u662F11\u4F4D\u6578"));
        mTips.setVisibility(0);
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            setResult(0);
            finish();
            return true;
        } else
        {
            return super.onKeyUp(i, keyevent);
        }
    }

    public void onSizeChanged(int i, int j, int k, int l)
    {
        DisplayMetrics displaymetrics;
        displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        if (displaymetrics.widthPixels > displaymetrics.heightPixels) goto _L2; else goto _L1
_L1:
        if (mMaxHeight < j)
        {
            i = j;
        } else
        {
            i = mMaxHeight;
        }
        mMaxHeight = i;
        k = 0;
        if (j >= l) goto _L4; else goto _L3
_L3:
        i = 1;
_L6:
        mInputHandler.sendEmptyMessage(i);
_L2:
        return;
_L4:
        if (j > l && j < mMaxHeight)
        {
            i = 1;
        } else
        {
            i = k;
            if (j == l)
            {
                i = k;
                if (j != mMaxHeight)
                {
                    i = 1;
                }
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void submit(final String phoneNum, String s)
    {
        WeiboParameters weiboparameters = new WeiboParameters(mAppkey);
        weiboparameters.put("appkey", mAppkey);
        weiboparameters.put("packagename", mPackageName);
        weiboparameters.put("key_hash", mKeyHash);
        weiboparameters.put("phone", phoneNum);
        weiboparameters.put("version", "0031205000");
        weiboparameters.put("code", s);
        weiboparameters.put("cfrom", cfrom);
        mLoadingDlg.show();
        NetUtils.internalHttpRequest(this, "http://api.weibo.com/oauth2/sms_authorize/submit", weiboparameters, "GET", new RequestListener() {

            final MobileRegisterActivity this$0;
            private final String val$phoneNum;

            public void onComplete(String s1)
            {
                dismiss();
                LogUtil.d(MobileRegisterActivity.TAG, (new StringBuilder("get onComplete : ")).append(s1).toString());
                if (s1 == null)
                {
                    break MISSING_BLOCK_LABEL_126;
                }
                s1 = new JSONObject(s1);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("uid", s1.optString("uid"));
                bundle.putString("phone_num", phoneNum);
                bundle.putString("access_token", s1.optString("oauth_token"));
                bundle.putString("expires_in", s1.optString("expires"));
                intent.putExtras(bundle);
                setResult(-1, intent);
                finish();
                return;
                s1;
                s1.printStackTrace();
                return;
            }

            public void onWeiboException(WeiboException weiboexception)
            {
                String s1;
                LogUtil.d(MobileRegisterActivity.TAG, (new StringBuilder("get onWeiboException ")).append(weiboexception.getMessage()).toString());
                s1 = ResourceManager.getString(getApplicationContext(), "the server is busy, please  wait", "\u670D\u52A1\u5668\u5FD9,\u8BF7\u7A0D\u540E\u518D\u8BD5", "\u670D\u52D9\u5668\u5FD9,\u8ACB\u7A0D\u5F8C\u518D\u8A66");
                JSONObject jsonobject = new JSONObject(weiboexception.getMessage());
                weiboexception = s1;
                try
                {
                    if (!TextUtils.isEmpty(jsonobject.optString("error_description")))
                    {
                        weiboexception = jsonobject.optString("error_description");
                    }
                }
                // Misplaced declaration of an exception variable
                catch (WeiboException weiboexception)
                {
                    weiboexception.printStackTrace();
                    weiboexception = s1;
                }
                mTips.setVisibility(0);
                mTips.setText(weiboexception);
                dismiss();
                return;
            }

            
            {
                this$0 = MobileRegisterActivity.this;
                phoneNum = s;
                super();
            }
        });
    }














    private class InputHandler extends Handler
    {

        final MobileRegisterActivity this$0;

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                return;

            case 0: // '\0'
                mInfoText.setVisibility(0);
                mCountryLayout.setVisibility(0);
                return;

            case 1: // '\001'
                mInfoText.setVisibility(8);
                break;
            }
            mCountryLayout.setVisibility(8);
        }

        private InputHandler()
        {
            this$0 = MobileRegisterActivity.this;
            super();
        }

        InputHandler(InputHandler inputhandler)
        {
            this();
        }
    }


    private class WBSdkUrlClickSpan extends ClickableSpan
    {

        private Context context;
        final MobileRegisterActivity this$0;
        private String url;

        public void onClick(View view)
        {
            view = new Intent(context, com/sina/weibo/sdk/component/WeiboSdkBrowser);
            Bundle bundle = new Bundle();
            bundle.putString("key_url", url);
            view.putExtras(bundle);
            startActivity(view);
        }

        public void updateDrawState(TextPaint textpaint)
        {
            textpaint.setColor(0xff507daf);
            textpaint.setUnderlineText(false);
        }

        public WBSdkUrlClickSpan(Context context1, String s)
        {
            this$0 = MobileRegisterActivity.this;
            super();
            context = context1;
            url = s;
        }
    }


    private class PhoneNumTextWatcher
        implements TextWatcher
    {

        final MobileRegisterActivity this$0;

        public void afterTextChanged(Editable editable)
        {
            if (TextUtils.isEmpty(mPhoneNum.getText().toString()) || TextUtils.isEmpty(mCheckCode.getText().toString()))
            {
                disableRegisterBtn();
                return;
            } else
            {
                enableRegisterBtn();
                return;
            }
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            if (TextUtils.isEmpty(mPhoneNum.getText().toString()))
            {
                mPhoneNumClearBtn.setVisibility(4);
                return;
            } else
            {
                mPhoneNumClearBtn.setVisibility(0);
                return;
            }
        }

        private PhoneNumTextWatcher()
        {
            this$0 = MobileRegisterActivity.this;
            super();
        }

        PhoneNumTextWatcher(PhoneNumTextWatcher phonenumtextwatcher)
        {
            this();
        }
    }


    private class CodeTextWatcher
        implements TextWatcher
    {

        final MobileRegisterActivity this$0;

        public void afterTextChanged(Editable editable)
        {
            if (TextUtils.isEmpty(mPhoneNum.getText().toString()) || TextUtils.isEmpty(mCheckCode.getText().toString()))
            {
                disableRegisterBtn();
                return;
            } else
            {
                enableRegisterBtn();
                return;
            }
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        private CodeTextWatcher()
        {
            this$0 = MobileRegisterActivity.this;
            super();
        }

        CodeTextWatcher(CodeTextWatcher codetextwatcher)
        {
            this();
        }
    }

}
