// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ag.a;

import android.util.Patterns;
import com.shazam.model.account.EmailValidator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
    implements EmailValidator
{

    public a()
    {
    }

    public final boolean a(String s)
    {
        return Patterns.EMAIL_ADDRESS.matcher(s).matches();
    }
}
