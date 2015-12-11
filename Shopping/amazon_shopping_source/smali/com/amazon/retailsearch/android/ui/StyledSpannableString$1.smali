.class Lcom/amazon/retailsearch/android/ui/StyledSpannableString$1;
.super Lcom/amazon/retailsearch/android/ui/results/SearchLinkSpan;
.source "StyledSpannableString.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->postAppendStyle(IILjava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

.field final synthetic val$url:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/StyledSpannableString;Landroid/content/res/Resources;Ljava/lang/String;)V
    .locals 0
    .param p2, "x0"    # Landroid/content/res/Resources;

    .prologue
    .line 426
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString$1;->this$0:Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    iput-object p3, p0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString$1;->val$url:Ljava/lang/String;

    invoke-direct {p0, p2}, Lcom/amazon/retailsearch/android/ui/results/SearchLinkSpan;-><init>(Landroid/content/res/Resources;)V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 430
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString$1;->this$0:Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    if-eqz v0, :cond_0

    .line 432
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString$1;->this$0:Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString$1;->val$url:Ljava/lang/String;

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->search(Ljava/lang/String;)V

    .line 434
    :cond_0
    return-void
.end method
