// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.web.bridge.command.data;

import android.content.Intent;
import java.net.URISyntaxException;

public class IsIntentSupportedData
{

    private Intent intent;
    private transient String intentString;

    public IsIntentSupportedData(String s)
    {
        try
        {
            intentString = s;
            intent = Intent.parseUri(s, 1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            intent = null;
        }
    }

    public Intent getIntent()
    {
        return intent;
    }

    public String getIntentString()
    {
        return intentString;
    }
}
