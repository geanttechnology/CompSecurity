.class public Lcom/disney/datg/videoplatforms/sdk/models/api/ErrorMessage;
.super Ljava/lang/Object;
.source "ErrorMessage.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "error"
    strict = false
.end annotation


# instance fields
.field private code:I
    .annotation runtime Lorg/simpleframework/xml/Attribute;
        name = "code"
        required = false
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    return-void
.end method


# virtual methods
.method public getCode()I
    .locals 1

    .prologue
    .line 73
    iget v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/ErrorMessage;->code:I

    return v0
.end method
