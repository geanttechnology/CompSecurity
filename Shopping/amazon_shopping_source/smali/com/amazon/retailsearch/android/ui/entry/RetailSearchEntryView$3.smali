.class Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView$3;
.super Ljava/lang/Object;
.source "RetailSearchEntryView.java"

# interfaces
.implements Landroid/widget/TextView$OnEditorActionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->onFinishInflate()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;)V
    .locals 0

    .prologue
    .line 218
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView$3;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onEditorAction(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z
    .locals 4
    .param p1, "editText"    # Landroid/widget/TextView;
    .param p2, "actionId"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v1, 0x1

    .line 222
    const/4 v2, 0x2

    if-ne p2, v2, :cond_1

    .line 224
    invoke-virtual {p1}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    .line 225
    .local v0, "keyWord":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 235
    .end local v0    # "keyWord":Ljava/lang/String;
    :goto_0
    return v1

    .line 231
    .restart local v0    # "keyWord":Ljava/lang/String;
    :cond_0
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView$3;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->doSearch(Ljava/lang/String;)V

    goto :goto_0

    .line 235
    .end local v0    # "keyWord":Ljava/lang/String;
    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method
