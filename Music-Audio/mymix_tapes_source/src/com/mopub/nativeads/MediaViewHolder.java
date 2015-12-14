// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mopub.common.logging.MoPubLog;

// Referenced classes of package com.mopub.nativeads:
//            MediaViewBinder, MediaLayout

class MediaViewHolder
{

    static final MediaViewHolder EMPTY_MEDIA_VIEW_HOLDER = new MediaViewHolder();
    TextView callToActionView;
    ImageView iconImageView;
    View mainView;
    MediaLayout mediaLayout;
    ImageView privacyInformationIconImageView;
    TextView textView;
    TextView titleView;

    private MediaViewHolder()
    {
    }

    static MediaViewHolder fromViewBinder(View view, MediaViewBinder mediaviewbinder)
    {
        MediaViewHolder mediaviewholder = new MediaViewHolder();
        mediaviewholder.mainView = view;
        try
        {
            mediaviewholder.titleView = (TextView)view.findViewById(mediaviewbinder.titleId);
            mediaviewholder.textView = (TextView)view.findViewById(mediaviewbinder.textId);
            mediaviewholder.callToActionView = (TextView)view.findViewById(mediaviewbinder.callToActionId);
            mediaviewholder.mediaLayout = (MediaLayout)view.findViewById(mediaviewbinder.mediaLayoutId);
            mediaviewholder.iconImageView = (ImageView)view.findViewById(mediaviewbinder.iconImageId);
            mediaviewholder.privacyInformationIconImageView = (ImageView)view.findViewById(mediaviewbinder.privacyInformationIconImageId);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            MoPubLog.w("Could not cast from id in MediaViewBinder to expected View type", view);
            return EMPTY_MEDIA_VIEW_HOLDER;
        }
        return mediaviewholder;
    }

}
