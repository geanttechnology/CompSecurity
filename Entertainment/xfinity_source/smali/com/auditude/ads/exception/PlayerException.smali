.class public Lcom/auditude/ads/exception/PlayerException;
.super Ljava/lang/Exception;
.source "PlayerException.java"


# instance fields
.field public id:I


# direct methods
.method public constructor <init>(ILjava/lang/String;)V
    .locals 0
    .param p1, "id"    # I
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 15
    invoke-direct {p0, p2}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    .line 17
    iput p1, p0, Lcom/auditude/ads/exception/PlayerException;->id:I

    .line 18
    return-void
.end method


# virtual methods
.method public toParams()Ljava/util/HashMap;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 22
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 24
    .local v0, "variables":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v2, "errorId"

    iget v3, p0, Lcom/auditude/ads/exception/PlayerException;->id:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    const-string v4, "0"

    invoke-static {v3, v4}, Lcom/auditude/ads/util/ObjectUtil;->convertToString(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 25
    const-string v2, "message"

    invoke-virtual {p0}, Lcom/auditude/ads/exception/PlayerException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 27
    invoke-static {}, Lcom/auditude/ads/core/AuditudeEnv;->getInstance()Lcom/auditude/ads/core/AuditudeEnv;

    move-result-object v2

    invoke-virtual {v2}, Lcom/auditude/ads/core/AuditudeEnv;->getAdSettings()Lcom/auditude/ads/core/AdSettings;

    move-result-object v2

    invoke-virtual {v2}, Lcom/auditude/ads/core/AdSettings;->getZoneId()I

    move-result v1

    .line 28
    .local v1, "zoneId":I
    if-lez v1, :cond_0

    .line 30
    const-string v2, "z"

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    const-string v4, "0"

    invoke-static {v3, v4}, Lcom/auditude/ads/util/ObjectUtil;->convertToString(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 33
    :cond_0
    return-object v0
.end method
