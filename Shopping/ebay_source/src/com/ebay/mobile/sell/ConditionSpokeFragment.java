// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ebay.android.widget.ContainerLayout;
import com.ebay.app.AlertDialogFragment;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.sell.util.DescriptionConverter;
import com.ebay.nautilus.domain.content.ListingDraftContent;
import com.ebay.nautilus.domain.content.dm.ListingDraftDataManager;
import com.ebay.nautilus.domain.data.LdsField;
import com.ebay.nautilus.domain.data.LdsOption;
import com.ebay.nautilus.domain.data.ListingDraft;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.sell:
//            BaseSpokeFragment, ListingFragmentActivity

public class ConditionSpokeFragment extends BaseSpokeFragment
    implements android.view.View.OnClickListener, com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.Observer
{
    private class ConditionDescriptionWatcher
        implements TextWatcher
    {

        final ConditionSpokeFragment this$0;

        public void afterTextChanged(Editable editable)
        {
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            draftDescriptionViewHeight = -1;
            letterCount = charsequence.length();
            String s = getResources().getString(0x7f0709ab);
            i = 0;
            while (i < conditionList.getChildCount()) 
            {
                TextView textview = (TextView)conditionList.getChildAt(i).findViewById(0x7f100709);
                if (charsequence.length() > 0)
                {
                    textview.setVisibility(0);
                    textview.setText((new StringBuilder()).append(letterCount).append(s).toString());
                } else
                {
                    textview.setVisibility(4);
                }
                i++;
            }
        }

        private ConditionDescriptionWatcher()
        {
            this$0 = ConditionSpokeFragment.this;
            super();
        }

    }

    public class ShowHideAnimation extends Animation
    {

        final long animationDuration;
        int finishHeight;
        int heightDif;
        int startHeight;
        final ConditionSpokeFragment this$0;
        View view;

        protected void applyTransformation(float f, Transformation transformation)
        {
            int i = (int)((float)heightDif * f) + startHeight;
            if (f >= 1.0F)
            {
                i = finishHeight;
            }
            view.getLayoutParams().height = i;
            view.requestLayout();
        }

        public boolean willChangeBounds()
        {
            return true;
        }

        public ShowHideAnimation(View view1, int i, int j)
        {
            this$0 = ConditionSpokeFragment.this;
            super();
            animationDuration = 500L;
            view = view1;
            startHeight = i;
            finishHeight = j;
            heightDif = j - i;
            setDuration(500L);
        }

        public ShowHideAnimation(View view1, int i, int j, int k)
        {
            this$0 = ConditionSpokeFragment.this;
            super();
            animationDuration = 500L;
            view = view1;
            startHeight = i;
            finishHeight = k;
            heightDif = j - i;
            setDuration(500L);
        }
    }


    private static int CONDITION_NEW_INTVALUE = 1000;
    private SparseArray conditionDefinitions;
    private EditText conditionDescription;
    protected int conditionDescriptionHeight;
    protected ContainerLayout conditionList;
    private ListingDraftDataManager dm;
    private int draftDescriptionPosition;
    protected int draftDescriptionViewHeight;
    private LayoutInflater inflater;
    private boolean isGuaranteeSelectedThisSession;
    private int lastPosition;
    private ListingDraft latestDraft;
    private int letterCount;
    private View parent;
    private View progress;

    public ConditionSpokeFragment()
    {
        lastPosition = -1;
        draftDescriptionViewHeight = -1;
        draftDescriptionPosition = -1;
        letterCount = 0;
    }

    private void conditionUpdateOptions(ListingDraft listingdraft)
    {
        LdsField ldsfield = listingdraft.condition;
        boolean flag = ldsfield.isEnabled();
        boolean flag1 = isConditionDescEnabled(listingdraft);
        conditionList.removeAllViews();
        listingdraft = getActivity().obtainStyledAttributes(0x101004d, new int[] {
            0x101004d
        });
        int j = listingdraft.getDimensionPixelSize(0, -1);
        listingdraft.recycle();
        listingdraft = null;
        if (flag1)
        {
            listingdraft = new ConditionDescriptionWatcher();
        }
        int i = 0;
        while (i < ldsfield.options.size()) 
        {
            LdsOption ldsoption = (LdsOption)ldsfield.options.get(i);
            if (ldsoption.getIntValue() != -1)
            {
                LinearLayout linearlayout = (LinearLayout)inflater.inflate(0x7f03021f, null);
                CheckedTextView checkedtextview = (CheckedTextView)linearlayout.findViewById(0x1020014);
                checkedtextview.setText(ldsoption.caption);
                checkedtextview.setTag(Integer.valueOf(i));
                checkedtextview.setClickable(true);
                checkedtextview.setOnClickListener(this);
                checkedtextview.setEnabled(flag);
                int k = (int)TypedValue.applyDimension(1, 6F, getResources().getDisplayMetrics());
                android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-1, -2);
                layoutparams.setMargins(k, 0, k, 0);
                linearlayout.setLayoutParams(layoutparams);
                checkedtextview.setMinHeight(j);
                linearlayout.findViewById(0x7f100708).setSaveEnabled(false);
                if (ldsoption.getIntValue() == ldsfield.getIntValue())
                {
                    checkedtextview.setChecked(true);
                    lastPosition = i;
                    if (flag1)
                    {
                        conditionDescription = (EditText)linearlayout.findViewById(0x7f100708);
                        String s = DescriptionConverter.toPlainText(latestDraft.conditionDescription.getStringValue());
                        conditionDescription.requestFocus();
                        TextView textview1 = (TextView)linearlayout.findViewById(0x7f100709);
                        if (!TextUtils.isEmpty(s))
                        {
                            letterCount = s.length();
                            String s1 = getResources().getString(0x7f0709ab);
                            textview1.setText((new StringBuilder()).append(letterCount).append(s1).toString());
                            textview1.setVisibility(0);
                            conditionDescription.setText(s);
                            conditionDescription.setSelection(s.length());
                        }
                        textview1.measure(0, 0);
                        conditionDescription.measure(0, 0);
                        draftDescriptionViewHeight = conditionDescription.getMeasuredHeight() + textview1.getMeasuredHeight();
                        draftDescriptionPosition = i;
                        if (ldsoption.getIntValue() == CONDITION_NEW_INTVALUE)
                        {
                            checkedtextview.measure(0, 0);
                            linearlayout.getLayoutParams().height = checkedtextview.getMeasuredHeight();
                        }
                    } else
                    {
                        linearlayout.findViewById(0x7f100708).setVisibility(8);
                        linearlayout.findViewById(0x7f100709).setVisibility(8);
                    }
                } else
                {
                    if (flag1)
                    {
                        if (conditionDescriptionHeight == 0)
                        {
                            EditText edittext = (EditText)linearlayout.findViewById(0x7f100708);
                            edittext.measure(0, 0);
                            TextView textview = (TextView)linearlayout.findViewById(0x7f100709);
                            textview.measure(0, 0);
                            conditionDescriptionHeight = edittext.getMeasuredHeight() + textview.getMeasuredHeight();
                        }
                    } else
                    {
                        linearlayout.findViewById(0x7f100708).setVisibility(8);
                        linearlayout.findViewById(0x7f100709).setVisibility(8);
                    }
                    checkedtextview.measure(0, 0);
                    linearlayout.getLayoutParams().height = checkedtextview.getMeasuredHeight();
                }
                ((EditText)linearlayout.findViewById(0x7f100708)).addTextChangedListener(listingdraft);
                conditionList.addView(linearlayout);
            }
            i++;
        }
    }

    private String getDefinition(int i)
    {
        SparseArray sparsearray = conditionDefinitions;
        if (sparsearray == null)
        {
            return null;
        } else
        {
            return (String)sparsearray.get(i);
        }
    }

    private boolean havePendingChanges()
    {
        if (lastPosition != -1 && conditionDescription != null)
        {
            LdsOption ldsoption = (LdsOption)latestDraft.condition.options.get(lastPosition);
            String s2 = conditionDescription.getText().toString();
            String s1 = latestDraft.conditionDescription.getStringValue();
            String s = s1;
            if (s1 == null)
            {
                s = "";
            }
            if (ldsoption.getIntValue() != CONDITION_NEW_INTVALUE && !s2.equals(s))
            {
                return true;
            }
        }
        return false;
    }

    private void initializeConditionDefinitionDisplay()
    {
        int i = -1;
        if (lastPosition != -1 || latestDraft == null || latestDraft.condition == null || !latestDraft.condition.hasSelection()) goto _L2; else goto _L1
_L1:
        i = latestDraft.condition.getIntValue();
_L4:
        if (i != -1)
        {
            setDefinitionText(i);
        }
        return;
_L2:
        if (lastPosition != -1)
        {
            i = ((LdsOption)latestDraft.condition.options.get(lastPosition)).getIntValue();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private boolean isConditionDescEnabled(ListingDraft listingdraft)
    {
        boolean flag = true;
        if (listingdraft != null || latestDraft != null) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        if (listingdraft != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (DeviceConfiguration.getAsync().get(DcsBoolean.SellConditionDescEnabled) && latestDraft.conditionDescription.isEnabled()) goto _L4; else goto _L3
_L3:
        return false;
        if (DeviceConfiguration.getAsync().get(DcsBoolean.SellConditionDescEnabled) && listingdraft.conditionDescription.isEnabled()) goto _L4; else goto _L5
_L5:
        return false;
    }

    private void setDefinitionText(int i)
    {
        String s = getDefinition(i);
        if (s != null)
        {
            TextView textview = (TextView)getView().findViewById(0x7f10062c);
            TextView textview1 = (TextView)getView().findViewById(0x7f10062d);
            textview.setText(LdsField.getCaptionInt(latestDraft.condition, i));
            textview1.setText(s);
        }
    }

    protected int getLayoutResource()
    {
        return 0x7f0301fa;
    }

    public int getTitleRes()
    {
        return 0x7f0709d4;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        inflater = (LayoutInflater)getActivity().getSystemService("layout_inflater");
    }

    public void onClick(View view)
    {
        int i = ((Integer)view.getTag()).intValue();
        Object obj2 = getView();
        if (i == lastPosition || obj2 == null || isDetached() || isRemoving())
        {
            return;
        }
        boolean flag = isConditionDescEnabled(null);
        ((CheckedTextView)view).setChecked(true);
        LdsOption ldsoption = (LdsOption)latestDraft.condition.options.get(i);
        Object obj1 = null;
        Object obj = obj1;
        if (lastPosition != -1)
        {
            obj2 = (CheckedTextView)((View) (obj2)).findViewWithTag(Integer.valueOf(lastPosition));
            ((CheckedTextView) (obj2)).setChecked(false);
            obj = obj1;
            if (flag)
            {
                String s = conditionDescription.getText().toString();
                obj = s;
                if (((LdsOption)latestDraft.condition.options.get(lastPosition)).getIntValue() != CONDITION_NEW_INTVALUE)
                {
                    obj = (LinearLayout)((CheckedTextView) (obj2)).getParent();
                    if (draftDescriptionViewHeight == -1)
                    {
                        conditionDescriptionHeight = conditionDescription.getHeight() + ((LinearLayout) (obj)).findViewById(0x7f100709).getHeight();
                    }
                    showOrHideView(((View) (obj)), ((LinearLayout) (obj)).getHeight(), ((CheckedTextView) (obj2)).getHeight(), null);
                    obj = s;
                }
            }
        }
        lastPosition = i;
        if (flag)
        {
            view = (LinearLayout)view.getParent();
            conditionDescription = (EditText)view.findViewById(0x7f100708);
            if (ldsoption.getIntValue() != CONDITION_NEW_INTVALUE)
            {
                conditionDescription.requestFocus();
                if (draftDescriptionViewHeight != -1 && draftDescriptionPosition == i)
                {
                    showOrHideView(view, view.getHeight(), view.getHeight() + draftDescriptionViewHeight, Integer.valueOf(-2));
                } else
                {
                    showOrHideView(view, view.getHeight(), view.getHeight() + conditionDescriptionHeight, Integer.valueOf(-2));
                }
            } else
            {
                ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(conditionDescription.getWindowToken(), 0);
            }
            if (!TextUtils.isEmpty(((CharSequence) (obj))) && draftDescriptionViewHeight == -1)
            {
                ((InputMethodManager)getActivity().getSystemService("input_method")).showSoftInput(conditionDescription, 0);
                conditionDescription.setText(((CharSequence) (obj)));
                conditionDescription.setSelection(0, ((String) (obj)).length());
            } else
            {
                if (draftDescriptionViewHeight == -1)
                {
                    conditionDescription.setText("");
                }
                ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(conditionDescription.getWindowToken(), 0);
            }
        }
        dm.updateCondition(ldsoption.value);
        setDefinitionText(ldsoption.getIntValue());
    }

    public void onContentChanged(ListingDraftDataManager listingdraftdatamanager, ListingDraftContent listingdraftcontent, com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.DispatchType dispatchtype)
    {
        if (listingdraftcontent.getStatus().hasError())
        {
            return;
        }
        if (latestDraft == null)
        {
            latestDraft = (ListingDraft)listingdraftcontent.getData();
            conditionDefinitions = listingdraftcontent.conditionDefinitions;
            conditionUpdateOptions(latestDraft);
            initializeConditionDefinitionDisplay();
            parent.setVisibility(0);
            progress.setVisibility(8);
        }
        if (!listingdraftcontent.isGuaranteeSelectedThisSession && isGuaranteeSelectedThisSession)
        {
            (new com.ebay.app.AlertDialogFragment.Builder()).setMessage(0x7f070141).setPositiveButton(0x7f070738).createFromActivity(0).show(getFragmentManager(), "recommendation_changed_warning");
            listingdraftdatamanager = getActivity();
            if (listingdraftdatamanager != null)
            {
                (new TrackingData("spgClear", TrackingType.EVENT)).send(listingdraftdatamanager);
            }
        }
        isGuaranteeSelectedThisSession = listingdraftcontent.isGuaranteeSelectedThisSession;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        initDataManagers();
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        datamanagercontainer = (com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.KeyParams)getArguments().getParcelable("key_params");
        dm = (ListingDraftDataManager)getDataManagerContainer().initialize(datamanagercontainer, this);
    }

    public void onResume()
    {
        super.onResume();
        ((ListingFragmentActivity)getActivity()).sendTrackingForSpokeEvent("RefineItemCondition");
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        progress = view.findViewById(0x7f100143);
        parent = view.findViewById(0x7f1004bc);
        conditionList = (ContainerLayout)view.findViewById(0x7f10062b);
    }

    protected void saveOutstandingChanges(boolean flag)
    {
        if (isConditionDescEnabled(null) && havePendingChanges())
        {
            String s = DescriptionConverter.toHtml(conditionDescription.getText().toString());
            dm.updateConditionDescription(s, flag);
        } else
        if (flag)
        {
            dm.validateDraft();
            return;
        }
    }

    protected final void showOrHideView(View view, int i, int j, Integer integer)
    {
        if (integer == null)
        {
            view.startAnimation(new ShowHideAnimation(view, i, j));
            return;
        } else
        {
            view.startAnimation(new ShowHideAnimation(view, i, j, integer.intValue()));
            return;
        }
    }




/*
    static int access$102(ConditionSpokeFragment conditionspokefragment, int i)
    {
        conditionspokefragment.letterCount = i;
        return i;
    }

*/
}
