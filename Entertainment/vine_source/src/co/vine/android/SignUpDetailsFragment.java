// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import co.vine.android.util.ContactsHelper;
import co.vine.android.util.Util;
import co.vine.android.widget.SpanClickListener;
import co.vine.android.widget.StyledClickableSpan;
import co.vine.android.widget.Typefaces;

// Referenced classes of package co.vine.android:
//            BaseFragment, SignUpPagerActivity, WebViewActivity

public class SignUpDetailsFragment extends BaseFragment
    implements TextWatcher, SpanClickListener, co.vine.android.util.ContactsHelper.ContactHelperListener
{

    private static final int SPAN_PRIVACY_POLICY = 1;
    private static final int SPAN_TOS = 2;
    private MenuItem mDoneButton;
    private EditText mEmail;
    private EditText mPassword;
    private EditText mPhone;

    public SignUpDetailsFragment()
    {
    }

    private boolean onNextClicked()
    {
        boolean flag = false;
        Util.setSoftKeyboardVisibility(getActivity(), mEmail, false);
        SignUpPagerActivity signuppageractivity = (SignUpPagerActivity)getActivity();
        if (signuppageractivity != null)
        {
            signuppageractivity.setLogin(mEmail.getText().toString());
            signuppageractivity.setPassword(mPassword.getText().toString());
            signuppageractivity.setPhone(mPhone.getText().toString());
            signuppageractivity.toNextStep();
            flag = true;
        }
        return flag;
    }

    private boolean validate()
    {
        return mEmail != null && mEmail.length() >= 3 && mPassword != null && mPassword.length() >= 8;
    }

    public void afterTextChanged(Editable editable)
    {
        if (mDoneButton != null)
        {
            mDoneButton.setEnabled(validate());
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        ((SignUpPagerActivity)getActivity()).setBarTitle(0x7f0e0124);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        menuinflater.inflate(0x7f100004, menu);
        menu = menu.findItem(0x7f0a0245);
        if (menu != null)
        {
            menu.setEnabled(validate());
        }
        mDoneButton = menu;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030094, viewgroup, false);
    }

    public void onEmailLoaded(String s)
    {
        EditText edittext = mEmail;
        if (TextUtils.isEmpty(edittext.getText()) && !TextUtils.isEmpty(s))
        {
            edittext.setText(s);
            edittext.setSelection(s.length());
        }
    }

    public void onNameLoaded(String s)
    {
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131362373: 
            return onNextClicked();
        }
    }

    public void onPhoneNumberLoaded(String s)
    {
        if (TextUtils.isEmpty(mPhone.getText()) && !TextUtils.isEmpty(s))
        {
            mPhone.setText(s);
        }
    }

    public void onSpanClicked(View view, int i, Object obj)
    {
        if (getActivity() == null)
        {
            return;
        }
        view = new Intent(getActivity(), co/vine/android/WebViewActivity);
        i;
        JVM INSTR tableswitch 1 2: default 44
    //                   1 45
    //                   2 59;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        view.putExtra("type", 1);
_L5:
        startActivity(view);
        return;
_L3:
        view.putExtra("type", 2);
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        mEmail = (EditText)view.findViewById(0x7f0a0215);
        mEmail.addTextChangedListener(this);
        mPassword = (EditText)view.findViewById(0x7f0a0217);
        mPassword.addTextChangedListener(this);
        mPassword.setTypeface(Typefaces.get(getActivity()).getContentTypeface(0, 2));
        mPhone = (EditText)view.findViewById(0x7f0a021a);
        mPhone.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final SignUpDetailsFragment this$0;

            public boolean onEditorAction(TextView textview, int k, KeyEvent keyevent)
            {
                if (k == 6 && validate() && getActivity() != null)
                {
                    ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(mPhone.getWindowToken(), 0);
                    onNextClicked();
                }
                return true;
            }

            
            {
                this$0 = SignUpDetailsFragment.this;
                super();
            }
        });
        bundle = (TextView)view.findViewById(0x7f0a021e);
        view = new StyleSpan(1);
        Object obj = new StyleSpan(1);
        String s = getString(0x7f0e0220);
        view = Util.getSpannedText(new StyleSpan[] {
            view, obj
        }, s, '"');
        bundle.setText(view);
        bundle.setMovementMethod(LinkMovementMethod.getInstance());
        bundle = (Spannable)bundle.getText();
        StyleSpan astylespan[] = (StyleSpan[])view.getSpans(0, view.length(), android/text/style/StyleSpan);
        obj = getResources();
        int i = view.getSpanStart(astylespan[0]);
        int j = view.getSpanEnd(astylespan[0]);
        StyledClickableSpan styledclickablespan = new StyledClickableSpan(1, null, this);
        styledclickablespan.setColor(((Resources) (obj)).getColor(0x7f09008d));
        Util.safeSetSpan(bundle, styledclickablespan, i, j, 33);
        i = view.getSpanStart(astylespan[1]);
        j = view.getSpanEnd(astylespan[1]);
        view = new StyledClickableSpan(2, null, this);
        view.setColor(((Resources) (obj)).getColor(0x7f09008d));
        Util.safeSetSpan(bundle, view, i, j, 33);
        ContactsHelper.loadContacts(this, this);
    }



}
