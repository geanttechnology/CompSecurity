// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            GrouponDialogCustomViewListener, GrouponDialogListener

public class GrouponDialogFragment extends DialogFragment
{

    public static final String DIALOG_CUSTOM_VIEW_RES_ID = "dialog_custom_view_res_id";
    public static final String DIALOG_ITEMS = "dialog_items";
    public static final String DIALOG_MESSAGE = "dialog_message";
    public static final String DIALOG_MESSAGE_RES_ID = "dialog_message_res_id";
    public static final String DIALOG_MULTI_CHOICE_CHECKED_ITEMS = "dialog_multi_choice_checked_items";
    public static final String DIALOG_MULTI_CHOICE_ITEMS = "dialog_multi_choice_items";
    public static final String DIALOG_NEGATIVE_BUTTON_TEXT = "dialog_negative_button_text";
    public static final String DIALOG_NEGATIVE_BUTTON_TEXT_RES_ID = "dialog_negative_button_text_res_id";
    public static final String DIALOG_POSITIVE_BUTTON_AUTO_DISMISS = "dialog_positive_button_auto_dismiss";
    public static final String DIALOG_POSITIVE_BUTTON_TEXT = "dialog_positive_button_text";
    public static final String DIALOG_POSITIVE_BUTTON_TEXT_RES_ID = "dialog_positive_button_text_res_id";
    public static final String DIALOG_SCREEN_SHOT = "dialog_screen_shot";
    public static final String DIALOG_SINGLE_CHOICE_CHECKED_ITEM = "dialog_single_choice_checked_item";
    public static final String DIALOG_SINGLE_CHOICE_ITEMS = "dialog_single_choice_items";
    public static final String DIALOG_TAG = "dialog_tag";
    public static final String DIALOG_TITLE = "dialog_title";
    public static final String DIALOG_TITLE_RES_ID = "dialog_title_res_id";
    private View customView;
    private GrouponDialogCustomViewListener listener;

    public GrouponDialogFragment()
    {
    }

    public GrouponDialogFragment(GrouponDialogCustomViewListener groupondialogcustomviewlistener)
    {
        listener = groupondialogcustomviewlistener;
    }

    public GrouponDialogFragment(String s, String s1)
    {
        Bundle bundle = new Bundle();
        bundle.putString("dialog_title", s);
        bundle.putString("dialog_screen_shot", s1);
        setArguments(bundle);
    }

    public static void show(FragmentManager fragmentmanager, GrouponDialogFragment groupondialogfragment, String s)
    {
        if (groupondialogfragment != null)
        {
            groupondialogfragment.getArguments().putString("dialog_tag", s);
            groupondialogfragment.show(fragmentmanager, s);
        }
    }

    public View getCustomView()
    {
        return ((FrameLayout)getDialog().getWindow().findViewById(0x7f100132)).getChildAt(0);
    }

    protected GrouponDialogCustomViewListener getCustomViewListener()
    {
        if (listener != null)
        {
            return listener;
        }
        if (getActivity() instanceof GrouponDialogCustomViewListener)
        {
            return (GrouponDialogCustomViewListener)getActivity();
        } else
        {
            return null;
        }
    }

