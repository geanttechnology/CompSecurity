.class Lcom/amazon/mShop/feature/Features$3;
.super Ljava/lang/Object;
.source "Features.java"

# interfaces
.implements Lcom/amazon/mShop/model/auth/UserListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/feature/Features;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/feature/Features;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/feature/Features;)V
    .locals 0

    .prologue
    .line 677
    iput-object p1, p0, Lcom/amazon/mShop/feature/Features$3;->this$0:Lcom/amazon/mShop/feature/Features;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public userSignedIn(Lcom/amazon/mShop/model/auth/User;)V
    .locals 1
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 685
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features$3;->this$0:Lcom/amazon/mShop/feature/Features;

    # invokes: Lcom/amazon/mShop/feature/Features;->sendFeatureStateRequest()V
    invoke-static {v0}, Lcom/amazon/mShop/feature/Features;->access$400(Lcom/amazon/mShop/feature/Features;)V

    .line 686
    return-void
.end method

.method public userSignedOut()V
    .locals 1

    .prologue
    .line 690
    iget-object v0, p0, Lcom/amazon/mShop/feature/Features$3;->this$0:Lcom/amazon/mShop/feature/Features;

    # invokes: Lcom/amazon/mShop/feature/Features;->sendFeatureStateRequest()V
    invoke-static {v0}, Lcom/amazon/mShop/feature/Features;->access$400(Lcom/amazon/mShop/feature/Features;)V

    .line 691
    return-void
.end method

.method public userUpdated(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 681
    return-void
.end method
