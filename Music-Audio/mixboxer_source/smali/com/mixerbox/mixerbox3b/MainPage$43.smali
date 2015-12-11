.class Lcom/mixerbox/mixerbox3b/MainPage$43;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;

.field final synthetic val$textView:Landroid/widget/AutoCompleteTextView;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/widget/AutoCompleteTextView;)V
    .locals 0

    .prologue
    .line 3617
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$43;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/MainPage$43;->val$textView:Landroid/widget/AutoCompleteTextView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 2

    .prologue
    .line 3620
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$43;->val$textView:Landroid/widget/AutoCompleteTextView;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/widget/AutoCompleteTextView;->onEditorAction(I)V

    .line 3621
    return-void
.end method
