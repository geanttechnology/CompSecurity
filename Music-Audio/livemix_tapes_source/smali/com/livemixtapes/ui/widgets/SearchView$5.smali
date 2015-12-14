.class Lcom/livemixtapes/ui/widgets/SearchView$5;
.super Ljava/lang/Object;
.source "SearchView.java"

# interfaces
.implements Landroid/text/TextWatcher;


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
    iput-object p1, p0, Lcom/livemixtapes/ui/widgets/SearchView$5;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    .line 160
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 2
    .param p1, "s"    # Landroid/text/Editable;

    .prologue
    .line 183
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView$5;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->editTextQuery:Landroid/widget/EditText;
    invoke-static {v0}, Lcom/livemixtapes/ui/widgets/SearchView;->access$5(Lcom/livemixtapes/ui/widgets/SearchView;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->length()I

    move-result v0

    if-lez v0, :cond_1

    .line 184
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView$5;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->searchClear:Landroid/widget/ImageButton;
    invoke-static {v0}, Lcom/livemixtapes/ui/widgets/SearchView;->access$7(Lcom/livemixtapes/ui/widgets/SearchView;)Landroid/widget/ImageButton;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 189
    :goto_0
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView$5;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->queryTextListener:Lcom/livemixtapes/ui/widgets/SearchView$QueryTextListener;
    invoke-static {v0}, Lcom/livemixtapes/ui/widgets/SearchView;->access$6(Lcom/livemixtapes/ui/widgets/SearchView;)Lcom/livemixtapes/ui/widgets/SearchView$QueryTextListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 190
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView$5;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->queryTextListener:Lcom/livemixtapes/ui/widgets/SearchView$QueryTextListener;
    invoke-static {v0}, Lcom/livemixtapes/ui/widgets/SearchView;->access$6(Lcom/livemixtapes/ui/widgets/SearchView;)Lcom/livemixtapes/ui/widgets/SearchView$QueryTextListener;

    move-result-object v0

    invoke-interface {p1}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/livemixtapes/ui/widgets/SearchView$QueryTextListener;->onQueryTextChange(Ljava/lang/String;)Z

    .line 192
    :cond_0
    return-void

    .line 186
    :cond_1
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView$5;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->searchClear:Landroid/widget/ImageButton;
    invoke-static {v0}, Lcom/livemixtapes/ui/widgets/SearchView;->access$7(Lcom/livemixtapes/ui/widgets/SearchView;)Landroid/widget/ImageButton;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setVisibility(I)V

    goto :goto_0
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "count"    # I
    .param p4, "after"    # I

    .prologue
    .line 167
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 2
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    .line 173
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView$5;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->queryTextListener:Lcom/livemixtapes/ui/widgets/SearchView$QueryTextListener;
    invoke-static {v0}, Lcom/livemixtapes/ui/widgets/SearchView;->access$6(Lcom/livemixtapes/ui/widgets/SearchView;)Lcom/livemixtapes/ui/widgets/SearchView$QueryTextListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 174
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView$5;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->queryTextListener:Lcom/livemixtapes/ui/widgets/SearchView$QueryTextListener;
    invoke-static {v0}, Lcom/livemixtapes/ui/widgets/SearchView;->access$6(Lcom/livemixtapes/ui/widgets/SearchView;)Lcom/livemixtapes/ui/widgets/SearchView$QueryTextListener;

    move-result-object v0

    invoke-interface {p1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/livemixtapes/ui/widgets/SearchView$QueryTextListener;->onQueryTextChange(Ljava/lang/String;)Z

    .line 176
    :cond_0
    return-void
.end method
