// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.customviews.PMEditListingImageSelectorView;
import com.poshmark.ui.customviews.PMListingImageView;
import com.poshmark.utils.ObjectPickupDropOff;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, CameraPreviewFragment, CameraFiltersFragment

public class EditListingImageFragment extends PMFragment
{

    public static final int DELETEIMAGE = 0;
    public static final int EDITIMAGE = 1;
    public static final int NEWIMAGE = 2;
    private int CAPTURE_IMAGE;
    private int FILTER_IMAGE;
    private boolean bIsCovershot;
    private boolean bIsNewListing;
    private ImageButton cameraButton;
    private ImageButton editButton;
    PMListingImageView image;
    PMEditListingImageSelectorView imageSelectorView;
    private Uri imageURI;
    private String imageURL;
    private Uri originalImageURI;
    private ImageButton recycleButton;

    public EditListingImageFragment()
    {
        bIsCovershot = false;
        bIsNewListing = false;
        FILTER_IMAGE = 3;
        CAPTURE_IMAGE = 4;
    }

    private void fireCameraActivity()
    {
        Intent intent = new Intent((PMActivity)getActivity(), com/poshmark/ui/PMContainerActivity);
        intent.putExtra("FRAGMENT", com/poshmark/ui/fragments/CameraPreviewFragment);
        Bundle bundle = new Bundle();
        bundle.putInt("CREATION_MODE", CameraPreviewFragment.CREATE_COVERSHOT);
        if (imageSelectorView.isCovershot())
        {
            bundle.putBoolean("IS_FIRST_IMAGE", true);
        }
        intent.putExtra("FRAGMENT_DATA", bundle);
        startActivityForResult(intent, CAPTURE_IMAGE);
    }

    private void fireCameraFiltersActivity(Uri uri)
    {
        Intent intent = new Intent((PMActivity)getActivity(), com/poshmark/ui/PMContainerActivity);
        intent.putExtra("FRAGMENT", com/poshmark/ui/fragments/CameraFiltersFragment);
        Bundle bundle = new Bundle();
        bundle.putParcelable("FILE", uri);
        intent.putExtra("FRAGMENT_DATA", bundle);
        startActivityForResult(intent, FILTER_IMAGE);
    }

    private void releaseBitmap()
    {
        ((BitmapDrawable)image.getDrawable()).getBitmap().recycle();
    }

    private void setupButtonHandlers()
    {
        recycleButton = (ImageButton)getView().findViewById(0x7f0c00f3);
        cameraButton = (ImageButton)getView().findViewById(0x7f0c00f4);
        editButton = (ImageButton)getView().findViewById(0x7f0c00f2);
        recycleButton.setOnClickListener(new android.view.View.OnClickListener() {

            final EditListingImageFragment this$0;

            public void onClick(View view)
            {
                view = new Intent();
                Bundle bundle = new Bundle();
                bundle.putInt("EDITMODE", 0);
                view.putExtras(bundle);
                finishActivityWithResult(-1, view);
            }

            
            {
                this$0 = EditListingImageFragment.this;
                super();
            }
        });
        cameraButton.setOnClickListener(new android.view.View.OnClickListener() {

            final EditListingImageFragment this$0;

            public void onClick(View view)
            {
                fireCameraActivity();
            }

            
            {
                this$0 = EditListingImageFragment.this;
                super();
            }
        });
        editButton.setOnClickListener(new android.view.View.OnClickListener() {

            final EditListingImageFragment this$0;

            public void onClick(View view)
            {
                fireCameraFiltersActivity(originalImageURI);
            }

            
            {
                this$0 = EditListingImageFragment.this;
                super();
            }
        });
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setupButtonHandlers();
        if (!bIsNewListing) goto _L2; else goto _L1
_L1:
        if (bIsCovershot)
        {
            editButton.setVisibility(0);
        } else
        {
            recycleButton.setVisibility(0);
        }
_L4:
        hideAllActionButtons(true);
        return;
_L2:
        if (!bIsCovershot)
        {
            recycleButton.setVisibility(0);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (j == -1 && (i == FILTER_IMAGE || i == CAPTURE_IMAGE))
        {
            intent = intent.getExtras();
            intent.putInt("EDITMODE", 2);
            Intent intent1 = new Intent();
            intent1.putExtras(intent);
            finishActivityWithResult(-1, intent1);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null) goto _L2; else goto _L1
_L1:
        bundle = ((Bundle) (getFragmentDataOfType(com/poshmark/ui/customviews/PMEditListingImageSelectorView)));
        if (bundle != null)
        {
            imageSelectorView = (PMEditListingImageSelectorView)bundle;
        }
_L4:
        if (imageSelectorView != null)
        {
            imageURL = imageSelectorView.getImageUrl();
            if (imageURL == null)
            {
                imageURI = imageSelectorView.getFileUri();
                originalImageURI = imageSelectorView.getOriginalFileUri();
            }
        }
        bIsCovershot = getArguments().getBoolean("COVERSHOT");
        bIsNewListing = getArguments().getBoolean("NEWLISTING");
        return;
_L2:
        bundle = (ParcelUuid)bundle.getParcelable("EDIT_MODE_IMAGEVIEW");
        if (bundle != null)
        {
            imageSelectorView = (PMEditListingImageSelectorView)ObjectPickupDropOff.pickupDataObject(bundle.getUuid());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f030039, viewgroup, false);
        image = (PMListingImageView)layoutinflater.findViewById(0x7f0c00f1);
        if (imageURL == null) goto _L2; else goto _L1
_L1:
        image.loadImage(imageURL);
_L4:
        setTitle(0x7f0600c3);
        return layoutinflater;
_L2:
        if (imageURI != null)
        {
            image.setImageBitmap(BitmapFactoryInstrumentation.decodeFile(imageURI.getPath()));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (imageSelectorView != null)
        {
            java.util.UUID uuid = ObjectPickupDropOff.getUniqueKey();
            ObjectPickupDropOff.dropOffDataObject(uuid, imageSelectorView);
            bundle.putParcelable("EDIT_MODE_IMAGEVIEW", new ParcelUuid(uuid));
        }
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "image_preview_screen";
    }



}
