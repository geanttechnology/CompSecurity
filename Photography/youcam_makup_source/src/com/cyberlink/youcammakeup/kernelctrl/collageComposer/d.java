// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.collageComposer;

import android.content.DialogInterface;
import android.widget.DatePicker;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.collageComposer:
//            b, c

class d
    implements android.app.DatePickerDialog.OnDateSetListener, android.content.DialogInterface.OnCancelListener, android.content.DialogInterface.OnDismissListener, android.content.DialogInterface.OnShowListener
{

    final b a;
    private boolean b;
    private final Calendar c;

    private d(b b1)
    {
        a = b1;
        super();
        b = false;
        c = Calendar.getInstance();
    }

    d(b b1, b._cls1 _pcls1)
    {
        this(b1);
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        b = true;
    }

    public void onDateSet(DatePicker datepicker, int i, int j, int k)
    {
        c.set(i, j, k);
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        if (!b)
        {
            com.cyberlink.youcammakeup.kernelctrl.collageComposer.b.a(a, c.getTimeInMillis());
            for (dialoginterface = com.cyberlink.youcammakeup.kernelctrl.collageComposer.b.a(a).iterator(); dialoginterface.hasNext(); ((c)dialoginterface.next()).a(com.cyberlink.youcammakeup.kernelctrl.collageComposer.b.b(a))) { }
        }
    }

    public void onShow(DialogInterface dialoginterface)
    {
        b = false;
    }
}
