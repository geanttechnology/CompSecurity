// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.az;

import android.widget.SeekBar;
import android.widget.TextView;

// Referenced classes of package myobfuscated.az:
//            e

public final class a
    implements myobfuscated.m.a
{

    public final int a;
    public String b;
    public int c;
    public Object d;
    public Object e;
    public Object f;
    public Object g;
    public Integer h;
    public Integer i;
    public int j;
    public int k;
    protected e l;

    public a(int i1, String s, int j1, int k1, Object obj, Object obj1, Object obj2, 
            Object obj3)
    {
        c = -1;
        h = null;
        i = null;
        l = null;
        a = i1;
        b = s;
        c = j1;
        j = k1;
        g = obj;
        f = obj1;
        e = obj2;
        d = obj3;
    }

    public final String a()
    {
        return (new StringBuilder()).append(b).append(" : ").append(g).toString();
    }

    public final void a(e e1)
    {
        l = e1;
    }

    public final String toString()
    {
        return (new StringBuilder()).append(b).append(g).toString();
    }

    // Unreferenced inner class myobfuscated/az/a$1

/* anonymous class */
    public final class _cls1
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        private TextView a;
        private a b;

        public final void onProgressChanged(SeekBar seekbar, int i1, boolean flag)
        {
            if (flag)
            {
                int j1 = ((Integer)b.e).intValue();
                b.g = Integer.valueOf(j1 + i1);
                a.setText(b.a());
            }
        }

        public final void onStartTrackingTouch(SeekBar seekbar)
        {
        }

        public final void onStopTrackingTouch(SeekBar seekbar)
        {
            if (b.l != null)
            {
                int i1 = ((Integer)b.e).intValue();
                int j1 = seekbar.getProgress();
                b.g = Integer.valueOf(i1 + j1);
                a.setText(b.a());
                b.l.a();
            }
        }

            public 
            {
                b = a.this;
                a = textview;
                super();
            }
    }

}
