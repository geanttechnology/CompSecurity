// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.outfitbuilder.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bitstrips.outfitbuilder.managers.OBUrlsManager;
import com.bitstrips.outfitbuilder.models.OBAvatarData;
import com.bitstrips.outfitbuilder.models.OBBrand;
import com.bitstrips.outfitbuilder.models.OBOutfit;
import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.lang.ref.WeakReference;

public class FittingRoomPreviewView extends RelativeLayout
{
    public static interface Listener
    {

        public abstract void onAssetLoadingError();

        public abstract void onOutfitLoaded(OBOutfit oboutfit);
    }


    private static final Integer AVATAR_BODY_TAG = Integer.valueOf(2);
    private static final Integer HEAD_BACK_TAG = Integer.valueOf(1);
    private static final Integer HEAD_FRONT_TAG = Integer.valueOf(0);
    Context applicationContext;
    boolean avatarIsVisible;
    ImageView avatarPreviewImageView;
    ImageView backgroundImageView;
    int currentBrandId;
    String currentSublogo;
    TextView descriptionTextView;
    ImageView headBackImageView;
    ImageView headFrontImageView;
    ImageView sublogoImageView;
    boolean viewsReady[] = {
        0, 0, 0
    };

    public FittingRoomPreviewView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        applicationContext = getContext().getApplicationContext();
        currentBrandId = 0;
        currentSublogo = null;
        avatarIsVisible = false;
        ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(com.bitstrips.outfitbuilder.R.layout.fitting_room_preview, this, true);
        headBackImageView = (ImageView)findViewById(com.bitstrips.outfitbuilder.R.id.avatar_preview_head_back);
        headFrontImageView = (ImageView)findViewById(com.bitstrips.outfitbuilder.R.id.avatar_preview_head_front);
        avatarPreviewImageView = (ImageView)findViewById(com.bitstrips.outfitbuilder.R.id.avatar_preview_body);
        backgroundImageView = (ImageView)findViewById(com.bitstrips.outfitbuilder.R.id.fitting_room_background);
        sublogoImageView = (ImageView)findViewById(com.bitstrips.outfitbuilder.R.id.fitting_room_preview_sublogo);
        descriptionTextView = (TextView)findViewById(com.bitstrips.outfitbuilder.R.id.fitting_room_preview_description);
        headBackImageView.setVisibility(4);
        headFrontImageView.setVisibility(4);
        avatarPreviewImageView.setVisibility(4);
        headBackImageView.setTag(HEAD_BACK_TAG);
        headFrontImageView.setTag(HEAD_FRONT_TAG);
        avatarPreviewImageView.setTag(AVATAR_BODY_TAG);
    }

    private void centerCropImageIntoImageView(String s, ImageView imageview, boolean flag, Callback callback)
    {
        if (flag)
        {
            Picasso.with(applicationContext).load(s).fit().centerCrop().noFade().into(imageview, callback);
            return;
        } else
        {
            Picasso.with(applicationContext).load(s).memoryPolicy(MemoryPolicy.NO_STORE, new MemoryPolicy[0]).fit().centerCrop().noFade().into(imageview, callback);
            return;
        }
    }

    private void centerCropOptionalImageIntoImageView(String s, ImageView imageview, boolean flag)
    {
        centerCropImageIntoImageView(s, imageview, flag, null);
    }

    private void centerCropRequiredImageIntoImageView(String s, final ImageView imageView, boolean flag)
    {
        centerCropImageIntoImageView(s, imageView, flag, new Callback() {

            final FittingRoomPreviewView this$0;
            final ImageView val$imageView;
            final WeakReference val$weakActivity;

            public void onError()
            {
                Listener listener = (Listener)weakActivity.get();
                if (listener != null)
                {
                    listener.onAssetLoadingError();
                }
            }

            public void onSuccess()
            {
                showAvatarWhenReady(imageView);
            }

            
            {
                this$0 = FittingRoomPreviewView.this;
                imageView = imageview;
                weakActivity = weakreference;
                super();
            }
        });
    }

    private void setBrandData(OBBrand obbrand)
    {
        if (currentBrandId == obbrand.getId())
        {
            return;
        } else
        {
            currentBrandId = obbrand.getId();
            Picasso.with(applicationContext).load(obbrand.getStoreBackground()).memoryPolicy(MemoryPolicy.NO_STORE, new MemoryPolicy[0]).fit().noPlaceholder().noFade().into(backgroundImageView);
            return;
        }
    }

    private void showAvatarWhenReady(ImageView imageview)
    {
        if (!avatarIsVisible) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((imageview = (Integer)imageview.getTag()) != null)
        {
            viewsReady[imageview.intValue()] = true;
            int i = 0;
label0:
            do
            {
label1:
                {
                    if (i >= viewsReady.length)
                    {
                        break label1;
                    }
                    if (!viewsReady[i])
                    {
                        break label0;
                    }
                    i++;
                }
            } while (true);
        }
        if (true) goto _L1; else goto _L3
_L3:
        avatarIsVisible = true;
        headBackImageView.setVisibility(0);
        headFrontImageView.setVisibility(0);
        avatarPreviewImageView.setVisibility(0);
        return;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        Picasso picasso = Picasso.with(applicationContext);
        picasso.cancelRequest(headBackImageView);
        picasso.cancelRequest(headFrontImageView);
        picasso.cancelRequest(avatarPreviewImageView);
        picasso.cancelRequest(sublogoImageView);
        picasso.cancelRequest(backgroundImageView);
        headBackImageView.setImageBitmap(null);
        headFrontImageView.setImageBitmap(null);
        avatarPreviewImageView.setImageBitmap(null);
        backgroundImageView.setImageBitmap(null);
    }

    public void setHeadData(String s)
    {
        String s1 = OBUrlsManager.getInstance().getHeadBackUrl(s);
        s = OBUrlsManager.getInstance().getHeadFrontUrl(s);
        centerCropRequiredImageIntoImageView(s1, headBackImageView, false);
        centerCropRequiredImageIntoImageView(s, headFrontImageView, false);
    }

    public void setNakedAvatar(OBAvatarData obavatardata)
    {
        obavatardata = OBUrlsManager.getInstance().getNakedOutfit(obavatardata);
        Picasso.with(getContext()).cancelRequest(avatarPreviewImageView);
        centerCropRequiredImageIntoImageView(obavatardata, avatarPreviewImageView, true);
    }

    public void setOutfitData(OBAvatarData obavatardata, final OBOutfit outfit)
    {
        final WeakReference weakActivity = new WeakReference((Listener)getContext());
        setBrandData(outfit.getBrand());
        obavatardata = OBUrlsManager.getInstance().getOutfitUrl(outfit.getId(), obavatardata);
        Picasso.with(applicationContext).load(obavatardata).fit().centerCrop().noFade().noPlaceholder().into(avatarPreviewImageView, new Callback() {

            final FittingRoomPreviewView this$0;
            final OBOutfit val$outfit;
            final WeakReference val$weakActivity;

            public void onError()
            {
                Listener listener = (Listener)weakActivity.get();
                if (listener != null)
                {
                    listener.onAssetLoadingError();
                }
            }

            public void onSuccess()
            {
                showAvatarWhenReady(avatarPreviewImageView);
                Listener listener = (Listener)weakActivity.get();
                if (listener != null)
                {
                    listener.onOutfitLoaded(outfit);
                }
            }

            
            {
                this$0 = FittingRoomPreviewView.this;
                weakActivity = weakreference;
                outfit = oboutfit;
                super();
            }
        });
        obavatardata = outfit.getSublogoURL();
        if (obavatardata != null) goto _L2; else goto _L1
_L1:
        currentSublogo = null;
        sublogoImageView.setImageBitmap(null);
_L4:
        descriptionTextView.setText(outfit.getDescription());
        return;
_L2:
        if (!obavatardata.equals(currentSublogo))
        {
            currentSublogo = obavatardata;
            Picasso.with(applicationContext).load(obavatardata).memoryPolicy(MemoryPolicy.NO_STORE, new MemoryPolicy[0]).fit().centerInside().noPlaceholder().noFade().into(sublogoImageView);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }


}
