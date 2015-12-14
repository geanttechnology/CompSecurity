.class Lcom/livemixtapes/ui/widgets/SearchView$4;
.super Ljava/lang/Object;
.source "SearchView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/ui/widgets/SearchView;->attachEvents()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/ui/widgets/SearchView;


# direct methods
.method constructor <init>(Lcom/livemixtapes/ui/widgets/SearchView;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/ui/widgets/SearchView$4;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    .line 144
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 149
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView$4;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->editTextQuery:Landroid/widget/EditText;
    invoke-static {v0}, Lcom/livemixtapes/ui/widgets/SearchView;->access$5(Lcom/livemixtapes/ui/widgets/SearchView;)Landroid/widget/EditText;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 151
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView$4;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->isExpanded:Z
    invoke-static {v0}, Lcom/livemixtapes/ui/widgets/SearchView;->access$2(Lcom/livemixtapes/ui/widgets/SearchView;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 152
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView$4;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/livemixtapes/ui/widgets/SearchView;->access$3(Lcom/livemixtapes/ui/widgets/SearchView;Z)V

    .line 154
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView$4;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    iget-object v1, p0, Lcom/livemixtapes/ui/widgets/SearchView$4;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->isExpanded:Z
    invoke-static {v1}, Lcom/livemixtapes/ui/widgets/SearchView;->access$2(Lcom/livemixtapes/ui/widgets/SearchView;)Z

    move-result v1

    # invokes: Lcom/livemixtapes/ui/widgets/SearchView;->startAnimation(Z)V
    invoke-static {v0, v1}, Lcom/livemixtapes/ui/widgets/SearchView;->access$4(Lcom/livemixtapes/ui/widgets/SearchView;Z)V

    .line 156
    :cond_0
    return-void
.end method
