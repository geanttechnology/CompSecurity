.class Lcom/amazon/mShop/AmazonApplication$AIVUserListener;
.super Ljava/lang/Object;
.source "AmazonApplication.java"

# interfaces
.implements Lcom/amazon/mShop/model/auth/UserListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/AmazonApplication;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "AIVUserListener"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 265
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/AmazonApplication$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/AmazonApplication$1;

    .prologue
    .line 265
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonApplication$AIVUserListener;-><init>()V

    return-void
.end method

.method private forceRefreshAccount()V
    .locals 1

    .prologue
    .line 282
    invoke-static {}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->getInstance()Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;->forceRefreshAccount()V

    .line 283
    return-void
.end method


# virtual methods
.method public userSignedIn(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 278
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonApplication$AIVUserListener;->forceRefreshAccount()V

    .line 279
    return-void
.end method

.method public userSignedOut()V
    .locals 0

    .prologue
    .line 273
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonApplication$AIVUserListener;->forceRefreshAccount()V

    .line 274
    return-void
.end method

.method public userUpdated(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 269
    return-void
.end method
