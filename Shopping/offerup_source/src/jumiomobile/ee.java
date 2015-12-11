// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.TransformationMethod;
import android.widget.EditText;
import android.widget.TextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package jumiomobile:
//            eo, eh, bg, ef, 
//            eg, en, cs

public class ee extends eo
{

    protected TextView a;
    protected EditText b;
    protected Pattern c;
    protected boolean d;
    protected eh e;

    public ee(Context context)
    {
        super(context);
        e = null;
        d = true;
        setLayoutParams(new android.widget.TableLayout.LayoutParams(-2, -2));
        setOrientation(0);
        setGravity(16);
        e = new eh(this);
        a = new TextView(context);
        android.widget.TableRow.LayoutParams layoutparams = new android.widget.TableRow.LayoutParams(-2, -2);
        a.setLayoutParams(layoutparams);
        a.setTextColor(0xff646464);
        a.setTextSize(2, 18F);
        addView(a);
        b = new EditText(context);
        layoutparams = new android.widget.TableRow.LayoutParams(0, -2);
        layoutparams.weight = 1.0F;
        b.setBackgroundColor(0);
        b.setLayoutParams(layoutparams);
        b.setTextColor(0xff444444);
        b.setHintTextColor(0xff969696);
        b.setGravity(5);
        b.setTextSize(2, 20F);
        b.addTextChangedListener(e);
        int i = bg.a(context, 9);
        b.setPadding(0, i, 0, i);
        addView(b);
    }

    public void a(TextWatcher textwatcher)
    {
        b.addTextChangedListener(textwatcher);
    }

    protected void a(EditText edittext)
    {
        edittext.setOnLongClickListener(new ef(this));
        edittext.setCustomSelectionActionModeCallback(new eg(this));
    }

    public boolean a()
    {
        if (c != null)
        {
            Matcher matcher = c.matcher(b.getText());
            if (d)
            {
                EditText edittext = b;
                int i;
                if (matcher.matches())
                {
                    i = 0xff444444;
                } else
                {
                    i = 0xffcc0000;
                }
                edittext.setTextColor(i);
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
            if (m != null)
            {
                if (!flag)
                {
                    break label0;
                }
                m.a(this);
            }
            return;
        }
        m.b(this);
    }

    public void c()
    {
        a(b);
    }

    public Editable getValueText()
    {
        return b.getText();
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

    public void setInputType(int i)
    {
        b.setInputType(i);
    }

    public void setKeyListener(KeyListener keylistener)
    {
        b.setKeyListener(keylistener);
    }

    public void setLabelId(int i)
    {
        a.setId(i);
    }

    public void setLabelText(CharSequence charsequence)
    {
        a.setText(charsequence);
        if (cs.a())
        {
            b.setContentDescription(charsequence);
        }
    }

    public void setTransformationMethod(TransformationMethod transformationmethod)
    {
        b.setTransformationMethod(transformationmethod);
    }

    public void setTypeface(Typeface typeface)
    {
        b.setTypeface(typeface);
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

    public void setValueId(int i)
    {
        b.setId(i);
    }

    public void setValueText(CharSequence charsequence)
    {
        b.setText(charsequence);
    }
}
