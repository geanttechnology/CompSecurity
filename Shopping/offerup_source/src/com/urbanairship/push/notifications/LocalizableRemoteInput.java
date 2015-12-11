// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.notifications;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.cr;
import android.support.v4.app.cs;

public class LocalizableRemoteInput
{

    private final boolean allowFreeFormInput;
    private final int choices[];
    private final Bundle extras;
    private final int labelId;
    private final String resultKey;

    private LocalizableRemoteInput(String s, int i, int ai[], boolean flag, Bundle bundle)
    {
        resultKey = s;
        labelId = i;
        choices = ai;
        allowFreeFormInput = flag;
        extras = bundle;
    }

    LocalizableRemoteInput(String s, int i, int ai[], boolean flag, Bundle bundle, _cls1 _pcls1)
    {
        this(s, i, ai, flag, bundle);
    }

    public cr createRemoteInput(Context context)
    {
        cs cs1 = (new cs(resultKey)).a(extras);
        if (choices != null)
        {
            CharSequence acharsequence[] = new CharSequence[choices.length];
            for (int i = 0; i < choices.length; i++)
            {
                acharsequence[i] = context.getText(choices[i]);
            }

            cs1.a(acharsequence);
        }
        if (labelId >= 0)
        {
            cs1.a(context.getText(labelId));
        }
        return cs1.a();
    }

    public boolean getAllowFreeFormInput()
    {
        return allowFreeFormInput;
    }

    public int[] getChoices()
    {
        return choices;
    }

    public Bundle getExtras()
    {
        return extras;
    }

    public int getLabel()
    {
        return labelId;
    }

    public String getResultKey()
    {
        return resultKey;
    }
}
