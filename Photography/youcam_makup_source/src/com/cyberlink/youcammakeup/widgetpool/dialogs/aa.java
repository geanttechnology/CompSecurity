// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            ab

public class aa extends Dialog
{

    private View a;
    private ab b;

    public aa(Context context)
    {
        super(context);
        a = LayoutInflater.from(context).inflate(0x7f030155, null);
        a();
        setContentView(a);
    }

    static ab a(aa aa1)
    {
        return aa1.b;
    }

    private void a()
    {
        getWindow().requestFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setBackgroundDrawableResource(0x106000d);
        TextView textview = (TextView)a.findViewById(0x7f0c056d);
        View view = a.findViewById(0x7f0c056f);
        View view1 = a.findViewById(0x7f0c061c);
        View view2 = a.findViewById(0x7f0c056e);
        textview.setText(0x7f07050b);
        view2.setVisibility(4);
        view1.setVisibility(0);
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final aa a;

            public void onClick(View view3)
            {
                if (aa.a(a) != null)
                {
                    aa.a(a).a();
                }
                a.dismiss();
            }

            
            {
                a = aa.this;
                super();
            }
        });
        setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final aa a;

            public void onCancel(DialogInterface dialoginterface)
            {
                if (aa.a(a) != null)
                {
                    aa.a(a).a();
                }
            }

            
            {
                a = aa.this;
                super();
            }
        });
    }

    public void a(ab ab)
    {
        if (ab != null)
        {
            b = ab;
        }
    }
}
