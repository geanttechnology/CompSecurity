.class Lcom/poshmark/ui/fragments/CommentFragment$4;
.super Ljava/lang/Object;
.source "CommentFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/CommentFragment;->setupActionBarNextActionButton()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/CommentFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/CommentFragment;)V
    .locals 0

    .prologue
    .line 205
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CommentFragment$4;->this$0:Lcom/poshmark/ui/fragments/CommentFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 208
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CommentFragment$4;->this$0:Lcom/poshmark/ui/fragments/CommentFragment;

    # invokes: Lcom/poshmark/ui/fragments/CommentFragment;->postComment()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/CommentFragment;->access$100(Lcom/poshmark/ui/fragments/CommentFragment;)V

    .line 209
    return-void
.end method
