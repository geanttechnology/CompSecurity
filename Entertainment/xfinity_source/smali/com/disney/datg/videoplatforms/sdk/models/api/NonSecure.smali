.class public Lcom/disney/datg/videoplatforms/sdk/models/api/NonSecure;
.super Ljava/lang/Object;
.source "NonSecure.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "nonsecure"
    strict = false
.end annotation


# instance fields
.field private url:Lcom/disney/datg/videoplatforms/sdk/models/api/Url;
    .annotation runtime Lorg/simpleframework/xml/Element;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getUrl()Lcom/disney/datg/videoplatforms/sdk/models/api/Url;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/NonSecure;->url:Lcom/disney/datg/videoplatforms/sdk/models/api/Url;

    return-object v0
.end method
