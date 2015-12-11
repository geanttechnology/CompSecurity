// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.Html;

public class kt
{

    private Context a;
    private ku b;
    private nb c;

    public kt(Context context, ku ku1)
    {
        b = ku.c;
        a = context;
        b = ku1;
        c = nb.a();
    }

    static nb a(kt kt1)
    {
        return kt1.c;
    }

    static Context b(kt kt1)
    {
        return kt1.a;
    }

    public void a()
    {
        android.app.AlertDialog.Builder builder;
        Resources resources;
        builder = new android.app.AlertDialog.Builder(a);
        resources = a.getResources();
        if (b != ku.a) goto _L2; else goto _L1
_L1:
        android.content.SharedPreferences.Editor editor = c.c().edit();
        editor.putBoolean(a.getString(0x7f08004c), true);
        editor.commit();
        builder.setMessage(Html.fromHtml(resources.getString(0x7f080186))).setCancelable(false).setPositiveButton(resources.getString(0x7f08001f), new android.content.DialogInterface.OnClickListener(resources) {

            final Resources a;
            final kt b;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                dialoginterface = kt.a(b).c().edit();
                dialoginterface.putBoolean(a.getString(0x7f08003e), true);
                dialoginterface.commit();
                lq.a(kt.b(b), null);
            }

            
            {
                b = kt.this;
                a = resources;
                super();
            }
        }).setNegativeButton(resources.getString(0x7f08003d), new android.content.DialogInterface.OnClickListener() {

            final kt a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.cancel();
            }

            
            {
                a = kt.this;
                super();
            }
        });
_L6:
        builder.create().show();
_L4:
        return;
_L2:
        if (b != ku.b) goto _L4; else goto _L3
_L3:
        android.content.SharedPreferences.Editor editor1 = c.c().edit();
        editor1.putBoolean(a.getString(0x7f08004d), true);
        editor1.commit();
        builder.setMessage(Html.fromHtml(resources.getString(0x7f080189))).setCancelable(false).setPositiveButton(resources.getString(0x7f08001f), new android.content.DialogInterface.OnClickListener(resources) {

            final Resources a;
            final kt b;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                android.content.SharedPreferences.Editor editor2 = kt.a(b).c().edit();
                editor2.putBoolean(a.getString(0x7f08008a), true);
                editor2.commit();
                lq.a(kt.b(b), null);
                dialoginterface.dismiss();
            }

            
            {
                b = kt.this;
                a = resources;
                super();
            }
        }).setNegativeButton(resources.getString(0x7f08003d), new android.content.DialogInterface.OnClickListener() {

            final kt a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.cancel();
            }

            
            {
                a = kt.this;
                super();
            }
        });
        if (true) goto _L6; else goto _L5
_L5:
    }
}
