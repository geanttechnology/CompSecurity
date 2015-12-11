.class public Lcom/disney/datg/videoplatforms/sdk/models/api/EndBeacon;
.super Ljava/lang/Object;
.source "EndBeacon.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "end"
    strict = false
.end annotation


# instance fields
.field private value:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Text;
        required = false
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/EndBeacon;->value:Ljava/lang/String;

    return-void
.end method
