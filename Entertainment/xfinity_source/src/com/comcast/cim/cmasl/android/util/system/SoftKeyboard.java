// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.system;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class SoftKeyboard
{

    public SoftKeyboard()
    {
    }

    public void hide(View view)
    {
        ((InputMethodManager)view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
