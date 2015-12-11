// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;

public class kq
{

    private static final String a = kq.getSimpleName();
    private no b;
    private nn c;
    private Context d;

    public kq(Context context, no no, nn nn)
    {
        b = no;
        c = nn;
        d = context;
        kf.e(a, "No Connectivity called - Callstack");
        kf.a(a, new Exception());
    }

    static nn a(kq kq1)
    {
        return kq1.c;
    }

    static no b(kq kq1)
    {
        return kq1.b;
    }

    public void a()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(d);
        builder.setMessage(Html.fromHtml("<font face = 'Sans-Serif'>\nThe service is not responding.\n Please reload or check back soon.\n</font>")).setCancelable(false).setPositiveButton(Html.fromHtml("<font face = 'Sans-Serif'><b> Reload </b></font>"), new android.content.DialogInterface.OnClickListener() {

            final kq a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                kq.b(a).a();
            }

            
            {
                a = kq.this;
                super();
            }
        }).setNegativeButton(Html.fromHtml("<font face = 'Sans-Serif'>Cancel</font>"), new android.content.DialogInterface.OnClickListener() {

            final kq a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                kq.a(a).a();
                dialoginterface.dismiss();
            }

            
            {
                a = kq.this;
                super();
            }
        });
        builder.create().show();
    }

}
