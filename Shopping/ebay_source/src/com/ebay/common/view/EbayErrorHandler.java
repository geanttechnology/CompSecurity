// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.view;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.ebay.common.Preferences;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.common.view.util.DialogManager;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.CoreActivity;
import com.ebay.mobile.activities.CoreListActivity;
import com.ebay.mobile.activities.CorePreferenceActivity;
import com.ebay.mobile.activities.ErrorDialogActivity;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.KernelContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.HttpError;
import com.ebay.nautilus.kernel.net.InvalidDeviceClockError;
import com.ebay.nautilus.kernel.net.IoError;
import com.ebay.nautilus.shell.app.BaseActivity;
import com.ebay.nautilus.shell.app.FwActivity;
import com.ebay.nautilus.shell.content.FwNetLoader;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public class EbayErrorHandler
{
    class _cls1Listener
        implements android.content.DialogInterface.OnCancelListener, android.content.DialogInterface.OnClickListener
    {

        final WeakReference activity;
        final boolean hasDateSettings;

        public void onCancel(DialogInterface dialoginterface)
        {
            Process.killProcess(Process.myPid());
        }

        public void onClick(DialogInterface dialoginterface, int i)
        {
            if (i == -2)
            {
                Intent intent;
                Activity activity1;
                if (hasDateSettings)
                {
                    intent = new Intent("android.settings.DATE_SETTINGS");
                } else
                {
                    intent = new Intent("android.settings.SETTINGS");
                }
                intent.addFlags(0x10000000);
                activity1 = (Activity)activity.get();
                if (activity1 != null)
                {
                    activity1.startActivity(intent);
                }
            }
            dialoginterface.cancel();
        }

        _cls1Listener(Activity activity1)
        {
            boolean flag = false;
            super();
            activity = new WeakReference(activity1);
            if (activity1.getPackageManager().resolveActivity(new Intent("android.settings.DATE_SETTINGS"), 0) != null)
            {
                flag = true;
            }
            hasDateSettings = flag;
        }
    }

    public static final class DefaultUserNotLoggedInCallback
        implements UserNotLoggedInCallback
    {

        private final Activity activity;

        public void onUserNotLoggedIn()
        {
            if (MyApp.getPrefs().isSignedIn())
            {
                MyApp.signOutForIafTokenFailure(activity);
            }
        }

        public DefaultUserNotLoggedInCallback(Activity activity1)
        {
            activity = activity1;
        }
    }

    public static class OverrideHandler
    {

        public HandleState handleError(Activity activity1, Fragment fragment, int i, ResultStatus resultstatus)
        {
            return HandleState.DefaultHandling;
        }

        public HandleState handleWarning(Activity activity1, Fragment fragment, int i, ResultStatus resultstatus)
        {
            return HandleState.DefaultHandling;
        }

        public OverrideHandler()
        {
        }
    }

    public static final class OverrideHandler.HandleState extends Enum
    {

        private static final OverrideHandler.HandleState $VALUES[];
        public static final OverrideHandler.HandleState DefaultHandling;
        public static final OverrideHandler.HandleState Handled;
        public static final OverrideHandler.HandleState Ignored;

        public static OverrideHandler.HandleState valueOf(String s)
        {
            return (OverrideHandler.HandleState)Enum.valueOf(com/ebay/common/view/EbayErrorHandler$OverrideHandler$HandleState, s);
        }

        public static OverrideHandler.HandleState[] values()
        {
            return (OverrideHandler.HandleState[])$VALUES.clone();
        }

        static 
        {
            DefaultHandling = new OverrideHandler.HandleState("DefaultHandling", 0);
            Handled = new OverrideHandler.HandleState("Handled", 1);
            Ignored = new OverrideHandler.HandleState("Ignored", 2);
            $VALUES = (new OverrideHandler.HandleState[] {
                DefaultHandling, Handled, Ignored
            });
        }

        private OverrideHandler.HandleState(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface UserNotLoggedInCallback
    {

        public abstract void onUserNotLoggedIn();
    }


    protected final Activity activity;
    protected final boolean closeActivityAfterDialog;
    private final UserNotLoggedInCallback userNotLoggedInCallback;

    public EbayErrorHandler(Activity activity1)
    {
        this(activity1, false, ((UserNotLoggedInCallback) (null)));
    }

    public EbayErrorHandler(Activity activity1, UserNotLoggedInCallback usernotloggedincallback)
    {
        this(activity1, false, usernotloggedincallback);
    }

    public EbayErrorHandler(Activity activity1, boolean flag)
    {
        this(activity1, flag, ((UserNotLoggedInCallback) (null)));
    }

    public EbayErrorHandler(Activity activity1, boolean flag, UserNotLoggedInCallback usernotloggedincallback)
    {
        activity = activity1;
        closeActivityAfterDialog = flag;
        userNotLoggedInCallback = usernotloggedincallback;
    }

    public EbayErrorHandler(Activity activity1, boolean flag, boolean flag1)
    {
        DefaultUserNotLoggedInCallback defaultusernotloggedincallback;
        if (flag1)
        {
            defaultusernotloggedincallback = new DefaultUserNotLoggedInCallback(activity1);
        } else
        {
            defaultusernotloggedincallback = null;
        }
        this(activity1, flag, ((UserNotLoggedInCallback) (defaultusernotloggedincallback)));
    }

    private static boolean deviceClockInvalid(List list)
    {
        if (list != null && !list.isEmpty())
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                if ((com.ebay.nautilus.kernel.content.ResultStatus.Message)list.next() instanceof InvalidDeviceClockError)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean handleResultStatus(Activity activity1, int i, ResultStatus resultstatus)
    {
        return handleResultStatus(activity1, i, resultstatus, null);
    }

    public static boolean handleResultStatus(Activity activity1, int i, ResultStatus resultstatus, OverrideHandler overridehandler)
    {
        return handleResultStatus(activity1, null, i, resultstatus, overridehandler);
    }

    private static boolean handleResultStatus(Activity activity1, Fragment fragment, int i, ResultStatus resultstatus, OverrideHandler overridehandler)
    {
        if (activity1 != null && !activity1.isFinishing()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (!resultstatus.hasError()) goto _L4; else goto _L3
_L3:
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$common$view$EbayErrorHandler$OverrideHandler$HandleState[];

            static 
            {
                $SwitchMap$com$ebay$common$view$EbayErrorHandler$OverrideHandler$HandleState = new int[OverrideHandler.HandleState.values().length];
                try
                {
                    $SwitchMap$com$ebay$common$view$EbayErrorHandler$OverrideHandler$HandleState[OverrideHandler.HandleState.DefaultHandling.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$common$view$EbayErrorHandler$OverrideHandler$HandleState[OverrideHandler.HandleState.Handled.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        OverrideHandler.HandleState handlestate;
        if (overridehandler != null)
        {
            handlestate = overridehandler.handleError(activity1, fragment, i, resultstatus);
        } else
        {
            handlestate = OverrideHandler.HandleState.DefaultHandling;
        }
        _cls1..SwitchMap.com.ebay.common.view.EbayErrorHandler.OverrideHandler.HandleState[handlestate.ordinal()];
        JVM INSTR tableswitch 1 2: default 68
    //                   1 122
    //                   2 11;
           goto _L4 _L5 _L1
_L4:
        if (!resultstatus.hasWarning() || overridehandler != null && overridehandler.handleWarning(activity1, fragment, i, resultstatus) != OverrideHandler.HandleState.DefaultHandling) goto _L7; else goto _L6
_L6:
        if (!(activity1 instanceof CoreActivity)) goto _L9; else goto _L8
_L8:
        ((CoreActivity)activity1).showMessage(fragment, i, resultstatus);
_L7:
        return true;
_L5:
        if (EbayErrorUtil.userNotLoggedIn(resultstatus.getMessages()) && MyApp.getPrefs().isSignedIn())
        {
            MyApp.signOutForIafTokenFailure(activity1);
            return false;
        }
        if (deviceClockInvalid(resultstatus.getMessages()) && (activity1 instanceof FwActivity))
        {
            promptToUpdateDeviceDateTime((FwActivity)activity1);
            return false;
        }
        if (activity1 instanceof CoreActivity)
        {
            ((CoreActivity)activity1).showMessage(fragment, i, resultstatus);
            return false;
        }
        if (activity1 instanceof CoreListActivity)
        {
            ((CoreListActivity)activity1).showMessage(fragment, i, resultstatus);
            return false;
        }
        if (activity1 instanceof CorePreferenceActivity)
        {
            ((CorePreferenceActivity)activity1).showMessage(fragment, i, resultstatus);
            return false;
        } else
        {
            showError(activity1, resultstatus.getFirstError());
            return false;
        }
_L9:
        if (activity1 instanceof CoreListActivity)
        {
            ((CoreListActivity)activity1).showMessage(fragment, i, resultstatus);
        } else
        if (activity1 instanceof CorePreferenceActivity)
        {
            ((CorePreferenceActivity)activity1).showMessage(fragment, i, resultstatus);
        }
        if (true) goto _L7; else goto _L10
_L10:
    }

    public static boolean handleResultStatus(Fragment fragment, int i, ResultStatus resultstatus)
    {
        return handleResultStatus(fragment, i, resultstatus, null);
    }

    public static boolean handleResultStatus(Fragment fragment, int i, ResultStatus resultstatus, OverrideHandler overridehandler)
    {
        return handleResultStatus(fragment.getActivity(), fragment, i, resultstatus, overridehandler);
    }

    public static void promptToUpdateDeviceDateTime(FwActivity fwactivity)
    {
        DialogManager dialogmanager = (DialogManager)fwactivity.getShim(com/ebay/common/view/util/DialogManager);
        if (dialogmanager != null)
        {
            Context context = (Context)fwactivity;
            fwactivity = new _cls1Listener((Activity)fwactivity);
            dialogmanager.showDynamicAlertDialog(context.getString(0x7f070130), context.getString(0x7f070136), fwactivity, fwactivity);
        }
    }

    public static void rewriteServiceErrors(EbayContext ebaycontext, ResultStatus resultstatus)
    {
        List list = resultstatus.getMessages();
        if (list != null && !list.isEmpty())
        {
            int i = list.size() - 1;
            while (i >= 0) 
            {
                resultstatus = (com.ebay.nautilus.kernel.content.ResultStatus.Message)list.get(i);
                if (resultstatus.getSeverity() == com.ebay.nautilus.kernel.content.ResultStatus.Severity.Error)
                {
                    if (resultstatus instanceof EbayResponseError)
                    {
                        EbayResponseError ebayresponseerror = (EbayResponseError)resultstatus;
                        if (EbayTradingApi.errorCodeRepresentsCongestion(ebayresponseerror.code))
                        {
                            ebayresponseerror.shortMessage = ebaycontext.getString(0x7f07014c);
                            ebayresponseerror.longMessage = null;
                        }
                        if (MyApp.getDeviceConfiguration().isMaintenanceWindow())
                        {
                            String s = ebayresponseerror.longMessage;
                            resultstatus = s;
                            if (TextUtils.isEmpty(s))
                            {
                                resultstatus = ebayresponseerror.shortMessage;
                            }
                            if (!ebayresponseerror.isLongMessageHtml(ebaycontext))
                            {
                                ebayresponseerror.longMessage = (new StringBuilder()).append(ebaycontext.getString(0x7f0705fd)).append("\n\n").append(resultstatus).toString();
                            }
                        }
                        if (TextUtils.isEmpty(ebayresponseerror.longMessage) && TextUtils.isEmpty(ebayresponseerror.shortMessage))
                        {
                            ebayresponseerror.shortMessage = ebaycontext.getString(0x7f070255);
                        }
                    } else
                    if (resultstatus instanceof HttpError)
                    {
                        if (resultstatus.getId() == 500)
                        {
                            resultstatus = (HttpError)resultstatus;
                            resultstatus.message = ebaycontext.getString(0x7f070254);
                            if (MyApp.getDeviceConfiguration().isMaintenanceWindow())
                            {
                                resultstatus.message = (new StringBuilder()).append(ebaycontext.getString(0x7f0705fd)).append("\n\n").append(((HttpError) (resultstatus)).message).toString();
                            }
                        }
                    } else
                    if (resultstatus instanceof IoError)
                    {
                        resultstatus = (IoError)resultstatus;
                        if (resultstatus.getException() instanceof com.ebay.nautilus.kernel.net.Connector.ClientErrorException)
                        {
                            resultstatus.message = ebaycontext.getString(0x7f07024b);
                            if (MyApp.getDeviceConfiguration().isMaintenanceWindow())
                            {
                                resultstatus.message = (new StringBuilder()).append(ebaycontext.getString(0x7f0705fd)).append("\n\n").append(((IoError) (resultstatus)).message).toString();
                            }
                        } else
                        {
                            resultstatus.message = ebaycontext.getString(0x7f07024c);
                        }
                    } else
                    if (resultstatus instanceof InvalidDeviceClockError)
                    {
                        ((InvalidDeviceClockError)resultstatus).message = ebaycontext.getString(0x7f070136);
                    }
                }
                i--;
            }
        }
    }

    private static void showError(Activity activity1, com.ebay.nautilus.kernel.content.ResultStatus.Message message)
    {
        EbayContext ebaycontext;
        if (activity1 instanceof FwActivity)
        {
            ebaycontext = ((FwActivity)activity1).getEbayContext();
        } else
        {
            ebaycontext = KernelContext.getSingleBaseContext(activity1.getApplication());
        }
        ErrorDialogActivity.StartActivity(activity1, String.valueOf(message.getId()), ResultStatus.getSafeLongMessage(ebaycontext, message));
    }

    protected void displayUserError(List list, boolean flag)
    {
        if (list != null && !list.isEmpty() && (activity instanceof BaseActivity))
        {
            DialogManager dialogmanager = (DialogManager)((BaseActivity)activity).getShim(com/ebay/common/view/util/DialogManager);
            if (dialogmanager == null)
            {
                Toast.makeText(activity, 0x7f07024a, 1).show();
                return;
            }
            String s = getMessageFromResponseError((EbayResponseError)list.get(0));
            list.remove(0);
            Object obj = s;
            if (!list.isEmpty())
            {
                obj = new StringBuilder();
                ((StringBuilder) (obj)).append(s);
                if (flag)
                {
                    ((StringBuilder) (obj)).append("\n");
                }
                EbayResponseError ebayresponseerror;
                for (list = list.iterator(); list.hasNext(); ((StringBuilder) (obj)).append('\n').append(getMessageFromResponseError(ebayresponseerror)))
                {
                    ebayresponseerror = (EbayResponseError)list.next();
                }

                obj = ((StringBuilder) (obj)).toString();
            }
            dialogmanager.showDynamicAlertDialog(null, ((String) (obj)), closeActivityAfterDialog);
            return;
        } else
        {
            Toast.makeText(activity, 0x7f07024a, 1).show();
            return;
        }
    }

    public String getMaintenanceTitle()
    {
        if (MyApp.getDeviceConfiguration().isMaintenanceWindow())
        {
            return activity.getString(0x7f0705fd);
        } else
        {
            return null;
        }
    }

    protected String getMessageFromResponseError(EbayResponseError ebayresponseerror)
    {
        String s = ebayresponseerror.shortMessage;
        if (EbayTradingApi.errorCodeRepresentsCongestion(ebayresponseerror.code))
        {
            s = activity.getString(0x7f07014c);
        }
        return s;
    }

    protected String getString(int i)
    {
        return activity.getString(i);
    }

    public final boolean handleEbayError(int i, List list)
    {
        i;
        JVM INSTR tableswitch -4 -1: default 32
    //                   -4 78
    //                   -3 34
    //                   -2 41
    //                   -1 85;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return true;
_L3:
        onInternalError();
        continue; /* Loop/switch isn't completed */
_L4:
        if (list != null && !list.isEmpty())
        {
            list = (EbayResponseError)list.get(0);
        } else
        {
            list = null;
        }
        onNetworkError(list);
        continue; /* Loop/switch isn't completed */
_L2:
        onServerError();
        continue; /* Loop/switch isn't completed */
_L5:
        if (EbayErrorUtil.userNotLoggedIn(list))
        {
            onUserNotLoggedIn();
            return false;
        }
        onError(list);
        if (true) goto _L1; else goto _L6
_L6:
    }

    public final boolean handleEbayError(List list, FwNetLoader fwnetloader)
    {
        Assert.assertTrue(fwnetloader.isError());
        return handleEbayError(list, fwnetloader.isConnectionError(), fwnetloader.isClientError(), fwnetloader.isServiceError(), fwnetloader.getException());
    }

    public final boolean handleEbayError(List list, boolean flag, boolean flag1, boolean flag2, IOException ioexception)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        if (ioexception instanceof com.ebay.nautilus.kernel.net.Connector.HostErrorException)
        {
            ioexception = (com.ebay.nautilus.kernel.net.Connector.HostErrorException)ioexception;
            if (ioexception.getResponseCode() == 500)
            {
                onServerError();
            } else
            {
                list = new EbayResponseError();
                list.code = String.valueOf(ioexception.getResponseCode());
                ioexception = ioexception.getLocalizedMessage();
                list.longMessage = ioexception;
                list.shortMessage = ioexception;
                onNetworkError(list);
            }
        } else
        {
            onNetworkError(null);
        }
_L4:
        return true;
_L2:
        if (flag1)
        {
            onInternalError();
        } else
        if (flag2)
        {
            if (EbayErrorUtil.userNotLoggedIn(list))
            {
                onUserNotLoggedIn();
                return false;
            }
            onError(list);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onError(List list)
    {
        if (list != null && !list.isEmpty())
        {
            ArrayList arraylist = new ArrayList(list.size());
            for (list = list.iterator(); list.hasNext();)
            {
                EbayResponseError ebayresponseerror = (EbayResponseError)list.next();
                if (ebayresponseerror.userDisplay && !TextUtils.isEmpty(ebayresponseerror.shortMessage))
                {
                    arraylist.add(ebayresponseerror);
                } else
                {
                    Log.e(getClass().getSimpleName(), ebayresponseerror.toString());
                }
            }

            if (!arraylist.isEmpty())
            {
                onUserError(arraylist);
                return;
            }
        }
        onUserError(null);
    }

    protected void onInternalError()
    {
        String s1 = activity.getString(0x7f07024b);
        String s2 = getMaintenanceTitle();
        String s = s1;
        if (s2 != null)
        {
            s = (new StringBuilder()).append(s2).append("\n\n").append(s1).toString();
        }
        Toast.makeText(activity, s, 1).show();
    }

    protected void onNetworkError(EbayResponseError ebayresponseerror)
    {
        Toast.makeText(activity, 0x7f07024c, 1).show();
    }

    public void onServerError()
    {
        String s1 = activity.getString(0x7f070254);
        String s2 = getMaintenanceTitle();
        String s = s1;
        if (s2 != null)
        {
            s = (new StringBuilder()).append(s2).append("\n\n").append(s1).toString();
        }
        Toast.makeText(activity, s, 1).show();
    }

    protected void onUserError(List list)
    {
        boolean flag = false;
        if (MyApp.getDeviceConfiguration().isMaintenanceWindow())
        {
            if (list != null)
            {
                EbayResponseError ebayresponseerror = new EbayResponseError();
                String s = activity.getString(0x7f0705fd);
                ebayresponseerror.longMessage = s;
                ebayresponseerror.shortMessage = s;
                list.add(0, ebayresponseerror);
            }
            flag = true;
        }
        displayUserError(list, flag);
    }

    protected void onUserNotLoggedIn()
    {
        if (userNotLoggedInCallback != null)
        {
            userNotLoggedInCallback.onUserNotLoggedIn();
        }
    }
}
