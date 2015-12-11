.class public Lcom/disney/datg/videoplatforms/sdk/common/VPAuthToken;
.super Ljava/lang/Object;
.source "VPAuthToken.java"


# instance fields
.field private tokenParameters:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/common/VPAuthToken;->tokenParameters:Ljava/util/Map;

    return-void
.end method


# virtual methods
.method public getTokenParameters()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 26
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/common/VPAuthToken;->tokenParameters:Ljava/util/Map;

    return-object v0
.end method

.method public setTokenParameters(Ljava/util/Map;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 29
    .local p1, "tokenParameters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/common/VPAuthToken;->tokenParameters:Ljava/util/Map;

    .line 30
    return-void
.end method
