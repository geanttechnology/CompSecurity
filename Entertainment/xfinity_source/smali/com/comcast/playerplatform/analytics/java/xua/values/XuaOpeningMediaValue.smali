.class public Lcom/comcast/playerplatform/analytics/java/xua/values/XuaOpeningMediaValue;
.super Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;
.source "XuaOpeningMediaValue.java"


# instance fields
.field private manifestUrl:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "MANIF"
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "manifestUrl"    # Ljava/lang/String;

    .prologue
    .line 19
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaOpeningMediaValue;->manifestUrl:Ljava/lang/String;

    .line 21
    return-void
.end method


# virtual methods
.method public getManifestUrl()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 26
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaOpeningMediaValue;->manifestUrl:Ljava/lang/String;

    return-object v0
.end method

.method public setManifestUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "manifestUrl"    # Ljava/lang/String;

    .prologue
    .line 31
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaOpeningMediaValue;->manifestUrl:Ljava/lang/String;

    .line 32
    return-void
.end method
