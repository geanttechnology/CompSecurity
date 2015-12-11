.class public Lcom/disney/datg/videoplatforms/sdk/models/api/Season;
.super Ljava/lang/Object;
.source "Season.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    name = "season"
    strict = false
.end annotation


# instance fields
.field private num:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Attribute;
        required = false
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
.method public getNum()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Season;->num:Ljava/lang/String;

    return-object v0
.end method
