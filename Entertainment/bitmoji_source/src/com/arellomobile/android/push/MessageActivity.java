// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.logging.Logger;

public class MessageActivity extends Activity
{

    private static final String MESSAGE_HANDLER_KEY = ".MESSAGE";

    public MessageActivity()
    {
    }

    private void startPushMessageHandlerActivity()
    {
        Intent intent = new Intent();
        String s = (new StringBuilder()).append(getApplicationContext().getPackageName()).append(".MESSAGE").toString();
        intent.setAction(s);
        intent.setFlags(0x24000000);
        intent.putExtras(getIntent().getExtras());
        try
        {
            startActivity(intent);
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            Logger.getLogger(getClass().getSimpleName()).severe((new StringBuilder()).append("Can't launch activity. Are you sure you have an activity with '").append(s).append("' action in your manifest?").toString());
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        startPushMessageHandlerActivity();
        finish();
    }
}
