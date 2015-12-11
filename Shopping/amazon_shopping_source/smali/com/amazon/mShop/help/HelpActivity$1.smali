.class Lcom/amazon/mShop/help/HelpActivity$1;
.super Ljava/lang/Object;
.source "HelpActivity.java"

# interfaces
.implements Lcom/amazon/mShop/model/auth/UserListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/help/HelpActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/help/HelpActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/help/HelpActivity;)V
    .locals 0

    .prologue
    .line 39
    iput-object p1, p0, Lcom/amazon/mShop/help/HelpActivity$1;->this$0:Lcom/amazon/mShop/help/HelpActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public userSignedIn(Lcom/amazon/mShop/model/auth/User;)V
    .locals 2
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 47
    iget-object v0, p0, Lcom/amazon/mShop/help/HelpActivity$1;->this$0:Lcom/amazon/mShop/help/HelpActivity;

    iget-object v1, p0, Lcom/amazon/mShop/help/HelpActivity$1;->this$0:Lcom/amazon/mShop/help/HelpActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/help/HelpActivity;->getCurrentView()Landroid/view/View;

    move-result-object v1

    # invokes: Lcom/amazon/mShop/help/HelpActivity;->setPrimeInstantVideoPageContentVisibility(Landroid/view/View;)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/help/HelpActivity;->access$000(Lcom/amazon/mShop/help/HelpActivity;Landroid/view/View;)V

    .line 48
    return-void
.end method

.method public userSignedOut()V
    .locals 0

    .prologue
    .line 52
    return-void
.end method

.method public userUpdated(Lcom/amazon/mShop/model/auth/User;)V
    .locals 2
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 42
    iget-object v0, p0, Lcom/amazon/mShop/help/HelpActivity$1;->this$0:Lcom/amazon/mShop/help/HelpActivity;

    iget-object v1, p0, Lcom/amazon/mShop/help/HelpActivity$1;->this$0:Lcom/amazon/mShop/help/HelpActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/help/HelpActivity;->getCurrentView()Landroid/view/View;

    move-result-object v1

    # invokes: Lcom/amazon/mShop/help/HelpActivity;->setPrimeInstantVideoPageContentVisibility(Landroid/view/View;)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/help/HelpActivity;->access$000(Lcom/amazon/mShop/help/HelpActivity;Landroid/view/View;)V

    .line 43
    return-void
.end method
