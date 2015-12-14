.class Lcom/livemixtapes/ui/widgets/SearchView$7;
.super Ljava/lang/Object;
.source "SearchView.java"

# interfaces
.implements Landroid/widget/TextView$OnEditorActionListener;


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
    iput-object p1, p0, Lcom/livemixtapes/ui/widgets/SearchView$7;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    .line 205
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onEditorAction(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z
    .locals 3
    .param p1, "v"    # Landroid/widget/TextView;
    .param p2, "actionId"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v2, 0x0

    .line 211
    const/4 v0, 0x3

    if-ne p2, v0, :cond_0

    .line 212
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView$7;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->queryTextListener:Lcom/livemixtapes/ui/widgets/SearchView$QueryTextListener;
    invoke-static {v0}, Lcom/livemixtapes/ui/widgets/SearchView;->access$6(Lcom/livemixtapes/ui/widgets/SearchView;)Lcom/livemixtapes/ui/widgets/SearchView$QueryTextListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 213
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView$7;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->queryTextListener:Lcom/livemixtapes/ui/widgets/SearchView$QueryTextListener;
    invoke-static {v0}, Lcom/livemixtapes/ui/widgets/SearchView;->access$6(Lcom/livemixtapes/ui/widgets/SearchView;)Lcom/livemixtapes/ui/widgets/SearchView$QueryTextListener;

    move-result-object v0

    iget-object v1, p0, Lcom/livemixtapes/ui/widgets/SearchView$7;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->editTextQuery:Landroid/widget/EditText;
    invoke-static {v1}, Lcom/livemixtapes/ui/widgets/SearchView;->access$5(Lcom/livemixtapes/ui/widgets/SearchView;)Landroid/widget/EditText;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-interface {v1}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/livemixtapes/ui/widgets/SearchView$QueryTextListener;->onQueryTextChange(Ljava/lang/String;)Z

    .line 214
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView$7;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    invoke-virtual {v0, v2}, Lcom/livemixtapes/ui/widgets/SearchView;->setExpand(Z)V

    .line 217
    :cond_0
    return v2
.end method
