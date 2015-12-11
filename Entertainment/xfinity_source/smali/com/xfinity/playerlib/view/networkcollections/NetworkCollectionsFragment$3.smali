.class Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$3;
.super Ljava/lang/Object;
.source "NetworkCollectionsFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->loadResources()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    .prologue
    .line 196
    iput-object p1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$3;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialogInterface"    # Landroid/content/DialogInterface;

    .prologue
    .line 199
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$3;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->getLoadingViewDelegate()Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onLoadingFinished()V

    .line 200
    return-void
.end method
