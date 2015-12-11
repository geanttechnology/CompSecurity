.class public Lcom/xfinity/playerlib/authorization/GoldenTicket;
.super Ljava/lang/Object;
.source "GoldenTicket.java"


# instance fields
.field private final authorization:Lcom/xfinity/playerlib/authorization/VideoAuthorization;


# virtual methods
.method public getToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 15
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/GoldenTicket;->authorization:Lcom/xfinity/playerlib/authorization/VideoAuthorization;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/authorization/VideoAuthorization;->getDevicePlaybackToken()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
