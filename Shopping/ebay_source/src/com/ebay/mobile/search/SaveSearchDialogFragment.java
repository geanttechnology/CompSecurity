// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.ebay.common.Preferences;
import com.ebay.common.UserCache;
import com.ebay.common.content.dm.FollowedEntityDataManager;
import com.ebay.common.model.followinterest.FollowDescriptor;
import com.ebay.common.model.followinterest.FollowType;
import com.ebay.common.model.search.SavedSearch;
import com.ebay.common.net.api.fuss.EbayFussApi;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.util.EbayAsyncTask;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.notifications.ItemCache;
import com.ebay.mobile.notifications.NotificationPreferenceManager;
import com.ebay.mobile.notifications.NotificationUtil;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.FwActivity;
import com.ebay.shared.ui.SearchRefinementSummary;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.ebay.mobile.search:
//            SavedSearchList

public class SaveSearchDialogFragment extends DialogFragment
    implements android.widget.TextView.OnEditorActionListener, com.ebay.common.UserCache.IUpdateSavedSearch, com.ebay.common.util.EbayAsyncTask.TaskHandler
{
    public static interface OnSaveSearchListener
    {

        public abstract void onSaveSearch();
    }

    private static final class SaveSearchAsyncTask extends EbayAsyncTask
    {

        private final EbayFussApi api;
        private final Context applicationContext;
        private final boolean doReplace;
        private final EbayContext ebayContext;
        private final boolean enableNotifications;
        private FollowedEntityDataManager followInterestDataManager;
        private boolean hasError;
        private final String iafToken;
        private final String replaceSearchId;
        private final SavedSearch savedSearch;
        private final String searchName;
        private final SearchParameters searchParameters;
        private final String userId;

        private void updateItemCacheAndMdnsOrFollowSvc(String s)
        {
            savedSearch.id = s;
            (new ItemCache(applicationContext)).addSavedSearch(s, savedSearch.name, 0, 0L, 0L, 0L);
            NotificationPreferenceManager notificationpreferencemanager = new NotificationPreferenceManager(applicationContext);
            if (enableNotifications)
            {
                notificationpreferencemanager.addNotifyEnabledSavedSearchId(userId, s);
            } else
            {
                notificationpreferencemanager.removeNotifyEnabledSavedSearchId(userId, s);
            }
            NotificationUtil.updateNotificationSubscriptions(applicationContext, ebayContext, notificationpreferencemanager.getNotifyEnabledSavedSearchIdList(userId));
        }

        private boolean useFollowInterest()
        {
            return DeviceConfiguration.getAsync().get(DcsBoolean.searchSavedSearchUseFollowInterest);
        }

        protected volatile Object doInBackgroundInternal(Object obj)
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
        {
            return doInBackgroundInternal((Void)obj);
        }

        protected Object doInBackgroundInternal(Void void1)
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
        {
label0:
            {
label1:
                {
                    boolean flag = true;
                    if (doReplace)
                    {
                        if (useFollowInterest())
                        {
                            if (!TextUtils.isEmpty(replaceSearchId))
                            {
                                followInterestDataManager.deleteFollow(FollowType.INTEREST, replaceSearchId, iafToken);
                            } else
                            {
                                followInterestDataManager.deleteFollowedSearchByName(searchName, iafToken);
                            }
                            flag = true;
                        } else
                        if (!TextUtils.isEmpty(replaceSearchId))
                        {
                            flag = api.removeFavoriteSearch(iafToken, replaceSearchId, null);
                        } else
                        {
                            flag = api.removeFavoriteSearch(iafToken, null, searchName);
                        }
                    }
                    if (flag)
                    {
                        if (!useFollowInterest())
                        {
                            break label0;
                        }
                        void1 = followInterestDataManager.followSearchSynchronous(searchParameters, searchName);
                        if (void1 == null || void1.getStatus().hasError())
                        {
                            break label1;
                        }
                        updateItemCacheAndMdnsOrFollowSvc(((FollowDescriptor)void1.getData()).getInterestId());
                    }
                    return null;
                }
                hasError = true;
                return null;
            }
            updateItemCacheAndMdnsOrFollowSvc(api.saveFavoriteSearch(iafToken, searchParameters, searchName));
            return null;
        }

        protected void onPostExecute(Object obj)
        {
            super.onPostExecute(obj);
            if (hasError)
            {
                Toast.makeText(applicationContext, 0x7f070255, 0).show();
            }
        }

        protected SaveSearchAsyncTask(com.ebay.common.util.EbayAsyncTask.TaskHandler taskhandler, Activity activity, String s, SearchParameters searchparameters, String s1, String s2, boolean flag, 
                SavedSearch savedsearch, String s3, boolean flag1)
        {
            super(taskhandler);
            hasError = false;
            applicationContext = activity.getApplicationContext();
            ebayContext = ((FwActivity)activity).getEbayContext();
            api = EbayApiUtil.getFindingUserSettingsApi(ebayContext);
            iafToken = s;
            searchParameters = searchparameters;
            replaceSearchId = s1;
            searchName = s2;
            doReplace = flag;
            savedSearch = savedsearch;
            userId = s3;
            enableNotifications = flag1;
            searchparameters.iafToken = s;
            followInterestDataManager = (FollowedEntityDataManager)DataManager.get(ebayContext, FollowedEntityDataManager.KEY);
        }
    }


    private static final String EXTRA_INITIAL_SUGGESTION = "suggestion";
    private static final String EXTRA_IS_SAVING = "isSaving";
    private static final String EXTRA_SEARCH_PARAMS = "searchParams";
    private static final String EXTRA_USER_ID = "userId";
    private List duplicatePositions;
    private View duplicationErrorText;
    private CompoundButton enableNotificationSwitch;
    private boolean isDismissed;
    private boolean isSaving;
    private ItemCache itemCache;
    private SearchParameters m_searchParameters;
    private View mainLayout;
    private SavedSearch newlySavedSearch;
    private int newlySavedSearchPosition;
    private View progressLayout;
    private TextView progressText;
    private View saveButton;
    private EditText searchEditText;
    private String sellerIdPrefix;
    private String suggestedUniqueName;
    private UserCache userCache;
    private String userId;

    public SaveSearchDialogFragment()
    {
        newlySavedSearch = null;
        newlySavedSearchPosition = -1;
        isDismissed = false;
        isSaving = false;
    }

    private void checkAndSetSearchName(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            duplicationErrorText.setVisibility(8);
            saveButton.setEnabled(false);
            enableNotificationSwitch.setEnabled(false);
            return;
        } else
        {
            saveButton.setEnabled(true);
            enableNotificationSwitch.setEnabled(true);
            updateUiForDuplicateSavedSearch(s);
            return;
        }
    }

    private void checkSearchName()
    {
        checkAndSetSearchName(searchEditText.getText().toString());
    }

    private View getDialogContent()
    {
        Activity activity = getActivity();
        View view = activity.getLayoutInflater().inflate(0x7f0301e8, null, false);
        enableNotificationSwitch = (CompoundButton)view.findViewById(0x7f10060e);
        searchEditText = (EditText)view.findViewById(0x7f10060c);
        searchEditText.setOnEditorActionListener(this);
        duplicationErrorText = view.findViewById(0x7f10060d);
        progressLayout = view.findViewById(0x7f100143);
        progressLayout.setVisibility(8);
        progressText = (TextView)view.findViewById(0x7f100610);
        mainLayout = view.findViewById(0x7f100016);
        itemCache = new ItemCache(activity);
        userCache = new UserCache(activity, ((FwActivity)activity).getEbayContext());
        sellerIdPrefix = (new StringBuilder()).append(getString(0x7f0709ed)).append(' ').toString();
        CharSequence charsequence = SearchRefinementSummary.getRefinementsSummary(m_searchParameters, getResources(), null, null);
        ((TextView)view.findViewById(0x7f10060f)).setText(charsequence);
        boolean flag;
        if (itemCache.isSearchListReady())
        {
            processUiState();
        } else
        {
            refreshAsync();
        }
        new NotificationPreferenceManager(activity);
        flag = DeviceConfiguration.getAsync().get(DcsBoolean.savedSearchNotificationDefault);
        enableNotificationSwitch.setChecked(flag);
        return view;
    }

    public static SaveSearchDialogFragment newInstance(SearchParameters searchparameters, String s)
    {
        SaveSearchDialogFragment savesearchdialogfragment = new SaveSearchDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("searchParams", searchparameters);
        bundle.putString("userId", s);
        savesearchdialogfragment.setArguments(bundle);
        return savesearchdialogfragment;
    }

    private void performSave()
    {
        boolean flag = true;
        String s = searchEditText.getText().toString();
        updateUiForProgress(true, getString(0x7f07094d, new Object[] {
            s
        }));
        saveButton.setEnabled(false);
        enableNotificationSwitch.setEnabled(false);
        Util.hideSoftInput(getActivity(), mainLayout);
        Activity activity = getActivity();
        if (activity != null && (activity instanceof OnSaveSearchListener))
        {
            ((OnSaveSearchListener)activity).onSaveSearch();
        }
        if (duplicatePositions.size() == 0)
        {
            flag = false;
        }
        saveSearch(s, flag);
    }

    private void processUiState()
    {
        CompoundButton compoundbutton;
        boolean flag;
        if (suggestedUniqueName == null)
        {
            suggestedUniqueName = UserCache.getSavedSearchList().suggestUniqueName(m_searchParameters, sellerIdPrefix);
            setSearchName(suggestedUniqueName);
        } else
        {
            checkSearchName();
        }
        updateUiForDuplicateSavedSearch(suggestedUniqueName);
        compoundbutton = enableNotificationSwitch;
        if (!TextUtils.isEmpty(suggestedUniqueName))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        compoundbutton.setEnabled(flag);
    }

    private void refreshAsync()
    {
        updateUiForProgress(true, null);
        userCache.registerSavedSearchHandler(this);
    }

    private void saveSearch(String s, boolean flag)
    {
        Object obj = null;
        Object obj2 = null;
        Object obj1 = MyApp.getPrefs().getAuthentication();
        if (obj1 == null)
        {
            obj1 = null;
        } else
        {
            obj1 = ((Authentication) (obj1)).iafToken;
        }
        if (flag)
        {
            obj = obj2;
            if (duplicatePositions.size() == 1)
            {
                obj = UserCache.getSavedSearchList().get(((Integer)duplicatePositions.get(0)).intValue());
                if (obj == null)
                {
                    obj = null;
                } else
                {
                    obj = ((SavedSearch) (obj)).id;
                }
            }
            UserCache.getSavedSearchList().removeById(getActivity(), ((String) (obj)));
            itemCache.deleteSavedSearch(((String) (obj)));
        }
        newlySavedSearch = new SavedSearch(s, m_searchParameters);
        newlySavedSearchPosition = UserCache.getSavedSearchList().add(newlySavedSearch);
        (new SaveSearchAsyncTask(this, getActivity(), ((String) (obj1)), m_searchParameters, ((String) (obj)), s, flag, newlySavedSearch, userId, enableNotificationSwitch.isChecked())).execute(new Void[0]);
        isSaving = true;
    }

    private void setSearchName(String s)
    {
        searchEditText.setText(s);
        s = searchEditText.getText();
        Selection.setSelection(s, s.length());
    }

    private void updateUiForDuplicateSavedSearch(String s)
    {
        SavedSearchList savedsearchlist = UserCache.getSavedSearchList();
        if (savedsearchlist != null)
        {
            duplicatePositions = savedsearchlist.getPositions(s);
            if (duplicatePositions.size() != 0)
            {
                duplicationErrorText.setVisibility(0);
                return;
            } else
            {
                duplicationErrorText.setVisibility(8);
                return;
            }
        } else
        {
            duplicationErrorText.setVisibility(8);
            return;
        }
    }

    private void updateUiForProgress(boolean flag, String s)
    {
label0:
        {
            byte byte1 = 4;
            View view = mainLayout;
            byte byte0;
            if (flag)
            {
                byte0 = 4;
            } else
            {
                byte0 = 0;
            }
            view.setVisibility(byte0);
            view = progressLayout;
            byte0 = byte1;
            if (flag)
            {
                byte0 = 0;
            }
            view.setVisibility(byte0);
            if (flag)
            {
                if (TextUtils.isEmpty(s))
                {
                    break label0;
                }
                progressText.setVisibility(0);
                progressText.setText(s);
            }
            return;
        }
        progressText.setVisibility(8);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            isSaving = bundle.getBoolean("isSaving", false);
            if (isSaving)
            {
                dismiss();
            }
            suggestedUniqueName = bundle.getString("suggestion");
        } else
        {
            isSaving = false;
        }
        bundle = getArguments();
        m_searchParameters = (SearchParameters)bundle.getParcelable("searchParams");
        userId = bundle.getString("userId");
    }

    public Dialog onCreateDialog(final Bundle dialog)
    {
        dialog = new android.support.v7.app.AlertDialog.Builder(getActivity());
        dialog.setTitle(0x7f07064b);
        dialog.setPositiveButton(0x7f07093f, null);
        dialog.setNegativeButton(0x7f0701cc, null);
        dialog.setView(getDialogContent());
        dialog = dialog.create();
        dialog.setOnShowListener(new android.content.DialogInterface.OnShowListener() {

            final SaveSearchDialogFragment this$0;
            final AlertDialog val$dialog;

            public void onShow(DialogInterface dialoginterface)
            {
                saveButton = dialog.getButton(-1);
                dialoginterface = saveButton;
                boolean flag;
                if (itemCache.isSearchListReady() && !TextUtils.isEmpty(searchEditText.getText().toString()))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                dialoginterface.setEnabled(flag);
                saveButton.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls1 this$1;

                    public void onClick(View view)
                    {
                        performSave();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
                dialog.getButton(-2).setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls1 this$1;

                    public void onClick(View view)
                    {
                        dialog.dismiss();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
                searchEditText.addTextChangedListener(new TextWatcher() {

                    final _cls1 this$1;

                    public void afterTextChanged(Editable editable)
                    {
                        checkAndSetSearchName(editable.toString());
                    }

                    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
                    {
                    }

                    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
                    {
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
            }

            
            {
                this$0 = SaveSearchDialogFragment.this;
                dialog = alertdialog;
                super();
            }
        });
        return dialog;
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        isDismissed = true;
        super.onDismiss(dialoginterface);
        userCache.unregisterSavedSearchHandler(this);
    }

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        boolean flag1 = true;
        i;
        JVM INSTR tableswitch 6 6: default 24
    //                   6 30;
           goto _L1 _L2
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (saveButton.isEnabled())
        {
            flag = flag1;
            if (!TextUtils.isEmpty(searchEditText.getText().toString()))
            {
                performSave();
                return true;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onError(int i, List list)
    {
        if (isDismissed)
        {
            return;
        }
        if (i == -1 && EbayErrorUtil.userNotLoggedIn(list) && MyApp.getPrefs().isSignedIn())
        {
            MyApp.signOutForIafTokenFailure(getActivity());
            dismiss();
            return;
        }
        updateUiForProgress(false, null);
        if (newlySavedSearchPosition != -1)
        {
            enableNotificationSwitch.setEnabled(true);
            searchEditText.setEnabled(true);
            saveButton.setEnabled(true);
            newlySavedSearchPosition = -1;
        } else
        {
            userCache.clearSavedSearchList();
        }
        (new EbayErrorHandler(getActivity(), true)).handleEbayError(i, list);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("suggestion", searchEditText.getText().toString());
        bundle.putBoolean("isSaving", isSaving);
    }

    public void onStop()
    {
        isDismissed = true;
        super.onStop();
    }

    public void onTaskComplete(Object obj)
    {
        boolean flag = false;
        if (isDismissed)
        {
            return;
        }
        updateUiForProgress(false, null);
        enableNotificationSwitch.setEnabled(true);
        if (obj instanceof List)
        {
            obj = (List)obj;
            UserCache.getSavedSearchList().setSearchList(((List) (obj)));
            suggestedUniqueName = UserCache.getSavedSearchList().suggestUniqueName(m_searchParameters, sellerIdPrefix);
            if (TextUtils.isEmpty(searchEditText.getText().toString()))
            {
                setSearchName(suggestedUniqueName);
            }
            obj = saveButton;
            if (!TextUtils.isEmpty(suggestedUniqueName))
            {
                flag = true;
            }
            ((View) (obj)).setEnabled(flag);
            searchEditText.setEnabled(true);
            return;
        } else
        {
            dismiss();
            return;
        }
    }

    public void updateSavedSearch(SavedSearchList savedsearchlist)
    {
        updateUiForProgress(false, null);
        processUiState();
    }



/*
    static View access$002(SaveSearchDialogFragment savesearchdialogfragment, View view)
    {
        savesearchdialogfragment.saveButton = view;
        return view;
    }

*/




}
