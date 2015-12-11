// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.lib.riskcomponent.utils;


public final class PPRiskData extends Enum
{

    private static final PPRiskData $VALUES[];
    public static final PPRiskData PPRiskDataAdvertisingIdentifier;
    public static final PPRiskData PPRiskDataAnId;
    public static final PPRiskData PPRiskDataAndroidId;
    public static final PPRiskData PPRiskDataAppFirstInstallTime;
    public static final PPRiskData PPRiskDataAppGuid;
    public static final PPRiskData PPRiskDataAppId;
    public static final PPRiskData PPRiskDataAppLastUpdateTime;
    public static final PPRiskData PPRiskDataAppVersion;
    public static final PPRiskData PPRiskDataBaseStationId;
    public static final PPRiskData PPRiskDataBluetoothMacAddress;
    public static final PPRiskData PPRiskDataBssid;
    public static final PPRiskData PPRiskDataCdmaNetworkId;
    public static final PPRiskData PPRiskDataCdmaSystemId;
    public static final PPRiskData PPRiskDataCellId;
    public static final PPRiskData PPRiskDataCloudIdentifier;
    public static final PPRiskData PPRiskDataClrVersion;
    public static final PPRiskData PPRiskDataCompVersion;
    public static final PPRiskData PPRiskDataConfUrl;
    public static final PPRiskData PPRiskDataConfVersion;
    public static final PPRiskData PPRiskDataConnType;
    public static final PPRiskData PPRiskDataDeviceFirmwareVersion;
    public static final PPRiskData PPRiskDataDeviceId;
    public static final PPRiskData PPRiskDataDeviceModel;
    public static final PPRiskData PPRiskDataDeviceName;
    public static final PPRiskData PPRiskDataDeviceUptime;
    public static final PPRiskData PPRiskDataDongleDeviceId;
    public static final PPRiskData PPRiskDataEmailConfigured;
    public static final PPRiskData PPRiskDataEmulator;
    public static final PPRiskData PPRiskDataError;
    public static final PPRiskData PPRiskDataGeoCountry;
    public static final PPRiskData PPRiskDataGsfId;
    public static final PPRiskData PPRiskDataIpAddrs;
    public static final PPRiskData PPRiskDataIsDaylightSaving;
    public static final PPRiskData PPRiskDataIsEmulator;
    public static final PPRiskData PPRiskDataIsRooted;
    public static final PPRiskData PPRiskDataKeyboardPresent;
    public static final PPRiskData PPRiskDataKnownApps;
    public static final PPRiskData PPRiskDataLicenseAccepted;
    public static final PPRiskData PPRiskDataLine1Number;
    public static final PPRiskData PPRiskDataLinkerId;
    public static final PPRiskData PPRiskDataLocalIdentifier;
    public static final PPRiskData PPRiskDataLocaleCountry;
    public static final PPRiskData PPRiskDataLocaleLang;
    public static final PPRiskData PPRiskDataLocation;
    public static final PPRiskData PPRiskDataLocationAreaCode;
    public static final PPRiskData PPRiskDataLocationAuthStatus;
    public static final PPRiskData PPRiskDataMacAddrs;
    public static final PPRiskData PPRiskDataMobileOperatorName;
    public static final PPRiskData PPRiskDataNetworkOperator;
    public static final PPRiskData PPRiskDataNotifToken;
    public static final PPRiskData PPRiskDataOsPlatform;
    public static final PPRiskData PPRiskDataOsType;
    public static final PPRiskData PPRiskDataOsVersion;
    public static final PPRiskData PPRiskDataPairingId;
    public static final PPRiskData PPRiskDataPayloadType;
    public static final PPRiskData PPRiskDataPhoneType;
    public static final PPRiskData PPRiskDataPinLockLastTimestamp;
    public static final PPRiskData PPRiskDataPowerSource;
    public static final PPRiskData PPRiskDataProxySetting;
    public static final PPRiskData PPRiskDataRiskCompSessionId;
    public static final PPRiskData PPRiskDataRoaming;
    public static final PPRiskData PPRiskDataRoamingPossible;
    public static final PPRiskData PPRiskDataSerialNumber;
    public static final PPRiskData PPRiskDataSimOperatorName;
    public static final PPRiskData PPRiskDataSimSerialNumber;
    public static final PPRiskData PPRiskDataSmsEnabled;
    public static final PPRiskData PPRiskDataSourceApp;
    public static final PPRiskData PPRiskDataSourceAppVersion;
    public static final PPRiskData PPRiskDataSsid;
    public static final PPRiskData PPRiskDataSubscriberId;
    public static final PPRiskData PPRiskDataTimeZoneOffset;
    public static final PPRiskData PPRiskDataTimestamp;
    public static final PPRiskData PPRiskDataTotalDeviceMemory;
    public static final PPRiskData PPRiskDataTotalStorageSpace;
    public static final PPRiskData PPRiskDataTzName;
    public static final PPRiskData PPRiskDataUnused1;
    public static final PPRiskData PPRiskDataUnused2;
    public static final PPRiskData PPRiskDataUnused3;
    public static final PPRiskData PPRiskDataUnused4;
    public static final PPRiskData PPRiskDataVPNSetting;
    public static final PPRiskData PPRiskDataVendorIdentifier;

