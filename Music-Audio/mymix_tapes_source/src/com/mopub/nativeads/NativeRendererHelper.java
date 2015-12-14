// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Drawables;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.mopub.nativeads:
//            NativeImageHelper

public class NativeRendererHelper
{

    public NativeRendererHelper()
    {
    }

    public static void addCtaButton(TextView textview, View view, String s)
    {
        addTextView(textview, s);
        if (textview == null || view == null)
        {
            return;
        } else
        {
            textview.setOnClickListener(new android.view.View.OnClickListener(view) {

                final View val$rootView;

                public void onClick(View view1)
                {
                    rootView.performClick();
                }

            
            {
                rootView = view;
                super();
            }
            });
            return;
        }
    }

    public static void addPrivacyInformationIcon(ImageView imageview, String s)
    {
        if (imageview != null)
        {
            if (s == null)
            {
                imageview.setImageDrawable(null);
                imageview.setOnClickListener(null);
                imageview.setVisibility(4);
                return;
            }
            Context context = imageview.getContext();
            if (context != null)
            {
                imageview.setImageDrawable(Drawables.NATIVE_PRIVACY_INFORMATION_ICON.createDrawable(context));
                imageview.setOnClickListener(new android.view.View.OnClickListener(context, s) {

                    final Context val$context;
                    final String val$privacyInformationClickthroughUrl;

                    public void onClick(View view)
                    {
                        (new com.mopub.common.UrlHandler.Builder()).withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, new UrlAction[] {
                            UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK
                        }).build().handleUrl(context, privacyInformationClickthroughUrl);
                    }

            
            {
                context = context1;
                privacyInformationClickthroughUrl = s;
                super();
            }
                });
                imageview.setVisibility(0);
                return;
            }
        }
    }

    public static void addTextView(TextView textview, String s)
    {
        if (textview == null)
        {
            MoPubLog.d((new StringBuilder()).append("Attempted to add text (").append(s).append(") to null TextView.").toString());
            return;
        }
        textview.setText(null);
        if (s == null)
        {
            MoPubLog.d("Attempted to set TextView contents to null.");
            return;
        } else
        {
            textview.setText(s);
            return;
        }
    }

    public static void updateExtras(View view, Map map, Map map1)
    {
        if (view == null)
        {
            MoPubLog.w("Attempted to bind extras on a null main view.");
        } else
        {
            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()) 
            {
                Object obj = (String)iterator.next();
                View view1 = view.findViewById(((Integer)map.get(obj)).intValue());
                Object obj1 = map1.get(obj);
                if (view1 instanceof ImageView)
                {
                    ((ImageView)view1).setImageDrawable(null);
                    obj = map1.get(obj);
                    if (obj != null && (obj instanceof String))
                    {
                        NativeImageHelper.loadImageView((String)obj, (ImageView)view1);
                    }
                } else
                if (view1 instanceof TextView)
                {
                    ((TextView)view1).setText(null);
                    if (obj1 instanceof String)
                    {
                        addTextView((TextView)view1, (String)obj1);
                    }
                } else
                {
                    MoPubLog.d((new StringBuilder()).append("View bound to ").append(((String) (obj))).append(" should be an instance of TextView or ImageView.").toString());
                }
            }
        }
    }
}
