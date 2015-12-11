// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.crittercism.app.Crittercism;
import com.smule.android.c.a;
import com.smule.android.c.aa;
import com.smule.android.d.g;
import com.smule.android.d.h;
import com.smule.android.d.u;
import com.smule.android.network.models.f;
import com.smule.pianoandroid.utils.t;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ap

class b
    implements h
{

    final ViewGroup a;
    final String b;
    final ap c;

    public void a(Map map)
    {
        com.smule.pianoandroid.magicpiano.ap.g(c);
        if (map != null) goto _L2; else goto _L1
_L1:
        if (!ap.b(c).isEmpty())
        {
            ((TextView)c.findViewById(0x7f0a01eb)).setText(0x7f0c0037);
        }
_L4:
        return;
_L2:
        c.findViewById(0x7f0a01eb).setVisibility(8);
        Iterator iterator = ap.b(c).iterator();
        while (iterator.hasNext()) 
        {
            f f1 = (f)iterator.next();
            Object obj1 = (u)map.get(f1.sku);
            Object obj;
            String s;
            Runnable runnable;
            if (obj1 != null)
            {
                obj = ((u) (obj1)).b();
            } else
            {
                obj = "?";
            }
            if (f1.trial)
            {
                obj = f1.trialLabelKey;
            } else
            {
                obj = (new StringBuilder()).append(f1.labelKey).append(" - ").append(((String) (obj))).toString();
            }
            if (f1.trial)
            {
                s = MessageFormat.format(f1.trialDescriptionKey, new Object[] {
                    ((u) (obj1)).b()
                });
            } else
            {
                s = f1.descriptionKey;
            }
            runnable = new Runnable(f1.sku, ((u) (obj1))) {

                final String a;
                final u b;
                final ap._cls7 c;

                public void run()
                {
                    Iterator iterator1 = ap.b(c.c).iterator();
_L7:
                    if (!iterator1.hasNext()) goto _L2; else goto _L1
_L1:
                    f f2;
                    f2 = (f)iterator1.next();
                    if (f2.sku.compareTo(a) != 0)
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                    if (!com.smule.pianoandroid.magicpiano.ap.f(c.c).d()) goto _L4; else goto _L3
_L3:
                    if (ap.c(c.c) > 0)
                    {
                        Crittercism.a((new Exception()).initCause(ap.d(c.c)));
                        return;
                    }
                    try
                    {
                        ap.e(c.c);
                        com.smule.pianoandroid.magicpiano.ap.a(c.c, new Exception());
                        com.smule.pianoandroid.magicpiano.ap.f(c.c).b(f2.sku);
                        com.smule.android.c.a.a(a, f2.period, b.b());
                    }
                    catch (IllegalStateException illegalstateexception)
                    {
                        aa.b(ap.d(), "Subscription purchase was already launched", illegalstateexception);
                        Crittercism.a(illegalstateexception);
                    }
_L5:
                    t.b();
                    com.smule.pianoandroid.magicpiano.ap.a(c.c, f2);
                    continue; /* Loop/switch isn't completed */
_L4:
                    c.c.showDialog(2);
                    if (true) goto _L5; else goto _L2
_L2:
                    return;
                    if (true) goto _L7; else goto _L6
_L6:
                }

            
            {
                c = ap._cls7.this;
                a = s;
                b = u1;
                super();
            }
            };
            obj1 = View.inflate(c, 0x7f03005c, null);
            com.smule.pianoandroid.magicpiano.ap.a(c, ((View) (obj1)), ((String) (obj)), s, Boolean.valueOf(true), f1.trial, runnable);
            obj = new android.widget.rLayout.LayoutParams(-1, Math.round(c.getResources().getDimension(0x7f0900ee)));
            a.addView(((View) (obj1)), ((android.view.roup.LayoutParams) (obj)));
        }
        if (TextUtils.isEmpty(b)) goto _L4; else goto _L3
_L3:
        if (ap.c(c) > 0)
        {
            Crittercism.a((new Exception()).initCause(ap.d(c)));
            return;
        }
          goto _L5
_L7:
        t.b();
        return;
_L5:
        try
        {
            ap.e(c);
            com.smule.pianoandroid.magicpiano.ap.a(c, new Exception());
            com.smule.pianoandroid.magicpiano.ap.f(c).b(b);
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            aa.b(ap.d(), "Subscription purchase was already launched", map);
            Crittercism.a(map);
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    _cls1.b(ap ap1, ViewGroup viewgroup, String s)
    {
        c = ap1;
        a = viewgroup;
        b = s;
        super();
    }
}
