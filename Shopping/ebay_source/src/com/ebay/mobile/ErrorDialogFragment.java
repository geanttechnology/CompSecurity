// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView;
import android.widget.TextView;
import com.ebay.android.widget.MessageBar;

public class ErrorDialogFragment extends DialogFragment
{
    private final class FloaterDialog extends Dialog
        implements android.view.View.OnClickListener, android.view.animation.Animation.AnimationListener
    {

        private boolean dismissed;
        private boolean retry;
        private Animation runningAnimation;
        final ErrorDialogFragment this$0;

        public void cancel()
        {
            if (!dismissed)
            {
                if (runningAnimation != null)
                {
                    runningAnimation.cancel();
                }
                dismissed = true;
                retry = false;
                if (!startAnimation(false))
                {
                    super.cancel();
                    return;
                }
            }
        }

        public void onAnimationEnd(Animation animation)
        {
            runningAnimation = null;
            animation = floaterView;
            if (animation != null)
            {
                animation.setAnimation(null);
            }
            if (dismissed)
            {
                if (animation != null)
                {
                    animation.setVisibility(8);
                }
                dismissAllowingStateLoss();
                dismissMessage(retry);
            }
        }

        public void onAnimationRepeat(Animation animation)
        {
        }

        public void onAnimationStart(Animation animation)
        {
            runningAnimation = animation;
        }

        public void onClick(View view)
        {
            boolean flag = true;
            if (!dismissed)
            {
                if (runningAnimation != null)
                {
                    runningAnimation.cancel();
                }
                dismissed = true;
                if (view.getId() != 0x7f100195)
                {
                    flag = false;
                }
                retry = flag;
                if (!startAnimation(false))
                {
                    super.dismiss();
                    return;
                }
            }
        }

        public boolean startAnimation(boolean flag)
        {
            int j = 0;
            View view = floaterView;
            if (view == null)
            {
                return false;
            }
            Object obj;
            TranslateAnimation translateanimation;
            int i;
            if (flag)
            {
                i = -1;
            } else
            {
                i = 0;
            }
            if (!flag)
            {
                j = -1;
            }
            translateanimation = new TranslateAnimation(1, 0, 1, 0, 1, i, 1, j);
            translateanimation.setAnimationListener(this);
            translateanimation.setDuration(500L);
            if (flag)
            {
                obj = new DecelerateInterpolator();
            } else
            {
                obj = new AccelerateInterpolator();
            }
            translateanimation.setInterpolator(((android.view.animation.Interpolator) (obj)));
            translateanimation.setStartTime(AnimationUtils.currentAnimationTimeMillis());
            view.startAnimation(translateanimation);
            return true;
        }

        public FloaterDialog(Context context, int i)
        {
            this$0 = ErrorDialogFragment.this;
            super(context, i);
        }
    }

    private final class Listener
        implements android.content.DialogInterface.OnClickListener
    {

        final ErrorDialogFragment this$0;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            dialoginterface = ErrorDialogFragment.this;
            boolean flag;
            if (i == -1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            dialoginterface.dismissMessage(flag);
        }

        private Listener()
        {
            this$0 = ErrorDialogFragment.this;
            super();
        }

    }

    public static interface OnDismissMessageListener
    {

        public abstract void onDismissMessage(int i, boolean flag);
    }


    public static final String EXTRA_ALLOW_RETRY = "allowRetry";
    public static final String EXTRA_AS_MESSAGE_BAR = "asMessageBar";
    public static final String EXTRA_ERROR_CODE = "errorCode";
    public static final String EXTRA_ID = "id";
    public static final String EXTRA_IS_ERROR = "isError";
    public static final String EXTRA_MESSAGE = "message";
    public static final String EXTRA_TITLE = "title";
    View floaterView;

    public ErrorDialogFragment()
    {
    }

