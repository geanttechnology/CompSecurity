// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bj;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.socialin.android.dialog.d;
import myobfuscated.f.m;

// Referenced classes of package myobfuscated.bj:
//            b

public final class a extends d
{

    public b a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public float h;
    private EditText i;
    private EditText j;
    private final TextWatcher k = new TextWatcher() {

        private a a;

        public final void afterTextChanged(Editable editable)
        {
            if (a.a(a) != -1F)
            {
                int i1 = a.b(a);
                myobfuscated.bj.a.d(a).removeTextChangedListener(a.c(a));
                myobfuscated.bj.a.d(a).setText(String.valueOf((int)((float)i1 * a.a(a))));
                myobfuscated.bj.a.d(a).addTextChangedListener(a.c(a));
            }
        }

        public final void beforeTextChanged(CharSequence charsequence, int i1, int j1, int k1)
        {
        }

        public final void onTextChanged(CharSequence charsequence, int i1, int j1, int k1)
        {
        }

            
            {
                a = a.this;
                super();
            }
    };
    private final TextWatcher l = new TextWatcher() {

        private a a;

        public final void afterTextChanged(Editable editable)
        {
            if (a.a(a) != -1F)
            {
                int i1 = a.e(a);
                a.g(a).removeTextChangedListener(a.f(a));
                a.g(a).setText(String.valueOf((int)((float)i1 / a.a(a))));
                a.g(a).addTextChangedListener(a.f(a));
            }
        }

        public final void beforeTextChanged(CharSequence charsequence, int i1, int j1, int k1)
        {
        }

        public final void onTextChanged(CharSequence charsequence, int i1, int j1, int k1)
        {
        }

            
            {
                a = a.this;
                super();
            }
    };

    public a()
    {
        setStyle(1, 0x7f0c0181);
        setRetainInstance(true);
        h = -1F;
    }

    static float a(a a1)
    {
        return a1.h;
    }

    private int a()
    {
        int i1;
        try
        {
            i1 = Integer.parseInt(i.getText().toString());
        }
        catch (NumberFormatException numberformatexception)
        {
            return 0;
        }
        return i1;
    }

    private int b()
    {
        int i1;
        try
        {
            i1 = Integer.parseInt(j.getText().toString());
        }
        catch (NumberFormatException numberformatexception)
        {
            return 0;
        }
        return i1;
    }

    static int b(a a1)
    {
        return a1.a();
    }

    static TextWatcher c(a a1)
    {
        return a1.l;
    }

    static EditText d(a a1)
    {
        return a1.j;
    }

    static int e(a a1)
    {
        return a1.b();
    }

    static TextWatcher f(a a1)
    {
        return a1.k;
    }

    static EditText g(a a1)
    {
        return a1.i;
    }

    static int h(a a1)
    {
        return a1.f;
    }

    static int i(a a1)
    {
        return a1.d;
    }

    static int j(a a1)
    {
        return a1.g;
    }

    static int k(a a1)
    {
        return a1.e;
    }

    static b l(a a1)
    {
        return a1.a;
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f0300a8, viewgroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        m.b(view).setText(0x7f080581);
        i = (EditText)view.findViewById(0x7f100392);
        i.setText(String.valueOf(b));
        i.addTextChangedListener(k);
        j = (EditText)view.findViewById(0x7f100393);
        j.setText(String.valueOf(c));
        j.addTextChangedListener(l);
        view.findViewById(0x7f100125).setOnClickListener(new android.view.View.OnClickListener() {

            private a a;

            public final void onClick(View view1)
            {
                int i1 = a.b(a);
                int j1 = a.e(a);
                if (i1 == -1 || j1 == -1)
                {
                    Toast.makeText(a.getActivity(), a.getString(0x7f08039e), 1).show();
                    return;
                }
                if (i1 < a.h(a) || i1 > a.i(a))
                {
                    Toast.makeText(a.getActivity(), a.getString(0x7f080107, new Object[] {
                        Integer.valueOf(a.h(a)), Integer.valueOf(a.i(a))
                    }), 1).show();
                    return;
                }
                if (j1 < a.j(a) || j1 > a.k(a))
                {
                    Toast.makeText(a.getActivity(), a.getString(0x7f080106, new Object[] {
                        Integer.valueOf(a.j(a)), Integer.valueOf(a.k(a))
                    }), 1).show();
                    return;
                }
                if (a.l(a) != null)
                {
                    a.l(a).a(i1, j1);
                }
                a.dismiss();
            }

            
            {
                a = a.this;
                super();
            }
        });
        view.findViewById(0x7f100395).setOnClickListener(new android.view.View.OnClickListener() {

            private a a;

            public final void onClick(View view1)
            {
                a.dismiss();
            }

            
            {
                a = a.this;
                super();
            }
        });
    }
}
