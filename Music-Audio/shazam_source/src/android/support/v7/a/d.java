// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import java.lang.ref.WeakReference;

// Referenced classes of package android.support.v7.a:
//            m

public final class d
{
    public static final class a
    {

        public int A;
        public boolean B;
        public boolean C[];
        public boolean D;
        public boolean E;
        public int F;
        public android.content.DialogInterface.OnMultiChoiceClickListener G;
        public Cursor H;
        public String I;
        public String J;
        public android.widget.AdapterView.OnItemSelectedListener K;
        public boolean L;
        public final Context a;
        public final LayoutInflater b;
        public int c;
        public Drawable d;
        public int e;
        public CharSequence f;
        public View g;
        public CharSequence h;
        public CharSequence i;
        public android.content.DialogInterface.OnClickListener j;
        public CharSequence k;
        public android.content.DialogInterface.OnClickListener l;
        public CharSequence m;
        public android.content.DialogInterface.OnClickListener n;
        public boolean o;
        public android.content.DialogInterface.OnCancelListener p;
        public android.content.DialogInterface.OnDismissListener q;
        public android.content.DialogInterface.OnKeyListener r;
        public CharSequence s[];
        public ListAdapter t;
        public android.content.DialogInterface.OnClickListener u;
        public int v;
        public View w;
        public int x;
        public int y;
        public int z;

        public a(Context context)
        {
            c = 0;
            e = 0;
            B = false;
            F = -1;
            L = true;
            a = context;
            o = true;
            b = (LayoutInflater)context.getSystemService("layout_inflater");
        }
    }

    private static final class b extends Handler
    {

        private WeakReference a;

        public final void handleMessage(Message message)
        {
            switch (message.what)
            {
            case 0: // '\0'
            default:
                return;

            case -3: 
            case -2: 
            case -1: 
                ((android.content.DialogInterface.OnClickListener)message.obj).onClick((DialogInterface)a.get(), message.what);
                return;

            case 1: // '\001'
                ((DialogInterface)message.obj).dismiss();
                break;
            }
        }

        public b(DialogInterface dialoginterface)
        {
            a = new WeakReference(dialoginterface);
        }
    }

    private static final class c extends ArrayAdapter
    {

        public final long getItemId(int i1)
        {
            return (long)i1;
        }

        public final boolean hasStableIds()
        {
            return true;
        }

        public c(Context context, int i1, CharSequence acharsequence[])
        {
            super(context, i1, 0x1020014, acharsequence);
        }
    }


    TextView A;
    public TextView B;
    public View C;
    public ListAdapter D;
    public int E;
    int F;
    int G;
    public int H;
    public int I;
    public int J;
    public int K;
    int L;
    Handler M;
    final android.view.View.OnClickListener N = new android.view.View.OnClickListener() {

        final d a;

        public final void onClick(View view)
        {
            if (view == a.n && a.p != null)
            {
                view = Message.obtain(a.p);
            } else
            if (view == a.q && a.s != null)
            {
                view = Message.obtain(a.s);
            } else
            if (view == a.t && a.v != null)
            {
                view = Message.obtain(a.v);
            } else
            {
                view = null;
            }
            if (view != null)
            {
                view.sendToTarget();
            }
            a.M.obtainMessage(1, a.b).sendToTarget();
        }

            
            {
                a = d.this;
                super();
            }
    };
    public final Context a;
    final m b;
    final Window c;
    CharSequence d;
    public CharSequence e;
    public ListView f;
    public View g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public boolean m;
    Button n;
    CharSequence o;
    Message p;
    Button q;
    CharSequence r;
    Message s;
    Button t;
    CharSequence u;
    Message v;
    ScrollView w;
    public int x;
    public Drawable y;
    public ImageView z;

    public d(Context context, m m1, Window window)
    {
        m = false;
        x = 0;
        E = -1;
        L = 0;
        a = context;
        b = m1;
        c = window;
        M = new b(m1);
        context = context.obtainStyledAttributes(null, android.support.v7.b.a.k.AlertDialog, android.support.v7.b.a.a.alertDialogStyle, 0);
        F = context.getResourceId(android.support.v7.b.a.k.AlertDialog_android_layout, 0);
        G = context.getResourceId(android.support.v7.b.a.k.AlertDialog_buttonPanelSideLayout, 0);
        H = context.getResourceId(android.support.v7.b.a.k.AlertDialog_listLayout, 0);
        I = context.getResourceId(android.support.v7.b.a.k.AlertDialog_multiChoiceItemLayout, 0);
        J = context.getResourceId(android.support.v7.b.a.k.AlertDialog_singleChoiceItemLayout, 0);
        K = context.getResourceId(android.support.v7.b.a.k.AlertDialog_listItemLayout, 0);
        context.recycle();
    }

