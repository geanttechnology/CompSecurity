// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.popup;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.TextView;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;

// Referenced classes of package com.amazon.retailsearch.popup:
//            Position, PopupDialog, DialogSizeChangedListener

public class PopupDialogFragmentV4 extends DialogFragment
{
    private class ChildSizeChangedListener
        implements DialogSizeChangedListener
    {

        final PopupDialogFragmentV4 this$0;

        public void onHeightChanged(int i)
        {
            if (dialog != null && dialog.getWindow() != null && dialog.getWindow().getAttributes() != null)
            {
                android.view.WindowManager.LayoutParams layoutparams = dialog.getWindow().getAttributes();
                int j;
                if (i > 0 && i < maxHeight)
                {
                    j = i;
                } else
                {
                    j = maxHeight;
                }
                layoutparams.height = j;
                height = i;
                dialog.getWindow().setAttributes(layoutparams);
                if (mSizeChangedListener != null)
                {
                    mSizeChangedListener.onSizeChanged();
                    return;
                }
            }
        }

        private ChildSizeChangedListener()
        {
            this$0 = PopupDialogFragmentV4.this;
            super();
        }

    }

    public static interface OnCloseListener
    {

        public abstract void onClose();
    }

    public static interface OnSizeChangedListener
    {

        public abstract void onSizeChanged();
    }


