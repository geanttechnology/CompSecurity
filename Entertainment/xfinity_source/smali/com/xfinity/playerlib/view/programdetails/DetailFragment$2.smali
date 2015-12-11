.class Lcom/xfinity/playerlib/view/programdetails/DetailFragment$2;
.super Ljava/lang/Object;
.source "DetailFragment.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$ReadyListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    .prologue
    .line 524
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onReady()V
    .locals 1

    .prologue
    .line 527
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->loadScreenInfo()V

    .line 528
    return-void
.end method
