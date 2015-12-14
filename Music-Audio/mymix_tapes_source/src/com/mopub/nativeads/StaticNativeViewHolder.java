// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mopub.common.logging.MoPubLog;

// Referenced classes of package com.mopub.nativeads:
//            ViewBinder

class StaticNativeViewHolder
{

    static final StaticNativeViewHolder EMPTY_VIEW_HOLDER = new StaticNativeViewHolder();
    TextView callToActionView;
    ImageView iconImageView;
    ImageView mainImageView;
    View mainView;
    ImageView privacyInformationIconImageView;
    TextView textView;
    TextView titleView;

    private StaticNativeViewHolder()
    {
    }

    static StaticNativeViewHolder fromViewBinder(View view, ViewBinder viewbinder)
    {
        StaticNativeViewHolder staticnativeviewholder = new StaticNativeViewHolder();
        staticnativeviewholder.mainView = view;
        try
        {
            staticnativeviewholder.titleView = (TextView)view.findViewById(viewbinder.titleId);
            staticnativeviewholder.textView = (TextView)view.findViewById(viewbinder.textId);
            staticnativeviewholder.callToActionView = (TextView)view.findViewById(viewbinder.callToActionId);
            staticnativeviewholder.mainImageView = (ImageView)view.findViewById(viewbinder.mainImageId);
            staticnativeviewholder.iconImageView = (ImageView)view.findViewById(viewbinder.iconImageId);
            staticnativeviewholder.privacyInformationIconImageView = (ImageView)view.findViewById(viewbinder.privacyInformationIconImageId);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            MoPubLog.w("Could not cast from id in ViewBinder to expected View type", view);
            return EMPTY_VIEW_HOLDER;
        }
        return staticnativeviewholder;
    }

}
