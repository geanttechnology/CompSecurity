// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.view.util;

import android.content.DialogInterface;

// Referenced classes of package com.ebay.common.view.util:
//            DialogManager

static final class tener
    implements android.content.OnClickListener
{

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.cancel();
    }

    tener()
    {
    }
}
