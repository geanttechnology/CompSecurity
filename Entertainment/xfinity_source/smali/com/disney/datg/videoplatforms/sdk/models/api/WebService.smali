.class public Lcom/disney/datg/videoplatforms/sdk/models/api/WebService;
.super Ljava/lang/Object;
.source "WebService.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "webservice"
    strict = false
.end annotation


# instance fields
.field private name:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Attribute;
        name = "name"
        required = true
    .end annotation
.end field

.field private nonsecure:Lcom/disney/datg/videoplatforms/sdk/models/api/NonSecure;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private secure:Lcom/disney/datg/videoplatforms/sdk/models/api/Secure;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/WebService;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getNonsecure()Lcom/disney/datg/videoplatforms/sdk/models/api/NonSecure;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/WebService;->nonsecure:Lcom/disney/datg/videoplatforms/sdk/models/api/NonSecure;

    return-object v0
.end method

.method public getSecure()Lcom/disney/datg/videoplatforms/sdk/models/api/Secure;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/WebService;->secure:Lcom/disney/datg/videoplatforms/sdk/models/api/Secure;

    return-object v0
.end method
