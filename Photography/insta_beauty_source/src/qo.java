// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.CompoundButton;
import com.fotoable.beautyui.gpuimage.sample.activity.contiCapEditItem;
import java.util.ArrayList;

class qo
    implements android.widget.CompoundButton.OnCheckedChangeListener
{

    final int a;
    final qn b;

    qo(qn qn1, int i)
    {
        b = qn1;
        a = i;
        super();
    }

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        int i;
        i = 0;
        ((contiCapEditItem)qn.a(b).get(a)).isChecked = flag;
        if (!flag) goto _L2; else goto _L1
_L1:
        qn.b(b).a(true);
_L4:
        qn.b(b).a(b.a().size());
        return;
_L2:
        qn.b(b).a(false);
        do
        {
            if (i < qn.a(b).size())
            {
label0:
                {
                    if (!((contiCapEditItem)qn.a(b).get(i)).isChecked)
                    {
                        break label0;
                    }
                    qn.b(b).a(true);
                }
            }
            if (true)
            {
                continue;
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }
}
