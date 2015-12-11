.class Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText$1;
.super Ljava/lang/Object;
.source "RetailSearchEditText.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->onWindowFocusChanged(Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;)V
    .locals 0

    .prologue
    .line 68
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText$1;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 72
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText$1;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->getContext()Landroid/content/Context;

    move-result-object v1

    const-string/jumbo v2, "input_method"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 74
    .local v0, "inputManager":Landroid/view/inputmethod/InputMethodManager;
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText$1;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->showSoftInput(Landroid/view/View;I)Z

    .line 75
    return-void
.end method