    private View createFloaterBar(FloaterDialog floaterdialog, LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        Object obj1 = getArguments();
        Object obj = null;
        boolean flag1 = false;
        boolean flag = false;
        if (obj1 != null)
        {
            obj = ((Bundle) (obj1)).get("message");
            flag1 = ((Bundle) (obj1)).getBoolean("isError");
            flag = ((Bundle) (obj1)).getBoolean("allowRetry");
        }
        layoutinflater = layoutinflater.inflate(0x7f030098, viewgroup, false);
        Object obj2 = layoutinflater.findViewById(0x7f100194);
        viewgroup = ((View) (obj2)).findViewById(0x7f100196);
        obj1 = ((View) (obj2)).findViewById(0x7f100195);
        floaterView = ((View) (obj2));
        viewgroup.setOnClickListener(floaterdialog);
        ((View) (obj1)).setOnClickListener(floaterdialog);
        obj2 = (TextView)layoutinflater.findViewById(0x7f10018f);
        int i;
        if (obj instanceof Integer)
        {
            ((TextView) (obj2)).setText(((Integer)obj).intValue());
        } else
        {
            ((TextView) (obj2)).setText((String)obj);
        }
        if (layoutinflater instanceof MessageBar)
        {
            ((MessageBar)layoutinflater).setError(flag1);
        }
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((View) (obj1)).setVisibility(i);
        if (flag)
        {
            i = 8;
        } else
        {
            i = 0;
        }
        viewgroup.setVisibility(i);
        if (bundle == null)
        {
            floaterdialog.startAnimation(true);
        }
        return layoutinflater;
    }

