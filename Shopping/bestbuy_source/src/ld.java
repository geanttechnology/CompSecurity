// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;

public class ld
{

    private nn a;
    private Context b;

    public ld(Context context, nn nn)
    {
        a = nn;
        b = context;
    }

    static nn a(ld ld1)
    {
        return ld1.a;
    }

    public void a()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(b);
        builder.setMessage(Html.fromHtml("<font face = 'Sans-Serif'>We're sorry. This service is being \nupdated. Please check back soon.</font>")).setNegativeButton(Html.fromHtml("<font face = 'Sans-Serif'>Okay</font>"), new android.content.DialogInterface.OnClickListener() {

            final ld a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                ld.a(a).a();
                dialoginterface.dismiss();
            }

            
            {
                a = ld.this;
                super();
            }
        });
        builder.create().show();
    }
}
