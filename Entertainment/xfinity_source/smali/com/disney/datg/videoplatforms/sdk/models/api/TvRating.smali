.class public Lcom/disney/datg/videoplatforms/sdk/models/api/TvRating;
.super Ljava/lang/Object;
.source "TvRating.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "tvrating"
    strict = false
.end annotation


# instance fields
.field private rating:Ljava/lang/String;
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
.method public getRating()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/TvRating;->rating:Ljava/lang/String;

    return-object v0
.end method
