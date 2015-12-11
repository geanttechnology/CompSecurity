.class public Lcom/disney/datg/videoplatforms/sdk/models/api/User;
.super Ljava/lang/Object;
.source "User.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "user"
    strict = false
.end annotation


# instance fields
.field private allowed:Ljava/lang/Boolean;
    .annotation runtime Lorg/simpleframework/xml/Attribute;
        required = false
    .end annotation
.end field

.field private city:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private country:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private proxy:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private state:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private zipcode:Ljava/lang/String;
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
.method public getAllowed()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->allowed:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getCity()Ljava/lang/String;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->city:Ljava/lang/String;

    return-object v0
.end method

.method public getCountry()Ljava/lang/String;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->country:Ljava/lang/String;

    return-object v0
.end method

.method public getProxy()Ljava/lang/String;
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->proxy:Ljava/lang/String;

    return-object v0
.end method

.method public getState()Ljava/lang/String;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->state:Ljava/lang/String;

    return-object v0
.end method

.method public getZipCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 130
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->zipcode:Ljava/lang/String;

    return-object v0
.end method
