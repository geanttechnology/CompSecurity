// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.validation;

import android.view.View;
import com.target.ui.util.validation.a.l;
import com.target.ui.view.CustomErrorViewWrapper;

public class g
{

    public static boolean a(l l1, View view, CustomErrorViewWrapper customerrorviewwrapper)
    {
        if (l1.a())
        {
            return false;
        }
        if (!view.hasFocus())
        {
            return true;
        } else
        {
            return customerrorviewwrapper.a();
        }
    }
}
