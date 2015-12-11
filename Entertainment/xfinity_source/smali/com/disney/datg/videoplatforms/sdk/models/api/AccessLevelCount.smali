.class public Lcom/disney/datg/videoplatforms/sdk/models/api/AccessLevelCount;
.super Ljava/lang/Object;
.source "AccessLevelCount.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "video"
    strict = false
.end annotation


# instance fields
.field private accessLevel:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Attribute;
        name = "accesslevel"
        required = false
    .end annotation
.end field

.field private count:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Text;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    const-string v0, "0"

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AccessLevelCount;->accessLevel:Ljava/lang/String;

    .line 28
    const-string v0, "0"

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AccessLevelCount;->count:Ljava/lang/String;

    .line 32
    return-void
.end method
