// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.smule.android.c.a;
import com.smule.android.c.i;
import com.smule.android.c.n;
import com.smule.android.c.o;
import com.smule.magicpiano.PianoCoreBridge;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            af

public class ae extends DialogFragment
{

    private static final String a = com/smule/pianoandroid/magicpiano/ae.getName();
    private static String b;
    private af c;
    private Button d;
    private Button e;
    private EditText f;
    private AsyncTask g;

    public ae()
    {
    }

    static EditText a(ae ae1)
    {
        return ae1.f;
    }

    static ae a(String s)
    {
        b = s;
        s = new ae();
        s.setStyle(1, 0);
        return s;
    }

    static String a()
    {
        return b;
    }

    static AsyncTask b(ae ae1)
    {
        return ae1.g;
    }

    private void b()
    {
        if (isResumed())
        {
            if (c != null)
            {
                c.a();
            }
            dismiss();
        }
    }

    static void c(ae ae1)
    {
        ae1.b();
    }

    public void a(FragmentManager fragmentmanager, String s, AsyncTask asynctask)
    {
        g = asynctask;
        super.show(fragmentmanager, s);
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        b();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03004f, null, false);
        getDialog().setCanceledOnTouchOutside(false);
        f = (EditText)layoutinflater.findViewById(0x7f0a01a2);
        e = (Button)layoutinflater.findViewById(0x7f0a01a4);
        e.setOnClickListener(new android.view.View.OnClickListener() {

            final ae a;

            public void onClick(View view)
            {
                com.smule.android.c.a.b(com.smule.pianoandroid.magicpiano.ae.a(), o.b, n.a, i.a, PianoCoreBridge.getEnsembleAnalyticsType());
                ae.b(a).execute(new String[] {
                    com.smule.pianoandroid.magicpiano.ae.a(a).getText().toString()
                });
                a.dismiss();
            }

            
            {
                a = ae.this;
                super();
            }
        });
        d = (Button)layoutinflater.findViewById(0x7f0a01a3);
        d.setOnClickListener(new android.view.View.OnClickListener() {

            final ae a;

            public void onClick(View view)
            {
                ae.c(a);
            }

            
            {
                a = ae.this;
                super();
            }
        });
        return layoutinflater;
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        super.onDismiss(dialoginterface);
    }

}
