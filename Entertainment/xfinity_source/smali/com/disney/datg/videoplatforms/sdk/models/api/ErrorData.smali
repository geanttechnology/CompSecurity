.class public Lcom/disney/datg/videoplatforms/sdk/models/api/ErrorData;
.super Ljava/lang/Object;
.source "ErrorData.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "errors"
    strict = false
.end annotation


# instance fields
.field private errors:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/ErrorMessage;",
            ">;"
        }
    .end annotation

    .annotation runtime Lorg/simpleframework/xml/ElementList;
        inline = true
        name = "errorlist"
        required = false
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/ErrorData;->errors:Ljava/util/List;

    .line 33
    return-void
.end method


# virtual methods
.method public getErrors()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/ErrorMessage;",
            ">;"
        }
    .end annotation

    .prologue
    .line 42
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/ErrorData;->errors:Ljava/util/List;

    return-object v0
.end method
