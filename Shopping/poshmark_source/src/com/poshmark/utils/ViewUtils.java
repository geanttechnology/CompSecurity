// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.poshmark.data_model.models.inner_models.Host;
import com.poshmark.ui.customviews.RoundedImageView;
import java.util.List;

public class ViewUtils
{

    public static final int sMaxHostImageCount = 7;

    public ViewUtils()
    {
    }

    public static void addEmptyView(Context context, ViewGroup viewgroup, int i, boolean flag)
    {
        if (!flag)
        {
            i = (int)dipToPixels(context, i);
        }
        context = new View(context, null);
        context.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, i));
        viewgroup.addView(context);
    }

    public static float dipToPixels(Context context, float f)
    {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static Point getDiffInTops(View view, View view1)
    {
        Rect rect = new Rect();
        Rect rect1 = new Rect();
        Rect rect2 = new Rect();
        int ai[] = new int[2];
        int ai1[] = new int[2];
        Point point = new Point();
        view.getGlobalVisibleRect(rect1);
        view1.getGlobalVisibleRect(rect2);
        point.x = ai1[0] - ai[0];
        point.y = ai1[1] - ai[1];
        view.getLocationOnScreen(ai);
        view1.getLocationOnScreen(ai1);
        rect.left = rect2.left - rect1.left;
        rect.top = rect2.top - rect1.top;
        rect.right = rect2.right - rect1.right;
        rect.bottom = rect2.bottom - rect1.bottom;
        return point;
    }

    public static Typeface getTypefaceFromName(Context context, String s)
    {
        if (s != null)
        {
            return Typeface.createFromAsset(context.getAssets(), s);
        } else
        {
            return Typeface.create((String)null, 0);
        }
    }

    public static void loadFbAvataar(String s, ImageView imageview)
    {
        s = String.format(new String("https://graph.facebook.com/%s/picture?width=100&height=100"), new Object[] {
            s
        });
        ImageLoader.getInstance().displayImage(s, imageview);
    }

    public static void loadGooglePlusAvataar(String s, ImageView imageview)
    {
        ImageLoader.getInstance().displayImage(s, imageview);
    }

    public static void populatePartyHostsInLayout(Context context, List list, GridLayout gridlayout)
    {
        int k = 0;
        int i = 0;
        int l = list.size();
        int j = 0;
        while (j < l) 
        {
            Object obj = (Host)list.get(j);
            RoundedImageView roundedimageview = new RoundedImageView(context, null);
            roundedimageview.setUser(((Host) (obj)).getUsername());
            int i1 = (int)dipToPixels(context.getApplicationContext(), 10F);
            int j1 = i1 * 3;
            android.widget.GridLayout.LayoutParams layoutparams = new android.widget.GridLayout.LayoutParams(GridLayout.spec(k, 1), GridLayout.spec(i, 1));
            layoutparams.width = j1;
            layoutparams.height = j1;
            layoutparams.setMargins(0, i1 / 2, i1, 0);
            gridlayout.addView(roundedimageview, layoutparams);
            obj = ((Host) (obj)).getAvataar();
            if (obj != null)
            {
                ImageLoader.getInstance().loadImage(((String) (obj)), roundedimageview.listener);
            } else
            {
                roundedimageview.setBitmap(0x7f0200d4);
            }
            if (i + 1 == 7)
            {
                k++;
                i = 0;
            } else
            {
                i++;
            }
            j++;
        }
    }

    public static void setTypefaceForView(Context context, String s, TextView textview)
    {
        if (textview == null);
    }

    public static void showLoadingProgress(Context context, View view)
    {
        view = (LinearLayout)view.findViewById(0x7f0c012d);
        if (view.findViewById(0x7f0c012e) == null)
        {
            view.addView(LayoutInflater.from(context).inflate(0x7f03004e, null));
        }
    }
}
