// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;

public class kr
{

    private Context a;
    private nb b;
    private String c;

    public kr(Context context, String s)
    {
        a = context;
        c = s;
        b = nb.a();
    }

    static String a(kr kr1)
    {
        return kr1.c;
    }

    static String a(kr kr1, String s)
    {
        kr1.c = s;
        return s;
    }

    static nb b(kr kr1)
    {
        return kr1.b;
    }

    static Context c(kr kr1)
    {
        return kr1.a;
    }

    public void a()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(a);
        builder.setMessage(Html.fromHtml("<font face = 'Sans-Serif'>You will be redirected to a CitiBank site to manage your Best Buy credit card</font>")).setCancelable(false).setPositiveButton(Html.fromHtml("<font face = 'Sans-Serif'><b>Continue</b></font>"), new android.content.DialogInterface.OnClickListener() {

            final kr a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                if (kr.a(a) == null || kr.a(a).isEmpty())
                {
                    kr.a(a, kr.b(a).d());
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(kr.a(a)));
                kr.c(a).startActivity(intent);
                dialoginterface.cancel();
            }

            
            {
                a = kr.this;
                super();
            }
        }).setNegativeButton(Html.fromHtml("<font face = 'Sans-Serif'>Cancel</font>"), new android.content.DialogInterface.OnClickListener() {

            final kr a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.cancel();
            }

            
            {
                a = kr.this;
                super();
            }
        });
        builder.create().show();
    }

    public void b()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(a);
        builder.setMessage(Html.fromHtml("<font face = 'Sans-Serif'>These terms & conditions will be downloaded to your device.</font>")).setCancelable(false).setPositiveButton(Html.fromHtml("<font face = 'Sans-Serif'><b>Continue</b></font>"), new android.content.DialogInterface.OnClickListener() {

            final kr a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                if (kr.a(a) == null || kr.a(a).isEmpty())
                {
                    kr.a(a, kr.b(a).d());
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(kr.a(a)));
                kr.c(a).startActivity(intent);
                dialoginterface.cancel();
            }

            
            {
                a = kr.this;
                super();
            }
        }).setNegativeButton(Html.fromHtml("<font face = 'Sans-Serif'>Cancel</font>"), new android.content.DialogInterface.OnClickListener() {

            final kr a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.cancel();
            }

            
            {
                a = kr.this;
                super();
            }
        });
        builder.create().show();
    }
}
