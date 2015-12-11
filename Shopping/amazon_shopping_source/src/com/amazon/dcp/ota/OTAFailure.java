// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.ota;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.amazon.dcp.ota:
//            OTAStep

public final class OTAFailure extends Enum
    implements Parcelable
{

    private static final OTAFailure $VALUES[];
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public OTAFailure createFromParcel(Parcel parcel)
        {
            return OTAFailure.fromValue(parcel.readInt());
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public OTAFailure[] newArray(int i)
        {
            return new OTAFailure[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final OTAFailure DownloadAppPackageNameVerificationFailure;
    public static final OTAFailure DownloadAppPackageParseFailure;
    public static final OTAFailure DownloadAppVersionVerificationFailure;
    public static final OTAFailure DownloadCannotResume;
    public static final OTAFailure DownloadCouldNotStart;
    public static final OTAFailure DownloadDatabaseInBadState;
    public static final OTAFailure DownloadDeviceNotFound;
    public static final OTAFailure DownloadFailedToCheckSDCardEncryptionState;
    public static final OTAFailure DownloadFailedToDeleteUpdateOnOutOfSpace;
    public static final OTAFailure DownloadFailedToSetDestinationToSDCardDueToEncryption;
    public static final OTAFailure DownloadFailedToSetDestinationToSystemCache;
    public static final OTAFailure DownloadFileError;
    public static final OTAFailure DownloadFileExists;
    public static final OTAFailure DownloadHTTPClientError4xx;
    public static final OTAFailure DownloadHTTPError;
    public static final OTAFailure DownloadHTTPServerError5xx;
    public static final OTAFailure DownloadInstallManifestBadEncoding;
    public static final OTAFailure DownloadInstallManifestFailed;
    public static final OTAFailure DownloadInsufficientSpace;
    public static final OTAFailure DownloadItemsMissing;
    public static final OTAFailure DownloadMalformedLocalURI;
    public static final OTAFailure DownloadManagerRaceCondition;
    public static final OTAFailure DownloadManifestContainsMultipleInstallManifests;
    public static final OTAFailure DownloadManifestContainsNoInstallManifests;
    public static final OTAFailure DownloadManifestImportingFailed;
    public static final OTAFailure DownloadManifestParsingFailed;
    public static final OTAFailure DownloadOSVerificationFailure;
    public static final OTAFailure DownloadOSVersionVerificationFailure;
    public static final OTAFailure DownloadSignatureMismatch;
    public static final OTAFailure DownloadTooManyRedirects;
    public static final OTAFailure DownloadUnhandledHTTPCode;
    public static final OTAFailure DownloadUnknownError;
    public static final OTAFailure DownloadUpdatesFailure;
    public static final OTAFailure InstallApplicationFailure;
    public static final OTAFailure InstallApplicationFailureAlreadyExists;
    public static final OTAFailure InstallApplicationFailureBadManifest;
    public static final OTAFailure InstallApplicationFailureBadPackageName;
    public static final OTAFailure InstallApplicationFailureBadSharedUserId;
    public static final OTAFailure InstallApplicationFailureCPUAbiIncompatible;
    public static final OTAFailure InstallApplicationFailureCertificateEncoding;
    public static final OTAFailure InstallApplicationFailureConflictingProvider;
    public static final OTAFailure InstallApplicationFailureContainerError;
    public static final OTAFailure InstallApplicationFailureDexopt;
    public static final OTAFailure InstallApplicationFailureDuplicatePackage;
    public static final OTAFailure InstallApplicationFailureInconsistentCertificates;
    public static final OTAFailure InstallApplicationFailureInsufficientStorage;
    public static final OTAFailure InstallApplicationFailureInternalError;
    public static final OTAFailure InstallApplicationFailureInvalidApk;
    public static final OTAFailure InstallApplicationFailureInvalidInstallLocation;
    public static final OTAFailure InstallApplicationFailureInvalidUri;
    public static final OTAFailure InstallApplicationFailureManifestEmpty;
    public static final OTAFailure InstallApplicationFailureManifestMalformed;
    public static final OTAFailure InstallApplicationFailureMediaUnavailable;
    public static final OTAFailure InstallApplicationFailureMissingFeature;
    public static final OTAFailure InstallApplicationFailureMissingSharedLibrary;
    public static final OTAFailure InstallApplicationFailureNewerSdk;
    public static final OTAFailure InstallApplicationFailureNoCertificates;
    public static final OTAFailure InstallApplicationFailureNoSharedUser;
    public static final OTAFailure InstallApplicationFailureNotApk;
    public static final OTAFailure InstallApplicationFailureOlderSdk;
    public static final OTAFailure InstallApplicationFailureReplaceCouldntDelete;
    public static final OTAFailure InstallApplicationFailureSharedUserIncompatible;
    public static final OTAFailure InstallApplicationFailureTestOnly;
    public static final OTAFailure InstallApplicationFailureUnexpectedException;
    public static final OTAFailure InstallApplicationFailureUpdateIncompatible;
    public static final OTAFailure InstallApplicationStalled;
    public static final OTAFailure InstallCheckOSUpdateStatusFailure;
    public static final OTAFailure InstallDatabaseInvalidUpdateType;
    public static final OTAFailure InstallErrorMarkingPackageAsInstalled;
    public static final OTAFailure InstallManifestDedupingAgainstInstalledFailed;
    public static final OTAFailure InstallManifestIOFailure;
    public static final OTAFailure InstallManifestInvalidJSON;
    public static final OTAFailure InstallManifestInvalidUpdateType;
    public static final OTAFailure InstallManifestUpdateFileNotFound;
    public static final OTAFailure InstallOSFailureOnReboot;
    public static final OTAFailure InstallOSIOFailure;
    public static final OTAFailure InstallOSMalformedURI;
    public static final OTAFailure InstallOSUnexpectedError;
    public static final OTAFailure InstallProcessUpdatesFailure;
    public static final OTAFailure None;
    public static final OTAFailure ProcessManifestDatabaseInsertionFailure;
    public static final OTAFailure ProcessManifestFailedToGetLength;
    public static final OTAFailure Unknown;
    public static final OTAFailure UpdateCancelledFailure;
    private final String mFailureString;
    private final OTAStep mStep;
    private final int mValue;

    private OTAFailure(String s, int i, int j, OTAStep otastep, String s1)
    {
        super(s, i);
        mValue = j;
        mStep = otastep;
        mFailureString = (new StringBuilder()).append(otastep.toString()).append("Failure").append(s1).toString();
    }

    public static OTAFailure fromValue(int i)
    {
        OTAFailure aotafailure[] = values();
        int k = aotafailure.length;
        for (int j = 0; j < k; j++)
        {
            OTAFailure otafailure = aotafailure[j];
            if (otafailure.value() == i)
            {
                return otafailure;
            }
        }

        return Unknown;
    }

    public static OTAFailure valueOf(String s)
    {
        return (OTAFailure)Enum.valueOf(com/amazon/dcp/ota/OTAFailure, s);
    }

    public static OTAFailure[] values()
    {
        return (OTAFailure[])$VALUES.clone();
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        return mFailureString;
    }

    public int value()
    {
        return mValue;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(mValue);
    }

    static 
    {
        Unknown = new OTAFailure("Unknown", 0, 0x7fffffff, OTAStep.None, "Unknown");
        None = new OTAFailure("None", 1, 0, OTAStep.None, "None");
        DownloadManifestParsingFailed = new OTAFailure("DownloadManifestParsingFailed", 2, 1, OTAStep.DownloadManifest, "ManifestParsingFailed");
        DownloadManifestContainsMultipleInstallManifests = new OTAFailure("DownloadManifestContainsMultipleInstallManifests", 3, 2, OTAStep.DownloadManifest, "MultipleInstallManifests");
        DownloadManifestContainsNoInstallManifests = new OTAFailure("DownloadManifestContainsNoInstallManifests", 4, 3, OTAStep.DownloadManifest, "NoInstallManifest");
        DownloadManifestImportingFailed = new OTAFailure("DownloadManifestImportingFailed", 5, 4, OTAStep.DownloadManifest, "ImportingFailed");
        InstallManifestUpdateFileNotFound = new OTAFailure("InstallManifestUpdateFileNotFound", 6, 5, OTAStep.InstallManifest, "UpdateFileNotFound");
        InstallManifestInvalidUpdateType = new OTAFailure("InstallManifestInvalidUpdateType", 7, 6, OTAStep.InstallManifest, "InvalidUpdateType");
        InstallManifestIOFailure = new OTAFailure("InstallManifestIOFailure", 8, 7, OTAStep.InstallManifest, "IOFailureImportingManifest");
        InstallManifestInvalidJSON = new OTAFailure("InstallManifestInvalidJSON", 9, 8, OTAStep.InstallManifest, "InvalidJsonImportingManifest");
        InstallManifestDedupingAgainstInstalledFailed = new OTAFailure("InstallManifestDedupingAgainstInstalledFailed", 10, 9, OTAStep.InstallManifest, "InstallManifestDedupingAgainstInstalledFailed");
        DownloadFailedToSetDestinationToSystemCache = new OTAFailure("DownloadFailedToSetDestinationToSystemCache", 11, 10, OTAStep.Download, "FailedToSetDestinationToSystemCache");
        DownloadFailedToSetDestinationToSDCardDueToEncryption = new OTAFailure("DownloadFailedToSetDestinationToSDCardDueToEncryption", 12, 11, OTAStep.Download, "FailedToSetDestinationToSDCardDueToEncryption");
        DownloadFailedToCheckSDCardEncryptionState = new OTAFailure("DownloadFailedToCheckSDCardEncryptionState", 13, 12, OTAStep.Download, "FailedToCheckSDCardEncryptionState");
        DownloadCouldNotStart = new OTAFailure("DownloadCouldNotStart", 14, 13, OTAStep.Download, "CouldNotStartSomeDownloads");
        ProcessManifestFailedToGetLength = new OTAFailure("ProcessManifestFailedToGetLength", 15, 14, OTAStep.ProcessManfiest, "FailedToGetLength");
        DownloadItemsMissing = new OTAFailure("DownloadItemsMissing", 16, 15, OTAStep.Download, "SomeDownloadsMissing");
        DownloadCannotResume = new OTAFailure("DownloadCannotResume", 17, 16, OTAStep.Download, "CannotResume");
        DownloadDeviceNotFound = new OTAFailure("DownloadDeviceNotFound", 18, 17, OTAStep.Download, "ExternalStorageMissing");
        DownloadFailedToDeleteUpdateOnOutOfSpace = new OTAFailure("DownloadFailedToDeleteUpdateOnOutOfSpace", 19, 18, OTAStep.Download, "FailedToDeleteUpdateOnOutOfSpace");
        DownloadFileExists = new OTAFailure("DownloadFileExists", 20, 19, OTAStep.Download, "FileAlreadyExists");
        DownloadFileError = new OTAFailure("DownloadFileError", 21, 20, OTAStep.Download, "FileError");
        DownloadHTTPError = new OTAFailure("DownloadHTTPError", 22, 21, OTAStep.Download, "HTTPDataError");
        DownloadInsufficientSpace = new OTAFailure("DownloadInsufficientSpace", 23, 22, OTAStep.Download, "OutOfSpace");
        DownloadTooManyRedirects = new OTAFailure("DownloadTooManyRedirects", 24, 23, OTAStep.Download, "TooManyRedirects");
        DownloadUnhandledHTTPCode = new OTAFailure("DownloadUnhandledHTTPCode", 25, 24, OTAStep.Download, "UnhandledHTTPCode");
        DownloadUnknownError = new OTAFailure("DownloadUnknownError", 26, 25, OTAStep.Download, "Unknown");
        DownloadHTTPClientError4xx = new OTAFailure("DownloadHTTPClientError4xx", 27, 26, OTAStep.Download, "HTTPClient4xx");
        DownloadHTTPServerError5xx = new OTAFailure("DownloadHTTPServerError5xx", 28, 27, OTAStep.Download, "HTTPServer5xx");
        DownloadManagerRaceCondition = new OTAFailure("DownloadManagerRaceCondition", 29, 28, OTAStep.Download, "DownloadManagerRaceCondition");
        DownloadInstallManifestFailed = new OTAFailure("DownloadInstallManifestFailed", 30, 29, OTAStep.Download, "FailedToDownloadInstallManifest");
        DownloadInstallManifestBadEncoding = new OTAFailure("DownloadInstallManifestBadEncoding", 31, 30, OTAStep.Download, "BadEncodingOfInstallManifest");
        DownloadDatabaseInBadState = new OTAFailure("DownloadDatabaseInBadState", 32, 31, OTAStep.Download, "DownloadDatabaseInBadState");
        DownloadUpdatesFailure = new OTAFailure("DownloadUpdatesFailure", 33, 32, OTAStep.Download, "DownloadUpdatesFailure");
        DownloadMalformedLocalURI = new OTAFailure("DownloadMalformedLocalURI", 34, 33, OTAStep.Download, "MalformedLocalURI");
        DownloadAppPackageParseFailure = new OTAFailure("DownloadAppPackageParseFailure", 35, 34, OTAStep.Download, "AppPackageParseFailure");
        DownloadAppPackageNameVerificationFailure = new OTAFailure("DownloadAppPackageNameVerificationFailure", 36, 35, OTAStep.Download, "AppPackageNameVerificationFailure");
        DownloadAppVersionVerificationFailure = new OTAFailure("DownloadAppVersionVerificationFailure", 37, 36, OTAStep.Download, "AppVersionVerificationFailure");
        DownloadOSVersionVerificationFailure = new OTAFailure("DownloadOSVersionVerificationFailure", 38, 37, OTAStep.Download, "OSVersionVerificationFailure");
        DownloadOSVerificationFailure = new OTAFailure("DownloadOSVerificationFailure", 39, 38, OTAStep.Download, "OSVerificationFailure");
        InstallOSFailureOnReboot = new OTAFailure("InstallOSFailureOnReboot", 40, 39, OTAStep.Install, "OSInstallFailureDetected");
        InstallApplicationFailureAlreadyExists = new OTAFailure("InstallApplicationFailureAlreadyExists", 41, 40, OTAStep.Install, "AppInstallFailedAlreadyExists");
        InstallApplicationFailureInvalidApk = new OTAFailure("InstallApplicationFailureInvalidApk", 42, 41, OTAStep.Install, "AppInstallFailedInvalidApk");
        InstallApplicationFailureInvalidUri = new OTAFailure("InstallApplicationFailureInvalidUri", 43, 42, OTAStep.Install, "AppInstallFailedInvalidUri");
        InstallApplicationFailureInsufficientStorage = new OTAFailure("InstallApplicationFailureInsufficientStorage", 44, 43, OTAStep.Install, "AppInstallFailedInsufficientStorage");
        InstallApplicationFailureDuplicatePackage = new OTAFailure("InstallApplicationFailureDuplicatePackage", 45, 44, OTAStep.Install, "AppInstallFailedDuplicatePackage");
        InstallApplicationFailureNoSharedUser = new OTAFailure("InstallApplicationFailureNoSharedUser", 46, 45, OTAStep.Install, "AppInstallFailedNoSharedUser");
        InstallApplicationFailureUpdateIncompatible = new OTAFailure("InstallApplicationFailureUpdateIncompatible", 47, 46, OTAStep.Install, "AppInstallFailedUpdateIncompatible");
        InstallApplicationFailureSharedUserIncompatible = new OTAFailure("InstallApplicationFailureSharedUserIncompatible", 48, 47, OTAStep.Install, "AppInstallFailedSharedUserIncompatible");
        InstallApplicationFailureMissingSharedLibrary = new OTAFailure("InstallApplicationFailureMissingSharedLibrary", 49, 48, OTAStep.Install, "AppInstallFailedMissingSharedLibrary");
        InstallApplicationFailureReplaceCouldntDelete = new OTAFailure("InstallApplicationFailureReplaceCouldntDelete", 50, 49, OTAStep.Install, "AppInstallFailedReplaceCouldntDelete");
        InstallApplicationFailureDexopt = new OTAFailure("InstallApplicationFailureDexopt", 51, 50, OTAStep.Install, "AppInstallFailedDexopt");
        InstallApplicationFailureOlderSdk = new OTAFailure("InstallApplicationFailureOlderSdk", 52, 51, OTAStep.Install, "AppInstallFailedOlderSdk");
        InstallApplicationFailureConflictingProvider = new OTAFailure("InstallApplicationFailureConflictingProvider", 53, 52, OTAStep.Install, "AppInstallFailedConflictingProvider");
        InstallApplicationFailureNewerSdk = new OTAFailure("InstallApplicationFailureNewerSdk", 54, 53, OTAStep.Install, "AppInstallFailedNewerSdk");
        InstallApplicationFailureTestOnly = new OTAFailure("InstallApplicationFailureTestOnly", 55, 54, OTAStep.Install, "AppInstallFailedTestOnly");
        InstallApplicationFailureCPUAbiIncompatible = new OTAFailure("InstallApplicationFailureCPUAbiIncompatible", 56, 55, OTAStep.Install, "AppInstallFailedCPUAbiIncompatible");
        InstallApplicationFailureMissingFeature = new OTAFailure("InstallApplicationFailureMissingFeature", 57, 56, OTAStep.Install, "AppInstallFailedMissingFeature");
        InstallApplicationFailureContainerError = new OTAFailure("InstallApplicationFailureContainerError", 58, 57, OTAStep.Install, "AppInstallFailedContainerError");
        InstallApplicationFailureInvalidInstallLocation = new OTAFailure("InstallApplicationFailureInvalidInstallLocation", 59, 58, OTAStep.Install, "AppInstallFailedInvalidInstallLocation");
        InstallApplicationFailureMediaUnavailable = new OTAFailure("InstallApplicationFailureMediaUnavailable", 60, 59, OTAStep.Install, "AppInstallFailedMediaUnavailable");
        InstallApplicationFailureNotApk = new OTAFailure("InstallApplicationFailureNotApk", 61, 60, OTAStep.Install, "AppInstallFailedNotApk");
        InstallApplicationFailureBadManifest = new OTAFailure("InstallApplicationFailureBadManifest", 62, 61, OTAStep.Install, "AppInstallFailedBadManifest");
        InstallApplicationFailureUnexpectedException = new OTAFailure("InstallApplicationFailureUnexpectedException", 63, 62, OTAStep.Install, "AppInstallFailedUnexpectedException");
        InstallApplicationFailureNoCertificates = new OTAFailure("InstallApplicationFailureNoCertificates", 64, 63, OTAStep.Install, "AppInstallFailedNoCertificates");
        InstallApplicationFailureInconsistentCertificates = new OTAFailure("InstallApplicationFailureInconsistentCertificates", 65, 64, OTAStep.Install, "AppInstallFailedInconsistentCertificates");
        InstallApplicationFailureCertificateEncoding = new OTAFailure("InstallApplicationFailureCertificateEncoding", 66, 65, OTAStep.Install, "AppInstallFailedCertificateEncoding");
        InstallApplicationFailureBadPackageName = new OTAFailure("InstallApplicationFailureBadPackageName", 67, 66, OTAStep.Install, "AppInstallFailedBadPackageName");
        InstallApplicationFailureBadSharedUserId = new OTAFailure("InstallApplicationFailureBadSharedUserId", 68, 67, OTAStep.Install, "AppInstallFailedBadSharedUserId");
        InstallApplicationFailureManifestMalformed = new OTAFailure("InstallApplicationFailureManifestMalformed", 69, 68, OTAStep.Install, "AppInstallFailedManifestMalformed");
        InstallApplicationFailureManifestEmpty = new OTAFailure("InstallApplicationFailureManifestEmpty", 70, 69, OTAStep.Install, "AppInstallFailedManifestEmpty");
        InstallApplicationFailureInternalError = new OTAFailure("InstallApplicationFailureInternalError", 71, 70, OTAStep.Install, "AppInstallFailedInternalError");
        InstallApplicationFailure = new OTAFailure("InstallApplicationFailure", 72, 71, OTAStep.Install, "AppFailedToInstall");
        InstallApplicationStalled = new OTAFailure("InstallApplicationStalled", 73, 72, OTAStep.Install, "AppInstallationStalled");
        InstallOSMalformedURI = new OTAFailure("InstallOSMalformedURI", 74, 73, OTAStep.Install, "OSUpdateMalformedURIFailure");
        InstallOSIOFailure = new OTAFailure("InstallOSIOFailure", 75, 74, OTAStep.Install, "OSUpdateIOFailure");
        InstallOSUnexpectedError = new OTAFailure("InstallOSUnexpectedError", 76, 75, OTAStep.Install, "OSUpdateUnexpectedError");
        InstallErrorMarkingPackageAsInstalled = new OTAFailure("InstallErrorMarkingPackageAsInstalled", 77, 76, OTAStep.Install, "ErrorMarkingPackageAsInstalled");
        InstallDatabaseInvalidUpdateType = new OTAFailure("InstallDatabaseInvalidUpdateType", 78, 77, OTAStep.Install, "DatabaseInvalidUpdateType");
        InstallCheckOSUpdateStatusFailure = new OTAFailure("InstallCheckOSUpdateStatusFailure", 79, 78, OTAStep.Install, "CheckOSUpdateStatusFailure");
        InstallProcessUpdatesFailure = new OTAFailure("InstallProcessUpdatesFailure", 80, 79, OTAStep.Install, "ProcessUpdatesFailure");
        UpdateCancelledFailure = new OTAFailure("UpdateCancelledFailure", 81, 80, OTAStep.None, "UpdateCancelledFailure");
        DownloadSignatureMismatch = new OTAFailure("DownloadSignatureMismatch", 82, 81, OTAStep.Download, "SignatureMismatch");
        ProcessManifestDatabaseInsertionFailure = new OTAFailure("ProcessManifestDatabaseInsertionFailure", 83, 82, OTAStep.ProcessManfiest, "DatabaseInsertionFailure");
        $VALUES = (new OTAFailure[] {
            Unknown, None, DownloadManifestParsingFailed, DownloadManifestContainsMultipleInstallManifests, DownloadManifestContainsNoInstallManifests, DownloadManifestImportingFailed, InstallManifestUpdateFileNotFound, InstallManifestInvalidUpdateType, InstallManifestIOFailure, InstallManifestInvalidJSON, 
            InstallManifestDedupingAgainstInstalledFailed, DownloadFailedToSetDestinationToSystemCache, DownloadFailedToSetDestinationToSDCardDueToEncryption, DownloadFailedToCheckSDCardEncryptionState, DownloadCouldNotStart, ProcessManifestFailedToGetLength, DownloadItemsMissing, DownloadCannotResume, DownloadDeviceNotFound, DownloadFailedToDeleteUpdateOnOutOfSpace, 
            DownloadFileExists, DownloadFileError, DownloadHTTPError, DownloadInsufficientSpace, DownloadTooManyRedirects, DownloadUnhandledHTTPCode, DownloadUnknownError, DownloadHTTPClientError4xx, DownloadHTTPServerError5xx, DownloadManagerRaceCondition, 
            DownloadInstallManifestFailed, DownloadInstallManifestBadEncoding, DownloadDatabaseInBadState, DownloadUpdatesFailure, DownloadMalformedLocalURI, DownloadAppPackageParseFailure, DownloadAppPackageNameVerificationFailure, DownloadAppVersionVerificationFailure, DownloadOSVersionVerificationFailure, DownloadOSVerificationFailure, 
            InstallOSFailureOnReboot, InstallApplicationFailureAlreadyExists, InstallApplicationFailureInvalidApk, InstallApplicationFailureInvalidUri, InstallApplicationFailureInsufficientStorage, InstallApplicationFailureDuplicatePackage, InstallApplicationFailureNoSharedUser, InstallApplicationFailureUpdateIncompatible, InstallApplicationFailureSharedUserIncompatible, InstallApplicationFailureMissingSharedLibrary, 
            InstallApplicationFailureReplaceCouldntDelete, InstallApplicationFailureDexopt, InstallApplicationFailureOlderSdk, InstallApplicationFailureConflictingProvider, InstallApplicationFailureNewerSdk, InstallApplicationFailureTestOnly, InstallApplicationFailureCPUAbiIncompatible, InstallApplicationFailureMissingFeature, InstallApplicationFailureContainerError, InstallApplicationFailureInvalidInstallLocation, 
            InstallApplicationFailureMediaUnavailable, InstallApplicationFailureNotApk, InstallApplicationFailureBadManifest, InstallApplicationFailureUnexpectedException, InstallApplicationFailureNoCertificates, InstallApplicationFailureInconsistentCertificates, InstallApplicationFailureCertificateEncoding, InstallApplicationFailureBadPackageName, InstallApplicationFailureBadSharedUserId, InstallApplicationFailureManifestMalformed, 
            InstallApplicationFailureManifestEmpty, InstallApplicationFailureInternalError, InstallApplicationFailure, InstallApplicationStalled, InstallOSMalformedURI, InstallOSIOFailure, InstallOSUnexpectedError, InstallErrorMarkingPackageAsInstalled, InstallDatabaseInvalidUpdateType, InstallCheckOSUpdateStatusFailure, 
            InstallProcessUpdatesFailure, UpdateCancelledFailure, DownloadSignatureMismatch, ProcessManifestDatabaseInsertionFailure
        });
    }
}
