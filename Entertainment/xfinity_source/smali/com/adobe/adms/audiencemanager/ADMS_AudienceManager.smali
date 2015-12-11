.class public Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;
.super Ljava/lang/Object;
.source "ADMS_AudienceManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$SubmitSignalTask;,
        Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$AudienceManagerCallback;
    }
.end annotation


# static fields
.field private static final ADB_AUDIENCE_MANAGER_CUSTOMER_DATA_PREFIX:Ljava/lang/String; = "c_"

.field private static final ADB_AUDIENCE_MANAGER_DATA_PROVIDER_ID_KEY:Ljava/lang/String; = "d_dpid"

.field private static final ADB_AUDIENCE_MANAGER_DATA_PROVIDER_USER_ID_KEY:Ljava/lang/String; = "d_dpuuid"

.field private static final ADB_AUDIENCE_MANAGER_JSON_COOKIE_NAME_KEY:Ljava/lang/String; = "cn"

.field private static final ADB_AUDIENCE_MANAGER_JSON_COOKIE_VALUE_KEY:Ljava/lang/String; = "cv"

.field private static final ADB_AUDIENCE_MANAGER_JSON_DESTS_KEY:Ljava/lang/String; = "dests"

.field private static final ADB_AUDIENCE_MANAGER_JSON_STUFF_KEY:Ljava/lang/String; = "stuff"

.field private static final ADB_AUDIENCE_MANAGER_JSON_URL_KEY:Ljava/lang/String; = "c"

.field private static final ADB_AUDIENCE_MANAGER_JSON_USER_ID_KEY:Ljava/lang/String; = "uuid"

.field private static final ADB_AUDIENCE_MANAGER_SHARED_PREFS_PROFILE_KEY:Ljava/lang/String; = "AAMUserProfile"

.field private static final ADB_AUDIENCE_MANAGER_SHARED_PREFS_USER_ID_KEY:Ljava/lang/String; = "AAMUserId"

.field private static final ADB_AUDIENCE_MANAGER_URL_PREFIX:Ljava/lang/String; = "http://%s/event?"

.field private static final ADB_AUDIENCE_MANAGER_URL_SUFFIX:Ljava/lang/String; = "&d_ptfm=android&d_dst=1&d_rtbd=json"

.field private static final ADB_AUDIENCE_MANAGER_USER_ID_KEY:Ljava/lang/String; = "d_uuid"

.field private static final PREFS_NAME:Ljava/lang/String; = "APP_MEASUREMENT_CACHE"

.field private static volatile SharedPreferencesEditor_pred:Z

.field private static volatile SharedPreferences_pred:Z

.field private static volatile UrlPrefix_pred:Z

.field private static volatile Uuid_pred:Z

.field private static volatile VisitorProfile_pred:Z

.field private static _aamServer:Ljava/lang/String;

.field private static _context:Landroid/content/Context;

.field private static _debugLogging:Z

.field private static _dpid:Ljava/lang/String;

.field private static _dpuuid:Ljava/lang/String;

.field private static _editor:Landroid/content/SharedPreferences$Editor;

.field private static _prefs:Landroid/content/SharedPreferences;

.field private static _urlPrefix:Ljava/lang/String;

.field private static _uuid:Ljava/lang/String;

.field private static _visitorProfile:Ljava/util/HashMap;

