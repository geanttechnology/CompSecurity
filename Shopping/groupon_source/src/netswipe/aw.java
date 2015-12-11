// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.TransformationMethod;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package netswipe:
//            dc, ay, ax, bh

public class aw extends TableRow
{

    protected TextView a;
    protected EditText b;
    protected Pattern c;
    protected bh d;
    protected boolean e;
    protected boolean f;
    protected boolean g;
    protected Paint h;
    protected boolean i;
    protected int j;
    protected int k;
    protected int l;
    protected ay m;

    public aw(Context context)
    {
        super(context);
        m = null;
        e = true;
        f = true;
        g = false;
        i = false;
        j = dc.a(context, 6);
        k = dc.a(context, 14);
        l = dc.a(context, 22);
        h = new Paint(1);
        h.setColor(0xff969696);
        setLayoutParams(new android.widget.TableLayout.LayoutParams(-2, -2));
        setPadding(k, j, l, j);
        setBackgroundColor(0xccffffff);
        setOrientation(0);
        setGravity(16);
        m = new ay(this);
        a = new TextView(context);
        android.widget.TableRow.LayoutParams layoutparams = new android.widget.TableRow.LayoutParams(-2, -2);
        a.setLayoutParams(layoutparams);
        a.setTextColor(0xff646464);
        a.setTextSize(0, dc.a(context, 15));
        addView(a);
        b = new EditText(context);
        layoutparams = new android.widget.TableRow.LayoutParams(0, -2);
        layoutparams.weight = 1.0F;
        b.setBackgroundColor(0);
        b.setLayoutParams(layoutparams);
        b.setTextColor(0xff444444);
        b.setHintTextColor(0xff969696);
        b.setGravity(5);
        b.setTextSize(0, dc.a(context, 17));
        b.addTextChangedListener(m);
        addView(b);
    }

    public void a(int i1, int j1, int k1, int l1)
    {
        android.widget.TableLayout.LayoutParams layoutparams = (android.widget.TableLayout.LayoutParams)getLayoutParams();
        layoutparams.leftMargin = i1;
        layoutparams.topMargin = j1;
        layoutparams.rightMargin = k1;
        layoutparams.bottomMargin = l1;
        setLayoutParams(layoutparams);
    }

    public void a(TextWatcher textwatcher)
    {
        b.addTextChangedListener(textwatcher);
    }

    protected void a(EditText edittext)
    {
        edittext.setCustomSelectionActionModeCallback(new ax(this));
    }

    public boolean a()
    {
        if (c != null)
        {
            Matcher matcher = c.matcher(b.getText());
            if (e)
            {
                EditText edittext = b;
                int i1;
                if (matcher.matches())
                {
                    i1 = 0xff444444;
                } else
                {
                    i1 = 0xffcc0000;
                }
                edittext.setTextColor(i1);
            }
            return matcher.matches();
        } else
        {
            return true;
        }
    }

    protected void b()
    {
label0:
        {
            boolean flag = a();
            if (d != null)
            {
                if (!flag)
                {
                    break label0;
                }
                d.a(this);
            }
            return;
        }
        d.b(this);
    }

    public void c()
    {
        a(b);
    }

    public boolean getAutoFocusNextView()
    {
        return f;
    }

    public boolean getAutoShowNextView()
    {
        return g;
    }

    public Editable getValueText()
    {
        return b.getText();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (i)
        {
            canvas.drawLine(0.0F, 0.0F, canvas.getWidth(), 0.0F, h);
        }
    }

    public void setAutoFocusNextView(boolean flag)
    {
        f = flag;
    }

    public void setAutoShowNextView(boolean flag)
    {
        g = flag;
    }

    public void setEnabled(boolean flag)
    {
        a.setEnabled(flag);
        b.setEnabled(flag);
    }

    public void setFilters(InputFilter ainputfilter[])
    {
        b.setFilters(ainputfilter);
    }

    public void setInputType(int i1)
    {
        b.setInputType(i1);
    }

    public void setKeyListener(KeyListener keylistener)
    {
        b.setKeyListener(keylistener);
    }

    public void setLabelId(int i1)
    {
        a.setId(i1);
    }

    public void setLabelText(CharSequence charsequence)
    {
        a.setText(charsequence);
    }

    public void setShowDivider(boolean flag)
    {
        i = flag;
        invalidate();
    }

    public void setTransformationMethod(TransformationMethod transformationmethod)
    {
        b.setTransformationMethod(transformationmethod);
    }

    public void setTypeface(Typeface typeface)
    {
        b.setTypeface(typeface);
    }

    public void setValidationCallback(bh bh1)
    {
        d = bh1;
    }

    public void setValidationPattern(String s)
    {
        if (s != null && s.length() != 0)
        {
            c = Pattern.compile(s);
            return;
        } else
        {
            c = null;
            return;
        }
    }

    public void setValidationPattern(Pattern pattern)
    {
        c = pattern;
    }

    public void setValueHint(CharSequence charsequence)
    {
        b.setHint(charsequence);
    }

    public void setValueId(int i1)
    {
        b.setId(i1);
    }

    public void setValueText(CharSequence charsequence)
    {
        b.setText(charsequence);
    }
}
