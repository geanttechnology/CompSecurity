// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import java.util.Comparator;
import java.util.Locale;

// Referenced classes of package co.vine.android:
//            LocaleDialog

private class <init>
    implements Comparator
{

    final LocaleDialog this$0;

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((Locale)obj, (Locale)obj1);
    }

    public int compare(Locale locale, Locale locale1)
    {
        return (new StringBuilder()).append(locale.getLanguage()).append("-").append(locale.getCountry()).toString().compareTo((new StringBuilder()).append(locale1.getLanguage()).append("-").append(locale1.getCountry()).toString());
    }

    private ()
    {
        this$0 = LocaleDialog.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
