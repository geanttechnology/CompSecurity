// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.Html;
import android.view.View;
import com.bestbuy.android.activities.blueassist.BlueAssistDateTimeSelectionActivity;
import java.util.ArrayList;

public class hw extends ka
{

    private Activity a;
    private String j;
    private String k;
    private String l;
    private ArrayList m;
    private int n;

    public hw(Activity activity, String s, String s1, String s2, View view)
    {
        n = 0;
        a = activity;
        j = s;
        k = s1;
        l = s2;
        g = view;
    }

    static Activity a(hw hw1)
    {
        return hw1.a;
    }

    public void a()
    {
        m = fs.b(j, k, l);
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        if (m != null)
        {
            if (a instanceof BlueAssistDateTimeSelectionActivity)
            {
                ((BlueAssistDateTimeSelectionActivity)a).a(m);
            }
            return;
        } else
        {
            c();
            return;
        }
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(a);
        builder.setMessage(Html.fromHtml("<b>\nSorry, no meeting times are available on this day.\n \n</b>")).setCancelable(false).setPositiveButton(Html.fromHtml("<font face = 'Sans-Serif'><b> Try Again </b></font>"), new android.content.DialogInterface.OnClickListener() {

            final hw a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                if (hw.a(a) instanceof BlueAssistDateTimeSelectionActivity)
                {
                    ((BlueAssistDateTimeSelectionActivity)hw.a(a)).a();
                }
            }

            
            {
                a = hw.this;
                super();
            }
        }).setNegativeButton(Html.fromHtml("<font face = 'Sans-Serif'>Cancel</font>"), new android.content.DialogInterface.OnClickListener() {

            final hw a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                a = hw.this;
                super();
            }
        });
        builder.create().show();
    }
}
