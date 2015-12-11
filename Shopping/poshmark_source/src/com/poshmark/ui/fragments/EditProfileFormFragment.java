// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.adapters.MetaItemSpinAdapter;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.data_model.models.inner_models.Profile;
import com.poshmark.db.DbApi;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.customviews.PMAvataarImageView;
import com.poshmark.ui.customviews.PMEditText;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.user.UserInfoDetails;
import com.poshmark.utils.FeatureManager;
import com.poshmark.utils.ObjectPickupDropOff;
import com.poshmark.utils.meta_data.ListingMetaDataController;
import com.poshmark.utils.view_holders.EditProfileFormViewHolder;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, ChangePasswordFragment, CameraPreviewFragment, SuggestedBrandsPickerFragment, 
//            FindFriendsFragment

public class EditProfileFormFragment extends PMFragment
{
    public static final class PROFILE_MODE extends Enum
    {

        private static final PROFILE_MODE $VALUES[];
        public static final PROFILE_MODE PROFILE_MODE_CREATE;
        public static final PROFILE_MODE PROFILE_MODE_EDIT;

        public static PROFILE_MODE valueOf(String s)
        {
            return (PROFILE_MODE)Enum.valueOf(com/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE, s);
        }

        public static PROFILE_MODE[] values()
        {
            return (PROFILE_MODE[])$VALUES.clone();
        }

        static 
        {
            PROFILE_MODE_CREATE = new PROFILE_MODE("PROFILE_MODE_CREATE", 0);
            PROFILE_MODE_EDIT = new PROFILE_MODE("PROFILE_MODE_EDIT", 1);
            $VALUES = (new PROFILE_MODE[] {
                PROFILE_MODE_CREATE, PROFILE_MODE_EDIT
            });
        }

        private PROFILE_MODE(String s, int i)
        {
            super(s, i);
        }
    }


    private int SELECT_PICTURE;
    private Uri avataarImageFile;
    private android.view.View.OnTouchListener changePasswordListener;
    private android.view.View.OnFocusChangeListener focusChangeListener;
    private android.view.View.OnClickListener imageClickListener;
    private boolean isAvtaarImageSet;
    ListingMetaDataController metaData;
    PROFILE_MODE mode;
    boolean profileUpdated;
    UserInfoDetails userProfile;
    private EditProfileFormViewHolder viewHolder;

