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
//            ViewBinder, NativeResponse

class NativeViewHolder
{

    static final NativeViewHolder EMPTY_VIEW_HOLDER = new NativeViewHolder();
    TextView callToActionView;
    ImageView daaIconImageView;
    ImageView iconImageView;
    ImageView mainImageView;
    View mainView;
    TextView textView;
    TextView titleView;

    private NativeViewHolder()
    {
    }

    private void addDaaIcon(final String daaClickthroughUrl)
    {
        if (daaIconImageView != null)
        {
            if (daaClickthroughUrl == null)
            {
                daaIconImageView.setImageDrawable(null);
                daaIconImageView.setOnClickListener(null);
                daaIconImageView.setVisibility(4);
                return;
            }
            final Context context = daaIconImageView.getContext();
            if (context != null)
            {
                daaIconImageView.setImageDrawable(Drawables.NATIVE_DAA_ICON.createDrawable(context));
                daaIconImageView.setOnClickListener(new android.view.View.OnClickListener() {

                    final NativeViewHolder this$0;
                    final Context val$context;
                    final String val$daaClickthroughUrl;

                    public void onClick(View view)
                    {
                        (new com.mopub.common.UrlHandler.Builder()).withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, new UrlAction[] {
                            UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK
                        }).build().handleUrl(context, daaClickthroughUrl);
                    }

            
            {
                this$0 = NativeViewHolder.this;
                context = context1;
                daaClickthroughUrl = s;
                super();
            }
                });
                daaIconImageView.setVisibility(0);
                return;
            }
        }
    }

    private void addTextView(TextView textview, String s)
    {
        if (textview == null)
        {
            MoPubLog.d((new StringBuilder("Attempted to add text (")).append(s).append(") to null TextView.").toString());
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

    static NativeViewHolder fromViewBinder(View view, ViewBinder viewbinder)
    {
        NativeViewHolder nativeviewholder = new NativeViewHolder();
        nativeviewholder.mainView = view;
        try
        {
            nativeviewholder.titleView = (TextView)view.findViewById(viewbinder.titleId);
            nativeviewholder.textView = (TextView)view.findViewById(viewbinder.textId);
            nativeviewholder.callToActionView = (TextView)view.findViewById(viewbinder.callToActionId);
            nativeviewholder.mainImageView = (ImageView)view.findViewById(viewbinder.mainImageId);
            nativeviewholder.iconImageView = (ImageView)view.findViewById(viewbinder.iconImageId);
            nativeviewholder.daaIconImageView = (ImageView)view.findViewById(viewbinder.daaIconImageId);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            MoPubLog.w("Could not cast from id in ViewBinder to expected View type", view);
            return EMPTY_VIEW_HOLDER;
        }
        return nativeviewholder;
    }

    public void setViewVisibility(int i)
    {
        if (mainView != null)
        {
            mainView.setVisibility(i);
        }
    }

    void update(NativeResponse nativeresponse)
    {
        addTextView(titleView, nativeresponse.getTitle());
        addTextView(textView, nativeresponse.getText());
        addTextView(callToActionView, nativeresponse.getCallToAction());
        nativeresponse.loadMainImage(mainImageView);
        nativeresponse.loadIconImage(iconImageView);
        addDaaIcon(nativeresponse.getDaaIconClickthroughUrl());
    }

    void updateExtras(NativeResponse nativeresponse, ViewBinder viewbinder)
    {
        if (mainView == null)
        {
            MoPubLog.w("Attempted to bind extras on a null main view.");
        } else
        {
            Iterator iterator = viewbinder.extras.keySet().iterator();
            while (iterator.hasNext()) 
            {
                String s = (String)iterator.next();
                int i = ((Integer)viewbinder.extras.get(s)).intValue();
                View view = mainView.findViewById(i);
                Object obj = nativeresponse.getExtra(s);
                if (view instanceof ImageView)
                {
                    ((ImageView)view).setImageDrawable(null);
                    nativeresponse.loadExtrasImage(s, (ImageView)view);
                } else
                if (view instanceof TextView)
                {
                    ((TextView)view).setText(null);
                    if (obj instanceof String)
                    {
                        addTextView((TextView)view, (String)obj);
                    }
                } else
                {
                    MoPubLog.d((new StringBuilder("View bound to ")).append(s).append(" should be an instance of TextView or ImageView.").toString());
                }
            }
        }
    }

}
