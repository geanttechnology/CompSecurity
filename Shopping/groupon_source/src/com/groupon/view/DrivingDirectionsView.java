// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.groupon.models.drivingdirection.DrivingDirections;
import com.groupon.models.drivingdirection.DrivingDirectionsLeg;
import com.groupon.models.drivingdirection.DrivingDirectionsRoute;
import com.groupon.models.drivingdirection.DrivingDirectionsTextValue;
import com.groupon.service.DrivingDirectionsService;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.ReturningFunction1;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;
import roboguice.util.Strings;

public class DrivingDirectionsView extends FrameLayout
{
    protected class CalculateTravelTimeFunction
        implements Function1
    {

        protected final Function1 callback;
        final DrivingDirectionsView this$0;

        public void execute(DrivingDirections drivingdirections)
        {
            if (drivingdirections == null)
            {
                Ln.d("DETAILS: null directions", new Object[0]);
                callback.execute(null);
                return;
            }
            Ln.d("DETAILS: status = %s", new Object[] {
                drivingdirections.status
            });
            if (!drivingdirections.status.equals("OK"))
            {
                callback.execute(null);
                return;
            }
            drivingdirections = drivingdirections.routes;
            int i;
            if (drivingdirections != null)
            {
                i = drivingdirections.size();
            } else
            {
                i = 0;
            }
            Ln.d("DETAILS: routes = %s, count=%s", new Object[] {
                drivingdirections, Integer.valueOf(i)
            });
            if (drivingdirections == null || drivingdirections.isEmpty())
            {
                callback.execute(null);
                return;
            }
            drivingdirections = ((DrivingDirectionsRoute)drivingdirections.get(0)).legs;
            if (drivingdirections != null)
            {
                i = drivingdirections.size();
            } else
            {
                i = 0;
            }
            Ln.d("DETAILS: legs = %s, count=%s", new Object[] {
                drivingdirections, Integer.valueOf(i)
            });
            if (drivingdirections == null || drivingdirections.isEmpty())
            {
                callback.execute(null);
                return;
            }
            drivingdirections = ((DrivingDirectionsLeg)drivingdirections.get(0)).duration;
            Ln.d("DETAILS: duration = %s", new Object[] {
                drivingdirections
            });
            if (drivingdirections == null)
            {
                callback.execute(null);
                return;
            }
            int j = (int)((double)((DrivingDirectionsTextValue) (drivingdirections)).value / 60D + 0.5D);
            i = j / 60;
            j %= 60;
            drivingdirections = new StringBuilder();
            if (i > 0)
            {
                drivingdirections.append(i).append(" ").append(getContext().getString(0x7f08022a)).append(" ");
            }
            if (j > 0)
            {
                drivingdirections.append(j).append(" ").append(getContext().getString(0x7f08047b));
            }
            callback.execute(drivingdirections.toString());
        }

        public volatile void execute(Object obj)
            throws Exception
        {
            execute((DrivingDirections)obj);
        }

        public CalculateTravelTimeFunction(Function1 function1)
        {
            this$0 = DrivingDirectionsView.this;
            super();
            callback = function1;
        }
    }

    protected static class ExecuteCallbackExceptionFunction
        implements ReturningFunction1
    {

        protected final Function1 callback;

        public Boolean execute(Exception exception)
        {
            callback.execute(null);
            return Boolean.valueOf(false);
        }

        public volatile Object execute(Object obj)
            throws Exception
        {
            return execute((Exception)obj);
        }

        public ExecuteCallbackExceptionFunction(Function1 function1)
        {
            callback = function1;
        }
    }

    protected class ShowDrivingTimeFunction
        implements Function1
    {

        final DrivingDirectionsView this$0;

        public volatile void execute(Object obj)
            throws Exception
        {
            execute((String)obj);
        }

        public void execute(String s)
        {
            Ln.d("DETAILS: getDirections: drivingResult = %s", new Object[] {
                s
            });
            message.setVisibility(8);
            setDrivingTime(s);
        }

        protected ShowDrivingTimeFunction()
        {
            this$0 = DrivingDirectionsView.this;
            super();
        }
    }