    private PPRiskData(String s, int i)
    {
        super(s, i);
    }

    public static PPRiskData valueOf(String s)
    {
        return (PPRiskData)Enum.valueOf(com/paypal/android/lib/riskcomponent/utils/PPRiskData, s);
    }

    public static PPRiskData[] values()
    {
        return (PPRiskData[])$VALUES.clone();
    }

    static 
    {
        PPRiskDataAnId = new PPRiskData("PPRiskDataAnId", 0);
        PPRiskDataAppGuid = new PPRiskData("PPRiskDataAppGuid", 1);
        PPRiskDataAppId = new PPRiskData("PPRiskDataAppId", 2);
        PPRiskDataAppVersion = new PPRiskData("PPRiskDataAppVersion", 3);
        PPRiskDataBaseStationId = new PPRiskData("PPRiskDataBaseStationId", 4);
        PPRiskDataBssid = new PPRiskData("PPRiskDataBssid", 5);
        PPRiskDataCellId = new PPRiskData("PPRiskDataCellId", 6);
        PPRiskDataClrVersion = new PPRiskData("PPRiskDataClrVersion", 7);
        PPRiskDataCompVersion = new PPRiskData("PPRiskDataCompVersion", 8);
        PPRiskDataConfUrl = new PPRiskData("PPRiskDataConfUrl", 9);
        PPRiskDataConfVersion = new PPRiskData("PPRiskDataConfVersion", 10);
        PPRiskDataConnType = new PPRiskData("PPRiskDataConnType", 11);
        PPRiskDataDeviceFirmwareVersion = new PPRiskData("PPRiskDataDeviceFirmwareVersion", 12);
        PPRiskDataDeviceId = new PPRiskData("PPRiskDataDeviceId", 13);
        PPRiskDataDeviceModel = new PPRiskData("PPRiskDataDeviceModel", 14);
        PPRiskDataDeviceName = new PPRiskData("PPRiskDataDeviceName", 15);
        PPRiskDataDeviceUptime = new PPRiskData("PPRiskDataDeviceUptime", 16);
        PPRiskDataDongleDeviceId = new PPRiskData("PPRiskDataDongleDeviceId", 17);
        PPRiskDataEmailConfigured = new PPRiskData("PPRiskDataEmailConfigured", 18);
        PPRiskDataEmulator = new PPRiskData("PPRiskDataEmulator", 19);
        PPRiskDataError = new PPRiskData("PPRiskDataError", 20);
        PPRiskDataIpAddrs = new PPRiskData("PPRiskDataIpAddrs", 21);
        PPRiskDataKeyboardPresent = new PPRiskData("PPRiskDataKeyboardPresent", 22);
        PPRiskDataKnownApps = new PPRiskData("PPRiskDataKnownApps", 23);
        PPRiskDataLine1Number = new PPRiskData("PPRiskDataLine1Number", 24);
        PPRiskDataLinkerId = new PPRiskData("PPRiskDataLinkerId", 25);
        PPRiskDataLicenseAccepted = new PPRiskData("PPRiskDataLicenseAccepted", 26);
        PPRiskDataLocaleCountry = new PPRiskData("PPRiskDataLocaleCountry", 27);
        PPRiskDataLocaleLang = new PPRiskData("PPRiskDataLocaleLang", 28);
        PPRiskDataLocation = new PPRiskData("PPRiskDataLocation", 29);
        PPRiskDataLocationAreaCode = new PPRiskData("PPRiskDataLocationAreaCode", 30);
        PPRiskDataLocationAuthStatus = new PPRiskData("PPRiskDataLocationAuthStatus", 31);
        PPRiskDataMacAddrs = new PPRiskData("PPRiskDataMacAddrs", 32);
        PPRiskDataMobileOperatorName = new PPRiskData("PPRiskDataMobileOperatorName", 33);
        PPRiskDataNotifToken = new PPRiskData("PPRiskDataNotifToken", 34);
        PPRiskDataOsPlatform = new PPRiskData("PPRiskDataOsPlatform", 35);
        PPRiskDataOsType = new PPRiskData("PPRiskDataOsType", 36);
        PPRiskDataOsVersion = new PPRiskData("PPRiskDataOsVersion", 37);
        PPRiskDataPayloadType = new PPRiskData("PPRiskDataPayloadType", 38);
        PPRiskDataPhoneType = new PPRiskData("PPRiskDataPhoneType", 39);
        PPRiskDataPinLockLastTimestamp = new PPRiskData("PPRiskDataPinLockLastTimestamp", 40);
        PPRiskDataPowerSource = new PPRiskData("PPRiskDataPowerSource", 41);
        PPRiskDataRiskCompSessionId = new PPRiskData("PPRiskDataRiskCompSessionId", 42);
        PPRiskDataRoaming = new PPRiskData("PPRiskDataRoaming", 43);
        PPRiskDataRoamingPossible = new PPRiskData("PPRiskDataRoamingPossible", 44);
        PPRiskDataSimOperatorName = new PPRiskData("PPRiskDataSimOperatorName", 45);
        PPRiskDataSimSerialNumber = new PPRiskData("PPRiskDataSimSerialNumber", 46);
        PPRiskDataSmsEnabled = new PPRiskData("PPRiskDataSmsEnabled", 47);
        PPRiskDataSsid = new PPRiskData("PPRiskDataSsid", 48);
        PPRiskDataSubscriberId = new PPRiskData("PPRiskDataSubscriberId", 49);
        PPRiskDataTimestamp = new PPRiskData("PPRiskDataTimestamp", 50);
        PPRiskDataTotalDeviceMemory = new PPRiskData("PPRiskDataTotalDeviceMemory", 51);
        PPRiskDataTotalStorageSpace = new PPRiskData("PPRiskDataTotalStorageSpace", 52);
        PPRiskDataTzName = new PPRiskData("PPRiskDataTzName", 53);
        PPRiskDataAdvertisingIdentifier = new PPRiskData("PPRiskDataAdvertisingIdentifier", 54);
        PPRiskDataVendorIdentifier = new PPRiskData("PPRiskDataVendorIdentifier", 55);
        PPRiskDataNetworkOperator = new PPRiskData("PPRiskDataNetworkOperator", 56);
        PPRiskDataCdmaNetworkId = new PPRiskData("PPRiskDataCdmaNetworkId", 57);
        PPRiskDataCdmaSystemId = new PPRiskData("PPRiskDataCdmaSystemId", 58);
        PPRiskDataIsEmulator = new PPRiskData("PPRiskDataIsEmulator", 59);
        PPRiskDataIsRooted = new PPRiskData("PPRiskDataIsRooted", 60);
        PPRiskDataGeoCountry = new PPRiskData("PPRiskDataGeoCountry", 61);
        PPRiskDataSourceApp = new PPRiskData("PPRiskDataSourceApp", 62);
        PPRiskDataSourceAppVersion = new PPRiskData("PPRiskDataSourceAppVersion", 63);
        PPRiskDataPairingId = new PPRiskData("PPRiskDataPairingId", 64);
        PPRiskDataAppFirstInstallTime = new PPRiskData("PPRiskDataAppFirstInstallTime", 65);
        PPRiskDataAppLastUpdateTime = new PPRiskData("PPRiskDataAppLastUpdateTime", 66);
        PPRiskDataBluetoothMacAddress = new PPRiskData("PPRiskDataBluetoothMacAddress", 67);
        PPRiskDataSerialNumber = new PPRiskData("PPRiskDataSerialNumber", 68);
        PPRiskDataAndroidId = new PPRiskData("PPRiskDataAndroidId", 69);
        PPRiskDataGsfId = new PPRiskData("PPRiskDataGsfId", 70);
        PPRiskDataVPNSetting = new PPRiskData("PPRiskDataVPNSetting", 71);
        PPRiskDataProxySetting = new PPRiskData("PPRiskDataProxySetting", 72);
        PPRiskDataLocalIdentifier = new PPRiskData("PPRiskDataLocalIdentifier", 73);
        PPRiskDataCloudIdentifier = new PPRiskData("PPRiskDataCloudIdentifier", 74);
        PPRiskDataUnused1 = new PPRiskData("PPRiskDataUnused1", 75);
        PPRiskDataUnused2 = new PPRiskData("PPRiskDataUnused2", 76);
        PPRiskDataUnused3 = new PPRiskData("PPRiskDataUnused3", 77);
        PPRiskDataUnused4 = new PPRiskData("PPRiskDataUnused4", 78);
        PPRiskDataIsDaylightSaving = new PPRiskData("PPRiskDataIsDaylightSaving", 79);
        PPRiskDataTimeZoneOffset = new PPRiskData("PPRiskDataTimeZoneOffset", 80);
        $VALUES = (new PPRiskData[] {
            PPRiskDataAnId, PPRiskDataAppGuid, PPRiskDataAppId, PPRiskDataAppVersion, PPRiskDataBaseStationId, PPRiskDataBssid, PPRiskDataCellId, PPRiskDataClrVersion, PPRiskDataCompVersion, PPRiskDataConfUrl, 
            PPRiskDataConfVersion, PPRiskDataConnType, PPRiskDataDeviceFirmwareVersion, PPRiskDataDeviceId, PPRiskDataDeviceModel, PPRiskDataDeviceName, PPRiskDataDeviceUptime, PPRiskDataDongleDeviceId, PPRiskDataEmailConfigured, PPRiskDataEmulator, 
            PPRiskDataError, PPRiskDataIpAddrs, PPRiskDataKeyboardPresent, PPRiskDataKnownApps, PPRiskDataLine1Number, PPRiskDataLinkerId, PPRiskDataLicenseAccepted, PPRiskDataLocaleCountry, PPRiskDataLocaleLang, PPRiskDataLocation, 
            PPRiskDataLocationAreaCode, PPRiskDataLocationAuthStatus, PPRiskDataMacAddrs, PPRiskDataMobileOperatorName, PPRiskDataNotifToken, PPRiskDataOsPlatform, PPRiskDataOsType, PPRiskDataOsVersion, PPRiskDataPayloadType, PPRiskDataPhoneType, 
            PPRiskDataPinLockLastTimestamp, PPRiskDataPowerSource, PPRiskDataRiskCompSessionId, PPRiskDataRoaming, PPRiskDataRoamingPossible, PPRiskDataSimOperatorName, PPRiskDataSimSerialNumber, PPRiskDataSmsEnabled, PPRiskDataSsid, PPRiskDataSubscriberId, 
            PPRiskDataTimestamp, PPRiskDataTotalDeviceMemory, PPRiskDataTotalStorageSpace, PPRiskDataTzName, PPRiskDataAdvertisingIdentifier, PPRiskDataVendorIdentifier, PPRiskDataNetworkOperator, PPRiskDataCdmaNetworkId, PPRiskDataCdmaSystemId, PPRiskDataIsEmulator, 
            PPRiskDataIsRooted, PPRiskDataGeoCountry, PPRiskDataSourceApp, PPRiskDataSourceAppVersion, PPRiskDataPairingId, PPRiskDataAppFirstInstallTime, PPRiskDataAppLastUpdateTime, PPRiskDataBluetoothMacAddress, PPRiskDataSerialNumber, PPRiskDataAndroidId, 
            PPRiskDataGsfId, PPRiskDataVPNSetting, PPRiskDataProxySetting, PPRiskDataLocalIdentifier, PPRiskDataCloudIdentifier, PPRiskDataUnused1, PPRiskDataUnused2, PPRiskDataUnused3, PPRiskDataUnused4, PPRiskDataIsDaylightSaving, 
            PPRiskDataTimeZoneOffset
        });
    }
}
