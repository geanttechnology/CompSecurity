.class public Lcom/poshmark/data_model/models/inner_models/UserReference;
.super Ljava/lang/Object;
.source "UserReference.java"


# instance fields
.field caller_is_following:Z

.field created_at:Ljava/lang/String;

.field display_handle:Ljava/lang/String;

.field fb_user_id:Ljava/lang/String;

.field full_name:Ljava/lang/String;

.field id:Ljava/lang/String;

.field picture_url:Ljava/lang/String;

.field username:Ljava/lang/String;


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
    .line 14
    const/4 v0, 0x0

    .line 15
    .local v0, "url":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/UserReference;->picture_url:Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 16
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/UserReference;->picture_url:Ljava/lang/String;

    .line 21
    :cond_0
    :goto_0
    return-object v0

    .line 17
    :cond_1
    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/UserReference;->fb_user_id:Ljava/lang/String;

    if-eqz v1, :cond_0

    .line 18
    const-string v0, "https://graph.facebook.com/%s/picture?width=100&height=100"

    .line 19
    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/poshmark/data_model/models/inner_models/UserReference;->fb_user_id:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getDisplayHandle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/UserReference;->display_handle:Ljava/lang/String;

    return-object v0
.end method

.method public getFullName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/UserReference;->full_name:Ljava/lang/String;

    return-object v0
.end method

.method public getUserId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/UserReference;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getUserName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/UserReference;->username:Ljava/lang/String;

    return-object v0
.end method

.method public isCallerFollowing()Z
    .locals 1

    .prologue
    .line 37
    iget-boolean v0, p0, Lcom/poshmark/data_model/models/inner_models/UserReference;->caller_is_following:Z

    return v0
.end method

.method public setCallerFollowing(Z)V
    .locals 0
    .param p1, "following"    # Z

    .prologue
    .line 41
    iput-boolean p1, p0, Lcom/poshmark/data_model/models/inner_models/UserReference;->caller_is_following:Z

    .line 42
    return-void
.end method

.method public setDisplayHandle(Ljava/lang/String;)V
    .locals 0
    .param p1, "commenterDisplayHandle"    # Ljava/lang/String;

    .prologue
    .line 50
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/UserReference;->display_handle:Ljava/lang/String;

    .line 51
    return-void
.end method
