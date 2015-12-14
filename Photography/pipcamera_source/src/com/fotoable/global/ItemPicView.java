// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.global;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.pipcamera.application.PIPCameraApplication;
import kc;

public class ItemPicView extends FrameLayout
{

    public static final int ITEMTAG_NONE = 0;
    public static final int ITEMTAG_PICPHOTO = 1;
    public static final int ITEMTAG_TAKEPHOTO = 2;
    kc lisener;
    Context mContext;
    ImageView picPhotoImageView;
    FrameLayout picPhotoLayout;
    ImageView takePhotoImageView;
    FrameLayout takePhotoLayout;

    public ItemPicView(Context context)
    {
        super(context);
        init(context);
    }

    public ItemPicView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init(context);
    }

    public ItemPicView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init(context);
    }

    private void init(Context context)
    {
        mContext = context;
        context = (ViewGroup)View.inflate(getContext(), 0x7f0300c3, this);
        ((FrameLayout)context.findViewById(0x7f0c02f8)).setOnClickListener(new android.view.View.OnClickListener() {

            final ItemPicView a;

            public void onClick(View view)
            {
                a.onBackgroundClicke();
            }

            
            {
                a = ItemPicView.this;
                super();
            }
        });
        picPhotoLayout = (FrameLayout)context.findViewById(0x7f0c02f9);
        picPhotoLayout.setOnClickListener(new android.view.View.OnClickListener() {

            final ItemPicView a;

            public void onClick(View view)
            {
                a.onPicPhotoItemClicked();
            }

            
            {
                a = ItemPicView.this;
                super();
            }
        });
        picPhotoImageView = (ImageView)context.findViewById(0x7f0c02fa);
        takePhotoLayout = (FrameLayout)context.findViewById(0x7f0c02fb);
        takePhotoLayout.setOnClickListener(new android.view.View.OnClickListener() {

            final ItemPicView a;

            public void onClick(View view)
            {
                a.onTakePhotoItemClicked();
            }

            
            {
                a = ItemPicView.this;
                super();
            }
        });
        takePhotoImageView = (ImageView)context.findViewById(0x7f0c02fc);
    }

    private void onBackgroundClicke()
    {
        if (lisener != null)
        {
            lisener.a(0);
        }
    }

    private void onPicPhotoItemClicked()
    {
        if (lisener != null)
        {
            lisener.a(1);
        }
    }

    private void onTakePhotoItemClicked()
    {
        if (lisener != null)
        {
            lisener.a(2);
        }
    }

    private void tagAnimation(View view, int i, long l, long l1, boolean flag)
    {
        Animation animation = AnimationUtils.loadAnimation(PIPCameraApplication.a, i);
        animation.setDuration(l);
        animation.setStartOffset(l1);
        animation.setAnimationListener(new android.view.animation.Animation.AnimationListener(flag, view) {

            final boolean a;
            final View b;
            final ItemPicView c;

            public void onAnimationEnd(Animation animation1)
            {
                if (a)
                {
                    b.setVisibility(0);
                    return;
                } else
                {
                    b.setVisibility(4);
                    return;
                }
            }

            public void onAnimationRepeat(Animation animation1)
            {
            }

            public void onAnimationStart(Animation animation1)
            {
            }

            
            {
                c = ItemPicView.this;
                a = flag;
                b = view;
                super();
            }
        });
        view.startAnimation(animation);
    }

    public void HiddenBtnTagSelAnim()
    {
        tagAnimation(picPhotoLayout, 0x7f040031, 300L, 0L, false);
        tagAnimation(takePhotoLayout, 0x7f040031, 300L, 100L, false);
    }

    public void ShowBtnTagSelAnim()
    {
        tagAnimation(picPhotoLayout, 0x7f040030, 300L, 0L, true);
        tagAnimation(takePhotoLayout, 0x7f040030, 300L, 100L, true);
    }

    public void setItemPicLisener(kc kc1)
    {
        lisener = kc1;
    }

    public void setItemsBackground(int i, int j)
    {
        picPhotoImageView.setBackgroundResource(i);
        takePhotoImageView.setBackgroundResource(j);
    }



}
