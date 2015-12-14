// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.tokenautocomplete;

import android.content.Context;
import android.widget.TextView;

// Referenced classes of package com.cyberlink.you.widgetpool.tokenautocomplete:
//            h

public class b extends h
{

    public String a;

    public b(int i, Context context, int j, int k, int l)
    {
        super(new TextView(context), l);
        a = "";
        context = (TextView)b;
        context.setTextColor(j);
        context.setTextSize(0, k);
        a(i);
    }

    public void a(int i)
    {
        a = (new StringBuilder()).append("+").append(i).toString();
        ((TextView)b).setText(a);
    }
}
