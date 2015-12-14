// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.tokenautocomplete;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.QwertyKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.Filter;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.you.widgetpool.tokenautocomplete:
//            f, c, g, b, 
//            HintSpan, d, a, e

public abstract class TokenCompleteTextView extends MultiAutoCompleteTextView
    implements android.widget.TextView.OnEditorActionListener
{

    static final boolean b;
    boolean a;
    private char c[] = {
        ',', ';'
    };
    private android.widget.MultiAutoCompleteTextView.Tokenizer d;
    private Object e;
    private e f;
    private f g;
    private g h;
    private ArrayList i;
    private List j;
    private TokenDeleteStyle k;
    private TokenClickStyle l;
    private String m;
    private boolean n;
    private Layout o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w;

    public TokenCompleteTextView(Context context)
    {
        super(context);
        k = TokenDeleteStyle.a;
        l = TokenClickStyle.a;
        m = "";
        n = false;
        o = null;
        p = true;
        q = false;
        r = false;
        s = true;
        t = false;
        u = false;
        v = true;
        w = -1;
        a = false;
        d();
    }

    public TokenCompleteTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        k = TokenDeleteStyle.a;
        l = TokenClickStyle.a;
        m = "";
        n = false;
        o = null;
        p = true;
        q = false;
        r = false;
        s = true;
        t = false;
        u = false;
        v = true;
        w = -1;
        a = false;
        d();
    }

    public TokenCompleteTextView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        k = TokenDeleteStyle.a;
        l = TokenClickStyle.a;
        m = "";
        n = false;
        o = null;
        p = true;
        q = false;
        r = false;
        s = true;
        t = false;
        u = false;
        v = true;
        w = -1;
        a = false;
        d();
    }

    static int a(TokenCompleteTextView tokencompletetextview)
    {
        return tokencompletetextview.w;
    }

    private SpannableStringBuilder a(CharSequence charsequence)
    {
        char c1 = c[0];
        return new SpannableStringBuilder((new StringBuilder()).append(String.valueOf(c1)).append(d.terminateToken(charsequence)).toString());
    }

    static void a(TokenCompleteTextView tokencompletetextview, c c1)
    {
        tokencompletetextview.a(c1);
    }

    static void a(TokenCompleteTextView tokencompletetextview, Object obj, CharSequence charsequence)
    {
        tokencompletetextview.b(obj, charsequence);
    }

    private void a(c c1)
    {
        Editable editable = getText();
        if (editable != null)
        {
            if (((f[])editable.getSpans(0, editable.length(), com/cyberlink/you/widgetpool/tokenautocomplete/f)).length == 0)
            {
                g.onSpanRemoved(editable, c1, editable.getSpanStart(c1), editable.getSpanEnd(c1));
            }
            editable.delete(editable.getSpanStart(c1), editable.getSpanEnd(c1) + 1);
            if (v && !isFocused())
            {
                g();
                return;
            }
        }
    }

    private boolean a(char c1)
    {
        boolean flag1 = false;
        char ac[] = c;
        int j1 = ac.length;
        int i1 = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i1 < j1)
                {
                    if (c1 != ac[i1])
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i1++;
        } while (true);
    }

    static boolean a(TokenCompleteTextView tokencompletetextview, char c1)
    {
        return tokencompletetextview.a(c1);
    }

    static boolean a(TokenCompleteTextView tokencompletetextview, boolean flag)
    {
        return tokencompletetextview.c(flag);
    }

    static ArrayList b(TokenCompleteTextView tokencompletetextview)
    {
        return tokencompletetextview.i;
    }

    private void b(c c1)
    {
        e(c1.a());
    }

    private void b(Object obj, CharSequence charsequence)
    {
        charsequence = a(charsequence);
        c c1 = b(obj);
        Editable editable = getText();
        if (editable != null)
        {
            if (!v || isFocused() || j.isEmpty())
            {
                int j1 = editable.length();
                int i1;
                if (n)
                {
                    i1 = m.length();
                    editable.insert(i1, charsequence);
                } else
                {
                    String s1 = b();
                    i1 = j1;
                    if (s1 != null)
                    {
                        i1 = j1;
                        if (s1.length() > 0)
                        {
                            i1 = TextUtils.indexOf(editable, s1);
                        }
                    }
                    editable.delete(i1, editable.length());
                    editable.insert(i1, charsequence);
                }
                editable.setSpan(c1, i1, (charsequence.length() + i1) - 1, 33);
                if (!isFocused() && v)
                {
                    b(false);
                }
                if (!i.contains(obj))
                {
                    g.onSpanAdded(editable, c1, 0, 0);
                    return;
                }
            } else
            {
                j.add(c1);
                g.onSpanAdded(editable, c1, 0, 0);
                g();
                return;
            }
        }
    }

    static String c(TokenCompleteTextView tokencompletetextview)
    {
        return tokencompletetextview.m;
    }

    private boolean c(boolean flag)
    {
        int i1 = 0;
        if (l != null && l.a())
        {
            Editable editable = getText();
            if (editable != null)
            {
                c ac[] = (c[])editable.getSpans(0, editable.length(), com/cyberlink/you/widgetpool/tokenautocomplete/c);
                int j1 = ac.length;
                while (i1 < j1) 
                {
                    c c1 = ac[i1];
                    if (c1.b.isSelected())
                    {
                        a(c1);
                        return true;
                    }
                    i1++;
                }
            }
        }
        return flag;
    }

    private void d()
    {
        if (r)
        {
            return;
        }
        setTokenizer(new android.widget.MultiAutoCompleteTextView.CommaTokenizer());
        i = new ArrayList();
        Editable editable = getText();
        if (!b && editable == null)
        {
            throw new AssertionError();
        } else
        {
            g = new f(this);
            h = new g(this);
            j = new ArrayList();
            a();
            setTextIsSelectable(false);
            setLongClickable(false);
            setInputType(getInputType() | 0x80000 | 0x10000);
            setHorizontallyScrolling(false);
            setOnEditorActionListener(this);
            setFilters(new InputFilter[] {
                new InputFilter() {

                    final TokenCompleteTextView a;

                    public CharSequence filter(CharSequence charsequence, int i1, int j1, Spanned spanned, int k1, int l1)
                    {
                        if (TokenCompleteTextView.a(a) != -1 && TokenCompleteTextView.b(a).size() == TokenCompleteTextView.a(a))
                        {
                            return "";
                        }
                        if (charsequence.length() == 1 && TokenCompleteTextView.a(a, charsequence.charAt(0)))
                        {
                            a.performCompletion();
                            return "";
                        }
                        if (k1 < TokenCompleteTextView.c(a).length() && l1 == TokenCompleteTextView.c(a).length())
                        {
                            return TokenCompleteTextView.c(a).substring(k1, l1);
                        } else
                        {
                            return null;
                        }
                    }

            
            {
                a = TokenCompleteTextView.this;
                super();
            }
                }
            });
            setDeletionStyle(TokenDeleteStyle.b);
            r = true;
            return;
        }
    }

    static boolean d(TokenCompleteTextView tokencompletetextview)
    {
        return tokencompletetextview.p;
    }

    static List e(TokenCompleteTextView tokencompletetextview)
    {
        return tokencompletetextview.j;
    }

    private void e()
    {
        if (r && !a)
        {
            a = true;
            setShadowLayer(getShadowRadius(), getShadowDx(), getShadowDy(), getShadowColor());
            a = false;
        }
    }

    private void e(Object obj)
    {
        b(obj, obj.toString());
    }

    static f f(TokenCompleteTextView tokencompletetextview)
    {
        return tokencompletetextview.g;
    }

    private void f()
    {
        performCompletion();
        ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    }

    private void g()
    {
        int i1 = 0;
        Editable editable = getText();
        b ab[] = (b[])editable.getSpans(0, editable.length(), com/cyberlink/you/widgetpool/tokenautocomplete/b);
        int j1 = j.size();
        int k1 = ab.length;
        while (i1 < k1) 
        {
            b b1 = ab[i1];
            if (j1 == 0)
            {
                editable.delete(editable.getSpanStart(b1), editable.getSpanEnd(b1));
                editable.removeSpan(b1);
            } else
            {
                b1.a(j.size());
                editable.setSpan(b1, editable.getSpanStart(b1), editable.getSpanEnd(b1), 33);
            }
            i1++;
        }
    }

    static void g(TokenCompleteTextView tokencompletetextview)
    {
        tokencompletetextview.g();
    }

    static TokenClickStyle h(TokenCompleteTextView tokencompletetextview)
    {
        return tokencompletetextview.l;
    }

    private void h()
    {
        Editable editable;
        CharSequence charsequence;
        editable = getText();
        charsequence = getHint();
        break MISSING_BLOCK_LABEL_10;
label0:
        while (obj == null) 
        {
            do
            {
                do
                {
                    return;
                } while (editable == null || charsequence == null || m.length() <= 0);
                HintSpan ahintspan[] = (HintSpan[])editable.getSpans(0, editable.length(), com/cyberlink/you/widgetpool/tokenautocomplete/HintSpan);
                int i1 = m.length();
                Object obj;
                int j1;
                if (ahintspan.length > 0)
                {
                    obj = ahintspan[0];
                    i1 = (editable.getSpanEnd(obj) - editable.getSpanStart(obj)) + i1;
                } else
                {
                    obj = null;
                }
                if (editable.length() != i1)
                {
                    continue label0;
                }
                n = true;
            } while (obj != null);
            obj = getTypeface();
            if (obj != null)
            {
                i1 = ((Typeface) (obj)).getStyle();
            } else
            {
                i1 = 0;
            }
            obj = getHintTextColors();
            obj = new HintSpan(null, i1, (int)getTextSize(), ((android.content.res.ColorStateList) (obj)), ((android.content.res.ColorStateList) (obj)));
            editable.insert(m.length(), charsequence);
            editable.setSpan(obj, m.length(), m.length() + getHint().length(), 33);
            setSelection(m.length());
            return;
        }
        i1 = editable.getSpanStart(obj);
        j1 = editable.getSpanEnd(obj);
        editable.removeSpan(obj);
        editable.replace(i1, j1, "");
        n = false;
        return;
    }

    private void i()
    {
        Editable editable;
        if (l != null && l.a())
        {
            if ((editable = getText()) != null)
            {
                c ac[] = (c[])editable.getSpans(0, editable.length(), com/cyberlink/you/widgetpool/tokenautocomplete/c);
                int j1 = ac.length;
                for (int i1 = 0; i1 < j1; i1++)
                {
                    c c1 = ac[i1];
                    c1.b.setSelected(false);
                    a(c1.b);
                }

                invalidate();
                return;
            }
        }
    }

    static void i(TokenCompleteTextView tokencompletetextview)
    {
        tokencompletetextview.i();
    }

    static boolean j(TokenCompleteTextView tokencompletetextview)
    {
        return tokencompletetextview.t;
    }

    static boolean k(TokenCompleteTextView tokencompletetextview)
    {
        return tokencompletetextview.q;
    }

    static e l(TokenCompleteTextView tokencompletetextview)
    {
        return tokencompletetextview.f;
    }

    static void m(TokenCompleteTextView tokencompletetextview)
    {
        tokencompletetextview.h();
    }

    protected abstract View a(Object obj);

    protected void a()
    {
        Editable editable = getText();
        if (editable != null)
        {
            editable.setSpan(g, 0, editable.length(), 18);
            addTextChangedListener(h);
        }
    }

    protected abstract void a(View view);

    public void a(Object obj, CharSequence charsequence)
    {
        post(new Runnable(obj, charsequence) {

            final Object a;
            final CharSequence b;
            final TokenCompleteTextView c;

            public void run()
            {
                if (a != null && (TokenCompleteTextView.d(c) || !TokenCompleteTextView.b(c).contains(a)) && (TokenCompleteTextView.a(c) == -1 || TokenCompleteTextView.b(c).size() != TokenCompleteTextView.a(c)))
                {
                    TokenCompleteTextView.a(c, a, b);
                    if (c.getText() != null && c.isFocused())
                    {
                        c.setSelection(c.getText().length());
                        return;
                    }
                }
            }

            
            {
                c = TokenCompleteTextView.this;
                a = obj;
                b = charsequence;
                super();
            }
        });
    }

    public void a(boolean flag)
    {
        p = flag;
    }

    protected c b(Object obj)
    {
        if (obj == null)
        {
            return null;
        } else
        {
            return new c(this, a(obj), obj, (int)c());
        }
    }

    protected abstract Object b(String s1);

    protected String b()
    {
        if (n)
        {
            return "";
        }
        Editable editable = getText();
        int k1 = getSelectionEnd();
        int j1 = d.findTokenStart(editable, k1);
        int i1 = j1;
        if (j1 < m.length())
        {
            i1 = m.length();
        }
        return TextUtils.substring(editable, i1, k1);
    }

    public void b(boolean flag)
    {
        q = true;
        if (!flag)
        {
            Object obj = getText();
            if (obj != null && o != null)
            {
                int i1 = o.getLineVisibleEnd(0);
                c ac[] = (c[])((Editable) (obj)).getSpans(0, i1, com/cyberlink/you/widgetpool/tokenautocomplete/c);
                int k1 = i.size() - ac.length;
                b ab1[] = (b[])((Editable) (obj)).getSpans(0, i1, com/cyberlink/you/widgetpool/tokenautocomplete/b);
                if (k1 > 0 && ab1.length == 0)
                {
                    i1++;
                    b b1 = new b(k1, getContext(), getCurrentTextColor(), (int)getTextSize(), (int)c());
                    ((Editable) (obj)).insert(i1, b1.a);
                    if (Layout.getDesiredWidth(((CharSequence) (obj)), 0, b1.a.length() + i1, o.getPaint()) > c())
                    {
                        ((Editable) (obj)).delete(i1, b1.a.length() + i1);
                        if (ac.length > 0)
                        {
                            i1 = ((Editable) (obj)).getSpanStart(ac[ac.length - 1]);
                            b1.a(k1 + 1);
                        } else
                        {
                            i1 = m.length();
                        }
                        ((Editable) (obj)).insert(i1, b1.a);
                    }
                    ((Editable) (obj)).setSpan(b1, i1, b1.a.length() + i1, 33);
                    j = new ArrayList(Arrays.asList((c[])(c[])((Editable) (obj)).getSpans(b1.a.length() + i1, ((Editable) (obj)).length(), com/cyberlink/you/widgetpool/tokenautocomplete/c)));
                    for (obj = j.iterator(); ((Iterator) (obj)).hasNext(); a((c)((Iterator) (obj)).next())) { }
                }
            }
        } else
        {
            Editable editable = getText();
            if (editable != null)
            {
                b ab[] = (b[])editable.getSpans(0, editable.length(), com/cyberlink/you/widgetpool/tokenautocomplete/b);
                int l1 = ab.length;
                for (int j1 = 0; j1 < l1; j1++)
                {
                    b b2 = ab[j1];
                    editable.delete(editable.getSpanStart(b2), editable.getSpanEnd(b2));
                    editable.removeSpan(b2);
                }

                for (Iterator iterator = j.iterator(); iterator.hasNext(); b((c)iterator.next())) { }
                j.clear();
                if (n)
                {
                    setSelection(m.length());
                } else
                {
                    postDelayed(new Runnable(editable) {

                        final Editable a;
                        final TokenCompleteTextView b;

                        public void run()
                        {
                            b.setSelection(a.length());
                        }

            
            {
                b = TokenCompleteTextView.this;
                a = editable;
                super();
            }
                    }, 10L);
                }
                if (((f[])getText().getSpans(0, getText().length(), com/cyberlink/you/widgetpool/tokenautocomplete/f)).length == 0)
                {
                    editable.setSpan(g, 0, editable.length(), 18);
                }
            }
        }
        q = false;
    }

    protected float c()
    {
        return (float)(getWidth() - getPaddingLeft() - getPaddingRight());
    }

    protected String c(String s1)
    {
        return s1.replaceAll("[^\\:]*: (,, )*", "");
    }

    public void c(Object obj)
    {
        a(obj, "");
    }

    protected CharSequence convertSelectionToString(Object obj)
    {
        e = obj;
        class _cls5
        {

            static final int a[];
            static final int b[];

            static 
            {
                b = new int[TokenClickStyle.values().length];
                try
                {
                    b[TokenClickStyle.c.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    b[TokenClickStyle.d.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    b[TokenClickStyle.b.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    b[TokenClickStyle.a.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                a = new int[TokenDeleteStyle.values().length];
                try
                {
                    a[TokenDeleteStyle.b.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[TokenDeleteStyle.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[TokenDeleteStyle.d.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[TokenDeleteStyle.a.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls5.a[k.ordinal()])
        {
        default:
            return super.convertSelectionToString(obj);

        case 1: // '\001'
            return "";

        case 2: // '\002'
            return b();

        case 3: // '\003'
            break;
        }
        if (obj != null)
        {
            return obj.toString();
        } else
        {
            return "";
        }
    }

    public void d(Object obj)
    {
        post(new Runnable(obj) {

            final Object a;
            final TokenCompleteTextView b;

            public void run()
            {
                int i1 = 0;
                Editable editable = b.getText();
                if (editable != null)
                {
                    Object obj1 = new ArrayList();
                    Iterator iterator = TokenCompleteTextView.e(b).iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        c c3 = (c)iterator.next();
                        if (c3.a().equals(a))
                        {
                            ((ArrayList) (obj1)).add(c3);
                        }
                    } while (true);
                    c c2;
                    for (obj1 = ((ArrayList) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); TokenCompleteTextView.f(b).onSpanRemoved(editable, c2, 0, 0))
                    {
                        c2 = (c)((Iterator) (obj1)).next();
                        TokenCompleteTextView.e(b).remove(c2);
                    }

                    TokenCompleteTextView.g(b);
                    c ac[] = (c[])editable.getSpans(0, editable.length(), com/cyberlink/you/widgetpool/tokenautocomplete/c);
                    int j1 = ac.length;
                    while (i1 < j1) 
                    {
                        c c1 = ac[i1];
                        if (c1.a().equals(a))
                        {
                            TokenCompleteTextView.a(b, c1);
                        }
                        i1++;
                    }
                }
            }

            
            {
                b = TokenCompleteTextView.this;
                a = obj;
                super();
            }
        });
    }

    public boolean enoughToFilter()
    {
        Editable editable = getText();
        int k1 = getSelectionEnd();
        if (k1 < 0 || d == null)
        {
            return false;
        }
        int j1 = d.findTokenStart(editable, k1);
        int i1 = j1;
        if (j1 < m.length())
        {
            i1 = m.length();
        }
        return k1 - i1 >= Math.max(getThreshold(), 1);
    }

    public boolean extractText(ExtractedTextRequest extractedtextrequest, ExtractedText extractedtext)
    {
        boolean flag;
        try
        {
            flag = super.extractText(extractedtextrequest, extractedtext);
        }
        // Misplaced declaration of an exception variable
        catch (ExtractedTextRequest extractedtextrequest)
        {
            Log.d("TokenAutoComplete", "extractText hit IndexOutOfBoundsException. This may be normal.", extractedtextrequest);
            return false;
        }
        return flag;
    }

    public List getObjects()
    {
        return i;
    }

    public void invalidate()
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            e();
        }
        super.invalidate();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorinfo)
    {
        d d1 = new d(this, super.onCreateInputConnection(editorinfo), true);
        editorinfo.imeOptions = editorinfo.imeOptions & 0xbfffffff;
        editorinfo.imeOptions = editorinfo.imeOptions | 0x10000000;
        return d1;
    }

    public boolean onEditorAction(TextView textview, int i1, KeyEvent keyevent)
    {
        if (i1 == 6)
        {
            f();
            return true;
        } else
        {
            return false;
        }
    }

    public void onFocusChanged(boolean flag, int i1, Rect rect)
    {
        super.onFocusChanged(flag, i1, rect);
        if (!flag)
        {
            performCompletion();
        }
        if (v)
        {
            b(flag);
        }
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        boolean flag1 = false;
        i1;
        JVM INSTR lookupswitch 4: default 48
    //                   23: 70
    //                   61: 70
    //                   66: 70
    //                   67: 87;
           goto _L1 _L2 _L2 _L2 _L3
_L1:
        boolean flag = false;
_L8:
        if (flag) goto _L5; else goto _L4
_L4:
        flag = flag1;
        if (!super.onKeyDown(i1, keyevent)) goto _L6; else goto _L5
_L5:
        flag = true;
_L6:
        return flag;
_L2:
        if (!keyevent.hasNoModifiers()) goto _L1; else goto _L7
_L7:
        u = true;
        flag = true;
          goto _L8
_L3:
        flag = c(false);
          goto _L8
    }

    public boolean onKeyUp(int i1, KeyEvent keyevent)
    {
        boolean flag = super.onKeyUp(i1, keyevent);
        if (u)
        {
            u = false;
            f();
        }
        return flag;
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        super.onLayout(flag, i1, j1, k1, l1);
        o = getLayout();
    }

    protected void onSelectionChanged(int i1, int j1)
    {
        j1 = 0;
        if (n)
        {
            i1 = 0;
        }
        if (l != null && l.a() && getText() != null)
        {
            i();
        }
        if (m != null && (i1 < m.length() || i1 < m.length()))
        {
            setSelection(m.length());
            return;
        }
        Editable editable = getText();
        if (editable != null)
        {
            c ac[] = (c[])editable.getSpans(i1, i1, com/cyberlink/you/widgetpool/tokenautocomplete/c);
            for (int k1 = ac.length; j1 < k1; j1++)
            {
                c c1 = ac[j1];
                int l1 = editable.getSpanEnd(c1);
                if (i1 <= l1 && editable.getSpanStart(c1) < i1)
                {
                    if (l1 == editable.length())
                    {
                        setSelection(l1);
                        return;
                    } else
                    {
                        setSelection(l1 + 1);
                        return;
                    }
                }
            }

        }
        super.onSelectionChanged(i1, i1);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i1 = motionevent.getActionMasked();
        Editable editable = getText();
        boolean flag;
        if (l == TokenClickStyle.a)
        {
            flag = super.onTouchEvent(motionevent);
        } else
        {
            flag = false;
        }
        if (isFocused() && editable != null && o != null && i1 == 1)
        {
            int j1 = getOffsetForPosition(motionevent.getX(), motionevent.getY());
            if (j1 != -1)
            {
                c ac[] = (c[])editable.getSpans(j1, j1, com/cyberlink/you/widgetpool/tokenautocomplete/c);
                boolean flag1;
                if (ac.length > 0)
                {
                    ac[0].b();
                    flag = true;
                } else
                {
                    i();
                }
            }
        }
        flag1 = flag;
        if (!flag)
        {
            flag1 = flag;
            if (l != TokenClickStyle.a)
            {
                flag1 = super.onTouchEvent(motionevent);
            }
        }
        return flag1;
    }

    public void performCompletion()
    {
        if (getListSelection() == -1 && enoughToFilter())
        {
            replaceText(convertSelectionToString(b(b())));
            return;
        } else
        {
            super.performCompletion();
            return;
        }
    }

    protected void performFiltering(CharSequence charsequence, int i1, int j1, int k1)
    {
        k1 = i1;
        if (i1 < m.length())
        {
            k1 = m.length();
        }
        Filter filter = getFilter();
        if (filter != null)
        {
            filter.filter(charsequence.subSequence(k1, j1), this);
        }
    }

    protected void replaceText(CharSequence charsequence)
    {
        clearComposingText();
        if (e != null && !e.toString().equals(""))
        {
            charsequence = a(charsequence);
            c c1 = b(e);
            Editable editable = getText();
            int k1 = getSelectionEnd();
            int j1 = d.findTokenStart(editable, k1);
            int i1 = j1;
            if (j1 < m.length())
            {
                i1 = m.length();
            }
            String s1 = TextUtils.substring(editable, i1, k1);
            if (editable != null)
            {
                if (c1 == null)
                {
                    editable.replace(i1, k1, "");
                    return;
                }
                if (!p && i.contains(c1.a()))
                {
                    editable.replace(i1, k1, "");
                    return;
                } else
                {
                    QwertyKeyListener.markAsReplaced(editable, i1, k1, s1);
                    editable.replace(i1, k1, charsequence);
                    editable.setSpan(c1, i1, (charsequence.length() + i1) - 1, 33);
                    return;
                }
            }
        }
    }

    public void setDeletionStyle(TokenDeleteStyle tokendeletestyle)
    {
        k = tokendeletestyle;
    }

    public void setPrefix(String s1)
    {
        m = "";
        Editable editable = getText();
        if (editable != null)
        {
            editable.insert(0, s1);
        }
        m = s1;
        h();
    }

    public void setSplitChar(char c1)
    {
        if (c1 == ' ')
        {
            setSplitChar(new char[] {
                '\247', c1
            });
            return;
        } else
        {
            setSplitChar(new char[] {
                c1
            });
            return;
        }
    }

    public void setSplitChar(char ac[])
    {
        char ac1[] = ac;
        if (ac[0] == ' ')
        {
            char c1;
            if (ac.length > 1)
            {
                c1 = ac[1];
            } else
            {
                c1 = '\247';
            }
            ac1 = (new char[] {
                c1, ac[0]
            });
        }
        c = ac1;
        setTokenizer(new a(ac1));
    }

    public void setTokenClickStyle(TokenClickStyle tokenclickstyle)
    {
        l = tokenclickstyle;
    }

    public void setTokenLimit(int i1)
    {
        w = i1;
    }

    public void setTokenListener(e e1)
    {
        f = e1;
    }

    public void setTokenizer(android.widget.MultiAutoCompleteTextView.Tokenizer tokenizer)
    {
        super.setTokenizer(tokenizer);
        d = tokenizer;
    }

    static 
    {
        boolean flag;
        if (!com/cyberlink/you/widgetpool/tokenautocomplete/TokenCompleteTextView.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b = flag;
    }

    private class TokenDeleteStyle extends Enum
    {

        public static final TokenDeleteStyle a;
        public static final TokenDeleteStyle b;
        public static final TokenDeleteStyle c;
        public static final TokenDeleteStyle d;
        private static final TokenDeleteStyle e[];

        public static TokenDeleteStyle valueOf(String s1)
        {
            return (TokenDeleteStyle)Enum.valueOf(com/cyberlink/you/widgetpool/tokenautocomplete/TokenCompleteTextView$TokenDeleteStyle, s1);
        }

        public static TokenDeleteStyle[] values()
        {
            return (TokenDeleteStyle[])e.clone();
        }

        static 
        {
            a = new TokenDeleteStyle("_Parent", 0);
            b = new TokenDeleteStyle("Clear", 1);
            c = new TokenDeleteStyle("PartialCompletion", 2);
            d = new TokenDeleteStyle("ToString", 3);
            e = (new TokenDeleteStyle[] {
                a, b, c, d
            });
        }

        private TokenDeleteStyle(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    private class TokenClickStyle extends Enum
    {

        public static final TokenClickStyle a;
        public static final TokenClickStyle b;
        public static final TokenClickStyle c;
        public static final TokenClickStyle d;
        private static final TokenClickStyle e[];
        private boolean mIsSelectable;

        public static TokenClickStyle valueOf(String s1)
        {
            return (TokenClickStyle)Enum.valueOf(com/cyberlink/you/widgetpool/tokenautocomplete/TokenCompleteTextView$TokenClickStyle, s1);
        }

        public static TokenClickStyle[] values()
        {
            return (TokenClickStyle[])e.clone();
        }

        public boolean a()
        {
            return mIsSelectable;
        }

        static 
        {
            a = new TokenClickStyle("None", 0, false);
            b = new TokenClickStyle("Delete", 1, false);
            c = new TokenClickStyle("Select", 2, true);
            d = new TokenClickStyle("SelectDeselect", 3, true);
            e = (new TokenClickStyle[] {
                a, b, c, d
            });
        }

        private TokenClickStyle(String s1, int i1, boolean flag)
        {
            super(s1, i1);
            mIsSelectable = false;
            mIsSelectable = flag;
        }
    }

}
