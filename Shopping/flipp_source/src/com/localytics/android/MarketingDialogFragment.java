// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.y;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.localytics.android:
//            Constants, MarketingMessage, MarketingCallable, JavaScriptClient

public final class MarketingDialogFragment extends y
{

    private static final String AMP_DESCRIPTION = "amp_view";
    private static final String CLOSE_BUTTON_DESCRIPTION = "close_button";
    private static final int CLOSE_BUTTON_ID = 1;
    static final String DIALOG_TAG = "marketing_dialog";
    private static final int OPENING_EXTERNAL = 2;
    private static final int OPENING_INTERNAL = 1;
    private static final int PROTOCOL_UNMATCHED = -1;
    private static final int PROTOCOL_UNRECOGNIZED = -2;
    private static final int WEB_VIEW_ID = 2;
    private static Localytics.InAppMessageDismissButtonLocation dismissButtonLocation;
    private static Bitmap sDismissButtonImage = null;
    private SparseArray mCallbacks;
    private final AtomicBoolean mEnterAnimatable = new AtomicBoolean(true);
    private final AtomicBoolean mExitAnimatable = new AtomicBoolean(true);
    private JavaScriptClient mJavaScriptClient;
    private MarketingDialog mMarketingDialog;
    private MarketingMessage mMarketingMessage;
    private final AtomicBoolean mUploadedViewEvent = new AtomicBoolean(false);

    public MarketingDialogFragment()
    {
    }

    static Localytics.InAppMessageDismissButtonLocation getInAppDismissButtonLocation()
    {
        return dismissButtonLocation;
    }

