// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.graphics.Bitmap;
import android.webkit.WebIconDatabase;
import com.amazon.android.webkit.AmazonIconListener;
import com.amazon.android.webkit.AmazonWebIconDatabase;

public class AndroidWebIconDatabase extends AmazonWebIconDatabase
{

    public AndroidWebIconDatabase()
    {
    }

    public void close()
    {
        WebIconDatabase.getInstance().close();
    }

    public void open(String s)
    {
        WebIconDatabase.getInstance().open(s);
    }

    public void releaseIconForPageUrl(String s)
    {
        WebIconDatabase.getInstance().releaseIconForPageUrl(s);
    }

    public void removeAllIcons()
    {
        WebIconDatabase.getInstance().removeAllIcons();
    }

    public void requestIconForPageUrl(String s, final AmazonIconListener amazonIconlistener)
    {
        amazonIconlistener = new android.webkit.WebIconDatabase.IconListener() {

            final AndroidWebIconDatabase this$0;
            final AmazonIconListener val$amazonIconlistener;

            public void onReceivedIcon(String s1, Bitmap bitmap)
            {
                amazonIconlistener.onReceivedIcon(s1, bitmap);
            }

            
            {
                this$0 = AndroidWebIconDatabase.this;
                amazonIconlistener = amazoniconlistener;
                super();
            }
        };
        WebIconDatabase.getInstance().requestIconForPageUrl(s, amazonIconlistener);
    }

    public void retainIconForPageUrl(String s)
    {
        WebIconDatabase.getInstance().retainIconForPageUrl(s);
    }
}