    static void a(Button button)
    {
        android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)button.getLayoutParams();
        layoutparams.gravity = 1;
        layoutparams.weight = 0.5F;
        button.setLayoutParams(layoutparams);
    }

    static boolean a(View view)
    {
        if (view.onCheckIsTextEditor())
        {
            return true;
        }
        if (!(view instanceof ViewGroup))
        {
            return false;
        }
        view = (ViewGroup)view;
        for (int i1 = view.getChildCount(); i1 > 0;)
        {
            int j1 = i1 - 1;
            i1 = j1;
            if (a(view.getChildAt(j1)))
            {
                return true;
            }
        }

        return false;
    }

    public final void a(int i1)
    {
label0:
        {
            y = null;
            x = i1;
            if (z != null)
            {
                if (i1 == 0)
                {
                    break label0;
                }
                z.setImageResource(x);
            }
            return;
        }
        z.setVisibility(8);
    }

    public final void a(int i1, CharSequence charsequence, android.content.DialogInterface.OnClickListener onclicklistener, Message message)
    {
        if (onclicklistener != null)
        {
            message = M.obtainMessage(i1, onclicklistener);
        }
        switch (i1)
        {
        default:
            throw new IllegalArgumentException("Button does not exist");

        case -1: 
            o = charsequence;
            p = message;
            return;

        case -2: 
            r = charsequence;
            s = message;
            return;

        case -3: 
            u = charsequence;
            v = message;
            return;
        }
    }

    public final void a(CharSequence charsequence)
    {
        d = charsequence;
        if (A != null)
        {
            A.setText(charsequence);
        }
    }

    // Unreferenced inner class android/support/v7/a/d$a$1

/* anonymous class */
    public final class a._cls1 extends ArrayAdapter
    {

        final ListView a;
        final a b;

        public final View getView(int i1, View view, ViewGroup viewgroup)
        {
            view = super.getView(i1, view, viewgroup);
            if (b.C != null && b.C[i1])
            {
                a.setItemChecked(i1, true);
            }
            return view;
        }

            public 
            {
                b = a1;
                a = listview;
                super(context, i1, 0x1020014, acharsequence);
            }
    }


    // Unreferenced inner class android/support/v7/a/d$a$2

/* anonymous class */
    public final class a._cls2 extends CursorAdapter
    {

        final ListView a;
        final d b;
        final a c;
        private final int d;
        private final int e;

        public final void bindView(View view, Context context, Cursor cursor)
        {
            ((CheckedTextView)view.findViewById(0x1020014)).setText(cursor.getString(d));
            view = a;
            int i1 = cursor.getPosition();
            boolean flag;
            if (cursor.getInt(e) == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.setItemChecked(i1, flag);
        }

        public final View newView(Context context, Cursor cursor, ViewGroup viewgroup)
        {
            return c.b.inflate(b.I, viewgroup, false);
        }

            public 
            {
                c = a1;
                a = listview;
                b = d1;
                super(context, cursor, false);
                a1 = getCursor();
                d = a1.getColumnIndexOrThrow(c.I);
                e = a1.getColumnIndexOrThrow(c.J);
            }
    }


    // Unreferenced inner class android/support/v7/a/d$a$3

/* anonymous class */
    public final class a._cls3
        implements android.widget.AdapterView.OnItemClickListener
    {

        final d a;
        final a b;

        public final void onItemClick(AdapterView adapterview, View view, int i1, long l1)
        {
            b.u.onClick(a.b, i1);
            if (!b.E)
            {
                a.b.dismiss();
            }
        }

            public 
            {
                b = a1;
                a = d1;
                super();
            }
    }


    // Unreferenced inner class android/support/v7/a/d$a$4

/* anonymous class */
    public final class a._cls4
        implements android.widget.AdapterView.OnItemClickListener
    {

        final ListView a;
        final d b;
        final a c;

        public final void onItemClick(AdapterView adapterview, View view, int i1, long l1)
        {
            if (c.C != null)
            {
                c.C[i1] = a.isItemChecked(i1);
            }
            c.G.onClick(b.b, i1, a.isItemChecked(i1));
        }

            public 
            {
                c = a1;
                a = listview;
                b = d1;
                super();
            }
    }

}
