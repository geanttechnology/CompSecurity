// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.boldchat.sdk.utils.FloatLabelLayout;
import com.boldchat.visitor.api.Chat;
import com.boldchat.visitor.api.Form;
import com.boldchat.visitor.api.FormField;
import com.boldchat.visitor.api.FormFieldOption;
import com.boldchat.visitor.api.FormFieldType;
import com.boldchat.visitor.api.LanguageChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatSession

public class BoldChatFormView extends ScrollView
{
    private class LanguageChanger
        implements android.widget.AdapterView.OnItemSelectedListener, LanguageChangeListener
    {

        String mLanguage;
        final BoldChatFormView this$0;

        public void onItemSelected(AdapterView adapterview, View view, int i, long l)
        {
            if (i != 0)
            {
                adapterview = (FormFieldOption)adapterview.getItemAtPosition(i);
                if (mLanguage == null || !mLanguage.equals(adapterview.getValue()))
                {
                    mChat.changeLanguage(adapterview.getValue(), this);
                }
            }
        }

        public void onLanguageChange(String s)
        {
            mLanguage = s;
            BoldChatSession.runMain(new Runnable() {

                final LanguageChanger this$1;

                public void run()
                {
                    for (Iterator iterator = mFormKeyLabels.keySet().iterator(); iterator.hasNext();)
                    {
                        FormField formfield = (FormField)iterator.next();
                        Iterator iterator2 = ((ArrayList)mFormKeyLabels.get(formfield)).iterator();
                        while (iterator2.hasNext()) 
                        {
                            View view = (View)iterator2.next();
                            if (view != null)
                            {
                                setLabel(view, formfield);
                            }
                        }
                    }

                    for (Iterator iterator1 = mSelectAdapters.iterator(); iterator1.hasNext(); ((SelectAdapter)iterator1.next()).notifyDataSetChanged()) { }
                    if (mTitleKey != null && mTitleLabel != null)
                    {
                        CharSequence charsequence = getLabel(mTitleKey);
                        if (charsequence != null)
                        {
                            mTitleLabel.setText(charsequence);
                        }
                    }
                    if (mSubmitButtonLabelKey != null && mSubmitButton != null)
                    {
                        CharSequence charsequence1 = getLabel(mSubmitButtonLabelKey);
                        if (charsequence1 != null)
                        {
                            mSubmitButton.setText(charsequence1);
                        }
                    }
                }

            
            {
                this$1 = LanguageChanger.this;
                super();
            }
            }, mContext);
        }

        public void onLanguageChangeFailed(String s)
        {
            BoldChatSession.runMain(s. new Runnable() {

                final LanguageChanger this$1;
                final String val$message;

                public void run()
                {
                    Toast.makeText(mContext, message, 0).show();
                }

            
            {
                this$1 = final_languagechanger;
                message = String.this;
                super();
            }
            }, mContext);
        }

        public void onNothingSelected(AdapterView adapterview)
        {
        }

        public LanguageChanger(String s, FloatLabelLayout floatlabellayout)
        {
            this$0 = BoldChatFormView.this;
            super();
            mLanguage = s;
        }
    }

    public static class RegularExpressions
    {

        public static final Pattern EMAIL_ADDRESS = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");

    }

    private class SelectAdapter extends BaseAdapter
    {

        private int mErrorTextColor;
        private final FormField mFormField;
        private int mHintTextColor;
        private HashMap mHtmlLabelCache;
        private boolean mIsErrorState;
        private int mNormalTextColor;
        final BoldChatFormView this$0;

        private Spanned fromHtml(String s)
        {
            Spanned spanned1 = (Spanned)mHtmlLabelCache.get(s);
            Spanned spanned = spanned1;
            if (spanned1 == null)
            {
                spanned = Html.fromHtml(s);
                mHtmlLabelCache.put(s, spanned);
            }
            return spanned;
        }

        public int getCount()
        {
            if (mFormField.getOptions() != null)
            {
                return mFormField.getOptions().size() + 1;
            } else
            {
                return 1;
            }
        }

        public FormFieldOption getItem(int i)
        {
            if (i == 0)
            {
                return null;
            } else
            {
                return (FormFieldOption)mFormField.getOptions().get(i - 1);
            }
        }

