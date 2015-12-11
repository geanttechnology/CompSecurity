.class Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$8$1;
.super Ljava/lang/Object;
.source "ViewItTutorialContentView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$8;->onAnimationEnd(Landroid/view/animation/Animation;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$8;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$8;)V
    .locals 0

    .prologue
    .line 431
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$8$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$8;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 434
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$8$1;->this$1:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$8;

    iget-object v0, v0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$8;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->completeTutorial()V
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->access$000(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;)V

    .line 435
    const-string/jumbo v0, "fl_tutor_start_btn"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 436
    return-void
.end method
