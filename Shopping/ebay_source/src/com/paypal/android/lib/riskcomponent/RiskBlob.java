// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.lib.riskcomponent;

import android.location.Location;
import com.paypal.android.lib.riskcomponent.utils.Util;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RiskBlob
{

    public String advertisingId;
    public String androidId;
    public long appFirstInstallTime;
    public String appGuid;
    public String appId;
    public long appLastUpdateTime;
    public String appVersion;
    public int baseStationId;
    public String bluetoothMacAddrs;
    public String bssid;
    public int cdmaNetworkId;
    public int cdmaSystemId;
    public int cellId;
    public String compVersion;
    public String confUrl;
    public String confVersion;
    public String connType;
    public Map customValues;
    public String deviceId;
    public String deviceModel;
    public String deviceName;
    public long deviceUptime;
    public Boolean ds;
    public String gsfId;
    public List ipAddresses;
    public String ipAddrs;
    public Boolean isEmulator;
    public Boolean isRooted;
    public List knownApps;
    public String line1Number;
    public String linkerId;
    public String localeCountry;
    public String localeLang;
    public Location location;
    public int locationAreaCode;
    public String macAddrs;
    public String networkOperator;
    public String osType;
    public String osVersion;
    public String pairingID;
    public String payloadType;
    public String phoneType;
    public String proxySetting;
    public String registrationId;
    public String riskCompSessionId;
    public Boolean roaming;
    public String serialNumber;
    public String simOperatorName;
    public String simSerialNumber;
    public Boolean smsEnabled;
    public int sourceApp;
    public String sourceAppVersion;
    public String ssid;
    public String subscriberId;
    public long timestamp;
    public long totalStorageSpace;
    public Integer tz;
    public String tzName;
    public String vpnSetting;

    public RiskBlob()
    {
        baseStationId = -1;
        cellId = -1;
        deviceUptime = -1L;
        locationAreaCode = -1;
        cdmaSystemId = -1;
        cdmaNetworkId = -1;
        sourceApp = -1;
        osType = "Android";
        payloadType = "full";
    }

    private void addCustomValues(JSONObject jsonobject)
    {
        if (customValues != null)
        {
            for (Iterator iterator = customValues.entrySet().iterator(); iterator.hasNext();)
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                try
                {
                    jsonobject.put((String)entry.getKey(), entry.getValue());
                }
                catch (JSONException jsonexception)
                {
                    Util.logExceptionSliently(null, null, jsonexception);
                }
            }

        }
    }

    private JSONObject locationToJSONObject(Location location1)
    {
        if (location1 != null)
        {
            try
            {
                location1 = new JSONObject((new StringBuilder()).append("{\"lat\":").append(location1.getLatitude()).append(",\"lng\":").append(location1.getLongitude()).append(",\"acc\":").append(location1.getAccuracy()).append(",\"timestamp\":").append(location1.getTime()).append("}").toString());
            }
            // Misplaced declaration of an exception variable
            catch (Location location1)
            {
                return null;
            }
            return location1;
        } else
        {
            return null;
        }
    }

    public JSONObject toJSONObject()
    {
        Object obj1;
        JSONObject jsonobject;
        obj1 = null;
        jsonobject = new JSONObject();
        jsonobject.put("app_guid", appGuid);
        jsonobject.put("app_id", appId);
        jsonobject.put("app_version", appVersion);
        if (baseStationId != -1) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L23:
        jsonobject.put("base_station_id", obj);
        jsonobject.put("bssid", bssid);
        if (cellId != -1) goto _L4; else goto _L3
_L3:
        obj = null;
_L24:
        jsonobject.put("cell_id", obj);
        jsonobject.put("comp_version", compVersion);
        jsonobject.put("conf_url", confUrl);
        jsonobject.put("conf_version", confVersion);
        jsonobject.put("conn_type", connType);
        jsonobject.put("device_id", deviceId);
        jsonobject.put("device_model", deviceModel);
        jsonobject.put("device_name", deviceName);
        if (deviceUptime != -1L) goto _L6; else goto _L5
_L5:
        obj = null;
_L25:
        jsonobject.put("device_uptime", obj);
        jsonobject.put("ip_addrs", ipAddrs);
        if (ipAddresses != null) goto _L8; else goto _L7
_L7:
        obj = null;
_L26:
        jsonobject.put("ip_addresses", obj);
        if (knownApps != null) goto _L10; else goto _L9
_L9:
        obj = null;
_L27:
        jsonobject.put("known_apps", obj);
        if (!"".equals(line1Number)) goto _L12; else goto _L11
_L11:
        obj = null;
_L28:
        jsonobject.put("line_1_number", obj);
        jsonobject.put("linker_id", linkerId);
        jsonobject.put("locale_country", localeCountry);
        jsonobject.put("locale_lang", localeLang);
        jsonobject.put("location", locationToJSONObject(location));
        if (locationAreaCode != -1) goto _L14; else goto _L13
_L13:
        obj = null;
_L29:
        jsonobject.put("location_area_code", obj);
        jsonobject.put("mac_addrs", macAddrs);
        jsonobject.put("os_type", osType);
        jsonobject.put("os_version", osVersion);
        jsonobject.put("payload_type", payloadType);
        jsonobject.put("phone_type", phoneType);
        jsonobject.put("risk_comp_session_id", riskCompSessionId);
        jsonobject.put("roaming", roaming);
        if (!"".equals(simOperatorName)) goto _L16; else goto _L15
_L15:
        obj = null;
_L30:
        jsonobject.put("sim_operator_name", obj);
        jsonobject.put("sim_serial_number", simSerialNumber);
        jsonobject.put("sms_enabled", smsEnabled);
        jsonobject.put("ssid", ssid);
        if (cdmaNetworkId != -1) goto _L18; else goto _L17
_L17:
        obj = null;
_L31:
        jsonobject.put("cdma_network_id", obj);
        if (cdmaSystemId != -1) goto _L20; else goto _L19
_L19:
        obj = null;
_L32:
        jsonobject.put("cdma_system_id", obj);
        jsonobject.put("subscriber_id", subscriberId);
        jsonobject.put("timestamp", timestamp);
        jsonobject.put("total_storage_space", totalStorageSpace);
        jsonobject.put("tz_name", tzName);
        jsonobject.put("ds", ds);
        jsonobject.put("tz", tz);
        jsonobject.put("network_operator", networkOperator);
        if (sourceApp != -1) goto _L22; else goto _L21
_L21:
        obj = obj1;
_L33:
        int i;
        try
        {
            jsonobject.put("source_app", obj);
            jsonobject.put("source_app_version", sourceAppVersion);
            jsonobject.put("is_emulator", isEmulator);
            jsonobject.put("is_rooted", isRooted);
            jsonobject.put("pairing_id", pairingID);
            jsonobject.put("app_first_install_time", appFirstInstallTime);
            jsonobject.put("app_last_update_time", appLastUpdateTime);
            jsonobject.put("android_id", androidId);
            jsonobject.put("serial_number", serialNumber);
            jsonobject.put("advertising_identifier", advertisingId);
            jsonobject.put("notif_token", registrationId);
            jsonobject.put("bluetooth_mac_addrs", bluetoothMacAddrs);
            jsonobject.put("gsf_id", gsfId);
            jsonobject.put("VPN_setting", vpnSetting);
            jsonobject.put("proxy_setting", proxySetting);
            addCustomValues(jsonobject);
        }
        catch (JSONException jsonexception)
        {
            return jsonobject;
        }
        return jsonobject;
_L2:
        obj = Integer.valueOf(baseStationId);
          goto _L23
_L4:
        obj = Integer.valueOf(cellId);
          goto _L24
_L6:
        obj = Long.valueOf(deviceUptime);
          goto _L25
_L8:
        obj = new JSONArray(ipAddresses);
          goto _L26
_L10:
        obj = new JSONArray(knownApps);
          goto _L27
_L12:
        obj = line1Number;
          goto _L28
_L14:
        obj = Integer.valueOf(locationAreaCode);
          goto _L29
_L16:
        obj = simOperatorName;
          goto _L30
_L18:
        obj = Integer.valueOf(cdmaNetworkId);
          goto _L31
_L20:
        obj = Integer.valueOf(cdmaSystemId);
          goto _L32
_L22:
        i = sourceApp;
        obj = Integer.valueOf(i);
          goto _L33
    }
}
