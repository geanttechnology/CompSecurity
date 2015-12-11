.class public abstract Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate;
.super Ljava/lang/Object;
.source "ApplicationStateDelegate.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    return-void
.end method


# virtual methods
.method public getInHomeState()Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;
    .locals 1

    .prologue
    .line 14
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;->UNKNOWN:Lcom/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState;

    return-object v0
.end method
