// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.comcast.cim.android.view.launch.LaunchStrategy;
import com.comcast.cim.cmasl.android.util.system.AndroidDevice;
import com.comcast.cim.container.CALContainer;
import com.comcast.cim.model.user.UserManager;
import com.comcast.cim.utils.AppLauncher;
import java.util.Iterator;
import java.util.List;

public class CALDialogFragment extends DialogFragment
{
    public static class CDFButton
    {

        android.content.DialogInterface.OnClickListener onClickListener;
        String text;

        public CDFButton(String s, android.content.DialogInterface.OnClickListener onclicklistener)
        {
            text = s;
            onClickListener = onclicklistener;
        }
    }

    public static interface TryAgainListener
    {

        public abstract void tryAgain();
    }


    private final AndroidDevice androidDevice = CALContainer.getInstance().getAndroidDevice();
    private final AppLauncher appLauncher = CALContainer.getInstance().getAppLauncher();
    private LinearLayout buttonLayout;
    protected List buttonList;
    private LayoutInflater inflater;
    private final LaunchStrategy launchStrategy = CALContainer.getInstance().getLaunchStrategy();
    android.content.DialogInterface.OnCancelListener onCancelListener;
    android.content.DialogInterface.OnDismissListener onDismissListener;
    private TryAgainListener tryAgainListener;
    private final UserManager userManager = CALContainer.getInstance().getUserManager();

    public CALDialogFragment()
    {
    }

    private Button addButton(ViewGroup viewgroup, final int buttonNum, final CDFButton button)
    {
        return addButton(viewgroup, button.text, new android.view.View.OnClickListener() {

            final CALDialogFragment this$0;
            final CDFButton val$button;
            final int val$buttonNum;

            public void onClick(View view)
            {
                if (button.onClickListener != null)
                {
                    button.onClickListener.onClick(getDialog(), buttonNum);
                }
                dismiss();
            }

            
            {
                this$0 = CALDialogFragment.this;
                button = cdfbutton;
                buttonNum = i;
                super();
            }
        });
    }

    private Button addButton(ViewGroup viewgroup, String s, android.view.View.OnClickListener onclicklistener)
    {
        if (viewgroup.getChildCount() > 0)
        {
            View view = new View(viewgroup.getContext());
            view.setLayoutParams(new android.widget.LinearLayout.LayoutParams(1, -1));
            view.setBackgroundResource(com.comcast.cim.android.R.color.MediumGray);
            viewgroup.addView(view);
        }
        Button button = (Button)inflater.inflate(com.comcast.cim.android.R.layout.caldialogfragment_button, viewgroup, false);
        button.setText(s);
        button.setOnClickListener(onclicklistener);
        viewgroup.addView(button);
        return button;
    }

    private void copyViewText(Context context, TextView textview)
    {
        ((ClipboardManager)context.getSystemService("clipboard")).setText(textview.getText());
        Toast.makeText(context, context.getResources().getString(com.comcast.cim.android.R.string.toast_copied), 0).show();
    }

    private View createDefaultErrorDialogView(View view, Bundle bundle)
    {
        setMoreInfoButton(view, bundle);
        addButton(buttonLayout, getResources().getString(com.comcast.cim.android.R.string.dlg_btn_ok), new android.view.View.OnClickListener() {

            final CALDialogFragment this$0;

            public void onClick(View view1)
            {
                getDialog().cancel();
            }

            
            {
                this$0 = CALDialogFragment.this;
                super();
            }
        });
        return view;
    }

