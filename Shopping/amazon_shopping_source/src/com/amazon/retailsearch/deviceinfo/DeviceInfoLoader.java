// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.deviceinfo;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;
import com.amazon.searchapp.retailsearch.client.DeviceInformation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

// Referenced classes of package com.amazon.retailsearch.deviceinfo:
//            DeviceProfile, DeviceInfoClient

public class DeviceInfoLoader
{
    private class DeviceInfoTask
        implements Runnable
    {

        private final Context context;
        final DeviceInfoLoader this$0;
        private final int ver;

        private void fetch()
        {
            com.amazon.searchapp.retailsearch.client.DeviceInformation.Builder builder = new com.amazon.searchapp.retailsearch.client.DeviceInformation.Builder(DeviceInfoLoader.createDefaultDeviceInfo(context));
            Object obj = (new DeviceInfoClient()).getDeviceInfo(context);
            if (obj == null || ((Map) (obj)).isEmpty() || ver != version.get())
            {
                return;
            }
            Iterator iterator = ((Map) (obj)).entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                String s = (String)entry.getKey();
                if (s != null && !MasField.SearchContext.getName().equals(s) && !MasField.DeviceInfo.getName().equals(s))
                {
                    readValue(s, (String)entry.getValue(), builder);
                }
            } while (true);
            obj = (String)((Map) (obj)).get(MasField.SearchContext.getName());
            if (obj != null)
            {
                readSearchContext(((String) (obj)), builder);
            }
            synchronized (updateLock)
            {
                if (ver == version.get())
                {
                    deviceInfo = builder.build();
                }
            }
            return;
            exception;
            obj1;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private void readSearchContext(String s, com.amazon.searchapp.retailsearch.client.DeviceInformation.Builder builder)
        {
            s = (new JSONObject(s)).getJSONObject(MasField.DeviceInfo.getName());
            if (s == null)
            {
                return;
            }
            Iterator iterator = s.keys();
_L2:
            String s1;
            do
            {
                if (!iterator.hasNext())
                {
                    break MISSING_BLOCK_LABEL_84;
                }
                s1 = (String)iterator.next();
            } while (s1 == null);
            readValue(s1, (String)s.get(s1), builder);
            if (true) goto _L2; else goto _L1
_L1:
            s;
            DeviceInfoLoader.log.error("Parse searchContext", s);
        }

        private void readValue(String s, String s1, com.amazon.searchapp.retailsearch.client.DeviceInformation.Builder builder)
        {
            if (s == null || s1 == null)
            {
                return;
            }
            MasField masfield = MasField.find(s);
            if (masfield == null)
            {
                DeviceInfoLoader.log.warn((new StringBuilder()).append("Unknown device info field: ").append(s).append(": ").append(s1).toString());
                return;
            }
            static class _cls1
            {

                static final int $SwitchMap$com$amazon$retailsearch$deviceinfo$DeviceInfoLoader$MasField[];

                static 
                {
                    $SwitchMap$com$amazon$retailsearch$deviceinfo$DeviceInfoLoader$MasField = new int[MasField.values().length];
                    try
                    {
                        $SwitchMap$com$amazon$retailsearch$deviceinfo$DeviceInfoLoader$MasField[MasField.BuildFingerprint.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror13) { }
                    try
                    {
                        $SwitchMap$com$amazon$retailsearch$deviceinfo$DeviceInfoLoader$MasField[MasField.BuildProduct.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror12) { }
                    try
                    {
                        $SwitchMap$com$amazon$retailsearch$deviceinfo$DeviceInfoLoader$MasField[MasField.Carrier.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror11) { }
                    try
                    {
                        $SwitchMap$com$amazon$retailsearch$deviceinfo$DeviceInfoLoader$MasField[MasField.DeviceDensityClassification.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror10) { }
                    try
                    {
                        $SwitchMap$com$amazon$retailsearch$deviceinfo$DeviceInfoLoader$MasField[MasField.DeviceDescriptorId.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror9) { }
                    try
                    {
                        $SwitchMap$com$amazon$retailsearch$deviceinfo$DeviceInfoLoader$MasField[MasField.DeviceScrenLayout.ordinal()] = 6;
                    }
                    catch (NoSuchFieldError nosuchfielderror8) { }
                    try
                    {
                        $SwitchMap$com$amazon$retailsearch$deviceinfo$DeviceInfoLoader$MasField[MasField.DeviceType.ordinal()] = 7;
                    }
                    catch (NoSuchFieldError nosuchfielderror7) { }
                    try
                    {
                        $SwitchMap$com$amazon$retailsearch$deviceinfo$DeviceInfoLoader$MasField[MasField.Manufacturer.ordinal()] = 8;
                    }
                    catch (NoSuchFieldError nosuchfielderror6) { }
                    try
                    {
                        $SwitchMap$com$amazon$retailsearch$deviceinfo$DeviceInfoLoader$MasField[MasField.Model.ordinal()] = 9;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    try
                    {
                        $SwitchMap$com$amazon$retailsearch$deviceinfo$DeviceInfoLoader$MasField[MasField.OsVersion.ordinal()] = 10;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$com$amazon$retailsearch$deviceinfo$DeviceInfoLoader$MasField[MasField.PhoneType.ordinal()] = 11;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$amazon$retailsearch$deviceinfo$DeviceInfoLoader$MasField[MasField.Ref.ordinal()] = 12;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$amazon$retailsearch$deviceinfo$DeviceInfoLoader$MasField[MasField.Serial.ordinal()] = 13;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$amazon$retailsearch$deviceinfo$DeviceInfoLoader$MasField[MasField.SimOperator.ordinal()] = 14;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.com.amazon.retailsearch.deviceinfo.DeviceInfoLoader.MasField[masfield.ordinal()])
            {
            default:
                return;

            case 1: // '\001'
                builder.setBuildFingerprint(s1);
                return;

            case 2: // '\002'
                builder.setBuildProduct(s1);
                return;

            case 3: // '\003'
                builder.setCarrier(s1);
                return;

            case 4: // '\004'
                builder.setDeviceDensityClassification(s1);
                return;

            case 5: // '\005'
                builder.setDeviceDescriptorId(s1);
                return;

            case 6: // '\006'
                builder.setDeviceScreenLayout(s1);
                return;

            case 7: // '\007'
                builder.setDeviceType(s1);
                return;

            case 8: // '\b'
                builder.setManufacturer(s1);
                return;

            case 9: // '\t'
                builder.setModel(s1);
                return;

            case 10: // '\n'
                builder.setOsVersion(s1);
                return;

            case 11: // '\013'
                builder.setPhoneType(s1);
                return;

            case 12: // '\f'
                builder.setRef(s1);
                return;

            case 13: // '\r'
                builder.setSerial(s1);
                return;

            case 14: // '\016'
                builder.setSimOperator(s1);
                break;
            }
        }

        public void run()
        {
            try
            {
                fetch();
                return;
            }
            catch (Exception exception)
            {
                DeviceInfoLoader.log.error("Device info load", exception);
            }
        }

        public DeviceInfoTask(Context context1)
        {
            this$0 = DeviceInfoLoader.this;
            super();
            context = context1;
            ver = version.incrementAndGet();
        }
    }

    private static final class MasField extends Enum
    {

        private static final MasField $VALUES[];
        public static final MasField BuildFingerprint;
        public static final MasField BuildProduct;
        public static final MasField Carrier;
        public static final MasField DeviceDensityClassification;
        public static final MasField DeviceDescriptorId;
        public static final MasField DeviceInfo;
        public static final MasField DeviceScrenLayout;
        public static final MasField DeviceType;
        public static final MasField Manufacturer;
        public static final MasField Model;
        public static final MasField OsVersion;
        public static final MasField PhoneType;
        public static final MasField Ref;
        public static final MasField SearchContext;
        public static final MasField Serial;
        public static final MasField SimOperator;
        private static final Map names;
        private final String name;

        public static MasField find(String s)
        {
            return (MasField)names.get(s);
        }

        public static MasField valueOf(String s)
        {
            return (MasField)Enum.valueOf(com/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField, s);
        }

        public static MasField[] values()
        {
            return (MasField[])$VALUES.clone();
        }

        public String getName()
        {
            return name;
        }

        static 
        {
            Carrier = new MasField("Carrier", 0, "carrier");
            Manufacturer = new MasField("Manufacturer", 1, "manufacturer");
            Model = new MasField("Model", 2, "model");
            DeviceType = new MasField("DeviceType", 3, "deviceType");
            DeviceDescriptorId = new MasField("DeviceDescriptorId", 4, "deviceDescriptorId");
            OsVersion = new MasField("OsVersion", 5, "osVersion");
            Ref = new MasField("Ref", 6, "ref");
            DeviceDensityClassification = new MasField("DeviceDensityClassification", 7, "deviceDensityClassification");
            DeviceScrenLayout = new MasField("DeviceScrenLayout", 8, "deviceScreenLayout");
            Serial = new MasField("Serial", 9, "serial");
            BuildProduct = new MasField("BuildProduct", 10, "build_product");
            BuildFingerprint = new MasField("BuildFingerprint", 11, "build_fingerprint");
            SimOperator = new MasField("SimOperator", 12, "simOperator");
            PhoneType = new MasField("PhoneType", 13, "phoneType");
            SearchContext = new MasField("SearchContext", 14, "searchContext");
            DeviceInfo = new MasField("DeviceInfo", 15, "deviceInfo");
            $VALUES = (new MasField[] {
                Carrier, Manufacturer, Model, DeviceType, DeviceDescriptorId, OsVersion, Ref, DeviceDensityClassification, DeviceScrenLayout, Serial, 
                BuildProduct, BuildFingerprint, SimOperator, PhoneType, SearchContext, DeviceInfo
            });
            HashMap hashmap = new HashMap(values().length);
            MasField amasfield[] = values();
            int j = amasfield.length;
            for (int i = 0; i < j; i++)
            {
                MasField masfield = amasfield[i];
                hashmap.put(masfield.getName(), masfield);
            }

            names = Collections.unmodifiableMap(hashmap);
        }

        private MasField(String s, int i, String s1)
        {
            super(s, i);
            name = s1;
        }
    }


    public static final int CONFIGURATION_SCREENLAYOUT_SIZE_XLARGE = 4;
    public static final int DEFAULT_DELAY = 750;
    public static final int TELEPHONY_PHONE_TYPE_SIP = 3;
    private static final String THIRD_PARTY_ANDROID = "A1MPSLFC7L5AFK";
    private static volatile DeviceInfoLoader loader;
    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/deviceinfo/DeviceInfoLoader);
    private static final Map phoneTypes;
    private static final Map screenFamilies;
    private volatile DeviceInformation deviceInfo;
    private Object updateLock;
    private AtomicInteger version;

    public DeviceInfoLoader()
    {
        deviceInfo = (new com.amazon.searchapp.retailsearch.client.DeviceInformation.Builder()).build();
        version = new AtomicInteger(0);
        updateLock = new Object();
    }

    private static DeviceInformation createDefaultDeviceInfo(Context context)
    {
        com.amazon.searchapp.retailsearch.client.DeviceInformation.Builder builder = new com.amazon.searchapp.retailsearch.client.DeviceInformation.Builder();
        DisplayMetrics displaymetrics;
        try
        {
            builder.setCarrier(DeviceProfile.getSimOperatorName(context));
        }
        catch (Exception exception)
        {
            log.error("SIM operator name", exception);
        }
        builder.setManufacturer(Build.MANUFACTURER);
        builder.setModel(Build.MODEL);
        builder.setDeviceType(getDefaultDeviceType());
        builder.setOsVersion(String.valueOf(android.os.Build.VERSION.SDK_INT));
        displaymetrics = getDisplayMetrics(context);
        if (displaymetrics != null)
        {
            try
            {
                builder.setDeviceDensityClassification(String.valueOf(displaymetrics.densityDpi));
            }
            catch (Exception exception1)
            {
                log.error("Density classification", exception1);
            }
        }
        try
        {
            builder.setDeviceScreenLayout(getScreenFamily(context));
        }
        catch (Exception exception2)
        {
            log.error("Screen layout", exception2);
        }
        builder.setSerial(DeviceProfile.getSerial());
        builder.setBuildProduct(Build.PRODUCT);
        builder.setBuildFingerprint(Build.FINGERPRINT);
        try
        {
            builder.setSimOperator(DeviceProfile.getSimOperator(context));
        }
        catch (Exception exception3)
        {
            log.error("SIM operator", exception3);
        }
        try
        {
            builder.setPhoneType((String)phoneTypes.get(Integer.valueOf(DeviceProfile.getPhoneType(context))));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            log.error("Phone type", context);
        }
        return builder.build();
    }

    private static String getDefaultDeviceType()
    {
        return "A1MPSLFC7L5AFK";
    }

    private static DisplayMetrics getDisplayMetrics(Context context)
    {
        context = (WindowManager)context.getSystemService("window");
        DisplayMetrics displaymetrics = new DisplayMetrics();
        context.getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics;
    }

    public static DeviceInfoLoader getInstance()
    {
        com/amazon/retailsearch/deviceinfo/DeviceInfoLoader;
        JVM INSTR monitorenter ;
        DeviceInfoLoader deviceinfoloader;
        if (loader == null)
        {
            loader = new DeviceInfoLoader();
        }
        deviceinfoloader = loader;
        com/amazon/retailsearch/deviceinfo/DeviceInfoLoader;
        JVM INSTR monitorexit ;
        return deviceinfoloader;
        Exception exception;
        exception;
        throw exception;
    }

    private static String getScreenFamily(Context context)
    {
        int i = context.getResources().getConfiguration().screenLayout;
        return (String)screenFamilies.get(Integer.valueOf(i & 0xf));
    }

    public DeviceInformation getDeviceInfo()
    {
        return deviceInfo;
    }

    public void load(Context context)
    {
        load(context, 0);
    }

    public void load(Context context, int i)
    {
        try
        {
            context = new DeviceInfoTask(context);
            (new ScheduledThreadPoolExecutor(1)).schedule(context, i, TimeUnit.MILLISECONDS);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            log.error("Device info load", context);
        }
    }

    public DeviceInformation loadDefaults(Context context)
    {
        context = createDefaultDeviceInfo(context);
        deviceInfo = context;
        return context;
        context;
        log.error("Default device info", context);
        deviceInfo = null;
        return null;
        context;
        deviceInfo = null;
        throw context;
    }

    public void loadSync(Context context)
    {
        try
        {
            (new DeviceInfoTask(context)).run();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            log.error("Device info load", context);
        }
    }

    public void refresh(Context context)
    {
        refresh(context, 0);
    }

    public void refresh(Context context, int i)
    {
        loadDefaults(context);
        load(context, i);
    }

    static 
    {
        HashMap hashmap = new HashMap(4);
        hashmap.put(Integer.valueOf(0), "PHONE_TYPE_NONE");
        hashmap.put(Integer.valueOf(1), "PHONE_TYPE_GSM");
        hashmap.put(Integer.valueOf(2), "PHONE_TYPE_CDMA");
        hashmap.put(Integer.valueOf(3), "PHONE_TYPE_SIP");
        phoneTypes = Collections.unmodifiableMap(hashmap);
        hashmap = new HashMap(4);
        hashmap.put(Integer.valueOf(4), "SCREENLAYOUT_SIZE_XLARGE");
        hashmap.put(Integer.valueOf(3), "SCREENLAYOUT_SIZE_LARGE");
        hashmap.put(Integer.valueOf(2), "SCREENLAYOUT_SIZE_NORMAL");
        hashmap.put(Integer.valueOf(1), "SCREENLAYOUT_SIZE_SMALL");
        screenFamilies = Collections.unmodifiableMap(hashmap);
    }






/*
    static DeviceInformation access$402(DeviceInfoLoader deviceinfoloader, DeviceInformation deviceinformation)
    {
        deviceinfoloader.deviceInfo = deviceinformation;
        return deviceinformation;
    }

*/
}
