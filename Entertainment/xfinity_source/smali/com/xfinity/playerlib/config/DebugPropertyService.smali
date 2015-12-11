.class public Lcom/xfinity/playerlib/config/DebugPropertyService;
.super Ljava/lang/Object;
.source "DebugPropertyService.java"

# interfaces
.implements Lcom/comcast/cim/android/PropertyService;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getOmnitureAccount()Ljava/lang/String;
    .locals 1

    .prologue
    .line 8
    const-string v0, "comcastipaddev"

    return-object v0
.end method

.method public getOmnitureDebug()Z
    .locals 1

    .prologue
    .line 13
    const/4 v0, 0x1

    return v0
.end method