    private View createView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        Bundle bundle1 = getArguments();
        Object obj = null;
        bundle = null;
        boolean flag = false;
        if (bundle1 != null)
        {
            obj = bundle1.get("message");
            bundle = ((Bundle) (bundle1.get("errorCode")));
            flag = isHtml(obj);
        }
        int i;
        if (flag)
        {
            i = 0x7f030099;
        } else
        {
            i = 0x7f030097;
        }
        layoutinflater = layoutinflater.inflate(i, viewgroup, false);
        if (flag)
        {
            ((WebView)layoutinflater.findViewById(0x7f100190)).loadData((String)obj, "text/html", "utf-8");
        } else
        {
            viewgroup = (TextView)layoutinflater.findViewById(0x7f10018f);
            if (obj instanceof Integer)
            {
                viewgroup.setText(((Integer)obj).intValue());
            } else
            {
                viewgroup.setText((String)obj);
            }
        }
        if (bundle == null)
        {
            layoutinflater.findViewById(0x7f100191).setVisibility(8);
            return layoutinflater;
        } else
        {
            ((TextView)layoutinflater.findViewById(0x7f100193)).setText(bundle.toString());
            return layoutinflater;
        }
    }

    private boolean isHtml(Object obj)
    {
        return (obj instanceof String) && obj.toString().contains("</");
    }

    final void dismissMessage(boolean flag)
    {
        int i = -1;
        Object obj = getArguments();
        if (obj != null)
        {
            i = ((Bundle) (obj)).getInt("id", -1);
        }
        obj = getActivity();
        if (!((Activity) (obj)).isFinishing())
        {
            android.app.Fragment fragment = getTargetFragment();
            if (fragment instanceof OnDismissMessageListener)
            {
                ((OnDismissMessageListener)fragment).onDismissMessage(i, flag);
            } else
            if (obj instanceof OnDismissMessageListener)
            {
                ((OnDismissMessageListener)obj).onDismissMessage(i, flag);
                return;
            }
        }
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        super.onCancel(dialoginterface);
        dismissMessage(false);
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        Object obj;
        Object obj1;
        Object obj2;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        Bundle bundle1 = getArguments();
        obj2 = null;
        obj1 = null;
        obj = null;
        flag2 = false;
        flag = false;
        flag1 = false;
        flag3 = false;
        if (bundle1 != null)
        {
            Object obj3 = bundle1.get("title");
            Object obj4 = bundle1.get("message");
            Object obj5 = bundle1.get("errorCode");
            boolean flag4 = bundle1.getBoolean("isError");
            boolean flag5 = bundle1.getBoolean("allowRetry");
            boolean flag6 = bundle1.getBoolean("asMessageBar");
            boolean flag7 = isHtml(obj4);
            if (obj3 != null && !(obj3 instanceof Integer) && !(obj3 instanceof String))
            {
                throw new IllegalArgumentException((new StringBuilder()).append("EXTRA_TITLE is ").append(obj3.getClass()).toString());
            }
            if (obj4 != null && !(obj4 instanceof Integer) && !(obj4 instanceof String))
            {
                throw new IllegalArgumentException((new StringBuilder()).append("EXTRA_MESSAGE is ").append(obj4.getClass()).toString());
            }
            flag = flag5;
            flag1 = flag6;
            obj = obj5;
            flag2 = flag4;
            flag3 = flag7;
            obj1 = obj4;
            obj2 = obj3;
            if (obj5 != null)
            {
                flag = flag5;
                flag1 = flag6;
                obj = obj5;
                flag2 = flag4;
                flag3 = flag7;
                obj1 = obj4;
                obj2 = obj3;
                if (!(obj5 instanceof Integer))
                {
                    flag = flag5;
                    flag1 = flag6;
                    obj = obj5;
                    flag2 = flag4;
                    flag3 = flag7;
                    obj1 = obj4;
                    obj2 = obj3;
                    if (!(obj5 instanceof String))
                    {
                        throw new IllegalArgumentException((new StringBuilder()).append("EXTRA_ERROR_CODE is ").append(obj5.getClass()).toString());
                    }
                }
            }
        }
        if (!flag3) goto _L2; else goto _L1
_L1:
        setStyle(1, getTheme());
        obj = new android.support.v7.app.AlertDialog.Builder(new ContextThemeWrapper(getActivity(), 0x7f0a0280), getTheme());
        ((android.support.v7.app.AlertDialog.Builder) (obj)).setView(createView(LayoutInflater.from(((android.support.v7.app.AlertDialog.Builder) (obj)).getContext()), null, bundle));
        bundle = ((Bundle) (obj));
_L5:
        obj = new Listener();
        bundle.setNeutralButton(0x104000a, ((android.content.DialogInterface.OnClickListener) (obj)));
        if (flag)
        {
            bundle.setPositiveButton(0x7f070920, ((android.content.DialogInterface.OnClickListener) (obj)));
        }
        return bundle.create();
_L2:
        android.support.v7.app.AlertDialog.Builder builder;
        if (flag1)
        {
            bundle = new TypedValue();
            if (!getActivity().getTheme().resolveAttribute(0x7f010063, bundle, true))
            {
                bundle.resourceId = getTheme();
            }
            setStyle(1, ((TypedValue) (bundle)).resourceId);
            bundle = new FloaterDialog(getActivity(), getTheme());
            obj = bundle.getWindow();
            obj1 = ((Window) (obj)).getAttributes();
            obj1.gravity = 55;
            ((Window) (obj)).setAttributes(((android.view.WindowManager.LayoutParams) (obj1)));
            return bundle;
        }
        builder = new android.support.v7.app.AlertDialog.Builder(getActivity(), getTheme());
        if (obj2 != null) goto _L4; else goto _L3
_L3:
        builder.setTitle(0x7f070130);
_L6:
        if (flag2)
        {
            builder.setIconAttribute(0x1010355);
        }
        if (obj == null)
        {
            if (obj1 instanceof Integer)
            {
                builder.setMessage(((Integer)obj1).intValue());
                bundle = builder;
            } else
            {
                builder.setMessage((String)obj1);
                bundle = builder;
            }
        } else
        {
            builder.setView(createView(LayoutInflater.from(builder.getContext()), null, bundle));
            bundle = builder;
        }
        if (true) goto _L5; else goto _L4
_L4:
        if (obj2 instanceof Integer)
        {
            builder.setTitle(((Integer)obj2).intValue());
        } else
        {
            builder.setTitle((String)obj2);
        }
          goto _L6
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        Dialog dialog = getDialog();
        if (dialog instanceof FloaterDialog)
        {
            return createFloaterBar((FloaterDialog)dialog, layoutinflater, viewgroup, bundle);
        }
        if (getShowsDialog())
        {
            return super.onCreateView(layoutinflater, viewgroup, bundle);
        } else
        {
            return createView(layoutinflater, viewgroup, bundle);
        }
    }

    public void onDestroyView()
    {
        floaterView = null;
        super.onDestroyView();
    }
}
