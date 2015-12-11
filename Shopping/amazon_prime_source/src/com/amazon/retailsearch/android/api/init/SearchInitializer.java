// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.init;

import android.content.Context;
import java.util.Locale;

// Referenced classes of package com.amazon.retailsearch.android.api.init:
//            RetailSearchInitSettings

public interface SearchInitializer
{

    public abstract void initialize(Context context);

    public abstract void initialize(Context context, RetailSearchInitSettings retailsearchinitsettings);

    public abstract void reset();

    public abstract void reset(String s);

    public abstract void reset(Locale locale);

    public abstract void reset(Locale locale, boolean flag);
}
