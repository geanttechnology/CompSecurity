// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.actions.ActionRunRequest;
import com.urbanairship.actions.ActionValue;
import com.urbanairship.actions.Situation;
import com.urbanairship.push.PushManager;
import com.urbanairship.push.iam.view.Banner;
import com.urbanairship.push.iam.view.SwipeDismissViewLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.urbanairship.push.iam:
//            Timer, InAppMessage

public class InAppMessageFragment extends Fragment
{

    public static final long DEFAULT_DURATION = 15000L;
    private static final String DISMISSED = "dismissed";
    private static final String DISMISS_ANIMATION = "dismiss_animation";
    private static final String DISMISS_ON_RECREATE = "dismiss_on_recreate";
    private static final String MESSAGE = "message";
    private static Boolean isCardViewAvailable;
    private boolean dismissOnRecreate;
    private boolean isDismissed;
    private final List listeners = new ArrayList();
    private InAppMessage message;
    private Timer timer;

    public InAppMessageFragment()
    {
    }

    private static boolean checkCardViewDependencyAvailable()
    {
        if (isCardViewAvailable == null)
        {
            try
            {
                Class.forName("android.support.v7.widget.CardView");
                isCardViewAvailable = Boolean.valueOf(true);
            }
            catch (ClassNotFoundException classnotfoundexception)
            {
                isCardViewAvailable = Boolean.valueOf(false);
            }
        }
        return isCardViewAvailable.booleanValue();
    }

