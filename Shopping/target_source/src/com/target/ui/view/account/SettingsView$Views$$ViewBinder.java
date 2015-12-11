// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;
import butterknife.internal.DebouncingOnClickListener;

public class _cls4.val.target
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder, final _cls4.val.target target, Object obj)
    {
        View view = (View)viewbinder.View(obj, 0x7f1005b0, "field 'notification' and method 'onSettingsViewClicked'");
        target. = view;
        view.setOnClickListener(new DebouncingOnClickListener() {

            final SettingsView.Views..ViewBinder this$0;
            final SettingsView.Views val$target;

            public void doClick(View view1)
            {
                target.onSettingsViewClicked();
            }

            
            {
                this$0 = SettingsView.Views..ViewBinder.this;
                target = views;
                super();
            }
        });
        view = (View)viewbinder.View(obj, 0x7f1005b1, "field 'notificationToggle' and method 'notificationChanged'");
        target.Toggle = (SwitchCompat)viewbinder.notificationToggle(view, 0x7f1005b1, "field 'notificationToggle'");
        ((CompoundButton)view).setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final SettingsView.Views..ViewBinder this$0;
            final SettingsView.Views val$target;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                target.notificationChanged(flag);
            }

            
            {
                this$0 = SettingsView.Views..ViewBinder.this;
                target = views;
                super();
            }
        });
        view = (View)viewbinder.View(obj, 0x7f1005b2, "field 'instoreLocation' and method 'onLocationViewClicked'");
        target.ion = view;
        view.setOnClickListener(new DebouncingOnClickListener() {

            final SettingsView.Views..ViewBinder this$0;
            final SettingsView.Views val$target;

            public void doClick(View view1)
            {
                target.onLocationViewClicked();
            }

            
            {
                this$0 = SettingsView.Views..ViewBinder.this;
                target = views;
                super();
            }
        });
        obj = (View)viewbinder.View(obj, 0x7f1005b3, "field 'instoreLocationToggle' and method 'inStoreLocationChanged'");
        target.ionToggle = (SwitchCompat)viewbinder.instoreLocationToggle(((View) (obj)), 0x7f1005b3, "field 'instoreLocationToggle'");
        ((CompoundButton)obj).setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final SettingsView.Views..ViewBinder this$0;
            final SettingsView.Views val$target;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                target.inStoreLocationChanged(flag);
            }

            
            {
                this$0 = SettingsView.Views..ViewBinder.this;
                target = views;
                super();
            }
        });
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1. = null;
        bind1.Toggle = null;
        bind1.ion = null;
        bind1.ionToggle = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public _cls4.val.target()
    {
    }
}
