.class public final enum Lcom/amazon/dcp/ota/OTAFailure;
.super Ljava/lang/Enum;
.source "OTAFailure.java"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/dcp/ota/OTAFailure;",
        ">;",
        "Landroid/os/Parcelable;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/dcp/ota/OTAFailure;

.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/amazon/dcp/ota/OTAFailure;",
            ">;"
        }
    .end annotation
.end field

.field public static final enum DownloadAppPackageNameVerificationFailure:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadAppPackageParseFailure:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadAppVersionVerificationFailure:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadCannotResume:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadCouldNotStart:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadDatabaseInBadState:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadDeviceNotFound:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadFailedToCheckSDCardEncryptionState:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadFailedToDeleteUpdateOnOutOfSpace:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadFailedToSetDestinationToSDCardDueToEncryption:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadFailedToSetDestinationToSystemCache:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadFileError:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadFileExists:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadHTTPClientError4xx:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadHTTPError:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadHTTPServerError5xx:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadInstallManifestBadEncoding:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadInstallManifestFailed:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadInsufficientSpace:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadItemsMissing:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadMalformedLocalURI:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadManagerRaceCondition:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadManifestContainsMultipleInstallManifests:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadManifestContainsNoInstallManifests:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadManifestImportingFailed:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadManifestParsingFailed:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadOSVerificationFailure:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadOSVersionVerificationFailure:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadSignatureMismatch:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadTooManyRedirects:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadUnhandledHTTPCode:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadUnknownError:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum DownloadUpdatesFailure:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailure:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureAlreadyExists:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureBadManifest:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureBadPackageName:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureBadSharedUserId:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureCPUAbiIncompatible:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureCertificateEncoding:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureConflictingProvider:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureContainerError:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureDexopt:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureDuplicatePackage:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureInconsistentCertificates:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureInsufficientStorage:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureInternalError:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureInvalidApk:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureInvalidInstallLocation:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureInvalidUri:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureManifestEmpty:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureManifestMalformed:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureMediaUnavailable:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureMissingFeature:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureMissingSharedLibrary:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureNewerSdk:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureNoCertificates:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureNoSharedUser:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureNotApk:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureOlderSdk:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureReplaceCouldntDelete:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureSharedUserIncompatible:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureTestOnly:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureUnexpectedException:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationFailureUpdateIncompatible:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallApplicationStalled:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallCheckOSUpdateStatusFailure:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallDatabaseInvalidUpdateType:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallErrorMarkingPackageAsInstalled:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallManifestDedupingAgainstInstalledFailed:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallManifestIOFailure:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallManifestInvalidJSON:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallManifestInvalidUpdateType:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallManifestUpdateFileNotFound:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallOSFailureOnReboot:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallOSIOFailure:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallOSMalformedURI:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallOSUnexpectedError:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum InstallProcessUpdatesFailure:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum None:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum ProcessManifestDatabaseInsertionFailure:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum ProcessManifestFailedToGetLength:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum Unknown:Lcom/amazon/dcp/ota/OTAFailure;

.field public static final enum UpdateCancelledFailure:Lcom/amazon/dcp/ota/OTAFailure;


# instance fields
.field private final mFailureString:Ljava/lang/String;

.field private final mStep:Lcom/amazon/dcp/ota/OTAStep;

.field private final mValue:I


