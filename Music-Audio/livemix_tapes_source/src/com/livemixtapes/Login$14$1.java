// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.widget.ProgressBar;

// Referenced classes of package com.livemixtapes:
//            Login

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        Login.access$16(_fld0, "Error", "The given user name or password is invalid.");
    }

    llback()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/livemixtapes/Login$14

/* anonymous class */
    class Login._cls14 extends User.UserCallback
    {

        final Login this$0;

        public void always()
        {
            Login.access$14(Login.this, Boolean.valueOf(false));
            Login.access$15(Login.this).setVisibility(8);
        }

        public void failure(int i, Exception exception)
        {
            if (i == 1)
            {
                Login.access$8(Login.this, Login.access$3(Login.this));
                Login.access$17(Login.this, Login.access$5(Login.this), new Login._cls14._cls1());
                return;
            } else
            {
                Login.access$16(Login.this, "Error", "There was an unknown error while logging in.");
                return;
            }
        }

        public void success(User.UserData userdata)
        {
            Login.access$12(Login.this);
        }


            
            {
                this$0 = Login.this;
                super();
            }
    }

}
