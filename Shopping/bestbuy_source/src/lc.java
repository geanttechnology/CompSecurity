// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.Html;

public class lc
{

    private Context a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;

    public lc(Context context, String s, String s1)
    {
        b = "Title";
        c = "Update Text";
        d = "market://details?id=com.bestbuy.android";
        a = context;
        b = s;
        c = s1;
    }

    static void a(lc lc1)
    {
        lc1.b();
    }

    private void b()
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(d));
        a.startActivity(intent);
    }

    public void a()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(a);
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("<font face = 'Sans-Serif'>").append(a.getResources().getString(0x7f0801ab)).append("<br><br>Installed Version: <span class='bold'>").append(f).append(" </span><br>Available Version: <span class='bold'>").append(g);
        if (c != null && !c.isEmpty())
        {
            stringbuilder.append("</span><br><br><span class='bold'>What's New:</span><br>");
            stringbuilder.append(c);
        }
        stringbuilder.append("<br></font>");
        builder.setMessage(Html.fromHtml(stringbuilder.toString())).setCancelable(false).setPositiveButton(Html.fromHtml((new StringBuilder()).append("<font face = 'Sans-Serif'>").append(e).append("</font>").toString()), new android.content.DialogInterface.OnClickListener() {

            final lc a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                lc.a(a);
            }

            
            {
                a = lc.this;
                super();
            }
        });
        builder.create().show();
    }

    public void a(String s)
    {
        d = s;
    }

    public void a(String s, String s1, String s2)
    {
        e = s;
        f = s1;
        g = s2;
    }
}