# direct methods
.method static constructor <clinit>()V
    .locals 13

    .prologue
    const/4 v12, 0x4

    const/4 v11, 0x3

    const/4 v10, 0x2

    const/4 v9, 0x1

    const/4 v2, 0x0

    .line 9
    new-instance v0, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v1, "Unknown"

    const v3, 0x7fffffff

    sget-object v4, Lcom/amazon/dcp/ota/OTAStep;->None:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v5, "Unknown"

    invoke-direct/range {v0 .. v5}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/dcp/ota/OTAFailure;->Unknown:Lcom/amazon/dcp/ota/OTAFailure;

    .line 10
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "None"

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->None:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "None"

    move v5, v9

    move v6, v2

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->None:Lcom/amazon/dcp/ota/OTAFailure;

    .line 11
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadManifestParsingFailed"

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->DownloadManifest:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "ManifestParsingFailed"

    move v5, v10

    move v6, v9

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadManifestParsingFailed:Lcom/amazon/dcp/ota/OTAFailure;

    .line 12
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadManifestContainsMultipleInstallManifests"

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->DownloadManifest:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "MultipleInstallManifests"

    move v5, v11

    move v6, v10

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadManifestContainsMultipleInstallManifests:Lcom/amazon/dcp/ota/OTAFailure;

    .line 13
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadManifestContainsNoInstallManifests"

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->DownloadManifest:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "NoInstallManifest"

    move v5, v12

    move v6, v11

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadManifestContainsNoInstallManifests:Lcom/amazon/dcp/ota/OTAFailure;

    .line 14
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadManifestImportingFailed"

    const/4 v5, 0x5

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->DownloadManifest:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "ImportingFailed"

    move v6, v12

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadManifestImportingFailed:Lcom/amazon/dcp/ota/OTAFailure;

    .line 15
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallManifestUpdateFileNotFound"

    const/4 v5, 0x6

    const/4 v6, 0x5

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->InstallManifest:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "UpdateFileNotFound"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallManifestUpdateFileNotFound:Lcom/amazon/dcp/ota/OTAFailure;

    .line 16
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallManifestInvalidUpdateType"

    const/4 v5, 0x7

    const/4 v6, 0x6

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->InstallManifest:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "InvalidUpdateType"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallManifestInvalidUpdateType:Lcom/amazon/dcp/ota/OTAFailure;

    .line 17
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallManifestIOFailure"

    const/16 v5, 0x8

    const/4 v6, 0x7

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->InstallManifest:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "IOFailureImportingManifest"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallManifestIOFailure:Lcom/amazon/dcp/ota/OTAFailure;

    .line 18
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallManifestInvalidJSON"

    const/16 v5, 0x9

    const/16 v6, 0x8

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->InstallManifest:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "InvalidJsonImportingManifest"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallManifestInvalidJSON:Lcom/amazon/dcp/ota/OTAFailure;

    .line 19
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallManifestDedupingAgainstInstalledFailed"

    const/16 v5, 0xa

    const/16 v6, 0x9

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->InstallManifest:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "InstallManifestDedupingAgainstInstalledFailed"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallManifestDedupingAgainstInstalledFailed:Lcom/amazon/dcp/ota/OTAFailure;

    .line 21
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadFailedToSetDestinationToSystemCache"

    const/16 v5, 0xb

    const/16 v6, 0xa

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "FailedToSetDestinationToSystemCache"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadFailedToSetDestinationToSystemCache:Lcom/amazon/dcp/ota/OTAFailure;

    .line 22
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadFailedToSetDestinationToSDCardDueToEncryption"

    const/16 v5, 0xc

    const/16 v6, 0xb

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "FailedToSetDestinationToSDCardDueToEncryption"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadFailedToSetDestinationToSDCardDueToEncryption:Lcom/amazon/dcp/ota/OTAFailure;

    .line 24
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadFailedToCheckSDCardEncryptionState"

    const/16 v5, 0xd

    const/16 v6, 0xc

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "FailedToCheckSDCardEncryptionState"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadFailedToCheckSDCardEncryptionState:Lcom/amazon/dcp/ota/OTAFailure;

    .line 25
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadCouldNotStart"

    const/16 v5, 0xe

    const/16 v6, 0xd

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "CouldNotStartSomeDownloads"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadCouldNotStart:Lcom/amazon/dcp/ota/OTAFailure;

    .line 26
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "ProcessManifestFailedToGetLength"

    const/16 v5, 0xf

    const/16 v6, 0xe

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->ProcessManfiest:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "FailedToGetLength"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->ProcessManifestFailedToGetLength:Lcom/amazon/dcp/ota/OTAFailure;

    .line 27
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadItemsMissing"

    const/16 v5, 0x10

    const/16 v6, 0xf

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "SomeDownloadsMissing"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadItemsMissing:Lcom/amazon/dcp/ota/OTAFailure;

    .line 28
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadCannotResume"

    const/16 v5, 0x11

    const/16 v6, 0x10

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "CannotResume"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadCannotResume:Lcom/amazon/dcp/ota/OTAFailure;

    .line 29
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadDeviceNotFound"

    const/16 v5, 0x12

    const/16 v6, 0x11

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "ExternalStorageMissing"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadDeviceNotFound:Lcom/amazon/dcp/ota/OTAFailure;

    .line 30
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadFailedToDeleteUpdateOnOutOfSpace"

    const/16 v5, 0x13

    const/16 v6, 0x12

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "FailedToDeleteUpdateOnOutOfSpace"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadFailedToDeleteUpdateOnOutOfSpace:Lcom/amazon/dcp/ota/OTAFailure;

    .line 31
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadFileExists"

    const/16 v5, 0x14

    const/16 v6, 0x13

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "FileAlreadyExists"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadFileExists:Lcom/amazon/dcp/ota/OTAFailure;

    .line 32
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadFileError"

    const/16 v5, 0x15

    const/16 v6, 0x14

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "FileError"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadFileError:Lcom/amazon/dcp/ota/OTAFailure;

    .line 33
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadHTTPError"

    const/16 v5, 0x16

    const/16 v6, 0x15

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "HTTPDataError"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadHTTPError:Lcom/amazon/dcp/ota/OTAFailure;

    .line 34
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadInsufficientSpace"

    const/16 v5, 0x17

    const/16 v6, 0x16

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "OutOfSpace"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadInsufficientSpace:Lcom/amazon/dcp/ota/OTAFailure;

    .line 35
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadTooManyRedirects"

    const/16 v5, 0x18

    const/16 v6, 0x17

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "TooManyRedirects"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadTooManyRedirects:Lcom/amazon/dcp/ota/OTAFailure;

    .line 36
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadUnhandledHTTPCode"

    const/16 v5, 0x19

    const/16 v6, 0x18

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "UnhandledHTTPCode"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadUnhandledHTTPCode:Lcom/amazon/dcp/ota/OTAFailure;

    .line 37
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadUnknownError"

    const/16 v5, 0x1a

    const/16 v6, 0x19

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "Unknown"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadUnknownError:Lcom/amazon/dcp/ota/OTAFailure;

    .line 38
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadHTTPClientError4xx"

    const/16 v5, 0x1b

    const/16 v6, 0x1a

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "HTTPClient4xx"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadHTTPClientError4xx:Lcom/amazon/dcp/ota/OTAFailure;

    .line 39
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadHTTPServerError5xx"

    const/16 v5, 0x1c

    const/16 v6, 0x1b

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "HTTPServer5xx"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadHTTPServerError5xx:Lcom/amazon/dcp/ota/OTAFailure;

    .line 40
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadManagerRaceCondition"

    const/16 v5, 0x1d

    const/16 v6, 0x1c

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "DownloadManagerRaceCondition"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadManagerRaceCondition:Lcom/amazon/dcp/ota/OTAFailure;

    .line 41
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadInstallManifestFailed"

    const/16 v5, 0x1e

    const/16 v6, 0x1d

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "FailedToDownloadInstallManifest"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadInstallManifestFailed:Lcom/amazon/dcp/ota/OTAFailure;

    .line 42
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadInstallManifestBadEncoding"

    const/16 v5, 0x1f

    const/16 v6, 0x1e

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "BadEncodingOfInstallManifest"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadInstallManifestBadEncoding:Lcom/amazon/dcp/ota/OTAFailure;

    .line 43
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadDatabaseInBadState"

    const/16 v5, 0x20

    const/16 v6, 0x1f

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "DownloadDatabaseInBadState"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadDatabaseInBadState:Lcom/amazon/dcp/ota/OTAFailure;

    .line 44
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadUpdatesFailure"

    const/16 v5, 0x21

    const/16 v6, 0x20

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "DownloadUpdatesFailure"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadUpdatesFailure:Lcom/amazon/dcp/ota/OTAFailure;

    .line 45
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadMalformedLocalURI"

    const/16 v5, 0x22

    const/16 v6, 0x21

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "MalformedLocalURI"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadMalformedLocalURI:Lcom/amazon/dcp/ota/OTAFailure;

    .line 46
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadAppPackageParseFailure"

    const/16 v5, 0x23

    const/16 v6, 0x22

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppPackageParseFailure"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadAppPackageParseFailure:Lcom/amazon/dcp/ota/OTAFailure;

    .line 47
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadAppPackageNameVerificationFailure"

    const/16 v5, 0x24

    const/16 v6, 0x23

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppPackageNameVerificationFailure"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadAppPackageNameVerificationFailure:Lcom/amazon/dcp/ota/OTAFailure;

    .line 48
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadAppVersionVerificationFailure"

    const/16 v5, 0x25

    const/16 v6, 0x24

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppVersionVerificationFailure"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadAppVersionVerificationFailure:Lcom/amazon/dcp/ota/OTAFailure;

    .line 49
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadOSVersionVerificationFailure"

    const/16 v5, 0x26

    const/16 v6, 0x25

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "OSVersionVerificationFailure"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadOSVersionVerificationFailure:Lcom/amazon/dcp/ota/OTAFailure;

    .line 50
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadOSVerificationFailure"

    const/16 v5, 0x27

    const/16 v6, 0x26

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "OSVerificationFailure"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadOSVerificationFailure:Lcom/amazon/dcp/ota/OTAFailure;

    .line 51
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallOSFailureOnReboot"

    const/16 v5, 0x28

    const/16 v6, 0x27

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "OSInstallFailureDetected"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallOSFailureOnReboot:Lcom/amazon/dcp/ota/OTAFailure;

    .line 52
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureAlreadyExists"

    const/16 v5, 0x29

    const/16 v6, 0x28

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedAlreadyExists"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureAlreadyExists:Lcom/amazon/dcp/ota/OTAFailure;

    .line 53
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureInvalidApk"

    const/16 v5, 0x2a

    const/16 v6, 0x29

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedInvalidApk"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureInvalidApk:Lcom/amazon/dcp/ota/OTAFailure;

    .line 54
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureInvalidUri"

    const/16 v5, 0x2b

    const/16 v6, 0x2a

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedInvalidUri"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureInvalidUri:Lcom/amazon/dcp/ota/OTAFailure;

    .line 55
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureInsufficientStorage"

    const/16 v5, 0x2c

    const/16 v6, 0x2b

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedInsufficientStorage"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureInsufficientStorage:Lcom/amazon/dcp/ota/OTAFailure;

    .line 56
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureDuplicatePackage"

    const/16 v5, 0x2d

    const/16 v6, 0x2c

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedDuplicatePackage"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureDuplicatePackage:Lcom/amazon/dcp/ota/OTAFailure;

    .line 57
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureNoSharedUser"

    const/16 v5, 0x2e

    const/16 v6, 0x2d

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedNoSharedUser"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureNoSharedUser:Lcom/amazon/dcp/ota/OTAFailure;

    .line 58
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureUpdateIncompatible"

    const/16 v5, 0x2f

    const/16 v6, 0x2e

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedUpdateIncompatible"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureUpdateIncompatible:Lcom/amazon/dcp/ota/OTAFailure;

    .line 59
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureSharedUserIncompatible"

    const/16 v5, 0x30

    const/16 v6, 0x2f

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedSharedUserIncompatible"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureSharedUserIncompatible:Lcom/amazon/dcp/ota/OTAFailure;

    .line 60
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureMissingSharedLibrary"

    const/16 v5, 0x31

    const/16 v6, 0x30

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedMissingSharedLibrary"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureMissingSharedLibrary:Lcom/amazon/dcp/ota/OTAFailure;

    .line 61
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureReplaceCouldntDelete"

    const/16 v5, 0x32

    const/16 v6, 0x31

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedReplaceCouldntDelete"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureReplaceCouldntDelete:Lcom/amazon/dcp/ota/OTAFailure;

    .line 62
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureDexopt"

    const/16 v5, 0x33

    const/16 v6, 0x32

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedDexopt"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureDexopt:Lcom/amazon/dcp/ota/OTAFailure;

    .line 63
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureOlderSdk"

    const/16 v5, 0x34

    const/16 v6, 0x33

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedOlderSdk"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureOlderSdk:Lcom/amazon/dcp/ota/OTAFailure;

    .line 64
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureConflictingProvider"

    const/16 v5, 0x35

    const/16 v6, 0x34

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedConflictingProvider"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureConflictingProvider:Lcom/amazon/dcp/ota/OTAFailure;

    .line 65
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureNewerSdk"

    const/16 v5, 0x36

    const/16 v6, 0x35

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedNewerSdk"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureNewerSdk:Lcom/amazon/dcp/ota/OTAFailure;

    .line 66
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureTestOnly"

    const/16 v5, 0x37

    const/16 v6, 0x36

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedTestOnly"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureTestOnly:Lcom/amazon/dcp/ota/OTAFailure;

    .line 67
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureCPUAbiIncompatible"

    const/16 v5, 0x38

    const/16 v6, 0x37

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedCPUAbiIncompatible"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureCPUAbiIncompatible:Lcom/amazon/dcp/ota/OTAFailure;

    .line 68
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureMissingFeature"

    const/16 v5, 0x39

    const/16 v6, 0x38

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedMissingFeature"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureMissingFeature:Lcom/amazon/dcp/ota/OTAFailure;

    .line 69
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureContainerError"

    const/16 v5, 0x3a

    const/16 v6, 0x39

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedContainerError"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureContainerError:Lcom/amazon/dcp/ota/OTAFailure;

    .line 70
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureInvalidInstallLocation"

    const/16 v5, 0x3b

    const/16 v6, 0x3a

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedInvalidInstallLocation"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureInvalidInstallLocation:Lcom/amazon/dcp/ota/OTAFailure;

    .line 71
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureMediaUnavailable"

    const/16 v5, 0x3c

    const/16 v6, 0x3b

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedMediaUnavailable"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureMediaUnavailable:Lcom/amazon/dcp/ota/OTAFailure;

    .line 72
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureNotApk"

    const/16 v5, 0x3d

    const/16 v6, 0x3c

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedNotApk"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureNotApk:Lcom/amazon/dcp/ota/OTAFailure;

    .line 73
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureBadManifest"

    const/16 v5, 0x3e

    const/16 v6, 0x3d

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedBadManifest"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureBadManifest:Lcom/amazon/dcp/ota/OTAFailure;

    .line 74
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureUnexpectedException"

    const/16 v5, 0x3f

    const/16 v6, 0x3e

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedUnexpectedException"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureUnexpectedException:Lcom/amazon/dcp/ota/OTAFailure;

    .line 75
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureNoCertificates"

    const/16 v5, 0x40

    const/16 v6, 0x3f

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedNoCertificates"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureNoCertificates:Lcom/amazon/dcp/ota/OTAFailure;

    .line 76
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureInconsistentCertificates"

    const/16 v5, 0x41

    const/16 v6, 0x40

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedInconsistentCertificates"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureInconsistentCertificates:Lcom/amazon/dcp/ota/OTAFailure;

    .line 77
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureCertificateEncoding"

    const/16 v5, 0x42

    const/16 v6, 0x41

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedCertificateEncoding"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureCertificateEncoding:Lcom/amazon/dcp/ota/OTAFailure;

    .line 78
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureBadPackageName"

    const/16 v5, 0x43

    const/16 v6, 0x42

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedBadPackageName"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureBadPackageName:Lcom/amazon/dcp/ota/OTAFailure;

    .line 79
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureBadSharedUserId"

    const/16 v5, 0x44

    const/16 v6, 0x43

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedBadSharedUserId"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureBadSharedUserId:Lcom/amazon/dcp/ota/OTAFailure;

    .line 80
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureManifestMalformed"

    const/16 v5, 0x45

    const/16 v6, 0x44

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedManifestMalformed"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureManifestMalformed:Lcom/amazon/dcp/ota/OTAFailure;

    .line 81
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureManifestEmpty"

    const/16 v5, 0x46

    const/16 v6, 0x45

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedManifestEmpty"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureManifestEmpty:Lcom/amazon/dcp/ota/OTAFailure;

    .line 82
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailureInternalError"

    const/16 v5, 0x47

    const/16 v6, 0x46

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallFailedInternalError"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureInternalError:Lcom/amazon/dcp/ota/OTAFailure;

    .line 83
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationFailure"

    const/16 v5, 0x48

    const/16 v6, 0x47

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppFailedToInstall"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailure:Lcom/amazon/dcp/ota/OTAFailure;

    .line 84
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallApplicationStalled"

    const/16 v5, 0x49

    const/16 v6, 0x48

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "AppInstallationStalled"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationStalled:Lcom/amazon/dcp/ota/OTAFailure;

    .line 85
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallOSMalformedURI"

    const/16 v5, 0x4a

    const/16 v6, 0x49

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "OSUpdateMalformedURIFailure"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallOSMalformedURI:Lcom/amazon/dcp/ota/OTAFailure;

    .line 86
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallOSIOFailure"

    const/16 v5, 0x4b

    const/16 v6, 0x4a

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "OSUpdateIOFailure"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallOSIOFailure:Lcom/amazon/dcp/ota/OTAFailure;

    .line 87
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallOSUnexpectedError"

    const/16 v5, 0x4c

    const/16 v6, 0x4b

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "OSUpdateUnexpectedError"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallOSUnexpectedError:Lcom/amazon/dcp/ota/OTAFailure;

    .line 88
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallErrorMarkingPackageAsInstalled"

    const/16 v5, 0x4d

    const/16 v6, 0x4c

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "ErrorMarkingPackageAsInstalled"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallErrorMarkingPackageAsInstalled:Lcom/amazon/dcp/ota/OTAFailure;

    .line 89
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallDatabaseInvalidUpdateType"

    const/16 v5, 0x4e

    const/16 v6, 0x4d

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "DatabaseInvalidUpdateType"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallDatabaseInvalidUpdateType:Lcom/amazon/dcp/ota/OTAFailure;

    .line 90
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallCheckOSUpdateStatusFailure"

    const/16 v5, 0x4f

    const/16 v6, 0x4e

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "CheckOSUpdateStatusFailure"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallCheckOSUpdateStatusFailure:Lcom/amazon/dcp/ota/OTAFailure;

    .line 91
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "InstallProcessUpdatesFailure"

    const/16 v5, 0x50

    const/16 v6, 0x4f

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Install:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "ProcessUpdatesFailure"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->InstallProcessUpdatesFailure:Lcom/amazon/dcp/ota/OTAFailure;

    .line 92
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "UpdateCancelledFailure"

    const/16 v5, 0x51

    const/16 v6, 0x50

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->None:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "UpdateCancelledFailure"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->UpdateCancelledFailure:Lcom/amazon/dcp/ota/OTAFailure;

    .line 93
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "DownloadSignatureMismatch"

    const/16 v5, 0x52

    const/16 v6, 0x51

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->Download:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "SignatureMismatch"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->DownloadSignatureMismatch:Lcom/amazon/dcp/ota/OTAFailure;

    .line 94
    new-instance v3, Lcom/amazon/dcp/ota/OTAFailure;

    const-string/jumbo v4, "ProcessManifestDatabaseInsertionFailure"

    const/16 v5, 0x53

    const/16 v6, 0x52

    sget-object v7, Lcom/amazon/dcp/ota/OTAStep;->ProcessManfiest:Lcom/amazon/dcp/ota/OTAStep;

    const-string/jumbo v8, "DatabaseInsertionFailure"

    invoke-direct/range {v3 .. v8}, Lcom/amazon/dcp/ota/OTAFailure;-><init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V

    sput-object v3, Lcom/amazon/dcp/ota/OTAFailure;->ProcessManifestDatabaseInsertionFailure:Lcom/amazon/dcp/ota/OTAFailure;

    .line 7
    const/16 v0, 0x54

    new-array v0, v0, [Lcom/amazon/dcp/ota/OTAFailure;

    sget-object v1, Lcom/amazon/dcp/ota/OTAFailure;->Unknown:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/dcp/ota/OTAFailure;->None:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v1, v0, v9

    sget-object v1, Lcom/amazon/dcp/ota/OTAFailure;->DownloadManifestParsingFailed:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v1, v0, v10

    sget-object v1, Lcom/amazon/dcp/ota/OTAFailure;->DownloadManifestContainsMultipleInstallManifests:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v1, v0, v11

    sget-object v1, Lcom/amazon/dcp/ota/OTAFailure;->DownloadManifestContainsNoInstallManifests:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v1, v0, v12

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->DownloadManifestImportingFailed:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallManifestUpdateFileNotFound:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallManifestInvalidUpdateType:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallManifestIOFailure:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallManifestInvalidJSON:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallManifestDedupingAgainstInstalledFailed:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->DownloadFailedToSetDestinationToSystemCache:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->DownloadFailedToSetDestinationToSDCardDueToEncryption:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->DownloadFailedToCheckSDCardEncryptionState:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->DownloadCouldNotStart:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->ProcessManifestFailedToGetLength:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->DownloadItemsMissing:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->DownloadCannotResume:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->DownloadDeviceNotFound:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x13

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->DownloadFailedToDeleteUpdateOnOutOfSpace:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x14

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->DownloadFileExists:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x15

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->DownloadFileError:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x16

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->DownloadHTTPError:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x17

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->DownloadInsufficientSpace:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x18

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->DownloadTooManyRedirects:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x19

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->DownloadUnhandledHTTPCode:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->DownloadUnknownError:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->DownloadHTTPClientError4xx:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x1c

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->DownloadHTTPServerError5xx:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x1d

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->DownloadManagerRaceCondition:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x1e

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->DownloadInstallManifestFailed:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x1f

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->DownloadInstallManifestBadEncoding:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x20

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->DownloadDatabaseInBadState:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x21

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->DownloadUpdatesFailure:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x22

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->DownloadMalformedLocalURI:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x23

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->DownloadAppPackageParseFailure:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x24

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->DownloadAppPackageNameVerificationFailure:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x25

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->DownloadAppVersionVerificationFailure:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x26

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->DownloadOSVersionVerificationFailure:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x27

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->DownloadOSVerificationFailure:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x28

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallOSFailureOnReboot:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x29

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureAlreadyExists:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x2a

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureInvalidApk:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x2b

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureInvalidUri:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x2c

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureInsufficientStorage:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x2d

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureDuplicatePackage:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x2e

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureNoSharedUser:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x2f

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureUpdateIncompatible:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x30

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureSharedUserIncompatible:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x31

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureMissingSharedLibrary:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x32

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureReplaceCouldntDelete:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x33

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureDexopt:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x34

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureOlderSdk:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x35

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureConflictingProvider:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x36

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureNewerSdk:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x37

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureTestOnly:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x38

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureCPUAbiIncompatible:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x39

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureMissingFeature:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x3a

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureContainerError:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x3b

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureInvalidInstallLocation:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x3c

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureMediaUnavailable:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x3d

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureNotApk:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x3e

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureBadManifest:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x3f

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureUnexpectedException:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x40

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureNoCertificates:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x41

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureInconsistentCertificates:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x42

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureCertificateEncoding:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x43

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureBadPackageName:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x44

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureBadSharedUserId:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x45

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureManifestMalformed:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x46

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureManifestEmpty:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x47

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailureInternalError:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x48

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationFailure:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x49

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallApplicationStalled:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x4a

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallOSMalformedURI:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x4b

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallOSIOFailure:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x4c

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallOSUnexpectedError:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x4d

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallErrorMarkingPackageAsInstalled:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x4e

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallDatabaseInvalidUpdateType:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x4f

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallCheckOSUpdateStatusFailure:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x50

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->InstallProcessUpdatesFailure:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x51

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->UpdateCancelledFailure:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x52

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->DownloadSignatureMismatch:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    const/16 v1, 0x53

    sget-object v2, Lcom/amazon/dcp/ota/OTAFailure;->ProcessManifestDatabaseInsertionFailure:Lcom/amazon/dcp/ota/OTAFailure;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/dcp/ota/OTAFailure;->$VALUES:[Lcom/amazon/dcp/ota/OTAFailure;

    .line 96
    new-instance v0, Lcom/amazon/dcp/ota/OTAFailure$1;

    invoke-direct {v0}, Lcom/amazon/dcp/ota/OTAFailure$1;-><init>()V

    sput-object v0, Lcom/amazon/dcp/ota/OTAFailure;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;IILcom/amazon/dcp/ota/OTAStep;Ljava/lang/String;)V
    .locals 2
    .param p3, "id"    # I
    .param p4, "step"    # Lcom/amazon/dcp/ota/OTAStep;
    .param p5, "reason"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Lcom/amazon/dcp/ota/OTAStep;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 116
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 117
    iput p3, p0, Lcom/amazon/dcp/ota/OTAFailure;->mValue:I

    .line 118
    iput-object p4, p0, Lcom/amazon/dcp/ota/OTAFailure;->mStep:Lcom/amazon/dcp/ota/OTAStep;

    .line 119
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p4}, Lcom/amazon/dcp/ota/OTAStep;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "Failure"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/dcp/ota/OTAFailure;->mFailureString:Ljava/lang/String;

    .line 120
    return-void
