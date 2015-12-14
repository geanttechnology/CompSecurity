// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAdView;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAdView;
import java.util.List;

public class ee
{

    private static String a = "ADMobUtil";
    private static float b = 1.0F;

    public static void a(Context context, NativeAppInstallAdView nativeappinstalladview)
    {
        float f = context.getResources().getDisplayMetrics().widthPixels;
        float f2 = f - f / 8F;
        f = (207F * f2) / 300F;
        context = (android.widget.FrameLayout.LayoutParams)nativeappinstalladview.findViewById(com.fotoabroad.fotoabroadlib.R.id.container_frame).getLayoutParams();
        context.width = (int)f2;
        context.height = (int)f;
        nativeappinstalladview.findViewById(com.fotoabroad.fotoabroadlib.R.id.container_frame).setLayoutParams(context);
        context = (android.widget.FrameLayout.LayoutParams)((ImageView)nativeappinstalladview.findViewById(com.fotoabroad.fotoabroadlib.R.id.logoicon)).getLayoutParams();
        context.width = (int)((31F * f2) / 300F);
        context.height = (int)((15F * f2) / 300F);
        ((ImageView)nativeappinstalladview.findViewById(com.fotoabroad.fotoabroadlib.R.id.logoicon)).setLayoutParams(context);
        f = f2 / b;
        float f1;
        float f3;
        if (b < 1.910828F)
        {
            f = f2 * 0.5233333F;
            f1 = b * f;
        } else
        {
            f1 = f2;
        }
        context = (android.widget.FrameLayout.LayoutParams)((ImageView)nativeappinstalladview.getImageView()).getLayoutParams();
        context.width = (int)f1;
        context.height = (int)f;
        f3 = (16F * f2) / 300F;
        context.topMargin = (int)((0.5233333F * f2 - f) / 2.0F + f3);
        context.leftMargin = (int)(f2 - f1) / 2;
        ((ImageView)nativeappinstalladview.getImageView()).setLayoutParams(context);
        context = (android.widget.FrameLayout.LayoutParams)nativeappinstalladview.findViewById(com.fotoabroad.fotoabroadlib.R.id.content_frame).getLayoutParams();
        context.height = (int)((34F * f2) / 300F);
        context.rightMargin = (int)((64F * f2) / 300F);
        context.leftMargin = (int)((40F * f2) / 300F);
        nativeappinstalladview.findViewById(com.fotoabroad.fotoabroadlib.R.id.content_frame).setLayoutParams(context);
        context = (android.widget.FrameLayout.LayoutParams)nativeappinstalladview.getIconView().getLayoutParams();
        context.height = (int)((f2 * 30F) / 300F);
        context.width = (int)((f2 * 30F) / 300F);
        context.leftMargin = (int)((f2 * 2.0F) / 300F);
        nativeappinstalladview.getIconView().setLayoutParams(context);
        context = (android.widget.FrameLayout.LayoutParams)nativeappinstalladview.getCallToActionView().getLayoutParams();
        context.height = (int)((f2 * 30F) / 300F);
        context.width = (int)((60F * f2) / 300F);
        context.rightMargin = (int)((f2 * 2.0F) / 300F);
        context.bottomMargin = (int)((f2 * 2.0F) / 300F);
        context.topMargin = (int)((f2 * 2.0F) / 300F);
        nativeappinstalladview.getCallToActionView().setLayoutParams(context);
    }

    public static void a(Context context, NativeContentAdView nativecontentadview)
    {
        float f = context.getResources().getDisplayMetrics().widthPixels;
        float f2 = f - f / 8F;
        f = (207F * f2) / 300F;
        context = (android.widget.FrameLayout.LayoutParams)((ImageView)nativecontentadview.findViewById(com.fotoabroad.fotoabroadlib.R.id.logoicon)).getLayoutParams();
        context.width = (int)((31F * f2) / 300F);
        context.height = (int)((15F * f2) / 300F);
        ((ImageView)nativecontentadview.findViewById(com.fotoabroad.fotoabroadlib.R.id.logoicon)).setLayoutParams(context);
        context = (android.widget.FrameLayout.LayoutParams)nativecontentadview.findViewById(com.fotoabroad.fotoabroadlib.R.id.container_frame).getLayoutParams();
        context.width = (int)f2;
        context.height = (int)f;
        nativecontentadview.findViewById(com.fotoabroad.fotoabroadlib.R.id.container_frame).setLayoutParams(context);
        f = f2 / b;
        float f1;
        float f3;
        if (b < 1.910828F)
        {
            f = f2 * 0.5233333F;
            f1 = b * f;
        } else
        {
            f1 = f2;
        }
        context = (android.widget.FrameLayout.LayoutParams)((ImageView)nativecontentadview.getImageView()).getLayoutParams();
        context.width = (int)f1;
        context.height = (int)f;
        f3 = (16F * f2) / 300F;
        context.topMargin = (int)((0.5233333F * f2 - f) / 2.0F + f3);
        context.leftMargin = (int)(f2 - f1) / 2;
        ((ImageView)nativecontentadview.getImageView()).setLayoutParams(context);
        context = (android.widget.FrameLayout.LayoutParams)nativecontentadview.findViewById(com.fotoabroad.fotoabroadlib.R.id.content_frame).getLayoutParams();
        context.height = (int)((f2 * 34F) / 300F);
        context.rightMargin = (int)((62F * f2) / 300F);
        context.leftMargin = (int)((f2 * 34F) / 300F);
        nativecontentadview.findViewById(com.fotoabroad.fotoabroadlib.R.id.content_frame).setLayoutParams(context);
        context = (android.widget.FrameLayout.LayoutParams)nativecontentadview.getLogoView().getLayoutParams();
        context.height = (int)((f2 * 30F) / 300F);
        context.width = (int)((f2 * 30F) / 300F);
        context.leftMargin = (int)((f2 * 2.0F) / 300F);
        nativecontentadview.getLogoView().setLayoutParams(context);
        context = (android.widget.FrameLayout.LayoutParams)nativecontentadview.getCallToActionView().getLayoutParams();
        context.height = (int)((f2 * 30F) / 300F);
        context.width = (int)((60F * f2) / 300F);
        context.rightMargin = (int)((f2 * 2.0F) / 300F);
        nativecontentadview.getCallToActionView().setLayoutParams(context);
    }