    public static final String DIALOG_TAG = "popup_dialog_fragment";
    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/popup/PopupDialogFragmentV4);
    private ChildSizeChangedListener childSizeChangedListener;
    private Dialog dialog;
    private int height;
    private int mAnchorId;
    private OnCloseListener mCloseListener;
    private View mContent;
    private Position mPosition;
    private OnSizeChangedListener mSizeChangedListener;
    private int mXOffset;
    private int mYOffset;
    private int maxHeight;
    private int width;

    public PopupDialogFragmentV4()
    {
        childSizeChangedListener = new ChildSizeChangedListener();
    }

    private void setDialogBounds(Dialog dialog1)
    {
        Object obj;
        Object obj1;
        int k;
        k = 0;
        int i = 0;
        obj = new int[2];
        obj1 = getAnchor();
        if (obj1 != null)
        {
            ((View) (obj1)).getLocationInWindow(((int []) (obj)));
            k = ((View) (obj1)).getWidth();
            i = ((View) (obj1)).getHeight();
        }
        obj1 = dialog1.getWindow().getAttributes();
        obj1.y = obj[1] + i;
        static class _cls4
        {

            static final int $SwitchMap$com$amazon$retailsearch$popup$Position[];

            static 
            {
                $SwitchMap$com$amazon$retailsearch$popup$Position = new int[Position.values().length];
                try
                {
                    $SwitchMap$com$amazon$retailsearch$popup$Position[Position.BELOW_LEFT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$retailsearch$popup$Position[Position.BELOW_CENTER.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls4..SwitchMap.com.amazon.retailsearch.popup.Position[mPosition.ordinal()];
        JVM INSTR tableswitch 1 2: default 88
    //                   1 212
    //                   2 222;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_222;
_L4:
        obj1.x = ((android.view.WindowManager.LayoutParams) (obj1)).x + mXOffset;
        obj1.y = ((android.view.WindowManager.LayoutParams) (obj1)).y + mYOffset;
        obj = getActivity().getWindow().getDecorView();
        int j;
        if (width == 0)
        {
            j = ((View) (obj)).getWidth();
        } else
        {
            j = width;
        }
        obj1.width = j;
        maxHeight = ((View) (obj)).getHeight() - ((android.view.WindowManager.LayoutParams) (obj1)).y;
        if (height > 0 && height < maxHeight)
        {
            j = height;
        } else
        {
            j = maxHeight;
        }
        obj1.height = j;
        dialog1.getWindow().setAttributes(((android.view.WindowManager.LayoutParams) (obj1)));
        if (mSizeChangedListener != null)
        {
            mSizeChangedListener.onSizeChanged();
        }
        return;
_L2:
        obj1.x = obj[0];
          goto _L4
        obj1.x = (obj[0] - Math.round(((android.view.WindowManager.LayoutParams) (obj1)).width / 2)) + Math.round(k / 2);
          goto _L4
    }

    public View getAnchor()
    {
        return (TextView)getActivity().findViewById(mAnchorId);
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        configuration = getAnchor();
        if (configuration != null)
        {
            runAfterNextLayoutPass(configuration, new Runnable() {

                final PopupDialogFragmentV4 this$0;

                public void run()
                {
                    if (getDialog() != null)
                    {
                        setDialogBounds(getDialog());
                    }
                }

            
            {
                this$0 = PopupDialogFragmentV4.this;
                super();
            }
            });
        }
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        dialog = new Dialog(getActivity(), 0x1030010) {

            final PopupDialogFragmentV4 this$0;

            private boolean isOutOfBounds(MotionEvent motionevent)
            {
                int i = (int)motionevent.getX();
                int j = (int)motionevent.getY();
                motionevent = getWindow().getDecorView();
                return i < 0 || j < 0 || i > motionevent.getWidth() || j > motionevent.getHeight();
            }

            public boolean onTouchEvent(MotionEvent motionevent)
            {
                boolean flag1 = super.onTouchEvent(motionevent);
                boolean flag = flag1;
                if (!flag1)
                {
                    flag = flag1;
                    if (isShowing())
                    {
                        flag = flag1;
                        if (motionevent.getAction() == 0)
                        {
                            flag = flag1;
                            if (isOutOfBounds(motionevent))
                            {
                                cancel();
                                flag = true;
                            }
                        }
                    }
                }
                return flag;
            }

            
            {
                this$0 = PopupDialogFragmentV4.this;
                super(context, i);
            }
        };
        if (getAnchor() == null)
        {
            dismiss();
            return dialog;
        } else
        {
            dialog.setCanceledOnTouchOutside(true);
            setCancelable(true);
            dialog.getWindow().clearFlags(1024);
            dialog.getWindow().setLayout(-2, -2);
            dialog.getWindow().setGravity(51);
            dialog.getWindow().getAttributes().windowAnimations = com.amazon.retailsearch.R.style.PopupDialogFragmentAnimation;
            setDialogBounds(dialog);
            return dialog;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (mContent != null && mContent.getParent() != null)
        {
            ((ViewGroup)mContent.getParent()).removeView(mContent);
        }
        return mContent;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        if (mCloseListener != null)
        {
            mCloseListener.onClose();
        }
        if (mContent != null)
        {
            if (mContent.getParent() != null)
            {
                ((ViewGroup)mContent.getParent()).removeView(mContent);
            }
            mAnchorId = 0;
            mContent = null;
        }
    }

    public void runAfterNextLayoutPass(final View view, final Runnable runnable)
    {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final PopupDialogFragmentV4 this$0;
            final Runnable val$runnable;
            final View val$view;

            public void onGlobalLayout()
            {
                if (android.os.Build.VERSION.SDK_INT < 16)
                {
                    view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else
                {
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                runnable.run();
            }

            
            {
                this$0 = PopupDialogFragmentV4.this;
                view = view1;
                runnable = runnable1;
                super();
            }
        });
    }

    public void setOnCloseListener(OnCloseListener oncloselistener)
    {
        mCloseListener = oncloselistener;
    }

    public void setOnSizeChangedListener(OnSizeChangedListener onsizechangedlistener)
    {
        mSizeChangedListener = onsizechangedlistener;
    }

    public void setPosition(Position position)
    {
        setPosition(position, 0, 0);
    }

    public void setPosition(Position position, int i, int j)
    {
        if (getDialog() != null)
        {
            mPosition = position;
            mXOffset = i;
            mYOffset = j;
            setDialogBounds(getDialog());
        }
    }

    public void show(FragmentManager fragmentmanager, int i, View view, Position position, int j, int k)
    {
        show(fragmentmanager, i, view, position, 0, 0, j, k);
    }

    public void show(FragmentManager fragmentmanager, int i, View view, Position position, int j, int k, int l, 
            int i1)
    {
        if (isAdded())
        {
            return;
        }
        mAnchorId = i;
        mContent = view;
        mPosition = position;
        mXOffset = j;
        mYOffset = k;
        width = l;
        height = i1;
        ((PopupDialog)view).setSizeChangeListener(childSizeChangedListener);
        try
        {
            fragmentmanager = fragmentmanager.beginTransaction();
            if (fragmentmanager.isAddToBackStackAllowed())
            {
                fragmentmanager.addToBackStack("popup_dialog_fragment");
            }
            show(((FragmentTransaction) (fragmentmanager)), "popup_dialog_fragment");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (FragmentManager fragmentmanager)
        {
            log.error("Error while displaying popup dialog fragment", fragmentmanager);
        }
    }






/*
    static int access$402(PopupDialogFragmentV4 popupdialogfragmentv4, int i)
    {
        popupdialogfragmentv4.height = i;
        return i;
    }

*/

}
