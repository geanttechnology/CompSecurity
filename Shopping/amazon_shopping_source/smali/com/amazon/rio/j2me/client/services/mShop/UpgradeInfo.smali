.class public Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;
.super Ljava/lang/Object;
.source "UpgradeInfo.java"


# instance fields
.field private critical:Ljava/lang/Boolean;

.field private message:Ljava/lang/String;

.field private newVersion:Ljava/lang/String;

.field private uniqueId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getUniqueId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;->uniqueId:Ljava/lang/String;

    return-object v0
.end method

.method public setCritical(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 28
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;->critical:Ljava/lang/Boolean;

    .line 29
    return-void
.end method

.method public setMessage(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 41
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;->message:Ljava/lang/String;

    .line 42
    return-void
.end method

.method public setNewVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 67
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;->newVersion:Ljava/lang/String;

    .line 68
    return-void
.end method

.method public setUniqueId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 54
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;->uniqueId:Ljava/lang/String;

    .line 55
    return-void
.end method
