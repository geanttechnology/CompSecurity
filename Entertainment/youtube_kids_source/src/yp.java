// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.AutoCompleteTextView;
import com.google.android.apps.youtube.kids.activities.SearchActivity;

public final class yp
    implements Runnable
{

    private AutoCompleteTextView a;

    public yp(SearchActivity searchactivity, AutoCompleteTextView autocompletetextview)
    {
        a = autocompletetextview;
        super();
    }

    public final void run()
    {
        a.setThreshold(1);
    }
}
