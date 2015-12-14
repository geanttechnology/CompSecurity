// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.ui.cab;

import android.content.Context;
import android.content.res.Resources;

// Referenced classes of package com.amazon.gallery.thor.app.ui.cab:
//            TitleUpdater

public class MultiSelectTitleUpdater
    implements TitleUpdater
{

    private final Context context;

    public MultiSelectTitleUpdater(Context context1)
    {
        context = context1;
    }

    public String getSubTitle(int i)
    {
        return (new StringBuilder()).append(i).append(" ").append(context.getResources().getString(0x7f0e0083)).toString();
    }

    public String getTitle()
    {
        return context.getResources().getString(0x7f0e0084);
    }
}
