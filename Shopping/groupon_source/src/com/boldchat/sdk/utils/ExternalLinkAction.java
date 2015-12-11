// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;

public class ExternalLinkAction
    implements RichTextUtils.SpanConverter
{
    public static class LinkActionSpan extends ClickableSpan
    {

        private final Context mContext;
        private String mUrl;

        public void onClick(View view)
        {
            view = new Intent("android.intent.action.VIEW");
            view.setData(Uri.parse(mUrl));
            mContext.startActivity(view);
        }

        public LinkActionSpan(String s, Context context)
        {
            mUrl = s;
            mContext = context;
        }
    }


    private final Context mContext;

    public ExternalLinkAction(Context context)
    {
        mContext = context;
    }

    public volatile CharacterStyle convert(CharacterStyle characterstyle)
    {
        return convert((URLSpan)characterstyle);
    }

    public LinkActionSpan convert(URLSpan urlspan)
    {
        return new LinkActionSpan(urlspan.getURL(), mContext);
    }
}