.field private static final encodedChars:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    const/4 v0, 0x0

    .line 55
    sput-object v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_context:Landroid/content/Context;

    .line 56
    sput-object v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_aamServer:Ljava/lang/String;

    .line 57
    sput-object v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_dpid:Ljava/lang/String;

    .line 58
    sput-object v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_dpuuid:Ljava/lang/String;

    .line 59
    sput-object v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_uuid:Ljava/lang/String;

    .line 60
    sput-object v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_visitorProfile:Ljava/util/HashMap;

    .line 61
    sput-boolean v3, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_debugLogging:Z

    .line 78
    sput-boolean v2, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->VisitorProfile_pred:Z

    .line 331
    sput-boolean v2, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->Uuid_pred:Z

    .line 360
    sput-object v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_urlPrefix:Ljava/lang/String;

    .line 361
    sput-boolean v2, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->UrlPrefix_pred:Z

    .line 371
    sput-object v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_prefs:Landroid/content/SharedPreferences;

    .line 372
    sput-boolean v2, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->SharedPreferences_pred:Z

    .line 382
    sput-object v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_editor:Landroid/content/SharedPreferences$Editor;

    .line 383
    sput-boolean v2, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->SharedPreferencesEditor_pred:Z

    .line 411
    const/16 v0, 0x100

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "%00"

    aput-object v1, v0, v3

    const-string v1, "%01"

    aput-object v1, v0, v2

    const/4 v1, 0x2

    const-string v2, "%02"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "%03"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "%04"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string v2, "%05"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "%06"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "%07"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "%08"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "%09"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "%0A"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, "%0B"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string v2, "%0C"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string v2, "%0D"

    aput-object v2, v0, v1

    const/16 v1, 0xe

    const-string v2, "%0E"

    aput-object v2, v0, v1

    const/16 v1, 0xf

    const-string v2, "%0F"

    aput-object v2, v0, v1

    const/16 v1, 0x10

    const-string v2, "%10"

    aput-object v2, v0, v1

    const/16 v1, 0x11

    const-string v2, "%11"

    aput-object v2, v0, v1

    const/16 v1, 0x12

    const-string v2, "%12"

    aput-object v2, v0, v1

    const/16 v1, 0x13

    const-string v2, "%13"

    aput-object v2, v0, v1

    const/16 v1, 0x14

    const-string v2, "%14"

    aput-object v2, v0, v1

    const/16 v1, 0x15

    const-string v2, "%15"

    aput-object v2, v0, v1

    const/16 v1, 0x16

    const-string v2, "%16"

    aput-object v2, v0, v1

    const/16 v1, 0x17

    const-string v2, "%17"

    aput-object v2, v0, v1

    const/16 v1, 0x18

    const-string v2, "%18"

    aput-object v2, v0, v1

    const/16 v1, 0x19

    const-string v2, "%19"

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    const-string v2, "%1A"

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    const-string v2, "%1B"

    aput-object v2, v0, v1

    const/16 v1, 0x1c

    const-string v2, "%1C"

    aput-object v2, v0, v1

    const/16 v1, 0x1d

    const-string v2, "%1D"

    aput-object v2, v0, v1

    const/16 v1, 0x1e

    const-string v2, "%1E"

    aput-object v2, v0, v1

    const/16 v1, 0x1f

    const-string v2, "%1F"

    aput-object v2, v0, v1

    const/16 v1, 0x20

    const-string v2, "%20"

    aput-object v2, v0, v1

    const/16 v1, 0x21

    const-string v2, "%21"

    aput-object v2, v0, v1

    const/16 v1, 0x22

    const-string v2, "%22"

    aput-object v2, v0, v1

    const/16 v1, 0x23

    const-string v2, "%23"

    aput-object v2, v0, v1

    const/16 v1, 0x24

    const-string v2, "%24"

    aput-object v2, v0, v1

    const/16 v1, 0x25

    const-string v2, "%25"

    aput-object v2, v0, v1

    const/16 v1, 0x26

    const-string v2, "%26"

    aput-object v2, v0, v1

    const/16 v1, 0x27

    const-string v2, "%27"

    aput-object v2, v0, v1

    const/16 v1, 0x28

    const-string v2, "%28"

    aput-object v2, v0, v1

    const/16 v1, 0x29

    const-string v2, "%29"

    aput-object v2, v0, v1

    const/16 v1, 0x2a

    const-string v2, "*"

    aput-object v2, v0, v1

    const/16 v1, 0x2b

    const-string v2, "%2B"

    aput-object v2, v0, v1

    const/16 v1, 0x2c

    const-string v2, "%2C"

    aput-object v2, v0, v1

    const/16 v1, 0x2d

    const-string v2, "-"

    aput-object v2, v0, v1

    const/16 v1, 0x2e

    const-string v2, "."

    aput-object v2, v0, v1

    const/16 v1, 0x2f

    const-string v2, "%2F"

    aput-object v2, v0, v1

    const/16 v1, 0x30

    const-string v2, "0"

    aput-object v2, v0, v1

    const/16 v1, 0x31

    const-string v2, "1"

    aput-object v2, v0, v1

    const/16 v1, 0x32

    const-string v2, "2"

    aput-object v2, v0, v1

    const/16 v1, 0x33

    const-string v2, "3"

    aput-object v2, v0, v1

    const/16 v1, 0x34

    const-string v2, "4"

    aput-object v2, v0, v1

    const/16 v1, 0x35

    const-string v2, "5"

    aput-object v2, v0, v1

    const/16 v1, 0x36

    const-string v2, "6"

    aput-object v2, v0, v1

    const/16 v1, 0x37

    const-string v2, "7"

    aput-object v2, v0, v1

    const/16 v1, 0x38

    const-string v2, "8"

    aput-object v2, v0, v1

    const/16 v1, 0x39

    const-string v2, "9"

    aput-object v2, v0, v1

    const/16 v1, 0x3a

    const-string v2, "%3A"

    aput-object v2, v0, v1

    const/16 v1, 0x3b

    const-string v2, "%3B"

    aput-object v2, v0, v1

    const/16 v1, 0x3c

    const-string v2, "%3C"

    aput-object v2, v0, v1

    const/16 v1, 0x3d

    const-string v2, "%3D"

    aput-object v2, v0, v1

    const/16 v1, 0x3e

    const-string v2, "%3E"

    aput-object v2, v0, v1

    const/16 v1, 0x3f

    const-string v2, "%3F"

    aput-object v2, v0, v1

    const/16 v1, 0x40

    const-string v2, "%40"

    aput-object v2, v0, v1

    const/16 v1, 0x41

    const-string v2, "A"

    aput-object v2, v0, v1

    const/16 v1, 0x42

    const-string v2, "B"

    aput-object v2, v0, v1

    const/16 v1, 0x43

    const-string v2, "C"

    aput-object v2, v0, v1

    const/16 v1, 0x44

    const-string v2, "D"

    aput-object v2, v0, v1

    const/16 v1, 0x45

    const-string v2, "E"

    aput-object v2, v0, v1

    const/16 v1, 0x46

    const-string v2, "F"

    aput-object v2, v0, v1

    const/16 v1, 0x47

    const-string v2, "G"

    aput-object v2, v0, v1

    const/16 v1, 0x48

    const-string v2, "H"

    aput-object v2, v0, v1

    const/16 v1, 0x49

    const-string v2, "I"

    aput-object v2, v0, v1

    const/16 v1, 0x4a

    const-string v2, "J"

    aput-object v2, v0, v1

    const/16 v1, 0x4b

    const-string v2, "K"

    aput-object v2, v0, v1

    const/16 v1, 0x4c

    const-string v2, "L"

    aput-object v2, v0, v1

    const/16 v1, 0x4d

    const-string v2, "M"

    aput-object v2, v0, v1

    const/16 v1, 0x4e

    const-string v2, "N"

    aput-object v2, v0, v1

    const/16 v1, 0x4f

    const-string v2, "O"

    aput-object v2, v0, v1

    const/16 v1, 0x50

    const-string v2, "P"

    aput-object v2, v0, v1

    const/16 v1, 0x51

    const-string v2, "Q"

    aput-object v2, v0, v1

    const/16 v1, 0x52

    const-string v2, "R"

    aput-object v2, v0, v1

    const/16 v1, 0x53

    const-string v2, "S"

    aput-object v2, v0, v1

    const/16 v1, 0x54

    const-string v2, "T"

    aput-object v2, v0, v1

    const/16 v1, 0x55

    const-string v2, "U"

    aput-object v2, v0, v1

    const/16 v1, 0x56

    const-string v2, "V"

    aput-object v2, v0, v1

    const/16 v1, 0x57

    const-string v2, "W"

    aput-object v2, v0, v1

    const/16 v1, 0x58

    const-string v2, "X"

    aput-object v2, v0, v1

    const/16 v1, 0x59

    const-string v2, "Y"

    aput-object v2, v0, v1

    const/16 v1, 0x5a

    const-string v2, "Z"

    aput-object v2, v0, v1

    const/16 v1, 0x5b

    const-string v2, "%5B"

    aput-object v2, v0, v1

    const/16 v1, 0x5c

    const-string v2, "%5C"

    aput-object v2, v0, v1

    const/16 v1, 0x5d

    const-string v2, "%5D"

    aput-object v2, v0, v1

    const/16 v1, 0x5e

    const-string v2, "%5E"

    aput-object v2, v0, v1

    const/16 v1, 0x5f

    const-string v2, "_"

    aput-object v2, v0, v1

    const/16 v1, 0x60

    const-string v2, "%60"

    aput-object v2, v0, v1

    const/16 v1, 0x61

    const-string v2, "a"

    aput-object v2, v0, v1

    const/16 v1, 0x62

    const-string v2, "b"

    aput-object v2, v0, v1

    const/16 v1, 0x63

    const-string v2, "c"

    aput-object v2, v0, v1

    const/16 v1, 0x64

    const-string v2, "d"

    aput-object v2, v0, v1

    const/16 v1, 0x65

    const-string v2, "e"

    aput-object v2, v0, v1

    const/16 v1, 0x66

    const-string v2, "f"

    aput-object v2, v0, v1

    const/16 v1, 0x67

    const-string v2, "g"

    aput-object v2, v0, v1

    const/16 v1, 0x68

    const-string v2, "h"

    aput-object v2, v0, v1

    const/16 v1, 0x69

    const-string v2, "i"

    aput-object v2, v0, v1

    const/16 v1, 0x6a

    const-string v2, "j"

    aput-object v2, v0, v1

    const/16 v1, 0x6b

    const-string v2, "k"

    aput-object v2, v0, v1

    const/16 v1, 0x6c

    const-string v2, "l"

    aput-object v2, v0, v1

    const/16 v1, 0x6d

    const-string v2, "m"

    aput-object v2, v0, v1

    const/16 v1, 0x6e

    const-string v2, "n"

    aput-object v2, v0, v1

    const/16 v1, 0x6f

    const-string v2, "o"

    aput-object v2, v0, v1

    const/16 v1, 0x70

    const-string v2, "p"

    aput-object v2, v0, v1

    const/16 v1, 0x71

    const-string v2, "q"

    aput-object v2, v0, v1

    const/16 v1, 0x72

    const-string v2, "r"

    aput-object v2, v0, v1

    const/16 v1, 0x73

    const-string v2, "s"

    aput-object v2, v0, v1

    const/16 v1, 0x74

    const-string v2, "t"

    aput-object v2, v0, v1

    const/16 v1, 0x75

    const-string v2, "u"

    aput-object v2, v0, v1

    const/16 v1, 0x76

    const-string v2, "v"

    aput-object v2, v0, v1

    const/16 v1, 0x77

    const-string v2, "w"

    aput-object v2, v0, v1

    const/16 v1, 0x78

    const-string v2, "x"

    aput-object v2, v0, v1

    const/16 v1, 0x79

    const-string v2, "y"

    aput-object v2, v0, v1

    const/16 v1, 0x7a

    const-string v2, "z"

    aput-object v2, v0, v1

    const/16 v1, 0x7b

    const-string v2, "%7B"

    aput-object v2, v0, v1

    const/16 v1, 0x7c

    const-string v2, "%7C"

    aput-object v2, v0, v1

    const/16 v1, 0x7d

    const-string v2, "%7D"

    aput-object v2, v0, v1

    const/16 v1, 0x7e

    const-string v2, "%7E"

    aput-object v2, v0, v1

    const/16 v1, 0x7f

    const-string v2, "%7F"

    aput-object v2, v0, v1

    const/16 v1, 0x80

    const-string v2, "%80"

    aput-object v2, v0, v1

    const/16 v1, 0x81

    const-string v2, "%81"

    aput-object v2, v0, v1

    const/16 v1, 0x82

    const-string v2, "%82"

    aput-object v2, v0, v1

    const/16 v1, 0x83

    const-string v2, "%83"

    aput-object v2, v0, v1

    const/16 v1, 0x84

    const-string v2, "%84"

    aput-object v2, v0, v1

    const/16 v1, 0x85

    const-string v2, "%85"

    aput-object v2, v0, v1

    const/16 v1, 0x86

    const-string v2, "%86"

    aput-object v2, v0, v1

    const/16 v1, 0x87

    const-string v2, "%87"

    aput-object v2, v0, v1

    const/16 v1, 0x88

    const-string v2, "%88"

    aput-object v2, v0, v1

    const/16 v1, 0x89

    const-string v2, "%89"

    aput-object v2, v0, v1

    const/16 v1, 0x8a

    const-string v2, "%8A"

    aput-object v2, v0, v1

    const/16 v1, 0x8b

    const-string v2, "%8B"

    aput-object v2, v0, v1

    const/16 v1, 0x8c

    const-string v2, "%8C"

    aput-object v2, v0, v1

    const/16 v1, 0x8d

    const-string v2, "%8D"

    aput-object v2, v0, v1

    const/16 v1, 0x8e

    const-string v2, "%8E"

    aput-object v2, v0, v1

    const/16 v1, 0x8f

    const-string v2, "%8F"

    aput-object v2, v0, v1

    const/16 v1, 0x90

    const-string v2, "%90"

    aput-object v2, v0, v1

    const/16 v1, 0x91

    const-string v2, "%91"

    aput-object v2, v0, v1

    const/16 v1, 0x92

    const-string v2, "%92"

    aput-object v2, v0, v1

    const/16 v1, 0x93

    const-string v2, "%93"

    aput-object v2, v0, v1

    const/16 v1, 0x94

    const-string v2, "%94"

    aput-object v2, v0, v1

    const/16 v1, 0x95

    const-string v2, "%95"

    aput-object v2, v0, v1

    const/16 v1, 0x96

    const-string v2, "%96"

    aput-object v2, v0, v1

    const/16 v1, 0x97

    const-string v2, "%97"

    aput-object v2, v0, v1

    const/16 v1, 0x98

    const-string v2, "%98"

    aput-object v2, v0, v1

    const/16 v1, 0x99

    const-string v2, "%99"

    aput-object v2, v0, v1

    const/16 v1, 0x9a

    const-string v2, "%9A"

    aput-object v2, v0, v1

    const/16 v1, 0x9b

    const-string v2, "%9B"

    aput-object v2, v0, v1

    const/16 v1, 0x9c

    const-string v2, "%9C"

    aput-object v2, v0, v1

    const/16 v1, 0x9d

    const-string v2, "%9D"

    aput-object v2, v0, v1

    const/16 v1, 0x9e

    const-string v2, "%9E"

    aput-object v2, v0, v1

    const/16 v1, 0x9f

    const-string v2, "%9F"

    aput-object v2, v0, v1

    const/16 v1, 0xa0

    const-string v2, "%A0"

    aput-object v2, v0, v1

    const/16 v1, 0xa1

    const-string v2, "%A1"

    aput-object v2, v0, v1

    const/16 v1, 0xa2

    const-string v2, "%A2"

    aput-object v2, v0, v1

    const/16 v1, 0xa3

    const-string v2, "%A3"

    aput-object v2, v0, v1

    const/16 v1, 0xa4

    const-string v2, "%A4"

    aput-object v2, v0, v1

    const/16 v1, 0xa5

    const-string v2, "%A5"

    aput-object v2, v0, v1

    const/16 v1, 0xa6

    const-string v2, "%A6"

    aput-object v2, v0, v1

    const/16 v1, 0xa7

    const-string v2, "%A7"

    aput-object v2, v0, v1

    const/16 v1, 0xa8

    const-string v2, "%A8"

    aput-object v2, v0, v1

    const/16 v1, 0xa9

    const-string v2, "%A9"

    aput-object v2, v0, v1

    const/16 v1, 0xaa

    const-string v2, "%AA"

    aput-object v2, v0, v1

    const/16 v1, 0xab

    const-string v2, "%AB"

    aput-object v2, v0, v1

    const/16 v1, 0xac

    const-string v2, "%AC"

    aput-object v2, v0, v1

    const/16 v1, 0xad

    const-string v2, "%AD"

    aput-object v2, v0, v1

    const/16 v1, 0xae

    const-string v2, "%AE"

    aput-object v2, v0, v1

    const/16 v1, 0xaf

    const-string v2, "%AF"

    aput-object v2, v0, v1

    const/16 v1, 0xb0

    const-string v2, "%B0"

    aput-object v2, v0, v1

    const/16 v1, 0xb1

    const-string v2, "%B1"

    aput-object v2, v0, v1

    const/16 v1, 0xb2

    const-string v2, "%B2"

    aput-object v2, v0, v1

    const/16 v1, 0xb3

    const-string v2, "%B3"

    aput-object v2, v0, v1

    const/16 v1, 0xb4

    const-string v2, "%B4"

    aput-object v2, v0, v1

    const/16 v1, 0xb5

    const-string v2, "%B5"

    aput-object v2, v0, v1

    const/16 v1, 0xb6

    const-string v2, "%B6"

    aput-object v2, v0, v1

    const/16 v1, 0xb7

    const-string v2, "%B7"

    aput-object v2, v0, v1

    const/16 v1, 0xb8

    const-string v2, "%B8"

    aput-object v2, v0, v1

    const/16 v1, 0xb9

    const-string v2, "%B9"

    aput-object v2, v0, v1

    const/16 v1, 0xba

    const-string v2, "%BA"

    aput-object v2, v0, v1

    const/16 v1, 0xbb

    const-string v2, "%BB"

    aput-object v2, v0, v1

    const/16 v1, 0xbc

    const-string v2, "%BC"

    aput-object v2, v0, v1

    const/16 v1, 0xbd

    const-string v2, "%BD"

    aput-object v2, v0, v1

    const/16 v1, 0xbe

    const-string v2, "%BE"

    aput-object v2, v0, v1

    const/16 v1, 0xbf

    const-string v2, "%BF"

    aput-object v2, v0, v1

    const/16 v1, 0xc0

    const-string v2, "%C0"

    aput-object v2, v0, v1

    const/16 v1, 0xc1

    const-string v2, "%C1"

    aput-object v2, v0, v1

    const/16 v1, 0xc2

    const-string v2, "%C2"

    aput-object v2, v0, v1

    const/16 v1, 0xc3

    const-string v2, "%C3"

    aput-object v2, v0, v1

    const/16 v1, 0xc4

    const-string v2, "%C4"

    aput-object v2, v0, v1

    const/16 v1, 0xc5

    const-string v2, "%C5"

    aput-object v2, v0, v1

    const/16 v1, 0xc6

    const-string v2, "%C6"

    aput-object v2, v0, v1

    const/16 v1, 0xc7

    const-string v2, "%C7"

    aput-object v2, v0, v1

    const/16 v1, 0xc8

    const-string v2, "%C8"

    aput-object v2, v0, v1

    const/16 v1, 0xc9

    const-string v2, "%C9"

    aput-object v2, v0, v1

    const/16 v1, 0xca

    const-string v2, "%CA"

    aput-object v2, v0, v1

    const/16 v1, 0xcb

    const-string v2, "%CB"

    aput-object v2, v0, v1

    const/16 v1, 0xcc

    const-string v2, "%CC"

    aput-object v2, v0, v1

    const/16 v1, 0xcd

    const-string v2, "%CD"

    aput-object v2, v0, v1

    const/16 v1, 0xce

    const-string v2, "%CE"

    aput-object v2, v0, v1

    const/16 v1, 0xcf

    const-string v2, "%CF"

    aput-object v2, v0, v1

    const/16 v1, 0xd0

    const-string v2, "%D0"

    aput-object v2, v0, v1

    const/16 v1, 0xd1

    const-string v2, "%D1"

    aput-object v2, v0, v1

    const/16 v1, 0xd2

    const-string v2, "%D2"

    aput-object v2, v0, v1

    const/16 v1, 0xd3

    const-string v2, "%D3"

    aput-object v2, v0, v1

    const/16 v1, 0xd4

    const-string v2, "%D4"

    aput-object v2, v0, v1

    const/16 v1, 0xd5

    const-string v2, "%D5"

    aput-object v2, v0, v1

    const/16 v1, 0xd6

    const-string v2, "%D6"

    aput-object v2, v0, v1

    const/16 v1, 0xd7

    const-string v2, "%D7"

    aput-object v2, v0, v1

    const/16 v1, 0xd8

    const-string v2, "%D8"

    aput-object v2, v0, v1

    const/16 v1, 0xd9

    const-string v2, "%D9"

    aput-object v2, v0, v1

    const/16 v1, 0xda

    const-string v2, "%DA"

    aput-object v2, v0, v1

    const/16 v1, 0xdb

    const-string v2, "%DB"

    aput-object v2, v0, v1

    const/16 v1, 0xdc

    const-string v2, "%DC"

    aput-object v2, v0, v1

    const/16 v1, 0xdd

    const-string v2, "%DD"

    aput-object v2, v0, v1

    const/16 v1, 0xde

    const-string v2, "%DE"

    aput-object v2, v0, v1

    const/16 v1, 0xdf

    const-string v2, "%DF"

    aput-object v2, v0, v1

    const/16 v1, 0xe0

    const-string v2, "%E0"

    aput-object v2, v0, v1

    const/16 v1, 0xe1

    const-string v2, "%E1"

    aput-object v2, v0, v1

    const/16 v1, 0xe2

    const-string v2, "%E2"

    aput-object v2, v0, v1

    const/16 v1, 0xe3

    const-string v2, "%E3"

    aput-object v2, v0, v1

    const/16 v1, 0xe4

    const-string v2, "%E4"

    aput-object v2, v0, v1

    const/16 v1, 0xe5

    const-string v2, "%E5"

    aput-object v2, v0, v1

    const/16 v1, 0xe6

    const-string v2, "%E6"

    aput-object v2, v0, v1

    const/16 v1, 0xe7

    const-string v2, "%E7"

    aput-object v2, v0, v1

    const/16 v1, 0xe8

    const-string v2, "%E8"

    aput-object v2, v0, v1

    const/16 v1, 0xe9

    const-string v2, "%E9"

    aput-object v2, v0, v1

    const/16 v1, 0xea

    const-string v2, "%EA"

    aput-object v2, v0, v1

    const/16 v1, 0xeb

    const-string v2, "%EB"

    aput-object v2, v0, v1

    const/16 v1, 0xec

    const-string v2, "%EC"

    aput-object v2, v0, v1

    const/16 v1, 0xed

    const-string v2, "%ED"

    aput-object v2, v0, v1

    const/16 v1, 0xee

    const-string v2, "%EE"

    aput-object v2, v0, v1

    const/16 v1, 0xef

    const-string v2, "%EF"

    aput-object v2, v0, v1

    const/16 v1, 0xf0

    const-string v2, "%F0"

    aput-object v2, v0, v1

    const/16 v1, 0xf1

    const-string v2, "%F1"

    aput-object v2, v0, v1

    const/16 v1, 0xf2

    const-string v2, "%F2"

    aput-object v2, v0, v1

    const/16 v1, 0xf3

    const-string v2, "%F3"

    aput-object v2, v0, v1

    const/16 v1, 0xf4

    const-string v2, "%F4"

    aput-object v2, v0, v1

    const/16 v1, 0xf5

    const-string v2, "%F5"

    aput-object v2, v0, v1

    const/16 v1, 0xf6

    const-string v2, "%F6"

    aput-object v2, v0, v1

    const/16 v1, 0xf7

    const-string v2, "%F7"

    aput-object v2, v0, v1

    const/16 v1, 0xf8

    const-string v2, "%F8"

    aput-object v2, v0, v1

    const/16 v1, 0xf9

    const-string v2, "%F9"

    aput-object v2, v0, v1

    const/16 v1, 0xfa

    const-string v2, "%FA"

    aput-object v2, v0, v1

    const/16 v1, 0xfb

    const-string v2, "%FB"

    aput-object v2, v0, v1

    const/16 v1, 0xfc

    const-string v2, "%FC"

    aput-object v2, v0, v1

    const/16 v1, 0xfd

    const-string v2, "%FD"

    aput-object v2, v0, v1

    const/16 v1, 0xfe

    const-string v2, "%FE"

    aput-object v2, v0, v1

    const/16 v1, 0xff

    const-string v2, "%FF"

    aput-object v2, v0, v1

    sput-object v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->encodedChars:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 116
    return-void
