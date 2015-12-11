// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.formats.multiwebviews;

import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import io.presage.utils.e;

public final class g extends WebChromeClient
{

    private String a;

    public g(String s)
    {
        a = s;
    }

    public final boolean onConsoleMessage(ConsoleMessage consolemessage)
    {
        e.a(new String[] {
            "Webviews", "[", a, "]", consolemessage.message(), "-- From line", Integer.toString(consolemessage.lineNumber()), "of", consolemessage.sourceId()
        });
        return super.onConsoleMessage(consolemessage);
    }
}
