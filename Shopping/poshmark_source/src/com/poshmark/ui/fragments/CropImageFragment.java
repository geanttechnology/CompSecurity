// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import com.poshmark.ui.customviews.CameraViewportRectView;
import com.poshmark.ui.customviews.CropImageSurfaceView;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment

public class CropImageFragment extends PMFragment
{

    private int CREATION_MODE;
    private Button cancelButton;
    private CropImageSurfaceView cropImageSurfaceView;
    private Button doneButton;
    private String fileName;
    boolean isNextClicked;
    private CameraViewportRectView viewportOverlay;

    public CropImageFragment()
    {
        isNextClicked = false;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        viewportOverlay = (CameraViewportRectView)getView().findViewById(0x7f0c0090);
        cropImageSurfaceView = (CropImageSurfaceView)getView().findViewById(0x7f0c00ea);
        cropImageSurfaceView.setFile(fileName);
        cropImageSurfaceView.setMode(CREATION_MODE);
        cropImageSurfaceView.setViewPortRect(viewportOverlay.getViewportRect());
        doneButton = (Button)getView().findViewById(0x7f0c00eb);
        doneButton.setOnClickListener(new android.view.View.OnClickListener() {

            final CropImageFragment this$0;

            public void onClick(View view)
            {
                if (!isNextClicked)
                {
                    isNextClicked = true;
                    view = cropImageSurfaceView.getBitmap(viewportOverlay.getViewportRect());
                    Intent intent = new Intent();
                    intent.setData(view);
                    finishActivityWithResult(-1, intent);
                }
            }

            
            {
                this$0 = CropImageFragment.this;
                super();
            }
        });
        cancelButton = (Button)getView().findViewById(0x7f0c0093);
        cancelButton.setOnClickListener(new android.view.View.OnClickListener() {

            final CropImageFragment this$0;

            public void onClick(View view)
            {
                getActivity().finish();
            }

            
            {
                this$0 = CropImageFragment.this;
                super();
            }
        });
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getArguments();
        bShouldHideActionBar = true;
        if (bundle != null)
        {
            fileName = bundle.getString("FILE");
            CREATION_MODE = bundle.getInt("CREATION_MODE");
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        return layoutinflater.inflate(0x7f030035, viewgroup, false);
    }

    public void onResume()
    {
        super.onResume();
        getActivity().getWindow().setFlags(1024, 1024);
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "crop_image_screen";
    }


}
