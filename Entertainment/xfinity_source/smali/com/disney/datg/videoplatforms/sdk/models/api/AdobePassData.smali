.class public Lcom/disney/datg/videoplatforms/sdk/models/api/AdobePassData;
.super Ljava/lang/Object;
.source "AdobePassData.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "adobe"
    strict = false
.end annotation


# instance fields
.field private isauthorized:Ljava/lang/Boolean;
    .annotation runtime Lorg/simpleframework/xml/Element;
        required = false
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/AdobePassData;->isauthorized:Ljava/lang/Boolean;

    return-void
.end method
