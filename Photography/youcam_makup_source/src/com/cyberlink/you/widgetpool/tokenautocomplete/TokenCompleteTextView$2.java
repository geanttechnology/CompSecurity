// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.tokenautocomplete;

import android.text.Editable;

// Referenced classes of package com.cyberlink.you.widgetpool.tokenautocomplete:
//            TokenCompleteTextView

class a
    implements Runnable
{

    final Editable a;
    final TokenCompleteTextView b;

    public void run()
    {
        b.setSelection(a.length());
    }

    (TokenCompleteTextView tokencompletetextview, Editable editable)
    {
        b = tokencompletetextview;
        a = editable;
        super();
    }
}
