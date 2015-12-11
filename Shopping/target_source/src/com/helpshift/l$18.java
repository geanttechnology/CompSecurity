// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.helpshift.f.a;
import com.helpshift.h.e;
import com.helpshift.i.h;
import com.helpshift.i.k;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Referenced classes of package com.helpshift:
//            l, s

class <init> extends Handler
{

    final String a;
    final l b;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        int i;
        int j;
        try
        {
            message = e.a(a);
            i = message.h();
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            Log.d("HelpShiftDebug", "rfrAccepted", message);
            return;
        }
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        if (!a.equals(b.a.k()))
        {
            j = (int)h.a.parse(message.e()).getTime();
            k.a(l.c(b), a, j, i, "inapp", k.a(l.c(b)));
        }
    }

    ption(l l1, String s1)
    {
        b = l1;
        a = s1;
        super();
    }
}