.end method

.method public static fromValue(I)Lcom/amazon/dcp/ota/OTAFailure;
    .locals 5
    .param p0, "value"    # I

    .prologue
    .line 140
    invoke-static {}, Lcom/amazon/dcp/ota/OTAFailure;->values()[Lcom/amazon/dcp/ota/OTAFailure;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/dcp/ota/OTAFailure;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_1

    aget-object v1, v0, v2

    .line 142
    .local v1, "failure":Lcom/amazon/dcp/ota/OTAFailure;
    invoke-virtual {v1}, Lcom/amazon/dcp/ota/OTAFailure;->value()I

    move-result v4

    if-ne v4, p0, :cond_0

    .line 148
    .end local v1    # "failure":Lcom/amazon/dcp/ota/OTAFailure;
    :goto_1
    return-object v1

    .line 140
    .restart local v1    # "failure":Lcom/amazon/dcp/ota/OTAFailure;
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 148
    .end local v1    # "failure":Lcom/amazon/dcp/ota/OTAFailure;
    :cond_1
    sget-object v1, Lcom/amazon/dcp/ota/OTAFailure;->Unknown:Lcom/amazon/dcp/ota/OTAFailure;

    goto :goto_1
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/dcp/ota/OTAFailure;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 7
    const-class v0, Lcom/amazon/dcp/ota/OTAFailure;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/dcp/ota/OTAFailure;

    return-object v0
.end method

.method public static values()[Lcom/amazon/dcp/ota/OTAFailure;
    .locals 1

    .prologue
    .line 7
    sget-object v0, Lcom/amazon/dcp/ota/OTAFailure;->$VALUES:[Lcom/amazon/dcp/ota/OTAFailure;

    invoke-virtual {v0}, [Lcom/amazon/dcp/ota/OTAFailure;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/dcp/ota/OTAFailure;

    return-object v0
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 154
    const/4 v0, 0x0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 130
    iget-object v0, p0, Lcom/amazon/dcp/ota/OTAFailure;->mFailureString:Ljava/lang/String;

    return-object v0
.end method

.method public value()I
    .locals 1

    .prologue
    .line 135
    iget v0, p0, Lcom/amazon/dcp/ota/OTAFailure;->mValue:I

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 160
    iget v0, p0, Lcom/amazon/dcp/ota/OTAFailure;->mValue:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 161
    return-void
.end method
