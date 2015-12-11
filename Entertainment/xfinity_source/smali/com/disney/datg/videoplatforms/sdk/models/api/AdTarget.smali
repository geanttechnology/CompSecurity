.class public Lcom/disney/datg/videoplatforms/sdk/models/api/AdTarget;
.super Ljava/lang/Object;
.source "AdTarget.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "adtarget"
    strict = false
.end annotation


# instance fields
.field private abcdvas:Lcom/disney/datg/videoplatforms/sdk/models/api/Abcdvas;
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
.method public getAbcdvas()Lcom/disney/datg/videoplatforms/sdk/models/api/Abcdvas;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdTarget;->abcdvas:Lcom/disney/datg/videoplatforms/sdk/models/api/Abcdvas;

    return-object v0
.end method
