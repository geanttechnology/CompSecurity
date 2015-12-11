.class public Lio/branch/referral/PrefHelper;
.super Ljava/lang/Object;
.source "PrefHelper.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/branch/referral/PrefHelper$DebugNetworkCallback;
    }
.end annotation


# static fields
.field private static BNC_App_Listing:Z = false

.field private static BNC_Debug:Z = false

.field private static BNC_Debug_Connecting:Z = false

.field private static BNC_Dev_Debug:Z = false

.field private static BNC_Remote_Debug:Z = false

.field private static BNC_Smart_Session:Z = false

.field private static BNC_Touch_Debugging:Z = false

.field private static Branch_Key:Ljava/lang/String; = null

.field public static final DEBUG_TRIGGER_NUM_FINGERS:I = 0x4

.field public static final DEBUG_TRIGGER_PRESS_TIME:I = 0xbb8

.field private static final INTERVAL_RETRY:I = 0x0

.field private static final KEY_ACTIONS:Ljava/lang/String; = "bnc_actions"

.field private static final KEY_APP_KEY:Ljava/lang/String; = "bnc_app_key"

.field private static final KEY_APP_LINK:Ljava/lang/String; = "bnc_app_link"

.field private static final KEY_APP_VERSION:Ljava/lang/String; = "bnc_app_version"

.field private static final KEY_BRANCH_KEY:Ljava/lang/String; = "bnc_branch_key"

.field private static final KEY_BUCKETS:Ljava/lang/String; = "bnc_buckets"

.field private static final KEY_CREDIT_BASE:Ljava/lang/String; = "bnc_credit_base_"

.field private static final KEY_DEVICE_FINGERPRINT_ID:Ljava/lang/String; = "bnc_device_fingerprint_id"

.field private static final KEY_EXTERNAL_INTENT_EXTRA:Ljava/lang/String; = "bnc_external_intent_extra"

.field private static final KEY_EXTERNAL_INTENT_URI:Ljava/lang/String; = "bnc_external_intent_uri"

.field private static final KEY_IDENTITY:Ljava/lang/String; = "bnc_identity"

.field private static final KEY_IDENTITY_ID:Ljava/lang/String; = "bnc_identity_id"

.field private static final KEY_INSTALL_PARAMS:Ljava/lang/String; = "bnc_install_params"

.field private static final KEY_IS_REFERRABLE:Ljava/lang/String; = "bnc_is_referrable"

.field private static final KEY_LAST_READ_SYSTEM:Ljava/lang/String; = "bnc_system_read_date"

.field private static final KEY_LINK_CLICK_ID:Ljava/lang/String; = "bnc_link_click_id"

.field private static final KEY_LINK_CLICK_IDENTIFIER:Ljava/lang/String; = "bnc_link_click_identifier"

.field private static final KEY_RETRY_COUNT:Ljava/lang/String; = "bnc_retry_count"

.field private static final KEY_RETRY_INTERVAL:Ljava/lang/String; = "bnc_retry_interval"

.field private static final KEY_SESSION_ID:Ljava/lang/String; = "bnc_session_id"

.field private static final KEY_SESSION_PARAMS:Ljava/lang/String; = "bnc_session_params"

.field private static final KEY_TIMEOUT:Ljava/lang/String; = "bnc_timeout"

.field private static final KEY_TOTAL_BASE:Ljava/lang/String; = "bnc_total_base_"

.field private static final KEY_UNIQUE_BASE:Ljava/lang/String; = "bnc_balance_base_"

.field private static final KEY_USER_URL:Ljava/lang/String; = "bnc_user_url"

.field private static final MAX_RETRIES:I = 0x1

.field public static final NO_STRING_VALUE:Ljava/lang/String; = "bnc_no_value"

.field public static final REQ_TAG_DEBUG_CONNECT:Ljava/lang/String; = "t_debug_connect"

.field public static final REQ_TAG_DEBUG_DISCONNECT:Ljava/lang/String; = "t_debug_disconnect"

.field public static final REQ_TAG_DEBUG_LOG:Ljava/lang/String; = "t_debug_log"

.field public static final REQ_TAG_DEBUG_SCREEN:Ljava/lang/String; = "t_debug_screen"

.field private static final SHARED_PREF_FILE:Ljava/lang/String; = "branch_referral_shared_pref"

.field private static final TIMEOUT:I = 0x1388

.field private static prefHelper_:Lio/branch/referral/PrefHelper;


# instance fields
.field private appSharedPrefs_:Landroid/content/SharedPreferences;

.field private context_:Landroid/content/Context;

.field private prefsEditor_:Landroid/content/SharedPreferences$Editor;

.field private remoteInterface_:Lio/branch/referral/BranchRemoteInterface;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 27
    sput-boolean v0, Lio/branch/referral/PrefHelper;->BNC_Dev_Debug:Z

    .line 32
    sput-boolean v0, Lio/branch/referral/PrefHelper;->BNC_Debug:Z

    .line 37
    sput-boolean v0, Lio/branch/referral/PrefHelper;->BNC_Debug_Connecting:Z

    .line 42
    sput-boolean v0, Lio/branch/referral/PrefHelper;->BNC_Remote_Debug:Z

    .line 50
    sput-boolean v1, Lio/branch/referral/PrefHelper;->BNC_App_Listing:Z

    .line 57
    sput-boolean v1, Lio/branch/referral/PrefHelper;->BNC_Touch_Debugging:Z

    .line 59
    sput-boolean v1, Lio/branch/referral/PrefHelper;->BNC_Smart_Session:Z

    .line 148
    const/4 v0, 0x0

    sput-object v0, Lio/branch/referral/PrefHelper;->Branch_Key:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 182
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 183
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 191
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 192
    const-string v0, "branch_referral_shared_pref"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lio/branch/referral/PrefHelper;->appSharedPrefs_:Landroid/content/SharedPreferences;

    .line 194
    iget-object v0, p0, Lio/branch/referral/PrefHelper;->appSharedPrefs_:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    iput-object v0, p0, Lio/branch/referral/PrefHelper;->prefsEditor_:Landroid/content/SharedPreferences$Editor;

    .line 195
    iput-object p1, p0, Lio/branch/referral/PrefHelper;->context_:Landroid/content/Context;

    .line 196
    return-void
