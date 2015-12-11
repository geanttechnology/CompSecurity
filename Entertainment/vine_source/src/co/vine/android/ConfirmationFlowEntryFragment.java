// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import co.vine.android.util.Util;
import co.vine.android.widgets.PromptDialogSupportFragment;

// Referenced classes of package co.vine.android:
//            BaseControllerFragment, ConfirmationFlowVerificationFragment

public class ConfirmationFlowEntryFragment extends BaseControllerFragment
    implements co.vine.android.widgets.PromptDialogSupportFragment.OnDialogDoneListener
{

    public static final String ARG_PHONE_NUMBER = "phone_number";
    public static final String STATE_PHONE_NUMBER = "phone_number";
    private MenuItem mNext;
    private boolean mNextEnabled;
    private String mPhone;
    private EditText mPhoneNumberBox;

    public ConfirmationFlowEntryFragment()
    {
    }

    private void toggleNextAction(boolean flag)
    {
        mNextEnabled = flag;
        if (mNext != null)
        {
            mNext.setEnabled(flag);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        Bundle bundle1 = getArguments();
        if (bundle1 != null)
        {
            mPhone = bundle1.getString("phone_number");
        } else
        if (bundle != null)
        {
            mPhone = bundle.getString("phone_number");
            return;
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        menuinflater.inflate(0x7f10000b, menu);
        mNext = menu.findItem(0x7f0a0246);
        mNext.setEnabled(mNextEnabled);
        super.onCreateOptionsMenu(menu, menuinflater);
    }

    public View onCreateView(LayoutInflater layoutinflater, final ViewGroup phoneNumberBox, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030027, phoneNumberBox, false);
        phoneNumberBox = (EditText)layoutinflater.findViewById(0x7f0a0085);
        ((TextView)layoutinflater.findViewById(0x7f0a0084)).setText(getString(0x7f0e008a));
        bundle = mPhone;
        if (!TextUtils.isEmpty(bundle))
        {
            phoneNumberBox.setText(bundle);
            phoneNumberBox.setSelection(bundle.length());
        }
        phoneNumberBox.addTextChangedListener(new TextWatcher() {

            final ConfirmationFlowEntryFragment this$0;
            final EditText val$phoneNumberBox;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                if (!TextUtils.isEmpty(phoneNumberBox.getText()))
                {
                    toggleNextAction(true);
                    return;
                } else
                {
                    toggleNextAction(false);
                    return;
                }
            }

            
            {
                this$0 = ConfirmationFlowEntryFragment.this;
                phoneNumberBox = edittext;
                super();
            }
        });
        mPhoneNumberBox = phoneNumberBox;
        return layoutinflater;
    }

    public void onDialogDone(DialogInterface dialoginterface, int i, int j)
    {
        i;
        JVM INSTR tableswitch 1 1: default 20
    //                   1 21;
           goto _L1 _L2
_L1:
        return;
_L2:
        switch (j)
        {
        default:
            return;

        case -1: 
            dialoginterface = getActivity();
            break;
        }
        if (dialoginterface != null)
        {
            ConfirmationFlowVerificationFragment confirmationflowverificationfragment = new ConfirmationFlowVerificationFragment();
            Bundle bundle = new Bundle();
            bundle.putString("phone_number", mPhone);
            bundle.putBoolean("from_sign_up", false);
            confirmationflowverificationfragment.setArguments(bundle);
            dialoginterface.getSupportFragmentManager().beginTransaction().setCustomAnimations(0x7f040017, 0x7f040018).replace(0x7f0a0102, confirmationflowverificationfragment).commit();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        boolean flag = false;
        menuitem.getItemId();
        JVM INSTR tableswitch 2131362374 2131362374: default 28
    //                   2131362374 36;
           goto _L1 _L2
_L1:
        flag = super.onOptionsItemSelected(menuitem);
_L4:
        return flag;
_L2:
        menuitem = mPhoneNumberBox.getText();
        if (menuitem != null)
        {
            mPhone = menuitem.toString();
            menuitem = PromptDialogSupportFragment.newInstance(1, 3);
            menuitem.setTargetFragment(this, 0);
            menuitem.setTitle(0x7f0e026f).setMessage(getString(0x7f0e0117, new Object[] {
                mPhone
            })).setPositiveButton(0x7f0e0163).setNeutralButton(0x7f0e0057).show(getActivity().getSupportFragmentManager());
            return true;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onPause()
    {
        super.onPause();
        Util.setSoftKeyboardVisibility(getActivity(), mPhoneNumberBox, false);
    }

    public void onResume()
    {
        super.onResume();
        if (!TextUtils.isEmpty(mPhone))
        {
            toggleNextAction(true);
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putString("phone_number", mPhone);
        super.onSaveInstanceState(bundle);
    }

}
