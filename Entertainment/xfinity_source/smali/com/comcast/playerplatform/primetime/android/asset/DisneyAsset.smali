.class public Lcom/comcast/playerplatform/primetime/android/asset/DisneyAsset;
.super Lcom/comcast/playerplatform/primetime/android/asset/Asset;
.source "DisneyAsset.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/playerplatform/primetime/android/asset/DisneyAsset$Builder;
    }
.end annotation


# instance fields
.field private activity:Landroid/app/Activity;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;Landroid/app/Activity;)V
    .locals 1
    .param p1, "channelName"    # Ljava/lang/String;
    .param p2, "networkId"    # Ljava/lang/String;
    .param p3, "drmKey"    # Ljava/lang/String;
    .param p4, "tokenDelegate"    # Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;
    .param p5, "activity"    # Landroid/app/Activity;

    .prologue
    .line 27
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/asset/DisneyAsset$Builder;

    invoke-direct {v0, p1, p2, p3, p4}, Lcom/comcast/playerplatform/primetime/android/asset/DisneyAsset$Builder;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;)V

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;-><init>(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)V

    .line 28
    iput-object p5, p0, Lcom/comcast/playerplatform/primetime/android/asset/DisneyAsset;->activity:Landroid/app/Activity;

    .line 29
    return-void
.end method


# virtual methods
.method public getActivity()Landroid/app/Activity;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/DisneyAsset;->activity:Landroid/app/Activity;

    return-object v0
.end method
