// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

// Referenced classes of package co.vine.android:
//            SignUpDetailsFragment

class this._cls0
    implements android.widget.istener
{

    final SignUpDetailsFragment this$0;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (i == 6 && SignUpDetailsFragment.access$000(SignUpDetailsFragment.this) && getActivity() != null)
        {
            ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(SignUpDetailsFragment.access$100(SignUpDetailsFragment.this).getWindowToken(), 0);
            boolean _tmp = SignUpDetailsFragment.access$200(SignUpDetailsFragment.this);
        }
        return true;
    }

    ger()
    {
        this$0 = SignUpDetailsFragment.this;
        super();
    }
}