    protected GrouponDialogListener getListener()
    {
        if (listener != null && (listener instanceof GrouponDialogListener))
        {
            return (GrouponDialogListener)listener;
        }
        if (getActivity() instanceof GrouponDialogListener)
        {
            return (GrouponDialogListener)getActivity();
        } else
        {
            return null;
        }
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        GrouponDialogListener groupondialoglistener = getListener();
        if (groupondialoglistener != null)
        {
            groupondialoglistener.onDialogCancel(getArguments().getString("dialog_tag", null), dialoginterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        Bundle bundle1 = getArguments();
        if (bundle1 == null)
        {
            return null;
        }
        CharSequence charsequence = bundle1.getCharSequence("dialog_title");
        int i = bundle1.getInt("dialog_title_res_id");
        String s1 = bundle1.getString("dialog_message");
        int j = bundle1.getInt("dialog_message_res_id");
        int k = bundle1.getInt("dialog_custom_view_res_id");
        bundle = bundle1.getString("dialog_positive_button_text");
        int l = bundle1.getInt("dialog_positive_button_text_res_id");
        boolean flag = bundle1.getBoolean("dialog_positive_button_auto_dismiss", true);
        String s = bundle1.getString("dialog_negative_button_text");
        int i1 = bundle1.getInt("dialog_negative_button_text_res_id");
        String as[] = bundle1.getStringArray("dialog_items");
        String as1[] = bundle1.getStringArray("dialog_single_choice_items");
        int j1 = bundle1.getInt("dialog_single_choice_checked_item");
        String as2[] = bundle1.getStringArray("dialog_multi_choice_items");
        boolean aflag[] = bundle1.getBooleanArray("dialog_multi_choice_checked_items");
        GrouponAlertDialog.Builder builder = new GrouponAlertDialog.Builder(getActivity());
        if (Strings.notEmpty(charsequence))
        {
            builder.setTitle(charsequence);
        } else
        if (i != 0)
        {
            builder.setTitle(i);
        }
        if (Strings.notEmpty(s1))
        {
            builder.setMessage(s1);
        } else
        if (j != 0)
        {
            builder.setMessage(j);
        }
        if (k != 0)
        {
            builder.setView(getActivity().getLayoutInflater().inflate(k, null));
        } else
        if (customView != null)
        {
            builder.setView(customView);
        } else
        {
            Object obj = getCustomViewListener();
            if (obj != null)
            {
                obj = ((GrouponDialogCustomViewListener) (obj)).getDialogCustomView(getArguments().getString("dialog_tag", null));
                if (obj != null)
                {
                    builder.setView(((View) (obj)));
                }
            }
        }
        if (as != null && as.length > 0)
        {
            builder.setItems(as, new android.content.DialogInterface.OnClickListener() {

                final GrouponDialogFragment this$0;

                public void onClick(DialogInterface dialoginterface, int k1)
                {
                    GrouponDialogListener groupondialoglistener = getListener();
                    if (groupondialoglistener != null)
                    {
                        groupondialoglistener.onDialogItemClick(getArguments().getString("dialog_tag", null), dialoginterface, k1);
                    }
                }

            
            {
                this$0 = GrouponDialogFragment.this;
                super();
            }
            });
        }
        if (as1 != null && as1.length > 0)
        {
            builder.setSingleChoiceItems(as1, j1, new android.content.DialogInterface.OnClickListener() {

                final GrouponDialogFragment this$0;

                public void onClick(DialogInterface dialoginterface, int k1)
                {
                    GrouponDialogListener groupondialoglistener = getListener();
                    if (groupondialoglistener != null)
                    {
                        groupondialoglistener.onDialogItemClick(getArguments().getString("dialog_tag", null), dialoginterface, k1);
                    }
                }

            
            {
                this$0 = GrouponDialogFragment.this;
                super();
            }
            });
        }
        if (as2 != null && as2.length > 0)
        {
            builder.setMultiChoiceItems(as2, aflag, new android.content.DialogInterface.OnMultiChoiceClickListener() {

                final GrouponDialogFragment this$0;

                public void onClick(DialogInterface dialoginterface, int k1, boolean flag1)
                {
                    GrouponDialogListener groupondialoglistener = getListener();
                    if (groupondialoglistener != null)
                    {
                        groupondialoglistener.onDialogMultiChoiceItemClick(getArguments().getString("dialog_tag", null), dialoginterface, k1, flag1);
                    }
                }

            
            {
                this$0 = GrouponDialogFragment.this;
                super();
            }
            });
        }
        if (Strings.notEmpty(bundle))
        {
            builder.setPositiveButton(bundle, new android.content.DialogInterface.OnClickListener() {

                final GrouponDialogFragment this$0;

                public void onClick(DialogInterface dialoginterface, int k1)
                {
                    GrouponDialogListener groupondialoglistener = getListener();
                    if (groupondialoglistener != null)
                    {
                        groupondialoglistener.onDialogPositiveButtonClick(getArguments().getString("dialog_tag", null), dialoginterface);
                    }
                }

            
            {
                this$0 = GrouponDialogFragment.this;
                super();
            }
            });
        } else
        if (l != 0)
        {
            builder.setPositiveButton(l, new android.content.DialogInterface.OnClickListener() {

                final GrouponDialogFragment this$0;

                public void onClick(DialogInterface dialoginterface, int k1)
                {
                    GrouponDialogListener groupondialoglistener = getListener();
                    if (groupondialoglistener != null)
                    {
                        groupondialoglistener.onDialogPositiveButtonClick(getArguments().getString("dialog_tag", null), dialoginterface);
                    }
                }

            
            {
                this$0 = GrouponDialogFragment.this;
                super();
            }
            });
        }
        builder.setAutoDismissOnPositiveButtonClick(flag);
        if (Strings.notEmpty(s))
        {
            builder.setNegativeButton(s, new android.content.DialogInterface.OnClickListener() {

                final GrouponDialogFragment this$0;

                public void onClick(DialogInterface dialoginterface, int k1)
                {
                    GrouponDialogListener groupondialoglistener = getListener();
                    if (groupondialoglistener != null)
                    {
                        groupondialoglistener.onDialogNegativeButtonClick(getArguments().getString("dialog_tag", null), dialoginterface);
                    }
                }

            
            {
                this$0 = GrouponDialogFragment.this;
                super();
            }
            });
        } else
        if (i1 != 0)
        {
            builder.setNegativeButton(i1, new android.content.DialogInterface.OnClickListener() {

                final GrouponDialogFragment this$0;

                public void onClick(DialogInterface dialoginterface, int k1)
                {
                    GrouponDialogListener groupondialoglistener = getListener();
                    if (groupondialoglistener != null)
                    {
                        groupondialoglistener.onDialogNegativeButtonClick(getArguments().getString("dialog_tag", null), dialoginterface);
                    }
                }

            
            {
                this$0 = GrouponDialogFragment.this;
                super();
            }
            });
        }
        bundle = builder.create();
        bundle.setOnShowListener(new android.content.DialogInterface.OnShowListener() {

            final GrouponDialogFragment this$0;

            public void onShow(DialogInterface dialoginterface)
            {
                GrouponDialogListener groupondialoglistener = getListener();
                if (groupondialoglistener != null)
                {
                    groupondialoglistener.onDialogShown(getArguments().getString("dialog_tag", null), dialoginterface);
                }
            }

            
            {
                this$0 = GrouponDialogFragment.this;
                super();
            }
        });
        return bundle;
    }

    public void setCustomView(View view)
    {
        customView = view;
    }
}
