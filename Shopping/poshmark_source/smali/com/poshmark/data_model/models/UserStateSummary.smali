.class public Lcom/poshmark/data_model/models/UserStateSummary;
.super Ljava/lang/Object;
.source "UserStateSummary.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/models/UserStateSummary$Brands;,
        Lcom/poshmark/data_model/models/UserStateSummary$Catalog;,
        Lcom/poshmark/data_model/models/UserStateSummary$FeatureSettings;,
        Lcom/poshmark/data_model/models/UserStateSummary$Collections;,
        Lcom/poshmark/data_model/models/UserStateSummary$UpdatedAt;,
        Lcom/poshmark/data_model/models/UserStateSummary$Posts;,
        Lcom/poshmark/data_model/models/UserStateSummary$Segment;,
        Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;,
        Lcom/poshmark/data_model/models/UserStateSummary$Info;,
        Lcom/poshmark/data_model/models/UserStateSummary$EventInvites;,
        Lcom/poshmark/data_model/models/UserStateSummary$NotificationsObject;
    }
.end annotation


# instance fields
.field public brands:Lcom/poshmark/data_model/models/UserStateSummary$Brands;

.field public catalog:Lcom/poshmark/data_model/models/UserStateSummary$Catalog;

.field public collections:Lcom/poshmark/data_model/models/UserStateSummary$Collections;

.field public event_invites:Lcom/poshmark/data_model/models/UserStateSummary$EventInvites;

.field public feature_settings:Lcom/poshmark/data_model/models/UserStateSummary$FeatureSettings;

.field public info:Lcom/poshmark/data_model/models/UserStateSummary$Info;

.field public notifications:Lcom/poshmark/data_model/models/UserStateSummary$NotificationsObject;

.field public user_info:Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 102
    return-void
.end method


# virtual methods
.method public getPoshProtectText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/poshmark/data_model/models/UserStateSummary;->info:Lcom/poshmark/data_model/models/UserStateSummary$Info;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/data_model/models/UserStateSummary;->info:Lcom/poshmark/data_model/models/UserStateSummary$Info;

    iget-object v0, v0, Lcom/poshmark/data_model/models/UserStateSummary$Info;->posh_protect:Ljava/lang/String;

    if-nez v0, :cond_1

    .line 23
    :cond_0
    const-string v0, ""

    .line 24
    :goto_0
    return-object v0

    :cond_1
    iget-object v0, p0, Lcom/poshmark/data_model/models/UserStateSummary;->info:Lcom/poshmark/data_model/models/UserStateSummary$Info;

    iget-object v0, v0, Lcom/poshmark/data_model/models/UserStateSummary$Info;->posh_protect:Ljava/lang/String;

    goto :goto_0
.end method

.method public getShippingReturnText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/poshmark/data_model/models/UserStateSummary;->info:Lcom/poshmark/data_model/models/UserStateSummary$Info;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/data_model/models/UserStateSummary;->info:Lcom/poshmark/data_model/models/UserStateSummary$Info;

    iget-object v0, v0, Lcom/poshmark/data_model/models/UserStateSummary$Info;->shipping_returns:Ljava/lang/String;

    if-nez v0, :cond_1

    .line 17
    :cond_0
    const-string v0, ""

    .line 18
    :goto_0
    return-object v0

    :cond_1
    iget-object v0, p0, Lcom/poshmark/data_model/models/UserStateSummary;->info:Lcom/poshmark/data_model/models/UserStateSummary$Info;

    iget-object v0, v0, Lcom/poshmark/data_model/models/UserStateSummary$Info;->shipping_returns:Ljava/lang/String;

    goto :goto_0
.end method

.method public isMySizeSet()Z
    .locals 3

    .prologue
    .line 28
    const/4 v0, 0x0

    .line 29
    .local v0, "set":Z
    iget-object v1, p0, Lcom/poshmark/data_model/models/UserStateSummary;->user_info:Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;

    if-eqz v1, :cond_0

    .line 30
    iget-object v1, p0, Lcom/poshmark/data_model/models/UserStateSummary;->user_info:Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;

    iget-object v1, v1, Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;->size_available:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/data_model/models/UserStateSummary;->user_info:Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;

    const-string v2, "complete"

    invoke-virtual {v1, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 31
    const/4 v0, 0x1

    .line 34
    :cond_0
    return v0
.end method
