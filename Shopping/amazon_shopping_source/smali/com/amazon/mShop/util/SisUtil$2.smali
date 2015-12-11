.class final Lcom/amazon/mShop/util/SisUtil$2;
.super Ljava/lang/Object;
.source "SisUtil.java"

# interfaces
.implements Lcom/amazon/mShop/model/auth/UserListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/util/SisUtil;->reset(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 130
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public userSignedIn(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 139
    invoke-static {}, Lcom/amazon/mShop/util/SisUtil;->identifyUserWhenRegInfoReady()V

    .line 140
    return-void
.end method

.method public userSignedOut()V
    .locals 0

    .prologue
    .line 134
    return-void
.end method

.method public userUpdated(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 132
    return-void
.end method
