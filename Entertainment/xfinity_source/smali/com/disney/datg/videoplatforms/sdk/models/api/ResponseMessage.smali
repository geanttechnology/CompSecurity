.class public Lcom/disney/datg/videoplatforms/sdk/models/api/ResponseMessage;
.super Ljava/lang/Object;
.source "ResponseMessage.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "entitlement"
    strict = false
.end annotation


# instance fields
.field private errors:Lcom/disney/datg/videoplatforms/sdk/models/api/ErrorData;
    .annotation runtime Lorg/simpleframework/xml/Element;
        name = "errors"
        required = false
    .end annotation
.end field

.field private uplynkData:Lcom/disney/datg/videoplatforms/sdk/models/api/UplynkData;
    .annotation runtime Lorg/simpleframework/xml/Element;
        name = "uplynk"
        required = false
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getErrors()Lcom/disney/datg/videoplatforms/sdk/models/api/ErrorData;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/ResponseMessage;->errors:Lcom/disney/datg/videoplatforms/sdk/models/api/ErrorData;

    return-object v0
.end method

.method public getUplynkData()Lcom/disney/datg/videoplatforms/sdk/models/api/UplynkData;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/ResponseMessage;->uplynkData:Lcom/disney/datg/videoplatforms/sdk/models/api/UplynkData;

    return-object v0
.end method
