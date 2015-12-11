// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.bestbuy.android.activities.blueassist.BlueAssistUserContactInfoActivity;
import com.bestbuy.android.bbyobjects.BBYButton;

public class bv
    implements TextWatcher
{

    final BlueAssistUserContactInfoActivity a;
    private EditText b;

    public bv(BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity, EditText edittext)
    {
        a = blueassistusercontactinfoactivity;
        super();
        b = edittext;
    }

    public void afterTextChanged(Editable editable)
    {
        editable = editable.toString();
        b.getId();
        JVM INSTR tableswitch 2131492906 2131492909: default 44
    //                   2131492906 118
    //                   2131492907 146
    //                   2131492908 174
    //                   2131492909 220;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_220;
_L6:
        BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity;
        boolean flag;
        if (BlueAssistUserContactInfoActivity.n(a) && BlueAssistUserContactInfoActivity.o(a) && BlueAssistUserContactInfoActivity.p(a) && BlueAssistUserContactInfoActivity.q(a))
        {
            BlueAssistUserContactInfoActivity.a(a).setEnabled(true);
            BlueAssistUserContactInfoActivity.a(a).setTextColor(a.getResources().getColor(0x7f0b0002));
            return;
        } else
        {
            BlueAssistUserContactInfoActivity.a(a).setEnabled(false);
            BlueAssistUserContactInfoActivity.a(a).setTextColor(a.getResources().getColor(0x7f0b0006));
            return;
        }
_L2:
        blueassistusercontactinfoactivity = a;
        if (!editable.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        BlueAssistUserContactInfoActivity.b(blueassistusercontactinfoactivity, flag);
          goto _L6
_L3:
        BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity1 = a;
        boolean flag1;
        if (!editable.isEmpty())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        BlueAssistUserContactInfoActivity.c(blueassistusercontactinfoactivity1, flag1);
          goto _L6
_L4:
        if (!editable.isEmpty() && a.d(editable))
        {
            BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity2 = a;
            boolean flag2;
            if (!editable.isEmpty())
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            BlueAssistUserContactInfoActivity.d(blueassistusercontactinfoactivity2, flag2);
        }
          goto _L6
        if (!editable.isEmpty() && a.c(editable))
        {
            BlueAssistUserContactInfoActivity blueassistusercontactinfoactivity3 = a;
            boolean flag3;
            if (!editable.isEmpty())
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            BlueAssistUserContactInfoActivity.e(blueassistusercontactinfoactivity3, flag3);
        }
          goto _L6
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }
}
