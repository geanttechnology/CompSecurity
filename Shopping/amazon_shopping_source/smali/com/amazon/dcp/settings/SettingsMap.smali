.class final Lcom/amazon/dcp/settings/SettingsMap;
.super Ljava/lang/Object;
.source "SettingsMap.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/dcp/settings/SettingsMap$Builder;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/dcp/settings/SettingsNamespace;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 13
    const-class v0, Lcom/amazon/dcp/settings/SettingsMap;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/dcp/settings/SettingsMap;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 103
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 100
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/dcp/settings/SettingsMap;->mMap:Ljava/util/Map;

    .line 104
    return-void
.end method

.method static synthetic access$000(Ljava/util/Map;Lcom/amazon/dcp/settings/SettingsNamespace;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Ljava/util/Map;
    .param p1, "x1"    # Lcom/amazon/dcp/settings/SettingsNamespace;

    .prologue
    .line 11
    invoke-static {p0, p1}, Lcom/amazon/dcp/settings/SettingsMap;->getNamespaceSettings(Ljava/util/Map;Lcom/amazon/dcp/settings/SettingsNamespace;)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/dcp/settings/SettingsMap;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/dcp/settings/SettingsMap;

    .prologue
    .line 11
    iget-object v0, p0, Lcom/amazon/dcp/settings/SettingsMap;->mMap:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic access$102(Lcom/amazon/dcp/settings/SettingsMap;Ljava/util/Map;)Ljava/util/Map;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/dcp/settings/SettingsMap;
    .param p1, "x1"    # Ljava/util/Map;

    .prologue
    .line 11
    iput-object p1, p0, Lcom/amazon/dcp/settings/SettingsMap;->mMap:Ljava/util/Map;

    return-object p1
.end method

.method private static getNamespaceSettings(Ljava/util/Map;Lcom/amazon/dcp/settings/SettingsNamespace;)Ljava/util/Map;
    .locals 1
    .param p1, "namespace"    # Lcom/amazon/dcp/settings/SettingsNamespace;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/dcp/settings/SettingsNamespace;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;",
            "Lcom/amazon/dcp/settings/SettingsNamespace;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 126
    .local p0, "map":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/dcp/settings/SettingsNamespace;Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    sget-object v0, Lcom/amazon/dcp/settings/SettingsNamespace;->Default:Lcom/amazon/dcp/settings/SettingsNamespace;

    if-ne p1, v0, :cond_0

    .line 128
    sget-object v0, Lcom/amazon/dcp/settings/SettingsNamespace;->AppLocal:Lcom/amazon/dcp/settings/SettingsNamespace;

    invoke-interface {p0, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    .line 132
    :goto_0
    return-object v0

    :cond_0
    invoke-interface {p0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    goto :goto_0
.end method


# virtual methods
.method public getValue(Lcom/amazon/dcp/settings/SettingsNamespace;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "namespace"    # Lcom/amazon/dcp/settings/SettingsNamespace;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "defaultValue"    # Ljava/lang/String;

    .prologue
    .line 113
    iget-object v1, p0, Lcom/amazon/dcp/settings/SettingsMap;->mMap:Ljava/util/Map;

    invoke-static {v1, p1}, Lcom/amazon/dcp/settings/SettingsMap;->getNamespaceSettings(Ljava/util/Map;Lcom/amazon/dcp/settings/SettingsNamespace;)Ljava/util/Map;

    move-result-object v0

    .line 115
    .local v0, "namespaceSettings":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz v0, :cond_0

    invoke-interface {v0, p2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    :cond_0
    move-object v1, p3

    .line 120
    :goto_0
    return-object v1

    :cond_1
    invoke-interface {v0, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    goto :goto_0
.end method
