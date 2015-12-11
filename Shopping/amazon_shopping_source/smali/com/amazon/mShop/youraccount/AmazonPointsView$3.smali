.class Lcom/amazon/mShop/youraccount/AmazonPointsView$3;
.super Ljava/lang/Object;
.source "AmazonPointsView.java"

# interfaces
.implements Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/youraccount/AmazonPointsView;->onRequiresUserLogin(Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/youraccount/AmazonPointsView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/youraccount/AmazonPointsView;)V
    .locals 0

    .prologue
    .line 123
    iput-object p1, p0, Lcom/amazon/mShop/youraccount/AmazonPointsView$3;->this$0:Lcom/amazon/mShop/youraccount/AmazonPointsView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public userCancelledSignIn()V
    .locals 0

    .prologue
    .line 129
    return-void
.end method

.method public userSuccessfullySignedIn()V
    .locals 0

    .prologue
    .line 126
    return-void
.end method