    private View createRetryableErrorDialogView(String s, View view, Bundle bundle)
    {
        setMoreInfoButton(view, bundle);
        if (s.equals("errorDlgRetryIgnore"))
        {
            s = getResources().getString(com.comcast.cim.android.R.string.dlg_btn_ignore);
        } else
        {
            s = getResources().getString(com.comcast.cim.android.R.string.dlg_btn_cancel);
        }
        addButton(buttonLayout, s, new android.view.View.OnClickListener() {

            final CALDialogFragment this$0;

            public void onClick(View view1)
            {
                getDialog().cancel();
            }

            
            {
                this$0 = CALDialogFragment.this;
                super();
            }
        });
        if (tryAgainListener != null)
        {
            addButton(buttonLayout, getResources().getString(com.comcast.cim.android.R.string.dlg_btn_try_again), new android.view.View.OnClickListener() {

                final CALDialogFragment this$0;

                public void onClick(View view1)
                {
                    tryAgainListener.tryAgain();
                    dismiss();
                }

            
            {
                this$0 = CALDialogFragment.this;
                super();
            }
            });
        }
        return view;
    }

    public static CALDialogFragment newInstance(String s)
    {
        Bundle bundle = new Bundle();
        bundle.putString("tag", s);
        s = new CALDialogFragment();
        s.setArguments(bundle);
        return s;
    }

    private void setMessage(View view, String s)
    {
        view = (TextView)view.findViewById(com.comcast.cim.android.R.id.txt1);
        if (view != null && s != null)
        {
            view.setText(s);
            view.setVisibility(0);
        } else
        if (view != null)
        {
            view.setVisibility(8);
            return;
        }
    }

    private void setMoreInfoButton(final View stackTrace, Bundle bundle)
    {
        bundle = bundle.getString("additionalInfo");
        if (bundle != null && bundle.length() > 0)
        {
            stackTrace = (TextView)stackTrace.findViewById(com.comcast.cim.android.R.id.txt2);
            stackTrace.setText(bundle);
            stackTrace.setMovementMethod(new ScrollingMovementMethod());
            addButton(buttonLayout, getResources().getString(com.comcast.cim.android.R.string.dlg_btn_more_info), new android.view.View.OnClickListener() {

                final CALDialogFragment this$0;
                final TextView val$stackTrace;

                public void onClick(View view)
                {
                    stackTrace.setVisibility(0);
                    ((Button)view).setText(getResources().getString(com.comcast.cim.android.R.string.dlg_btn_copy_info));
                    view.setOnClickListener(new android.view.View.OnClickListener() {

                        final _cls12 this$1;

                        public void onClick(View view)
                        {
                            copyViewText(view.getContext(), stackTrace);
                        }

            
            {
                this$1 = _cls12.this;
                super();
            }
                    });
                }

            
            {
                this$0 = CALDialogFragment.this;
                stackTrace = textview;
                super();
            }
            });
            stackTrace.setOnLongClickListener(new android.view.View.OnLongClickListener() {

                final CALDialogFragment this$0;

                public boolean onLongClick(View view)
                {
                    copyViewText(view.getContext(), (TextView)view);
                    return true;
                }

            
            {
                this$0 = CALDialogFragment.this;
                super();
            }
            });
        }
    }

