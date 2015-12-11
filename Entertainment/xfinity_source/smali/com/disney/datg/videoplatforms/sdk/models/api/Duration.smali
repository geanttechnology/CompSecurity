.class public Lcom/disney/datg/videoplatforms/sdk/models/api/Duration;
.super Ljava/lang/Object;
.source "Duration.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "duration"
    strict = false
.end annotation


# instance fields
.field private unit:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Attribute;
        required = false
    .end annotation
.end field

.field private value:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Text;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    const-string v0, "millisecond"

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Duration;->unit:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Duration;->value:Ljava/lang/String;

    return-object v0
.end method
