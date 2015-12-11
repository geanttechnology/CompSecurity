// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import com.bestbuy.android.api.lib.models.capi.lookup.GiftCard;
import com.bestbuy.android.base.BBYBaseFragment;

public class ho extends ka
{

    private static int l = 0;
    private String a;
    private String j;
    private GiftCard k;

    public ho(Activity activity, BBYBaseFragment bbybasefragment, View view, String s, String s1)
    {
        super(activity, bbybasefragment);
        a = s;
        g = view;
        j = s1;
    }

    public void a()
    {
        k = fs.a(ft.a, a, j);
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        l = 0;
        String s1 = String.valueOf(k.getValue());
        String s;
        if (s1 == null || s1.equals(f.getString(0x7f080068)) || s1.equals("0.0"))
        {
            s = "0.00";
        } else
        {
            s = s1;
            if (s1.substring(s1.indexOf(".") + 1, s1.length()).equals("0"))
            {
                s = (new StringBuilder()).append(s1).append("0").toString();
            }
        }
        s = (new StringBuilder()).append("Remaining Balance:\n$").append(s).toString();
        if (f == null || f.isFinishing())
        {
            return;
        } else
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(f);
            builder.setMessage(s).setNeutralButton(f.getString(0x7f080284), new android.content.DialogInterface.OnClickListener() {

                final ho a;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                a = ho.this;
                super();
            }
            });
            builder.create().show();
            return;
        }
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        (new kv(f, "We did not recognize the Gift Card \n number. Please check for accuracy and \n try again.")).a();
    }

    public void d()
    {
        l++;
        (new ho(f, i, g, a, j)).executeOnExecutor(nb.h, new Void[0]);
    }

    protected void onPreExecute()
    {
        if (g != null)
        {
            g.setVisibility(0);
        }
    }

}