    public static Bundle createArgs(InAppMessage inappmessage, int i)
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("message", inappmessage);
        bundle.putInt("dismiss_animation", i);
        return bundle;
    }

    private void runActions(Map map, Situation situation)
    {
        if (map != null)
        {
            map = map.entrySet().iterator();
            while (map.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
                ActionRunRequest.createRequest((String)entry.getKey()).setValue((ActionValue)entry.getValue()).setSituation(situation).run();
            }
        }
    }

    public final void addListener(Listener listener)
    {
        synchronized (listeners)
        {
            listeners.add(listener);
        }
        return;
        listener;
        list;
        JVM INSTR monitorexit ;
        throw listener;
    }

    public void dismiss(boolean flag)
    {
        timer.stop();
        if (!isDismissed) goto _L2; else goto _L1
_L1:
        return;
_L2:
        List list = listeners;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = (new ArrayList(listeners)).iterator(); iterator.hasNext(); ((Listener)iterator.next()).onFinish(this)) { }
        break MISSING_BLOCK_LABEL_69;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
        isDismissed = true;
        if (getActivity() != null)
        {
            FragmentTransaction fragmenttransaction = getActivity().getFragmentManager().beginTransaction();
            int i;
            if (flag)
            {
                i = getArguments().getInt("dismiss_animation", 0);
            } else
            {
                i = 0;
            }
            fragmenttransaction.setCustomAnimations(0, i).remove(this).commit();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public int getDismissAnimation()
    {
        return getArguments().getInt("dismiss_animation", 0);
    }

    public InAppMessage getMessage()
    {
        return message;
    }

    public boolean isDismissed()
    {
        return isDismissed;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setRetainInstance(true);
        message = (InAppMessage)getArguments().getParcelable("message");
        if (message == null)
        {
            dismiss(false);
        } else
        {
            long l;
            boolean flag;
            if (bundle != null && bundle.getBoolean("dismissed", false))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            isDismissed = flag;
            if (message.getDuration() == null)
            {
                l = 15000L;
            } else
            {
                l = message.getDuration().longValue();
            }
            timer = new _cls1(l);
            if (bundle != null && bundle.getBoolean("dismiss_on_recreate", false) != dismissOnRecreate)
            {
                Logger.debug("InAppMessageFragment - Dismissing on recreate.");
                dismiss(true);
                return;
            }
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (message == null || message.getAlert() == null)
        {
            dismiss(false);
            return null;
        }
        int i;
        if (checkCardViewDependencyAvailable())
        {
            i = com.urbanairship.R.layout.ua_fragment_iam_card;
        } else
        {
            i = com.urbanairship.R.layout.ua_fragment_iam;
        }
        layoutinflater = (SwipeDismissViewLayout)layoutinflater.inflate(i, viewgroup, false);
        viewgroup = (android.widget.FrameLayout.LayoutParams)layoutinflater.getLayoutParams();
        if (message.getPosition() == 1)
        {
            i = 48;
        } else
        {
            i = 80;
        }
        viewgroup.gravity = i;
        layoutinflater.setLayoutParams(viewgroup);
        layoutinflater.setListener(new _cls2());
        viewgroup = (FrameLayout)layoutinflater.findViewById(com.urbanairship.R.id.in_app_message);
        if (!message.getClickActionValues().isEmpty())
        {
            viewgroup.setOnClickListener(new _cls3());
        } else
        {
            viewgroup.setClickable(false);
            viewgroup.setForeground(null);
        }
        viewgroup = (Banner)viewgroup;
        viewgroup.setOnDismissClickListener(new _cls4());
        viewgroup.setOnActionClickListener(new _cls5());
        if (message.getPrimaryColor() != null)
        {
            viewgroup.setPrimaryColor(message.getPrimaryColor().intValue());
        }
        if (message.getSecondaryColor() != null)
        {
            viewgroup.setSecondaryColor(message.getSecondaryColor().intValue());
        }
        viewgroup.setText(message.getAlert());
        viewgroup.setNotificationActionButtonGroup(UAirship.shared().getPushManager().getNotificationActionGroup(message.getButtonGroupId()));
        return layoutinflater;
    }

    public void onPause()
    {
        super.onPause();
        timer.stop();
        List list = listeners;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = (new ArrayList(listeners)).iterator(); iterator.hasNext(); ((Listener)iterator.next()).onPause(this)) { }
        break MISSING_BLOCK_LABEL_65;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    public void onResume()
    {
        super.onResume();
        timer.start();
        List list = listeners;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = (new ArrayList(listeners)).iterator(); iterator.hasNext(); ((Listener)iterator.next()).onResume(this)) { }
        break MISSING_BLOCK_LABEL_65;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("dismissed", isDismissed);
        bundle.putBoolean("dismiss_on_recreate", dismissOnRecreate);
    }

    public final void removeListener(Listener listener)
    {
        synchronized (listeners)
        {
            listeners.remove(listener);
        }
        return;
        listener;
        list;
        JVM INSTR monitorexit ;
        throw listener;
    }

    void setDismissOnRecreate(boolean flag)
    {
        dismissOnRecreate = flag;
    }




    private class Listener
    {

        public abstract void onFinish(InAppMessageFragment inappmessagefragment);

        public abstract void onPause(InAppMessageFragment inappmessagefragment);

        public abstract void onResume(InAppMessageFragment inappmessagefragment);
    }


    private class _cls1 extends Timer
    {

        final InAppMessageFragment this$0;

        protected void onFinish()
        {
            dismiss(true);
            ResolutionEvent resolutionevent = ResolutionEvent.createTimedOutResolutionEvent(message, timer.getRunTime());
            UAirship.shared().getAnalytics().addEvent(resolutionevent);
        }

        _cls1(long l)
        {
            this$0 = InAppMessageFragment.this;
            super(l);
        }
    }


    private class _cls2
        implements com.urbanairship.push.iam.view.SwipeDismissViewLayout.Listener
    {

        final InAppMessageFragment this$0;

        public void onDismissed(View view)
        {
            dismiss(false);
            view = ResolutionEvent.createUserDismissedResolutionEvent(message, timer.getRunTime());
            UAirship.shared().getAnalytics().addEvent(view);
        }

        public void onDragStateChanged(View view, int i)
        {
            switch (i)
            {
            default:
                return;

            case 1: // '\001'
                timer.stop();
                return;

            case 0: // '\0'
                timer.start();
                return;
            }
        }

        _cls2()
        {
            this$0 = InAppMessageFragment.this;
            super();
        }
    }


    private class _cls3
        implements android.view.View.OnClickListener
    {

        final InAppMessageFragment this$0;

        public void onClick(View view)
        {
            dismiss(true);
            runActions(message.getClickActionValues(), Situation.FOREGROUND_NOTIFICATION_ACTION_BUTTON);
            view = ResolutionEvent.createClickedResolutionEvent(message, timer.getRunTime());
            UAirship.shared().getAnalytics().addEvent(view);
        }

        _cls3()
        {
            this$0 = InAppMessageFragment.this;
            super();
        }
    }


    private class _cls4
        implements com.urbanairship.push.iam.view.Banner.OnDismissClickListener
    {

        final InAppMessageFragment this$0;

        public void onDismissClick()
        {
            dismiss(true);
            ResolutionEvent resolutionevent = ResolutionEvent.createUserDismissedResolutionEvent(message, timer.getRunTime());
            UAirship.shared().getAnalytics().addEvent(resolutionevent);
        }

        _cls4()
        {
            this$0 = InAppMessageFragment.this;
            super();
        }
    }


    private class _cls5
        implements com.urbanairship.push.iam.view.Banner.OnActionClickListener
    {

        final InAppMessageFragment this$0;

        public void onActionClick(NotificationActionButton notificationactionbutton)
        {
            Logger.info((new StringBuilder("In-app message button clicked: ")).append(notificationactionbutton.getId()).toString());
            dismiss(true);
            Situation situation;
            if (notificationactionbutton.isForegroundAction())
            {
                situation = Situation.FOREGROUND_NOTIFICATION_ACTION_BUTTON;
            } else
            {
                situation = Situation.BACKGROUND_NOTIFICATION_ACTION_BUTTON;
            }
            runActions(message.getButtonActionValues(notificationactionbutton.getId()), situation);
            notificationactionbutton = ResolutionEvent.createButtonClickedResolutionEvent(getActivity(), message, notificationactionbutton, timer.getRunTime());
            UAirship.shared().getAnalytics().addEvent(notificationactionbutton);
        }

        _cls5()
        {
            this$0 = InAppMessageFragment.this;
            super();
        }
    }

}
