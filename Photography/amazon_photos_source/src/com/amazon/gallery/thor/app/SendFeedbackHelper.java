// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SendFeedbackHelper
{

    private static Map MARKETPLACE_TO_FEEDBACK_EMAILS;

    public static Intent getIntentForSendFeedback(Context context, String s)
    {
        String s1 = (String)MARKETPLACE_TO_FEEDBACK_EMAILS.get(s);
        s = s1;
        if (s1 == null)
        {
            s = "clouddrive-android-feedback@amazon.com";
        }
        context = Uri.parse(String.format("mailto:%1$s?subject=%2$s", new Object[] {
            s, context.getString(0x7f0e01de, new Object[] {
                context.getString(0x7f0e01b4)
            })
        }));
        s = new Intent("android.intent.action.SENDTO");
        s.setData(context);
        return s;
    }

    static 
    {
        HashMap hashmap = new HashMap();
        hashmap.put("www.amazon.com", "clouddrive-android-feedback@amazon.com");
        hashmap.put("www.amazon.co.uk", "clouddrive-android-feedback@amazon.co.uk");
        hashmap.put("www.amazon.de", "clouddrive-android-feedback@amazon.de");
        hashmap.put("www.amazon.fr", "clouddrive-android-feedback@amazon.fr");
        hashmap.put("www.amazon.it", "clouddrive-android-feedback@amazon.it");
        hashmap.put("www.amazon.es", "clouddrive-android-feedback@amazon.es");
        hashmap.put("www.amazon.co.jp", "clouddrive-android-feedback@amazon.co.jp");
        hashmap.put("www.amazon.cn", "clouddrive-android-feedback@amazon.cn");
        hashmap.put("www.amazon.ca", "clouddrive-android-feedback@amazon.ca");
        hashmap.put("www.amazon.com.au", "clouddrive-android-feedback@amazon.au");
        hashmap.put("www.amazon.com.br", "clouddrive-android-feedback@amazon.com.br");
        hashmap.put("www.amazon.in", "clouddrive-android-feedback@amazon.com");
        MARKETPLACE_TO_FEEDBACK_EMAILS = Collections.unmodifiableMap(hashmap);
    }
}
