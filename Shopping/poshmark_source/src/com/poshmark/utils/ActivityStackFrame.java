// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import com.poshmark.ui.fragments.PMFragment;

public class ActivityStackFrame
{

    public PMFragment fragment;
    public android.app.ActionBar.Tab tab;

    public ActivityStackFrame(PMFragment pmfragment, android.app.ActionBar.Tab tab1)
    {
        fragment = pmfragment;
        tab = tab1;
    }
}
