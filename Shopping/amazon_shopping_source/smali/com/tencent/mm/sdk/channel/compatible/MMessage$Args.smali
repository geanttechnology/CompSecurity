.class public Lcom/tencent/mm/sdk/channel/compatible/MMessage$Args;
.super Ljava/lang/Object;
.source "MMessage.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/mm/sdk/channel/compatible/MMessage;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Args"
.end annotation


# instance fields
.field public action:Ljava/lang/String;

.field public bundle:Landroid/os/Bundle;

.field public content:Ljava/lang/String;

.field public targetPkg:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 63
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
