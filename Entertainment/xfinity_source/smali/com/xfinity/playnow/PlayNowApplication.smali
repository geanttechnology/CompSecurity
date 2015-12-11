.class public Lcom/xfinity/playnow/PlayNowApplication;
.super Lcom/xfinity/playerlib/PlayerApplication;
.source "PlayNowApplication.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Lcom/xfinity/playerlib/PlayerApplication;-><init>()V

    return-void
.end method


# virtual methods
.method public initializeContainer(Lcom/xfinity/playerlib/PlayerApplication;)V
    .locals 0
    .param p1, "application"    # Lcom/xfinity/playerlib/PlayerApplication;

    .prologue
    .line 8
    invoke-static {p0}, Lcom/xfinity/playnow/PlayNowContainer;->initialize(Lcom/xfinity/playerlib/PlayerApplication;)V

    .line 9
    return-void
.end method
