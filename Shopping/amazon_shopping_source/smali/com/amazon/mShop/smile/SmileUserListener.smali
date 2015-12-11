.class public Lcom/amazon/mShop/smile/SmileUserListener;
.super Ljava/lang/Object;
.source "SmileUserListener.java"

# interfaces
.implements Lcom/amazon/mShop/feature/FeatureStateSubscriber;
.implements Lcom/amazon/mShop/model/auth/UserListener;


# static fields
.field private static sInstance:Lcom/amazon/mShop/smile/SmileUserListener;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    new-instance v0, Lcom/amazon/mShop/smile/SmileUserListener;

    invoke-direct {v0}, Lcom/amazon/mShop/smile/SmileUserListener;-><init>()V

    sput-object v0, Lcom/amazon/mShop/smile/SmileUserListener;->sInstance:Lcom/amazon/mShop/smile/SmileUserListener;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    return-void
.end method

.method public static getInstance()Lcom/amazon/mShop/smile/SmileUserListener;
    .locals 1

    .prologue
    .line 38
    sget-object v0, Lcom/amazon/mShop/smile/SmileUserListener;->sInstance:Lcom/amazon/mShop/smile/SmileUserListener;

    return-object v0
.end method

.method private refreshMenu()V
    .locals 1

    .prologue
    .line 47
    invoke-static {}, Lcom/amazon/mShop/smile/SmileHelper;->shouldSyncSmileInfo()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 48
    invoke-static {}, Lcom/amazon/mShop/gno/GNODrawer;->getGNOItemAdapter()Lcom/amazon/mShop/gno/GNOItemAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNOItemAdapter;->updateVisibleItems()V

    .line 50
    :cond_0
    return-void
.end method

.method public static registerFeatureStateListener()V
    .locals 2

    .prologue
    .line 33
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v0

    invoke-static {}, Lcom/amazon/mShop/smile/SmileUserListener;->getInstance()Lcom/amazon/mShop/smile/SmileUserListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/feature/Features;->addFeatureStateSubscriber(Lcom/amazon/mShop/feature/FeatureStateSubscriber;)V

    .line 34
    return-void
.end method

.method public static registerUserListener()V
    .locals 1

    .prologue
    .line 27
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->isSmileEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 28
    invoke-static {}, Lcom/amazon/mShop/smile/SmileUserListener;->getInstance()Lcom/amazon/mShop/smile/SmileUserListener;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/model/auth/User;->addUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 30
    :cond_0
    return-void
.end method

.method private syncSmileInfo()V
    .locals 1

    .prologue
    .line 63
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->isSmileEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 64
    invoke-static {}, Lcom/amazon/mShop/control/smile/SmileController;->getInstance()Lcom/amazon/mShop/control/smile/SmileController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/control/smile/SmileController;->syncSmileInfo()V

    .line 66
    :cond_0
    return-void
.end method


# virtual methods
.method public onCancel()V
    .locals 0

    .prologue
    .line 92
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 0
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 87
    return-void
.end method

.method public onFeatureStateReceived(Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/Feature;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 73
    .local p1, "features":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/Feature;>;"
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->isSmileEnabled()Z

    move-result v0

    if-nez v0, :cond_1

    .line 74
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->isLoggedIn()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/model/auth/User;->isSmile()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 75
    const/4 v0, 0x0

    const-string/jumbo v1, ""

    invoke-static {v0, v1}, Lcom/amazon/mShop/smile/SmileHelper;->updateSmileInfo(ZLjava/lang/String;)Z

    .line 76
    invoke-static {}, Lcom/amazon/mShop/gno/GNODrawer;->getGNOItemAdapter()Lcom/amazon/mShop/gno/GNOItemAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/gno/GNOItemAdapter;->updateVisibleItems()V

    .line 82
    :cond_0
    :goto_0
    return-void

    .line 79
    :cond_1
    invoke-static {}, Lcom/amazon/mShop/smile/SmileHelper;->shouldSyncSmileInfo()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 80
    invoke-static {}, Lcom/amazon/mShop/control/smile/SmileController;->getInstance()Lcom/amazon/mShop/control/smile/SmileController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/control/smile/SmileController;->syncSmileInfo()V

    goto :goto_0
.end method

.method public userSignedIn(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 54
    invoke-direct {p0}, Lcom/amazon/mShop/smile/SmileUserListener;->syncSmileInfo()V

    .line 55
    return-void
.end method

.method public userSignedOut()V
    .locals 0

    .prologue
    .line 60
    return-void
.end method

.method public userUpdated(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 43
    invoke-direct {p0}, Lcom/amazon/mShop/smile/SmileUserListener;->refreshMenu()V

    .line 44
    return-void
.end method
