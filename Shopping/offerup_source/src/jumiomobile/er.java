// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.text.Editable;
import com.jumio.netswipe.sdk.enums.CreditCardType;

// Referenced classes of package jumiomobile:
//            eh, ep, ee

class er extends eh
{

    final CreditCardType b;
    final ep c;
    private boolean d;

    er(ep ep1, ee ee1, CreditCardType creditcardtype)
    {
        c = ep1;
        b = creditcardtype;
        ee1.getClass();
        super(ee1);
        d = true;
    }

    public void afterTextChanged(Editable editable)
    {
        if ((b == CreditCardType.AMERICAN_EXPRESS && editable.length() == 4 || b != CreditCardType.AMERICAN_EXPRESS && editable.length() == 3) && d)
        {
            for (int i = 0; i < c.getChildCount(); i++)
            {
                if (c.getChildAt(i) == ep.a(c) && i + 1 < c.getChildCount() && (c.getChildAt(i + 1) instanceof ee))
                {
                    ep.a(c, ep.a(c));
                }
                d = false;
            }

        }
        super.afterTextChanged(editable);
    }
}
