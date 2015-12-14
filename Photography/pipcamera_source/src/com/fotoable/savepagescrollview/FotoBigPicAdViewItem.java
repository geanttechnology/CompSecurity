// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.savepagescrollview;

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
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import nx;

public class FotoBigPicAdViewItem extends LinearLayout
{

    String SavePageScrollClicked;
    String SavePageScrollOpened;
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
        View view = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(com.fotoable.fotoadpackage.R.layout.bigpic_ad_item, this, true);
        iv_icon = (ImageView)view.findViewById(com.fotoable.fotoadpackage.R.id.app_icon);
        iv_preview = (ImageView)view.findViewById(com.fotoable.fotoadpackage.R.id.app_preview_image);
        iv_rating = (ImageView)view.findViewById(com.fotoable.fotoadpackage.R.id.img_rating);
        tv_title = (TextView)view.findViewById(com.fotoable.fotoadpackage.R.id.app_title);
        btn_install = (Button)view.findViewById(com.fotoable.fotoadpackage.R.id.app_btn);
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
        Object obj = (FrameLayout)view.findViewById(com.fotoable.fotoadpackage.R.id.divider_line);
        android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)((FrameLayout) (obj)).getLayoutParams();
        layoutparams.width = (int)f1;
        layoutparams.height = 1;
        layoutparams.leftMargin = (int)f3;
        layoutparams.rightMargin = (int)f;
        ((FrameLayout) (obj)).setLayoutParams(layoutparams);
        view = (FrameLayout)view.findViewById(com.fotoable.fotoadpackage.R.id.imgFrame);
        obj = (android.widget.FrameLayout.LayoutParams)view.getLayoutParams();
        obj.width = (int)f1;
        obj.height = (int)f2;
        obj.leftMargin = (int)f3;
        obj.rightMargin = (int)f;
        view.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
    }

    public void setData(nx nx1)
    {
        if (nx1 == null)
        {
            return;
        }
        if (nx1.b != null)
        {
            Bitmap bitmap = getAssetBitmapByPath(nx1.b);
            iv_icon.setImageBitmap(bitmap);
        }
        if (nx1.c != null)
        {
            Bitmap bitmap1 = getAssetBitmapByPath(nx1.c);
            iv_preview.setImageBitmap(bitmap1);
            iv_preview.setBackgroundColor(0);
        }
        if (nx1.d != null)
        {
            Bitmap bitmap2 = getAssetBitmapByPath(nx1.d);
            iv_rating.setImageBitmap(bitmap2);
        }
        if (nx1.g != -1)
        {
            tv_title.setTextColor(nx1.g);
        }
        tv_title.setText(nx1.a);
        btn_install.setTag(nx1);
        if (isInstalled(mContext, nx1.e))
        {
            btn_install.setText(com.fotoable.fotoadpackage.R.string.open);
        } else
        {
            btn_install.setText(com.fotoable.fotoadpackage.R.string.install);
        }
        btn_install.setOnClickListener(new android.view.View.OnClickListener() {

            final FotoBigPicAdViewItem a;

            public void onClick(View view)
            {
                if (a.flurryMap == null)
                {
                    a.flurryMap = new HashMap();
                }
                view = (nx)view.getTag();
                if (a.btn_install.getText().equals("Open"))
                {
                    a.handOpenApp(((nx) (view)).e);
                    a.flurryMap.put(a.SavePageScrollOpened, ((nx) (view)).a);
                } else
                {
                    a.handOpenUrl(((nx) (view)).f);
                    a.flurryMap.put(a.SavePageScrollClicked, ((nx) (view)).a);
                }
                FlurryAgent.logEvent(a.SavePageScrollClicked, a.flurryMap);
            }

            
            {
                a = FotoBigPicAdViewItem.this;
                super();
            }
        });
    }



/*
    static Map access$002(FotoBigPicAdViewItem fotobigpicadviewitem, Map map)
    {
        fotobigpicadviewitem.flurryMap = map;
        return map;
    }

*/



}
