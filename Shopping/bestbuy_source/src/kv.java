// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;

public class kv
{

    private String a;
    private Context b;

    public kv(Context context, String s)
    {
        b = context;
        a = s;
    }

    public void a()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(b);
        builder.setMessage(Html.fromHtml((new StringBuilder()).append("<font face = 'Sans-Serif'>").append(a).append("</font>").toString())).setCancelable(false).setNegativeButton(Html.fromHtml("<font face = 'Sans-Serif'>OK</font>"), new android.content.DialogInterface.OnClickListener() {

            final kv a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                a = kv.this;
                super();
            }
        });
        builder.create().show();
    }
}
