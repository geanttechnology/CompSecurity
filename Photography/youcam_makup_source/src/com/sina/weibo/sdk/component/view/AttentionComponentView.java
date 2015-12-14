// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.component.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.sina.weibo.sdk.cmd.WbAppActivator;
import com.sina.weibo.sdk.component.WeiboSdkBrowser;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.NetUtils;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.ResourceManager;
import com.sina.weibo.sdk.utils.Utility;
import org.json.JSONException;
import org.json.JSONObject;

public class AttentionComponentView extends FrameLayout
{

    private static final String ALREADY_ATTEND_EN = "Following";
    private static final String ALREADY_ATTEND_ZH_CN = "\u5DF2\u5173\u6CE8";
    private static final String ALREADY_ATTEND_ZH_TW = "\u5DF2\u95DC\u6CE8";
    private static final String ATTEND_EN = "Follow";
    private static final String ATTEND_ZH_CN = "\u5173\u6CE8";
    private static final String ATTEND_ZH_TW = "\u95DC\u6CE8";
    private static final String ATTENTION_H5 = "http://widget.weibo.com/relationship/followsdk.php";
    private static final String FRIENDSHIPS_SHOW_URL = "https://api.weibo.com/2/friendships/show.json";
    private static final String TAG = com/sina/weibo/sdk/component/view/AttentionComponentView.getName();
    private FrameLayout flButton;
    private RequestParam mAttentionParam;
    private TextView mButton;
    private volatile boolean mIsLoadingState;
    private ProgressBar pbLoading;

    public AttentionComponentView(Context context)
    {
        super(context);
        mIsLoadingState = false;
        init(context);
    }