.end method

.method public static Debug(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 1167
    sget-object v0, Lio/branch/referral/PrefHelper;->prefHelper_:Lio/branch/referral/PrefHelper;

    if-eqz v0, :cond_1

    .line 1168
    sget-object v0, Lio/branch/referral/PrefHelper;->prefHelper_:Lio/branch/referral/PrefHelper;

    invoke-virtual {v0, p0, p1}, Lio/branch/referral/PrefHelper;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 1174
    :cond_0
    :goto_0
    return-void

    .line 1170
    :cond_1
    sget-boolean v0, Lio/branch/referral/PrefHelper;->BNC_Debug:Z

    if-nez v0, :cond_2

    sget-boolean v0, Lio/branch/referral/PrefHelper;->BNC_Dev_Debug:Z

    if-eqz v0, :cond_0

    .line 1171
    :cond_2
    invoke-static {p0, p1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method static synthetic access$000(Lio/branch/referral/PrefHelper;)Lio/branch/referral/BranchRemoteInterface;
    .locals 1
    .param p0, "x0"    # Lio/branch/referral/PrefHelper;

    .prologue
    .line 22
    iget-object v0, p0, Lio/branch/referral/PrefHelper;->remoteInterface_:Lio/branch/referral/BranchRemoteInterface;

    return-object v0
.end method

.method static synthetic access$002(Lio/branch/referral/PrefHelper;Lio/branch/referral/BranchRemoteInterface;)Lio/branch/referral/BranchRemoteInterface;
    .locals 0
    .param p0, "x0"    # Lio/branch/referral/PrefHelper;
    .param p1, "x1"    # Lio/branch/referral/BranchRemoteInterface;

    .prologue
    .line 22
    iput-object p1, p0, Lio/branch/referral/PrefHelper;->remoteInterface_:Lio/branch/referral/BranchRemoteInterface;

    return-object p1
.end method

.method static synthetic access$100(Lio/branch/referral/PrefHelper;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lio/branch/referral/PrefHelper;

    .prologue
    .line 22
    iget-object v0, p0, Lio/branch/referral/PrefHelper;->context_:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$202(Z)Z
    .locals 0
    .param p0, "x0"    # Z

    .prologue
    .line 22
    sput-boolean p0, Lio/branch/referral/PrefHelper;->BNC_Remote_Debug:Z

    return p0
.end method

.method static synthetic access$302(Z)Z
    .locals 0
    .param p0, "x0"    # Z

    .prologue
    .line 22
    sput-boolean p0, Lio/branch/referral/PrefHelper;->BNC_Debug_Connecting:Z

    return p0
.end method

.method private clearPrefOnBranchKeyChange()V
    .locals 4

    .prologue
    .line 1000
    invoke-virtual {p0}, Lio/branch/referral/PrefHelper;->getLinkClickID()Ljava/lang/String;

    move-result-object v1

    .line 1001
    .local v1, "linkClickID":Ljava/lang/String;
    invoke-virtual {p0}, Lio/branch/referral/PrefHelper;->getLinkClickIdentifier()Ljava/lang/String;

    move-result-object v2

    .line 1002
    .local v2, "linkClickIdentifier":Ljava/lang/String;
    invoke-virtual {p0}, Lio/branch/referral/PrefHelper;->getAppLink()Ljava/lang/String;

    move-result-object v0

    .line 1003
    .local v0, "appLink":Ljava/lang/String;
    iget-object v3, p0, Lio/branch/referral/PrefHelper;->prefsEditor_:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v3}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    .line 1005
    invoke-virtual {p0, v1}, Lio/branch/referral/PrefHelper;->setLinkClickID(Ljava/lang/String;)V

    .line 1006
    invoke-virtual {p0, v2}, Lio/branch/referral/PrefHelper;->setLinkClickIdentifier(Ljava/lang/String;)V

    .line 1007
    invoke-virtual {p0, v0}, Lio/branch/referral/PrefHelper;->setAppLink(Ljava/lang/String;)V

    .line 1008
    sget-object v3, Lio/branch/referral/PrefHelper;->prefHelper_:Lio/branch/referral/PrefHelper;

    iget-object v3, v3, Lio/branch/referral/PrefHelper;->prefsEditor_:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v3}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 1009
    return-void
.end method

.method private deserializeString(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 3
    .param p1, "list"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 868
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 869
    .local v1, "strings":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const-string v2, ","

    invoke-virtual {p1, v2}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 870
    .local v0, "stringArr":[Ljava/lang/String;
    invoke-static {v1, v0}, Ljava/util/Collections;->addAll(Ljava/util/Collection;[Ljava/lang/Object;)Z

    .line 871
    return-object v1
.end method

.method private getActions()Ljava/util/ArrayList;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 783
    const-string v1, "bnc_actions"

    invoke-virtual {p0, v1}, Lio/branch/referral/PrefHelper;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 784
    .local v0, "actionList":Ljava/lang/String;
    const-string v1, "bnc_no_value"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 785
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 787
    :goto_0
    return-object v1

    :cond_0
    invoke-direct {p0, v0}, Lio/branch/referral/PrefHelper;->deserializeString(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    goto :goto_0
.end method

.method private getBuckets()Ljava/util/ArrayList;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 705
    const-string v1, "bnc_buckets"

    invoke-virtual {p0, v1}, Lio/branch/referral/PrefHelper;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 706
    .local v0, "bucketList":Ljava/lang/String;
    const-string v1, "bnc_no_value"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 707
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 709
    :goto_0
    return-object v1

    :cond_0
    invoke-direct {p0, v0}, Lio/branch/referral/PrefHelper;->deserializeString(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    goto :goto_0
.end method

.method public static getInstance(Landroid/content/Context;)Lio/branch/referral/PrefHelper;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 208
    sget-object v0, Lio/branch/referral/PrefHelper;->prefHelper_:Lio/branch/referral/PrefHelper;

    if-nez v0, :cond_0

    .line 209
    new-instance v0, Lio/branch/referral/PrefHelper;

    invoke-direct {v0, p0}, Lio/branch/referral/PrefHelper;-><init>(Landroid/content/Context;)V

    sput-object v0, Lio/branch/referral/PrefHelper;->prefHelper_:Lio/branch/referral/PrefHelper;

    .line 211
    :cond_0
    sget-object v0, Lio/branch/referral/PrefHelper;->prefHelper_:Lio/branch/referral/PrefHelper;

    return-object v0
.end method

.method private serializeArrayList(Ljava/util/ArrayList;)Ljava/lang/String;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 859
    .local p1, "strings":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const-string v1, ""

    .line 860
    .local v1, "retString":Ljava/lang/String;
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 861
    .local v2, "value":Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ","

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 862
    goto :goto_0

    .line 863
    .end local v2    # "value":Ljava/lang/String;
    :cond_0
    const/4 v3, 0x0

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    .line 864
    return-object v1
.end method

.method private setActions(Ljava/util/ArrayList;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 792
    .local p1, "actions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-nez v0, :cond_0

    .line 793
    const-string v0, "bnc_actions"

    const-string v1, "bnc_no_value"

    invoke-virtual {p0, v0, v1}, Lio/branch/referral/PrefHelper;->setString(Ljava/lang/String;Ljava/lang/String;)V

    .line 797
    :goto_0
    return-void

    .line 795
    :cond_0
    const-string v0, "bnc_actions"

    invoke-direct {p0, p1}, Lio/branch/referral/PrefHelper;->serializeArrayList(Ljava/util/ArrayList;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lio/branch/referral/PrefHelper;->setString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private setBuckets(Ljava/util/ArrayList;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 714
    .local p1, "buckets":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-nez v0, :cond_0

    .line 715
    const-string v0, "bnc_buckets"

    const-string v1, "bnc_no_value"

    invoke-virtual {p0, v0, v1}, Lio/branch/referral/PrefHelper;->setString(Ljava/lang/String;Ljava/lang/String;)V

    .line 719
    :goto_0
    return-void

    .line 717
    :cond_0
    const-string v0, "bnc_buckets"

    invoke-direct {p0, p1}, Lio/branch/referral/PrefHelper;->serializeArrayList(Ljava/util/ArrayList;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lio/branch/referral/PrefHelper;->setString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method public clearDebug()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 1107
    sput-boolean v1, Lio/branch/referral/PrefHelper;->BNC_Debug:Z

    .line 1108
    sput-boolean v1, Lio/branch/referral/PrefHelper;->BNC_Debug_Connecting:Z

    .line 1110
    sget-boolean v0, Lio/branch/referral/PrefHelper;->BNC_Remote_Debug:Z

    if-eqz v0, :cond_0

    .line 1111
    sput-boolean v1, Lio/branch/referral/PrefHelper;->BNC_Remote_Debug:Z

    .line 1113
    iget-object v0, p0, Lio/branch/referral/PrefHelper;->remoteInterface_:Lio/branch/referral/BranchRemoteInterface;

    if-eqz v0, :cond_0

    .line 1114
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lio/branch/referral/PrefHelper$2;

    invoke-direct {v1, p0}, Lio/branch/referral/PrefHelper$2;-><init>(Lio/branch/referral/PrefHelper;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 1122
    :cond_0
    return-void
.end method

.method public clearIsReferrable()V
    .locals 2

    .prologue
    .line 671
    const-string v0, "bnc_is_referrable"

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lio/branch/referral/PrefHelper;->setInteger(Ljava/lang/String;I)V

    .line 672
    return-void
.end method

.method public clearSystemReadStatus()V
    .locals 6

    .prologue
    .line 679
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 680
    .local v0, "c":Ljava/util/Calendar;
    const-string v1, "bnc_system_read_date"

    invoke-virtual {v0}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v2

    const-wide/16 v4, 0x3e8

    div-long/2addr v2, v4

    invoke-virtual {p0, v1, v2, v3}, Lio/branch/referral/PrefHelper;->setLong(Ljava/lang/String;J)V

    .line 681
    return-void
.end method

.method public clearUserValues()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 688
    invoke-direct {p0}, Lio/branch/referral/PrefHelper;->getBuckets()Ljava/util/ArrayList;

    move-result-object v3

    .line 689
    .local v3, "buckets":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 690
    .local v2, "bucket":Ljava/lang/String;
    invoke-virtual {p0, v2, v6}, Lio/branch/referral/PrefHelper;->setCreditCount(Ljava/lang/String;I)V

    goto :goto_0

    .line 692
    .end local v2    # "bucket":Ljava/lang/String;
    :cond_0
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    invoke-direct {p0, v5}, Lio/branch/referral/PrefHelper;->setBuckets(Ljava/util/ArrayList;)V

    .line 694
    invoke-direct {p0}, Lio/branch/referral/PrefHelper;->getActions()Ljava/util/ArrayList;

    move-result-object v1

    .line 695
    .local v1, "actions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 696
    .local v0, "action":Ljava/lang/String;
    invoke-virtual {p0, v0, v6}, Lio/branch/referral/PrefHelper;->setActionTotalCount(Ljava/lang/String;I)V

    .line 697
    invoke-virtual {p0, v0, v6}, Lio/branch/referral/PrefHelper;->setActionUniqueCount(Ljava/lang/String;I)V

    goto :goto_1

    .line 699
    .end local v0    # "action":Ljava/lang/String;
    :cond_1
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    invoke-direct {p0, v5}, Lio/branch/referral/PrefHelper;->setActions(Ljava/util/ArrayList;)V

    .line 700
    return-void
.end method

.method public disableExternAppListing()V
    .locals 1

    .prologue
    .line 1033
    const/4 v0, 0x0

    sput-boolean v0, Lio/branch/referral/PrefHelper;->BNC_App_Listing:Z

    .line 1034
    return-void
.end method

.method public disableSmartSession()V
    .locals 1

    .prologue
    .line 1068
    const/4 v0, 0x0

    sput-boolean v0, Lio/branch/referral/PrefHelper;->BNC_Smart_Session:Z

    .line 1069
    return-void
.end method

.method public disableTouchDebugging()V
    .locals 1

    .prologue
    .line 1051
    const/4 v0, 0x0

    sput-boolean v0, Lio/branch/referral/PrefHelper;->BNC_Touch_Debugging:Z

    .line 1052
    return-void
.end method

.method public getAPIBaseUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 221
    const-string v0, "https://api.branch.io/"

    return-object v0
.end method

.method public getActionTotalCount(Ljava/lang/String;)I
    .locals 2
    .param p1, "action"    # Ljava/lang/String;

    .prologue
    .line 840
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "bnc_total_base_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lio/branch/referral/PrefHelper;->getInteger(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public getActionUniqueCount(Ljava/lang/String;)I
    .locals 2
    .param p1, "action"    # Ljava/lang/String;

    .prologue
    .line 853
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "bnc_balance_base_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lio/branch/referral/PrefHelper;->getInteger(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public getAppKey()Ljava/lang/String;
    .locals 5

    .prologue
    .line 330
    const/4 v1, 0x0

    .line 332
    .local v1, "appKey":Ljava/lang/String;
    :try_start_0
    iget-object v2, p0, Lio/branch/referral/PrefHelper;->context_:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    iget-object v3, p0, Lio/branch/referral/PrefHelper;->context_:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const/16 v4, 0x80

    invoke-virtual {v2, v3, v4}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    .line 333
    .local v0, "ai":Landroid/content/pm/ApplicationInfo;
    iget-object v2, v0, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    if-eqz v2, :cond_0

    .line 334
    iget-object v2, v0, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    const-string v3, "io.branch.sdk.ApplicationId"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 339
    .end local v0    # "ai":Landroid/content/pm/ApplicationInfo;
    :cond_0
    :goto_0
    if-nez v1, :cond_1

    .line 340
    const-string v2, "bnc_app_key"

    invoke-virtual {p0, v2}, Lio/branch/referral/PrefHelper;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 343
    :cond_1
    return-object v1

    .line 336
    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method public getAppLink()Ljava/lang/String;
    .locals 1

    .prologue
    .line 576
    const-string v0, "bnc_app_link"

    invoke-virtual {p0, v0}, Lio/branch/referral/PrefHelper;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getAppVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 305
    const-string v0, "bnc_app_version"

    invoke-virtual {p0, v0}, Lio/branch/referral/PrefHelper;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getBool(Ljava/lang/String;)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 935
    sget-object v0, Lio/branch/referral/PrefHelper;->prefHelper_:Lio/branch/referral/PrefHelper;

    iget-object v0, v0, Lio/branch/referral/PrefHelper;->appSharedPrefs_:Landroid/content/SharedPreferences;

    const/4 v1, 0x0

    invoke-interface {v0, p1, v1}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public getBranchKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 365
    sget-object v0, Lio/branch/referral/PrefHelper;->Branch_Key:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 366
    const-string v0, "bnc_branch_key"

    invoke-virtual {p0, v0}, Lio/branch/referral/PrefHelper;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lio/branch/referral/PrefHelper;->Branch_Key:Ljava/lang/String;

    .line 368
    :cond_0
    sget-object v0, Lio/branch/referral/PrefHelper;->Branch_Key:Ljava/lang/String;

    return-object v0
.end method

.method public getCreditCount()I
    .locals 1

    .prologue
    .line 765
    sget-object v0, Lio/branch/referral/Defines$Jsonkey;->DefaultBucket:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v0}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lio/branch/referral/PrefHelper;->getCreditCount(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public getCreditCount(Ljava/lang/String;)I
    .locals 2
    .param p1, "bucket"    # Ljava/lang/String;

    .prologue
    .line 777
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "bnc_credit_base_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lio/branch/referral/PrefHelper;->getInteger(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public getDeviceFingerPrintID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 410
    const-string v0, "bnc_device_fingerprint_id"

    invoke-virtual {p0, v0}, Lio/branch/referral/PrefHelper;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getExternAppListing()Z
    .locals 1

    .prologue
    .line 1043
    sget-boolean v0, Lio/branch/referral/PrefHelper;->BNC_App_Listing:Z

    return v0
.end method

.method public getExternDebug()Z
    .locals 1

    .prologue
    .line 1024
    sget-boolean v0, Lio/branch/referral/PrefHelper;->BNC_Dev_Debug:Z

    return v0
.end method

.method public getExternalIntentExtra()Ljava/lang/String;
    .locals 1

    .prologue
    .line 539
    const-string v0, "bnc_external_intent_extra"

    invoke-virtual {p0, v0}, Lio/branch/referral/PrefHelper;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getExternalIntentUri()Ljava/lang/String;
    .locals 1

    .prologue
    .line 520
    const-string v0, "bnc_external_intent_uri"

    invoke-virtual {p0, v0}, Lio/branch/referral/PrefHelper;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getFloat(Ljava/lang/String;)F
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 915
    sget-object v0, Lio/branch/referral/PrefHelper;->prefHelper_:Lio/branch/referral/PrefHelper;

    iget-object v0, v0, Lio/branch/referral/PrefHelper;->appSharedPrefs_:Landroid/content/SharedPreferences;

    const/4 v1, 0x0

    invoke-interface {v0, p1, v1}, Landroid/content/SharedPreferences;->getFloat(Ljava/lang/String;F)F

    move-result v0

    return v0
.end method

.method public getIdentity()Ljava/lang/String;
    .locals 1

    .prologue
    .line 482
    const-string v0, "bnc_identity"

    invoke-virtual {p0, v0}, Lio/branch/referral/PrefHelper;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getIdentityID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 455
    const-string v0, "bnc_identity_id"

    invoke-virtual {p0, v0}, Lio/branch/referral/PrefHelper;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getInstallParams()Ljava/lang/String;
    .locals 1

    .prologue
    .line 608
    const-string v0, "bnc_install_params"

    invoke-virtual {p0, v0}, Lio/branch/referral/PrefHelper;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getInteger(Ljava/lang/String;)I
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 881
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lio/branch/referral/PrefHelper;->getInteger(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public getInteger(Ljava/lang/String;I)I
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "defaultValue"    # I

    .prologue
    .line 895
    sget-object v0, Lio/branch/referral/PrefHelper;->prefHelper_:Lio/branch/referral/PrefHelper;

    iget-object v0, v0, Lio/branch/referral/PrefHelper;->appSharedPrefs_:Landroid/content/SharedPreferences;

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public getIsReferrable()I
    .locals 1

    .prologue
    .line 647
    const-string v0, "bnc_is_referrable"

    invoke-virtual {p0, v0}, Lio/branch/referral/PrefHelper;->getInteger(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public getLinkClickID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 502
    const-string v0, "bnc_link_click_id"

    invoke-virtual {p0, v0}, Lio/branch/referral/PrefHelper;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getLinkClickIdentifier()Ljava/lang/String;
    .locals 1

    .prologue
    .line 558
    const-string v0, "bnc_link_click_identifier"

    invoke-virtual {p0, v0}, Lio/branch/referral/PrefHelper;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getLong(Ljava/lang/String;)J
    .locals 4
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 905
    sget-object v0, Lio/branch/referral/PrefHelper;->prefHelper_:Lio/branch/referral/PrefHelper;

    iget-object v0, v0, Lio/branch/referral/PrefHelper;->appSharedPrefs_:Landroid/content/SharedPreferences;

    const-wide/16 v2, 0x0

    invoke-interface {v0, p1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v0

    return-wide v0
.end method

.method public getRetryCount()I
    .locals 2

    .prologue
    .line 265
    const-string v0, "bnc_retry_count"

    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Lio/branch/referral/PrefHelper;->getInteger(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public getRetryInterval()I
    .locals 2

    .prologue
    .line 287
    const-string v0, "bnc_retry_interval"

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lio/branch/referral/PrefHelper;->getInteger(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public getSessionID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 430
    const-string v0, "bnc_session_id"

    invoke-virtual {p0, v0}, Lio/branch/referral/PrefHelper;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getSessionParams()Ljava/lang/String;
    .locals 1

    .prologue
    .line 588
    const-string v0, "bnc_session_params"

    invoke-virtual {p0, v0}, Lio/branch/referral/PrefHelper;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getSmartSession()Z
    .locals 1

    .prologue
    .line 1076
    sget-boolean v0, Lio/branch/referral/PrefHelper;->BNC_Smart_Session:Z

    return v0
.end method

.method public getString(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 925
    sget-object v0, Lio/branch/referral/PrefHelper;->prefHelper_:Lio/branch/referral/PrefHelper;

    iget-object v0, v0, Lio/branch/referral/PrefHelper;->appSharedPrefs_:Landroid/content/SharedPreferences;

    const-string v1, "bnc_no_value"

    invoke-interface {v0, p1, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTimeout()I
    .locals 2

    .prologue
    .line 242
    const-string v0, "bnc_timeout"

    const/16 v1, 0x1388

    invoke-virtual {p0, v0, v1}, Lio/branch/referral/PrefHelper;->getInteger(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public getTouchDebugging()Z
    .locals 1

    .prologue
    .line 1061
    sget-boolean v0, Lio/branch/referral/PrefHelper;->BNC_Touch_Debugging:Z

    return v0
.end method

.method public getUserURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 636
    const-string v0, "bnc_user_url"

    invoke-virtual {p0, v0}, Lio/branch/referral/PrefHelper;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public isDebug()Z
    .locals 1

    .prologue
    .line 1136
    sget-boolean v0, Lio/branch/referral/PrefHelper;->BNC_Debug:Z

    return v0
.end method

.method public keepDebugConnection()Z
    .locals 2

    .prologue
    .line 1188
    sget-boolean v0, Lio/branch/referral/PrefHelper;->BNC_Remote_Debug:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lio/branch/referral/PrefHelper;->remoteInterface_:Lio/branch/referral/BranchRemoteInterface;

    if-eqz v0, :cond_0

    .line 1189
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lio/branch/referral/PrefHelper$4;

    invoke-direct {v1, p0}, Lio/branch/referral/PrefHelper$4;-><init>(Lio/branch/referral/PrefHelper;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 1195
    const/4 v0, 0x1

    .line 1198
    :goto_0
    return v0

    :cond_0
    sget-boolean v0, Lio/branch/referral/PrefHelper;->BNC_Debug_Connecting:Z

    goto :goto_0
.end method

.method public log(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 1146
    sget-boolean v0, Lio/branch/referral/PrefHelper;->BNC_Debug:Z

    if-nez v0, :cond_0

    sget-boolean v0, Lio/branch/referral/PrefHelper;->BNC_Dev_Debug:Z

    if-eqz v0, :cond_1

    .line 1147
    :cond_0
    invoke-static {p1, p2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1149
    sget-boolean v0, Lio/branch/referral/PrefHelper;->BNC_Remote_Debug:Z

    if-eqz v0, :cond_1

    iget-object v0, p0, Lio/branch/referral/PrefHelper;->remoteInterface_:Lio/branch/referral/BranchRemoteInterface;

    if-eqz v0, :cond_1

    .line 1150
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lio/branch/referral/PrefHelper$3;

    invoke-direct {v1, p0, p1, p2}, Lio/branch/referral/PrefHelper$3;-><init>(Lio/branch/referral/PrefHelper;Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 1158
    :cond_1
    return-void
.end method

.method public readBranchKey(Z)Ljava/lang/String;
    .locals 6
    .param p1, "isLive"    # Z

    .prologue
    .line 372
    const/4 v1, 0x0

    .line 373
    .local v1, "branchKey":Ljava/lang/String;
    if-eqz p1, :cond_3

    const-string v2, "io.branch.sdk.BranchKey"

    .line 374
    .local v2, "metaDataKey":Ljava/lang/String;
    :goto_0
    if-nez p1, :cond_0

    invoke-virtual {p0}, Lio/branch/referral/PrefHelper;->setExternDebug()V

    .line 376
    :cond_0
    :try_start_0
    iget-object v3, p0, Lio/branch/referral/PrefHelper;->context_:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    iget-object v4, p0, Lio/branch/referral/PrefHelper;->context_:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    const/16 v5, 0x80

    invoke-virtual {v3, v4, v5}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    .line 377
    .local v0, "ai":Landroid/content/pm/ApplicationInfo;
    iget-object v3, v0, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    if-eqz v3, :cond_1

    .line 378
    iget-object v3, v0, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    invoke-virtual {v3, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 379
    if-nez v1, :cond_1

    if-nez p1, :cond_1

    .line 380
    iget-object v3, v0, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    const-string v4, "io.branch.sdk.BranchKey"

    invoke-virtual {v3, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 386
    .end local v0    # "ai":Landroid/content/pm/ApplicationInfo;
    :cond_1
    :goto_1
    if-nez v1, :cond_2

    .line 387
    const-string v1, "bnc_no_value"

    .line 390
    :cond_2
    return-object v1

    .line 373
    .end local v2    # "metaDataKey":Ljava/lang/String;
    :cond_3
    const-string v2, "io.branch.sdk.BranchKey.test"

    goto :goto_0

    .line 383
    .restart local v2    # "metaDataKey":Ljava/lang/String;
    :catch_0
    move-exception v3

    goto :goto_1
.end method

.method public setActionTotalCount(Ljava/lang/String;I)V
    .locals 3
    .param p1, "action"    # Ljava/lang/String;
    .param p2, "count"    # I

    .prologue
    .line 809
    invoke-direct {p0}, Lio/branch/referral/PrefHelper;->getActions()Ljava/util/ArrayList;

    move-result-object v0

    .line 810
    .local v0, "actions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 811
    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 812
    invoke-direct {p0, v0}, Lio/branch/referral/PrefHelper;->setActions(Ljava/util/ArrayList;)V

    .line 814
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "bnc_total_base_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1, p2}, Lio/branch/referral/PrefHelper;->setInteger(Ljava/lang/String;I)V

    .line 815
    return-void
.end method

.method public setActionUniqueCount(Ljava/lang/String;I)V
    .locals 2
    .param p1, "action"    # Ljava/lang/String;
    .param p2, "count"    # I

    .prologue
    .line 827
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "bnc_balance_base_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p2}, Lio/branch/referral/PrefHelper;->setInteger(Ljava/lang/String;I)V

    .line 828
    return-void
.end method

.method public setAppKey(Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 321
    const-string v0, "bnc_app_key"

    invoke-virtual {p0, v0, p1}, Lio/branch/referral/PrefHelper;->setString(Ljava/lang/String;Ljava/lang/String;)V

    .line 322
    return-void
.end method

.method public setAppLink(Ljava/lang/String;)V
    .locals 1
    .param p1, "appLinkUrl"    # Ljava/lang/String;

    .prologue
    .line 567
    const-string v0, "bnc_app_link"

    invoke-virtual {p0, v0, p1}, Lio/branch/referral/PrefHelper;->setString(Ljava/lang/String;Ljava/lang/String;)V

    .line 568
    return-void
.end method

.method public setAppVersion(Ljava/lang/String;)V
    .locals 1
    .param p1, "version"    # Ljava/lang/String;

    .prologue
    .line 296
    const-string v0, "bnc_app_version"

    invoke-virtual {p0, v0, p1}, Lio/branch/referral/PrefHelper;->setString(Ljava/lang/String;Ljava/lang/String;)V

    .line 297
    return-void
.end method

.method public setBool(Ljava/lang/String;Ljava/lang/Boolean;)V
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Boolean;

    .prologue
    .line 989
    sget-object v0, Lio/branch/referral/PrefHelper;->prefHelper_:Lio/branch/referral/PrefHelper;

    iget-object v0, v0, Lio/branch/referral/PrefHelper;->prefsEditor_:Landroid/content/SharedPreferences$Editor;

    invoke-virtual {p2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    invoke-interface {v0, p1, v1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 990
    sget-object v0, Lio/branch/referral/PrefHelper;->prefHelper_:Lio/branch/referral/PrefHelper;

    iget-object v0, v0, Lio/branch/referral/PrefHelper;->prefsEditor_:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 991
    return-void
.end method

.method public setBranchKey(Ljava/lang/String;)Z
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 353
    sput-object p1, Lio/branch/referral/PrefHelper;->Branch_Key:Ljava/lang/String;

    .line 354
    const-string v1, "bnc_branch_key"

    invoke-virtual {p0, v1}, Lio/branch/referral/PrefHelper;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 355
    .local v0, "currentBranchKey":Ljava/lang/String;
    if-eqz p1, :cond_0

    if-eqz v0, :cond_0

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 356
    :cond_0
    invoke-direct {p0}, Lio/branch/referral/PrefHelper;->clearPrefOnBranchKeyChange()V

    .line 357
    const-string v1, "bnc_branch_key"

    invoke-virtual {p0, v1, p1}, Lio/branch/referral/PrefHelper;->setString(Ljava/lang/String;Ljava/lang/String;)V

    .line 358
    const/4 v1, 0x1

    .line 360
    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public setCreditCount(I)V
    .locals 1
    .param p1, "count"    # I

    .prologue
    .line 733
    sget-object v0, Lio/branch/referral/Defines$Jsonkey;->DefaultBucket:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v0}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lio/branch/referral/PrefHelper;->setCreditCount(Ljava/lang/String;I)V

    .line 734
    return-void
.end method

.method public setCreditCount(Ljava/lang/String;I)V
    .locals 3
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "count"    # I

    .prologue
    .line 749
    invoke-direct {p0}, Lio/branch/referral/PrefHelper;->getBuckets()Ljava/util/ArrayList;

    move-result-object v0

    .line 750
    .local v0, "buckets":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 751
    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 752
    invoke-direct {p0, v0}, Lio/branch/referral/PrefHelper;->setBuckets(Ljava/util/ArrayList;)V

    .line 754
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "bnc_credit_base_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1, p2}, Lio/branch/referral/PrefHelper;->setInteger(Ljava/lang/String;I)V

    .line 755
    return-void
.end method

.method public setDebug()V
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 1084
    sput-boolean v0, Lio/branch/referral/PrefHelper;->BNC_Debug:Z

    .line 1085
    sput-boolean v0, Lio/branch/referral/PrefHelper;->BNC_Debug_Connecting:Z

    .line 1087
    sget-boolean v0, Lio/branch/referral/PrefHelper;->BNC_Remote_Debug:Z

    if-nez v0, :cond_0

    .line 1088
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lio/branch/referral/PrefHelper$1;

    invoke-direct {v1, p0}, Lio/branch/referral/PrefHelper$1;-><init>(Lio/branch/referral/PrefHelper;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 1100
    :cond_0
    return-void
.end method

.method public setDeviceFingerPrintID(Ljava/lang/String;)V
    .locals 1
    .param p1, "device_fingerprint_id"    # Ljava/lang/String;

    .prologue
    .line 400
    const-string v0, "bnc_device_fingerprint_id"

    invoke-virtual {p0, v0, p1}, Lio/branch/referral/PrefHelper;->setString(Ljava/lang/String;Ljava/lang/String;)V

    .line 401
    return-void
.end method

.method public setExternDebug()V
    .locals 1

    .prologue
    .line 1015
    const/4 v0, 0x1

    sput-boolean v0, Lio/branch/referral/PrefHelper;->BNC_Dev_Debug:Z

    .line 1016
    return-void
.end method

.method public setExternalIntentExtra(Ljava/lang/String;)V
    .locals 1
    .param p1, "extras"    # Ljava/lang/String;

    .prologue
    .line 531
    const-string v0, "bnc_external_intent_extra"

    invoke-virtual {p0, v0, p1}, Lio/branch/referral/PrefHelper;->setString(Ljava/lang/String;Ljava/lang/String;)V

    .line 532
    return-void
.end method

.method public setExternalIntentUri(Ljava/lang/String;)V
    .locals 1
    .param p1, "uri"    # Ljava/lang/String;

    .prologue
    .line 512
    const-string v0, "bnc_external_intent_uri"

    invoke-virtual {p0, v0, p1}, Lio/branch/referral/PrefHelper;->setString(Ljava/lang/String;Ljava/lang/String;)V

    .line 513
    return-void
.end method

.method public setFloat(Ljava/lang/String;F)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # F

    .prologue
    .line 967
    sget-object v0, Lio/branch/referral/PrefHelper;->prefHelper_:Lio/branch/referral/PrefHelper;

    iget-object v0, v0, Lio/branch/referral/PrefHelper;->prefsEditor_:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putFloat(Ljava/lang/String;F)Landroid/content/SharedPreferences$Editor;

    .line 968
    sget-object v0, Lio/branch/referral/PrefHelper;->prefHelper_:Lio/branch/referral/PrefHelper;

    iget-object v0, v0, Lio/branch/referral/PrefHelper;->prefsEditor_:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 969
    return-void
.end method

.method public setIdentity(Ljava/lang/String;)V
    .locals 1
    .param p1, "identity"    # Ljava/lang/String;

    .prologue
    .line 470
    const-string v0, "bnc_identity"

    invoke-virtual {p0, v0, p1}, Lio/branch/referral/PrefHelper;->setString(Ljava/lang/String;Ljava/lang/String;)V

    .line 471
    return-void
.end method

.method public setIdentityID(Ljava/lang/String;)V
    .locals 1
    .param p1, "identity_id"    # Ljava/lang/String;

    .prologue
    .line 445
    const-string v0, "bnc_identity_id"

    invoke-virtual {p0, v0, p1}, Lio/branch/referral/PrefHelper;->setString(Ljava/lang/String;Ljava/lang/String;)V

    .line 446
    return-void
.end method

.method public setInstallParams(Ljava/lang/String;)V
    .locals 1
    .param p1, "params"    # Ljava/lang/String;

    .prologue
    .line 618
    const-string v0, "bnc_install_params"

    invoke-virtual {p0, v0, p1}, Lio/branch/referral/PrefHelper;->setString(Ljava/lang/String;Ljava/lang/String;)V

    .line 619
    return-void
.end method

.method public setInteger(Ljava/lang/String;I)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # I

    .prologue
    .line 945
    sget-object v0, Lio/branch/referral/PrefHelper;->prefHelper_:Lio/branch/referral/PrefHelper;

    iget-object v0, v0, Lio/branch/referral/PrefHelper;->prefsEditor_:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 946
    sget-object v0, Lio/branch/referral/PrefHelper;->prefHelper_:Lio/branch/referral/PrefHelper;

    iget-object v0, v0, Lio/branch/referral/PrefHelper;->prefsEditor_:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 947
    return-void
.end method

.method public setIsReferrable()V
    .locals 2

    .prologue
    .line 659
    const-string v0, "bnc_is_referrable"

    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Lio/branch/referral/PrefHelper;->setInteger(Ljava/lang/String;I)V

    .line 660
    return-void
.end method

.method public setLinkClickID(Ljava/lang/String;)V
    .locals 1
    .param p1, "link_click_id"    # Ljava/lang/String;

    .prologue
    .line 492
    const-string v0, "bnc_link_click_id"

    invoke-virtual {p0, v0, p1}, Lio/branch/referral/PrefHelper;->setString(Ljava/lang/String;Ljava/lang/String;)V

    .line 493
    return-void
.end method

.method public setLinkClickIdentifier(Ljava/lang/String;)V
    .locals 1
    .param p1, "identifer"    # Ljava/lang/String;

    .prologue
    .line 549
    const-string v0, "bnc_link_click_identifier"

    invoke-virtual {p0, v0, p1}, Lio/branch/referral/PrefHelper;->setString(Ljava/lang/String;Ljava/lang/String;)V

    .line 550
    return-void
.end method

.method public setLong(Ljava/lang/String;J)V
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # J

    .prologue
    .line 956
    sget-object v0, Lio/branch/referral/PrefHelper;->prefHelper_:Lio/branch/referral/PrefHelper;

    iget-object v0, v0, Lio/branch/referral/PrefHelper;->prefsEditor_:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0, p1, p2, p3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 957
    sget-object v0, Lio/branch/referral/PrefHelper;->prefHelper_:Lio/branch/referral/PrefHelper;

    iget-object v0, v0, Lio/branch/referral/PrefHelper;->prefsEditor_:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 958
    return-void
.end method

.method public setRetryCount(I)V
    .locals 1
    .param p1, "retry"    # I

    .prologue
    .line 255
    const-string v0, "bnc_retry_count"

    invoke-virtual {p0, v0, p1}, Lio/branch/referral/PrefHelper;->setInteger(Ljava/lang/String;I)V

    .line 256
    return-void
.end method

.method public setRetryInterval(I)V
    .locals 1
    .param p1, "retryInt"    # I

    .prologue
    .line 276
    const-string v0, "bnc_retry_interval"

    invoke-virtual {p0, v0, p1}, Lio/branch/referral/PrefHelper;->setInteger(Ljava/lang/String;I)V

    .line 277
    return-void
.end method

.method public setSessionID(Ljava/lang/String;)V
    .locals 1
    .param p1, "session_id"    # Ljava/lang/String;

    .prologue
    .line 420
    const-string v0, "bnc_session_id"

    invoke-virtual {p0, v0, p1}, Lio/branch/referral/PrefHelper;->setString(Ljava/lang/String;Ljava/lang/String;)V

    .line 421
    return-void
.end method

.method public setSessionParams(Ljava/lang/String;)V
    .locals 1
    .param p1, "params"    # Ljava/lang/String;

    .prologue
    .line 598
    const-string v0, "bnc_session_params"

    invoke-virtual {p0, v0, p1}, Lio/branch/referral/PrefHelper;->setString(Ljava/lang/String;Ljava/lang/String;)V

    .line 599
    return-void
.end method

.method public setString(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 978
    sget-object v0, Lio/branch/referral/PrefHelper;->prefHelper_:Lio/branch/referral/PrefHelper;

    iget-object v0, v0, Lio/branch/referral/PrefHelper;->prefsEditor_:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 979
    sget-object v0, Lio/branch/referral/PrefHelper;->prefHelper_:Lio/branch/referral/PrefHelper;

    iget-object v0, v0, Lio/branch/referral/PrefHelper;->prefsEditor_:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 980
    return-void
.end method

.method public setTimeout(I)V
    .locals 1
    .param p1, "timeout"    # I

    .prologue
    .line 230
    const-string v0, "bnc_timeout"

    invoke-virtual {p0, v0, p1}, Lio/branch/referral/PrefHelper;->setInteger(Ljava/lang/String;I)V

    .line 231
    return-void
.end method

.method public setUserURL(Ljava/lang/String;)V
    .locals 1
    .param p1, "user_url"    # Ljava/lang/String;

    .prologue
    .line 627
    const-string v0, "bnc_user_url"

    invoke-virtual {p0, v0, p1}, Lio/branch/referral/PrefHelper;->setString(Ljava/lang/String;Ljava/lang/String;)V

    .line 628
    return-void
.end method
