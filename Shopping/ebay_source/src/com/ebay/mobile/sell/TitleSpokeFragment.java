// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.DialogFragment;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.MetricAffectingSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.app.AlertDialogFragment;
import com.ebay.app.DialogFragmentCallback;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.nautilus.domain.content.ListingDraftContent;
import com.ebay.nautilus.domain.content.dm.ListingDraftDataManager;
import com.ebay.nautilus.domain.data.LdsField;
import com.ebay.nautilus.domain.data.ListingDraft;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;

// Referenced classes of package com.ebay.mobile.sell:
//            BaseSpokeFragment, ListingFragmentActivity

public class TitleSpokeFragment extends BaseSpokeFragment
    implements android.view.View.OnClickListener, DialogFragmentCallback, com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.Observer
{

    public static final int LISTING_SUBTITLE_MAX_LENGTH = 55;
    public static final int LISTING_TITLE_MAX_LENGTH = 80;
    protected TextView characterCounter;
    private ListingDraftDataManager dm;
    private boolean isGuaranteeSelectedThisSession;
    private ListingDraft latestDraft;
    private View loading;
    private View parent;
    private View showMore;
    private boolean showingAdvancedOptions;
    protected EditText subtitle;
    private View subtitleRow;
    protected EditText title;
    private View titleRow;

    public TitleSpokeFragment()
    {
        showingAdvancedOptions = false;
    }

    protected int getLayoutResource()
    {
        return 0x7f030225;
    }

    public int getTitleRes()
    {
        return 0x7f0709da;
    }

    public boolean havePendingChanges()
    {
        String s1 = LdsField.getStringValueSafe(latestDraft.title);
        String s2 = LdsField.getStringValueSafe(latestDraft.subtitle);
        String s = s1;
        if (s1 == null)
        {
            s = "";
        }
        s1 = s2;
        if (s2 == null)
        {
            s1 = "";
        }
        return !TextUtils.equals(s, title.getText().toString()) || !TextUtils.equals(s1, subtitle.getText().toString());
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131756805 2131756805: default 24
    //                   2131756805 25;
           goto _L1 _L2
_L1:
        return;
_L2:
        int i;
        boolean flag;
        if (!showingAdvancedOptions)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        showingAdvancedOptions = flag;
        view = (ImageView)getView().findViewById(0x7f100707);
        if (showingAdvancedOptions)
        {
            i = 0x7f020256;
        } else
        {
            i = 0x7f020252;
        }
        view.setImageResource(i);
        view = (TextView)getView().findViewById(0x7f100706);
        if (showingAdvancedOptions)
        {
            i = 0x7f0705c1;
        } else
        {
            i = 0x7f0705c2;
        }
        view.setText(i);
        showOrHideView(subtitleRow, showingAdvancedOptions, -2, titleRow.getHeight(), true);
        if (!subtitle.hasFocus())
        {
            continue; /* Loop/switch isn't completed */
        }
        view = characterCounter;
        if (showingAdvancedOptions)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        if (!showingAdvancedOptions) goto _L1; else goto _L3
_L3:
        i = 55 - subtitle.getText().toString().length();
        characterCounter.setText(getView().getContext().getResources().getQuantityString(0x7f080011, i, new Object[] {
            Integer.valueOf(i)
        }));
        return;
        if (title.hasFocus()) goto _L1; else goto _L4
_L4:
        characterCounter.setVisibility(8);
        return;
    }

    public void onContentChanged(ListingDraftDataManager listingdraftdatamanager, ListingDraftContent listingdraftcontent, com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.DispatchType dispatchtype)
    {
        if (listingdraftcontent.getStatus().hasError())
        {
            return;
        }
        boolean flag;
        if (latestDraft != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        latestDraft = (ListingDraft)listingdraftcontent.getData();
        if (!flag)
        {
            updateState();
            loading.setVisibility(8);
            parent.setVisibility(0);
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

    public void onDialogFragmentResult(DialogFragment dialogfragment, int i, int j)
    {
        dialogfragment.dismiss();
        if (j == 1)
        {
            clearBackStack();
        }
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
        ((ListingFragmentActivity)getActivity()).sendTrackingForSpokeEvent("SellingItemTitleAndSubtitle");
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        parent = view.findViewById(0x7f1004bc);
        loading = view.findViewById(0x7f10071b);
        title = (EditText)view.findViewById(0x7f10071e);
        characterCounter = (TextView)view.findViewById(0x7f10071c);
        titleRow = view.findViewById(0x7f10071d);
        subtitleRow = view.findViewById(0x7f10071f);
        bundle = new InputFilter() {

            final TitleSpokeFragment this$0;

            public CharSequence filter(CharSequence charsequence, int i, int j, Spanned spanned, int k, int l)
            {
                if (charsequence instanceof Editable)
                {
                    spanned = (Editable)charsequence;
                    android.text.style.CharacterStyle acharacterstyle[] = (android.text.style.CharacterStyle[])spanned.getSpans(0, spanned.length(), android/text/style/MetricAffectingSpan);
                    for (k = 0; k < acharacterstyle.length; k++)
                    {
                        spanned.removeSpan(acharacterstyle[k]);
                    }

                }
                for (k = i; k < j; k++)
                {
                    if (charsequence.charAt(k) == '\n')
                    {
                        spanned = new char[j - i];
                        TextUtils.getChars(charsequence, i, j, spanned, 0);
                        return (new String(spanned)).replace("\n", "");
                    }
                }

                return null;
            }

            
            {
                this$0 = TitleSpokeFragment.this;
                super();
            }
        };
        title.setFilters(new InputFilter[] {
            new android.text.InputFilter.LengthFilter(80), bundle
        });
        title.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            final TitleSpokeFragment this$0;

            public void onFocusChange(View view1, boolean flag)
            {
                if (characterCounter.getVisibility() != 0)
                {
                    characterCounter.setVisibility(0);
                }
                if (flag)
                {
                    int i = 80 - title.getText().toString().length();
                    characterCounter.setText(getView().getContext().getResources().getQuantityString(0x7f080011, i, new Object[] {
                        Integer.valueOf(i)
                    }));
                }
            }

            
            {
                this$0 = TitleSpokeFragment.this;
                super();
            }
        });
        title.addTextChangedListener(new TextWatcher() {

            final TitleSpokeFragment this$0;

            public void afterTextChanged(Editable editable)
            {
                int i = 80 - editable.toString().length();
                characterCounter.setText(getView().getContext().getResources().getQuantityString(0x7f080011, i, new Object[] {
                    Integer.valueOf(i)
                }));
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            
            {
                this$0 = TitleSpokeFragment.this;
                super();
            }
        });
        subtitle = (EditText)view.findViewById(0x7f100720);
        subtitle.setFilters(new InputFilter[] {
            new android.text.InputFilter.LengthFilter(55), bundle
        });
        subtitle.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            final TitleSpokeFragment this$0;

            public void onFocusChange(View view1, boolean flag)
            {
                if (characterCounter.getVisibility() != 0)
                {
                    characterCounter.setVisibility(0);
                }
                if (flag)
                {
                    int i = 55 - subtitle.getText().toString().length();
                    characterCounter.setText(getView().getContext().getResources().getQuantityString(0x7f080011, i, new Object[] {
                        Integer.valueOf(i)
                    }));
                }
            }

            
            {
                this$0 = TitleSpokeFragment.this;
                super();
            }
        });
        subtitle.addTextChangedListener(new TextWatcher() {

            final TitleSpokeFragment this$0;

            public void afterTextChanged(Editable editable)
            {
                int i = 55 - editable.toString().length();
                characterCounter.setText(getView().getContext().getResources().getQuantityString(0x7f080011, i, new Object[] {
                    Integer.valueOf(i)
                }));
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            
            {
                this$0 = TitleSpokeFragment.this;
                super();
            }
        });
        loading.setVisibility(0);
        parent.setVisibility(8);
        showMore = view.findViewById(0x7f100705);
        showMore.setOnClickListener(this);
    }

    protected void saveOutstandingChanges(boolean flag)
    {
        if (havePendingChanges())
        {
            dm.updateTitles(title.getText().toString(), subtitle.getText().toString(), flag);
        } else
        if (flag)
        {
            dm.validateDraft();
            return;
        }
    }

    public void updateState()
    {
        title.setEnabled(latestDraft.title.isEnabled());
        title.setText(latestDraft.title.getStringValue());
        if (latestDraft.subtitle != null)
        {
            subtitle.setEnabled(latestDraft.subtitle.isEnabled());
            subtitle.setText(latestDraft.subtitle.getStringValue());
            return;
        } else
        {
            subtitle.setEnabled(false);
            subtitle.setText("");
            return;
        }
    }
}