    public static void a(NativeAppInstallAd nativeappinstallad, NativeAppInstallAdView nativeappinstalladview)
    {
        nativeappinstalladview.setHeadlineView(nativeappinstalladview.findViewById(com.fotoabroad.fotoabroadlib.R.id.appinstall_headline));
        nativeappinstalladview.setImageView(nativeappinstalladview.findViewById(com.fotoabroad.fotoabroadlib.R.id.appinstall_image));
        nativeappinstalladview.setBodyView(nativeappinstalladview.findViewById(com.fotoabroad.fotoabroadlib.R.id.appinstall_body));
        nativeappinstalladview.setCallToActionView(nativeappinstalladview.findViewById(com.fotoabroad.fotoabroadlib.R.id.appinstall_call_to_action));
        nativeappinstalladview.setIconView(nativeappinstalladview.findViewById(com.fotoabroad.fotoabroadlib.R.id.appinstall_app_icon));
        Object obj = nativeappinstallad.getHeadline().toString();
        String s = nativeappinstallad.getBody().toString();
        String s1 = nativeappinstallad.getCallToAction().toString();
        ((TextView)nativeappinstalladview.getHeadlineView()).setText(((CharSequence) (obj)));
        ((TextView)nativeappinstalladview.getBodyView()).setText(s);
        ((Button)nativeappinstalladview.getCallToActionView()).setText(s1);
        obj = nativeappinstallad.getIcon();
        if (obj != null)
        {
            ((ImageView)nativeappinstalladview.getIconView()).setImageDrawable(((com.google.android.gms.ads.formats.NativeAd.Image) (obj)).getDrawable());
        }
        obj = nativeappinstallad.getImages();
        if (((List) (obj)).size() > 0)
        {
            obj = ((com.google.android.gms.ads.formats.NativeAd.Image)((List) (obj)).get(0)).getDrawable();
            if (obj != null && ((Drawable) (obj)).getIntrinsicHeight() != 0)
            {
                b = (float)((Drawable) (obj)).getIntrinsicWidth() / (float)((Drawable) (obj)).getIntrinsicHeight();
                ((ImageView)nativeappinstalladview.getImageView()).setImageDrawable(((Drawable) (obj)));
            }
        }
        nativeappinstalladview.setNativeAd(nativeappinstallad);
    }

    public static void a(NativeContentAd nativecontentad, NativeContentAdView nativecontentadview)
    {
        nativecontentadview.setHeadlineView(nativecontentadview.findViewById(com.fotoabroad.fotoabroadlib.R.id.contentad_headline));
        nativecontentadview.setImageView(nativecontentadview.findViewById(com.fotoabroad.fotoabroadlib.R.id.contentad_image));
        nativecontentadview.setBodyView(nativecontentadview.findViewById(com.fotoabroad.fotoabroadlib.R.id.contentad_body));
        nativecontentadview.setCallToActionView(nativecontentadview.findViewById(com.fotoabroad.fotoabroadlib.R.id.contentad_call_to_action));
        nativecontentadview.setLogoView(nativecontentadview.findViewById(com.fotoabroad.fotoabroadlib.R.id.contentad_logo));
        Object obj = nativecontentad.getHeadline().toString();
        Object obj1 = nativecontentad.getBody().toString();
        String s = nativecontentad.getCallToAction().toString();
        ((TextView)nativecontentadview.getHeadlineView()).setText(((CharSequence) (obj)));
        ((TextView)nativecontentadview.getBodyView()).setText(((CharSequence) (obj1)));
        ((TextView)nativecontentadview.getCallToActionView()).setText(s);
        obj = nativecontentad.getLogo();
        if (obj != null)
        {
            ((ImageView)nativecontentadview.getLogoView()).setImageDrawable(((com.google.android.gms.ads.formats.NativeAd.Image) (obj)).getDrawable());
        }
        obj1 = nativecontentad.getImages();
        if (obj1 != null && ((List) (obj1)).size() > 0)
        {
            obj1 = ((com.google.android.gms.ads.formats.NativeAd.Image)((List) (obj1)).get(0)).getDrawable();
            if (obj1 != null && ((Drawable) (obj1)).getIntrinsicHeight() != 0)
            {
                b = (float)((Drawable) (obj1)).getIntrinsicWidth() / (float)((Drawable) (obj1)).getIntrinsicHeight();
                ((ImageView)nativecontentadview.getImageView()).setImageDrawable(((Drawable) (obj1)));
                if (obj == null)
                {
                    ((ImageView)nativecontentadview.getLogoView()).setImageDrawable(((Drawable) (obj1)));
                }
            }
        }
        nativecontentadview.setNativeAd(nativecontentad);
    }

}