    protected class ShowErrorOrSuccessCallbackFunction
        implements Function0
    {

        protected final Function1 callback;
        final DrivingDirectionsView this$0;

        public void execute()
        {
            if (int i = 
// JavaClassFileOutputException: get_constant: invalid tag

        public ShowErrorOrSuccessCallbackFunction(Function1 function1)
        {
            this$0 = DrivingDirectionsView.this;
            super();
            callback = function1;
        }
    }

    protected class ShowWalkingTimeFunction
        implements Function1
    {

        final DrivingDirectionsView this$0;

        public volatile void execute(Object obj)
            throws Exception
        {
            execute((String)obj);
        }

        public void execute(String s)
        {
            Ln.d("DETAILS: getDirections: walkingResult = %s", new Object[] {
                s
            });
            message.setVisibility(8);
            setWalkingTime(s);
        }

        protected ShowWalkingTimeFunction()
        {
            this$0 = DrivingDirectionsView.this;
            super();
        }
    }


    private int callCount;
    private DrivingDirectionsService drivingDirectionsService;
    private String drivingTime;
    private TextView drivingView;
    private TextView error;
    private TextView message;
    private ProgressBar progressView;
    private String walkingTime;
    private TextView walkingView;

    public DrivingDirectionsView(Context context)
    {
        DrivingDirectionsView(context, null);
    }

    public DrivingDirectionsView(Context context, AttributeSet attributeset)
    {
        FrameLayout(context, attributeset);
        callCount = 0;
        RoboGuice.getInjector(context).injectMembers(this);
        inflate(getContext(), 0x7f0300d5, this);
        error = (TextView)findViewById(0x7f10027d);
        message = (TextView)findViewById(0x7f10027c);
        drivingView = (TextView)findViewById(0x7f10027e);
        walkingView = (TextView)findViewById(0x7f10027f);
        progressView = (ProgressBar)findViewById(0x7f10010b);
    }

    public void getDirections(double d, double d1, double d2, double d3, Function1 function1)
    {
        if (!hasDirections() && callCount <= 0)
        {
            message.setVisibility(0);
            drivingView.setVisibility(8);
            walkingView.setVisibility(8);
            if (Strings.isEmpty(drivingTime))
            {
                callCount = callCount + 1;
                getDirectionsInternal(d, d1, d2, d3, com.groupon.service.DrivingDirectionsService.Mode.DRIVING, new ShowDrivingTimeFunction(), new ShowErrorOrSuccessCallbackFunction(function1));
            }
            if (Strings.isEmpty(walkingTime))
            {
                callCount = callCount + 1;
                getDirectionsInternal(d, d1, d2, d3, com.groupon.service.DrivingDirectionsService.Mode.WALKING, new ShowWalkingTimeFunction(), new ShowErrorOrSuccessCallbackFunction(function1));
                return;
            }
        }
    }

    protected void getDirectionsInternal(double d, double d1, double d2, double d3, com.groupon.service.DrivingDirectionsService.Mode mode, Function1 function1, Function0 function0)
    {
        showProgress(true);
        drivingDirectionsService.getDirections(d, d1, d2, d3, mode, new CalculateTravelTimeFunction(function1), new ExecuteCallbackExceptionFunction(function1), function0);
    }

    protected boolean hasDirections()
    {
        return Strings.notEmpty(drivingTime) || Strings.notEmpty(walkingTime);
    }

    protected void setDrivingTime(String s)
    {
        drivingTime = s;
        drivingView.setText(drivingTime);
        TextView textview = drivingView;
        int i;
        if (Strings.notEmpty(s))
        {
            i = 0;
        } else
        {
            i = 8;
        }
        textview.setVisibility(i);
    }

    protected void setWalkingTime(String s)
    {
        walkingTime = s;
        walkingView.setText(walkingTime);
        TextView textview = walkingView;
        int i;
        if (Strings.notEmpty(s))
        {
            i = 0;
        } else
        {
            i = 8;
        }
        textview.setVisibility(i);
    }

    protected void showError()
    {
        error.setVisibility(0);
        message.setVisibility(8);
        drivingView.setVisibility(8);
        walkingView.setVisibility(8);
    }

    protected void showProgress(boolean flag)
    {
        ProgressBar progressbar = progressView;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        progressbar.setVisibility(i);
    }


/*
    static int access$006(DrivingDirectionsView drivingdirectionsview)
    {
        int i = drivingdirectionsview.callCount - 1;
        drivingdirectionsview.callCount = i;
        return i;
    }

*/

}
