// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.j;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.helpshift.g.a.a;
import com.helpshift.l;
import com.helpshift.s;
import java.util.Map;

public class b extends RelativeLayout
    implements android.view.View.OnClickListener
{
    public static interface a
    {

        public abstract void b(String s1);

        public abstract void g();
    }


    private a a;
    private ImageView b;
    private Button c;
    private String d;
    private int e;
    private l f;

    public b(Context context)
    {
        super(context);
        e = 0;
        f = new l(context);
        a(context);
    }

    private void a(Context context)
    {
        View.inflate(context, com.helpshift.d.B, this);
        b = (ImageView)findViewById(com.helpshift.c.Q);
        Button button = (Button)findViewById(com.helpshift.c.R);
        c = (Button)findViewById(com.helpshift.c.S);
        if (!f.a.Z())
        {
            ImageView imageview = (ImageView)findViewById(com.helpshift.c.l);
            imageview.setImageDrawable(com.helpshift.g.a.a.a(context, (String)com.helpshift.g.a.b.a.get("newHSLogo")));
            imageview.setBackgroundResource(0x106000c);
        }
        button.setOnClickListener(this);
        c.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        int i = view.getId();
        if (i == com.helpshift.c.R)
        {
            a.g();
        } else
        if (i == com.helpshift.c.S)
        {
            switch (e)
            {
            default:
                a.b(d);
                return;

            case 2: // '\002'
                a.b("");
                break;
            }
            return;
        }
    }

    public void setScreenshotPreview(String s1)
    {
        d = s1;
        s1 = com.helpshift.i.b.a(s1, -1);
        b.setImageBitmap(s1);
        if (e == 2)
        {
            setSendButtonText(1);
        }
    }

    public void setScreenshotPreviewInterface(a a1)
    {
        a = a1;
    }

    public void setSendButtonText(int i)
    {
        e = i;
        switch (i)
        {
        default:
            c.setText(getContext().getString(com.helpshift.g.H));
            return;

        case 1: // '\001'
            c.setText(getContext().getString(com.helpshift.g.F));
            return;

        case 2: // '\002'
            c.setText(getContext().getString(com.helpshift.g.G));
            break;
        }
    }
}
