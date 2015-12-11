// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.ebay.app.AlertDialogFragment;
import com.ebay.common.util.ImageCache;
import com.ebay.mobile.activities.BaseFragment;
import com.ebay.mobile.photomanager.PhotoManagerActivity;
import com.ebay.mobile.ui_stuff.Util;
import java.util.ArrayList;
import java.util.Iterator;

public class ComposeMessageFragment extends BaseFragment
    implements android.view.View.OnClickListener
{
    public static interface OnMessageSendListener
    {

        public abstract void onMessageSend(int i, String s, ArrayList arraylist, Bundle bundle);
    }


    private static final int ACTIVITY_SELECT_PHOTOS = 1;
    private static final String PARAM_CALLER_CONTEXT = "param_caller_context";
    private static final String PARAM_IN_DIALOG = "param_compose_in_dialog";
    private static final String PARAM_IN_PICTURE_URLS = "param_picture_urls";
    private static final String PARAM_IN_TEXT = "param_in_text";
    private static final String PARAM_SHOW_SEND = "param_show_send";
    private static final int PHOTO_PAD_PX = 5;
    private static final int PHOTO_PX = 100;
    private static final String STATE_PHOTO_URLS = "instanceStatePhotoUrls";
    private static final String STATE_SENDING_MESSAGE = "instanceStateSendingMessage";
    public static final String TAG = "compose.fragment";
    private Bundle callerContext;
    private EditText composeMsgView;
    private ImageCache imageCache;
    private boolean inDialog;
    private boolean isSendingMessage;
    private android.view.View.OnClickListener onClickListener;
    private ArrayList photoUrls;
    private LinearLayout photosLayout;
    private HorizontalScrollView photosScroll;
    private ImageView sendButton;
    private boolean showSend;
    private String startingText;

    public ComposeMessageFragment()
    {
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

    public static Dialog getConfirmAbandonMessageDialog(Context context, android.content.DialogInterface.OnClickListener onclicklistener, android.content.DialogInterface.OnClickListener onclicklistener1)
    {
        return (new android.support.v7.app.AlertDialog.Builder(context)).setTitle(0x7f070112).setMessage(0x7f070111).setPositiveButton(context.getString(0x7f070738), onclicklistener).setNegativeButton(context.getString(0x7f0701cc), onclicklistener1).create();
    }

    private void handleSelectPhotosResult(int i, Intent intent)
    {
        if (i == -1)
        {
            photoUrls = intent.getStringArrayListExtra("photourls");
            updatePhotosLayout();
        }
    }

    public static ComposeMessageFragment newInstance(int i, String s, ArrayList arraylist, Bundle bundle)
    {
        ComposeMessageFragment composemessagefragment = new ComposeMessageFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putString("param_in_text", s);
        bundle1.putStringArrayList("param_picture_urls", arraylist);
        bundle1.putBundle("param_caller_context", bundle);
        bundle1.putBoolean("param_show_send", false);
        bundle1.putBoolean("param_compose_in_dialog", true);
        composemessagefragment.setArguments(bundle1);
        return composemessagefragment;
    }

    public static ComposeMessageFragment newInstance(Fragment fragment, int i, String s, Bundle bundle)
    {
        ComposeMessageFragment composemessagefragment = new ComposeMessageFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putString("param_in_text", s);
        bundle1.putBundle("param_caller_context", bundle);
        composemessagefragment.setTargetFragment(fragment, i);
        composemessagefragment.setArguments(bundle1);
        return composemessagefragment;
    }

    private void send()
    {
        OnMessageSendListener onmessagesendlistener;
        Fragment fragment;
        onmessagesendlistener = null;
        fragment = getTargetFragment();
        if (!(fragment instanceof OnMessageSendListener)) goto _L2; else goto _L1
_L1:
        onmessagesendlistener = (OnMessageSendListener)fragment;
_L4:
        if (onmessagesendlistener != null)
        {
            String s = getMessage();
            if (s != null && s.length() > 0)
            {
                setSendEnabled(false);
                isSendingMessage = true;
                onmessagesendlistener.onMessageSend(getTargetRequestCode(), s, photoUrls, callerContext);
            }
        }
        return;
_L2:
        if (getActivity() instanceof OnMessageSendListener)
        {
            onmessagesendlistener = (OnMessageSendListener)getActivity();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void setAlpha(ImageView imageview, int i)
    {
        imageview.setAlpha(i);
    }

    private void setImageAlpha(ImageView imageview, int i)
    {
        imageview.setImageAlpha(i);
    }

    public static void showConfirmAbandonMessageDialogFragment(Fragment fragment, int i, String s)
    {
        showConfirmAbandonMessageDialogFragment(fragment, i, s, true);
    }

    public static void showConfirmAbandonMessageDialogFragment(Fragment fragment, int i, String s, boolean flag)
    {
        (new com.ebay.app.AlertDialogFragment.Builder()).setTitle(0x7f070112).setMessage(0x7f070111).setPositiveButton(fragment.getString(0x7f070738)).setNegativeButton(fragment.getString(0x7f0701cc)).setRetainInstance(flag).createFromFragment(i, fragment).show(fragment.getFragmentManager(), s);
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
            Activity activity = getActivity();
            Object obj = getResources().getDisplayMetrics();
            int j = (int)TypedValue.applyDimension(2, 100F, ((android.util.DisplayMetrics) (obj)));
            int k = (int)TypedValue.applyDimension(2, 5F, ((android.util.DisplayMetrics) (obj)));
            int l = photoUrls.size();
            int i = 0;
            obj = photoUrls.iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                String s = (String)((Iterator) (obj)).next();
                ImageView imageview = new ImageView(activity);
                imageview.setBackgroundColor(getResources().getColor(0x106000b));
                imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
                android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(j, j);
                if (i != 0)
                {
                    layoutparams.leftMargin = k;
                }
                if (i != l - 1)
                {
                    layoutparams.rightMargin = k;
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

    public void clearDraft()
    {
        composeMsgView.setText("");
        isSendingMessage = false;
        photosScroll.setVisibility(8);
        photosLayout.removeAllViews();
        photoUrls.clear();
    }

    public EditText getComposeEditText()
    {
        return composeMsgView;
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

    public boolean isDraftInProgress()
    {
        return !TextUtils.isEmpty(getMessage()) || !photoUrls.isEmpty();
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        imageCache = new ImageCache(getActivity());
        updatePhotosLayout();
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

    public void onClick(View view)
    {
        if (onClickListener != null)
        {
            onClickListener.onClick(getView());
        }
        int i = view.getId();
        if (i == 0x7f100152)
        {
            send();
        } else
        if (i == 0x7f100150)
        {
            attachPhotos();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setRetainInstance(true);
        Bundle bundle1 = getArguments();
        if (bundle1 != null)
        {
            startingText = bundle1.getString("param_in_text");
            photoUrls = bundle1.getStringArrayList("param_picture_urls");
            callerContext = bundle1.getBundle("param_caller_context");
            showSend = bundle1.getBoolean("param_show_send", true);
            inDialog = bundle1.getBoolean("param_compose_in_dialog", false);
        }
        if (bundle != null)
        {
            isSendingMessage = bundle1.getBoolean("instanceStateSendingMessage");
            photoUrls = bundle1.getStringArrayList("instanceStatePhotoUrls");
        }
        if (photoUrls == null)
        {
            photoUrls = new ArrayList();
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = layoutinflater;
        if (!inDialog)
        {
            viewgroup = LayoutInflater.from(new ContextThemeWrapper(layoutinflater.getContext(), 0x7f0a0279));
        }
        layoutinflater = viewgroup.inflate(0x7f03007e, null);
        sendButton = (ImageView)layoutinflater.findViewById(0x7f100152);
        sendButton.setOnClickListener(this);
        viewgroup = sendButton;
        int i;
        if (showSend)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        viewgroup.setVisibility(i);
        layoutinflater.findViewById(0x7f100150).setOnClickListener(this);
        photosScroll = (HorizontalScrollView)layoutinflater.findViewById(0x7f100153);
        photosLayout = (LinearLayout)layoutinflater.findViewById(0x7f100154);
        composeMsgView = (EditText)layoutinflater.findViewById(0x7f100151);
        composeMsgView.setOnClickListener(this);
        composeMsgView.addTextChangedListener(new TextWatcher() {

            final ComposeMessageFragment this$0;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int j, int k, int l)
            {
            }

            public void onTextChanged(CharSequence charsequence, int j, int k, int l)
            {
                ComposeMessageFragment composemessagefragment = ComposeMessageFragment.this;
                boolean flag;
                if (!isSendingMessage && charsequence.length() > 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                composemessagefragment.setSendEnabled(flag);
            }

            
            {
                this$0 = ComposeMessageFragment.this;
                super();
            }
        });
        composeMsgView.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            final ComposeMessageFragment this$0;

            public void onFocusChange(View view, boolean flag)
            {
                Object obj = getActivity();
                if (obj != null)
                {
                    obj = (InputMethodManager)((Activity) (obj)).getSystemService("input_method");
                    if (flag)
                    {
                        ((InputMethodManager) (obj)).showSoftInput(view, 1);
                    } else
                    {
                        ((InputMethodManager) (obj)).hideSoftInputFromWindow(view.getWindowToken(), 0);
                    }
                }
                if (flag && onClickListener != null)
                {
                    onClickListener.onClick(getView());
                }
            }

            
            {
                this$0 = ComposeMessageFragment.this;
                super();
            }
        });
        if (TextUtils.isEmpty(startingText))
        {
            setSendEnabled(false);
            return layoutinflater;
        } else
        {
            composeMsgView.setText(startingText);
            composeMsgView.setSelection(0);
            setSendEnabled(true);
            return layoutinflater;
        }
    }

    public void onDestroyView()
    {
        sendButton = null;
        photosScroll = null;
        photosLayout = null;
        composeMsgView = null;
        imageCache = null;
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("instanceStateSendingMessage", isSendingMessage);
        bundle.putStringArrayList("instanceStatePhotoUrls", photoUrls);
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        onClickListener = onclicklistener;
    }

    public void setSendEnabled(boolean flag)
    {
        char c = '\377';
        sendButton.setEnabled(flag);
        if (flag)
        {
            isSendingMessage = false;
        }
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            ImageView imageview = sendButton;
            if (!flag)
            {
                c = '\200';
            }
            setAlpha(imageview, c);
            return;
        }
        ImageView imageview1 = sendButton;
        if (!flag)
        {
            c = '\200';
        }
        setImageAlpha(imageview1, c);
    }

    public void startDraft()
    {
        View view = getView();
        if (view != null)
        {
            Util.forceEditTextFocus(view);
        }
    }


}
