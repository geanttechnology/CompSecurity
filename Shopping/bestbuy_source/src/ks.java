// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.widget.TextView;
import com.bestbuy.android.activities.registry.WishListSettingsFragment;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.HashMap;

public class ks
{

    private Fragment a;
    private Context b;
    private String c;
    private String d;

    public ks(Context context, Fragment fragment, String s, String s1)
    {
        b = context;
        a = fragment;
        c = s;
        d = s1;
    }

    static Context a(ks ks1)
    {
        return ks1.b;
    }

    static Fragment b(ks ks1)
    {
        return ks1.a;
    }

    static String c(ks ks1)
    {
        return ks1.c;
    }

    static String d(ks ks1)
    {
        return ks1.d;
    }

    public void a()
    {
        Object obj = new android.app.AlertDialog.Builder(b);
        ((android.app.AlertDialog.Builder) (obj)).setMessage(Html.fromHtml(b.getResources().getString(0x7f0800bb))).setCancelable(false).setPositiveButton(Html.fromHtml(b.getResources().getString(0x7f080391)), new android.content.DialogInterface.OnClickListener() {

            final ks a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                (new jc((Activity)ks.a(a), (BBYBaseFragment)ks.b(a), null, ks.c(a), ks.d(a))).executeOnExecutor(nb.g, new Void[0]);
                dialoginterface.dismiss();
                dialoginterface = new HashMap();
                dialoginterface.put("List Type", ks.c(a));
                dialoginterface.put("List UUID", ks.d(a));
                lu.b(lu.Q, dialoginterface);
            }

            
            {
                a = ks.this;
                super();
            }
        }).setNegativeButton(Html.fromHtml(b.getResources().getString(0x7f0800e9)), new android.content.DialogInterface.OnClickListener() {

            final ks a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                a = ks.this;
                super();
            }
        });
        obj = ((android.app.AlertDialog.Builder) (obj)).create();
        ((AlertDialog) (obj)).setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

            final ks a;

            public void onDismiss(DialogInterface dialoginterface)
            {
                ((WishListSettingsFragment)ks.b(a)).c();
            }

            
            {
                a = ks.this;
                super();
            }
        });
        ((AlertDialog) (obj)).show();
        ((TextView)((AlertDialog) (obj)).findViewById(0x102000b)).setGravity(17);
    }
}
