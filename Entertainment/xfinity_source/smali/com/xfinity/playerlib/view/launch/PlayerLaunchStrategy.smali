.class public Lcom/xfinity/playerlib/view/launch/PlayerLaunchStrategy;
.super Lcom/comcast/cim/android/view/launch/LaunchStrategy;
.source "PlayerLaunchStrategy.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Lcom/comcast/cim/android/view/launch/LaunchStrategy;-><init>()V

    return-void
.end method


# virtual methods
.method public getDefaultActivityClass()Ljava/lang/Class;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<+",
            "Landroid/app/Activity;",
            ">;"
        }
    .end annotation

    .prologue
    .line 10
    const-class v0, Lcom/xfinity/playerlib/view/featured/FeaturedActivity;

    return-object v0
.end method
