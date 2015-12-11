.class Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$1;
.super Ljava/lang/Object;
.source "ViewItTutorialContentView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->updateContentView()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;)V
    .locals 0

    .prologue
    .line 100
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 103
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->completeTutorial()V
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;->access$000(Lcom/amazon/mShop/search/viewit/ViewItTutorialContentView;)V

    .line 104
    const-string/jumbo v0, "fl_tutor_sk_btn"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 105
    return-void
.end method
