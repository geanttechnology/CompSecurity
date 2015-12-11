// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.text.Html;
import com.bestbuy.android.activities.cart.MyCartFragment;

public class le
{

    private Fragment a;
    private Context b;

    public le(Context context, Fragment fragment)
    {
        b = context;
        a = fragment;
    }

    static Fragment a(le le1)
    {
        return le1.a;
    }

    public void a()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(b);
        builder.setMessage(Html.fromHtml("<font face = 'Sans-Serif'>Are you sure you want to sign out?</font>")).setCancelable(false).setPositiveButton(Html.fromHtml("<font face = 'Sans-Serif'>Sign Out</font>"), new android.content.DialogInterface.OnClickListener() {

            final le a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                if (le.a(a) instanceof MyCartFragment)
                {
                    ((MyCartFragment)le.a(a)).c();
                }
                dialoginterface.dismiss();
            }

            
            {
                a = le.this;
                super();
            }
        }).setNegativeButton(Html.fromHtml("<font face = 'Sans-Serif'>Cancel</font>"), new android.content.DialogInterface.OnClickListener() {

            final le a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                a = le.this;
                super();
            }
        });
        builder.create().show();
    }
}
