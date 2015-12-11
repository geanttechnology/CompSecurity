// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import android.content.Context;
import android.content.Intent;
import com.espn.androidplayersdk.utilities.Utils;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            JSONParserInterface, DataManager

abstract class JSONParserAbstract
    implements JSONParserInterface
{

    JSONParserAbstract()
    {
    }

    protected void sendBroadcast(String s)
    {
        try
        {
            Intent intent = new Intent();
            intent.setAction(s);
            DataManager.mCtx.sendBroadcast(intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        if ((new StringBuilder("Error sending broadcast():")).append(s.getMessage()).toString() != null)
        {
            s = s.getMessage();
        } else
        {
            s = "";
        }
        Utils.sdkLog(s, 5, null);
    }
}
