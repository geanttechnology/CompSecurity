.class public Lcom/poshmark/data_model/models/inner_models/Host;
.super Ljava/lang/Object;
.source "Host.java"


# instance fields
.field public display_handle:Ljava/lang/String;

.field public fb_user_id:Ljava/lang/String;

.field public full_name:Ljava/lang/String;

.field public id:Ljava/lang/String;

.field private picture_url:Ljava/lang/String;

.field public username:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAvataar()Ljava/lang/String;
    .locals 4

    .prologue
    .line 16
    const/4 v0, 0x0

    .line 17
    .local v0, "url":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/Host;->picture_url:Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 18
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Host;->picture_url:Ljava/lang/String;

    .line 23
    :cond_0
    :goto_0
    return-object v0

    .line 19
    :cond_1
    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/Host;->fb_user_id:Ljava/lang/String;

    if-eqz v1, :cond_0

    .line 20
    const-string v0, "https://graph.facebook.com/%s/picture?width=100&height=100"

    .line 21
    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/poshmark/data_model/models/inner_models/Host;->fb_user_id:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getUsername()Ljava/lang/String;
    .locals 1

    .prologue
    .line 12
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/Host;->username:Ljava/lang/String;

    return-object v0
.end method
