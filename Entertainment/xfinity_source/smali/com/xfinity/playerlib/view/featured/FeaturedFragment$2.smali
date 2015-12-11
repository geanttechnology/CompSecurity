.class Lcom/xfinity/playerlib/view/featured/FeaturedFragment$2;
.super Ljava/lang/Object;
.source "FeaturedFragment.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$ReadyListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/featured/FeaturedFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/featured/FeaturedFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/featured/FeaturedFragment;

    .prologue
    .line 117
    iput-object p1, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment$2;->this$0:Lcom/xfinity/playerlib/view/featured/FeaturedFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onReady()V
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment$2;->this$0:Lcom/xfinity/playerlib/view/featured/FeaturedFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->loadResources()V

    .line 121
    return-void
.end method