    public AttentionComponentView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mIsLoadingState = false;
        init(context);
    }

    public AttentionComponentView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mIsLoadingState = false;
        init(context);
    }

    private void execAttented()
    {
        Object obj = new WidgetRequestParam(getContext());
        ((WidgetRequestParam) (obj)).setUrl("http://widget.weibo.com/relationship/followsdk.php");
        ((WidgetRequestParam) (obj)).setSpecifyTitle(ResourceManager.getString(getContext(), "Follow", "\u5173\u6CE8", "\u95DC\u6CE8"));
        ((WidgetRequestParam) (obj)).setAppKey(mAttentionParam.mAppKey);
        ((WidgetRequestParam) (obj)).setAttentionFuid(mAttentionParam.mAttentionUid);
        ((WidgetRequestParam) (obj)).setAuthListener(mAttentionParam.mAuthlistener);
        ((WidgetRequestParam) (obj)).setToken(mAttentionParam.mAccessToken);
        ((WidgetRequestParam) (obj)).setWidgetRequestCallback(new com.sina.weibo.sdk.component.WidgetRequestParam.WidgetRequestCallback() {

            final AttentionComponentView this$0;

            public void onWebViewResult(String s)
            {
                s = Utility.parseUri(s).getString("result");
                if (TextUtils.isEmpty(s))
                {
                    break MISSING_BLOCK_LABEL_54;
                }
                long l = Integer.parseInt(s);
                if (l == 1L)
                {
                    try
                    {
                        showFollowButton(true);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s) { }
                    break MISSING_BLOCK_LABEL_54;
                }
                if (l != 0L)
                {
                    break MISSING_BLOCK_LABEL_54;
                }
                showFollowButton(false);
                return;
            }

            
            {
                this$0 = AttentionComponentView.this;
                super();
            }
        });
        obj = ((WidgetRequestParam) (obj)).createRequestParamBundle();
        Intent intent = new Intent(getContext(), com/sina/weibo/sdk/component/WeiboSdkBrowser);
        intent.putExtras(((Bundle) (obj)));
        getContext().startActivity(intent);
    }

    private void init(Context context)
    {
        android.graphics.drawable.StateListDrawable statelistdrawable = ResourceManager.createStateListDrawable(context, "common_button_white.9.png", "common_button_white_highlighted.9.png");
        flButton = new FrameLayout(context);
        flButton.setBackgroundDrawable(statelistdrawable);
        int i = ResourceManager.dp2px(getContext(), 6);
        int j = ResourceManager.dp2px(getContext(), 2);
        int k = ResourceManager.dp2px(getContext(), 6);
        flButton.setPadding(0, i, j, k);
        flButton.setLayoutParams(new android.widget.FrameLayout.LayoutParams(ResourceManager.dp2px(getContext(), 66), -2));
        addView(flButton);
        mButton = new TextView(getContext());
        mButton.setIncludeFontPadding(false);
        mButton.setSingleLine(true);
        mButton.setTextSize(2, 13F);
        context = new android.widget.FrameLayout.LayoutParams(-2, -2);
        context.gravity = 17;
        mButton.setLayoutParams(context);
        flButton.addView(mButton);
        pbLoading = new ProgressBar(getContext(), null, 0x1010079);
        pbLoading.setVisibility(8);
        context = new android.widget.FrameLayout.LayoutParams(-2, -2);
        context.gravity = 17;
        pbLoading.setLayoutParams(context);
        flButton.addView(pbLoading);
        flButton.setOnClickListener(new android.view.View.OnClickListener() {

            final AttentionComponentView this$0;

            public void onClick(View view)
            {
                execAttented();
            }

            
            {
                this$0 = AttentionComponentView.this;
                super();
            }
        });
        showFollowButton(false);
    }

    private void loadAttentionState(RequestParam requestparam)
    {
        if (mIsLoadingState)
        {
            return;
        } else
        {
            WbAppActivator.getInstance(getContext(), requestparam.mAppKey).activateApp();
            mIsLoadingState = true;
            startLoading();
            WeiboParameters weiboparameters = new WeiboParameters(requestparam.mAppKey);
            weiboparameters.put("access_token", requestparam.mAccessToken);
            weiboparameters.put("target_id", requestparam.mAttentionUid);
            weiboparameters.put("target_screen_name", requestparam.mAttentionScreenName);
            NetUtils.internalHttpRequest(getContext(), "https://api.weibo.com/2/friendships/show.json", weiboparameters, "GET", new RequestListener() {

                final AttentionComponentView this$0;

                public void onComplete(String s)
                {
                    LogUtil.d(AttentionComponentView.TAG, (new StringBuilder("json : ")).append(s).toString());
                    try
                    {
                        s = (new JSONObject(s)).optJSONObject("target");
                        getHandler().post(s. new Runnable() {

                            final _cls2 this$1;
                            private final JSONObject val$target;

                            public void run()
                            {
                                if (target != null)
                                {
                                    showFollowButton(target.optBoolean("followed_by", false));
                                }
                                mIsLoadingState = false;
                            }

            
            {
                this$1 = final__pcls2;
                target = JSONObject.this;
                super();
            }
                        });
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s)
                    {
                        return;
                    }
                }

                public void onWeiboException(WeiboException weiboexception)
                {
                    LogUtil.d(AttentionComponentView.TAG, (new StringBuilder("error : ")).append(weiboexception.getMessage()).toString());
                    mIsLoadingState = false;
                }


            
            {
                this$0 = AttentionComponentView.this;
                super();
            }
            });
            return;
        }
    }

    private void requestAsync(Context context, String s, WeiboParameters weiboparameters, String s1, RequestListener requestlistener)
    {
        NetUtils.internalHttpRequest(context, s, weiboparameters, s1, requestlistener);
    }

    private void showFollowButton(boolean flag)
    {
        stopLoading();
        if (flag)
        {
            mButton.setText(ResourceManager.getString(getContext(), "Following", "\u5DF2\u5173\u6CE8", "\u5DF2\u95DC\u6CE8"));
            mButton.setTextColor(0xff333333);
            android.graphics.drawable.Drawable drawable = ResourceManager.getDrawable(getContext(), "timeline_relationship_icon_attention.png");
            mButton.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
            flButton.setEnabled(false);
            return;
        } else
        {
            mButton.setText(ResourceManager.getString(getContext(), "Follow", "\u5173\u6CE8", "\u95DC\u6CE8"));
            mButton.setTextColor(-32256);
            android.graphics.drawable.Drawable drawable1 = ResourceManager.getDrawable(getContext(), "timeline_relationship_icon_addattention.png");
            mButton.setCompoundDrawablesWithIntrinsicBounds(drawable1, null, null, null);
            flButton.setEnabled(true);
            return;
        }
    }

    private void startLoading()
    {
        flButton.setEnabled(false);
        mButton.setVisibility(8);
        pbLoading.setVisibility(0);
    }

    private void stopLoading()
    {
        flButton.setEnabled(true);
        mButton.setVisibility(0);
        pbLoading.setVisibility(8);
    }

    public void setAttentionParam(RequestParam requestparam)
    {
        mAttentionParam = requestparam;
        if (requestparam.hasAuthoriz())
        {
            loadAttentionState(requestparam);
        }
    }






    private class RequestParam
    {

        private String mAccessToken;
        private String mAppKey;
        private String mAttentionScreenName;
        private String mAttentionUid;
        private WeiboAuthListener mAuthlistener;

        public static RequestParam createRequestParam(String s, String s1, String s2, WeiboAuthListener weiboauthlistener)
        {
            RequestParam requestparam = new RequestParam();
            requestparam.mAppKey = s;
            requestparam.mAttentionUid = s1;
            requestparam.mAttentionScreenName = s2;
            requestparam.mAuthlistener = weiboauthlistener;
            return requestparam;
        }

        public static RequestParam createRequestParam(String s, String s1, String s2, String s3, WeiboAuthListener weiboauthlistener)
        {
            RequestParam requestparam = new RequestParam();
            requestparam.mAppKey = s;
            requestparam.mAccessToken = s1;
            requestparam.mAttentionUid = s2;
            requestparam.mAttentionScreenName = s3;
            requestparam.mAuthlistener = weiboauthlistener;
            return requestparam;
        }

        private boolean hasAuthoriz()
        {
            return !TextUtils.isEmpty(mAccessToken);
        }







        private RequestParam()
        {
        }
    }

}