        public volatile Object getItem(int i)
        {
            return getItem(i);
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            View view1;
            FormFieldOption formfieldoption;
            if (view == null)
            {
                view1 = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(R.layout.bc_form_select_option, null);
                viewgroup = new ViewHolder();
                viewgroup.optionText = (TextView)view1.findViewById(R.id.bc_form_select_option);
                viewgroup.optionAvailText = (TextView)view1.findViewById(R.id.bc_form_select_option_label);
                view1.setTag(viewgroup);
            } else
            {
                viewgroup = (ViewHolder)view.getTag();
                view1 = view;
            }
            formfieldoption = getItem(i);
            if (((ViewHolder) (viewgroup)).optionText != null)
            {
                view = "";
                if (formfieldoption == null)
                {
                    if (i == 0)
                    {
                        String s = mFormField.getLabel();
                        view = s;
                        if (mFormField.isRequired())
                        {
                            view = String.format("#%06X", new Object[] {
                                Integer.valueOf(mContext.getResources().getColor(R.color.bc_required_label) & 0xffffff)
                            });
                            view = (new StringBuilder()).append(s).append(String.format(" <font color=\"%s\">%s</font>", new Object[] {
                                view, BoldChatSession.getBranding("api#chat#required_label", mChat.getBrandings(), mContext)
                            })).toString();
                        }
                    }
                } else
                {
                    view = formfieldoption.getName();
                }
                ((ViewHolder) (viewgroup)).optionText.setText(fromHtml(view), android.widget.TextView.BufferType.SPANNABLE);
                if (i == 0 && mIsErrorState && ((ViewHolder) (viewgroup)).optionText.getCurrentTextColor() != getResources().getColor(R.color.bc_required))
                {
                    ((ViewHolder) (viewgroup)).optionText.setTextColor(mErrorTextColor);
                } else
                if (i == 0)
                {
                    ((ViewHolder) (viewgroup)).optionText.setTextColor(mHintTextColor);
                } else
                {
                    ((ViewHolder) (viewgroup)).optionText.setTextColor(mNormalTextColor);
                }
            }
            if (formfieldoption == null || ((ViewHolder) (viewgroup)).optionAvailText == null || formfieldoption.getAvailableLabel() == null || !mFormField.isDepartmentStatusVisible()) goto _L2; else goto _L1
_L1:
            ((ViewHolder) (viewgroup)).optionAvailText.setVisibility(0);
            ((ViewHolder) (viewgroup)).optionAvailText.setText(fromHtml(formfieldoption.getAvailableLabel()), android.widget.TextView.BufferType.SPANNABLE);
            if (!formfieldoption.isAvailable()) goto _L4; else goto _L3
_L3:
            ((ViewHolder) (viewgroup)).optionAvailText.setTextColor(mContext.getResources().getColor(R.color.bc_online));
_L6:
            return view1;
_L4:
            ((ViewHolder) (viewgroup)).optionAvailText.setTextColor(mContext.getResources().getColor(R.color.bc_offline));
            return view1;
_L2:
            if (((ViewHolder) (viewgroup)).optionAvailText != null)
            {
                ((ViewHolder) (viewgroup)).optionAvailText.setVisibility(8);
                return view1;
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

        public void setErrorState(boolean flag)
        {
            mIsErrorState = flag;
        }

        public SelectAdapter(FormField formfield)
        {
            this$0 = BoldChatFormView.this;
            super();
            mIsErrorState = false;
            mHtmlLabelCache = new HashMap();
            mFormField = formfield;
            mNormalTextColor = getResources().getColor(R.color.bc_select_normal);
            mHintTextColor = getResources().getColor(R.color.bc_placeholder);
            mErrorTextColor = getResources().getColor(R.color.bc_required);
        }
    }

    private class SelectAdapter.ViewHolder
    {

        TextView optionAvailText;
        TextView optionText;
        final SelectAdapter this$1;

        private SelectAdapter.ViewHolder()
        {
            this$1 = SelectAdapter.this;
            super();
        }

    }

    private class SubmitButtonListener
        implements android.view.View.OnClickListener
    {

        final BoldChatFormView this$0;

        public void onClick(View view)
        {
            boolean flag1 = true;
            boolean flag = true;
            int i = ((flag1) ? 1 : 0);
            if (mForm != null)
            {
                i = ((flag1) ? 1 : 0);
                if (mForm.getFormFields() != null)
                {
                    view = mForm.getFormFields().iterator();
                    do
                    {
                        i = ((flag) ? 1 : 0);
                        if (!view.hasNext())
                        {
                            break;
                        }
                        FormField formfield = (FormField)view.next();
                        Object obj = (View)mFormValues.get(formfield);
                        if (obj != null)
                        {
                            if (obj instanceof EditText)
                            {
                                formfield.setValue(((EditText)obj).getText().toString().trim());
                                if (formfield.getType() == FormFieldType.Email && !TextUtils.isEmpty(formfield.getValue()))
                                {
                                    i = formfield.getValue().indexOf('@');
                                    if (i <= 0 || i >= formfield.getValue().length() - 1 || !RegularExpressions.EMAIL_ADDRESS.matcher(formfield.getValue()).matches())
                                    {
                                        ((EditText)obj).setError(BoldChatSession.getBranding("api#email#error", mChat.getBrandings(), ((View) (obj)).getContext()));
                                        if (flag)
                                        {
                                            ((View) (obj)).requestFocus();
                                            smoothScrollToCenter(((View) (obj)));
                                        }
                                        flag = false;
                                    }
                                } else
                                if (formfield.isRequired() && TextUtils.isEmpty(formfield.getValue()))
                                {
                                    ((EditText)obj).setError(BoldChatSession.getBranding("api#chat#required_error", mChat.getBrandings(), ((View) (obj)).getContext()));
                                    if (flag)
                                    {
                                        ((View) (obj)).requestFocus();
                                        smoothScrollToCenter(((View) (obj)));
                                    }
                                    flag = false;
                                } else
                                {
                                    ((EditText)obj).setError(null);
                                }
                            } else
                            if (obj instanceof Spinner)
                            {
                                obj = (Spinner)obj;
                                FormFieldOption formfieldoption = (FormFieldOption)((Spinner) (obj)).getSelectedItem();
                                SelectAdapter selectadapter = (SelectAdapter)((Spinner) (obj)).getAdapter();
                                if (formfieldoption != null)
                                {
                                    formfield.setValue(formfieldoption.getValue());
                                    if (formfield.isRequired())
                                    {
                                        selectadapter.setErrorState(false);
                                    }
                                } else
                                if (formfield.isRequired())
                                {
                                    selectadapter.setErrorState(true);
                                    selectadapter.notifyDataSetChanged();
                                    if (flag)
                                    {
                                        ((Spinner) (obj)).requestFocus();
                                        smoothScrollToCenter(((View) (obj)));
                                        flag = false;
                                    }
                                }
                            } else
                            if (obj instanceof RatingBar)
                            {
                                obj = (RatingBar)obj;
                                i = Math.round(((RatingBar) (obj)).getRating());
                                if (i > 0)
                                {
                                    formfield.setValue(Integer.toString(i));
                                } else
                                if (formfield.isRequired())
                                {
                                    TextView textview = (TextView)mRatingBarLabels.get(obj);
                                    if (textview != null)
                                    {
                                        textview.setTextColor(getResources().getColor(R.color.bc_required));
                                    }
                                    if (flag)
                                    {
                                        smoothScrollToCenter(((View) (obj)));
                                        flag = false;
                                    }
                                }
                            }
                        }
                    } while (true);
                }
            }
            if (i != 0)
            {
                ((InputMethodManager)mContext.getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
                mSubmitListener.onFormSubmit(mForm);
            }
        }

        private SubmitButtonListener()
        {
            this$0 = BoldChatFormView.this;
            super();
        }

    }

    public static interface SubmitListener
    {

        public abstract void onFormSubmit(Form form);
    }


    private final Chat mChat;
    private final Context mContext;
    private Form mForm;
    private HashMap mFormKeyLabels;
    private HashMap mFormValues;
    private ViewGroup mMainLayout;
    private HashMap mRatingBarLabels;
    private ArrayList mSelectAdapters;
    private Button mSubmitButton;
    private final String mSubmitButtonLabelKey;
    private SubmitListener mSubmitListener;
    private final String mTitleKey;
    private TextView mTitleLabel;

    public BoldChatFormView(String s, String s1, String s2, String s3, Form form, SubmitListener submitlistener, Context context, 
            Chat chat)
    {
        super(context);
        mFormKeyLabels = new HashMap();
        mFormValues = new HashMap();
        mRatingBarLabels = new HashMap();
        mSelectAdapters = new ArrayList();
        mSubmitListener = submitlistener;
        mForm = form;
        mContext = context;
        mChat = chat;
        mTitleKey = s1;
        mSubmitButtonLabelKey = s3;
        setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        setFillViewport(true);
        s1 = LayoutInflater.from(context);
        mMainLayout = (ViewGroup)s1.inflate(R.layout.bc_form, mMainLayout);
        mTitleLabel = (TextView)mMainLayout.findViewById(R.id.bc_form_title);
        int i;
        if (s != null)
        {
            mTitleLabel.setText(Html.fromHtml(s), android.widget.TextView.BufferType.SPANNABLE);
        } else
        {
            mTitleLabel.setVisibility(8);
        }
        s = (ViewGroup)mMainLayout.findViewById(R.id.bc_form_fields);
        i = 0;
        if (form != null && form.getFormFields() != null)
        {
            for (s3 = form.getFormFields().iterator(); s3.hasNext();)
            {
                form = (FormField)s3.next();
                submitlistener = getFormFieldLayout(s1, form);
                if (form.isFloatToTop())
                {
                    s.addView(submitlistener, i);
                    i++;
                } else
                {
                    s.addView(submitlistener);
                }
            }

        }
        mSubmitButton = (Button)mMainLayout.findViewById(R.id.bc_form_submit);
        mSubmitButton.setText(Html.fromHtml(s2), android.widget.TextView.BufferType.SPANNABLE);
        mSubmitButton.setOnClickListener(new SubmitButtonListener());
        addView(mMainLayout);
    }

    private CharSequence addRequiredLabel(FormField formfield, CharSequence charsequence, Context context)
    {
        Object obj = charsequence;
        if (formfield.isRequired())
        {
            formfield = String.format("#%06X", new Object[] {
                Integer.valueOf(mContext.getResources().getColor(R.color.bc_required_label) & 0xffffff)
            });
            obj = Html.fromHtml((new StringBuilder()).append(charsequence).append(String.format(" <font color=\"%s\">%s</font>", new Object[] {
                formfield, BoldChatSession.getBranding("api#chat#required_label", mChat.getBrandings(), context)
            })).toString());
        }
        return ((CharSequence) (obj));
    }

    private View getFormFieldLayout(LayoutInflater layoutinflater, FormField formfield)
    {
        int i = -1;
        static class _cls1
        {

            static final int $SwitchMap$com$boldchat$visitor$api$FormFieldType[];

            static 
            {
                $SwitchMap$com$boldchat$visitor$api$FormFieldType = new int[FormFieldType.values().length];
                try
                {
                    $SwitchMap$com$boldchat$visitor$api$FormFieldType[FormFieldType.Text.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$boldchat$visitor$api$FormFieldType[FormFieldType.Email.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$boldchat$visitor$api$FormFieldType[FormFieldType.Phone.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$boldchat$visitor$api$FormFieldType[FormFieldType.Select.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$boldchat$visitor$api$FormFieldType[FormFieldType.Radio.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$boldchat$visitor$api$FormFieldType[FormFieldType.Rating.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.boldchat.visitor.api.FormFieldType[formfield.getType().ordinal()];
        JVM INSTR tableswitch 1 6: default 52
    //                   1 480
    //                   2 503
    //                   3 511
    //                   4 519
    //                   5 519
    //                   6 527;
           goto _L1 _L2 _L3 _L4 _L5 _L5 _L6
_L1:
        View view;
        TextView textview;
        RatingBar ratingbar;
        Spinner spinner;
        FloatLabelLayout floatlabellayout;
        view = layoutinflater.inflate(i, null);
        textview = (TextView)view.findViewById(R.id.bc_form_label);
        layoutinflater = (EditText)view.findViewById(R.id.bc_form_text);
        spinner = (Spinner)view.findViewById(R.id.bc_form_select);
        ratingbar = (RatingBar)view.findViewById(R.id.bc_form_rating);
        floatlabellayout = (FloatLabelLayout)view.findViewById(R.id.bc_floating_label);
        if (textview != null)
        {
            setLabel(textview, formfield);
        }
        if (floatlabellayout != null)
        {
            setLabel(floatlabellayout, formfield);
        }
        if (layoutinflater != null)
        {
            layoutinflater.setHint(formfield.getLabel());
        }
        if (formfield.getAdditionalHeading() != null)
        {
            TextView textview1 = (TextView)view.findViewById(R.id.bc_form_additional_heading);
            if (textview1 != null)
            {
                textview1.setVisibility(0);
                textview1.setText(formfield.getAdditionalHeading());
            }
        }
        if (layoutinflater != null)
        {
            setLabel(layoutinflater, formfield);
            if (formfield.getValue() != null)
            {
                layoutinflater.setText(formfield.getValue());
            }
            mFormValues.put(formfield, layoutinflater);
        }
        if (spinner == null) goto _L8; else goto _L7
_L7:
        layoutinflater = new SelectAdapter(formfield);
        spinner.setAdapter(layoutinflater);
        mSelectAdapters.add(layoutinflater);
        layoutinflater = null;
        if (formfield.getDefaultOption() != null)
        {
            layoutinflater = formfield.getDefaultOption().getValue();
        }
        if (formfield.getValue() != null)
        {
            layoutinflater = formfield.getValue();
        }
        if (layoutinflater == null) goto _L10; else goto _L9
_L9:
        i = 0;
_L11:
        if (i < formfield.getOptions().size())
        {
            if (!layoutinflater.equals(((FormFieldOption)formfield.getOptions().get(i)).getValue()))
            {
                break MISSING_BLOCK_LABEL_535;
            }
            spinner.setSelection(i + 1);
        }
_L10:
        if ("language".equals(formfield.getKey()))
        {
            layoutinflater = null;
            if (formfield.getDefaultOption() != null)
            {
                layoutinflater = formfield.getDefaultOption().getValue();
            }
            spinner.setOnItemSelectedListener(new LanguageChanger(layoutinflater, floatlabellayout));
        }
        mFormValues.put(formfield, spinner);
_L8:
        if (ratingbar == null)
        {
            break MISSING_BLOCK_LABEL_465;
        }
        mFormValues.put(formfield, ratingbar);
        if (formfield.getValue() == null)
        {
            break MISSING_BLOCK_LABEL_448;
        }
        i = Integer.valueOf(formfield.getValue()).intValue();
        if (i <= 5)
        {
            try
            {
                ratingbar.setRating(i);
            }
            // Misplaced declaration of an exception variable
            catch (LayoutInflater layoutinflater)
            {
                ratingbar.setRating(0.0F);
            }
        }
        if (textview != null)
        {
            mRatingBarLabels.put(ratingbar, textview);
        }
        if (!formfield.isVisible())
        {
            view.setVisibility(8);
        }
        return view;
_L2:
        if (formfield.isMultiLine())
        {
            i = R.layout.bc_form_text_multiline;
        } else
        {
            i = R.layout.bc_form_text;
        }
          goto _L1
_L3:
        i = R.layout.bc_form_email;
          goto _L1
_L4:
        i = R.layout.bc_form_phone;
          goto _L1
_L5:
        i = R.layout.bc_form_select;
          goto _L1
_L6:
        i = R.layout.bc_form_rating;
          goto _L1
        i++;
          goto _L11
    }

    private CharSequence getLabel(String s)
    {
        if (mChat != null && mChat.getBrandings() != null && s != null && mChat.getBrandings().get(s) != null)
        {
            return Html.fromHtml((String)mChat.getBrandings().get(s));
        } else
        {
            return null;
        }
    }

    private int getScrollTop(View view)
    {
        if (view == this || !(view.getParent() instanceof View))
        {
            return 0;
        } else
        {
            int i = view.getTop();
            return getScrollTop((View)view.getParent()) + i;
        }
    }

    private void setLabel(View view, FormField formfield)
    {
        CharSequence charsequence = getLabel(formfield.getLabelBrandingKey());
        if (charsequence == null)
        {
            charsequence = addRequiredLabel(formfield, formfield.getLabel(), view.getContext());
        } else
        {
            charsequence = addRequiredLabel(formfield, charsequence, view.getContext());
        }
        if (formfield.getLabelBrandingKey() != null)
        {
            ArrayList arraylist1 = (ArrayList)mFormKeyLabels.get(formfield);
            ArrayList arraylist = arraylist1;
            if (arraylist1 == null)
            {
                arraylist = new ArrayList();
                mFormKeyLabels.put(formfield, arraylist);
            }
            if (!arraylist.contains(view))
            {
                arraylist.add(view);
            }
        }
        if (view instanceof EditText)
        {
            ((EditText)view).setHint(charsequence);
        } else
        {
            if (view instanceof TextView)
            {
                ((TextView)view).setText(charsequence, android.widget.TextView.BufferType.SPANNABLE);
                return;
            }
            if (view instanceof FloatLabelLayout)
            {
                ((FloatLabelLayout)view).getLabel().setText(charsequence);
                return;
            }
        }
    }

    public void smoothScrollToCenter(View view)
    {
        int i = getScrollTop(view);
        int j = ((view.getHeight() >> 1) + i) - (getHeight() >> 1);
        i = j;
        if (j < 0)
        {
            i = 0;
        }
        smoothScrollTo(0, i);
    }














}
