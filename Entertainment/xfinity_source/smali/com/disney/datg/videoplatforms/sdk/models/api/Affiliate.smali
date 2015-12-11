.class public Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliate;
.super Ljava/lang/Object;
.source "Affiliate.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "affiliate"
    strict = false
.end annotation


# instance fields
.field private id:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Attribute;
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
.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Affiliate;->id:Ljava/lang/String;

    return-object v0
.end method
