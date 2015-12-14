// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.events;

import com.socialin.android.constants.EventParam;

public class addParam extends addParam
{

    public addParam setOnKeyboardClose(boolean flag)
    {
        addParam(EventParam.ON_KEYBOARD_CLOSE, Boolean.valueOf(flag));
        return this;
    }

    public A(String s, String s1, String s2)
    {
        super("search");
        addParam(EventParam.SOURCE, s);
        addParam(EventParam.TYPE, s1);
        addParam(EventParam.KEY, s2);
    }
}
