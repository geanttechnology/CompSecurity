.class Lcom/livemixtapes/SearchFragment$5;
.super Ljava/lang/Object;
.source "SearchFragment.java"

# interfaces
.implements Lcom/livemixtapes/ui/widgets/SearchView$ExpandListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/SearchFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/SearchFragment;


# direct methods
.method constructor <init>(Lcom/livemixtapes/SearchFragment;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/SearchFragment$5;->this$0:Lcom/livemixtapes/SearchFragment;

    .line 87
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/livemixtapes/SearchFragment$5;)Lcom/livemixtapes/SearchFragment;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/livemixtapes/SearchFragment$5;->this$0:Lcom/livemixtapes/SearchFragment;

    return-object v0
.end method


# virtual methods
.method public onAfterExpand(Z)V
    .locals 0
    .param p1, "expand"    # Z

    .prologue
    .line 112
    return-void
.end method

.method public onBeforeExpand(Z)V
    .locals 3
    .param p1, "expand"    # Z

    .prologue
    .line 92
    new-instance v0, Lcom/livemixtapes/SearchFragment$5$1;

    invoke-direct {v0, p0, p1}, Lcom/livemixtapes/SearchFragment$5$1;-><init>(Lcom/livemixtapes/SearchFragment$5;Z)V

    .line 105
    .local v0, "layoutAnimation":Landroid/view/animation/Animation;
    const-wide/16 v1, 0x12c

    invoke-virtual {v0, v1, v2}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 106
    iget-object v1, p0, Lcom/livemixtapes/SearchFragment$5;->this$0:Lcom/livemixtapes/SearchFragment;

    iget-object v1, v1, Lcom/livemixtapes/SearchFragment;->layoutHeader:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, v0}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    .line 107
    return-void
.end method
