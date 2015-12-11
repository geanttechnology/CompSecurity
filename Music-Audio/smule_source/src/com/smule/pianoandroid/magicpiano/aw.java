// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.smule.android.c.f;
import com.smule.android.c.o;
import com.smule.android.f.p;
import com.smule.pianoandroid.utils.j;
import com.smule.pianoandroid.utils.q;
import com.smule.pianoandroid.utils.z;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ay, ax

public class aw extends Dialog
{

    private static final String a = com/smule/pianoandroid/magicpiano/aw.getName();
    private android.view.View.OnClickListener b;
    private android.view.View.OnClickListener c;
    private android.view.View.OnClickListener d;
    private android.view.View.OnClickListener e;
    private android.view.View.OnClickListener f;
    private android.view.View.OnClickListener g;
    private View h;
    private View i;
    private View j;
    private View k;
    private View l;
    private TextView m;
    private TextView n;
    private CheckBox o;
    private Activity p;
    private ay q;

    public aw(Activity activity, ay ay1, String s, f f1, android.view.View.OnClickListener onclicklistener, android.view.View.OnClickListener onclicklistener1, android.view.View.OnClickListener onclicklistener2, 
            android.view.View.OnClickListener onclicklistener3, android.view.View.OnClickListener onclicklistener4, android.view.View.OnClickListener onclicklistener5)
    {
        super(activity, 0x7f0d007f);
        p = activity;
        b = onclicklistener;
        c = onclicklistener1;
        d = onclicklistener2;
        e = onclicklistener3;
        f = onclicklistener4;
        g = onclicklistener5;
        q = ay1;
        requestWindowFeature(1);
        ay1 = activity.getLayoutInflater().inflate(0x7f03006d, null, false);
        setContentView(ay1);
        com.smule.pianoandroid.utils.j.a(ay1, p);
        setCanceledOnTouchOutside(true);
        m = (TextView)ay1.findViewById(0x7f0a022a);
        n = (TextView)ay1.findViewById(0x7f0a022b);
        o = (CheckBox)ay1.findViewById(0x7f0a0233);
        z.a(o, z.e(activity));
        class _cls8
        {

            static final int a[];

            static 
            {
                a = new int[ay.values().length];
                try
                {
                    a[ay.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[ay.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[ay.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls8.a[q.ordinal()];
        JVM INSTR tableswitch 1 3: default 176
    //                   1 451
    //                   2 509
    //                   3 538;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_538;
_L5:
        h = ay1.findViewById(0x7f0a0232);
        i = ay1.findViewById(0x7f0a0231);
        j = ay1.findViewById(0x7f0a0230);
        k = ay1.findViewById(0x7f0a022e);
        l = ay1.findViewById(0x7f0a022f);
        h.setOnClickListener(new ax(p, new android.view.View.OnClickListener(s, f1) {

            final String a;
            final f b;
            final aw c;

            public void onClick(View view)
            {
                if (aw.a(c) != null)
                {
                    if (a != null)
                    {
                        com.smule.pianoandroid.utils.q.a(a, o.j, b);
                    }
                    aw.a(c).onClick(view);
                }
            }

            
            {
                c = aw.this;
                a = s;
                b = f1;
                super();
            }
        }));
        i.setOnClickListener(new ax(p, new android.view.View.OnClickListener(s, f1) {

            final String a;
            final f b;
            final aw c;

            public void onClick(View view)
            {
                if (aw.b(c) != null)
                {
                    if (a != null)
                    {
                        com.smule.pianoandroid.utils.q.a(a, o.b, b);
                    }
                    aw.b(c).onClick(view);
                }
            }

            
            {
                c = aw.this;
                a = s;
                b = f1;
                super();
            }
        }));
        j.setOnClickListener(new ax(p, new android.view.View.OnClickListener(s, f1) {

            final String a;
            final f b;
            final aw c;

            public void onClick(View view)
            {
                if (aw.c(c) != null)
                {
                    if (a != null)
                    {
                        com.smule.pianoandroid.utils.q.a(a, o.c, b);
                    }
                    aw.c(c).onClick(view);
                }
            }

            
            {
                c = aw.this;
                a = s;
                b = f1;
                super();
            }
        }));
        activity = j;
        int i1;
        boolean flag;
        if (a())
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        activity.setVisibility(i1);
        k.setOnClickListener(new ax(p, new android.view.View.OnClickListener(s, f1) {

            final String a;
            final f b;
            final aw c;

            public void onClick(View view)
            {
                if (aw.d(c) != null)
                {
                    if (a != null)
                    {
                        com.smule.pianoandroid.utils.q.a(a, o.f, b);
                    }
                    aw.d(c).onClick(view);
                }
            }

            
            {
                c = aw.this;
                a = s;
                b = f1;
                super();
            }
        }));
        activity = k;
        if (b())
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        activity.setVisibility(i1);
        l.setOnClickListener(new ax(p, new android.view.View.OnClickListener(s, f1) {

            final String a;
            final f b;
            final aw c;

            public void onClick(View view)
            {
                if (aw.e(c) != null)
                {
                    if (a != null)
                    {
                        com.smule.pianoandroid.utils.q.a(a, o.g, b);
                    }
                    aw.e(c).onClick(view);
                }
            }

            
            {
                c = aw.this;
                a = s;
                b = f1;
                super();
            }
        }));
        o.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final aw a;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag1)
            {
                compoundbutton = com.smule.pianoandroid.magicpiano.aw.f(a).getSharedPreferences("sharedialog", 0).edit();
                compoundbutton.putBoolean("doNotShow", flag1);
                com.smule.android.f.p.a(compoundbutton);
            }

            
            {
                a = aw.this;
                super();
            }
        });
        ay1.findViewById(0x7f0a0063).setOnClickListener(new android.view.View.OnClickListener() {

            final aw a;

            public void onClick(View view)
            {
                a.dismiss();
            }

            
            {
                a = aw.this;
                super();
            }
        });
        return;
_L2:
        m.setText(0x7f0c0256);
        n.setText(0x7f0c0255);
        o.setVisibility(0);
        flag = p.getSharedPreferences("sharedialog", 0).getBoolean("doNotShow", false);
        o.setChecked(flag);
          goto _L5
_L3:
        m.setText(0x7f0c024c);
        n.setText(0x7f0c0253);
        o.setVisibility(4);
          goto _L5
        m.setText(0x7f0c024c);
        n.setText(0x7f0c0253);
        o.setVisibility(4);
          goto _L5
    }

    static android.view.View.OnClickListener a(aw aw1)
    {
        return aw1.b;
    }

    private boolean a()
    {
label0:
        {
            Object obj = new Intent("android.intent.action.SEND");
            ((Intent) (obj)).setType("text/plain");
            obj = p.getPackageManager().queryIntentActivities(((Intent) (obj)), 0);
            if (((List) (obj)).isEmpty())
            {
                break label0;
            }
            obj = ((List) (obj)).iterator();
            ResolveInfo resolveinfo;
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
                resolveinfo = (ResolveInfo)((Iterator) (obj)).next();
            } while (!resolveinfo.activityInfo.packageName.toLowerCase().contains("twitter") && !resolveinfo.activityInfo.name.toLowerCase().contains("twitter"));
            return true;
        }
        return false;
    }

    static android.view.View.OnClickListener b(aw aw1)
    {
        return aw1.c;
    }

    private boolean b()
    {
        boolean flag = false;
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setType("vnd.android-dir/mms-sms");
        if (!p.getPackageManager().queryIntentActivities(intent, 0).isEmpty())
        {
            flag = true;
        }
        return flag;
    }

    static android.view.View.OnClickListener c(aw aw1)
    {
        return aw1.d;
    }

    static android.view.View.OnClickListener d(aw aw1)
    {
        return aw1.e;
    }

    static android.view.View.OnClickListener e(aw aw1)
    {
        return aw1.f;
    }

    static Activity f(aw aw1)
    {
        return aw1.p;
    }

}
