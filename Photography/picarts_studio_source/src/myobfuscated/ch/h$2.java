// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ch;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import com.photo.effect.EffectParameter;
import java.util.ArrayList;

// Referenced classes of package myobfuscated.ch:
//            h

final class it>
    implements android.widget.terView.OnItemSelectedListener
{

    private ArrayList a;
    private EffectParameter b;
    private Button c;
    private ArrayList d;
    private h e;

    public final void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (String)a.get(i);
        if (adapterview.compareTo(b.g) == 0)
        {
            return;
        } else
        {
            c.setText((CharSequence)d.get(i));
            b.a(adapterview);
            h.a(e, h.c(e));
            return;
        }
    }

    public final void onNothingSelected(AdapterView adapterview)
    {
    }

    n(h h1, ArrayList arraylist, EffectParameter effectparameter, Button button, ArrayList arraylist1)
    {
        e = h1;
        a = arraylist;
        b = effectparameter;
        c = button;
        d = arraylist1;
        super();
    }
}
