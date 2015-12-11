// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.ebay.common.util.ImageCache;
import com.ebay.mobile.activities.BaseFragment;
import com.ebay.mobile.photomanager.PhotoManagerActivity;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.mobile.myebay:
//            SubjectDialogFragment

public class ComposeNewMessageFragment extends BaseFragment
    implements android.view.View.OnClickListener, SubjectDialogFragment.OnSubjectSelectedObserver
{
    public static interface ComposeMessageObserver
    {

        public abstract void onCancelClicked();

        public abstract void onEnableSendButton(boolean flag);

        public abstract void onRegisterFragment(ComposeNewMessageFragment composenewmessagefragment);

        public abstract void onSendClicked();
    }


    private static final int ACTIVITY_SELECT_PHOTOS = 1;
    private static final String MESSAGE_BODY = "message_body";
    private static final String MESSAGE_HIDE_ADD_PHOTOS = "message_hide_add_photos";
    private static final String MESSAGE_MODIFIED = "message_modified";
    private static final String MESSAGE_PHOTO_URLS = "picture_urls";
    private static final String MESSAGE_RECEPIENT = "message_recepient";
    private static final String MESSAGE_SUBJECT = "message_subject";
    private static final String MESSAGE_SUBJECT_TYPE = "subject_type";
    private static final String MESSAGE_TYPE = "message_type";
    private static final int PHOTO_PAD_PX = 5;
    private static final int PHOTO_PX = 100;
    private static final int PHOTO_TABLET_PX = 150;
    private static final int QUESTION_GENERAL = 0;
    private static final int QUESTION_SHIPPING_ITEM = 3;
    private static final int QUESTION_SHIPPING_MULTIPLE_ITEMS = 1;
    private static final int QUESTION_TO_PAY = 2;
    public static final String TAG = "compose.fragment";
    private ComposeMessageObserver composeMessageListner;
    private EditText composeMsgView;
    private EditText customSubjectView;
    private ImageCache imageCache;
    private boolean isCustomTypeMessage;
    private boolean isHideAddPhotos;
    private boolean isMessageEdited;
    private ArrayList photoUrls;
    private LinearLayout photosLayout;
    private FrameLayout photosScroll;
    private String prefillBodyText;
    private String prefillSubjectText;
    private String recepient;
    private Button subjectSpinnerView;
    private com.ebay.nautilus.domain.net.api.trading.AddMemberMessageAAQRequest.QuestionType subjectType;

    public ComposeNewMessageFragment()
    {
        prefillBodyText = "";
        prefillSubjectText = "";
        isCustomTypeMessage = false;
        isHideAddPhotos = false;
        isMessageEdited = false;
        subjectType = com.ebay.nautilus.domain.net.api.trading.AddMemberMessageAAQRequest.QuestionType.General;
        photoUrls = new ArrayList();
    }

    private void attachPhotos()
    {
        if (getActivity() != null)
        {
            Intent intent = new Intent(getActivity(), com/ebay/mobile/photomanager/PhotoManagerActivity);
            intent.putExtra("maxphotos", 5);
            intent.putExtra("photourls", photoUrls);
            startActivityForResult(intent, 1);
        }
    }

    private void handleSelectPhotosResult(int i, Intent intent)
    {
        if (i == -1)
        {
            photoUrls = intent.getStringArrayListExtra("photourls");
            updatePhotosLayout();
        }
    }

    public static ComposeNewMessageFragment newInstance(String s, String s1, String s2, boolean flag, boolean flag1)
    {
        ComposeNewMessageFragment composenewmessagefragment = new ComposeNewMessageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("message_body", s);
        bundle.putBoolean("message_type", flag);
        bundle.putString("message_subject", s1);
        bundle.putString("message_recepient", s2);
        bundle.putBoolean("message_hide_add_photos", flag1);
        composenewmessagefragment.setArguments(bundle);
        return composenewmessagefragment;
    }

    private boolean shouldEnableSendState()
    {
        return composeMsgView.getText().length() > 0 && (customSubjectView.isShown() && customSubjectView.getText().length() > 0 || subjectSpinnerView.getText().length() > 0);
    }

    private void updatePhotosLayout()
    {
        photosLayout.removeAllViews();
        if (photoUrls == null || photoUrls.isEmpty())
        {
            photosScroll.setVisibility(8);
        } else
        {
            photosScroll.setVisibility(0);
            boolean flag = getResources().getBoolean(0x7f0b0006);
            Activity activity = getActivity();
            Object obj = getResources().getDisplayMetrics();
            float f;
            int i;
            int j;
            int k;
            int l;
            if (flag)
            {
                f = 150F;
            } else
            {
                f = 100F;
            }
            j = (int)TypedValue.applyDimension(2, f, ((android.util.DisplayMetrics) (obj)));
            k = (int)TypedValue.applyDimension(2, 5F, ((android.util.DisplayMetrics) (obj)));
            l = photoUrls.size() - 1;
            i = 0;
            obj = photoUrls.iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                String s = (String)((Iterator) (obj)).next();
                ImageView imageview = new ImageView(activity);
                imageview.setBackgroundColor(getResources().getColor(0x106000b));
                imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
                android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(j, j);
                if (photosScroll instanceof ScrollView)
                {
                    photosLayout.setOrientation(1);
                    if (i != 0)
                    {
                        layoutparams.topMargin = k;
                    }
                    if (i != l)
                    {
                        layoutparams.bottomMargin = k;
                    }
                } else
                {
                    if (i != 0)
                    {
                        layoutparams.leftMargin = k;
                    }
                    if (i != l)
                    {
                        layoutparams.rightMargin = k;
                    }
                }
                imageview.setLayoutParams(layoutparams);
                imageview.setId(0x7f100150);
                imageview.setOnClickListener(this);
                imageCache.setImage(imageview, s);
                photosLayout.addView(imageview);
                i++;
            }
        }
    }

    public String getMessage()
    {
        if (composeMsgView != null)
        {
            return composeMsgView.getText().toString();
        } else
        {
            return null;
        }
    }

    public ArrayList getPhotoUrls()
    {
        return photoUrls;
    }

    public String getSubject()
    {
        if (customSubjectView != null && customSubjectView.isShown())
        {
            return customSubjectView.getText().toString();
        } else
        {
            return null;
        }
    }

    public com.ebay.nautilus.domain.net.api.trading.AddMemberMessageAAQRequest.QuestionType getSubjectType()
    {
        return subjectType;
    }

    public boolean isMessageEdited()
    {
        return isMessageEdited;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (composeMessageListner != null)
        {
            composeMessageListner.onRegisterFragment(this);
        }
        imageCache = new ImageCache(getActivity());
        updatePhotosLayout();
        if (TextUtils.isEmpty(prefillBodyText))
        {
            if (composeMessageListner != null)
            {
                composeMessageListner.onEnableSendButton(false);
            }
        } else
        {
            composeMsgView.setText(prefillBodyText);
            if (composeMessageListner != null)
            {
                composeMessageListner.onEnableSendButton(true);
            }
        }
        if (isCustomTypeMessage)
        {
            customSubjectView.setVisibility(0);
            subjectSpinnerView.setVisibility(8);
            customSubjectView.setText(prefillSubjectText);
            subjectType = com.ebay.nautilus.domain.net.api.trading.AddMemberMessageAAQRequest.QuestionType.CustomizedSubject;
        } else
        {
            customSubjectView.setVisibility(8);
            subjectSpinnerView.setVisibility(0);
            subjectSpinnerView.setText(getActivity().getResources().getStringArray(0x7f0e000b)[subjectType.ordinal()]);
        }
        if (photoUrls == null)
        {
            photoUrls = new ArrayList();
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        i;
        JVM INSTR tableswitch 1 1: default 20
    //                   1 28;
           goto _L1 _L2
_L1:
        super.onActivityResult(i, j, intent);
        return;
_L2:
        handleSelectPhotosResult(j, intent);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (!(activity instanceof ComposeMessageObserver))
        {
            throw new RuntimeException("Calling Activity Should Implement  ComposeMessageObserver");
        } else
        {
            composeMessageListner = (ComposeMessageObserver)activity;
            return;
        }
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR lookupswitch 4: default 48
    //                   2131755346: 87
    //                   2131755352: 54
    //                   2131755353: 49
    //                   2131755356: 70;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L4:
        attachPhotos();
        return;
_L3:
        SubjectDialogFragment.createInstance(this, 0).show(getFragmentManager(), "Subject Dialog");
        return;
_L5:
        if (composeMessageListner != null)
        {
            composeMessageListner.onCancelClicked();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (composeMessageListner != null)
        {
            composeMessageListner.onSendClicked();
            return;
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setRetainInstance(true);
        Bundle bundle1 = getArguments();
        if (bundle1 != null)
        {
            prefillBodyText = bundle1.getString("message_body", "");
            isCustomTypeMessage = bundle1.getBoolean("message_type", false);
            prefillSubjectText = bundle1.getString("message_subject", "");
            recepient = bundle1.getString("message_recepient");
            isHideAddPhotos = bundle1.getBoolean("message_hide_add_photos", false);
        }
        if (bundle != null)
        {
            subjectType = (com.ebay.nautilus.domain.net.api.trading.AddMemberMessageAAQRequest.QuestionType)bundle.getSerializable("subject_type");
            photoUrls = bundle.getStringArrayList("picture_urls");
            isMessageEdited = bundle.getBoolean("message_modified");
            prefillBodyText = bundle.getString("message_body", "");
            prefillSubjectText = bundle.getString("message_subject", "");
            isCustomTypeMessage = bundle.getBoolean("message_type", false);
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030080, null);
        viewgroup = layoutinflater.findViewById(0x7f100159);
        byte byte0;
        if (isHideAddPhotos)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        viewgroup.setVisibility(byte0);
        viewgroup.setOnClickListener(this);
        ((TextView)layoutinflater.findViewById(0x7f100156)).setText(String.format(getActivity().getString(0x7f07060e), new Object[] {
            recepient
        }));
        photosScroll = (FrameLayout)layoutinflater.findViewById(0x7f100153);
        photosLayout = (LinearLayout)layoutinflater.findViewById(0x7f100154);
        composeMsgView = (EditText)layoutinflater.findViewById(0x7f100151);
        composeMsgView.setOnClickListener(this);
        composeMsgView.addTextChangedListener(new TextWatcher() {

            final ComposeNewMessageFragment this$0;

            public void afterTextChanged(Editable editable)
            {
                if (composeMessageListner != null)
                {
                    (new Handler()).postDelayed(new Runnable() {

                        final _cls1 this$1;

                        public void run()
                        {
                            composeMessageListner.onEnableSendButton(shouldEnableSendState());
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    }, 1L);
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                if (prefillBodyText.length() != k)
                {
                    isMessageEdited = true;
                }
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            
            {
                this$0 = ComposeNewMessageFragment.this;
                super();
            }
        });
        customSubjectView = (EditText)layoutinflater.findViewById(0x7f100157);
        customSubjectView.addTextChangedListener(new TextWatcher() {

            final ComposeNewMessageFragment this$0;

            public void afterTextChanged(Editable editable)
            {
                if (composeMessageListner != null)
                {
                    (new Handler()).postDelayed(new Runnable() {

                        final _cls2 this$1;

                        public void run()
                        {
                            composeMessageListner.onEnableSendButton(shouldEnableSendState());
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    }, 1L);
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                if (prefillSubjectText.length() != k)
                {
                    isMessageEdited = true;
                }
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            
            {
                this$0 = ComposeNewMessageFragment.this;
                super();
            }
        });
        subjectSpinnerView = (Button)layoutinflater.findViewById(0x7f100158);
        subjectSpinnerView.setOnClickListener(this);
        if (layoutinflater.getResources().getBoolean(0x7f0b0006))
        {
            layoutinflater.findViewById(0x7f10015c).setOnClickListener(this);
            layoutinflater.findViewById(0x7f100152).setOnClickListener(this);
        }
        return layoutinflater;
    }

    public void onDestroyView()
    {
        photosScroll = null;
        photosLayout = null;
        composeMsgView = null;
        imageCache.clearImageFetching();
        imageCache = null;
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("picture_urls", photoUrls);
        bundle.putSerializable("subject_type", subjectType);
        bundle.putSerializable("message_body", getMessage());
        bundle.putSerializable("message_subject", getSubject());
        bundle.putSerializable("message_modified", Boolean.valueOf(isMessageEdited));
        bundle.putSerializable("message_type", Boolean.valueOf(isCustomTypeMessage));
    }

    public void onSubjectSelected(int i)
    {
        subjectSpinnerView.setText(getActivity().getResources().getStringArray(0x7f0e000b)[i]);
        i;
        JVM INSTR tableswitch 0 3: default 52
    //                   0 73
    //                   1 83
    //                   2 93
    //                   3 103;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        if (composeMessageListner != null)
        {
            composeMessageListner.onEnableSendButton(shouldEnableSendState());
        }
        return;
_L2:
        subjectType = com.ebay.nautilus.domain.net.api.trading.AddMemberMessageAAQRequest.QuestionType.General;
        continue; /* Loop/switch isn't completed */
_L3:
        subjectType = com.ebay.nautilus.domain.net.api.trading.AddMemberMessageAAQRequest.QuestionType.MultipleItemShipping;
        continue; /* Loop/switch isn't completed */
_L4:
        subjectType = com.ebay.nautilus.domain.net.api.trading.AddMemberMessageAAQRequest.QuestionType.Payment;
        continue; /* Loop/switch isn't completed */
_L5:
        subjectType = com.ebay.nautilus.domain.net.api.trading.AddMemberMessageAAQRequest.QuestionType.Shipping;
        if (true) goto _L1; else goto _L6
_L6:
    }





/*
    static boolean access$302(ComposeNewMessageFragment composenewmessagefragment, boolean flag)
    {
        composenewmessagefragment.isMessageEdited = flag;
        return flag;
    }

*/

}
