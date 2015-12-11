// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Editable;
import android.widget.TableRow;

// Referenced classes of package jumiomobile:
//            bf, en

public abstract class eo extends TableRow
{

    protected int f;
    protected int g;
    protected int h;
    protected boolean i;
    protected boolean j;
    protected boolean k;
    protected Paint l;
    protected en m;

    public eo(Context context)
    {
        super(context);
        f = bf.a(context, 6);
        g = bf.a(context, 14);
        h = bf.a(context, 14);
        setPadding(g, f, h, f);
        setBackgroundColor(0xccffffff);
        l = new Paint(1);
        l.setColor(0xff969696);
        j = true;
        k = false;
        i = false;
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

    public abstract boolean a();

    protected abstract void b();

    public boolean getAutoFocusNextView()
    {
        return j;
    }

    public boolean getAutoShowNextView()
    {
        return k;
    }

    public abstract Editable getValueText();

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (i)
        {
            canvas.drawLine(0.0F, 0.0F, canvas.getWidth(), 0.0F, l);
        }
    }

    public void setAutoFocusNextView(boolean flag)
    {
        j = flag;
    }

    public void setAutoShowNextView(boolean flag)
    {
        k = flag;
    }

    public void setShowDivider(boolean flag)
    {
        i = flag;
        invalidate();
    }

    public void setValidationCallback(en en)
    {
        m = en;
    }
}
