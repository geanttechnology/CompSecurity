.class public Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;
.super Ljava/lang/Object;
.source "MMessageActV2.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/mm/sdk/channel/MMessageActV2;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Args"
.end annotation


# instance fields
.field public bundle:Landroid/os/Bundle;

.field public content:Ljava/lang/String;

.field public flags:I

.field public targetClassName:Ljava/lang/String;

.field public targetPkgName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 81
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 87
    const/4 v0, -0x1

    iput v0, p0, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;->flags:I

    return-void
.end method