.end method

.method private static varargs ADBLogDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 3
    .param p0, "format"    # Ljava/lang/String;
    .param p1, "args"    # [Ljava/lang/Object;

    .prologue
    .line 404
    invoke-static {}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->GetDebugLogging()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 405
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "ADBMobile Debug : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, p1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 406
    .local v0, "formattedString":Ljava/lang/String;
    const-string v1, "ADBMobile"

    invoke-static {v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 408
    .end local v0    # "formattedString":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method private static varargs ADBLogErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 3
    .param p0, "format"    # Ljava/lang/String;
    .param p1, "args"    # [Ljava/lang/Object;

    .prologue
    .line 399
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "ADBMobile Error : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, p1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 400
    .local v0, "formattedString":Ljava/lang/String;
    const-string v1, "ADBMobile"

    invoke-static {v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 401
    return-void
.end method

.method public static AudienceManagerIsConfigured()Z
    .locals 1

    .prologue
    .line 394
    sget-object v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_aamServer:Ljava/lang/String;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_aamServer:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static BuildSchemaRequest(Ljava/util/HashMap;)Ljava/lang/String;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 258
    .local p0, "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 260
    .local v0, "urlSB":Ljava/lang/StringBuilder;
    invoke-static {}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->GetUrlPrefix()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p0}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->GetCustomUrlVariables(Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->GetDataProviderUrlVariables()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "&d_ptfm=android&d_dst=1&d_rtbd=json"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 266
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 267
    .local v1, "urlString":Ljava/lang/String;
    const-string v2, "?&"

    const-string v3, "?"

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    .line 269
    return-object v1
.end method

.method public static ConfigureAudienceManager(Ljava/lang/String;Landroid/content/Context;)V
    .locals 0
    .param p0, "server"    # Ljava/lang/String;
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 74
    sput-object p0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_aamServer:Ljava/lang/String;

    .line 75
    sput-object p1, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_context:Landroid/content/Context;

    .line 76
    return-void
.end method

.method private static GetCustomUrlVariables(Ljava/util/HashMap;)Ljava/lang/String;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 273
    .local p0, "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/util/HashMap;->size()I

    move-result v3

    if-nez v3, :cond_1

    .line 274
    :cond_0
    const-string v3, ""

    .line 287
    :goto_0
    return-object v3

    .line 277
    :cond_1
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 279
    .local v2, "urlVars":Ljava/lang/StringBuilder;
    invoke-virtual {p0}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 280
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v3, "&"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "c_"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-static {v3}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->SanitizeUrlVariableName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->urlEncode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 287
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_2
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto :goto_0
.end method

.method private static GetDataProviderUrlVariables()Ljava/lang/String;
    .locals 3

    .prologue
    .line 297
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 300
    .local v0, "urlVars":Ljava/lang/StringBuilder;
    invoke-static {}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->GetUUID()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 301
    const-string v1, "&"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "d_uuid"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->GetUUID()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 308
    :cond_0
    sget-object v1, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_dpid:Ljava/lang/String;

    if-eqz v1, :cond_1

    sget-object v1, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_dpid:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_1

    sget-object v1, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_dpuuid:Ljava/lang/String;

    if-eqz v1, :cond_1

    sget-object v1, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_dpuuid:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_1

    .line 309
    const-string v1, "&"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "d_dpid"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_dpid:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "&"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "d_dpuuid"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_dpuuid:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 319
    :cond_1
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public static GetDebugLogging()Z
    .locals 1

    .prologue
    .line 96
    sget-boolean v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_debugLogging:Z

    return v0
.end method

.method public static GetDpid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 108
    sget-object v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_dpid:Ljava/lang/String;

    return-object v0
.end method

.method public static GetDpuuid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 104
    sget-object v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_dpuuid:Ljava/lang/String;

    return-object v0
.end method

.method private static GetSharedPreferences()Landroid/content/SharedPreferences;
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 374
    sget-boolean v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->SharedPreferences_pred:Z

    if-eqz v0, :cond_0

    .line 375
    sput-boolean v2, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->SharedPreferences_pred:Z

    .line 376
    sget-object v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_context:Landroid/content/Context;

    const-string v1, "APP_MEASUREMENT_CACHE"

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    sput-object v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_prefs:Landroid/content/SharedPreferences;

    .line 379
    :cond_0
    sget-object v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_prefs:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method private static GetSharedPreferencesEditor()Landroid/content/SharedPreferences$Editor;
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 385
    sget-boolean v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->SharedPreferencesEditor_pred:Z

    if-eqz v0, :cond_0

    .line 386
    sput-boolean v2, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->SharedPreferencesEditor_pred:Z

    .line 387
    sget-object v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_context:Landroid/content/Context;

    const-string v1, "APP_MEASUREMENT_CACHE"

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    sput-object v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_editor:Landroid/content/SharedPreferences$Editor;

    .line 390
    :cond_0
    sget-object v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_editor:Landroid/content/SharedPreferences$Editor;

    return-object v0
.end method

.method private static GetUUID()Ljava/lang/String;
    .locals 3

    .prologue
    .line 333
    sget-boolean v1, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->Uuid_pred:Z

    if-eqz v1, :cond_0

    .line 334
    const/4 v1, 0x0

    sput-boolean v1, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->Uuid_pred:Z

    .line 335
    invoke-static {}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->GetSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v0

    .line 336
    .local v0, "settings":Landroid/content/SharedPreferences;
    const-string v1, "AAMUserId"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_uuid:Ljava/lang/String;

    .line 339
    :cond_0
    sget-object v1, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_uuid:Ljava/lang/String;

    return-object v1
.end method

.method private static GetUrlPrefix()Ljava/lang/String;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 363
    sget-boolean v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->UrlPrefix_pred:Z

    if-eqz v0, :cond_0

    .line 364
    sput-boolean v3, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->UrlPrefix_pred:Z

    .line 365
    const-string v0, "http://%s/event?"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    sget-object v2, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_aamServer:Ljava/lang/String;

    aput-object v2, v1, v3

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_urlPrefix:Ljava/lang/String;

    .line 368
    :cond_0
    sget-object v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_urlPrefix:Ljava/lang/String;

    return-object v0
.end method

.method public static GetVisitorProfile()Ljava/util/HashMap;
    .locals 5

    .prologue
    const/4 v2, 0x0

    const/4 v4, 0x0

    .line 80
    sget-object v3, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_context:Landroid/content/Context;

    if-nez v3, :cond_0

    .line 81
    const-string v3, "Audience Manager - Unable to retrieve visitor profile from SharedPreferences, context is null"

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v3, v4}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->ADBLogErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 92
    .local v0, "profile":Ljava/lang/String;
    .local v1, "settings":Landroid/content/SharedPreferences;
    :goto_0
    return-object v2

    .line 85
    .end local v0    # "profile":Ljava/lang/String;
    .end local v1    # "settings":Landroid/content/SharedPreferences;
    :cond_0
    sget-boolean v3, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->VisitorProfile_pred:Z

    if-eqz v3, :cond_1

    .line 86
    sput-boolean v4, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->VisitorProfile_pred:Z

    .line 87
    invoke-static {}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->GetSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v1

    .line 88
    .restart local v1    # "settings":Landroid/content/SharedPreferences;
    const-string v3, "AAMUserProfile"

    invoke-interface {v1, v3, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 89
    .restart local v0    # "profile":Ljava/lang/String;
    invoke-static {v0}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->restoreFromStringify(Ljava/lang/String;)Ljava/util/HashMap;

    move-result-object v2

    sput-object v2, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_visitorProfile:Ljava/util/HashMap;

    .line 92
    :cond_1
    sget-object v2, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_visitorProfile:Ljava/util/HashMap;

    goto :goto_0
.end method

.method private static SanitizeUrlVariableName(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 292
    const-string v0, "."

    const-string v1, "_"

    invoke-virtual {p0, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static SetDebugLogging(Z)V
    .locals 0
    .param p0, "logging"    # Z

    .prologue
    .line 100
    sput-boolean p0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_debugLogging:Z

    .line 101
    return-void
.end method

.method public static SetDpidAndDpuuid(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "newDpid"    # Ljava/lang/String;
    .param p1, "newDpuuid"    # Ljava/lang/String;

    .prologue
    .line 112
    sput-object p0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_dpid:Ljava/lang/String;

    .line 113
    sput-object p1, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_dpuuid:Ljava/lang/String;

    .line 114
    return-void
.end method

.method private static SetUUID(Ljava/lang/String;)V
    .locals 3
    .param p0, "newUuid"    # Ljava/lang/String;

    .prologue
    .line 323
    sget-object v1, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_uuid:Ljava/lang/String;

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 324
    sput-object p0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_uuid:Ljava/lang/String;

    .line 325
    invoke-static {}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->GetSharedPreferencesEditor()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 326
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "AAMUserId"

    sget-object v2, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_uuid:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 327
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 329
    .end local v0    # "editor":Landroid/content/SharedPreferences$Editor;
    :cond_0
    return-void
.end method

.method private static SetVisitorProfile(Ljava/util/HashMap;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 344
    .local p0, "profile":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v2, 0x0

    sput-boolean v2, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->VisitorProfile_pred:Z

    .line 346
    invoke-static {}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->GetSharedPreferencesEditor()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 348
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    if-eqz p0, :cond_0

    .line 349
    invoke-static {p0}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->stringify(Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v1

    .line 350
    .local v1, "profileString":Ljava/lang/String;
    const-string v2, "AAMUserProfile"

    invoke-interface {v0, v2, v1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 356
    .end local v1    # "profileString":Ljava/lang/String;
    :goto_0
    sput-object p0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_visitorProfile:Ljava/util/HashMap;

    .line 357
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 358
    return-void

    .line 353
    :cond_0
    const-string v2, "AAMUserProfile"

    invoke-interface {v0, v2}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    goto :goto_0
.end method

.method public static SubmitSignal(Ljava/util/HashMap;Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$AudienceManagerCallback;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;",
            "Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$AudienceManagerCallback",
            "<",
            "Ljava/util/HashMap;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 242
    .local p0, "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .local p1, "callback":Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$AudienceManagerCallback;, "Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$AudienceManagerCallback<Ljava/util/HashMap;>;"
    sget-object v1, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_aamServer:Ljava/lang/String;

    if-eqz v1, :cond_0

    sget-object v1, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->_aamServer:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_2

    .line 243
    :cond_0
    const-string v1, "Audience Manager - Configure has not been called"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v1, v2}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->ADBLogErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 244
    if-eqz p1, :cond_1

    .line 245
    const/4 v1, 0x0

    invoke-interface {p1, v1}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$AudienceManagerCallback;->call(Ljava/lang/Object;)V

    .line 252
    :cond_1
    :goto_0
    return-void

    .line 250
    :cond_2
    new-instance v0, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$SubmitSignalTask;

    invoke-direct {v0, p0, p1}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$SubmitSignalTask;-><init>(Ljava/util/HashMap;Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$AudienceManagerCallback;)V

    .line 251
    .local v0, "backgroundTask":Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager$SubmitSignalTask;
    new-instance v1, Ljava/lang/Thread;

    invoke-direct {v1, v0}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v1}, Ljava/lang/Thread;->start()V

    goto :goto_0
.end method

.method static synthetic access$000(Ljava/util/HashMap;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Ljava/util/HashMap;

    .prologue
    .line 25
    invoke-static {p0}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->BuildSchemaRequest(Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 0
    .param p0, "x0"    # Ljava/lang/String;
    .param p1, "x1"    # [Ljava/lang/Object;

    .prologue
    .line 25
    invoke-static {p0, p1}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->ADBLogDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    return-void
.end method

.method static synthetic access$200(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 0
    .param p0, "x0"    # Ljava/lang/String;
    .param p1, "x1"    # [Ljava/lang/Object;

    .prologue
    .line 25
    invoke-static {p0, p1}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->ADBLogErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    return-void
.end method

.method static synthetic access$300(Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Ljava/lang/String;

    .prologue
    .line 25
    invoke-static {p0}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->SetUUID(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$400(Ljava/util/HashMap;)V
    .locals 0
    .param p0, "x0"    # Ljava/util/HashMap;

    .prologue
    .line 25
    invoke-static {p0}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->SetVisitorProfile(Ljava/util/HashMap;)V

    return-void
.end method

.method private static restoreFromStringify(Ljava/lang/String;)Ljava/util/HashMap;
    .locals 9
    .param p0, "str"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 463
    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    .line 464
    .local v5, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v7, "|||"

    invoke-static {p0, v7}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->splitUsingTokenizer(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 465
    .local v3, "kvpArray":[Ljava/lang/String;
    move-object v0, v3

    .local v0, "arr$":[Ljava/lang/String;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v4, :cond_1

    aget-object v2, v0, v1

    .line 466
    .local v2, "kvp":Ljava/lang/String;
    const-string v7, "~~~"

    invoke-static {v2, v7}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->splitUsingTokenizer(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    .line 467
    .local v6, "pair":[Ljava/lang/String;
    array-length v7, v6

    const/4 v8, 0x2

    if-ne v7, v8, :cond_0

    .line 468
    const/4 v7, 0x0

    aget-object v7, v6, v7

    const/4 v8, 0x1

    aget-object v8, v6, v8

    invoke-virtual {v5, v7, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 465
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 472
    .end local v2    # "kvp":Ljava/lang/String;
    .end local v6    # "pair":[Ljava/lang/String;
    :cond_1
    return-object v5
.end method

.method private static splitUsingTokenizer(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;
    .locals 3
    .param p0, "source"    # Ljava/lang/String;
    .param p1, "delimiters"    # Ljava/lang/String;

    .prologue
    .line 476
    new-instance v1, Ljava/util/StringTokenizer;

    invoke-direct {v1, p0, p1}, Ljava/util/StringTokenizer;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 477
    .local v1, "token":Ljava/util/StringTokenizer;
    new-instance v0, Ljava/util/ArrayList;

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    invoke-direct {v0, v2}, Ljava/util/ArrayList;-><init>(I)V

    .line 478
    .local v0, "arrayList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :goto_0
    invoke-virtual {v1}, Ljava/util/StringTokenizer;->hasMoreTokens()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 479
    invoke-virtual {v1}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 482
    :cond_0
    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Ljava/lang/String;

    return-object v2
.end method

.method private static stringify(Ljava/util/HashMap;)Ljava/lang/String;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 453
    .local p0, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 454
    .local v2, "sb":Ljava/lang/StringBuilder;
    invoke-virtual {p0}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 455
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "~~~"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "|||"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 459
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    const/4 v3, 0x0

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->length()I

    move-result v4

    add-int/lit8 v4, v4, -0x3

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->substring(II)Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method

.method private static urlEncode(Ljava/lang/String;)Ljava/lang/String;
    .locals 8
    .param p0, "unencodedString"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 431
    if-nez p0, :cond_0

    .line 447
    :goto_0
    return-object v5

    .line 436
    :cond_0
    :try_start_0
    const-string v6, "UTF-8"

    invoke-virtual {p0, v6}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v4

    .line 437
    .local v4, "stringBytes":[B
    array-length v3, v4

    .line 438
    .local v3, "len":I
    new-instance v1, Ljava/lang/StringBuilder;

    shl-int/lit8 v6, v3, 0x1

    invoke-direct {v1, v6}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 440
    .local v1, "encodedString":Ljava/lang/StringBuilder;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    if-ge v2, v3, :cond_1

    .line 441
    sget-object v6, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->encodedChars:[Ljava/lang/String;

    aget-byte v7, v4, v2

    and-int/lit16 v7, v7, 0xff

    aget-object v6, v6, v7

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 440
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 444
    :cond_1
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v5

    goto :goto_0

    .line 445
    .end local v1    # "encodedString":Ljava/lang/StringBuilder;
    .end local v2    # "i":I
    .end local v3    # "len":I
    .end local v4    # "stringBytes":[B
    :catch_0
    move-exception v0

    .line 446
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "UnsupportedEncodingException : "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v0}, Ljava/io/UnsupportedEncodingException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x0

    new-array v7, v7, [Ljava/lang/Object;

    invoke-static {v6, v7}, Lcom/adobe/adms/audiencemanager/ADMS_AudienceManager;->ADBLogErrorFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method
