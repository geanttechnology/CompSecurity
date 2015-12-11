// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import com.gotv.crackle.Application;
import com.gotv.crackle.ApplicationConstants;
import com.gotv.crackle.base.BaseActivity;
import com.gotv.crackle.helpers.SharedPrefsManager;
import com.gotv.crackle.model.CountryListItem;
import com.gotv.crackle.util.CrackleHMAC;
import com.gotv.crackle.util.Log;
import com.gotv.crackle.util.NetworkUtil;
import com.gotv.crackle.util.OmnitureWrapper;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.gotv.crackle.data:
//            DataRequest

public class Localization
{

    private static final int ALLOWED_LOCATIONS_ERROR_CODE_BASE = 1100;
    private static final String COUNTRY_CODE = "CountryCode";
    private static final int GET_LOCATION_ERROR_CODE_BASE = 1200;
    private static final String IP_ADDRESS = "IPAddress";
    public static final String LATIN_AMERICA_LOCALE_CODE = "2";
    private static final String SOFTWARE_VERISON = "SoftwareVersion";
    private static final String SUPPORTED_REGIONS = "SupportedRegions";
    public static final String TAG_GET_ALLOWED_LOCATIONS = "GetAllowedLocations";
    public static final String TAG_GET_LOCATION = "GetLocation";
    private static final String UNREACHABLE_COUNTRY_CODE = "UNREACHABLE";
    private static final String UPGRADE_LINK = "UpgradeLink";
    private static final String UPGRADE_MESSAGE = "UpgradeMessage";
    private DataRequest.RequestState mAllowedCountriesRequestState;
    private List mAllowedCountryList;
    private String mCurrentCountryCode;
    private DataRequest.RequestState mCurrentCountryRequestState;
    private String mIPAddress;
    private Map mLocaleBaseURLMap;
    private String mSoftwareVersion;
    private String mUpgradeLink;
    private String mUpgradeMessage;

    public Localization()
    {
        mCurrentCountryCode = "";
        mIPAddress = "";
        mAllowedCountryList = new ArrayList();
        mLocaleBaseURLMap = new HashMap();
        mAllowedCountriesRequestState = DataRequest.RequestState.IDLE;
        mCurrentCountryRequestState = DataRequest.RequestState.IDLE;
    }

    private String getUIType()
    {
        String s = getCurrentCountryCode();
        return ((CountryListItem)mLocaleBaseURLMap.get(s)).getUITemplateType();
    }

    public boolean allRequestsComplete()
    {
        Log.d("LOADING", (new StringBuilder()).append("LOADING allowedState = ").append(mAllowedCountriesRequestState).append(" countryCodeState = ").append(mCurrentCountryRequestState).toString());
        return mAllowedCountriesRequestState == DataRequest.RequestState.COMPLETE && mCurrentCountryRequestState == DataRequest.RequestState.COMPLETE;
    }

    public DataRequest.RequestState getAllowedCountriesRequestState()
    {
        return mAllowedCountriesRequestState;
    }

