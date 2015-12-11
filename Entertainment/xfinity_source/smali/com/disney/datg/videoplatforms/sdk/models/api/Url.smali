.class public Lcom/disney/datg/videoplatforms/sdk/models/api/Url;
.super Ljava/lang/Object;
.source "Url.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "param"
    strict = false
.end annotation


# instance fields
.field private value:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Text;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Url;->value:Ljava/lang/String;

    return-object v0
.end method
