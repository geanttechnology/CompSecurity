.class public Lcom/disney/datg/videoplatforms/sdk/models/api/UplynkData;
.super Ljava/lang/Object;
.source "UplynkData.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "uplynk"
    strict = false
.end annotation


# instance fields
.field private host:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private sessionId:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Attribute;
        name = "sid"
        required = false
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getHost()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/UplynkData;->host:Ljava/lang/String;

    return-object v0
.end method

.method public getSessionId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/UplynkData;->sessionId:Ljava/lang/String;

    return-object v0
.end method
