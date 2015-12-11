// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.view.util;

import android.content.Context;
import android.widget.ArrayAdapter;

// Referenced classes of package com.ebay.common.view.util:
//            DialogManager

public static final class context extends android.support.v7.app.er
{

    private final Context context;

    public android.support.v7.app.er setSingleChoiceItems(CharSequence acharsequence[], int i, android.content.ogBuilder ogbuilder)
    {
        return super.ceItems(new ArrayAdapter(context, 0x7f0301f2, 0x1020014, acharsequence), i, ogbuilder);
    }

    public (Context context1)
    {
        super(context1);
        context = context1;
    }
}
