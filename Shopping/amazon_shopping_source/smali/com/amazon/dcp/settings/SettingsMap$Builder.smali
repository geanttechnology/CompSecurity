.class public final Lcom/amazon/dcp/settings/SettingsMap$Builder;
.super Ljava/lang/Object;
.source "SettingsMap.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/dcp/settings/SettingsMap;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation


# static fields
.field static final synthetic $assertionsDisabled:Z


# instance fields
.field private mBuilt:Lcom/amazon/dcp/settings/SettingsMap;

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
    .line 15
    const-class v0, Lcom/amazon/dcp/settings/SettingsMap;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/amazon/dcp/settings/SettingsMap$Builder;->$assertionsDisabled:Z

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    iput-object v0, p0, Lcom/amazon/dcp/settings/SettingsMap$Builder;->mMap:Ljava/util/Map;

    .line 18
    iput-object v0, p0, Lcom/amazon/dcp/settings/SettingsMap$Builder;->mBuilt:Lcom/amazon/dcp/settings/SettingsMap;

    .line 22
    invoke-virtual {p0}, Lcom/amazon/dcp/settings/SettingsMap$Builder;->clear()V

    .line 23
    return-void
.end method


# virtual methods
.method public build()Lcom/amazon/dcp/settings/SettingsMap;
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/amazon/dcp/settings/SettingsMap$Builder;->mBuilt:Lcom/amazon/dcp/settings/SettingsMap;

    .line 94
    .local v0, "built":Lcom/amazon/dcp/settings/SettingsMap;
    invoke-virtual {p0}, Lcom/amazon/dcp/settings/SettingsMap$Builder;->clear()V

    .line 96
    return-object v0
.end method

.method public clear()V
    .locals 4

    .prologue
    .line 77
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/dcp/settings/SettingsMap$Builder;->mMap:Ljava/util/Map;

    .line 78
    iget-object v0, p0, Lcom/amazon/dcp/settings/SettingsMap$Builder;->mMap:Ljava/util/Map;

    sget-object v1, Lcom/amazon/dcp/settings/SettingsNamespace;->AppLocal:Lcom/amazon/dcp/settings/SettingsNamespace;

    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 79
    iget-object v0, p0, Lcom/amazon/dcp/settings/SettingsMap$Builder;->mMap:Ljava/util/Map;

    sget-object v1, Lcom/amazon/dcp/settings/SettingsNamespace;->DeviceGlobal:Lcom/amazon/dcp/settings/SettingsNamespace;

    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 82
    new-instance v0, Lcom/amazon/dcp/settings/SettingsMap;

    invoke-direct {v0}, Lcom/amazon/dcp/settings/SettingsMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/dcp/settings/SettingsMap$Builder;->mBuilt:Lcom/amazon/dcp/settings/SettingsMap;

    .line 83
    iget-object v0, p0, Lcom/amazon/dcp/settings/SettingsMap$Builder;->mBuilt:Lcom/amazon/dcp/settings/SettingsMap;

    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    # setter for: Lcom/amazon/dcp/settings/SettingsMap;->mMap:Ljava/util/Map;
    invoke-static {v0, v1}, Lcom/amazon/dcp/settings/SettingsMap;->access$102(Lcom/amazon/dcp/settings/SettingsMap;Ljava/util/Map;)Ljava/util/Map;

    .line 84
    iget-object v0, p0, Lcom/amazon/dcp/settings/SettingsMap$Builder;->mBuilt:Lcom/amazon/dcp/settings/SettingsMap;

    # getter for: Lcom/amazon/dcp/settings/SettingsMap;->mMap:Ljava/util/Map;
    invoke-static {v0}, Lcom/amazon/dcp/settings/SettingsMap;->access$100(Lcom/amazon/dcp/settings/SettingsMap;)Ljava/util/Map;

    move-result-object v1

    sget-object v2, Lcom/amazon/dcp/settings/SettingsNamespace;->AppLocal:Lcom/amazon/dcp/settings/SettingsNamespace;

    iget-object v0, p0, Lcom/amazon/dcp/settings/SettingsMap$Builder;->mMap:Ljava/util/Map;

    sget-object v3, Lcom/amazon/dcp/settings/SettingsNamespace;->AppLocal:Lcom/amazon/dcp/settings/SettingsNamespace;

    invoke-interface {v0, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 86
    iget-object v0, p0, Lcom/amazon/dcp/settings/SettingsMap$Builder;->mBuilt:Lcom/amazon/dcp/settings/SettingsMap;

    # getter for: Lcom/amazon/dcp/settings/SettingsMap;->mMap:Ljava/util/Map;
    invoke-static {v0}, Lcom/amazon/dcp/settings/SettingsMap;->access$100(Lcom/amazon/dcp/settings/SettingsMap;)Ljava/util/Map;

    move-result-object v1

    sget-object v2, Lcom/amazon/dcp/settings/SettingsNamespace;->DeviceGlobal:Lcom/amazon/dcp/settings/SettingsNamespace;

    iget-object v0, p0, Lcom/amazon/dcp/settings/SettingsMap$Builder;->mMap:Ljava/util/Map;

    sget-object v3, Lcom/amazon/dcp/settings/SettingsNamespace;->DeviceGlobal:Lcom/amazon/dcp/settings/SettingsNamespace;

    invoke-interface {v0, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 88
    iget-object v0, p0, Lcom/amazon/dcp/settings/SettingsMap$Builder;->mBuilt:Lcom/amazon/dcp/settings/SettingsMap;

    iget-object v1, p0, Lcom/amazon/dcp/settings/SettingsMap$Builder;->mBuilt:Lcom/amazon/dcp/settings/SettingsMap;

    # getter for: Lcom/amazon/dcp/settings/SettingsMap;->mMap:Ljava/util/Map;
    invoke-static {v1}, Lcom/amazon/dcp/settings/SettingsMap;->access$100(Lcom/amazon/dcp/settings/SettingsMap;)Ljava/util/Map;

    move-result-object v1

    invoke-static {v1}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v1

    # setter for: Lcom/amazon/dcp/settings/SettingsMap;->mMap:Ljava/util/Map;
    invoke-static {v0, v1}, Lcom/amazon/dcp/settings/SettingsMap;->access$102(Lcom/amazon/dcp/settings/SettingsMap;Ljava/util/Map;)Ljava/util/Map;

    .line 89
    return-void
.end method

.method public setValue(Lcom/amazon/dcp/settings/SettingsNamespace;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "namespace"    # Lcom/amazon/dcp/settings/SettingsNamespace;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;

    .prologue
    .line 33
    iget-object v1, p0, Lcom/amazon/dcp/settings/SettingsMap$Builder;->mMap:Ljava/util/Map;

    # invokes: Lcom/amazon/dcp/settings/SettingsMap;->getNamespaceSettings(Ljava/util/Map;Lcom/amazon/dcp/settings/SettingsNamespace;)Ljava/util/Map;
    invoke-static {v1, p1}, Lcom/amazon/dcp/settings/SettingsMap;->access$000(Ljava/util/Map;Lcom/amazon/dcp/settings/SettingsNamespace;)Ljava/util/Map;

    move-result-object v0

    .line 35
    .local v0, "namespaceSettings":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-nez v0, :cond_0

    .line 37
    new-instance v1, Ljava/lang/IllegalArgumentException;

    invoke-direct {v1}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v1

    .line 40
    :cond_0
    invoke-interface {v0, p2, p3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 41
    return-void
.end method
