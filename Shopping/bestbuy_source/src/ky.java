// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.widget.TextView;
import com.bestbuy.android.activities.browseproduct.pdp.PDPProductAvailabilityContainer;

public class ky
{

    private Fragment a;
    private Context b;
    private String c;

    public ky(Context context, Fragment fragment, String s)
    {
        b = context;
        a = fragment;
        c = s;
    }

    static String a(ky ky1)
    {
        return ky1.c;
    }

    static Fragment b(ky ky1)
    {
        return ky1.a;
    }

    public void a()
    {
        Object obj = new android.app.AlertDialog.Builder(b);
        ((android.app.AlertDialog.Builder) (obj)).setMessage(Html.fromHtml(b.getResources().getString(0x7f0800bc))).setCancelable(false).setPositiveButton(Html.fromHtml(b.getResources().getString(0x7f080283)), new android.content.DialogInterface.OnClickListener() {

            final ky a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(Uri.parse(ky.a(a)));
                ((PDPProductAvailabilityContainer)ky.b(a).getParentFragment()).startActivity(intent);
                dialoginterface.dismiss();
            }

            
            {
                a = ky.this;
                super();
            }
        }).setNegativeButton(Html.fromHtml(b.getResources().getString(0x7f0800e9)), new android.content.DialogInterface.OnClickListener() {

            final ky a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                a = ky.this;
                super();
            }
        });
        obj = ((android.app.AlertDialog.Builder) (obj)).create();
        ((AlertDialog) (obj)).show();
        ((TextView)((AlertDialog) (obj)).findViewById(0x102000b)).setGravity(17);
    }
}