    private String getValueByQueryKey(String s, URI uri)
    {
        String s1 = uri.getQuery();
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1))
        {
            uri = uri.getQuery().split("[&]");
            int j = uri.length;
            int i = 0;
            while (i < j) 
            {
                String as[] = uri[i].split("[=]");
                if (as[0].compareTo(s) == 0 && 2 == as.length)
                {
                    try
                    {
                        s = URLDecoder.decode(as[1], "UTF-8");
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s)
                    {
                        return null;
                    }
                    return s;
                }
                i++;
            }
        }
        return null;
    }

    private String getValueByQueryKey(String s, URL url)
    {
        try
        {
            s = getValueByQueryKey(s, url.toURI());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    private int handleCustomProtocolRequest(String s, Activity activity)
    {
        s = new Intent("android.intent.action.VIEW", Uri.parse(s));
        if (mMarketingDialog.getContext().getPackageManager().queryIntentActivities(s, 0).size() > 0)
        {
            Localytics.Log.w("[In-app Nav Handler]: An app on this device is registered to handle this protocol scheme. Opening...");
            s.setFlags(0x20000);
            activity.startActivity(s);
            return 2;
        } else
        {
            return -2;
        }
    }

    private int handleCustomProtocolRequest(URL url, Activity activity)
    {
        return handleCustomProtocolRequest(url.toString(), activity);
    }

    private int handleFileProtocolRequest(URL url)
    {
        if (!url.getProtocol().equals("file"))
        {
            return -1;
        } else
        {
            Localytics.Log.w("[In-app Nav Handler]: Displaying content from your local creatives.");
            return 1;
        }
    }

    private int handleHttpProtocolRequest(URL url, Activity activity)
    {
        String s = url.getProtocol();
        if (!s.equals("http") && !s.equals("https"))
        {
            return -1;
        }
        Localytics.Log.w("[In-app Nav Handler]: Handling a request for an external HTTP address.");
        s = getValueByQueryKey("ampExternalOpen", url);
        if (!TextUtils.isEmpty(s) && s.toLowerCase(Locale.US).equals("true"))
        {
            Localytics.Log.w(String.format("[In-app Nav Handler]: Query string hook [%s] set to true. Opening the URL in chrome", new Object[] {
                "ampExternalOpen"
            }));
            url = new Intent("android.intent.action.VIEW", Uri.parse(url.toString()));
            if (mMarketingDialog.getContext().getPackageManager().queryIntentActivities(url, 0).size() > 0)
            {
                activity.startActivity(url);
                return 2;
            }
        }
        Localytics.Log.w("[In-app Nav Handler]: Loading HTTP request inside the current in-app view");
        return 1;
    }

    static MarketingDialogFragment newInstance()
    {
        MarketingDialogFragment marketingdialogfragment = new MarketingDialogFragment();
        marketingdialogfragment.setRetainInstance(true);
        return marketingdialogfragment;
    }

    static void setDismissButtonImage(Bitmap bitmap)
    {
        if (sDismissButtonImage != null)
        {
            sDismissButtonImage.recycle();
        }
        sDismissButtonImage = bitmap;
    }

    static void setInAppDismissButtonLocation(Localytics.InAppMessageDismissButtonLocation inappmessagedismissbuttonlocation)
    {
        dismissButtonLocation = inappmessagedismissbuttonlocation;
    }

    private void tagMarketingActionEventWithAction(String s)
    {
        if (!Constants.isTestModeEnabled())
        {
            if (mUploadedViewEvent.getAndSet(true))
            {
                Localytics.Log.w(String.format("The in-app action for this message has already been set. Ignoring in-app Action: [%s]", new Object[] {
                    s
                }));
                return;
            }
            Object obj = new TreeMap();
            ((TreeMap) (obj)).put("ampAction", s);
            ((TreeMap) (obj)).put("type", "In-App");
            ((TreeMap) (obj)).put("ampCampaignId", mMarketingMessage.get("campaign_id").toString());
            ((TreeMap) (obj)).put("ampCampaign", mMarketingMessage.get("rule_name_non_unique").toString());
            ((TreeMap) (obj)).put("Schema Version - Client", "3");
            s = ((String) (mMarketingMessage.get("schema_version")));
            if (s != null)
            {
                ((TreeMap) (obj)).put("Schema Version - Server", s.toString());
            }
            s = (String)mMarketingMessage.get("ab_test");
            if (!TextUtils.isEmpty(s))
            {
                ((TreeMap) (obj)).put("ampAB", s);
            }
            if (mCallbacks != null)
            {
                s = (MarketingCallable)mCallbacks.get(2);
                if (s != null)
                {
                    s.call(new Object[] {
                        "ampView", obj
                    });
                }
                if (Constants.IS_LOGGING_ENABLED)
                {
                    s = new StringBuilder();
                    java.util.Map.Entry entry;
                    for (obj = ((TreeMap) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); s.append("Key = ").append((String)entry.getKey()).append(", Value = ").append((String)entry.getValue()))
                    {
                        entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                    }

                    Localytics.Log.v(String.format("In-app event tagged successfully.\n   Attributes Dictionary = \n%s", new Object[] {
                        s.toString()
                    }));
                    return;
                }
            }
        }
    }

    private void tagMarketingActionForURL(URI uri)
    {
        String s = getValueByQueryKey("ampAction", uri);
        if (!TextUtils.isEmpty(s))
        {
            Localytics.Log.w(String.format("Attempting to tag event with custom in-app action. [Action: %s]", new Object[] {
                s
            }));
            tagMarketingActionEventWithAction(s);
        } else
        {
            uri = uri.getScheme();
            if (!uri.equals("file") && !uri.equals("http") && !uri.equals("https"))
            {
                tagMarketingActionEventWithAction("click");
                return;
            }
        }
    }

    final void dismissCampaign()
    {
        if (mMarketingDialog != null)
        {
            if (mMarketingMessage != null)
            {
                tagMarketingActionEventWithAction("X");
            }
            mMarketingDialog.dismiss();
        }
    }

    final boolean handleUrl(String s, Activity activity)
    {
        int i;
        boolean flag;
        boolean flag1;
        boolean flag5;
        boolean flag6;
        flag = true;
        flag5 = true;
        flag6 = true;
        flag1 = true;
        i = 0;
        Localytics.Log.w(String.format("[In-app Nav Handler]: Evaluating in-app URL:\n\tURL:%s", new Object[] {
            s
        }));
        if (!s.endsWith("://")) goto _L2; else goto _L1
_L1:
        Object obj = s.substring(0, s.length() - 1);
_L13:
        URL url;
        int j;
        tagMarketingActionForURL(new URI(((String) (obj))));
        url = new URL(((String) (obj)));
        j = handleFileProtocolRequest(url);
        if (j <= 0) goto _L4; else goto _L3
_L3:
        if (j != 2)
        {
            flag1 = false;
        }
        flag = flag1;
        if (j == 2)
        {
            mMarketingDialog.dismissWithAnimation();
            flag = flag1;
        }
_L6:
        return flag;
_L4:
        i = j;
        int k = handleHttpProtocolRequest(url, activity);
        j = k;
        if (j <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        boolean flag2;
        if (j == 2)
        {
            flag2 = flag;
        } else
        {
            flag2 = false;
        }
        flag = flag2;
        if (j == 2)
        {
            mMarketingDialog.dismissWithAnimation();
            return flag2;
        }
        if (true) goto _L6; else goto _L5
_L5:
        i = j;
        k = handleCustomProtocolRequest(url, activity);
        if (k <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        boolean flag3;
        if (k == 2)
        {
            flag3 = flag5;
        } else
        {
            flag3 = false;
        }
        flag = flag3;
        if (k == 2)
        {
            mMarketingDialog.dismissWithAnimation();
            return flag3;
        }
        if (true) goto _L6; else goto _L7
_L7:
        i = k;
        j = k;
        Localytics.Log.w(String.format("[In-app Nav Handler]: Protocol handler scheme not recognized. Attempting to load the URL... [Scheme: %s]", new Object[] {
            url.getProtocol()
        }));
        if (k == 2)
        {
            mMarketingDialog.dismissWithAnimation();
        }
_L8:
        return false;
        obj;
        i = 0;
        obj = s;
_L11:
        j = handleCustomProtocolRequest(((String) (obj)), activity);
label0:
        {
            if (j <= 0)
            {
                break label0;
            }
            boolean flag4;
            if (j == 2)
            {
                flag4 = flag6;
            } else
            {
                flag4 = false;
            }
            flag = flag4;
            if (j == 2)
            {
                mMarketingDialog.dismissWithAnimation();
                return flag4;
            }
        }
          goto _L6
        i = j;
        Localytics.Log.w(String.format("[In-app Nav Handler]: Invalid url %s", new Object[] {
            s
        }));
        i = j;
        mMarketingDialog.dismissWithAnimation();
        if (j == 2)
        {
            mMarketingDialog.dismissWithAnimation();
        }
          goto _L8
        s;
_L10:
        if (i == 2)
        {
            mMarketingDialog.dismissWithAnimation();
        }
        throw s;
        s;
        if (true) goto _L10; else goto _L9
_L9:
        Exception exception;
        exception;
        i = 0;
          goto _L11
        exception;
        i = j;
          goto _L11
_L2:
        obj = s;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public final void onActivityCreated(Bundle bundle)
    {
        Localytics.Log.v("[InAppDialogFragment]: onActivityCreated");
        super.onActivityCreated(bundle);
    }

    public final void onAttach(Activity activity)
    {
        Localytics.Log.v("[InAppDialogFragment]: onAttach");
        super.onAttach(activity);
    }

    public final void onCreate(Bundle bundle)
    {
        Localytics.Log.v("[InAppDialogFragment]: onCreate");
        super.onCreate(bundle);
    }

    public final Dialog onCreateDialog(Bundle bundle)
    {
        Localytics.Log.v("[InAppDialogFragment]: onCreateDialog");
        bundle = new MarketingDialog(getActivity(), 0x103000b);
        mMarketingDialog = bundle;
        return bundle;
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        Localytics.Log.v("[InAppDialogFragment]: onCreateView");
        return super.onCreateView(layoutinflater, viewgroup, bundle);
    }

    public final void onDestroy()
    {
        Localytics.Log.v("[InAppDialogFragment]: onDestroy");
        if (mCallbacks != null)
        {
            MarketingCallable marketingcallable = (MarketingCallable)mCallbacks.get(1);
            if (!Constants.isTestModeEnabled() && marketingcallable != null)
            {
                marketingcallable.call(new Object[] {
                    mMarketingMessage
                });
            }
        }
        super.onDestroy();
    }

    public final void onDestroyView()
    {
        Localytics.Log.v("[InAppDialogFragment]: onDestroyView");
        if (getDialog() != null && getRetainInstance())
        {
            getDialog().setOnDismissListener(null);
        }
        super.onDestroyView();
    }

    public final void onDetach()
    {
        Localytics.Log.v("[InAppDialogFragment]: onDetach");
        super.onDetach();
    }

    public final void onDismiss(DialogInterface dialoginterface)
    {
        Localytics.Log.v("[InAppDialogFragment]: onDismiss");
        try
        {
            if (mMarketingMessage != null)
            {
                tagMarketingActionEventWithAction("X");
            }
        }
        catch (Exception exception)
        {
            Localytics.Log.e("MarketingDialogFragment onDismiss", exception);
        }
        super.onDismiss(dialoginterface);
    }

    public final void onPause()
    {
        Localytics.Log.v("[InAppDialogFragment]: onPause");
        super.onPause();
    }

    public final void onResume()
    {
        Localytics.Log.v("[InAppDialogFragment]: onResume");
        super.onResume();
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        Localytics.Log.v("[InAppDialogFragment]: onSaveInstanceState");
        super.onSaveInstanceState(bundle);
    }

    public final void onStart()
    {
        Localytics.Log.v("[InAppDialogFragment]: onStart");
        super.onStart();
    }

    public final void onStop()
    {
        Localytics.Log.v("[InAppDialogFragment]: onStop");
        super.onStop();
    }

    public final void onViewStateRestored(Bundle bundle)
    {
        Localytics.Log.v("[InAppDialogFragment]: onViewStateRestored");
        super.onViewStateRestored(bundle);
    }

    public final MarketingDialogFragment setCallbacks(SparseArray sparsearray)
    {
        mCallbacks = sparsearray;
        return this;
    }

    final MarketingDialogFragment setData(MarketingMessage marketingmessage)
    {
        mMarketingMessage = marketingmessage;
        return this;
    }

    final MarketingDialogFragment setJavaScriptClient(JavaScriptClient javascriptclient)
    {
        mJavaScriptClient = javascriptclient;
        javascriptclient = mJavaScriptClient.getCallbacks();
        javascriptclient.put(15, new _cls1());
        javascriptclient.put(4, new _cls2());
        return this;
    }

    static 
    {
        dismissButtonLocation = Localytics.InAppMessageDismissButtonLocation.LEFT;
    }









    private class MarketingDialog extends Dialog
    {

        private static final String LOCATION_BOTTOM = "bottom";
        private static final String LOCATION_CENTER = "center";
        private static final String LOCATION_FULL = "full";
        private static final String LOCATION_TOP = "top";
        private static final int MARGIN = 10;
        private static final int MAX_BANNER_WIDTH_DIP = 360;
        private TranslateAnimation mAnimBottomIn;
        private TranslateAnimation mAnimBottomOut;
        private TranslateAnimation mAnimCenterIn;
        private TranslateAnimation mAnimCenterOut;
        private TranslateAnimation mAnimFullIn;
        private TranslateAnimation mAnimFullOut;
        private TranslateAnimation mAnimTopIn;
        private TranslateAnimation mAnimTopOut;
        private CloseButton mBtnClose;
        private RelativeLayout mDialogLayout;
        private float mHeight;
        private String mLocation;
        private DisplayMetrics mMetrics;
        private RelativeLayout mRootLayout;
        private MarketingWebView mWebView;
        private float mWidth;
        final MarketingDialogFragment this$0;

        private void adjustLayout()
        {
            float f;
            float f1;
            Window window;
            Object obj;
            mMetrics = new DisplayMetrics();
            ((WindowManager)getActivity().getSystemService("window")).getDefaultDisplay().getMetrics(mMetrics);
            mWidth = ((Float)mMarketingMessage.get("display_width")).floatValue();
            mHeight = ((Float)mMarketingMessage.get("display_height")).floatValue();
            f = mHeight / mWidth;
            f1 = Math.min(360F * mMetrics.density, Math.min(mMetrics.widthPixels, mMetrics.heightPixels));
            window = getWindow();
            obj = window.getAttributes();
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setFlags(32, 32);
            if (!mLocation.equals("center")) goto _L2; else goto _L1
_L1:
            window.setLayout(mMetrics.widthPixels, mMetrics.heightPixels);
            int i = (int)(10F * mMetrics.density + 0.5F);
            obj = (android.view.ViewGroup.MarginLayoutParams)mWebView.getLayoutParams();
            obj.width = (int)Math.min(f1 - (float)(i << 1), (int)(mWidth * mMetrics.density + 0.5F)) + (i << 1);
            obj.height = (int)(f * Math.min(f1 - (float)(i << 1), (int)(mWidth * mMetrics.density + 0.5F))) + (i << 1);
            ((android.view.ViewGroup.MarginLayoutParams) (obj)).setMargins(i, i, i, i);
            mWebView.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            mWebView.requestLayout();
            class CloseButton extends View
            {

                private Bitmap mBitmap;
                private final float mCenterX;
                private final float mCenterY;
                private final float mInnerRadius;
                private final float mOffset;
                private final Paint mPaint = new Paint(1);
                private final float mRadius;
                private final Paint mShadowInnerPaint = new Paint(1);
                private final Paint mShadowOuterPaint = new Paint(1);
                private final float mStrokeWidth;
                final MarketingDialog this$1;

                protected final void onDraw(Canvas canvas)
                {
                    float f4;
                    super.onDraw(canvas);
                    f4 = getResources().getDisplayMetrics().density;
                    if (MarketingDialogFragment.sDismissButtonImage == null) goto _L2; else goto _L1
_L1:
                    float f2;
                    Bitmap bitmap;
                    bitmap = MarketingDialogFragment.sDismissButtonImage;
                    f2 = (float)(bitmap.getHeight() - bitmap.getWidth()) / 2.0F;
_L6:
                    canvas.drawBitmap(bitmap, f2, 0.0F, mPaint);
_L4:
                    return;
_L2:
                    if (mBitmap == null) goto _L4; else goto _L3
_L3:
                    float f3;
                    if (MarketingDialogFragment.dismissButtonLocation == Localytics.InAppMessageDismissButtonLocation.LEFT)
                    {
                        f3 = f4;
                        f2 = 0.0F;
                    } else
                    {
                        f2 = 4F * f4;
                        f3 = 3F * f4;
                    }
                    canvas.drawCircle(mCenterX + f3, mCenterY + f4, mRadius - f4, mShadowInnerPaint);
                    canvas.drawCircle(f3 + mCenterX, mCenterY + f4, mRadius - f4, mShadowOuterPaint);
                    bitmap = mBitmap;
                    if (true) goto _L6; else goto _L5
_L5:
                }

                public final void release()
                {
                    if (mBitmap != null)
                    {
                        mBitmap.recycle();
                        mBitmap = null;
                    }
                }

                CloseButton(Context context, AttributeSet attributeset)
                {
                    this$1 = MarketingDialog.this;
                    super(context, attributeset);
                    setId(1);
                    setContentDescription("close_button");
                    if (DatapointHelper.getApiLevel() >= 14)
                    {
                        setLayerType(1, null);
                    }
                    float f1 = getResources().getDisplayMetrics().density;
                    mCenterX = 13F * f1;
                    mCenterY = 13F * f1;
                    mRadius = 13F * f1;
                    mOffset = 5F * f1;
                    mStrokeWidth = 2.5F * f1;
                    mInnerRadius = mRadius - mStrokeWidth * 0.5F;
                    mShadowInnerPaint.setMaskFilter(new BlurMaskFilter(mRadius - f1, android.graphics.BlurMaskFilter.Blur.INNER));
                    mShadowOuterPaint.setMaskFilter(new BlurMaskFilter(2.0F * f1, android.graphics.BlurMaskFilter.Blur.OUTER));
                    float f;
                    if (MarketingDialogFragment.sDismissButtonImage == null)
                    {
                        f = 30F;
                    } else
                    {
                        f = 40F;
                    }
                    f = f * f1 + 0.5F;
                    setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)f, (int)f));
                    mBitmap = Bitmap.createBitmap((int)(26F * f1 + 0.5F), (int)(26F * f1 + 0.5F), android.graphics.Bitmap.Config.ARGB_8888);
                    marketingdialog = new Canvas(mBitmap);
                    mPaint.setColor(0xff000000);
                    mPaint.setStyle(android.graphics.Paint.Style.FILL);
                    drawCircle(mCenterX, mCenterY, mRadius, mPaint);
                    mPaint.setColor(-1);
                    mPaint.setStyle(android.graphics.Paint.Style.STROKE);
                    mPaint.setStrokeWidth(mStrokeWidth);
                    drawCircle(mCenterX, mCenterY, mInnerRadius, mPaint);
                    mPaint.setStrokeWidth(f1 * 4.5F);
                    drawLine(mCenterX - mOffset, mCenterY - mOffset, mCenterX + mOffset, mCenterY + mOffset, mPaint);
                    drawLine(mCenterX - mOffset, mCenterY + mOffset, mCenterX + mOffset, mCenterY - mOffset, mPaint);
                }
            }

            obj = (android.widget.RelativeLayout.LayoutParams)mBtnClose.getLayoutParams();
            ((android.widget.RelativeLayout.LayoutParams) (obj)).setMargins(0, 0, -i, 0);
            mBtnClose.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            mBtnClose.requestLayout();
_L4:
            window.setFlags(1024, 1024);
            return;
_L2:
            if (mLocation.equals("full"))
            {
                window.setLayout(mMetrics.widthPixels, mMetrics.heightPixels);
            } else
            if (mLocation.equals("top"))
            {
                obj.y = 0xf0000001;
                obj.dimAmount = 0.0F;
                window.setLayout((int)f1, (int)(f * f1 + 0.5F));
            } else
            if (mLocation.equals("bottom"))
            {
                obj.y = 0xfffffff;
                obj.dimAmount = 0.0F;
                window.setLayout((int)f1, (int)(f * f1 + 0.5F));
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        private void createAnimations()
        {
            mAnimCenterIn = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 1.0F, 2, 0.0F);
            mAnimCenterIn.setDuration(500L);
            mAnimCenterOut = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 0.0F, 2, 1.0F);
            mAnimCenterOut.setDuration(500L);
            mAnimTopIn = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, -1F, 2, 0.0F);
            mAnimTopIn.setDuration(500L);
            mAnimTopOut = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 0.0F, 2, -1F);
            mAnimTopOut.setDuration(500L);
            mAnimBottomIn = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 1.0F, 2, 0.0F);
            mAnimBottomIn.setDuration(500L);
            mAnimBottomOut = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 0.0F, 2, 1.0F);
            mAnimBottomOut.setDuration(500L);
            mAnimFullIn = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 1.0F, 2, 0.0F);
            mAnimFullIn.setDuration(500L);
            mAnimFullOut = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 0.0F, 2, 1.0F);
            mAnimFullOut.setDuration(500L);
            class _cls3
                implements android.view.animation.Animation.AnimationListener
            {

                final MarketingDialog this$1;

                public void onAnimationEnd(Animation animation)
                {
                    try
                    {
                        dismiss();
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Animation animation)
                    {
                        LocalyticsManager.throwOrLogError(java/lang/RuntimeException, "Localytics library threw an uncaught exception", animation);
                    }
                }

                public void onAnimationRepeat(Animation animation)
                {
                }

                public void onAnimationStart(Animation animation)
                {
                    if (mCallbacks != null)
                    {
                        animation = (MarketingCallable)mCallbacks.get(17);
                        if (!Constants.isTestModeEnabled() && animation != null)
                        {
                            animation.call(null);
                        }
                    }
                }

                _cls3()
                {
                    this$1 = MarketingDialog.this;
                    super();
                }
            }

            Object obj = new _cls3();
            mAnimCenterOut.setAnimationListener(((android.view.animation.Animation.AnimationListener) (obj)));
            mAnimTopOut.setAnimationListener(((android.view.animation.Animation.AnimationListener) (obj)));
            mAnimBottomOut.setAnimationListener(((android.view.animation.Animation.AnimationListener) (obj)));
            mAnimFullOut.setAnimationListener(((android.view.animation.Animation.AnimationListener) (obj)));
            class _cls4
                implements android.view.animation.Animation.AnimationListener
            {

                final MarketingDialog this$1;

                public void onAnimationEnd(Animation animation)
                {
                    if (mCallbacks != null)
                    {
                        animation = (MarketingCallable)mCallbacks.get(16);
                        if (!Constants.isTestModeEnabled() && animation != null)
                        {
                            animation.call(new Object[] {
                                mMarketingMessage
                            });
                        }
                    }
                }

                public void onAnimationRepeat(Animation animation)
                {
                }

                public void onAnimationStart(Animation animation)
                {
                }

                _cls4()
                {
                    this$1 = MarketingDialog.this;
                    super();
                }
            }

            obj = new _cls4();
            mAnimCenterIn.setAnimationListener(((android.view.animation.Animation.AnimationListener) (obj)));
            mAnimTopIn.setAnimationListener(((android.view.animation.Animation.AnimationListener) (obj)));
            mAnimBottomIn.setAnimationListener(((android.view.animation.Animation.AnimationListener) (obj)));
            mAnimFullIn.setAnimationListener(((android.view.animation.Animation.AnimationListener) (obj)));
        }

        private void setupViews()
        {
            mRootLayout = new RelativeLayout(getContext());
            mRootLayout.setVisibility(4);
            mRootLayout.setContentDescription("amp_view");
            mRootLayout.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-2, -2));
            mDialogLayout = new RelativeLayout(getContext());
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutparams.addRule(13);
            mDialogLayout.setLayoutParams(layoutparams);
            mRootLayout.addView(mDialogLayout);
            mWebView = new MarketingWebView(getContext(), null);
            mWebView.setId(2);
            mDialogLayout.addView(mWebView);
            mBtnClose = new CloseButton(getContext(), null);
            class _cls2
                implements android.view.View.OnClickListener
            {

                final MarketingDialog this$1;

                public void onClick(View view)
                {
                    if (mExitAnimatable.getAndSet(false))
                    {
                        dismissWithAnimation();
                    }
                }

                _cls2()
                {
                    this$1 = MarketingDialog.this;
                    super();
                }
            }

            mBtnClose.setOnClickListener(new _cls2());
            if (MarketingDialogFragment.dismissButtonLocation == Localytics.InAppMessageDismissButtonLocation.RIGHT)
            {
                android.widget.RelativeLayout.LayoutParams layoutparams1 = (android.widget.RelativeLayout.LayoutParams)mBtnClose.getLayoutParams();
                layoutparams1.addRule(7, mWebView.getId());
                mBtnClose.setLayoutParams(layoutparams1);
            }
            mDialogLayout.addView(mBtnClose);
            requestWindowFeature(1);
            setContentView(mRootLayout);
        }

        final void dismissWithAnimation()
        {
            class _cls5
                implements Runnable
            {

                final MarketingDialog this$1;

                public void run()
                {
                    String s = (String)mMarketingMessage.get("location");
                    if (s.equals("center"))
                    {
                        mRootLayout.startAnimation(mAnimCenterOut);
                    } else
                    {
                        if (s.equals("full"))
                        {
                            mRootLayout.startAnimation(mAnimFullOut);
                            return;
                        }
                        if (s.equals("top"))
                        {
                            mRootLayout.startAnimation(mAnimTopOut);
                            return;
                        }
                        if (s.equals("bottom"))
                        {
                            mRootLayout.startAnimation(mAnimBottomOut);
                            return;
                        }
                    }
                }

                _cls5()
                {
                    this$1 = MarketingDialog.this;
                    super();
                }
            }

            (new Handler(Looper.getMainLooper())).post(new _cls5());
        }

        final void enterWithAnimation()
        {
            String s = (String)mMarketingMessage.get("location");
            if (s.equals("center"))
            {
                mRootLayout.startAnimation(mAnimCenterIn);
            } else
            {
                if (s.equals("full"))
                {
                    mRootLayout.startAnimation(mAnimFullIn);
                    return;
                }
                if (s.equals("top"))
                {
                    mRootLayout.startAnimation(mAnimTopIn);
                    return;
                }
                if (s.equals("bottom"))
                {
                    mRootLayout.startAnimation(mAnimBottomIn);
                    return;
                }
            }
        }

        public final boolean onKeyDown(int i, KeyEvent keyevent)
        {
            if (i == 4)
            {
                if (mExitAnimatable.getAndSet(false))
                {
                    dismissWithAnimation();
                }
                return true;
            } else
            {
                return super.onKeyDown(i, keyevent);
            }
        }

        protected final void onStop()
        {
            if (mBtnClose != null)
            {
                mBtnClose.release();
            }
            super.onStop();
        }










        MarketingDialog(Context context, int i)
        {
            this$0 = MarketingDialogFragment.this;
            super(context, i);
            if (mMarketingMessage == null)
            {
                dismiss();
                return;
            }
            mLocation = (String)mMarketingMessage.get("location");
            setupViews();
            createAnimations();
            adjustLayout();
            context = (String)mMarketingMessage.get("html_url");
            if (context != null)
            {
                mWebView.loadUrl(context);
                return;
            } else
            {
                class _cls1
                    implements Runnable
                {

                    final MarketingDialog this$1;
                    final MarketingDialogFragment val$this$0;

                    public void run()
                    {
                        dismiss();
                    }


// JavaClassFileOutputException: Invalid index accessing method local variables table of <init>
                }

                (new Handler(Looper.getMainLooper())).post(new _cls1());
                return;
            }
        }
    }


    private class _cls1 extends MarketingCallable
    {

        final MarketingDialogFragment this$0;

        Object call(final Object url[])
        {
            url = (String)url[0];
            final MarketingDialog.MarketingWebView mWebView = mMarketingDialog.mWebView;
            class _cls1
                implements Runnable
            {

                final _cls1 this$1;
                final MarketingDialog.MarketingWebView val$mWebView;
                final String val$url;

                public void run()
                {
                    mWebView.loadUrl(url);
                }

                _cls1()
                {
                    this$1 = _cls1.this;
                    mWebView = marketingwebview;
                    url = s;
                    super();
                }
            }

            if (handleUrl(((String) (url)), getActivity()))
            {
                (new Handler(Looper.getMainLooper())).post(new _cls1());
            }
            return null;
        }

        _cls1()
        {
            this$0 = MarketingDialogFragment.this;
            super();
        }
    }


    private class _cls2 extends MarketingCallable
    {

        final MarketingDialogFragment this$0;

        Object call(Object aobj[])
        {
            mMarketingDialog.dismissWithAnimation();
            return null;
        }

        _cls2()
        {
            this$0 = MarketingDialogFragment.this;
            super();
        }
    }

}
