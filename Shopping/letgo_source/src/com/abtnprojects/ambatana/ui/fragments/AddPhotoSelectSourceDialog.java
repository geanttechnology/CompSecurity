// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.f;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;

public class AddPhotoSelectSourceDialog extends f
{
    public static interface a
    {

        public abstract void c_();

        public abstract void d_();
    }


    private a aj;

    public AddPhotoSelectSourceDialog()
    {
    }

    public View a(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f04002c, viewgroup, false);
    }

    public void a(Activity activity)
    {
        super.a(activity);
        if (activity instanceof a)
        {
            aj = (a)activity;
            return;
        } else
        {
            throw new IllegalArgumentException("Activity must implement OnDialogButtonClick");
        }
    }

    public void a(Bundle bundle)
    {
        super.a(bundle);
        a(1, 0);
    }

    public void a(View view, Bundle bundle)
    {
        super.a(view, bundle);
        ButterKnife.bind(this, view);
    }

    public void d()
    {
        super.d();
        aj = null;
    }

    void onCameraButtonClicked()
    {
        if (aj != null)
        {
            aj.d_();
            a();
        }
    }

    void onGalleryButtonClicked()
    {
        if (aj != null)
        {
            aj.c_();
            a();
        }
    }
}
