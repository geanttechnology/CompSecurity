// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import com.poshmark.ui.customviews.CameraViewportRectView;
import com.poshmark.ui.customviews.GestureView;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment

public class GestureTester extends PMFragment
{

    private int CREATION_MODE;
    private Button cancelButton;
    CameraViewportRectView croppable_space;
    GestureView croppable_view;
    ImageView cropped_image;
    private Button doneButton;
    private String fileName;
    boolean isNextClicked;

    public GestureTester()
    {
        isNextClicked = false;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        doneButton = (Button)getView().findViewById(0x7f0c00eb);
        doneButton.setOnClickListener(new android.view.View.OnClickListener() {

            final GestureTester this$0;

            public void onClick(View view)
            {
                if (!isNextClicked)
                {
                    isNextClicked = true;
                    view = croppable_view.getCroppedImage();
                    Intent intent = new Intent();
                    intent.setData(view);
                    finishActivityWithResult(-1, intent);
                }
            }

            
            {
                this$0 = GestureTester.this;
                super();
            }
        });
        cancelButton = (Button)getView().findViewById(0x7f0c0093);
        cancelButton.setOnClickListener(new android.view.View.OnClickListener() {

            final GestureTester this$0;

            public void onClick(View view)
            {
                getActivity().finish();
            }

            
            {
                this$0 = GestureTester.this;
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
        layoutinflater = layoutinflater.inflate(0x7f030055, viewgroup, false);
        croppable_space = (CameraViewportRectView)layoutinflater.findViewById(0x7f0c015a);
        croppable_view = (GestureView)layoutinflater.findViewById(0x7f0c0159);
        cropped_image = (ImageView)layoutinflater.findViewById(0x7f0c015c);
        croppable_view.setFileName(fileName);
        croppable_view.setMode(CREATION_MODE);
        viewgroup = new com.poshmark.ui.customviews.CameraViewportRectView.CustomListener() {

            final GestureTester this$0;

            public void afterDraw()
            {
                Log.d("GestureTester", (new StringBuilder()).append(croppable_space.getViewportRect().width()).append(":").append(croppable_space.getViewportRect().height()).append(":").append(croppable_space.getViewportRect().left).append(":").append(croppable_space.getViewportRect().top).toString());
                croppable_view.setVisibility(0);
                croppable_view.setupBitmap(croppable_space.getViewportRect());
            }

            
            {
                this$0 = GestureTester.this;
                super();
            }
        };
        croppable_space.setCustomListerner(viewgroup);
        return layoutinflater;
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
