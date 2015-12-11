// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import com.bestbuy.android.bbyobjects.BBYButton;

public class kz extends Dialog
    implements android.view.View.OnClickListener
{

    BroadcastReceiver a;
    private BBYButton b;
    private Context c;
    private no d;

    public kz(Context context, no no1)
    {
        super(context, 0x103000a);
        a = new BroadcastReceiver() {

            final kz a;

            public void onReceive(Context context1, Intent intent)
            {
                kz.a(a);
            }

            
            {
                a = kz.this;
                super();
            }
        };
        c = context;
        d = no1;
        setCancelable(false);
        no1 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(a, no1);
    }

    private void a()
    {
        Object obj = (ConnectivityManager)c.getSystemService("connectivity");
        android.net.NetworkInfo networkinfo = ((ConnectivityManager) (obj)).getActiveNetworkInfo();
        obj = ((ConnectivityManager) (obj)).getNetworkInfo(0);
        if (networkinfo == null && obj == null || !lm.a(c))
        {
            return;
        } else
        {
            dismiss();
            nm.d = false;
            d.a();
            return;
        }
    }

    static void a(kz kz1)
    {
        kz1.a();
    }

    public void onClick(View view)
    {
        if (view == b)
        {
            c.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030080);
        b = (BBYButton)findViewById(0x7f0c01ea);
        b.setOnClickListener(this);
    }
}
