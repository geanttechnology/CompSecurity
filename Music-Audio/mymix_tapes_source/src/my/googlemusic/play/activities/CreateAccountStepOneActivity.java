// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.TextView;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;
import my.googlemusic.play.utils.views.RobotoEditText;
import my.googlemusic.play.utils.views.RobotoTextView;

// Referenced classes of package my.googlemusic.play.activities:
//            CreateAccountStepTwoActivity

public class CreateAccountStepOneActivity extends ActionBarActivity
    implements android.view.View.OnClickListener, android.view.View.OnFocusChangeListener, android.view.View.OnLongClickListener, android.view.View.OnTouchListener
{
    public static class DialogTermsFragment extends DialogFragment
    {

        public Dialog onCreateDialog(Bundle bundle)
        {
            bundle = new android.app.AlertDialog.Builder(new ContextThemeWrapper(getActivity(), 0x7f080025));
            bundle.setView(getActivity().getLayoutInflater().inflate(0x7f030049, null));
            return bundle.create();
        }

        public DialogTermsFragment()
        {
        }
    }

    private static class ViewHolder
    {

        private CheckBox authorize;
        private RobotoEditText confirmPassword;
        private View confirmPasswordSelector;
        private RobotoEditText email;
        private View emailSelector;
        private RobotoEditText name;
        private View nameSelector;
        private RobotoTextView next;
        private RobotoEditText password;
        private View passwordSelector;
        private TextView terms;




/*
        static RobotoEditText access$1002(ViewHolder viewholder, RobotoEditText robotoedittext)
        {
            viewholder.confirmPassword = robotoedittext;
            return robotoedittext;
        }

*/


/*
        static TextView access$102(ViewHolder viewholder, TextView textview)
        {
            viewholder.terms = textview;
            return textview;
        }

*/



/*
        static View access$1102(ViewHolder viewholder, View view)
        {
            viewholder.confirmPasswordSelector = view;
            return view;
        }

*/



/*
        static RobotoEditText access$202(ViewHolder viewholder, RobotoEditText robotoedittext)
        {
            viewholder.name = robotoedittext;
            return robotoedittext;
        }

*/



/*
        static View access$302(ViewHolder viewholder, View view)
        {
            viewholder.nameSelector = view;
            return view;
        }

*/



/*
        static RobotoEditText access$402(ViewHolder viewholder, RobotoEditText robotoedittext)
        {
            viewholder.email = robotoedittext;
            return robotoedittext;
        }

*/



/*
        static View access$502(ViewHolder viewholder, View view)
        {
            viewholder.emailSelector = view;
            return view;
        }

*/



/*
        static CheckBox access$602(ViewHolder viewholder, CheckBox checkbox)
        {
            viewholder.authorize = checkbox;
            return checkbox;
        }

*/



/*
        static RobotoTextView access$702(ViewHolder viewholder, RobotoTextView robototextview)
        {
            viewholder.next = robototextview;
            return robototextview;
        }

*/



/*
        static RobotoEditText access$802(ViewHolder viewholder, RobotoEditText robotoedittext)
        {
            viewholder.password = robotoedittext;
            return robotoedittext;
        }

*/



/*
        static View access$902(ViewHolder viewholder, View view)
        {
            viewholder.passwordSelector = view;
            return view;
        }

*/

        private ViewHolder()
        {
        }

    }


    private ViewHolder mHolder;

    public CreateAccountStepOneActivity()
    {
    }

    private void initData()
    {
    }

    private void initView()
    {
        getSupportActionBar().hide();
        setContentView(0x7f030021);
        mHolder = new ViewHolder();
        mHolder.terms = (TextView)findViewById(0x7f0d00b7);
        mHolder.name = (RobotoEditText)findViewById(0x7f0d00ae);
        mHolder.nameSelector = findViewById(0x7f0d00af);
        mHolder.email = (RobotoEditText)findViewById(0x7f0d00b0);
        mHolder.emailSelector = findViewById(0x7f0d00b1);
        mHolder.authorize = (CheckBox)findViewById(0x7f0d00b6);
        mHolder.next = (RobotoTextView)findViewById(0x7f0d00b8);
        mHolder.password = (RobotoEditText)findViewById(0x7f0d00b2);
        mHolder.passwordSelector = findViewById(0x7f0d00b3);
        mHolder.confirmPassword = (RobotoEditText)findViewById(0x7f0d00b4);
        mHolder.confirmPasswordSelector = findViewById(0x7f0d00b5);
        mHolder.next.setOnClickListener(this);
        mHolder.terms.setOnClickListener(this);
        mHolder.authorize.setOnClickListener(this);
        mHolder.name.setOnFocusChangeListener(this);
        mHolder.email.setOnFocusChangeListener(this);
        mHolder.password.setOnFocusChangeListener(this);
        mHolder.confirmPassword.setOnFocusChangeListener(this);
        mHolder.name.setOnTouchListener(this);
        mHolder.name.setOnLongClickListener(this);
        mHolder.password.setOnTouchListener(this);
        mHolder.password.setOnLongClickListener(this);
        mHolder.email.setOnTouchListener(this);
        mHolder.email.setOnLongClickListener(this);
        mHolder.confirmPassword.setOnTouchListener(this);
        mHolder.confirmPassword.setOnLongClickListener(this);
    }

    public boolean isVerify()
    {
        String s = mHolder.name.getText().toString();
        String s1 = mHolder.email.getText().toString();
        String s2 = mHolder.password.getText().toString();
        if (s.isEmpty() || mHolder.email.getText().toString().isEmpty() || mHolder.password.getText().toString().isEmpty() || mHolder.confirmPassword.getText().toString().isEmpty())
        {
            Toast.with(this).message("All fields are required.").show();
            return false;
        }
        if (!mHolder.email.getText().toString().contains("@") || !mHolder.email.getText().toString().contains("."))
        {
            Toast.with(this).message("Format email invalid.").show();
            return false;
        }
        if (!mHolder.password.getText().toString().equals(mHolder.confirmPassword.getText().toString()))
        {
            Toast.with(this).message("Passwords don't match.").show();
            return false;
        }
        if (mHolder.password.getText().toString().length() < 6)
        {
            Toast.with(this).message("The password must have at least 6 characters.").show();
            return false;
        }
        if (s.contains("#") || s1.contains("#") || s2.contains("#"))
        {
            Toast.with(this).message("Only use letters, numbers and _ ").show();
            return false;
        }
        if (s.contains("&") || s1.contains("&") || s2.contains("&"))
        {
            Toast.with(this).message("Only use letters, numbers and _ ").show();
            return false;
        }
        if (s.contains("/") || s1.contains("/") || s2.contains("/"))
        {
            Toast.with(this).message("Only use letters, numbers and _ ").show();
            return false;
        }
        if (s.contains("$") || s1.contains("$") || s2.contains("$"))
        {
            Toast.with(this).message("Only use letters, numbers and _ ").show();
            return false;
        }
        if (s.contains("%") || s1.contains("%") || s2.contains("%"))
        {
            Toast.with(this).message("Only use letters, numbers and _ ").show();
            return false;
        }
        if (s.contains("?") || s1.contains("?") || s2.contains("?"))
        {
            Toast.with(this).message("Only use letters, numbers and _ ").show();
            return false;
        }
        if (!mHolder.authorize.isChecked())
        {
            Toast.with(this).message("You need to agree with the terms and conditions").show();
            return false;
        } else
        {
            return true;
        }
    }

    public void onClick(View view)
    {
        if (view == mHolder.next)
        {
            if (isVerify())
            {
                startActivity((new Intent(this, my/googlemusic/play/activities/CreateAccountStepTwoActivity)).putExtra("name", mHolder.name.getText().toString()).putExtra("email", mHolder.email.getText().toString()).putExtra("password", mHolder.password.getText().toString()));
            }
        } else
        if (view.getId() == mHolder.terms.getId())
        {
            (new DialogTermsFragment()).show(getSupportFragmentManager(), "");
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        initData();
        initView();
    }

    public void onFocusChange(View view, boolean flag)
    {
        if (view == mHolder.name)
        {
            mHolder.nameSelector.setBackgroundColor(getResources().getColor(0x7f0c0020));
            mHolder.emailSelector.setBackgroundColor(getResources().getColor(0x7f0c003c));
            mHolder.passwordSelector.setBackgroundColor(getResources().getColor(0x7f0c003c));
            mHolder.confirmPasswordSelector.setBackgroundColor(getResources().getColor(0x7f0c003c));
        } else
        {
            if (view == mHolder.email)
            {
                mHolder.nameSelector.setBackgroundColor(getResources().getColor(0x7f0c003c));
                mHolder.emailSelector.setBackgroundColor(getResources().getColor(0x7f0c0020));
                mHolder.passwordSelector.setBackgroundColor(getResources().getColor(0x7f0c003c));
                mHolder.confirmPasswordSelector.setBackgroundColor(getResources().getColor(0x7f0c003c));
                return;
            }
            if (view == mHolder.password)
            {
                mHolder.nameSelector.setBackgroundColor(getResources().getColor(0x7f0c003c));
                mHolder.emailSelector.setBackgroundColor(getResources().getColor(0x7f0c003c));
                mHolder.passwordSelector.setBackgroundColor(getResources().getColor(0x7f0c0020));
                mHolder.confirmPasswordSelector.setBackgroundColor(getResources().getColor(0x7f0c003c));
                return;
            }
            if (view == mHolder.confirmPassword)
            {
                mHolder.nameSelector.setBackgroundColor(getResources().getColor(0x7f0c003c));
                mHolder.emailSelector.setBackgroundColor(getResources().getColor(0x7f0c003c));
                mHolder.passwordSelector.setBackgroundColor(getResources().getColor(0x7f0c003c));
                mHolder.confirmPasswordSelector.setBackgroundColor(getResources().getColor(0x7f0c0020));
                return;
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 82)
        {
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public boolean onLongClick(View view)
    {
        return true;
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        view.requestFocus();
        ((InputMethodManager)getSystemService("input_method")).showSoftInput(view, 1);
        return true;
    }
}
