// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.registry;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import com.target.ui.view.CustomErrorViewWrapper;

public class 
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder,  , Object obj)
    {
        .Wrapper = (CustomErrorViewWrapper)viewbinder.registryTypeWrapper((View)viewbinder.registryTypeWrapper(obj, 0x7f100566, "field 'registryTypeWrapper'"), 0x7f100566, "field 'registryTypeWrapper'");
        .Spinner = (Spinner)viewbinder.registryTypeSpinner((View)viewbinder.registryTypeSpinner(obj, 0x7f100568, "field 'registryTypeSpinner'"), 0x7f100568, "field 'registryTypeSpinner'");
        .Spinner = (CustomErrorViewWrapper)viewbinder.cityWrapper((View)viewbinder.cityWrapper(obj, 0x7f100569, "field 'cityWrapper'"), 0x7f100569, "field 'cityWrapper'");
        .Spinner = (EditText)viewbinder.city((View)viewbinder.city(obj, 0x7f10056a, "field 'city'"), 0x7f10056a, "field 'city'");
        . = (CustomErrorViewWrapper)viewbinder.stateWrapper((View)viewbinder.stateWrapper(obj, 0x7f10056b, "field 'stateWrapper'"), 0x7f10056b, "field 'stateWrapper'");
        . = (Spinner)viewbinder.stateSpinner((View)viewbinder.stateSpinner(obj, 0x7f10056d, "field 'stateSpinner'"), 0x7f10056d, "field 'stateSpinner'");
        .pper = (CustomErrorViewWrapper)viewbinder.startDateWrapper((View)viewbinder.startDateWrapper(obj, 0x7f10056e, "field 'startDateWrapper'"), 0x7f10056e, "field 'startDateWrapper'");
        .pper = (EditText)viewbinder.startDate((View)viewbinder.startDate(obj, 0x7f10056f, "field 'startDate'"), 0x7f10056f, "field 'startDate'");
        .ePicker = (ImageView)viewbinder.startDateDatePicker((View)viewbinder.startDateDatePicker(obj, 0x7f100570, "field 'startDateDatePicker'"), 0x7f100570, "field 'startDateDatePicker'");
        .er = (CustomErrorViewWrapper)viewbinder.endDateWrapper((View)viewbinder.endDateWrapper(obj, 0x7f100571, "field 'endDateWrapper'"), 0x7f100571, "field 'endDateWrapper'");
        .er = (EditText)viewbinder.endDate((View)viewbinder.endDate(obj, 0x7f100572, "field 'endDate'"), 0x7f100572, "field 'endDate'");
        .icker = (ImageView)viewbinder.endDateDatePicker((View)viewbinder.endDateDatePicker(obj, 0x7f100573, "field 'endDateDatePicker'"), 0x7f100573, "field 'endDateDatePicker'");
        . = (CustomErrorViewWrapper)viewbinder.emailWrapper((View)viewbinder.emailWrapper(obj, 0x7f100574, "field 'emailWrapper'"), 0x7f100574, "field 'emailWrapper'");
        . = (EditText)viewbinder.email((View)viewbinder.email(obj, 0x7f100575, "field 'email'"), 0x7f100575, "field 'email'");
    }

    public volatile void bind(butterknife.ews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.Wrapper = null;
        bind1.Spinner = null;
        bind1.Spinner = null;
        bind1.Spinner = null;
        bind1. = null;
        bind1. = null;
        bind1.pper = null;
        bind1.pper = null;
        bind1.ePicker = null;
        bind1.er = null;
        bind1.er = null;
        bind1.icker = null;
        bind1. = null;
        bind1. = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
