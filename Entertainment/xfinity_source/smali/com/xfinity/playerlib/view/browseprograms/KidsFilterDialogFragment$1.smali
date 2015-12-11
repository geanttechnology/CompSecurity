.class Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment$1;
.super Ljava/lang/Object;
.source "KidsFilterDialogFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;

    .prologue
    .line 91
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 94
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/KidsFilterDialogFragment;->handleDone()V

    .line 95
    return-void
.end method
