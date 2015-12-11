// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import com.ebay.android.widget.EbaySpinner;
import com.ebay.app.AlertDialogFragment;
import com.ebay.app.DialogFragmentCallback;
import com.ebay.mobile.sell.util.DescriptionConverter;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.nautilus.domain.content.ListingDraftContent;
import com.ebay.nautilus.domain.content.dm.ListingDraftDataManager;
import com.ebay.nautilus.domain.data.LdsField;
import com.ebay.nautilus.domain.data.ListingDraft;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.sell:
//            BaseSpokeFragment, ProductDetailsActivity, DescriptionPreviewDialogFragment, ListingFragmentActivity

public class DescriptionSpokeFragment extends BaseSpokeFragment
    implements android.view.View.OnClickListener, com.ebay.android.widget.EbaySpinner.OnUserSelectionChanged, DialogFragmentCallback, com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.Observer
{

    private static final int DIALOG_SWITCH_TO_STANDARD_EDITOR = 1;
    private static final int EDIT_MODE_APPEND_TO_DESCRIPTION = 1;
    private static final int EDIT_MODE_DESCRIPTION = 0;
    private static final int EDIT_MODE_DISABLED = 2;
    private static final String HTML_REGEX = ".*\\<[^>]+>.*";
    private static final int MODE_HTML = 1;
    private static final int MODE_PLAIN_TEXT = 0;
    private static final int RESULT_VOICE_RECOGNITION = 1234;
    private static final String STATE_EDIT_MODE = "editMode";
    private static final String STATE_ORIGINAL_ADD_TO_DESCRIPTION = "addToDescription";
    private static final String STATE_ORIGINAL_DESCRIPTION = "description";
    private static final String STATE_TEXT_MODE = "textMode";
    private static final String STATE_WORKING_TEXT = "workingText";
    private static final String TAG_BR = "<br>";
    private ListingDraftDataManager dm;
    private int editMode;
    private ArrayAdapter editModeAdapter;
    private boolean initialized;
    private ListingDraft latestDraft;
    private View micButton;
    private String originalAddToDescription;
    private String originalDescription;
    private View parent;
    private TextView previewLink;
    private String productDescription;
    private View progress;
    private EbaySpinner spinnerEditMode;
    private EbaySpinner spinnerEditModeAppend;
    private int textMode;
    private boolean wasFragmentRetained;
    private EditText workingText;

    public DescriptionSpokeFragment()
    {
        textMode = 1;
        editMode = 0;
        wasFragmentRetained = false;
        initialized = false;
    }

    private static boolean containsHtml(String s)
    {
        if (s == null)
        {
            return false;
        } else
        {
            return s.replace("\n", "").replace("<br>", "").matches(".*\\<[^>]+>.*");
        }
    }

    private boolean hasSpeechRecognition()
    {
        boolean flag = false;
        if (getActivity().getPackageManager().queryIntentActivities(new Intent("android.speech.action.RECOGNIZE_SPEECH"), 0).size() > 0)
        {
            flag = true;
        }
        return flag;
    }

    private boolean havePendingChanges()
    {
        if (editMode != 0) goto _L2; else goto _L1
_L1:
        if (originalDescription != null) goto _L4; else goto _L3
_L3:
        if (workingText.getText().toString().equals("")) goto _L6; else goto _L5
_L5:
        return true;
_L6:
        return false;
_L4:
        if (!workingText.getText().toString().equals(originalDescription)) goto _L5; else goto _L7
_L7:
        return false;
_L2:
        if (editMode != 1)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        if (originalAddToDescription != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!workingText.getText().toString().equals("")) goto _L5; else goto _L8
_L8:
        return false;
        if (!workingText.getText().toString().equals(originalAddToDescription)) goto _L5; else goto _L9
_L9:
        return false;
        return false;
    }

    private void initializeFromDraft(ListingDraft listingdraft)
    {
        if (initialized)
        {
            return;
        }
        initialized = true;
        latestDraft = listingdraft;
        View view = getView().findViewById(0x7f100634);
        View view1 = getView().findViewById(0x7f100635);
        TextView textview = (TextView)getView().findViewById(0x7f100636);
        textview.setOnClickListener(this);
        Object obj = listingdraft.productTitle;
        if (!TextUtils.isEmpty(productDescription))
        {
            obj = new SpannableStringBuilder();
            ((SpannableStringBuilder) (obj)).append(Html.fromHtml(productDescription));
            if (((SpannableStringBuilder) (obj)).length() > 500)
            {
                ((SpannableStringBuilder) (obj)).delete(500, ((SpannableStringBuilder) (obj)).length()).append(getString(0x7f0703a6));
            }
            textview.setText(((CharSequence) (obj)));
            view1.setVisibility(0);
            view.setVisibility(0);
            getView().findViewById(0x7f10063f).setVisibility(0);
            getView().findViewById(0x7f100640).setVisibility(0);
        } else
        if (obj != null && ((LdsField) (obj)).getStringValue() != null)
        {
            textview.setText(((LdsField) (obj)).getStringValue());
            view1.setVisibility(0);
            view.setVisibility(0);
            getView().findViewById(0x7f10063f).setVisibility(0);
            getView().findViewById(0x7f100640).setVisibility(0);
        } else
        {
            getView().findViewById(0x7f10063f).setVisibility(8);
            getView().findViewById(0x7f100640).setVisibility(8);
        }
        if (listingdraft.description != null)
        {
            originalDescription = listingdraft.description.getStringValue();
            if (listingdraft.description.isEnabled())
            {
                editMode = 0;
            } else
            {
                editMode = 2;
            }
        }
        if (listingdraft.appendToDescription != null)
        {
            originalAddToDescription = listingdraft.appendToDescription.getStringValue();
            if (listingdraft.appendToDescription.isEnabled())
            {
                editMode = 1;
            }
        }
        if (editMode == 0)
        {
            if (originalDescription == null || originalDescription.trim().length() == 0)
            {
                textMode = 0;
            } else
            if (!containsHtml(originalDescription))
            {
                originalDescription = DescriptionConverter.toPlainText(originalDescription);
                textMode = 0;
            } else
            {
                textMode = 1;
            }
        } else
        if (editMode == 1)
        {
            spinnerEditMode.setVisibility(8);
            getView().findViewById(0x7f10063a).setVisibility(0);
            getView().findViewById(0x7f100638).setVisibility(0);
            listingdraft = (TextView)getView().findViewById(0x7f100639);
            listingdraft.setOnClickListener(this);
            if (originalDescription != null)
            {
                SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
                spannablestringbuilder.append(Html.fromHtml(originalDescription));
                if (spannablestringbuilder.length() > 500)
                {
                    spannablestringbuilder.delete(500, spannablestringbuilder.length()).append(getString(0x7f0703a6));
                }
                listingdraft.setText(spannablestringbuilder);
            }
            if (originalAddToDescription == null || originalAddToDescription.trim().length() == 0)
            {
                textMode = 0;
            } else
            if (!containsHtml(originalAddToDescription))
            {
                originalAddToDescription = DescriptionConverter.toPlainText(originalAddToDescription);
                textMode = 0;
            } else
            {
                textMode = 1;
            }
        } else
        if (editMode == 2)
        {
            spinnerEditMode.setVisibility(8);
            spinnerEditModeAppend.setVisibility(8);
        }
        if (textMode == 0)
        {
            spinnerEditMode.setSelection(editModeAdapter.getPosition(getString(0x7f0703a3)));
            spinnerEditModeAppend.setSelection(editModeAdapter.getPosition(getString(0x7f0703a3)));
            previewLink.setVisibility(8);
        } else
        {
            spinnerEditMode.setSelection(editModeAdapter.getPosition(getString(0x7f0703a2)));
            spinnerEditModeAppend.setSelection(editModeAdapter.getPosition(getString(0x7f0703a2)));
            previewLink.setVisibility(0);
        }
        if (editMode == 0)
        {
            workingText.setText(originalDescription);
        } else
        if (editMode == 1)
        {
            workingText.setText(originalAddToDescription);
            workingText.setHint(0x7f070459);
        } else
        if (editMode == 2)
        {
            workingText.setEnabled(false);
        }
        if (editMode != 2 && textMode == 0 && hasSpeechRecognition())
        {
            micButton.setVisibility(0);
        } else
        {
            micButton.setVisibility(8);
        }
        progress.setVisibility(8);
        parent.setVisibility(0);
    }

    private void onRestoreInstanceState(Bundle bundle)
    {
        textMode = bundle.getInt("textMode");
        editMode = bundle.getInt("editMode");
        originalDescription = bundle.getString("description");
        originalAddToDescription = bundle.getString("addToDescription");
        bundle = bundle.getString("workingText");
        if (textMode == 0)
        {
            spinnerEditMode.setSelection(editModeAdapter.getPosition(getString(0x7f0703a3)));
            spinnerEditModeAppend.setSelection(editModeAdapter.getPosition(getString(0x7f0703a3)));
            previewLink.setVisibility(8);
        } else
        {
            spinnerEditMode.setSelection(editModeAdapter.getPosition(getString(0x7f0703a2)));
            spinnerEditModeAppend.setSelection(editModeAdapter.getPosition(getString(0x7f0703a2)));
            previewLink.setVisibility(0);
        }
        if (editMode == 0)
        {
            workingText.setText(bundle);
        } else
        {
            if (editMode == 1)
            {
                workingText.setText(bundle);
                workingText.setHint(0x7f070459);
                return;
            }
            if (editMode == 2)
            {
                workingText.setEnabled(false);
                spinnerEditMode.setVisibility(8);
                spinnerEditModeAppend.setVisibility(8);
                return;
            }
        }
    }

    private void switchToStandardEditor()
    {
        textMode = 0;
        String s = DescriptionConverter.toPlainText(workingText.getText().toString());
        workingText.setTextKeepState(s);
        previewLink.setVisibility(8);
        if (editMode != 2 && textMode == 0 && hasSpeechRecognition())
        {
            micButton.setVisibility(0);
            return;
        } else
        {
            micButton.setVisibility(8);
            return;
        }
    }

    protected int getLayoutResource()
    {
        return 0x7f0301fc;
    }

    public int getTitleRes()
    {
        return 0x7f07053c;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (!wasFragmentRetained)
        {
            wasFragmentRetained = true;
            previewLink.setOnClickListener(this);
            micButton.setOnClickListener(new android.view.View.OnClickListener() {

                final DescriptionSpokeFragment this$0;

                public void onClick(View view)
                {
                    view = new Intent("android.speech.action.RECOGNIZE_SPEECH");
                    view.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
                    startActivityForResult(view, 1234);
                }

            
            {
                this$0 = DescriptionSpokeFragment.this;
                super();
            }
            });
            String s = getString(0x7f0703a3);
            String s1 = getString(0x7f0703a2);
            editModeAdapter = new ArrayAdapter(getActivity(), 0x1090008, new String[] {
                s, s1
            });
            editModeAdapter.setDropDownViewResource(0x7f030217);
            spinnerEditMode.setAdapter(editModeAdapter);
            spinnerEditMode.setChangeListener(this);
            spinnerEditModeAppend.setAdapter(editModeAdapter);
            spinnerEditModeAppend.setChangeListener(this);
            parent.setVisibility(8);
            progress.setVisibility(0);
            if (bundle != null)
            {
                onRestoreInstanceState(bundle);
                return;
            }
        }
    }

    protected void onActivityResultSafe(int i, int j, Intent intent)
    {
        if (j == -1)
        {
            switch (i)
            {
            default:
                return;

            case 1234: 
                intent = intent.getStringArrayListExtra("android.speech.extra.RESULTS");
                break;
            }
            if (!intent.isEmpty())
            {
                intent = (String)intent.get(0);
                if (editMode == 0 || editMode == 1)
                {
                    i = workingText.getSelectionStart();
                    j = workingText.getText().length();
                    String s = workingText.getText().subSequence(0, i).toString();
                    String s1 = workingText.getText().subSequence(i, j).toString();
                    workingText.setTextKeepState((new StringBuilder()).append(s).append(intent).append(s1).toString());
                    workingText.setSelection((new StringBuilder()).append(s).append(intent).toString().length());
                    return;
                }
            }
        }
    }

    public void onChange(int i, Object obj)
    {
        if (((String)obj).equals(getString(0x7f0703a2)))
        {
            textMode = 1;
            obj = DescriptionConverter.toHtml(workingText.getText().toString());
            workingText.setTextKeepState(((CharSequence) (obj)));
            previewLink.setVisibility(0);
            micButton.setVisibility(8);
            return;
        }
        if (containsHtml(workingText.getText().toString()))
        {
            (new com.ebay.app.AlertDialogFragment.Builder()).setTitle(getString(0x7f070bb6)).setMessage(getString(0x7f070163)).setPositiveButton(0x7f070738).setNegativeButton(0x7f0701cc).createFromFragment(1, this).show(getFragmentManager(), "convert_warning");
            return;
        } else
        {
            switchToStandardEditor();
            return;
        }
    }

    public void onClick(View view)
    {
        Util.hideSoftInput(getView().getContext(), workingText);
        if (view.getId() == 0x7f100636)
        {
            view = new Intent(getActivity(), com/ebay/mobile/sell/ProductDetailsActivity);
            if (latestDraft.productTitle != null)
            {
                view.putExtra("title", latestDraft.productTitle.getStringValue());
            }
            if (latestDraft.productStockPhoto != null)
            {
                view.putExtra("photo", latestDraft.productStockPhoto.getStringValue());
            }
            if (latestDraft.productId != null)
            {
                view.putExtra("product_memento_id", latestDraft.productId.getStringValue());
            }
            startActivity(view);
        } else
        {
            if (view.getId() == 0x7f100639)
            {
                Object obj = latestDraft.description.getStringValue();
                view = new Bundle();
                view.putString("description", ((String) (obj)));
                obj = new DescriptionPreviewDialogFragment();
                ((DialogFragment) (obj)).setArguments(view);
                ((DialogFragment) (obj)).show(getFragmentManager(), "preview");
                return;
            }
            if (view.getId() == 0x7f10063d)
            {
                Object obj1 = workingText.getText().toString();
                view = ((View) (obj1));
                if (textMode == 0)
                {
                    view = DescriptionConverter.toHtml(((String) (obj1)));
                }
                obj1 = view;
                if (editMode == 1)
                {
                    obj1 = (new StringBuilder()).append(originalDescription).append("<p>").append(view).append("</p>").toString();
                }
                view = new Bundle();
                view.putString("description", ((String) (obj1)));
                obj1 = new DescriptionPreviewDialogFragment();
                ((DialogFragment) (obj1)).setArguments(view);
                ((DialogFragment) (obj1)).show(getFragmentManager(), "preview");
                return;
            }
        }
    }

    public void onContentChanged(ListingDraftDataManager listingdraftdatamanager, ListingDraftContent listingdraftcontent, com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.DispatchType dispatchtype)
    {
        if (listingdraftcontent.getStatus().hasError())
        {
            return;
        } else
        {
            productDescription = listingdraftcontent.productDescription;
            initializeFromDraft((ListingDraft)listingdraftcontent.getData());
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        initDataManagers();
    }

    public void onDialogFragmentResult(DialogFragment dialogfragment, int i, int j)
    {
label0:
        {
            if (i == 1)
            {
                if (j != 1)
                {
                    break label0;
                }
                switchToStandardEditor();
            }
            return;
        }
        spinnerEditMode.setSelection(editModeAdapter.getPosition(getString(0x7f0703a2)));
        spinnerEditModeAppend.setSelection(editModeAdapter.getPosition(getString(0x7f0703a2)));
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        datamanagercontainer = (com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.KeyParams)getArguments().getParcelable("key_params");
        dm = (ListingDraftDataManager)getDataManagerContainer().initialize(datamanagercontainer, this);
    }

    public void onPause()
    {
        Util.hideSoftInput(getView().getContext(), workingText);
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        ((ListingFragmentActivity)getActivity()).sendTrackingForSpokeEvent("SellingItemDetails");
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (workingText != null)
        {
            bundle.putString("workingText", workingText.getText().toString());
        }
        bundle.putInt("textMode", textMode);
        bundle.putInt("editMode", editMode);
        bundle.putString("description", originalDescription);
        bundle.putString("addToDescription", originalAddToDescription);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        progress = view.findViewById(0x7f100143);
        parent = view.findViewById(0x7f1004bc);
        workingText = (EditText)view.findViewById(0x7f10063c);
        previewLink = (TextView)view.findViewById(0x7f10063d);
        micButton = view.findViewById(0x7f10063e);
        spinnerEditMode = (EbaySpinner)view.findViewById(0x7f100637);
        spinnerEditModeAppend = (EbaySpinner)view.findViewById(0x7f10063b);
    }

    protected void saveOutstandingChanges(boolean flag)
    {
        boolean flag1 = true;
        if (havePendingChanges())
        {
            Object obj = workingText.getText().toString();
            String s = ((String) (obj));
            if (textMode == 0)
            {
                s = DescriptionConverter.toHtml(((String) (obj)));
            }
            obj = dm;
            if (editMode != 1)
            {
                flag1 = false;
            }
            ((ListingDraftDataManager) (obj)).updateDescription(flag1, s, flag);
        } else
        if (flag)
        {
            dm.validateDraft();
            return;
        }
    }
}
