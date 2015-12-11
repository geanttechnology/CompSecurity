.class public Lcom/disney/datg/videoplatforms/sdk/models/api/Delay;
.super Ljava/lang/Object;
.source "Delay.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "delay"
    strict = false
.end annotation


# instance fields
.field private unit:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Attribute;
        name = "unit"
        required = false
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    const-string v0, "millisecond"

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Delay;->unit:Ljava/lang/String;

    return-void
.end method
