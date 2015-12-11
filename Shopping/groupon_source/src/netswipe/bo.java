// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.text.Editable;
import com.jumio.netswipe.sdk.enums.CreditCardType;

// Referenced classes of package netswipe:
//            ay, bm, aw

class bo extends ay
{

    final CreditCardType b;
    final bm c;
    private boolean d;

    bo(bm bm1, aw aw1, CreditCardType creditcardtype)
    {
        c = bm1;
        b = creditcardtype;
        aw1.getClass();
        super(aw1);
        d = true;
    }

    public void afterTextChanged(Editable editable)
    {
        if (b == CreditCardType.AMERICAN_EXPRESS && editable.length() == 4 && d)
        {
            for (int i = 0; i < c.getChildCount(); i++)
            {
                if (c.getChildAt(i) == bm.a(c) && i + 1 < c.getChildCount() && (c.getChildAt(i + 1) instanceof aw))
                {
                    bm.a(c, bm.a(c));
                }
                d = false;
            }

        }
        super.afterTextChanged(editable);
    }
}