    public void addArguments(Bundle bundle)
    {
        Bundle bundle1 = getArguments();
        if (bundle1 == null)
        {
            setArguments(bundle);
            return;
        } else
        {
            bundle1.putAll(bundle);
            return;
        }
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        if (onCancelListener != null)
        {
            onCancelListener.onCancel(dialoginterface);
        }
        getFragmentManager().beginTransaction().remove(this).commit();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null && bundle.getBoolean("dismissOnOrientationChange", false))
        {
            dismiss();
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        final Object args;
        Object obj;
        Object obj1;
        inflater = layoutinflater;
        if (androidDevice.isKindle())
        {
            getDialog().getWindow().addFlags(1024);
        }
        args = getArguments();
        obj = layoutinflater.inflate(com.comcast.cim.android.R.layout.dlg_default, viewgroup, false);
        buttonLayout = (LinearLayout)((View) (obj)).findViewById(com.comcast.cim.android.R.id.button_layout);
        setTitle(((Bundle) (args)).getString("title"), ((View) (obj)));
        setMessage(((View) (obj)), ((Bundle) (args)).getString("description"));
        obj1 = ((Bundle) (args)).getString("tag");
        if (!((String) (obj1)).equals("errorDlg")) goto _L2; else goto _L1
_L1:
        args = createDefaultErrorDialogView(((View) (obj)), ((Bundle) (args)));
_L4:
        if (buttonList != null)
        {
            int i = 1;
            for (obj = buttonList.iterator(); ((Iterator) (obj)).hasNext();)
            {
                obj1 = (CDFButton)((Iterator) (obj)).next();
                addButton(buttonLayout, i, ((CDFButton) (obj1)));
                i++;
            }

        }
        break; /* Loop/switch isn't completed */
_L2:
        if (((String) (obj1)).equals("errorDlgXipProvisioning"))
        {
            addButton(buttonLayout, getResources().getString(com.comcast.cim.android.R.string.dlg_btn_sign_out), new android.view.View.OnClickListener() {

                final CALDialogFragment this$0;

                public void onClick(View view)
                {
                    dismiss();
                    userManager.signOutUser();
                    launchStrategy.restartAppFlow(view.getContext());
                }

            
            {
                this$0 = CALDialogFragment.this;
                super();
            }
            });
            args = obj;
        } else
        if (((String) (obj1)).equals("errorDlgRetryable") || ((String) (obj1)).equals("errorDlgRetryIgnore"))
        {
            args = createRetryableErrorDialogView(((String) (obj1)), ((View) (obj)), ((Bundle) (args)));
        } else
        if (((String) (obj1)).equals("openAnotherAppDlg"))
        {
            setMessage(((View) (obj)), getResources().getString(com.comcast.cim.android.R.string.alert_launch_another_application));
            addButton(buttonLayout, getResources().getString(com.comcast.cim.android.R.string.dlg_btn_ok), new android.view.View.OnClickListener() {

                final CALDialogFragment this$0;
                final Bundle val$args;

                public void onClick(View view)
                {
                    dismiss();
                    if (args.containsKey("uri"))
                    {
                        view = (Uri)args.getParcelable("uri");
                        appLauncher.startUri(view, getActivity());
                        return;
                    } else
                    {
                        view = args.getString("packageName");
                        appLauncher.startApplication(view, getActivity());
                        return;
                    }
                }

            
            {
                this$0 = CALDialogFragment.this;
                args = bundle;
                super();
            }
            });
            addButton(buttonLayout, getResources().getString(com.comcast.cim.android.R.string.dlg_btn_cancel), new android.view.View.OnClickListener() {

                final CALDialogFragment this$0;

                public void onClick(View view)
                {
                    dismiss();
                }

            
            {
                this$0 = CALDialogFragment.this;
                super();
            }
            });
            args = obj;
        } else
        if (((String) (obj1)).equals("hsdPromptDlg"))
        {
            setMessage(((View) (obj)), getResources().getString(com.comcast.cim.android.R.string.HAVE_HIGH_SPEED_INTERNET_QUESTION));
            addButton(buttonLayout, getResources().getString(com.comcast.cim.android.R.string.dlg_btn_yes), new android.view.View.OnClickListener() {

                final CALDialogFragment this$0;

                public void onClick(View view)
                {
                    dismiss();
                    view = new Bundle();
                    view.putParcelable("uri", Uri.parse(getResources().getString(com.comcast.cim.android.R.string.URL_LOOKUP_ID)));
                    CALDialogFragment caldialogfragment = CALDialogFragment.newInstance("openAnotherAppDlg");
                    caldialogfragment.addArguments(view);
                    caldialogfragment.show(getFragmentManager(), "openAnotherAppDlg");
                }

            
            {
                this$0 = CALDialogFragment.this;
                super();
            }
            });
            addButton(buttonLayout, getResources().getString(com.comcast.cim.android.R.string.dlg_btn_no), new android.view.View.OnClickListener() {

                final CALDialogFragment this$0;

                public void onClick(View view)
                {
                    dismiss();
                    view = new Bundle();
                    view.putParcelable("uri", Uri.parse(getResources().getString(com.comcast.cim.android.R.string.URL_NEEDID)));
                    CALDialogFragment caldialogfragment = CALDialogFragment.newInstance("openAnotherAppDlg");
                    caldialogfragment.addArguments(view);
                    caldialogfragment.show(getFragmentManager(), "openAnotherAppDlg");
                }

            
            {
                this$0 = CALDialogFragment.this;
                super();
            }
            });
            args = obj;
        } else
        if (((String) (obj1)).equals("messageDlg"))
        {
            addButton(buttonLayout, getResources().getString(com.comcast.cim.android.R.string.dlg_btn_ok), new android.view.View.OnClickListener() {

                final CALDialogFragment this$0;

                public void onClick(View view)
                {
                    dismiss();
                }

            
            {
                this$0 = CALDialogFragment.this;
                super();
            }
            });
            args = obj;
        } else
        {
            args = obj;
            if (((String) (obj1)).equals("cancelableMessageDlg"))
            {
                addButton(buttonLayout, getResources().getString(com.comcast.cim.android.R.string.dlg_btn_ok), new android.view.View.OnClickListener() {

                    final CALDialogFragment this$0;

                    public void onClick(View view)
                    {
                        dismiss();
                    }

            
            {
                this$0 = CALDialogFragment.this;
                super();
            }
                });
                addButton(buttonLayout, getResources().getString(com.comcast.cim.android.R.string.dlg_btn_cancel), new android.view.View.OnClickListener() {

                    final CALDialogFragment this$0;

                    public void onClick(View view)
                    {
                        getDialog().cancel();
                    }

            
            {
                this$0 = CALDialogFragment.this;
                super();
            }
                });
                args = obj;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (args != null)
        {
            return ((View) (args));
        } else
        {
            return super.onCreateView(layoutinflater, viewgroup, bundle);
        }
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        if (onDismissListener != null)
        {
            onDismissListener.onDismiss(dialoginterface);
        }
    }

    public void onResume()
    {
        super.onResume();
        getDialog().getWindow().setLayout(getResources().getDimensionPixelSize(com.comcast.cim.android.R.dimen.dialog_default_width), -2);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        if (onDismissListener != null || onCancelListener != null || tryAgainListener != null || getArguments() != null && getArguments().getBoolean("dismissOnOrientationChange", false))
        {
            bundle.putBoolean("dismissOnOrientationChange", true);
        }
    }

    public void setButtonList(List list)
    {
        buttonList = list;
    }

    public void setOnCancelListener(android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        onCancelListener = oncancellistener;
    }

    public void setOnDismissListener(android.content.DialogInterface.OnDismissListener ondismisslistener)
    {
        onDismissListener = ondismisslistener;
    }

    void setTitle(String s, View view)
    {
        boolean flag = false;
        if (s != null)
        {
            getDialog().setTitle(s);
            flag = true;
        } else
        if (getArguments().getString("tag").contains("errorDlg"))
        {
            getDialog().setTitle(getResources().getString(com.comcast.cim.android.R.string.dlg_title_error));
            flag = true;
        } else
        {
            getDialog().getWindow().requestFeature(1);
            view.findViewById(com.comcast.cim.android.R.id.divider).setVisibility(8);
        }
        if (flag && androidDevice.isKindleOrFromAmazonStore())
        {
            s = view.findViewById(com.comcast.cim.android.R.id.divider);
            s.setBackgroundResource(com.comcast.cim.android.R.color.light_blue);
            s.getLayoutParams().height = (int)TypedValue.applyDimension(1, 2.0F, getResources().getDisplayMetrics());
        }
    }

    public void setTryAgainListener(TryAgainListener tryagainlistener)
    {
        tryAgainListener = tryagainlistener;
    }





}
