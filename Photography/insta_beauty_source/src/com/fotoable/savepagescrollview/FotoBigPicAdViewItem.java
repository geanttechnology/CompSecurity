// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.savepagescrollview;

import aar;
import aas;
import aat;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import atd;
import ate;
import com.crashlytics.android.Crashlytics;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class FotoBigPicAdViewItem extends LinearLayout
{

    public String SavePageScrollClicked;
    public String SavePageScrollOpened;
    private Button btn_install;
    private Map flurryMap;
    private ImageView iv_icon;
    private ImageView iv_preview;
    private ImageView iv_rating;
    private Context mContext;
    private TextView tv_title;

    public FotoBigPicAdViewItem(Context context)
    {
        super(context);
        SavePageScrollClicked = "SavePageScrollClicked";
        SavePageScrollOpened = "SavePageScrollOpened";
        mContext = context;
        initView();
    }

    public FotoBigPicAdViewItem(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        SavePageScrollClicked = "SavePageScrollClicked";
        SavePageScrollOpened = "SavePageScrollOpened";
        mContext = context;
        initView();
    }

    private Bitmap getAssetBitmapByPath(String s)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = mContext.getAssets();
        s = ((AssetManager) (obj)).open(s);
        String s1;
        obj = obj1;
        s1 = s;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        obj = BitmapFactory.decodeStream(s);
        s1 = s;
_L2:
        if (s1 != null)
        {
            try
            {
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                Crashlytics.logException(s);
                return ((Bitmap) (obj));
            }
        }
        return ((Bitmap) (obj));
        obj;
        s = null;
_L3:
        ((IOException) (obj)).printStackTrace();
        Crashlytics.logException(((Throwable) (obj)));
        obj = obj1;
        s1 = s;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
          goto _L3
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
        View view = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(aas.bigpic_ad_item, this, true);
        iv_icon = (ImageView)view.findViewById(aar.app_icon);
        iv_preview = (ImageView)view.findViewById(aar.app_preview_image);
        iv_rating = (ImageView)view.findViewById(aar.img_rating);
        tv_title = (TextView)view.findViewById(aar.app_title);
        btn_install = (Button)view.findViewById(aar.app_btn);
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
        float f = f1 / 16F;
        f1 -= f;
        float f2 = (207F * f1) / 300F;
        float f3 = f / 2.0F;
        f /= 2.0F;
        Object obj = (FrameLayout)view.findViewById(aar.divider_line);
        android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)((FrameLayout) (obj)).getLayoutParams();
        layoutparams.width = (int)f1;
        layoutparams.height = 1;
        layoutparams.leftMargin = (int)f3;
        layoutparams.rightMargin = (int)f;
        ((FrameLayout) (obj)).setLayoutParams(layoutparams);
        view = (FrameLayout)view.findViewById(aar.imgFrame);
        obj = (android.widget.FrameLayout.LayoutParams)view.getLayoutParams();
        obj.width = (int)f1;
        obj.height = (int)f2;
        obj.leftMargin = (int)f3;
        obj.rightMargin = (int)f;
        view.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
    }

    public void setData(ate ate1)
    {
        if (ate1 == null)
        {
            return;
        }
        if (ate1.b != null)
        {
            Bitmap bitmap = getAssetBitmapByPath(ate1.b);
            iv_icon.setImageBitmap(bitmap);
        }
        if (ate1.c != null)
        {
            Bitmap bitmap1 = getAssetBitmapByPath(ate1.c);
            iv_preview.setImageBitmap(bitmap1);
            iv_preview.setBackgroundColor(0);
        }
        if (ate1.d != null)
        {
            Bitmap bitmap2 = getAssetBitmapByPath(ate1.d);
            iv_rating.setImageBitmap(bitmap2);
        }
        if (ate1.g != -1)
        {
            tv_title.setTextColor(ate1.g);
        }
        tv_title.setText(ate1.a);
        btn_install.setTag(ate1);
        if (isInstalled(mContext, ate1.e))
        {
            btn_install.setText(aat.open);
        } else
        {
            btn_install.setText(aat.install);
        }
        btn_install.setOnClickListener(new atd(this));
    }



/*
    public static Map access$002(FotoBigPicAdViewItem fotobigpicadviewitem, Map map)
    {
        fotobigpicadviewitem.flurryMap = map;
        return map;
    }

*/



}