    public EditProfileFormFragment()
    {
        SELECT_PICTURE = 1;
        isAvtaarImageSet = false;
        profileUpdated = false;
        changePasswordListener = new android.view.View.OnTouchListener() {

            final EditProfileFormFragment this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 1)
                {
                    hideKeyboard();
                    ((PMActivity)getActivity()).launchFragment(null, com/poshmark/ui/fragments/ChangePasswordFragment, null);
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = EditProfileFormFragment.this;
                super();
            }
        };
        imageClickListener = new android.view.View.OnClickListener() {

            final EditProfileFormFragment this$0;

            public void onClick(View view)
            {
                if (mode == PROFILE_MODE.PROFILE_MODE_EDIT)
                {
                    view = new Intent((PMActivity)getActivity(), com/poshmark/ui/PMContainerActivity);
                    view.putExtra("FRAGMENT", com/poshmark/ui/fragments/CameraPreviewFragment);
                    Bundle bundle = new Bundle();
                    bundle.putInt("CREATION_MODE", CameraPreviewFragment.CREATE_COVERSHOT);
                    view.putExtra("FRAGMENT_DATA", bundle);
                    startActivityForResult(view, SELECT_PICTURE);
                }
            }

            
            {
                this$0 = EditProfileFormFragment.this;
                super();
            }
        };
        focusChangeListener = new android.view.View.OnFocusChangeListener() {

            final EditProfileFormFragment this$0;

            public void onFocusChange(View view, boolean flag)
            {
                if (flag && mode == PROFILE_MODE.PROFILE_MODE_EDIT && view == viewHolder.passwordEditText)
                {
                    hideKeyboard();
                    ((PMActivity)getActivity()).launchFragment(null, com/poshmark/ui/fragments/ChangePasswordFragment, null);
                }
            }

            
            {
                this$0 = EditProfileFormFragment.this;
                super();
            }
        };
    }

    private boolean isFormValid()
    {
        String s;
label0:
        {
            String s1 = new String();
            if (viewHolder.firstNameEditText.isValid())
            {
                s = s1;
                if (viewHolder.lastNameEditText.isValid())
                {
                    break label0;
                }
            }
            s = (new StringBuilder()).append(s1).append(viewHolder.firstNameEditText.getValidatorString()).append("\n").toString();
        }
        String s2 = s;
        if (!viewHolder.emailEditText.isValid())
        {
            s2 = (new StringBuilder()).append(s).append(viewHolder.emailEditText.getValidatorString()).append("\n").toString();
        }
        if (!s2.isEmpty())
        {
            showAlertMessage(getResources().getString(0x7f060148), s2);
            return false;
        } else
        {
            return true;
        }
    }

    private void loadUserProfile()
    {
        if (userProfile == null)
        {
            showProgressDialogWithMessage(getString(0x7f060190));
            PMApi.getUserProfile(PMApplicationSession.GetPMSession().getUserId(), new PMApiResponseHandler() {

                final EditProfileFormFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
label0:
                    {
                        if (isAdded())
                        {
                            hideProgressDialog();
                            if (pmapiresponse.hasError())
                            {
                                break label0;
                            }
                            userProfile = (UserInfoDetails)pmapiresponse.data;
                            updateView();
                        }
                        return;
                    }
                    showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.LOAD_USER_PROFILE, PMApplication.getContext().getString(0x7f0600eb)), new com.poshmark.ui.customviews.PMProgressDialog.ProgressDialogAutoDismissListener() {

                        final _cls1 this$1;

                        public void dialogDismissed()
                        {
                            ((PMContainerActivity)getActivity()).onBackPressed();
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                }

            
            {
                this$0 = EditProfileFormFragment.this;
                super();
            }
            });
            return;
        } else
        {
            updateView();
            return;
        }
    }

    private void restoreState(Bundle bundle)
    {
        if (mode == PROFILE_MODE.PROFILE_MODE_EDIT)
        {
            if (bundle != null)
            {
                isAvtaarImageSet = bundle.getBoolean("IS_IMAGE_SET");
                if (isAvtaarImageSet)
                {
                    avataarImageFile = Uri.parse(bundle.getString("IMAGE_FILE"));
                }
                bundle = (ParcelUuid)bundle.getParcelable("USER_PROFILE_PICKUP_KEY");
                if (bundle != null)
                {
                    userProfile = (UserInfoDetails)ObjectPickupDropOff.pickupDataObject(bundle.getUuid());
                }
            }
            loadUserProfile();
        }
    }

    private void setupNextActionButton()
    {
        hideAllActionButtons(true);
        if (mode == PROFILE_MODE.PROFILE_MODE_CREATE)
        {
            setupNextActionForCreate();
            return;
        } else
        {
            setupNextActionForUpdate();
            return;
        }
    }

    private void setupNextActionForCreate()
    {
        Button button = getNextActionButton();
        if (button == null)
        {
            return;
        } else
        {
            button.setText(getString(0x7f0601cc).toUpperCase());
            button.setOnClickListener(new android.view.View.OnClickListener() {

                final EditProfileFormFragment this$0;

                public void onClick(View view)
                {
                    Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "create_profile_button_tapped", null);
                    view = new HashMap();
                    Object obj = (MetaItem)viewHolder.shoeSizeSpinner.getSelectedItem();
                    if (obj != null)
                    {
                        Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "onramp_shoe_size_entered", null);
                        obj = ((MetaItem) (obj)).getId();
                        if (obj != null && !((String) (obj)).isEmpty())
                        {
                            view.put("shoe_size", obj);
                        }
                    }
                    obj = (MetaItem)viewHolder.dressSizeSpinner.getSelectedItem();
                    if (obj != null)
                    {
                        Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "onramp_dress_size_entered", null);
                        obj = ((MetaItem) (obj)).getId();
                        if (obj != null && !((String) (obj)).isEmpty())
                        {
                            view.put("dress_size", obj);
                        }
                    }
                    obj = viewHolder.cityEditText.getText().toString();
                    String s = viewHolder.websiteEditText.getText().toString();
                    if (obj != null && !((String) (obj)).isEmpty())
                    {
                        Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "onramp_mycity_entered", null);
                        String as[] = ((String) (obj)).split(",");
                        if (as != null && as.length > 1)
                        {
                            view.put("state", as[as.length - 1]);
                            view.put("city", as[0]);
                        } else
                        {
                            view.put("city", obj);
                        }
                    }
                    if (s != null && !s.isEmpty())
                    {
                        Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "onramp_website_entered", null);
                        view.put("website", s);
                    }
                    PMApi.setUserProfile(view, null, new PMApiResponseHandler() {

                        final _cls5 this$1;

                        public void handleResponse(PMApiResponse pmapiresponse)
                        {
                            if (!isAdded()) goto _L2; else goto _L1
_L1:
                            hideProgressDialog();
                            if (pmapiresponse.hasError())
                            {
                                break MISSING_BLOCK_LABEL_107;
                            }
                            if (!FeatureManager.getGlobalFeatureManager().isBrandsFollowOnSignupEnabled()) goto _L4; else goto _L3
_L3:
                            pmapiresponse = (PMActivity)getActivity();
                            if (pmapiresponse != null && pmapiresponse.isActivityInForeground())
                            {
                                pmapiresponse.launchFragment(null, com/poshmark/ui/fragments/SuggestedBrandsPickerFragment, null);
                            }
_L2:
                            return;
_L4:
                            pmapiresponse = (PMActivity)getActivity();
                            if (pmapiresponse == null || !pmapiresponse.isActivityInForeground()) goto _L2; else goto _L5
_L5:
                            pmapiresponse.launchFragment(null, com/poshmark/ui/fragments/FindFriendsFragment, null);
                            return;
                            showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.UPDATE_USER_PROFILE, PMApplication.getContext().getString(0x7f060100)));
                            return;
                        }

            
            {
                this$1 = _cls5.this;
                super();
            }
                    });
                }

            
            {
                this$0 = EditProfileFormFragment.this;
                super();
            }
            });
            return;
        }
    }

    private void setupNextActionForUpdate()
    {
        Button button = getNextActionButton();
        if (button == null)
        {
            return;
        } else
        {
            button.setText(getString(0x7f0602b3).toUpperCase());
            button.setOnClickListener(new android.view.View.OnClickListener() {

                final EditProfileFormFragment this$0;

                public void onClick(View view)
                {
                    if (isFormValid())
                    {
                        showProgressDialogWithMessage("Updating...");
                        HashMap hashmap = new HashMap();
                        view = viewHolder.cityEditText.getText().toString();
                        if (view != null && !view.isEmpty())
                        {
                            String as[] = view.split(",");
                            if (as != null && as.length > 1)
                            {
                                hashmap.put("state", as[as.length - 1]);
                                hashmap.put("city", as[0]);
                            } else
                            {
                                hashmap.put("city", view);
                                hashmap.put("state", "");
                            }
                        } else
                        {
                            hashmap.put("city", "");
                            hashmap.put("state", "");
                        }
                        if (viewHolder.websiteEditText.length() > 0)
                        {
                            hashmap.put("website", viewHolder.websiteEditText.getText().toString());
                        } else
                        {
                            hashmap.put("website", "");
                        }
                        hashmap.put("first_name", viewHolder.firstNameEditText.getText().toString());
                        hashmap.put("last_name", viewHolder.lastNameEditText.getText().toString());
                        hashmap.put("email", viewHolder.emailEditText.getText().toString());
                        view = null;
                        if (isAvtaarImageSet)
                        {
                            view = ((BitmapDrawable)viewHolder.avataarImageView.getDrawable()).getBitmap();
                        }
                        PMApi.setUserProfile(hashmap, view, new PMApiResponseHandler() {

                            final _cls6 this$1;

                            public void handleResponse(PMApiResponse pmapiresponse)
                            {
label0:
                                {
                                    if (isAdded())
                                    {
                                        if (pmapiresponse.hasError())
                                        {
                                            break label0;
                                        }
                                        PMApi.getUserProfile(PMApplicationSession.GetPMSession().getUserId(), new PMApiResponseHandler() {

                                            final _cls1 this$2;

                                            public void handleResponse(PMApiResponse pmapiresponse)
                                            {
label0:
                                                {
                                                    if (isAdded())
                                                    {
                                                        hideProgressDialog();
                                                        if (pmapiresponse.hasError())
                                                        {
                                                            break label0;
                                                        }
                                                        pmapiresponse = (UserInfoDetails)pmapiresponse.data;
                                                        PMApplicationSession.GetPMSession().updateUserInfo(pmapiresponse);
                                                        pmapiresponse = (PMActivity)getActivity();
                                                        profileUpdated = true;
                                                        pmapiresponse.onBackPressed();
                                                    }
                                                    return;
                                                }
                                                showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.LOAD_USER_PROFILE, PMApplication.getContext().getString(0x7f0600eb)));
                                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                                        });
                                    }
                                    return;
                                }
                                hideProgressDialog();
                                showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.UPDATE_USER_PROFILE, PMApplication.getContext().getString(0x7f060100)));
                            }

            
            {
                this$1 = _cls6.this;
                super();
            }
                        });
                    }
                }

            
            {
                this$0 = EditProfileFormFragment.this;
                super();
            }
            });
            return;
        }
    }

    private void setupView(View view)
    {
        viewHolder = new EditProfileFormViewHolder();
        viewHolder.cityEditText = (PMEditText)view.findViewById(0x7f0c0103);
        viewHolder.websiteEditText = (PMEditText)view.findViewById(0x7f0c0104);
        if (mode == PROFILE_MODE.PROFILE_MODE_CREATE)
        {
            view.findViewById(0x7f0c00fd).setVisibility(8);
            viewHolder.shoeSizeSpinner = (Spinner)view.findViewById(0x7f0c00fc);
            viewHolder.dressSizeSpinner = (Spinner)view.findViewById(0x7f0c00fa);
            if (metaData == null)
            {
                metaData = new ListingMetaDataController();
            }
            view = getString(0x7f0601e5);
            Object obj = DbApi.getShoeSizes();
            obj = new MetaItemSpinAdapter(getActivity(), 0x1090008, ((java.util.List) (obj)), view, false);
            ((MetaItemSpinAdapter) (obj)).setDropDownViewResource(0x1090009);
            viewHolder.shoeSizeSpinner.setAdapter(((android.widget.SpinnerAdapter) (obj)));
            obj = DbApi.getDressSizes();
            view = new MetaItemSpinAdapter(getActivity(), 0x1090008, ((java.util.List) (obj)), view, false);
            view.setDropDownViewResource(0x1090009);
            viewHolder.dressSizeSpinner.setAdapter(view);
            return;
        } else
        {
            view.findViewById(0x7f0c00f8).setVisibility(8);
            view.findViewById(0x7f0c00f5).setVisibility(8);
            viewHolder.avataarImageView = (PMAvataarImageView)view.findViewById(0x7f0c00fe);
            viewHolder.emailEditText = (PMEditText)view.findViewById(0x7f0c00ff);
            viewHolder.firstNameEditText = (PMEditText)view.findViewById(0x7f0c0100);
            viewHolder.lastNameEditText = (PMEditText)view.findViewById(0x7f0c0101);
            viewHolder.passwordEditText = (PMEditText)view.findViewById(0x7f0c0102);
            viewHolder.passwordEditText.setOnTouchListener(changePasswordListener);
            viewHolder.passwordEditText.setOnFocusChangeListener(focusChangeListener);
            viewHolder.avataarImageView.setOnClickListener(imageClickListener);
            return;
        }
    }

    private void updateView()
    {
        String s;
        String s1;
        Object obj1;
        if (isAvtaarImageSet)
        {
            Object obj = new android.graphics.BitmapFactory.Options();
            obj.inMutable = true;
            obj = BitmapFactoryInstrumentation.decodeFile(avataarImageFile.getPath(), ((android.graphics.BitmapFactory.Options) (obj)));
            viewHolder.avataarImageView.setImageBitmap(((android.graphics.Bitmap) (obj)));
        } else
        {
            viewHolder.avataarImageView.loadImage(userProfile.getUserSmallPicUrl());
        }
        viewHolder.emailEditText.setText(userProfile.getUserEmail());
        viewHolder.firstNameEditText.setText(userProfile.getUserFirstName());
        viewHolder.lastNameEditText.setText(userProfile.getUserLastName());
        s = userProfile.getProfile().city;
        s1 = userProfile.getProfile().state;
        obj1 = null;
        if (s == null || s.length() <= 0 || s1 == null || s1.length() <= 0) goto _L2; else goto _L1
_L1:
        s = (new StringBuilder()).append(s).append(",").append(s1).toString();
_L4:
        viewHolder.cityEditText.setText(s);
        viewHolder.websiteEditText.setText(userProfile.getProfile().website);
        return;
_L2:
        if (s == null || s.length() <= 0)
        {
            s = obj1;
            if (s1 != null)
            {
                s = obj1;
                if (s1.length() > 0)
                {
                    s = s1;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean handleBack()
    {
        if (profileUpdated && mode == PROFILE_MODE.PROFILE_MODE_EDIT)
        {
            PMNotificationManager.fireNotification("com.poshmark.intents.PROFILE_UPDATED");
        }
        if (((PMContainerActivity)getActivity()).getFragmentStackCount() > 1)
        {
            return false;
        } else
        {
            finishActivity();
            return true;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (j == -1 && i == SELECT_PICTURE)
        {
            avataarImageFile = (Uri)intent.getExtras().getParcelable("IMAGE_FILE_URI");
            intent = new android.graphics.BitmapFactory.Options();
            intent.inMutable = true;
            intent = BitmapFactoryInstrumentation.decodeFile(avataarImageFile.getPath(), intent);
            ImageLoader.getInstance().cancelDisplayTask(viewHolder.avataarImageView);
            viewHolder.avataarImageView.setImageBitmap(intent);
            isAvtaarImageSet = true;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null)
        {
            mode = PROFILE_MODE.values()[bundle.getInt("MODE")];
            return;
        } else
        {
            mode = PROFILE_MODE.PROFILE_MODE_CREATE;
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        if (mode == PROFILE_MODE.PROFILE_MODE_CREATE)
        {
            setTitle(0x7f0600cf);
        } else
        {
            setTitle((new StringBuilder()).append("@").append(PMApplicationSession.GetPMSession().getUserName()).toString());
        }
        layoutinflater = layoutinflater.inflate(0x7f03003a, viewgroup, false);
        setupView(layoutinflater);
        restoreState(bundle);
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (isAvtaarImageSet)
        {
            bundle.putString("IMAGE_FILE", avataarImageFile.toString());
            bundle.putBoolean("IS_IMAGE_SET", true);
        }
        if (userProfile != null)
        {
            java.util.UUID uuid = ObjectPickupDropOff.getUniqueKey();
            ObjectPickupDropOff.dropOffDataObject(uuid, userProfile);
            bundle.putParcelable("USER_PROFILE_PICKUP_KEY", new ParcelUuid(uuid));
        }
    }

    public void setViewNameForAnalytics()
    {
        if (mode == PROFILE_MODE.PROFILE_MODE_CREATE)
        {
            viewNameForAnalytics = "create_user_profile_screen";
        } else
        if (mode == PROFILE_MODE.PROFILE_MODE_EDIT)
        {
            viewNameForAnalytics = "edit_user_profile_screen";
            return;
        }
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        setupNextActionButton();
    }





}