    public void getAllowedLocations(boolean flag)
    {
        Object obj;
        obj = String.format(ApplicationConstants.GET_ALLOWED_LOCATIONS_URL, new Object[] {
            "json"
        });
        mAllowedCountriesRequestState = DataRequest.RequestState.RUNNING;
        Object obj2 = CrackleHMAC.encodeURL(((String) (obj)));
        HashMap hashmap = new HashMap();
        hashmap.put("Authorization", obj2);
        obj2 = NetworkUtil.getJSONFromUrl(((String) (obj)), hashmap);
        obj = ((JSONObject) (obj2)).getJSONArray("SupportedRegions");
        mSoftwareVersion = ((JSONObject) (obj2)).getString("SoftwareVersion");
        mUpgradeLink = ((JSONObject) (obj2)).getString("UpgradeLink");
        mUpgradeMessage = ((JSONObject) (obj2)).getString("UpgradeMessage");
        int i = 0;
_L2:
        if (i >= ((JSONArray) (obj)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        CountryListItem countrylistitem = new CountryListItem(((JSONArray) (obj)).getJSONObject(i));
        mAllowedCountryList.add(countrylistitem.getCountryCode());
        mLocaleBaseURLMap.put(countrylistitem.getCountryCode(), countrylistitem);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_200;
        }
        mAllowedCountriesRequestState = DataRequest.RequestState.COMPLETE;
        if (Application.getInstance().getCurrentActivity() != null)
        {
            ((BaseActivity)Application.getInstance().getCurrentActivity().get()).runOnUiThread(new Runnable() {

                final Localization this$0;

                public void run()
                {
                    ((BaseActivity)Application.getInstance().getCurrentActivity().get()).onDataSuccess("GetAllowedLocations");
                }

            
            {
                this$0 = Localization.this;
                super();
            }
            });
        }
_L4:
        return;
        Object obj1;
        obj1;
        mAllowedCountriesRequestState = DataRequest.RequestState.FAILED;
        if (!flag || Application.getInstance().getCurrentActivity() == null) goto _L4; else goto _L3
_L3:
        ((BaseActivity)Application.getInstance().getCurrentActivity().get()).runOnUiThread(new Runnable() {

            final Localization this$0;

            public void run()
            {
                ((BaseActivity)Application.getInstance().getCurrentActivity().get()).onDataFailed("GetAllowedLocations", DataRequest.getParseErrorString(1100));
            }

            
            {
                this$0 = Localization.this;
                super();
            }
        });
        return;
        obj1;
        if (!flag) goto _L4; else goto _L5
_L5:
        mAllowedCountriesRequestState = DataRequest.RequestState.FAILED;
        if (Application.getInstance().getCurrentActivity() == null) goto _L4; else goto _L6
_L6:
        ((BaseActivity)Application.getInstance().getCurrentActivity().get()).runOnUiThread(new Runnable() {

            final Localization this$0;

            public void run()
            {
                ((BaseActivity)Application.getInstance().getCurrentActivity().get()).onDataFailed("GetAllowedLocations", DataRequest.getNetworkErrorString(1100));
            }

            
            {
                this$0 = Localization.this;
                super();
            }
        });
        return;
        obj1;
        if (flag)
        {
            mAllowedCountriesRequestState = DataRequest.RequestState.FAILED;
            if (Application.getInstance().getCurrentActivity() != null)
            {
                ((BaseActivity)Application.getInstance().getCurrentActivity().get()).runOnUiThread(new Runnable() {

                    final Localization this$0;

                    public void run()
                    {
                        ((BaseActivity)Application.getInstance().getCurrentActivity().get()).onDataFailed("GetAllowedLocations", DataRequest.getURIExceptionString(1100));
                    }

            
            {
                this$0 = Localization.this;
                super();
            }
                });
                return;
            }
        }
          goto _L4
    }

    public void getAllowedLocationsAsync()
    {
        Log.d("LOADING", "LOADING getAllowedLocations");
        mAllowedCountriesRequestState = DataRequest.RequestState.IDLE;
        (new Thread() {

            final Localization this$0;

            public void run()
            {
                getAllowedLocations(true);
            }

            
            {
                this$0 = Localization.this;
                super();
            }
        }).start();
    }

    public String getApiHostName()
    {
        return ((CountryListItem)mLocaleBaseURLMap.get(getCurrentCountryCode())).getApiHostName();
    }

    public String getCurrentCountryCode()
    {
        return mCurrentCountryCode;
    }

    public DataRequest.RequestState getCurrentCountryRequestState()
    {
        return mCurrentCountryRequestState;
    }

    public String getLoacalizedBaseURL()
    {
        while (true) 
        {
            try
            {
                if (Application.getInstance().mOmnitureTracker == null)
                {
                    if (isLatinAmericaUI())
                    {
                        Application.getInstance().mOmnitureTracker = new OmnitureWrapper("crackleprodlatam");
                    } else
                    {
                        Application.getInstance().mOmnitureTracker = new OmnitureWrapper("crackleprod");
                    }
                }
                return (new StringBuilder()).append(((CountryListItem)mLocaleBaseURLMap.get(getCurrentCountryCode())).getApiHostName()).append("/Service.svc").toString();
            }
            catch (Exception exception)
            {
                Application.getInstance().getLocalization().updateCurrentLocation(false);
            }
            Application.getInstance().getLocalization().getAllowedLocations(false);
        }
        return (new StringBuilder()).append(((CountryListItem)mLocaleBaseURLMap.get(getCurrentCountryCode())).getApiHostName()).append("/Service.svc").toString();
    }

    public String getPublicIPAddress()
    {
        return mIPAddress;
    }

    public String getSoftwareVersion()
    {
        return mSoftwareVersion;
    }

    public String getUpgradeLink()
    {
        return mUpgradeLink;
    }

    public String getUpgradeMessage()
    {
        return mUpgradeMessage;
    }

    public boolean isCurrentCountryCodeValid()
    {
        for (Iterator iterator = mAllowedCountryList.iterator(); iterator.hasNext();)
        {
            if (((String)iterator.next()).compareTo(mCurrentCountryCode) == 0)
            {
                return true;
            }
        }

        return false;
    }

    public boolean isLatinAmericaUI()
    {
        boolean flag;
        try
        {
            flag = getUIType().equalsIgnoreCase("2");
            SharedPrefsManager.setLastIsLatamValue(flag);
        }
        catch (Exception exception)
        {
            return SharedPrefsManager.getLastIsLatamValue();
        }
        return flag;
    }

    public void updateCurrentLocation(boolean flag)
    {
        Object obj;
        String s;
        obj = String.format(ApplicationConstants.GET_LOCATION_URL, new Object[] {
            "json"
        });
        mCurrentCountryRequestState = DataRequest.RequestState.RUNNING;
        s = CrackleHMAC.encodeURL(((String) (obj)));
        HashMap hashmap = new HashMap();
        hashmap.put("Authorization", s);
        obj = NetworkUtil.getJSONFromUrl(((String) (obj)), hashmap);
        s = ((JSONObject) (obj)).getString("CountryCode");
        if (s == null) goto _L2; else goto _L1
_L1:
        if (SharedPrefsManager.getIsPushEnabled())
        {
            (new HashSet(1)).add(s);
        }
        if (mCurrentCountryCode.compareTo("") != 0 && s.compareTo(mCurrentCountryCode) != 0)
        {
            Application.getInstance().restartApplication();
        }
        mIPAddress = ((JSONObject) (obj)).getString("IPAddress");
        mCurrentCountryCode = s;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_187;
        }
        mCurrentCountryRequestState = DataRequest.RequestState.COMPLETE;
        if (Application.getInstance().getCurrentActivity() == null)
        {
            break MISSING_BLOCK_LABEL_187;
        }
        obj = Application.getInstance().getCurrentActivity().get();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_187;
        }
        ((BaseActivity)Application.getInstance().getCurrentActivity().get()).runOnUiThread(new Runnable() {

            final Localization this$0;

            public void run()
            {
                ((BaseActivity)Application.getInstance().getCurrentActivity().get()).onDataSuccess("GetLocation");
            }

            
            {
                this$0 = Localization.this;
                super();
            }
        });
_L4:
        return;
_L2:
        mCurrentCountryRequestState = DataRequest.RequestState.FAILED;
        if (!flag) goto _L4; else goto _L3
_L3:
        if (Application.getInstance().getCurrentActivity() == null) goto _L4; else goto _L5
_L5:
        obj = Application.getInstance().getCurrentActivity().get();
        if (obj == null)
        {
            try
            {
                ((BaseActivity)Application.getInstance().getCurrentActivity().get()).runOnUiThread(new Runnable() {

                    final Localization this$0;

                    public void run()
                    {
                        mCurrentCountryCode = "UNREACHABLE";
                        ((BaseActivity)Application.getInstance().getCurrentActivity().get()).onDataFailed("GetLocation", Application.getInstance().getString(0x7f0b0140));
                    }

            
            {
                this$0 = Localization.this;
                super();
            }
                });
                return;
            }
            catch (Exception exception)
            {
                return;
            }
            catch (JSONException jsonexception)
            {
                mCurrentCountryRequestState = DataRequest.RequestState.FAILED;
                if (flag && Application.getInstance().getCurrentActivity() != null)
                {
                    ((BaseActivity)Application.getInstance().getCurrentActivity().get()).runOnUiThread(new Runnable() {

                        final Localization this$0;

                        public void run()
                        {
                            mCurrentCountryCode = "UNREACHABLE";
                            ((BaseActivity)Application.getInstance().getCurrentActivity().get()).onDataFailed("GetLocation", DataRequest.getParseErrorString(1200));
                        }

            
            {
                this$0 = Localization.this;
                super();
            }
                    });
                    return;
                }
            }
            catch (IOException ioexception)
            {
                mCurrentCountryRequestState = DataRequest.RequestState.FAILED;
                if (flag && Application.getInstance().getCurrentActivity() != null)
                {
                    ((BaseActivity)Application.getInstance().getCurrentActivity().get()).runOnUiThread(new Runnable() {

                        final Localization this$0;

                        public void run()
                        {
                            mCurrentCountryCode = "UNREACHABLE";
                            ((BaseActivity)Application.getInstance().getCurrentActivity().get()).onDataFailed("GetLocation", DataRequest.getNetworkErrorString(1200));
                        }

            
            {
                this$0 = Localization.this;
                super();
            }
                    });
                    return;
                }
            }
            catch (URISyntaxException urisyntaxexception)
            {
                mCurrentCountryRequestState = DataRequest.RequestState.FAILED;
                if (flag && Application.getInstance().getCurrentActivity() != null)
                {
                    ((BaseActivity)Application.getInstance().getCurrentActivity().get()).runOnUiThread(new Runnable() {

                        final Localization this$0;

                        public void run()
                        {
                            mCurrentCountryRequestState = DataRequest.RequestState.FAILED;
                            mCurrentCountryCode = "UNREACHABLE";
                            ((BaseActivity)Application.getInstance().getCurrentActivity().get()).onDataFailed("GetLocation", DataRequest.getURIExceptionString(1200));
                        }

            
            {
                this$0 = Localization.this;
                super();
            }
                    });
                    return;
                }
            }
        }
          goto _L4
        Exception exception1;
        exception1;
    }

    public void updateCurrentLocationAsync()
    {
        Log.d("LOADING", "LOADING updateCurrentCountry");
        mCurrentCountryRequestState = DataRequest.RequestState.IDLE;
        (new Thread() {

            final Localization this$0;

            public void run()
            {
                updateCurrentLocation(true);
            }

            
            {
                this$0 = Localization.this;
                super();
            }
        }).start();
    }


/*
    static String access$002(Localization localization, String s)
    {
        localization.mCurrentCountryCode = s;
        return s;
    }

*/


/*
    static DataRequest.RequestState access$102(Localization localization, DataRequest.RequestState requeststate)
    {
        localization.mCurrentCountryRequestState = requeststate;
        return requeststate;
    }

*/
}
