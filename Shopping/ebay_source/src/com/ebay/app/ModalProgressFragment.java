// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.app;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

public class ModalProgressFragment extends DialogFragment
{

    private static final String MODAL_PROGRESS_TAG = "modal_progress_tag";
    private android.content.DialogInterface.OnCancelListener listener;

    public ModalProgressFragment()
    {
    }

    public static void hide(FragmentManager fragmentmanager)
    {
        DialogFragment dialogfragment;
        if (fragmentmanager != null)
        {
            if ((dialogfragment = (DialogFragment)fragmentmanager.findFragmentByTag("modal_progress_tag")) != null)
            {
                fragmentmanager.beginTransaction().remove(dialogfragment).commitAllowingStateLoss();
                return;
            }
        }
    }

    public static void show(FragmentManager fragmentmanager, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        while (fragmentmanager == null || (ModalProgressFragment)fragmentmanager.findFragmentByTag("modal_progress_tag") != null) 
        {
            return;
        }
        Log.d("ModalProgressFragment", "showing now");
        ModalProgressFragment modalprogressfragment = new ModalProgressFragment();
        modalprogressfragment.listener = oncancellistener;
        fragmentmanager.beginTransaction().add(modalprogressfragment, "modal_progress_tag").commitAllowingStateLoss();
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        if (listener != null)
        {
            listener.onCancel(dialoginterface);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setStyle(2, 0x7f0a0280);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return layoutinflater.inflate(0x7f030079, viewgroup);
    }
}
