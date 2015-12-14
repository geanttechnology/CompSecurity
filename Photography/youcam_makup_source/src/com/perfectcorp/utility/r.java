// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.perfectcorp.utility;

import android.text.SpannableString;
import android.text.style.ClickableSpan;

public class r extends SpannableString
{

    public r(CharSequence charsequence, ClickableSpan clickablespan)
    {
        super(charsequence);
        setSpan(clickablespan, 0, length(), 17);
    }
}
