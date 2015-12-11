.class public Lcom/amazon/retailsearch/client/ClientIdProvider;
.super Ljava/lang/Object;
.source "ClientIdProvider.java"


# static fields
.field private static final log:Lcom/amazon/retailsearch/log/MessageLogger;

.field private static final unknownClientID:Ljava/lang/String; = "unknown"


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    const-class v0, Lcom/amazon/retailsearch/client/ClientIdProvider;

    invoke-static {v0}, Lcom/amazon/retailsearch/log/AppLog;->getLog(Ljava/lang/Class;)Lcom/amazon/retailsearch/log/MessageLogger;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/client/ClientIdProvider;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getClientId(Landroid/content/res/Resources;)Ljava/lang/String;
    .locals 1
    .param p0, "resources"    # Landroid/content/res/Resources;

    .prologue
    .line 21
    invoke-static {p0}, Lcom/amazon/retailsearch/client/ClientIdProvider;->readClientIdFromConfig(Landroid/content/res/Resources;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static readClientIdFromConfig(Landroid/content/res/Resources;)Ljava/lang/String;
    .locals 3
    .param p0, "resources"    # Landroid/content/res/Resources;

    .prologue
    .line 26
    sget v1, Lcom/amazon/retailsearch/R$string;->config_rs_client_id:I

    invoke-virtual {p0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 28
    .local v0, "configuredClientId":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 30
    sget-object v1, Lcom/amazon/retailsearch/client/ClientIdProvider;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v2, "SRDS client ID is null"

    invoke-interface {v1, v2}, Lcom/amazon/retailsearch/log/MessageLogger;->error(Ljava/lang/String;)V

    .line 31
    const-string/jumbo v0, "unknown"

    .line 34
    :cond_0
    return-object v0
.end method
