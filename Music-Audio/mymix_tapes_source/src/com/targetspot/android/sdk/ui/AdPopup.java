// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.targetspot.android.sdk.AdSettings;
import com.targetspot.android.sdk.TSContentSize;
import com.targetspot.android.sdk.service.AdBreak;
import com.targetspot.android.sdk.service.AdClientImpl;
import com.targetspot.android.sdk.service.AdData;
import com.targetspot.android.sdk.service.AdLink;
import com.targetspot.android.sdk.service.AdManager;
import com.targetspot.android.sdk.service.AdSegment;
import com.targetspot.android.sdk.service.DownloadManager;
import com.targetspot.android.sdk.service.LoggingManager;
import com.targetspot.android.sdk.util.ImageUtil;
import java.io.IOException;
import java.lang.reflect.Field;

public class AdPopup extends PopupWindow
    implements android.widget.PopupWindow.OnDismissListener
{
    class AdLayout extends LinearLayout
    {

        AdPopup owner;
        final AdPopup this$0;

        public boolean dispatchKeyEvent(KeyEvent keyevent)
        {
            if (keyevent.getKeyCode() == 4)
            {
                if (keyevent.getAction() == 0 && keyevent.getRepeatCount() == 0)
                {
                    return true;
                }
                if (keyevent.getAction() == 1)
                {
                    owner.dismissPopup();
                    return true;
                } else
                {
                    return super.dispatchKeyEvent(keyevent);
                }
            } else
            {
                return super.dispatchKeyEvent(keyevent);
            }
        }

        AdLayout(AdPopup adpopup1, Context context)
        {
            this$0 = AdPopup.this;
            super(context);
            owner = adpopup1;
        }
    }


    private static final int BACK_COLOR = Color.rgb(186, 186, 186);
    private static final int GRADIENT_COLORS[] = {
        Color.rgb(137, 137, 137), Color.rgb(37, 37, 37)
    };
    private static final int INFO_BUTTON_FONT_SIZE = 16;
    private static final int INFO_BUTTON_MIN_WIDTH = 280;
    private static final int INFO_BUTTON_PADDING = 12;
    private static final int LABEL_FONT_SIZE = 18;
    private static final int LABEL_MIN_HEIGHT = 48;
    private com.targetspot.android.sdk.service.AdBreak.SegmentPosition adPosition;
    private int backColor;
    private AdClientImpl client;
    private int deviceWidth;
    private Handler handler;
    private ImageView image;
    private Button infoButton;
    private TextView label;
    private Activity parent;
    private int popupId;
    private int reason;

    public AdPopup(Activity activity, AdClientImpl adclientimpl, int i)
    {
        super(activity);
        reason = 2;
        adPosition = new com.targetspot.android.sdk.service.AdBreak.SegmentPosition();
        deviceWidth = 320;
        handler = new Handler();
        parent = activity;
        client = adclientimpl;
        popupId = i;
        setOnDismissListener(this);
        backColor = Color.argb(Math.max(Math.min((int)(AdManager.getInstance().getAdSettings().getAlphaForBackground() * 255D), 255), 0), Color.red(BACK_COLOR), Color.green(BACK_COLOR), Color.blue(BACK_COLOR));
    }

    private Rect getImageSize()
    {
        TSContentSize tscontentsize = AdManager.getInstance().getImageSize();
        static class _cls4
        {

            static final int $SwitchMap$com$targetspot$android$sdk$TSContentSize[];

            static 
            {
                $SwitchMap$com$targetspot$android$sdk$TSContentSize = new int[TSContentSize.values().length];
                try
                {
                    $SwitchMap$com$targetspot$android$sdk$TSContentSize[TSContentSize.TSContentSizeLarge.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$targetspot$android$sdk$TSContentSize[TSContentSize.TSContentSizeMedium.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$targetspot$android$sdk$TSContentSize[TSContentSize.TSContentSizeSmall.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls4..SwitchMap.com.targetspot.android.sdk.TSContentSize[tscontentsize.ordinal()];
        JVM INSTR tableswitch 1 2: default 36
    //                   1 56
    //                   2 67;
           goto _L1 _L2 _L3
_L1:
        char c;
        char c1;
        c1 = '\264';
        c = '\226';
_L5:
        return new Rect(0, 0, c1, c);
_L2:
        c1 = '\u0168';
        c = '\u012C';
        continue; /* Loop/switch isn't completed */
_L3:
        c1 = '\u012C';
        c = '\372';
        if (true) goto _L5; else goto _L4
_L4:
    }

    private double getScaleX(int i)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)parent.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        deviceWidth = displaymetrics.widthPixels;
        Log.d("AdPopup", (new StringBuilder()).append("Device width: ").append(deviceWidth).toString());
        return (double)i / (double)deviceWidth;
    }

    boolean createPopup(boolean flag)
    {
        ViewGroup viewgroup = (ViewGroup)parent.getWindow().peekDecorView();
        ViewGroup viewgroup1 = (ViewGroup)viewgroup.getChildAt(0);
        Object obj = new Rect();
        parent.getWindow().getDecorView().getWindowVisibleDisplayFrame(((Rect) (obj)));
        int j = ((Rect) (obj)).top;
        int i = j;
        if (j < 0)
        {
            i = 0;
        }
        double d = getScaleX(viewgroup1.getWidth());
        android.widget.LinearLayout.LayoutParams layoutparams;
        android.widget.FrameLayout.LayoutParams layoutparams1;
        android.view.View.OnClickListener onclicklistener;
        FrameLayout framelayout;
        Rect rect;
        ImageView imageview;
        boolean flag1;
        int k;
        if (viewgroup1.getWidth() > viewgroup1.getHeight())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Log.d("AdPopup", (new StringBuilder()).append("Size ").append(viewgroup1.getWidth()).append("x").append(viewgroup1.getHeight()).append(", title ").append(i).append(", scale ").append(d).toString());
        obj = new AdLayout(this, parent);
        ((LinearLayout) (obj)).setOrientation(1);
        ((LinearLayout) (obj)).setBackgroundColor(backColor);
        ((LinearLayout) (obj)).setFocusable(true);
        ((LinearLayout) (obj)).setPadding(0, i, 0, 0);
        setBackgroundDrawable(null);
        layoutparams = new android.widget.LinearLayout.LayoutParams(-1, -2);
        layoutparams.gravity = 80;
        layoutparams1 = new android.widget.FrameLayout.LayoutParams(-2, -2, 17);
        label = new TextView(parent);
        label.setText("Advertisement");
        label.setGravity(17);
        label.setTypeface(Typeface.create("", 1));
        label.setTextColor(-1);
        label.setTextSize(18F);
        label.setMinimumHeight((int)(48D * d));
        label.setBackgroundDrawable(new GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, GRADIENT_COLORS));
        ((LinearLayout) (obj)).addView(label, layoutparams);
        onclicklistener = new android.view.View.OnClickListener() {

            final AdPopup this$0;

            public void onClick(View view)
            {
                reason = 4;
                dismissPopup();
                view = adPosition.segment.getClickThrough();
                if (view != null)
                {
                    view = view.getLinkUrl();
                    parent.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(view)));
                    AdManager.getInstance().getLogger().logImpression(adPosition.segment.getClickThrough());
                }
            }

            
            {
                this$0 = AdPopup.this;
                super();
            }
        };
        image = new ImageView(parent);
        image.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        framelayout = new FrameLayout(parent);
        rect = getImageSize();
        imageview = image;
        k = (int)((double)rect.right * d);
        if (flag1)
        {
            i = -2;
        } else
        {
            i = (int)((double)rect.bottom * d);
        }
        framelayout.addView(imageview, new android.widget.FrameLayout.LayoutParams(k, i, 17));
        ((LinearLayout) (obj)).addView(framelayout, new android.widget.LinearLayout.LayoutParams(-1, -2, 1.0F));
        image.setOnClickListener(onclicklistener);
        infoButton = new Button(parent);
        infoButton.setText("Press for Info");
        infoButton.setTextSize(16F);
        infoButton.setMinimumWidth((int)(280D * d));
        framelayout = new FrameLayout(parent);
        framelayout.setPadding(0, 0, 0, 12);
        framelayout.addView(infoButton, layoutparams1);
        ((LinearLayout) (obj)).addView(framelayout, layoutparams);
        infoButton.setOnClickListener(onclicklistener);
        setContentView(((View) (obj)));
        setWidth(viewgroup1.getWidth());
        setHeight(viewgroup1.getHeight());
        setFocusable(true);
        if (flag)
        {
            setAnimationStyle(findAnimationStyle());
        }
        try
        {
            showAtLocation(viewgroup, 0, 0, 0);
        }
        catch (Throwable throwable)
        {
            Log.d("AdPopup", "Window not valid");
            setContentView(null);
            return false;
        }
        Log.d("AdPopup", "Popup created");
        return true;
    }

    LinearLayout createThrobber()
    {
        Object obj = (ViewGroup)((ViewGroup)parent.getWindow().peekDecorView()).getChildAt(0);
        int i = 0;
        if (((ViewGroup) (obj)).getChildAt(0) instanceof ViewGroup)
        {
            i = 0 + ((ViewGroup) (obj)).getChildAt(0).getTop();
        }
        obj = new AdLayout(this, parent);
        ((LinearLayout) (obj)).setOrientation(1);
        ((LinearLayout) (obj)).setBackgroundColor(backColor);
        ((LinearLayout) (obj)).setFocusable(true);
        ((LinearLayout) (obj)).setPadding(0, i, 0, 0);
        setBackgroundDrawable(null);
        (new android.widget.LinearLayout.LayoutParams(-1, -2)).gravity = 80;
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-2, -1, 17);
        ProgressBar progressbar = new ProgressBar(parent, null, 0x101007a);
        progressbar.setIndeterminate(false);
        FrameLayout framelayout = new FrameLayout(parent);
        framelayout.addView(progressbar, layoutparams);
        ((LinearLayout) (obj)).addView(framelayout, new android.widget.LinearLayout.LayoutParams(-1, -2, 0.0F));
        return ((LinearLayout) (obj));
    }

    public void dismissPopup()
    {
        handler.removeCallbacksAndMessages(this);
        dismiss();
        client.onAdClosed(reason);
    }

    int findAnimationStyle()
    {
        int i;
        try
        {
            Field field = Class.forName("com.android.internal.R$style").getField("Animation_StatusBar");
            i = field.getInt(field);
        }
        catch (Exception exception)
        {
            return 0x1030002;
        }
        return i;
    }

    public int getId()
    {
        return popupId;
    }

    public void onDismiss()
    {
        handler.removeCallbacksAndMessages(this);
    }

    public void setPosition(com.targetspot.android.sdk.service.AdBreak.SegmentPosition segmentposition)
    {
        Object obj = AdManager.getInstance();
        adPosition = segmentposition;
        segmentposition = segmentposition.segment;
        if (infoButton == null || image == null)
        {
            return;
        }
        Button button = infoButton;
        int i;
        if (segmentposition.getClickThrough() != null)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        button.setVisibility(i);
        try
        {
            obj = ((AdManager) (obj)).getDownloader().getContentURL(segmentposition.getVisualFile().getUrl());
        }
        catch (IOException ioexception)
        {
            Log.e("AdPopup", (new StringBuilder()).append("Unable to load image from ").append(segmentposition.getVisualFile().getUrl()).toString());
            return;
        }
        ImageUtil.getImageFromURL(((String) (obj)), image);
    }

    public void showPopup(boolean flag, AdBreak adbreak, int i)
    {
        boolean flag1;
        if (i == 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!createPopup(flag1))
        {
            Log.d("AdPopup", "Popup create failed, delaying");
            showPopupDelayed(flag, adbreak, i);
            return;
        }
        if (!adbreak.getSegment(i, adPosition))
        {
            Log.e("AdPopup", "Ad positioning error");
            return;
        } else
        {
            setPosition(adPosition);
            adbreak = new Runnable() {

                final AdPopup this$0;
                final int val$duration;
                final long val$playbackStarted;
                final int val$pos;

                public void run()
                {
                    long l = SystemClock.uptimeMillis();
                    int j = duration - pos / 1000 - (int)((l - playbackStarted) / 1000L);
                    if (j > 1)
                    {
                        label.setText((new StringBuilder()).append("Advertisement: ").append(j).append(" seconds left").toString());
                        handler.postAtTime(this, AdPopup.this, l + 200L);
                        return;
                    }
                    if (j == 1)
                    {
                        label.setText("Advertisement: 1 second left");
                        handler.postAtTime(this, AdPopup.this, l + 200L);
                        return;
                    } else
                    {
                        label.setText("Advertisement: 0 seconds left");
                        return;
                    }
                }

            
            {
                this$0 = AdPopup.this;
                duration = i;
                pos = j;
                playbackStarted = l;
                super();
            }
            };
            handler.postAtTime(adbreak, this, SystemClock.uptimeMillis() + 200L);
            return;
        }
    }

    public void showPopupDelayed(final boolean preRoll, final AdBreak adBreak, final int pos)
    {
        adBreak = new Runnable() {

            final AdPopup this$0;
            final AdBreak val$adBreak;
            final int val$pos;
            final boolean val$preRoll;

            public void run()
            {
                showPopup(preRoll, adBreak, pos);
            }

            
            {
                this$0 = AdPopup.this;
                preRoll = flag;
                adBreak = adbreak;
                pos = i;
                super();
            }
        };
        handler.postAtTime(adBreak, this, SystemClock.uptimeMillis() + 200L);
    }



/*
    static int access$002(AdPopup adpopup, int i)
    {
        adpopup.reason = i;
        return i;
    }

*/




}
