// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import android.content.DialogInterface;

// Referenced classes of package com.adobe.mobile:
//            MessageAlert

final class message
    implements android.content.
{

    private final MessageAlert message;

    public void onCancel(DialogInterface dialoginterface)
    {
        message.viewed();
        message.isVisible = false;
    }

    public (MessageAlert messagealert)
    {
        message = messagealert;
    }
}
