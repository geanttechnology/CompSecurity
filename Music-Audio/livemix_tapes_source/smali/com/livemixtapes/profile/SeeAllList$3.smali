.class Lcom/livemixtapes/profile/SeeAllList$3;
.super Ljava/lang/Object;
.source "SeeAllList.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/profile/SeeAllList;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/profile/SeeAllList;


# direct methods
.method constructor <init>(Lcom/livemixtapes/profile/SeeAllList;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/profile/SeeAllList$3;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    .line 110
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 113
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList$3;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget-object v0, p0, Lcom/livemixtapes/profile/SeeAllList$3;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget-boolean v0, v0, Lcom/livemixtapes/profile/SeeAllList;->isEditableMode:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    iput-boolean v0, v1, Lcom/livemixtapes/profile/SeeAllList;->isEditableMode:Z

    .line 114
    iget-object v0, p0, Lcom/livemixtapes/profile/SeeAllList$3;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget-boolean v0, v0, Lcom/livemixtapes/profile/SeeAllList;->isEditableMode:Z

    if-eqz v0, :cond_1

    .line 115
    iget-object v0, p0, Lcom/livemixtapes/profile/SeeAllList$3;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget-object v0, v0, Lcom/livemixtapes/profile/SeeAllList;->textViewAction:Landroid/widget/TextView;

    const-string v1, "Done"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 118
    :goto_1
    iget-object v0, p0, Lcom/livemixtapes/profile/SeeAllList$3;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget-object v0, v0, Lcom/livemixtapes/profile/SeeAllList;->adapter:Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;

    invoke-virtual {v0}, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;->notifyDataSetChanged()V

    .line 119
    return-void

    .line 113
    :cond_0
    const/4 v0, 0x1

    goto :goto_0

    .line 117
    :cond_1
    iget-object v0, p0, Lcom/livemixtapes/profile/SeeAllList$3;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget-object v0, v0, Lcom/livemixtapes/profile/SeeAllList;->textViewAction:Landroid/widget/TextView;

    const-string v1, "Edit"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_1
.end method
