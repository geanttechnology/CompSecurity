.class public Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;
.super Ljava/lang/Object;
.source "GeoLocation.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "geolocation"
    strict = false
.end annotation


# instance fields
.field private affiliates:Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliates;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private user:Lcom/disney/datg/videoplatforms/sdk/models/api/User;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAffiliates()Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliates;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;->affiliates:Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliates;

    return-object v0
.end method

.method public getUser()Lcom/disney/datg/videoplatforms/sdk/models/api/User;
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;->user:Lcom/disney/datg/videoplatforms/sdk/models/api/User;

    return-object v0
.end method
