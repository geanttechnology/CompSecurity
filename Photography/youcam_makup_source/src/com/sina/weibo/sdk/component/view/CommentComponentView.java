// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.component.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sina.weibo.sdk.cmd.WbAppActivator;
import com.sina.weibo.sdk.component.WeiboSdkBrowser;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.sina.weibo.sdk.utils.ResourceManager;

public class CommentComponentView extends FrameLayout
{

    private static final String ALREADY_COMMENT_EN = "Comment";
    private static final String ALREADY_COMMENT_ZH_CN = "\u5FAE\u535A\u70ED\u8BC4";
    private static final String ALREADY_COMMENT_ZH_TW = "\u5FAE\u535A\u71B1\u8A55";
    private static final String COMMENT_H5 = "http://widget.weibo.com/distribution/socail_comments_sdk.php";
    private RequestParam mCommentParam;
    private LinearLayout mContentLy;

    public CommentComponentView(Context context)
    {
        super(context);
        init(context);
    }

    public CommentComponentView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init(context);
    }

    public CommentComponentView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init(context);
    }

    private void execAttented()
    {
        WbAppActivator.getInstance(getContext(), mCommentParam.mAppKey).activateApp();
        Object obj = new WidgetRequestParam(getContext());
        ((WidgetRequestParam) (obj)).setUrl("http://widget.weibo.com/distribution/socail_comments_sdk.php");
        ((WidgetRequestParam) (obj)).setSpecifyTitle(ResourceManager.getString(getContext(), "Comment", "\u5FAE\u535A\u70ED\u8BC4", "\u5FAE\u535A\u71B1\u8A55"));
        ((WidgetRequestParam) (obj)).setAppKey(mCommentParam.mAppKey);
        ((WidgetRequestParam) (obj)).setCommentTopic(mCommentParam.mTopic);
        ((WidgetRequestParam) (obj)).setCommentContent(mCommentParam.mContent);
        ((WidgetRequestParam) (obj)).setCommentCategory(mCommentParam.mCategory.getValue());
        ((WidgetRequestParam) (obj)).setAuthListener(mCommentParam.mAuthlistener);
        ((WidgetRequestParam) (obj)).setToken(mCommentParam.mAccessToken);
        obj = ((WidgetRequestParam) (obj)).createRequestParamBundle();
        Intent intent = new Intent(getContext(), com/sina/weibo/sdk/component/WeiboSdkBrowser);
        intent.putExtras(((android.os.Bundle) (obj)));
        getContext().startActivity(intent);
    }

    private void init(Context context)
    {
        mContentLy = new LinearLayout(context);
        mContentLy.setOrientation(0);
        mContentLy.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
        ImageView imageview = new ImageView(context);
        imageview.setImageDrawable(ResourceManager.getDrawable(context, "sdk_weibo_logo.png"));
        Object obj = new android.widget.LinearLayout.LayoutParams(ResourceManager.dp2px(getContext(), 20), ResourceManager.dp2px(getContext(), 20));
        obj.gravity = 16;
        imageview.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        obj = new TextView(context);
        ((TextView) (obj)).setText(ResourceManager.getString(context, "Comment", "\u5FAE\u535A\u70ED\u8BC4", "\u5FAE\u535A\u71B1\u8A55"));
        ((TextView) (obj)).setTextColor(-32256);
        ((TextView) (obj)).setTextSize(2, 15F);
        ((TextView) (obj)).setIncludeFontPadding(false);
        context = new android.widget.LinearLayout.LayoutParams(-2, -2);
        context.gravity = 16;
        context.leftMargin = ResourceManager.dp2px(getContext(), 4);
        ((TextView) (obj)).setLayoutParams(context);
        mContentLy.addView(imageview);
        mContentLy.addView(((View) (obj)));
        addView(mContentLy);
        ((TextView) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            final CommentComponentView this$0;

            public void onClick(View view)
            {
                execAttented();
            }

            
            {
                this$0 = CommentComponentView.this;
                super();
            }
        });
    }

    public void setCommentParam(RequestParam requestparam)
    {
        mCommentParam = requestparam;
    }


    private class RequestParam
    {

        private String mAccessToken;
        private String mAppKey;
        private WeiboAuthListener mAuthlistener;
        private Category mCategory;
        private String mContent;
        private String mTopic;

        public static RequestParam createRequestParam(String s, String s1, String s2, Category category, WeiboAuthListener weiboauthlistener)
        {
            RequestParam requestparam = new RequestParam();
            requestparam.mAppKey = s;
            requestparam.mTopic = s1;
            requestparam.mContent = s2;
            requestparam.mCategory = category;
            requestparam.mAuthlistener = weiboauthlistener;
            return requestparam;
        }

        public static RequestParam createRequestParam(String s, String s1, String s2, String s3, Category category, WeiboAuthListener weiboauthlistener)
        {
            RequestParam requestparam = new RequestParam();
            requestparam.mAppKey = s;
            requestparam.mAccessToken = s1;
            requestparam.mTopic = s2;
            requestparam.mContent = s3;
            requestparam.mCategory = category;
            requestparam.mAuthlistener = weiboauthlistener;
            return requestparam;
        }







        private RequestParam()
        {
        }
    }


    private class Category extends Enum
    {

        private static final Category ENUM$VALUES[];
        public static final Category MOVIE;
        public static final Category TRAVEL;
        private String mVal;

        public static Category valueOf(String s)
        {
            return (Category)Enum.valueOf(com/sina/weibo/sdk/component/view/CommentComponentView$Category, s);
        }

        public static Category[] values()
        {
            Category acategory[] = ENUM$VALUES;
            int i = acategory.length;
            Category acategory1[] = new Category[i];
            System.arraycopy(acategory, 0, acategory1, 0, i);
            return acategory1;
        }

        public String getValue()
        {
            return mVal;
        }

        static 
        {
            MOVIE = new Category("MOVIE", 0, "1001");
            TRAVEL = new Category("TRAVEL", 1, "1002");
            ENUM$VALUES = (new Category[] {
                MOVIE, TRAVEL
            });
        }

        private Category(String s, int i, String s1)
        {
            super(s, i);
            mVal = s1;
        }
    }

}
