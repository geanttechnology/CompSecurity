.class Lcom/mixerbox/mixerbox3b/MainPage$44;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;

.field final synthetic val$textView:Landroid/widget/AutoCompleteTextView;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/widget/AutoCompleteTextView;)V
    .locals 0

    .prologue
    .line 3624
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$44;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/MainPage$44;->val$textView:Landroid/widget/AutoCompleteTextView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 3627
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$44;->val$textView:Landroid/widget/AutoCompleteTextView;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/AutoCompleteTextView;->setText(Ljava/lang/CharSequence;)V

    .line 3628
    return-void
.end method
