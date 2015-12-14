// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.content.res.Resources;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

// Referenced classes of package com.livemixtapes:
//            SignUp, console

class this._cls0
    implements android.view.ckListener
{

    final SignUp this$0;

    public void onClick(View view)
    {
        String s;
        String as[];
        String s1;
        String s2;
        SignUp.access$6(SignUp.this);
        if (SignUp.access$8(SignUp.this).length() == 0)
        {
            SignUp.access$13(SignUp.this, SignUp.access$12(SignUp.this));
            SignUp.access$8(SignUp.this).requestFocus();
            return;
        }
        if (SignUp.access$14(SignUp.this).length() == 0)
        {
            SignUp.access$13(SignUp.this, SignUp.access$15(SignUp.this));
            SignUp.access$14(SignUp.this).requestFocus();
            return;
        }
        if (SignUp.access$16(SignUp.this).length() == 0)
        {
            SignUp.access$13(SignUp.this, SignUp.access$17(SignUp.this));
            SignUp.access$16(SignUp.this).requestFocus();
            return;
        }
        if (SignUp.access$10(SignUp.this).length() == 0)
        {
            SignUp.access$13(SignUp.this, SignUp.access$18(SignUp.this));
            SignUp.access$10(SignUp.this).requestFocus();
            return;
        }
        if (SignUp.access$19(SignUp.this).length() == 0)
        {
            SignUp.access$13(SignUp.this, SignUp.access$20(SignUp.this));
            SignUp.access$19(SignUp.this).requestFocus();
            return;
        }
        if (SignUp.access$21(SignUp.this).length() == 0)
        {
            SignUp.access$13(SignUp.this, SignUp.access$22(SignUp.this));
            SignUp.access$21(SignUp.this).requestFocus();
            return;
        }
        if (SignUp.access$23(SignUp.this).length() == 0)
        {
            SignUp.access$13(SignUp.this, SignUp.access$24(SignUp.this));
            SignUp.access$23(SignUp.this).requestFocus();
            return;
        }
        if (SignUp.access$25(SignUp.this).length() == 0)
        {
            SignUp.access$13(SignUp.this, SignUp.access$26(SignUp.this));
            SignUp.access$25(SignUp.this).requestFocus();
            return;
        }
        if (SignUp.access$27(SignUp.this).length() == 0)
        {
            SignUp.access$13(SignUp.this, SignUp.access$28(SignUp.this));
            SignUp.access$27(SignUp.this).requestFocus();
            return;
        }
        if (!SignUp.access$29(SignUp.this).isChecked() && !SignUp.access$30(SignUp.this).isChecked())
        {
            SignUp.access$13(SignUp.this, SignUp.access$31(SignUp.this));
            SignUp.access$29(SignUp.this).requestFocus();
            return;
        }
        if (SignUp.access$32(SignUp.this).length() == 0)
        {
            SignUp.access$13(SignUp.this, SignUp.access$33(SignUp.this));
            SignUp.access$32(SignUp.this).requestFocus();
            return;
        }
        if (!SignUp.access$34(SignUp.this).isChecked())
        {
            SignUp.access$13(SignUp.this, SignUp.access$35(SignUp.this));
            SignUp.access$34(SignUp.this).requestFocus();
            return;
        }
        s = getResources().getStringArray(0x7f0f0001)[SignUp.access$36(SignUp.this).getSelectedItemPosition()];
        as = SignUp.access$32(SignUp.this).getText().toString().split("/");
        s1 = SignUp.access$14(SignUp.this).getText().toString();
        s2 = SignUp.access$23(SignUp.this).getText().toString();
        console.log(new Object[] {
            as[0]
        });
        view = null;
        if (!SignUp.access$29(SignUp.this).isChecked()) goto _L2; else goto _L1
_L1:
        view = "M";
_L4:
        String s3 = SignUp.access$25(SignUp.this).getText().toString();
        String s4 = SignUp.access$19(SignUp.this).getText().toString();
        String s5 = SignUp.access$8(SignUp.this).getText().toString();
        String s6 = SignUp.access$27(SignUp.this).getText().toString();
        console.log(new Object[] {
            (new StringBuilder("country=")).append(s).append("&dob_day=").append(as[1]).append("&dob_month=").append(as[0]).append("&dob_year=").append(as[2]).append("&email=").append(s1).append("&firstname=").append(s2).append("&gender=").append(view).append("&lastname=").append(s3).append("&password=").append(s4).append("&tos=1").append("&username=").append(s5).append("&zip=").append(s6).toString()
        });
        SignUp.access$37(SignUp.this);
        return;
_L2:
        if (SignUp.access$30(SignUp.this).isChecked())
        {
            view = "F";
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    es()
    {
        this$0 = SignUp.this;
        super();
    }
}
