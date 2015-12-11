.class public Lcom/disney/datg/videoplatforms/sdk/models/api/Generic;
.super Ljava/lang/Object;
.source "Generic.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "generic"
    strict = false
.end annotation


# instance fields
.field private cgenre:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private cprogram:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private cshow:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCgenre()Ljava/lang/String;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Generic;->cgenre:Ljava/lang/String;

    return-object v0
.end method

.method public getCprogram()Ljava/lang/String;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Generic;->cprogram:Ljava/lang/String;

    return-object v0
.end method

.method public getCshow()Ljava/lang/String;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Generic;->cshow:Ljava/lang/String;

    return-object v0
.end method
