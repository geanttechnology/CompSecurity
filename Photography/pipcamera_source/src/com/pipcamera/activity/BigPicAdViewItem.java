// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.pipcamera.application.PIPCameraApplication;
import java.util.HashMap;
import java.util.Map;
import pb;
import rt;

public class BigPicAdViewItem extends LinearLayout
{

    String SavePageScrollClicked;
    String SavePageScrollOpened;
    private Button btn_install;
    private Map flurryMap;
    private ImageView iv_icon;
    private ImageView iv_preview;
    private ImageView iv_rating;
    private Context mContext;
    private TextView tv_desc;
    private TextView tv_title;

    public BigPicAdViewItem(Context context)
    {
        super(context);
        SavePageScrollClicked = "SavePageScrollClicked";
        SavePageScrollOpened = "SavePageScrollOpened";
        mContext = context;
        initView();
    }

    public BigPicAdViewItem(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        SavePageScrollClicked = "SavePageScrollClicked";
        SavePageScrollOpened = "SavePageScrollOpened";
        mContext = context;
        initView();
    }

    private void handOpenApp(String s)
    {
        try
        {
            s = mContext.getPackageManager().getLaunchIntentForPackage(s);
            s.addFlags(0x10000000);
            mContext.startActivity(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
        }
    }

    private void handOpenUrl(String s)
    {
        if (s == null || s.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        mContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
        return;
        s;
        Crashlytics.logException(s);
        return;
        s;
        Crashlytics.logException(s);
        return;
    }

    private void initView()
    {
        View view = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030035, this, true);
        iv_icon = (ImageView)view.findViewById(0x7f0c0104);
        iv_preview = (ImageView)view.findViewById(0x7f0c010c);
        iv_rating = (ImageView)view.findViewById(0x7f0c0106);
        tv_title = (TextView)view.findViewById(0x7f0c0105);
        tv_desc = (TextView)view.findViewById(0x7f0c0109);
        btn_install = (Button)view.findViewById(0x7f0c0107);
        resetView(view);
    }

    public static boolean isInstalled(Context context, String s)
    {
        if (s != null)
        {
            try
            {
                context = context.getPackageManager().getPackageInfo(s, 0);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
                Crashlytics.logException(context);
                context = null;
            }
            if (context != null)
            {
                return true;
            }
        }
        return false;
    }

    private void resetView(View view)
    {
        float f1 = mContext.getResources().getDisplayMetrics().widthPixels;
        float f = f1 / 8F;
        f1 -= f;
        float f2 = (207F * f1) / 300F;
        float f3 = f / 2.0F;
        f /= 2.0F;
        Object obj = (FrameLayout)view.findViewById(0x7f0c0102);
        android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)((FrameLayout) (obj)).getLayoutParams();
        layoutparams.width = (int)f1;
        layoutparams.leftMargin = (int)f3;
        layoutparams.rightMargin = (int)f;
        layoutparams.topMargin = (int)f3;
        ((FrameLayout) (obj)).setLayoutParams(layoutparams);
        obj = (FrameLayout)view.findViewById(0x7f0c0108);
        layoutparams = (android.widget.LinearLayout.LayoutParams)((FrameLayout) (obj)).getLayoutParams();
        layoutparams.width = (int)f1;
        layoutparams.leftMargin = (int)f3;
        ((FrameLayout) (obj)).setLayoutParams(layoutparams);
        obj = (FrameLayout)view.findViewById(0x7f0c010d);
        layoutparams = (android.widget.LinearLayout.LayoutParams)((FrameLayout) (obj)).getLayoutParams();
        layoutparams.width = (int)f1;
        layoutparams.height = 1;
        layoutparams.leftMargin = (int)f3;
        layoutparams.rightMargin = (int)f;
        ((FrameLayout) (obj)).setLayoutParams(layoutparams);
        view = (FrameLayout)view.findViewById(0x7f0c010b);
        obj = (android.widget.FrameLayout.LayoutParams)view.getLayoutParams();
        obj.width = (int)f1;
        obj.height = (int)f2;
        obj.leftMargin = (int)f3;
        obj.rightMargin = (int)f;
        view.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
    }

    public void setData(rt rt1)
    {
        if (rt1 == null)
        {
            return;
        }
        if (rt1.c != null)
        {
            android.graphics.Bitmap bitmap = pb.b(PIPCameraApplication.a, rt1.c);
            iv_icon.setImageBitmap(bitmap);
        }
        if (rt1.d != null)
        {
            android.graphics.Bitmap bitmap1 = pb.b(PIPCameraApplication.a, rt1.d);
            iv_preview.setImageBitmap(bitmap1);
            iv_preview.setBackgroundColor(0);
        }
        if (rt1.e != null)
        {
            android.graphics.Bitmap bitmap2 = pb.b(PIPCameraApplication.a, rt1.e);
            iv_rating.setImageBitmap(bitmap2);
        }
        tv_title.setText(rt1.a);
        tv_desc.setText(rt1.b);
        btn_install.setTag(rt1);
        if (isInstalled(mContext, rt1.f))
        {
            btn_install.setText(0x7f060180);
        } else
        {
            btn_install.setText(0x7f06013b);
        }
        btn_install.setOnClickListener(new android.view.View.OnClickListener() {

            final BigPicAdViewItem a;

            public void onClick(View view)
            {
                if (a.flurryMap == null)
                {
                    a.flurryMap = new HashMap();
                }
                view = (rt)view.getTag();
                if (a.btn_install.getText().equals(a.getResources().getText(0x7f060180)))
                {
                    a.handOpenApp(((rt) (view)).f);
                    a.flurryMap.put(a.SavePageScrollOpened, ((rt) (view)).a);
                } else
                {
                    a.handOpenUrl(((rt) (view)).g);
                    a.flurryMap.put(a.SavePageScrollClicked, ((rt) (view)).a);
                }
                FlurryAgent.logEvent(a.SavePageScrollClicked, a.flurryMap);
            }

            
            {
                a = BigPicAdViewItem.this;
                super();
            }
        });
    }



/*
    static Map access$002(BigPicAdViewItem bigpicadviewitem, Map map)
    {
        bigpicadviewitem.flurryMap = map;
        return map;
    }

*/



}
