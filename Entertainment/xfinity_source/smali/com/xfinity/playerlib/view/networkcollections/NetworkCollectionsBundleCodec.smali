.class public Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsBundleCodec;
.super Ljava/lang/Object;
.source "NetworkCollectionsBundleCodec.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createBundle(Lcom/xfinity/playerlib/model/tags/Network;)Landroid/os/Bundle;
    .locals 4
    .param p1, "network"    # Lcom/xfinity/playerlib/model/tags/Network;

    .prologue
    .line 10
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 11
    .local v0, "createdBundle":Landroid/os/Bundle;
    const-string v1, "companyId"

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/tags/Network;->getCompanyId()J

    move-result-wide v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 12
    return-object v0
.end method

.method public getNetworkCompanyId(Landroid/os/Bundle;)J
    .locals 2
    .param p1, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 16
    const-string v0, "companyId"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v0

    return-wide v0
.end method
