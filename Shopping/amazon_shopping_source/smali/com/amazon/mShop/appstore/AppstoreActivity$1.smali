.class Lcom/amazon/mShop/appstore/AppstoreActivity$1;
.super Ljava/lang/Object;
.source "AppstoreActivity.java"

# interfaces
.implements Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/appstore/AppstoreActivity;->onInsufficientInfoReceived(Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/appstore/AppstoreActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/appstore/AppstoreActivity;)V
    .locals 0

    .prologue
    .line 138
    iput-object p1, p0, Lcom/amazon/mShop/appstore/AppstoreActivity$1;->this$0:Lcom/amazon/mShop/appstore/AppstoreActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public userCancelledSignIn()V
    .locals 1

    .prologue
    .line 147
    iget-object v0, p0, Lcom/amazon/mShop/appstore/AppstoreActivity$1;->this$0:Lcom/amazon/mShop/appstore/AppstoreActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/appstore/AppstoreActivity;->finish()V

    .line 148
    return-void
.end method

.method public userSuccessfullySignedIn()V
    .locals 0

    .prologue
    .line 142
    return-void
.end method
