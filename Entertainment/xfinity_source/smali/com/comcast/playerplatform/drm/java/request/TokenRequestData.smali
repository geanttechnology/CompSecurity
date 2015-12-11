.class public Lcom/comcast/playerplatform/drm/java/request/TokenRequestData;
.super Ljava/lang/Object;
.source "TokenRequestData.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonInclude;
    value = .enum Lcom/fasterxml/jackson/annotation/JsonInclude$Include;->NON_NULL:Lcom/fasterxml/jackson/annotation/JsonInclude$Include;
.end annotation


# instance fields
.field private accountToken:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "client:authnToken"
    .end annotation
.end field

.field private messageId:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "message:id"
    .end annotation
.end field

.field private messageNonce:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "message:nonce"
    .end annotation
.end field

.field private messageType:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "message:type"
    .end annotation
.end field

.field private product:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "client:product"
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "messageId"    # Ljava/lang/String;
    .param p2, "messageType"    # Ljava/lang/String;
    .param p3, "messageNonce"    # Ljava/lang/String;
    .param p4, "product"    # Ljava/lang/String;
    .param p5, "accountToken"    # Ljava/lang/String;

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    iput-object p1, p0, Lcom/comcast/playerplatform/drm/java/request/TokenRequestData;->messageId:Ljava/lang/String;

    .line 33
    iput-object p2, p0, Lcom/comcast/playerplatform/drm/java/request/TokenRequestData;->messageType:Ljava/lang/String;

    .line 34
    iput-object p3, p0, Lcom/comcast/playerplatform/drm/java/request/TokenRequestData;->messageNonce:Ljava/lang/String;

    .line 35
    iput-object p4, p0, Lcom/comcast/playerplatform/drm/java/request/TokenRequestData;->product:Ljava/lang/String;

    .line 36
    iput-object p5, p0, Lcom/comcast/playerplatform/drm/java/request/TokenRequestData;->accountToken:Ljava/lang/String;

    .line 37
    return-void
.end method
