// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ftue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.gallery.ftue.PagedFragmentActivity;
import com.amazon.gallery.framework.kindle.CameraUtils;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.kindle.metrics.customer.AddPhotosMetrics;
import com.amazon.gallery.framework.kindle.ui.NoContentOverlayStringParams;
import com.amazon.gallery.framework.network.http.rest.account.AccountDetails;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import com.amazon.gallery.framework.network.upload.DeviceAttributeStore;
import com.amazon.gallery.framework.network.util.EndpointLoadedEvent;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.ftue.DesktopScreen;
import com.amazon.gallery.thor.ftue.FacebookScreen;
import com.amazon.gallery.thor.ftue.MobileScreen;

// Referenced classes of package com.amazon.gallery.framework.kindle.ftue:
//            AccountDetailsListener

public class FTUEAddPhotosFragment extends Fragment
    implements AccountDetailsListener
{
    public static final class OrderedFragments extends Enum
    {

        private static final OrderedFragments $VALUES[];
        public static final OrderedFragments DESKTOP;
        public static final OrderedFragments FACEBOOK;
        public static final OrderedFragments MOBILE;

        public static OrderedFragments valueOf(String s)
        {
            return (OrderedFragments)Enum.valueOf(com/amazon/gallery/framework/kindle/ftue/FTUEAddPhotosFragment$OrderedFragments, s);
        }

        public static OrderedFragments[] values()
        {
            return (OrderedFragments[])$VALUES.clone();
        }

        static 
        {
            DESKTOP = new OrderedFragments("DESKTOP", 0);
            FACEBOOK = new OrderedFragments("FACEBOOK", 1);
            MOBILE = new OrderedFragments("MOBILE", 2);
            $VALUES = (new OrderedFragments[] {
                DESKTOP, FACEBOOK, MOBILE
            });
        }

        private OrderedFragments(String s, int i)
        {
            super(s, i);
        }
    }


    private BeanAwareActivity activity;
    private AddPhotosMetrics addPhotosProfiler;
    private View cameraRow;
    private View dividerLine;
    private View facebookRow;
    private final Class ftueActivity;
    private boolean hasCamera;
    private TextView header;
    private TextView libraryTitle;
    private View mobileRow;
    private com.amazon.gallery.framework.kindle.ui.NoContentOverlay.ContentMode noContentMode;
    private View pcRow;
    private boolean showFacebook;
    private NoContentOverlayStringParams stringParams;
    private boolean usbMode;
    private View usbRow;

    public FTUEAddPhotosFragment()
    {
        this(null);
    }

    public FTUEAddPhotosFragment(Class class1)
    {
        usbMode = false;
        showFacebook = true;
        hasCamera = false;
        ftueActivity = class1;
    }

    protected boolean isAccountRegistered()
    {
        return ((AuthenticationManager)activity.getApplicationBean(Keys.AUTHENTICATING_MANAGER)).hasActiveAccount();
    }

    public boolean isInUSBMode()
    {
        return usbMode;
    }

    public void launchRegisterSettingsPage()
    {
        this;
        JVM INSTR monitorenter ;
        Intent intent = new Intent("com.amazon.dcp.sso.AddAccount");
        activity.startActivityForResult(intent, 974);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void onAccountDetailsReceived(AccountDetails accountdetails)
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        activity = (BeanAwareActivity)getActivity();
        addPhotosProfiler = new AddPhotosMetrics((Profiler)activity.getApplicationBean(Keys.PROFILER));
        hasCamera = CameraUtils.isCameraAvailable(activity);
        stringParams = new NoContentOverlayStringParams();
        stringParams.emptyCameraLabel = activity.getString(0x7f0e009e);
        stringParams.emptyLibraryLabel = activity.getString(0x7f0e00a1);
        stringParams.addPhotosVideoLibrary = activity.getString(0x7f0e00ad);
        stringParams.addPhotosCloud = activity.getString(0x7f0e00ab);
        stringParams.addPhotosDevice = activity.getString(0x7f0e00aa);
        stringParams.addPhotosLibrary = activity.getString(0x7f0e00ac);
        stringParams.emptyHiddenLabel = activity.getString(0x7f0e0233);
        GlobalMessagingBus.register(this);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (viewgroup == null)
        {
            layoutinflater = null;
        } else
        {
            viewgroup = layoutinflater.inflate(0x7f0300b4, viewgroup, false);
            cameraRow = viewgroup.findViewById(0x7f0c019a);
            mobileRow = viewgroup.findViewById(0x7f0c019b);
            pcRow = viewgroup.findViewById(0x7f0c019c);
            facebookRow = viewgroup.findViewById(0x7f0c019d);
            usbRow = viewgroup.findViewById(0x7f0c019e);
            libraryTitle = (TextView)viewgroup.findViewById(0x7f0c0197);
            header = (TextView)viewgroup.findViewById(0x7f0c0131);
            dividerLine = viewgroup.findViewById(0x7f0c0198);
            header.setText(stringParams.addPhotosLibrary);
            pcRow.setOnClickListener(new android.view.View.OnClickListener() {

                final FTUEAddPhotosFragment this$0;

                public void onClick(View view)
                {
                    openFTUEFragment(com/amazon/gallery/thor/ftue/DesktopScreen);
                    addPhotosProfiler.trackEvent(com.amazon.gallery.framework.kindle.metrics.customer.AddPhotosMetrics.MetricsEvent.PCOrMacOptionClicked);
                }

            
            {
                this$0 = FTUEAddPhotosFragment.this;
                super();
            }
            });
            if (BuildFlavors.isAosp())
            {
                pcRow.setVisibility(8);
                facebookRow.setVisibility(8);
            } else
            {
                layoutinflater = facebookRow;
                int i;
                if (showFacebook)
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                layoutinflater.setVisibility(i);
                facebookRow.setOnClickListener(new android.view.View.OnClickListener() {

                    final FTUEAddPhotosFragment this$0;

                    public void onClick(View view)
                    {
                        openFTUEFragment(com/amazon/gallery/thor/ftue/FacebookScreen);
                        addPhotosProfiler.trackEvent(com.amazon.gallery.framework.kindle.metrics.customer.AddPhotosMetrics.MetricsEvent.FacebookOptionClicked);
                    }

            
            {
                this$0 = FTUEAddPhotosFragment.this;
                super();
            }
                });
            }
            if (!((DeviceAttributeStore)ThorGalleryApplication.getBean(Keys.DEVICE_ATTRIBUTE_STORE)).isTablet())
            {
                mobileRow.setVisibility(8);
            } else
            {
                mobileRow.setOnClickListener(new android.view.View.OnClickListener() {

                    final FTUEAddPhotosFragment this$0;

                    public void onClick(View view)
                    {
                        openFTUEFragment(com/amazon/gallery/thor/ftue/MobileScreen);
                        addPhotosProfiler.trackEvent(com.amazon.gallery.framework.kindle.metrics.customer.AddPhotosMetrics.MetricsEvent.MobileDeviceOptionClicked);
                    }

            
            {
                this$0 = FTUEAddPhotosFragment.this;
                super();
            }
                });
            }
            usbRow.setOnClickListener(new android.view.View.OnClickListener() {

                final FTUEAddPhotosFragment this$0;

                public void onClick(View view)
                {
                    usbInstructionsMode(true);
                }

            
            {
                this$0 = FTUEAddPhotosFragment.this;
                super();
            }
            });
            layoutinflater = viewgroup;
            if (noContentMode != null)
            {
                updateView();
                return viewgroup;
            }
        }
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        GlobalMessagingBus.unregister(this);
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        libraryTitle = null;
        header = null;
        cameraRow = null;
        mobileRow = null;
        pcRow = null;
        facebookRow = null;
        usbRow = null;
    }

    public void onEndpointLoaded(final EndpointLoadedEvent facebookRow)
    {
        boolean flag1 = true;
        boolean flag2 = showFacebook;
        boolean flag;
        if (!BuildFlavors.isAosp())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        showFacebook = flag & flag2;
        flag2 = showFacebook;
        if (facebookRow.endpoint != null && facebookRow.endpoint.getMarketplace() != com.amazon.gallery.framework.network.http.rest.account.Endpoint.Marketplace.CHINA)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        showFacebook = flag2 & flag;
        if (getView() != null)
        {
            facebookRow = getView().findViewById(0x7f0c019d);
            if (facebookRow != null)
            {
                facebookRow.post(new Runnable() {

                    final FTUEAddPhotosFragment this$0;
                    final View val$facebookRow;

                    public void run()
                    {
                        synchronized (FTUEAddPhotosFragment.this)
                        {
                            if (!showFacebook && getView() != null)
                            {
                                facebookRow.setVisibility(8);
                            }
                        }
                        return;
                        exception;
                        ftueaddphotosfragment;
                        JVM INSTR monitorexit ;
                        throw exception;
                    }

            
            {
                this$0 = FTUEAddPhotosFragment.this;
                facebookRow = view;
                super();
            }
                });
            }
        }
    }

    protected void openFTUEFragment(Class class1)
    {
        if (!isAccountRegistered())
        {
            launchRegisterSettingsPage();
        } else
        {
            if (getActivity() instanceof PagedFragmentActivity)
            {
                ((PagedFragmentActivity)getActivity()).moveToSpecific(class1, true);
                return;
            }
            if (ftueActivity != null)
            {
                Intent intent = new Intent(activity, ftueActivity);
                intent.putExtra("fragment_class_name", class1.getName());
                activity.startActivity(intent);
                return;
            }
        }
    }

    public void setEmptyCameraMode()
    {
        this;
        JVM INSTR monitorenter ;
        libraryTitle.setVisibility(0);
        libraryTitle.setText(stringParams.emptyCameraLabel);
        header.setText("");
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setEmptyDeviceMode()
    {
        this;
        JVM INSTR monitorenter ;
        libraryTitle.setVisibility(0);
        libraryTitle.setText(stringParams.emptyLibraryLabel);
        header.setText(stringParams.addPhotosDevice);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setEmptyHiddenMode()
    {
        this;
        JVM INSTR monitorenter ;
        libraryTitle.setVisibility(8);
        header.setText(stringParams.emptyHiddenLabel);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setEmptyLibraryMode(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        libraryTitle.setVisibility(0);
        libraryTitle.setText(stringParams.emptyLibraryLabel);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        header.setText(stringParams.addPhotosVideoLibrary);
_L1:
        if (BuildFlavors.isAosp())
        {
            header.setVisibility(8);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        header.setText(stringParams.addPhotosLibrary);
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    public void setNoContentMode(com.amazon.gallery.framework.kindle.ui.NoContentOverlay.ContentMode contentmode)
    {
        this;
        JVM INSTR monitorenter ;
        noContentMode = contentmode;
        if (getView() != null)
        {
            updateView();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        contentmode;
        throw contentmode;
    }

    protected void updateView()
    {
        int i;
        byte byte0;
        boolean flag;
        boolean flag1;
        boolean flag2;
        flag2 = false;
        i = 0;
        byte0 = 0;
        flag1 = false;
        flag = false;
        static class _cls6
        {

            static final int $SwitchMap$com$amazon$gallery$framework$kindle$ui$NoContentOverlay$ContentMode[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$kindle$ui$NoContentOverlay$ContentMode = new int[com.amazon.gallery.framework.kindle.ui.NoContentOverlay.ContentMode.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$ui$NoContentOverlay$ContentMode[com.amazon.gallery.framework.kindle.ui.NoContentOverlay.ContentMode.DEVICE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$ui$NoContentOverlay$ContentMode[com.amazon.gallery.framework.kindle.ui.NoContentOverlay.ContentMode.ALL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$ui$NoContentOverlay$ContentMode[com.amazon.gallery.framework.kindle.ui.NoContentOverlay.ContentMode.VIDEOS.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$ui$NoContentOverlay$ContentMode[com.amazon.gallery.framework.kindle.ui.NoContentOverlay.ContentMode.CAMERA.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$kindle$ui$NoContentOverlay$ContentMode[com.amazon.gallery.framework.kindle.ui.NoContentOverlay.ContentMode.HIDDEN.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls6..SwitchMap.com.amazon.gallery.framework.kindle.ui.NoContentOverlay.ContentMode[noContentMode.ordinal()];
        JVM INSTR tableswitch 1 5: default 60
    //                   1 224
    //                   2 233
    //                   3 241
    //                   4 252
    //                   5 261;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        break; /* Loop/switch isn't completed */
_L6:
        break MISSING_BLOCK_LABEL_261;
_L7:
        View view = cameraRow;
        int j;
        if (hasCamera && (i != 0 || byte0 != 0))
        {
            j = 0;
        } else
        {
            j = 8;
        }
        view.setVisibility(j);
        view = mobileRow;
        if (!((DeviceAttributeStore)ThorGalleryApplication.getBean(Keys.DEVICE_ATTRIBUTE_STORE)).isTablet() || i != 0 || byte0 != 0 || flag)
        {
            j = 8;
        } else
        {
            j = 0;
        }
        view.setVisibility(j);
        view = pcRow;
        if (BuildFlavors.isAosp() || i != 0 || byte0 != 0 || flag)
        {
            j = 8;
        } else
        {
            j = 0;
        }
        view.setVisibility(j);
        view = facebookRow;
        if (!showFacebook || flag1 || i != 0 || byte0 != 0 || flag)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        view.setVisibility(byte0);
        view = usbRow;
        if (i != 0)
        {
            i = ((flag2) ? 1 : 0);
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        return;
_L2:
        i = 1;
        setEmptyDeviceMode();
          goto _L7
_L3:
        setEmptyLibraryMode(false);
          goto _L7
_L4:
        flag1 = true;
        setEmptyLibraryMode(true);
          goto _L7
_L5:
        byte0 = 1;
        setEmptyCameraMode();
          goto _L7
        setEmptyHiddenMode();
        flag = true;
          goto _L7
    }

    public void usbInstructionsMode(boolean flag)
    {
        byte byte0 = 8;
        usbMode = flag;
        Object obj = getView().findViewById(0x7f0c019f);
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
        obj = getView().findViewById(0x7f0c0199);
        if (flag)
        {
            i = 8;
        } else
        {
            i = 0;
        }
        ((View) (obj)).setVisibility(i);
        obj = header;
        if (flag)
        {
            i = 8;
        } else
        {
            i = 0;
        }
        ((TextView) (obj)).setVisibility(i);
        obj = getView().findViewById(0x7f0c0197);
        if (flag)
        {
            i = 8;
        } else
        {
            i = 0;
        }
        ((View) (obj)).setVisibility(i);
        obj = getView().findViewById(0x7f0c0198);
        if (flag)
        {
            i = byte0;
        } else
        {
            i = 0;
        }
        ((View) (obj)).setVisibility(i);
    }


}
