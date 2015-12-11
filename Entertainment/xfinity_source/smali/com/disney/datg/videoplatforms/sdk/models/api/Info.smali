.class public Lcom/disney/datg/videoplatforms/sdk/models/api/Info;
.super Ljava/lang/Object;
.source "Info.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "info"
    strict = false
.end annotation


# instance fields
.field private advertiser:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field

.field private category:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    const-string v0, ""

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Info;->category:Ljava/lang/String;

    .line 19
    const-string v0, ""

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Info;->advertiser:Ljava/lang/String;

    return-void
.end method
